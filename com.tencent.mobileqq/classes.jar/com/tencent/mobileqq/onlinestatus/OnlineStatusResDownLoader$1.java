package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class OnlineStatusResDownLoader$1
  implements Runnable
{
  OnlineStatusResDownLoader$1(OnlineStatusResDownLoader paramOnlineStatusResDownLoader, ArrayList paramArrayList, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      if ((!TextUtils.isEmpty(localOnlineStatusItem.k)) && (!TextUtils.isEmpty(localOnlineStatusItem.l)))
      {
        String[] arrayOfString = OnlineStatusResDownLoader.a(localOnlineStatusItem.b);
        OnlineStatusResDownLoader.a(this.this$0);
        if (ZipResourcesDownloader.a(localOnlineStatusItem.k, localOnlineStatusItem.l, arrayOfString))
        {
          QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes itemRes is ready item.id=", Long.valueOf(localOnlineStatusItem.b) });
        }
        else
        {
          QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes itemRes need download item.id=", Long.valueOf(localOnlineStatusItem.b) });
          OnlineStatusResDownLoader.a(this.this$0).a(this.b, 10096, "prd", localOnlineStatusItem.k, localOnlineStatusItem.l, arrayOfString, null);
        }
      }
      else
      {
        QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes paramError item.id=", Long.valueOf(localOnlineStatusItem.b), " item.resUrl=", localOnlineStatusItem.k, " item.md5=", localOnlineStatusItem.l });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusResDownLoader.1
 * JD-Core Version:    0.7.0.1
 */