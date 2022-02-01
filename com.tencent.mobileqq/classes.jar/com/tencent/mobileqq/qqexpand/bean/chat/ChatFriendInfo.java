package com.tencent.mobileqq.qqexpand.bean.chat;

import com.tencent.mobileqq.qqexpand.bean.match.PersonalTag;
import java.util.ArrayList;

public class ChatFriendInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public ArrayList<PersonalTag> f;
  public String g;
  public int h;
  public String i;
  public String j;
  public int k;
  public String l;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public long p;
  public ArrayList<SchoolInfo> q;
  public int r = -1;
  public int s = -1;
  public String t = "";
  public String u = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{friendUin: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    localStringBuilder.append("{age: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    localStringBuilder.append("{constellation: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    localStringBuilder.append("{city: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    localStringBuilder.append("{school: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    localStringBuilder.append("{constel:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    localStringBuilder.append("{company:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    localStringBuilder.append("{mGender: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    localStringBuilder.append("{mDeclaration: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("}");
    localStringBuilder.append("{mVoiceUrl: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    localStringBuilder.append("{mVoiceDuration: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("}");
    localStringBuilder.append("{signWords: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("}");
    if (this.f == null)
    {
      localStringBuilder.append("{personalTags: is empty ");
      localStringBuilder.append("}");
    }
    else
    {
      localStringBuilder.append("{personalTags:size  ");
      localStringBuilder.append(this.f.size());
      localStringBuilder.append("}");
    }
    localStringBuilder.append("{popular: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append("}");
    if (this.q == null)
    {
      localStringBuilder.append("{schoolInfo: is empty ");
      localStringBuilder.append("}");
    }
    else
    {
      localStringBuilder.append("{schoolInfo:size  ");
      localStringBuilder.append(this.q.size());
      localStringBuilder.append("}");
    }
    localStringBuilder.append("{distance: ");
    localStringBuilder.append(this.r);
    localStringBuilder.append("}");
    localStringBuilder.append("{signalBombMatchPool: ");
    localStringBuilder.append(this.s);
    localStringBuilder.append("}");
    localStringBuilder.append("{strFromCity: ");
    localStringBuilder.append(this.t);
    localStringBuilder.append("}");
    localStringBuilder.append("{strToCity: ");
    localStringBuilder.append(this.u);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo
 * JD-Core Version:    0.7.0.1
 */