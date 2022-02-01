import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.3;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class pgd
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int = -1;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RIJOnScrollListener.1(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public ped a;
  sqx jdField_a_of_type_Sqx = new sqx();
  udp jdField_a_of_type_Udp;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public pgd(ped paramped)
  {
    this.jdField_a_of_type_Ped = paramped;
    this.jdField_a_of_type_Udp = new pge(this, paramped);
  }
  
  private String a()
  {
    if (qny.a().b()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  private void a()
  {
    if (pay.a()) {}
    switch (this.jdField_a_of_type_Ped.a().b())
    {
    default: 
      if (pcl.c(this.jdField_a_of_type_Ped.a().b()))
      {
        DropFrameMonitor.getInstance().startMonitorScene(a());
        return;
      }
      break;
    case 56: 
      DropFrameMonitor.getInstance().startMonitorScene("list_video_kandian");
      return;
    case 0: 
      DropFrameMonitor.getInstance().startMonitorScene("list_new_kandian");
      return;
    case 70: 
      DropFrameMonitor.getInstance().startMonitorScene("list_subscript");
      return;
    }
    DropFrameMonitor.getInstance().startMonitorScene("list_kandian_channel_" + this.jdField_a_of_type_Ped.a().b());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (twr.a(this.jdField_a_of_type_Ped.a().b()))
    {
      Pair localPair = pkm.a().a(this.jdField_a_of_type_Ped.a().b(), paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        pkm.a().a(this.jdField_a_of_type_Ped.a().b(), ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
        ThreadManager.executeOnSubThread(new RIJOnScrollListener.3(this, localPair));
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (this.jdField_a_of_type_Int == 2) {
      if (Build.VERSION.SDK_INT < 21)
      {
        if (!a(paramAbsListView)) {
          break label31;
        }
        syn.a().b();
      }
    }
    label31:
    while (this.jdField_a_of_type_Int != -1)
    {
      return;
      syn.a().c();
      return;
    }
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)DeviceInfoUtil.getPortraitHeight();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  private void b()
  {
    if (pay.a()) {}
    switch (this.jdField_a_of_type_Ped.a().b())
    {
    default: 
      if (pcl.c(this.jdField_a_of_type_Ped.a().b()))
      {
        DropFrameMonitor.getInstance().stopMonitorScene(a(), false);
        return;
      }
      break;
    case 56: 
      DropFrameMonitor.getInstance().stopMonitorScene("list_video_kandian", false);
      return;
    case 0: 
      DropFrameMonitor.getInstance().stopMonitorScene("list_new_kandian", false);
      return;
    case 70: 
      DropFrameMonitor.getInstance().stopMonitorScene("list_subscript", false);
      return;
    }
    DropFrameMonitor.getInstance().stopMonitorScene("list_kandian_channel_" + this.jdField_a_of_type_Ped.a().b(), false);
  }
  
  public udp a()
  {
    return this.jdField_a_of_type_Udp;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ttq localttq = (ttq)pem.a().getManager(307);
    if ((localttq.a(this.jdField_a_of_type_Ped.a().a(), (Activity)this.jdField_a_of_type_Ped.a().a())) && (this.jdField_a_of_type_Ped.a().a() != null)) {
      this.jdField_a_of_type_Ped.a().a().a(this.jdField_a_of_type_Ped.a().a(), (Activity)this.jdField_a_of_type_Ped.a().a());
    }
    a(paramInt1, paramInt2);
    if (paramInt1 > this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      localttq.a(this.jdField_a_of_type_Ped.a().a(), (Activity)this.jdField_a_of_type_Ped.a().a(), this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
      this.jdField_b_of_type_Int = paramInt1;
      a(paramAbsListView);
      return;
      if (paramInt1 < this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("RIJOnScrollListener", 2, "onScrollStateChanged " + paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJOnScrollListener", 2, "onScrollStateChanged " + paramInt);
    }
    if (paramInt == 0)
    {
      b();
      this.jdField_a_of_type_Sqx.b();
      this.jdField_a_of_type_Ped.a().a().a(this.jdField_a_of_type_Boolean, paramAbsListView.getCount(), paramAbsListView.getLastVisiblePosition(), this.jdField_a_of_type_Ped.a().a(), this.jdField_a_of_type_Ped);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      if ((paramInt != 2) || (!this.jdField_a_of_type_Ped.a().a())) {
        break label194;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Udp.a(paramAbsListView, paramInt);
      return;
      a();
      this.jdField_a_of_type_Sqx.a();
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      break;
      label194:
      if ((paramInt != 2) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Ped.a().g(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgd
 * JD-Core Version:    0.7.0.1
 */