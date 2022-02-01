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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
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
import org.json.JSONException;
import org.json.JSONObject;

public class phe
{
  public static sdg a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static sdg a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    sdg localsdg = new sdg();
    localsdg.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localsdg.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localsdg.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localsdg.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localsdg.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localsdg.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localsdg.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localsdg.jdField_b_of_type_JavaLangString = ((String)localObject);
      localsdg.k = paramBaseArticleInfo.getSubscribeUin();
      localsdg.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localsdg.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new rdt();
      ((rdt)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((rdt)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((rdt)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((rdt)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((rdt)localObject).j = paramBaseArticleInfo.getVideoWidth();
      ((rdt)localObject).k = paramBaseArticleInfo.getVideoHeight();
      ((rdt)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((rdt)localObject).o = 0;
      ((rdt)localObject).p = 0;
      ((rdt)localObject).q = 0;
      ((rdt)localObject).jdField_f_of_type_Boolean = false;
      ((rdt)localObject).g = false;
      ((rdt)localObject).h = false;
      ((rdt)localObject).jdField_f_of_type_JavaLangString = "";
      localsdg.jdField_a_of_type_Rdt = ((rdt)localObject);
      localsdg.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localsdg.e = paramBaseArticleInfo.thirdName;
      localsdg.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localsdg.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localsdg.j = paramBaseArticleInfo.getInnerUniqueID();
      localsdg.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localsdg.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localsdg.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label400;
      }
    }
    label400:
    for (int i = 3;; i = 0)
    {
      localsdg.m = i;
      if (pgb.a((ArticleInfo)paramBaseArticleInfo) == 4) {
        localsdg.jdField_c_of_type_Boolean = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (pay.u()))
      {
        i = DisplayUtil.dip2px(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localsdg.o = i;
        localsdg.p = i;
        localsdg.q = i;
        localsdg.r = i;
      }
      return localsdg;
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
      break;
    }
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
    int i = pej.a(paramContext);
    int j;
    if (paramBoolean)
    {
      j = pej.b(paramContext);
      i /= 2;
    }
    for (;;)
    {
      paramView.setPadding(j, k, i, m);
      return;
      j = i / 2;
      i = pej.b(paramContext);
    }
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2, Context paramContext)
  {
    int i = bkwm.e();
    boolean bool2 = bkwm.q();
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
        paramKandianUrlImageView.setOnClickListener(new phj(paramContext, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString, paramView2));
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
    rwv.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), amtj.a(2131712036), "0");
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
    pai.a(paramKandianUrlImageView, paramURL, paramContext, paramBoolean);
  }
  
  private static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if ((pay.w(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
    {
      paramReadInJoyHeadImageView.setHeadImgByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = bfvo.b();
    localURLDrawableOptions.mFailedDrawable = bfvo.b();
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
        paramReadInJoyHeadImageView.setImageDrawable(bfvo.b());
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
      paramBaseArticleInfo.setDecodeHandler(bfol.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (pay.w(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(twr.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(pai.a(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private static void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (pay.u())
    {
      paramRoundAngleFrameLayout.setRadius(28);
      return;
    }
    paramRoundAngleFrameLayout.setRadius(0);
  }
  
  /* Error */
  public static void a(sju paramsju, BaseArticleInfo paramBaseArticleInfo, ped paramped, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 583	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +144 -> 153
    //   12: aload_1
    //   13: getfield 583	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 588	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   23: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +448 -> 474
    //   29: aload_0
    //   30: getfield 593	sju:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 6
    //   35: getfield 588	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   38: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_0
    //   42: getfield 593	sju:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   49: aload 6
    //   51: getfield 595	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +439 -> 496
    //   60: new 224	java/net/URL
    //   63: dup
    //   64: aload 6
    //   66: getfield 595	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 7
    //   74: aload_0
    //   75: getfield 598	sju:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 7
    //   80: invokevirtual 602	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_0
    //   85: getfield 598	sju:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 6
    //   94: getfield 603	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +426 -> 526
    //   103: aload_0
    //   104: getfield 605	sju:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   107: aload 6
    //   109: getfield 603	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_0
    //   116: getfield 605	sju:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   123: aload 6
    //   125: getfield 606	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:j	Ljava/lang/String;
    //   128: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +22 -> 153
    //   134: aload 6
    //   136: getfield 606	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:j	Ljava/lang/String;
    //   139: invokestatic 612	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: aload_0
    //   145: getfield 605	sju:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   148: iload 5
    //   150: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   153: aload_1
    //   154: invokestatic 617	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lsdg;
    //   157: astore 6
    //   159: aload 6
    //   161: aload_0
    //   162: getfield 619	sju:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   165: putfield 622	sdg:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   168: aload 6
    //   170: aload_0
    //   171: getfield 623	sju:jdField_a_of_type_Int	I
    //   174: putfield 624	sdg:jdField_a_of_type_Int	I
    //   177: aload 6
    //   179: aload_1
    //   180: putfield 179	sdg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   183: aload_0
    //   184: aload 6
    //   186: putfield 627	sju:jdField_a_of_type_Sdg	Lsdg;
    //   189: aload_0
    //   190: getfield 629	sju:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   193: aload_1
    //   194: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   197: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   200: aload_0
    //   201: getfield 629	sju:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   204: invokevirtual 633	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   207: iconst_1
    //   208: invokevirtual 639	android/text/TextPaint:setFakeBoldText	(Z)V
    //   211: aload_0
    //   212: getfield 629	sju:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   215: aload_2
    //   216: invokevirtual 644	ped:a	()Lpeg;
    //   219: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   222: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   225: ldc_w 649
    //   228: invokevirtual 655	android/content/res/Resources:getColor	(I)I
    //   231: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   234: aload_0
    //   235: getfield 657	sju:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   238: bipush 8
    //   240: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   243: aload_0
    //   244: getfield 659	sju:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   247: aload 6
    //   249: getfield 40	sdg:jdField_b_of_type_Int	I
    //   252: iconst_1
    //   253: invokestatic 662	pai:a	(IZ)Ljava/lang/String;
    //   256: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   259: aload_0
    //   260: getfield 665	sju:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   263: bipush 10
    //   265: bipush 10
    //   267: bipush 10
    //   269: bipush 10
    //   271: invokestatic 671	com/tencent/biz/qqstory/utils/UIUtils:expandViewTouchArea	(Landroid/view/View;IIII)V
    //   274: aload_0
    //   275: getfield 665	sju:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   278: aload_0
    //   279: invokevirtual 675	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   282: aload_0
    //   283: getfield 665	sju:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   286: aload_3
    //   287: invokevirtual 676	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   290: aload_2
    //   291: invokevirtual 644	ped:a	()Lpeg;
    //   294: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   297: aload_0
    //   298: getfield 619	sju:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   301: aload_0
    //   302: getfield 627	sju:jdField_a_of_type_Sdg	Lsdg;
    //   305: invokestatic 681	psf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lsdg;)V
    //   308: aload_0
    //   309: getfield 619	sju:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   312: aload_1
    //   313: iconst_0
    //   314: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   317: iconst_0
    //   318: aload_2
    //   319: invokevirtual 644	ped:a	()Lpeg;
    //   322: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   325: invokestatic 411	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   328: aload_0
    //   329: getfield 619	sju:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   332: aload 4
    //   334: invokevirtual 685	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   337: aload_0
    //   338: getfield 688	sju:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   341: fconst_1
    //   342: aload 6
    //   344: getfield 45	sdg:jdField_c_of_type_Int	I
    //   347: aload 6
    //   349: getfield 51	sdg:jdField_d_of_type_Int	I
    //   352: invokestatic 691	pai:a	(II)F
    //   355: invokevirtual 697	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   358: aload_0
    //   359: getfield 688	sju:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   362: aload_0
    //   363: invokevirtual 698	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   366: aload_2
    //   367: invokevirtual 644	ped:a	()Lpeg;
    //   370: invokevirtual 701	peg:a	()Lslt;
    //   373: aload_2
    //   374: invokevirtual 644	ped:a	()Lpeg;
    //   377: invokevirtual 703	peg:b	()I
    //   380: aload_1
    //   381: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   384: invokevirtual 708	slt:b	(IJ)Z
    //   387: ifeq +26 -> 413
    //   390: aload_0
    //   391: getfield 710	sju:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   394: aload_2
    //   395: invokevirtual 644	ped:a	()Lpeg;
    //   398: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   401: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   404: ldc_w 711
    //   407: invokevirtual 655	android/content/res/Resources:getColor	(I)I
    //   410: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   413: aload_1
    //   414: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   417: lconst_0
    //   418: lcmp
    //   419: ifgt +119 -> 538
    //   422: aload_0
    //   423: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   426: ldc_w 717
    //   429: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   432: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   435: aload_2
    //   436: invokevirtual 644	ped:a	()Lpeg;
    //   439: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   442: invokestatic 372	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   445: ifeq +132 -> 577
    //   448: aload_0
    //   449: getfield 719	sju:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   452: iconst_0
    //   453: invokevirtual 378	android/widget/ImageView:setVisibility	(I)V
    //   456: aload_0
    //   457: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   460: bipush 8
    //   462: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   465: aload_0
    //   466: getfield 721	sju:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   469: iconst_0
    //   470: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   473: return
    //   474: aload_0
    //   475: getfield 593	sju:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   478: bipush 8
    //   480: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   483: goto -434 -> 49
    //   486: astore 7
    //   488: aload 7
    //   490: invokevirtual 724	java/lang/Exception:printStackTrace	()V
    //   493: goto -401 -> 92
    //   496: aload_0
    //   497: getfield 598	sju:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   500: bipush 8
    //   502: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   505: goto -413 -> 92
    //   508: astore 6
    //   510: aload_0
    //   511: getfield 605	sju:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   514: ldc_w 726
    //   517: invokestatic 612	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   520: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   523: goto -370 -> 153
    //   526: aload_0
    //   527: getfield 605	sju:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   530: bipush 8
    //   532: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   535: goto -382 -> 153
    //   538: aload_0
    //   539: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   542: new 414	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   549: aload_1
    //   550: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   553: invokestatic 729	rwv:b	(J)Ljava/lang/String;
    //   556: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: ldc_w 730
    //   562: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   565: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   574: goto -139 -> 435
    //   577: aload_0
    //   578: getfield 719	sju:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   581: bipush 8
    //   583: invokevirtual 378	android/widget/ImageView:setVisibility	(I)V
    //   586: aload_2
    //   587: invokevirtual 644	ped:a	()Lpeg;
    //   590: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   593: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   596: ldc_w 731
    //   599: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   602: astore_3
    //   603: aload_0
    //   604: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   607: aload_3
    //   608: aconst_null
    //   609: aconst_null
    //   610: aconst_null
    //   611: invokevirtual 738	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   614: aload_0
    //   615: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   618: ldc_w 739
    //   621: aload_2
    //   622: invokevirtual 644	ped:a	()Lpeg;
    //   625: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   628: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   631: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   634: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   637: aload_0
    //   638: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   641: iconst_0
    //   642: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   645: invokestatic 746	bgoa:a	()I
    //   648: iconst_1
    //   649: if_icmpne +34 -> 683
    //   652: aload_0
    //   653: getfield 716	sju:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   656: ldc_w 747
    //   659: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   662: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   665: aload_0
    //   666: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   669: bipush 8
    //   671: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   674: aload_0
    //   675: getfield 721	sju:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   678: iconst_0
    //   679: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   682: return
    //   683: invokestatic 751	bkwm:w	()Z
    //   686: ifeq +291 -> 977
    //   689: aload_2
    //   690: invokevirtual 644	ped:a	()Lpeg;
    //   693: invokevirtual 753	peg:e	()Z
    //   696: ifne +281 -> 977
    //   699: aload_0
    //   700: getfield 623	sju:jdField_a_of_type_Int	I
    //   703: ifne +274 -> 977
    //   706: invokestatic 755	bkwm:e	()Ljava/lang/String;
    //   709: astore 4
    //   711: invokestatic 757	bkwm:f	()Ljava/lang/String;
    //   714: astore 6
    //   716: invokestatic 759	bkwm:g	()Ljava/lang/String;
    //   719: astore 7
    //   721: aload 4
    //   723: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   726: ifne +217 -> 943
    //   729: invokestatic 762	pay:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   732: astore 8
    //   734: ldc 134
    //   736: astore_3
    //   737: aload 8
    //   739: ifnull +9 -> 748
    //   742: aload 8
    //   744: invokevirtual 767	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   747: astore_3
    //   748: new 769	sie
    //   751: dup
    //   752: aconst_null
    //   753: aconst_null
    //   754: aconst_null
    //   755: aconst_null
    //   756: invokespecial 772	sie:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload_3
    //   760: invokevirtual 775	sie:m	(Ljava/lang/String;)Lsie;
    //   763: aload_1
    //   764: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   767: invokevirtual 777	sie:i	(Ljava/lang/String;)Lsie;
    //   770: invokevirtual 780	sie:a	()Lsid;
    //   773: invokevirtual 784	sid:a	()Ljava/lang/String;
    //   776: astore_1
    //   777: aload_0
    //   778: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   781: iconst_0
    //   782: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   785: aload_0
    //   786: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   789: fconst_2
    //   790: aload_2
    //   791: invokevirtual 644	ped:a	()Lpeg;
    //   794: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   797: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   800: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   803: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   806: aload_2
    //   807: invokevirtual 644	ped:a	()Lpeg;
    //   810: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   813: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   816: ldc_w 785
    //   819: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   822: astore_3
    //   823: aload_3
    //   824: iconst_0
    //   825: iconst_0
    //   826: ldc_w 786
    //   829: aload_2
    //   830: invokevirtual 644	ped:a	()Lpeg;
    //   833: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   836: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   839: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   842: ldc_w 786
    //   845: aload_2
    //   846: invokevirtual 644	ped:a	()Lpeg;
    //   849: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   852: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   855: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   858: invokevirtual 791	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   861: aload_0
    //   862: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   865: aconst_null
    //   866: aconst_null
    //   867: aload_3
    //   868: aconst_null
    //   869: invokevirtual 794	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   872: aload_2
    //   873: invokevirtual 644	ped:a	()Lpeg;
    //   876: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   879: aload_0
    //   880: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   883: aload 6
    //   885: aload 7
    //   887: aload 4
    //   889: new 796	phh
    //   892: dup
    //   893: aload_1
    //   894: aload_0
    //   895: invokespecial 799	phh:<init>	(Ljava/lang/String;Lsju;)V
    //   898: invokestatic 802	rwv:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   901: aload_0
    //   902: getfield 721	sju:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   905: ldc_w 803
    //   908: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   911: aload_2
    //   912: invokevirtual 644	ped:a	()Lpeg;
    //   915: iconst_1
    //   916: invokevirtual 806	peg:c	(Z)Lpeg;
    //   919: pop
    //   920: aconst_null
    //   921: ldc 134
    //   923: ldc_w 808
    //   926: ldc_w 808
    //   929: iconst_0
    //   930: iconst_0
    //   931: ldc 134
    //   933: ldc 134
    //   935: ldc 134
    //   937: aload_1
    //   938: iconst_0
    //   939: invokestatic 813	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   942: return
    //   943: aload_0
    //   944: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   947: bipush 8
    //   949: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   952: aload_0
    //   953: getfield 721	sju:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   956: iconst_0
    //   957: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   960: invokestatic 523	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   963: ifeq -959 -> 4
    //   966: ldc_w 815
    //   969: iconst_2
    //   970: ldc_w 817
    //   973: invokestatic 819	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: return
    //   977: aload_0
    //   978: getfield 749	sju:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   981: bipush 8
    //   983: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   986: aload_0
    //   987: getfield 721	sju:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   990: iconst_0
    //   991: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   994: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	paramsju	sju
    //   0	995	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	995	2	paramped	ped
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
  public static void a(sjv paramsjv, BaseArticleInfo paramBaseArticleInfo, ped paramped, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +542 -> 554
    //   15: aload_0
    //   16: getfield 827	sjv:i	Landroid/widget/TextView;
    //   19: aload_1
    //   20: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_1
    //   27: getfield 830	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +512 -> 545
    //   36: ldc_w 832
    //   39: astore 6
    //   41: aload 6
    //   43: invokestatic 612	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore 5
    //   48: aload_0
    //   49: getfield 827	sjv:i	Landroid/widget/TextView;
    //   52: iload 5
    //   54: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   57: aload_0
    //   58: getfield 827	sjv:i	Landroid/widget/TextView;
    //   61: iconst_0
    //   62: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   65: aload_0
    //   66: getfield 833	sjv:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   69: aload_1
    //   70: getfield 836	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   73: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   76: aload_1
    //   77: invokevirtual 306	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   80: ifeq +501 -> 581
    //   83: new 224	java/net/URL
    //   86: dup
    //   87: aload_1
    //   88: getfield 310	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrcx;
    //   91: getfield 313	rcx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: astore 6
    //   99: aload_1
    //   100: getfield 310	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrcx;
    //   103: getfield 317	rcx:jdField_b_of_type_Int	I
    //   106: ifle +33 -> 139
    //   109: aload_0
    //   110: getfield 837	sjv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   113: aload 6
    //   115: aload_1
    //   116: getfield 310	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrcx;
    //   119: getfield 318	rcx:jdField_a_of_type_Int	I
    //   122: aload_1
    //   123: getfield 310	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lrcx;
    //   126: getfield 317	rcx:jdField_b_of_type_Int	I
    //   129: aload_2
    //   130: invokevirtual 644	ped:a	()Lpeg;
    //   133: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   136: invokestatic 321	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;IILandroid/content/Context;)V
    //   139: aload_0
    //   140: getfield 837	sjv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   143: iconst_0
    //   144: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   147: aload_0
    //   148: getfield 839	sjv:h	Landroid/widget/TextView;
    //   151: bipush 8
    //   153: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   156: aload_1
    //   157: getfield 842	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   160: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifne +494 -> 657
    //   166: new 224	java/net/URL
    //   169: dup
    //   170: aload_1
    //   171: getfield 842	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   174: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   177: astore 6
    //   179: aload_0
    //   180: getfield 844	sjv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   183: aload 6
    //   185: invokevirtual 602	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   188: pop
    //   189: aload_0
    //   190: getfield 844	sjv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   193: iconst_0
    //   194: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   197: aload_0
    //   198: getfield 845	sjv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   201: bipush 10
    //   203: bipush 10
    //   205: bipush 10
    //   207: bipush 10
    //   209: invokestatic 671	com/tencent/biz/qqstory/utils/UIUtils:expandViewTouchArea	(Landroid/view/View;IIII)V
    //   212: aload_0
    //   213: getfield 845	sjv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 675	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   220: aload_0
    //   221: getfield 845	sjv:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   224: aload_3
    //   225: invokevirtual 676	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   228: aload_1
    //   229: invokestatic 617	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lsdg;
    //   232: astore_3
    //   233: aload_3
    //   234: aload_0
    //   235: getfield 846	sjv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   238: putfield 622	sdg:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   241: aload_3
    //   242: aload_0
    //   243: getfield 847	sjv:jdField_a_of_type_Int	I
    //   246: putfield 624	sdg:jdField_a_of_type_Int	I
    //   249: aload_3
    //   250: aload_1
    //   251: putfield 179	sdg:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   254: aload_3
    //   255: iconst_1
    //   256: putfield 850	sdg:n	I
    //   259: aload_0
    //   260: aload_3
    //   261: putfield 851	sjv:jdField_a_of_type_Sdg	Lsdg;
    //   264: aload_0
    //   265: getfield 852	sjv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   268: bipush 8
    //   270: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   273: aload_0
    //   274: getfield 853	sjv:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   277: bipush 8
    //   279: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   282: aload_0
    //   283: getfield 855	sjv:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   286: bipush 8
    //   288: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   291: aload_0
    //   292: getfield 856	sjv:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   295: aload_1
    //   296: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   299: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   302: aload_0
    //   303: getfield 856	sjv:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   306: astore 6
    //   308: invokestatic 861	pkm:a	()Lpkm;
    //   311: aload_1
    //   312: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   315: invokevirtual 864	pkm:a	(J)Z
    //   318: ifeq +351 -> 669
    //   321: getstatic 867	pel:jdField_a_of_type_Int	I
    //   324: istore 5
    //   326: aload 6
    //   328: iload 5
    //   330: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   333: aload_0
    //   334: getfield 868	sjv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   337: aload_3
    //   338: getfield 40	sdg:jdField_b_of_type_Int	I
    //   341: iconst_1
    //   342: invokestatic 662	pai:a	(IZ)Ljava/lang/String;
    //   345: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   348: aload_2
    //   349: invokevirtual 644	ped:a	()Lpeg;
    //   352: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   355: aload_0
    //   356: getfield 846	sjv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   359: aload_0
    //   360: getfield 851	sjv:jdField_a_of_type_Sdg	Lsdg;
    //   363: invokestatic 681	psf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lsdg;)V
    //   366: aload_0
    //   367: getfield 846	sjv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   370: aload_1
    //   371: iconst_0
    //   372: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   375: iconst_0
    //   376: aload_2
    //   377: invokevirtual 644	ped:a	()Lpeg;
    //   380: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   383: invokestatic 411	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   386: aload_0
    //   387: getfield 846	sjv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   390: aload 4
    //   392: invokevirtual 685	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   395: aload_0
    //   396: getfield 868	sjv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   399: iconst_0
    //   400: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   403: aload_0
    //   404: getfield 868	sjv:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   407: invokevirtual 871	android/widget/TextView:clearAnimation	()V
    //   410: aload_0
    //   411: getfield 872	sjv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   414: fconst_1
    //   415: aload_3
    //   416: getfield 45	sdg:jdField_c_of_type_Int	I
    //   419: aload_3
    //   420: getfield 51	sdg:jdField_d_of_type_Int	I
    //   423: invokestatic 691	pai:a	(II)F
    //   426: invokevirtual 697	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   429: aload_0
    //   430: getfield 872	sjv:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   433: aload_0
    //   434: invokevirtual 698	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   437: aload_2
    //   438: invokevirtual 644	ped:a	()Lpeg;
    //   441: invokevirtual 701	peg:a	()Lslt;
    //   444: aload_2
    //   445: invokevirtual 644	ped:a	()Lpeg;
    //   448: invokevirtual 703	peg:b	()I
    //   451: aload_1
    //   452: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   455: invokevirtual 708	slt:b	(IJ)Z
    //   458: ifeq +26 -> 484
    //   461: aload_0
    //   462: getfield 873	sjv:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   465: aload_2
    //   466: invokevirtual 644	ped:a	()Lpeg;
    //   469: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   472: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   475: ldc_w 711
    //   478: invokevirtual 655	android/content/res/Resources:getColor	(I)I
    //   481: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   484: aload_1
    //   485: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   488: lconst_0
    //   489: lcmp
    //   490: ifgt +187 -> 677
    //   493: aload_0
    //   494: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   497: ldc_w 717
    //   500: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   503: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   506: aload_2
    //   507: invokevirtual 644	ped:a	()Lpeg;
    //   510: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   513: invokestatic 372	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   516: ifeq +200 -> 716
    //   519: aload_0
    //   520: getfield 875	sjv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   523: iconst_0
    //   524: invokevirtual 378	android/widget/ImageView:setVisibility	(I)V
    //   527: aload_0
    //   528: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   531: bipush 8
    //   533: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   536: aload_0
    //   537: getfield 876	sjv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   540: iconst_0
    //   541: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   544: return
    //   545: aload_1
    //   546: getfield 830	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   549: astore 6
    //   551: goto -510 -> 41
    //   554: aload_0
    //   555: getfield 827	sjv:i	Landroid/widget/TextView;
    //   558: bipush 8
    //   560: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   563: goto -498 -> 65
    //   566: astore 6
    //   568: ldc_w 337
    //   571: iconst_2
    //   572: ldc_w 878
    //   575: invokestatic 344	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: goto -422 -> 156
    //   581: aload_0
    //   582: getfield 837	sjv:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   585: bipush 8
    //   587: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   590: aload_0
    //   591: getfield 839	sjv:h	Landroid/widget/TextView;
    //   594: iconst_0
    //   595: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   598: ldc_w 337
    //   601: iconst_2
    //   602: ldc_w 880
    //   605: invokestatic 344	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_0
    //   609: getfield 839	sjv:h	Landroid/widget/TextView;
    //   612: new 414	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   619: aload_1
    //   620: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   623: invokestatic 882	rwv:d	(I)Ljava/lang/String;
    //   626: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w 883
    //   632: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   635: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   644: goto -488 -> 156
    //   647: astore 6
    //   649: aload 6
    //   651: invokevirtual 724	java/lang/Exception:printStackTrace	()V
    //   654: goto -457 -> 197
    //   657: aload_0
    //   658: getfield 844	sjv:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   661: bipush 8
    //   663: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   666: goto -469 -> 197
    //   669: getstatic 884	pel:jdField_b_of_type_Int	I
    //   672: istore 5
    //   674: goto -348 -> 326
    //   677: aload_0
    //   678: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   681: new 414	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   688: aload_1
    //   689: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   692: invokestatic 729	rwv:b	(J)Ljava/lang/String;
    //   695: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 730
    //   701: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   704: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   713: goto -207 -> 506
    //   716: aload_0
    //   717: getfield 875	sjv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   720: bipush 8
    //   722: invokevirtual 378	android/widget/ImageView:setVisibility	(I)V
    //   725: aload_2
    //   726: invokevirtual 644	ped:a	()Lpeg;
    //   729: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   732: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   735: ldc_w 731
    //   738: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   741: astore_3
    //   742: aload_0
    //   743: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   746: aload_3
    //   747: aconst_null
    //   748: aconst_null
    //   749: aconst_null
    //   750: invokevirtual 738	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   753: aload_0
    //   754: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   757: ldc_w 739
    //   760: aload_2
    //   761: invokevirtual 644	ped:a	()Lpeg;
    //   764: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   767: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   770: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   773: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   776: aload_0
    //   777: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   780: iconst_0
    //   781: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   784: invokestatic 746	bgoa:a	()I
    //   787: iconst_1
    //   788: if_icmpne +34 -> 822
    //   791: aload_0
    //   792: getfield 874	sjv:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   795: ldc_w 747
    //   798: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   801: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   804: aload_0
    //   805: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   808: bipush 8
    //   810: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   813: aload_0
    //   814: getfield 876	sjv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   817: iconst_0
    //   818: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   821: return
    //   822: invokestatic 751	bkwm:w	()Z
    //   825: ifeq +291 -> 1116
    //   828: aload_2
    //   829: invokevirtual 644	ped:a	()Lpeg;
    //   832: invokevirtual 753	peg:e	()Z
    //   835: ifne +281 -> 1116
    //   838: aload_0
    //   839: getfield 847	sjv:jdField_a_of_type_Int	I
    //   842: ifne +274 -> 1116
    //   845: invokestatic 755	bkwm:e	()Ljava/lang/String;
    //   848: astore 4
    //   850: invokestatic 757	bkwm:f	()Ljava/lang/String;
    //   853: astore 6
    //   855: invokestatic 759	bkwm:g	()Ljava/lang/String;
    //   858: astore 7
    //   860: aload 4
    //   862: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   865: ifne +217 -> 1082
    //   868: invokestatic 762	pay:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   871: astore 8
    //   873: ldc 134
    //   875: astore_3
    //   876: aload 8
    //   878: ifnull +9 -> 887
    //   881: aload 8
    //   883: invokevirtual 767	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   886: astore_3
    //   887: new 769	sie
    //   890: dup
    //   891: aconst_null
    //   892: aconst_null
    //   893: aconst_null
    //   894: aconst_null
    //   895: invokespecial 772	sie:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload_3
    //   899: invokevirtual 775	sie:m	(Ljava/lang/String;)Lsie;
    //   902: aload_1
    //   903: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   906: invokevirtual 777	sie:i	(Ljava/lang/String;)Lsie;
    //   909: invokevirtual 780	sie:a	()Lsid;
    //   912: invokevirtual 784	sid:a	()Ljava/lang/String;
    //   915: astore_1
    //   916: aload_0
    //   917: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   920: iconst_0
    //   921: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   924: aload_0
    //   925: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   928: fconst_2
    //   929: aload_2
    //   930: invokevirtual 644	ped:a	()Lpeg;
    //   933: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   936: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   939: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   942: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   945: aload_2
    //   946: invokevirtual 644	ped:a	()Lpeg;
    //   949: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   952: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   955: ldc_w 785
    //   958: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   961: astore_3
    //   962: aload_3
    //   963: iconst_0
    //   964: iconst_0
    //   965: ldc_w 786
    //   968: aload_2
    //   969: invokevirtual 644	ped:a	()Lpeg;
    //   972: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   975: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   978: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   981: ldc_w 786
    //   984: aload_2
    //   985: invokevirtual 644	ped:a	()Lpeg;
    //   988: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   991: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   994: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   997: invokevirtual 791	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1000: aload_0
    //   1001: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1004: aconst_null
    //   1005: aconst_null
    //   1006: aload_3
    //   1007: aconst_null
    //   1008: invokevirtual 794	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1011: aload_2
    //   1012: invokevirtual 644	ped:a	()Lpeg;
    //   1015: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1018: aload_0
    //   1019: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1022: aload 6
    //   1024: aload 7
    //   1026: aload 4
    //   1028: new 887	phg
    //   1031: dup
    //   1032: aload_1
    //   1033: aload_0
    //   1034: invokespecial 890	phg:<init>	(Ljava/lang/String;Lsjv;)V
    //   1037: invokestatic 802	rwv:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1040: aload_0
    //   1041: getfield 876	sjv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1044: ldc_w 803
    //   1047: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1050: aload_2
    //   1051: invokevirtual 644	ped:a	()Lpeg;
    //   1054: iconst_1
    //   1055: invokevirtual 806	peg:c	(Z)Lpeg;
    //   1058: pop
    //   1059: aconst_null
    //   1060: ldc 134
    //   1062: ldc_w 808
    //   1065: ldc_w 808
    //   1068: iconst_0
    //   1069: iconst_0
    //   1070: ldc 134
    //   1072: ldc 134
    //   1074: ldc 134
    //   1076: aload_1
    //   1077: iconst_0
    //   1078: invokestatic 813	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1081: return
    //   1082: aload_0
    //   1083: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1086: bipush 8
    //   1088: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1091: aload_0
    //   1092: getfield 876	sjv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1095: iconst_0
    //   1096: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1099: invokestatic 523	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1102: ifeq -1098 -> 4
    //   1105: ldc_w 815
    //   1108: iconst_2
    //   1109: ldc_w 817
    //   1112: invokestatic 819	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: return
    //   1116: aload_0
    //   1117: getfield 885	sjv:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1120: bipush 8
    //   1122: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1125: aload_0
    //   1126: getfield 876	sjv:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1129: iconst_0
    //   1130: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1133: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1134	0	paramsjv	sjv
    //   0	1134	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1134	2	paramped	ped
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
  
  public static void a(sjw paramsjw, BaseArticleInfo paramBaseArticleInfo, ped paramped, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramBaseArticleInfo == null) {}
    for (;;)
    {
      return;
      paramsjw.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      Object localObject2;
      Object localObject1;
      if (paramBaseArticleInfo.mVideoColumnInfo != null)
      {
        localObject2 = paramBaseArticleInfo.mVideoColumnInfo;
        if (((VideoColumnInfo)localObject2).jdField_d_of_type_Int != 1) {
          break label770;
        }
        localObject1 = paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.dip2px(paramped.a().a(), 90.0F);
        paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      try
      {
        if (!TextUtils.isEmpty(((VideoColumnInfo)localObject2).jdField_d_of_type_JavaLangString)) {
          a(paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(((VideoColumnInfo)localObject2).jdField_d_of_type_JavaLangString), paramped.a().a());
        }
      }
      catch (Exception localMalformedURLException)
      {
        try
        {
          if (!TextUtils.isEmpty(((VideoColumnInfo)localObject2).e))
          {
            localObject1 = pai.a(((VideoColumnInfo)localObject2).e);
            paramsjw.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          }
        }
        catch (Exception localMalformedURLException)
        {
          try
          {
            a(paramsjw.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(((VideoColumnInfo)localObject2).jdField_f_of_type_JavaLangString), paramped.a().a());
            paramsjw.jdField_a_of_type_AndroidWidgetTextView.setText(((VideoColumnInfo)localObject2).jdField_b_of_type_JavaLangString);
            localObject1 = pax.a(((VideoColumnInfo)localObject2).jdField_a_of_type_Long, true) + amtj.a(2131711839);
            localObject3 = bkwm.b(((VideoColumnInfo)localObject2).jdField_b_of_type_Int) + amtj.a(2131711948);
            String str2 = ((VideoColumnInfo)localObject2).jdField_c_of_type_Int + amtj.a(2131712198);
            localObject1 = (String)localObject1 + " · " + (String)localObject3 + " · " + str2;
            paramsjw.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean)
            {
              paramsjw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              paramsjw.i.setText(((VideoColumnInfo)localObject2).jdField_g_of_type_JavaLangString);
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            try
            {
              for (;;)
              {
                paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(DisplayUtil.dip2px(paramped.a().a(), 2.0F));
                a(paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, new URL(((VideoColumnInfo)localObject2).h), paramped.a().a());
                paramsjw.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramsjw);
                paramsjw.jdField_c_of_type_AndroidWidgetTextView.setTag(paramsjw);
                paramsjw.jdField_b_of_type_AndroidViewViewGroup.setTag(paramsjw);
                paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setTag(paramsjw);
                paramsjw.i.setTag(paramsjw);
                paramsjw.jdField_b_of_type_AndroidWidgetImageView.setTag(paramsjw);
                paramsjw.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
                paramOnClickListener = a(paramBaseArticleInfo);
                paramOnClickListener.jdField_a_of_type_AndroidViewView = paramsjw.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
                paramOnClickListener.jdField_a_of_type_Int = paramsjw.jdField_a_of_type_Int;
                paramOnClickListener.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
                paramsjw.jdField_a_of_type_Sdg = paramOnClickListener;
                paramsjw.jdField_d_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
                paramsjw.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
                paramsjw.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramped.a().a().getResources().getColor(2131167337));
                if (paramBaseArticleInfo.mVideoPlayCount != 0) {
                  break;
                }
                paramsjw.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
                paramsjw.jdField_f_of_type_AndroidWidgetTextView.setText(pai.a(paramOnClickListener.jdField_b_of_type_Int, true));
                psf.a(paramped.a().a(), paramsjw.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramsjw.jdField_a_of_type_Sdg);
                a(paramsjw.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramped.a().a());
                paramsjw.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
                paramsjw.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramsjw);
                paramsjw.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
                paramsjw.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
                paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pai.a(paramOnClickListener.jdField_c_of_type_Int, paramOnClickListener.jdField_d_of_type_Int));
                paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(paramsjw);
                if (paramped.a().a().b(paramped.a().b(), paramBaseArticleInfo.mArticleID)) {
                  paramsjw.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramped.a().a().getResources().getColor(2131166900));
                }
                if (paramBaseArticleInfo.mXGFileSize > 0L) {
                  break label1011;
                }
                paramsjw.jdField_g_of_type_AndroidWidgetTextView.setText(amtj.a(2131712115));
                if (!NetworkUtil.isWifiConnected(paramped.a().a())) {
                  break label1050;
                }
                paramsjw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                paramsjw.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
                paramsjw.jdField_b_of_type_AndroidViewView.setVisibility(0);
                paramsjw.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
                return;
                label770:
                localObject1 = paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.dip2px(paramped.a().a(), 80.0F);
                paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                continue;
                paramsjw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(new ColorDrawable(-15837762));
                continue;
                localException1 = localException1;
                if (QLog.isColorLevel())
                {
                  QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgUrl error: ", localException1);
                  continue;
                  ColorDrawable localColorDrawable = new ColorDrawable(-15837762);
                  continue;
                  localException2 = localException2;
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgColor error: ", localException2);
                  }
                  paramsjw.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(new ColorDrawable(-15837762));
                  continue;
                  localMalformedURLException = localMalformedURLException;
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyBaseAdapter", 2, "configImage columnCardIcon error: ", localMalformedURLException);
                  }
                }
              }
              paramsjw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            catch (Exception localException3)
            {
              Object localObject3;
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("ReadInJoyBaseAdapter", 2, "configImage appIcon error: ", localException3);
                  continue;
                  paramsjw.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
                  paramsjw.jdField_e_of_type_AndroidWidgetTextView.setText(rwv.c(paramBaseArticleInfo.mVideoPlayCount) + amtj.a(2131712192));
                  continue;
                  label1011:
                  paramsjw.jdField_g_of_type_AndroidWidgetTextView.setText(rwv.b(paramBaseArticleInfo.mXGFileSize) + amtj.a(2131711888));
                }
              }
              label1050:
              paramsjw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              paramOnClickListener = paramped.a().a().getResources().getDrawable(2130843190);
              paramsjw.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramOnClickListener, null, null, null);
              paramsjw.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, paramped.a().a().getResources()));
              paramsjw.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
              if (bgoa.a() == 1)
              {
                paramsjw.jdField_g_of_type_AndroidWidgetTextView.setText(amtj.a(2131712111));
                paramsjw.h.setVisibility(8);
                paramsjw.jdField_b_of_type_AndroidViewView.setVisibility(0);
                paramsjw.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
                return;
              }
              if ((bkwm.w()) && (!paramped.a().e()) && (paramsjw.jdField_a_of_type_Int == 0))
              {
                paramOnLongClickListener = bkwm.e();
                String str1 = bkwm.f();
                localObject2 = bkwm.g();
                if (!TextUtils.isEmpty(paramOnLongClickListener))
                {
                  localObject3 = pay.a();
                  paramOnClickListener = "";
                  if (localObject3 != null) {
                    paramOnClickListener = ((QQAppInterface)localObject3).getCurrentAccountUin();
                  }
                  paramBaseArticleInfo = new sie(null, null, null, null).m(paramOnClickListener).i(paramBaseArticleInfo.innerUniqueID).a().a();
                  paramsjw.h.setVisibility(0);
                  paramsjw.h.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, paramped.a().a().getResources()));
                  paramOnClickListener = paramped.a().a().getResources().getDrawable(2130842992);
                  paramOnClickListener.setBounds(0, 0, AIOUtils.dp2px(10.0F, paramped.a().a().getResources()), AIOUtils.dp2px(10.0F, paramped.a().a().getResources()));
                  paramsjw.h.setCompoundDrawables(null, null, paramOnClickListener, null);
                  rwv.b(paramped.a().a(), paramsjw.h, str1, (String)localObject2, paramOnLongClickListener, new phi(paramBaseArticleInfo));
                  paramsjw.jdField_a_of_type_AndroidViewView.setBackgroundColor(1711276032);
                  paramsjw.jdField_b_of_type_AndroidViewView.setVisibility(0);
                  paramped.a().c(true);
                  odq.a(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramBaseArticleInfo, false);
                  return;
                }
                paramsjw.h.setVisibility(8);
                paramsjw.jdField_b_of_type_AndroidViewView.setVisibility(0);
                paramsjw.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
                if (QLog.isColorLevel()) {
                  QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
                }
              }
              else
              {
                paramsjw.h.setVisibility(8);
                paramsjw.jdField_b_of_type_AndroidViewView.setVisibility(0);
                paramsjw.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(sjx paramsjx, BaseArticleInfo paramBaseArticleInfo, ped paramped, View.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1004	sjx:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   4: aconst_null
    //   5: invokevirtual 1005	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 1006	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   13: aload_0
    //   14: aload_1
    //   15: getfield 1010	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubArtilceList	Ljava/util/List;
    //   18: iconst_0
    //   19: invokeinterface 1016 2 0
    //   24: checkcast 18	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo
    //   27: putfield 1018	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   30: aload_0
    //   31: getfield 1019	sjx:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   34: aload_2
    //   35: invokevirtual 644	ped:a	()Lpeg;
    //   38: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   41: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   44: ldc_w 649
    //   47: invokevirtual 655	android/content/res/Resources:getColor	(I)I
    //   50: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   53: aload_0
    //   54: getfield 1020	sjx:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   57: aload_0
    //   58: getfield 1021	sjx:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   61: aload_2
    //   62: invokevirtual 644	ped:a	()Lpeg;
    //   65: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   68: invokestatic 1023	phe:a	(Landroid/view/View;Landroid/view/View;Landroid/content/Context;)V
    //   71: aload_0
    //   72: getfield 1006	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   75: astore 8
    //   77: aload 8
    //   79: aload_0
    //   80: getfield 1024	sjx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   83: aload_0
    //   84: getfield 1025	sjx:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   87: aload_0
    //   88: getfield 1026	sjx:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   91: aload_0
    //   92: getfield 1027	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   95: aload_0
    //   96: getfield 1004	sjx:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   99: aload_2
    //   100: invokevirtual 644	ped:a	()Lpeg;
    //   103: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   106: invokestatic 1029	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/view/View;Landroid/content/Context;)V
    //   109: aload_0
    //   110: getfield 1032	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   113: invokestatic 1034	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   116: aload_0
    //   117: getfield 1024	sjx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   120: aload 8
    //   122: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   125: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   128: aload_0
    //   129: getfield 1024	sjx:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   132: invokevirtual 633	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   135: iconst_1
    //   136: invokevirtual 639	android/text/TextPaint:setFakeBoldText	(Z)V
    //   139: aload_0
    //   140: getfield 1035	sjx:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   143: aload 8
    //   145: getfield 967	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   148: invokestatic 993	rwv:c	(I)Ljava/lang/String;
    //   151: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: aload_0
    //   155: getfield 1036	sjx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   158: aload_0
    //   159: getfield 1037	sjx:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   162: aload 8
    //   164: iconst_0
    //   165: aload_2
    //   166: invokevirtual 644	ped:a	()Lpeg;
    //   169: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   172: invokestatic 1039	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;ZLandroid/content/Context;)V
    //   175: aload_0
    //   176: getfield 1036	sjx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   179: aload_0
    //   180: invokevirtual 970	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 1036	sjx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   187: aload_3
    //   188: invokevirtual 333	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   191: aload_0
    //   192: getfield 1036	sjx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   195: ldc_w 1041
    //   198: invokestatic 1047	com/tencent/qqlive/module/videoreport/VideoReport:setElementId	(Ljava/lang/Object;Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield 1036	sjx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   205: astore 9
    //   207: new 1049	pil
    //   210: dup
    //   211: invokespecial 1050	pil:<init>	()V
    //   214: aload_2
    //   215: invokevirtual 644	ped:a	()Lpeg;
    //   218: invokevirtual 703	peg:b	()I
    //   221: invokestatic 1055	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: invokevirtual 1058	pil:a	(Ljava/lang/Number;)Lpil;
    //   227: astore 10
    //   229: aload 8
    //   231: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   234: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifeq +687 -> 924
    //   240: ldc_w 1060
    //   243: astore_1
    //   244: aload 9
    //   246: aload 10
    //   248: aload_1
    //   249: invokevirtual 1063	pil:e	(Ljava/lang/String;)Lpil;
    //   252: invokevirtual 1066	pil:a	()Ljava/util/Map;
    //   255: invokestatic 1070	com/tencent/qqlive/module/videoreport/VideoReport:setElementParams	(Ljava/lang/Object;Ljava/util/Map;)V
    //   258: aload_0
    //   259: getfield 1036	sjx:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   262: aload 8
    //   264: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   267: invokestatic 1073	com/tencent/qqlive/module/videoreport/VideoReport:setElementReuseIdentifier	(Ljava/lang/Object;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 1027	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   274: aload 8
    //   276: invokevirtual 970	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   279: aload 8
    //   281: getfield 1076	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   284: aload 8
    //   286: getfield 1079	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   289: aload_0
    //   290: getfield 1080	sjx:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   293: invokestatic 1083	rwv:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   296: aload 8
    //   298: getfield 1086	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isAccountShown	Z
    //   301: ifeq +653 -> 954
    //   304: aload_2
    //   305: invokevirtual 644	ped:a	()Lpeg;
    //   308: invokevirtual 703	peg:b	()I
    //   311: ifne +643 -> 954
    //   314: aload 8
    //   316: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   319: ifnull +635 -> 954
    //   322: aload_0
    //   323: getfield 1092	sjx:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   326: iconst_0
    //   327: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   330: aload_0
    //   331: getfield 1092	sjx:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   334: aload 8
    //   336: invokevirtual 1093	android/view/View:setTag	(Ljava/lang/Object;)V
    //   339: aload_0
    //   340: getfield 1092	sjx:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   343: ldc_w 1094
    //   346: aload_0
    //   347: invokevirtual 1097	android/view/View:setTag	(ILjava/lang/Object;)V
    //   350: lconst_0
    //   351: lstore 4
    //   353: aload 8
    //   355: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   358: getfield 1103	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   361: invokevirtual 1108	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   364: ifeq +16 -> 380
    //   367: aload 8
    //   369: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   372: getfield 1103	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   375: invokevirtual 1111	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   378: lstore 4
    //   380: aload_0
    //   381: getfield 1114	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   384: lload 4
    //   386: invokevirtual 1117	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setHeadImgByUin	(J)V
    //   389: aload_0
    //   390: getfield 1114	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   393: aload 8
    //   395: invokevirtual 1118	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(Ljava/lang/Object;)V
    //   398: aload_0
    //   399: getfield 1114	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   402: ldc_w 1094
    //   405: aload_0
    //   406: invokevirtual 1119	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(ILjava/lang/Object;)V
    //   409: aload_0
    //   410: getfield 1114	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   413: bipush 10
    //   415: bipush 10
    //   417: bipush 10
    //   419: bipush 10
    //   421: invokestatic 1121	pay:a	(Landroid/view/View;IIII)V
    //   424: aload 8
    //   426: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   429: getfield 1125	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:bytes_v_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   432: invokestatic 1128	pay:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_1
    //   437: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne +21 -> 461
    //   443: new 224	java/net/URL
    //   446: dup
    //   447: aload_1
    //   448: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   451: astore_1
    //   452: aload_0
    //   453: getfield 1130	sjx:jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   456: aload_1
    //   457: invokevirtual 602	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   460: pop
    //   461: aload_0
    //   462: getfield 1133	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   465: lload 4
    //   467: invokevirtual 1135	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setNickNameByUin	(J)V
    //   470: aload_0
    //   471: getfield 1092	sjx:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   474: aload_3
    //   475: invokevirtual 1005	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   478: aload_0
    //   479: getfield 1114	sjx:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   482: aload_3
    //   483: invokevirtual 1136	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   486: aload_0
    //   487: getfield 1018	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   490: astore 8
    //   492: aload 8
    //   494: iconst_1
    //   495: putfield 1139	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   498: aload 8
    //   500: aload_0
    //   501: getfield 1140	sjx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   504: aload_0
    //   505: getfield 1141	sjx:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   508: aload_0
    //   509: getfield 1142	sjx:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   512: aload_0
    //   513: getfield 1143	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   516: aload_0
    //   517: getfield 1004	sjx:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   520: aload_2
    //   521: invokevirtual 644	ped:a	()Lpeg;
    //   524: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   527: invokestatic 1029	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/view/View;Landroid/content/Context;)V
    //   530: aload_0
    //   531: getfield 1145	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   534: invokestatic 1034	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   537: aload_0
    //   538: getfield 1140	sjx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   541: aload 8
    //   543: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   546: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   549: aload_0
    //   550: getfield 1140	sjx:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   553: invokevirtual 633	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   556: iconst_1
    //   557: invokevirtual 639	android/text/TextPaint:setFakeBoldText	(Z)V
    //   560: aload_0
    //   561: getfield 1146	sjx:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   564: aload 8
    //   566: getfield 967	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   569: invokestatic 993	rwv:c	(I)Ljava/lang/String;
    //   572: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   575: aload_0
    //   576: getfield 1148	sjx:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   579: aload_0
    //   580: getfield 1149	sjx:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   583: aload 8
    //   585: iconst_0
    //   586: aload_2
    //   587: invokevirtual 644	ped:a	()Lpeg;
    //   590: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   593: invokestatic 1039	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;ZLandroid/content/Context;)V
    //   596: aload_0
    //   597: getfield 1148	sjx:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   600: aload_0
    //   601: invokevirtual 970	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   604: aload_0
    //   605: getfield 1148	sjx:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   608: aload_3
    //   609: invokevirtual 333	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   612: aload_0
    //   613: getfield 1148	sjx:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   616: ldc_w 1041
    //   619: invokestatic 1047	com/tencent/qqlive/module/videoreport/VideoReport:setElementId	(Ljava/lang/Object;Ljava/lang/String;)V
    //   622: aload_0
    //   623: getfield 1148	sjx:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   626: astore 9
    //   628: new 1049	pil
    //   631: dup
    //   632: invokespecial 1050	pil:<init>	()V
    //   635: aload_2
    //   636: invokevirtual 644	ped:a	()Lpeg;
    //   639: invokevirtual 703	peg:b	()I
    //   642: invokestatic 1055	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokevirtual 1058	pil:a	(Ljava/lang/Number;)Lpil;
    //   648: astore 10
    //   650: aload 8
    //   652: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   655: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifeq +308 -> 966
    //   661: ldc_w 1060
    //   664: astore_1
    //   665: aload 9
    //   667: aload 10
    //   669: aload_1
    //   670: invokevirtual 1063	pil:e	(Ljava/lang/String;)Lpil;
    //   673: invokevirtual 1066	pil:a	()Ljava/util/Map;
    //   676: invokestatic 1070	com/tencent/qqlive/module/videoreport/VideoReport:setElementParams	(Ljava/lang/Object;Ljava/util/Map;)V
    //   679: aload_0
    //   680: getfield 1148	sjx:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   683: aload 8
    //   685: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   688: invokestatic 1073	com/tencent/qqlive/module/videoreport/VideoReport:setElementReuseIdentifier	(Ljava/lang/Object;Ljava/lang/String;)V
    //   691: aload_0
    //   692: getfield 1143	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   695: aload 8
    //   697: invokevirtual 970	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   700: aload 8
    //   702: getfield 1076	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   705: aload 8
    //   707: getfield 1079	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   710: aload_0
    //   711: getfield 1150	sjx:h	Landroid/widget/TextView;
    //   714: invokestatic 1083	rwv:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   717: aload 8
    //   719: getfield 1086	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isAccountShown	Z
    //   722: ifeq +274 -> 996
    //   725: aload_2
    //   726: invokevirtual 644	ped:a	()Lpeg;
    //   729: invokevirtual 703	peg:b	()I
    //   732: ifne +264 -> 996
    //   735: aload 8
    //   737: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   740: ifnull +256 -> 996
    //   743: aload_0
    //   744: getfield 1152	sjx:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   747: iconst_0
    //   748: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   751: aload_0
    //   752: getfield 1152	sjx:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   755: aload 8
    //   757: invokevirtual 1093	android/view/View:setTag	(Ljava/lang/Object;)V
    //   760: aload_0
    //   761: getfield 1152	sjx:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   764: ldc_w 1094
    //   767: aload_0
    //   768: invokevirtual 1097	android/view/View:setTag	(ILjava/lang/Object;)V
    //   771: lconst_0
    //   772: lstore 6
    //   774: lload 6
    //   776: lstore 4
    //   778: aload 8
    //   780: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   783: ifnull +34 -> 817
    //   786: lload 6
    //   788: lstore 4
    //   790: aload 8
    //   792: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   795: getfield 1103	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   798: invokevirtual 1108	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   801: ifeq +16 -> 817
    //   804: aload 8
    //   806: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   809: getfield 1103	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   812: invokevirtual 1111	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   815: lstore 4
    //   817: aload_0
    //   818: getfield 1154	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   821: lload 4
    //   823: invokevirtual 1117	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setHeadImgByUin	(J)V
    //   826: aload_0
    //   827: getfield 1154	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   830: aload 8
    //   832: invokevirtual 1118	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(Ljava/lang/Object;)V
    //   835: aload_0
    //   836: getfield 1154	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   839: ldc_w 1094
    //   842: aload_0
    //   843: invokevirtual 1119	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(ILjava/lang/Object;)V
    //   846: aload_0
    //   847: getfield 1154	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   850: bipush 10
    //   852: bipush 10
    //   854: bipush 10
    //   856: bipush 10
    //   858: invokestatic 1121	pay:a	(Landroid/view/View;IIII)V
    //   861: aload 8
    //   863: getfield 1090	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   866: getfield 1125	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:bytes_v_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   869: invokestatic 1128	pay:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   872: astore_1
    //   873: aload_1
    //   874: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   877: ifne +21 -> 898
    //   880: new 224	java/net/URL
    //   883: dup
    //   884: aload_1
    //   885: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   888: astore_1
    //   889: aload_0
    //   890: getfield 1156	sjx:jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   893: aload_1
    //   894: invokevirtual 602	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   897: pop
    //   898: aload_0
    //   899: getfield 1158	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   902: lload 4
    //   904: invokevirtual 1135	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setNickNameByUin	(J)V
    //   907: aload_0
    //   908: getfield 1152	sjx:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   911: aload_3
    //   912: invokevirtual 1005	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   915: aload_0
    //   916: getfield 1154	sjx:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   919: aload_3
    //   920: invokevirtual 1136	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   923: return
    //   924: aload 8
    //   926: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   929: astore_1
    //   930: goto -686 -> 244
    //   933: astore_1
    //   934: invokestatic 523	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   937: ifeq -476 -> 461
    //   940: ldc_w 337
    //   943: iconst_2
    //   944: ldc_w 1160
    //   947: aload_1
    //   948: invokestatic 985	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   951: goto -490 -> 461
    //   954: aload_0
    //   955: getfield 1092	sjx:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   958: bipush 8
    //   960: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   963: goto -477 -> 486
    //   966: aload 8
    //   968: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   971: astore_1
    //   972: goto -307 -> 665
    //   975: astore_1
    //   976: invokestatic 523	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq -81 -> 898
    //   982: ldc_w 337
    //   985: iconst_2
    //   986: ldc_w 1162
    //   989: aload_1
    //   990: invokestatic 985	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   993: goto -95 -> 898
    //   996: aload_0
    //   997: getfield 1152	sjx:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1000: bipush 8
    //   1002: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   1005: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	paramsjx	sjx
    //   0	1006	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1006	2	paramped	ped
    //   0	1006	3	paramOnClickListener	View.OnClickListener
    //   351	552	4	l1	long
    //   772	15	6	l2	long
    //   75	892	8	localBaseArticleInfo	BaseArticleInfo
    //   205	461	9	localKandianUrlImageView	KandianUrlImageView
    //   227	441	10	localpil	pil
    // Exception table:
    //   from	to	target	type
    //   443	461	933	java/lang/Exception
    //   880	898	975	java/lang/Exception
  }
  
  public static void a(sjy paramsjy, BaseArticleInfo paramBaseArticleInfo)
  {
    sdg localsdg = a(paramBaseArticleInfo);
    localsdg.jdField_a_of_type_AndroidViewView = paramsjy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localsdg.jdField_a_of_type_Int = paramsjy.jdField_a_of_type_Int;
    localsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramsjy.jdField_a_of_type_Sdg = localsdg;
  }
  
  /* Error */
  public static void a(sjy paramsjy, BaseArticleInfo paramBaseArticleInfo, ped paramped, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, java.util.Set<Long> paramSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 1171	phe:a	(Lsjy;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   10: aload_0
    //   11: getfield 1168	sjy:jdField_a_of_type_Sdg	Lsdg;
    //   14: astore 7
    //   16: aload_0
    //   17: getfield 1172	sjy:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   20: aload_1
    //   21: getfield 59	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   24: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   27: aload_0
    //   28: getfield 1172	sjy:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   31: invokevirtual 633	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   34: iconst_1
    //   35: invokevirtual 639	android/text/TextPaint:setFakeBoldText	(Z)V
    //   38: aload_0
    //   39: getfield 1172	sjy:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   42: aload_2
    //   43: invokevirtual 644	ped:a	()Lpeg;
    //   46: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   49: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   52: ldc_w 649
    //   55: invokevirtual 655	android/content/res/Resources:getColor	(I)I
    //   58: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   61: aload_1
    //   62: getfield 967	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   65: ifne +904 -> 969
    //   68: aload_0
    //   69: getfield 1173	sjy:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   72: bipush 8
    //   74: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   77: aload_0
    //   78: getfield 1174	sjy:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   81: aload 7
    //   83: getfield 40	sdg:jdField_b_of_type_Int	I
    //   86: iconst_1
    //   87: invokestatic 662	pai:a	(IZ)Ljava/lang/String;
    //   90: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   93: aload_0
    //   94: getfield 1175	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   97: aload_1
    //   98: aload_1
    //   99: invokestatic 472	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   102: invokestatic 1177	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Z)V
    //   105: aload_0
    //   106: getfield 1178	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   109: aload_1
    //   110: invokestatic 1180	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   113: aload_0
    //   114: getfield 1178	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   117: aload_1
    //   118: invokevirtual 565	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   121: invokevirtual 1183	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   124: aload_0
    //   125: getfield 1175	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   128: iconst_0
    //   129: invokevirtual 1184	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setVisibility	(I)V
    //   132: aload_0
    //   133: getfield 1175	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   136: aload_1
    //   137: invokevirtual 565	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   140: invokevirtual 1185	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   143: aload_0
    //   144: getfield 1186	sjy:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   147: aload_1
    //   148: invokevirtual 958	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 1186	sjy:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   155: ldc_w 1094
    //   158: aload_0
    //   159: invokevirtual 1187	android/view/ViewGroup:setTag	(ILjava/lang/Object;)V
    //   162: aload_0
    //   163: getfield 1186	sjy:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   166: aload_3
    //   167: invokevirtual 1188	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   170: aload_1
    //   171: getfield 842	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   174: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +849 -> 1026
    //   180: new 224	java/net/URL
    //   183: dup
    //   184: aload_1
    //   185: getfield 842	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   188: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   191: astore 8
    //   193: aload_0
    //   194: getfield 1189	sjy:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   197: aload 8
    //   199: invokevirtual 602	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   202: pop
    //   203: aload_0
    //   204: getfield 1189	sjy:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   207: iconst_0
    //   208: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   211: aload_1
    //   212: invokestatic 472	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   215: ifeq +992 -> 1207
    //   218: aload_1
    //   219: checkcast 469	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   222: astore 5
    //   224: aload_0
    //   225: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   228: iconst_0
    //   229: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   232: invokestatic 199	pay:u	()Z
    //   235: ifeq +803 -> 1038
    //   238: aload_0
    //   239: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   242: aconst_null
    //   243: invokestatic 1195	oyw:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   246: aload_0
    //   247: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   250: ldc_w 1197
    //   253: invokestatic 612	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   256: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   259: aload_0
    //   260: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   263: ldc_w 1200
    //   266: invokestatic 612	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   269: invokevirtual 615	android/widget/TextView:setTextColor	(I)V
    //   272: aload_1
    //   273: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   276: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +785 -> 1064
    //   282: aload_0
    //   283: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   286: aload_1
    //   287: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   290: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   293: aload_0
    //   294: getfield 1203	sjy:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   297: iconst_0
    //   298: invokevirtual 1206	android/widget/LinearLayout:setVisibility	(I)V
    //   301: aload_1
    //   302: invokestatic 500	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   305: ifeq +830 -> 1135
    //   308: iconst_0
    //   309: istore 6
    //   311: new 502	org/json/JSONObject
    //   314: dup
    //   315: aload 5
    //   317: getfield 505	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   320: invokespecial 506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   323: astore 8
    //   325: aload_2
    //   326: invokevirtual 644	ped:a	()Lpeg;
    //   329: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   332: aload 8
    //   334: ldc_w 1208
    //   337: invokevirtual 1211	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokestatic 1216	bfwv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   343: ifeq +744 -> 1087
    //   346: aload_0
    //   347: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   350: aload_2
    //   351: invokevirtual 644	ped:a	()Lpeg;
    //   354: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   357: ldc_w 1217
    //   360: invokevirtual 1219	android/content/Context:getString	(I)Ljava/lang/String;
    //   363: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   366: iconst_1
    //   367: istore 6
    //   369: aload 5
    //   371: getfield 1222	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   374: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +20 -> 397
    //   380: iload 6
    //   382: ifne +15 -> 397
    //   385: aload_0
    //   386: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   389: aload 5
    //   391: getfield 1222	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   394: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   397: new 502	org/json/JSONObject
    //   400: dup
    //   401: aload 5
    //   403: getfield 1225	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   406: invokespecial 506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   409: astore 5
    //   411: aload 5
    //   413: ldc_w 1227
    //   416: invokevirtual 1211	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   422: ifne +18 -> 440
    //   425: aload_0
    //   426: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   429: aload 5
    //   431: ldc_w 1227
    //   434: invokevirtual 1211	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   437: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   440: aload_0
    //   441: getfield 1229	sjy:jdField_e_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   444: aload_3
    //   445: invokevirtual 676	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   448: aload_0
    //   449: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   452: aload_3
    //   453: invokevirtual 1230	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   456: aload_0
    //   457: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   460: aload_3
    //   461: invokevirtual 1230	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   464: aload_0
    //   465: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   468: aload_0
    //   469: invokevirtual 955	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   472: aload_0
    //   473: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   476: aload_0
    //   477: invokevirtual 955	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   480: aload_0
    //   481: getfield 1229	sjy:jdField_e_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   484: aload_0
    //   485: invokevirtual 675	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   488: aload_0
    //   489: getfield 1233	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   492: bipush 8
    //   494: invokevirtual 1236	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   497: aload_0
    //   498: getfield 1238	sjy:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   501: bipush 8
    //   503: invokevirtual 1206	android/widget/LinearLayout:setVisibility	(I)V
    //   506: aload_2
    //   507: invokevirtual 644	ped:a	()Lpeg;
    //   510: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   513: aload_0
    //   514: getfield 1166	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   517: aload_0
    //   518: getfield 1168	sjy:jdField_a_of_type_Sdg	Lsdg;
    //   521: invokestatic 681	psf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lsdg;)V
    //   524: aload_0
    //   525: getfield 1166	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   528: aload_1
    //   529: iconst_0
    //   530: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   533: iconst_0
    //   534: aload_2
    //   535: invokevirtual 644	ped:a	()Lpeg;
    //   538: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   541: invokestatic 411	phe:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   544: aload_0
    //   545: getfield 1166	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   548: aload_3
    //   549: invokevirtual 333	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   552: aload_0
    //   553: getfield 1166	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   556: aload 4
    //   558: invokevirtual 685	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   561: aload_0
    //   562: getfield 1166	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   565: aload_0
    //   566: invokevirtual 970	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   569: aload_0
    //   570: getfield 1174	sjy:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   573: iconst_0
    //   574: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   577: aload_0
    //   578: getfield 1174	sjy:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   581: invokevirtual 871	android/widget/TextView:clearAnimation	()V
    //   584: aload_0
    //   585: getfield 1239	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   588: fconst_1
    //   589: aload 7
    //   591: getfield 45	sdg:jdField_c_of_type_Int	I
    //   594: aload 7
    //   596: getfield 51	sdg:jdField_d_of_type_Int	I
    //   599: invokestatic 691	pai:a	(II)F
    //   602: invokevirtual 697	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   605: aload_0
    //   606: getfield 1239	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   609: aload_3
    //   610: invokevirtual 1240	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   613: aload_0
    //   614: getfield 1239	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   617: aload_0
    //   618: invokevirtual 698	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   621: aload_2
    //   622: invokevirtual 644	ped:a	()Lpeg;
    //   625: invokevirtual 701	peg:a	()Lslt;
    //   628: aload_2
    //   629: invokevirtual 644	ped:a	()Lpeg;
    //   632: invokevirtual 703	peg:b	()I
    //   635: aload_1
    //   636: getfield 30	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   639: invokevirtual 708	slt:b	(IJ)Z
    //   642: ifeq +26 -> 668
    //   645: aload_0
    //   646: getfield 1241	sjy:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   649: aload_2
    //   650: invokevirtual 644	ped:a	()Lpeg;
    //   653: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   656: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   659: ldc_w 711
    //   662: invokevirtual 655	android/content/res/Resources:getColor	(I)I
    //   665: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   668: aload_2
    //   669: invokevirtual 644	ped:a	()Lpeg;
    //   672: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   675: aload_0
    //   676: getfield 1242	sjy:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   679: aload_0
    //   680: getfield 1243	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   683: invokestatic 1248	pbh:a	(Landroid/content/Context;Landroid/view/View;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   686: invokestatic 199	pay:u	()Z
    //   689: ifeq +620 -> 1309
    //   692: aload_0
    //   693: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   696: aload_2
    //   697: invokevirtual 644	ped:a	()Lpeg;
    //   700: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   703: ldc_w 278
    //   706: invokestatic 216	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   709: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   712: aload_2
    //   713: invokevirtual 644	ped:a	()Lpeg;
    //   716: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   719: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   722: ldc_w 1250
    //   725: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   728: astore 4
    //   730: aload_2
    //   731: invokevirtual 644	ped:a	()Lpeg;
    //   734: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   737: ldc_w 1251
    //   740: invokestatic 216	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   743: istore 6
    //   745: aload 4
    //   747: iconst_0
    //   748: iconst_0
    //   749: iload 6
    //   751: iload 6
    //   753: invokevirtual 791	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   756: aload_0
    //   757: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   760: aload 4
    //   762: aconst_null
    //   763: aconst_null
    //   764: aconst_null
    //   765: invokevirtual 794	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   768: aload_0
    //   769: getfield 1243	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   772: aload_3
    //   773: invokevirtual 1252	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   776: aload_0
    //   777: getfield 1243	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   780: aload_0
    //   781: invokevirtual 1253	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setTag	(Ljava/lang/Object;)V
    //   784: aload_0
    //   785: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   788: aload_1
    //   789: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   792: ldc_w 1254
    //   795: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   798: invokestatic 1257	rwv:a	(Landroid/widget/TextView;ILjava/lang/String;)V
    //   801: aload_0
    //   802: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   805: aload_3
    //   806: invokevirtual 1230	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   809: aload_0
    //   810: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   813: aload_0
    //   814: invokevirtual 955	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   817: aload_0
    //   818: getfield 1258	sjy:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   821: aload_3
    //   822: invokevirtual 1259	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   825: aload_0
    //   826: getfield 1258	sjy:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   829: aload_0
    //   830: invokevirtual 954	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   833: aload_1
    //   834: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   837: lconst_0
    //   838: lcmp
    //   839: ifgt +521 -> 1360
    //   842: aload_0
    //   843: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   846: ldc_w 1261
    //   849: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   852: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   855: aload_1
    //   856: invokestatic 472	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   859: ifeq +54 -> 913
    //   862: aload_1
    //   863: checkcast 469	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   866: getfield 1264	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoFileSize	J
    //   869: lconst_0
    //   870: lcmp
    //   871: iflt +42 -> 913
    //   874: aload_0
    //   875: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   878: new 414	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   885: aload_1
    //   886: checkcast 469	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   889: getfield 1264	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoFileSize	J
    //   892: invokestatic 729	rwv:b	(J)Ljava/lang/String;
    //   895: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc_w 1265
    //   901: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   904: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   913: aload_2
    //   914: invokevirtual 644	ped:a	()Lpeg;
    //   917: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   920: invokestatic 372	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   923: ifeq +476 -> 1399
    //   926: aload_0
    //   927: getfield 1267	sjy:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   930: iconst_0
    //   931: invokevirtual 378	android/widget/ImageView:setVisibility	(I)V
    //   934: aload_0
    //   935: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   938: bipush 8
    //   940: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   943: aload_0
    //   944: getfield 1268	sjy:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   947: iconst_0
    //   948: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   951: aload_0
    //   952: getfield 1269	sjy:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   955: iconst_0
    //   956: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   959: aload_0
    //   960: getfield 1270	sjy:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   963: bipush 8
    //   965: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   968: return
    //   969: aload_0
    //   970: getfield 1173	sjy:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   973: iconst_0
    //   974: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   977: aload_0
    //   978: getfield 1173	sjy:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   981: new 414	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   988: aload_1
    //   989: getfield 967	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   992: invokestatic 993	rwv:c	(I)Ljava/lang/String;
    //   995: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: ldc_w 1271
    //   1001: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   1004: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1013: goto -936 -> 77
    //   1016: astore 8
    //   1018: aload 8
    //   1020: invokevirtual 724	java/lang/Exception:printStackTrace	()V
    //   1023: goto -812 -> 211
    //   1026: aload_0
    //   1027: getfield 1189	sjy:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   1030: bipush 8
    //   1032: invokevirtual 334	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   1035: goto -824 -> 211
    //   1038: aload_0
    //   1039: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   1042: ldc_w 1273
    //   1045: invokestatic 612	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1048: aload_2
    //   1049: invokevirtual 644	ped:a	()Lpeg;
    //   1052: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1055: invokestatic 1276	twr:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   1058: invokestatic 1195	oyw:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   1061: goto -789 -> 272
    //   1064: aload_0
    //   1065: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   1068: aload_2
    //   1069: invokevirtual 644	ped:a	()Lpeg;
    //   1072: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1075: ldc_w 1277
    //   1078: invokevirtual 1219	android/content/Context:getString	(I)Ljava/lang/String;
    //   1081: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1084: goto -791 -> 293
    //   1087: aload_0
    //   1088: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   1091: aload_2
    //   1092: invokevirtual 644	ped:a	()Lpeg;
    //   1095: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1098: ldc_w 1278
    //   1101: invokevirtual 1219	android/content/Context:getString	(I)Ljava/lang/String;
    //   1104: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1107: goto -738 -> 369
    //   1110: astore 8
    //   1112: aload_0
    //   1113: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   1116: aload_2
    //   1117: invokevirtual 644	ped:a	()Lpeg;
    //   1120: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1123: ldc_w 1279
    //   1126: invokevirtual 1219	android/content/Context:getString	(I)Ljava/lang/String;
    //   1129: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1132: goto -763 -> 369
    //   1135: aload 5
    //   1137: getfield 1222	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   1140: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1143: ifne +18 -> 1161
    //   1146: aload_0
    //   1147: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   1150: aload 5
    //   1152: getfield 1222	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   1155: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1158: goto -761 -> 397
    //   1161: aload_0
    //   1162: getfield 1198	sjy:i	Landroid/widget/TextView;
    //   1165: aload_2
    //   1166: invokevirtual 644	ped:a	()Lpeg;
    //   1169: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1172: ldc_w 1279
    //   1175: invokevirtual 1219	android/content/Context:getString	(I)Ljava/lang/String;
    //   1178: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1181: goto -784 -> 397
    //   1184: astore 5
    //   1186: invokestatic 523	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1189: ifeq -749 -> 440
    //   1192: ldc_w 337
    //   1195: iconst_2
    //   1196: ldc_w 1281
    //   1199: aload 5
    //   1201: invokestatic 985	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1204: goto -764 -> 440
    //   1207: aload_0
    //   1208: getfield 1190	sjy:h	Landroid/widget/TextView;
    //   1211: bipush 8
    //   1213: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1216: aload_0
    //   1217: getfield 1203	sjy:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1220: bipush 8
    //   1222: invokevirtual 1206	android/widget/LinearLayout:setVisibility	(I)V
    //   1225: aload_0
    //   1226: getfield 1233	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1229: iconst_0
    //   1230: invokevirtual 1236	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   1233: aload_0
    //   1234: getfield 1238	sjy:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1237: iconst_0
    //   1238: invokevirtual 1206	android/widget/LinearLayout:setVisibility	(I)V
    //   1241: aload_0
    //   1242: getfield 1233	sjy:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   1245: aload_1
    //   1246: aload_2
    //   1247: invokevirtual 644	ped:a	()Lpeg;
    //   1250: invokevirtual 701	peg:a	()Lslt;
    //   1253: aload_2
    //   1254: invokevirtual 644	ped:a	()Lpeg;
    //   1257: invokevirtual 703	peg:b	()I
    //   1260: aload 5
    //   1262: invokevirtual 1285	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   1265: aload_0
    //   1266: getfield 1286	sjy:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1269: aload_3
    //   1270: invokevirtual 676	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1273: aload_0
    //   1274: getfield 1286	sjy:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1277: aload_0
    //   1278: invokevirtual 675	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1281: aload_0
    //   1282: getfield 1287	sjy:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1285: aload_3
    //   1286: invokevirtual 676	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1289: aload_0
    //   1290: getfield 1287	sjy:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1293: aload 4
    //   1295: invokevirtual 1288	android/widget/ImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1298: aload_0
    //   1299: getfield 1287	sjy:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1302: aload_0
    //   1303: invokevirtual 675	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1306: goto -800 -> 506
    //   1309: aload_0
    //   1310: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1313: aload_2
    //   1314: invokevirtual 644	ped:a	()Lpeg;
    //   1317: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1320: fconst_0
    //   1321: invokestatic 216	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   1324: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1327: aload_2
    //   1328: invokevirtual 644	ped:a	()Lpeg;
    //   1331: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1334: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1337: ldc_w 1289
    //   1340: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1343: astore 4
    //   1345: aload_0
    //   1346: getfield 1249	sjy:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1349: aload 4
    //   1351: aconst_null
    //   1352: aconst_null
    //   1353: aconst_null
    //   1354: invokevirtual 738	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1357: goto -589 -> 768
    //   1360: aload_0
    //   1361: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1364: new 414	java/lang/StringBuilder
    //   1367: dup
    //   1368: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   1371: aload_1
    //   1372: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   1375: invokestatic 729	rwv:b	(J)Ljava/lang/String;
    //   1378: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: ldc_w 1265
    //   1384: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   1387: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1396: goto -541 -> 855
    //   1399: aload_0
    //   1400: getfield 1267	sjy:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1403: bipush 8
    //   1405: invokevirtual 378	android/widget/ImageView:setVisibility	(I)V
    //   1408: aload_2
    //   1409: invokevirtual 644	ped:a	()Lpeg;
    //   1412: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1415: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1418: ldc_w 731
    //   1421: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1424: astore_3
    //   1425: aload_0
    //   1426: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1429: aload_3
    //   1430: aconst_null
    //   1431: aconst_null
    //   1432: aconst_null
    //   1433: invokevirtual 738	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1436: aload_0
    //   1437: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1440: ldc_w 739
    //   1443: aload_2
    //   1444: invokevirtual 644	ped:a	()Lpeg;
    //   1447: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1450: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1453: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   1456: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1459: aload_0
    //   1460: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1463: iconst_0
    //   1464: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1467: invokestatic 746	bgoa:a	()I
    //   1470: iconst_1
    //   1471: if_icmpne +44 -> 1515
    //   1474: aload_0
    //   1475: getfield 1260	sjy:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1478: ldc_w 1290
    //   1481: invokestatic 355	amtj:a	(I)Ljava/lang/String;
    //   1484: invokevirtual 594	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1487: aload_0
    //   1488: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1491: bipush 8
    //   1493: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1496: aload_0
    //   1497: getfield 1268	sjy:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1500: iconst_0
    //   1501: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   1504: aload_0
    //   1505: getfield 1269	sjy:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1508: iconst_0
    //   1509: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1512: goto -553 -> 959
    //   1515: invokestatic 751	bkwm:w	()Z
    //   1518: ifeq +311 -> 1829
    //   1521: aload_2
    //   1522: invokevirtual 644	ped:a	()Lpeg;
    //   1525: invokevirtual 753	peg:e	()Z
    //   1528: ifne +301 -> 1829
    //   1531: aload_0
    //   1532: getfield 1167	sjy:jdField_a_of_type_Int	I
    //   1535: ifne +294 -> 1829
    //   1538: invokestatic 755	bkwm:e	()Ljava/lang/String;
    //   1541: astore 4
    //   1543: invokestatic 757	bkwm:f	()Ljava/lang/String;
    //   1546: astore 5
    //   1548: invokestatic 759	bkwm:g	()Ljava/lang/String;
    //   1551: astore 7
    //   1553: aload 4
    //   1555: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1558: ifne +227 -> 1785
    //   1561: invokestatic 762	pay:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1564: astore 8
    //   1566: ldc 134
    //   1568: astore_3
    //   1569: aload 8
    //   1571: ifnull +9 -> 1580
    //   1574: aload 8
    //   1576: invokevirtual 767	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1579: astore_3
    //   1580: new 769	sie
    //   1583: dup
    //   1584: aconst_null
    //   1585: aconst_null
    //   1586: aconst_null
    //   1587: aconst_null
    //   1588: invokespecial 772	sie:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1591: aload_3
    //   1592: invokevirtual 775	sie:m	(Ljava/lang/String;)Lsie;
    //   1595: aload_1
    //   1596: getfield 99	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1599: invokevirtual 777	sie:i	(Ljava/lang/String;)Lsie;
    //   1602: invokevirtual 780	sie:a	()Lsid;
    //   1605: invokevirtual 784	sid:a	()Ljava/lang/String;
    //   1608: astore_1
    //   1609: aload_0
    //   1610: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1613: iconst_0
    //   1614: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1617: aload_0
    //   1618: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1621: fconst_2
    //   1622: aload_2
    //   1623: invokevirtual 644	ped:a	()Lpeg;
    //   1626: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1629: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1632: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   1635: invokevirtual 742	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1638: aload_2
    //   1639: invokevirtual 644	ped:a	()Lpeg;
    //   1642: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1645: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1648: ldc_w 785
    //   1651: invokevirtual 734	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1654: astore_3
    //   1655: aload_3
    //   1656: iconst_0
    //   1657: iconst_0
    //   1658: ldc_w 786
    //   1661: aload_2
    //   1662: invokevirtual 644	ped:a	()Lpeg;
    //   1665: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1668: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1671: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   1674: ldc_w 786
    //   1677: aload_2
    //   1678: invokevirtual 644	ped:a	()Lpeg;
    //   1681: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1684: invokevirtual 284	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1687: invokestatic 290	com/tencent/mobileqq/activity/aio/AIOUtils:dp2px	(FLandroid/content/res/Resources;)I
    //   1690: invokevirtual 791	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1693: aload_0
    //   1694: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1697: aconst_null
    //   1698: aconst_null
    //   1699: aload_3
    //   1700: aconst_null
    //   1701: invokevirtual 794	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1704: aload_2
    //   1705: invokevirtual 644	ped:a	()Lpeg;
    //   1708: invokevirtual 648	peg:a	()Landroid/content/Context;
    //   1711: aload_0
    //   1712: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1715: aload 5
    //   1717: aload 7
    //   1719: aload 4
    //   1721: new 1293	phf
    //   1724: dup
    //   1725: aload_1
    //   1726: aload_0
    //   1727: invokespecial 1296	phf:<init>	(Ljava/lang/String;Lsjy;)V
    //   1730: invokestatic 802	rwv:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1733: aload_0
    //   1734: getfield 1269	sjy:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1737: ldc_w 803
    //   1740: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1743: aload_0
    //   1744: getfield 1268	sjy:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1747: iconst_0
    //   1748: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   1751: aload_2
    //   1752: invokevirtual 644	ped:a	()Lpeg;
    //   1755: iconst_1
    //   1756: invokevirtual 806	peg:c	(Z)Lpeg;
    //   1759: pop
    //   1760: aconst_null
    //   1761: ldc 134
    //   1763: ldc_w 808
    //   1766: ldc_w 808
    //   1769: iconst_0
    //   1770: iconst_0
    //   1771: ldc 134
    //   1773: ldc 134
    //   1775: ldc 134
    //   1777: aload_1
    //   1778: iconst_0
    //   1779: invokestatic 813	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1782: goto -823 -> 959
    //   1785: aload_0
    //   1786: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1789: bipush 8
    //   1791: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1794: aload_0
    //   1795: getfield 1268	sjy:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1798: iconst_0
    //   1799: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   1802: aload_0
    //   1803: getfield 1269	sjy:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1806: iconst_0
    //   1807: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1810: invokestatic 523	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1813: ifeq -854 -> 959
    //   1816: ldc_w 815
    //   1819: iconst_2
    //   1820: ldc_w 817
    //   1823: invokestatic 819	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1826: goto -867 -> 959
    //   1829: aload_0
    //   1830: getfield 1291	sjy:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1833: bipush 8
    //   1835: invokevirtual 335	android/widget/TextView:setVisibility	(I)V
    //   1838: aload_0
    //   1839: getfield 1268	sjy:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1842: iconst_0
    //   1843: invokevirtual 303	android/view/View:setVisibility	(I)V
    //   1846: aload_0
    //   1847: getfield 1269	sjy:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1850: iconst_0
    //   1851: invokevirtual 714	android/view/View:setBackgroundColor	(I)V
    //   1854: goto -895 -> 959
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1857	0	paramsjy	sjy
    //   0	1857	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1857	2	paramped	ped
    //   0	1857	3	paramOnClickListener	View.OnClickListener
    //   0	1857	4	paramOnLongClickListener	View.OnLongClickListener
    //   0	1857	5	paramSet	java.util.Set<Long>
    //   309	443	6	i	int
    //   14	1704	7	localObject1	Object
    //   191	142	8	localObject2	Object
    //   1016	3	8	localException	Exception
    //   1110	1	8	localJSONException	JSONException
    //   1564	11	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   180	211	1016	java/lang/Exception
    //   311	366	1110	org/json/JSONException
    //   1087	1107	1110	org/json/JSONException
    //   397	440	1184	org/json/JSONException
  }
  
  public static void a(skd paramskd, BaseArticleInfo paramBaseArticleInfo, ped paramped, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramskd.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
    paramskd.jdField_g_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickListener);
    paramskd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramskd.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramskd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramskd.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramskd.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramskd.jdField_b_of_type_AndroidWidgetTextView.setText(rwv.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = paramped.a().a().getResources().getDrawable(2130843191);
    int i = ViewUtils.dpToPx(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, i, i);
    paramskd.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramskd.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0F));
    rwv.a(paramskd.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), amtj.a(2131711848), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramskd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false, paramped.a().a());
    paramskd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramskd);
    paramskd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramskd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    rwv.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramskd.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = paramskd.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramskd.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramskd.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramskd.jdField_f_of_type_AndroidWidgetTextView.setText(rwv.c(localBaseArticleInfo.mVideoPlayCount));
    paramskd.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramskd.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0F));
    rwv.a(paramskd.jdField_g_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), amtj.a(2131711837), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramskd.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false, paramped.a().a());
    paramskd.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramskd);
    paramskd.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramskd.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    rwv.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramskd.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phe
 * JD-Core Version:    0.7.0.1
 */