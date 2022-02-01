package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId")
public class Emoticon
  extends Entity
  implements Serializable
{
  public static final int JOB_H5_MAGIC = 4;
  public static final int JOB_MAGIC = 2;
  public static final int JOB_NORMAL = 0;
  public static final int JOB_QFACE = 1;
  public static final int JOB_SMALL = 3;
  public static final int MEDIA_TYPE_H5_MAGIC = 3;
  public static final int MEDIA_TYPE_QFACE = 2;
  public static final int MEDIA_TYPE_SOUND = 1;
  private static final long serialVersionUID = 2994277280135415857L;
  public String backColor;
  public String businessExtra;
  public String character;
  public int clickNum;
  public String eId;
  public String encryptKey;
  public String epId;
  public int exposeNum;
  public int extensionHeight;
  public int extensionWidth;
  public int height;
  public String ipsiteName;
  public String ipsiteUrl;
  public boolean isAPNG = false;
  public boolean isSound;
  public int jobType;
  public String keyword;
  public String keywords;
  public String magicValue;
  public String name;
  public boolean value;
  public String voicePrint;
  @notColumn
  public List<Integer> voicePrintItems;
  public String volumeColor;
  public int width;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Emoticon)) {
        return false;
      }
      paramObject = (Emoticon)paramObject;
      String str = paramObject.eId;
      if ((str != null) && (str.equals(this.eId)))
      {
        paramObject = paramObject.epId;
        if ((paramObject != null) && (paramObject.equals(this.epId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String getMapKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.epId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.eId);
    return localStringBuilder.toString();
  }
  
  public boolean hasEncryptKey()
  {
    return TextUtils.isEmpty(this.encryptKey) ^ true;
  }
  
  public void increaseClickNum()
  {
    int i = this.clickNum;
    if (i == 2147483647) {
      return;
    }
    this.clickNum = (i + 1);
  }
  
  public void increaseExposeNum()
  {
    int i = this.exposeNum;
    if (i == 2147483647) {
      return;
    }
    this.exposeNum = (i + 1);
  }
  
  public boolean isNewSoundEmoticon()
  {
    return (parseSoundPrintString() != null) && (!parseSoundPrintString().isEmpty());
  }
  
  public List<Integer> parseSoundPrintString()
  {
    Object localObject = this.voicePrintItems;
    if (localObject != null) {
      return localObject;
    }
    if (TextUtils.isEmpty(this.voicePrint)) {
      return null;
    }
    try
    {
      localObject = this.voicePrint.split("\\|");
      ArrayList localArrayList = new ArrayList();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(localObject[i])));
        i += 1;
      }
      this.voicePrintItems = localArrayList;
      localObject = this.voicePrintItems;
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("Emoticon", 2, localException, new Object[0]);
    }
    return null;
  }
  
  public String toSoundPrintString()
  {
    if (!TextUtils.isEmpty(this.voicePrint)) {
      return this.voicePrint;
    }
    Object localObject = this.voicePrintItems;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < this.voicePrintItems.size())
      {
        ((StringBuilder)localObject).append(this.voicePrintItems.get(i));
        if (i != this.voicePrintItems.size() - 1) {
          ((StringBuilder)localObject).append("|");
        }
        i += 1;
      }
      this.voicePrint = ((StringBuilder)localObject).toString();
      return this.voicePrint;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Emoticon
 * JD-Core Version:    0.7.0.1
 */