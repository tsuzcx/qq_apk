package com.tencent.tavcut.cover;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VideoImageExtractor
{
  private List<Bitmap> mBitMapList;
  private CountDownLatch mCountDownLatch;
  private int mCoverHeight;
  private CoverProvider mCoverProvider;
  private int mCoverWidth;
  private TAVSource mTavSource;
  private List<CMTime> mTimeInfo;
  
  private List<CMTime> getCMTimeInfos(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(CMTime.fromMs(((Long)paramList.next()).longValue()));
    }
    return localArrayList;
  }
  
  public List<Bitmap> extractImages()
  {
    if (this.mCoverProvider != null) {
      HandlerUtils.getMainHandler().postDelayed(new VideoImageExtractor.2(this), 300L);
    }
    try
    {
      this.mCountDownLatch.await();
      return this.mBitMapList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void initCoverProvider(List<Long> paramList, @NonNull TAVSource paramTAVSource, CGSize paramCGSize, int paramInt)
  {
    this.mBitMapList = new ArrayList();
    this.mTimeInfo = getCMTimeInfos(paramList);
    this.mCoverHeight = ((int)paramCGSize.height);
    this.mCoverWidth = ((int)paramCGSize.width);
    Logger.i("VideoImageExtractor", "width = " + this.mCoverWidth + "height = " + this.mCoverHeight);
    float f;
    if (paramInt > 0)
    {
      f = this.mCoverWidth * 1.0F / this.mCoverHeight;
      if (this.mCoverHeight <= this.mCoverWidth) {
        break label255;
      }
      if (this.mCoverHeight > paramInt)
      {
        this.mCoverHeight = paramInt;
        this.mCoverWidth = ((int)(f * this.mCoverHeight));
      }
    }
    for (;;)
    {
      Logger.i("VideoImageExtractor", "scaled width = " + this.mCoverWidth + "height = " + this.mCoverHeight);
      this.mTavSource = paramTAVSource;
      if (this.mCoverProvider == null)
      {
        this.mCoverProvider = new CoverProvider();
        paramTAVSource = new RenderContextParams();
        paramTAVSource.putParam("video_cover", "video_cover_param");
        this.mCoverProvider.setRenderContextParams(paramTAVSource);
        this.mCountDownLatch = new CountDownLatch(paramList.size());
        this.mCoverProvider.setCoverListener(new VideoImageExtractor.1(this));
      }
      return;
      label255:
      if (this.mCoverWidth > paramInt)
      {
        this.mCoverWidth = paramInt;
        this.mCoverHeight = ((int)(this.mCoverWidth / f));
      }
    }
  }
  
  public void release()
  {
    this.mCoverProvider.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.cover.VideoImageExtractor
 * JD-Core Version:    0.7.0.1
 */