package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class GuildNotice
{
  public String a;
  public int b = 0;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  public String f;
  public GuildNotice.GuildNoticeCover g;
  public List<GuildNotice.GuildNoticeText> h;
  public List<GuildNotice.GuildNoticeText> i;
  public List<GuildNotice.GuildNoticeText> j;
  public List<GuildNotice.GuildNoticeAction> k;
  public String l;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (GuildNotice)paramObject;
      return (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.a.equals(paramObject.a)) && (this.f.equals(paramObject.f));
    }
    return false;
  }
  
  @RequiresApi(api=19)
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.a, Integer.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), this.f });
  }
  
  @NonNull
  public String toString()
  {
    Object localObject1 = this.h;
    Object localObject3 = "";
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject4 = this.h.iterator();
      for (localObject1 = "";; localObject1 = ((StringBuilder)localObject5).toString())
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject2 = (GuildNotice.GuildNoticeText)((Iterator)localObject4).next();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append(((GuildNotice.GuildNoticeText)localObject2).toString());
      }
    }
    Object localObject2 = "";
    localObject1 = this.i;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject5 = this.i.iterator();
      for (localObject1 = "";; localObject1 = ((StringBuilder)localObject6).toString())
      {
        localObject4 = localObject1;
        if (!((Iterator)localObject5).hasNext()) {
          break;
        }
        localObject4 = (GuildNotice.GuildNoticeText)((Iterator)localObject5).next();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append((String)localObject1);
        ((StringBuilder)localObject6).append(((GuildNotice.GuildNoticeText)localObject4).toString());
      }
    }
    Object localObject4 = "";
    localObject1 = this.j;
    Object localObject7;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject6 = this.j.iterator();
      for (localObject1 = "";; localObject1 = ((StringBuilder)localObject7).toString())
      {
        localObject5 = localObject1;
        if (!((Iterator)localObject6).hasNext()) {
          break;
        }
        localObject5 = (GuildNotice.GuildNoticeText)((Iterator)localObject6).next();
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append((String)localObject1);
        ((StringBuilder)localObject7).append(((GuildNotice.GuildNoticeText)localObject5).toString());
      }
    }
    Object localObject5 = "";
    localObject1 = this.k;
    Object localObject6 = localObject3;
    if (localObject1 != null)
    {
      localObject6 = localObject3;
      if (((List)localObject1).size() > 0)
      {
        localObject7 = this.k.iterator();
        for (localObject1 = localObject3;; localObject1 = ((StringBuilder)localObject6).toString())
        {
          localObject6 = localObject1;
          if (!((Iterator)localObject7).hasNext()) {
            break;
          }
          localObject3 = (GuildNotice.GuildNoticeAction)((Iterator)localObject7).next();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append((String)localObject1);
          ((StringBuilder)localObject6).append(((GuildNotice.GuildNoticeAction)localObject3).toString());
        }
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("noticeId:");
    ((StringBuilder)localObject3).append(this.a);
    ((StringBuilder)localObject3).append(" templateId:");
    ((StringBuilder)localObject3).append(this.b);
    ((StringBuilder)localObject3).append(" createTs:");
    ((StringBuilder)localObject3).append(this.d);
    ((StringBuilder)localObject3).append(" expireTs:");
    ((StringBuilder)localObject3).append(this.c);
    ((StringBuilder)localObject3).append(" handleTs:");
    ((StringBuilder)localObject3).append(this.e);
    ((StringBuilder)localObject3).append(" guildId:");
    ((StringBuilder)localObject3).append(this.f);
    ((StringBuilder)localObject3).append(" cover:");
    localObject1 = this.g;
    if (localObject1 != null) {
      localObject1 = ((GuildNotice.GuildNoticeCover)localObject1).toString();
    } else {
      localObject1 = "null";
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" strTitle:");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" strSubTitle:");
    ((StringBuilder)localObject3).append((String)localObject4);
    ((StringBuilder)localObject3).append(" strCommentTitle:");
    ((StringBuilder)localObject3).append((String)localObject5);
    ((StringBuilder)localObject3).append(" strAction:");
    ((StringBuilder)localObject3).append((String)localObject6);
    ((StringBuilder)localObject3).append(" joinSign:");
    ((StringBuilder)localObject3).append(this.l);
    return ((StringBuilder)localObject3).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildNotice
 * JD-Core Version:    0.7.0.1
 */