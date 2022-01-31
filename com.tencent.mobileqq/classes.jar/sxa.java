import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class sxa
  implements adca
{
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  swz jdField_a_of_type_Swz = null;
  
  public sxa(swz paramswz, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_Swz = paramswz;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail, status: " + paramInt + " | icon: " + paramDrawable + " | mFolder: " + this.jdField_a_of_type_Swz);
    }
    if ((paramInt == 2) && (paramDrawable != null) && (this.jdField_a_of_type_Swz != null)) {
      this.jdField_a_of_type_Swz.a = paramDrawable;
    }
    try
    {
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(1).notifyUI(4, true, new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxa
 * JD-Core Version:    0.7.0.1
 */