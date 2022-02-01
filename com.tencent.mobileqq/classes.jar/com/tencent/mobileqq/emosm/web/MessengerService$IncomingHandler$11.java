package com.tencent.mobileqq.emosm.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler$11
  extends IPicDownloadListener
{
  MessengerService$IncomingHandler$11(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, IFavroamingDBManagerService paramIFavroamingDBManagerService, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void onDone(List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2)
  {
    int i = 0;
    if (paramList2 != null) {}
    try
    {
      if (!paramList2.isEmpty())
      {
        int j = paramList2.size();
        if ((paramList1 != null) && (!paramList1.isEmpty()))
        {
          i = paramList1.size();
          this.val$reqbundle.putInt("result", 2);
        }
        else
        {
          this.val$reqbundle.putInt("result", 1);
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("succeedNum", i);
        ((JSONObject)localObject).put("failedNum", j);
        this.val$reqbundle.putString("data", ((JSONObject)localObject).toString());
        paramList2 = paramList2.iterator();
        while (paramList2.hasNext())
        {
          localObject = (CustomEmotionData)paramList2.next();
          this.val$fdb.deleteCustomEmotion((CustomEmotionData)localObject);
        }
      }
      this.val$reqbundle.putInt("result", 0);
      this.val$service.a(this.val$reqbundle);
      this.val$service.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
      paramList2 = this.val$qqApp.getHandler(ChatActivity.class);
      if (paramList2 != null) {
        paramList2.obtainMessage(10).sendToTarget();
      }
      paramList2 = (IFavroamingManagerService)this.val$qqApp.getRuntimeService(IFavroamingManagerService.class);
      if ((paramList2 != null) && (paramList1 != null) && (!paramList1.isEmpty()))
      {
        paramList2.syncUpload(paramList1);
        return;
      }
    }
    catch (Exception paramList1)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
        return;
      }
    }
    catch (JSONException paramList1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */