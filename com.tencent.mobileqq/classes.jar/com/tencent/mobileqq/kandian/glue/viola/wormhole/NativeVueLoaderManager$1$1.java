package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class NativeVueLoaderManager$1$1
  implements OnLoadListener
{
  NativeVueLoaderManager$1$1(NativeVueLoaderManager.1 param1) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("preload NativeVue: ");
    paramLoadExtResult.append(paramInt);
    QLog.e("NativeVueLoaderManager", 1, paramLoadExtResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager.1.1
 * JD-Core Version:    0.7.0.1
 */