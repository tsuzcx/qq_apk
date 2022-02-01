package com.tencent.mobileqq.winkpublish.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StFeed;

public class PublishVideoView
  extends PublishAbsBaseVideoView
{
  private SeekBar g;
  private int h;
  
  public PublishVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PublishVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PublishVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (((FeedCloudMeta.StFeed)getData() != null) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(":");
      localStringBuilder.append(paramInt1);
      localStringBuilder.toString();
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    this.h = paramInt;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public SeekBar getProgressBar()
  {
    return this.g;
  }
  
  protected void n()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  public void setProgressBar(SeekBar paramSeekBar)
  {
    this.g = paramSeekBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.PublishVideoView
 * JD-Core Version:    0.7.0.1
 */