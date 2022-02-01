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
  public boolean isTemp = false;
  private Map<String, String> mapReportInfo;
  public int mergenum = 0;
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
  public int tabletype = 0;
  public long time = 0L;
  public long toUin = 0L;
  private boolean useMapMode = false;
  
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
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(this.extraInfo)) {
      localJSONObject = new JSONObject(this.extraInfo);
    } else {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("touin", this.toUin);
    localJSONObject.put("network_type", String.valueOf(this.networkType));
    localJSONObject.put("tabletype", this.tabletype);
    Object localObject1;
    Object localObject2;
    if (this.useMapMode)
    {
      localObject1 = this.mapReportInfo;
      if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
      {
        localObject1 = this.mapReportInfo.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localJSONObject.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
      }
    }
    else
    {
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
      localObject1 = this.reservesExt;
      if (localObject1 != null)
      {
        int j = ((ArrayList)localObject1).size();
        int i = 0;
        while (i < j)
        {
          localObject1 = (String)this.reservesExt.get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reserves");
            ((StringBuilder)localObject2).append(i + 2);
            localJSONObject.put(((StringBuilder)localObject2).toString(), localObject1);
          }
          i += 1;
        }
      }
    }
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