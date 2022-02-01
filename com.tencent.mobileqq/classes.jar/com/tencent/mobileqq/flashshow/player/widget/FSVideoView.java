package com.tencent.mobileqq.flashshow.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class FSVideoView
  extends FSAbsBaseVideoView
{
  private SeekBar g;
  private int h;
  
  public FSVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(localStFeed, getReportBean()).a(2).b(6).a(localStFeed.poster.id.get()).g(this.h).f(2).a(paramLong1).b(paramLong2).a(true));
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(localStFeed, getReportBean()).a(2).b(9).a(localStFeed.poster.id.get()).g(this.h).f(2).a(paramLong1).b(paramLong2).p(String.valueOf(paramLong3)).u(String.valueOf(paramLong4)).a(true));
    }
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null)
    {
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(paramInt1);
        localObject = ((StringBuilder)localObject).toString();
      }
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(localStFeed, getReportBean()).a(2).b(7).a(localStFeed.poster.id.get()).g(this.h).f(2).a(paramLong1).b(paramLong2).a(true).l((String)localObject));
    }
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
    if (localStFeed != null) {
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(localStFeed, getReportBean()).a(2).b(4).a(localStFeed.poster.id.get()).g(this.h).f(2).a(true));
    }
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  public void setProgressBar(SeekBar paramSeekBar)
  {
    this.g = paramSeekBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSVideoView
 * JD-Core Version:    0.7.0.1
 */