import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class oen
  extends biht
{
  private WeakReference<oek> a;
  
  oen(oek paramoek)
  {
    this.a = new WeakReference(paramoek);
  }
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (this.a != null)
    {
      Object localObject = (oek)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((oek)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((parambihu.a == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambihu.i).commit();
          ((oek)localObject).b();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(oek.jdField_a_of_type_JavaLangString);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambihu.a() + ",errCode=" + parambihu.a + ",httpCode=" + parambihu.f + ",local lastModify=" + l + ",server lastModify=" + parambihu.i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oen
 * JD-Core Version:    0.7.0.1
 */