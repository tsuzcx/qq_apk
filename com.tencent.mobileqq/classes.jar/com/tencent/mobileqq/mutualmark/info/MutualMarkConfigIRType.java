package com.tencent.mobileqq.mutualmark.info;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MutualMarkConfigIRType
{
  public long a;
  public String b;
  public int c = -1;
  public boolean d = false;
  public int e = 999;
  public boolean f;
  public ArrayList<MutualMarkConfigIRType.TypeItem> g;
  
  public static MutualMarkConfigIRType a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = new MutualMarkConfigIRType();
    for (;;)
    {
      try
      {
        ((MutualMarkConfigIRType)localObject).a = paramJSONObject.optLong("type");
        ((MutualMarkConfigIRType)localObject).b = paramJSONObject.optString("cluster");
        bool = paramJSONObject.has("disableLocalResource");
        int i = 0;
        if (bool)
        {
          if (paramJSONObject.optInt("disableLocalResource") == 1)
          {
            bool = true;
            ((MutualMarkConfigIRType)localObject).f = bool;
          }
        }
        else
        {
          if (paramJSONObject.has("typeItem"))
          {
            paramJSONObject = paramJSONObject.optJSONArray("typeItem");
            ((MutualMarkConfigIRType)localObject).g = new ArrayList();
            if (i < paramJSONObject.length())
            {
              MutualMarkConfigIRType.TypeItem localTypeItem = MutualMarkConfigIRType.TypeItem.a(paramJSONObject.getJSONObject(i));
              if (localTypeItem != null)
              {
                ((MutualMarkConfigIRType)localObject).g.add(localTypeItem);
                localTypeItem.g = ((MutualMarkConfigIRType)localObject);
              }
              i += 1;
              continue;
            }
          }
          return localObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse error->");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.e("MutualMarkConfigIRType", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      boolean bool = false;
    }
  }
  
  public MutualMarkConfigIRType.TypeItem a(long paramLong)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)((Iterator)localObject).next();
        if ((localTypeItem != null) && (localTypeItem.e == paramLong)) {
          return localTypeItem;
        }
      }
    }
    return null;
  }
  
  public boolean a()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)((Iterator)localObject).next();
        if ((localTypeItem != null) && (localTypeItem.c)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b(long paramLong)
  {
    MutualMarkConfigIRType.TypeItem localTypeItem = a(paramLong);
    if (localTypeItem != null) {
      return localTypeItem.c;
    }
    return false;
  }
  
  public String c(long paramLong)
  {
    MutualMarkConfigIRType.TypeItem localTypeItem = a(paramLong);
    if (localTypeItem != null) {
      return localTypeItem.b;
    }
    return "";
  }
  
  public long d(long paramLong)
  {
    Object localObject = this.g;
    long l1 = -1L;
    long l2 = l1;
    if (localObject != null)
    {
      l2 = l1;
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = this.g.iterator();
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)((Iterator)localObject).next();
          if ((localTypeItem != null) && (localTypeItem.c) && (localTypeItem.e <= paramLong)) {
            l1 = localTypeItem.e;
          }
        }
      }
    }
    return l2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkConfigIRType{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cluster='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sortKeyForNormal=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isInAIOTitleLeft2=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", sortKeyForAIOTitle=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", disableLocalResource=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", typeItems=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType
 * JD-Core Version:    0.7.0.1
 */