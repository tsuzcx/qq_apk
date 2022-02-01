package com.tencent.pts.ui;

import android.text.TextUtils;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class PTSNodeInfo$Builder
{
  private PTSNodeAttribute attributes = new PTSNodeAttribute();
  private List<PTSNodeInfo> children;
  private String content;
  private HashMap<String, String> eventInfo = new HashMap();
  private boolean isRootNode;
  private String nodeType;
  private String parentID;
  private PTSNodeStyle style = new PTSNodeStyle();
  private String uniqueID;
  
  private void check(PTSNodeInfo paramPTSNodeInfo)
  {
    if (PTSNodeInfo.access$000(paramPTSNodeInfo) == null) {
      PTSNodeInfo.access$002(paramPTSNodeInfo, new PTSNodeStyle());
    }
    if (PTSNodeInfo.access$100(paramPTSNodeInfo) == null) {
      PTSNodeInfo.access$102(paramPTSNodeInfo, new PTSNodeAttribute());
    }
    if (PTSNodeInfo.access$200(paramPTSNodeInfo) == null) {
      PTSNodeInfo.access$202(paramPTSNodeInfo, new HashMap());
    }
  }
  
  public PTSNodeInfo build()
  {
    if (TextUtils.isEmpty(this.nodeType))
    {
      PTSLog.e("PTSNodeInfo", "[build] PTSNodeInfo is not valid, nodeType is empty.");
      if (!PTSLog.isDebug()) {
        this.nodeType = "view";
      } else {
        throw new IllegalArgumentException("[build] PTSNodeInfo is not valid, nodeType is empty.");
      }
    }
    if (TextUtils.isEmpty(this.uniqueID))
    {
      PTSLog.e("PTSNodeInfo", "[build] PTSNodeInfo is not valid, id is empty.");
      if (!PTSLog.isDebug())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pts_uid_");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        this.uniqueID = ((StringBuilder)localObject).toString();
      }
      else
      {
        throw new IllegalArgumentException("[build] PTSNodeInfo is not valid, id is empty.");
      }
    }
    Object localObject = new PTSNodeInfo(null);
    PTSNodeInfo.access$402((PTSNodeInfo)localObject, this.nodeType);
    PTSNodeInfo.access$502((PTSNodeInfo)localObject, this.uniqueID);
    PTSNodeInfo.access$602((PTSNodeInfo)localObject, this.isRootNode);
    PTSNodeInfo.access$702((PTSNodeInfo)localObject, this.parentID);
    PTSNodeInfo.access$802((PTSNodeInfo)localObject, this.content);
    PTSNodeInfo.access$002((PTSNodeInfo)localObject, this.style);
    PTSNodeInfo.access$102((PTSNodeInfo)localObject, this.attributes);
    PTSNodeInfo.access$902((PTSNodeInfo)localObject, this.children);
    PTSNodeInfo.access$202((PTSNodeInfo)localObject, this.eventInfo);
    check((PTSNodeInfo)localObject);
    return localObject;
  }
  
  public Builder withChildren(List<PTSNodeInfo> paramList)
  {
    this.children = paramList;
    return this;
  }
  
  public Builder withContent(String paramString)
  {
    this.content = paramString;
    return this;
  }
  
  public Builder withEventInfo(HashMap<String, String> paramHashMap)
  {
    this.eventInfo = paramHashMap;
    return this;
  }
  
  public Builder withIsRootNode(boolean paramBoolean)
  {
    this.isRootNode = paramBoolean;
    return this;
  }
  
  public Builder withNodeType(String paramString)
  {
    this.nodeType = paramString;
    return this;
  }
  
  public Builder withPTSAttribute(PTSNodeAttribute paramPTSNodeAttribute)
  {
    this.attributes = new PTSNodeAttribute(paramPTSNodeAttribute);
    return this;
  }
  
  public Builder withPTSAttribute(JSONObject paramJSONObject)
  {
    this.attributes = new PTSNodeAttribute(paramJSONObject);
    return this;
  }
  
  public Builder withPTSStyle(PTSNodeStyle paramPTSNodeStyle)
  {
    this.style = new PTSNodeStyle(paramPTSNodeStyle);
    return this;
  }
  
  public Builder withPTSStyle(JSONObject paramJSONObject)
  {
    this.style = new PTSNodeStyle(paramJSONObject);
    return this;
  }
  
  public Builder withParentID(String paramString)
  {
    this.parentID = paramString;
    return this;
  }
  
  public Builder withUniqueID(String paramString)
  {
    this.uniqueID = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeInfo.Builder
 * JD-Core Version:    0.7.0.1
 */