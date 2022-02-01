package com.tencent.mobileqq.guild.mainframe.container.discover.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.im.group_pro_proto.oidb0xf9c.common.Guild;

public class DiscoverGuildBean
{
  public long a;
  public long b;
  public String c;
  public String d;
  public int e;
  public String f;
  public String g;
  public boolean h;
  public String i;
  
  public static DiscoverGuildBean a(common.Guild paramGuild)
  {
    DiscoverGuildBean localDiscoverGuildBean = new DiscoverGuildBean();
    localDiscoverGuildBean.a = paramGuild.id.get();
    localDiscoverGuildBean.b = paramGuild.code.get();
    if ((paramGuild.name.has()) && (!TextUtils.isEmpty(paramGuild.name.get()))) {
      localDiscoverGuildBean.c = paramGuild.name.get();
    }
    if ((paramGuild.profile.has()) && (!TextUtils.isEmpty(paramGuild.profile.get()))) {
      localDiscoverGuildBean.d = paramGuild.profile.get();
    }
    localDiscoverGuildBean.e = paramGuild.type.get();
    if ((paramGuild.cover.has()) && (!TextUtils.isEmpty(paramGuild.cover.get()))) {
      localDiscoverGuildBean.g = a(paramGuild.cover.get());
    }
    if ((paramGuild.avatar.has()) && (!TextUtils.isEmpty(paramGuild.avatar.get()))) {
      localDiscoverGuildBean.f = paramGuild.avatar.get();
    }
    localDiscoverGuildBean.h = paramGuild.verify.get();
    if ((paramGuild.join_sig.has()) && (!TextUtils.isEmpty(paramGuild.join_sig.get().toStringUtf8()))) {
      localDiscoverGuildBean.i = paramGuild.join_sig.get().toStringUtf8();
    }
    return localDiscoverGuildBean;
  }
  
  private static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = Pattern.compile("\\u0024WIDTH\\u0024").matcher(paramString);
      int k = 0;
      int j = 0;
      while (((Matcher)localObject).find()) {
        j += 1;
      }
      if (j != 1) {
        return paramString;
      }
      localObject = ((Matcher)localObject).replaceAll("500");
      localObject = Pattern.compile("\\u0024HEIGHT\\u0024").matcher((CharSequence)localObject);
      j = k;
      while (((Matcher)localObject).find()) {
        j += 1;
      }
      if (j != 1) {
        return paramString;
      }
      localObject = ((Matcher)localObject).replaceAll("300");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("originUrl = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", resultUrl = ");
        localStringBuilder.append((String)localObject);
        QLog.d("GuildDiscover", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    return paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscoverGuildBean{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", profile='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", avatarUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", verify=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", joinSig='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.handler.DiscoverGuildBean
 * JD-Core Version:    0.7.0.1
 */