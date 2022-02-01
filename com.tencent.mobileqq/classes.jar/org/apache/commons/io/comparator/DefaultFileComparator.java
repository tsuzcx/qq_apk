package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DefaultFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> DEFAULT_COMPARATOR = new DefaultFileComparator();
  public static final Comparator<File> DEFAULT_REVERSE = new ReverseComparator(DEFAULT_COMPARATOR);
  private static final long serialVersionUID = 3260141861365313518L;
  
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.compareTo(paramFile2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.comparator.DefaultFileComparator
 * JD-Core Version:    0.7.0.1
 */