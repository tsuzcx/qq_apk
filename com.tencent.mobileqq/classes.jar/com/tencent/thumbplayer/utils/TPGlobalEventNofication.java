package com.tencent.thumbplayer.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TPGlobalEventNofication
{
  public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
  public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
  public static final int EVENT_ID_UPC_CHANGED = 100003;
  private static final String TAG = "TPGlobalEventNofication";
  private static CopyOnWriteArrayList<TPGlobalEventNofication.OnGlobalEventChangeListener> mListeners = new CopyOnWriteArrayList();
  
  public static void addEventListener(TPGlobalEventNofication.OnGlobalEventChangeListener paramOnGlobalEventChangeListener)
  {
    try
    {
      if ((mListeners != null) && (!mListeners.contains(paramOnGlobalEventChangeListener)))
      {
        mListeners.add(paramOnGlobalEventChangeListener);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add onNetStatus change listener: ");
        localStringBuilder.append(paramOnGlobalEventChangeListener);
        localStringBuilder.append(", mListeners: ");
        localStringBuilder.append(mListeners.size());
        TPLogUtil.i("TPGlobalEventNofication", localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      paramOnGlobalEventChangeListener = finally;
      throw paramOnGlobalEventChangeListener;
    }
  }
  
  public static void postGlobalEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((TPGlobalEventNofication.OnGlobalEventChangeListener)localIterator.next()).onEvent(paramInt1, paramInt2, paramInt3, paramObject);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static void removeEventListener(TPGlobalEventNofication.OnGlobalEventChangeListener paramOnGlobalEventChangeListener)
  {
    try
    {
      if (mListeners != null)
      {
        mListeners.remove(paramOnGlobalEventChangeListener);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove netStatusChangeListener, listener: ");
        localStringBuilder.append(paramOnGlobalEventChangeListener);
        localStringBuilder.append(", mListeners: ");
        localStringBuilder.append(mListeners.size());
        TPLogUtil.i("TPGlobalEventNofication", localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      paramOnGlobalEventChangeListener = finally;
      throw paramOnGlobalEventChangeListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPGlobalEventNofication
 * JD-Core Version:    0.7.0.1
 */