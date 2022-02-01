package com.tencent.qqmini.minigame.manager;

import android.view.ViewGroup;
import com.tencent.qqmini.minigame.widget.CustomButton;
import java.util.Map;

class CustomButtonManager$2
  implements Runnable
{
  CustomButtonManager$2(CustomButtonManager paramCustomButtonManager, long paramLong) {}
  
  public void run()
  {
    CustomButton localCustomButton = (CustomButton)CustomButtonManager.access$000(this.this$0).get(Long.valueOf(this.val$componentId));
    CustomButtonManager.access$000(this.this$0).remove(Long.valueOf(this.val$componentId));
    if (localCustomButton != null)
    {
      CustomButtonManager.access$100(this.this$0).removeView(localCustomButton.getButton());
      localCustomButton.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.CustomButtonManager.2
 * JD-Core Version:    0.7.0.1
 */