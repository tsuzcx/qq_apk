package cooperation.qqcircle.beans;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class Friend
  extends Entity
  implements Serializable, Cloneable
{
  public String mName = "";
  public long mUin = -1L;
  
  public Friend() {}
  
  public Friend(long paramLong, String paramString)
  {
    this.mUin = paramLong;
    this.mName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.beans.Friend
 * JD-Core Version:    0.7.0.1
 */