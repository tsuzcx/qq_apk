package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QVipTroopFileConfig
{
  QVipTroopFileConfig.Info a = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info b = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info c = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info d = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info e = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info f = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info g = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info h = new QVipTroopFileConfig.Info();
  QVipTroopFileConfig.Info i = new QVipTroopFileConfig.Info();
  boolean j = true;
  private int k = 0;
  private String l = "";
  private String m = "";
  private String n = "暂不";
  
  @NonNull
  public static QVipTroopFileConfig b(@Nullable String paramString)
  {
    QVipTroopFileConfig localQVipTroopFileConfig = new QVipTroopFileConfig();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localQVipTroopFileConfig.k = paramString.optInt("enable", localQVipTroopFileConfig.k);
        localQVipTroopFileConfig.l = paramString.optString("cacheFlag", localQVipTroopFileConfig.l);
        localQVipTroopFileConfig.m = paramString.optString("intructionPageUrl", localQVipTroopFileConfig.m);
        localQVipTroopFileConfig.a = QVipTroopFileConfig.Info.a(paramString.getJSONObject("fullSpaceMessage"));
        localQVipTroopFileConfig.b = QVipTroopFileConfig.Info.a(paramString.getJSONObject("redSubString"));
        localQVipTroopFileConfig.c = QVipTroopFileConfig.Info.a(paramString.getJSONObject("blueSubString"));
        localQVipTroopFileConfig.d = QVipTroopFileConfig.Info.a(paramString.getJSONObject("blueActionUrl"));
        localQVipTroopFileConfig.e = QVipTroopFileConfig.Info.a(paramString.getJSONObject("fullAlertMessage"));
        localQVipTroopFileConfig.f = QVipTroopFileConfig.Info.a(paramString.getJSONObject("bigFileAlertMessage"));
        localQVipTroopFileConfig.g = QVipTroopFileConfig.Info.a(paramString.getJSONObject("alertButtonTitle"));
        localQVipTroopFileConfig.h = QVipTroopFileConfig.Info.a(paramString.getJSONObject("buttonActionUrl"));
        localQVipTroopFileConfig.i = QVipTroopFileConfig.Info.a(paramString.getJSONObject("AIObuttonActionUrl"));
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("json parse error:");
      localStringBuilder.append(paramString);
      QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" : ");
      paramString.append(localQVipTroopFileConfig.toString());
      QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, paramString.toString());
    }
    return localQVipTroopFileConfig;
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    int i1;
    if ("normal".equals(paramString2)) {
      i1 = 1;
    } else if ("vip".equals(paramString2)) {
      i1 = 2;
    } else if ("svip".equals(paramString2)) {
      i1 = 3;
    } else {
      i1 = 0;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", paramString1, i1, 1, 0, "", "", paramString3, "");
  }
  
  @NonNull
  public static QVipTroopFileConfig c()
  {
    return b("{\"enable\":1,\"cacheFlag\":\"20200403\",\"intructionPageUrl\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\",\"fullSpaceMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传文件仅保留10天，开通超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，开通超级会员可延长至30天。\",\"SVIP\":\"当前群文件容量已满，你已享受超级会员特权，新上传的文件可保留30天。\"},\"redSubString\":{\"nonVIP\":\"容量已满\",\"VIP\":\"容量已满\",\"SVIP\":\"容量已满\"},\"blueSubString\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"超级会员特权\"},\"blueActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\"},\"fullAlertMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传的文件仅保留10天，超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，超级会员可延长至30天。\",\"SVIP\":\"\"},\"bigFileAlertMessage\":{\"nonVIP\":\"临时文件有效期10天，开通超级会员可将保存时间延长至30天\",\"VIP\":\"会员上传的临时文件有效期20天，开通超级会员可将保存时间延长至30天。\",\"SVIP\":\"\"},\"alertButtonTitle\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"\"},\"buttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"},\"AIObuttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"}}");
  }
  
  public SpannableString a(String paramString)
  {
    String str1 = this.a.a(paramString);
    String str2 = this.b.a(paramString);
    String str3 = this.c.a(paramString);
    String str4 = this.d.a(paramString);
    SpannableString localSpannableString = new SpannableString(str1);
    int i1 = str1.indexOf(str2);
    if (i1 > -1) {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), i1, str2.length() + i1, 33);
    }
    i1 = str1.indexOf(str3);
    if (i1 > -1) {
      localSpannableString.setSpan(new QVipTroopFileConfig.1(this, str4, paramString), i1, str3.length() + i1, 33);
    }
    b("0X800AE66", paramString, "");
    return localSpannableString;
  }
  
  void a(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = DialogUtil.a(paramContext, 230, "", paramString1, this.n, this.g.a(paramString2), new QVipTroopFileConfig.3(this, paramContext, paramBoolean1, paramString2, paramBoolean2), new QVipTroopFileConfig.4(this, paramRunnable, paramBoolean1, paramString2, paramBoolean2));
    paramContext.getTitleTextView().setVisibility(8);
    paramContext.show();
    if (paramBoolean1) {
      paramContext = "0X800AE69";
    } else {
      paramContext = "0X800AE63";
    }
    if (paramBoolean2) {
      paramString1 = "size";
    } else {
      paramString1 = "full";
    }
    b(paramContext, paramString2, paramString1);
    paramString2 = (IMobileReportManager)QRoute.api(IMobileReportManager.class);
    paramString1 = "2";
    if (paramBoolean1) {
      paramContext = "2";
    } else {
      paramContext = "3";
    }
    if (!paramBoolean1) {
      paramString1 = "1";
    }
    paramString2.reportAction("", "", "platform898", paramContext, paramString1, 111, 1, System.currentTimeMillis());
  }
  
  public boolean a()
  {
    return this.k == 1;
  }
  
  public boolean a(Context paramContext, Runnable paramRunnable, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      localObject = this.f;
    } else {
      localObject = this.e;
    }
    Object localObject = ((QVipTroopFileConfig.Info)localObject).a(paramString);
    if (!(TextUtils.isEmpty((CharSequence)localObject) ^ true)) {
      return false;
    }
    if (!b()) {
      return false;
    }
    a(paramContext, (String)localObject, paramString, paramRunnable, paramBoolean2, paramBoolean1);
    return true;
  }
  
  public boolean a(@NonNull SpannableString paramSpannableString, @NonNull String paramString1, String paramString2)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramSpannableString)))
    {
      str = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
    }
    try
    {
      int i2 = Integer.valueOf(str).intValue();
      int i1;
      if (paramSpannableString.toString().contains("\n"))
      {
        str = paramSpannableString.toString().replace("\n", "");
        i1 = 1;
      }
      else
      {
        str = paramSpannableString.toString();
        i1 = 0;
      }
      int i3 = str.indexOf(paramString1);
      if ((i2 > 10) && (i3 > -1))
      {
        paramSpannableString.setSpan(new QVipTroopFileConfig.2(this, paramString2), i3, paramString1.length() + i3 + i1, 33);
        b("0X800AE6C", paramString2, "");
        return true;
      }
      return false;
    }
    catch (Exception paramSpannableString) {}
    return false;
  }
  
  boolean b()
  {
    if (!this.j) {
      return false;
    }
    this.j = false;
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences();
    boolean bool = TextUtils.equals(this.l, localSharedPreferences.getString("vas_guide_troop_file", null)) ^ true;
    if (bool) {
      localSharedPreferences.edit().putString("vas_guide_troop_file", this.l).apply();
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QVipTroopFileConfig{enable=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", cacheFlag='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", intructionPageUrl='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fullSpaceMessage=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", redSubString=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", blueSubString=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", blueActionUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", fullAlertMessage=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", bigFileAlertMessage=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", alertButtonTitle=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", buttonActionUrl=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", AIObuttonActionUrl=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig
 * JD-Core Version:    0.7.0.1
 */