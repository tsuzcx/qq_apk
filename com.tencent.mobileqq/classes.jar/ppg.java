import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.3;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class ppg
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int = -1;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RIJOnScrollListener.1(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public pne a;
  tei jdField_a_of_type_Tei = new tei();
  urm jdField_a_of_type_Urm;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public ppg(pne parampne)
  {
    this.jdField_a_of_type_Pne = parampne;
    this.jdField_a_of_type_Urm = new pph(this, parampne);
  }
  
  private String a()
  {
    if (rad.a().b()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  private void a()
  {
    if (pnn.a()) {}
    switch (this.jdField_a_of_type_Pne.a().b())
    {
    default: 
      if (plm.c(this.jdField_a_of_type_Pne.a().b()))
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
    DropFrameMonitor.getInstance().startMonitorScene("list_kandian_channel_" + this.jdField_a_of_type_Pne.a().b());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (uks.a(this.jdField_a_of_type_Pne.a().b()))
    {
      Pair localPair = pvj.a().a(this.jdField_a_of_type_Pne.a().b(), paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        pvj.a().a(this.jdField_a_of_type_Pne.a().b(), ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
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
        tlv.a().b();
      }
    }
    label31:
    while (this.jdField_a_of_type_Int != -1)
    {
      return;
      tlv.a().c();
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
    if (pnn.a()) {}
    switch (this.jdField_a_of_type_Pne.a().b())
    {
    default: 
      if (plm.c(this.jdField_a_of_type_Pne.a().b()))
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
    DropFrameMonitor.getInstance().stopMonitorScene("list_kandian_channel_" + this.jdField_a_of_type_Pne.a().b(), false);
  }
  
  public urm a()
  {
    return this.jdField_a_of_type_Urm;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    uhx localuhx = (uhx)pnn.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
    if ((localuhx.a(this.jdField_a_of_type_Pne.a().a(), (Activity)this.jdField_a_of_type_Pne.a().a())) && (this.jdField_a_of_type_Pne.a().a() != null)) {
      this.jdField_a_of_type_Pne.a().a().a(this.jdField_a_of_type_Pne.a().a(), (Activity)this.jdField_a_of_type_Pne.a().a());
    }
    a(paramInt1, paramInt2);
    if (paramInt1 > this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      localuhx.a(this.jdField_a_of_type_Pne.a().a(), (Activity)this.jdField_a_of_type_Pne.a().a(), this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
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
      this.jdField_a_of_type_Tei.b();
      this.jdField_a_of_type_Pne.a().a().a(this.jdField_a_of_type_Boolean, paramAbsListView.getCount(), paramAbsListView.getLastVisiblePosition(), this.jdField_a_of_type_Pne.a().a(), this.jdField_a_of_type_Pne);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      if ((paramInt != 2) || (!this.jdField_a_of_type_Pne.a().a())) {
        break label194;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Urm.a(paramAbsListView, paramInt);
      return;
      a();
      this.jdField_a_of_type_Tei.a();
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      break;
      label194:
      if ((paramInt != 2) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Pne.a().g(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppg
 * JD-Core Version:    0.7.0.1
 */