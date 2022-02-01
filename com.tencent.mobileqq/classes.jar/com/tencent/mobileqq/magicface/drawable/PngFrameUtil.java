package com.tencent.mobileqq.magicface.drawable;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PngFrameUtil
{
  public static int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return Math.abs(new Random().nextInt(paramInt));
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (paramString.contains("rscType"))
    {
      int i = paramString.indexOf("rscType") + 7 + 1;
      int j = i + 1;
      if (j < paramString.length())
      {
        paramString = paramString.substring(i, j);
        try
        {
          i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  private PngPlayParam a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    localPngPlayParam = new PngPlayParam();
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1.has("num")) {
        localPngPlayParam.jdField_a_of_type_Int = paramString1.getInt("num");
      }
      boolean bool = paramString1.has("process_frame");
      int j = 0;
      Object localObject1;
      int i;
      Object localObject2;
      if (bool)
      {
        localObject1 = paramString1.getJSONObject("process_frame");
        if (((JSONObject)localObject1).has("repeat")) {
          localPngPlayParam.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("repeat");
        }
        if (((JSONObject)localObject1).has("frame_delay")) {
          localPngPlayParam.c = ((JSONObject)localObject1).getInt("frame_delay");
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("seq_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localPngPlayParam.jdField_a_of_type_ArrayOfJavaLangString = new String[((JSONArray)localObject1).length()];
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = localPngPlayParam.jdField_a_of_type_ArrayOfJavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(EmotionPanelConstans.pngFramePath.replace("[epId]", paramString2));
            localStringBuilder.append(((JSONArray)localObject1).getString(i));
            localObject2[i] = localStringBuilder.toString();
            i += 1;
          }
        }
      }
      paramString1 = paramString1.getJSONArray("result_frame");
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        localPngPlayParam.jdField_b_of_type_ArrayOfJavaLangString = new String[paramString1.length()];
        i = j;
        while (i < paramString1.length())
        {
          localObject1 = localPngPlayParam.jdField_b_of_type_ArrayOfJavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(EmotionPanelConstans.pngFramePath.replace("[epId]", paramString2));
          ((StringBuilder)localObject2).append(paramString1.getString(i));
          localObject1[i] = ((StringBuilder)localObject2).toString();
          i += 1;
        }
      }
      return localPngPlayParam;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(EmotionPanelConstans.pngFramePath.replace("[epId]", paramString));
    localStringBuffer.append("config.json");
    paramString = new File(localStringBuffer.toString());
    if (!paramString.exists()) {
      return null;
    }
    return FileUtils.readFileContent(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func checkRandomPngExist, file NOT exist.[");
        ((StringBuilder)localObject1).append(paramString.getAbsolutePath());
        ((StringBuilder)localObject1).append("].");
        QLog.d("PngFrameUtil", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    Object localObject1 = new File(paramString, "config.json");
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("func checkRandomPngExist, file NOT exist.[");
        paramString.append(((File)localObject1).getAbsolutePath());
        paramString.append("].");
        QLog.d("PngFrameUtil", 2, paramString.toString());
      }
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(FileUtils.readFileContent((File)localObject1));
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("process_frame");
        if (((JSONObject)localObject2).has("seq_array"))
        {
          JSONArray localJSONArray = ((JSONObject)localObject2).getJSONArray("seq_array");
          if (localJSONArray.length() > 0)
          {
            i = 0;
            if (i < localJSONArray.length())
            {
              localObject2 = new File(paramString, (String)localJSONArray.get(i));
              if (((File)localObject2).exists()) {
                break label421;
              }
              if (!QLog.isColorLevel()) {
                break label419;
              }
              paramString = new StringBuilder();
              paramString.append("func checkRandomPngExist, file NOT exist.[");
              paramString.append(((File)localObject2).getAbsolutePath());
              paramString.append("].");
              QLog.d("PngFrameUtil", 2, paramString.toString());
              return false;
            }
          }
        }
        localObject2 = ((JSONObject)localObject1).getJSONArray("result_frame");
        if (((JSONArray)localObject2).length() > 0)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject1 = new File(paramString, (String)((JSONArray)localObject2).get(i));
            if (!((File)localObject1).exists())
            {
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("func checkRandomPngExist, file NOT exist.[");
                paramString.append(((File)localObject1).getAbsolutePath());
                paramString.append("].");
                QLog.d("PngFrameUtil", 2, paramString.toString());
              }
              return false;
            }
            i += 1;
            continue;
          }
        }
        return true;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("func checkRandomPngExist, exception:");
          ((StringBuilder)localObject1).append(paramString.getMessage());
          QLog.w("PngFrameUtil", 2, ((StringBuilder)localObject1).toString());
        }
        return false;
      }
      label419:
      return false;
      label421:
      i += 1;
    }
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (paramString.contains("value"))
    {
      int i = paramString.indexOf("value") + 5 + 1;
      if (i < paramString.length())
      {
        paramString = paramString.substring(i);
        try
        {
          i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return 0;
  }
  
  public int a(File paramFile)
  {
    paramFile = FileUtils.readFileContent(paramFile);
    if (!TextUtils.isEmpty(paramFile)) {
      try
      {
        paramFile = new JSONObject(paramFile);
        if (paramFile.has("rscType"))
        {
          int i = paramFile.getInt("rscType");
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("func getRscType(from local json file),type:");
            paramFile.append(i);
            QLog.d("PngFrameUtil", 2, paramFile.toString());
          }
          return i;
        }
        return 0;
      }
      catch (JSONException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return 0;
  }
  
  public PngPlayParam a(String paramString)
  {
    return a(a(paramString), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameUtil
 * JD-Core Version:    0.7.0.1
 */