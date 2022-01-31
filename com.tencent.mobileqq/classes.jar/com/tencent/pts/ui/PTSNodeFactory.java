package com.tencent.pts.ui;

import android.text.TextUtils;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeContainer.Builder;
import com.tencent.pts.ui.vnode.PTSNodeImage.Builder;
import com.tencent.pts.ui.vnode.PTSNodeSwiper.Builder;
import com.tencent.pts.ui.vnode.PTSNodeText.Builder;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.ui.vnode.PTSNodeVirtual.IBuilder;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PTSNodeFactory
{
  private static final String TAG = "PTSNodeFactory";
  private static HashMap<String, PTSNodeVirtual.IBuilder> sBuilders = new HashMap();
  
  static
  {
    registerNodeBuilder("view", new PTSNodeContainer.Builder());
    registerNodeBuilder("page", new PTSNodeContainer.Builder());
    registerNodeBuilder("block", new PTSNodeContainer.Builder());
    registerNodeBuilder("text", new PTSNodeText.Builder());
    registerNodeBuilder("img", new PTSNodeImage.Builder());
    registerNodeBuilder("swiper", new PTSNodeSwiper.Builder());
    registerNodeBuilder("swiper-item", new PTSNodeContainer.Builder());
  }
  
  private static void addToListMap(String paramString, PTSNodeVirtual paramPTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPTSNodeVirtual == null) || (paramHashMap == null)) {
      return;
    }
    List localList = (List)paramHashMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramHashMap.put(paramString, localObject);
    }
    ((List)localObject).add(paramPTSNodeVirtual);
  }
  
  public static PTSNodeVirtual bindData(PTSAppInstance paramPTSAppInstance, PTSNodeInfo paramPTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((paramPTSAppInstance == null) || (paramPTSNodeInfo == null) || (paramHashMap == null)) {
      return null;
    }
    hideAllNodeOfListMap(paramHashMap);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramPTSNodeInfo);
    paramPTSNodeInfo = null;
    label303:
    label305:
    for (;;)
    {
      PTSNodeInfo localPTSNodeInfo;
      Object localObject;
      PTSNodeVirtual localPTSNodeVirtual1;
      String str;
      Iterator localIterator;
      if (!localLinkedList.isEmpty())
      {
        localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
        localObject = getReusableNodeFromListMap(localPTSNodeInfo.getAttributes().getViewID(), paramHashMap);
        if (localObject == null)
        {
          localPTSNodeVirtual1 = buildVirtualNodeBFS(localPTSNodeInfo, paramPTSAppInstance, paramHashMap);
          if (localPTSNodeVirtual1 != null) {
            localPTSNodeVirtual1.bindNodeInfo(localPTSNodeInfo);
          }
          localObject = localPTSNodeVirtual1;
          if (localPTSNodeInfo.hasParent())
          {
            str = localPTSNodeInfo.getParentID();
            localIterator = paramHashMap.values().iterator();
          }
        }
      }
      for (;;)
      {
        localObject = localPTSNodeVirtual1;
        if (localIterator.hasNext())
        {
          localObject = (List)localIterator.next();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              PTSNodeVirtual localPTSNodeVirtual2 = (PTSNodeVirtual)((Iterator)localObject).next();
              if ((localPTSNodeVirtual2 != null) && (localPTSNodeVirtual2.getNodeInfo() != null) && (TextUtils.equals(localPTSNodeVirtual2.getNodeInfo().getUniqueID(), str))) {
                localPTSNodeVirtual2.addChild(localPTSNodeVirtual1);
              }
            }
          }
        }
        else
        {
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label303;
            }
            localObject = localPTSNodeVirtual1;
            label232:
            if (localPTSNodeInfo.isRootNode()) {
              paramPTSNodeInfo = (PTSNodeInfo)localObject;
            }
            for (;;)
            {
              if (localObject != null)
              {
                ((PTSNodeVirtual)localObject).showNode();
                ((PTSNodeVirtual)localObject).setReusable(false);
              }
              if (!localPTSNodeInfo.isContainer()) {
                break label305;
              }
              localLinkedList.addAll(localPTSNodeInfo.getChildren());
              break;
              ((PTSNodeVirtual)localObject).bindNodeInfo(localPTSNodeInfo);
              break label232;
              makeAllNodeReusableOfListMap(paramHashMap);
              return paramPTSNodeInfo;
            }
          }
        }
      }
    }
  }
  
  public static PTSNodeVirtual buildVirtualNode(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance)
  {
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNode, nodeInfo or appInstance is null.");
      return null;
    }
    String str = paramPTSNodeInfo.getNodeType();
    PTSNodeVirtual.IBuilder localIBuilder = (PTSNodeVirtual.IBuilder)sBuilders.get(str);
    if (localIBuilder != null)
    {
      PTSTimeCostUtil.start("[buildNode]-" + paramPTSNodeInfo.getUniqueID());
      paramPTSAppInstance = localIBuilder.build(paramPTSAppInstance);
      if (paramPTSAppInstance != null) {
        paramPTSAppInstance.setViewID(paramPTSNodeInfo.getAttributes().getViewID());
      }
      PTSTimeCostUtil.end("[buildNode]-" + paramPTSNodeInfo.getUniqueID());
      return paramPTSAppInstance;
    }
    throw new IllegalArgumentException("buildVirtualNode, the node type does not exist, type: " + str);
  }
  
  public static PTSNodeVirtual buildVirtualNodeBFS(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNodeBFS, nodeInfo or appInstance is null.");
      localObject = null;
    }
    HashMap localHashMap;
    LinkedList localLinkedList;
    do
    {
      return localObject;
      localHashMap = new HashMap();
      localLinkedList = new LinkedList();
      localLinkedList.add(paramPTSNodeInfo);
      paramPTSNodeInfo = null;
      localObject = paramPTSNodeInfo;
    } while (localLinkedList.isEmpty());
    PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
    PTSNodeVirtual localPTSNodeVirtual = buildVirtualNode(localPTSNodeInfo, paramPTSAppInstance);
    String str = localPTSNodeInfo.getAttributes().getViewID();
    Object localObject = paramPTSNodeInfo;
    if (paramPTSNodeInfo == null) {
      localObject = localPTSNodeVirtual;
    }
    if (localPTSNodeVirtual == null)
    {
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
      throw new IllegalArgumentException("[buildVirtualNodeBFS], currentNode is null.");
    }
    if (localPTSNodeInfo.hasParent())
    {
      paramPTSNodeInfo = (PTSNodeVirtual)localHashMap.get(localPTSNodeInfo.getParentID());
      if (paramPTSNodeInfo != null) {
        paramPTSNodeInfo.addChild(localPTSNodeVirtual);
      }
    }
    else
    {
      label147:
      localHashMap.put(localPTSNodeInfo.getUniqueID(), localPTSNodeVirtual);
      if (TextUtils.isEmpty(str)) {
        break label216;
      }
      if (paramHashMap != null) {
        addToListMap(str, localPTSNodeVirtual, paramHashMap);
      }
    }
    for (;;)
    {
      paramPTSNodeInfo = (PTSNodeInfo)localObject;
      if (!localPTSNodeInfo.isContainer()) {
        break;
      }
      localLinkedList.addAll(localPTSNodeInfo.getChildren());
      paramPTSNodeInfo = (PTSNodeInfo)localObject;
      break;
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], parentNode is null.");
      break label147;
      label216:
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentViewID is null.");
    }
  }
  
  private static PTSNodeVirtual getReusableNodeFromListMap(String paramString, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null)) {
      return null;
    }
    paramString = (List)paramHashMap.get(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {
      return null;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      paramHashMap = (PTSNodeVirtual)paramString.next();
      if ((paramHashMap != null) && (paramHashMap.getReusable())) {
        return paramHashMap;
      }
    }
    return null;
  }
  
  private static void hideAllNodeOfListMap(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.hideNode();
          }
        }
      }
    }
  }
  
  private static void makeAllNodeReusableOfListMap(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.setReusable(true);
          }
        }
      }
    }
  }
  
  public static void registerNodeBuilder(String paramString, PTSNodeVirtual.IBuilder paramIBuilder)
  {
    sBuilders.put(paramString, paramIBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeFactory
 * JD-Core Version:    0.7.0.1
 */