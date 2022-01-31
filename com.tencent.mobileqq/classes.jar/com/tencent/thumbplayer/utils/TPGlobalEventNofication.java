package com.tencent.thumbplayer.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class TPGlobalEventNofication
{
  public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
  public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
  public static final int EVENT_ID_UPC_CHANGED = 100003;
  private static final String TAG = "TPGlobalEventNofication";
  private ArrayList<TPGlobalEventNofication.OnGlobalEventChangeListener> mListeners = null;
  
  private TPGlobalEventNofication()
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
  }
  
  public static TPGlobalEventNofication getInstance()
  {
    return TPGlobalEventNofication.InstanceHolder.access$100();
  }
  
  public void addEventListener(TPGlobalEventNofication.OnGlobalEventChangeListener paramOnGlobalEventChangeListener)
  {
    try
    {
      if ((this.mListeners != null) && (!this.mListeners.contains(paramOnGlobalEventChangeListener)))
      {
        this.mListeners.add(paramOnGlobalEventChangeListener);
        TPLogUtil.i("TPGlobalEventNofication", "add onNetStatus change listener: " + paramOnGlobalEventChangeListener + ", mListeners: " + this.mListeners.size());
      }
      return;
    }
    finally
    {
      paramOnGlobalEventChangeListener = finally;
      throw paramOnGlobalEventChangeListener;
    }
  }
  
  public void postGlobalEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((TPGlobalEventNofication.OnGlobalEventChangeListener)localIterator.next()).onEvent(paramInt1, paramInt2, paramInt3, paramObject);
      }
    }
    finally {}
  }
  
  public void removeEventListener(TPGlobalEventNofication.OnGlobalEventChangeListener paramOnGlobalEventChangeListener)
  {
    try
    {
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramOnGlobalEventChangeListener);
        TPLogUtil.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + paramOnGlobalEventChangeListener + ", mListeners: " + this.mListeners.size());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPGlobalEventNofication
 * JD-Core Version:    0.7.0.1
 */