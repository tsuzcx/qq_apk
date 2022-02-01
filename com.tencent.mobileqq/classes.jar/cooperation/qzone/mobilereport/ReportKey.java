package cooperation.qzone.mobilereport;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import org.json.JSONObject;

public class ReportKey
{
  final String adId;
  final int appId;
  final String pageAppId;
  final String pageId;
  final String schemaUrl;
  final String traceId;
  final int traceNum;
  
  public ReportKey(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.traceId = paramString1;
    this.traceNum = paramInt1;
    this.adId = paramString2;
    this.appId = paramInt2;
    this.pageAppId = paramString3;
    this.pageId = paramString4;
    this.schemaUrl = "";
  }
  
  public ReportKey(String paramString1, String paramString2)
  {
    this.appId = 0;
    this.schemaUrl = paramString2;
    this.traceId = "";
    this.traceNum = 0;
    this.adId = "";
    this.pageAppId = paramString1;
    this.pageId = "";
  }
  
  public static ReportKey build(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject2 = paramAppInfo.buffer.get();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    Object localObject1 = "0";
    int i;
    if (!bool)
    {
      try
      {
        Object localObject3 = new JSONObject((String)localObject2);
        localObject2 = ((JSONObject)localObject3).getString("trace_id");
        try
        {
          i = ((JSONObject)localObject3).getInt("trace_num");
          j = i + 1;
          try
          {
            localObject3 = ((JSONObject)localObject3).getString("ad_id");
            localObject1 = localObject3;
            i = paramAppInfo.uiAppId.get();
            paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject2;
            localObject1 = localObject3;
            k = i;
          }
          catch (Exception paramAppInfo)
          {
            i = j;
          }
          localObject3 = localObject2;
        }
        catch (Exception paramAppInfo)
        {
          i = 0;
        }
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      catch (Exception paramAppInfo)
      {
        localObject2 = "0";
        i = 0;
      }
      paramAppInfo.printStackTrace();
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      paramAppInfo = "0";
      localObject1 = paramAppInfo;
      i = 0;
    }
    int k = 0;
    int j = i;
    return new ReportKey(paramAppInfo, j, (String)localObject1, k, "vab_red", "vab_red");
  }
  
  public String buildTraceDetail()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trace_detail_ad_id=");
    localStringBuilder.append(this.adId);
    localStringBuilder.append("&trace_detail_app_id=");
    localStringBuilder.append(this.appId);
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ReportKey)paramObject;
      return (this.traceNum == paramObject.traceNum) && (this.traceId.equals(paramObject.traceId)) && (this.adId.equals(paramObject.adId)) && (this.appId == paramObject.appId) && (this.pageAppId.equals(paramObject.pageAppId)) && (this.pageId.equals(paramObject.pageId)) && (this.schemaUrl.equals(paramObject.schemaUrl));
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.traceId.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportKey{traceId='");
    localStringBuilder.append(this.traceId);
    localStringBuilder.append(", traceNum=");
    localStringBuilder.append(this.traceNum);
    localStringBuilder.append(", adId=");
    localStringBuilder.append(this.adId);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", schemaUrl=");
    localStringBuilder.append(this.schemaUrl);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.mobilereport.ReportKey
 * JD-Core Version:    0.7.0.1
 */