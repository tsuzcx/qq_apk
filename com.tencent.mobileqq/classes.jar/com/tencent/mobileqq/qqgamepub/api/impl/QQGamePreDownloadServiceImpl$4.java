package com.tencent.mobileqq.qqgamepub.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class QQGamePreDownloadServiceImpl$4
  implements Runnable
{
  QQGamePreDownloadServiceImpl$4(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl, List paramList) {}
  
  public void run()
  {
    try
    {
      if ((this.a != null) && (this.a.size() > 0))
      {
        Iterator localIterator1 = this.a.iterator();
        while (localIterator1.hasNext())
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)localIterator1.next();
          String str1 = localQQGameMsgInfo.arkAppName;
          String str2 = localQQGameMsgInfo.arkMetaList;
          Object localObject2;
          Object localObject1;
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            localObject2 = new JSONObject(str2);
            Iterator localIterator2 = ((JSONObject)localObject2).keys();
            localObject1 = "";
            if (localIterator2.hasNext()) {
              localObject1 = (String)localIterator2.next();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              QQGamePreDownloadServiceImpl.access$200(this.this$0, str1, (JSONObject)localObject2, (String)localObject1);
            }
          }
          else if (!TextUtils.isEmpty(localQQGameMsgInfo.url))
          {
            localObject1 = new HashSet();
            localObject2 = this.this$0.getActivityId(localQQGameMsgInfo.url);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((Set)localObject1).add(localObject2);
            }
            this.this$0.checkAndDownloadDSL((Set)localObject1);
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("preDownloadPubPushArkRes...arkAppName:");
            ((StringBuilder)localObject1).append(str1);
            ((StringBuilder)localObject1).append(",arkMetaList:");
            ((StringBuilder)localObject1).append(str2);
            ((StringBuilder)localObject1).append(",curNetType:");
            ((StringBuilder)localObject1).append(NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ));
            ((StringBuilder)localObject1).append(",url");
            ((StringBuilder)localObject1).append(localQQGameMsgInfo.url);
            QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */