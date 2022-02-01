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
  private IVoiceAssistantCore a = AssistantUtils.a();
  private HashMap<String, Integer> b;
  
  public CommandDistributorHelper()
  {
    a();
  }
  
  private CommandInfo a(ConfirmSendInfo paramConfirmSendInfo)
  {
    return CommandUtils.a(paramConfirmSendInfo);
  }
  
  private CommandInfo a(String paramString1, String paramString2)
  {
    paramString2 = b(paramString2);
    if (paramString2 != null) {
      paramString2.h = paramString1;
    }
    return paramString2;
  }
  
  private CommandInfo a(List<VoiceAssistantRespInfo.Slot> paramList)
  {
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()) && (this.a != null))
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
        } while ((TextUtils.isEmpty(((VoiceAssistantRespInfo.Slot)localObject).a)) || (!((VoiceAssistantRespInfo.Slot)localObject).a.equals("num")));
        paramList = this.a.getCurrentVoiceItemInfo();
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
        if (((VoiceItemInfo)((Iterator)localObject).next()).d == null) {
          continue;
        }
        i += 1;
        continue;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label305;
        }
        localObject = (VoiceItemInfo)paramList.next();
        if ((((VoiceItemInfo)localObject).d == null) || (j != ((VoiceItemInfo)localObject).d.e)) {
          continue;
        }
        paramList = ((VoiceItemInfo)localObject).d;
        if (paramList != null)
        {
          ReportUtils.c(2);
          return CommandUtils.a(paramList, paramList.d, false);
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
        if ((!TextUtils.isEmpty(paramList.a)) && (paramList.a.equals("voiceCallObject")) && (!TextUtils.isEmpty(paramList.c)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject = new ArrayList();
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            VoiceAssistantRespInfo.UserInfo localUserInfo = (VoiceAssistantRespInfo.UserInfo)paramList1.next();
            FriendItemInfo localFriendItemInfo = new FriendItemInfo();
            localFriendItemInfo.a = String.valueOf(localUserInfo.a);
            localFriendItemInfo.b = localUserInfo.b;
            localFriendItemInfo.c = localUserInfo.c;
            localFriendItemInfo.d = paramBoolean;
            localFriendItemInfo.h = localUserInfo.d;
            ((List)localObject).add(localFriendItemInfo);
          }
          return CommandUtils.a(paramList.b, (List)localObject);
        }
      }
    }
    return CommandUtils.a(AssistantUtils.a(2131917957));
  }
  
  private CommandInfo a(boolean paramBoolean)
  {
    return CommandUtils.a(paramBoolean);
  }
  
  private void a()
  {
    this.b = new HashMap();
    this.b.put("发消息发消息", Integer.valueOf(1));
    this.b.put("发消息发给谁", Integer.valueOf(2));
    this.b.put("发消息选择第几个", Integer.valueOf(3));
    this.b.put("发消息发消息给某人", Integer.valueOf(4));
    this.b.put("发消息找某人", Integer.valueOf(5));
    this.b.put("发消息是的", Integer.valueOf(6));
    this.b.put("发消息不是", Integer.valueOf(7));
    this.b.put("发消息返回", Integer.valueOf(11));
    this.b.put("结束指令结束会话", Integer.valueOf(8));
    this.b.put("语音消息确定发送", Integer.valueOf(9));
    this.b.put("语音消息取消发送", Integer.valueOf(10));
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
  
  private CommandInfo b(VoiceAssistantRespInfo paramVoiceAssistantRespInfo)
  {
    if ((paramVoiceAssistantRespInfo != null) && (!TextUtils.isEmpty(paramVoiceAssistantRespInfo.d)) && (this.b != null))
    {
      if (("NO_MATCH".equals(paramVoiceAssistantRespInfo.d)) && (paramVoiceAssistantRespInfo.i))
      {
        ReportUtils.a(paramVoiceAssistantRespInfo.b);
        return CommandUtils.a(AssistantUtils.a(2131917960), true);
      }
      StringBuilder localStringBuilder1;
      if (!TextUtils.isEmpty(paramVoiceAssistantRespInfo.e))
      {
        Object localObject;
        if ("跳转页面".equals(paramVoiceAssistantRespInfo.d))
        {
          if ((!"NO_MATCH".equals(paramVoiceAssistantRespInfo.e)) && (!"不支持此功能".equals(paramVoiceAssistantRespInfo.e)))
          {
            localObject = c(paramVoiceAssistantRespInfo.c);
            if (localObject != null)
            {
              ReportUtils.a(16, paramVoiceAssistantRespInfo.b);
              return new CommandInfo(((ContentJsonInfo)localObject).a, ((ContentJsonInfo)localObject).c, new JumpInfo(((ContentJsonInfo)localObject).b));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("buildCommandInfo JumpSkill content = ");
            ((StringBuilder)localObject).append(paramVoiceAssistantRespInfo.c);
            AssistantUtils.a("CommandDistributorHelper", ((StringBuilder)localObject).toString());
          }
          else
          {
            ReportUtils.b();
            return CommandUtils.a(AssistantUtils.a(2131917959), true);
          }
        }
        else if ("智能应答".equals(paramVoiceAssistantRespInfo.d))
        {
          localObject = c(paramVoiceAssistantRespInfo.c);
          if (localObject != null)
          {
            b(paramVoiceAssistantRespInfo.e, paramVoiceAssistantRespInfo.b);
            return new CommandInfo(((ContentJsonInfo)localObject).a, ((ContentJsonInfo)localObject).c);
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
            localObject = this.b;
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
            ReportUtils.a(17, paramVoiceAssistantRespInfo.b);
            return b(paramVoiceAssistantRespInfo.c);
          case 10: 
            ReportUtils.a(6, paramVoiceAssistantRespInfo.b);
            return b(paramVoiceAssistantRespInfo.c);
          case 9: 
            ReportUtils.a(5, paramVoiceAssistantRespInfo.b);
            return a(paramVoiceAssistantRespInfo.l);
          case 8: 
            ReportUtils.a(15, paramVoiceAssistantRespInfo.b);
            return b(paramVoiceAssistantRespInfo.c);
          case 7: 
            ReportUtils.a(9, paramVoiceAssistantRespInfo.b);
            return a(false);
          case 6: 
            ReportUtils.a(10, paramVoiceAssistantRespInfo.b);
            return a(true);
          case 5: 
            ReportUtils.a(8, paramVoiceAssistantRespInfo.b);
            return a(paramVoiceAssistantRespInfo.j, paramVoiceAssistantRespInfo.k, true);
          case 4: 
            ReportUtils.a(12, paramVoiceAssistantRespInfo.b);
            return a(paramVoiceAssistantRespInfo.j, paramVoiceAssistantRespInfo.k, false);
          case 3: 
            ReportUtils.a(11, paramVoiceAssistantRespInfo.b);
            return a(paramVoiceAssistantRespInfo.j);
          case 2: 
            ReportUtils.a(13, paramVoiceAssistantRespInfo.b);
            return a(paramVoiceAssistantRespInfo.j, paramVoiceAssistantRespInfo.k, false);
          case 1: 
            ReportUtils.a(14, paramVoiceAssistantRespInfo.b);
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
  
  private CommandInfo b(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return new CommandInfo(paramString.a, paramString.c);
    }
    return null;
  }
  
  private void b(String paramString1, String paramString2)
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
  
  private ContentJsonInfo c(String paramString)
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
            paramString.a = ((JSONObject)localObject1).getInt("command_type");
            paramString.b = ((JSONObject)localObject1).getInt("jump_type");
            paramString.c = ((JSONObject)localObject1).getString("command_name");
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
  
  public void a(VoiceAssistantRespInfo paramVoiceAssistantRespInfo)
  {
    paramVoiceAssistantRespInfo = b(paramVoiceAssistantRespInfo);
    IVoiceAssistantCore localIVoiceAssistantCore = this.a;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.executeCommand(paramVoiceAssistantRespInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.CommandDistributorHelper
 * JD-Core Version:    0.7.0.1
 */