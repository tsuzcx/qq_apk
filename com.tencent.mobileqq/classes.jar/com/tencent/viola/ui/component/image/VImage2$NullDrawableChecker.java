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
    if (localVImage2 == null) {}
    do
    {
      return;
      localObject = (ImageView)localVImage2.getHostView();
    } while ((localObject == null) || (((ImageView)localObject).getDrawable() != null));
    StringBuilder localStringBuilder = new StringBuilder().append("detect drawable is null, hashCode: ").append(localVImage2.hashCode()).append("url: ");
    if (VImage2.access$100(localVImage2) != null)
    {
      localObject = VImage2.access$100(localVImage2);
      ViolaLogUtils.e("VImage2", (String)localObject);
      if (TextUtils.isEmpty(VImage2.access$100(localVImage2))) {
        break label167;
      }
      VImage2.access$200(localVImage2, false, VImage2.access$100(localVImage2));
      localStringBuilder = new StringBuilder().append("check drawable is null restart. hashCode: ").append(localVImage2.hashCode()).append("url: ");
      if (VImage2.access$100(localVImage2) == null) {
        break label161;
      }
    }
    label161:
    for (Object localObject = VImage2.access$100(localVImage2);; localObject = "null")
    {
      ViolaLogUtils.e("VImage2", (String)localObject);
      return;
      localObject = "null";
      break;
    }
    label167:
    ViolaLogUtils.e("VImage2", "detect drawable is null, but imageUrl is null");
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2.NullDrawableChecker
 * JD-Core Version:    0.7.0.1
 */