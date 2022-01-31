package me.ele.uetool;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

public class UETSubMenu$ChangeStatus
  implements UETSubMenu.IchangeStatus
{
  public UETSubMenu$ChangeStatus(UETSubMenu paramUETSubMenu) {}
  
  public void changeStatus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UETSubMenu.access$100(this.this$0).setImageResource(UETSubMenu.access$000(this.this$0).getImageRes());
      UETSubMenu.access$200(this.this$0).setTextColor(Color.parseColor("#ffffff"));
      return;
    }
    UETSubMenu.access$100(this.this$0).setImageResource(UETSubMenu.access$000(this.this$0).getChosenImageRes());
    UETSubMenu.access$200(this.this$0).setTextColor(Color.parseColor("#000000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETSubMenu.ChangeStatus
 * JD-Core Version:    0.7.0.1
 */