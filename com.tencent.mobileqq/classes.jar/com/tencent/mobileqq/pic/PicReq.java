package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class PicReq
  implements Comparable<PicReq>
{
  public int a;
  public ICompressionCallBack a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public PicDownloadInfo a;
  public PicFowardInfo a;
  public PicUploadInfo a;
  public UiCallBack a;
  public Object a;
  public String a;
  public ArrayList<PicFowardInfo> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public PicReq()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__");
    localStringBuilder.append(UUID.randomUUID().toString());
    return localStringBuilder.toString();
  }
  
  public int a(PicReq paramPicReq)
  {
    int i = this.e;
    int j = paramPicReq.e;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicUiCallBack = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
    if (paramString != null) {
      paramString.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    if (paramString != null) {
      paramString.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (paramString != null) {
      paramString.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<PicFowardInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)localIterator.next();
        if (localPicFowardInfo != null)
        {
          if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
          {
            localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          }
          if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
          {
            localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      this.jdField_b_of_type_JavaLangString = Logger.a(((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int, 2, 1);
      return;
    }
    Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
  }
  
  public boolean a(MessageForPic paramMessageForPic, PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicDownloadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramPicDownloadInfo.c = paramMessageForPic.time;
    paramPicDownloadInfo.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramPicDownloadInfo;
    int i = this.jdField_a_of_type_Int;
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatthumb";
      i = 65537;
    }
    else if (i == 7)
    {
      i = 131075;
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatraw";
    }
    else
    {
      if (i == 6) {
        this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatimg";
      }
      i = 1;
    }
    this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int, 0, i);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    return true;
  }
  
  public boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    paramCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if (paramCompressInfo.c == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    return true;
  }
  
  public boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo = paramPicFowardInfo;
    int i = -1;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {
      i = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = Logger.a(i, 2, 1);
    return true;
  }
  
  public boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicUploadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = paramPicUploadInfo;
    this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int, 1, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReq
 * JD-Core Version:    0.7.0.1
 */