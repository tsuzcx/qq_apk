import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class sgm
  extends spc
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public sgq a;
  public final Object b;
  public AtomicBoolean b;
  
  public sgm()
  {
    this.jdField_a_of_type_Sgq = new sgq();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new sgp(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Sgq.b()) {
      d();
    }
    return this.jdField_a_of_type_Sgq.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      urk.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    urk.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Sgq);
    tas localtas = new tas();
    slv.a().a(localtas, new sgo(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return bach.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new sgn(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Sgq.a;
    }
    d();
    urk.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        urk.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Sgq;
        if (((sgq)???).a()) {
          return ((sgq)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          urk.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    urk.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((sgq)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Sgq.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Sgq.a;
      if (arrayOfByte != null) {
        return bach.a(arrayOfByte);
      }
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void c()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgm
 * JD-Core Version:    0.7.0.1
 */