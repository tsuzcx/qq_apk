package com.tencent.mobileqq.qassistant.core;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qassistant.wake.HelloQQHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoadManager
{
  private static String jdField_a_of_type_JavaLangString = "";
  public static final List<String> a;
  public static volatile AtomicBoolean a;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static String b;
  public static volatile AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "network_tip.mp3", "quit_voice_panel_tip.mp3", "voice_not_support_tip.mp3", "voice_not_understant_tip.mp3", "wake_default_tip.mp3" }));
    jdField_b_of_type_JavaLangString = "";
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static String a()
  {
    if ("".equals(jdField_b_of_type_JavaLangString)) {
      jdField_b_of_type_JavaLangString = AssistantUtils.a().getSharedPreferences("qq_assistant_sp_key", 0).getString("resAnimation", "animation1");
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a("voice", b()));
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/com.tencent.mobileqq/voiceAssistant/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static void a(List<String> paramList, String paramString, LoadManager.LoadCallBack paramLoadCallBack)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString != "") {}
    }
    else
    {
      str = "HelloQQWake";
    }
    if (!a(paramList)) {
      a("voice", b(), paramList, jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, str, paramLoadCallBack);
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    if (HelloQQHelper.a())
    {
      if (HelloQQHelper.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return false;
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return false;
      }
      if (a(a(), null))
      {
        if (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return false;
        }
        jdField_a_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(LoadManager.LoadCallBack paramLoadCallBack)
  {
    boolean bool = a();
    if (!bool)
    {
      a("wake", HelloQQHelper.a(), HelloQQHelper.jdField_a_of_type_JavaUtilList, HelloQQHelper.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, "HelloQQWake", paramLoadCallBack);
      a(jdField_a_of_type_JavaUtilList, "HelloQQWake", paramLoadCallBack);
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, List<String> paramList, AtomicBoolean paramAtomicBoolean, String paramString3, LoadManager.LoadCallBack paramLoadCallBack)
  {
    Object localObject = a(paramString1, paramString2);
    boolean bool = a((String)localObject, paramList);
    if (!bool)
    {
      AssistantUtils.a(paramString3, "loadRes hasRes no res");
      paramList = new StringBuilder();
      paramList.append((String)localObject);
      paramList.append(".zip");
      paramList = new File(paramList.toString());
      if ((!paramList.getParentFile().exists()) && (!paramList.getParentFile().mkdirs()))
      {
        paramString1 = new StringBuilder();
        paramString1.append("DownLoadZipFile  mkdirs failure：");
        paramString1.append(paramList.getPath());
        AssistantUtils.a(paramString3, paramString1.toString());
        return bool;
      }
      if (paramAtomicBoolean.compareAndSet(false, true))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://down.qq.com/helloqq/");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(".zip");
        ThreadManagerV2.excute(new LoadManager.1(paramString3, paramList, paramString1, paramAtomicBoolean, paramLoadCallBack, ((StringBuilder)localObject).toString()), 128, null, true);
        return bool;
      }
    }
    else
    {
      AssistantUtils.a("HelloQQWake", "loadRes hasRes no res");
    }
    return bool;
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    if (paramList == null) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/");
    paramString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramList);
        if (!new File(localStringBuilder.toString()).exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hasModel() not file :");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(paramList);
          AssistantUtils.a("HelloQQWake", ((StringBuilder)localObject).toString());
          return false;
        }
      }
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(List<String> paramList)
  {
    return a(a("voice", b()), paramList);
  }
  
  public static String b()
  {
    if ("".equals(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = AssistantUtils.a().getSharedPreferences("qq_assistant_sp_key", 0).getString("resVoice", "voice1");
    }
    return jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.LoadManager
 * JD-Core Version:    0.7.0.1
 */