package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class PTSSoLoader$2
  implements OnLoadListener
{
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("[onLoadResult], preload resCode = ");
    paramLoadExtResult.append(paramInt);
    QLog.i("PTSSoLoader", 1, paramLoadExtResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader.2
 * JD-Core Version:    0.7.0.1
 */