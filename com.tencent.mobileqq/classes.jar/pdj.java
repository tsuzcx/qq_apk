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

public class pdj
  extends pdc
{
  private pdt jdField_a_of_type_Pdt;
  private boolean jdField_a_of_type_Boolean;
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, rjk paramrjk)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)orc.a(paramContext, paramrjk));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private static BaseArticleInfo b(pdj parampdj, View paramView)
  {
    if ((parampdj == null) || (paramView == null) || (!(paramView.getTag() instanceof pdn))) {
      return null;
    }
    paramView = (pdn)paramView.getTag();
    if (paramView != null) {
      return parampdj.a(paramView.a());
    }
    return null;
  }
  
  private static pdn b(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof pdn))) {
      return null;
    }
    return (pdn)paramView.getTag();
  }
  
  private static void b(pdj parampdj, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = parampdj.a().a();
    String str = ors.d(paramBaseArticleInfo);
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
      parampdj = new ron(ors.a(paramBaseArticleInfo.mAlgorithmID, ors.a(paramBaseArticleInfo), 0, i, j, bdin.h(parampdj.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ors.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      parampdj.h(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(ntd.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(ors.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).R(paramInt).r(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        parampdj.aa(paramVideoColumnInfo.a);
      }
      nrt.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", parampdj.a().a(), false);
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
    rvg localrvg;
    if ((paramView == null) || (!(paramView.getTag() instanceof pdu)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((pdu)localObject).a(paramInt, paramViewGroup);
      ((pdu)localObject).f = paramView;
      ((pdu)localObject).a = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131369027, a());
      paramViewGroup = new pjn(a(), a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131379973, paramViewGroup);
      localrvg = new rvg(paramView);
      paramView.setTag(2131379976, localrvg);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((pdu)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localrvg.a();
      localObject = (pdu)paramView.getTag();
      ((pdu)localObject).a = paramInt;
      paramViewGroup = (piz)paramView.getTag(2131379973);
      localrvg = (rvg)paramView.getTag(2131379976);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((pdp)localObject, localBaseArticleInfo);
      srq.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new pgq(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131379971, localObject);
      paramViewGroup.a(localrvg, (pgd)localObject, i);
      return localrvg.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((pdq)localObject, localBaseArticleInfo, paramInt);
        srq.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((pdv)localObject, localBaseArticleInfo, paramInt);
        srq.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((pdo)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((pdq)localObject, localBaseArticleInfo, paramInt);
        localObject = (pdr)localObject;
        ((pdr)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((pdr)localObject).a(localBaseArticleInfo);
        pdr.a((pdr)localObject).setTag(localObject);
        pdr.a((pdr)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((pdm)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((pdl)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((a().a() != null) && (a().a().a() != null) && (a().a().a().a()))
    {
      a().a().a().i();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public pdu a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      return new pdq(paramView, this);
    case 4: 
      return new pdq(paramView, this);
    case 46: 
      return new pdp(paramView, this);
    case 70: 
      return new pdv(paramView, this);
    case 118: 
      return new pdo(paramView, this);
    case 119: 
      return new pdr(paramView, this);
    case 6: 
      return new pdm(paramView, this);
    }
    return new pdl(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Pdt = new pdt(this, null);
    this.jdField_a_of_type_Boolean = bkbq.d();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (ors.a(a(paramInt1))) && (b() == 56) && (this.jdField_a_of_type_Boolean) && (paramInt2 == 4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Pdt != null) {
      this.jdField_a_of_type_Pdt.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdj
 * JD-Core Version:    0.7.0.1
 */