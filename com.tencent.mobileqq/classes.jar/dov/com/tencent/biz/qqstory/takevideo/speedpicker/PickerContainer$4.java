package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.widget.ImageView;
import bnqi;
import bnqy;

class PickerContainer$4
  implements Runnable
{
  PickerContainer$4(PickerContainer paramPickerContainer, String paramString) {}
  
  public void run()
  {
    bnqy localbnqy;
    if ((PickerContainer.a(this.this$0) != null) && (PickerContainer.a(this.this$0).a(this.a)))
    {
      PickerContainer.a(this.this$0).stop();
      localbnqy = PickerContainer.a(this.this$0);
      if (PickerContainer.b(this.this$0)) {
        break label167;
      }
    }
    label167:
    for (boolean bool = true;; bool = false)
    {
      localbnqy.a(bool);
      PickerContainer.a(this.this$0).a(1);
      PickerContainer.a(this.this$0).start();
      if (PickerContainer.a(this.this$0) != null) {
        PickerContainer.a(this.this$0).setVisibility(0);
      }
      if ((!PickerContainer.b(this.this$0)) && (PickerContainer.a(this.this$0) != null))
      {
        PickerContainer.a(this.this$0).stop();
        PickerContainer.a(this.this$0).a(true);
        PickerContainer.a(this.this$0).a(1);
        PickerContainer.a(this.this$0).start();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer.4
 * JD-Core Version:    0.7.0.1
 */