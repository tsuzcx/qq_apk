import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.3;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.5;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class ntb
  extends ntg
  implements oti, pze, pzv
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private String jdField_a_of_type_JavaLangString;
  private ntf jdField_a_of_type_Ntf;
  private nuj jdField_a_of_type_Nuj;
  protected osp a;
  private qtu jdField_a_of_type_Qtu;
  private qvd jdField_a_of_type_Qvd;
  private boolean jdField_a_of_type_Boolean;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public ntb(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Osp = new ntd(this);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        pzi localpzi = (pzi)((AppInterface)localObject).getManager(261);
        this.jdField_a_of_type_Nuj = new nuj(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, this.jdField_b_of_type_AndroidAppActivity);
        if (localpzi != null) {
          localpzi.a(this);
        }
        localObject = (pzc)((AppInterface)localObject).getManager(270);
        if (localObject != null) {
          ((pzc)localObject).a(this);
        }
      }
    }
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        pzi localpzi = (pzi)((AppInterface)localObject).getManager(261);
        localpzi.b(this);
        localpzi.a();
        localObject = (pzc)((AppInterface)localObject).getManager(270);
        ((pzc)localObject).b(this);
        ((pzc)localObject).a();
      }
    }
  }
  
  private void r()
  {
    ((KandianMergeManager)onk.a().getManager(162)).c();
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new nte(this));
    }
  }
  
  public Activity a()
  {
    return this.jdField_b_of_type_AndroidAppActivity;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public qtu a()
  {
    return this.jdField_a_of_type_Qtu;
  }
  
  public void a()
  {
    int i = 0;
    super.a();
    this.jdField_a_of_type_Qtu = new qtu(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (pab.a() != -1) {
      i = pab.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, i, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new ntc(this));
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new nte(this));
    p();
    this.jdField_a_of_type_Qvd = new qvd((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379072), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131376712), this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qtu.a(this.jdField_a_of_type_Qvd);
    osm.a().a(this.jdField_a_of_type_Osp);
    osj.a().b();
    b();
    this.jdField_a_of_type_Ntf = new ntf(this);
    otd.a(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KanDianViewController", 1, "onSkinChanged");
      }
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setSkinHeader(paramInt, paramBoolean);
    }
    if ((a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)a()).a(paramInt, paramString, paramBoolean);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setSkinCheckAction(paramRunnable);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).t();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(0)), b(Integer.valueOf(0)));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.c(this.d);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
    }
    if (!this.jdField_b_of_type_Boolean) {
      r();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      return ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).e();
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    }
  }
  
  public void d()
  {
    osm.a().b(this.jdField_a_of_type_Osp);
    super.d();
    q();
    if (this.jdField_a_of_type_Qtu != null) {
      this.jdField_a_of_type_Qtu.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.d.clear();
    if (this.jdField_a_of_type_Nuj != null) {
      this.jdField_a_of_type_Nuj.a();
    }
    otd.b(this);
    sai.b();
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Qtu != null) {
      this.jdField_a_of_type_Qtu.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((pzi)localAppInterface.getManager(261)).a() == 1) && (this.jdField_a_of_type_Nuj != null)) {
        ThreadManager.post(new KanDianViewController.2(this), 8, null, true);
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).k();
    }
  }
  
  public void h()
  {
    super.h();
    rao localrao = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localrao = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Qtu != null) && (localrao != null))
    {
      qty localqty = this.jdField_a_of_type_Qtu.a();
      if ((localqty != null) && (localqty.jdField_b_of_type_Boolean)) {
        localrao.m();
      }
    }
    if (this.jdField_a_of_type_Qtu != null) {
      this.jdField_a_of_type_Qtu.f();
    }
    osm.a().a(this.jdField_a_of_type_Osp);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).m();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      r();
    }
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((pzi)localAppInterface.getManager(261)).a() == 1) && (this.jdField_a_of_type_Nuj != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    if (this.jdField_a_of_type_Qtu != null) {
      this.jdField_a_of_type_Qtu.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).k();
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
    {
      Map localMap1 = a(Integer.valueOf(0));
      Map localMap2 = shx.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.5(this, localMap1, a(Integer.valueOf(0)), localMap2, onk.e(0)));
      b(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).d(this.d);
      this.d.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void l() {}
  
  public void m()
  {
    QLog.d("KanDianViewController", 2, "[onAppStatusChange] switch to background, report and clear");
    k();
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */