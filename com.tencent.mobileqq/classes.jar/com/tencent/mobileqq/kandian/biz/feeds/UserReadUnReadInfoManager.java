package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadUnRead;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserReadUnReadInfoManager
{
  private List<ReadUnRead> a = new ArrayList();
  private boolean b = false;
  
  public static UserReadUnReadInfoManager a()
  {
    return UserReadUnReadInfoManager.Holder.a();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    ReadUnRead localReadUnRead = new ReadUnRead();
    localReadUnRead.a = NetConnInfoCenter.getServerTime();
    try
    {
      localReadUnRead.b = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int j = 0;
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localReadUnRead.c.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localReadUnRead.d.add(localObject);
          i += 1;
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addUserReadInfo:");
      localStringBuilder.append(paramJSONObject);
      QLog.i("UserReadUnReadInfoManager", 1, localStringBuilder.toString());
      this.a.add(localReadUnRead);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    ReadUnRead localReadUnRead = d();
    return (!localReadUnRead.c.isEmpty()) || (!localReadUnRead.d.isEmpty());
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public ReadUnRead d()
  {
    ReadUnRead localReadUnRead1 = new ReadUnRead();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ReadUnRead localReadUnRead2 = (ReadUnRead)((Iterator)localObject).next();
      if (localReadUnRead2.a + localReadUnRead2.b > l)
      {
        localReadUnRead1.c.addAll(localReadUnRead2.c);
        localReadUnRead1.d.addAll(localReadUnRead2.d);
      }
    }
    localReadUnRead1.d.removeAll(localReadUnRead1.c);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getEffectUserReadInfo:");
    ((StringBuilder)localObject).append(localReadUnRead1);
    QLog.e("UserReadUnReadInfoManager", 1, ((StringBuilder)localObject).toString());
    return localReadUnRead1;
  }
  
  public void e()
  {
    this.a.clear();
    this.b = false;
    QLog.e("UserReadUnReadInfoManager", 1, "clearUserReadUnRead");
  }
  
  public void f()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStart");
  }
  
  public void g()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStop");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager
 * JD-Core Version:    0.7.0.1
 */