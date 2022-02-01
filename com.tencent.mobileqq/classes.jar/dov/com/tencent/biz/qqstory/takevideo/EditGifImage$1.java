package dov.com.tencent.biz.qqstory.takevideo;

import bqeb;
import bqgk;
import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;

class EditGifImage$1
  implements Runnable
{
  EditGifImage$1(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = this.this$0.b;
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    this.this$0.b = localFastAnimationDrawable;
    this.this$0.d = true;
    this.this$0.jdField_a_of_type_Bqgk.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditGifImage.1
 * JD-Core Version:    0.7.0.1
 */