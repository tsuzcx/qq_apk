import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class odd
  extends bhhe
{
  private WeakReference<oda> a;
  
  odd(oda paramoda)
  {
    this.a = new WeakReference(paramoda);
  }
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (this.a != null)
    {
      Object localObject = (oda)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((oda)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((parambhhf.a == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambhhf.i).commit();
          ((oda)localObject).b();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(oda.jdField_a_of_type_JavaLangString);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambhhf.a() + ",errCode=" + parambhhf.a + ",httpCode=" + parambhhf.f + ",local lastModify=" + l + ",server lastModify=" + parambhhf.i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odd
 * JD-Core Version:    0.7.0.1
 */