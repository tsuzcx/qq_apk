package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class SuffixFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = -3389157631240246157L;
  private final IOCase caseSensitivity;
  private final String[] suffixes;
  
  public SuffixFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      this.suffixes = new String[] { paramString };
      paramString = paramIOCase;
      if (paramIOCase == null) {
        paramString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramString;
      return;
    }
    throw new IllegalArgumentException("The suffix must not be null");
  }
  
  public SuffixFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList != null)
    {
      this.suffixes = ((String[])paramList.toArray(new String[paramList.size()]));
      paramList = paramIOCase;
      if (paramIOCase == null) {
        paramList = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramList;
      return;
    }
    throw new IllegalArgumentException("The list of suffixes must not be null");
  }
  
  public SuffixFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString != null)
    {
      this.suffixes = new String[paramArrayOfString.length];
      System.arraycopy(paramArrayOfString, 0, this.suffixes, 0, paramArrayOfString.length);
      paramArrayOfString = paramIOCase;
      if (paramIOCase == null) {
        paramArrayOfString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramArrayOfString;
      return;
    }
    throw new IllegalArgumentException("The array of suffixes must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    String[] arrayOfString = this.suffixes;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (this.caseSensitivity.checkEndsWith(paramFile, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = this.suffixes;
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      String str = paramFile[i];
      if (this.caseSensitivity.checkEndsWith(paramString, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (this.suffixes != null)
    {
      int i = 0;
      while (i < this.suffixes.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.suffixes[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.SuffixFileFilter
 * JD-Core Version:    0.7.0.1
 */