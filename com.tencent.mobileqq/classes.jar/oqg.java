import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;

class oqg
  implements Runnable
{
  oqg(oqc paramoqc, TransitionHandler paramTransitionHandler) {}
  
  public void run()
  {
    SlideShowPhotoListManager.b(this.jdField_a_of_type_Oqc.a, false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowTransitionHandler != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowTransitionHandler.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqg
 * JD-Core Version:    0.7.0.1
 */