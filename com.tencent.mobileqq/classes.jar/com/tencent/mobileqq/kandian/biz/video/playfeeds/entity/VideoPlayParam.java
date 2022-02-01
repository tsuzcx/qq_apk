package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;

public class VideoPlayParam
{
  public ViewGroup a;
  public View b;
  public VideoInfo c;
  public int d = 0;
  public AbsReadInJoyVideoReportData e;
  public ReadinjoyAdVideoReportData f;
  public Bundle g = new Bundle();
  public IVideoPlayerWrapper h;
  public boolean i;
  public long j;
  public int k;
  public boolean l;
  public String m;
  public boolean n;
  public IVideoUIDelegate o;
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.g.getBoolean(paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    try
    {
      this.g.putBoolean(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */