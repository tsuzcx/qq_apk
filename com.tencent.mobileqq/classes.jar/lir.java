import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.qphone.base.util.QLog;

public class lir
  implements Runnable
{
  public lir(ReadInJoyArkViewController paramReadInJoyArkViewController, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify("com.tencent.khala", this.jdField_a_of_type_JavaLangString, this.b, "json");
      ark.arkNotify("com.tencent.test.khala", this.jdField_a_of_type_JavaLangString, this.b, "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyArkViewController", 2, "arkNotify failed, .so not loaded");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lir
 * JD-Core Version:    0.7.0.1
 */