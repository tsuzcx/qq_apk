import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.3;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.4;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class oqo
  extends oqu
  implements pwk, rmw, rnn
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private String jdField_a_of_type_JavaLangString;
  private oqs jdField_a_of_type_Oqs;
  private ory jdField_a_of_type_Ory;
  protected pvq a;
  private rkf jdField_a_of_type_Rkf;
  private spg jdField_a_of_type_Spg;
  private sqd jdField_a_of_type_Sqd;
  private boolean jdField_a_of_type_Boolean;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public oqo(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Pvq = new oqq(this);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == null) {
      return;
    }
    long l = paramListView.getItemIdAtPosition(paramListView.getFirstVisiblePosition());
    pvj.a().a(l, 0);
  }
  
  private void o()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        rna localrna = (rna)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        this.jdField_a_of_type_Ory = new ory(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, this.jdField_b_of_type_AndroidAppActivity);
        if (localrna != null) {
          localrna.a(this);
        }
        localObject = (rmu)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if (localObject != null) {
          ((rmu)localObject).a(this);
        }
      }
    }
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if (localObject != null)
      {
        rna localrna = (rna)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        localrna.b(this);
        localrna.b();
        localObject = (rmu)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        ((rmu)localObject).b(this);
        ((rmu)localObject).a();
      }
    }
  }
  
  private void q()
  {
    ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).d();
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new oqr(this));
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
  
  public spg a()
  {
    return this.jdField_a_of_type_Spg;
  }
  
  public void a()
  {
    int i = 0;
    super.a();
    this.jdField_a_of_type_Spg = new spg(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (qez.a() != -1) {
      i = qez.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, i, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new oqp(this));
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new oqr(this));
    o();
    this.jdField_a_of_type_Sqd = new sqd((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381023), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378302), this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Sqd);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    pvj.a().b();
    b();
    this.jdField_a_of_type_Oqs = new oqs(this);
    this.jdField_a_of_type_Rkf = new rkf();
    this.jdField_a_of_type_Rkf.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Spg);
    pwf.a(this);
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
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).n();
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
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
      {
        sfx localsfx = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a();
        if (localsfx != null) {
          localsfx.a();
        }
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      q();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      return ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
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
    pvm.a().b(this.jdField_a_of_type_Pvq);
    super.d();
    p();
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), a(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.d.clear();
    if (this.jdField_a_of_type_Ory != null) {
      this.jdField_a_of_type_Ory.a();
    }
    pwf.b(this);
    uda.b();
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
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.b();
    }
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((rna)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) && (this.jdField_a_of_type_Ory != null)) {
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
    szc localszc = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localszc = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.a();
    }
    if ((this.jdField_a_of_type_Spg != null) && (localszc != null))
    {
      spk localspk = this.jdField_a_of_type_Spg.a();
      if ((localspk != null) && (localspk.jdField_b_of_type_Boolean)) {
        localszc.e(true);
      }
    }
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.d(0);
    }
    pvm.a().a(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).l();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      q();
    }
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidAppActivity).getAppInterface();
      if ((localAppInterface != null) && (((rna)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 1) && (this.jdField_a_of_type_Ory != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.b();
    }
    if (this.jdField_a_of_type_Spg != null)
    {
      this.jdField_a_of_type_Spg.a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.jdField_a_of_type_Spg.e();
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
      Object localObject = (ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
      Map localMap1 = a(Integer.valueOf(0));
      Map localMap2 = uvs.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.4(this, (ReadInJoyListViewGroup)localObject, localMap1, a(Integer.valueOf(0)), localMap2, prp.a(0)));
      b(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)localObject).d(this.d);
      this.d.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      a(((ReadInJoyListViewGroup)localObject).a());
      localObject = (qcw)((ReadInJoyListViewGroup)localObject).a().a(2);
      if (localObject != null) {
        ((qcw)localObject).h();
      }
    }
  }
  
  public void l() {}
  
  public void m()
  {
    QLog.d("KanDianViewController", 2, "[onAppStatusChange] switch to background, report and clear");
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqo
 * JD-Core Version:    0.7.0.1
 */