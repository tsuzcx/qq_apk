import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class oqd
  implements Runnable
{
  oqd(oqc paramoqc) {}
  
  public void run()
  {
    if (SlideShowPhotoListManager.a(this.a.a) != null) {
      SlideShowPhotoListManager.a(this.a.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqd
 * JD-Core Version:    0.7.0.1
 */