package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.ZipResourcesDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class OnlineStatusResDownLoader$1
  implements Runnable
{
  OnlineStatusResDownLoader$1(OnlineStatusResDownLoader paramOnlineStatusResDownLoader, ArrayList paramArrayList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      if ((TextUtils.isEmpty(localOnlineStatusItem.e)) || (TextUtils.isEmpty(localOnlineStatusItem.f)))
      {
        QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes paramError item.id=", Long.valueOf(localOnlineStatusItem.a), " item.resUrl=", localOnlineStatusItem.e, " item.md5=", localOnlineStatusItem.f });
      }
      else
      {
        String[] arrayOfString = OnlineStatusResDownLoader.a(localOnlineStatusItem.a);
        if (ZipResourcesDownloader.a(localOnlineStatusItem.e, localOnlineStatusItem.f, arrayOfString))
        {
          QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes itemRes is ready item.id=", Long.valueOf(localOnlineStatusItem.a) });
        }
        else
        {
          QLog.d("OnlineStatusResDownLoader", 2, new Object[] { "[OnlineStatus] downloadRes itemRes need download item.id=", Long.valueOf(localOnlineStatusItem.a) });
          OnlineStatusResDownLoader.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10096, "prd", localOnlineStatusItem.e, localOnlineStatusItem.f, arrayOfString, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusResDownLoader.1
 * JD-Core Version:    0.7.0.1
 */