package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.controller.ResDownloadObject;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConstant;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.vfs.VFSSourcePathConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class MsgProcessPttImport
  extends MsgProcessImport
{
  public static String d = VFSSourcePathConfig.e;
  private static final String e;
  private String f = (String)this.b.get("md5");
  private String g = (String)this.b.get("uuid");
  private String h = (String)this.b.get("selfuin");
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.a);
    localStringBuilder.append("ptt");
    localStringBuilder.append(File.separator);
    e = RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public MsgProcessPttImport(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if (this.f == null) {
      this.f = "";
    }
    if (this.g == null) {
      this.g = "";
    }
    if (this.h == null) {
      this.h = "";
    }
    if ((TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.g)) || (TextUtils.isEmpty(this.h)))
    {
      paramMsgBackupResEntity = new StringBuilder();
      paramMsgBackupResEntity.append("md5:");
      paramMsgBackupResEntity.append(this.f);
      paramMsgBackupResEntity.append(" mUUID:");
      paramMsgBackupResEntity.append(this.g);
      paramMsgBackupResEntity.append(" mSelfuin:");
      paramMsgBackupResEntity.append(this.h);
      b(paramMsgBackupResEntity.toString());
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    return RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public ResDownloadObject b()
  {
    Object localObject = this.c;
    String str = c();
    boolean bool = a(str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResDownloadObject,entity:");
      localStringBuilder.append(((MsgBackupResEntity)localObject).toLogString());
      localStringBuilder.append(" tempPath:");
      localStringBuilder.append(str);
      localStringBuilder.append(" exist:");
      localStringBuilder.append(bool);
      b(localStringBuilder.toString());
    }
    localObject = new ResDownloadObject();
    ((ResDownloadObject)localObject).a = (bool ^ true);
    ((ResDownloadObject)localObject).b = str;
    return localObject;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(this.f);
    localStringBuilder.append(this.g);
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    return b(this.f, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPttImport
 * JD-Core Version:    0.7.0.1
 */