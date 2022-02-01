package com.tencent.rmonitor.bigbitmap.listener;

import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.data.FlushFile;
import com.tencent.rmonitor.bigbitmap.BigBitmapReporter;
import com.tencent.rmonitor.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.TimeUtil;
import java.io.File;
import java.util.List;

public class BitmapExceedListener
  implements IBitmapExceedListener
{
  private final String a;
  private final String b;
  private final BigBitmapReporter c = new BigBitmapReporter();
  
  public BitmapExceedListener()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppInfo.b(BaseInfo.app));
    ((StringBuilder)localObject).append("@10@BitmapOverDecode");
    this.a = ((StringBuilder)localObject).toString();
    localObject = FileUtil.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dumpfile/");
    localStringBuilder.append(this.a);
    localStringBuilder.append("/BitmapOverDecode.csv");
    this.b = new File((String)localObject, localStringBuilder.toString()).getAbsolutePath();
  }
  
  public void a(List<ExceedBitmapInfo> paramList)
  {
    try
    {
      File localFile = new File(this.b);
      if (!localFile.exists()) {
        FileUtil.a(this.b, "timestamp,activityName,bitmapWidth,bitmapHeight,viewWidth,viewHeight,viewChain,viewName,showType,allocatedByteSize,url\r\n", false);
      }
      FlushFile.a.a(this.b, paramList);
      if ((localFile.length() > 0L) && (PluginController.b.b(152)))
      {
        String str = localFile.getParentFile().getParent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(TimeUtil.a());
        localStringBuilder.append("=");
        localStringBuilder.append(this.a);
        localStringBuilder.append("[");
        if (TextUtils.isEmpty(BaseInfo.userMeta.version)) {
          paramList = "None";
        } else {
          paramList = BaseInfo.userMeta.version;
        }
        localStringBuilder.append(paramList);
        localStringBuilder.append("].finish");
        paramList = new File(str, localStringBuilder.toString());
        if (localFile.getParentFile().renameTo(paramList)) {
          this.c.a(paramList.getAbsolutePath());
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.listener.BitmapExceedListener
 * JD-Core Version:    0.7.0.1
 */