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
    int j = 0;
    Object localObject1 = "0";
    Object localObject2 = "0";
    Object localObject4 = paramAppInfo.buffer.get();
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3 = localObject1;
    }
    for (;;)
    {
      try
      {
        localObject4 = new JSONObject((String)localObject4);
        localObject3 = localObject1;
        localObject1 = ((JSONObject)localObject4).getString("trace_id");
        localObject3 = localObject1;
        i = ((JSONObject)localObject4).getInt("trace_num");
        i += 1;
        int k;
        paramAppInfo.printStackTrace();
      }
      catch (Exception paramAppInfo)
      {
        try
        {
          localObject3 = ((JSONObject)localObject4).getString("ad_id");
          localObject2 = localObject3;
          k = paramAppInfo.uiAppId.get();
          j = k;
          localObject2 = localObject3;
          return new ReportKey((String)localObject1, i, (String)localObject2, j, "vab_red", "vab_red");
        }
        catch (Exception paramAppInfo)
        {
          break label123;
        }
        paramAppInfo = paramAppInfo;
        i = 0;
        localObject1 = localObject3;
      }
      label123:
      continue;
      int i = 0;
    }
  }
  
  public String buildTraceDetail()
  {
    return "trace_detail_ad_id=" + this.adId + "&trace_detail_app_id=" + this.appId;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ReportKey)paramObject;
    } while ((this.traceNum == paramObject.traceNum) && (this.traceId.equals(paramObject.traceId)) && (this.adId.equals(paramObject.adId)) && (this.appId == paramObject.appId) && (this.pageAppId.equals(paramObject.pageAppId)) && (this.pageId.equals(paramObject.pageId)) && (this.schemaUrl.equals(paramObject.schemaUrl)));
    return false;
  }
  
  public int hashCode()
  {
    return this.traceId.hashCode();
  }
  
  public String toString()
  {
    return "ReportKey{traceId='" + this.traceId + ", traceNum=" + this.traceNum + ", adId=" + this.adId + ", appId=" + this.appId + ", schemaUrl=" + this.schemaUrl + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.mobilereport.ReportKey
 * JD-Core Version:    0.7.0.1
 */