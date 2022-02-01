package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class NamedLoggerBase
  implements Serializable, Logger
{
  private static final long serialVersionUID = 7535258609338176893L;
  protected String name;
  
  public String getName()
  {
    return this.name;
  }
  
  protected Object readResolve()
  {
    return LoggerFactory.getLogger(getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.slf4j.helpers.NamedLoggerBase
 * JD-Core Version:    0.7.0.1
 */