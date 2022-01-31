package dov.com.tencent.mobileqq.shortvideo;

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
  public int c = 201;
  
  public ShortVideoReq()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = PicReq.a();
  }
  
  public int a(ShortVideoReq paramShortVideoReq)
  {
    if (this.c < paramShortVideoReq.c) {
      return -1;
    }
    if (this.c > paramShortVideoReq.c) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
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
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
    if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = Logger.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_b_of_type_Int, 1, i);
      return;
      if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramShortVideoUploadInfo.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoReq
 * JD-Core Version:    0.7.0.1
 */