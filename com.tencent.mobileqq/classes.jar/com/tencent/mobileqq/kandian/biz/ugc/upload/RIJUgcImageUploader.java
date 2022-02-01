package com.tencent.mobileqq.kandian.biz.ugc.upload;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController;
import com.tencent.qphone.base.util.QLog;

public class RIJUgcImageUploader
  implements IImageUploader
{
  public static String a = "RIJUGC.RIJUgcImageUploader";
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IImageUploadListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploadListener;
  private ImageUploadController jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferImageUploadController;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public RIJUgcImageUploader(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload, path=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    QLog.i(str, 1, localStringBuilder.toString());
    this.jdField_b_of_type_Boolean = true;
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1(this));
  }
  
  public void a(IImageUploadListener paramIImageUploadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploadListener = paramIImageUploadListener;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancel, path=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferImageUploadController;
      if (localObject != null)
      {
        ((ImageUploadController)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferImageUploadController.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader
 * JD-Core Version:    0.7.0.1
 */