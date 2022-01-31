import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class stf
  extends tbv
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public stj a;
  public final Object b;
  public AtomicBoolean b;
  
  public stf()
  {
    this.jdField_a_of_type_Stj = new stj();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new sti(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Stj.b()) {
      d();
    }
    return this.jdField_a_of_type_Stj.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      ved.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    ved.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Stj);
    tnl localtnl = new tnl();
    syo.a().a(localtnl, new sth(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return bbea.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new stg(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Stj.a;
    }
    d();
    ved.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        ved.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Stj;
        if (((stj)???).a()) {
          return ((stj)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ved.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    ved.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((stj)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Stj.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Stj.a;
      if (arrayOfByte != null) {
        return bbea.a(arrayOfByte);
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
 * Qualified Name:     stf
 * JD-Core Version:    0.7.0.1
 */