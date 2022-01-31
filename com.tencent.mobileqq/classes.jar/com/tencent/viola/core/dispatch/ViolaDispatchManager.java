package com.tencent.viola.core.dispatch;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ViolaDispatchManager
{
  public static final String EVENT_NAME_COMPONENT_APPEAR = "EVENT_NAME_COMPONENT_APPEAR";
  private static volatile ViolaDispatchManager sManager;
  private HashMap mObserversMap = new HashMap();
  
  public static ViolaDispatchManager getInstance()
  {
    if (sManager == null) {}
    try
    {
      if (sManager == null) {
        sManager = new ViolaDispatchManager();
      }
      return sManager;
    }
    finally {}
  }
  
  public void addObserver(String paramString, IObserver paramIObserver)
  {
    synchronized (this.mObserversMap)
    {
      ArrayList localArrayList2 = (ArrayList)this.mObserversMap.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mObserversMap.put(paramString, localArrayList1);
      }
      localArrayList1.add(paramIObserver);
      return;
    }
  }
  
  public void dispatchEvent(String paramString, IEvent paramIEvent)
  {
    synchronized (this.mObserversMap)
    {
      localObject = (ArrayList)this.mObserversMap.get(paramString);
      if (localObject == null) {
        break label168;
      }
      if (paramIEvent == null)
      {
        paramString = ((ArrayList)localObject).iterator();
        if (!paramString.hasNext()) {
          break label168;
        }
        ((IObserver)paramString.next()).onReceive(null);
      }
    }
    paramString = paramIEvent.getRef();
    if (TextUtils.isEmpty(paramString))
    {
      paramString = ((ArrayList)localObject).iterator();
      while (paramString.hasNext()) {
        ((IObserver)paramString.next()).onReceive(paramIEvent);
      }
    }
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IObserver localIObserver = (IObserver)((Iterator)localObject).next();
      if (paramString.equals(localIObserver.getRef())) {
        localIObserver.onReceive(paramIEvent);
      }
    }
    label168:
  }
  
  public void removeObserver(String paramString, IObserver paramIObserver)
  {
    synchronized (this.mObserversMap)
    {
      ArrayList localArrayList = (ArrayList)this.mObserversMap.get(paramString);
      localArrayList.remove(paramIObserver);
      if (localArrayList.isEmpty()) {
        this.mObserversMap.remove(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.dispatch.ViolaDispatchManager
 * JD-Core Version:    0.7.0.1
 */