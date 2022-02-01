package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.GetRecommendWords.Classify;
import tencent.im.qqwallet.GetRecommendWords.ClassifyItem;
import tencent.im.qqwallet.GetRecommendWords.GetClassifyRsp;

final class GetRecommendWordUtils$2
  implements BusinessObserver
{
  GetRecommendWordUtils$2(long paramLong, SharedPreferences paramSharedPreferences, GetRecommendWordUtils.GetGroupWordsListener paramGetGroupWordsListener, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive:type:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",isSuccess:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",bundle:");
      ((StringBuilder)localObject1).append(paramBundle);
      ((StringBuilder)localObject1).append(",cost:");
      ((StringBuilder)localObject1).append(NetConnInfoCenter.getServerTimeMillis() - this.a);
      QLog.d("GetRandomRecommendWordUtils", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = paramBundle.getByteArray("data");
        if ((localObject1 != null) && (localObject1.length > 0) && (paramBoolean))
        {
          paramBundle = new GetRecommendWords.GetClassifyRsp();
          paramBundle.mergeFrom((byte[])localObject1);
          paramInt = paramBundle.code.get();
          localObject1 = paramBundle.message.get();
          i = paramBundle.ver.get();
          Object localObject2 = this.b.edit();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("sp_key_group_words_list");
          ((StringBuilder)localObject3).append(QWalletHelperImpl.getAppRuntime().getCurrentUin());
          ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), i).apply();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("retCode:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(",message:");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",ver:");
            ((StringBuilder)localObject2).append(i);
            QLog.d("GetRandomRecommendWordUtils", 2, ((StringBuilder)localObject2).toString());
          }
          if (paramInt == 0)
          {
            localObject1 = new ArrayList();
            paramBundle = paramBundle.classify.get();
            paramInt = 0;
            if (paramInt < paramBundle.size())
            {
              localObject2 = new GetRecommendWordUtils.RspGroupWordsListInfo();
              Object localObject4 = (GetRecommendWords.Classify)paramBundle.get(paramInt);
              localObject3 = ((GetRecommendWords.Classify)localObject4).items.get();
              if ((TextUtils.isEmpty(((GetRecommendWords.Classify)localObject4).name.get())) || (((List)localObject3).size() <= 0)) {
                break label567;
              }
              ((GetRecommendWordUtils.RspGroupWordsListInfo)localObject2).name = ((GetRecommendWords.Classify)localObject4).name.get();
              i = 0;
              if (i < ((List)localObject3).size())
              {
                localObject4 = ((GetRecommendWords.ClassifyItem)((List)localObject3).get(i)).item.get();
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label558;
                }
                ((GetRecommendWordUtils.RspGroupWordsListInfo)localObject2).wordList.add(localObject4);
                break label558;
              }
              ((List)localObject1).add(localObject2);
              break label567;
            }
            if (this.c != null) {
              this.c.a(true, this.d, (List)localObject1);
            }
            FileUtils.writeObject(GetRecommendWordUtils.a(), localObject1);
            return;
          }
          if (this.c != null)
          {
            this.c.a(false, 0, null);
            return;
          }
        }
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceive fail exception:");
        ((StringBuilder)localObject1).append(paramBundle.getMessage());
        QLog.e("GetRandomRecommendWordUtils", 1, ((StringBuilder)localObject1).toString());
      }
      return;
      label558:
      i += 1;
      continue;
      label567:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.2
 * JD-Core Version:    0.7.0.1
 */