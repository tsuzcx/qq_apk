package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class CreateTroopShareImpl
  implements ICreateTroopShare
{
  private AppRuntime mApp = null;
  ForwardBaseOption mForwardOption = null;
  
  public void ShareToQQ(JSONObject paramJSONObject, Activity paramActivity)
  {
    Object localObject1 = paramJSONObject.optString("shareLink");
    String str1 = paramJSONObject.optString("shareTitle");
    String str2 = paramJSONObject.optString("shareDesc");
    paramJSONObject = paramJSONObject.optString("shareIcon");
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(149);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715062));
    localStringBuilder.append(str1);
    localObject1 = ((AbsShareMsg.Builder)localObject2).a(localStringBuilder.toString()).e((String)localObject1).a();
    localObject2 = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject2).a(paramJSONObject, str1, str2);
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("forward_type", -3);
    paramJSONObject.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ForwardBaseOption.a(paramActivity, paramJSONObject, 1002);
  }
  
  public void miniAppShareQQDirectly(Intent paramIntent, Activity paramActivity)
  {
    Object localObject = this.mForwardOption;
    if (localObject != null) {
      ((ForwardBaseOption)localObject).z();
    }
    localObject = this.mApp;
    if ((localObject instanceof QQAppInterface))
    {
      this.mForwardOption = ForwardOptionBuilder.a(paramIntent, (QQAppInterface)localObject, paramActivity);
      this.mForwardOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), paramIntent.getExtras());
    }
  }
  
  public void miniAppShareQQDirectlyWithOutDialog(Intent paramIntent, Activity paramActivity)
  {
    Object localObject = this.mForwardOption;
    if (localObject != null) {
      ((ForwardBaseOption)localObject).z();
    }
    localObject = this.mApp;
    if ((localObject instanceof QQAppInterface))
    {
      this.mForwardOption = ForwardOptionBuilder.a(paramIntent, (QQAppInterface)localObject, paramActivity);
      this.mForwardOption.r();
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    ForwardBaseOption localForwardBaseOption = this.mForwardOption;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.CreateTroopShareImpl
 * JD-Core Version:    0.7.0.1
 */