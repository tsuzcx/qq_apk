package me.ele.uetool;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class UETMenu$MyHandler
  extends Handler
{
  WeakReference<UETMenu> uetMenu;
  
  UETMenu$MyHandler(UETMenu paramUETMenu)
  {
    this.uetMenu = new WeakReference(paramUETMenu);
  }
  
  public void handleMessage(Message arg1)
  {
    if (System.currentTimeMillis() - UETMenu.access$100((UETMenu)this.uetMenu.get()) < 4500L) {
      return;
    }
    synchronized ((UETMenu)this.uetMenu.get())
    {
      if (UETMenu.access$400((UETMenu)this.uetMenu.get())) {
        UETMenu.access$1200((UETMenu)this.uetMenu.get());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETMenu.MyHandler
 * JD-Core Version:    0.7.0.1
 */