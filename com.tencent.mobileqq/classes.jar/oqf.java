import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.widget.QQToast;

class oqf
  implements Runnable
{
  oqf(oqc paramoqc) {}
  
  public void run()
  {
    QQToast.a(SlideShowPhotoListManager.a(this.a.a), "处理失败，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqf
 * JD-Core Version:    0.7.0.1
 */