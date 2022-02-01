package cooperation.qqcircle.relation.entitys;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class QCircleFriendEntity
  extends Entity
  implements Serializable, Cloneable
{
  public int mGroupFlag = 0;
  public String mGroupName = "";
  public String mName = "";
  public long mUin = -1L;
  
  public QCircleFriendEntity() {}
  
  public QCircleFriendEntity(long paramLong, String paramString1, String paramString2)
  {
    this.mUin = paramLong;
    this.mName = paramString1;
    this.mGroupName = paramString2;
  }
  
  public int getGroupFlag()
  {
    return this.mGroupFlag;
  }
  
  public String getGroupName()
  {
    return this.mGroupName;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getUin()
  {
    return this.mUin;
  }
  
  public void setGroupFlag(int paramInt)
  {
    this.mGroupFlag = paramInt;
  }
  
  public void setGroupName(String paramString)
  {
    this.mGroupName = paramString;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setUin(long paramLong)
  {
    this.mUin = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.relation.entitys.QCircleFriendEntity
 * JD-Core Version:    0.7.0.1
 */