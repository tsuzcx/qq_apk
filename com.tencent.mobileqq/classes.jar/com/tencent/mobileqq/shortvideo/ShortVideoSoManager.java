package com.tencent.mobileqq.shortvideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;

class ShortVideoSoManager
{
  static ShortVideoSoManager.CfgParser a(String paramString)
  {
    return new ShortVideoSoManager.CfgParser(paramString);
  }
  
  @SuppressLint({"WrongConstant"})
  static String a()
  {
    return VideoEnvironment.getContext().getSharedPreferences("short_video_mgr_sp", 4).getString("sv_md5_version_soname_key", "d000_1");
  }
  
  static String a(File paramFile)
  {
    return FileUtils.a(paramFile);
  }
  
  static String a(String paramString)
  {
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[MD5.getFileMd5]md5=" + str1, null);
      String str3;
      if (str1 != null)
      {
        str3 = str1;
        if (!"".equals(str1)) {}
      }
      else
      {
        str3 = b(paramString);
      }
      return str3;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[MD5.getFileMd5] ", localUnsatisfiedLinkError);
        String str2 = b(paramString);
      }
    }
  }
  
  static final String a(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  @SuppressLint({"WrongConstant"})
  static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = VideoEnvironment.getContext().getSharedPreferences("short_video_mgr_sp", 4).edit();
    localEditor.putString("sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.LogDownLoad("ShortVideoSoManager.storeSoNewVersion saveAVCodecOK=" + bool, null);
    return bool;
  }
  
  static String b(String paramString)
  {
    try
    {
      paramString = MD5FileUtil.a(new File(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[getFileMD5String]", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoManager
 * JD-Core Version:    0.7.0.1
 */