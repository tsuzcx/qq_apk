package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class GuildAIOMultiActionHelper$3
  implements IGetUserInfoCallback
{
  GuildAIOMultiActionHelper$3(GuildAIOMultiActionHelper paramGuildAIOMultiActionHelper) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    GuildAIOMultiActionHelper.b(this.a).removeMessages(24);
    if (GuildAIOMultiActionHelper.a(this.a).ao != null)
    {
      if (!GuildAIOMultiActionHelper.a(this.a).ao.isShowing()) {
        return;
      }
      if (MultiMsgManager.a().e != 2) {
        GuildAIOMultiActionHelper.a(this.a).ao.dismiss();
      }
      MultiMsgManager.a().d.clear();
      paramList1 = new HashMap();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramString = (IGProUserInfo)paramList.next();
          String str = paramString.a();
          if (!TextUtils.isEmpty(paramString.b())) {
            paramString = paramString.b();
          } else {
            paramString = paramString.c();
          }
          paramList1.put(str, paramString);
        }
      }
      MultiMsgManager.a().d.putAll(paramList1);
      this.a.a(paramList1, MultiMsgManager.a().c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildAIOMultiActionHelper.3
 * JD-Core Version:    0.7.0.1
 */