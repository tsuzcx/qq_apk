package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileExcitingGroupUploadConfigBean
  implements IQFileExcitingGroupUploadConfigBean, IQStorageSafable<String>
{
  static boolean b = false;
  static boolean c = true;
  public String a = "";
  private long d = 20971520L;
  private boolean e = false;
  private ExcitingTransferUploadChnConfigInfo f = new ExcitingTransferUploadChnConfigInfo();
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.e = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      if (paramJSONObject != null)
      {
        this.f.uMuliFileSizeLimit = paramJSONObject.getLong("mulifilesizelimit");
        this.f.uMaxChannelNum = paramJSONObject.getInt("maxchannelnum");
        this.f.uPieceSize = paramJSONObject.getInt("piecesize");
        this.f.nMaxEachHostTotalUseCount = paramJSONObject.getInt("maxeachhosttotalusecount");
        this.f.nMaxEachHostErrorCount = paramJSONObject.getInt("maxeachhosterrorcount");
        this.f.nMaxEachHostParallelUseCount = paramJSONObject.getInt("maxeachhostparallelusecount");
        this.f.nConnectTimeout = paramJSONObject.getLong("connecttimeout");
        this.f.nDataTimeout = paramJSONObject.getLong("datatimeout");
        this.f.nTotoalDataTimeout = paramJSONObject.getLong("totoaldatatimeout");
        this.d = paramJSONObject.getLong("limitedsize");
      }
      else
      {
        this.d = 20971520L;
        this.f = new ExcitingTransferUploadChnConfigInfo();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parse Exciting-Group-Upload config: enable:");
      paramJSONObject.append(this.e);
      paramJSONObject.append(" LimitedSize:");
      paramJSONObject.append(this.d);
      paramJSONObject.append(" ");
      paramJSONObject.append(this.f.toString());
      QLog.i("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  private void d()
  {
    this.d = 20971520L;
    this.e = false;
    this.f = new ExcitingTransferUploadChnConfigInfo();
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a(String paramString)
  {
    this.a = paramString.toLowerCase();
    if (TextUtils.isEmpty(this.a))
    {
      QLog.w("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
      d();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(this.a);
        if (paramString.length() == 0)
        {
          QLog.w("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
          d();
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
          localObject = paramString.optJSONObject((String)localObject).getJSONObject("upload");
          if (localObject == null) {
            break label166;
          }
          a((JSONObject)localObject);
          j = 1;
        }
        if (j == 0)
        {
          QLog.w("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "configContent no Exciting-Group-Upload config, use default value");
          d();
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
      }
      return;
      label166:
      i += 1;
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public ExcitingTransferUploadChnConfigInfo c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupUploadConfigBean
 * JD-Core Version:    0.7.0.1
 */