package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class SignatureTemplateConfig
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    localStringBuilder.append("sign_tpl.json");
    a = localStringBuilder.toString();
  }
  
  public static SignatureTemplateInfo a(AppRuntime paramAppRuntime, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("config.json");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("signature.item.");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".json");
    paramAppRuntime = VasUpdateUtil.a(paramAppRuntime, 1000L, localStringBuilder.toString(), (String)localObject, true, null);
    try
    {
      paramAppRuntime = FileUtils.readFileToStringEx(paramAppRuntime, -1);
      if (paramAppRuntime == null)
      {
        QLog.e("SignatureTemplateConfig", 1, "read config fail result = null");
        return null;
      }
      localObject = new SignatureTemplateInfo(Integer.toString(paramInt));
      a(paramAppRuntime, (SignatureTemplateInfo)localObject);
      return localObject;
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      QLog.e("SignatureTemplateConfig", 1, "read config fail", paramAppRuntime);
    }
    return null;
  }
  
  private static Object a(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if (paramBoolean) {
      return paramObject1;
    }
    return paramObject2;
  }
  
  @Nullable
  private static String a(File paramFile)
  {
    try
    {
      paramFile = FileUtils.readFileToStringEx(paramFile, -1);
      if (paramFile == null) {
        return null;
      }
      return paramFile;
    }
    catch (OutOfMemoryError paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SignatureTemplateConfig", 2, "read config fail", paramFile);
      }
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static void a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    try
    {
      Color.parseColor(paramSignatureTemplateInfo.j);
      return;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    paramSignatureTemplateInfo.j = "";
  }
  
  private static void a(SignatureTemplateInfo paramSignatureTemplateInfo, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      a(paramSignatureTemplateInfo, paramJSONArray.getJSONObject(i));
      i += 1;
    }
  }
  
  private static void a(SignatureTemplateInfo paramSignatureTemplateInfo, JSONObject paramJSONObject)
  {
    int i;
    if (paramJSONObject.has("aio_rows")) {
      i = paramJSONObject.getInt("aio_rows");
    } else {
      i = -1;
    }
    if ((i == 0) || ((i > 1) && (i < 6)))
    {
      int j;
      if (i == 0) {
        j = i;
      } else {
        j = i - 1;
      }
      paramSignatureTemplateInfo.v[j].a = i;
      paramSignatureTemplateInfo.v[j].b = ((String)a(paramJSONObject.has("pngZip"), paramJSONObject.getString("pngZip"), ""));
      paramSignatureTemplateInfo.v[j].c = ((Float)a(paramJSONObject.has("posX"), paramJSONObject.getString("posX"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.v[j].d = ((Float)a(paramJSONObject.has("posY"), paramJSONObject.getString("posY"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.v[j].e = ((Float)a(paramJSONObject.has("width"), paramJSONObject.getString("width"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.v[j].f = ((Float)a(paramJSONObject.has("height"), paramJSONObject.getString("height"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.v[j].g = ((Integer)a(paramJSONObject.has("repeatTimes"), paramJSONObject.getString("repeatTimes"), Integer.valueOf(0))).intValue();
      paramSignatureTemplateInfo.v[j].h = ((Integer)a(paramJSONObject.has("interval"), paramJSONObject.getString("interval"), Integer.valueOf(0))).intValue();
    }
  }
  
  public static void a(String paramString, SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONArray("data");
      if ((localObject != null) && (((JSONArray)localObject).length() == 1))
      {
        i = 0;
        localObject = ((JSONArray)localObject).getJSONObject(0);
        if (((JSONObject)localObject).optInt("platId") == 1)
        {
          paramSignatureTemplateInfo.a();
          return;
        }
        paramSignatureTemplateInfo.k = ((JSONObject)localObject).optString("qqVer", "0.0.0");
        if (AppSetting.b(paramSignatureTemplateInfo.k) < 0)
        {
          paramSignatureTemplateInfo.a();
          return;
        }
        paramSignatureTemplateInfo.c = ((JSONObject)localObject).optString("name", HardCodeUtil.a(2131911516));
        paramSignatureTemplateInfo.e = ((JSONObject)localObject).optInt("type", -1);
        paramSignatureTemplateInfo.d = ((JSONObject)localObject).optInt("feeType", 1);
        paramSignatureTemplateInfo.f = ((JSONObject)localObject).optString("actUrl", null);
        paramSignatureTemplateInfo.g = ((JSONObject)localObject).optInt("newOrHot", 0);
        paramSignatureTemplateInfo.i = ((JSONObject)localObject).optInt("platId");
        paramSignatureTemplateInfo.j = ((JSONObject)localObject).optString("fontColor", "");
        paramSignatureTemplateInfo.E = ((JSONObject)localObject).optInt("signType", 0);
        a(paramSignatureTemplateInfo);
        paramSignatureTemplateInfo.s = ((JSONObject)localObject).optString("defText", "");
        paramSignatureTemplateInfo.t = ((JSONObject)localObject).optString("defTextColor", "");
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      int i;
      label216:
      label246:
      paramSignatureTemplateInfo = new StringBuilder();
      paramSignatureTemplateInfo.append("getSignatureTemplateInfoFromFile error: ");
      paramSignatureTemplateInfo.append(paramString.getMessage());
      QLog.e("SignatureTemplateConfig", 1, paramSignatureTemplateInfo.toString());
    }
    try
    {
      Color.parseColor(paramSignatureTemplateInfo.t);
    }
    catch (Exception localException1)
    {
      break label216;
    }
    paramSignatureTemplateInfo.t = "";
    paramSignatureTemplateInfo.u = ((JSONObject)localObject).optString("timeAndLocation", "");
    try
    {
      Color.parseColor(paramSignatureTemplateInfo.u);
    }
    catch (Exception localException2)
    {
      break label246;
    }
    paramSignatureTemplateInfo.u = "";
    paramSignatureTemplateInfo.w = ((JSONObject)localObject).optInt("isLimited", 1);
    paramSignatureTemplateInfo.x = ((JSONObject)localObject).optString("startTime");
    paramSignatureTemplateInfo.y = ((JSONObject)localObject).optString("endTime");
    paramSignatureTemplateInfo.z = ((JSONObject)localObject).optString("dot9png");
    paramSignatureTemplateInfo.h = ((JSONObject)localObject).optString("cover");
    paramSignatureTemplateInfo.l = ((JSONObject)localObject).optString("aio_2");
    paramSignatureTemplateInfo.m = ((JSONObject)localObject).optString("aio_3");
    paramSignatureTemplateInfo.n = ((JSONObject)localObject).optString("aio_4");
    paramSignatureTemplateInfo.o = ((JSONObject)localObject).optString("icon");
    paramSignatureTemplateInfo.p = ((JSONObject)localObject).optString("view");
    paramSignatureTemplateInfo.q = ((JSONObject)localObject).optString("action_off");
    paramSignatureTemplateInfo.r = ((JSONObject)localObject).optString("action_on");
    paramSignatureTemplateInfo.A = ((JSONObject)localObject).optString("backgroundColor");
    paramSignatureTemplateInfo.C = ((JSONObject)localObject).optString("shadowColor");
    paramSignatureTemplateInfo.B = ((JSONObject)localObject).optInt("materialVersion");
    if (paramString.has("dynamicItem")) {
      localObject = paramString.getJSONArray("dynamicItem");
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        d(paramSignatureTemplateInfo, ((JSONArray)localObject).getJSONObject(i));
        i += 1;
      }
      else
      {
        c(paramSignatureTemplateInfo, paramString);
        return;
      }
    }
  }
  
  private static void a(Map<Integer, SignatureTemplateConfig.SignatureTemplateType> paramMap, JSONObject paramJSONObject, Iterator paramIterator)
  {
    paramJSONObject = paramJSONObject.getJSONArray((String)paramIterator.next());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.getJSONObject(i);
      paramIterator = new SignatureTemplateInfo(((JSONObject)localObject).getString("id"));
      b(paramIterator, ((JSONObject)localObject).getJSONArray("data"));
      if (((JSONObject)localObject).has("dynamicItem")) {
        a(paramIterator, ((JSONObject)localObject).getJSONArray("dynamicItem"));
      }
      c(paramIterator, (JSONObject)localObject);
      localObject = (SignatureTemplateConfig.SignatureTemplateType)paramMap.get(Integer.valueOf(paramIterator.e));
      if (localObject != null) {
        ((SignatureTemplateConfig.SignatureTemplateType)localObject).c.add(paramIterator);
      }
      i += 1;
    }
  }
  
  public static SignatureTemplateConfig.SignatureTemplateType[] a(AppRuntime paramAppRuntime)
  {
    try
    {
      paramAppRuntime = new LinkedHashMap();
      localObject1 = a(new File(a));
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new JSONObject((String)((String)localObject1).subSequence(((String)localObject1).indexOf("{"), ((String)localObject1).length())).getJSONObject("data");
      Object localObject2 = ((JSONObject)localObject1).getJSONArray("itemType");
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        SignatureTemplateConfig.SignatureTemplateType localSignatureTemplateType = new SignatureTemplateConfig.SignatureTemplateType();
        localSignatureTemplateType.a = localJSONObject.getInt("sigId");
        localSignatureTemplateType.b = localJSONObject.getString("sigType");
        paramAppRuntime.put(Integer.valueOf(localSignatureTemplateType.a), localSignatureTemplateType);
        i += 1;
      }
      localObject1 = ((JSONObject)localObject1).getJSONObject("items");
      localObject2 = ((JSONObject)localObject1).keys();
      while (((Iterator)localObject2).hasNext()) {
        a(paramAppRuntime, (JSONObject)localObject1, (Iterator)localObject2);
      }
      localObject1 = paramAppRuntime.entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((SignatureTemplateConfig.SignatureTemplateType)((Map.Entry)((Iterator)localObject1).next()).getValue()).c.size() == 0) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = new SignatureTemplateConfig.SignatureTemplateType[paramAppRuntime.values().size()];
      paramAppRuntime.values().toArray((Object[])localObject1);
      return localObject1;
    }
    catch (Exception paramAppRuntime)
    {
      Object localObject1 = new File(a);
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
        ((File)localObject1).delete();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse sig cfg fail ");
        ((StringBuilder)localObject1).append(paramAppRuntime.getMessage());
        QLog.d("SignatureTemplateConfig", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return null;
  }
  
  private static void b(SignatureTemplateInfo paramSignatureTemplateInfo, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject.getInt("platId") != 1)
      {
        paramSignatureTemplateInfo.k = localJSONObject.getString("qqVer");
        if (AppSetting.b(paramSignatureTemplateInfo.k) >= 0)
        {
          paramSignatureTemplateInfo.c = ((String)a(localJSONObject.has("name"), localJSONObject.getString("name"), HardCodeUtil.a(2131911516)));
          paramSignatureTemplateInfo.e = ((Integer)a(localJSONObject.has("type"), Integer.valueOf(localJSONObject.getInt("type")), Integer.valueOf(-1))).intValue();
          paramSignatureTemplateInfo.d = ((Integer)a(localJSONObject.has("feeType"), Integer.valueOf(localJSONObject.getInt("feeType")), Integer.valueOf(1))).intValue();
          paramSignatureTemplateInfo.f = ((String)a(localJSONObject.has("actUrl"), localJSONObject.getString("actUrl"), null));
          paramSignatureTemplateInfo.g = ((Integer)a(localJSONObject.has("newOrHot"), localJSONObject.getString("newOrHot"), Integer.valueOf(0))).intValue();
          paramSignatureTemplateInfo.i = localJSONObject.getInt("platId");
          paramSignatureTemplateInfo.j = ((String)a(localJSONObject.has("fontColor"), localJSONObject.getString("fontColor"), ""));
          a(paramSignatureTemplateInfo);
          paramSignatureTemplateInfo.s = ((String)a(localJSONObject.has("defText"), localJSONObject.getString("defText"), ""));
          paramSignatureTemplateInfo.t = ((String)a(localJSONObject.has("defTextColor"), localJSONObject.getString("defTextColor"), ""));
        }
      }
      try
      {
        Color.parseColor(paramSignatureTemplateInfo.t);
      }
      catch (Exception localException1)
      {
        label304:
        label347:
        break label304;
      }
      paramSignatureTemplateInfo.t = "";
      paramSignatureTemplateInfo.u = ((String)a(localJSONObject.has("timeAndLocation"), localJSONObject.getString("timeAndLocation"), ""));
      try
      {
        Color.parseColor(paramSignatureTemplateInfo.u);
      }
      catch (Exception localException2)
      {
        break label347;
      }
      paramSignatureTemplateInfo.u = "";
      paramSignatureTemplateInfo.w = ((Integer)a(localJSONObject.has("isLimited"), localJSONObject.getString("isLimited"), Integer.valueOf(1))).intValue();
      paramSignatureTemplateInfo.x = ((String)a(localJSONObject.has("startTime"), localJSONObject.getString("startTime"), ""));
      paramSignatureTemplateInfo.y = ((String)a(localJSONObject.has("endTime"), localJSONObject.getString("endTime"), ""));
      paramSignatureTemplateInfo.z = ((String)a(localJSONObject.has("dot9png"), localJSONObject.getString("dot9png"), ""));
      paramSignatureTemplateInfo.A = ((String)a(localJSONObject.has("backgroundColor"), localJSONObject.getString("backgroundColor"), ""));
      b(paramSignatureTemplateInfo, localJSONObject);
      i += 1;
    }
  }
  
  private static void b(SignatureTemplateInfo paramSignatureTemplateInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("cover")) {
      paramSignatureTemplateInfo.h = paramJSONObject.getString("cover");
    }
    if (paramJSONObject.has("aio_2")) {
      paramSignatureTemplateInfo.l = paramJSONObject.getString("aio_2");
    }
    if (paramJSONObject.has("aio_3")) {
      paramSignatureTemplateInfo.m = paramJSONObject.getString("aio_3");
    }
    if (paramJSONObject.has("aio_4")) {
      paramSignatureTemplateInfo.n = paramJSONObject.getString("aio_4");
    }
    if (paramJSONObject.has("icon")) {
      paramSignatureTemplateInfo.o = paramJSONObject.getString("icon");
    }
    if (paramJSONObject.has("view")) {
      paramSignatureTemplateInfo.p = paramJSONObject.getString("view");
    }
    if (paramJSONObject.has("action_off")) {
      paramSignatureTemplateInfo.q = paramJSONObject.getString("action_off");
    }
    if (paramJSONObject.has("action_on")) {
      paramSignatureTemplateInfo.r = paramJSONObject.getString("action_on");
    }
  }
  
  private static void c(SignatureTemplateInfo paramSignatureTemplateInfo, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("imgItem");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      paramJSONObject = paramJSONObject.getJSONObject(0);
      paramSignatureTemplateInfo.getClass();
      SignatureTemplateInfo.ImageItem localImageItem = new SignatureTemplateInfo.ImageItem(paramSignatureTemplateInfo);
      localImageItem.d = paramJSONObject.optString("content");
      localImageItem.a = paramJSONObject.optString("img");
      localImageItem.b = paramJSONObject.optInt("imgWidth");
      localImageItem.c = paramJSONObject.optInt("imgHeight");
      localImageItem.e = paramJSONObject.optString("imgCover");
      paramSignatureTemplateInfo.D = localImageItem;
    }
  }
  
  private static void d(SignatureTemplateInfo paramSignatureTemplateInfo, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("aio_rows", -1);
    if ((j == 0) || ((j > 1) && (j < 6)))
    {
      int i;
      if (j == 0) {
        i = j;
      } else {
        i = j - 1;
      }
      paramSignatureTemplateInfo.v[i].a = j;
      paramSignatureTemplateInfo.v[i].b = paramJSONObject.optString("pngZip");
      paramSignatureTemplateInfo.v[i].c = ((float)paramJSONObject.optDouble("posX", 0.0D));
      paramSignatureTemplateInfo.v[i].d = ((float)paramJSONObject.optDouble("posY", 0.0D));
      paramSignatureTemplateInfo.v[i].e = ((float)paramJSONObject.optDouble("width", 0.0D));
      paramSignatureTemplateInfo.v[i].f = ((float)paramJSONObject.optDouble("height", 0.0D));
      paramSignatureTemplateInfo.v[i].g = paramJSONObject.optInt("repeatTimes", 0);
      paramSignatureTemplateInfo.v[i].h = paramJSONObject.optInt("interval", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SignatureTemplateConfig
 * JD-Core Version:    0.7.0.1
 */