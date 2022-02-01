import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class rua
  extends rtp
{
  private long jdField_a_of_type_Long;
  bdzm jdField_a_of_type_Bdzm = new rub(this);
  private bdzn jdField_a_of_type_Bdzn;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public rua(Context paramContext, QQAppInterface paramQQAppInterface, rtq paramrtq, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramrtq);
    this.d = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    bctj localbctj = bctj.a(this.jdField_a_of_type_AndroidContentContext);
    String str = pha.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localbctj.a(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("VideoUploadController", 2, "finish: retCode - " + paramInt + " fileUrl : " + paramString1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(paramInt);
    if (this.jdField_a_of_type_Rtq != null) {
      this.jdField_a_of_type_Rtq.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "cancelUploadVideo");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localObject != null) && (this.jdField_a_of_type_Bdzn != null))
    {
      localObject = (bdsx)((bdzi)localObject).a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      if (localObject != null)
      {
        ((bdsx)localObject).a();
        this.jdField_a_of_type_Bdzn = null;
      }
    }
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
    if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!bgnt.h(this.jdField_a_of_type_AndroidContentContext)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    bdzi localbdzi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Bdzm.getFilter().size() == 0) {
      this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdsp.class });
    }
    localbdzi.a(this.jdField_a_of_type_Bdzm);
    if (this.jdField_a_of_type_Bdzn == null)
    {
      this.jdField_a_of_type_Bdzn = new bdzn();
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bdzn.jdField_c_of_type_Int = 54;
      this.jdField_a_of_type_Bdzn.i = paramString;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString = "0";
      this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int = 24;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    }
    localbdzi.a(this.jdField_a_of_type_Bdzn);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Bdzm);
    ThreadManager.executeOnFileThread(new VideoUploadController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rua
 * JD-Core Version:    0.7.0.1
 */