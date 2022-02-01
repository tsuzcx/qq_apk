package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.utils.FileUtils;

public class PicFowardInfo
  extends PicInfoInterface
  implements PicUiInterface
{
  public int a;
  public PicDownloadInfo a;
  public PicUploadInfo a;
  public boolean a;
  public boolean b = true;
  
  public PicFowardInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = new PicUploadInfo();
    this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = new PicDownloadInfo();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    if (localObject != null) {
      localObject = ((PicUploadInfo)localObject).a();
    } else {
      localObject = "\n |-upInfo=null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    if (localObject == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((((PicUploadInfo)localObject).b == 1000) || (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1020) || (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1004)) && (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d == null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("secondId invalid,uinType:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b);
      ((StringBuilder)localObject).append(",secondId:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d);
      a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("protocolType invalid,protocolType:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int);
      a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
      if (localObject == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!((PicDownloadInfo)localObject).a())
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
        return false;
      }
    }
    return true;
  }
  
  public PicDownloadInfo getPicDownloadInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
  }
  
  public PicUploadInfo getPicUploadInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
  }
  
  public boolean isSendFromLocal()
  {
    return this.b;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicFowardInfo
 * JD-Core Version:    0.7.0.1
 */