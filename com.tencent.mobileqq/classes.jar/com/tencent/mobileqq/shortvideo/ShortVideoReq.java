package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import java.util.ArrayList;

public class ShortVideoReq
  implements Comparable<ShortVideoReq>
{
  public int a;
  public long a;
  public MessageForShortVideo a;
  public ShortVideoDownloadInfo a;
  public ShortVideoForwardInfo a;
  public ShortVideoUploadInfo a;
  public UiCallBack a;
  public VideoDownCallback a;
  public String a;
  public ArrayList<ShortVideoForwardInfo> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public ShortVideoReq()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = PicReq.a();
  }
  
  public int a(ShortVideoReq paramShortVideoReq)
  {
    int i = this.e;
    int j = paramShortVideoReq.e;
    if (i < j) {
      return -1;
    }
    if (i > j) {
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
    if (paramShortVideoDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramShortVideoDownloadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo = paramShortVideoDownloadInfo;
    int j = paramShortVideoDownloadInfo.e;
    int i = 6;
    if (j == 1002) {
      i = 7;
    } else if (paramShortVideoDownloadInfo.e == 1006) {
      i = 18;
    } else if (paramShortVideoDownloadInfo.e == 1004) {
      i = 16;
    } else if (paramShortVideoDownloadInfo.e != 1001) {
      if (paramShortVideoDownloadInfo.e == 1005) {
        i = 17;
      } else if (paramShortVideoDownloadInfo.e == 1003) {
        i = 9;
      }
    }
    this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_b_of_type_Int, 0, i);
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
    if (paramShortVideoUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramShortVideoUploadInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
    int j = paramShortVideoUploadInfo.jdField_b_of_type_Int;
    int i = 6;
    if (j != 0) {
      if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
    this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_b_of_type_Int, 1, i);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoReq
 * JD-Core Version:    0.7.0.1
 */