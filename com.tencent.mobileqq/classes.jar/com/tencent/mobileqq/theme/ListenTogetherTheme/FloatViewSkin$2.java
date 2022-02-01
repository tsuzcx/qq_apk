package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.os.Handler;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.quickupdate.MusicPlayerCallback;
import com.tencent.qphone.base.util.QLog;

class FloatViewSkin$2
  implements IApolloExtensionObserver
{
  FloatViewSkin$2(FloatViewSkin paramFloatViewSkin) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 36) && ((paramObject instanceof Integer)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mMusicBusinessObserver: isSuccess");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("  music player id:");
        localStringBuilder.append(paramObject);
        QLog.i("FloatViewSkin", 2, localStringBuilder.toString());
      }
      paramInt = ((Integer)paramObject).intValue();
      FloatViewSkin.a(this.a, paramInt);
      if (paramInt > 0)
      {
        this.a.a(true);
        MusicPlayerCallback.sInstance.download(FloatViewSkin.a(this.a), FloatViewSkin.a(this.a), false);
        return;
      }
      this.a.a(false);
      ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.2
 * JD-Core Version:    0.7.0.1
 */