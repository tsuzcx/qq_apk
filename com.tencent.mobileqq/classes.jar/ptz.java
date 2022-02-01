import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;

public class ptz
  extends ptx
  implements ogx
{
  private int jdField_a_of_type_Int = -1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdci jdField_a_of_type_Bdci;
  private ovz jdField_a_of_type_Ovz;
  private puc jdField_a_of_type_Puc = new puc(this);
  private qnu jdField_a_of_type_Qnu;
  public boolean a;
  public boolean b;
  private boolean c = true;
  
  private void a(int paramInt) {}
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366533));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    ogv.a().a(b(), (ptz)((ReadInJoyListViewGroup)a()).a());
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369049));
    if ((b() == 0) && (bmqa.j()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, bgtn.a(34.0F), bgtn.a(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new pub(this));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ovz != null) && ((a() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.jdField_a_of_type_Ovz.a();
      ListView localListView = (ListView)a();
      if (paramBoolean) {
        localListView.removeHeaderView(localRIJChannelBannerView);
      }
    }
  }
  
  private void m()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = false;
      if (b() != pwl.a()) {
        break label100;
      }
      uac.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      uac.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      uac.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      uac.a("KANDIAN_FEEDS_COST", null);
      if (b() == 56) {
        uac.a("video_tab_cost", null);
      }
      if (this.c)
      {
        this.c = false;
        if (b() != pwl.a()) {
          break;
        }
        uac.a("recommend_tab_cost", null);
      }
      return;
      label100:
      switch (b())
      {
      default: 
        break;
      case 0: 
        uac.jdField_a_of_type_Int = 1;
        break;
      case 56: 
        uac.jdField_a_of_type_Int = 2;
        break;
      case 70: 
        uac.jdField_a_of_type_Int = 3;
      }
    }
    switch (b())
    {
    default: 
      return;
    case 0: 
      uac.a("recommend_tab_cost", null);
      return;
    case 56: 
      uac.a("video_tab_cost", null);
      return;
    }
    uac.a("subscribe_tab_cost", null);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int j = a(paramInt).intValue();
    ArticleInfo localArticleInfo1 = (ArticleInfo)a(paramInt);
    ArticleInfo localArticleInfo2 = (ArticleInfo)a(paramInt + 1);
    if (localArticleInfo1 != null) {
      localArticleInfo1.mResolvedFeedType = j;
    }
    paramViewGroup = null;
    this.jdField_a_of_type_Puc.a();
    if ((this.jdField_a_of_type_Qnu != null) && (qnu.a(localArticleInfo1)))
    {
      paramViewGroup = new pya(a(), localArticleInfo1, j, b(), c(), paramInt, a(), d(), localArticleInfo2, a());
      paramViewGroup = this.jdField_a_of_type_Qnu.a(paramView, localArticleInfo1, paramInt, paramViewGroup);
    }
    label250:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewGroup;
            if ((j == 123) && (!pfr.a(a().a(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!pfr.a(j))) {
                break label250;
              }
              l = System.currentTimeMillis();
              paramView = puc.a(this.jdField_a_of_type_Puc, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              ttf.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!puc.a(this.jdField_a_of_type_Puc).a(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = puc.b(this.jdField_a_of_type_Puc, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            ttf.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = puc.a(this.jdField_a_of_type_Puc, paramView, localArticleInfo1, paramInt);
          ttf.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!qqq.a(j));
      long l = System.currentTimeMillis();
      paramView = puc.a(this.jdField_a_of_type_Puc, paramView, localArticleInfo1, j, paramInt);
      ttf.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
      paramViewGroup = paramView;
    } while (localArticleInfo1 == null);
    QLog.d("FrameworkHandler", 2, "article is cellRebuildView: " + localArticleInfo1.mTitle);
    return paramView;
  }
  
  public void a()
  {
    this.c = true;
    otw.b(b());
    if (this.jdField_a_of_type_Ovz != null) {
      this.jdField_a_of_type_Ovz.d();
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    super.a(paramInt, paramList);
    if (this.jdField_a_of_type_Ovz != null) {
      this.jdField_a_of_type_Ovz.b();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(paramView);
    b(paramView);
    PTSDeviceUtil.init(a());
    if (qph.a().a()) {
      this.jdField_a_of_type_Qnu = new qnu(a(), a());
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((b() == 0) || (pil.c(b()))) {
      pmy.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    if ((b() == 0) || (pil.c(b()))) {
      pmy.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)a((int)paramLong);
    if ((pil.c(b())) || (b() == 0))
    {
      pmy.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      rat.a().a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.b = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = true;
    pnn localpnn;
    if ((b() == 0) || (pil.c(b())))
    {
      localpnn = pmy.a().a;
      if (a() == null) {
        break label54;
      }
    }
    label54:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpnn.onScrollStateChanged(localListView, 6);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    if (this.jdField_a_of_type_Ovz != null) {
      this.jdField_a_of_type_Ovz.a();
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_Puc.a();
    if (oqb.a(paramInt)) {}
    while ((!pfr.a(paramInt)) && (!puc.a(this.jdField_a_of_type_Puc).a(paramInt)) && (38 != paramInt) && (!qqq.a(paramInt)) && (!qnu.a(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    otw.a(b());
    ruc.a().a();
    pnn localpnn;
    if ((b() == 0) || (pil.c(b())))
    {
      localpnn = pmy.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpnn.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void b(int paramInt, List<owd> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onRijChannelBannerRefreshed], channelId = ").append(paramInt).append(", list size = ");
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      QLog.i("FrameworkHandler", 1, i);
      if (paramInt == b()) {
        break label94;
      }
      QLog.i("FrameworkHandler", 1, "[onRijChannelBannerRefreshed], do not refresh, current channel id = " + b());
    }
    label94:
    while ((paramList == null) || (paramList.size() <= 0) || (this.jdField_a_of_type_Ovz == null))
    {
      return;
      i = 0;
      break;
    }
    this.jdField_a_of_type_Ovz.a((owd)paramList.get(0));
  }
  
  public void b(View paramView, ListView paramListView)
  {
    super.b(paramView, paramListView);
    if (qph.a().a())
    {
      this.jdField_a_of_type_Ovz = new ovz(b(), a());
      if ((this.jdField_a_of_type_Ovz.a() != null) && ((a() instanceof ListView)))
      {
        ((ListView)a()).addHeaderView(this.jdField_a_of_type_Ovz.a(), 2);
        this.jdField_a_of_type_Bdci = new pua(this);
        bdch.a(this.jdField_a_of_type_Bdci);
      }
    }
  }
  
  public void c()
  {
    super.c();
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void d()
  {
    ogv.a().b(b(), this);
    if (this.jdField_a_of_type_Qnu != null) {
      this.jdField_a_of_type_Qnu.a();
    }
    i();
    j();
  }
  
  public void g()
  {
    m();
    pnn localpnn;
    if ((b() == 0) || (pil.c(b())))
    {
      localpnn = pmy.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpnn.a(4, localListView);
      return;
    }
  }
  
  public void h()
  {
    super.h();
    if ((b() == 0) || (pil.c(b()))) {
      pmy.a().a.a();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ovz != null) {
      this.jdField_a_of_type_Ovz.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bdci != null) {
      bdch.b(this.jdField_a_of_type_Bdci);
    }
  }
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptz
 * JD-Core Version:    0.7.0.1
 */