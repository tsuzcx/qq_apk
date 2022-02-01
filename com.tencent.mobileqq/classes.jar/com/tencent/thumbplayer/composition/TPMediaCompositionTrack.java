package com.tencent.thumbplayer.composition;

import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
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
    if (paramITPMediaTrackClip == null) {
      try
      {
        throw new IllegalArgumentException("add track clip , clip can not be null");
      }
      finally {}
    }
    if (paramITPMediaTrackClip.getMediaType() != this.mTrackType) {
      throw new IllegalArgumentException("add track clip failed, media type is not same");
    }
  }
  
  /* Error */
  public int addTrackClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 55	com/tencent/thumbplayer/composition/TPMediaCompositionTrack:checkClipValid	(Lcom/tencent/thumbplayer/api/composition/ITPMediaTrackClip;)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/thumbplayer/composition/TPMediaCompositionTrack:mTrackClips	Ljava/util/List;
    //   11: aload_1
    //   12: invokeinterface 61 2 0
    //   17: ifeq +43 -> 60
    //   20: ldc 12
    //   22: new 63	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   29: ldc 66
    //   31: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokeinterface 73 1 0
    //   40: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 86	com/tencent/thumbplayer/utils/TPLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokeinterface 73 1 0
    //   55: istore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_2
    //   59: ireturn
    //   60: aload_0
    //   61: getfield 32	com/tencent/thumbplayer/composition/TPMediaCompositionTrack:mTrackClips	Ljava/util/List;
    //   64: aload_1
    //   65: invokeinterface 89 2 0
    //   70: pop
    //   71: aload_1
    //   72: invokeinterface 73 1 0
    //   77: istore_2
    //   78: goto -22 -> 56
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	TPMediaCompositionTrack
    //   0	86	1	paramITPMediaTrackClip	ITPMediaTrackClip
    //   55	23	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	56	81	finally
    //   60	78	81	finally
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
    try
    {
      Iterator localIterator = this.mTrackClips.iterator();
      long l2;
      for (long l1 = 0L; localIterator.hasNext(); l1 = l2 + l1) {
        l2 = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs();
      }
      return l1;
    }
    finally {}
  }
  
  /* Error */
  public ITPMediaTrackClip getTrackClip(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/thumbplayer/composition/TPMediaCompositionTrack:mTrackClips	Ljava/util/List;
    //   6: invokeinterface 99 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 105 1 0
    //   20: ifeq +30 -> 50
    //   23: aload 4
    //   25: invokeinterface 109 1 0
    //   30: checkcast 45	com/tencent/thumbplayer/api/composition/ITPMediaTrackClip
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 73 1 0
    //   40: istore_2
    //   41: iload_2
    //   42: iload_1
    //   43: if_icmpne -30 -> 13
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: areturn
    //   50: aconst_null
    //   51: astore_3
    //   52: goto -6 -> 46
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TPMediaCompositionTrack
    //   0	60	1	paramInt	int
    //   40	4	2	i	int
    //   33	19	3	localITPMediaTrackClip	ITPMediaTrackClip
    //   55	4	3	localObject	Object
    //   11	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	55	finally
    //   13	41	55	finally
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
  
  public String getUrl()
  {
    try
    {
      String str = TPMediaCompositionXmlGenerator.buildXmlPathFromTrackInfo(this.mTrackClips, this.mTrackType);
      return str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        TPLogUtil.e("TPMediaCompositionTrack", localIOException);
        Object localObject1 = null;
      }
    }
    finally {}
  }
  
  public int insertTrackClip(ITPMediaTrackClip paramITPMediaTrackClip, int paramInt)
  {
    for (;;)
    {
      try
      {
        checkClipValid(paramITPMediaTrackClip);
        if (this.mTrackClips.contains(paramITPMediaTrackClip))
        {
          TPLogUtil.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + paramITPMediaTrackClip.getClipId());
          paramInt = paramITPMediaTrackClip.getClipId();
          return paramInt;
        }
        if (paramInt == -1)
        {
          this.mTrackClips.add(0, paramITPMediaTrackClip);
          paramInt = paramITPMediaTrackClip.getClipId();
        }
        else
        {
          int j = this.mTrackClips.size();
          int i = 0;
          if (i < j)
          {
            if (((ITPMediaTrackClip)this.mTrackClips.get(i)).getClipId() == paramInt)
            {
              this.mTrackClips.add(i + 1, paramITPMediaTrackClip);
              paramInt = paramITPMediaTrackClip.getClipId();
            }
          }
          else
          {
            this.mTrackClips.add(paramITPMediaTrackClip);
            TPLogUtil.i("TPMediaCompositionTrack", "insert track clip into the end, coz after clip not found :" + paramInt);
            paramInt = paramITPMediaTrackClip.getClipId();
            continue;
          }
          i += 1;
        }
      }
      finally {}
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
    if (paramITPMediaTrackClip == null) {
      try
      {
        throw new IllegalArgumentException("remove track clip , clip can not be null");
      }
      finally {}
    }
    boolean bool = this.mTrackClips.remove(paramITPMediaTrackClip);
    return bool;
  }
  
  public void setTrackId(int paramInt)
  {
    this.mTrackId = paramInt;
  }
  
  public boolean swapTrackClip(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 >= 0) {}
    for (;;)
    {
      try
      {
        if (paramInt1 >= this.mTrackClips.size())
        {
          TPLogUtil.w("TPMediaCompositionTrack", "swap clip failed, from pos invalid , from pos : " + paramInt1);
          return bool;
        }
        if ((paramInt2 < 0) || (paramInt2 >= this.mTrackClips.size()))
        {
          TPLogUtil.w("TPMediaCompositionTrack", "swap clip failed, to pos invalid , to pos :" + paramInt2);
          continue;
        }
        Collections.swap(this.mTrackClips, paramInt1, paramInt2);
      }
      finally {}
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaCompositionTrack
 * JD-Core Version:    0.7.0.1
 */