package com.tencent.mobileqq.profile.like;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PraiseInfo
{
  public int a;
  public String b;
  public String c;
  public int d;
  public String e;
  public Bitmap f;
  public String g;
  public Bitmap h;
  public String i;
  public Bitmap j;
  public String k;
  public String l;
  
  public PraiseInfo(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static PraiseInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("content:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PraiseInfo", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new JSONObject(paramString);
      localPraiseInfo = new PraiseInfo(paramInt);
      localPraiseInfo.b = paramString.optString("name");
      localPraiseInfo.c = paramString.optString("text");
      if (paramString.has("color"))
      {
        localObject = paramString.optString("color").trim();
        paramString = (String)localObject;
        if (((String)localObject).startsWith("0x")) {
          paramString = ((String)localObject).substring(2);
        }
      }
    }
    catch (IOException paramString)
    {
      Object localObject;
      PraiseInfo localPraiseInfo;
      QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with IOException.", paramString);
      return null;
    }
    catch (JSONException paramString)
    {
      label168:
      QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with JsonException.", paramString);
      return null;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramString);
      localPraiseInfo.d = Color.parseColor(((StringBuilder)localObject).toString());
      return localPraiseInfo;
    }
    catch (Exception paramString)
    {
      break label168;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PraiseInfo", 2, "color invalid");
    }
    return localPraiseInfo;
  }
  
  private static String a(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" not exist!");
      QLog.e("PraiseInfo", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      paramString = FileUtils.readFileToString((File)localObject);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PraiseInfo", 2, paramString.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseInfo
 * JD-Core Version:    0.7.0.1
 */