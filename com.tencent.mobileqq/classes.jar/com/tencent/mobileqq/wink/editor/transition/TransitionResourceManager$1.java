package com.tencent.mobileqq.wink.editor.transition;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.util.ArrayList;

class TransitionResourceManager$1
  implements Runnable
{
  TransitionResourceManager$1(TransitionResourceManager paramTransitionResourceManager, Context paramContext) {}
  
  public void run()
  {
    try
    {
      String[] arrayOfString = this.a.getAssets().list("pag");
      Object localObject;
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject = arrayOfString[i];
          if (TransitionResourceManager.a.contains(TransitionResourceManager.a((String)localObject))) {
            TransitionResourceManager.a(this.this$0, this.a, (String)localObject);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("releasePagFilesToData, exception = ");
      ((StringBuilder)localObject).append(localException.toString());
      WinkQLog.a("TransitionResourceManager", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager.1
 * JD-Core Version:    0.7.0.1
 */