package com.tencent.mobileqq.download.unite.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadConfigBean
{
  @NonNull
  public List<String> a = new ArrayList();
  @NonNull
  public List<String> b = new ArrayList();
  public String c = HardCodeUtil.a(2131917738);
  public String d = HardCodeUtil.a(2131917735);
  public String e = HardCodeUtil.a(2131917737);
  public String f = HardCodeUtil.a(2131917736);
  public String g = HardCodeUtil.a(2131917734);
  public boolean h = true;
  
  public static DownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    DownloadConfigBean localDownloadConfigBean = new DownloadConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i].b;
        QLog.d("[UniteDownload] DownloadConfigBean", 2, new Object[] { "[config] parse: invoked. ", " content: ", localObject });
        try
        {
          localObject = new JSONObject((String)localObject);
          JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("BlackList");
          JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("WhiteList");
          localDownloadConfigBean.a = a(localJSONArray1);
          localDownloadConfigBean.b = a(localJSONArray2);
          localDownloadConfigBean.c = ((JSONObject)localObject).optString("DialogTitle", HardCodeUtil.a(2131917738));
          localDownloadConfigBean.d = ((JSONObject)localObject).optString("DialogContent", HardCodeUtil.a(2131917735));
          localDownloadConfigBean.f = ((JSONObject)localObject).optString("DialogDownloadButton", HardCodeUtil.a(2131917736));
          localDownloadConfigBean.g = ((JSONObject)localObject).optString("DialogCancelButton", HardCodeUtil.a(2131917734));
          localDownloadConfigBean.e = ((JSONObject)localObject).optString("DialogFeedbackButton", HardCodeUtil.a(2131917737));
          localDownloadConfigBean.h = ((JSONObject)localObject).optBoolean("EnableUniteDownloadDialog", true);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[UniteDownload] DownloadConfigBean", 1, localThrowable, new Object[0]);
        }
        i += 1;
      }
    }
    return localDownloadConfigBean;
  }
  
  private static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int j = paramJSONArray.length();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          localArrayList.add(paramJSONArray.getString(i));
          i += 1;
        }
        catch (JSONException paramJSONArray)
        {
          QLog.e("[UniteDownload] DownloadConfigBean", 1, "jsonArray2List error: ", paramJSONArray);
        }
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadConfigBean{blacklist=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", whitelist=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", dialogTitle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dialogContent='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dialogFeedbackButton='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dialogDownloadButton='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dialogCancelButton='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enableUniteDownloadDialog=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.config.DownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */