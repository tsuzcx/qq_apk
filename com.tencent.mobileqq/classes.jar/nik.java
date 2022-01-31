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

public class nik
  extends nhw
  implements View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "readinjoy_daily_old_version_cache_deal";
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean jdField_b_of_type_Boolean = ((Boolean)bgmq.a(jdField_a_of_type_JavaLangString, Boolean.valueOf(false))).booleanValue();
  private static int e;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ReadInJoyDailyPullToZoomHeaderXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView;
  private DailyDianDianEntranceView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView;
  protected ohe a;
  private qhp jdField_a_of_type_Qhp;
  private qiy jdField_a_of_type_Qiy;
  private qoe jdField_a_of_type_Qoe;
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  
  public nik(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Ohe = new nil(this);
    this.jdField_a_of_type_Qhp = new qhp(paramActivity);
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
  
  private void b(ListView paramListView, qoe paramqoe)
  {
    TemplateBean localTemplateBean = null;
    JSONObject localJSONObject = odm.a();
    try
    {
      Object localObject = localJSONObject.optString("style_ID", "null");
      QLog.i("ReadInJoyDailyViewController", 1, "[initPTSFooterView] " + (String)localObject);
      localObject = rdg.a("default_feeds", true);
      if (localObject != null) {
        localTemplateBean = ((rdg)localObject).getTemplateBean(localJSONObject);
      }
      if (localTemplateBean != null)
      {
        paramqoe = paramqoe.a();
        paramqoe = paramqoe.getViewFactory().inflate(paramqoe, localTemplateBean);
        oag.a(paramqoe, null, localTemplateBean);
        paramqoe.setTag(localTemplateBean);
        paramListView.addFooterView(paramqoe);
        if ((paramListView instanceof ReadInJoyDailyXListView)) {
          ((ReadInJoyDailyXListView)paramListView).setPTSFooterView(paramqoe);
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
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView = ((DailyDianDianEntranceView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131300124));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
      {
        if (qni.a().a()) {
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a(qni.a().a(a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView, this));
    } while (qni.a().a() != 1);
    RecommendFeedsDiandianEntranceManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
  }
  
  private void l()
  {
    if (e == 2) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setCanLoadMore(true);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.getOverScrollFooterView() != null) {
      return;
    }
    View localView = LayoutInflater.from(a()).inflate(2131494323, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setOverScrollFooter(localView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.a(new qpt());
  }
  
  private void m()
  {
    ooq localooq = ogy.a().a();
    if ((localooq != null) && (!jdField_b_of_type_Boolean)) {
      localooq.a(new nim(this, localooq));
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_Qoe.a();
  }
  
  public qhp a()
  {
    return this.jdField_a_of_type_Qhp;
  }
  
  public void a()
  {
    super.a();
    e = odm.a();
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.jdField_d_of_type_Int, null, 2131494321);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView = ((ReadInJoyDailyPullToZoomHeaderXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131310904));
    j();
    l();
    m();
    this.jdField_a_of_type_Qoe = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    this.jdField_a_of_type_Qiy = new qiy((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131313236), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Qiy);
    ohb.a().a(this.jdField_a_of_type_Ohe);
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      ogy.a().c();
    }
    b();
    rvw.a(8);
    obv.a().a();
    obv.a().a(String.valueOf(b()));
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
  
  public void a(ListView paramListView, qoe paramqoe)
  {
    if ((paramListView != null) && (a() != 2)) {
      b(paramListView, paramqoe);
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
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_c_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void d()
  {
    ohb.a().b(this.jdField_a_of_type_Ohe);
    ooq localooq = ogy.a().a();
    if (localooq != null) {
      localooq.a(null);
    }
    super.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
    {
      RecommendFeedsDiandianEntranceManager.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a();
    }
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Qoe.d();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Qoe != null) {
      this.jdField_a_of_type_Qoe.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
    if (!this.jdField_d_of_type_Boolean)
    {
      qni.a().a();
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
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    ohb.a().a(this.jdField_a_of_type_Ohe);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    qod localqod = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localqod = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Qhp != null) && (localqod != null))
    {
      qht localqht = this.jdField_a_of_type_Qhp.a();
      if ((localqht != null) && (localqht.jdField_b_of_type_Boolean)) {
        localqod.m();
      }
    }
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.f();
    }
    ohb.a().a(this.jdField_a_of_type_Ohe);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).m();
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(true, 1);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nik
 * JD-Core Version:    0.7.0.1
 */