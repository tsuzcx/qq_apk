package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileExcitingGroupDownloadConfigBean
  implements IQFileExcitingGroupDownloadConfigBean, IQStorageSafable<String>
{
  static boolean jdField_a_of_type_Boolean = true;
  static boolean b = true;
  private long jdField_a_of_type_Long = 20971520L;
  private ExcitingTransferDownloadConfig jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
  public String a;
  private boolean c = false;
  
  public QFileExcitingGroupDownloadConfigBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = 20971520L;
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.c = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      if (paramJSONObject != null)
      {
        if (paramJSONObject.has("oneslicesize")) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.mSliceSize = paramJSONObject.getLong("oneslicesize");
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.mSliceSize = 524288L;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxParrallelSlice = paramJSONObject.getInt("maxparrallelslice");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxWaitingSlice = paramJSONObject.getInt("maxtotalwaitingslice");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uNotifyIntervals = paramJSONObject.getInt("notifyintervals");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSpeedDuration = paramJSONObject.getInt("speedduration");
        this.jdField_a_of_type_Long = paramJSONObject.getInt("limitedsize");
        if (paramJSONObject.has("slicenum")) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSliceNum = paramJSONObject.getInt("slicenum");
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSliceNum = 10;
        }
      }
      else
      {
        this.jdField_a_of_type_Long = 20971520L;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parse Exciting-Group-Download config: enable:");
      paramJSONObject.append(this.c);
      paramJSONObject.append(" LimitedSize:");
      paramJSONObject.append(this.jdField_a_of_type_Long);
      paramJSONObject.append(" ");
      paramJSONObject.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.toString());
      QLog.i("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.toLowerCase();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
      a();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(this.jdField_a_of_type_JavaLangString);
        if (paramString.length() == 0)
        {
          QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
          a();
          return;
        }
        JSONArray localJSONArray = paramString.names();
        int k = 0;
        i = 0;
        int j = k;
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getString(i).trim();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label166;
          }
          localObject = paramString.optJSONObject((String)localObject).getJSONObject("download");
          if (localObject == null) {
            break label166;
          }
          a((JSONObject)localObject);
          j = 1;
        }
        if (j == 0)
        {
          QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent no Exciting-Group-Download config, use default value");
          a();
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
      }
      return;
      label166:
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */