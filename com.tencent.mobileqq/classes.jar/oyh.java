import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class oyh
  extends oya
{
  private oyr jdField_a_of_type_Oyr;
  private boolean jdField_a_of_type_Boolean;
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, qty paramqty)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)omu.a(paramContext, paramqty));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private static BaseArticleInfo b(oyh paramoyh, View paramView)
  {
    if ((paramoyh == null) || (paramView == null) || (!(paramView.getTag() instanceof oyl))) {
      return null;
    }
    paramView = (oyl)paramView.getTag();
    if (paramView != null) {
      return paramoyh.a(paramView.a());
    }
    return null;
  }
  
  private static oyl b(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof oyl))) {
      return null;
    }
    return (oyl)paramView.getTag();
  }
  
  private static void b(oyh paramoyh, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = paramoyh.a().a();
    String str = onk.c(paramBaseArticleInfo);
    int i;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label217;
      }
    }
    label217:
    for (int j = 0;; j = 1)
    {
      paramoyh = new qze(onk.a(paramBaseArticleInfo.mAlgorithmID, onk.a(paramBaseArticleInfo), 0, i, j, bbev.h(paramoyh.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, onk.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      paramoyh.h(paramBaseArticleInfo.innerUniqueID).a(k).e(paramBaseArticleInfo.mStrategyId).h(npx.a).i(409409).k(paramBaseArticleInfo.mVideoAdsJumpType).l(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(onk.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).S(paramInt).r(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        paramoyh.ab(paramVideoColumnInfo.a);
      }
      noo.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramoyh.a().a(), false);
      return;
      i = 0;
      break;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    Object localObject;
    rfn localrfn;
    if ((paramView == null) || (!(paramView.getTag() instanceof oys)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((oys)localObject).a(paramInt, paramViewGroup);
      ((oys)localObject).f = paramView;
      ((oys)localObject).a = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131368790, a());
      paramViewGroup = new pdo(a(), a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131379210, paramViewGroup);
      localrfn = new rfn(paramView);
      paramView.setTag(2131379213, localrfn);
      paramView.addOnAttachStateChangeListener(new oyi(this, (oys)localObject));
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((oys)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localrfn.a();
      localObject = (oys)paramView.getTag();
      ((oys)localObject).a = paramInt;
      paramViewGroup = (pda)paramView.getTag(2131379210);
      localrfn = (rfn)paramView.getTag(2131379213);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((oyn)localObject, localBaseArticleInfo);
      sai.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new pbi(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131379208, localObject);
      paramViewGroup.a(localrfn, (pax)localObject, i);
      return localrfn.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((oyo)localObject, localBaseArticleInfo, paramInt);
        sai.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((oyu)localObject, localBaseArticleInfo, paramInt);
        sai.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((oym)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((oyo)localObject, localBaseArticleInfo, paramInt);
        localObject = (oyp)localObject;
        ((oyp)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((oyp)localObject).a(localBaseArticleInfo);
        oyp.a((oyp)localObject).setTag(localObject);
        oyp.a((oyp)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((oyk)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((oyj)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((a().a() != null) && (a().a().a() != null) && (a().a().a().a()))
    {
      a().a().a().g();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public oys a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      return new oyo(paramView, this);
    case 4: 
      return new oyo(paramView, this);
    case 46: 
      return new oyn(paramView, this);
    case 70: 
      return new oyu(paramView, this);
    case 118: 
      return new oym(paramView, this);
    case 119: 
      return new oyp(paramView, this);
    case 6: 
      return new oyk(paramView, this);
    }
    return new oyj(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Oyr = new oyr(this, null);
    this.jdField_a_of_type_Boolean = bhvh.d();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (onk.a(a(paramInt1))) && (b() == 56) && (this.jdField_a_of_type_Boolean) && (paramInt2 == 4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Oyr != null) {
      this.jdField_a_of_type_Oyr.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyh
 * JD-Core Version:    0.7.0.1
 */