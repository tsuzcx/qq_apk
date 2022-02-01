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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

public class pms
  extends pmk
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private pnc jdField_a_of_type_Pnc;
  private boolean b;
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, rwc paramrwc)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)ozc.a(paramContext, paramrwc));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    View localView2;
    do
    {
      return;
      View localView1 = null;
      if ((paramView.getTag() instanceof pnd)) {
        localView1 = ((pnd)paramView.getTag()).f;
      }
      localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = localView1;
        if ((paramView.getTag(2131376226) instanceof pnd)) {
          localView2 = ((pnd)paramView.getTag(2131376226)).f;
        }
      }
    } while (localView2 == null);
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private static BaseArticleInfo b(pms parampms, View paramView)
  {
    if ((parampms == null) || (paramView == null) || (!(paramView.getTag() instanceof pmw))) {
      return null;
    }
    paramView = (pmw)paramView.getTag();
    if (paramView != null) {
      return parampms.a(paramView.a());
    }
    return null;
  }
  
  private static pmw b(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof pmw))) {
      return null;
    }
    return (pmw)paramView.getTag();
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private static void b(pms parampms, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = parampms.a().a();
    String str = ozs.d(paramBaseArticleInfo);
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
      parampms = new sbg(ozs.a(paramBaseArticleInfo.mAlgorithmID, ozs.a(paramBaseArticleInfo), 0, i, j, bhnv.h(parampms.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ozs.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      parampms.i(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(odr.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(ozs.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).Q(paramInt).p(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        parampms.X(paramVideoColumnInfo.a);
      }
      ocd.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", parampms.a().a(), false);
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
    skg localskg;
    if ((paramView == null) || (!(paramView.getTag() instanceof pnd)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((pnd)localObject).a(paramInt, paramViewGroup);
      ((pnd)localObject).f = paramView;
      ((pnd)localObject).a = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131369503, a());
      paramViewGroup = new ptk(a(), a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131381111, paramViewGroup);
      localskg = new skg(paramView);
      paramView.setTag(2131381115, localskg);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((pnd)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localskg.a();
      localObject = (pnd)paramView.getTag();
      ((pnd)localObject).a = paramInt;
      paramViewGroup = (psw)paramView.getTag(2131381111);
      localskg = (skg)paramView.getTag(2131381115);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((pmy)localObject, localBaseArticleInfo);
      tkb.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new pqk(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131381109, localObject);
      paramViewGroup.a(localskg, (ppu)localObject, i);
      return localskg.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((pmz)localObject, localBaseArticleInfo, paramInt);
        tkb.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((pne)localObject, localBaseArticleInfo, paramInt);
        tkb.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((pmx)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((pmz)localObject, localBaseArticleInfo, paramInt);
        localObject = (pna)localObject;
        ((pna)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((pna)localObject).a(localBaseArticleInfo);
        pna.a((pna)localObject).setTag(localObject);
        pna.a((pna)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((pmv)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((pmu)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public Boolean a()
  {
    if ((a().a() != null) && (a().a().a() != null) && (a().a().a().a()))
    {
      a().a().a().j();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public pnd a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      return new pmz(paramView, this);
    case 4: 
      return new pmz(paramView, this);
    case 46: 
      return new pmy(paramView, this);
    case 70: 
      return new pne(paramView, this);
    case 118: 
      return new pmx(paramView, this);
    case 119: 
      return new pna(paramView, this);
    case 6: 
      return new pmv(paramView, this);
    }
    return new pmu(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Pnc = new pnc(this, null);
    this.b = bnrf.e();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (ozs.a(a(paramInt1))) && (b() == 56) && (this.b) && (paramInt2 == 4);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Pnc != null) {
      this.jdField_a_of_type_Pnc.removeCallbacksAndMessages(null);
    }
  }
  
  public void f()
  {
    super.f();
    QQAppInterface localQQAppInterface = ozs.a();
    if ((localQQAppInterface != null) && (!jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      ((awcc)localQQAppInterface.getManager(306)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pms
 * JD-Core Version:    0.7.0.1
 */