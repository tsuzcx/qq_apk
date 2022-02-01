package com.tencent.pts.ui;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PTSNodeInfo
{
  private static final String TAG = "PTSNodeInfo";
  private PTSNodeAttribute attributes;
  private List<PTSNodeInfo> children;
  private String content;
  private HashMap<String, String> eventInfo;
  private boolean isRootNode;
  private String nodeType;
  private String parentID;
  private PTSNodeStyle style;
  private String uniqueID;
  
  public void addChild(int paramInt, PTSNodeInfo paramPTSNodeInfo)
  {
    if (this.children == null) {
      this.children = new ArrayList();
    }
    if ((paramInt >= 0) && (paramInt < this.children.size()))
    {
      this.children.add(paramInt, paramPTSNodeInfo);
      return;
    }
    this.children.add(paramPTSNodeInfo);
  }
  
  public void addChild(PTSNodeInfo paramPTSNodeInfo)
  {
    if (this.children == null) {
      this.children = new ArrayList();
    }
    this.children.add(paramPTSNodeInfo);
  }
  
  public void addChildren(List<PTSNodeInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (this.children == null) {
        this.children = new ArrayList();
      }
      this.children.addAll(paramList);
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof PTSNodeInfo)) {
      return TextUtils.equals(this.uniqueID, ((PTSNodeInfo)paramObject).getUniqueID());
    }
    return false;
  }
  
  public PTSNodeAttribute getAttributes()
  {
    return this.attributes;
  }
  
  public int getChildCount()
  {
    List localList = this.children;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public List<PTSNodeInfo> getChildren()
  {
    List localList = this.children;
    if (localList == null) {
      return new ArrayList();
    }
    return new ArrayList(localList);
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public HashMap<String, String> getEventInfo()
  {
    return this.eventInfo;
  }
  
  public String getNodeType()
  {
    return this.nodeType;
  }
  
  public String getParentID()
  {
    return this.parentID;
  }
  
  public PTSNodeStyle getStyle()
  {
    return this.style;
  }
  
  public String getUniqueID()
  {
    return this.uniqueID;
  }
  
  public boolean hasChildren()
  {
    List localList = this.children;
    return (localList != null) && (localList.size() > 0);
  }
  
  public boolean hasParent()
  {
    return TextUtils.isEmpty(this.parentID) ^ true;
  }
  
  public boolean isContainer()
  {
    return ("view".equals(this.nodeType)) || ("page".equals(this.nodeType)) || ("block".equals(this.nodeType)) || ("swiper-item".equals(this.nodeType));
  }
  
  public boolean isRootNode()
  {
    return this.isRootNode;
  }
  
  public void removeChild(PTSNodeInfo paramPTSNodeInfo)
  {
    List localList = this.children;
    if (localList != null) {
      localList.remove(paramPTSNodeInfo);
    }
  }
  
  public void setChild(int paramInt, PTSNodeInfo paramPTSNodeInfo)
  {
    List localList = this.children;
    if ((localList != null) && (paramInt >= 0))
    {
      if (paramInt >= localList.size()) {
        return;
      }
      this.children.set(paramInt, paramPTSNodeInfo);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PTSNodeInfo: \n");
    localStringBuilder.append("uniqueID: ");
    localStringBuilder.append(this.uniqueID);
    localStringBuilder.append("\n");
    localStringBuilder.append("nodeType: ");
    localStringBuilder.append(this.nodeType);
    localStringBuilder.append("\n");
    localStringBuilder.append("isRootNode: ");
    localStringBuilder.append(this.isRootNode);
    localStringBuilder.append("\n");
    localStringBuilder.append("parentID: ");
    localStringBuilder.append(this.parentID);
    localStringBuilder.append("\n");
    localStringBuilder.append("content: ");
    localStringBuilder.append(this.content);
    localStringBuilder.append("\n");
    localStringBuilder.append("\n");
    localStringBuilder.append("Styles: ");
    localStringBuilder.append("\n");
    Object localObject = this.style.entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("style [");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("] = ");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n");
    localStringBuilder.append("Attributes: ");
    localStringBuilder.append("\n");
    localObject = this.attributes.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("attribute [");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("] = ");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n");
    localStringBuilder.append("EventInfo: ");
    localStringBuilder.append("\n");
    localObject = this.eventInfo.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("eventInfo [");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("] = ");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("\n");
    }
    if (hasChildren())
    {
      localStringBuilder.append("\n");
      localStringBuilder.append("child count = ");
      localStringBuilder.append(getChildCount());
      localStringBuilder.append("\n");
      localStringBuilder.append("\n");
      localStringBuilder.append("Children: ");
      localStringBuilder.append("\n");
      localObject = getChildren();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localStringBuilder.append("child [");
        localStringBuilder.append(i);
        localStringBuilder.append("] = \n");
        localStringBuilder.append(((List)localObject).get(i));
        localStringBuilder.append("\n");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeInfo
 * JD-Core Version:    0.7.0.1
 */