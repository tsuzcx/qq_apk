import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem.6;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class prt
{
  public static spk a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static spk a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    spk localspk = new spk();
    localspk.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localspk.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localspk.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localspk.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localspk.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localspk.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localspk.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localspk.jdField_b_of_type_JavaLangString = ((String)localObject);
      localspk.k = paramBaseArticleInfo.getSubscribeUin();
      localspk.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localspk.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new rqa();
      ((rqa)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((rqa)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((rqa)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((rqa)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((rqa)localObject).j = paramBaseArticleInfo.getVideoWidth();
      ((rqa)localObject).k = paramBaseArticleInfo.getVideoHeight();
      ((rqa)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((rqa)localObject).o = 0;
      ((rqa)localObject).p = 0;
      ((rqa)localObject).q = 0;
      ((rqa)localObject).jdField_f_of_type_Boolean = false;
      ((rqa)localObject).g = false;
      ((rqa)localObject).h = false;
      ((rqa)localObject).jdField_f_of_type_JavaLangString = "";
      localspk.jdField_a_of_type_Rqa = ((rqa)localObject);
      localspk.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localspk.e = paramBaseArticleInfo.thirdName;
      localspk.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localspk.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localspk.j = paramBaseArticleInfo.getInnerUniqueID();
      localspk.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localspk.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localspk.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label400;
      }
    }
    label400:
    for (int i = 3;; i = 0)
    {
      localspk.m = i;
      if (ppe.a((ArticleInfo)paramBaseArticleInfo) == 4) {
        localspk.jdField_c_of_type_Boolean = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (pqt.j()))
      {
        i = DisplayUtil.dip2px(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localspk.o = i;
        localspk.p = i;
        localspk.q = i;
        localspk.r = i;
      }
      return localspk;
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
      break;
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getParent() instanceof View)) {
      a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, (View)paramView.getParent());
    }
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    paramView2.post(new RIJConfigVideoItem.6(paramView1, paramInt1, paramInt2, paramInt3, paramInt4, paramView2));
  }
  
  private static void a(View paramView1, View paramView2, Context paramContext)
  {
    a(paramView1, true, paramContext);
    a(paramView2, false, paramContext);
  }
  
  private static void a(View paramView, boolean paramBoolean, Context paramContext)
  {
    paramView.getPaddingLeft();
    int k = paramView.getPaddingTop();
    paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    int i = pnk.a(paramContext);
    int j;
    if (paramBoolean)
    {
      j = pnk.b(paramContext);
      i /= 2;
    }
    for (;;)
    {
      paramView.setPadding(j, k, i, m);
      return;
      j = i / 2;
      i = pnk.b(paramContext);
    }
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2, Context paramContext)
  {
    int i = bmhv.e();
    boolean bool2 = bmhv.t();
    paramTextView1.setMaxLines(i);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f;
    boolean bool1;
    if (bool2)
    {
      f = 5.0F;
      localLayoutParams.bottomMargin = AIOUtils.dp2px(f, paramContext.getResources());
      if (bool2) {
        break label186;
      }
      bool1 = true;
      label58:
      localLayoutParams.alignWithParent = bool1;
      paramTextView1.setLayoutParams(localLayoutParams);
      if (paramView1 != null) {
        if (!bool2) {
          break label192;
        }
      }
    }
    label186:
    label192:
    for (i = 0;; i = 8)
    {
      paramView1.setVisibility(i);
      if (!paramBaseArticleInfo.hasFamilyCommentIcon()) {
        break label211;
      }
      try
      {
        paramTextView1 = new URL(paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
        if (paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
          a(paramKandianUrlImageView, paramTextView1, paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int, paramContext);
        }
        paramKandianUrlImageView.setOnClickListener(new pry(paramContext, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString, paramView2));
        paramKandianUrlImageView.setVisibility(0);
        paramTextView2.setVisibility(8);
        return;
      }
      catch (MalformedURLException paramBaseArticleInfo)
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI exception");
        return;
      }
      f = 8.0F;
      break;
      bool1 = false;
      break label58;
    }
    label211:
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI setCommentCountText");
    paramKandianUrlImageView.setVisibility(8);
    paramTextView2.setVisibility(0);
    six.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), anvx.a(2131712383), "0");
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, Context paramContext)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (NetworkUtil.isWifiConnected(paramContext)))
    {
      bool = true;
      paramBaseArticleInfo.isShowGif = bool;
      localURL = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
      if (!paramBaseArticleInfo.isShowGif) {
        break label96;
      }
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramBaseArticleInfo.gifCoverUrl, localURLDrawableOptions));
    }
    for (;;)
    {
      a(paramKandianUrlImageView, localURL, paramBoolean, paramContext);
      return;
      bool = false;
      break;
      label96:
      paramImageView.setVisibility(8);
    }
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, int paramInt1, int paramInt2, Context paramContext)
  {
    if ((paramKandianUrlImageView == null) || (paramInt2 <= 0)) {
      return;
    }
    double d = paramInt1 / paramInt2;
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d + ", origin width " + localLayoutParams.width + " ,origin height " + localLayoutParams.height);
    localLayoutParams.height = Utils.dp2px(18.0D);
    localLayoutParams.width = ((int)(localLayoutParams.height * d));
    QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d + ", width " + localLayoutParams.width + " , height " + localLayoutParams.height);
    paramKandianUrlImageView.setLayoutParams(localLayoutParams);
    a(paramKandianUrlImageView, paramURL, false, paramContext);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, false, paramContext);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Context paramContext)
  {
    pjr.a(paramKandianUrlImageView, paramURL, paramContext, paramBoolean);
  }
  
  private static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if ((pqw.f(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
    {
      paramReadInJoyHeadImageView.setHeadImgByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = bheg.b();
    localURLDrawableOptions.mFailedDrawable = bheg.b();
    label179:
    label308:
    for (;;)
    {
      AdvertisementInfo localAdvertisementInfo;
      boolean bool;
      try
      {
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label244;
        }
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        bool = AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo);
        if (!bool) {
          break label215;
        }
      }
      catch (MalformedURLException paramReadInJoyHeadImageView) {}
      try
      {
        paramBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt).getString("applogo");
        bool = TextUtils.isEmpty(paramBaseArticleInfo);
        if (!bool) {
          break label179;
        }
        paramBaseArticleInfo = null;
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "cannot get avatar from app advertisement");
        paramBaseArticleInfo = localObject;
        continue;
      }
      if (paramBaseArticleInfo == null)
      {
        paramReadInJoyHeadImageView.setImageDrawable(bheg.b());
        paramReadInJoyHeadImageView.setVisibility(0);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "configVideoItemUI() ERROR e = " + paramReadInJoyHeadImageView.getMessage());
        return;
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        continue;
        label215:
        paramBaseArticleInfo = localObject;
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
          continue;
        }
        paramBaseArticleInfo = new URL(localAdvertisementInfo.mAdCorporateLogo);
        continue;
        label244:
        if (TextUtils.isEmpty(paramBaseArticleInfo.thirdIcon))
        {
          paramBaseArticleInfo = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          break label308;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label308;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(bgxc.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (pqw.f(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(uks.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(pjr.a(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private static void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (pqt.j())
    {
      paramRoundAngleFrameLayout.setRadius(28);
      return;
    }
    paramRoundAngleFrameLayout.setRadius(0);
  }
  
  /* Error */
  public static void a(sxd paramsxd, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 600	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +144 -> 153
    //   12: aload_1
    //   13: getfield 600	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 605	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   23: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +448 -> 474
    //   29: aload_0
    //   30: getfield 610	sxd:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 6
    //   35: getfield 605	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   38: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_0
    //   42: getfield 610	sxd:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   49: aload 6
    //   51: getfield 612	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +439 -> 496
    //   60: new 223	java/net/URL
    //   63: dup
    //   64: aload 6
    //   66: getfield 612	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 7
    //   74: aload_0
    //   75: getfield 615	sxd:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 7
    //   80: invokevirtual 619	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_0
    //   85: getfield 615	sxd:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 6
    //   94: getfield 620	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +426 -> 526
    //   103: aload_0
    //   104: getfield 622	sxd:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   107: aload 6
    //   109: getfield 620	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_0
    //   116: getfield 622	sxd:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   123: aload 6
    //   125: getfield 623	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:j	Ljava/lang/String;
    //   128: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +22 -> 153
    //   134: aload 6
    //   136: getfield 623	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:j	Ljava/lang/String;
    //   139: invokestatic 629	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: aload_0
    //   145: getfield 622	sxd:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   148: iload 5
    //   150: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   153: aload_1
    //   154: invokestatic 634	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lspk;
    //   157: astore 6
    //   159: aload 6
    //   161: aload_0
    //   162: getfield 636	sxd:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   165: putfield 639	spk:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   168: aload 6
    //   170: aload_0
    //   171: getfield 640	sxd:jdField_a_of_type_Int	I
    //   174: putfield 641	spk:jdField_a_of_type_Int	I
    //   177: aload 6
    //   179: aload_1
    //   180: putfield 179	spk:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   183: aload_0
    //   184: aload 6
    //   186: putfield 644	sxd:jdField_a_of_type_Spk	Lspk;
    //   189: aload_0
    //   190: getfield 646	sxd:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   193: aload_1
    //   194: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   197: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   200: aload_0
    //   201: getfield 646	sxd:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   204: invokevirtual 650	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   207: iconst_1
    //   208: invokevirtual 656	android/text/TextPaint:setFakeBoldText	(Z)V
    //   211: aload_0
    //   212: getfield 646	sxd:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   215: aload_2
    //   216: invokevirtual 661	pne:a	()Lpnh;
    //   219: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   222: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   225: ldc_w 666
    //   228: invokevirtual 672	android/content/res/Resources:getColor	(I)I
    //   231: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   234: aload_0
    //   235: getfield 674	sxd:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   238: bipush 8
    //   240: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   243: aload_0
    //   244: getfield 676	sxd:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   247: aload 6
    //   249: getfield 40	spk:jdField_b_of_type_Int	I
    //   252: iconst_1
    //   253: invokestatic 679	pjr:a	(IZ)Ljava/lang/String;
    //   256: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   259: aload_0
    //   260: getfield 682	sxd:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   263: bipush 10
    //   265: bipush 10
    //   267: bipush 10
    //   269: bipush 10
    //   271: invokestatic 687	com/tencent/biz/qqstory/utils/UIUtils:expandViewTouchArea	(Landroid/view/View;IIII)V
    //   274: aload_0
    //   275: getfield 682	sxd:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   278: aload_0
    //   279: invokevirtual 691	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   282: aload_0
    //   283: getfield 682	sxd:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   286: aload_3
    //   287: invokevirtual 692	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   290: aload_2
    //   291: invokevirtual 661	pne:a	()Lpnh;
    //   294: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   297: aload_0
    //   298: getfield 636	sxd:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   301: aload_0
    //   302: getfield 644	sxd:jdField_a_of_type_Spk	Lspk;
    //   305: invokestatic 697	qdc:a	(Landroid/content/Context;Landroid/widget/ImageView;Lspk;)V
    //   308: aload_0
    //   309: getfield 636	sxd:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   312: aload_1
    //   313: iconst_0
    //   314: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   317: iconst_0
    //   318: aload_2
    //   319: invokevirtual 661	pne:a	()Lpnh;
    //   322: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   325: invokestatic 427	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   328: aload_0
    //   329: getfield 636	sxd:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   332: aload 4
    //   334: invokevirtual 701	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   337: aload_0
    //   338: getfield 704	sxd:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   341: fconst_1
    //   342: aload 6
    //   344: getfield 45	spk:jdField_c_of_type_Int	I
    //   347: aload 6
    //   349: getfield 51	spk:jdField_d_of_type_Int	I
    //   352: invokestatic 707	pjr:a	(II)F
    //   355: invokevirtual 713	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   358: aload_0
    //   359: getfield 704	sxd:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   362: aload_0
    //   363: invokevirtual 714	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   366: aload_2
    //   367: invokevirtual 661	pne:a	()Lpnh;
    //   370: invokevirtual 717	pnh:a	()Lszd;
    //   373: aload_2
    //   374: invokevirtual 661	pne:a	()Lpnh;
    //   377: invokevirtual 719	pnh:b	()I
    //   380: aload_1
    //   381: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   384: invokevirtual 724	szd:b	(IJ)Z
    //   387: ifeq +26 -> 413
    //   390: aload_0
    //   391: getfield 726	sxd:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   394: aload_2
    //   395: invokevirtual 661	pne:a	()Lpnh;
    //   398: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   401: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   404: ldc_w 727
    //   407: invokevirtual 672	android/content/res/Resources:getColor	(I)I
    //   410: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   413: aload_1
    //   414: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   417: lconst_0
    //   418: lcmp
    //   419: ifgt +119 -> 538
    //   422: aload_0
    //   423: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   426: ldc_w 733
    //   429: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   432: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   435: aload_2
    //   436: invokevirtual 661	pne:a	()Lpnh;
    //   439: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   442: invokestatic 388	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   445: ifeq +132 -> 577
    //   448: aload_0
    //   449: getfield 735	sxd:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   452: iconst_0
    //   453: invokevirtual 394	android/widget/ImageView:setVisibility	(I)V
    //   456: aload_0
    //   457: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   460: bipush 8
    //   462: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   465: aload_0
    //   466: getfield 737	sxd:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   469: iconst_0
    //   470: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   473: return
    //   474: aload_0
    //   475: getfield 610	sxd:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   478: bipush 8
    //   480: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   483: goto -434 -> 49
    //   486: astore 7
    //   488: aload 7
    //   490: invokevirtual 740	java/lang/Exception:printStackTrace	()V
    //   493: goto -401 -> 92
    //   496: aload_0
    //   497: getfield 615	sxd:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   500: bipush 8
    //   502: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   505: goto -413 -> 92
    //   508: astore 6
    //   510: aload_0
    //   511: getfield 622	sxd:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   514: ldc_w 742
    //   517: invokestatic 629	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   520: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   523: goto -370 -> 153
    //   526: aload_0
    //   527: getfield 622	sxd:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   530: bipush 8
    //   532: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   535: goto -382 -> 153
    //   538: aload_0
    //   539: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   542: new 430	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 431	java/lang/StringBuilder:<init>	()V
    //   549: aload_1
    //   550: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   553: invokestatic 745	six:b	(J)Ljava/lang/String;
    //   556: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: ldc_w 746
    //   562: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   565: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   574: goto -139 -> 435
    //   577: aload_0
    //   578: getfield 735	sxd:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   581: bipush 8
    //   583: invokevirtual 394	android/widget/ImageView:setVisibility	(I)V
    //   586: aload_2
    //   587: invokevirtual 661	pne:a	()Lpnh;
    //   590: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   593: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   596: ldc_w 747
    //   599: invokevirtual 750	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   602: astore_3
    //   603: aload_0
    //   604: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   607: aload_3
    //   608: aconst_null
    //   609: aconst_null
    //   610: aconst_null
    //   611: invokevirtual 754	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   614: aload_0
    //   615: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   618: ldc_w 755
    //   621: aload_2
    //   622: invokevirtual 661	pne:a	()Lpnh;
    //   625: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   628: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   631: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   634: invokevirtual 758	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   637: aload_0
    //   638: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   641: iconst_0
    //   642: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   645: invokestatic 762	bhyk:a	()I
    //   648: iconst_1
    //   649: if_icmpne +34 -> 683
    //   652: aload_0
    //   653: getfield 732	sxd:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   656: ldc_w 763
    //   659: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   662: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   665: aload_0
    //   666: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   669: bipush 8
    //   671: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   674: aload_0
    //   675: getfield 737	sxd:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   678: iconst_0
    //   679: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   682: return
    //   683: invokestatic 768	bmhv:z	()Z
    //   686: ifeq +291 -> 977
    //   689: aload_2
    //   690: invokevirtual 661	pne:a	()Lpnh;
    //   693: invokevirtual 770	pnh:e	()Z
    //   696: ifne +281 -> 977
    //   699: aload_0
    //   700: getfield 640	sxd:jdField_a_of_type_Int	I
    //   703: ifne +274 -> 977
    //   706: invokestatic 772	bmhv:e	()Ljava/lang/String;
    //   709: astore 4
    //   711: invokestatic 774	bmhv:f	()Ljava/lang/String;
    //   714: astore 6
    //   716: invokestatic 776	bmhv:g	()Ljava/lang/String;
    //   719: astore 7
    //   721: aload 4
    //   723: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   726: ifne +217 -> 943
    //   729: invokestatic 781	pnn:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   732: astore 8
    //   734: ldc 134
    //   736: astore_3
    //   737: aload 8
    //   739: ifnull +9 -> 748
    //   742: aload 8
    //   744: invokevirtual 786	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   747: astore_3
    //   748: new 788	suu
    //   751: dup
    //   752: aconst_null
    //   753: aconst_null
    //   754: aconst_null
    //   755: aconst_null
    //   756: invokespecial 791	suu:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload_3
    //   760: invokevirtual 794	suu:m	(Ljava/lang/String;)Lsuu;
    //   763: aload_1
    //   764: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   767: invokevirtual 796	suu:i	(Ljava/lang/String;)Lsuu;
    //   770: invokevirtual 799	suu:a	()Lsut;
    //   773: invokevirtual 803	sut:a	()Ljava/lang/String;
    //   776: astore_1
    //   777: aload_0
    //   778: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   781: iconst_0
    //   782: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   785: aload_0
    //   786: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   789: fconst_2
    //   790: aload_2
    //   791: invokevirtual 661	pne:a	()Lpnh;
    //   794: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   797: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   800: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   803: invokevirtual 758	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   806: aload_2
    //   807: invokevirtual 661	pne:a	()Lpnh;
    //   810: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   813: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   816: ldc_w 804
    //   819: invokevirtual 750	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   822: astore_3
    //   823: aload_3
    //   824: iconst_0
    //   825: iconst_0
    //   826: ldc_w 805
    //   829: aload_2
    //   830: invokevirtual 661	pne:a	()Lpnh;
    //   833: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   836: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   839: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   842: ldc_w 805
    //   845: aload_2
    //   846: invokevirtual 661	pne:a	()Lpnh;
    //   849: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   852: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   855: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   858: invokevirtual 810	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   861: aload_0
    //   862: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   865: aconst_null
    //   866: aconst_null
    //   867: aload_3
    //   868: aconst_null
    //   869: invokevirtual 813	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   872: aload_2
    //   873: invokevirtual 661	pne:a	()Lpnh;
    //   876: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   879: aload_0
    //   880: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   883: aload 6
    //   885: aload 7
    //   887: aload 4
    //   889: new 815	prw
    //   892: dup
    //   893: aload_1
    //   894: aload_0
    //   895: invokespecial 818	prw:<init>	(Ljava/lang/String;Lsxd;)V
    //   898: invokestatic 821	six:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   901: aload_0
    //   902: getfield 737	sxd:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   905: ldc_w 822
    //   908: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   911: aload_2
    //   912: invokevirtual 661	pne:a	()Lpnh;
    //   915: iconst_1
    //   916: invokevirtual 825	pnh:c	(Z)Lpnh;
    //   919: pop
    //   920: aconst_null
    //   921: ldc 134
    //   923: ldc_w 827
    //   926: ldc_w 827
    //   929: iconst_0
    //   930: iconst_0
    //   931: ldc 134
    //   933: ldc 134
    //   935: ldc 134
    //   937: aload_1
    //   938: iconst_0
    //   939: invokestatic 832	olh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   942: return
    //   943: aload_0
    //   944: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   947: bipush 8
    //   949: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   952: aload_0
    //   953: getfield 737	sxd:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   956: iconst_0
    //   957: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   960: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   963: ifeq -959 -> 4
    //   966: ldc_w 834
    //   969: iconst_2
    //   970: ldc_w 836
    //   973: invokestatic 839	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: return
    //   977: aload_0
    //   978: getfield 765	sxd:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   981: bipush 8
    //   983: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   986: aload_0
    //   987: getfield 737	sxd:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   990: iconst_0
    //   991: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   994: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	paramsxd	sxd
    //   0	995	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	995	2	parampne	pne
    //   0	995	3	paramOnClickListener	View.OnClickListener
    //   0	995	4	paramOnLongClickListener	View.OnLongClickListener
    //   142	7	5	i	int
    //   16	332	6	localObject	Object
    //   508	1	6	localThrowable	java.lang.Throwable
    //   714	170	6	str1	String
    //   72	7	7	localURL	URL
    //   486	3	7	localException	Exception
    //   719	167	7	str2	String
    //   732	11	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   60	92	486	java/lang/Exception
    //   134	153	508	java/lang/Throwable
  }
  
  /* Error */
  public static void a(sxe paramsxe, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 843	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +542 -> 554
    //   15: aload_0
    //   16: getfield 847	sxe:i	Landroid/widget/TextView;
    //   19: aload_1
    //   20: getfield 843	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_1
    //   27: getfield 850	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +512 -> 545
    //   36: ldc_w 852
    //   39: astore 6
    //   41: aload 6
    //   43: invokestatic 629	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore 5
    //   48: aload_0
    //   49: getfield 847	sxe:i	Landroid/widget/TextView;
    //   52: iload 5
    //   54: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   57: aload_0
    //   58: getfield 847	sxe:i	Landroid/widget/TextView;
    //   61: iconst_0
    //   62: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   65: aload_0
    //   66: getfield 853	sxe:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   69: aload_1
    //   70: getfield 856	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   73: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   76: aload_1
    //   77: invokevirtual 322	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   80: ifeq +501 -> 581
    //   83: new 223	java/net/URL
    //   86: dup
    //   87: aload_1
    //   88: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrpd;
    //   91: getfield 329	rpd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: astore 6
    //   99: aload_1
    //   100: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrpd;
    //   103: getfield 333	rpd:jdField_b_of_type_Int	I
    //   106: ifle +33 -> 139
    //   109: aload_0
    //   110: getfield 857	sxe:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   113: aload 6
    //   115: aload_1
    //   116: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrpd;
    //   119: getfield 334	rpd:jdField_a_of_type_Int	I
    //   122: aload_1
    //   123: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrpd;
    //   126: getfield 333	rpd:jdField_b_of_type_Int	I
    //   129: aload_2
    //   130: invokevirtual 661	pne:a	()Lpnh;
    //   133: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   136: invokestatic 337	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;IILandroid/content/Context;)V
    //   139: aload_0
    //   140: getfield 857	sxe:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   143: iconst_0
    //   144: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   147: aload_0
    //   148: getfield 859	sxe:h	Landroid/widget/TextView;
    //   151: bipush 8
    //   153: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   156: aload_1
    //   157: getfield 862	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   160: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifne +494 -> 657
    //   166: new 223	java/net/URL
    //   169: dup
    //   170: aload_1
    //   171: getfield 862	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   174: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   177: astore 6
    //   179: aload_0
    //   180: getfield 864	sxe:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   183: aload 6
    //   185: invokevirtual 619	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   188: pop
    //   189: aload_0
    //   190: getfield 864	sxe:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   193: iconst_0
    //   194: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   197: aload_0
    //   198: getfield 865	sxe:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   201: bipush 10
    //   203: bipush 10
    //   205: bipush 10
    //   207: bipush 10
    //   209: invokestatic 687	com/tencent/biz/qqstory/utils/UIUtils:expandViewTouchArea	(Landroid/view/View;IIII)V
    //   212: aload_0
    //   213: getfield 865	sxe:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 691	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   220: aload_0
    //   221: getfield 865	sxe:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   224: aload_3
    //   225: invokevirtual 692	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   228: aload_1
    //   229: invokestatic 634	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lspk;
    //   232: astore_3
    //   233: aload_3
    //   234: aload_0
    //   235: getfield 866	sxe:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   238: putfield 639	spk:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   241: aload_3
    //   242: aload_0
    //   243: getfield 867	sxe:jdField_a_of_type_Int	I
    //   246: putfield 641	spk:jdField_a_of_type_Int	I
    //   249: aload_3
    //   250: aload_1
    //   251: putfield 179	spk:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   254: aload_3
    //   255: iconst_1
    //   256: putfield 870	spk:n	I
    //   259: aload_0
    //   260: aload_3
    //   261: putfield 871	sxe:jdField_a_of_type_Spk	Lspk;
    //   264: aload_0
    //   265: getfield 872	sxe:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   268: bipush 8
    //   270: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   273: aload_0
    //   274: getfield 873	sxe:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   277: bipush 8
    //   279: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   282: aload_0
    //   283: getfield 875	sxe:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   286: bipush 8
    //   288: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   291: aload_0
    //   292: getfield 876	sxe:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   295: aload_1
    //   296: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   299: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   302: aload_0
    //   303: getfield 876	sxe:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   306: astore 6
    //   308: invokestatic 881	pvj:a	()Lpvj;
    //   311: aload_1
    //   312: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   315: invokevirtual 884	pvj:a	(J)Z
    //   318: ifeq +351 -> 669
    //   321: getstatic 887	pnm:jdField_a_of_type_Int	I
    //   324: istore 5
    //   326: aload 6
    //   328: iload 5
    //   330: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   333: aload_0
    //   334: getfield 888	sxe:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   337: aload_3
    //   338: getfield 40	spk:jdField_b_of_type_Int	I
    //   341: iconst_1
    //   342: invokestatic 679	pjr:a	(IZ)Ljava/lang/String;
    //   345: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   348: aload_2
    //   349: invokevirtual 661	pne:a	()Lpnh;
    //   352: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   355: aload_0
    //   356: getfield 866	sxe:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   359: aload_0
    //   360: getfield 871	sxe:jdField_a_of_type_Spk	Lspk;
    //   363: invokestatic 697	qdc:a	(Landroid/content/Context;Landroid/widget/ImageView;Lspk;)V
    //   366: aload_0
    //   367: getfield 866	sxe:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   370: aload_1
    //   371: iconst_0
    //   372: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   375: iconst_0
    //   376: aload_2
    //   377: invokevirtual 661	pne:a	()Lpnh;
    //   380: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   383: invokestatic 427	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   386: aload_0
    //   387: getfield 866	sxe:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   390: aload 4
    //   392: invokevirtual 701	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   395: aload_0
    //   396: getfield 888	sxe:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   399: iconst_0
    //   400: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   403: aload_0
    //   404: getfield 888	sxe:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   407: invokevirtual 891	android/widget/TextView:clearAnimation	()V
    //   410: aload_0
    //   411: getfield 892	sxe:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   414: fconst_1
    //   415: aload_3
    //   416: getfield 45	spk:jdField_c_of_type_Int	I
    //   419: aload_3
    //   420: getfield 51	spk:jdField_d_of_type_Int	I
    //   423: invokestatic 707	pjr:a	(II)F
    //   426: invokevirtual 713	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   429: aload_0
    //   430: getfield 892	sxe:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   433: aload_0
    //   434: invokevirtual 714	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   437: aload_2
    //   438: invokevirtual 661	pne:a	()Lpnh;
    //   441: invokevirtual 717	pnh:a	()Lszd;
    //   444: aload_2
    //   445: invokevirtual 661	pne:a	()Lpnh;
    //   448: invokevirtual 719	pnh:b	()I
    //   451: aload_1
    //   452: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   455: invokevirtual 724	szd:b	(IJ)Z
    //   458: ifeq +26 -> 484
    //   461: aload_0
    //   462: getfield 893	sxe:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   465: aload_2
    //   466: invokevirtual 661	pne:a	()Lpnh;
    //   469: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   472: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   475: ldc_w 727
    //   478: invokevirtual 672	android/content/res/Resources:getColor	(I)I
    //   481: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   484: aload_1
    //   485: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   488: lconst_0
    //   489: lcmp
    //   490: ifgt +187 -> 677
    //   493: aload_0
    //   494: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   497: ldc_w 733
    //   500: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   503: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   506: aload_2
    //   507: invokevirtual 661	pne:a	()Lpnh;
    //   510: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   513: invokestatic 388	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   516: ifeq +200 -> 716
    //   519: aload_0
    //   520: getfield 895	sxe:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   523: iconst_0
    //   524: invokevirtual 394	android/widget/ImageView:setVisibility	(I)V
    //   527: aload_0
    //   528: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   531: bipush 8
    //   533: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   536: aload_0
    //   537: getfield 896	sxe:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   540: iconst_0
    //   541: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   544: return
    //   545: aload_1
    //   546: getfield 850	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   549: astore 6
    //   551: goto -510 -> 41
    //   554: aload_0
    //   555: getfield 847	sxe:i	Landroid/widget/TextView;
    //   558: bipush 8
    //   560: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   563: goto -498 -> 65
    //   566: astore 6
    //   568: ldc_w 353
    //   571: iconst_2
    //   572: ldc_w 898
    //   575: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: goto -422 -> 156
    //   581: aload_0
    //   582: getfield 857	sxe:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   585: bipush 8
    //   587: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   590: aload_0
    //   591: getfield 859	sxe:h	Landroid/widget/TextView;
    //   594: iconst_0
    //   595: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   598: ldc_w 353
    //   601: iconst_2
    //   602: ldc_w 900
    //   605: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_0
    //   609: getfield 859	sxe:h	Landroid/widget/TextView;
    //   612: new 430	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 431	java/lang/StringBuilder:<init>	()V
    //   619: aload_1
    //   620: invokevirtual 365	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   623: invokestatic 902	six:d	(I)Ljava/lang/String;
    //   626: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w 903
    //   632: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   635: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   644: goto -488 -> 156
    //   647: astore 6
    //   649: aload 6
    //   651: invokevirtual 740	java/lang/Exception:printStackTrace	()V
    //   654: goto -457 -> 197
    //   657: aload_0
    //   658: getfield 864	sxe:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   661: bipush 8
    //   663: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   666: goto -469 -> 197
    //   669: getstatic 904	pnm:jdField_b_of_type_Int	I
    //   672: istore 5
    //   674: goto -348 -> 326
    //   677: aload_0
    //   678: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   681: new 430	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 431	java/lang/StringBuilder:<init>	()V
    //   688: aload_1
    //   689: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   692: invokestatic 745	six:b	(J)Ljava/lang/String;
    //   695: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 746
    //   701: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   704: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   713: goto -207 -> 506
    //   716: aload_0
    //   717: getfield 895	sxe:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   720: bipush 8
    //   722: invokevirtual 394	android/widget/ImageView:setVisibility	(I)V
    //   725: aload_2
    //   726: invokevirtual 661	pne:a	()Lpnh;
    //   729: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   732: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   735: ldc_w 747
    //   738: invokevirtual 750	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   741: astore_3
    //   742: aload_0
    //   743: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   746: aload_3
    //   747: aconst_null
    //   748: aconst_null
    //   749: aconst_null
    //   750: invokevirtual 754	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   753: aload_0
    //   754: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   757: ldc_w 755
    //   760: aload_2
    //   761: invokevirtual 661	pne:a	()Lpnh;
    //   764: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   767: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   770: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   773: invokevirtual 758	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   776: aload_0
    //   777: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   780: iconst_0
    //   781: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   784: invokestatic 762	bhyk:a	()I
    //   787: iconst_1
    //   788: if_icmpne +34 -> 822
    //   791: aload_0
    //   792: getfield 894	sxe:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   795: ldc_w 763
    //   798: invokestatic 371	anvx:a	(I)Ljava/lang/String;
    //   801: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   804: aload_0
    //   805: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   808: bipush 8
    //   810: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   813: aload_0
    //   814: getfield 896	sxe:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   817: iconst_0
    //   818: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   821: return
    //   822: invokestatic 768	bmhv:z	()Z
    //   825: ifeq +291 -> 1116
    //   828: aload_2
    //   829: invokevirtual 661	pne:a	()Lpnh;
    //   832: invokevirtual 770	pnh:e	()Z
    //   835: ifne +281 -> 1116
    //   838: aload_0
    //   839: getfield 867	sxe:jdField_a_of_type_Int	I
    //   842: ifne +274 -> 1116
    //   845: invokestatic 772	bmhv:e	()Ljava/lang/String;
    //   848: astore 4
    //   850: invokestatic 774	bmhv:f	()Ljava/lang/String;
    //   853: astore 6
    //   855: invokestatic 776	bmhv:g	()Ljava/lang/String;
    //   858: astore 7
    //   860: aload 4
    //   862: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   865: ifne +217 -> 1082
    //   868: invokestatic 781	pnn:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   871: astore 8
    //   873: ldc 134
    //   875: astore_3
    //   876: aload 8
    //   878: ifnull +9 -> 887
    //   881: aload 8
    //   883: invokevirtual 786	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   886: astore_3
    //   887: new 788	suu
    //   890: dup
    //   891: aconst_null
    //   892: aconst_null
    //   893: aconst_null
    //   894: aconst_null
    //   895: invokespecial 791	suu:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload_3
    //   899: invokevirtual 794	suu:m	(Ljava/lang/String;)Lsuu;
    //   902: aload_1
    //   903: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   906: invokevirtual 796	suu:i	(Ljava/lang/String;)Lsuu;
    //   909: invokevirtual 799	suu:a	()Lsut;
    //   912: invokevirtual 803	sut:a	()Ljava/lang/String;
    //   915: astore_1
    //   916: aload_0
    //   917: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   920: iconst_0
    //   921: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   924: aload_0
    //   925: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   928: fconst_2
    //   929: aload_2
    //   930: invokevirtual 661	pne:a	()Lpnh;
    //   933: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   936: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   939: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   942: invokevirtual 758	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   945: aload_2
    //   946: invokevirtual 661	pne:a	()Lpnh;
    //   949: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   952: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   955: ldc_w 804
    //   958: invokevirtual 750	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   961: astore_3
    //   962: aload_3
    //   963: iconst_0
    //   964: iconst_0
    //   965: ldc_w 805
    //   968: aload_2
    //   969: invokevirtual 661	pne:a	()Lpnh;
    //   972: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   975: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   978: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   981: ldc_w 805
    //   984: aload_2
    //   985: invokevirtual 661	pne:a	()Lpnh;
    //   988: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   991: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   994: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   997: invokevirtual 810	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1000: aload_0
    //   1001: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1004: aconst_null
    //   1005: aconst_null
    //   1006: aload_3
    //   1007: aconst_null
    //   1008: invokevirtual 813	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1011: aload_2
    //   1012: invokevirtual 661	pne:a	()Lpnh;
    //   1015: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   1018: aload_0
    //   1019: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1022: aload 6
    //   1024: aload 7
    //   1026: aload 4
    //   1028: new 907	prv
    //   1031: dup
    //   1032: aload_1
    //   1033: aload_0
    //   1034: invokespecial 910	prv:<init>	(Ljava/lang/String;Lsxe;)V
    //   1037: invokestatic 821	six:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1040: aload_0
    //   1041: getfield 896	sxe:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1044: ldc_w 822
    //   1047: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   1050: aload_2
    //   1051: invokevirtual 661	pne:a	()Lpnh;
    //   1054: iconst_1
    //   1055: invokevirtual 825	pnh:c	(Z)Lpnh;
    //   1058: pop
    //   1059: aconst_null
    //   1060: ldc 134
    //   1062: ldc_w 827
    //   1065: ldc_w 827
    //   1068: iconst_0
    //   1069: iconst_0
    //   1070: ldc 134
    //   1072: ldc 134
    //   1074: ldc 134
    //   1076: aload_1
    //   1077: iconst_0
    //   1078: invokestatic 832	olh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1081: return
    //   1082: aload_0
    //   1083: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1086: bipush 8
    //   1088: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   1091: aload_0
    //   1092: getfield 896	sxe:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1095: iconst_0
    //   1096: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   1099: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1102: ifeq -1098 -> 4
    //   1105: ldc_w 834
    //   1108: iconst_2
    //   1109: ldc_w 836
    //   1112: invokestatic 839	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: return
    //   1116: aload_0
    //   1117: getfield 905	sxe:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1120: bipush 8
    //   1122: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   1125: aload_0
    //   1126: getfield 896	sxe:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1129: iconst_0
    //   1130: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   1133: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1134	0	paramsxe	sxe
    //   0	1134	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1134	2	parampne	pne
    //   0	1134	3	paramOnClickListener	View.OnClickListener
    //   0	1134	4	paramOnLongClickListener	View.OnLongClickListener
    //   46	627	5	i	int
    //   39	511	6	localObject	Object
    //   566	1	6	localMalformedURLException	MalformedURLException
    //   647	3	6	localException	Exception
    //   853	170	6	str1	String
    //   858	167	7	str2	String
    //   871	11	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   83	139	566	java/net/MalformedURLException
    //   139	156	566	java/net/MalformedURLException
    //   166	197	647	java/lang/Exception
  }
  
  private static void a(sxf paramsxf, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    paramsxf.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    VideoColumnInfo localVideoColumnInfo;
    if (paramBaseArticleInfo.mVideoColumnInfo != null)
    {
      localVideoColumnInfo = paramBaseArticleInfo.mVideoColumnInfo;
      if (localVideoColumnInfo.jdField_d_of_type_Int != 1) {
        break label407;
      }
      paramBaseArticleInfo = paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      paramBaseArticleInfo.height = DisplayUtil.dip2px(parampne.a().a(), 90.0F);
      paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramBaseArticleInfo);
    }
    try
    {
      if (!TextUtils.isEmpty(localVideoColumnInfo.jdField_d_of_type_JavaLangString)) {
        a(paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(localVideoColumnInfo.jdField_d_of_type_JavaLangString), parampne.a().a());
      }
    }
    catch (Exception paramBaseArticleInfo)
    {
      try
      {
        if (!TextUtils.isEmpty(localVideoColumnInfo.e))
        {
          paramBaseArticleInfo = pjr.a(localVideoColumnInfo.e);
          paramsxf.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramBaseArticleInfo);
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        try
        {
          a(paramsxf.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(localVideoColumnInfo.jdField_f_of_type_JavaLangString), parampne.a().a());
          paramsxf.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoColumnInfo.jdField_b_of_type_JavaLangString);
          paramBaseArticleInfo = pkg.a(localVideoColumnInfo.jdField_a_of_type_Long, true) + anvx.a(2131712186);
          String str1 = bmhv.b(localVideoColumnInfo.jdField_b_of_type_Int) + anvx.a(2131712295);
          String str2 = localVideoColumnInfo.jdField_c_of_type_Int + anvx.a(2131712545);
          paramBaseArticleInfo = paramBaseArticleInfo + " · " + str1 + " · " + str2;
          paramsxf.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo);
          if (localVideoColumnInfo.jdField_a_of_type_Boolean)
          {
            paramsxf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            paramsxf.i.setText(localVideoColumnInfo.jdField_g_of_type_JavaLangString);
          }
        }
        catch (MalformedURLException paramBaseArticleInfo)
        {
          try
          {
            for (;;)
            {
              paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(DisplayUtil.dip2px(parampne.a().a(), 2.0F));
              a(paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, new URL(localVideoColumnInfo.h), parampne.a().a());
              paramsxf.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramsxf);
              paramsxf.jdField_c_of_type_AndroidWidgetTextView.setTag(paramsxf);
              paramsxf.jdField_b_of_type_AndroidViewViewGroup.setTag(paramsxf);
              paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setTag(paramsxf);
              paramsxf.i.setTag(paramsxf);
              return;
              label407:
              paramBaseArticleInfo = paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
              paramBaseArticleInfo.height = DisplayUtil.dip2px(parampne.a().a(), 80.0F);
              paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramBaseArticleInfo);
              continue;
              paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(new ColorDrawable(-15837762));
              continue;
              paramBaseArticleInfo = paramBaseArticleInfo;
              if (QLog.isColorLevel())
              {
                QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgUrl error: ", paramBaseArticleInfo);
                continue;
                paramBaseArticleInfo = new ColorDrawable(-15837762);
                continue;
                paramBaseArticleInfo = paramBaseArticleInfo;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgColor error: ", paramBaseArticleInfo);
                }
                paramsxf.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(new ColorDrawable(-15837762));
                continue;
                paramBaseArticleInfo = paramBaseArticleInfo;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyBaseAdapter", 2, "configImage columnCardIcon error: ", paramBaseArticleInfo);
                }
              }
            }
            paramsxf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          catch (Exception paramBaseArticleInfo)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseAdapter", 2, "configImage appIcon error: ", paramBaseArticleInfo);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(sxf paramsxf, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    paramsxf.jdField_b_of_type_AndroidWidgetImageView.setTag(paramsxf);
    paramsxf.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = a(paramBaseArticleInfo);
    paramOnClickListener.jdField_a_of_type_AndroidViewView = paramsxf.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    paramOnClickListener.jdField_a_of_type_Int = paramsxf.jdField_a_of_type_Int;
    paramOnClickListener.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramsxf.jdField_a_of_type_Spk = paramOnClickListener;
    paramsxf.jdField_d_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    paramsxf.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramsxf.jdField_d_of_type_AndroidWidgetTextView.setTextColor(parampne.a().a().getResources().getColor(2131167363));
    if (paramBaseArticleInfo.mVideoPlayCount == 0) {
      paramsxf.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramsxf.jdField_f_of_type_AndroidWidgetTextView.setText(pjr.a(paramOnClickListener.jdField_b_of_type_Int, true));
      qdc.a(parampne.a().a(), paramsxf.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramsxf.jdField_a_of_type_Spk);
      a(paramsxf.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, parampne.a().a());
      paramsxf.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
      paramsxf.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramsxf);
      paramsxf.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      paramsxf.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pjr.a(paramOnClickListener.jdField_c_of_type_Int, paramOnClickListener.jdField_d_of_type_Int));
      paramsxf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(paramsxf);
      if (parampne.a().a().b(parampne.a().b(), paramBaseArticleInfo.mArticleID)) {
        paramsxf.jdField_g_of_type_AndroidViewView.setBackgroundColor(parampne.a().a().getResources().getColor(2131166914));
      }
      a(paramsxf, paramBaseArticleInfo, parampne);
      b(paramsxf, paramBaseArticleInfo, parampne);
      return;
      paramsxf.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      paramsxf.jdField_e_of_type_AndroidWidgetTextView.setText(six.c(paramBaseArticleInfo.mVideoPlayCount) + anvx.a(2131712539));
    }
  }
  
  /* Error */
  public static void a(sxg paramsxg, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1018	sxg:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   4: aconst_null
    //   5: invokevirtual 1019	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 1020	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   13: aload_0
    //   14: aload_1
    //   15: getfield 1024	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubArtilceList	Ljava/util/List;
    //   18: iconst_0
    //   19: invokeinterface 1030 2 0
    //   24: checkcast 18	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo
    //   27: putfield 1032	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   30: aload_0
    //   31: getfield 1033	sxg:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   34: aload_2
    //   35: invokevirtual 661	pne:a	()Lpnh;
    //   38: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   41: invokevirtual 300	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   44: ldc_w 666
    //   47: invokevirtual 672	android/content/res/Resources:getColor	(I)I
    //   50: invokevirtual 730	android/view/View:setBackgroundColor	(I)V
    //   53: aload_0
    //   54: getfield 1034	sxg:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   57: aload_0
    //   58: getfield 1035	sxg:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   61: aload_2
    //   62: invokevirtual 661	pne:a	()Lpnh;
    //   65: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   68: invokestatic 1037	prt:a	(Landroid/view/View;Landroid/view/View;Landroid/content/Context;)V
    //   71: aload_0
    //   72: getfield 1020	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   75: astore 8
    //   77: aload 8
    //   79: aload_0
    //   80: getfield 1038	sxg:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   83: aload_0
    //   84: getfield 1039	sxg:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   87: aload_0
    //   88: getfield 1040	sxg:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   91: aload_0
    //   92: getfield 1041	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   95: aload_0
    //   96: getfield 1018	sxg:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   99: aload_2
    //   100: invokevirtual 661	pne:a	()Lpnh;
    //   103: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   106: invokestatic 1043	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/view/View;Landroid/content/Context;)V
    //   109: aload_0
    //   110: getfield 1046	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   113: invokestatic 1048	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   116: aload_0
    //   117: getfield 1038	sxg:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   120: aload 8
    //   122: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   125: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   128: aload_0
    //   129: getfield 1038	sxg:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   132: invokevirtual 650	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   135: iconst_1
    //   136: invokevirtual 656	android/text/TextPaint:setFakeBoldText	(Z)V
    //   139: aload_0
    //   140: getfield 1049	sxg:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   143: aload 8
    //   145: getfield 1002	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   148: invokestatic 1013	six:c	(I)Ljava/lang/String;
    //   151: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: aload_0
    //   155: getfield 1050	sxg:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   158: aload_0
    //   159: getfield 1051	sxg:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   162: aload 8
    //   164: iconst_0
    //   165: aload_2
    //   166: invokevirtual 661	pne:a	()Lpnh;
    //   169: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   172: invokestatic 1053	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;ZLandroid/content/Context;)V
    //   175: aload_0
    //   176: getfield 1050	sxg:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   179: aload_0
    //   180: invokevirtual 1005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 1050	sxg:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   187: aload_3
    //   188: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   191: aload_0
    //   192: getfield 1050	sxg:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   195: ldc_w 1055
    //   198: invokestatic 1061	com/tencent/qqlive/module/videoreport/VideoReport:setElementId	(Ljava/lang/Object;Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield 1050	sxg:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   205: astore 9
    //   207: new 1063	pti
    //   210: dup
    //   211: invokespecial 1064	pti:<init>	()V
    //   214: aload_2
    //   215: invokevirtual 661	pne:a	()Lpnh;
    //   218: invokevirtual 719	pnh:b	()I
    //   221: invokestatic 1069	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: invokevirtual 1072	pti:a	(Ljava/lang/Number;)Lpti;
    //   227: astore 10
    //   229: aload 8
    //   231: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   234: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifeq +687 -> 924
    //   240: ldc_w 1074
    //   243: astore_1
    //   244: aload 9
    //   246: aload 10
    //   248: aload_1
    //   249: invokevirtual 1077	pti:e	(Ljava/lang/String;)Lpti;
    //   252: invokevirtual 1080	pti:a	()Ljava/util/Map;
    //   255: invokestatic 1084	com/tencent/qqlive/module/videoreport/VideoReport:setElementParams	(Ljava/lang/Object;Ljava/util/Map;)V
    //   258: aload_0
    //   259: getfield 1050	sxg:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   262: aload 8
    //   264: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   267: invokestatic 1087	com/tencent/qqlive/module/videoreport/VideoReport:setElementReuseIdentifier	(Ljava/lang/Object;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 1041	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   274: aload 8
    //   276: invokevirtual 1005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   279: aload 8
    //   281: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   284: aload 8
    //   286: getfield 1093	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   289: aload_0
    //   290: getfield 1094	sxg:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   293: invokestatic 1097	six:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   296: aload 8
    //   298: getfield 1100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isAccountShown	Z
    //   301: ifeq +653 -> 954
    //   304: aload_2
    //   305: invokevirtual 661	pne:a	()Lpnh;
    //   308: invokevirtual 719	pnh:b	()I
    //   311: ifne +643 -> 954
    //   314: aload 8
    //   316: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   319: ifnull +635 -> 954
    //   322: aload_0
    //   323: getfield 1106	sxg:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   326: iconst_0
    //   327: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   330: aload_0
    //   331: getfield 1106	sxg:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   334: aload 8
    //   336: invokevirtual 1107	android/view/View:setTag	(Ljava/lang/Object;)V
    //   339: aload_0
    //   340: getfield 1106	sxg:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   343: ldc_w 1108
    //   346: aload_0
    //   347: invokevirtual 1111	android/view/View:setTag	(ILjava/lang/Object;)V
    //   350: lconst_0
    //   351: lstore 4
    //   353: aload 8
    //   355: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   358: getfield 1117	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   361: invokevirtual 1122	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   364: ifeq +16 -> 380
    //   367: aload 8
    //   369: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   372: getfield 1117	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   375: invokevirtual 1125	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   378: lstore 4
    //   380: aload_0
    //   381: getfield 1128	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   384: lload 4
    //   386: invokevirtual 1131	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setHeadImgByUin	(J)V
    //   389: aload_0
    //   390: getfield 1128	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   393: aload 8
    //   395: invokevirtual 1132	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(Ljava/lang/Object;)V
    //   398: aload_0
    //   399: getfield 1128	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   402: ldc_w 1108
    //   405: aload_0
    //   406: invokevirtual 1133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(ILjava/lang/Object;)V
    //   409: aload_0
    //   410: getfield 1128	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   413: bipush 10
    //   415: bipush 10
    //   417: bipush 10
    //   419: bipush 10
    //   421: invokestatic 1135	prt:a	(Landroid/view/View;IIII)V
    //   424: aload 8
    //   426: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   429: getfield 1139	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:bytes_v_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   432: invokestatic 1144	qxl:b	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_1
    //   437: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne +21 -> 461
    //   443: new 223	java/net/URL
    //   446: dup
    //   447: aload_1
    //   448: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   451: astore_1
    //   452: aload_0
    //   453: getfield 1146	sxg:jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   456: aload_1
    //   457: invokevirtual 619	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   460: pop
    //   461: aload_0
    //   462: getfield 1149	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   465: lload 4
    //   467: invokevirtual 1151	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setNickNameByUin	(J)V
    //   470: aload_0
    //   471: getfield 1106	sxg:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   474: aload_3
    //   475: invokevirtual 1019	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   478: aload_0
    //   479: getfield 1128	sxg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   482: aload_3
    //   483: invokevirtual 1152	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   486: aload_0
    //   487: getfield 1032	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   490: astore 8
    //   492: aload 8
    //   494: iconst_1
    //   495: putfield 1155	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   498: aload 8
    //   500: aload_0
    //   501: getfield 1156	sxg:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   504: aload_0
    //   505: getfield 1157	sxg:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   508: aload_0
    //   509: getfield 1158	sxg:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   512: aload_0
    //   513: getfield 1159	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   516: aload_0
    //   517: getfield 1018	sxg:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   520: aload_2
    //   521: invokevirtual 661	pne:a	()Lpnh;
    //   524: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   527: invokestatic 1043	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/view/View;Landroid/content/Context;)V
    //   530: aload_0
    //   531: getfield 1161	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   534: invokestatic 1048	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   537: aload_0
    //   538: getfield 1156	sxg:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   541: aload 8
    //   543: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   546: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   549: aload_0
    //   550: getfield 1156	sxg:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   553: invokevirtual 650	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   556: iconst_1
    //   557: invokevirtual 656	android/text/TextPaint:setFakeBoldText	(Z)V
    //   560: aload_0
    //   561: getfield 1162	sxg:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   564: aload 8
    //   566: getfield 1002	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   569: invokestatic 1013	six:c	(I)Ljava/lang/String;
    //   572: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   575: aload_0
    //   576: getfield 1164	sxg:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   579: aload_0
    //   580: getfield 1165	sxg:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   583: aload 8
    //   585: iconst_0
    //   586: aload_2
    //   587: invokevirtual 661	pne:a	()Lpnh;
    //   590: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   593: invokestatic 1053	prt:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;ZLandroid/content/Context;)V
    //   596: aload_0
    //   597: getfield 1164	sxg:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   600: aload_0
    //   601: invokevirtual 1005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   604: aload_0
    //   605: getfield 1164	sxg:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   608: aload_3
    //   609: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   612: aload_0
    //   613: getfield 1164	sxg:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   616: ldc_w 1055
    //   619: invokestatic 1061	com/tencent/qqlive/module/videoreport/VideoReport:setElementId	(Ljava/lang/Object;Ljava/lang/String;)V
    //   622: aload_0
    //   623: getfield 1164	sxg:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   626: astore 9
    //   628: new 1063	pti
    //   631: dup
    //   632: invokespecial 1064	pti:<init>	()V
    //   635: aload_2
    //   636: invokevirtual 661	pne:a	()Lpnh;
    //   639: invokevirtual 719	pnh:b	()I
    //   642: invokestatic 1069	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokevirtual 1072	pti:a	(Ljava/lang/Number;)Lpti;
    //   648: astore 10
    //   650: aload 8
    //   652: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   655: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifeq +308 -> 966
    //   661: ldc_w 1074
    //   664: astore_1
    //   665: aload 9
    //   667: aload 10
    //   669: aload_1
    //   670: invokevirtual 1077	pti:e	(Ljava/lang/String;)Lpti;
    //   673: invokevirtual 1080	pti:a	()Ljava/util/Map;
    //   676: invokestatic 1084	com/tencent/qqlive/module/videoreport/VideoReport:setElementParams	(Ljava/lang/Object;Ljava/util/Map;)V
    //   679: aload_0
    //   680: getfield 1164	sxg:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   683: aload 8
    //   685: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   688: invokestatic 1087	com/tencent/qqlive/module/videoreport/VideoReport:setElementReuseIdentifier	(Ljava/lang/Object;Ljava/lang/String;)V
    //   691: aload_0
    //   692: getfield 1159	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   695: aload 8
    //   697: invokevirtual 1005	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   700: aload 8
    //   702: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   705: aload 8
    //   707: getfield 1093	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   710: aload_0
    //   711: getfield 1166	sxg:h	Landroid/widget/TextView;
    //   714: invokestatic 1097	six:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   717: aload 8
    //   719: getfield 1100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isAccountShown	Z
    //   722: ifeq +274 -> 996
    //   725: aload_2
    //   726: invokevirtual 661	pne:a	()Lpnh;
    //   729: invokevirtual 719	pnh:b	()I
    //   732: ifne +264 -> 996
    //   735: aload 8
    //   737: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   740: ifnull +256 -> 996
    //   743: aload_0
    //   744: getfield 1168	sxg:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   747: iconst_0
    //   748: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   751: aload_0
    //   752: getfield 1168	sxg:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   755: aload 8
    //   757: invokevirtual 1107	android/view/View:setTag	(Ljava/lang/Object;)V
    //   760: aload_0
    //   761: getfield 1168	sxg:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   764: ldc_w 1108
    //   767: aload_0
    //   768: invokevirtual 1111	android/view/View:setTag	(ILjava/lang/Object;)V
    //   771: lconst_0
    //   772: lstore 6
    //   774: lload 6
    //   776: lstore 4
    //   778: aload 8
    //   780: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   783: ifnull +34 -> 817
    //   786: lload 6
    //   788: lstore 4
    //   790: aload 8
    //   792: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   795: getfield 1117	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   798: invokevirtual 1122	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   801: ifeq +16 -> 817
    //   804: aload 8
    //   806: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   809: getfield 1117	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   812: invokevirtual 1125	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   815: lstore 4
    //   817: aload_0
    //   818: getfield 1170	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   821: lload 4
    //   823: invokevirtual 1131	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setHeadImgByUin	(J)V
    //   826: aload_0
    //   827: getfield 1170	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   830: aload 8
    //   832: invokevirtual 1132	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(Ljava/lang/Object;)V
    //   835: aload_0
    //   836: getfield 1170	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   839: ldc_w 1108
    //   842: aload_0
    //   843: invokevirtual 1133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(ILjava/lang/Object;)V
    //   846: aload_0
    //   847: getfield 1170	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   850: bipush 10
    //   852: bipush 10
    //   854: bipush 10
    //   856: bipush 10
    //   858: invokestatic 1135	prt:a	(Landroid/view/View;IIII)V
    //   861: aload 8
    //   863: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   866: getfield 1139	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:bytes_v_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   869: invokestatic 1144	qxl:b	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   872: astore_1
    //   873: aload_1
    //   874: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   877: ifne +21 -> 898
    //   880: new 223	java/net/URL
    //   883: dup
    //   884: aload_1
    //   885: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   888: astore_1
    //   889: aload_0
    //   890: getfield 1172	sxg:jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   893: aload_1
    //   894: invokevirtual 619	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   897: pop
    //   898: aload_0
    //   899: getfield 1174	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   902: lload 4
    //   904: invokevirtual 1151	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setNickNameByUin	(J)V
    //   907: aload_0
    //   908: getfield 1168	sxg:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   911: aload_3
    //   912: invokevirtual 1019	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   915: aload_0
    //   916: getfield 1170	sxg:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   919: aload_3
    //   920: invokevirtual 1152	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   923: return
    //   924: aload 8
    //   926: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   929: astore_1
    //   930: goto -686 -> 244
    //   933: astore_1
    //   934: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   937: ifeq -476 -> 461
    //   940: ldc_w 353
    //   943: iconst_2
    //   944: ldc_w 1176
    //   947: aload_1
    //   948: invokestatic 987	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   951: goto -490 -> 461
    //   954: aload_0
    //   955: getfield 1106	sxg:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   958: bipush 8
    //   960: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   963: goto -477 -> 486
    //   966: aload 8
    //   968: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   971: astore_1
    //   972: goto -307 -> 665
    //   975: astore_1
    //   976: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq -81 -> 898
    //   982: ldc_w 353
    //   985: iconst_2
    //   986: ldc_w 1178
    //   989: aload_1
    //   990: invokestatic 987	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   993: goto -95 -> 898
    //   996: aload_0
    //   997: getfield 1168	sxg:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1000: bipush 8
    //   1002: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   1005: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	paramsxg	sxg
    //   0	1006	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1006	2	parampne	pne
    //   0	1006	3	paramOnClickListener	View.OnClickListener
    //   351	552	4	l1	long
    //   772	15	6	l2	long
    //   75	892	8	localBaseArticleInfo	BaseArticleInfo
    //   205	461	9	localKandianUrlImageView	KandianUrlImageView
    //   227	441	10	localpti	pti
    // Exception table:
    //   from	to	target	type
    //   443	461	933	java/lang/Exception
    //   880	898	975	java/lang/Exception
  }
  
  public static void a(sxh paramsxh, BaseArticleInfo paramBaseArticleInfo)
  {
    spk localspk = a(paramBaseArticleInfo);
    localspk.jdField_a_of_type_AndroidViewView = paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localspk.jdField_a_of_type_Int = paramsxh.jdField_a_of_type_Int;
    localspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramsxh.jdField_a_of_type_Spk = localspk;
  }
  
  private static void a(sxh paramsxh, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    if (NetworkUtil.isWifiConnected(parampne.a().a()))
    {
      paramsxh.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramsxh.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      paramsxh.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramsxh.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    }
    do
    {
      return;
      paramsxh.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      Object localObject = parampne.a().a().getResources().getDrawable(2130843226);
      paramsxh.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      paramsxh.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, parampne.a().a().getResources()));
      paramsxh.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (bhyk.a() == 1)
      {
        paramsxh.jdField_f_of_type_AndroidWidgetTextView.setText(anvx.a(2131712307));
        paramsxh.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        paramsxh.jdField_e_of_type_AndroidViewView.setVisibility(0);
        paramsxh.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
        return;
      }
      if ((!bmhv.z()) || (parampne.a().e()) || (paramsxh.jdField_a_of_type_Int != 0)) {
        break;
      }
      String str1 = bmhv.e();
      String str2 = bmhv.f();
      String str3 = bmhv.g();
      if (!TextUtils.isEmpty(str1))
      {
        QQAppInterface localQQAppInterface = pnn.a();
        localObject = "";
        if (localQQAppInterface != null) {
          localObject = localQQAppInterface.getCurrentAccountUin();
        }
        paramBaseArticleInfo = new suu(null, null, null, null).m((String)localObject).i(paramBaseArticleInfo.innerUniqueID).a().a();
        paramsxh.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        paramsxh.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, parampne.a().a().getResources()));
        localObject = parampne.a().a().getResources().getDrawable(2130843026);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(10.0F, parampne.a().a().getResources()), AIOUtils.dp2px(10.0F, parampne.a().a().getResources()));
        paramsxh.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        six.b(parampne.a().a(), paramsxh.jdField_g_of_type_AndroidWidgetTextView, str2, str3, str1, new pru(paramBaseArticleInfo, paramsxh));
        paramsxh.jdField_d_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramsxh.jdField_e_of_type_AndroidViewView.setVisibility(0);
        parampne.a().c(true);
        olh.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramBaseArticleInfo, false);
        return;
      }
      paramsxh.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramsxh.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramsxh.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
    return;
    paramsxh.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    paramsxh.jdField_e_of_type_AndroidViewView.setVisibility(0);
    paramsxh.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
  }
  
  /* Error */
  private static void a(sxh paramsxh, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: checkcast 486	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   13: iconst_0
    //   14: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   17: invokestatic 198	pqt:j	()Z
    //   20: ifeq +264 -> 284
    //   23: aload_0
    //   24: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   27: aconst_null
    //   28: invokestatic 1204	pic:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   31: aload_0
    //   32: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   35: ldc_w 1206
    //   38: invokestatic 629	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   41: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   44: aload_0
    //   45: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   48: ldc_w 1209
    //   51: invokestatic 629	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   54: invokevirtual 632	android/widget/TextView:setTextColor	(I)V
    //   57: aload_1
    //   58: getfield 843	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   61: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +246 -> 310
    //   67: aload_0
    //   68: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   71: aload_1
    //   72: getfield 843	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   75: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   78: aload_0
    //   79: getfield 1212	sxh:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   82: iconst_0
    //   83: invokevirtual 1215	android/widget/LinearLayout:setVisibility	(I)V
    //   86: aload_1
    //   87: invokestatic 517	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   90: ifeq +290 -> 380
    //   93: new 519	org/json/JSONObject
    //   96: dup
    //   97: aload 5
    //   99: getfield 522	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   102: invokespecial 523	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_2
    //   107: invokevirtual 661	pne:a	()Lpnh;
    //   110: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   113: aload_1
    //   114: ldc_w 1217
    //   117: invokevirtual 1220	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokestatic 1225	bhfn:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   123: ifeq +210 -> 333
    //   126: aload_0
    //   127: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   130: aload_2
    //   131: invokevirtual 661	pne:a	()Lpnh;
    //   134: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   137: ldc_w 1226
    //   140: invokevirtual 1228	android/content/Context:getString	(I)Ljava/lang/String;
    //   143: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   146: iconst_1
    //   147: istore 4
    //   149: aload 5
    //   151: getfield 1231	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   154: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +20 -> 177
    //   160: iload 4
    //   162: ifne +15 -> 177
    //   165: aload_0
    //   166: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   169: aload 5
    //   171: getfield 1231	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   174: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   177: new 519	org/json/JSONObject
    //   180: dup
    //   181: aload 5
    //   183: getfield 1234	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   186: invokespecial 523	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   189: astore_1
    //   190: aload_1
    //   191: ldc_w 1236
    //   194: invokevirtual 1220	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +17 -> 217
    //   203: aload_0
    //   204: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   207: aload_1
    //   208: ldc_w 1236
    //   211: invokevirtual 1220	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   217: aload_0
    //   218: getfield 1238	sxh:jdField_e_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   221: aload_3
    //   222: invokevirtual 692	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   225: aload_0
    //   226: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   229: aload_3
    //   230: invokevirtual 1239	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   233: aload_0
    //   234: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   237: aload_3
    //   238: invokevirtual 1239	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   241: aload_0
    //   242: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   245: aload_0
    //   246: invokevirtual 975	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   249: aload_0
    //   250: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   253: aload_0
    //   254: invokevirtual 975	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   257: aload_0
    //   258: getfield 1238	sxh:jdField_e_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   261: aload_0
    //   262: invokevirtual 691	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   265: aload_0
    //   266: getfield 1242	sxh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   269: bipush 8
    //   271: invokevirtual 1245	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   274: aload_0
    //   275: getfield 1247	sxh:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   278: bipush 8
    //   280: invokevirtual 1215	android/widget/LinearLayout:setVisibility	(I)V
    //   283: return
    //   284: aload_0
    //   285: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   288: ldc_w 1249
    //   291: invokestatic 629	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   294: aload_2
    //   295: invokevirtual 661	pne:a	()Lpnh;
    //   298: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   301: invokestatic 1252	uks:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   304: invokestatic 1204	pic:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   307: goto -250 -> 57
    //   310: aload_0
    //   311: getfield 1199	sxh:h	Landroid/widget/TextView;
    //   314: aload_2
    //   315: invokevirtual 661	pne:a	()Lpnh;
    //   318: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   321: ldc_w 1253
    //   324: invokevirtual 1228	android/content/Context:getString	(I)Ljava/lang/String;
    //   327: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   330: goto -252 -> 78
    //   333: aload_0
    //   334: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   337: aload_2
    //   338: invokevirtual 661	pne:a	()Lpnh;
    //   341: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   344: ldc_w 1254
    //   347: invokevirtual 1228	android/content/Context:getString	(I)Ljava/lang/String;
    //   350: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   353: goto -204 -> 149
    //   356: astore_1
    //   357: aload_0
    //   358: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   361: aload_2
    //   362: invokevirtual 661	pne:a	()Lpnh;
    //   365: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   368: ldc_w 1255
    //   371: invokevirtual 1228	android/content/Context:getString	(I)Ljava/lang/String;
    //   374: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   377: goto -228 -> 149
    //   380: aload 5
    //   382: getfield 1231	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   385: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifne +18 -> 406
    //   391: aload_0
    //   392: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   395: aload 5
    //   397: getfield 1231	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   400: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   403: goto -226 -> 177
    //   406: aload_0
    //   407: getfield 1207	sxh:i	Landroid/widget/TextView;
    //   410: aload_2
    //   411: invokevirtual 661	pne:a	()Lpnh;
    //   414: invokevirtual 665	pnh:a	()Landroid/content/Context;
    //   417: ldc_w 1255
    //   420: invokevirtual 1228	android/content/Context:getString	(I)Ljava/lang/String;
    //   423: invokevirtual 611	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   426: goto -249 -> 177
    //   429: astore_1
    //   430: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -216 -> 217
    //   436: ldc_w 353
    //   439: iconst_2
    //   440: ldc_w 1257
    //   443: aload_1
    //   444: invokestatic 987	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: goto -230 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	paramsxh	sxh
    //   0	450	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	450	2	parampne	pne
    //   0	450	3	paramOnClickListener	View.OnClickListener
    //   1	160	4	i	int
    //   7	389	5	localAdvertisementInfo	AdvertisementInfo
    // Exception table:
    //   from	to	target	type
    //   93	146	356	org/json/JSONException
    //   333	353	356	org/json/JSONException
    //   177	217	429	org/json/JSONException
  }
  
  public static void a(sxh paramsxh, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, Set<Long> paramSet)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    a(paramsxh, paramBaseArticleInfo);
    spk localspk = paramsxh.jdField_a_of_type_Spk;
    paramsxh.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    paramsxh.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramsxh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(parampne.a().a().getResources().getColor(2131167363));
    if (paramBaseArticleInfo.mVideoPlayCount == 0)
    {
      paramsxh.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramsxh.jdField_b_of_type_AndroidWidgetTextView.setText(pjr.a(localspk.jdField_b_of_type_Int, true));
      a(paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramBaseArticleInfo, AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo));
      a(paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramBaseArticleInfo);
      paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramBaseArticleInfo.getSubscribeName());
      paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramBaseArticleInfo.getSubscribeName());
      paramsxh.jdField_a_of_type_AndroidViewViewGroup.setTag(paramBaseArticleInfo);
      paramsxh.jdField_a_of_type_AndroidViewViewGroup.setTag(2131376239, paramsxh);
      paramsxh.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramOnClickListener);
      if (TextUtils.isEmpty(paramBaseArticleInfo.vIconUrl)) {
        break label702;
      }
    }
    for (;;)
    {
      try
      {
        URL localURL = new URL(paramBaseArticleInfo.vIconUrl);
        paramsxh.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(localURL);
        paramsxh.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label714;
        }
        a(paramsxh, paramBaseArticleInfo, parampne, paramOnClickListener);
        qdc.a(parampne.a().a(), paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramsxh.jdField_a_of_type_Spk);
        a(paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, parampne.a().a());
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramsxh);
        paramsxh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramsxh.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pjr.a(localspk.jdField_c_of_type_Int, localspk.jdField_d_of_type_Int));
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(paramOnClickListener);
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(paramsxh);
        if (parampne.a().a().b(parampne.a().b(), paramBaseArticleInfo.mArticleID)) {
          paramsxh.jdField_g_of_type_AndroidViewView.setBackgroundColor(parampne.a().a().getResources().getColor(2131166914));
        }
        pki.a(parampne.a().a(), paramsxh.jdField_b_of_type_AndroidViewViewGroup, paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
        if (!pqt.j()) {
          break label816;
        }
        paramsxh.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.dip2px(parampne.a().a(), 5.0F));
        paramOnLongClickListener = parampne.a().a().getResources().getDrawable(2130843131);
        int i = DisplayUtil.dip2px(parampne.a().a(), 17.0F);
        paramOnLongClickListener.setBounds(0, 0, i, i);
        paramsxh.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnLongClickListener, null, null, null);
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setOnClickListener(paramOnClickListener);
        paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setTag(paramsxh);
        six.a(paramsxh.jdField_c_of_type_AndroidWidgetTextView, paramBaseArticleInfo.getCommentCount(), anvx.a(2131712372));
        paramsxh.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
        paramsxh.jdField_c_of_type_AndroidWidgetTextView.setTag(paramsxh);
        paramsxh.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
        paramsxh.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramsxh);
        if (paramBaseArticleInfo.mXGFileSize > 0L) {
          break label867;
        }
        paramsxh.jdField_f_of_type_AndroidWidgetTextView.setText(anvx.a(2131712198));
        if ((AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) && (((AdvertisementInfo)paramBaseArticleInfo).mAdVideoFileSize >= 0L)) {
          paramsxh.jdField_f_of_type_AndroidWidgetTextView.setText(six.b(((AdvertisementInfo)paramBaseArticleInfo).mAdVideoFileSize) + anvx.a(2131712464));
        }
        a(paramsxh, paramBaseArticleInfo, parampne);
        a(paramsxh, parampne, paramOnClickListener);
        return;
        paramsxh.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        paramsxh.jdField_e_of_type_AndroidWidgetTextView.setText(six.c(paramBaseArticleInfo.mVideoPlayCount) + anvx.a(2131712374));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label702:
      paramsxh.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      continue;
      label714:
      paramsxh.h.setVisibility(8);
      paramsxh.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setVisibility(0);
      paramsxh.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramBaseArticleInfo, parampne.a().a(), parampne.a().b(), paramSet);
      paramsxh.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramsxh.jdField_a_of_type_AndroidWidgetImageView.setTag(paramsxh);
      paramsxh.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramsxh.jdField_b_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
      paramsxh.jdField_b_of_type_AndroidWidgetImageView.setTag(paramsxh);
      continue;
      label816:
      paramsxh.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.dip2px(parampne.a().a(), 0.0F));
      paramOnLongClickListener = parampne.a().a().getResources().getDrawable(2130843130);
      paramsxh.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramOnLongClickListener, null, null, null);
      continue;
      label867:
      paramsxh.jdField_f_of_type_AndroidWidgetTextView.setText(six.b(paramBaseArticleInfo.mXGFileSize) + anvx.a(2131712464));
    }
  }
  
  public static void a(sxh paramsxh, pne parampne, View.OnClickListener paramOnClickListener)
  {
    paramsxh.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public static void a(sxn paramsxn, BaseArticleInfo paramBaseArticleInfo, pne parampne, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramsxn.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
    paramsxn.jdField_g_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickListener);
    paramsxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramsxn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramsxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramsxn.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramsxn.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramsxn.jdField_b_of_type_AndroidWidgetTextView.setText(six.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = parampne.a().a().getResources().getDrawable(2130843227);
    int i = ViewUtils.dpToPx(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, i, i);
    paramsxn.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramsxn.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0F));
    six.a(paramsxn.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), anvx.a(2131712195), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramsxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false, parampne.a().a());
    paramsxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramsxn);
    paramsxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramsxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    six.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramsxn.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = paramsxn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramsxn.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramsxn.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramsxn.jdField_f_of_type_AndroidWidgetTextView.setText(six.c(localBaseArticleInfo.mVideoPlayCount));
    paramsxn.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramsxn.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0F));
    six.a(paramsxn.jdField_g_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), anvx.a(2131712184), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramsxn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false, parampne.a().a());
    paramsxn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramsxn);
    paramsxn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramsxn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    six.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramsxn.h);
  }
  
  private static void b(sxf paramsxf, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    if (paramBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramsxf.jdField_g_of_type_AndroidWidgetTextView.setText(anvx.a(2131712462));
      if (!NetworkUtil.isWifiConnected(parampne.a().a())) {
        break label108;
      }
      paramsxf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramsxf.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramsxf.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramsxf.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    }
    label108:
    do
    {
      return;
      paramsxf.jdField_g_of_type_AndroidWidgetTextView.setText(six.b(paramBaseArticleInfo.mXGFileSize) + anvx.a(2131712235));
      break;
      paramsxf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Object localObject = parampne.a().a().getResources().getDrawable(2130843226);
      paramsxf.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      paramsxf.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, parampne.a().a().getResources()));
      paramsxf.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      if (bhyk.a() == 1)
      {
        paramsxf.jdField_g_of_type_AndroidWidgetTextView.setText(anvx.a(2131712458));
        paramsxf.h.setVisibility(8);
        paramsxf.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramsxf.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
        return;
      }
      if ((!bmhv.z()) || (parampne.a().e()) || (paramsxf.jdField_a_of_type_Int != 0)) {
        break label531;
      }
      String str1 = bmhv.e();
      String str2 = bmhv.f();
      String str3 = bmhv.g();
      if (!TextUtils.isEmpty(str1))
      {
        QQAppInterface localQQAppInterface = pnn.a();
        localObject = "";
        if (localQQAppInterface != null) {
          localObject = localQQAppInterface.getCurrentAccountUin();
        }
        paramBaseArticleInfo = new suu(null, null, null, null).m((String)localObject).i(paramBaseArticleInfo.innerUniqueID).a().a();
        paramsxf.h.setVisibility(0);
        paramsxf.h.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, parampne.a().a().getResources()));
        localObject = parampne.a().a().getResources().getDrawable(2130843026);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(10.0F, parampne.a().a().getResources()), AIOUtils.dp2px(10.0F, parampne.a().a().getResources()));
        paramsxf.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
        six.b(parampne.a().a(), paramsxf.h, str2, str3, str1, new prx(paramBaseArticleInfo));
        paramsxf.jdField_a_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramsxf.jdField_b_of_type_AndroidViewView.setVisibility(0);
        parampne.a().c(true);
        olh.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramBaseArticleInfo, false);
        return;
      }
      paramsxf.h.setVisibility(8);
      paramsxf.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramsxf.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
    return;
    label531:
    paramsxf.h.setVisibility(8);
    paramsxf.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramsxf.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prt
 * JD-Core Version:    0.7.0.1
 */