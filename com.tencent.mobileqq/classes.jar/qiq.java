import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class qiq
  extends qei
{
  private Context jdField_a_of_type_AndroidContentContext;
  public Bundle a;
  ayvz jdField_a_of_type_Ayvz = new qir(this);
  aywa jdField_a_of_type_Aywa;
  private WeakReference<qek> jdField_a_of_type_JavaLangRefWeakReference;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public qiq(Context paramContext, qek paramqek, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramqek);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onk.a());
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    qeh.a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((qek)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramFloat);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = qij.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a();
    if (paramInt == 0) {
      a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle, paramString1, (qek)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((qek)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramInt, paramString1);
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void c()
  {
    this.g = this.jdField_a_of_type_AndroidOsBundle.getString("arg_video_path");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getString("arg_video_cover");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("mTaskID");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    axrl localaxrl = axrl.a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrl.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a()
  {
    a(this.h);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(String paramString)
  {
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic path=" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic empty path!");
      b(10);
      return;
    }
    if (!new File(paramString).exists())
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic file not exist, path=" + paramString);
      b(5);
      return;
    }
    if (!nar.a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get()))
    {
      b(1003);
      return;
    }
    this.d = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = 0;
    if (!auoq.a(localCompressInfo)) {
      c(1001);
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic compressPath=" + localCompressInfo.jdField_e_of_type_JavaLangString + ", originPath=" + paramString + ", outWidth=" + localCompressInfo.d + ", outHeight=" + localCompressInfo.jdField_e_of_type_Int);
    if (TextUtils.isEmpty(localCompressInfo.jdField_e_of_type_JavaLangString)) {}
    for (;;)
    {
      this.d = paramString;
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_Ayvz.addFilter(new Class[] { ayos.class });
      paramString.a(this.jdField_a_of_type_Ayvz);
      this.jdField_a_of_type_Aywa = new aywa();
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aywa.jdField_c_of_type_Int = 10;
      this.jdField_a_of_type_Aywa.i = this.d;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString = "0";
      this.jdField_a_of_type_Aywa.b = 24;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangString = "KandianUGCPicUpload";
      paramString.a(this.jdField_a_of_type_Aywa);
      return;
      paramString = localCompressInfo.jdField_e_of_type_JavaLangString;
    }
  }
  
  public void b()
  {
    qeh.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiq
 * JD-Core Version:    0.7.0.1
 */