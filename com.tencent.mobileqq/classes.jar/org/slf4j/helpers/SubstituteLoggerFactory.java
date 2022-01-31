package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLoggerFactory
  implements ILoggerFactory
{
  final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = new LinkedBlockingQueue();
  final Map<String, SubstituteLogger> loggers = new HashMap();
  boolean postInitialization = false;
  
  public void clear()
  {
    this.loggers.clear();
    this.eventQueue.clear();
  }
  
  public LinkedBlockingQueue<SubstituteLoggingEvent> getEventQueue()
  {
    return this.eventQueue;
  }
  
  public Logger getLogger(String paramString)
  {
    try
    {
      SubstituteLogger localSubstituteLogger2 = (SubstituteLogger)this.loggers.get(paramString);
      SubstituteLogger localSubstituteLogger1 = localSubstituteLogger2;
      if (localSubstituteLogger2 == null)
      {
        localSubstituteLogger1 = new SubstituteLogger(paramString, this.eventQueue, this.postInitialization);
        this.loggers.put(paramString, localSubstituteLogger1);
      }
      return localSubstituteLogger1;
    }
    finally {}
  }
  
  public List<String> getLoggerNames()
  {
    return new ArrayList(this.loggers.keySet());
  }
  
  public List<SubstituteLogger> getLoggers()
  {
    return new ArrayList(this.loggers.values());
  }
  
  public void postInitialization()
  {
    this.postInitialization = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.slf4j.helpers.SubstituteLoggerFactory
 * JD-Core Version:    0.7.0.1
 */