import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class suc
  implements suh
{
  private suc(stz paramstz) {}
  
  public void a(sui paramsui)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    axei localaxei = axdq.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramsui.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    axdt localaxdt = localMessageForShortVideo.getDownloadInfo(localaxei.b);
    if (paramsui.jdField_a_of_type_Int == 2)
    {
      localaxdt.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localaxdt.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localaxei.a(localaxdt);
      localaxei.a(new sud(this, paramsui.jdField_a_of_type_JavaLangString));
      axdq.a(localaxei, localQQAppInterface);
      ved.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramsui }));
      return;
      localaxdt.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localaxdt.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(sui paramsui) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suc
 * JD-Core Version:    0.7.0.1
 */