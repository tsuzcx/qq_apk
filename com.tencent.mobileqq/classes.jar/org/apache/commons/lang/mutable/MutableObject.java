package org.apache.commons.lang.mutable;

import java.io.Serializable;

public class MutableObject
  implements Serializable, Mutable
{
  private static final long serialVersionUID = 86241875189L;
  private Object value;
  
  public MutableObject() {}
  
  public MutableObject(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MutableObject;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = ((MutableObject)paramObject).value;
      Object localObject = this.value;
      if (localObject != paramObject)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (!localObject.equals(paramObject)) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = this.value;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public String toString()
  {
    Object localObject = this.value;
    if (localObject == null) {
      return "null";
    }
    return localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.mutable.MutableObject
 * JD-Core Version:    0.7.0.1
 */