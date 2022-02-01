package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

class FileSystem$1
  implements FileSystem
{
  public Sink appendingSink(File paramFile)
  {
    try
    {
      Sink localSink = Okio.appendingSink(paramFile);
      return localSink;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      label7:
      break label7;
    }
    paramFile.getParentFile().mkdirs();
    return Okio.appendingSink(paramFile);
  }
  
  public void delete(File paramFile)
  {
    if (!paramFile.delete())
    {
      if (!paramFile.exists()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to delete ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public void deleteContents(File paramFile)
  {
    Object localObject = paramFile.listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramFile = localObject[i];
        if (paramFile.isDirectory()) {
          deleteContents(paramFile);
        }
        if (paramFile.delete())
        {
          i += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to delete ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not a readable directory: ");
    ((StringBuilder)localObject).append(paramFile);
    paramFile = new IOException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public boolean exists(File paramFile)
  {
    return paramFile.exists();
  }
  
  public void rename(File paramFile1, File paramFile2)
  {
    delete(paramFile2);
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed to rename ");
    localStringBuilder.append(paramFile1);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramFile2);
    throw new IOException(localStringBuilder.toString());
  }
  
  public Sink sink(File paramFile)
  {
    try
    {
      Sink localSink = Okio.sink(paramFile);
      return localSink;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      label7:
      break label7;
    }
    paramFile.getParentFile().mkdirs();
    return Okio.sink(paramFile);
  }
  
  public long size(File paramFile)
  {
    return paramFile.length();
  }
  
  public Source source(File paramFile)
  {
    return Okio.source(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.io.FileSystem.1
 * JD-Core Version:    0.7.0.1
 */