package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
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
    boolean bool = QfileFavFileRecordProvider.a(this.a);
    Integer localInteger = Integer.valueOf(1);
    if (!bool)
    {
      paramList = QfileFavFileRecordProvider.a;
      paramBundle = new StringBuilder();
      paramBundle.append(QfileFavFileRecordProvider.b);
      paramBundle.append("<<<getMoreFileRecords is not getting");
      QLog.d(paramList, 1, paramBundle.toString());
      return;
    }
    Object localObject = QfileFavFileRecordProvider.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileFavFileRecordProvider.b);
    localStringBuilder.append("<<<getMoreFileRecords result errCode:");
    localStringBuilder.append(paramInt);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    QfileFavFileRecordProvider.a(this.a);
    if (paramInt != 0)
    {
      int i = 2131698239;
      if (paramInt == 65535) {
        i = 2131698240;
      }
      int j = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168);
      int k = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
      QQToast.a(BaseApplication.getContext(), 0, i, 0).b(j - k);
      QfileFavFileRecordProvider.b(this.a);
      this.a.notifyObservers(new Object[] { localInteger, { Integer.valueOf(paramInt) } });
      return;
    }
    if (paramBundle != null)
    {
      QfileFavFileRecordProvider.a(this.a, paramBundle.getLong("resultTimestamp"));
      bool = paramBundle.getBoolean("fecth_end");
      QfileFavFileRecordProvider.a(this.a, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        QfileFavFileRecordProvider.b(this.a, true);
      }
      paramBundle = QfileFavFileRecordProvider.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QfileFavFileRecordProvider.b);
      ((StringBuilder)localObject).append("getMoreFileRecords result: nextTimestamp:");
      ((StringBuilder)localObject).append(QfileFavFileRecordProvider.a(this.a));
      ((StringBuilder)localObject).append(" gettedListEnd:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" localEnd:");
      ((StringBuilder)localObject).append(QfileFavFileRecordProvider.b(this.a));
      QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      paramBundle = QfileFavFileRecordProvider.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QfileFavFileRecordProvider.b);
      ((StringBuilder)localObject).append("getMoreFileRecords result: lastTimestamp:");
      ((StringBuilder)localObject).append(QfileFavFileRecordProvider.a(this.a));
      ((StringBuilder)localObject).append(" exData=null");
      QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    }
    paramBundle = new QfileFavFileRecordProvider.FileRecordGroup();
    this.a.a(paramList, paramBundle);
    this.a.a(paramBundle);
    QfileFavFileRecordProvider.c(this.a);
    this.a.notifyObservers(new Object[] { localInteger, { Integer.valueOf(0) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.1
 * JD-Core Version:    0.7.0.1
 */