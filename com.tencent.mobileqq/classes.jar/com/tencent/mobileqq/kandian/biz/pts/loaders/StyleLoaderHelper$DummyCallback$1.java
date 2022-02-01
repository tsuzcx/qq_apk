package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.kandian.biz.pts.util.ProteusCDNUtils;
import com.tencent.qphone.base.util.QLog;

class StyleLoaderHelper$DummyCallback$1
  implements Runnable
{
  StyleLoaderHelper$DummyCallback$1(StyleLoaderHelper.DummyCallback paramDummyCallback, String paramString, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check style config param: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" code: ");
    localStringBuilder.append(this.b);
    QLog.d("TemplateFactory", 1, localStringBuilder.toString());
    int i = this.b;
    if (i == 0) {
      this.c.a(this.a, i);
    }
    ProteusCDNUtils.a(StyleLoaderHelper.DummyCallback.a(this.c), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.StyleLoaderHelper.DummyCallback.1
 * JD-Core Version:    0.7.0.1
 */