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
  private int a;
  protected MediaPlayer a;
  protected SpriteNativeView a;
  protected boolean a;
  
  public ReadInJoySkinGuideView(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 2;
    LayoutInflater.from(getContext()).inflate(2131562708, this);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView = ((SpriteNativeView)findViewById(2131377644));
    setClickable(true);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == paramInt2) {
      this.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.post(new ReadInJoySkinGuideView.1(this, paramQQAppInterface, paramString2, paramOnClickListener1, paramString1, paramOnClickListener2, paramContext, paramInt1));
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.d();
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
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
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.pause();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView
 * JD-Core Version:    0.7.0.1
 */