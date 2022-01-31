package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class TeamWorkUtils
{
  public static String a = ".doc|.docx|.xls|.xlsx|";
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_enable_assistant", paramBoolean);
    paramQQAppInterface = (TeamWorkHandler)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a = paramBoolean;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TeamWorkHandler)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      paramActivity.startActivity(new Intent(paramActivity, QQBrowserActivity.class).putExtra("url", paramActivity.getSharedPreferences("tim_convert_teamwork_pre_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("tim_myfile_teamwork_list_url", "https://docs.qq.com/desktop/m/index.html?_from=1")));
      return true;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com"))
      {
        bool1 = bool3;
        if (!paramString.contains("docx.qq.com")) {
          break label94;
        }
      }
    }
    try
    {
      paramString = new URL(paramString).getPath();
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
      {
        bool3 = paramString.equals("/login.html");
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = false;
      }
      label94:
      return bool1;
    }
    catch (Exception paramString)
    {
      QLog.e("docHome", 1, " detect docHome error: " + paramString.toString());
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1 != null)
        {
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
    }
    paramString1 = FileUtil.a(str);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.toLowerCase();
      bool1 = bool2;
      if (a.indexOf(paramString1) >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_preload_tool_process", paramBoolean);
    paramQQAppInterface = (TeamWorkHandler)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b = paramBoolean;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TeamWorkHandler)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils
 * JD-Core Version:    0.7.0.1
 */