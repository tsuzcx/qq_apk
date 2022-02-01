package com.tencent.qapmsdk.bigbitmap.listener;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.uploaddata.FlushFile;
import com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.qapmsdk.common.reporter.IPluginReport;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.TimeUtil;
import java.io.File;
import java.util.List;

public class BitmapExceedListener
  implements IBitmapExceedListener
{
  private static final long MIN_FILE_SIZE = 0L;
  private String bigBitmapDirName;
  private String bigBitmapInfoFilePath;
  @Nullable
  private IPluginReport reporter = null;
  
  public BitmapExceedListener()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppInfo.obtainProcessPackageName(BaseInfo.app));
    ((StringBuilder)localObject).append("@10@BitmapOverDecode");
    this.bigBitmapDirName = ((StringBuilder)localObject).toString();
    localObject = FileUtil.getRootPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dumpfile/");
    localStringBuilder.append(this.bigBitmapDirName);
    localStringBuilder.append("/BitmapOverDecode.csv");
    this.bigBitmapInfoFilePath = new File((String)localObject, localStringBuilder.toString()).getAbsolutePath();
  }
  
  public void onBitmapExceed(List<ExceedBitmapInfo> paramList)
  {
    try
    {
      File localFile = new File(this.bigBitmapInfoFilePath);
      if (!localFile.exists()) {
        FileUtil.writeFile(this.bigBitmapInfoFilePath, "timestamp,activityName,bitmapWidth,bitmapHeight,viewWidth,viewHeight,viewChain,viewName,showType,allocatedByteSize,url\r\n", false);
      }
      FlushFile.INSTANCE.flush(this.bigBitmapInfoFilePath, paramList);
      if ((localFile.length() > 0L) && (PluginController.INSTANCE.canCollect(PluginCombination.bigBitmapPlugin.plugin)))
      {
        String str = localFile.getParentFile().getParent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(TimeUtil.getFormatDateMs());
        localStringBuilder.append("=");
        localStringBuilder.append(this.bigBitmapDirName);
        localStringBuilder.append("[");
        if (TextUtils.isEmpty(BaseInfo.userMeta.version)) {
          paramList = "None";
        } else {
          paramList = BaseInfo.userMeta.version;
        }
        localStringBuilder.append(paramList);
        localStringBuilder.append("].finish");
        paramList = new File(str, localStringBuilder.toString());
        if ((localFile.getParentFile().renameTo(paramList)) && (this.reporter != null)) {
          this.reporter.doReport(paramList.getAbsolutePath());
        }
      }
      return;
    }
    finally {}
  }
  
  public void setReporter(@Nullable IPluginReport paramIPluginReport)
  {
    try
    {
      this.reporter = paramIPluginReport;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.listener.BitmapExceedListener
 * JD-Core Version:    0.7.0.1
 */