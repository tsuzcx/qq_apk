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

public class puf
  extends ptx
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private pup jdField_a_of_type_Pup;
  private boolean b;
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, sey paramsey)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)pgk.a(paramContext, paramsey));
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
      if ((paramView.getTag() instanceof puq)) {
        localView1 = ((puq)paramView.getTag()).f;
      }
      localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = localView1;
        if ((paramView.getTag(2131376086) instanceof puq)) {
          localView2 = ((puq)paramView.getTag(2131376086)).f;
        }
      }
    } while (localView2 == null);
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private static BaseArticleInfo b(puf parampuf, View paramView)
  {
    if ((parampuf == null) || (paramView == null) || (!(paramView.getTag() instanceof puj))) {
      return null;
    }
    paramView = (puj)paramView.getTag();
    if (paramView != null) {
      return parampuf.a(paramView.a());
    }
    return null;
  }
  
  private static puj b(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof puj))) {
      return null;
    }
    return (puj)paramView.getTag();
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private static void b(puf parampuf, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = parampuf.a().a();
    String str = pha.d(paramBaseArticleInfo);
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
      parampuf = new skc(pha.a(paramBaseArticleInfo.mAlgorithmID, pha.a(paramBaseArticleInfo), 0, i, j, bgnt.h(parampuf.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pha.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      parampuf.h(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(och.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(pha.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).R(paramInt).o(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        parampuf.Y(paramVideoColumnInfo.a);
      }
      oat.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", parampuf.a().a(), false);
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
    stc localstc;
    if ((paramView == null) || (!(paramView.getTag() instanceof puq)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((puq)localObject).a(paramInt, paramViewGroup);
      ((puq)localObject).f = paramView;
      ((puq)localObject).a = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131369412, a());
      paramViewGroup = new qaz(a(), a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131380931, paramViewGroup);
      localstc = new stc(paramView);
      paramView.setTag(2131380935, localstc);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((puq)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localstc.a();
      localObject = (puq)paramView.getTag();
      ((puq)localObject).a = paramInt;
      paramViewGroup = (qal)paramView.getTag(2131380931);
      localstc = (stc)paramView.getTag(2131380935);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((pul)localObject, localBaseArticleInfo);
      ttf.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new pya(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131380929, localObject);
      paramViewGroup.a(localstc, (pxk)localObject, i);
      return localstc.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((pum)localObject, localBaseArticleInfo, paramInt);
        ttf.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((pur)localObject, localBaseArticleInfo, paramInt);
        ttf.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((puk)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((pum)localObject, localBaseArticleInfo, paramInt);
        localObject = (pun)localObject;
        ((pun)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((pun)localObject).a(localBaseArticleInfo);
        pun.a((pun)localObject).setTag(localObject);
        pun.a((pun)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((pui)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((puh)localObject, localBaseArticleInfo, paramInt);
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
  
  public puq a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      return new pum(paramView, this);
    case 4: 
      return new pum(paramView, this);
    case 46: 
      return new pul(paramView, this);
    case 70: 
      return new pur(paramView, this);
    case 118: 
      return new puk(paramView, this);
    case 119: 
      return new pun(paramView, this);
    case 6: 
      return new pui(paramView, this);
    }
    return new puh(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_Pup = new pup(this, null);
    this.b = bmqa.e();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (pha.a(a(paramInt1))) && (b() == 56) && (this.b) && (paramInt2 == 4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Pup != null) {
      this.jdField_a_of_type_Pup.removeCallbacksAndMessages(null);
    }
  }
  
  public void g()
  {
    super.g();
    QQAppInterface localQQAppInterface = pha.a();
    if ((localQQAppInterface != null) && (!jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      ((avju)localQQAppInterface.getManager(306)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puf
 * JD-Core Version:    0.7.0.1
 */