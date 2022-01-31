import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class suf
  implements suk
{
  private suf(suc paramsuc) {}
  
  public void a(sul paramsul)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    axeg localaxeg = axdo.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramsul.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    axdr localaxdr = localMessageForShortVideo.getDownloadInfo(localaxeg.b);
    if (paramsul.jdField_a_of_type_Int == 2)
    {
      localaxdr.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localaxdr.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localaxeg.a(localaxdr);
      localaxeg.a(new sug(this, paramsul.jdField_a_of_type_JavaLangString));
      axdo.a(localaxeg, localQQAppInterface);
      veg.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramsul }));
      return;
      localaxdr.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localaxdr.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(sul paramsul) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suf
 * JD-Core Version:    0.7.0.1
 */