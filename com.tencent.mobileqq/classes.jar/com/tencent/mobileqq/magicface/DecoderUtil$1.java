package com.tencent.mobileqq.magicface;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class DecoderUtil$1
  implements OnLoadListener
{
  DecoderUtil$1(DecoderUtil paramDecoderUtil, CountDownLatch paramCountDownLatch) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramLoadExtResult != null) {}
    try
    {
      if (!paramLoadExtResult.isSucc())
      {
        QLog.w("DecoderUtil", 2, "load error");
        return;
      }
      paramLoadExtResult = paramLoadExtResult.getSoLoadPath("TcVpxDec_old");
      if (!TextUtils.isEmpty(paramLoadExtResult)) {
        DecoderUtil.access$002(paramLoadExtResult);
      }
      return;
    }
    catch (Exception paramLoadExtResult)
    {
      QLog.e("DecoderUtil", 1, paramLoadExtResult, new Object[0]);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.DecoderUtil.1
 * JD-Core Version:    0.7.0.1
 */