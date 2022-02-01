import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.3;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.5;
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

public class ohf
  extends ohl
  implements pgb, qts, quj
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private String jdField_a_of_type_JavaLangString;
  private ohj jdField_a_of_type_Ohj;
  private oio jdField_a_of_type_Oio;
  protected pfh a;
  private rvy jdField_a_of_type_Rvy;
  private rwu jdField_a_of_type_Rwu;
  private boolean jdField_a_of_type_Boolean;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public ohf(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Pfh = new ohh(this);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        qtw localqtw = (qtw)((AppInterface)localObject).getManager(261);
        this.jdField_a_of_type_Oio = new oio(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, this.jdField_b_of_type_AndroidAppActivity);
        if (localqtw != null) {
          localqtw.a(this);
        }
        localObject = (qtq)((AppInterface)localObject).getManager(270);
        if (localObject != null) {
          ((qtq)localObject).a(this);
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
        qtw localqtw = (qtw)((AppInterface)localObject).getManager(261);
        localqtw.b(this);
        localqtw.b();
        localObject = (qtq)((AppInterface)localObject).getManager(270);
        ((qtq)localObject).b(this);
        ((qtq)localObject).a();
      }
    }
  }
  
  private void r()
  {
    ((KandianMergeManager)ozs.a().getManager(162)).d();
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new ohi(this));
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
  
  public rvy a()
  {
    return this.jdField_a_of_type_Rvy;
  }
  
  public void a()
  {
    int i = 0;
    super.a();
    this.jdField_a_of_type_Rvy = new rvy(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (pox.a() != -1) {
      i = pox.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, i, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new ohg(this));
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new ohi(this));
    p();
    this.jdField_a_of_type_Rwu = new rwu((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131380948), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378246), this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwu);
    pfd.a().a(this.jdField_a_of_type_Pfh);
    pfa.a().b();
    b();
    this.jdField_a_of_type_Ohj = new ohj(this);
    pfw.a(this);
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
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).s();
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
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
        ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a().a();
      }
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
    pfd.a().b(this.jdField_a_of_type_Pfh);
    super.d();
    q();
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.d.clear();
    if (this.jdField_a_of_type_Oio != null) {
      this.jdField_a_of_type_Oio.a();
    }
    pfw.b(this);
    tkb.b();
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
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((qtw)localAppInterface.getManager(261)).a() == 1) && (this.jdField_a_of_type_Oio != null)) {
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
    sek localsek = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localsek = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Rvy != null) && (localsek != null))
    {
      rwc localrwc = this.jdField_a_of_type_Rvy.a();
      if ((localrwc != null) && (localrwc.jdField_b_of_type_Boolean)) {
        localsek.m();
      }
    }
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.f();
    }
    pfd.a().a(this.jdField_a_of_type_Pfh);
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
      if ((localAppInterface != null) && (((qtw)localAppInterface.getManager(261)).a() == 1) && (this.jdField_a_of_type_Oio != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    if (this.jdField_a_of_type_Rvy != null) {
      this.jdField_a_of_type_Rvy.e();
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
      Object localObject = a(Integer.valueOf(0));
      Map localMap = ubg.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.5(this, (Map)localObject, a(Integer.valueOf(0)), localMap, ozs.e(0)));
      b(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).d(this.d);
      this.d.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject = (pmm)((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(2);
      if (localObject != null) {
        ((pmm)localObject).i();
      }
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
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohf
 * JD-Core Version:    0.7.0.1
 */