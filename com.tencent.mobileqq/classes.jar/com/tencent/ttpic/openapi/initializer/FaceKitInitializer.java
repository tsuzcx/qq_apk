package com.tencent.ttpic.openapi.initializer;

import com.google.gson.JsonArray;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.youtu.FaceKitSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FaceKitInitializer
  extends Feature
{
  public static final ModelInfo[] FACE_KIT_FILTER_MODEL;
  public static final ModelInfo[] FACE_KIT_SO_MODEL;
  public static int[] facekitIndices = new int[36180];
  public static float[] facekitUV;
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("XHumanActionSDK"), new SharedLibraryInfo("facekit") };
  
  static
  {
    FACE_KIT_SO_MODEL = new ModelInfo[] { new ModelInfo(true, "facekit", "pitu_gender_faceKit.lic"), new ModelInfo(true, "facekit", "Params_animoji.json"), new ModelInfo(true, "facekit", "FaceKit6K_Animoji.xbin") };
    FACE_KIT_FILTER_MODEL = new ModelInfo[] { new ModelInfo(true, "facekit", "facekit_uv.json"), new ModelInfo(true, "facekit", "facekit_indices.json") };
    facekitUV = new float[32225];
  }
  
  private boolean initModels()
  {
    return FaceKitSDK.INSTANCE.nativeInit(getModelFinalPath(FACE_KIT_SO_MODEL[0]), getModelFinalPath(FACE_KIT_SO_MODEL[1]), getModelFinalPath(FACE_KIT_SO_MODEL[2]));
  }
  
  private boolean loadFacekitIndices(String paramString1, String paramString2)
  {
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, true, VideoTemplateParser.decryptListener);
    if (paramString1 == null) {}
    do
    {
      return false;
      paramString1 = GsonUtils.optJsonArray(paramString1, "index");
    } while ((paramString1 == null) || (paramString1.size() == 0));
    int i = 0;
    while (i < paramString1.size())
    {
      facekitIndices[i] = GsonUtils.optInt(paramString1, i, 0);
      i += 1;
    }
    return true;
  }
  
  private boolean loadFacekitUV(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, true, VideoTemplateParser.decryptListener);
    if (paramString1 == null) {}
    do
    {
      return false;
      paramString1 = GsonUtils.optJsonArray(paramString1, "uv");
    } while ((paramString1 == null) || (paramString1.size() == 0));
    while (i < paramString1.size())
    {
      facekitUV[(i + 19335)] = ((float)GsonUtils.optDouble(paramString1, i, 0.0D));
      i += 1;
    }
    return true;
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, FACE_KIT_SO_MODEL);
    Collections.addAll(localArrayList, FACE_KIT_FILTER_MODEL);
    return localArrayList;
  }
  
  public String getName()
  {
    return "FaceKit";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  public boolean initFaceKit()
  {
    if (!loadAllSoFiles()) {}
    boolean bool;
    do
    {
      do
      {
        return false;
      } while ((!loadFacekitUV(getFinalResourcesDir(), "facekit_uv")) || (!loadFacekitIndices(getFinalResourcesDir(), "facekit_indices")));
      bool = initModels();
    } while (!bool);
    return bool;
  }
  
  protected boolean initImpl()
  {
    return initFaceKit();
  }
  
  public void setLicense(String paramString1, String paramString2)
  {
    ModelInfo localModelInfo = FACE_KIT_SO_MODEL[0];
    String str = paramString1;
    if (!paramString1.endsWith(File.separator)) {
      str = paramString1 + File.separator;
    }
    localModelInfo.assetsDir = str;
    localModelInfo.fileName = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.FaceKitInitializer
 * JD-Core Version:    0.7.0.1
 */