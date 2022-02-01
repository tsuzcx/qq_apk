package com.tencent.mobileqq.richstatus;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class SignatureHistoryFragment$4
  implements Runnable
{
  SignatureHistoryFragment$4(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get ower head is called,time is:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("Q.msg.delmsg", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Bitmap localBitmap = null;
    if (this.this$0.getBaseActivity() == null) {
      return;
    }
    QQAppInterface localQQAppInterface = this.this$0.getBaseActivity().app;
    if (localQQAppInterface == null) {
      return;
    }
    int i = this.this$0.getResources().getDimensionPixelSize(2131297229);
    if (localQQAppInterface.getCurrentAccountUin().equals(SignatureHistoryFragment.a(this.this$0)))
    {
      localObject2 = localBitmap;
      try
      {
        localObject1 = FaceUtil.b();
        localObject2 = localBitmap;
        Object localObject3 = new File((String)localObject1);
        localObject2 = localBitmap;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localObject2 = localBitmap;
        localObject3 = new FileInputStream((File)localObject3);
        localObject2 = localBitmap;
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject3, i, i));
        localObject2 = localBitmap;
        ((InputStream)localObject3).close();
        localObject2 = localBitmap;
        localBitmap = BitmapManager.a((String)localObject1, localOptions);
        localObject1 = localBitmap;
        if (localBitmap != null)
        {
          localObject2 = localBitmap;
          localObject1 = QQAppInterface.getCircleFaceBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        }
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("SignatureHistoryFragment", 2, localException.toString());
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localQQAppInterface.getFaceBitmap(SignatureHistoryFragment.a(this.this$0), true);
    }
    if (localObject2 != null)
    {
      localObject1 = SignatureHistoryFragment.a(this.this$0).obtainMessage(2);
      ((Message)localObject1).obj = localObject2;
      SignatureHistoryFragment.a(this.this$0).sendMessage((Message)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.4
 * JD-Core Version:    0.7.0.1
 */