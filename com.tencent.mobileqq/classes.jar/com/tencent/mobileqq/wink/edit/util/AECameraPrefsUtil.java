package com.tencent.mobileqq.wink.edit.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AECameraPrefsUtil
{
  public static String a = "ShadowBackendSvc.GetCategoryMaterialMqStoryCamera";
  public static String b = "ShadowBackendSvc.GetCategoryMaterialMqEmoCamera";
  public static String c = "ShadowBackendSvc.GetPlayShowCatMatTree";
  public static String d = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanEdit";
  public static String e = "key_app_version";
  public static String f = "key_first_change_face_click_flag";
  public static String g = "key_kuolie_sitck_bubble";
  public static String h = "key_kuolie_sitck_bubble_panel";
  public static String i = "key_peak_activity_crash_entryinfo";
  public static String j = "key_peak_activity_crash_pathinfo";
  public static String k = "key_ae_editor_record";
  public static String l = "key_ae_editor_files";
  public static String m = "key_ae_editor_record_type";
  public static String n = "key_ae_editor_record_data";
  public static String o = "key_ae_editor_record_mid_data";
  public static String p = "key_ae_arcake_id";
  public static String q = "key_ae_arcake_nick";
  public static String r = "key_ae_arcake_preview";
  public static String s = "key_ae_arcake_touin";
  public static String t = "key_eidt_medialmodel_";
  public static String u = "key_editor_switch_mode_dialog";
  private static final List<Pair<String, Integer>> v = new LinkedList();
  
  static
  {
    v.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    List localList = v;
    String str = a;
    Integer localInteger = Integer.valueOf(4);
    localList.add(new Pair(str, localInteger));
    v.add(new Pair(b, localInteger));
    v.add(new Pair(c, localInteger));
  }
  
  private AECameraPrefsUtil()
  {
    Object localObject = AECameraPrefsUtil.MultiProcessPreferences.b(e, "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.b().equals(localObject)))
    {
      localObject = v.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          AECameraPrefsUtil.MultiProcessPreferences.a((String)localPair.first);
        } else {
          AECameraPrefsUtil.DefaultPreferences.a((String)localPair.first);
        }
      }
      AECameraPrefsUtil.MultiProcessPreferences.a(e, AppSetting.b());
    }
  }
  
  public static AECameraPrefsUtil a()
  {
    return AECameraPrefsUtil.UtilInstanceHolder.a();
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString1, paramString2);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString, paramBoolean);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString, paramBoolean);
  }
  
  @Nullable
  public String b(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString1, paramString2);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString1, paramString2);
  }
  
  public boolean b(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString, paramBoolean);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil
 * JD-Core Version:    0.7.0.1
 */