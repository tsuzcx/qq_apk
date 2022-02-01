package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class PTSSoLoader$1
  implements OnLoadListener
{
  PTSSoLoader$1(PTSSoLoader paramPTSSoLoader, String paramString) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("[onLoadResult], resCode = ");
    paramLoadExtResult.append(paramInt);
    QLog.i("PTSSoLoader", 1, paramLoadExtResult.toString());
    if (paramInt == 0)
    {
      paramLoadExtResult = SoLoadManager.getInstance().getInitVer(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadResult], load so succeeded, name = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", currentVersion = ");
      localStringBuilder.append(paramLoadExtResult);
      QLog.i("PTSSoLoader", 1, localStringBuilder.toString());
      if (PTSSoLoader.a(this.b, paramLoadExtResult, "1.1.4")) {
        PTSSoLoader.a(this.b, true);
      }
    }
    PTSSoLoader.a(this.b, this.a, paramInt, SoLoadManager.getInstance().getInitVer(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader.1
 * JD-Core Version:    0.7.0.1
 */