package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMarkerBinder;

public class MarkerFactory
{
  static IMarkerFactory MARKER_FACTORY;
  
  static
  {
    try
    {
      MARKER_FACTORY = bwCompatibleGetMarkerFactoryFromBinder();
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      MARKER_FACTORY = new BasicMarkerFactory();
      return;
    }
    catch (Exception localException)
    {
      Util.report("Unexpected failure while binding MarkerFactory", localException);
    }
  }
  
  private static IMarkerFactory bwCompatibleGetMarkerFactoryFromBinder()
  {
    try
    {
      IMarkerFactory localIMarkerFactory = StaticMarkerBinder.getSingleton().getMarkerFactory();
      return localIMarkerFactory;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return StaticMarkerBinder.SINGLETON.getMarkerFactory();
  }
  
  public static Marker getDetachedMarker(String paramString)
  {
    return MARKER_FACTORY.getDetachedMarker(paramString);
  }
  
  public static IMarkerFactory getIMarkerFactory()
  {
    return MARKER_FACTORY;
  }
  
  public static Marker getMarker(String paramString)
  {
    return MARKER_FACTORY.getMarker(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.slf4j.MarkerFactory
 * JD-Core Version:    0.7.0.1
 */