package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.quickupdate.MusicPlayerCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;

class FloatViewSkin$3
  implements QuickUpdateListener
{
  FloatViewSkin$3(FloatViewSkin paramFloatViewSkin) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString1 = MusicPlayerCallback.sInstance.getDir(BaseApplicationImpl.getContext(), paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (FloatViewSkin.a(this.a) != null))
    {
      FloatViewSkin.a(this.a, true);
      this.a.b(paramString1);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onCompleted: mSkinRootPath");
        paramString1.append(this.a.c);
        paramString1.append(" mIsUserSkin=");
        paramString1.append(this.a.d);
        QLog.i("FloatViewSkin", 2, paramString1.toString());
      }
      if (this.a.d) {
        ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.3.1(this));
      }
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.3
 * JD-Core Version:    0.7.0.1
 */