package com.tencent.mobileqq.winkpublish.view;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.winkpublish.player.widget.PublishBaseVideoView;
import com.tencent.superplayer.api.ISuperPlayer;

public class PublishPreviewVideo
  extends PublishBaseVideoView
{
  public PublishPreviewVideo(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PublishPreviewVideo(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PublishPreviewVideo(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  protected void b(long paramLong1, long paramLong2) {}
  
  protected void bindData(Object paramObject, int paramInt)
  {
    setVideoPath(null, (String)paramObject, paramInt);
  }
  
  protected void f()
  {
    super.f();
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public SeekBar getProgressBar()
  {
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  protected void n() {}
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  protected boolean p()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.PublishPreviewVideo
 * JD-Core Version:    0.7.0.1
 */