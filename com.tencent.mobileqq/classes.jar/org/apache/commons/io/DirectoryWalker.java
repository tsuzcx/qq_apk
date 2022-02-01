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
    }
    else
    {
      if (paramIOFileFilter1 == null) {
        paramIOFileFilter1 = TrueFileFilter.TRUE;
      }
      if (paramIOFileFilter2 == null) {
        paramIOFileFilter2 = TrueFileFilter.TRUE;
      }
      this.filter = FileFilterUtils.or(new IOFileFilter[] { FileFilterUtils.makeDirectoryOnly(paramIOFileFilter1), FileFilterUtils.makeFileOnly(paramIOFileFilter2) });
    }
    this.depthLimit = paramInt;
  }
  
  private void walk(File paramFile, int paramInt, Collection<T> paramCollection)
  {
    checkIfCancelled(paramFile, paramInt, paramCollection);
    if (handleDirectory(paramFile, paramInt, paramCollection))
    {
      handleDirectoryStart(paramFile, paramInt, paramCollection);
      int j = paramInt + 1;
      int i = this.depthLimit;
      if ((i < 0) || (j <= i))
      {
        checkIfCancelled(paramFile, paramInt, paramCollection);
        Object localObject = this.filter;
        if (localObject == null) {
          localObject = paramFile.listFiles();
        } else {
          localObject = paramFile.listFiles((FileFilter)localObject);
        }
        localObject = filterDirectoryContents(paramFile, paramInt, (File[])localObject);
        if (localObject == null)
        {
          handleRestricted(paramFile, j, paramCollection);
        }
        else
        {
          int k = localObject.length;
          i = 0;
          while (i < k)
          {
            File localFile = localObject[i];
            if (localFile.isDirectory())
            {
              walk(localFile, j, paramCollection);
            }
            else
            {
              checkIfCancelled(localFile, j, paramCollection);
              handleFile(localFile, j, paramCollection);
              checkIfCancelled(localFile, j, paramCollection);
            }
            i += 1;
          }
        }
      }
      handleDirectoryEnd(paramFile, paramInt, paramCollection);
    }
    checkIfCancelled(paramFile, paramInt, paramCollection);
  }
  
  protected final void checkIfCancelled(File paramFile, int paramInt, Collection<T> paramCollection)
  {
    if (!handleIsCancelled(paramFile, paramInt, paramCollection)) {
      return;
    }
    throw new DirectoryWalker.CancelException(paramFile, paramInt);
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
    if (paramFile != null) {
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
        return;
      }
    }
    throw new NullPointerException("Start Directory is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.DirectoryWalker
 * JD-Core Version:    0.7.0.1
 */