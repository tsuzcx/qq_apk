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
  public static String b = VFSSourcePathConfig.c;
  private static final String c;
  private String d = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
  private String e = (String)this.jdField_a_of_type_JavaUtilMap.get("uuid");
  private String f = (String)this.jdField_a_of_type_JavaUtilMap.get("selfuin");
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("ptt");
    localStringBuilder.append(File.separator);
    c = RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public MsgProcessPttImport(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if (this.d == null) {
      this.d = "";
    }
    if (this.e == null) {
      this.e = "";
    }
    if (this.f == null) {
      this.f = "";
    }
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)))
    {
      paramMsgBackupResEntity = new StringBuilder();
      paramMsgBackupResEntity.append("md5:");
      paramMsgBackupResEntity.append(this.d);
      paramMsgBackupResEntity.append(" mUUID:");
      paramMsgBackupResEntity.append(this.e);
      paramMsgBackupResEntity.append(" mSelfuin:");
      paramMsgBackupResEntity.append(this.f);
      a(paramMsgBackupResEntity.toString());
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    return RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public ResDownloadObject a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    String str = a();
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
      a(localStringBuilder.toString());
    }
    localObject = new ResDownloadObject();
    ((ResDownloadObject)localObject).jdField_a_of_type_Boolean = (bool ^ true);
    ((ResDownloadObject)localObject).jdField_a_of_type_JavaLangString = str;
    return localObject;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return a(this.d, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPttImport
 * JD-Core Version:    0.7.0.1
 */