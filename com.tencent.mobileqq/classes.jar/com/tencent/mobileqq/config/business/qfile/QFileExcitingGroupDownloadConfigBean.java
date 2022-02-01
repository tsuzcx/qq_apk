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
  static boolean b = true;
  static boolean c = true;
  public String a = "";
  private long d = 20971520L;
  private boolean e = false;
  private ExcitingTransferDownloadConfig f = new ExcitingTransferDownloadConfig();
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.e = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      if (paramJSONObject != null)
      {
        if (paramJSONObject.has("oneslicesize")) {
          this.f.mSliceSize = paramJSONObject.getLong("oneslicesize");
        } else {
          this.f.mSliceSize = 524288L;
        }
        this.f.uMaxParrallelSlice = paramJSONObject.getInt("maxparrallelslice");
        this.f.uMaxWaitingSlice = paramJSONObject.getInt("maxtotalwaitingslice");
        this.f.uNotifyIntervals = paramJSONObject.getInt("notifyintervals");
        this.f.uSpeedDuration = paramJSONObject.getInt("speedduration");
        this.d = paramJSONObject.getInt("limitedsize");
        if (paramJSONObject.has("slicenum")) {
          this.f.uSliceNum = paramJSONObject.getInt("slicenum");
        } else {
          this.f.uSliceNum = 10;
        }
      }
      else
      {
        this.d = 20971520L;
        this.f = new ExcitingTransferDownloadConfig();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parse Exciting-Group-Download config: enable:");
      paramJSONObject.append(this.e);
      paramJSONObject.append(" LimitedSize:");
      paramJSONObject.append(this.d);
      paramJSONObject.append(" ");
      paramJSONObject.append(this.f.toString());
      QLog.i("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  private void d()
  {
    this.d = 20971520L;
    this.e = false;
    this.f = new ExcitingTransferDownloadConfig();
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
      QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
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
          QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
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
          d();
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
  
  public boolean b()
  {
    return this.e;
  }
  
  public ExcitingTransferDownloadConfig c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */