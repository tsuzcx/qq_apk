package com.tencent.mobileqq.qassistant.core;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.ContentJsonInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.Slot;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.UserInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CommandDistributorHelper
{
  private VoiceAssistantManager jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager = (VoiceAssistantManager)AssistantUtils.a().getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  
  public CommandDistributorHelper()
  {
    a();
  }
  
  private CommandInfo a(VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo)
  {
    return CommandUtils.a(paramConfirmSendInfo);
  }
  
  private CommandInfo a(VoiceAssiatantRespInfo paramVoiceAssiatantRespInfo)
  {
    ContentJsonInfo localContentJsonInfo;
    if ((paramVoiceAssiatantRespInfo != null) && (!TextUtils.isEmpty(paramVoiceAssiatantRespInfo.d)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      if (("NO_MATCH".equals(paramVoiceAssiatantRespInfo.d)) && (paramVoiceAssiatantRespInfo.jdField_a_of_type_Boolean))
      {
        ReportUtils.a(paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
        return CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720610), true);
      }
      if (TextUtils.isEmpty(paramVoiceAssiatantRespInfo.e)) {
        break label683;
      }
      if (!"跳转页面".equals(paramVoiceAssiatantRespInfo.d)) {
        break label205;
      }
      if (("NO_MATCH".equals(paramVoiceAssiatantRespInfo.e)) || ("不支持此功能".equals(paramVoiceAssiatantRespInfo.e)))
      {
        ReportUtils.b();
        return CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720609), true);
      }
      localContentJsonInfo = a(paramVoiceAssiatantRespInfo.c);
      if (localContentJsonInfo != null)
      {
        ReportUtils.a(16, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
        return new CommandInfo(localContentJsonInfo.jdField_a_of_type_Int, localContentJsonInfo.jdField_a_of_type_JavaLangString, new JumpInfo(localContentJsonInfo.jdField_b_of_type_Int));
      }
      AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo JumpSkill content = " + paramVoiceAssiatantRespInfo.c);
    }
    label683:
    for (;;)
    {
      return null;
      label205:
      if ("智能应答".equals(paramVoiceAssiatantRespInfo.d))
      {
        localContentJsonInfo = a(paramVoiceAssiatantRespInfo.c);
        if (localContentJsonInfo != null)
        {
          a(paramVoiceAssiatantRespInfo.e, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return new CommandInfo(localContentJsonInfo.jdField_a_of_type_Int, localContentJsonInfo.jdField_a_of_type_JavaLangString);
        }
        AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo smartAnswerSkill content = " + paramVoiceAssiatantRespInfo.c);
      }
      else
      {
        try
        {
          int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramVoiceAssiatantRespInfo.d + paramVoiceAssiatantRespInfo.e)).intValue();
          j = i;
          if (i <= 0) {}
        }
        catch (Exception localException)
        {
          for (;;)
          {
            AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo getIntentType exception = " + localException.getMessage());
            int j = 0;
          }
          ReportUtils.a(14, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.e, paramVoiceAssiatantRespInfo.c);
        }
        switch (j)
        {
        default: 
          AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo skill = " + paramVoiceAssiatantRespInfo.d + ", intent = " + paramVoiceAssiatantRespInfo.e);
          break;
        case 1: 
        case 2: 
          ReportUtils.a(13, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.jdField_a_of_type_JavaUtilList, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaUtilList, false);
        case 3: 
          ReportUtils.a(11, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.jdField_a_of_type_JavaUtilList);
        case 4: 
          ReportUtils.a(12, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.jdField_a_of_type_JavaUtilList, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaUtilList, false);
        case 5: 
          ReportUtils.a(8, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.jdField_a_of_type_JavaUtilList, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaUtilList, true);
        case 6: 
          ReportUtils.a(10, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(true);
        case 7: 
          ReportUtils.a(9, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(false);
        case 8: 
          ReportUtils.a(15, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.c);
        case 9: 
          ReportUtils.a(5, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo);
        case 10: 
          ReportUtils.a(6, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.c);
        case 11: 
          ReportUtils.a(17, paramVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString);
          return a(paramVoiceAssiatantRespInfo.c);
          AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo skill = " + paramVoiceAssiatantRespInfo.d);
        }
      }
    }
  }
  
  private CommandInfo a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return new CommandInfo(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
  
  private CommandInfo a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2);
    if (paramString2 != null) {
      paramString2.jdField_b_of_type_JavaLangString = paramString1;
    }
    return paramString2;
  }
  
  private CommandInfo a(List<VoiceAssiatantRespInfo.Slot> paramList)
  {
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (VoiceAssiatantRespInfo.Slot)localIterator.next();
        } while ((TextUtils.isEmpty(((VoiceAssiatantRespInfo.Slot)localObject).jdField_a_of_type_JavaLangString)) || (!((VoiceAssiatantRespInfo.Slot)localObject).jdField_a_of_type_JavaLangString.equals("num")));
        paramList = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a();
      } while ((TextUtils.isEmpty(((VoiceAssiatantRespInfo.Slot)localObject).c)) || (paramList == null) || (paramList.isEmpty()));
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = Integer.parseInt(((VoiceAssiatantRespInfo.Slot)localObject).c);
        localObject = paramList.iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label284;
        }
        if (((VoiceItemInfo)((Iterator)localObject).next()).a == null) {
          break label281;
        }
        i += 1;
      }
      catch (Exception paramList)
      {
        AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo exception = " + paramList.getMessage());
      }
      return CommandUtils.a();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject = (VoiceItemInfo)paramList.next();
        if ((((VoiceItemInfo)localObject).a == null) || (j != ((VoiceItemInfo)localObject).a.jdField_b_of_type_Int)) {
          continue;
        }
        paramList = ((VoiceItemInfo)localObject).a;
        if (paramList != null)
        {
          ReportUtils.c(2);
          return CommandUtils.a(paramList, paramList.jdField_a_of_type_Boolean, false);
        }
        AssistantUtils.a("CommandDistributorHelper", "buildCommandInfo not find friendItemInfo");
        break;
        break;
        return null;
      }
      paramList = null;
      continue;
      label281:
      continue;
      label284:
      if (j > 0) {
        if (j <= i) {}
      }
    }
  }
  
  private CommandInfo a(List<VoiceAssiatantRespInfo.Slot> paramList, List<VoiceAssiatantRespInfo.UserInfo> paramList1, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (VoiceAssiatantRespInfo.Slot)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (paramList.jdField_a_of_type_JavaLangString.equals("voiceCallObject")) && (!TextUtils.isEmpty(paramList.c)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject = new ArrayList();
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            VoiceAssiatantRespInfo.UserInfo localUserInfo = (VoiceAssiatantRespInfo.UserInfo)paramList1.next();
            FriendItemInfo localFriendItemInfo = new FriendItemInfo();
            localFriendItemInfo.jdField_a_of_type_JavaLangString = String.valueOf(localUserInfo.jdField_a_of_type_Long);
            localFriendItemInfo.jdField_b_of_type_JavaLangString = localUserInfo.jdField_a_of_type_JavaLangString;
            localFriendItemInfo.jdField_a_of_type_Int = localUserInfo.jdField_a_of_type_Int;
            localFriendItemInfo.jdField_a_of_type_Boolean = paramBoolean;
            localFriendItemInfo.jdField_a_of_type_Float = localUserInfo.jdField_a_of_type_Float;
            ((List)localObject).add(localFriendItemInfo);
          }
          return CommandUtils.a(paramList.jdField_b_of_type_JavaLangString, (List)localObject);
        }
      }
    }
    return CommandUtils.a(BaseApplicationImpl.getContext().getString(2131720607));
  }
  
  private CommandInfo a(boolean paramBoolean)
  {
    return CommandUtils.a(paramBoolean);
  }
  
  /* Error */
  private ContentJsonInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +99 -> 103
    //   7: aload_1
    //   8: invokestatic 295	com/tencent/mobileqq/qassistant/core/CommandDistributorHelper:a	(Ljava/lang/String;)Z
    //   11: ifeq +92 -> 103
    //   14: new 297	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 299	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: new 116	com/tencent/mobileqq/qassistant/data/ContentJsonInfo
    //   26: dup
    //   27: invokespecial 300	com/tencent/mobileqq/qassistant/data/ContentJsonInfo:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: aload_2
    //   33: ldc_w 302
    //   36: invokevirtual 305	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: putfield 118	com/tencent/mobileqq/qassistant/data/ContentJsonInfo:jdField_a_of_type_Int	I
    //   42: aload_1
    //   43: aload_2
    //   44: ldc_w 307
    //   47: invokevirtual 305	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   50: putfield 124	com/tencent/mobileqq/qassistant/data/ContentJsonInfo:jdField_b_of_type_Int	I
    //   53: aload_1
    //   54: aload_2
    //   55: ldc_w 309
    //   58: invokevirtual 312	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 120	com/tencent/mobileqq/qassistant/data/ContentJsonInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: ldc 132
    //   71: new 134	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 314
    //   81: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_2
    //   85: invokevirtual 315	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 148	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: areturn
    //   99: astore_2
    //   100: goto -31 -> 69
    //   103: aconst_null
    //   104: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	CommandDistributorHelper
    //   0	105	1	paramString	String
    //   22	33	2	localJSONObject	JSONObject
    //   66	19	2	localJSONException1	org.json.JSONException
    //   99	1	2	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   14	31	66	org/json/JSONException
    //   31	64	99	org/json/JSONException
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息发消息", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息发给谁", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息选择第几个", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息发消息给某人", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息找某人", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息是的", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息不是", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息返回", Integer.valueOf(11));
    this.jdField_a_of_type_JavaUtilHashMap.put("结束指令结束会话", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("语音消息确定发送", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("语音消息取消发送", Integer.valueOf(10));
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      i = 0;
      if (!"功能".equals(paramString1)) {
        break label43;
      }
      i = 1;
    }
    for (;;)
    {
      ReportUtils.a(i, str);
      return;
      label43:
      if ("脏话".equals(paramString1)) {
        i = 2;
      } else if ("你是谁".equals(paramString1)) {
        i = 3;
      } else if ("在干嘛".equals(paramString1)) {
        i = 4;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public void a(VoiceAssiatantRespInfo paramVoiceAssiatantRespInfo)
  {
    paramVoiceAssiatantRespInfo = a(paramVoiceAssiatantRespInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramVoiceAssiatantRespInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.CommandDistributorHelper
 * JD-Core Version:    0.7.0.1
 */