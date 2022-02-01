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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.circle.view.ProfileCircleInfoView;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;
import qqcircle.QQCircleFeedBase.StQQProfilePointInfo;

public class ProfileCircleComponent
  extends AbsProfileContentComponent
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
    String str = "1";
    if ((this.mFansValueStyle == 1) && (this.mFuelValueStyle == 1)) {
      str = "4";
    }
    do
    {
      return str;
      if (this.mFansValueStyle == 1) {
        return "3";
      }
    } while (this.mFuelValueStyle != 1);
    return "2";
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
    if ((mCache.get(paramString) == null) || (((ProfileCircleComponent.ProfileCircleCacheBean)mCache.get(paramString)).getUserInfo() == null)) {
      refreshFeed(paramString);
    }
    List localList;
    do
    {
      return;
      paramString = ((ProfileCircleComponent.ProfileCircleCacheBean)mCache.get(paramString)).getUserInfo();
      QLog.d("ProfileCircleComponent", 1, "Using cache update QCirlce ProfileCard");
      localList = paramString.vecFeed.get();
      setUserInfo(paramString, localList);
    } while ((localList == null) || (localList.size() <= 0));
    this.mQQCircleFeeds = localList;
    makeOrRefreshQQCircle(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard);
  }
  
  private void resetCircleContainer(ProfileCardInfo paramProfileCardInfo, LayoutInflater paramLayoutInflater, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.mActivity.getResources();
    int m = ((Resources)localObject1).getDimensionPixelSize(2131298426);
    int i = ((Resources)localObject1).getDimensionPixelSize(2131297605);
    int j = ViewUtils.b(30.0F);
    int n = (int)(this.mScreenWidth - i - j);
    int i1 = (int)((n - m * 4) * 1.0F) / 5;
    int i2 = ViewUtils.b(75.0F);
    log(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(this.mQQCircleFeeds.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
    j = 0;
    i = j;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = j;
      if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0)
      {
        paramProfileCardInfo = paramLayoutInflater.inflate(2131561522, null);
        localObject1 = (RoundRelativeLayout)paramProfileCardInfo.findViewById(2131377393);
        ((RoundRelativeLayout)localObject1).a = ViewUtils.b(4.0F);
        ((RoundRelativeLayout)localObject1).setVisibility(0);
        if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
          paramProfileCardInfo.findViewById(2131363573).setBackgroundColor(Color.parseColor("#77F5F6FA"));
        }
        paramViewGroup.addView(paramProfileCardInfo);
        localObject1 = paramProfileCardInfo.getLayoutParams();
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          ((LinearLayout.LayoutParams)localObject1).width = i1;
          ((LinearLayout.LayoutParams)localObject1).height = i2;
          ((LinearLayout.LayoutParams)localObject1).rightMargin = m;
          paramProfileCardInfo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramProfileCardInfo.setOnClickListener(new ProfileCircleComponent.2(this));
        }
        j = 0 + i1;
        i = j;
        if (this.mQQCircleHostShouldReport)
        {
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 3, 2, 1);
          this.mQQCircleHostShouldReport = false;
          i = j;
        }
      }
    }
    int i3 = this.mQQCircleFeeds.size();
    j = 0;
    Object localObject3;
    if (j < i3)
    {
      localObject3 = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)this.mQQCircleFeeds.get(j)).get();
      if (localObject3 != null) {}
    }
    for (;;)
    {
      j += 1;
      break;
      String str = ((FeedCloudMeta.StFeed)localObject3).cover.picUrl.get();
      Object localObject2 = paramLayoutInflater.inflate(2131561521, null);
      paramProfileCardInfo = (RoundRelativeLayout)((View)localObject2).findViewById(2131377393);
      paramProfileCardInfo.a = ViewUtils.b(4.0F);
      paramProfileCardInfo.setVisibility(0);
      ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131369090);
      View localView = ((View)localObject2).findViewById(2131369092);
      paramProfileCardInfo = ((View)localObject2).findViewById(2131369089);
      ((View)localObject2).findViewById(2131369091);
      localObject1 = (TextView)((View)localObject2).findViewById(2131369086);
      ((UnderlineTextView)((View)localObject2).findViewById(2131369085)).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      int k = 0;
      if (((FeedCloudMeta.StFeed)localObject3).feedType.get() == 3) {}
      for (boolean bool = true;; bool = false)
      {
        if (!TextUtils.isEmpty(str))
        {
          k = 1;
          if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
            localImageView.setColorFilter(1996488704);
          }
          resetPicAndVideo(i1, i2, str, localImageView, localView, bool);
        }
        if (k != 0) {
          break label597;
        }
        QLog.w("ProfileCircleComponent", 1, "doMakeOrRefreshQQCircle: needUpdateUI=false,skip this one");
        break;
      }
      label597:
      paramViewGroup.addView((View)localObject2);
      localObject3 = ((View)localObject2).getLayoutParams();
      if ((localObject3 instanceof LinearLayout.LayoutParams))
      {
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      localObject2 = localImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i1;
      ((ViewGroup.LayoutParams)localObject2).height = i2;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramProfileCardInfo.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i1;
      ((ViewGroup.LayoutParams)localObject2).height = i2;
      paramProfileCardInfo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      k = i;
      if (i > 0) {
        k = i + m;
      }
      i = k + i1;
      if (i + i1 + m > n)
      {
        log(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
        return;
      }
      paramProfileCardInfo.setVisibility(8);
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  private void resetPicAndVideo(int paramInt1, int paramInt2, String paramString, ImageView paramImageView, View paramView, boolean paramBoolean)
  {
    if (this.mQQCircleDefaultPic == null) {
      this.mQQCircleDefaultPic = new ColorDrawable(this.mActivity.getResources().getColor(2131165731));
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mQQCircleDefaultPic;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mQQCircleDefaultPic;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
          if ((!paramString.contains("video=1")) && (!paramBoolean)) {
            break;
          }
          paramView.setVisibility(0);
          return;
        }
        if (!paramBoolean) {
          break label175;
        }
        localObject = ShortVideoUtils.getVideoThumbnail(this.mActivity, paramString, paramInt1, 0L);
        if (localObject != null)
        {
          paramImageView.setImageBitmap((Bitmap)localObject);
          continue;
        }
        paramImageView.setImageDrawable(this.mQQCircleDefaultPic);
      }
      catch (Exception paramString)
      {
        QLog.e("ProfileCircleComponent", 2, "makeOrRefreshQZone fail!", paramString);
        return;
      }
      continue;
      label175:
      paramImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
    }
    paramView.setVisibility(8);
  }
  
  private void setRedPoint(QQCircleFeedBase.StPageRedPointInfo paramStPageRedPointInfo, List<FeedCloudMeta.StFeed> paramList)
  {
    String str2 = "";
    String str1 = str2;
    if (this.mData != null)
    {
      str1 = str2;
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        str1 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
    }
    if (paramStPageRedPointInfo != null) {}
    do
    {
      for (;;)
      {
        try
        {
          if (paramStPageRedPointInfo.redTotalNum.get() > 0)
          {
            if (!TextUtils.isEmpty(paramStPageRedPointInfo.qqProfileInfo.txt.get()))
            {
              this.mQcircleUpdateinfo = paramStPageRedPointInfo.qqProfileInfo.txt.get();
              if (this.mQQCircleShouldReport)
              {
                if (TextUtils.isEmpty(this.mQcircleUpdateinfo)) {
                  break;
                }
                ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(str1, 3, 1, 3);
                this.mQQCircleShouldReport = false;
              }
              return;
            }
            this.mQcircleUpdateinfo = "";
            continue;
          }
        }
        catch (Exception paramStPageRedPointInfo)
        {
          this.mQcircleUpdateinfo = "";
          continue;
        }
        this.mQcircleUpdateinfo = "";
      }
    } while ((paramList == null) || (paramList.size() <= 0));
    paramStPageRedPointInfo = new HashMap();
    paramStPageRedPointInfo.put("ext1", getCircleProfileInfoExt1());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(str1, 3, 1, 1, paramStPageRedPointInfo, null, null);
    this.mQQCircleShouldReport = false;
  }
  
  private void setUserInfo(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, List<FeedCloudMeta.StFeed> paramList)
  {
    if (this.mActivity == null) {
      return;
    }
    long l3 = paramStGetMainPageRsp.fansCount.get();
    long l2 = 0L;
    int k = paramStGetMainPageRsp.fansValueStyle.get();
    j = 0;
    i = j;
    long l1 = l2;
    try
    {
      QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
      i = j;
      l1 = l2;
      localStMainPageBusiRspData.mergeFrom(paramStGetMainPageRsp.busiRspData.get().toByteArray());
      i = j;
      l1 = l2;
      l2 = localStMainPageBusiRspData.fuelValue.get();
      i = j;
      l1 = l2;
      j = localStMainPageBusiRspData.fuelValueStyle.get();
      i = j;
      l1 = l2;
      mRequestTimeInterval = localStMainPageBusiRspData.timeInterval.get();
      if (l3 != 0L)
      {
        i = j;
        l1 = l2;
        this.mFansText = String.format(this.mActivity.getString(2131699477), new Object[] { QCircleHostUtil.fansNumberFormatTranfer(l3) });
      }
      if (l2 != 0L)
      {
        i = j;
        l1 = l2;
        this.mFuelText = String.format(this.mActivity.getString(2131699478), new Object[] { QCircleHostUtil.fansNumberFormatTranfer(l2) });
      }
      i = j;
      l1 = l2;
      this.mFansValueStyle = k;
      i = j;
      l1 = l2;
      this.mFuelValueStyle = j;
      i = j;
      l1 = l2;
      setRedPoint((QQCircleFeedBase.StPageRedPointInfo)localStMainPageBusiRspData.RedPointInfo.get(), paramList);
      l1 = l2;
    }
    catch (Exception paramStGetMainPageRsp)
    {
      for (;;)
      {
        paramStGetMainPageRsp.printStackTrace();
        j = i;
      }
    }
    QLog.d("ProfileCircleComponent", 1, new Object[] { "setUserInfo fansCount: ", Long.valueOf(l3), " | fuelCount: ", Long.valueOf(l1), " | fansValueStyle:", k + " | fuelValueStyle: ", Integer.valueOf(j) });
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
    Object localObject;
    if (this.mActivity == null) {
      localObject = "他";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = this.mActivity.getString(2131699475);
        localObject = str;
      } while (paramProfileCardInfo == null);
      localObject = str;
    } while (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {
      return this.mActivity.getString(2131699474);
    }
    return this.mActivity.getString(2131699475);
  }
  
  public String getProfileContentKey()
  {
    return "map_key_qqcircle";
  }
  
  public boolean makeOrRefreshQQCircle(Card paramCard)
  {
    if ((!QzoneConfig.isQQCircleShowProfileCardEntrance()) || (this.mActivity == null)) {
      return false;
    }
    QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle start");
    long l = SystemClock.elapsedRealtime();
    if ((paramCard != null) && (paramCard.switchQQCircle != 1))
    {
      bool = true;
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle switch: " + bool);
      if (bool) {
        break label105;
      }
      if (this.mViewContainer == null) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      this.mViewContainer = null;
      return bool;
      bool = false;
      break;
    }
    label105:
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    QQAppInterface localQQAppInterface = this.mApp;
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mActivity);
    Object localObject2 = (View)this.mViewContainer;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localLayoutInflater.inflate(2131561520, null);
      this.mViewContainer = localObject1;
    }
    View localView = ((View)localObject1).findViewById(2131365147);
    ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131369087);
    ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131369088);
    if ((this.mQQCircleFeeds == null) || (this.mQQCircleFeeds.isEmpty()))
    {
      if (!this.isRefreshFeed) {
        refreshFeed(paramCard.uin);
      }
      localView.setVisibility(8);
      localViewGroup1.setVisibility(8);
      localViewGroup2.setVisibility(8);
      return true;
    }
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131379248);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131368834);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131368771);
    this.mProfileCircleInfoView = ((ProfileCircleInfoView)((View)localObject1).findViewById(2131367073));
    localTextView.setMaxWidth(2147483647);
    String str1;
    if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0)
    {
      String str2 = getGenderName(localProfileCardInfo);
      str1 = String.format(this.mActivity.getString(2131699476), new Object[] { str2 });
      if (!TextUtils.isEmpty(this.mQcircleUpdateinfo))
      {
        localObject2 = str1;
        if (ViewUtils.a(localTextView.getPaint(), str1) > ViewUtils.b(170.0F))
        {
          localObject2 = str1;
          if (str2.length() > 7)
          {
            localObject2 = str2.substring(0, 7) + "...";
            localObject2 = String.format(this.mActivity.getString(2131699476), new Object[] { localObject2 });
          }
        }
        localTextView.setText((String)localObject2 + this.mQcircleUpdateinfo);
        localImageView1.setVisibility(0);
        this.mProfileCircleInfoView.setVisibility(8);
        localViewGroup1.removeAllViews();
        localViewGroup1.setVisibility(0);
        if ((localViewGroup2 != null) && (localViewGroup2.getVisibility() != 8))
        {
          localViewGroup2.removeAllViews();
          localViewGroup2.setVisibility(8);
        }
        if (this.mQQCircleFeeds.isEmpty()) {
          break label797;
        }
        bool = true;
        resetCircleContainer(localProfileCardInfo, localLayoutInflater, localQQAppInterface, localViewGroup1);
      }
    }
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new ProfileCircleComponent.1(this, localProfileCardInfo, paramCard, localQQAppInterface));
      ((View)localObject1).setContentDescription(this.mActivity.getString(2131699473));
      updateItemTheme((View)localObject1, localTextView, null, localImageView2);
      localView.setVisibility(0);
      localViewGroup1.setVisibility(0);
      localViewGroup2.setVisibility(0);
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle end： " + (SystemClock.elapsedRealtime() - l));
      return bool;
      localImageView1.setVisibility(8);
      localTextView.setText(str1);
      if ((TextUtils.isEmpty(this.mFansText)) && (TextUtils.isEmpty(this.mFuelText))) {
        break;
      }
      localTextView.setMaxWidth(ViewUtils.a(140.0F));
      this.mProfileCircleInfoView.updateCircleInfo(this.mFansValueStyle, this.mFuelValueStyle, this.mFansText, this.mFuelText);
      this.mProfileCircleInfoView.setVisibility(0);
      break;
      if ((TextUtils.isEmpty(this.mFansText)) && (TextUtils.isEmpty(this.mFuelText))) {
        break;
      }
      this.mProfileCircleInfoView.updateCircleInfo(this.mFansValueStyle, this.mFuelValueStyle, this.mFansText, this.mFuelText);
      this.mProfileCircleInfoView.setVisibility(0);
      break;
      label797:
      bool = false;
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mUiHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.mScreenWidth = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshQQCircle(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mQQCircleFeeds != null)
    {
      this.mQQCircleFeeds.clear();
      this.mQQCircleFeeds = null;
    }
    if (this.mProfileCircleInfoView != null) {
      this.mProfileCircleInfoView.onDestroy();
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
    boolean bool = true;
    super.onResume();
    if (!QzoneConfig.isQQCircleShowProfileCardEntrance()) {
      QLog.d("ProfileCircleComponent", 4, "qqcircle profile card entrance is close");
    }
    do
    {
      do
      {
        return;
      } while ((this.mData == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard == null));
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.switchQQCircle != 1) {}
      for (;;)
      {
        QLog.d("ProfileCircleComponent", 4, "card switch_qqcircle: " + bool);
        if ((!bool) || (!isNeedRequestUserInfo(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin))) {
          break;
        }
        refreshFeed(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        return;
        bool = false;
      }
    } while (!bool);
    refreshFeedUsingCache(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent
 * JD-Core Version:    0.7.0.1
 */