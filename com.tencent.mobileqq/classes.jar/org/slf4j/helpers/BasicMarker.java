package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

public class BasicMarker
  implements Marker
{
  private static String CLOSE = " ]";
  private static String OPEN = "[ ";
  private static String SEP = ", ";
  private static final long serialVersionUID = -2849567615646933777L;
  private final String name;
  private List<Marker> referenceList = new CopyOnWriteArrayList();
  
  BasicMarker(String paramString)
  {
    if (paramString != null)
    {
      this.name = paramString;
      return;
    }
    throw new IllegalArgumentException("A marker name cannot be null");
  }
  
  public void add(Marker paramMarker)
  {
    if (paramMarker != null)
    {
      if (contains(paramMarker)) {
        return;
      }
      if (paramMarker.contains(this)) {
        return;
      }
      this.referenceList.add(paramMarker);
      return;
    }
    throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
  }
  
  public boolean contains(String paramString)
  {
    if (paramString != null)
    {
      if (this.name.equals(paramString)) {
        return true;
      }
      if (hasReferences())
      {
        Iterator localIterator = this.referenceList.iterator();
        while (localIterator.hasNext()) {
          if (((Marker)localIterator.next()).contains(paramString)) {
            return true;
          }
        }
      }
      return false;
    }
    paramString = new IllegalArgumentException("Other cannot be null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean contains(Marker paramMarker)
  {
    if (paramMarker != null)
    {
      if (equals(paramMarker)) {
        return true;
      }
      if (hasReferences())
      {
        Iterator localIterator = this.referenceList.iterator();
        while (localIterator.hasNext()) {
          if (((Marker)localIterator.next()).contains(paramMarker)) {
            return true;
          }
        }
      }
      return false;
    }
    paramMarker = new IllegalArgumentException("Other cannot be null");
    for (;;)
    {
      throw paramMarker;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Marker)) {
      return false;
    }
    paramObject = (Marker)paramObject;
    return this.name.equals(paramObject.getName());
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean hasChildren()
  {
    return hasReferences();
  }
  
  public boolean hasReferences()
  {
    return this.referenceList.size() > 0;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public Iterator<Marker> iterator()
  {
    return this.referenceList.iterator();
  }
  
  public boolean remove(Marker paramMarker)
  {
    return this.referenceList.remove(paramMarker);
  }
  
  public String toString()
  {
    if (!hasReferences()) {
      return getName();
    }
    Iterator localIterator = iterator();
    StringBuilder localStringBuilder = new StringBuilder(getName());
    localStringBuilder.append(' ');
    localStringBuilder.append(OPEN);
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Marker)localIterator.next()).getName());
      if (localIterator.hasNext()) {
        localStringBuilder.append(SEP);
      }
    }
    localStringBuilder.append(CLOSE);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.slf4j.helpers.BasicMarker
 * JD-Core Version:    0.7.0.1
 */