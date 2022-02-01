package com.tencent.mobileqq.guild.share;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase.ShareUrlInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.sharehelper.ArkShareInfo;
import com.tencent.mobileqq.sharehelper.QzoneLinkShareInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ShareInfoProvider
{
  private static final Pattern a = Pattern.compile("http(?:s)?://qun.qq.com/qqweb/qunpro/[\\S]+");
  private final IGProGuildInfo b;
  private final FetchShareInfoUseCase.ShareUrlInfo c;
  private final IGProChannelInfo d;
  private final String e;
  private final String f;
  private final boolean g;
  
  public ShareInfoProvider(@NonNull IGProGuildInfo paramIGProGuildInfo, @Nullable IGProChannelInfo paramIGProChannelInfo, @NonNull FetchShareInfoUseCase.ShareUrlInfo paramShareUrlInfo, @NonNull String paramString)
  {
    this(paramIGProGuildInfo, paramIGProChannelInfo, paramShareUrlInfo, paramString, true);
  }
  
  public ShareInfoProvider(@NonNull IGProGuildInfo paramIGProGuildInfo, @Nullable IGProChannelInfo paramIGProChannelInfo, @NonNull FetchShareInfoUseCase.ShareUrlInfo paramShareUrlInfo, @NonNull String paramString, boolean paramBoolean)
  {
    this.b = paramIGProGuildInfo;
    this.d = paramIGProChannelInfo;
    this.e = paramString;
    this.f = k();
    this.g = paramBoolean;
    this.c = a(paramShareUrlInfo, this.f);
  }
  
  @NonNull
  private FetchShareInfoUseCase.ShareUrlInfo a(FetchShareInfoUseCase.ShareUrlInfo paramShareUrlInfo, String paramString)
  {
    Matcher localMatcher = a.matcher(paramShareUrlInfo.b);
    StringBuffer localStringBuffer = new StringBuffer(paramShareUrlInfo.b.length());
    while (localMatcher.find()) {
      localMatcher.appendReplacement(localStringBuffer, a(localMatcher.group(), null));
    }
    localMatcher.appendTail(localStringBuffer);
    return new FetchShareInfoUseCase.ShareUrlInfo(a(paramShareUrlInfo.a, paramString), localStringBuffer.toString());
  }
  
  @NonNull
  private String a(String paramString1, @Nullable String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = URLUtil.a(paramString1, "nickName", URLUtil.c(paramString2));
    }
    paramString2 = URLUtil.a(paramString1, "from", String.valueOf(246610));
    paramString1 = paramString2;
    if (this.g) {
      paramString1 = URLUtil.a(paramString2, "biz", "ka");
    }
    return paramString1;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appId", "com.tencent.qun.pro");
      localJSONObject2.put("title", paramString1);
      localJSONObject2.put("tag", "QQ频道");
      localJSONObject2.put("desc", paramString2);
      localJSONObject2.put("preview", paramString3);
      localJSONObject2.put("jumpUrl", h());
      localJSONObject1.put("contact", localJSONObject2);
    }
    catch (Exception paramString1)
    {
      QLog.e("ShareInfoProvider", 1, "getMetaString exception=", paramString1);
    }
    return localJSONObject1.toString();
  }
  
  private String k()
  {
    String str = QQGuildUtil.g().getAccount();
    return ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(str, false);
  }
  
  private boolean l()
  {
    IGProChannelInfo localIGProChannelInfo = this.d;
    return (localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 2);
  }
  
  private boolean m()
  {
    IGProChannelInfo localIGProChannelInfo = this.d;
    return (localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 5);
  }
  
  public ArkShareInfo a()
  {
    String str = a(d(), e(), b());
    Bundle localBundle = new Bundle();
    localBundle.putString("appName", "com.tencent.qun.pro");
    localBundle.putString("appMinVersion", "1.0.0.0");
    localBundle.putString("appView", "contact");
    localBundle.putString("metaData", str);
    localBundle.putFloat("scale", ViewUtils.getDensity());
    return new ArkShareInfo("com.tencent.qun.pro", "contact", "1.0.0.0", d(), str, localBundle, "guild_share_label");
  }
  
  public String b()
  {
    return this.b.getAvatarUrl(0);
  }
  
  public QzoneLinkShareInfo c()
  {
    QzoneLinkShareInfo localQzoneLinkShareInfo = new QzoneLinkShareInfo();
    localQzoneLinkShareInfo.b(g());
    localQzoneLinkShareInfo.d("");
    localQzoneLinkShareInfo.a(f());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b());
    localQzoneLinkShareInfo.a(localArrayList);
    localQzoneLinkShareInfo.c(h());
    localQzoneLinkShareInfo.a(0);
    localQzoneLinkShareInfo.e(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin());
    localQzoneLinkShareInfo.b(2000);
    return localQzoneLinkShareInfo;
  }
  
  public String d()
  {
    if (l()) {
      return QQGuildUIUtil.a(2131890612);
    }
    if (m()) {
      return QQGuildUIUtil.a(2131890608);
    }
    return QQGuildUIUtil.a(2131890604);
  }
  
  public String e()
  {
    if (l()) {
      return QQGuildUIUtil.a(2131890611, new Object[] { this.f, this.b.getGuildName(), this.d.getChannelName() });
    }
    if (m()) {
      return QQGuildUIUtil.a(2131890607, new Object[] { this.f, this.b.getGuildName(), this.d.getChannelName() });
    }
    return QQGuildUIUtil.a(2131890598, new Object[] { this.f, this.b.getGuildName() });
  }
  
  public String f()
  {
    if (l()) {
      return QQGuildUIUtil.a(2131890613, new Object[] { this.d.getChannelName() });
    }
    if (m()) {
      return QQGuildUIUtil.a(2131890609, new Object[] { this.d.getChannelName() });
    }
    return QQGuildUIUtil.a(2131890605, new Object[] { this.b.getGuildName() });
  }
  
  public String g()
  {
    if ((!l()) && (!m())) {
      return QQGuildUIUtil.a(2131890602, new Object[] { this.e });
    }
    return QQGuildUIUtil.a(2131890603, new Object[] { this.b.getGuildName() });
  }
  
  public String h()
  {
    return this.c.a;
  }
  
  public String i()
  {
    if (!TextUtils.isEmpty(this.c.b)) {
      return this.c.b;
    }
    if (l()) {
      return QQGuildUIUtil.a(2131890614, new Object[] { this.d.getChannelName(), h() });
    }
    if (m()) {
      return QQGuildUIUtil.a(2131890610, new Object[] { this.d.getChannelName(), h() });
    }
    return QQGuildUIUtil.a(2131890606, new Object[] { this.b.getGuildName(), h() });
  }
  
  public String j()
  {
    if ((!l()) && (!m())) {
      return QQGuildUIUtil.a(2131890599);
    }
    return QQGuildUIUtil.a(2131890600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.ShareInfoProvider
 * JD-Core Version:    0.7.0.1
 */