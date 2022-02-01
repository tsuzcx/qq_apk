package cooperation.qzone;

import android.text.TextUtils;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QZoneClickReport$ReportInfo
{
  public String actionType = "";
  public String appId = "0";
  public String domain_type = "2";
  public String extraInfo = "";
  public String info = "";
  public boolean isTemp;
  private Map<String, String> mapReportInfo;
  public int mergenum;
  public int networkType = NetworkState.getNetworkType();
  public String pushstatkey = "";
  public String readSource = "0";
  public String referId = "";
  public String reserves = "";
  public String reserves10 = "";
  public ArrayList<String> reservesExt;
  public String sourceFrom = "";
  public String sourceTo = "";
  public String sourceType = "";
  public String subactionType = "";
  public int tabletype;
  public long time = System.currentTimeMillis();
  public long toUin;
  private boolean useMapMode;
  
  public QZoneClickReport$ReportInfo() {}
  
  public QZoneClickReport$ReportInfo(long paramLong, int paramInt, String paramString, Map<String, String> paramMap)
  {
    this();
    this.toUin = paramLong;
    this.appId = paramString;
    this.tabletype = paramInt;
    this.useMapMode = true;
    if (paramMap != null)
    {
      this.mapReportInfo = new HashMap();
      this.mapReportInfo.putAll(paramMap);
    }
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, ArrayList<String> paramArrayList)
  {
    this();
    this.toUin = paramLong;
    this.appId = paramString1;
    this.referId = paramString3;
    this.actionType = paramString4;
    this.subactionType = paramString5;
    this.tabletype = paramInt;
    this.reserves = paramString6;
    this.info = paramString2;
    this.reservesExt = paramArrayList;
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, String paramString, Map<String, String> paramMap)
  {
    this();
    this.toUin = paramLong;
    this.appId = paramString;
    this.useMapMode = true;
    if (paramMap != null)
    {
      this.mapReportInfo = new HashMap();
      this.mapReportInfo.putAll(paramMap);
    }
  }
  
  public QZoneClickReport$ReportInfo(String paramString)
  {
    this();
    this.readSource = paramString;
    this.actionType = "12";
  }
  
  public String getActionType()
  {
    return this.actionType;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public boolean getIsTemp()
  {
    return this.isTemp;
  }
  
  public String getReadSource()
  {
    return this.readSource;
  }
  
  public String getReferId()
  {
    return this.referId;
  }
  
  public String getReserves()
  {
    return this.reserves;
  }
  
  public String getSubactionType()
  {
    return this.subactionType;
  }
  
  public long getToUin()
  {
    return this.toUin;
  }
  
  public void setActionType(String paramString)
  {
    this.actionType = paramString;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setIsTemp(boolean paramBoolean)
  {
    this.isTemp = paramBoolean;
  }
  
  public void setReadSource(String paramString)
  {
    this.readSource = paramString;
  }
  
  public void setReferId(String paramString)
  {
    this.referId = paramString;
  }
  
  public void setReserves(String paramString)
  {
    this.reserves = paramString;
  }
  
  public void setSubactionType(String paramString)
  {
    this.subactionType = paramString;
  }
  
  public void setToUin(long paramLong)
  {
    this.toUin = paramLong;
  }
  
  public JSONObject toJSON()
  {
    if (!TextUtils.isEmpty(this.extraInfo)) {}
    Object localObject;
    for (JSONObject localJSONObject = new JSONObject(this.extraInfo);; localJSONObject = new JSONObject())
    {
      localJSONObject.put("touin", this.toUin);
      localJSONObject.put("network_type", String.valueOf(this.networkType));
      localJSONObject.put("tabletype", this.tabletype);
      if (!this.useMapMode) {
        break;
      }
      if ((this.mapReportInfo == null) || (this.mapReportInfo.isEmpty())) {
        break label366;
      }
      localObject = this.mapReportInfo.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    if (!localJSONObject.has("refer")) {
      localJSONObject.put("refer", this.referId);
    }
    localJSONObject.put("actiontype", this.actionType);
    localJSONObject.put("subactiontype", this.subactionType);
    localJSONObject.put("tabletype", this.tabletype);
    localJSONObject.put("domain_type", this.domain_type);
    localJSONObject.put("reserves", this.reserves);
    localJSONObject.put("source_type", this.sourceType);
    localJSONObject.put("source_from", this.sourceFrom);
    localJSONObject.put("source_to", this.sourceTo);
    localJSONObject.put("mergenum", this.mergenum);
    localJSONObject.put("reserves10", this.reserves10);
    if (this.reservesExt != null)
    {
      int j = this.reservesExt.size();
      int i = 0;
      while (i < j)
      {
        localObject = (String)this.reservesExt.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("reserves" + (i + 2), localObject);
        }
        i += 1;
      }
    }
    label366:
    localJSONObject.put("read_source", this.readSource);
    localJSONObject.put("time", String.valueOf(this.time));
    localJSONObject.put("info", this.info);
    localJSONObject.put("pushstatkey", this.pushstatkey);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport.ReportInfo
 * JD-Core Version:    0.7.0.1
 */