package com.tencent.mobileqq.qrscan;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.utils.ScannerUtils;

public class QrImageScan
  implements Handler.Callback
{
  private Context a;
  private Handler b;
  private Handler c;
  private String d = "QR_CODE";
  private QrImageScan.FileDecodeListener e;
  
  public QrImageScan(Context paramContext, QrImageScan.FileDecodeListener paramFileDecodeListener)
  {
    this.a = paramContext;
    this.e = paramFileDecodeListener;
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(paramContext, hashCode(), "QrImageScan");
  }
  
  public void a()
  {
    try
    {
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.removeCallbacksAndMessages(null);
        this.c = null;
      }
      ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "QrImageScan");
      this.e = null;
      this.a = null;
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramString);
    paramString = Uri.parse(localStringBuilder.toString());
    if (this.b == null) {
      try
      {
        if (this.b == null)
        {
          this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
          this.c = new Handler(this.a.getMainLooper(), this);
        }
      }
      finally {}
    }
    this.b.obtainMessage(1, paramInt, 0, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        i = paramMessage.arg1;
        paramMessage = this.e;
        if (paramMessage != null)
        {
          paramMessage.a(i);
          return true;
        }
      }
      else
      {
        i = paramMessage.arg1;
        localObject = this.e;
        if (localObject != null)
        {
          ((QrImageScan.FileDecodeListener)localObject).a((ScannerResult)paramMessage.obj, i);
          return true;
        }
      }
    }
    else
    {
      i = paramMessage.arg1;
      paramMessage = ScannerUtils.a((Uri)paramMessage.obj, this.a, i);
      if ((paramMessage != null) && (paramMessage.f()))
      {
        localObject = this.c;
        if (localObject != null)
        {
          ((Handler)localObject).obtainMessage(2, i, 0, paramMessage).sendToTarget();
          return true;
        }
      }
      else
      {
        paramMessage = this.c;
        if (paramMessage != null) {
          paramMessage.obtainMessage(3, i, 0).sendToTarget();
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QrImageScan
 * JD-Core Version:    0.7.0.1
 */