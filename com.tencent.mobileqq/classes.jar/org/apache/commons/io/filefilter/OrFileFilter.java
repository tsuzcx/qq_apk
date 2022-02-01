package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OrFileFilter
  extends AbstractFileFilter
  implements Serializable, ConditionalFileFilter
{
  private static final long serialVersionUID = 5767770777065432721L;
  private final List<IOFileFilter> fileFilters;
  
  public OrFileFilter()
  {
    this.fileFilters = new ArrayList();
  }
  
  public OrFileFilter(List<IOFileFilter> paramList)
  {
    if (paramList == null)
    {
      this.fileFilters = new ArrayList();
      return;
    }
    this.fileFilters = new ArrayList(paramList);
  }
  
  public OrFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    if ((paramIOFileFilter1 == null) || (paramIOFileFilter2 == null)) {
      throw new IllegalArgumentException("The filters must not be null");
    }
    this.fileFilters = new ArrayList(2);
    addFileFilter(paramIOFileFilter1);
    addFileFilter(paramIOFileFilter2);
  }
  
  public boolean accept(File paramFile)
  {
    Iterator localIterator = this.fileFilters.iterator();
    while (localIterator.hasNext()) {
      if (((IOFileFilter)localIterator.next()).accept(paramFile)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    Iterator localIterator = this.fileFilters.iterator();
    while (localIterator.hasNext()) {
      if (((IOFileFilter)localIterator.next()).accept(paramFile, paramString)) {
        return true;
      }
    }
    return false;
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
      if (i < this.fileFilters.size())
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        Object localObject = this.fileFilters.get(i);
        if (localObject == null) {}
        for (localObject = "null";; localObject = localObject.toString())
        {
          localStringBuilder.append((String)localObject);
          i += 1;
          break;
        }
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.filefilter.OrFileFilter
 * JD-Core Version:    0.7.0.1
 */