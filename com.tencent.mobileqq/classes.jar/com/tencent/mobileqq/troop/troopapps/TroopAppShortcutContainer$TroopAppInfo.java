package com.tencent.mobileqq.troop.troopapps;

import java.util.ArrayList;
import java.util.List;

public class TroopAppShortcutContainer$TroopAppInfo
{
  public int a = 0;
  public long b;
  public long c = 0L;
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public int h = 0;
  public String i = "";
  public boolean j = false;
  public int k = 0;
  public String l = "";
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  List<String> q = new ArrayList();
  List<String> r = new ArrayList();
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof TroopAppInfo))
    {
      bool1 = bool2;
      if (((TroopAppInfo)paramObject).c == this.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopAppInfo{app_showtype='");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_type='");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_appid='");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_removable='");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_source='");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_name='");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_icon='");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_url='");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_desc='");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_added='");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_redpoint='");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_trace='");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_showframe='");
    ((StringBuilder)localObject).append(this.m);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_playingnum='");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_friend_playingnum='");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_total_playingnum='");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append('\'');
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = this.q;
    int i2 = 0;
    int i3;
    int i1;
    if (localObject != null)
    {
      localStringBuilder.append(", app_playing_users='");
      i3 = this.q.size();
      i1 = 0;
      while (i1 < i3)
      {
        if (i1 == i3 - 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.q.get(i1));
          ((StringBuilder)localObject).append("'");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.q.get(i1));
          ((StringBuilder)localObject).append("、 ");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        i1 += 1;
      }
    }
    if (this.r != null)
    {
      localStringBuilder.append(", app_recommend_tags='");
      i3 = this.r.size();
      i1 = i2;
      while (i1 < i3)
      {
        if (i1 == i3 - 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.r.get(i1));
          ((StringBuilder)localObject).append("'");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.r.get(i1));
          ((StringBuilder)localObject).append("、 ");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        i1 += 1;
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.TroopAppInfo
 * JD-Core Version:    0.7.0.1
 */