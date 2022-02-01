package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MQQProfileName
{
  public final MQQName a = new MQQName();
  public final List<MQQName> b = new ArrayList();
  
  public Object clone()
  {
    MQQProfileName localMQQProfileName = new MQQProfileName();
    localMQQProfileName.a.a(this.a);
    int i = 0;
    while (i < this.b.size())
    {
      MQQName localMQQName = (MQQName)this.b.get(i);
      localMQQProfileName.b.add((MQQName)localMQQName.clone());
      i += 1;
    }
    return localMQQProfileName;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MQQProfileName;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (MQQProfileName)paramObject;
      bool1 = bool2;
      if (Utils.a(paramObject.a, this.a))
      {
        List localList = this.b;
        int i;
        if (localList == null) {
          i = 0;
        } else {
          i = localList.size();
        }
        localList = paramObject.b;
        int j;
        if (localList == null) {
          j = 0;
        } else {
          j = localList.size();
        }
        bool1 = bool2;
        if (i == j)
        {
          bool1 = true;
          j = 0;
          while ((bool1) && (j < i))
          {
            if (!Utils.a((MQQName)this.b.get(j), (MQQName)paramObject.b.get(j))) {
              bool1 = false;
            }
            j += 1;
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(String.format("[head] type=%s value=%s\n", new Object[] { Integer.valueOf(this.a.a), Utils.i(this.a.b) }));
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        MQQName localMQQName = (MQQName)this.b.get(i);
        if (localMQQName != null) {
          localStringBuilder.append(String.format("[more item] type=%s value=%s\n", new Object[] { Integer.valueOf(localMQQName.a), Utils.i(localMQQName.b) }));
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      QLog.e("MQQProfileName", 1, "toString fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQProfileName
 * JD-Core Version:    0.7.0.1
 */