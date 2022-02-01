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
    Object localObject = FileUtils.genSeperateFileDir(paramString3) + "device_config.json";
    paramString3 = (String)localObject;
    if (!FileUtils.isFileExist((String)localObject)) {
      paramString3 = "assets://device_config.json";
    }
    paramContext = FileUtils.load(paramContext, paramString3);
    try
    {
      paramContext = (GpuScopeAttrs.GpuBean)new Gson().fromJson(paramContext, GpuScopeAttrs.GpuBean.class);
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
          paramContext = paramContext.deviceModels.iterator();
          while (paramContext.hasNext())
          {
            paramString2 = (GpuScopeAttrs.GpuBean.DeviceModel)paramContext.next();
            if (paramString1.contains(paramString2.device))
            {
              LightLogUtil.i("GpuScopeAttrs", paramString1 + "->>deviceModels:" + paramString2.device + ",shareGLContextError:" + paramString2.shareGLContextError);
              this.thisDeviceModel = paramString2;
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        LightLogUtil.e("GpuScopeAttrs", paramContext.toString());
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.device.GpuScopeAttrs
 * JD-Core Version:    0.7.0.1
 */