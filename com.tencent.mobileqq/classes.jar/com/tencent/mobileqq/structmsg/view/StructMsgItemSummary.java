package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StructMsgItemSummary
  extends AbsStructMsgTextElement
{
  public int aM = 0;
  public boolean aN = false;
  public int aO = 3;
  
  public StructMsgItemSummary()
  {
    this(null);
  }
  
  public StructMsgItemSummary(String paramString)
  {
    super(paramString, "summary");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("extend-data-json")) && (paramBundle.getInt("serviceID", 0) == 128))
    {
      Object localObject1 = paramBundle.getString("extend-data-json");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          if ((paramContext instanceof BaseActivity))
          {
            Object localObject3 = new JSONObject((String)localObject1);
            localObject1 = ((BaseActivity)paramContext).app;
            StringBuilder localStringBuilder = new StringBuilder();
            if (((JSONObject)localObject3).has("senderuin"))
            {
              localObject2 = ((JSONObject)localObject3).optString("senderuin");
              if (TextUtils.equals((CharSequence)localObject2, ((QQAppInterface)localObject1).getCurrentUin()))
              {
                localObject2 = ContactUtils.a((AppInterface)localObject1, ((JSONObject)localObject3).optString("invitedUin"), 0);
                localStringBuilder.append("你邀请");
                localStringBuilder.append(ContactUtils.a((String)localObject2, 12.0F));
              }
              else
              {
                localStringBuilder.append(ContactUtils.a(ContactUtils.a((AppInterface)localObject1, (String)localObject2, 0), 12.0F));
                localStringBuilder.append("邀请你");
              }
            }
            else
            {
              localStringBuilder.append("邀请");
            }
            localObject2 = ((JSONObject)localObject3).optString("groupname");
            TroopManager localTroopManager = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
            localObject1 = localObject2;
            if (localTroopManager != null)
            {
              localObject3 = localTroopManager.f(((JSONObject)localObject3).optString("groupcode"));
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject3 = ((TroopInfo)localObject3).getTroopDisplayName();
                localObject1 = localObject2;
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  localObject1 = localObject3;
                }
              }
            }
            localStringBuilder.append("加入群聊“");
            localStringBuilder.append(ContactUtils.a((String)localObject1, 12.0F));
            localStringBuilder.append("”，进入可查看详情。");
            this.aA = localStringBuilder.toString();
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createView error:");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.d("StructMsg", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    return super.a(paramContext, paramView, paramBundle);
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentSummary = this.aA;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.aN = paramBoolean;
    this.aM = paramInt;
  }
  
  public String b()
  {
    return "Summary";
  }
  
  public void c(int paramInt)
  {
    this.aO = paramInt;
  }
  
  public int d()
  {
    if ((this.as != null) && (this.as.mMsgServiceID == 35)) {
      return super.d();
    }
    return this.aO;
  }
  
  public int f()
  {
    return 2131448780;
  }
  
  public int i()
  {
    if ((this.aN) && (this.aM != 0)) {
      return -1;
    }
    return -8355712;
  }
  
  public int j()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemSummary
 * JD-Core Version:    0.7.0.1
 */