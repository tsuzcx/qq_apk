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

public class oms
  extends oml
{
  private onc jdField_a_of_type_Onc;
  private boolean jdField_a_of_type_Boolean;
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, qht paramqht)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)obj.a(paramContext, paramqht));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private static BaseArticleInfo b(oms paramoms, View paramView)
  {
    if ((paramoms == null) || (paramView == null) || (!(paramView.getTag() instanceof omw))) {
      return null;
    }
    paramView = (omw)paramView.getTag();
    if (paramView != null) {
      return paramoms.a(paramView.a());
    }
    return null;
  }
  
  private static omw b(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof omw))) {
      return null;
    }
    return (omw)paramView.getTag();
  }
  
  private static void b(oms paramoms, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = paramoms.a().a();
    String str = obz.c(paramBaseArticleInfo);
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
      paramoms = new qmv(obz.a(paramBaseArticleInfo.mAlgorithmID, obz.a(paramBaseArticleInfo), 0, i, j, badq.h(paramoms.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, obz.e(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      paramoms.h(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(new.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(obz.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).R(paramInt).r(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        paramoms.aa(paramVideoColumnInfo.a);
      }
      ndn.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramoms.a().a(), false);
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
    qtb localqtb;
    if ((paramView == null) || (!(paramView.getTag() instanceof ond)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((ond)localObject).a(paramInt, paramViewGroup);
      ((ond)localObject).f = paramView;
      ((ond)localObject).a = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131303150, a());
      paramViewGroup = new osm(a(), a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131313375, paramViewGroup);
      localqtb = new qtb(paramView);
      paramView.setTag(2131313378, localqtb);
      paramView.addOnAttachStateChangeListener(new omt(this, (ond)localObject));
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((ond)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localqtb.a();
      localObject = (ond)paramView.getTag();
      ((ond)localObject).a = paramInt;
      paramViewGroup = (ory)paramView.getTag(2131313375);
      localqtb = (qtb)paramView.getTag(2131313378);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((omy)localObject, localBaseArticleInfo);
      rnr.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new oqh(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131313373, localObject);
      paramViewGroup.a(localqtb, (opw)localObject, i);
      return localqtb.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((omz)localObject, localBaseArticleInfo, paramInt);
        rnr.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((onf)localObject, localBaseArticleInfo, paramInt);
        rnr.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((omx)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((omz)localObject, localBaseArticleInfo, paramInt);
        localObject = (ona)localObject;
        ((ona)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((ona)localObject).a(localBaseArticleInfo);
        ona.a((ona)localObject).setTag(localObject);
        ona.a((ona)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((omv)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((omu)localObject, localBaseArticleInfo, paramInt);
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
  
  public ond a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      return new omz(paramView, this);
    case 4: 
      return new omz(paramView, this);
    case 46: 
      return new omy(paramView, this);
    case 70: 
      return new onf(paramView, this);
    case 118: 
      return new omx(paramView, this);
    case 119: 
      return new ona(paramView, this);
    case 6: 
      return new omv(paramView, this);
    }
    return new omu(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Onc = new onc(this, null);
    this.jdField_a_of_type_Boolean = bgmq.d();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (obz.a(a(paramInt1))) && (b() == 56) && (this.jdField_a_of_type_Boolean) && (paramInt2 == 4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Onc != null) {
      this.jdField_a_of_type_Onc.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oms
 * JD-Core Version:    0.7.0.1
 */