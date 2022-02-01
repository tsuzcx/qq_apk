package com.tencent.mobileqq.widget.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ShareActionSheetV2$MyResultReceiver
  extends ResultReceiver
{
  private WeakReference<ShareActionSheetV2> a;
  
  public ShareActionSheetV2$MyResultReceiver(ShareActionSheetV2 paramShareActionSheetV2)
  {
    super(new Handler(Looper.getMainLooper()));
    this.a = new WeakReference(paramShareActionSheetV2);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceiveResult() called with: resultCode = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], resultData = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("] #this = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ShareActionSheetV2)this.a.get();
    if ((localObject != null) && (paramBundle != null))
    {
      paramBundle.setClassLoader(ShareActionSheetV2.class.getClassLoader());
      if (paramBundle.getInt("key_req") == 2)
      {
        if (paramInt == -1)
        {
          paramBundle = paramBundle.getParcelableArrayList("result_set");
          if (paramBundle != null)
          {
            Iterator localIterator = paramBundle.iterator();
            while (localIterator.hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)localIterator.next();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("onReceiveResult() called with: record = [");
                localStringBuilder.append(localResultRecord);
                QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
              }
            }
          }
          ShareActionSheetV2.a((ShareActionSheetV2)localObject, paramBundle);
          ShareActionSheetV2.a((ShareActionSheetV2)localObject, null);
          return;
        }
        if (paramInt == 100) {
          ShareActionSheetV2.a((ShareActionSheetV2)localObject, (ResultReceiver)paramBundle.getParcelable("receiver"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */