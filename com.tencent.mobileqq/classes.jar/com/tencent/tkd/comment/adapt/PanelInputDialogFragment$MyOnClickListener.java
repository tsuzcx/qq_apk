package com.tencent.tkd.comment.adapt;

import android.view.View;
import android.view.View.OnClickListener;

class PanelInputDialogFragment$MyOnClickListener
  implements View.OnClickListener
{
  private PanelInputDialogFragment$MyOnClickListener(PanelInputDialogFragment paramPanelInputDialogFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView == PanelInputDialogFragment.access$300(this.this$0))
    {
      this.this$0.dismiss();
      return;
    }
    if (paramView == PanelInputDialogFragment.access$400(this.this$0)) {
      this.this$0.changeState(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.PanelInputDialogFragment.MyOnClickListener
 * JD-Core Version:    0.7.0.1
 */