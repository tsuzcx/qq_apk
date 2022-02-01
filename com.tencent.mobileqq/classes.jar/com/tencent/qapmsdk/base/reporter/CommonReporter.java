package com.tencent.qapmsdk.base.reporter;

import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.reporter.IPluginReport;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class CommonReporter
  implements IPluginReport
{
  @Nullable
  private Object extraData;
  private int plugin;
  
  public CommonReporter(int paramInt)
  {
    this.plugin = paramInt;
  }
  
  public boolean doReport(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      Object localObject = (String)paramObject;
      File localFile = new File((String)localObject);
      paramObject = localObject;
      if (localFile.exists())
      {
        paramObject = localObject;
        if (localFile.isDirectory())
        {
          paramObject = localFile.getParent();
          long l = System.currentTimeMillis();
          String str = "out_" + l + ".zip";
          paramObject = paramObject + "/" + str;
          FileUtil.zipFiles((String)localObject, paramObject, false);
          if (paramObject.length() == 0) {
            return false;
          }
          FileUtil.deleteAllFilesOfDir(localFile);
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("processname", AppInfo.obtainProcessName(BaseInfo.app));
      ((JSONObject)localObject).put("fileObj", paramObject);
      ((JSONObject)localObject).put("plugin", this.plugin);
      if (this.extraData != null) {
        ((JSONObject)localObject).put("extra_data", this.extraData);
      }
      paramObject = new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject, false, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj(paramObject);
      return true;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public void setExtraData(@Nullable Object paramObject)
  {
    this.extraData = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.CommonReporter
 * JD-Core Version:    0.7.0.1
 */