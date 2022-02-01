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
  private static final String b;
  private String c = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
  private String d = (String)this.jdField_a_of_type_JavaUtilMap.get("thumbMd5");
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    b = RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public MsgProcessVideoImport(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d)))
    {
      paramMsgBackupResEntity = new StringBuilder();
      paramMsgBackupResEntity.append("md5:");
      paramMsgBackupResEntity.append(this.c);
      paramMsgBackupResEntity.append(" mThumbMD5:");
      paramMsgBackupResEntity.append(this.d);
      a(paramMsgBackupResEntity.toString());
    }
  }
  
  public static String a(String paramString)
  {
    return SVUtils.a(paramString, "jpg");
  }
  
  public static String b(String paramString)
  {
    paramString = SVUtils.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("MsgBackUp");
    return localStringBuilder.toString();
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(b);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(b);
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public ResDownloadObject a()
  {
    MsgBackupResEntity localMsgBackupResEntity = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    int i = localMsgBackupResEntity.msgSubType;
    ResDownloadObject localResDownloadObject = new ResDownloadObject();
    String str1 = a();
    String str2 = b();
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
      a(localStringBuilder.toString());
    }
    localResDownloadObject.jdField_a_of_type_JavaLangString = str1;
    if ((!bool1) && (!bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localResDownloadObject.jdField_a_of_type_Boolean = bool1;
    return localResDownloadObject;
  }
  
  public String a()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity.msgSubType)
    {
    default: 
      return null;
    case 7: 
    case 8: 
    case 9: 
      return d(this.d);
    }
    return c(this.c);
  }
  
  public String b()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity.msgSubType)
    {
    default: 
      return null;
    case 7: 
    case 8: 
    case 9: 
      return a(this.d);
    }
    return b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessVideoImport
 * JD-Core Version:    0.7.0.1
 */