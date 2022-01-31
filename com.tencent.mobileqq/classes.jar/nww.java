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

public class nww
  extends nwi
  implements View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "readinjoy_daily_old_version_cache_deal";
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean jdField_b_of_type_Boolean = ((Boolean)bkbq.a(jdField_a_of_type_JavaLangString, Boolean.valueOf(false))).booleanValue();
  private static int e;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ReadInJoyDailyPullToZoomHeaderXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView;
  private DailyDianDianEntranceView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView;
  protected oxe a;
  private rjg jdField_a_of_type_Rjg;
  private rkp jdField_a_of_type_Rkp;
  private rqj jdField_a_of_type_Rqj;
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  
  public nww(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Oxe = new nwx(this);
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
  
  private void b(ListView paramListView, rqj paramrqj)
  {
    TemplateBean localTemplateBean = null;
    JSONObject localJSONObject = otf.a();
    try
    {
      Object localObject = localJSONObject.optString("style_ID", "null");
      QLog.i("ReadInJoyDailyViewController", 1, "[initPTSFooterView] " + (String)localObject);
      localObject = sfq.a("default_feeds", true);
      if (localObject != null) {
        localTemplateBean = ((sfq)localObject).getTemplateBean(localJSONObject);
      }
      if (localTemplateBean != null)
      {
        paramrqj = paramrqj.a();
        paramrqj = paramrqj.getViewFactory().inflate(paramrqj, localTemplateBean);
        opy.a(paramrqj, null, localTemplateBean);
        paramrqj.setTag(localTemplateBean);
        paramListView.addFooterView(paramrqj);
        if ((paramListView instanceof ReadInJoyDailyXListView)) {
          ((ReadInJoyDailyXListView)paramListView).setPTSFooterView(paramrqj);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView = ((DailyDianDianEntranceView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131365806));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
      {
        if (rpk.a().a()) {
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a(rpk.a().a(a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView, this));
    } while (rpk.a().a() != 1);
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
    View localView = LayoutInflater.from(a()).inflate(2131559989, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setOverScrollFooter(localView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.a(new rry());
  }
  
  private void n()
  {
    pew localpew = owy.a().a();
    if ((localpew != null) && (!jdField_b_of_type_Boolean)) {
      localpew.a(new nwy(this, localpew));
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_Rqj.a();
  }
  
  public rjg a()
  {
    return this.jdField_a_of_type_Rjg;
  }
  
  public void a()
  {
    super.a();
    rlb.a().a(a());
    this.jdField_a_of_type_Rjg = new rjg(a());
    e = otf.a();
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.jdField_d_of_type_Int, null, 2131559987);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView = ((ReadInJoyDailyPullToZoomHeaderXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131377278));
    l();
    m();
    n();
    this.jdField_a_of_type_Rqj = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    this.jdField_a_of_type_Rkp = new rkp((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379813), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rkp);
    oxb.a().a(this.jdField_a_of_type_Oxe);
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      owy.a().c();
    }
    b();
    tah.a(8);
    oro.a().a();
    oro.a().a(String.valueOf(b()));
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
  
  public void a(ListView paramListView, rqj paramrqj)
  {
    if ((paramListView != null) && (a() != 2)) {
      b(paramListView, paramrqj);
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
    oxb.a().b(this.jdField_a_of_type_Oxe);
    pew localpew = owy.a().a();
    if (localpew != null) {
      localpew.a(null);
    }
    super.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
    {
      RecommendFeedsDiandianEntranceManager.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a();
    }
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.d();
    }
    rlb.a().b(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Rqj.d();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Rqj != null) {
      this.jdField_a_of_type_Rqj.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
    if (!this.jdField_d_of_type_Boolean)
    {
      rpk.a().a();
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
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    oxb.a().a(this.jdField_a_of_type_Oxe);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    rqi localrqi = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localrqi = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Rjg != null) && (localrqi != null))
    {
      rjk localrjk = this.jdField_a_of_type_Rjg.a();
      if ((localrjk != null) && (localrjk.jdField_b_of_type_Boolean)) {
        localrqi.m();
      }
    }
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.f();
    }
    oxb.a().a(this.jdField_a_of_type_Oxe);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).m();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nww
 * JD-Core Version:    0.7.0.1
 */