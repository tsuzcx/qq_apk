import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class ont
  extends bhyn
{
  private WeakReference<onq> a;
  
  ont(onq paramonq)
  {
    this.a = new WeakReference(paramonq);
  }
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (this.a != null)
    {
      Object localObject = (onq)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((onq)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((parambhyo.a == 0) && (localQQAppInterface != null))
        {
          localQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambhyo.i).commit();
          ((onq)localObject).b();
        }
        if (QLog.isColorLevel())
        {
          localObject = new File(onq.jdField_a_of_type_JavaLangString);
          long l = 0L;
          if (((File)localObject).exists()) {
            l = ((File)localObject).lastModified();
          }
          QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambhyo.a() + ",errCode=" + parambhyo.a + ",httpCode=" + parambhyo.f + ",local lastModify=" + l + ",server lastModify=" + parambhyo.i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ont
 * JD-Core Version:    0.7.0.1
 */