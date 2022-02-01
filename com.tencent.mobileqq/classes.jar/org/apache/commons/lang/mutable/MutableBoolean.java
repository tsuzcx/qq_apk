package org.apache.commons.lang.mutable;

import java.io.Serializable;
import org.apache.commons.lang.BooleanUtils;

public class MutableBoolean
  implements Serializable, Comparable, Mutable
{
  private static final long serialVersionUID = -4830728138360036487L;
  private boolean value;
  
  public MutableBoolean() {}
  
  public MutableBoolean(Boolean paramBoolean)
  {
    this.value = paramBoolean.booleanValue();
  }
  
  public MutableBoolean(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public boolean booleanValue()
  {
    return this.value;
  }
  
  public int compareTo(Object paramObject)
  {
    boolean bool1 = ((MutableBoolean)paramObject).value;
    boolean bool2 = this.value;
    if (bool2 == bool1) {
      return 0;
    }
    if (bool2) {
      return 1;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MutableBoolean;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.value == ((MutableBoolean)paramObject).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Object getValue()
  {
    return BooleanUtils.toBooleanObject(this.value);
  }
  
  public int hashCode()
  {
    Boolean localBoolean;
    if (this.value) {
      localBoolean = Boolean.TRUE;
    } else {
      localBoolean = Boolean.FALSE;
    }
    return localBoolean.hashCode();
  }
  
  public boolean isFalse()
  {
    return this.value ^ true;
  }
  
  public boolean isTrue()
  {
    return this.value == true;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Boolean)paramObject).booleanValue());
  }
  
  public void setValue(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public Boolean toBoolean()
  {
    return BooleanUtils.toBooleanObject(this.value);
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.mutable.MutableBoolean
 * JD-Core Version:    0.7.0.1
 */