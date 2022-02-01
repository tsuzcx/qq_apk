package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AndFileFilter
  extends AbstractFileFilter
  implements Serializable, ConditionalFileFilter
{
  private static final long serialVersionUID = 7215974688563965257L;
  private final List<IOFileFilter> fileFilters;
  
  public AndFileFilter()
  {
    this.fileFilters = new ArrayList();
  }
  
  public AndFileFilter(List<IOFileFilter> paramList)
  {
    if (paramList == null)
    {
      this.fileFilters = new ArrayList();
      return;
    }
    this.fileFilters = new ArrayList(paramList);
  }
  
  public AndFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    if ((paramIOFileFilter1 != null) && (paramIOFileFilter2 != null))
    {
      this.fileFilters = new ArrayList(2);
      addFileFilter(paramIOFileFilter1);
      addFileFilter(paramIOFileFilter2);
      return;
    }
    throw new IllegalArgumentException("The filters must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    if (this.fileFilters.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.fileFilters.iterator();
    while (localIterator.hasNext()) {
      if (!((IOFileFilter)localIterator.next()).accept(paramFile)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (this.fileFilters.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.fileFilters.iterator();
    while (localIterator.hasNext()) {
      if (!((IOFileFilter)localIterator.next()).accept(paramFile, paramString)) {
        return false;
      }
    }
    return true;
  }
  
  public void addFileFilter(IOFileFilter paramIOFileFilter)
  {
    this.fileFilters.add(paramIOFileFilter);
  }
  
  public List<IOFileFilter> getFileFilters()
  {
    return Collections.unmodifiableList(this.fileFilters);
  }
  
  public boolean removeFileFilter(IOFileFilter paramIOFileFilter)
  {
    return this.fileFilters.remove(paramIOFileFilter);
  }
  
  public void setFileFilters(List<IOFileFilter> paramList)
  {
    this.fileFilters.clear();
    this.fileFilters.addAll(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (this.fileFilters != null)
    {
      int i = 0;
      while (i < this.fileFilters.size())
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        Object localObject = this.fileFilters.get(i);
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = localObject.toString();
        }
        localStringBuilder.append((String)localObject);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.AndFileFilter
 * JD-Core Version:    0.7.0.1
 */