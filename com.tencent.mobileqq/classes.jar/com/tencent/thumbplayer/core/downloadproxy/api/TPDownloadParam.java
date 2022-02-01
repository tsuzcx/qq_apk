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
      int i;
      try
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("[");
        i = 0;
        if (i < paramArrayList.size())
        {
          Map localMap = (Map)paramArrayList.get(i);
          int j = paramArrayList.size();
          if (i == j - 1) {
            ((StringBuffer)localObject).append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          } else {
            ((StringBuffer)localObject).append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", new Object[] { localMap.get("dl_param_name"), localMap.get("dl_param_bitrate") }));
          }
        }
        else
        {
          ((StringBuffer)localObject).append("]");
          paramArrayList = ((StringBuffer)localObject).toString();
          return paramArrayList;
        }
      }
      catch (Throwable paramArrayList)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getExtraJsonInfo failed, error:");
        ((StringBuilder)localObject).append(paramArrayList.toString());
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", ((StringBuilder)localObject).toString());
        return "[]";
      }
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
      int i;
      try
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("[");
        i = 0;
        if (i < paramArrayList.size())
        {
          String str = (String)paramArrayList.get(i);
          if (i == paramArrayList.size() - 1) {
            ((StringBuffer)localObject).append(String.format("\"%s\"", new Object[] { str }));
          } else {
            ((StringBuffer)localObject).append(String.format("\"%s\", ", new Object[] { str }));
          }
        }
        else
        {
          ((StringBuffer)localObject).append("]");
          paramArrayList = ((StringBuffer)localObject).toString();
          return paramArrayList;
        }
      }
      catch (Throwable paramArrayList)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getArrayListStr failed, error:");
        ((StringBuilder)localObject).append(paramArrayList.toString());
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", ((StringBuilder)localObject).toString());
        return "[]";
      }
      i += 1;
    }
  }
  
  public String getCdnUrls()
  {
    if (this.urlList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Map localMap = this.extInfoMap;
    int i = 0;
    boolean bool;
    if ((localMap != null) && (localMap.containsKey("dl_param_enable_expand_donwload_url"))) {
      bool = ((Boolean)this.extInfoMap.get("dl_param_enable_expand_donwload_url")).booleanValue();
    } else {
      bool = false;
    }
    while (i < this.urlList.size())
    {
      localStringBuffer.append((String)this.urlList.get(i));
      if (bool) {
        if (((String)this.urlList.get(i)).indexOf("?") > 0) {
          localStringBuffer.append("&cost=low");
        } else {
          localStringBuffer.append("?cost=low");
        }
      }
      localStringBuffer.append(";");
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public int getClipCount()
  {
    Map localMap = this.extInfoMap;
    int j = 1;
    int i = j;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return 1;
      }
      i = j;
      if (this.extInfoMap.containsKey("dl_param_play_clip_count")) {
        i = ((Integer)this.extInfoMap.get("dl_param_play_clip_count")).intValue();
      }
    }
    return i;
  }
  
  public int getClipNo()
  {
    Map localMap = this.extInfoMap;
    int j = 1;
    int i = j;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return 1;
      }
      i = j;
      if (this.extInfoMap.containsKey("dl_param_play_clip_no")) {
        i = ((Integer)this.extInfoMap.get("dl_param_play_clip_no")).intValue();
      }
    }
    return i;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public Object getExtInfo(String paramString)
  {
    Map localMap = this.extInfoMap;
    if (localMap == null) {
      return null;
    }
    return localMap.get(paramString);
  }
  
  public Map<String, Object> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public String getExtraJsonInfo()
  {
    Object localObject1 = this.extInfoMap;
    if (localObject1 != null)
    {
      if (((Map)localObject1).isEmpty()) {
        return "";
      }
      try
      {
        localObject1 = new HashMap();
        localObject2 = this.extInfoMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          if ((!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_is_offline")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_extra_info")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_play_definition")) && (!((String)localEntry.getKey()).equalsIgnoreCase("dl_param_enable_expand_donwload_url"))) {
            ((Map)localObject1).put(localEntry.getKey(), localEntry.getValue());
          }
        }
        localObject1 = new JSONObject((Map)localObject1).toString();
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getExtraJsonInfo failed, error:");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadParam", 0, "tpdlnative", ((StringBuilder)localObject2).toString());
      }
    }
    return "";
  }
  
  public String getFormat()
  {
    Map localMap = this.extInfoMap;
    String str2 = "";
    String str1 = str2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return "";
      }
      str1 = str2;
      if (this.extInfoMap.containsKey("dl_param_current_format")) {
        str1 = (String)this.extInfoMap.get("dl_param_current_format");
      }
    }
    return str1;
  }
  
  public String getKeyid()
  {
    Map localMap = this.extInfoMap;
    String str2 = "";
    String str1 = str2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return "";
      }
      str1 = str2;
      if (this.extInfoMap.containsKey("dl_param_play_keyid")) {
        str1 = (String)this.extInfoMap.get("dl_param_play_keyid");
      }
    }
    return str1;
  }
  
  public Map<String, String> getOfflinePlayExtraInfo()
  {
    Map localMap = this.extInfoMap;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return null;
      }
      if (this.extInfoMap.containsKey("dl_param_play_extra_info")) {
        return (Map)this.extInfoMap.get("dl_param_play_extra_info");
      }
    }
    return null;
  }
  
  public String getPlayDefinition()
  {
    Map localMap = this.extInfoMap;
    String str2 = "";
    String str1 = str2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return "";
      }
      str1 = str2;
      if (this.extInfoMap.containsKey("dl_param_play_definition")) {
        str1 = (String)this.extInfoMap.get("dl_param_play_definition");
      }
    }
    return str1;
  }
  
  public String getSavaPath()
  {
    Map localMap = this.extInfoMap;
    String str2 = "";
    String str1 = str2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return "";
      }
      str1 = str2;
      if (this.extInfoMap.containsKey("dl_param_save_path")) {
        str1 = (String)this.extInfoMap.get("dl_param_save_path");
      }
    }
    return str1;
  }
  
  public long getTotalDurationMS()
  {
    Map localMap = this.extInfoMap;
    long l2 = 0L;
    long l1 = l2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return 0L;
      }
      l1 = l2;
      if (this.extInfoMap.containsKey("dl_param_file_duration")) {
        l1 = ((Long)this.extInfoMap.get("dl_param_file_duration")).longValue();
      }
    }
    return l1;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    Map localMap = this.extInfoMap;
    String str2 = "";
    String str1 = str2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return "";
      }
      str1 = str2;
      if (this.extInfoMap.containsKey("dl_param_vid")) {
        str1 = (String)this.extInfoMap.get("dl_param_vid");
      }
    }
    return str1;
  }
  
  public boolean isAdaptive()
  {
    Map localMap = this.extInfoMap;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return false;
      }
      bool1 = bool2;
      if (this.extInfoMap.containsKey("dl_param_adaptive_type"))
      {
        bool1 = bool2;
        if (((Integer)this.extInfoMap.get("dl_param_adaptive_type")).intValue() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isOffline()
  {
    Map localMap = this.extInfoMap;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return false;
      }
      bool1 = bool2;
      if (this.extInfoMap.containsKey("dl_param_is_offline")) {
        bool1 = ((Boolean)this.extInfoMap.get("dl_param_is_offline")).booleanValue();
      }
    }
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam
 * JD-Core Version:    0.7.0.1
 */