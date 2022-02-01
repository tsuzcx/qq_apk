package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.controller.ResDownloadObject;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConstant;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class MsgProcessVideoImport
  extends MsgProcessImport
{
  private static final String d;
  private String e = (String)this.b.get("md5");
  private String f = (String)this.b.get("thumbMd5");
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.a);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    d = RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public MsgProcessVideoImport(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if ((TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)))
    {
      paramMsgBackupResEntity = new StringBuilder();
      paramMsgBackupResEntity.append("md5:");
      paramMsgBackupResEntity.append(this.e);
      paramMsgBackupResEntity.append(" mThumbMD5:");
      paramMsgBackupResEntity.append(this.f);
      b(paramMsgBackupResEntity.toString());
    }
  }
  
  public static String d(String paramString)
  {
    return SVUtils.a(paramString, "jpg");
  }
  
  public static String e(String paramString)
  {
    paramString = SVUtils.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("MsgBackUp");
    return localStringBuilder.toString();
  }
  
  private String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(d);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(d);
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public ResDownloadObject b()
  {
    MsgBackupResEntity localMsgBackupResEntity = this.c;
    int i = localMsgBackupResEntity.msgSubType;
    ResDownloadObject localResDownloadObject = new ResDownloadObject();
    String str1 = c();
    String str2 = d();
    boolean bool1 = a(str1);
    boolean bool2 = a(str2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResDownloadObject,entity:");
      localStringBuilder.append(localMsgBackupResEntity.toLogString());
      localStringBuilder.append(" tempPath:");
      localStringBuilder.append(str1);
      localStringBuilder.append(" exist:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" realPath:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" exist:");
      localStringBuilder.append(bool2);
      b(localStringBuilder.toString());
    }
    localResDownloadObject.b = str1;
    if ((!bool1) && (!bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localResDownloadObject.a = bool1;
    return localResDownloadObject;
  }
  
  public String c()
  {
    switch (this.c.msgSubType)
    {
    default: 
      return null;
    case 7: 
    case 8: 
    case 9: 
      return g(this.f);
    }
    return f(this.e);
  }
  
  public String d()
  {
    switch (this.c.msgSubType)
    {
    default: 
      return null;
    case 7: 
    case 8: 
    case 9: 
      return d(this.f);
    }
    return e(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessVideoImport
 * JD-Core Version:    0.7.0.1
 */