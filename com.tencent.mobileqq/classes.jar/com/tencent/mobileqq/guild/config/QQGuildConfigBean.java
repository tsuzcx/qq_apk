package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGuildConfigBean
{
  public boolean a;
  public boolean b = false;
  public String c = "";
  public String d = "";
  public String e = "https://qun.qq.com/h5/group-create?_wv=16777216&_cwv=1";
  public String f = "https://qun.qq.com/qqweb/qunpro/create?_wv=3&_wwv=132";
  public boolean g;
  public int h;
  public boolean i;
  public List<String> j = new ArrayList();
  public List<GuildCoverInfo> k = new ArrayList();
  
  public static QQGuildConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QQGuildConfigBean localQQGuildConfigBean = new QQGuildConfigBean();
    int n = paramArrayOfQConfItem.length;
    int m = 0;
    Object localObject;
    if (m < n)
    {
      localObject = paramArrayOfQConfItem[m].b;
      if (QLog.isColorLevel()) {
        QLog.d("QQMeetConfigBean", 2, new Object[] { "parse, content=", localObject });
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("whiteUserConfig"))
        {
          if (((JSONObject)localObject).optInt("whiteUserConfig") != 1) {
            break label360;
          }
          bool = true;
          localQQGuildConfigBean.a = bool;
        }
        else if (((JSONObject)localObject).has("isRobotGuildOpen"))
        {
          localQQGuildConfigBean.b = ((JSONObject)localObject).optBoolean("isRobotGuildOpen");
          localQQGuildConfigBean.c = ((JSONObject)localObject).optString("robotListUrl", "");
          localQQGuildConfigBean.d = ((JSONObject)localObject).optString("robotDetailInfoUrl", "");
        }
        else if (((JSONObject)localObject).has("globalGuildConfig"))
        {
          a(localQQGuildConfigBean, ((JSONObject)localObject).optJSONObject("globalGuildConfig"));
        }
        else if (((JSONObject)localObject).has("enableVoiceChannel"))
        {
          if (((JSONObject)localObject).optInt("enableVoiceChannel") != 1) {
            break label365;
          }
          bool = true;
          localQQGuildConfigBean.g = bool;
          localQQGuildConfigBean.h = ((JSONObject)localObject).optInt("voiceChannelMaxPeopleCount");
        }
        else if (((JSONObject)localObject).has("forbiddenShowThirdAppAuthDialog"))
        {
          if (((JSONObject)localObject).optInt("forbiddenShowThirdAppAuthDialog") != 1) {
            break label370;
          }
          bool = true;
          localQQGuildConfigBean.i = bool;
        }
        if (((JSONObject)localObject).has("guildCoverInfo")) {
          b(localQQGuildConfigBean, (JSONObject)localObject);
        }
        if (((JSONObject)localObject).has("guildMedalInfo")) {
          c(localQQGuildConfigBean, (JSONObject)localObject);
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQMeetConfigBean", 1, localException, new Object[0]);
      }
      m += 1;
      break;
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("parse mIsWhiteUser:");
      paramArrayOfQConfItem.append(localQQGuildConfigBean.a);
      QLog.i("QQMeetConfigBean", 1, paramArrayOfQConfItem.toString());
      return localQQGuildConfigBean;
      label360:
      boolean bool = false;
      continue;
      label365:
      bool = false;
      continue;
      label370:
      bool = false;
    }
  }
  
  private static void a(QQGuildConfigBean paramQQGuildConfigBean, JSONObject paramJSONObject)
  {
    paramQQGuildConfigBean.e = paramJSONObject.optString("guild_open_create_url");
  }
  
  private static void b(QQGuildConfigBean paramQQGuildConfigBean, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("guildCoverInfo");
    int n = paramJSONObject.length();
    int m = 0;
    while (m < n)
    {
      Object localObject = paramJSONObject.getJSONObject(m);
      if (((JSONObject)localObject).has("id"))
      {
        localObject = new GuildCoverInfo(((JSONObject)localObject).optString("id"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optString("nameColor"), ((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optString("bgUrl"), ((JSONObject)localObject).optString("guildBgStartColor"), ((JSONObject)localObject).optString("guildBgEndColor"));
        paramQQGuildConfigBean.k.add(localObject);
      }
      m += 1;
    }
  }
  
  private static void c(QQGuildConfigBean paramQQGuildConfigBean, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("guildMedalInfo");
    int i1 = paramJSONObject.length();
    int m = 0;
    while (m < i1)
    {
      Object localObject = paramJSONObject.getJSONObject(m);
      int n = m + 1;
      String str = Integer.toString(n);
      m = n;
      if (((JSONObject)localObject).has(str))
      {
        localObject = ((JSONObject)localObject).optString(str);
        paramQQGuildConfigBean.j.add(localObject);
        m = n;
      }
    }
  }
  
  @NonNull
  public GuildCoverInfo a(String paramString)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      GuildCoverInfo localGuildCoverInfo = (GuildCoverInfo)localIterator.next();
      if (localGuildCoverInfo.a().equals(paramString)) {
        return localGuildCoverInfo;
      }
    }
    return new GuildCoverInfo(paramString, "", "", "", "", "", "");
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsWhiteUser:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",mGuildOpenCreateUrl:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildConfigBean
 * JD-Core Version:    0.7.0.1
 */