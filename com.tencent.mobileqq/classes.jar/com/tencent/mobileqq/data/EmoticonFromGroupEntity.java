package com.tencent.mobileqq.data;

import android.support.annotation.NonNull;
import aukm;
import aulx;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="md5")
public class EmoticonFromGroupEntity
  extends aukm
  implements Comparable
{
  public static final String TAG = "EmoticonFromGroupEntity";
  public String bigURL;
  public int fromType;
  public boolean gifImg;
  public String md5;
  @aulx
  public MessageForPic msg;
  public long msgseq;
  @aulx
  public int status = -1;
  public String thumbURL;
  public long timestamp;
  public String troopUin;
  
  public int compareTo(@NonNull Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof EmoticonFromGroupEntity))
    {
      paramObject = (EmoticonFromGroupEntity)paramObject;
      if (this.timestamp < paramObject.timestamp) {
        i = 1;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return i;
      } while (this.timestamp == paramObject.timestamp);
      return -1;
    }
    QLog.e("EmoticonFromGroupEntity", 2, "Class not correct in method compareTo.");
    return 0;
  }
  
  public void replaceEntity(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity != null)
    {
      this.troopUin = paramEmoticonFromGroupEntity.troopUin;
      this.fromType = paramEmoticonFromGroupEntity.fromType;
      this.md5 = paramEmoticonFromGroupEntity.md5;
      this.bigURL = paramEmoticonFromGroupEntity.bigURL;
      this.thumbURL = paramEmoticonFromGroupEntity.thumbURL;
      this.gifImg = paramEmoticonFromGroupEntity.gifImg;
      this.timestamp = paramEmoticonFromGroupEntity.timestamp;
      this.msgseq = paramEmoticonFromGroupEntity.msgseq;
    }
  }
  
  public String toString()
  {
    return "md5:" + this.md5 + " thumbURL:" + this.thumbURL + " bigURL:" + this.bigURL + " timestamp:" + this.timestamp + " msgseq:" + this.msgseq + " troopUin:" + this.troopUin + " gifImg:" + this.gifImg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonFromGroupEntity
 * JD-Core Version:    0.7.0.1
 */