package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.widget.VideoView;
import bnhy;
import bnhz;
import bnia;

public class FixedSizeVideoView
  extends VideoView
{
  private int jdField_a_of_type_Int = -1;
  public bnia a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new FixedSizeVideoView.1(this);
  private int b;
  private int c;
  
  public FixedSizeVideoView(Context paramContext)
  {
    super(paramContext);
    super.setOnCompletionListener(new bnhy(this));
  }
  
  public FixedSizeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnCompletionListener(new bnhz(this));
  }
  
  public void pause()
  {
    super.pause();
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnFixVDPlayCompelteListener(bnia parambnia)
  {
    if (parambnia != null) {
      this.jdField_a_of_type_Bnia = parambnia;
    }
  }
  
  public void setPlayDuration(int paramInt)
  {
    setPlayDuration(0, paramInt);
  }
  
  public void setPlayDuration(int paramInt1, int paramInt2)
  {
    try
    {
      int i = getDuration();
      if (paramInt1 >= i) {
        return;
      }
      int j = paramInt2 + paramInt1;
      this.b = j;
      if (j > i) {
        this.b = i;
      }
      this.c = paramInt1;
      this.jdField_a_of_type_Int = paramInt2;
      seekTo(paramInt1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    int i = getCurrentPosition();
    i = this.b - i;
    if (i >= 0)
    {
      super.start();
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView
 * JD-Core Version:    0.7.0.1
 */