package com.tencent.mobileqq.guild.message.eventflow;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.group_pro_proto.common.common.Event;

public class GuildMsgEventInfo
{
  private static String c = "GuildMsgEventVersionItem";
  private static long d = -1L;
  public ArrayList<GuildMsgEventInfo.VersionItem> a = new ArrayList();
  public long b = 9223372036854775807L;
  
  public GuildMsgEventInfo() {}
  
  public GuildMsgEventInfo(List<common.Event> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        common.Event localEvent = (common.Event)paramList.next();
        GuildMsgEventInfo.VersionItem localVersionItem = new GuildMsgEventInfo.VersionItem();
        localVersionItem.a = localEvent.type.get();
        localVersionItem.c = localEvent.version.get();
        this.a.add(localVersionItem);
      }
    }
  }
  
  public GuildMsgEventInfo(List<common.Event> paramList, long paramLong)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        common.Event localEvent = (common.Event)paramList.next();
        GuildMsgEventInfo.VersionItem localVersionItem = new GuildMsgEventInfo.VersionItem();
        localVersionItem.a = localEvent.type.get();
        localVersionItem.c = localEvent.version.get();
        if (b(localVersionItem.a)) {
          localVersionItem.b = localVersionItem.c;
        }
        this.a.add(localVersionItem);
      }
    }
    this.b = paramLong;
  }
  
  public static GuildMsgEventInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GuildMsgEventInfo localGuildMsgEventInfo = new GuildMsgEventInfo();
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = paramString.getJSONArray("versions");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
        GuildMsgEventInfo.VersionItem localVersionItem = new GuildMsgEventInfo.VersionItem();
        localVersionItem.a = localJSONObject.getLong("type");
        localVersionItem.b = localJSONObject.getLong("localVersion");
        localVersionItem.c = localJSONObject.getLong("latestVersion");
        localGuildMsgEventInfo.a.add(localVersionItem);
        i += 1;
      }
      localGuildMsgEventInfo.b = paramString.getLong("syncTime");
      return localGuildMsgEventInfo;
    }
    catch (Exception paramString)
    {
      QLog.e(c, 1, paramString.getMessage());
    }
    return null;
  }
  
  private boolean b(long paramLong)
  {
    return (paramLong == 1L) || (paramLong == 2L);
  }
  
  public GuildMsgEventInfo.VersionItem a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      GuildMsgEventInfo.VersionItem localVersionItem = (GuildMsgEventInfo.VersionItem)localIterator.next();
      if (localVersionItem.a == paramLong) {
        return localVersionItem;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      GuildMsgEventInfo.VersionItem localVersionItem = (GuildMsgEventInfo.VersionItem)localIterator.next();
      if ((b(localVersionItem.a)) && (localVersionItem.b < localVersionItem.c)) {
        return true;
      }
    }
    return false;
  }
  
  public long b()
  {
    Iterator localIterator = this.a.iterator();
    label10:
    GuildMsgEventInfo.VersionItem localVersionItem;
    for (long l = 0L; localIterator.hasNext(); l = localVersionItem.b)
    {
      localVersionItem = (GuildMsgEventInfo.VersionItem)localIterator.next();
      if ((!b(localVersionItem.a)) || (l >= localVersionItem.b)) {
        break label10;
      }
    }
    return l;
  }
  
  public String c()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        GuildMsgEventInfo.VersionItem localVersionItem = (GuildMsgEventInfo.VersionItem)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", localVersionItem.a);
        localJSONObject.put("localVersion", localVersionItem.b);
        localJSONObject.put("latestVersion", localVersionItem.c);
        localJSONArray.put(localJSONObject);
      }
      ((JSONObject)localObject).put("versions", localJSONArray);
      ((JSONObject)localObject).put("syncTime", this.b);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e(c, 1, localException.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo
 * JD-Core Version:    0.7.0.1
 */