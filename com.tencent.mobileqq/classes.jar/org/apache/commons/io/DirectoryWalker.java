package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public abstract class DirectoryWalker<T>
{
  private final int depthLimit;
  private final FileFilter filter;
  
  protected DirectoryWalker()
  {
    this(null, -1);
  }
  
  protected DirectoryWalker(FileFilter paramFileFilter, int paramInt)
  {
    this.filter = paramFileFilter;
    this.depthLimit = paramInt;
  }
  
  protected DirectoryWalker(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2, int paramInt)
  {
    if ((paramIOFileFilter1 == null) && (paramIOFileFilter2 == null))
    {
      this.filter = null;
      this.depthLimit = paramInt;
      return;
    }
    if (paramIOFileFilter1 != null) {
      label27:
      if (paramIOFileFilter2 == null) {
        break label66;
      }
    }
    for (;;)
    {
      this.filter = FileFilterUtils.or(new IOFileFilter[] { FileFilterUtils.makeDirectoryOnly(paramIOFileFilter1), FileFilterUtils.makeFileOnly(paramIOFileFilter2) });
      break;
      paramIOFileFilter1 = TrueFileFilter.TRUE;
      break label27;
      label66:
      paramIOFileFilter2 = TrueFileFilter.TRUE;
    }
  }
  
  private void walk(File paramFile, int paramInt, Collection<T> paramCollection)
  {
    checkIfCancelled(paramFile, paramInt, paramCollection);
    int j;
    if (handleDirectory(paramFile, paramInt, paramCollection))
    {
      handleDirectoryStart(paramFile, paramInt, paramCollection);
      j = paramInt + 1;
      if ((this.depthLimit < 0) || (j <= this.depthLimit))
      {
        checkIfCancelled(paramFile, paramInt, paramCollection);
        if (this.filter != null) {
          break label103;
        }
      }
    }
    label103:
    for (File[] arrayOfFile = paramFile.listFiles();; arrayOfFile = paramFile.listFiles(this.filter))
    {
      arrayOfFile = filterDirectoryContents(paramFile, paramInt, arrayOfFile);
      if (arrayOfFile != null) {
        break;
      }
      handleRestricted(paramFile, j, paramCollection);
      handleDirectoryEnd(paramFile, paramInt, paramCollection);
      checkIfCancelled(paramFile, paramInt, paramCollection);
      return;
    }
    int k = arrayOfFile.length;
    int i = 0;
    label124:
    File localFile;
    if (i < k)
    {
      localFile = arrayOfFile[i];
      if (!localFile.isDirectory()) {
        break label164;
      }
      walk(localFile, j, paramCollection);
    }
    for (;;)
    {
      i += 1;
      break label124;
      break;
      label164:
      checkIfCancelled(localFile, j, paramCollection);
      handleFile(localFile, j, paramCollection);
      checkIfCancelled(localFile, j, paramCollection);
    }
  }
  
  protected final void checkIfCancelled(File paramFile, int paramInt, Collection<T> paramCollection)
  {
    if (handleIsCancelled(paramFile, paramInt, paramCollection)) {
      throw new DirectoryWalker.CancelException(paramFile, paramInt);
    }
  }
  
  protected File[] filterDirectoryContents(File paramFile, int paramInt, File[] paramArrayOfFile)
  {
    return paramArrayOfFile;
  }
  
  protected void handleCancelled(File paramFile, Collection<T> paramCollection, DirectoryWalker.CancelException paramCancelException)
  {
    throw paramCancelException;
  }
  
  protected boolean handleDirectory(File paramFile, int paramInt, Collection<T> paramCollection)
  {
    return true;
  }
  
  protected void handleDirectoryEnd(File paramFile, int paramInt, Collection<T> paramCollection) {}
  
  protected void handleDirectoryStart(File paramFile, int paramInt, Collection<T> paramCollection) {}
  
  protected void handleEnd(Collection<T> paramCollection) {}
  
  protected void handleFile(File paramFile, int paramInt, Collection<T> paramCollection) {}
  
  protected boolean handleIsCancelled(File paramFile, int paramInt, Collection<T> paramCollection)
  {
    return false;
  }
  
  protected void handleRestricted(File paramFile, int paramInt, Collection<T> paramCollection) {}
  
  protected void handleStart(File paramFile, Collection<T> paramCollection) {}
  
  protected final void walk(File paramFile, Collection<T> paramCollection)
  {
    if (paramFile == null) {
      throw new NullPointerException("Start Directory is null");
    }
    try
    {
      handleStart(paramFile, paramCollection);
      walk(paramFile, 0, paramCollection);
      handleEnd(paramCollection);
      return;
    }
    catch (DirectoryWalker.CancelException localCancelException)
    {
      handleCancelled(paramFile, paramCollection, localCancelException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.DirectoryWalker
 * JD-Core Version:    0.7.0.1
 */