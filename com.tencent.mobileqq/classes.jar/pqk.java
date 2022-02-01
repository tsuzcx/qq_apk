import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager.3;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.app.AppRuntime;

public class pqk
{
  private pqo jdField_a_of_type_Pqo;
  private pvb jdField_a_of_type_Pvb;
  private pvd jdField_a_of_type_Pvd;
  private tcx jdField_a_of_type_Tcx;
  
  public pqk(pqo parampqo)
  {
    this.jdField_a_of_type_Pqo = parampqo;
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Tcx == null) {
      if (pro.b() != 2) {
        break label98;
      }
    }
    label98:
    for (this.jdField_a_of_type_Tcx = new tct(this.jdField_a_of_type_Pqo.a());; this.jdField_a_of_type_Tcx = new tcv(this.jdField_a_of_type_Pqo.a(), LayoutInflater.from(this.jdField_a_of_type_Pqo.a()).inflate(2131560329, this.jdField_a_of_type_Pqo.a(), false)))
    {
      this.jdField_a_of_type_Tcx.a(new pqn(this));
      this.jdField_a_of_type_Pqo.a().addHeaderView(this.jdField_a_of_type_Tcx.a());
      this.jdField_a_of_type_Tcx.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Tcx.a();
      this.jdField_a_of_type_Pqo.a().postInvalidate();
      return;
    }
  }
  
  private void l()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if (localKandianMsgBoxRedPntInfo == null)
    {
      c();
      return;
    }
    a(localKandianMsgBoxRedPntInfo);
  }
  
  public pqo a()
  {
    return this.jdField_a_of_type_Pqo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pvb = new pql(this);
    this.jdField_a_of_type_Pvd = new pqm(this);
  }
  
  public void b()
  {
    if (pro.b() == 0) {}
    while (this.jdField_a_of_type_Pqo.a() != 0) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      l();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new RIJTipMessageManager.3(this));
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_Tcx != null)
      {
        this.jdField_a_of_type_Pqo.a().removeHeaderView(this.jdField_a_of_type_Tcx.a());
        this.jdField_a_of_type_Pqo.a().postInvalidate();
        this.jdField_a_of_type_Tcx = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Tcx != null)
    {
      this.jdField_a_of_type_Tcx.b();
      this.jdField_a_of_type_Tcx = null;
    }
    f();
    this.jdField_a_of_type_Pvb = null;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Pqo.a().d();
    g();
  }
  
  public void f()
  {
    g();
    h();
  }
  
  public void g()
  {
    ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_Pvb);
  }
  
  public void h()
  {
    ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_Pvd);
  }
  
  public void i()
  {
    j();
    k();
  }
  
  public void j()
  {
    ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_Pvb);
  }
  
  public void k()
  {
    ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_Pvd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqk
 * JD-Core Version:    0.7.0.1
 */