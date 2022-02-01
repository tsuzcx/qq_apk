package com.tencent.thumbplayer.composition;

import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TPMediaCompositionTrack
  implements ITPMediaTrack, Serializable
{
  private static final String TAG = "TPMediaCompositionTrack";
  private List<ITPMediaTrackClip> mTrackClips;
  private int mTrackId = -1;
  private int mTrackType;
  
  public TPMediaCompositionTrack(int paramInt)
  {
    this.mTrackType = paramInt;
    this.mTrackClips = new ArrayList();
  }
  
  public TPMediaCompositionTrack(int paramInt1, int paramInt2)
  {
    this.mTrackId = paramInt1;
    this.mTrackType = paramInt2;
    this.mTrackClips = new ArrayList();
  }
  
  private void checkClipValid(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    if (paramITPMediaTrackClip != null) {}
    try
    {
      int i = paramITPMediaTrackClip.getMediaType();
      int j = this.mTrackType;
      if (i == j) {
        return;
      }
      throw new IllegalArgumentException("add track clip failed, media type is not same");
    }
    finally
    {
      label46:
      break label46;
    }
    throw new IllegalArgumentException("add track clip , clip can not be null");
    throw paramITPMediaTrackClip;
  }
  
  public int addTrackClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    try
    {
      checkClipValid(paramITPMediaTrackClip);
      if (this.mTrackClips.contains(paramITPMediaTrackClip))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add track clip failed, clip already exists : ");
        localStringBuilder.append(paramITPMediaTrackClip.getClipId());
        TPLogUtil.i("TPMediaCompositionTrack", localStringBuilder.toString());
        i = paramITPMediaTrackClip.getClipId();
        return i;
      }
      this.mTrackClips.add(paramITPMediaTrackClip);
      int i = paramITPMediaTrackClip.getClipId();
      return i;
    }
    finally {}
  }
  
  public List<ITPMediaTrackClip> getAllTrackClips()
  {
    try
    {
      List localList = this.mTrackClips;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMediaType()
  {
    try
    {
      int i = this.mTrackType;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getTimelineDurationMs()
  {
    long l1 = 0L;
    try
    {
      Iterator localIterator = this.mTrackClips.iterator();
      while (localIterator.hasNext())
      {
        long l2 = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs();
        l1 += l2;
      }
      return l1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public ITPMediaTrackClip getTrackClip(int paramInt)
  {
    try
    {
      Iterator localIterator = this.mTrackClips.iterator();
      while (localIterator.hasNext())
      {
        ITPMediaTrackClip localITPMediaTrackClip = (ITPMediaTrackClip)localIterator.next();
        int i = localITPMediaTrackClip.getClipId();
        if (i == paramInt) {
          return localITPMediaTrackClip;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int getTrackId()
  {
    try
    {
      int i = this.mTrackId;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String getUrl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/thumbplayer/composition/TPMediaCompositionTrack:mTrackClips	Ljava/util/List;
    //   6: aload_0
    //   7: getfield 27	com/tencent/thumbplayer/composition/TPMediaCompositionTrack:mTrackType	I
    //   10: invokestatic 124	com/tencent/thumbplayer/composition/TPMediaCompositionXmlGenerator:buildXmlPathFromTrackInfo	(Ljava/util/List;I)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: astore_1
    //   19: goto +14 -> 33
    //   22: astore_1
    //   23: ldc 12
    //   25: aload_1
    //   26: invokestatic 128	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	TPMediaCompositionTrack
    //   13	4	1	str	String
    //   18	1	1	localObject	Object
    //   22	14	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
    //   23	29	18	finally
    //   2	14	22	java/io/IOException
  }
  
  public int insertTrackClip(ITPMediaTrackClip paramITPMediaTrackClip, int paramInt)
  {
    try
    {
      checkClipValid(paramITPMediaTrackClip);
      if (this.mTrackClips.contains(paramITPMediaTrackClip))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("add track clip failed, clip already exists : ");
        localStringBuilder.append(paramITPMediaTrackClip.getClipId());
        TPLogUtil.i("TPMediaCompositionTrack", localStringBuilder.toString());
        paramInt = paramITPMediaTrackClip.getClipId();
        return paramInt;
      }
      int i = 0;
      if (paramInt == -1)
      {
        this.mTrackClips.add(0, paramITPMediaTrackClip);
        paramInt = paramITPMediaTrackClip.getClipId();
        return paramInt;
      }
      int j = this.mTrackClips.size();
      while (i < j)
      {
        if (((ITPMediaTrackClip)this.mTrackClips.get(i)).getClipId() == paramInt)
        {
          this.mTrackClips.add(i + 1, paramITPMediaTrackClip);
          paramInt = paramITPMediaTrackClip.getClipId();
          return paramInt;
        }
        i += 1;
      }
      this.mTrackClips.add(paramITPMediaTrackClip);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insert track clip into the end, coz after clip not found :");
      localStringBuilder.append(paramInt);
      TPLogUtil.i("TPMediaCompositionTrack", localStringBuilder.toString());
      paramInt = paramITPMediaTrackClip.getClipId();
      return paramInt;
    }
    finally {}
    for (;;)
    {
      throw paramITPMediaTrackClip;
    }
  }
  
  public void removeAllTrackClips()
  {
    try
    {
      this.mTrackClips.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean removeTrackClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    if (paramITPMediaTrackClip != null) {
      try
      {
        boolean bool = this.mTrackClips.remove(paramITPMediaTrackClip);
        return bool;
      }
      finally
      {
        break label35;
      }
    }
    throw new IllegalArgumentException("remove track clip , clip can not be null");
    label35:
    throw paramITPMediaTrackClip;
  }
  
  public void setTrackId(int paramInt)
  {
    this.mTrackId = paramInt;
  }
  
  public boolean swapTrackClip(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {}
    try
    {
      if (paramInt1 < this.mTrackClips.size())
      {
        if ((paramInt2 >= 0) && (paramInt2 < this.mTrackClips.size()))
        {
          Collections.swap(this.mTrackClips, paramInt1, paramInt2);
          return true;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("swap clip failed, to pos invalid , to pos :");
        localStringBuilder.append(paramInt2);
        TPLogUtil.w("TPMediaCompositionTrack", localStringBuilder.toString());
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("swap clip failed, from pos invalid , from pos : ");
      localStringBuilder.append(paramInt1);
      TPLogUtil.w("TPMediaCompositionTrack", localStringBuilder.toString());
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaCompositionTrack
 * JD-Core Version:    0.7.0.1
 */