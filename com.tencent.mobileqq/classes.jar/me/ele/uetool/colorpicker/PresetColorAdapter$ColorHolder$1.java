package me.ele.uetool.colorpicker;

import android.view.View;
import android.view.View.OnClickListener;

class PresetColorAdapter$ColorHolder$1
  implements View.OnClickListener
{
  PresetColorAdapter$ColorHolder$1(PresetColorAdapter.ColorHolder paramColorHolder, PresetColorAdapter paramPresetColorAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = this.this$1;
    boolean bool;
    if (!this.this$1.isChosen)
    {
      bool = true;
      paramView.isChosen = bool;
      this.this$1.roundView.setChosen(this.this$1.isChosen);
      PresetColorAdapter.access$000(this.this$1.this$0).setColor(this.this$1.color);
      if (!this.this$1.isChosen) {
        break label117;
      }
      if (PresetColorAdapter.access$100(this.this$1.this$0) != null) {
        PresetColorAdapter.access$100(this.this$1.this$0).setChosen(false);
      }
      PresetColorAdapter.access$102(this.this$1.this$0, this.this$1);
    }
    label117:
    while (PresetColorAdapter.access$100(this.this$1.this$0) != this.this$1)
    {
      return;
      bool = false;
      break;
    }
    PresetColorAdapter.access$102(this.this$1.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.colorpicker.PresetColorAdapter.ColorHolder.1
 * JD-Core Version:    0.7.0.1
 */