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
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
      Color.parseColor(paramSignatureTemplateInfo.jdField_e_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    paramSignatureTemplateInfo.jdField_e_of_type_JavaLangString = "";
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
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_a_of_type_Int = i;
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_a_of_type_JavaLangString = ((String)a(paramJSONObject.has("pngZip"), paramJSONObject.getString("pngZip"), ""));
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_a_of_type_Float = ((Float)a(paramJSONObject.has("posX"), paramJSONObject.getString("posX"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_b_of_type_Float = ((Float)a(paramJSONObject.has("posY"), paramJSONObject.getString("posY"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_c_of_type_Float = ((Float)a(paramJSONObject.has("width"), paramJSONObject.getString("width"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].d = ((Float)a(paramJSONObject.has("height"), paramJSONObject.getString("height"), Integer.valueOf(0))).floatValue();
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_b_of_type_Int = ((Integer)a(paramJSONObject.has("repeatTimes"), paramJSONObject.getString("repeatTimes"), Integer.valueOf(0))).intValue();
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[j].jdField_c_of_type_Int = ((Integer)a(paramJSONObject.has("interval"), paramJSONObject.getString("interval"), Integer.valueOf(0))).intValue();
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
        paramSignatureTemplateInfo.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("qqVer", "0.0.0");
        if (AppSetting.a(paramSignatureTemplateInfo.jdField_f_of_type_JavaLangString) < 0)
        {
          paramSignatureTemplateInfo.a();
          return;
        }
        paramSignatureTemplateInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", HardCodeUtil.a(2131713985));
        paramSignatureTemplateInfo.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
        paramSignatureTemplateInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeType", 1);
        paramSignatureTemplateInfo.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("actUrl", null);
        paramSignatureTemplateInfo.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("newOrHot", 0);
        paramSignatureTemplateInfo.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("platId");
        paramSignatureTemplateInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("fontColor", "");
        paramSignatureTemplateInfo.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("signType", 0);
        a(paramSignatureTemplateInfo);
        paramSignatureTemplateInfo.n = ((JSONObject)localObject).optString("defText", "");
        paramSignatureTemplateInfo.o = ((JSONObject)localObject).optString("defTextColor", "");
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      int i;
      label214:
      label244:
      paramSignatureTemplateInfo = new StringBuilder();
      paramSignatureTemplateInfo.append("getSignatureTemplateInfoFromFile error: ");
      paramSignatureTemplateInfo.append(paramString.getMessage());
      QLog.e("SignatureTemplateConfig", 1, paramSignatureTemplateInfo.toString());
    }
    try
    {
      Color.parseColor(paramSignatureTemplateInfo.o);
    }
    catch (Exception localException1)
    {
      break label214;
    }
    paramSignatureTemplateInfo.o = "";
    paramSignatureTemplateInfo.p = ((JSONObject)localObject).optString("timeAndLocation", "");
    try
    {
      Color.parseColor(paramSignatureTemplateInfo.p);
    }
    catch (Exception localException2)
    {
      break label244;
    }
    paramSignatureTemplateInfo.p = "";
    paramSignatureTemplateInfo.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("isLimited", 1);
    paramSignatureTemplateInfo.q = ((JSONObject)localObject).optString("startTime");
    paramSignatureTemplateInfo.r = ((JSONObject)localObject).optString("endTime");
    paramSignatureTemplateInfo.s = ((JSONObject)localObject).optString("dot9png");
    paramSignatureTemplateInfo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("cover");
    paramSignatureTemplateInfo.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("aio_2");
    paramSignatureTemplateInfo.h = ((JSONObject)localObject).optString("aio_3");
    paramSignatureTemplateInfo.i = ((JSONObject)localObject).optString("aio_4");
    paramSignatureTemplateInfo.j = ((JSONObject)localObject).optString("icon");
    paramSignatureTemplateInfo.k = ((JSONObject)localObject).optString("view");
    paramSignatureTemplateInfo.l = ((JSONObject)localObject).optString("action_off");
    paramSignatureTemplateInfo.m = ((JSONObject)localObject).optString("action_on");
    paramSignatureTemplateInfo.t = ((JSONObject)localObject).optString("backgroundColor");
    paramSignatureTemplateInfo.u = ((JSONObject)localObject).optString("shadowColor");
    paramSignatureTemplateInfo.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("materialVersion");
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
      localObject = (SignatureTemplateConfig.SignatureTemplateType)paramMap.get(Integer.valueOf(paramIterator.jdField_b_of_type_Int));
      if (localObject != null) {
        ((SignatureTemplateConfig.SignatureTemplateType)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramIterator);
      }
      i += 1;
    }
  }
  
  public static SignatureTemplateConfig.SignatureTemplateType[] a(AppRuntime paramAppRuntime)
  {
    try
    {
      paramAppRuntime = new LinkedHashMap();
      localObject1 = a(new File(jdField_a_of_type_JavaLangString));
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
        localSignatureTemplateType.jdField_a_of_type_Int = localJSONObject.getInt("sigId");
        localSignatureTemplateType.jdField_a_of_type_JavaLangString = localJSONObject.getString("sigType");
        paramAppRuntime.put(Integer.valueOf(localSignatureTemplateType.jdField_a_of_type_Int), localSignatureTemplateType);
        i += 1;
      }
      localObject1 = ((JSONObject)localObject1).getJSONObject("items");
      localObject2 = ((JSONObject)localObject1).keys();
      while (((Iterator)localObject2).hasNext()) {
        a(paramAppRuntime, (JSONObject)localObject1, (Iterator)localObject2);
      }
      localObject1 = paramAppRuntime.entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((SignatureTemplateConfig.SignatureTemplateType)((Map.Entry)((Iterator)localObject1).next()).getValue()).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = new SignatureTemplateConfig.SignatureTemplateType[paramAppRuntime.values().size()];
      paramAppRuntime.values().toArray((Object[])localObject1);
      return localObject1;
    }
    catch (Exception paramAppRuntime)
    {
      Object localObject1 = new File(jdField_a_of_type_JavaLangString);
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
        paramSignatureTemplateInfo.jdField_f_of_type_JavaLangString = localJSONObject.getString("qqVer");
        if (AppSetting.a(paramSignatureTemplateInfo.jdField_f_of_type_JavaLangString) >= 0)
        {
          paramSignatureTemplateInfo.jdField_b_of_type_JavaLangString = ((String)a(localJSONObject.has("name"), localJSONObject.getString("name"), HardCodeUtil.a(2131713985)));
          paramSignatureTemplateInfo.jdField_b_of_type_Int = ((Integer)a(localJSONObject.has("type"), Integer.valueOf(localJSONObject.getInt("type")), Integer.valueOf(-1))).intValue();
          paramSignatureTemplateInfo.jdField_a_of_type_Int = ((Integer)a(localJSONObject.has("feeType"), Integer.valueOf(localJSONObject.getInt("feeType")), Integer.valueOf(1))).intValue();
          paramSignatureTemplateInfo.jdField_c_of_type_JavaLangString = ((String)a(localJSONObject.has("actUrl"), localJSONObject.getString("actUrl"), null));
          paramSignatureTemplateInfo.jdField_c_of_type_Int = ((Integer)a(localJSONObject.has("newOrHot"), localJSONObject.getString("newOrHot"), Integer.valueOf(0))).intValue();
          paramSignatureTemplateInfo.jdField_d_of_type_Int = localJSONObject.getInt("platId");
          paramSignatureTemplateInfo.jdField_e_of_type_JavaLangString = ((String)a(localJSONObject.has("fontColor"), localJSONObject.getString("fontColor"), ""));
          a(paramSignatureTemplateInfo);
          paramSignatureTemplateInfo.n = ((String)a(localJSONObject.has("defText"), localJSONObject.getString("defText"), ""));
          paramSignatureTemplateInfo.o = ((String)a(localJSONObject.has("defTextColor"), localJSONObject.getString("defTextColor"), ""));
        }
      }
      try
      {
        Color.parseColor(paramSignatureTemplateInfo.o);
      }
      catch (Exception localException1)
      {
        label300:
        label343:
        break label300;
      }
      paramSignatureTemplateInfo.o = "";
      paramSignatureTemplateInfo.p = ((String)a(localJSONObject.has("timeAndLocation"), localJSONObject.getString("timeAndLocation"), ""));
      try
      {
        Color.parseColor(paramSignatureTemplateInfo.p);
      }
      catch (Exception localException2)
      {
        break label343;
      }
      paramSignatureTemplateInfo.p = "";
      paramSignatureTemplateInfo.jdField_e_of_type_Int = ((Integer)a(localJSONObject.has("isLimited"), localJSONObject.getString("isLimited"), Integer.valueOf(1))).intValue();
      paramSignatureTemplateInfo.q = ((String)a(localJSONObject.has("startTime"), localJSONObject.getString("startTime"), ""));
      paramSignatureTemplateInfo.r = ((String)a(localJSONObject.has("endTime"), localJSONObject.getString("endTime"), ""));
      paramSignatureTemplateInfo.s = ((String)a(localJSONObject.has("dot9png"), localJSONObject.getString("dot9png"), ""));
      paramSignatureTemplateInfo.t = ((String)a(localJSONObject.has("backgroundColor"), localJSONObject.getString("backgroundColor"), ""));
      b(paramSignatureTemplateInfo, localJSONObject);
      i += 1;
    }
  }
  
  private static void b(SignatureTemplateInfo paramSignatureTemplateInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("cover")) {
      paramSignatureTemplateInfo.jdField_d_of_type_JavaLangString = paramJSONObject.getString("cover");
    }
    if (paramJSONObject.has("aio_2")) {
      paramSignatureTemplateInfo.jdField_g_of_type_JavaLangString = paramJSONObject.getString("aio_2");
    }
    if (paramJSONObject.has("aio_3")) {
      paramSignatureTemplateInfo.h = paramJSONObject.getString("aio_3");
    }
    if (paramJSONObject.has("aio_4")) {
      paramSignatureTemplateInfo.i = paramJSONObject.getString("aio_4");
    }
    if (paramJSONObject.has("icon")) {
      paramSignatureTemplateInfo.j = paramJSONObject.getString("icon");
    }
    if (paramJSONObject.has("view")) {
      paramSignatureTemplateInfo.k = paramJSONObject.getString("view");
    }
    if (paramJSONObject.has("action_off")) {
      paramSignatureTemplateInfo.l = paramJSONObject.getString("action_off");
    }
    if (paramJSONObject.has("action_on")) {
      paramSignatureTemplateInfo.m = paramJSONObject.getString("action_on");
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
      localImageItem.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
      localImageItem.jdField_a_of_type_JavaLangString = paramJSONObject.optString("img");
      localImageItem.jdField_a_of_type_Int = paramJSONObject.optInt("imgWidth");
      localImageItem.jdField_b_of_type_Int = paramJSONObject.optInt("imgHeight");
      localImageItem.jdField_c_of_type_JavaLangString = paramJSONObject.optString("imgCover");
      paramSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem = localImageItem;
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
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_a_of_type_Int = j;
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_a_of_type_JavaLangString = paramJSONObject.optString("pngZip");
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("posX", 0.0D));
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_b_of_type_Float = ((float)paramJSONObject.optDouble("posY", 0.0D));
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_c_of_type_Float = ((float)paramJSONObject.optDouble("width", 0.0D));
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].d = ((float)paramJSONObject.optDouble("height", 0.0D));
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_b_of_type_Int = paramJSONObject.optInt("repeatTimes", 0);
      paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[i].jdField_c_of_type_Int = paramJSONObject.optInt("interval", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SignatureTemplateConfig
 * JD-Core Version:    0.7.0.1
 */