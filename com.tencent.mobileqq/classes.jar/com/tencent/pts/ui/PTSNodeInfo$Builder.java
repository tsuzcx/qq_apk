package com.tencent.pts.ui;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

public class PTSNodeInfo$Builder
{
  private PTSNodeAttribute attributes;
  private List<PTSNodeInfo> children;
  private String content;
  private boolean isRootNode;
  private String nodeType;
  private String parentID;
  private PTSNodeStyle style;
  private String uniqueID;
  
  private void check(PTSNodeInfo paramPTSNodeInfo)
  {
    if (PTSNodeInfo.access$000(paramPTSNodeInfo) == null) {
      PTSNodeInfo.access$002(paramPTSNodeInfo, new PTSNodeStyle());
    }
    if (PTSNodeInfo.access$100(paramPTSNodeInfo) == null) {
      PTSNodeInfo.access$102(paramPTSNodeInfo, new PTSNodeAttribute());
    }
  }
  
  public PTSNodeInfo build()
  {
    if ((TextUtils.isEmpty(this.nodeType)) || (TextUtils.isEmpty(this.uniqueID))) {
      throw new IllegalArgumentException("PTSNode info is wrong, there is no id or nodeType.");
    }
    PTSNodeInfo localPTSNodeInfo = new PTSNodeInfo(null);
    PTSNodeInfo.access$302(localPTSNodeInfo, this.nodeType);
    PTSNodeInfo.access$402(localPTSNodeInfo, this.uniqueID);
    PTSNodeInfo.access$502(localPTSNodeInfo, this.isRootNode);
    PTSNodeInfo.access$602(localPTSNodeInfo, this.parentID);
    PTSNodeInfo.access$702(localPTSNodeInfo, this.content);
    PTSNodeInfo.access$002(localPTSNodeInfo, this.style);
    PTSNodeInfo.access$102(localPTSNodeInfo, this.attributes);
    PTSNodeInfo.access$802(localPTSNodeInfo, this.children);
    check(localPTSNodeInfo);
    return localPTSNodeInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeInfo.Builder
 * JD-Core Version:    0.7.0.1
 */