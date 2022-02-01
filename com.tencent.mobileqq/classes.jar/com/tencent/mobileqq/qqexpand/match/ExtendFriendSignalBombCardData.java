package com.tencent.mobileqq.qqexpand.match;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.qqexpand.bean.chat.SchoolInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.PersonalTag;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendSignalBombCardData
{
  public long a;
  public String b;
  public String c;
  public long d;
  public String e;
  public String f;
  public long g;
  public int h;
  public String i;
  public int j;
  public ArrayList<String> k;
  public String l;
  public String m;
  public int n;
  public String o;
  public String p;
  
  public static ExtendFriendSignalBombCardData a(MatchInfo paramMatchInfo)
  {
    ExtendFriendSignalBombCardData localExtendFriendSignalBombCardData = new ExtendFriendSignalBombCardData();
    localExtendFriendSignalBombCardData.a = paramMatchInfo.e;
    localExtendFriendSignalBombCardData.b = paramMatchInfo.c;
    localExtendFriendSignalBombCardData.c = paramMatchInfo.g;
    if (paramMatchInfo.k != null)
    {
      localExtendFriendSignalBombCardData.d = paramMatchInfo.k.p;
      Object localObject;
      if ((paramMatchInfo.k.q != null) && (!paramMatchInfo.k.q.isEmpty()))
      {
        localObject = (SchoolInfo)paramMatchInfo.k.q.get(0);
        localExtendFriendSignalBombCardData.f = ((SchoolInfo)localObject).a;
        localExtendFriendSignalBombCardData.g = ((SchoolInfo)localObject).c;
        localExtendFriendSignalBombCardData.e = ((SchoolInfo)localObject).b;
      }
      localExtendFriendSignalBombCardData.h = paramMatchInfo.k.r;
      localExtendFriendSignalBombCardData.i = paramMatchInfo.k.b;
      localExtendFriendSignalBombCardData.j = paramMatchInfo.k.h;
      if (paramMatchInfo.k.f != null)
      {
        localExtendFriendSignalBombCardData.k = new ArrayList(paramMatchInfo.k.f.size());
        localObject = paramMatchInfo.k.f.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PersonalTag localPersonalTag = (PersonalTag)((Iterator)localObject).next();
          localExtendFriendSignalBombCardData.k.add(localPersonalTag.b);
        }
      }
      localExtendFriendSignalBombCardData.l = paramMatchInfo.k.i;
      localExtendFriendSignalBombCardData.m = paramMatchInfo.k.j;
      localExtendFriendSignalBombCardData.n = paramMatchInfo.k.k;
      localExtendFriendSignalBombCardData.h = paramMatchInfo.k.r;
      localExtendFriendSignalBombCardData.o = paramMatchInfo.k.c;
      localExtendFriendSignalBombCardData.p = paramMatchInfo.k.g;
    }
    return localExtendFriendSignalBombCardData;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("uin:%s,nick:%s,dis:%d", new Object[] { this.b, this.c, Integer.valueOf(this.h) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.ExtendFriendSignalBombCardData
 * JD-Core Version:    0.7.0.1
 */