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
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QrImageScan.FileDecodeListener jdField_a_of_type_ComTencentMobileqqQrscanQrImageScan$FileDecodeListener;
  private String jdField_a_of_type_JavaLangString = "QR_CODE";
  private Handler b;
  
  public QrImageScan(Context paramContext, QrImageScan.FileDecodeListener paramFileDecodeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqQrscanQrImageScan$FileDecodeListener = paramFileDecodeListener;
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(paramContext, hashCode(), "QrImageScan");
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "QrImageScan");
      this.jdField_a_of_type_ComTencentMobileqqQrscanQrImageScan$FileDecodeListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramString);
    paramString = Uri.parse(localStringBuilder.toString());
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null)
        {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
          this.b = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper(), this);
        }
      }
      finally {}
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramInt, 0, paramString).sendToTarget();
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
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqQrscanQrImageScan$FileDecodeListener;
        if (paramMessage != null)
        {
          paramMessage.a(i);
          return true;
        }
      }
      else
      {
        i = paramMessage.arg1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanQrImageScan$FileDecodeListener;
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
      paramMessage = ScannerUtils.a((Uri)paramMessage.obj, this.jdField_a_of_type_AndroidContentContext, i);
      if ((paramMessage != null) && (paramMessage.b()))
      {
        localObject = this.b;
        if (localObject != null)
        {
          ((Handler)localObject).obtainMessage(2, i, 0, paramMessage).sendToTarget();
          return true;
        }
      }
      else
      {
        paramMessage = this.b;
        if (paramMessage != null) {
          paramMessage.obtainMessage(3, i, 0).sendToTarget();
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QrImageScan
 * JD-Core Version:    0.7.0.1
 */