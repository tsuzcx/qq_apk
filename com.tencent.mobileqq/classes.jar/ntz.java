import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class ntz
  extends bead
{
  private WeakReference<ntw> a;
  
  ntz(ntw paramntw)
  {
    this.a = new WeakReference(paramntw);
  }
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (this.a != null)
    {
      Object localObject = (ntw)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((ntw)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((parambeae.a == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambeae.i).commit();
          ((ntw)localObject).b();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(ntw.jdField_a_of_type_JavaLangString);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambeae.a() + ",errCode=" + parambeae.a + ",httpCode=" + parambeae.f + ",local lastModify=" + l + ",server lastModify=" + parambeae.i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ntz
 * JD-Core Version:    0.7.0.1
 */