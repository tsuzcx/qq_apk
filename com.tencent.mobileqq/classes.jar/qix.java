import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class qix
  extends qim
{
  private long jdField_a_of_type_Long;
  ayvz jdField_a_of_type_Ayvz = new qiy(this);
  private aywa jdField_a_of_type_Aywa;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public qix(Context paramContext, QQAppInterface paramQQAppInterface, qin paramqin, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramqin);
    this.d = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    axrl localaxrl = axrl.a(this.jdField_a_of_type_AndroidContentContext);
    String str = onk.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrl.a(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("VideoUploadController", 2, "finish: retCode - " + paramInt + " fileUrl : " + paramString1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(paramInt);
    if (this.jdField_a_of_type_Qin != null) {
      this.jdField_a_of_type_Qin.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Ayvz);
    ThreadManager.executeOnFileThread(new VideoUploadController.1(this));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.e = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "startUploadVideo path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo empty path!");
      }
      a(1001, null, null, null);
      return;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo file not exist, path=" + paramString);
      }
      a(1002, null, null, null);
      return;
    }
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!bbev.h(this.jdField_a_of_type_AndroidContentContext)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    ayvv localayvv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Ayvz.getFilter().size() == 0) {
      this.jdField_a_of_type_Ayvz.addFilter(new Class[] { ayos.class });
    }
    localayvv.a(this.jdField_a_of_type_Ayvz);
    if (this.jdField_a_of_type_Aywa == null)
    {
      this.jdField_a_of_type_Aywa = new aywa();
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aywa.jdField_c_of_type_Int = 54;
      this.jdField_a_of_type_Aywa.i = paramString;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString = "0";
      this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_Aywa.jdField_b_of_type_Int = 24;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    }
    localayvv.a(this.jdField_a_of_type_Aywa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qix
 * JD-Core Version:    0.7.0.1
 */