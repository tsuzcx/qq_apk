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
  
  public void init(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(paramString3));
    ((StringBuilder)localObject).append("device_config.json");
    localObject = ((StringBuilder)localObject).toString();
    paramString3 = (String)localObject;
    if (!FileUtils.isFileExist((String)localObject)) {
      paramString3 = "assets://device_config.json";
    }
    paramContext = FileUtils.load(paramContext, paramString3);
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
        paramString3 = paramContext.gpuModels.iterator();
        while (paramString3.hasNext())
        {
          localObject = (GpuScopeAttrs.GpuBean.GpuModel)paramString3.next();
          if ((paramString2 != null) && (((GpuScopeAttrs.GpuBean.GpuModel)localObject).gpu != null) && (paramString2.contains(((GpuScopeAttrs.GpuBean.GpuModel)localObject).gpu))) {
            this.thisGpuModel = ((GpuScopeAttrs.GpuBean.GpuModel)localObject);
          }
        }
      }
      this.thisDeviceModel = null;
      if (paramContext.deviceModels != null)
      {
        paramString2 = paramContext.deviceModels.iterator();
        while (paramString2.hasNext())
        {
          paramContext = (GpuScopeAttrs.GpuBean.DeviceModel)paramString2.next();
          if (paramString1.contains(paramContext.device))
          {
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append("->>deviceModels:");
            paramString2.append(paramContext.device);
            paramString2.append(",shareGLContextError:");
            paramString2.append(paramContext.shareGLContextError);
            LightLogUtil.i("GpuScopeAttrs", paramString2.toString());
            this.thisDeviceModel = paramContext;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.device.GpuScopeAttrs
 * JD-Core Version:    0.7.0.1
 */