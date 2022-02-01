package com.tencent.ttpic.openapi.initializer;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.Coffee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class RapidnetModelManager
{
  public static final int MODEL_ID_GENDER_DETECT = 5;
  public static final int MODEL_ID_GENDER_SWITCH = 0;
  public static final int MODEL_ID_HAIR_SEG = 1;
  public static final int MODEL_ID_HAND_DETECT = 3;
  public static final int MODEL_ID_HUMAN_SEG = 4;
  public static final int MODEL_ID_RGB_DEPTH = 7;
  public static final int MODEL_ID_SKY_SEG = 2;
  public static final int MODEL_ID_STYLE_CHILD = 6;
  public static final int MODEL_TYPE_GENDER_DETECT = 3;
  public static final int MODEL_TYPE_GENDER_SWITCH = 1;
  public static final int MODEL_TYPE_HAND_DETECT = 2;
  public static final int MODEL_TYPE_SEG = 0;
  private static final String TAG = "RapidnetModelManager";
  private Map<Integer, Boolean> rapidnetModelMap = new HashMap();
  
  public static String copyIfInAssets(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.startsWith("assets://"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmp_");
      localStringBuilder.append(paramString2);
      paramString3 = new File(paramString3, localStringBuilder.toString());
      paramString3.deleteOnExit();
      paramString3 = paramString3.getPath();
      FileUtils.delete(paramString3);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileUtils.genSeperateFileDir(paramString1));
      localStringBuilder.append(paramString2);
      paramString1 = FileUtils.getRealPath(localStringBuilder.toString());
      FileUtils.copyAssets(AEModule.getContext(), paramString1, paramString3);
      return paramString3;
    }
    paramString3 = new StringBuilder();
    paramString3.append(FileUtils.genSeperateFileDir(paramString1));
    paramString3.append(paramString2);
    return paramString3.toString();
  }
  
  public static String decryptRapidNetFile(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FileUtils.genSeperateFileDir(paramString1));
    ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FileUtils.genSeperateFileDir(paramString1));
    ((StringBuilder)localObject2).append("decrypt_");
    ((StringBuilder)localObject2).append(paramString2);
    paramString1 = ((StringBuilder)localObject2).toString();
    paramString2 = new File((String)localObject1);
    localObject1 = new File(paramString1);
    if (((File)localObject1).exists()) {
      FileUtils.delete((File)localObject1);
    }
    try
    {
      if ((paramString2.isFile()) && (paramString2.exists()))
      {
        localObject1 = new FileInputStream(paramString2);
        paramString2 = Coffee.drinkACupOfCoffee((InputStream)localObject1, false);
        IOUtils.closeQuietly((InputStream)localObject1);
        localObject1 = new FileOutputStream(paramString1);
        localObject2 = new byte[1024];
        for (;;)
        {
          int i = paramString2.read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
        }
        IOUtils.closeQuietly(paramString2);
        IOUtils.closeQuietly((OutputStream)localObject1);
        return paramString1;
      }
    }
    catch (IOException paramString2)
    {
      paramString2.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("drinkACupOfCoffee IOException : ");
      ((StringBuilder)localObject1).append(paramString2.getMessage());
      LogUtils.e("RapidnetModelManager", ((StringBuilder)localObject1).toString());
      return paramString1;
    }
    catch (FileNotFoundException paramString2)
    {
      paramString2.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("protoFile Not found: ");
      ((StringBuilder)localObject1).append(paramString2.getMessage());
      LogUtils.e("RapidnetModelManager", ((StringBuilder)localObject1).toString());
    }
    return paramString1;
  }
  
  public void clear()
  {
    this.rapidnetModelMap.clear();
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    if (this.rapidnetModelMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.rapidnetModelMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return false;
  }
  
  public void toggleRapidModel(int paramInt, boolean paramBoolean)
  {
    this.rapidnetModelMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidnetModelManager
 * JD-Core Version:    0.7.0.1
 */