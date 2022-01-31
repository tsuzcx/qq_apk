package com.tencent.mobileqq.mini.widget.media.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePlayerJSAdapter$InnerITXSnapshotListenerImpl
  implements InvocationHandler
{
  private boolean mNeedCompress;
  
  public TXLivePlayerJSAdapter$InnerITXSnapshotListenerImpl(TXLivePlayerJSAdapter paramTXLivePlayerJSAdapter) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QLog.e("TXLivePlayerJSAdapter", 1, "InnerITXSnapshotListenerImpl invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
        return null;
      }
    }
    if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1))
    {
      paramObject = (Bitmap)paramArrayOfObject[0];
      if (TXLivePlayerJSAdapter.access$200(this.this$0) != null)
      {
        if (!this.mNeedCompress) {
          break label182;
        }
        if (paramObject == null) {
          break label166;
        }
        int i = paramObject.getWidth();
        int j = paramObject.getHeight();
        paramMethod = new Matrix();
        paramMethod.setScale(0.5F, 0.5F);
        paramMethod = Bitmap.createBitmap(paramObject, 0, 0, i, j, paramMethod, false);
        TXLivePlayerJSAdapter.access$200(this.this$0).onSnapshot(paramMethod);
        TXLivePlayerJSAdapter.access$300(this.this$0, paramObject);
      }
    }
    for (;;)
    {
      return null;
      label166:
      TXLivePlayerJSAdapter.access$200(this.this$0).onSnapshot(paramObject);
      continue;
      label182:
      TXLivePlayerJSAdapter.access$200(this.this$0).onSnapshot(paramObject);
    }
  }
  
  public void setNeedCompress(boolean paramBoolean)
  {
    this.mNeedCompress = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.InnerITXSnapshotListenerImpl
 * JD-Core Version:    0.7.0.1
 */