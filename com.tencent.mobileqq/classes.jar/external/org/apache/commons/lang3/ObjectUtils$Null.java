package external.org.apache.commons.lang3;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.ObjectUtils.Null
 * JD-Core Version:    0.7.0.1
 */