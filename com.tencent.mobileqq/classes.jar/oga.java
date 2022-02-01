import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class oga
  extends bgod
{
  private WeakReference<ofx> a;
  
  oga(ofx paramofx)
  {
    this.a = new WeakReference(paramofx);
  }
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (this.a != null)
    {
      Object localObject = (ofx)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((ofx)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((parambgoe.a == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambgoe.i).commit();
          ((ofx)localObject).b();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(ofx.jdField_a_of_type_JavaLangString);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambgoe.a() + ",errCode=" + parambgoe.a + ",httpCode=" + parambgoe.f + ",local lastModify=" + l + ",server lastModify=" + parambgoe.i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oga
 * JD-Core Version:    0.7.0.1
 */