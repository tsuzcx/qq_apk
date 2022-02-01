package com.tencent.mobileqq.qqexpand.widget.voice;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

class OldExpandVoiceView$1
  implements Runnable
{
  OldExpandVoiceView$1(OldExpandVoiceView paramOldExpandVoiceView) {}
  
  public void run()
  {
    Object localObject;
    int j;
    int i;
    if (OldExpandVoiceView.a(this.this$0) == 0)
    {
      localObject = ExpandResourceUtil.a("expand_voice_animation.json");
      j = ViewUtils.dip2px(19.0F);
      i = ViewUtils.dip2px(19.0F);
    }
    else
    {
      localObject = ExpandLimitChatResourceUtil.b("expand_voice_animation2.json");
      j = ViewUtils.dip2px(16.0F);
      i = ViewUtils.dip2px(17.0F);
    }
    try
    {
      localObject = new BufferedInputStream(new FileInputStream((String)localObject));
      LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new OldExpandVoiceView.1.1(this, j, i));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.1
 * JD-Core Version:    0.7.0.1
 */