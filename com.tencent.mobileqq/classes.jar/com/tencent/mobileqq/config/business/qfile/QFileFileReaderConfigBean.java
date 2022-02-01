package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileFileReaderConfigBean
  implements IQFileFileReaderConfigBean, IQStorageSafable<String>
{
  public static final String KEY_BAR_SHOW_SWITCH = "barShowSwitch";
  public static final String TAG = "QFileFileReaderConfigBean<QFile>";
  public boolean isShowReaderBar = false;
  public String strConfigContent = "{}";
  
  public boolean getIsShowReaderBar()
  {
    return this.isShowReaderBar;
  }
  
  public void onParse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileFileReaderConfigBean<QFile>", 1, "onParse: but configContent is null!");
    } else {
      this.strConfigContent = paramString;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("barShowSwitch"))
      {
        this.isShowReaderBar = paramString.getBoolean("barShowSwitch");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileFileReaderConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
  
  public void setIsShowReaderBar(boolean paramBoolean)
  {
    this.isShowReaderBar = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigBean
 * JD-Core Version:    0.7.0.1
 */