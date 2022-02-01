package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.IOCase;

public class FileFilterUtils
{
  private static final IOFileFilter cvsFilter = notFileFilter(and(new IOFileFilter[] { directoryFileFilter(), nameFileFilter("CVS") }));
  private static final IOFileFilter svnFilter = notFileFilter(and(new IOFileFilter[] { directoryFileFilter(), nameFileFilter(".svn") }));
  
  public static IOFileFilter ageFileFilter(long paramLong)
  {
    return new AgeFileFilter(paramLong);
  }
  
  public static IOFileFilter ageFileFilter(long paramLong, boolean paramBoolean)
  {
    return new AgeFileFilter(paramLong, paramBoolean);
  }
  
  public static IOFileFilter ageFileFilter(File paramFile)
  {
    return new AgeFileFilter(paramFile);
  }
  
  public static IOFileFilter ageFileFilter(File paramFile, boolean paramBoolean)
  {
    return new AgeFileFilter(paramFile, paramBoolean);
  }
  
  public static IOFileFilter ageFileFilter(Date paramDate)
  {
    return new AgeFileFilter(paramDate);
  }
  
  public static IOFileFilter ageFileFilter(Date paramDate, boolean paramBoolean)
  {
    return new AgeFileFilter(paramDate, paramBoolean);
  }
  
  public static IOFileFilter and(IOFileFilter... paramVarArgs)
  {
    return new AndFileFilter(toList(paramVarArgs));
  }
  
  @Deprecated
  public static IOFileFilter andFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    return new AndFileFilter(paramIOFileFilter1, paramIOFileFilter2);
  }
  
  public static IOFileFilter asFileFilter(FileFilter paramFileFilter)
  {
    return new DelegateFileFilter(paramFileFilter);
  }
  
  public static IOFileFilter asFileFilter(FilenameFilter paramFilenameFilter)
  {
    return new DelegateFileFilter(paramFilenameFilter);
  }
  
  public static IOFileFilter directoryFileFilter()
  {
    return DirectoryFileFilter.DIRECTORY;
  }
  
  public static IOFileFilter falseFileFilter()
  {
    return FalseFileFilter.FALSE;
  }
  
  public static IOFileFilter fileFileFilter()
  {
    return FileFileFilter.FILE;
  }
  
  private static <T extends Collection<File>> T filter(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable, T paramT)
  {
    if (paramIOFileFilter != null)
    {
      if (paramIterable != null)
      {
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          File localFile = (File)paramIterable.next();
          if (localFile != null)
          {
            if (paramIOFileFilter.accept(localFile)) {
              paramT.add(localFile);
            }
          }
          else {
            throw new IllegalArgumentException("file collection contains null");
          }
        }
      }
      return paramT;
    }
    paramIOFileFilter = new IllegalArgumentException("file filter is null");
    for (;;)
    {
      throw paramIOFileFilter;
    }
  }
  
  public static File[] filter(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable)
  {
    paramIOFileFilter = filterList(paramIOFileFilter, paramIterable);
    return (File[])paramIOFileFilter.toArray(new File[paramIOFileFilter.size()]);
  }
  
  public static File[] filter(IOFileFilter paramIOFileFilter, File... paramVarArgs)
  {
    if (paramIOFileFilter != null)
    {
      int i = 0;
      if (paramVarArgs == null) {
        return new File[0];
      }
      ArrayList localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      while (i < j)
      {
        File localFile = paramVarArgs[i];
        if (localFile != null)
        {
          if (paramIOFileFilter.accept(localFile)) {
            localArrayList.add(localFile);
          }
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("file array contains null");
        }
      }
      return (File[])localArrayList.toArray(new File[localArrayList.size()]);
    }
    paramIOFileFilter = new IllegalArgumentException("file filter is null");
    for (;;)
    {
      throw paramIOFileFilter;
    }
  }
  
  public static List<File> filterList(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable)
  {
    return (List)filter(paramIOFileFilter, paramIterable, new ArrayList());
  }
  
  public static List<File> filterList(IOFileFilter paramIOFileFilter, File... paramVarArgs)
  {
    return Arrays.asList(filter(paramIOFileFilter, paramVarArgs));
  }
  
  public static Set<File> filterSet(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable)
  {
    return (Set)filter(paramIOFileFilter, paramIterable, new HashSet());
  }
  
  public static Set<File> filterSet(IOFileFilter paramIOFileFilter, File... paramVarArgs)
  {
    return new HashSet(Arrays.asList(filter(paramIOFileFilter, paramVarArgs)));
  }
  
  public static IOFileFilter magicNumberFileFilter(String paramString)
  {
    return new MagicNumberFileFilter(paramString);
  }
  
  public static IOFileFilter magicNumberFileFilter(String paramString, long paramLong)
  {
    return new MagicNumberFileFilter(paramString, paramLong);
  }
  
  public static IOFileFilter magicNumberFileFilter(byte[] paramArrayOfByte)
  {
    return new MagicNumberFileFilter(paramArrayOfByte);
  }
  
  public static IOFileFilter magicNumberFileFilter(byte[] paramArrayOfByte, long paramLong)
  {
    return new MagicNumberFileFilter(paramArrayOfByte, paramLong);
  }
  
  public static IOFileFilter makeCVSAware(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      return cvsFilter;
    }
    return and(new IOFileFilter[] { paramIOFileFilter, cvsFilter });
  }
  
  public static IOFileFilter makeDirectoryOnly(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      return DirectoryFileFilter.DIRECTORY;
    }
    return new AndFileFilter(DirectoryFileFilter.DIRECTORY, paramIOFileFilter);
  }
  
  public static IOFileFilter makeFileOnly(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      return FileFileFilter.FILE;
    }
    return new AndFileFilter(FileFileFilter.FILE, paramIOFileFilter);
  }
  
  public static IOFileFilter makeSVNAware(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      return svnFilter;
    }
    return and(new IOFileFilter[] { paramIOFileFilter, svnFilter });
  }
  
  public static IOFileFilter nameFileFilter(String paramString)
  {
    return new NameFileFilter(paramString);
  }
  
  public static IOFileFilter nameFileFilter(String paramString, IOCase paramIOCase)
  {
    return new NameFileFilter(paramString, paramIOCase);
  }
  
  public static IOFileFilter notFileFilter(IOFileFilter paramIOFileFilter)
  {
    return new NotFileFilter(paramIOFileFilter);
  }
  
  public static IOFileFilter or(IOFileFilter... paramVarArgs)
  {
    return new OrFileFilter(toList(paramVarArgs));
  }
  
  @Deprecated
  public static IOFileFilter orFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    return new OrFileFilter(paramIOFileFilter1, paramIOFileFilter2);
  }
  
  public static IOFileFilter prefixFileFilter(String paramString)
  {
    return new PrefixFileFilter(paramString);
  }
  
  public static IOFileFilter prefixFileFilter(String paramString, IOCase paramIOCase)
  {
    return new PrefixFileFilter(paramString, paramIOCase);
  }
  
  public static IOFileFilter sizeFileFilter(long paramLong)
  {
    return new SizeFileFilter(paramLong);
  }
  
  public static IOFileFilter sizeFileFilter(long paramLong, boolean paramBoolean)
  {
    return new SizeFileFilter(paramLong, paramBoolean);
  }
  
  public static IOFileFilter sizeRangeFileFilter(long paramLong1, long paramLong2)
  {
    return new AndFileFilter(new SizeFileFilter(paramLong1, true), new SizeFileFilter(paramLong2 + 1L, false));
  }
  
  public static IOFileFilter suffixFileFilter(String paramString)
  {
    return new SuffixFileFilter(paramString);
  }
  
  public static IOFileFilter suffixFileFilter(String paramString, IOCase paramIOCase)
  {
    return new SuffixFileFilter(paramString, paramIOCase);
  }
  
  public static List<IOFileFilter> toList(IOFileFilter... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      ArrayList localArrayList = new ArrayList(paramVarArgs.length);
      int i = 0;
      while (i < paramVarArgs.length) {
        if (paramVarArgs[i] != null)
        {
          localArrayList.add(paramVarArgs[i]);
          i += 1;
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("The filter[");
          paramVarArgs.append(i);
          paramVarArgs.append("] is null");
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
      return localArrayList;
    }
    paramVarArgs = new IllegalArgumentException("The filters must not be null");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  public static IOFileFilter trueFileFilter()
  {
    return TrueFileFilter.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.FileFilterUtils
 * JD-Core Version:    0.7.0.1
 */