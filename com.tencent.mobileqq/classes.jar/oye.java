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

public class oye
  extends oxx
{
  private oyo jdField_a_of_type_Oyo;
  private boolean jdField_a_of_type_Boolean;
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, qtv paramqtv)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)omr.a(paramContext, paramqtv));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private static BaseArticleInfo b(oye paramoye, View paramView)
  {
    if ((paramoye == null) || (paramView == null) || (!(paramView.getTag() instanceof oyi))) {
      return null;
    }
    paramView = (oyi)paramView.getTag();
    if (paramView != null) {
      return paramoye.a(paramView.a());
    }
    return null;
  }
  
  private static oyi b(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof oyi))) {
      return null;
    }
    return (oyi)paramView.getTag();
  }
  
  private static void b(oye paramoye, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = paramoye.a().a();
    String str = onh.c(paramBaseArticleInfo);
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
      paramoye = new qzb(onh.a(paramBaseArticleInfo.mAlgorithmID, onh.a(paramBaseArticleInfo), 0, i, j, bbfj.h(paramoye.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, onh.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      paramoye.h(paramBaseArticleInfo.innerUniqueID).a(k).e(paramBaseArticleInfo.mStrategyId).h(npu.a).i(409409).k(paramBaseArticleInfo.mVideoAdsJumpType).l(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(onh.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).S(paramInt).r(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        paramoye.ab(paramVideoColumnInfo.a);
      }
      nol.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramoye.a().a(), false);
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
    rfk localrfk;
    if ((paramView == null) || (!(paramView.getTag() instanceof oyp)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((oyp)localObject).a(paramInt, paramViewGroup);
      ((oyp)localObject).f = paramView;
      ((oyp)localObject).a = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131368790, a());
      paramViewGroup = new pdl(a(), a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131379215, paramViewGroup);
      localrfk = new rfk(paramView);
      paramView.setTag(2131379218, localrfk);
      paramView.addOnAttachStateChangeListener(new oyf(this, (oyp)localObject));
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((oyp)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localrfk.a();
      localObject = (oyp)paramView.getTag();
      ((oyp)localObject).a = paramInt;
      paramViewGroup = (pcx)paramView.getTag(2131379215);
      localrfk = (rfk)paramView.getTag(2131379218);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((oyk)localObject, localBaseArticleInfo);
      saf.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new pbf(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131379213, localObject);
      paramViewGroup.a(localrfk, (pau)localObject, i);
      return localrfk.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((oyl)localObject, localBaseArticleInfo, paramInt);
        saf.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((oyr)localObject, localBaseArticleInfo, paramInt);
        saf.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((oyj)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((oyl)localObject, localBaseArticleInfo, paramInt);
        localObject = (oym)localObject;
        ((oym)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((oym)localObject).a(localBaseArticleInfo);
        oym.a((oym)localObject).setTag(localObject);
        oym.a((oym)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((oyh)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((oyg)localObject, localBaseArticleInfo, paramInt);
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
  
  public oyp a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      return new oyl(paramView, this);
    case 4: 
      return new oyl(paramView, this);
    case 46: 
      return new oyk(paramView, this);
    case 70: 
      return new oyr(paramView, this);
    case 118: 
      return new oyj(paramView, this);
    case 119: 
      return new oym(paramView, this);
    case 6: 
      return new oyh(paramView, this);
    }
    return new oyg(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Oyo = new oyo(this, null);
    this.jdField_a_of_type_Boolean = bhvy.d();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (onh.a(a(paramInt1))) && (b() == 56) && (this.jdField_a_of_type_Boolean) && (paramInt2 == 4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Oyo != null) {
      this.jdField_a_of_type_Oyo.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oye
 * JD-Core Version:    0.7.0.1
 */