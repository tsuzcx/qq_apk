package com.tencent.mobileqq.vip;

import VIP.AIOSendRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AioVipKeywordHelper
{
  private static AioVipKeywordHelper jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper;
  public static String a = "mvip.pt.android.aiocuifei_recikai";
  public static String b = "mvip.pt.android.aiocuifei_recizeng";
  public static String c = "mvip.p.a.aio_qunkt";
  public static String d = "mvip.p.a.aio_qunzs";
  public static String e = "mvip.p.a.aio_tlzkt";
  public static String f = "mvip.p.a.aio_tlzzs";
  public int a;
  public long a;
  public SessionInfo a;
  public MessageRecord a;
  private AioVipKeywordConfigHelper jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper = AioVipKeywordConfigHelper.a();
  public List<String> a;
  public Map<String, Boolean> a;
  public String[] a;
  public int b;
  public long b;
  public int c;
  public long c;
  public long d;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public AioVipKeywordHelper()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Long = 86400L;
    this.jdField_b_of_type_Long = 86400L;
    this.jdField_c_of_type_Long = 86400L;
    this.jdField_d_of_type_Long = 2000L;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static AioVipKeywordHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper == null) {
          jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper = new AioVipKeywordHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("aioVIPGrayTips");
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("c2cEnable", 1);
      this.jdField_b_of_type_Int = paramJSONObject.optInt("groupEnable", 1);
      this.jdField_c_of_type_Int = paramJSONObject.optInt("discussGroupEnable", 1);
      this.jdField_a_of_type_Long = paramJSONObject.optLong("c2cFreq", 86400L);
      this.jdField_b_of_type_Long = paramJSONObject.optLong("groupFreq", 86400L);
      this.jdField_c_of_type_Long = paramJSONObject.optLong("discussGroupFreq", 86400L);
      this.jdField_d_of_type_Long = paramJSONObject.optLong("fetchWordingTolerateTime", 2000L);
      Object localObject = paramJSONObject.optString("dirtyWords");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      int m = 0;
      ArrayList localArrayList;
      int n;
      int k;
      if (!bool)
      {
        localArrayList = new ArrayList();
        localObject = ((String)localObject).split(";");
        n = localObject.length;
        k = 0;
        while (k < n)
        {
          CharSequence localCharSequence = localObject[k];
          if (!TextUtils.isEmpty(localCharSequence)) {
            localArrayList.add(localCharSequence.trim().toLowerCase());
          }
          k += 1;
        }
        this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
      }
      paramJSONObject = paramJSONObject.optString("groupGrayTail");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramJSONObject = paramJSONObject.split(";");
        n = paramJSONObject.length;
        k = m;
        while (k < n)
        {
          localArrayList = paramJSONObject[k];
          if (!TextUtils.isEmpty(localArrayList)) {
            this.jdField_a_of_type_JavaUtilList.add(localArrayList.trim().toLowerCase());
          }
          k += 1;
        }
      }
    }
  }
  
  private void a(String[] paramArrayOfString, String paramString, ChatMessage paramChatMessage, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int k = 0;
    while (k < paramArrayOfString.length)
    {
      String str = paramArrayOfString[k];
      if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
      {
        paramArrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
        {
          k = 0;
          for (;;)
          {
            paramArrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
            if (k >= paramArrayOfString.length) {
              break;
            }
            paramArrayOfString = paramArrayOfString[k];
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
            k += 1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramChatMessage;
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("detected Keyword, keyword=");
        paramArrayOfString.append(str);
        QLog.d("AioVipKeywordHelper", 4, paramArrayOfString.toString());
        if (!paramBoolean)
        {
          a(paramQQAppInterface, paramSessionInfo, str, false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
        this.j = str;
        ((VIPAioSendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER)).a(str);
        ThreadManager.getUIHandler().postDelayed(new AioVipKeywordHelper.2(this, paramQQAppInterface, paramSessionInfo, str), this.jdField_d_of_type_Long);
        return;
      }
      k += 1;
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 2);
  }
  
  private String[] a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int k = 0;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.jdField_a_of_type_ArrayOfJavaLangString.length >= 1)) {}
    }
    else {
      while ((this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.b == null) || (this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.b.length < 1))
      {
        k = 1;
        break;
      }
    }
    if (k != 0) {
      a(paramContext, paramString);
    }
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.jdField_a_of_type_ArrayOfJavaLangString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.b;
  }
  
  private void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString, Context paramContext, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new AioVipKeywordHelper.1(this, paramQQAppInterface, paramSessionInfo, paramContext, paramString, paramChatMessage, paramBoolean), true);
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
      AvatarPendantUtil.jdField_a_of_type_Int = paramJSONObject.optInt("interval", 5000);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("getStrangerInterval is ");
      paramJSONObject.append(AvatarPendantUtil.jdField_a_of_type_Int);
      QLog.d("AioVipKeywordHelper", 1, paramJSONObject.toString());
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("ipProductGrayTips");
    if (paramJSONObject != null)
    {
      CommercialDrainageManagerConstants.jdField_a_of_type_JavaLangString = paramJSONObject.optString("leftText", CommercialDrainageManagerConstants.jdField_a_of_type_JavaLangString);
      CommercialDrainageManagerConstants.jdField_b_of_type_JavaLangString = paramJSONObject.optString("linkText", CommercialDrainageManagerConstants.jdField_b_of_type_JavaLangString);
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
      com.tencent.mobileqq.floatscr.ColorScreenConstants.jdField_a_of_type_Boolean = bool;
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
  
  public Pair<String, String> a(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = "";
    Object localObject1;
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 3000))
      {
        localObject1 = "";
      }
      else
      {
        if (paramBoolean) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.i;
        } else {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.k;
        }
        String str;
        if (paramBoolean)
        {
          str = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.j;
          localObject2 = localObject1;
          localObject1 = str;
        }
        else
        {
          str = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.l;
          localObject2 = localObject1;
          localObject1 = str;
        }
      }
    }
    else
    {
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.e;
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.f;
      }
      localObject2 = localObject1;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.g;
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.h;
      }
    }
    return new Pair(localObject2, localObject1);
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
          return e;
        }
        return f;
      }
      if (paramBoolean) {
        return jdField_c_of_type_JavaLangString;
      }
      return jdField_d_of_type_JavaLangString;
    }
    if (paramBoolean) {
      return jdField_a_of_type_JavaLangString;
    }
    return jdField_b_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.a(paramContext, paramString);
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
  
  public void a(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if (paramAIOSendRes != null)
    {
      this.g = paramAIOSendRes.sGrayStipMsg;
      Object localObject;
      if (paramAIOSendRes.mHighLightMap != null)
      {
        localObject = paramAIOSendRes.mHighLightMap.keySet().iterator();
        if (((Iterator)localObject).hasNext())
        {
          this.h = ((String)((Iterator)localObject).next());
          this.i = ((String)paramAIOSendRes.mHighLightMap.get(this.h));
        }
      }
      if (QLog.isColorLevel())
      {
        paramAIOSendRes = new StringBuilder();
        paramAIOSendRes.append("fetched tips from server: tips=");
        paramAIOSendRes.append(this.g);
        paramAIOSendRes.append(", highlight=");
        paramAIOSendRes.append(this.h);
        paramAIOSendRes.append(", openUrl=");
        paramAIOSendRes.append(this.i);
        QLog.d("AioVipKeywordHelper", 4, paramAIOSendRes.toString());
      }
      paramAIOSendRes = this.j;
      if (paramAIOSendRes != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (localObject != null)
        {
          a(paramQQAppInterface, (SessionInfo)localObject, paramAIOSendRes, true);
          this.j = null;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramChatMessage != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
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
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          Object localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend(), paramSessionInfo.jdField_a_of_type_Int);
          Object localObject1;
          Object localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend())
          {
            if (paramBoolean) {
              localObject1 = this.g;
            } else {
              localObject1 = (String)((Pair)localObject2).first;
            }
            if (paramBoolean) {
              localObject2 = this.h;
            } else {
              localObject2 = (String)((Pair)localObject2).second;
            }
            if (paramBoolean)
            {
              str = this.i;
              localObject3 = localObject1;
              localObject1 = str;
            }
            else
            {
              str = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.n;
              localObject3 = localObject1;
              localObject1 = str;
            }
          }
          else
          {
            localObject3 = (String)((Pair)localObject2).first;
            localObject2 = (String)((Pair)localObject2).second;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.m;
          }
          String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
          if (a(str))
          {
            a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, str, System.currentTimeMillis());
            a(paramQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, paramSessionInfo.jdField_a_of_type_Int, -4021, (String)localObject3, (String)localObject2, (String)localObject1, paramString);
            if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
              break label294;
            }
            paramQQAppInterface = "0";
            VasWebviewUtil.a(paramString, paramQQAppInterface, "0", a(paramSessionInfo.jdField_a_of_type_Int), str, "", "", "", "", "");
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
          if (paramBoolean)
          {
            this.i = null;
            this.h = null;
            this.g = null;
          }
        }
        return;
      }
      finally {}
      label294:
      paramQQAppInterface = "1";
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.jdField_a_of_type_Boolean = bool;
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
    int k = paramSessionInfo.jdField_a_of_type_Int;
    if (k != 0)
    {
      if ((k != 1) && (k != 3000)) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
        }
        Object localObject = this.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (paramSessionInfo.jdField_a_of_type_JavaLangString.endsWith(str))
            {
              this.jdField_a_of_type_JavaUtilMap.put(paramSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
              return true;
            }
          }
        }
        this.jdField_a_of_type_JavaUtilMap.put(paramSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(false));
      }
      QLog.d("AioVipKeywordHelper", 4, "current uin is not gray number.");
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.jdField_a_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QLog.d("AioVipKeywordHelper", 2, "sessionInfo.curFriendUin is empty, need not detect keyword.");
      return false;
    }
    if (SimpleUIUtil.a()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper.jdField_a_of_type_Int == 0) {
      return false;
    }
    long l1 = 86400L;
    int k = paramSessionInfo.jdField_a_of_type_Int;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 3000)
        {
          k = 0;
        }
        else
        {
          k = this.jdField_c_of_type_Int;
          l1 = this.jdField_c_of_type_Long;
        }
      }
      else
      {
        k = this.jdField_b_of_type_Int;
        l1 = this.jdField_b_of_type_Long;
      }
    }
    else
    {
      k = this.jdField_a_of_type_Int;
      l1 = this.jdField_a_of_type_Long;
    }
    if (k == 0)
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
    ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipKeywordHelper
 * JD-Core Version:    0.7.0.1
 */