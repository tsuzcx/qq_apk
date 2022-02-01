package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.nativevue.NativeVueLogAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;

class NativeVueLoaderManager$NVLogAdapter
  implements NativeVueLogAdapter
{
  public void logD(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[NativeVue Debug]: ");
      localStringBuilder.append(paramString);
      QLog.d("NativeVueLoaderManager", 2, localStringBuilder.toString());
    }
  }
  
  public void logE(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[NativeVue Error]: ");
    localStringBuilder.append(paramString);
    QLog.e("NativeVueLoaderManager", 1, localStringBuilder.toString());
  }
  
  public void onNativeVueError(String paramString)
  {
    ViolaUtils.reportNVError(paramString, NativeVueLoaderManager.a().b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager.NVLogAdapter
 * JD-Core Version:    0.7.0.1
 */