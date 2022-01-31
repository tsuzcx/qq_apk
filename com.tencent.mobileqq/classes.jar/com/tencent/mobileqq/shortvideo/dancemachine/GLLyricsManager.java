package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;

public class GLLyricsManager
{
  private GLViewContext mContext;
  private String mKey;
  private GLLyricsView mLyricsView;
  private long mStartRecordMis;
  
  public GLLyricsManager(GLViewContext paramGLViewContext, String paramString)
  {
    this.mContext = paramGLViewContext;
    this.mKey = paramString;
    this.mLyricsView = new GLLyricsView(this.mContext, this.mKey);
    this.mLyricsView.setTextSize(DisplayUtils.pixelToRealPixel(56.0F));
    this.mLyricsView.setShadowPadding(DisplayUtils.pixelToRealPixel(20.0F));
  }
  
  private void ResetLyricsViewLayout(String paramString)
  {
    if (paramString == null)
    {
      this.mLyricsView.setVisibility(false);
      return;
    }
    this.mLyricsView.clearTextCache();
    this.mLyricsView.setText(paramString, -1);
    paramString = this.mContext.getSurfaceViewSize();
    int i = paramString.width();
    int j = paramString.height();
    paramString = new RectF(0.0F, 0.0F, i, j);
    float f1 = (i - this.mLyricsView.getTextWidth() - this.mLyricsView.getShadowPadding()) / 2.0F;
    float f2 = j - DisplayUtils.pixelToRealPixel(100.0F) - this.mLyricsView.getTextHeight() - this.mLyricsView.getShadowPadding();
    paramString.set(f1, f2, i - f1, this.mLyricsView.getTextHeight() + f2 + this.mLyricsView.getShadowPadding());
    this.mLyricsView.setImageRegion(paramString);
    this.mLyricsView.setImageClipDrawRegion(paramString);
    this.mLyricsView.setVisibility(true);
  }
  
  private int calculateNewStatus(ResourceManager.LyricItem paramLyricItem)
  {
    long l = SystemClock.uptimeMillis() - this.mStartRecordMis;
    if (paramLyricItem.startTime > l) {
      return 0;
    }
    if ((paramLyricItem.startTime <= l) && (paramLyricItem.endTime > l)) {
      return 1;
    }
    return 2;
  }
  
  public void clearStatus()
  {
    this.mStartRecordMis = 0L;
    this.mLyricsView.setVisibility(false);
  }
  
  public void drawFrame()
  {
    Object localObject = ResourceManager.getInstance().getLyricsList();
    if ((localObject != null) && (((List)localObject).size() > 0) && (this.mStartRecordMis > 0L)) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      ResourceManager.LyricItem localLyricItem;
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localLyricItem = (ResourceManager.LyricItem)((Iterator)localObject).next();
        if (localLyricItem.status == 2) {
          continue;
        }
        if (localLyricItem.status != 1) {
          break label108;
        }
        i = calculateNewStatus(localLyricItem);
        if (i == 2)
        {
          ResetLyricsViewLayout(null);
          localLyricItem.status = i;
          continue;
        }
        if (i != 1) {
          continue;
        }
      }
      for (;;)
      {
        this.mLyricsView.draw();
        return;
        label108:
        i = calculateNewStatus(localLyricItem);
        if (i != 1) {
          break;
        }
        ResetLyricsViewLayout(localLyricItem.text);
        localLyricItem.status = i;
      }
      if (i == 2)
      {
        ResetLyricsViewLayout(null);
        localLyricItem.status = i;
      }
    }
  }
  
  public void updateStartTimestamp(long paramLong)
  {
    this.mStartRecordMis = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLyricsManager
 * JD-Core Version:    0.7.0.1
 */