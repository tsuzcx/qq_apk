package org.apache.commons.lang.builder;

final class IDKey
{
  private final int id;
  private final Object value;
  
  public IDKey(Object paramObject)
  {
    this.id = System.identityHashCode(paramObject);
    this.value = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof IDKey;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramObject = (IDKey)paramObject;
    if (this.id != paramObject.id) {
      return false;
    }
    if (this.value == paramObject.value) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.IDKey
 * JD-Core Version:    0.7.0.1
 */