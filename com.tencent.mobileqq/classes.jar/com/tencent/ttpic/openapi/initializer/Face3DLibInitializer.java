package com.tencent.ttpic.openapi.initializer;

import com.google.gson.JsonArray;
import com.tencent.ttpic.filter.Face3DLibJNI;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Face3DLibInitializer
  extends Feature
{
  public static final ModelInfo[] FACE_3D_FILTER_MODEL;
  public static final ModelInfo[] FACE_3D_SO_MODEL;
  public static int[] face3DIndices = new int[20208];
  public static Face3DLibJNI face3DLibJNI;
  public static float[] face3DUV;
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("face3DLib") };
  
  static
  {
    FACE_3D_SO_MODEL = new ModelInfo[] { new ModelInfo(true, "Face3DLib", "2DTo3D_Edge.txt"), new ModelInfo(true, "Face3DLib", "mean.bin"), new ModelInfo(true, "Face3DLib", "normalised_pca_basis_roi.bin"), new ModelInfo(true, "Face3DLib", "All_68_youtu2.txt"), new ModelInfo(true, "Face3DLib", "blendshape_46.bin"), new ModelInfo(true, "Face3DLib", "blendshape_46_nnls_68.bin"), new ModelInfo(true, "Face3DLib", "LeftFace2.txt"), new ModelInfo(true, "Face3DLib", "RightFace2.txt") };
    FACE_3D_FILTER_MODEL = new ModelInfo[] { new ModelInfo(true, "Face3DLib", "face3d_indices_config.dat"), new ModelInfo(true, "Face3DLib", "face3d_uv_config.dat"), new ModelInfo(true, "Face3DLib", "face3d_uv_config_yt.dat"), new ModelInfo(true, "Face3DLib", "face3d_normal_v2.dat") };
    face3DLibJNI = Face3DLibJNI.getInstance();
    face3DUV = new float[34480];
  }
  
  private boolean loadFace3DIndices(String paramString1, String paramString2)
  {
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, VideoTemplateParser.decryptListener);
    if (paramString1 == null) {
      return false;
    }
    paramString1 = GsonUtils.optJsonArray(paramString1, "index");
    if (paramString1 != null)
    {
      if (paramString1.size() == 0) {
        return false;
      }
      int i = 0;
      while (i < paramString1.size())
      {
        face3DIndices[i] = GsonUtils.optInt(paramString1, i, 0);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean loadFace3DNormal(String paramString1, String paramString2)
  {
    DecryptListener localDecryptListener = VideoTemplateParser.decryptListener;
    int i = 0;
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, localDecryptListener);
    if (paramString1 == null) {
      return false;
    }
    paramString1 = GsonUtils.optJsonArray(paramString1, "normal");
    if (paramString1 != null)
    {
      if (paramString1.size() == 0) {
        return false;
      }
      while (i < paramString1.size())
      {
        face3DUV[(i + 24136)] = ((float)GsonUtils.optDouble(paramString1, i, 0.0D));
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean loadFace3DUV(String paramString1, String paramString2)
  {
    DecryptListener localDecryptListener = VideoTemplateParser.decryptListener;
    int i = 0;
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, localDecryptListener);
    if (paramString1 == null) {
      return false;
    }
    paramString1 = GsonUtils.optJsonArray(paramString1, "uv");
    if (paramString1 != null)
    {
      if (paramString1.size() == 0) {
        return false;
      }
      while (i < paramString1.size())
      {
        face3DUV[(i + 10344)] = ((float)GsonUtils.optDouble(paramString1, i, 0.0D));
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean loadFace3DUV2(String paramString1, String paramString2)
  {
    DecryptListener localDecryptListener = VideoTemplateParser.decryptListener;
    int i = 0;
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, localDecryptListener);
    if (paramString1 == null) {
      return false;
    }
    paramString1 = GsonUtils.optJsonArray(paramString1, "uv");
    if (paramString1 != null)
    {
      if (paramString1.size() == 0) {
        return false;
      }
      while (i < paramString1.size())
      {
        face3DUV[(i + 17240)] = ((float)GsonUtils.optDouble(paramString1, i, 0.0D));
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  protected boolean destroyImpl()
  {
    face3DLibJNI.destroy();
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, FACE_3D_SO_MODEL);
    Collections.addAll(localArrayList, FACE_3D_FILTER_MODEL);
    return localArrayList;
  }
  
  public String getName()
  {
    return "Face3DLib";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  public boolean initFace3D()
  {
    if (!loadAllSoFiles()) {
      return false;
    }
    if (!loadFace3DUV(getFinalResourcesDir(), "face3d_uv_config")) {
      return false;
    }
    if (!loadFace3DUV2(getFinalResourcesDir(), "face3d_uv_config_yt")) {
      return false;
    }
    if (!loadFace3DIndices(getFinalResourcesDir(), "face3d_indices_config")) {
      return false;
    }
    if (!loadFace3DNormal(getFinalResourcesDir(), "face3d_normal_v2")) {
      return false;
    }
    return face3DLibJNI.init(getFinalResourcesDir());
  }
  
  protected boolean initImpl()
  {
    return initFace3D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Face3DLibInitializer
 * JD-Core Version:    0.7.0.1
 */