package cooperation.qzone.mobilereport;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MobileReportManager$NewReportKey
{
  final String mAppId;
  final String mItemId;
  final String mItemType;
  final String mPageId;
  
  private MobileReportManager$NewReportKey(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mAppId = paramString1;
    this.mPageId = paramString2;
    this.mItemId = paramString3;
    this.mItemType = paramString4;
  }
  
  public static NewReportKey build(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    String str3 = paramAppInfo.buffer.get();
    boolean bool = TextUtils.isEmpty(str3);
    String str1 = "0";
    String str2 = "";
    paramAppInfo = str1;
    Object localObject = str2;
    if (!bool)
    {
      paramAppInfo = str1;
      try
      {
        localObject = new JSONObject(str3);
        paramAppInfo = str1;
        str1 = ((JSONObject)localObject).getString("ad_id");
        paramAppInfo = str1;
        localObject = ((JSONObject)localObject).getString("pos_id");
        paramAppInfo = str1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = str2;
      }
    }
    return new NewReportKey("vab_red", (String)localObject, paramAppInfo, "5");
  }
  
  public String buildTraceDetail()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appid", this.mAppId);
      ((JSONObject)localObject).put("page_id", this.mPageId);
      ((JSONObject)localObject).put("item_id", this.mItemId);
      ((JSONObject)localObject).put("item_type", this.mItemType);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((JSONObject)localObject).toString());
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse json exception ");
      localStringBuilder.append(localException);
      QLog.e("MobileReport.Manager", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportKey{appid=");
    localStringBuilder.append(this.mAppId);
    localStringBuilder.append(", pageId=");
    localStringBuilder.append(this.mPageId);
    localStringBuilder.append(", mItemId=");
    localStringBuilder.append(this.mItemId);
    localStringBuilder.append(", mItemType=");
    localStringBuilder.append(this.mItemType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.NewReportKey
 * JD-Core Version:    0.7.0.1
 */