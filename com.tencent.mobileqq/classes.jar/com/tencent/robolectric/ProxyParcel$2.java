package com.tencent.robolectric;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class ProxyParcel$2
  extends ObjectInputStream
{
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
  {
    if (this.a != null)
    {
      Class localClass = Class.forName(paramObjectStreamClass.getName(), false, this.a);
      if (localClass != null) {
        return localClass;
      }
    }
    return super.resolveClass(paramObjectStreamClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.robolectric.ProxyParcel.2
 * JD-Core Version:    0.7.0.1
 */