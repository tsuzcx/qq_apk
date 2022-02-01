package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.GetFileListResult;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QfileFavFileRecordProvider$1
  extends IQQFavProxy.GetFileListResult
{
  QfileFavFileRecordProvider$1(QfileFavFileRecordProvider paramQfileFavFileRecordProvider) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!QfileFavFileRecordProvider.a(this.a))
    {
      QLog.d(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "<<<getMoreFileRecords is not getting");
      return;
    }
    QLog.i(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "<<<getMoreFileRecords result errCode:" + paramInt);
    QfileFavFileRecordProvider.a(this.a);
    if (paramInt != 0)
    {
      int i = 2131698175;
      if (paramInt == 65535) {
        i = 2131698176;
      }
      int j = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166);
      int k = (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(j - k);
      QfileFavFileRecordProvider.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(paramInt) } });
      return;
    }
    if (paramBundle != null)
    {
      QfileFavFileRecordProvider.a(this.a, paramBundle.getLong("resultTimestamp"));
      boolean bool = paramBundle.getBoolean("fecth_end");
      QfileFavFileRecordProvider.a(this.a, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        QfileFavFileRecordProvider.b(this.a, true);
      }
      QLog.i(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "getMoreFileRecords result: nextTimestamp:" + QfileFavFileRecordProvider.a(this.a) + " gettedListEnd:" + bool + " localEnd:" + QfileFavFileRecordProvider.b(this.a));
    }
    for (;;)
    {
      paramBundle = new QfileFavFileRecordProvider.FileRecordGroup(this.a);
      this.a.a(paramList, paramBundle);
      this.a.a(paramBundle);
      QfileFavFileRecordProvider.c(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(0) } });
      return;
      QLog.i(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "getMoreFileRecords result: lastTimestamp:" + QfileFavFileRecordProvider.a(this.a) + " exData=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.1
 * JD-Core Version:    0.7.0.1
 */