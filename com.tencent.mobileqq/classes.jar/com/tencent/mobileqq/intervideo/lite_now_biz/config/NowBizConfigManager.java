package com.tencent.mobileqq.intervideo.lite_now_biz.config;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NowBizConfigManager
{
  private static Map<String, Boolean> a = new HashMap();
  private static List<String> b = new ArrayList();
  private static boolean h = false;
  private static NowBizConfigManager j = new NowBizConfigManager();
  private List<String> c = new ArrayList();
  private List<String> d = new ArrayList();
  private Map<String, String> e = new HashMap();
  private List<String> f = new ArrayList();
  private List<String> g = new ArrayList();
  private Bundle i = null;
  
  private NowBizConfigManager()
  {
    b();
  }
  
  public static NowBizConfigManager a()
  {
    return j;
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    Object localObject2 = paramBundle.getString("mqqschema");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramBundle.getString("mqqScheme");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = Uri.parse((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject1).getQueryParameter(paramString);
        break label51;
      }
    }
    localObject1 = "";
    label51:
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramBundle.getString(paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getValueFromBundle: bundle=");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      ((StringBuilder)localObject1).append(" name=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" value=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("NowBizConfigManager", 1, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void a(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  private void b()
  {
    this.c.addAll(Arrays.asList(NowBizConfigConst.a));
    this.d.addAll(Arrays.asList(NowBizConfigConst.b));
    b.addAll(Arrays.asList(NowBizConfigConst.c));
  }
  
  public static boolean b(String paramString)
  {
    if (b.contains(paramString)) {
      return ((Boolean)a.get("multi_voice")).booleanValue();
    }
    return h;
  }
  
  public static String c(Bundle paramBundle)
  {
    String str = a(paramBundle, "fromid");
    if (b.contains(str)) {
      return "multi_voice";
    }
    if ("10001".equals(a(paramBundle, "roomtype"))) {
      return "od";
    }
    return "live";
  }
  
  private void d(Bundle paramBundle)
  {
    this.i = paramBundle;
  }
  
  public boolean a(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean a(String paramString)
  {
    return b.contains(paramString);
  }
  
  public String b(Bundle paramBundle)
  {
    d(paramBundle);
    String str = a(paramBundle, "fromid");
    if (b.contains(str))
    {
      if ((a.containsKey("multi_voice")) && (((Boolean)a.get("multi_voice")).booleanValue())) {
        return "multi_voice";
      }
      return "";
    }
    paramBundle = a(paramBundle, "roomtype");
    if (!h) {
      return "";
    }
    if ("10001".equals(paramBundle)) {
      return "od";
    }
    return "live";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager
 * JD-Core Version:    0.7.0.1
 */