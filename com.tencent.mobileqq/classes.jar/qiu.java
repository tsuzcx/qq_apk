import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class qiu
  extends qij
{
  private long jdField_a_of_type_Long;
  aywb jdField_a_of_type_Aywb = new qiv(this);
  private aywc jdField_a_of_type_Aywc;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public qiu(Context paramContext, QQAppInterface paramQQAppInterface, qik paramqik, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramqik);
    this.d = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    axrn localaxrn = axrn.a(this.jdField_a_of_type_AndroidContentContext);
    String str = onh.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("VideoUploadController", 2, "finish: retCode - " + paramInt + " fileUrl : " + paramString1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(paramInt);
    if (this.jdField_a_of_type_Qik != null) {
      this.jdField_a_of_type_Qik.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aywb);
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
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!bbfj.h(this.jdField_a_of_type_AndroidContentContext)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    ayvx localayvx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Aywb.getFilter().size() == 0) {
      this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayou.class });
    }
    localayvx.a(this.jdField_a_of_type_Aywb);
    if (this.jdField_a_of_type_Aywc == null)
    {
      this.jdField_a_of_type_Aywc = new aywc();
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aywc.jdField_c_of_type_Int = 54;
      this.jdField_a_of_type_Aywc.i = paramString;
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString = "0";
      this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_Aywc.jdField_b_of_type_Int = 24;
      this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    }
    localayvx.a(this.jdField_a_of_type_Aywc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiu
 * JD-Core Version:    0.7.0.1
 */