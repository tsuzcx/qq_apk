package com.tencent.mobileqq.confess;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.util.Pair;
import java.util.concurrent.ConcurrentHashMap;

public class ConfessCache
{
  public static final Object b = new Object();
  ConcurrentHashMap<String, ConfessInfo> a = new ConcurrentHashMap();
  Pair<String, Boolean> c = new Pair("", Boolean.valueOf(false));
  
  public ConfessInfo a(String arg1, int paramInt1, int paramInt2)
  {
    Object localObject1 = UinTypeUtil.a(???, paramInt1, paramInt2);
    synchronized (b)
    {
      localObject1 = (ConfessInfo)this.a.get(localObject1);
      return localObject1;
    }
  }
  
  public ConfessInfo a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4, long paramLong)
  {
    ConfessInfo localConfessInfo = new ConfessInfo();
    localConfessInfo.reset();
    localConfessInfo.topicId = paramInt2;
    localConfessInfo.confessorSex = paramInt3;
    localConfessInfo.confessorNick = paramString3;
    try
    {
      localConfessInfo.confessorUin = Long.parseLong(paramString2);
      label44:
      localConfessInfo.confessorUinStr = paramString2;
      localConfessInfo.confessTime = paramLong;
      if (paramString4 != null) {
        localConfessInfo.topic = paramString4;
      }
      a(paramString1, paramInt1, localConfessInfo);
      return localConfessInfo;
    }
    catch (Exception paramString3)
    {
      break label44;
    }
  }
  
  public void a(String arg1, int paramInt, ConfessInfo paramConfessInfo)
  {
    String str = UinTypeUtil.a(???, paramInt, paramConfessInfo.topicId);
    synchronized (b)
    {
      ConfessInfo localConfessInfo = (ConfessInfo)this.a.get(str);
      if ((localConfessInfo == null) || (!localConfessInfo.equals(paramConfessInfo))) {
        this.a.put(str, paramConfessInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessCache
 * JD-Core Version:    0.7.0.1
 */