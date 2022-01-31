package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GestureRecognitionUtils
{
  public static HashMap a;
  private static boolean a;
  public static String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject2 = (Drawable)((WeakReference)jdField_a_of_type_JavaUtilHashMap.get(paramString)).get();
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    if (paramString.equals("fivea")) {
      paramContext = paramContext.getResources().getDrawable(2130840222);
    }
    for (;;)
    {
      localObject2 = paramContext;
      if (paramContext == null) {
        break;
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString, new WeakReference(paramContext));
      return paramContext;
      if (paramString.equals("palmup"))
      {
        paramContext = paramContext.getResources().getDrawable(2130840223);
      }
      else if (paramString.equals("qheart"))
      {
        paramContext = paramContext.getResources().getDrawable(2130840224);
      }
      else
      {
        paramContext = localObject1;
        if (!paramString.equals("")) {
          paramContext = new BitmapDrawable(FileUtil.a(GestureUtil.a() + paramString + ".png"));
        }
      }
    }
  }
  
  public static TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    if ((!c()) || (!b())) {}
    for (int i = 1; i == 0; i = 0) {
      return paramTemplateGroupItem;
    }
    TemplateGroupItem localTemplateGroupItem = new TemplateGroupItem();
    localTemplateGroupItem.jdField_a_of_type_Int = paramTemplateGroupItem.jdField_a_of_type_Int;
    localTemplateGroupItem.jdField_a_of_type_JavaLangString = paramTemplateGroupItem.jdField_a_of_type_JavaLangString;
    localTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramTemplateGroupItem = paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
    if (i != 0) {
      while (paramTemplateGroupItem.hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramTemplateGroupItem.next();
        if (!localPtvTemplateInfo.hasGesture()) {
          localTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        }
      }
    }
    return localTemplateGroupItem;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    jdField_a_of_type_Boolean = paramBoolean;
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("GestureRecognitionUtils", 4).edit().putBoolean("shared_gesture_recognize_result", paramBoolean));
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("GestureRecognitionUtils", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b()
  {
    boolean bool = GestureMgr.a().a();
    if (!bool) {
      GestureMgr.a().b();
    }
    QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check gestureResource ready " + bool);
    return bool;
  }
  
  public static boolean c()
  {
    boolean bool1;
    if ((EffectsRenderController.a(8, 1400000L)) || (EffectsRenderController.a(4, 2150000L)))
    {
      bool1 = true;
      QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check condition 2 +cpuNumber is" + bool1);
      EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
      if ((localEffectFaceDeviceConfig == null) || (localEffectFaceDeviceConfig.b())) {
        break label196;
      }
    }
    label196:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (Build.VERSION.SDK_INT > 17) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        boolean bool4 = MediaCodecDPC.d();
        boolean bool5 = a();
        QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils isSupportGestureFilter faceFilterCheck: " + true + ";checkDeviceSupport:" + bool1 + ":inBlackLists:" + bool2 + ":isSDKEnable:" + bool3 + ":isNotInShortVideoBlackWhiteList:" + bool4 + ":isHardCodePhoneInBlackList" + bool5);
        if ((bool1) && (!bool2) && (bool3) && (bool4) && (!bool5))
        {
          return true;
          bool1 = false;
          break;
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils
 * JD-Core Version:    0.7.0.1
 */