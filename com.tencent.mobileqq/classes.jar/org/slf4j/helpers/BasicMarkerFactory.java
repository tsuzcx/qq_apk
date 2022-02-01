package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

public class BasicMarkerFactory
  implements IMarkerFactory
{
  private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap();
  
  public boolean detachMarker(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if (this.markerMap.remove(paramString) != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean exists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.markerMap.containsKey(paramString);
  }
  
  public Marker getDetachedMarker(String paramString)
  {
    return new BasicMarker(paramString);
  }
  
  public Marker getMarker(String paramString)
  {
    if (paramString != null)
    {
      Marker localMarker = (Marker)this.markerMap.get(paramString);
      Object localObject = localMarker;
      if (localMarker == null)
      {
        localObject = new BasicMarker(paramString);
        paramString = (Marker)this.markerMap.putIfAbsent(paramString, localObject);
        if (paramString != null) {
          localObject = paramString;
        }
      }
      return localObject;
    }
    throw new IllegalArgumentException("Marker name cannot be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.slf4j.helpers.BasicMarkerFactory
 * JD-Core Version:    0.7.0.1
 */