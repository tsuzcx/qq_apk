package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import java.util.ArrayList;

public class ShortVideoReq
  implements Comparable
{
  public int a;
  public MessageForShortVideo a;
  public ShortVideoDownloadInfo a;
  public ShortVideoForwardInfo a;
  public ShortVideoUploadInfo a;
  public UiCallBack a;
  public String a;
  public ArrayList a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  
  public ShortVideoReq()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = PicReq.a();
  }
  
  public int a(ShortVideoReq paramShortVideoReq)
  {
    if (this.e < paramShortVideoReq.e) {
      return -1;
    }
    if (this.e > paramShortVideoReq.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    int j = 6;
    if (paramShortVideoDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramShortVideoDownloadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo = paramShortVideoDownloadInfo;
    int i;
    if (paramShortVideoDownloadInfo.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_b_of_type_Int, 0, i);
      return;
      if (paramShortVideoDownloadInfo.e == 1006)
      {
        i = 18;
      }
      else if (paramShortVideoDownloadInfo.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramShortVideoDownloadInfo.e != 1001) {
          if (paramShortVideoDownloadInfo.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramShortVideoDownloadInfo.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    if (paramShortVideoForwardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramShortVideoForwardInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo = paramShortVideoForwardInfo;
    this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int i = 6;
    if (paramShortVideoUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramShortVideoUploadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
    if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_b_of_type_Int, 1, i);
      return;
      if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoReq
 * JD-Core Version:    0.7.0.1
 */