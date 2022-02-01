package org.light.device;

import android.content.Context;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import org.light.utils.FileUtils;
import org.light.utils.LightLogUtil;

public class GpuScopeAttrs
{
  private static final String[] GPU_NAMES = { "Mali-T860", "Mali-T720" };
  private static final GpuScopeAttrs INSTANCE = new GpuScopeAttrs();
  private static final String TAG = "GpuScopeAttrs";
  private GpuScopeAttrs.GpuBean.DeviceModel thisDeviceModel;
  private GpuScopeAttrs.GpuBean.GpuModel thisGpuModel;
  private GpuScopeAttrs.GpuBean.SysVersionModel thisSysVersionModel;
  
  public static GpuScopeAttrs getInstance()
  {
    return INSTANCE;
  }
  
  public GpuScopeAttrs.GpuBean.DeviceModel getDeviceModel()
  {
    return this.thisDeviceModel;
  }
  
  public GpuScopeAttrs.GpuBean.GpuModel getGPuModel()
  {
    return this.thisGpuModel;
  }
  
  public GpuScopeAttrs.GpuBean.SysVersionModel getSysVersionModel()
  {
    return this.thisSysVersionModel;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(paramString4));
    ((StringBuilder)localObject).append("device_config.json");
    localObject = ((StringBuilder)localObject).toString();
    paramString4 = (String)localObject;
    if (!FileUtils.isFileExist((String)localObject)) {
      paramString4 = "assets://device_config.json";
    }
    paramContext = FileUtils.load(paramContext, paramString4);
    try
    {
      paramContext = (GpuScopeAttrs.GpuBean)new Gson().fromJson(paramContext, GpuScopeAttrs.GpuBean.class);
    }
    catch (Throwable paramContext)
    {
      LightLogUtil.e("GpuScopeAttrs", paramContext.toString());
      paramContext = null;
    }
    if (paramContext != null)
    {
      this.thisGpuModel = null;
      if (paramContext.gpuModels != null)
      {
        paramString4 = paramContext.gpuModels.iterator();
        while (paramString4.hasNext())
        {
          localObject = (GpuScopeAttrs.GpuBean.GpuModel)paramString4.next();
          if ((paramString2 != null) && (((GpuScopeAttrs.GpuBean.GpuModel)localObject).gpu != null) && (paramString2.contains(((GpuScopeAttrs.GpuBean.GpuModel)localObject).gpu))) {
            this.thisGpuModel = ((GpuScopeAttrs.GpuBean.GpuModel)localObject);
          }
        }
      }
      this.thisDeviceModel = null;
      if (paramContext.deviceModels != null)
      {
        localObject = paramContext.deviceModels.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramString4 = (GpuScopeAttrs.GpuBean.DeviceModel)((Iterator)localObject).next();
          if (paramString1.contains(paramString4.device))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append("->>deviceModels:");
            ((StringBuilder)localObject).append(paramString4.device);
            ((StringBuilder)localObject).append(",shareGLContextError:");
            ((StringBuilder)localObject).append(paramString4.shareGLContextError);
            LightLogUtil.i("GpuScopeAttrs", ((StringBuilder)localObject).toString());
            this.thisDeviceModel = paramString4;
          }
        }
      }
      this.thisSysVersionModel = null;
      if (paramContext.sysVersionModels != null)
      {
        paramContext = paramContext.sysVersionModels.iterator();
        while (paramContext.hasNext())
        {
          paramString1 = (GpuScopeAttrs.GpuBean.SysVersionModel)paramContext.next();
          if ((paramString2 != null) && (paramString1.version != null) && (paramString3.contains(paramString1.version))) {
            this.thisSysVersionModel = paramString1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.GpuScopeAttrs
 * JD-Core Version:    0.7.0.1
 */