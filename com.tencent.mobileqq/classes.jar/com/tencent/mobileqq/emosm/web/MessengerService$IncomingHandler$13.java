package com.tencent.mobileqq.emosm.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
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

class MessengerService$IncomingHandler$13
  extends IPicDownloadListener
{
  MessengerService$IncomingHandler$13(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, QQAppInterface paramQQAppInterface, MessengerService paramMessengerService) {}
  
  public void onDone(List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2)
  {
    int i;
    int m;
    int j;
    int n;
    if (paramList2 != null) {
      for (;;)
      {
        try
        {
          if (paramList2.isEmpty()) {
            continue;
          }
          k = paramList2.size();
          i = 0;
          if ((paramList1 == null) || (paramList1.isEmpty())) {
            continue;
          }
          i = paramList1.size();
          this.val$reqbundle.putInt("result", 2);
          paramList2 = new JSONObject();
          paramList2.put("succeedNum", i);
          paramList2.put("failedNum", k);
          this.val$reqbundle.putString("data", paramList2.toString());
        }
        catch (JSONException paramList1)
        {
          int i2;
          HashSet localHashSet;
          int i1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
          return;
          this.val$reqbundle.putInt("result", 0);
          int k = 0;
          continue;
          n = paramList1.size();
          Object localObject = new ArrayList();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if (n + j <= i2) {
            break label696;
          }
          m = 1;
          paramList1 = paramList1.iterator();
          if (!paramList1.hasNext()) {
            continue;
          }
          localCustomEmotionData = (CustomEmotionData)paramList1.next();
          if (m == 0) {
            continue;
          }
          ((ArrayList)localObject).add(localCustomEmotionData.eId);
          localArrayList1.add(localCustomEmotionData.url);
          if (localCustomEmotionData.md5 != null) {
            continue;
          }
          localArrayList2.add("");
          break label693;
          localArrayList2.add(localCustomEmotionData.md5);
          break label693;
          i += 1;
          localCustomEmotionData.emoId = i;
          if ((TextUtils.isEmpty(localCustomEmotionData.md5)) || (localHashSet.contains(localCustomEmotionData.md5))) {
            break label702;
          }
          paramList2.c(localCustomEmotionData);
          break label702;
          if (m == 0) {
            break label611;
          }
          this.val$reqbundle.putInt("extra_key_over_num", n + j - i2);
          this.val$reqbundle.putBoolean("openManagerActivity", true);
          this.val$reqbundle.putStringArrayList("extra_key_paths", localArrayList1);
          this.val$reqbundle.putStringArrayList("extra_key_pkgids", (ArrayList)localObject);
          this.val$reqbundle.putStringArrayList("extra_key_md5s", localArrayList2);
          this.val$reqbundle.putInt("extra_key_faile_count", k);
          this.val$service.a(this.val$reqbundle);
          return;
        }
        catch (Exception paramList1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
          return;
        }
        if ((paramList1 == null) || (paramList1.isEmpty())) {
          continue;
        }
        paramList2 = (FavroamingDBManager)this.val$qqApp.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
        localObject = paramList2.a();
        i2 = FavEmoConstant.a;
        i = 0;
        localHashSet = new HashSet();
        if (localObject == null) {
          break label656;
        }
        m = 0;
        j = 1;
        if (m >= ((List)localObject).size()) {
          break label680;
        }
        i1 = ((CustomEmotionData)((List)localObject).get(m)).emoId;
        n = j;
        if (j < i1) {
          n = i1;
        }
        j = i;
        if ("needDel".equals(((CustomEmotionData)((List)localObject).get(m)).RomaingType)) {
          break label664;
        }
        i += 1;
        j = i;
        if (TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(m)).md5)) {
          break label664;
        }
        localHashSet.add(((CustomEmotionData)((List)localObject).get(m)).md5);
        j = i;
        break label664;
        this.val$reqbundle.putInt("result", 1);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      label380:
      CustomEmotionData localCustomEmotionData;
      label611:
      this.val$service.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
      paramList1 = this.val$qqApp.getHandler(ChatActivity.class);
      if (paramList1 != null)
      {
        paramList1.obtainMessage(10).sendToTarget();
        continue;
        label656:
        j = 0;
        i = 1;
        continue;
        label664:
        m += 1;
        i = j;
        j = n;
        break;
        label680:
        m = i;
        i = j;
        j = m;
      }
    }
    label693:
    label696:
    label702:
    for (;;)
    {
      break label380;
      m = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.13
 * JD-Core Version:    0.7.0.1
 */