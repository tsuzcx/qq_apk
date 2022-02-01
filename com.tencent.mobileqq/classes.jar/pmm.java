import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;

public class pmm
  extends pmk
  implements oif
{
  private int jdField_a_of_type_Int = -1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bduz jdField_a_of_type_Bduz;
  private oom jdField_a_of_type_Oom;
  private pmp jdField_a_of_type_Pmp = new pmp(this);
  private qgg jdField_a_of_type_Qgg;
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
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366582));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    oid.a().a(b(), (pmm)((ReadInJoyListViewGroup)a()).a());
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369138));
    if ((b() == 0) && (bnrf.j()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, bhtq.a(34.0F), bhtq.a(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new pmo(this));
  }
  
  private void b(List<oor> paramList)
  {
    if (this.jdField_a_of_type_Oom == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_Oom.a(true);
      this.jdField_a_of_type_Oom.a((oor)paramList.get(0));
      return;
    }
    this.jdField_a_of_type_Oom.a(false);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Oom != null) && ((a() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.jdField_a_of_type_Oom.a();
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
      if (b() != pox.a()) {
        break label100;
      }
      uae.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      uae.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      uae.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      uae.a("KANDIAN_FEEDS_COST", null);
      if (b() == 56) {
        uae.a("video_tab_cost", null);
      }
      if (this.c)
      {
        this.c = false;
        if (b() != pox.a()) {
          break;
        }
        uae.a("recommend_tab_cost", null);
      }
      return;
      label100:
      switch (b())
      {
      default: 
        break;
      case 0: 
        uae.jdField_a_of_type_Int = 1;
        break;
      case 56: 
        uae.jdField_a_of_type_Int = 2;
        break;
      case 70: 
        uae.jdField_a_of_type_Int = 3;
      }
    }
    switch (b())
    {
    default: 
      return;
    case 0: 
      uae.a("recommend_tab_cost", null);
      return;
    case 56: 
      uae.a("video_tab_cost", null);
      return;
    }
    uae.a("subscribe_tab_cost", null);
  }
  
  private void n()
  {
    sel localsel = a();
    if ((localsel != null) && (localsel.a() != null)) {
      pgk.a.a(localsel, localsel.a());
    }
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
    this.jdField_a_of_type_Pmp.a();
    if ((this.jdField_a_of_type_Qgg != null) && (qgg.a(localArticleInfo1)))
    {
      paramViewGroup = new pqk(a(), localArticleInfo1, j, b(), c(), paramInt, a(), d(), localArticleInfo2, a());
      paramViewGroup = this.jdField_a_of_type_Qgg.a(paramView, localArticleInfo1, paramInt, paramViewGroup);
    }
    label254:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewGroup;
            if ((j == 123) && (!oyj.a(a().a(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!oyj.a(j))) {
                break label254;
              }
              l = System.currentTimeMillis();
              paramView = pmp.a(this.jdField_a_of_type_Pmp, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              tkb.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!pmp.a(this.jdField_a_of_type_Pmp).a(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = pmp.b(this.jdField_a_of_type_Pmp, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            tkb.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = pmp.a(this.jdField_a_of_type_Pmp, paramView, localArticleInfo1, paramInt);
          tkb.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!qje.a(j));
      long l = System.currentTimeMillis();
      paramView = pmp.a(this.jdField_a_of_type_Pmp, paramView, localArticleInfo1, j, paramInt);
      tkb.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
      paramViewGroup = paramView;
    } while (localArticleInfo1 == null);
    QLog.d("FrameworkHandler", 2, "article is cellRebuildView: " + localArticleInfo1.mTitle);
    return paramView;
  }
  
  public void a()
  {
    super.a();
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    super.a(paramInt, paramList);
    if (this.jdField_a_of_type_Oom != null) {
      this.jdField_a_of_type_Oom.b();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(paramView);
    b(paramView);
    PTSDeviceUtil.init(a());
    if (qhv.a().a()) {
      this.jdField_a_of_type_Qgg = new qgg(a(), a());
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((b() == 0) || (pbd.c(b()))) {
      pfs.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    if ((b() == 0) || (pbd.c(b()))) {
      pfs.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)a((int)paramLong);
    if ((pbd.c(b())) || (b() == 0))
    {
      pfs.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      qrn.a().a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
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
    pgh localpgh;
    if ((b() == 0) || (pbd.c(b())))
    {
      localpgh = pfs.a().a;
      if (a() == null) {
        break label54;
      }
    }
    label54:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpgh.onScrollStateChanged(localListView, 6);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    if (this.jdField_a_of_type_Oom != null) {
      this.jdField_a_of_type_Oom.a();
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_Pmp.a();
    if (tpr.a(paramInt)) {}
    while ((!oyj.a(paramInt)) && (!pmp.a(this.jdField_a_of_type_Pmp).a(paramInt)) && (38 != paramInt) && (!qje.a(paramInt)) && (!qgg.a(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.c = true;
    omj.b(b());
    if (this.jdField_a_of_type_Oom != null) {
      this.jdField_a_of_type_Oom.d();
    }
    n();
  }
  
  public void b(int paramInt, List<oor> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onRijChannelBannerRefreshed], channelId = ").append(paramInt).append(", list size = ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.i("FrameworkHandler", 1, i);
      if (paramInt == b()) {
        break;
      }
      QLog.i("FrameworkHandler", 1, "[onRijChannelBannerRefreshed], do not refresh, current channel id = " + b());
      return;
    }
    ozs.b().post(new FrameworkHandler.2(this, paramList));
  }
  
  public void b(View paramView, ListView paramListView)
  {
    super.b(paramView, paramListView);
    if (qhv.a().a())
    {
      this.jdField_a_of_type_Oom = new oom(b(), a());
      if ((this.jdField_a_of_type_Oom.a() != null) && ((a() instanceof ListView)))
      {
        ((ListView)a()).addHeaderView(this.jdField_a_of_type_Oom.a(), 2);
        this.jdField_a_of_type_Bduz = new pmn(this);
        bduy.a(this.jdField_a_of_type_Bduz);
      }
    }
  }
  
  public void c()
  {
    omj.a(b());
    rky.a().a();
    pgh localpgh;
    if ((b() == 0) || (pbd.c(b())))
    {
      localpgh = pfs.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpgh.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void e()
  {
    oid.a().b(b(), this);
    if (this.jdField_a_of_type_Qgg != null) {
      this.jdField_a_of_type_Qgg.a();
    }
    i();
    j();
  }
  
  public void f()
  {
    m();
    pgh localpgh;
    if ((b() == 0) || (pbd.c(b())))
    {
      localpgh = pfs.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpgh.a(4, localListView);
      return;
    }
  }
  
  public void h()
  {
    super.h();
    if ((b() == 0) || (pbd.c(b()))) {
      pfs.a().a.a();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Oom != null) {
      this.jdField_a_of_type_Oom.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bduz != null) {
      bduy.b(this.jdField_a_of_type_Bduz);
    }
  }
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmm
 * JD-Core Version:    0.7.0.1
 */