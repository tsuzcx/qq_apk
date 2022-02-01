package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVSource;
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
    if (this.mCoverProvider != null)
    {
      HandlerUtils.getMainHandler().postDelayed(new VideoImageExtractor.2(this), 300L);
      try
      {
        this.mCountDownLatch.await();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return this.mBitMapList;
  }
  
  public void initCoverProvider(List<Long> paramList, @NonNull TAVSource paramTAVSource, CGSize paramCGSize, int paramInt)
  {
    this.mBitMapList = new ArrayList();
    this.mTimeInfo = getCMTimeInfos(paramList);
    this.mCoverHeight = ((int)paramCGSize.height);
    this.mCoverWidth = ((int)paramCGSize.width);
    paramCGSize = new StringBuilder();
    paramCGSize.append("width = ");
    paramCGSize.append(this.mCoverWidth);
    paramCGSize.append("height = ");
    paramCGSize.append(this.mCoverHeight);
    Logger.i("VideoImageExtractor", paramCGSize.toString());
    if (paramInt > 0)
    {
      int i = this.mCoverWidth;
      float f = i;
      int j = this.mCoverHeight;
      f = f * 1.0F / j;
      if (j > i)
      {
        if (j > paramInt)
        {
          this.mCoverHeight = paramInt;
          this.mCoverWidth = ((int)(this.mCoverHeight * f));
        }
      }
      else if (i > paramInt)
      {
        this.mCoverWidth = paramInt;
        this.mCoverHeight = ((int)(this.mCoverWidth / f));
      }
    }
    paramCGSize = new StringBuilder();
    paramCGSize.append("scaled width = ");
    paramCGSize.append(this.mCoverWidth);
    paramCGSize.append("height = ");
    paramCGSize.append(this.mCoverHeight);
    Logger.i("VideoImageExtractor", paramCGSize.toString());
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
  }
  
  public void release()
  {
    this.mCoverProvider.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.cover.VideoImageExtractor
 * JD-Core Version:    0.7.0.1
 */