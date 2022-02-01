package com.tencent.tkd.comment.adapt;

class PanelInputDialogFragment$1
  implements OnKeyboardChangeListener
{
  PanelInputDialogFragment$1(PanelInputDialogFragment paramPanelInputDialogFragment) {}
  
  public void onPanelHeightChange(int paramInt)
  {
    PanelInputDialogFragment.access$200(this.this$0).setPanelHeight(paramInt);
  }
  
  public void onVisibilityChange(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.changeState(1);
      return;
    }
    switch (PanelInputDialogFragment.access$100(this.this$0))
    {
    default: 
      return;
    }
    this.this$0.changeState(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.PanelInputDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */