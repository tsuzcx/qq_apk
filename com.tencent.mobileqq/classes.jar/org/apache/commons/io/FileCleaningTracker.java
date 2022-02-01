package org.apache.commons.io;

import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FileCleaningTracker
{
  final List<String> deleteFailures = Collections.synchronizedList(new ArrayList());
  volatile boolean exitWhenFinished = false;
  ReferenceQueue<Object> q = new ReferenceQueue();
  Thread reaper;
  final Collection<FileCleaningTracker.Tracker> trackers = Collections.synchronizedSet(new HashSet());
  
  private void addTracker(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy)
  {
    try
    {
      if (!this.exitWhenFinished)
      {
        if (this.reaper == null)
        {
          this.reaper = new FileCleaningTracker.Reaper(this);
          this.reaper.start();
        }
        this.trackers.add(new FileCleaningTracker.Tracker(paramString, paramFileDeleteStrategy, paramObject, this.q));
        return;
      }
      throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
    }
    finally {}
  }
  
  public void exitWhenFinished()
  {
    try
    {
      this.exitWhenFinished = true;
      if (this.reaper != null) {
        synchronized (this.reaper)
        {
          this.reaper.interrupt();
        }
      }
      return;
    }
    finally {}
  }
  
  public List<String> getDeleteFailures()
  {
    return this.deleteFailures;
  }
  
  public int getTrackCount()
  {
    return this.trackers.size();
  }
  
  public void track(File paramFile, Object paramObject)
  {
    track(paramFile, paramObject, null);
  }
  
  public void track(File paramFile, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy)
  {
    if (paramFile != null)
    {
      addTracker(paramFile.getPath(), paramObject, paramFileDeleteStrategy);
      return;
    }
    throw new NullPointerException("The file must not be null");
  }
  
  public void track(String paramString, Object paramObject)
  {
    track(paramString, paramObject, null);
  }
  
  public void track(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy)
  {
    if (paramString != null)
    {
      addTracker(paramString, paramObject, paramFileDeleteStrategy);
      return;
    }
    throw new NullPointerException("The path must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FileCleaningTracker
 * JD-Core Version:    0.7.0.1
 */