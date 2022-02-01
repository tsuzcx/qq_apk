import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyPullToZoomHeaderXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DailyDianDianEntranceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Map;
import org.json.JSONObject;

public class orj
  extends oqu
  implements View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "readinjoy_daily_old_version_cache_deal";
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean jdField_b_of_type_Boolean = ((Boolean)bmhv.a(jdField_a_of_type_JavaLangString, Boolean.valueOf(false))).booleanValue();
  private static int e;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ReadInJoyDailyPullToZoomHeaderXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView;
  private DailyDianDianEntranceView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView;
  protected pvq a;
  private spg jdField_a_of_type_Spg;
  private sqd jdField_a_of_type_Sqd;
  private szd jdField_a_of_type_Szd;
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  
  public orj(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Pvq = new ork(this);
  }
  
  public static int a()
  {
    return e;
  }
  
  private int b()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private void b(ListView paramListView, szd paramszd)
  {
    TemplateBean localTemplateBean = null;
    JSONObject localJSONObject = plm.a();
    try
    {
      Object localObject = localJSONObject.optString("style_ID", "null");
      QLog.i("ReadInJoyDailyViewController", 1, "[initPTSFooterView] " + (String)localObject);
      localObject = tmh.a("default_feeds", true);
      if (localObject != null) {
        localTemplateBean = ((tmh)localObject).getTemplateBean(localJSONObject);
      }
      if (localTemplateBean != null)
      {
        paramszd = paramszd.a();
        paramszd = paramszd.getViewFactory().inflate(paramszd, localTemplateBean);
        piv.a(paramszd, null, localTemplateBean);
        paramszd.setTag(localTemplateBean);
        paramListView.addFooterView(paramszd);
        if ((paramListView instanceof ReadInJoyDailyXListView)) {
          ((ReadInJoyDailyXListView)paramListView).setPTSFooterView(paramszd);
        }
      }
      else
      {
        QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] template bean is null");
        return;
      }
    }
    catch (Exception paramListView)
    {
      QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] ", paramListView);
    }
  }
  
  private int c()
  {
    if (this.jdField_c_of_type_Int != -1) {
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_type", 0);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView = ((DailyDianDianEntranceView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131366229));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
      {
        if (syf.a().a()) {
          break label57;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.setVisibility(8);
        QLog.d("ReadInJoyDailyViewController", 1, "hide entry Icon");
      }
    }
    label57:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a(syf.a().a(a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView, this));
    } while (syf.a().a() != 1);
    RecommendFeedsDiandianEntranceManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
  }
  
  private void m()
  {
    if (e == 2) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setCanLoadMore(true);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.getOverScrollFooterView() != null) {
      return;
    }
    View localView = LayoutInflater.from(a()).inflate(2131560201, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setOverScrollFooter(localView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.a(new szn());
  }
  
  private void o()
  {
    qep localqep = pvj.a().a();
    if ((localqep != null) && (!jdField_b_of_type_Boolean)) {
      localqep.a(new orl(this, localqep));
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_Szd.a();
  }
  
  public spg a()
  {
    return this.jdField_a_of_type_Spg;
  }
  
  public void a()
  {
    super.a();
    sqp.a().a(a());
    this.jdField_a_of_type_Spg = new spg(a());
    e = plm.a();
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.jdField_d_of_type_Int, null, 2131560200);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView = ((ReadInJoyDailyPullToZoomHeaderXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378302));
    l();
    m();
    o();
    this.jdField_a_of_type_Szd = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    this.jdField_a_of_type_Sqd = new sqd((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381023), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Sqd);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      pvj.a().c();
    }
    b();
    uwl.a(8);
    pkd.a().a();
    pkd.a().a(String.valueOf(b()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(ListView paramListView, szd paramszd)
  {
    if ((paramListView != null) && (a() != 2)) {
      b(paramListView, paramszd);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_Boolean = true;
        super.b();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(b())), b(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_Boolean = false;
        super.c();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
      i();
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void d()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
    qep localqep = pvj.a().a();
    if (localqep != null) {
      localqep.a(null);
    }
    super.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
    {
      RecommendFeedsDiandianEntranceManager.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a();
    }
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.d();
    }
    sqp.a().b(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Szd.b();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
    if (!this.jdField_d_of_type_Boolean)
    {
      syf.a().a();
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    pvm.a().a(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    szc localszc = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localszc = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Spg != null) && (localszc != null))
    {
      spk localspk = this.jdField_a_of_type_Spg.a();
      if ((localspk != null) && (localspk.jdField_b_of_type_Boolean)) {
        localszc.f();
      }
    }
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.d(b());
    }
    pvm.a().a(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).l();
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(true, 1);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orj
 * JD-Core Version:    0.7.0.1
 */