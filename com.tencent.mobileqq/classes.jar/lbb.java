import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.lang.ref.WeakReference;

public class lbb
  implements Runnable
{
  public lbb(PublicAccountManager paramPublicAccountManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.get();
    String str = this.a.jdField_b_of_type_JavaLangString;
    boolean bool = this.a.jdField_b_of_type_Boolean;
    if ((this.a.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (localQQAppInterface != null)) {
      SosoInterface.a(new lbc(this, 1, true, true, 0L, true, false, "PublicAccountManager", str, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbb
 * JD-Core Version:    0.7.0.1
 */