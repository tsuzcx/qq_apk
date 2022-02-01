package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AudioChannelMgr
{
  private GPSManagerEngine a;
  private Map<String, ChannelMemberInfos> b = new ConcurrentHashMap();
  
  public AudioChannelMgr(GPSManagerEngine paramGPSManagerEngine)
  {
    this.a = paramGPSManagerEngine;
  }
  
  private boolean a(ChannelMemberInfos paramChannelMemberInfos)
  {
    boolean bool2 = this.b.containsKey(paramChannelMemberInfos.b());
    boolean bool1 = true;
    if (bool2)
    {
      localObject = (ChannelMemberInfos)this.b.get(paramChannelMemberInfos.b());
      if (((ChannelMemberInfos)localObject).b(paramChannelMemberInfos))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" update audio channel userList: ");
        localStringBuilder.append(paramChannelMemberInfos.toString());
        GProLog.a("AudioChannelMgr", false, "cache", localStringBuilder.toString());
      }
      else
      {
        bool1 = false;
      }
      ((ChannelMemberInfos)localObject).a(paramChannelMemberInfos);
      return bool1;
    }
    this.b.put(paramChannelMemberInfos.b(), paramChannelMemberInfos);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" add audio channel userList: ");
    ((StringBuilder)localObject).append(paramChannelMemberInfos.toString());
    GProLog.b("AudioChannelMgr", false, "cache", ((StringBuilder)localObject).toString());
    return true;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" remove audio channel userList: ");
    localStringBuilder.append(paramString);
    GProLog.d("AudioChannelMgr", 1, localStringBuilder.toString());
    this.b.remove(paramString);
  }
  
  public void a(String paramString, GProUserInfo paramGProUserInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramGProUserInfo == null) {
        return;
      }
      if (this.b.containsKey(paramString))
      {
        if (this.b.get(paramString) == null) {
          return;
        }
        ChannelMemberInfos localChannelMemberInfos = (ChannelMemberInfos)this.b.get(paramString);
        if (localChannelMemberInfos.a(paramGProUserInfo))
        {
          paramGProUserInfo = new ArrayList();
          paramGProUserInfo.add(paramString);
          this.a.a(31, "addUserToAudioChannel", localChannelMemberInfos.a(), paramGProUserInfo);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (this.b.containsKey(paramString1))
      {
        if (this.b.get(paramString1) == null) {
          return;
        }
        ChannelMemberInfos localChannelMemberInfos = (ChannelMemberInfos)this.b.get(paramString1);
        if ((localChannelMemberInfos != null) && (localChannelMemberInfos.a(paramString2)))
        {
          paramString2 = new ArrayList();
          paramString2.add(paramString1);
          this.a.a(31, "removeUserFromAudioChannel", localChannelMemberInfos.a(), paramString2);
        }
      }
    }
  }
  
  public void a(String paramString, List<ChannelMemberInfos> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelMemberInfos localChannelMemberInfos = (ChannelMemberInfos)paramList.next();
        if ((localChannelMemberInfos != null) && (a(localChannelMemberInfos))) {
          localArrayList.add(localChannelMemberInfos.b());
        }
      }
      if (localArrayList.size() > 0) {
        this.a.a(31, "updateAudioChannelUserList", paramString, localArrayList);
      }
    }
  }
  
  public IAudioChannelMemberInfos b(String paramString)
  {
    return (IAudioChannelMemberInfos)this.b.get(paramString);
  }
  
  public void b(String paramString, List<String> paramList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      if (this.b.containsKey(paramString))
      {
        if (this.b.get(paramString) == null) {
          return;
        }
        ChannelMemberInfos localChannelMemberInfos = (ChannelMemberInfos)this.b.get(paramString);
        if (localChannelMemberInfos != null)
        {
          int k = 0;
          int i = 0;
          int j = k;
          if (paramList != null)
          {
            j = k;
            if (paramList.size() > 0)
            {
              paramList = paramList.iterator();
              for (;;)
              {
                j = i;
                if (!paramList.hasNext()) {
                  break;
                }
                if (localChannelMemberInfos.a((String)paramList.next())) {
                  i = 1;
                }
              }
            }
          }
          if (j != 0)
          {
            paramList = new ArrayList();
            paramList.add(paramString);
            this.a.a(31, "removeUserFromAudioChannel", localChannelMemberInfos.a(), paramList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.AudioChannelMgr
 * JD-Core Version:    0.7.0.1
 */