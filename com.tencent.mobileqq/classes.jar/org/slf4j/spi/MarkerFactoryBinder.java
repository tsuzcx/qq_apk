package org.slf4j.spi;

import org.slf4j.IMarkerFactory;

public abstract interface MarkerFactoryBinder
{
  public abstract IMarkerFactory getMarkerFactory();
  
  public abstract String getMarkerFactoryClassStr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.slf4j.spi.MarkerFactoryBinder
 * JD-Core Version:    0.7.0.1
 */