package com.tencent.mobileqq.qassistant.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.ContentJsonInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssistantRespInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssistantRespInfo.Slot;
import com.tencent.mobileqq.qassistant.data.VoiceAssistantRespInfo.UserInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommandDistributorHelper
{
  private IVoiceAssistantCore jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore = AssistantUtils.a();
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  
  public CommandDistributorHelper()
  {
    a();
  }
  
  private CommandInfo a(ConfirmSendInfo paramConfirmSendInfo)
  {
    return CommandUtils.a(paramConfirmSendInfo);
  }
  
  private CommandInfo a(VoiceAssistantRespInfo paramVoiceAssistantRespInfo)
  {
    if ((paramVoiceAssistantRespInfo != null) && (!TextUtils.isEmpty(paramVoiceAssistantRespInfo.d)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      if (("NO_MATCH".equals(paramVoiceAssistantRespInfo.d)) && (paramVoiceAssistantRespInfo.jdField_a_of_type_Boolean))
      {
        ReportUtils.a(paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
        return CommandUtils.a(AssistantUtils.a(2131720325), true);
      }
      StringBuilder localStringBuilder1;
      if (!TextUtils.isEmpty(paramVoiceAssistantRespInfo.e))
      {
        Object localObject;
        if ("跳转页面".equals(paramVoiceAssistantRespInfo.d))
        {
          if ((!"NO_MATCH".equals(paramVoiceAssistantRespInfo.e)) && (!"不支持此功能".equals(paramVoiceAssistantRespInfo.e)))
          {
            localObject = a(paramVoiceAssistantRespInfo.c);
            if (localObject != null)
            {
              ReportUtils.a(16, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
              return new CommandInfo(((ContentJsonInfo)localObject).jdField_a_of_type_Int, ((ContentJsonInfo)localObject).jdField_a_of_type_JavaLangString, new JumpInfo(((ContentJsonInfo)localObject).jdField_b_of_type_Int));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("buildCommandInfo JumpSkill content = ");
            ((StringBuilder)localObject).append(paramVoiceAssistantRespInfo.c);
            AssistantUtils.a("CommandDistributorHelper", ((StringBuilder)localObject).toString());
          }
          else
          {
            ReportUtils.b();
            return CommandUtils.a(AssistantUtils.a(2131720324), true);
          }
        }
        else if ("智能应答".equals(paramVoiceAssistantRespInfo.d))
        {
          localObject = a(paramVoiceAssistantRespInfo.c);
          if (localObject != null)
          {
            a(paramVoiceAssistantRespInfo.e, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return new CommandInfo(((ContentJsonInfo)localObject).jdField_a_of_type_Int, ((ContentJsonInfo)localObject).jdField_a_of_type_JavaLangString);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("buildCommandInfo smartAnswerSkill content = ");
          ((StringBuilder)localObject).append(paramVoiceAssistantRespInfo.c);
          AssistantUtils.a("CommandDistributorHelper", ((StringBuilder)localObject).toString());
        }
        else
        {
          int i;
          try
          {
            localObject = this.jdField_a_of_type_JavaUtilHashMap;
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramVoiceAssistantRespInfo.d);
            localStringBuilder2.append(paramVoiceAssistantRespInfo.e);
            i = ((Integer)((HashMap)localObject).get(localStringBuilder2.toString())).intValue();
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("buildCommandInfo getIntentType exception = ");
            localStringBuilder2.append(localException.getMessage());
            AssistantUtils.a("CommandDistributorHelper", localStringBuilder2.toString());
            i = 0;
          }
          switch (i)
          {
          default: 
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("buildCommandInfo skill = ");
            localStringBuilder1.append(paramVoiceAssistantRespInfo.d);
            localStringBuilder1.append(", intent = ");
            localStringBuilder1.append(paramVoiceAssistantRespInfo.e);
            AssistantUtils.a("CommandDistributorHelper", localStringBuilder1.toString());
            break;
          case 11: 
            ReportUtils.a(17, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.c);
          case 10: 
            ReportUtils.a(6, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.c);
          case 9: 
            ReportUtils.a(5, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo);
          case 8: 
            ReportUtils.a(15, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.c);
          case 7: 
            ReportUtils.a(9, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(false);
          case 6: 
            ReportUtils.a(10, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(true);
          case 5: 
            ReportUtils.a(8, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.jdField_a_of_type_JavaUtilList, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaUtilList, true);
          case 4: 
            ReportUtils.a(12, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.jdField_a_of_type_JavaUtilList, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaUtilList, false);
          case 3: 
            ReportUtils.a(11, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.jdField_a_of_type_JavaUtilList);
          case 2: 
            ReportUtils.a(13, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.jdField_a_of_type_JavaUtilList, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaUtilList, false);
          case 1: 
            ReportUtils.a(14, paramVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString);
            return a(paramVoiceAssistantRespInfo.e, paramVoiceAssistantRespInfo.c);
          }
        }
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("buildCommandInfo skill = ");
        localStringBuilder1.append(paramVoiceAssistantRespInfo.d);
        AssistantUtils.a("CommandDistributorHelper", localStringBuilder1.toString());
      }
    }
    return null;
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
  
  private CommandInfo a(List<VoiceAssistantRespInfo.Slot> paramList)
  {
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (VoiceAssistantRespInfo.Slot)localIterator.next();
        } while ((TextUtils.isEmpty(((VoiceAssistantRespInfo.Slot)localObject).jdField_a_of_type_JavaLangString)) || (!((VoiceAssistantRespInfo.Slot)localObject).jdField_a_of_type_JavaLangString.equals("num")));
        paramList = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.getCurrentVoiceItemInfo();
      } while ((TextUtils.isEmpty(((VoiceAssistantRespInfo.Slot)localObject).c)) || (paramList == null) || (paramList.isEmpty()));
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = Integer.parseInt(((VoiceAssistantRespInfo.Slot)localObject).c);
        localObject = paramList.iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label293;
        }
        if (((VoiceItemInfo)((Iterator)localObject).next()).a == null) {
          continue;
        }
        i += 1;
        continue;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label305;
        }
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
      }
      catch (Exception paramList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildCommandInfo exception = ");
        ((StringBuilder)localObject).append(paramList.getMessage());
        AssistantUtils.a("CommandDistributorHelper", ((StringBuilder)localObject).toString());
      }
      paramList = CommandUtils.a();
      return paramList;
      break;
      return null;
      label293:
      if (j > 0) {
        if (j > i)
        {
          continue;
          label305:
          paramList = null;
        }
      }
    }
  }
  
  private CommandInfo a(List<VoiceAssistantRespInfo.Slot> paramList, List<VoiceAssistantRespInfo.UserInfo> paramList1, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (VoiceAssistantRespInfo.Slot)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (paramList.jdField_a_of_type_JavaLangString.equals("voiceCallObject")) && (!TextUtils.isEmpty(paramList.c)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject = new ArrayList();
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            VoiceAssistantRespInfo.UserInfo localUserInfo = (VoiceAssistantRespInfo.UserInfo)paramList1.next();
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
    return CommandUtils.a(AssistantUtils.a(2131720322));
  }
  
  private CommandInfo a(boolean paramBoolean)
  {
    return CommandUtils.a(paramBoolean);
  }
  
  private ContentJsonInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    StringBuilder localStringBuilder = null;
    Object localObject1 = localObject2;
    String str;
    if (!bool)
    {
      localObject1 = localObject2;
      if (a(paramString))
      {
        try
        {
          localObject1 = new JSONObject(paramString);
          paramString = new ContentJsonInfo();
          try
          {
            paramString.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("command_type");
            paramString.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("jump_type");
            paramString.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("command_name");
            return paramString;
          }
          catch (JSONException localJSONException1) {}
          localStringBuilder = new StringBuilder();
        }
        catch (JSONException localJSONException2)
        {
          paramString = localStringBuilder;
        }
        localStringBuilder.append("parseContent exception :");
        localStringBuilder.append(localJSONException2.getMessage());
        AssistantUtils.a("CommandDistributorHelper", localStringBuilder.toString());
        str = paramString;
      }
    }
    return str;
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
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      int i = 0;
      if ("功能".equals(paramString1)) {
        i = 1;
      } else if ("脏话".equals(paramString1)) {
        i = 2;
      } else if ("你是谁".equals(paramString1)) {
        i = 3;
      } else if ("在干嘛".equals(paramString1)) {
        i = 4;
      }
      ReportUtils.a(i, str);
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      label11:
      break label11;
    }
    return false;
  }
  
  public void a(VoiceAssistantRespInfo paramVoiceAssistantRespInfo)
  {
    paramVoiceAssistantRespInfo = a(paramVoiceAssistantRespInfo);
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.executeCommand(paramVoiceAssistantRespInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.CommandDistributorHelper
 * JD-Core Version:    0.7.0.1
 */