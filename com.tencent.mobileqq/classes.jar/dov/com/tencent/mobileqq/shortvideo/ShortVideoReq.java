package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.PicReq;
import java.util.ArrayList;

public class ShortVideoReq
  implements Comparable<ShortVideoReq>
{
  public int a;
  public MessageForShortVideo a;
  public ShortVideoDownloadInfo a;
  public ShortVideoForwardInfo a;
  public ShortVideoUploadInfo a;
  public UiCallBack a;
  public String a;
  public ArrayList<ShortVideoForwardInfo> a;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoReq
 * JD-Core Version:    0.7.0.1
 */