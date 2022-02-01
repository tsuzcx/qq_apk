package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gprosdk.GProChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChannelMemberInfos
  implements IAudioChannelMemberInfos
{
  private String a;
  private String b;
  private int c;
  private List<GProUserInfo> d = new ArrayList();
  
  public ChannelMemberInfos(String paramString, GProChannelMemberInfos paramGProChannelMemberInfos)
  {
    this.a = paramString;
    this.b = GProConvert.a(paramGProChannelMemberInfos.getChannleId());
    this.c = paramGProChannelMemberInfos.getChannelMemberCount();
    this.d = GProConvert.d(paramGProChannelMemberInfos.getMemberList());
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(ChannelMemberInfos paramChannelMemberInfos)
  {
    if (paramChannelMemberInfos != null)
    {
      if (!this.b.equals(paramChannelMemberInfos.b)) {
        return;
      }
      this.c = paramChannelMemberInfos.c;
      this.d.clear();
      this.d.addAll(paramChannelMemberInfos.d);
    }
  }
  
  public boolean a(GProUserInfo paramGProUserInfo)
  {
    if (paramGProUserInfo == null) {
      return false;
    }
    Object localObject = null;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      GProUserInfo localGProUserInfo = (GProUserInfo)localIterator.next();
      if (localGProUserInfo.a().equals(paramGProUserInfo.a())) {
        localObject = localGProUserInfo;
      }
    }
    if (localObject != null)
    {
      ((GProUserInfo)localObject).a(paramGProUserInfo.k());
      return true;
    }
    this.d.add(paramGProUserInfo);
    this.c += 1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mGuildId: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" mChannleId:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" add audio chanel mem:");
    ((StringBuilder)localObject).append(paramGProUserInfo.a());
    GProLog.d("ChannelMemberInfos", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      GProUserInfo localGProUserInfo = (GProUserInfo)((Iterator)localObject).next();
      if (localGProUserInfo.a().equals(paramString))
      {
        this.d.remove(localGProUserInfo);
        int i = this.c;
        if (i > 0) {
          this.c = (i - 1);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mGuildId: ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" mChannleId:");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" remove audio chanel mem:");
        ((StringBuilder)localObject).append(paramString);
        GProLog.d("ChannelMemberInfos", 1, ((StringBuilder)localObject).toString());
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean b(ChannelMemberInfos paramChannelMemberInfos)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramChannelMemberInfos != null)
    {
      bool1 = bool2;
      if (this.c == paramChannelMemberInfos.c)
      {
        if (this.d.size() != paramChannelMemberInfos.d.size()) {
          return true;
        }
        int j = this.d.size();
        int i = 20;
        if (j < 20) {
          i = this.d.size();
        }
        j = 0;
        while (j < i)
        {
          GProUserInfo localGProUserInfo1 = (GProUserInfo)this.d.get(j);
          GProUserInfo localGProUserInfo2 = (GProUserInfo)paramChannelMemberInfos.d.get(j);
          if (!TextUtils.isEmpty(localGProUserInfo1.a()))
          {
            if (!localGProUserInfo1.a().equals(localGProUserInfo2.a())) {
              return true;
            }
          }
          else if (!TextUtils.isEmpty(localGProUserInfo2.a())) {
            return true;
          }
          j += 1;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public List<IGProUserInfo> d()
  {
    return new ArrayList(this.d);
  }
  
  @NonNull
  public String toString()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Iterator localIterator = this.d.iterator();
      StringBuilder localStringBuilder;
      for (localObject1 = " member infos ==>";; localObject1 = localStringBuilder.toString())
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (GProUserInfo)localIterator.next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(((GProUserInfo)localObject2).toString());
        localStringBuilder.append(", ");
      }
    }
    Object localObject2 = " no member";
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ChannelMemberInfos:{ channelId:");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(" mChannelMemberCount:");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("}");
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos
 * JD-Core Version:    0.7.0.1
 */