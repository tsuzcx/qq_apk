package com.tencent.qqmini.miniapp.widget.media.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePlayerJSAdapter$InnerITXSnapshotListenerImpl
  implements InvocationHandler
{
  private boolean mNeedCompress = false;
  
  public TXLivePlayerJSAdapter$InnerITXSnapshotListenerImpl(TXLivePlayerJSAdapter paramTXLivePlayerJSAdapter) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("InnerITXSnapshotListenerImpl invoke:");
    paramObject.append(paramMethod.getName());
    QMLog.e("TXLivePlayerJSAdapter", paramObject.toString());
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
        if (this.mNeedCompress)
        {
          if (paramObject != null)
          {
            int i = paramObject.getWidth();
            int j = paramObject.getHeight();
            paramMethod = new Matrix();
            paramMethod.setScale(0.5F, 0.5F);
            paramMethod = Bitmap.createBitmap(paramObject, 0, 0, i, j, paramMethod, false);
            TXLivePlayerJSAdapter.access$200(this.this$0).onSnapshot(paramMethod);
            TXLivePlayerJSAdapter.access$300(this.this$0, paramObject);
            return null;
          }
          TXLivePlayerJSAdapter.access$200(this.this$0).onSnapshot(paramObject);
          return null;
        }
        TXLivePlayerJSAdapter.access$200(this.this$0).onSnapshot(paramObject);
      }
    }
    return null;
  }
  
  public void setNeedCompress(boolean paramBoolean)
  {
    this.mNeedCompress = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.InnerITXSnapshotListenerImpl
 * JD-Core Version:    0.7.0.1
 */