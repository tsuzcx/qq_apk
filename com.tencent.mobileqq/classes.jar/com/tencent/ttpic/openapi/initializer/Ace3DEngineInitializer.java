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
  private static final String TAG = Ace3DEngineInitializer.class.getSimpleName();
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
      File localFile = new File(paramString + File.separator + localModelInfo.fileName);
      if (!localFile.exists()) {}
      while ((localModelInfo.getFileSizeInBytes() > 0) && (localFile.length() < localModelInfo.getFileSizeInBytes())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean initAceEngine()
  {
    boolean bool = true;
    if (!supportAceEngine()) {}
    do
    {
      do
      {
        return false;
        if (isFilamentInited) {
          break;
        }
        isFilamentInited = true;
      } while (!isFilamentInited);
      if (isGltfioInited) {
        break;
      }
      isGltfioInited = loadSoFile(sharedLibraries[1]);
    } while (!isGltfioInited);
    com.google.android.filament.gltfio.ImageLoader.desiredSize = 1024;
    if ((isFilamentInited) && (isGltfioInited)) {}
    for (;;)
    {
      this.isSoFilesLoaded = bool;
      return this.isSoFilesLoaded;
      bool = false;
    }
  }
  
  public static boolean isDeviceSupportAceEngine(String paramString)
  {
    GpuScopeAttrs.GpuBean.GpuModel localGpuModel = GpuScopeAttrs.getInstance().getGPuModel();
    if (localGpuModel == null) {}
    while ((localGpuModel.filamentSupport) || ((localGpuModel.filamentWhiteList != null) && (localGpuModel.filamentWhiteList.contains(paramString)))) {
      return true;
    }
    return false;
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
    Log.d(TAG, "[Ace3DEngine] init succeed! AceEngine Version: " + AceMaterialManager.getEngineVersion());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer
 * JD-Core Version:    0.7.0.1
 */