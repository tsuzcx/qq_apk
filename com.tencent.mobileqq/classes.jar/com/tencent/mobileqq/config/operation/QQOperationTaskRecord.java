package com.tencent.mobileqq.config.operation;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class QQOperationTaskRecord
  extends Entity
{
  public int aioCount;
  public String hasShowedUins = "";
  public long recordTime;
  public String showCount = "";
  @unique
  public int taskid;
  
  public void addUinShowCount(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("+");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("_");
      localObject1 = ((StringBuilder)localObject1).toString();
      if ((!TextUtils.isEmpty(this.showCount)) && (this.showCount.contains((CharSequence)localObject1)))
      {
        int i = this.showCount.indexOf((String)localObject1);
        if (i == -1)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("addUinShowCount  showCount = ");
            ((StringBuilder)localObject1).append(this.showCount);
            ((StringBuilder)localObject1).append(" uin = ");
            ((StringBuilder)localObject1).append(paramString);
            QLog.d("QQOperateVoIP", 2, ((StringBuilder)localObject1).toString());
          }
          return;
        }
        Object localObject2 = this.showCount.substring(i + ((String)localObject1).length());
        i = ((String)localObject2).indexOf("|");
        if (i == -1)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("addUinShowCount  showCount = ");
            ((StringBuilder)localObject1).append(this.showCount);
            ((StringBuilder)localObject1).append(" uin = ");
            ((StringBuilder)localObject1).append(paramString);
            QLog.d("QQOperateVoIP", 2, ((StringBuilder)localObject1).toString());
          }
          return;
        }
        i = Integer.valueOf(((String)localObject2).substring(0, i)).intValue();
        paramString = this.showCount;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(i);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(i + 1);
        this.showCount = paramString.replace((CharSequence)localObject2, localStringBuilder.toString());
        return;
      }
      paramString = new StringBuilder();
      paramString.append(this.showCount);
      paramString.append((String)localObject1);
      paramString.append("1|");
      this.showCount = paramString.toString();
    }
  }
  
  public int getUinTotalShowCount(String paramString)
  {
    Object localObject;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("+");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      localObject = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(this.showCount)) && (this.showCount.contains((CharSequence)localObject)))
      {
        i = this.showCount.indexOf((String)localObject);
        if (i == -1)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getUinTotalShowCount  showCount = ");
            ((StringBuilder)localObject).append(this.showCount);
            ((StringBuilder)localObject).append(" uin = ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("QQOperateVoIP", 2, ((StringBuilder)localObject).toString());
          }
          return 0;
        }
        localObject = this.showCount.substring(i + ((String)localObject).length());
        i = ((String)localObject).indexOf("|");
        if (i == -1)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getUinTotalShowCount  showCount = ");
            ((StringBuilder)localObject).append(this.showCount);
            ((StringBuilder)localObject).append(" uin = ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("QQOperateVoIP", 2, ((StringBuilder)localObject).toString());
          }
          return 0;
        }
      }
    }
    try
    {
      i = Integer.valueOf(((String)localObject).substring(0, i)).intValue();
      return i;
    }
    catch (Exception localException)
    {
      label226:
      break label226;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUinTotalShowCount  showCount = ");
      ((StringBuilder)localObject).append(this.showCount);
      ((StringBuilder)localObject).append(" uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQOperateVoIP", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperationTaskRecord
 * JD-Core Version:    0.7.0.1
 */