package com.tencent.mobileqq.emosm.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler$12
  extends IPicDownloadListener
{
  MessengerService$IncomingHandler$12(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, QQAppInterface paramQQAppInterface, MessengerService paramMessengerService) {}
  
  public void onDone(List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2)
  {
    int i2 = 0;
    if (paramList2 != null) {}
    label670:
    label686:
    label687:
    label703:
    label712:
    for (;;)
    {
      int n;
      try
      {
        int m;
        if (!paramList2.isEmpty())
        {
          m = paramList2.size();
          if ((paramList1 != null) && (!paramList1.isEmpty()))
          {
            i = paramList1.size();
            this.val$reqbundle.putInt("result", 2);
          }
          else
          {
            this.val$reqbundle.putInt("result", 1);
            i = 0;
          }
          paramList2 = new JSONObject();
          paramList2.put("succeedNum", i);
          paramList2.put("failedNum", m);
          this.val$reqbundle.putString("data", paramList2.toString());
        }
        else
        {
          this.val$reqbundle.putInt("result", 0);
          m = 0;
        }
        Object localObject;
        int i3;
        HashSet localHashSet;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        CustomEmotionData localCustomEmotionData;
        if ((paramList1 != null) && (!paramList1.isEmpty()))
        {
          paramList2 = (IFavroamingDBManagerService)this.val$qqApp.getRuntimeService(IFavroamingDBManagerService.class);
          localObject = paramList2.getEmoticonDataList();
          i3 = FavEmoConstant.a;
          localHashSet = new HashSet();
          if (localObject == null) {
            break label703;
          }
          n = 0;
          k = 1;
          i = 0;
          j = k;
          i1 = i;
          if (n < ((List)localObject).size())
          {
            i1 = ((CustomEmotionData)((List)localObject).get(n)).emoId;
            j = k;
            if (k < i1) {
              j = i1;
            }
            i1 = i;
            if ("needDel".equals(((CustomEmotionData)((List)localObject).get(n)).RomaingType)) {
              break label687;
            }
            i += 1;
            i1 = i;
            if (TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(n)).md5)) {
              break label687;
            }
            localHashSet.add(((CustomEmotionData)((List)localObject).get(n)).md5);
            i1 = i;
            break label687;
          }
          i = paramList1.size();
          localObject = new ArrayList();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          n = i + i1;
          i = i2;
          if (n > i3) {
            i = 1;
          }
          paramList1 = paramList1.iterator();
          if (paramList1.hasNext())
          {
            localCustomEmotionData = (CustomEmotionData)paramList1.next();
            if (i == 0) {}
          }
        }
        try
        {
          ((ArrayList)localObject).add(localCustomEmotionData.eId);
          localArrayList1.add(localCustomEmotionData.url);
          if (localCustomEmotionData.md5 == null) {
            localArrayList2.add("");
          } else {
            localArrayList2.add(localCustomEmotionData.md5);
          }
        }
        catch (JSONException paramList1)
        {
          break label670;
        }
        k = j + 1;
        localCustomEmotionData.emoId = k;
        j = k;
        if (TextUtils.isEmpty(localCustomEmotionData.md5)) {
          break label712;
        }
        j = k;
        if (localHashSet.contains(localCustomEmotionData.md5)) {
          break label712;
        }
        paramList2.insertCustomEmotion(localCustomEmotionData);
        j = k;
        break label712;
        if (i != 0)
        {
          this.val$reqbundle.putInt("extra_key_over_num", n - i3);
          this.val$reqbundle.putBoolean("openManagerActivity", true);
          this.val$reqbundle.putStringArrayList("extra_key_paths", localArrayList1);
          this.val$reqbundle.putStringArrayList("extra_key_pkgids", (ArrayList)localObject);
          this.val$reqbundle.putStringArrayList("extra_key_md5s", localArrayList2);
          this.val$reqbundle.putInt("extra_key_faile_count", m);
        }
        else
        {
          this.val$service.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
          paramList1 = this.val$qqApp.getHandler(ChatActivity.class);
          if (paramList1 != null) {
            paramList1.obtainMessage(10).sendToTarget();
          }
        }
        this.val$service.a(this.val$reqbundle);
        return;
      }
      catch (Exception paramList1)
      {
        if (!QLog.isColorLevel()) {
          break label686;
        }
        QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
        return;
      }
      catch (JSONException paramList1) {}
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
      }
      return;
      n += 1;
      int k = j;
      int i = i1;
      continue;
      int j = 1;
      int i1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.12
 * JD-Core Version:    0.7.0.1
 */