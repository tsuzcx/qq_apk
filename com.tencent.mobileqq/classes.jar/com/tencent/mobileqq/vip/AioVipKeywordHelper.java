package com.tencent.mobileqq.vip;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.VasEmojiManagerContstant;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.model.CommercialDrainageManagerConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VipLongMsgShareDomainHelper;
import com.tencent.mobileqq.vas.helper.AioVipKeywordConfigHelper;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class AioVipKeywordHelper
{
  public static final String[] a = { HardCodeUtil.a(2131903317), HardCodeUtil.a(2131903313), HardCodeUtil.a(2131903315), HardCodeUtil.a(2131903318), HardCodeUtil.a(2131903316), HardCodeUtil.a(2131903314), HardCodeUtil.a(2131903312) };
  public static String b = "mvip.pt.android.aiocuifei_recikai";
  public static String c = "mvip.pt.android.aiocuifei_recizeng";
  public static String d = "mvip.p.a.aio_qunkt";
  public static String e = "mvip.p.a.aio_qunzs";
  public static String f = "mvip.p.a.aio_tlzkt";
  public static String g = "mvip.p.a.aio_tlzzs";
  private static AioVipKeywordHelper s;
  public MessageRecord h;
  public int i = 1;
  public int j = 1;
  public int k = 1;
  public long l = 86400L;
  public long m = 86400L;
  public long n = 86400L;
  public long o = 2000L;
  public String[] p;
  public List<String> q;
  public Map<String, Boolean> r = new HashMap();
  private AioVipKeywordConfigHelper t = AioVipKeywordConfigHelper.a();
  
  public static AioVipKeywordHelper a()
  {
    if (s == null) {
      try
      {
        if (s == null) {
          s = new AioVipKeywordHelper();
        }
      }
      finally {}
    }
    return s;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("aioVIPGrayTips");
    if (paramJSONObject != null)
    {
      this.i = paramJSONObject.optInt("c2cEnable", 1);
      this.j = paramJSONObject.optInt("groupEnable", 1);
      this.k = paramJSONObject.optInt("discussGroupEnable", 1);
      this.l = paramJSONObject.optLong("c2cFreq", 86400L);
      this.m = paramJSONObject.optLong("groupFreq", 86400L);
      this.n = paramJSONObject.optLong("discussGroupFreq", 86400L);
      this.o = paramJSONObject.optLong("fetchWordingTolerateTime", 2000L);
      Object localObject = paramJSONObject.optString("dirtyWords");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      int i2 = 0;
      ArrayList localArrayList;
      int i3;
      int i1;
      if (!bool)
      {
        localArrayList = new ArrayList();
        localObject = ((String)localObject).split(";");
        i3 = localObject.length;
        i1 = 0;
        while (i1 < i3)
        {
          CharSequence localCharSequence = localObject[i1];
          if (!TextUtils.isEmpty(localCharSequence)) {
            localArrayList.add(localCharSequence.trim().toLowerCase());
          }
          i1 += 1;
        }
        this.p = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
      }
      paramJSONObject = paramJSONObject.optString("groupGrayTail");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.q = new ArrayList();
        paramJSONObject = paramJSONObject.split(";");
        i3 = paramJSONObject.length;
        i1 = i2;
        while (i1 < i3)
        {
          localArrayList = paramJSONObject[i1];
          if (!TextUtils.isEmpty(localArrayList)) {
            this.q.add(localArrayList.trim().toLowerCase());
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(String[] paramArrayOfString, String paramString, ChatMessage paramChatMessage, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i2 = 0;
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i1];
      if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
      {
        paramArrayOfString = this.p;
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
        {
          i1 = i2;
          for (;;)
          {
            paramArrayOfString = this.p;
            if (i1 >= paramArrayOfString.length) {
              break;
            }
            paramArrayOfString = paramArrayOfString[i1];
            if ((!TextUtils.isEmpty(paramArrayOfString)) && (paramString.contains(paramArrayOfString)))
            {
              paramString = new StringBuilder();
              paramString.append("detected Keyword but contain dirty word, keyword=");
              paramString.append(str);
              paramString.append(", dirty word=");
              paramString.append(paramArrayOfString);
              QLog.d("AioVipKeywordHelper", 4, paramString.toString());
              return;
            }
            i1 += 1;
          }
        }
        this.h = paramChatMessage;
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("detected Keyword, keyword=");
        paramArrayOfString.append(str);
        QLog.d("AioVipKeywordHelper", 4, paramArrayOfString.toString());
        ((VIPAioSendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER)).a(paramSessionInfo.b, paramSessionInfo.a, str, paramBoolean);
        a(paramQQAppInterface, paramSessionInfo, str);
        return;
      }
      i1 += 1;
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 2);
  }
  
  private void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString, Context paramContext, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new AioVipKeywordHelper.1(this, paramQQAppInterface, paramSessionInfo, paramString, paramChatMessage, paramBoolean), true);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("shareDomainConfig");
    if (paramJSONObject != null) {
      VipLongMsgShareDomainHelper.a().a(paramJSONObject);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("tmsDualCoreConfig");
    if (paramJSONObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tms DPC : ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("KC.TMSManager", 1, localStringBuilder.toString());
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("downloadTimeoutConfig");
    if (paramJSONObject != null)
    {
      EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT = paramJSONObject.optInt("emotion", EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT);
      boolean bool = false;
      if (paramJSONObject.optInt("emoTryReadNoLen", 0) == 1) {
        bool = true;
      }
      EmojiManagerServiceConstant.EMOTION_TRY_DOWNLOAD = bool;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadTimeoutConfig is ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("AioVipKeywordHelper", 1, localStringBuilder.toString());
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("getStrangerInterval");
    if (paramJSONObject != null)
    {
      AvatarPendantUtil.h = paramJSONObject.optInt("interval", 5000);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("getStrangerInterval is ");
      paramJSONObject.append(AvatarPendantUtil.h);
      QLog.d("AioVipKeywordHelper", 1, paramJSONObject.toString());
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("ipProductGrayTips");
    if (paramJSONObject != null)
    {
      CommercialDrainageManagerConstants.i = paramJSONObject.optString("leftText", CommercialDrainageManagerConstants.i);
      CommercialDrainageManagerConstants.j = paramJSONObject.optString("linkText", CommercialDrainageManagerConstants.j);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipProductGrayTips: ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("AioVipKeywordHelper", 2, localStringBuilder.toString());
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("lottieConfig");
    if (paramJSONObject != null)
    {
      boolean bool;
      if (paramJSONObject.optInt("switch") == 1) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.mobileqq.floatscr.ColorScreenConstants.a = bool;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("lottieConfig.switch is ");
      paramJSONObject.append(bool);
      QLog.i("AioVipKeywordHelper", 1, paramJSONObject.toString());
    }
  }
  
  private void h(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("recommendConfig");
    if (paramJSONObject != null) {
      EmoticonRecDressup.setRecommendClearTime(paramJSONObject.optLong("interval", 86400L));
    }
  }
  
  public String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return "";
        }
        return "2";
      }
      return "1";
    }
    return "0";
  }
  
  public String a(boolean paramBoolean, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return "";
        }
        if (paramBoolean) {
          return f;
        }
        return g;
      }
      if (paramBoolean) {
        return d;
      }
      return e;
    }
    if (paramBoolean) {
      return b;
    }
    return c;
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = null;
    File localFile = new File(paramContext.getFilesDir(), "vipKerwordJson");
    paramContext = localObject;
    if (localFile.exists()) {
      paramContext = FileUtils.readFileContent(localFile);
    }
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    this.t.a(paramContext, paramString);
    a(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AioVipKeywordGrayTips_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lastShowGrayTipsTime_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    paramQQAppInterface.putLong(((StringBuilder)localObject).toString(), paramLong).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramChatMessage != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.h != null)
      {
        QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
        return;
      }
      if (!a(paramQQAppInterface, paramSessionInfo)) {
        return;
      }
      b(paramQQAppInterface, paramSessionInfo, paramChatMessage, paramString, paramContext, paramBoolean);
      return;
    }
    QLog.e("AioVipKeywordHelper", 1, "detectKeyword : params error");
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.h != null)
        {
          String str = paramSessionInfo.b;
          if (a(str))
          {
            a(paramQQAppInterface, paramSessionInfo.a, str, System.currentTimeMillis());
            if (this.h.isSend())
            {
              paramQQAppInterface = "0";
              VasWebviewUtil.a(paramString, paramQQAppInterface, "0", a(paramSessionInfo.a), str, "", "", "", "", "");
            }
          }
          else
          {
            this.h = null;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramQQAppInterface = "1";
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramAppRuntime = VasUpdateUtil.a(paramAppRuntime, "vip_personal_card.json", true, null);
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 2, "parsejson file not exists");
      }
      return;
    }
    JSONObject localJSONObject = paramAppRuntime.optJSONObject("isChooseStyleClosed");
    if (localJSONObject != null)
    {
      if (localJSONObject.optInt("isChooseStyleClosed", 0) != 1) {
        bool = false;
      }
      com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.a = bool;
    }
    a(paramAppRuntime);
    h(paramAppRuntime);
    g(paramAppRuntime);
    f(paramAppRuntime);
    e(paramAppRuntime);
    d(paramAppRuntime);
    c(paramAppRuntime);
    b(paramAppRuntime);
    VasEmojiManagerContstant.setMagicTips(paramAppRuntime.optJSONArray("h5MagicTips"));
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    int i1 = paramSessionInfo.a;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 3000)) {
        return false;
      }
      if (this.t.r)
      {
        if (this.r.containsKey(paramSessionInfo.b)) {
          return ((Boolean)this.r.get(paramSessionInfo.b)).booleanValue();
        }
        Object localObject = this.q;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = this.q.iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (paramSessionInfo.b.endsWith(str))
            {
              this.r.put(paramSessionInfo.b, Boolean.valueOf(true));
              return true;
            }
          }
        }
        this.r.put(paramSessionInfo.b, Boolean.valueOf(false));
      }
      QLog.d("AioVipKeywordHelper", 4, "current uin is not gray number.");
      return false;
    }
    return this.t.r;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramSessionInfo.b))
    {
      QLog.d("AioVipKeywordHelper", 2, "sessionInfo.curFriendUin is empty, need not detect keyword.");
      return false;
    }
    if (SimpleUIUtil.e()) {
      return false;
    }
    long l1 = 86400L;
    int i1 = paramSessionInfo.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 3000)
        {
          i1 = 0;
        }
        else
        {
          i1 = this.k;
          l1 = this.n;
        }
      }
      else
      {
        i1 = this.j;
        l1 = this.m;
      }
    }
    else
    {
      i1 = this.i;
      l1 = this.l;
    }
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "VIP Keyword Function is closed.");
      }
      return false;
    }
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AioVipKeywordGrayTips_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lastShowGrayTipsTime_");
    ((StringBuilder)localObject).append(paramSessionInfo.a);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramSessionInfo.b);
    long l2 = paramQQAppInterface.getLong(((StringBuilder)localObject).toString(), 0L);
    if (System.currentTimeMillis() - l2 < 1000L * l1)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("VIP Keyword Function frequency = ");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append("s, so need not detect keyword.");
      QLog.d("AioVipKeywordHelper", 4, paramQQAppInterface.toString());
      return false;
    }
    return a(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipKeywordHelper
 * JD-Core Version:    0.7.0.1
 */