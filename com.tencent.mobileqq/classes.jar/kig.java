import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import java.lang.ref.WeakReference;

public class kig
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  
  public kig(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null) {
      QAVGroupConfig.a("addGroupMember_" + this.jdField_a_of_type_Long, localQQAppInterface, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kig
 * JD-Core Version:    0.7.0.1
 */