package me.ele.uetool.view;

import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.dialog.MultipleAttrsDialog;
import me.ele.uetool.dialog.MultipleAttrsDialog.ValidCallBack;

class EditAttrLayout$MultipleChosenMode$2
  implements MultipleAttrsDialog.ValidCallBack
{
  EditAttrLayout$MultipleChosenMode$2(EditAttrLayout.MultipleChosenMode paramMultipleChosenMode, MultipleAttrsDialog paramMultipleAttrsDialog) {}
  
  public void selectView(Element paramElement)
  {
    this.val$multipleAttrsDialog.dismiss();
    if (paramElement != null)
    {
      if (!EditAttrLayout.access$700(this.this$1.this$0).contains(paramElement)) {
        break label58;
      }
      EditAttrLayout.access$700(this.this$1.this$0).remove(paramElement);
    }
    for (;;)
    {
      this.this$1.this$0.invalidate();
      return;
      label58:
      EditAttrLayout.access$700(this.this$1.this$0).add(paramElement);
    }
  }
  
  public void validView(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.val$multipleAttrsDialog.notifyValidViewItemInserted(paramInt + 1, this.this$1.this$0.getTargetElements(EditAttrLayout.access$000(this.this$1.this$0), EditAttrLayout.access$100(this.this$1.this$0)), EditAttrLayout.access$300(this.this$1.this$0));
      return;
    }
    this.val$multipleAttrsDialog.notifyItemRangeRemoved(paramInt + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.MultipleChosenMode.2
 * JD-Core Version:    0.7.0.1
 */