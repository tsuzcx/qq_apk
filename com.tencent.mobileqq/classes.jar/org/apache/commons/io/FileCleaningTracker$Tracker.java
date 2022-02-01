package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class FileCleaningTracker$Tracker
  extends PhantomReference<Object>
{
  private final FileDeleteStrategy deleteStrategy;
  private final String path;
  
  FileCleaningTracker$Tracker(String paramString, FileDeleteStrategy paramFileDeleteStrategy, Object paramObject, ReferenceQueue<? super Object> paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.path = paramString;
    paramString = paramFileDeleteStrategy;
    if (paramFileDeleteStrategy == null) {
      paramString = FileDeleteStrategy.NORMAL;
    }
    this.deleteStrategy = paramString;
  }
  
  public boolean delete()
  {
    return this.deleteStrategy.deleteQuietly(new File(this.path));
  }
  
  public String getPath()
  {
    return this.path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.FileCleaningTracker.Tracker
 * JD-Core Version:    0.7.0.1
 */