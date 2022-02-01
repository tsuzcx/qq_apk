package com.tencent.mobileqq.extendfriend.wiget;

import atax;
import atcj;
import ateb;
import bhtq;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExtendFriendVoiceView$1
  implements Runnable
{
  ExtendFriendVoiceView$1(ExtendFriendVoiceView paramExtendFriendVoiceView) {}
  
  public void run()
  {
    Object localObject;
    int j;
    if (ExtendFriendVoiceView.a(this.this$0) == 0)
    {
      localObject = atcj.a("expand_voice_animation.json");
      j = bhtq.a(19.0F);
    }
    for (int i = bhtq.a(19.0F);; i = bhtq.a(17.0F))
    {
      try
      {
        localObject = new BufferedInputStream(new FileInputStream((String)localObject));
        LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new ateb(this, j, i));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", localException);
      }
      localObject = atax.a("expand_voice_animation2.json");
      j = bhtq.a(16.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.1
 * JD-Core Version:    0.7.0.1
 */