import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager.3;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.app.AppRuntime;

public class pgz
{
  private phc jdField_a_of_type_Phc;
  private pke jdField_a_of_type_Pke;
  private pkg jdField_a_of_type_Pkg;
  private spm jdField_a_of_type_Spm;
  
  public pgz(phc paramphc)
  {
    this.jdField_a_of_type_Phc = paramphc;
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Spm == null) {
      if (pay.k() != 2) {
        break label98;
      }
    }
    label98:
    for (this.jdField_a_of_type_Spm = new spi(this.jdField_a_of_type_Phc.a());; this.jdField_a_of_type_Spm = new spk(this.jdField_a_of_type_Phc.a(), LayoutInflater.from(this.jdField_a_of_type_Phc.a()).inflate(2131560283, this.jdField_a_of_type_Phc.a(), false)))
    {
      this.jdField_a_of_type_Spm.a(new phb(this));
      this.jdField_a_of_type_Phc.a().addHeaderView(this.jdField_a_of_type_Spm.a());
      this.jdField_a_of_type_Spm.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Spm.a();
      this.jdField_a_of_type_Phc.a().postInvalidate();
      return;
    }
  }
  
  private void k()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)pay.a().getManager(162)).a();
    if (localKandianMsgBoxRedPntInfo == null)
    {
      b();
      return;
    }
    a(localKandianMsgBoxRedPntInfo);
  }
  
  public phc a()
  {
    return this.jdField_a_of_type_Phc;
  }
  
  public void a()
  {
    if (pay.k() == 0) {}
    while (this.jdField_a_of_type_Phc.a() != 0) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      k();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new RIJTipMessageManager.3(this));
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Spm != null)
      {
        this.jdField_a_of_type_Phc.a().removeHeaderView(this.jdField_a_of_type_Spm.a());
        this.jdField_a_of_type_Phc.a().postInvalidate();
        this.jdField_a_of_type_Spm = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Spm != null)
    {
      this.jdField_a_of_type_Spm.b();
      this.jdField_a_of_type_Spm = null;
    }
    e();
    this.jdField_a_of_type_Pke = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Phc.a().d();
    f();
  }
  
  public void e()
  {
    f();
    g();
  }
  
  public void f()
  {
    ((KandianMergeManager)pay.a().getManager(162)).b(this.jdField_a_of_type_Pke);
  }
  
  public void g()
  {
    ((KandianMergeManager)pay.a().getManager(162)).b(this.jdField_a_of_type_Pkg);
  }
  
  public void h()
  {
    i();
    j();
  }
  
  public void i()
  {
    ((KandianMergeManager)pay.a().getManager(162)).a(this.jdField_a_of_type_Pke);
  }
  
  public void j()
  {
    ((KandianMergeManager)pay.a().getManager(162)).a(this.jdField_a_of_type_Pkg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgz
 * JD-Core Version:    0.7.0.1
 */