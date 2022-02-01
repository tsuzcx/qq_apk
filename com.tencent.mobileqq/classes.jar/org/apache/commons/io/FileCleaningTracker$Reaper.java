package org.apache.commons.io;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.List;

final class FileCleaningTracker$Reaper
  extends Thread
{
  FileCleaningTracker$Reaper(FileCleaningTracker paramFileCleaningTracker)
  {
    super("File Reaper");
    setPriority(10);
    setDaemon(true);
  }
  
  public void run()
  {
    for (;;)
    {
      if ((this.this$0.exitWhenFinished) && (this.this$0.trackers.size() <= 0)) {
        return;
      }
      try
      {
        FileCleaningTracker.Tracker localTracker = (FileCleaningTracker.Tracker)this.this$0.q.remove();
        this.this$0.trackers.remove(localTracker);
        if (!localTracker.delete()) {
          this.this$0.deleteFailures.add(localTracker.getPath());
        }
        localTracker.clear();
      }
      catch (InterruptedException localInterruptedException)
      {
        label88:
        break label88;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FileCleaningTracker.Reaper
 * JD-Core Version:    0.7.0.1
 */