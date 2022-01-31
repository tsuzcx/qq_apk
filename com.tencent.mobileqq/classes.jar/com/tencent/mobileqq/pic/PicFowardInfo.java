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
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1000) || (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1020) || (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b == 1004)) && (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b + ",secondId:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int);
      return false;
    }
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicFowardInfo
 * JD-Core Version:    0.7.0.1
 */