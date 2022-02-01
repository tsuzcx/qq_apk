package com.tencent.mobileqq.widget.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ShareActionSheetV2$MyResultReceiver
  extends ResultReceiver
{
  private WeakReference<ShareActionSheetV2> mRef;
  
  public ShareActionSheetV2$MyResultReceiver(ShareActionSheetV2 paramShareActionSheetV2)
  {
    super(new Handler(Looper.getMainLooper()));
    this.mRef = new WeakReference(paramShareActionSheetV2);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    ShareActionSheetV2 localShareActionSheetV2 = (ShareActionSheetV2)this.mRef.get();
    if ((localShareActionSheetV2 != null) && (paramBundle != null))
    {
      paramBundle.setClassLoader(ShareActionSheetV2.class.getClassLoader());
      if (paramBundle.getInt("key_req") == ForwardRecentActivity.g)
      {
        if (paramInt != -1) {
          break label192;
        }
        paramBundle = paramBundle.getParcelableArrayList("result_set");
        if (paramBundle != null)
        {
          localIterator = paramBundle.iterator();
          while (localIterator.hasNext())
          {
            localResultRecord = (ResultRecord)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("ShareActionSheetV2", 2, "onReceiveResult() called with: record = [" + localResultRecord);
            }
          }
        }
        ShareActionSheetV2.access$1600(localShareActionSheetV2, paramBundle);
        ShareActionSheetV2.access$1702(localShareActionSheetV2, null);
      }
    }
    label192:
    while (paramInt != 100)
    {
      Iterator localIterator;
      ResultRecord localResultRecord;
      return;
    }
    ShareActionSheetV2.access$1702(localShareActionSheetV2, (ResultReceiver)paramBundle.getParcelable("receiver"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */