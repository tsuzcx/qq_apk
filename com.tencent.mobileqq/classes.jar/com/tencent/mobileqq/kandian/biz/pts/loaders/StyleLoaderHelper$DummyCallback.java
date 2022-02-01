package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils.ConfigData;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class StyleLoaderHelper$DummyCallback
  implements AsyncBack
{
  private final String b;
  private final String c;
  
  public StyleLoaderHelper$DummyCallback(StyleLoaderHelper paramStyleLoaderHelper, String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loaded: bid : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" param ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" code : ");
    localStringBuilder.append(paramInt);
    QLog.d("TemplateFactory", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      if (paramString == null) {}
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("下载离线样式包完成 : ");
        localStringBuilder.append(this.b);
        QLog.d("TemplateFactory", 2, localStringBuilder.toString());
        OfflineUtils.c(StyleLoaderHelper.a(this.a));
        if ((paramString == null) && (OfflineUtils.b(this.b).a))
        {
          paramString = new StringBuilder();
          paramString.append("加载离线包 : ");
          paramString.append(this.b);
          QLog.d("TemplateFactory", 1, paramString.toString());
          ProteusReportUtil.a(2, StyleLoaderHelper.a(this.a));
          this.a.b(this.b);
          RIJSPUtils.a("kandian_pts_style_update", Boolean.valueOf(true));
          StyleConfigHelper.a().c();
          return;
        }
      }
      catch (Exception paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loaded: bid : ");
        localStringBuilder.append(this.b);
        QLog.e("TemplateFactory", 1, localStringBuilder.toString(), paramString);
      }
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new StyleLoaderHelper.DummyCallback.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.StyleLoaderHelper.DummyCallback
 * JD-Core Version:    0.7.0.1
 */