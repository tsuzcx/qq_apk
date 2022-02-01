package com.tencent.mobileqq.jsp;

import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;

class TeleScreenApiPlugin$1
  implements JumpCallback
{
  TeleScreenApiPlugin$1(TeleScreenApiPlugin paramTeleScreenApiPlugin, String paramString) {}
  
  public void onJump(int paramInt1, int paramInt2)
  {
    if (TeleScreenApiPlugin.a(this.b) != null) {
      TeleScreenApiPlugin.a(this.b).remove(Integer.valueOf(paramInt1));
    }
    TeleScreen.a().a(paramInt1);
    TeleScreenApiPlugin localTeleScreenApiPlugin = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"openresult\":");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("}");
    localTeleScreenApiPlugin.callJs(str, new String[] { localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TeleScreenApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */