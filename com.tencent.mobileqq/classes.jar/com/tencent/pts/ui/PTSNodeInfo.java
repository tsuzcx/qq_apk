package com.tencent.pts.ui;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PTSNodeInfo
{
  private final String TAG = "PTSNodeInfo";
  private PTSNodeAttribute attributes;
  private List<PTSNodeInfo> children;
  private String content;
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
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (this.children == null) {
      this.children = new ArrayList();
    }
    this.children.addAll(paramList);
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
    if (this.children == null) {
      return 0;
    }
    return this.children.size();
  }
  
  public List<PTSNodeInfo> getChildren()
  {
    if (this.children == null) {
      return new ArrayList();
    }
    return new ArrayList(this.children);
  }
  
  public String getContent()
  {
    return this.content;
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
    return (this.children != null) && (this.children.size() > 0);
  }
  
  public boolean hasParent()
  {
    return !TextUtils.isEmpty(this.parentID);
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
    if (this.children != null) {
      this.children.remove(paramPTSNodeInfo);
    }
  }
  
  public void setChild(int paramInt, PTSNodeInfo paramPTSNodeInfo)
  {
    if ((this.children == null) || (paramInt < 0) || (paramInt >= this.children.size())) {
      return;
    }
    this.children.set(paramInt, paramPTSNodeInfo);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PTSNodeInfo: \n").append("uniqueID: ").append(this.uniqueID).append("\n").append("nodeType: ").append(this.nodeType).append("\n").append("isRootNode: ").append(this.isRootNode).append("\n").append("parentID: ").append(this.parentID).append("\n").append("content: ").append(this.content).append("\n");
    localStringBuilder.append("\n").append("Styles: ").append("\n");
    Object localObject = this.style.entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("style [").append((String)localEntry.getKey()).append("] = ").append(localEntry.getValue()).append("\n");
    }
    localStringBuilder.append("\n").append("Attributes: ").append("\n");
    localObject = this.attributes.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("attribute [").append((String)localEntry.getKey()).append("] = ").append(localEntry.getValue()).append("\n");
    }
    if (hasChildren())
    {
      localStringBuilder.append("\n").append("child count = ").append(getChildCount()).append("\n");
      localStringBuilder.append("\n").append("Children: ").append("\n");
      localObject = getChildren();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localStringBuilder.append("child [").append(i).append("] = \n").append(((List)localObject).get(i)).append("\n");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeInfo
 * JD-Core Version:    0.7.0.1
 */