package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructMsgItemLive$2
  implements View.OnClickListener
{
  StructMsgItemLive$2(StructMsgItemLive paramStructMsgItemLive) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = TextUtils.isEmpty(this.a.as.mMsgActionData);
    int i = 1;
    if ((!bool) && (this.a.as.mMsgActionData.startsWith("story:")))
    {
      localObject1 = this.a.as.mMsgActionData.substring(6, this.a.as.mMsgActionData.length() - 1);
    }
    else
    {
      String[] arrayOfString1 = this.a.aw.substring(this.a.aw.indexOf("?") + 1).split("&");
      localObject2 = "-1";
      localObject1 = "0";
      i = 0;
      while (i < arrayOfString1.length)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        Object localObject3 = localObject1;
        localObject5 = localObject2;
        if (arrayOfString2.length == 2)
        {
          if ("roomid".equals(arrayOfString2[0])) {
            localObject1 = arrayOfString2[1];
          }
          localObject3 = localObject1;
          localObject5 = localObject2;
        }
        try
        {
          if ("from".equals(arrayOfString2[0]))
          {
            localObject5 = arrayOfString2[1];
            localObject3 = localObject1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Object localObject4 = localObject1;
            localObject5 = localObject2;
          }
        }
        i += 1;
        localObject1 = localObject3;
        localObject2 = localObject5;
      }
      localObject1 = String.format("nowmqqapi://now/openroom?src_type=app&version=1&roomid=%s&fromid=%s", new Object[] { localObject1, localObject2 });
      i = 2;
    }
    JumpParser.a(localQQAppInterface, paramView.getContext(), (String)localObject1).a();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("actionType:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("|uri:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("StructMsgQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, ((StringBuilder)localObject2).toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemLive.2
 * JD-Core Version:    0.7.0.1
 */