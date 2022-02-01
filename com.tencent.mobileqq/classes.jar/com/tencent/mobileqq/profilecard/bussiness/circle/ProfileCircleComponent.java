package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.circle.view.ProfileCircleInfoView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;
import qqcircle.QQCircleFeedBase.StQQProfilePointInfo;

public class ProfileCircleComponent
  extends AbsQQProfileContentComponent
{
  private static final String TAG = "ProfileCircleComponent";
  private static LruCache<String, ProfileCircleComponent.ProfileCircleCacheBean> mCache;
  private static long mRequestTimeInterval;
  private boolean isRefreshFeed = false;
  private String mFansText = "";
  private int mFansValueStyle = 0;
  private String mFuelText = "";
  private int mFuelValueStyle = 0;
  private final AtomicBoolean mIsDoingRequest = new AtomicBoolean(false);
  private ProfileCircleInfoView mProfileCircleInfoView;
  private ColorDrawable mQQCircleDefaultPic;
  private volatile List<FeedCloudMeta.StFeed> mQQCircleFeeds;
  private volatile boolean mQQCircleHostShouldReport = true;
  private volatile boolean mQQCircleProfileInfoReport = true;
  private volatile boolean mQQCircleShouldReport = true;
  private String mQcircleUpdateinfo;
  private float mScreenWidth;
  private WeakReferenceHandler mUiHandler;
  
  public ProfileCircleComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
    if (mCache == null) {
      mCache = new LruCache(5);
    }
  }
  
  private String getCircleProfileInfoExt1()
  {
    if ((this.mFansValueStyle == 1) && (this.mFuelValueStyle == 1)) {
      return "4";
    }
    if (this.mFansValueStyle == 1) {
      return "3";
    }
    if (this.mFuelValueStyle == 1) {
      return "2";
    }
    return "1";
  }
  
  private boolean isNeedRequestUserInfo(String paramString)
  {
    return true;
  }
  
  private static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCircleComponent", 2, paramString);
    }
  }
  
  private void refreshFeed(String paramString)
  {
    if (this.mIsDoingRequest.compareAndSet(false, true))
    {
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle sendRequest");
      QCircleUtils.a().refreshMainPageFeed(paramString, new ProfileCircleComponent.FeedVsRspCallBack(this));
    }
    this.isRefreshFeed = true;
  }
  
  private void refreshFeedUsingCache(String paramString)
  {
    if ((mCache.get(paramString) != null) && (((ProfileCircleComponent.ProfileCircleCacheBean)mCache.get(paramString)).getUserInfo() != null))
    {
      paramString = ((ProfileCircleComponent.ProfileCircleCacheBean)mCache.get(paramString)).getUserInfo();
      QLog.d("ProfileCircleComponent", 1, "Using cache update QCirlce ProfileCard");
      List localList = paramString.vecFeed.get();
      setUserInfo(paramString, localList);
      if ((localList != null) && (localList.size() > 0))
      {
        this.mQQCircleFeeds = localList;
        makeOrRefreshQQCircle(((ProfileCardInfo)this.mData).card);
      }
      return;
    }
    refreshFeed(paramString);
  }
  
  private void resetCircleContainer(ProfileCardInfo paramProfileCardInfo, LayoutInflater paramLayoutInflater, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup)
  {
    Object localObject1 = this;
    Object localObject2 = ((ProfileCircleComponent)localObject1).mActivity.getResources();
    int m = ((Resources)localObject2).getDimensionPixelSize(2131298421);
    int i = ((Resources)localObject2).getDimensionPixelSize(2131297596);
    int j = ViewUtils.b(30.0F);
    int n = (int)(((ProfileCircleComponent)localObject1).mScreenWidth - i - j);
    int i1 = (int)((n - m * 4) * 1.0F) / 5;
    int i2 = ViewUtils.b(75.0F);
    log(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(((ProfileCircleComponent)localObject1).mQQCircleFeeds.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
    i = paramProfileCardInfo.allInOne.pa;
    paramProfileCardInfo = null;
    Object localObject3;
    if ((i == 0) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      localObject2 = paramLayoutInflater.inflate(2131561363, null);
      localObject3 = (RoundRelativeLayout)((View)localObject2).findViewById(2131376843);
      ((RoundRelativeLayout)localObject3).a = ViewUtils.b(4.0F);
      ((RoundRelativeLayout)localObject3).setVisibility(0);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        ((View)localObject2).findViewById(2131363496).setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView((View)localObject2);
      localObject3 = ((View)localObject2).getLayoutParams();
      if ((localObject3 instanceof LinearLayout.LayoutParams))
      {
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        ((LinearLayout.LayoutParams)localObject3).width = i1;
        ((LinearLayout.LayoutParams)localObject3).height = i2;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((View)localObject2).setOnClickListener(new ProfileCircleComponent.2((ProfileCircleComponent)localObject1));
      }
      j = 0 + i1;
      i = j;
      if (((ProfileCircleComponent)localObject1).mQQCircleHostShouldReport)
      {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 3, 2, 1);
        ((ProfileCircleComponent)localObject1).mQQCircleHostShouldReport = false;
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    int i3 = ((ProfileCircleComponent)localObject1).mQQCircleFeeds.size();
    j = 0;
    while (j < i3)
    {
      localObject1 = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)this.mQQCircleFeeds.get(j)).get();
      TextView localTextView;
      if (localObject1 != null)
      {
        localObject4 = ((FeedCloudMeta.StFeed)localObject1).cover.picUrl.get();
        paramProfileCardInfo = paramLayoutInflater.inflate(2131561362, paramProfileCardInfo);
        localObject2 = (RoundRelativeLayout)paramProfileCardInfo.findViewById(2131376843);
        ((RoundRelativeLayout)localObject2).a = ViewUtils.b(4.0F);
        ((RoundRelativeLayout)localObject2).setVisibility(0);
        localObject3 = (ImageView)paramProfileCardInfo.findViewById(2131368811);
        View localView = paramProfileCardInfo.findViewById(2131368813);
        localObject2 = paramProfileCardInfo.findViewById(2131368810);
        paramProfileCardInfo.findViewById(2131368812);
        localTextView = (TextView)paramProfileCardInfo.findViewById(2131368807);
        ((UnderlineTextView)paramProfileCardInfo.findViewById(2131368806)).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        boolean bool;
        if (((FeedCloudMeta.StFeed)localObject1).feedType.get() == 3) {
          bool = true;
        } else {
          bool = false;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
            ((ImageView)localObject3).setColorFilter(1996488704);
          }
          resetPicAndVideo(i1, i2, (String)localObject4, (ImageView)localObject3, localView, bool);
          k = 1;
        }
        else
        {
          k = 0;
        }
        localObject1 = null;
        localObject4 = null;
        if (k == 0)
        {
          QLog.w("ProfileCircleComponent", 1, "doMakeOrRefreshQQCircle: needUpdateUI=false,skip this one");
          paramProfileCardInfo = (ProfileCardInfo)localObject4;
        }
      }
      else
      {
        break label807;
      }
      paramViewGroup.addView(paramProfileCardInfo);
      Object localObject4 = paramProfileCardInfo.getLayoutParams();
      if ((localObject4 instanceof LinearLayout.LayoutParams))
      {
        localObject4 = (LinearLayout.LayoutParams)localObject4;
        ((LinearLayout.LayoutParams)localObject4).rightMargin = m;
        paramProfileCardInfo.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      }
      paramProfileCardInfo = ((ImageView)localObject3).getLayoutParams();
      paramProfileCardInfo.width = i1;
      paramProfileCardInfo.height = i2;
      ((ImageView)localObject3).setLayoutParams(paramProfileCardInfo);
      paramProfileCardInfo = ((View)localObject2).getLayoutParams();
      paramProfileCardInfo.width = i1;
      paramProfileCardInfo.height = i2;
      ((View)localObject2).setLayoutParams(paramProfileCardInfo);
      int k = i;
      if (i > 0) {
        k = i + m;
      }
      i = k + i1;
      if (i + i1 + m > n)
      {
        log(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
        return;
      }
      ((View)localObject2).setVisibility(8);
      localTextView.setVisibility(8);
      paramProfileCardInfo = (ProfileCardInfo)localObject1;
      label807:
      j += 1;
    }
  }
  
  private void resetPicAndVideo(int paramInt1, int paramInt2, String paramString, ImageView paramImageView, View paramView, boolean paramBoolean)
  {
    if (this.mQQCircleDefaultPic == null) {
      this.mQQCircleDefaultPic = new ColorDrawable(this.mActivity.getResources().getColor(2131165722));
    }
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mQQCircleDefaultPic;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mQQCircleDefaultPic;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
      {
        if (paramBoolean)
        {
          localObject = ShortVideoUtils.getVideoThumbnail(this.mActivity, paramString, paramInt1, 0L);
          if (localObject != null) {
            paramImageView.setImageBitmap((Bitmap)localObject);
          } else {
            paramImageView.setImageDrawable(this.mQQCircleDefaultPic);
          }
        }
        else
        {
          paramImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
        }
      }
      else {
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
      }
      if ((!paramString.contains("video=1")) && (!paramBoolean))
      {
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(0);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ProfileCircleComponent", 2, "makeOrRefreshQZone fail!", paramString);
    }
  }
  
  private void setRedPoint(QQCircleFeedBase.StPageRedPointInfo paramStPageRedPointInfo, List<FeedCloudMeta.StFeed> paramList)
  {
    String str;
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).card != null)) {
      str = ((ProfileCardInfo)this.mData).card.uin;
    } else {
      str = "";
    }
    if (paramStPageRedPointInfo != null) {}
    try
    {
      if (paramStPageRedPointInfo.redTotalNum.get() > 0)
      {
        if (!TextUtils.isEmpty(paramStPageRedPointInfo.qqProfileInfo.txt.get())) {
          this.mQcircleUpdateinfo = paramStPageRedPointInfo.qqProfileInfo.txt.get();
        } else {
          this.mQcircleUpdateinfo = "";
        }
      }
      else {
        this.mQcircleUpdateinfo = "";
      }
    }
    catch (Exception paramStPageRedPointInfo)
    {
      label105:
      break label105;
    }
    this.mQcircleUpdateinfo = "";
    if (this.mQQCircleShouldReport)
    {
      if (!TextUtils.isEmpty(this.mQcircleUpdateinfo))
      {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(str, 3, 1, 3);
        this.mQQCircleShouldReport = false;
        return;
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramStPageRedPointInfo = new HashMap();
        paramStPageRedPointInfo.put("ext1", getCircleProfileInfoExt1());
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(str, 3, 1, 1, paramStPageRedPointInfo, null, null);
        this.mQQCircleShouldReport = false;
      }
    }
  }
  
  /* Error */
  private void setUserInfo(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, List<FeedCloudMeta.StFeed> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 205	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: getfield 553	feedcloud/FeedCloudRead$StGetMainPageRsp:fansCount	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: invokevirtual 413	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15: i2l
    //   16: lstore 7
    //   18: aload_1
    //   19: getfield 556	feedcloud/FeedCloudRead$StGetMainPageRsp:fansValueStyle	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   22: invokevirtual 413	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   25: istore 4
    //   27: new 558	qqcircle/QQCircleFeedBase$StMainPageBusiRspData
    //   30: dup
    //   31: invokespecial 559	qqcircle/QQCircleFeedBase$StMainPageBusiRspData:<init>	()V
    //   34: astore 9
    //   36: aload 9
    //   38: aload_1
    //   39: getfield 563	feedcloud/FeedCloudRead$StGetMainPageRsp:busiRspData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   42: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   45: invokevirtual 574	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   48: invokevirtual 578	qqcircle/QQCircleFeedBase$StMainPageBusiRspData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   51: pop
    //   52: aload 9
    //   54: getfield 581	qqcircle/QQCircleFeedBase$StMainPageBusiRspData:fuelValue	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   57: invokevirtual 413	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   60: istore_3
    //   61: iload_3
    //   62: i2l
    //   63: lstore 5
    //   65: aload 9
    //   67: getfield 584	qqcircle/QQCircleFeedBase$StMainPageBusiRspData:fuelValueStyle	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   70: invokevirtual 413	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   73: istore_3
    //   74: aload 9
    //   76: getfield 587	qqcircle/QQCircleFeedBase$StMainPageBusiRspData:timeInterval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   79: invokevirtual 413	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   82: i2l
    //   83: putstatic 589	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mRequestTimeInterval	J
    //   86: lload 7
    //   88: lconst_0
    //   89: lcmp
    //   90: ifeq +32 -> 122
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 205	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   98: ldc_w 590
    //   101: invokevirtual 594	com/tencent/mobileqq/app/QBaseActivity:getString	(I)Ljava/lang/String;
    //   104: iconst_1
    //   105: anewarray 239	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: lload 7
    //   112: invokestatic 600	com/tencent/mobileqq/qcircle/api/utils/QCircleHostUtil:fansNumberFormatTranfer	(J)Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 603	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   119: putfield 60	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mFansText	Ljava/lang/String;
    //   122: lload 5
    //   124: lconst_0
    //   125: lcmp
    //   126: ifeq +32 -> 158
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 205	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   134: ldc_w 604
    //   137: invokevirtual 594	com/tencent/mobileqq/app/QBaseActivity:getString	(I)Ljava/lang/String;
    //   140: iconst_1
    //   141: anewarray 239	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: lload 5
    //   148: invokestatic 600	com/tencent/mobileqq/qcircle/api/utils/QCircleHostUtil:fansNumberFormatTranfer	(J)Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 603	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   155: putfield 62	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mFuelText	Ljava/lang/String;
    //   158: aload_0
    //   159: iload 4
    //   161: putfield 54	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mFansValueStyle	I
    //   164: aload_0
    //   165: iload_3
    //   166: putfield 56	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:mFuelValueStyle	I
    //   169: aload_0
    //   170: aload 9
    //   172: getfield 608	qqcircle/QQCircleFeedBase$StMainPageBusiRspData:RedPointInfo	Lqqcircle/QQCircleFeedBase$StPageRedPointInfo;
    //   175: invokevirtual 609	qqcircle/QQCircleFeedBase$StPageRedPointInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   178: checkcast 522	qqcircle/QQCircleFeedBase$StPageRedPointInfo
    //   181: aload_2
    //   182: invokespecial 611	com/tencent/mobileqq/profilecard/bussiness/circle/ProfileCircleComponent:setRedPoint	(Lqqcircle/QQCircleFeedBase$StPageRedPointInfo;Ljava/util/List;)V
    //   185: goto +21 -> 206
    //   188: astore_1
    //   189: goto +13 -> 202
    //   192: astore_1
    //   193: goto +7 -> 200
    //   196: astore_1
    //   197: lconst_0
    //   198: lstore 5
    //   200: iconst_0
    //   201: istore_3
    //   202: aload_1
    //   203: invokevirtual 614	java/lang/Exception:printStackTrace	()V
    //   206: new 616	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 617	java/lang/StringBuilder:<init>	()V
    //   213: astore_1
    //   214: aload_1
    //   215: iload 4
    //   217: invokevirtual 621	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_1
    //   222: ldc_w 623
    //   225: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 8
    //   231: iconst_1
    //   232: bipush 7
    //   234: anewarray 239	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: ldc_w 628
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: lload 7
    //   247: invokestatic 633	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   250: aastore
    //   251: dup
    //   252: iconst_2
    //   253: ldc_w 635
    //   256: aastore
    //   257: dup
    //   258: iconst_3
    //   259: lload 5
    //   261: invokestatic 633	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: aastore
    //   265: dup
    //   266: iconst_4
    //   267: ldc_w 637
    //   270: aastore
    //   271: dup
    //   272: iconst_5
    //   273: aload_1
    //   274: invokevirtual 640	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aastore
    //   278: dup
    //   279: bipush 6
    //   281: iload_3
    //   282: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokestatic 643	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   289: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	ProfileCircleComponent
    //   0	290	1	paramStGetMainPageRsp	FeedCloudRead.StGetMainPageRsp
    //   0	290	2	paramList	List<FeedCloudMeta.StFeed>
    //   60	222	3	i	int
    //   25	191	4	j	int
    //   63	197	5	l1	long
    //   16	230	7	l2	long
    //   34	137	9	localStMainPageBusiRspData	qqcircle.QQCircleFeedBase.StMainPageBusiRspData
    // Exception table:
    //   from	to	target	type
    //   74	86	188	java/lang/Exception
    //   93	122	188	java/lang/Exception
    //   129	158	188	java/lang/Exception
    //   158	185	188	java/lang/Exception
    //   65	74	192	java/lang/Exception
    //   27	61	196	java/lang/Exception
  }
  
  public String getComponentName()
  {
    return "ProfileCircleComponent";
  }
  
  public int getComponentType()
  {
    return 1015;
  }
  
  public String getGenderName(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mActivity == null) {
      return "他";
    }
    String str = this.mActivity.getString(2131699580);
    Object localObject = str;
    if (paramProfileCardInfo != null)
    {
      localObject = str;
      if (paramProfileCardInfo.card != null)
      {
        if (paramProfileCardInfo.card.shGender == 1) {
          paramProfileCardInfo = this.mActivity.getString(2131699579);
        } else {
          paramProfileCardInfo = this.mActivity.getString(2131699580);
        }
        localObject = paramProfileCardInfo;
      }
    }
    return localObject;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_qqcircle";
  }
  
  public boolean makeOrRefreshQQCircle(Card paramCard)
  {
    if ((QzoneConfig.isQQCircleShowProfileCardEntrance()) && (this.mActivity != null))
    {
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle start");
      long l = SystemClock.elapsedRealtime();
      boolean bool;
      if ((paramCard != null) && (paramCard.switchQQCircle != 1)) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("makeOrRefreshQQCircle switch: ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ProfileCircleComponent", 4, ((StringBuilder)localObject1).toString());
      if (!bool)
      {
        if (this.mViewContainer != null) {
          bool = true;
        } else {
          bool = false;
        }
        this.mViewContainer = null;
        return bool;
      }
      ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
      QQAppInterface localQQAppInterface = this.mQQAppInterface;
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.mActivity);
      Object localObject2 = (View)this.mViewContainer;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localLayoutInflater.inflate(2131561361, null);
        this.mViewContainer = localObject1;
      }
      View localView = ((View)localObject1).findViewById(2131365027);
      ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131368808);
      ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131368809);
      if ((this.mQQCircleFeeds != null) && (!this.mQQCircleFeeds.isEmpty()))
      {
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131378609);
        ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131368562);
        ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131368501);
        this.mProfileCircleInfoView = ((ProfileCircleInfoView)((View)localObject1).findViewById(2131366917));
        localTextView.setMaxWidth(2147483647);
        if (localProfileCardInfo.allInOne.pa != 0)
        {
          Object localObject3 = getGenderName(localProfileCardInfo);
          localObject2 = String.format(this.mActivity.getString(2131699581), new Object[] { localObject3 });
          if (!TextUtils.isEmpty(this.mQcircleUpdateinfo))
          {
            if ((ViewUtils.a(localTextView.getPaint(), (CharSequence)localObject2) > ViewUtils.b(170.0F)) && (((String)localObject3).length() > 7))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(((String)localObject3).substring(0, 7));
              ((StringBuilder)localObject2).append("...");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject2 = String.format(this.mActivity.getString(2131699581), new Object[] { localObject2 });
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(this.mQcircleUpdateinfo);
            localTextView.setText(((StringBuilder)localObject3).toString());
            localImageView1.setVisibility(0);
            this.mProfileCircleInfoView.setVisibility(8);
          }
          else
          {
            localImageView1.setVisibility(8);
            localTextView.setText((CharSequence)localObject2);
            if ((!TextUtils.isEmpty(this.mFansText)) || (!TextUtils.isEmpty(this.mFuelText)))
            {
              localTextView.setMaxWidth(ViewUtils.a(140.0F));
              this.mProfileCircleInfoView.updateCircleInfo(this.mFansValueStyle, this.mFuelValueStyle, this.mFansText, this.mFuelText);
              this.mProfileCircleInfoView.setVisibility(0);
            }
          }
        }
        else
        {
          if ((!TextUtils.isEmpty(this.mFansText)) || (!TextUtils.isEmpty(this.mFuelText))) {
            break label603;
          }
        }
        break label634;
        label603:
        this.mProfileCircleInfoView.updateCircleInfo(this.mFansValueStyle, this.mFuelValueStyle, this.mFansText, this.mFuelText);
        this.mProfileCircleInfoView.setVisibility(0);
        label634:
        localViewGroup1.removeAllViews();
        localViewGroup1.setVisibility(0);
        if ((localViewGroup2 != null) && (localViewGroup2.getVisibility() != 8))
        {
          localViewGroup2.removeAllViews();
          localViewGroup2.setVisibility(8);
        }
        if (!this.mQQCircleFeeds.isEmpty())
        {
          resetCircleContainer(localProfileCardInfo, localLayoutInflater, localQQAppInterface, localViewGroup1);
          bool = true;
        }
        else
        {
          bool = false;
        }
        ((View)localObject1).setOnClickListener(new ProfileCircleComponent.1(this, localProfileCardInfo, paramCard, localQQAppInterface));
        ((View)localObject1).setContentDescription(this.mActivity.getString(2131699578));
        updateItemTheme((View)localObject1, localTextView, null, localImageView2);
        localView.setVisibility(0);
        localViewGroup1.setVisibility(0);
        localViewGroup2.setVisibility(0);
        paramCard = new StringBuilder();
        paramCard.append("makeOrRefreshQQCircle end： ");
        paramCard.append(SystemClock.elapsedRealtime() - l);
        QLog.d("ProfileCircleComponent", 4, paramCard.toString());
        return bool;
      }
      if (!this.isRefreshFeed) {
        refreshFeed(paramCard.uin);
      }
      localView.setVisibility(8);
      localViewGroup1.setVisibility(8);
      localViewGroup2.setVisibility(8);
      return true;
    }
    return false;
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mUiHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    paramQBaseActivity = paramQBaseActivity.getResources().getDisplayMetrics();
    this.mScreenWidth = Math.min(paramQBaseActivity.widthPixels, paramQBaseActivity.heightPixels);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshQQCircle(((ProfileCardInfo)this.mData).card);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mQQCircleFeeds != null)
    {
      this.mQQCircleFeeds.clear();
      this.mQQCircleFeeds = null;
    }
    ProfileCircleInfoView localProfileCircleInfoView = this.mProfileCircleInfoView;
    if (localProfileCircleInfoView != null) {
      localProfileCircleInfoView.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mQQCircleShouldReport = true;
    this.mQQCircleHostShouldReport = true;
    this.mQQCircleProfileInfoReport = true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (!QzoneConfig.isQQCircleShowProfileCardEntrance())
    {
      QLog.d("ProfileCircleComponent", 4, "qqcircle profile card entrance is close");
      return;
    }
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).card != null))
    {
      int i = ((ProfileCardInfo)this.mData).card.switchQQCircle;
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("card switch_qqcircle: ");
      localStringBuilder.append(bool);
      QLog.d("ProfileCircleComponent", 4, localStringBuilder.toString());
      if ((bool) && (isNeedRequestUserInfo(((ProfileCardInfo)this.mData).card.uin)))
      {
        refreshFeed(((ProfileCardInfo)this.mData).card.uin);
        return;
      }
      if (bool) {
        refreshFeedUsingCache(((ProfileCardInfo)this.mData).card.uin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent
 * JD-Core Version:    0.7.0.1
 */