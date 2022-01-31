package com.tencent.mobileqq.extendfriend.wiget;

import aqbo;
import aqcy;
import aqec;
import bdkf;
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
      localObject = aqcy.a("expand_voice_animation.json");
      j = bdkf.a(19.0F);
    }
    for (int i = bdkf.a(19.0F);; i = bdkf.a(17.0F))
    {
      try
      {
        localObject = new BufferedInputStream(new FileInputStream((String)localObject));
        LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new aqec(this, j, i));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", localException);
      }
      localObject = aqbo.a("expand_voice_animation2.json");
      j = bdkf.a(16.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.1
 * JD-Core Version:    0.7.0.1
 */