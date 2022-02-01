package com.tencent.viola.ui.component.image;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;

class VImage2$NullDrawableChecker
  extends Handler
{
  public static final int DELAY_TIME = 3500;
  public static final int MSG_CHECK_DRAWABLE = 1;
  private WeakReference<VImage2> mWeakRef;
  
  public VImage2$NullDrawableChecker(VImage2 paramVImage2)
  {
    this.mWeakRef = new WeakReference(paramVImage2);
  }
  
  private void checkDrawable()
  {
    VImage2 localVImage2 = (VImage2)this.mWeakRef.get();
    if (localVImage2 == null) {
      return;
    }
    Object localObject = (ImageView)localVImage2.getHostView();
    if (localObject == null) {
      return;
    }
    if (((ImageView)localObject).getDrawable() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detect drawable is null, hashCode: ");
      localStringBuilder.append(localVImage2.hashCode());
      localStringBuilder.append("url: ");
      localObject = VImage2.access$200(localVImage2);
      String str = "null";
      if (localObject != null) {
        localObject = VImage2.access$200(localVImage2);
      } else {
        localObject = "null";
      }
      localStringBuilder.append((String)localObject);
      ViolaLogUtils.e("VImage2", localStringBuilder.toString());
      if (!TextUtils.isEmpty(VImage2.access$200(localVImage2)))
      {
        VImage2.access$300(localVImage2, false, VImage2.access$200(localVImage2));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("check drawable is null restart. hashCode: ");
        localStringBuilder.append(localVImage2.hashCode());
        localStringBuilder.append("url: ");
        localObject = str;
        if (VImage2.access$200(localVImage2) != null) {
          localObject = VImage2.access$200(localVImage2);
        }
        localStringBuilder.append((String)localObject);
        ViolaLogUtils.e("VImage2", localStringBuilder.toString());
        return;
      }
      ViolaLogUtils.e("VImage2", "detect drawable is null, but imageUrl is null");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    checkDrawable();
  }
  
  public void removeCheckMsg()
  {
    removeMessages(1);
  }
  
  public void sendCheckMsg()
  {
    if (!hasMessages(1))
    {
      sendEmptyMessageDelayed(1, 3500L);
      ViolaLogUtils.d("VImage2", "send check drawable msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2.NullDrawableChecker
 * JD-Core Version:    0.7.0.1
 */