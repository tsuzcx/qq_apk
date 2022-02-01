package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoySkinGuideView
  extends RelativeLayout
{
  protected SpriteNativeView a;
  protected boolean b = false;
  protected MediaPlayer c;
  private int d = 2;
  
  public ReadInJoySkinGuideView(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2131629141, this);
    this.a = ((SpriteNativeView)findViewById(2131446056));
    setClickable(true);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == paramInt2) {
      this.d = 1;
    }
    this.a.post(new ReadInJoySkinGuideView.1(this, paramQQAppInterface, paramString2, paramOnClickListener1, paramString1, paramOnClickListener2, paramContext, paramInt1));
  }
  
  public void a()
  {
    if (!this.b)
    {
      this.b = true;
      this.a.d();
    }
    MediaPlayer localMediaPlayer = this.c;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.stop();
        this.c.release();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void b()
  {
    MediaPlayer localMediaPlayer = this.c;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.pause();
        this.c.seekTo(0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(localException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView
 * JD-Core Version:    0.7.0.1
 */