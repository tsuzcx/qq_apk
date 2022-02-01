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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      if ((!TextUtils.isEmpty(localOnlineStatusItem.f)) && (!TextUtils.isEmpty(localOnlineStatusItem.g)))
      {
        String[] arrayOfString = OnlineStatusResDownLoader.a(localOnlineStatusItem.a);
        OnlineStatusResDownLoader.a(this.this$0);
        if (ZipResourcesDownloader.a(localOnlineStatusItem.f, localOnlineStatusItem.g, arrayOfString))
        {
          QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes itemRes is ready item.id=", Long.valueOf(localOnlineStatusItem.a) });
        }
        else
        {
          QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes itemRes need download item.id=", Long.valueOf(localOnlineStatusItem.a) });
          OnlineStatusResDownLoader.a(this.this$0).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 10096, "prd", localOnlineStatusItem.f, localOnlineStatusItem.g, arrayOfString, null);
        }
      }
      else
      {
        QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes paramError item.id=", Long.valueOf(localOnlineStatusItem.a), " item.resUrl=", localOnlineStatusItem.f, " item.md5=", localOnlineStatusItem.g });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusResDownLoader.1
 * JD-Core Version:    0.7.0.1
 */