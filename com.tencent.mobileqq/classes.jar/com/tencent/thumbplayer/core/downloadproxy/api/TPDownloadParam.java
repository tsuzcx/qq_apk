package com.tencent.thumbplayer.core.downloadproxy.api;

import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class TPDownloadParam
{
  private static final String FILE_NAME = "TPDownloadParam";
  private int dlType;
  private Map<String, Object> extInfoMap;
  private ArrayList<String> urlList;
  
  public TPDownloadParam(ArrayList<String> paramArrayList, int paramInt, Map<String, Object> paramMap)
  {
    this.urlList = paramArrayList;
    this.dlType = paramInt;
    this.extInfoMap = paramMap;
  }
  
  private String getExtraFormatNodesJsonInfo(ArrayList<Map<String, Object>> paramArrayList)
  {
    if (paramArrayList == null) {
      return "[]";
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      try
      {
        localStringBuffer = new StringBuffer().append("[");
        i = 0;
        if (i < paramArrayList.size())
        {
          Map localMap = (Map)paramArrayList.get(i);
          if (i == paramArrayList.size() - 1) {
            localStringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          } else {
            localStringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          }
        }
      }
      catch (Throwable paramArrayList)
      {
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getExtraJsonInfo failed, error:" + paramArrayList.toString());
        return "[]";
      }
      localStringBuffer.append("]");
      paramArrayList = localStringBuffer.toString();
      return paramArrayList;
      i += 1;
    }
  }
  
  private String getUrlHostNodesJsonInfo(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return "[]";
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      try
      {
        localStringBuffer = new StringBuffer().append("[");
        i = 0;
        if (i < paramArrayList.size())
        {
          String str = (String)paramArrayList.get(i);
          if (i == paramArrayList.size() - 1) {
            localStringBuffer.append(String.format("\"%s\"", new Object[] { str }));
          } else {
            localStringBuffer.append(String.format("\"%s\", ", new Object[] { str }));
          }
        }
      }
      catch (Throwable paramArrayList)
      {
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getArrayListStr failed, error:" + paramArrayList.toString());
        return "[]";
      }
      localStringBuffer.append("]");
      paramArrayList = localStringBuffer.toString();
      return paramArrayList;
      i += 1;
    }
  }
  
  public String getCdnUrls()
  {
    int i = 0;
    if (this.urlList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool;
    if ((this.extInfoMap != null) && (this.extInfoMap.containsKey("dl_param_enable_expand_donwload_url"))) {
      bool = ((Boolean)this.extInfoMap.get("dl_param_enable_expand_donwload_url")).booleanValue();
    }
    for (;;)
    {
      if (i < this.urlList.size())
      {
        localStringBuffer.append((String)this.urlList.get(i));
        if (bool)
        {
          if (((String)this.urlList.get(i)).indexOf("?") <= 0) {
            break label130;
          }
          localStringBuffer.append("&cost=low");
        }
        for (;;)
        {
          localStringBuffer.append(";");
          i += 1;
          break;
          label130:
          localStringBuffer.append("?cost=low");
        }
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      return localStringBuffer.toString();
      bool = false;
    }
  }
  
  public int getClipCount()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_play_clip_count")) {
      return 1;
    }
    return ((Integer)this.extInfoMap.get("dl_param_play_clip_count")).intValue();
  }
  
  public int getClipNo()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_play_clip_no")) {
      return 1;
    }
    return ((Integer)this.extInfoMap.get("dl_param_play_clip_no")).intValue();
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public Object getExtInfo(String paramString)
  {
    if (this.extInfoMap == null) {
      return null;
    }
    return this.extInfoMap.get(paramString);
  }
  
  public Map<String, Object> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public String getExtraJsonInfo()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {
      return "";
    }
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.extInfoMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_is_offline")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_extra_info")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_definition")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_enable_expand_donwload_url"))) {
          localHashMap.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      str = new JSONObject(localThrowable).toString();
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", "getExtraJsonInfo failed, error:" + localThrowable.toString());
      return "";
    }
    String str;
    return str;
  }
  
  public String getFormat()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_current_format")) {
      return "";
    }
    return (String)this.extInfoMap.get("dl_param_current_format");
  }
  
  public String getKeyid()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_play_keyid")) {
      return "";
    }
    return (String)this.extInfoMap.get("dl_param_play_keyid");
  }
  
  public Map<String, String> getOfflinePlayExtraInfo()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_play_extra_info")) {
      return null;
    }
    return (Map)this.extInfoMap.get("dl_param_play_extra_info");
  }
  
  public String getPlayDefinition()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_play_definition")) {
      return "";
    }
    return (String)this.extInfoMap.get("dl_param_play_definition");
  }
  
  public String getSavaPath()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_save_path")) {
      return "";
    }
    return (String)this.extInfoMap.get("dl_param_save_path");
  }
  
  public long getTotalDurationMS()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_file_duration")) {
      return 0L;
    }
    return ((Long)this.extInfoMap.get("dl_param_file_duration")).longValue();
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_vid")) {
      return "";
    }
    return (String)this.extInfoMap.get("dl_param_vid");
  }
  
  public boolean isAdaptive()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {
      return false;
    }
    return (this.extInfoMap.containsKey("dl_param_adaptive_type")) && (((Integer)this.extInfoMap.get("dl_param_adaptive_type")).intValue() > 0);
  }
  
  public boolean isOffline()
  {
    if ((this.extInfoMap == null) || (this.extInfoMap.isEmpty())) {}
    while (!this.extInfoMap.containsKey("dl_param_is_offline")) {
      return false;
    }
    return ((Boolean)this.extInfoMap.get("dl_param_is_offline")).booleanValue();
  }
  
  public void setDlType(int paramInt)
  {
    this.dlType = paramInt;
  }
  
  public void setExtInfoMap(Map<String, Object> paramMap)
  {
    this.extInfoMap = paramMap;
  }
  
  public void setUrlList(ArrayList<String> paramArrayList)
  {
    this.urlList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam
 * JD-Core Version:    0.7.0.1
 */