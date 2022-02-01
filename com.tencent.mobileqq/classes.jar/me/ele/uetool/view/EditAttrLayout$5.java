package me.ele.uetool.view;

import me.ele.uetool.base.Element;
import me.ele.uetool.dialog.AttrsDialog.AttrDialogTouchCallback;

class EditAttrLayout$5
  implements AttrsDialog.AttrDialogTouchCallback
{
  EditAttrLayout$5(EditAttrLayout paramEditAttrLayout) {}
  
  public void touch(float paramFloat1, float paramFloat2)
  {
    Object localObject = new int[2];
    this.this$0.getLocationOnScreen((int[])localObject);
    float f1 = localObject[0];
    float f2 = localObject[1];
    if (EditAttrLayout.access$600(this.this$0) != null) {
      EditAttrLayout.access$602(this.this$0, null);
    }
    localObject = this.this$0.getTargetElement(paramFloat1 - f1, paramFloat2 - f2);
    this.this$0.clickAndShow((Element)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.5
 * JD-Core Version:    0.7.0.1
 */