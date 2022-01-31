package com.tencent.mobileqq.extendfriend.wiget;

import antz;
import anum;
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
    Object localObject = antz.a("expand_voice_animation.json");
    try
    {
      localObject = new BufferedInputStream(new FileInputStream((String)localObject));
      LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new anum(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.1
 * JD-Core Version:    0.7.0.1
 */