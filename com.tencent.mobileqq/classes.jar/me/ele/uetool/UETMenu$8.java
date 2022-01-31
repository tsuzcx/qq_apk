package me.ele.uetool;

import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class UETMenu$8
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  UETMenu$8(UETMenu paramUETMenu) {}
  
  public void onGlobalLayout()
  {
    UETMenu localUETMenu;
    if (UETMenu.access$1500(this.this$0))
    {
      UETMenu.access$1602(this.this$0, UETMenu.access$1700(this.this$0).getWidth());
      UETMenu.access$1700(this.this$0).setVisibility(8);
      localUETMenu = this.this$0;
      if (UETMenu.access$1500(this.this$0)) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      UETMenu.access$1502(localUETMenu, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETMenu.8
 * JD-Core Version:    0.7.0.1
 */