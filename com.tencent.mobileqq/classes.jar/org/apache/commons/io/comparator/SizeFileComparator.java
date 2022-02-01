package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.FileUtils;

public class SizeFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
  public static final Comparator<File> SIZE_REVERSE = new ReverseComparator(SIZE_COMPARATOR);
  public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
  public static final Comparator<File> SIZE_SUMDIR_REVERSE = new ReverseComparator(SIZE_SUMDIR_COMPARATOR);
  private static final long serialVersionUID = -1201561106411416190L;
  private final boolean sumDirectoryContents;
  
  public SizeFileComparator()
  {
    this.sumDirectoryContents = false;
  }
  
  public SizeFileComparator(boolean paramBoolean)
  {
    this.sumDirectoryContents = paramBoolean;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    long l1;
    if (paramFile1.isDirectory())
    {
      if ((this.sumDirectoryContents) && (paramFile1.exists())) {
        l1 = FileUtils.sizeOfDirectory(paramFile1);
      } else {
        l1 = 0L;
      }
    }
    else {
      l1 = paramFile1.length();
    }
    long l2;
    if (paramFile2.isDirectory())
    {
      if ((this.sumDirectoryContents) && (paramFile2.exists())) {
        l2 = FileUtils.sizeOfDirectory(paramFile2);
      } else {
        l2 = 0L;
      }
    }
    else {
      l2 = paramFile2.length();
    }
    l1 -= l2;
    if (l1 < 0L) {
      return -1;
    }
    if (l1 > 0L) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[sumDirectoryContents=");
    localStringBuilder.append(this.sumDirectoryContents);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.comparator.SizeFileComparator
 * JD-Core Version:    0.7.0.1
 */