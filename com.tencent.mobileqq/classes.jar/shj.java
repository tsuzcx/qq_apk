import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class shj
  implements sho
{
  private shj(shg paramshg) {}
  
  public void a(shp paramshp)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    awey localawey = aweg.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramshp.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    awej localawej = localMessageForShortVideo.getDownloadInfo(localawey.b);
    if (paramshp.jdField_a_of_type_Int == 2)
    {
      localawej.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localawej.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localawey.a(localawej);
      localawey.a(new shk(this, paramshp.jdField_a_of_type_JavaLangString));
      aweg.a(localawey, localQQAppInterface);
      urk.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramshp }));
      return;
      localawej.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localawej.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(shp paramshp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shj
 * JD-Core Version:    0.7.0.1
 */