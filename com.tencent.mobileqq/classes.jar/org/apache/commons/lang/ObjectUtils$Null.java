package org.apache.commons.lang;

import java.io.Serializable;

public class ObjectUtils$Null
  implements Serializable
{
  private static final long serialVersionUID = 7092611880189329093L;
  
  private Object readResolve()
  {
    return ObjectUtils.NULL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.ObjectUtils.Null
 * JD-Core Version:    0.7.0.1
 */