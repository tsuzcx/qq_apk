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
      Object localObject1 = (String)paramObject;
      File localFile = new File((String)localObject1);
      paramObject = localObject1;
      if (localFile.exists())
      {
        paramObject = localObject1;
        if (localFile.isDirectory())
        {
          paramObject = localFile.getParent();
          long l = System.currentTimeMillis();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("out_");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(".zip");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramObject);
          localStringBuilder.append("/");
          localStringBuilder.append((String)localObject2);
          paramObject = localStringBuilder.toString();
          FileUtil.zipFiles((String)localObject1, paramObject, false);
          if (paramObject.length() == 0) {
            return false;
          }
          FileUtil.deleteAllFilesOfDir(localFile);
        }
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("processname", AppInfo.obtainProcessName(BaseInfo.app));
      ((JSONObject)localObject1).put("fileObj", paramObject);
      ((JSONObject)localObject1).put("plugin", this.plugin);
      if (this.extraData != null) {
        ((JSONObject)localObject1).put("extra_data", this.extraData);
      }
      paramObject = new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, false, true, BaseInfo.userMeta.uin);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.CommonReporter
 * JD-Core Version:    0.7.0.1
 */