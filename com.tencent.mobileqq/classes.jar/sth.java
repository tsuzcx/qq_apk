import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class sth
  implements syq<tnl, tow>
{
  sth(stf paramstf) {}
  
  public void a(tnl arg1, tow paramtow, ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {}
    for (;;)
    {
      synchronized (this.a.jdField_b_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_Stj = paramtow.jdField_a_of_type_Stj;
        this.a.jdField_a_of_type_Stj.a();
        ved.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.jdField_a_of_type_Stj);
        this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        paramtow = finally;
        throw paramtow;
        ved.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sth
 * JD-Core Version:    0.7.0.1
 */