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
    return FileUtils.readFileContent(paramFile);
  }
  
  static String a(String paramString)
  {
    Object localObject;
    String str2;
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShortVideoSoManager:computeMd5[MD5.getFileMd5]md5=");
      ((StringBuilder)localObject).append(str1);
      VideoEnvironment.LogDownLoad(((StringBuilder)localObject).toString(), null);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[MD5.getFileMd5] ", localUnsatisfiedLinkError);
      str2 = b(paramString);
    }
    if (str2 != null)
    {
      localObject = str2;
      if (!"".equals(str2)) {}
    }
    else
    {
      localObject = b(paramString);
    }
    return localObject;
  }
  
  static final String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('_');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"WrongConstant"})
  static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = VideoEnvironment.getContext().getSharedPreferences("short_video_mgr_sp", 4).edit();
    localEditor.putString("sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    paramString = new StringBuilder();
    paramString.append("ShortVideoSoManager.storeSoNewVersion saveAVCodecOK=");
    paramString.append(bool);
    VideoEnvironment.LogDownLoad(paramString.toString(), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoManager
 * JD-Core Version:    0.7.0.1
 */