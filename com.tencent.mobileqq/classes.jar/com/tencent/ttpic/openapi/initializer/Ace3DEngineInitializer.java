package com.tencent.ttpic.openapi.initializer;

import android.util.Log;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.GpuModel;
import com.tencent.ttpic.filament.AceMaterialManager;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Ace3DEngineInitializer
  extends Feature
{
  private static final String TAG = "Ace3DEngineInitializer";
  private static boolean isFilamentInited = false;
  private static boolean isGltfioInited = false;
  private static final ModelInfo[] modelFiles;
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("filament-jni"), new SharedLibraryInfo("gltfio-jni") };
  
  static
  {
    modelFiles = new ModelInfo[] { new ModelInfo(true, "filament", "bloom_blur.filamat", 0), new ModelInfo(true, "filament", "bloom_mix.filamat", 0), new ModelInfo(true, "filament", "face_mesh.filamat", 0), new ModelInfo(true, "filament", "face_mesh_lit.filamat", 0), new ModelInfo(true, "filament", "filament_head.filamat", 0), new ModelInfo(true, "filament", "fur.filamat", 0), new ModelInfo(true, "filament", "fur_light.filamat", 0), new ModelInfo(true, "filament", "head_feather.filamat", 0), new ModelInfo(true, "filament", "head_index.txt", 0), new ModelInfo(true, "filament", "head_vertex.txt", 0), new ModelInfo(true, "filament", "location_init.filamat", 0), new ModelInfo(true, "filament", "reflection.filamat", 0) };
  }
  
  private static boolean checkModelFilesExist(String paramString)
  {
    ModelInfo[] arrayOfModelInfo = modelFiles;
    int j = arrayOfModelInfo.length;
    int i = 0;
    while (i < j)
    {
      ModelInfo localModelInfo = arrayOfModelInfo[i];
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(localModelInfo.fileName);
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        return false;
      }
      if ((localModelInfo.getFileSizeInBytes() > 0) && (((File)localObject).length() < localModelInfo.getFileSizeInBytes())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean initAceEngine()
  {
    boolean bool1 = supportAceEngine();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (!isFilamentInited)
    {
      isFilamentInited = true;
      if (!isFilamentInited) {
        return false;
      }
    }
    if (!isGltfioInited)
    {
      isGltfioInited = loadSoFile(sharedLibraries[1]);
      if (!isGltfioInited) {
        return false;
      }
    }
    com.google.android.filament.gltfio.ImageLoader.desiredSize = 1024;
    bool1 = bool2;
    if (isFilamentInited)
    {
      bool1 = bool2;
      if (isGltfioInited) {
        bool1 = true;
      }
    }
    this.isSoFilesLoaded = bool1;
    return this.isSoFilesLoaded;
  }
  
  public static boolean isDeviceSupportAceEngine(String paramString)
  {
    GpuScopeAttrs.GpuBean.GpuModel localGpuModel = GpuScopeAttrs.getInstance().getGPuModel();
    if (localGpuModel == null) {
      return true;
    }
    if (localGpuModel.filamentSupport) {
      return true;
    }
    return (localGpuModel.filamentWhiteList != null) && (localGpuModel.filamentWhiteList.contains(paramString));
  }
  
  public static boolean supportAceEngine()
  {
    return (GLCapabilities.getGlesVersion().contains("3.")) && (GLCapabilities.isFilamentShaderCompileSucceed());
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return Arrays.asList(modelFiles);
  }
  
  public String getName()
  {
    return "Filament";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    if (!initAceEngine())
    {
      Log.e(TAG, "[Ace3DEngine] init failed! so load failed!");
      return false;
    }
    boolean bool = checkModelFilesExist(getFinalResourcesDir());
    if (!bool)
    {
      Log.e(TAG, "[Ace3DEngine] init failed! Model file not exist!");
      return bool;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Ace3DEngine] init succeed! AceEngine Version: ");
    localStringBuilder.append(AceMaterialManager.getEngineVersion());
    Log.d(str, localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer
 * JD-Core Version:    0.7.0.1
 */