package com.tencent.mobileqq.vas.floatscreen;

import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;

class ColorScreenManager$1
  implements Runnable
{
  ColorScreenManager$1(ColorScreenManager paramColorScreenManager, int paramInt, VasManager.CompleteListener paramCompleteListener) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("colorScreen.android.");
    ((StringBuilder)localObject).append(this.a);
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.a((String)localObject, this.b, null);
    ColorScreenConfig localColorScreenConfig = ColorScreenManager.a(this.this$0, this.a);
    if (localColorScreenConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
      }
      ColorScreenManager.b(this.this$0, this.a);
      return;
    }
    this.this$0.a((String)localObject, localColorScreenConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.floatscreen.ColorScreenManager.1
 * JD-Core Version:    0.7.0.1
 */