package com.tencent.ttpic.openapi.initializer;

import com.google.android.filament.Filament;
import com.google.android.filament.gltfio.AssetLoader;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.GpuModel;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FilamentInitializer
  extends Feature
{
  private static final String TAG = FilamentInitializer.class.getSimpleName();
  private static boolean isFilamentInited = false;
  private static boolean isGltfioInited = false;
  private static final ModelInfo[] modelFiles;
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("filament-jni_11081930"), new SharedLibraryInfo("gltfio-jni_11262100") };
  
  static
  {
    modelFiles = new ModelInfo[] { new ModelInfo(true, "filament", "filament_head.filamat", 0), new ModelInfo(true, "filament", "head_index.txt", 0), new ModelInfo(true, "filament", "head_vertex.txt", 0), new ModelInfo(true, "filament", "fur.filamat", 0), new ModelInfo(true, "filament", "bloom_blur.filamat", 0), new ModelInfo(true, "filament", "bloom_mix.filamat", 0) };
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
  
  private boolean initFilament()
  {
    boolean bool = true;
    if (!supportFilament()) {}
    do
    {
      do
      {
        return false;
        if (isFilamentInited) {
          break;
        }
        Filament.initBeforeSoLoaded();
        isFilamentInited = loadSoFile(sharedLibraries[0]);
      } while (!isFilamentInited);
      if (isGltfioInited) {
        break;
      }
      isGltfioInited = loadSoFile(sharedLibraries[1]);
    } while (!isGltfioInited);
    AssetLoader.initAfterSoLoaded();
    if ((isFilamentInited) && (isGltfioInited)) {}
    for (;;)
    {
      this.isSoFilesLoaded = bool;
      return this.isSoFilesLoaded;
      bool = false;
    }
  }
  
  public static boolean isDeviceSupportFilament(String paramString)
  {
    GpuScopeAttrs.GpuBean.GpuModel localGpuModel = GpuScopeAttrs.getInstance().getGPuModel();
    if (localGpuModel == null) {}
    while ((localGpuModel.filamentSupport) || ((localGpuModel.filamentWhiteList != null) && (localGpuModel.filamentWhiteList.contains(paramString)))) {
      return true;
    }
    return false;
  }
  
  public static boolean supportFilament()
  {
    return (GLCapabilities.getGlesVersion().contains("3.")) && (GLCapabilities.isFilamentShaderCompileSucceed());
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public String getHeadFilamentPath()
  {
    return getModelFinalPath(modelFiles[0]);
  }
  
  public String getHeadGlbPath()
  {
    return getModelFinalPath(modelFiles[1]);
  }
  
  public String getIndexTxtPath()
  {
    return getModelFinalPath(modelFiles[2]);
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
  
  public String getVertextxtPath()
  {
    return getModelFinalPath(modelFiles[3]);
  }
  
  protected boolean initImpl()
  {
    if (!initFilament()) {
      return false;
    }
    return checkModelFilesExist(getFinalResourcesDir());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.FilamentInitializer
 * JD-Core Version:    0.7.0.1
 */