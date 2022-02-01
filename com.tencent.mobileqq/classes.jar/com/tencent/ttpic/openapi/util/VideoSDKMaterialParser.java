package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.DecryptListener;
import java.util.HashMap;

public class VideoSDKMaterialParser
{
  private static final DecryptListener decryptListener = new VideoSDKMaterialParser.1();
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2)
  {
    return VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, true, decryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    return VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, true, decryptListener, paramHashMap);
  }
  
  public static VideoMaterial parseVideoMaterialForEdit(String paramString1, String paramString2)
  {
    return VideoTemplateParser.parseVideoMaterialForEdit(paramString1, paramString2, true, decryptListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoSDKMaterialParser
 * JD-Core Version:    0.7.0.1
 */