package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.controller.ResDownloadObject;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConstant;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MsgProcessPicImport
  extends MsgProcessImport
{
  public MsgProcessPicImport(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
  }
  
  public ResDownloadObject a()
  {
    MsgBackupResEntity localMsgBackupResEntity = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    ResDownloadObject localResDownloadObject = new ResDownloadObject();
    String str1 = b(localMsgBackupResEntity);
    boolean bool2 = false;
    if (str1 == null)
    {
      a("getResDownloadObject realPath is null");
      localResDownloadObject.jdField_a_of_type_Boolean = false;
      return localResDownloadObject;
    }
    String str2 = a(str1);
    boolean bool3 = a(str2);
    boolean bool4 = a(str1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResDownloadObject,entity:");
      localStringBuilder.append(localMsgBackupResEntity.toLogString());
      localStringBuilder.append(" tempPath:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" exist:");
      localStringBuilder.append(bool3);
      localStringBuilder.append(" realPath:");
      localStringBuilder.append(str1);
      localStringBuilder.append(" exist:");
      localStringBuilder.append(bool4);
      a(localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4) {
        bool1 = true;
      }
    }
    localResDownloadObject.jdField_a_of_type_Boolean = bool1;
    localResDownloadObject.jdField_a_of_type_JavaLangString = str2;
    return localResDownloadObject;
  }
  
  public String a()
  {
    String str = b(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity);
    if (TextUtils.isEmpty(str))
    {
      a("getTempPath realPath is null");
      return null;
    }
    return a(str);
  }
  
  public String a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
    String str2 = (String)this.jdField_a_of_type_JavaUtilMap.get("isOriginal");
    boolean bool;
    if (str2 != null) {
      bool = str2.equals("0") ^ true;
    } else {
      bool = true;
    }
    int i = paramMsgBackupResEntity.msgSubType;
    paramMsgBackupResEntity = "chatimg";
    if (i == 1)
    {
      if (bool) {
        paramMsgBackupResEntity = "chatraw";
      }
    }
    else if (i != 2)
    {
      if (i != 3) {
        break label127;
      }
      paramMsgBackupResEntity = "chatthumb";
    }
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        paramMsgBackupResEntity = AbsDownloader.getFilePath(new URL(paramMsgBackupResEntity, null, str1).toString());
        return paramMsgBackupResEntity;
      }
      catch (MalformedURLException paramMsgBackupResEntity)
      {
        paramMsgBackupResEntity.printStackTrace();
      }
    }
    label127:
    return null;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = paramString.substring(a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MsgBackupConstant.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String b()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity);
  }
  
  public String b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return a(paramMsgBackupResEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPicImport
 * JD-Core Version:    0.7.0.1
 */