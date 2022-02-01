package okhttp3.internal.io;

import java.io.File;
import okio.Sink;
import okio.Source;

public abstract interface FileSystem
{
  public static final FileSystem SYSTEM = new FileSystem.1();
  
  public abstract Sink appendingSink(File paramFile);
  
  public abstract void delete(File paramFile);
  
  public abstract void deleteContents(File paramFile);
  
  public abstract boolean exists(File paramFile);
  
  public abstract void rename(File paramFile1, File paramFile2);
  
  public abstract Sink sink(File paramFile);
  
  public abstract long size(File paramFile);
  
  public abstract Source source(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.io.FileSystem
 * JD-Core Version:    0.7.0.1
 */