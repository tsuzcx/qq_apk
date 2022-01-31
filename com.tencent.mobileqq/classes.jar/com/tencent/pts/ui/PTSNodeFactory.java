package com.tencent.pts.ui;

import android.os.Trace;
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
import java.util.HashMap;
import java.util.LinkedList;

public class PTSNodeFactory
{
  private static final String TAG = "PTSNodeFactory";
  private static HashMap<String, PTSNodeVirtual.IBuilder> sBuilders = new HashMap();
  private static HashMap<String, PTSNodeVirtual> sCacheNodes = new HashMap();
  
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
      Trace.beginSection("[buildNode]-" + str);
      PTSTimeCostUtil.start("[buildNode]-" + paramPTSNodeInfo.getUniqueID());
      paramPTSAppInstance = localIBuilder.build(paramPTSAppInstance);
      if (paramPTSAppInstance != null) {
        paramPTSAppInstance.setViewID(paramPTSNodeInfo.getAttributes().getViewID());
      }
      PTSTimeCostUtil.end("[buildNode]-" + paramPTSNodeInfo.getUniqueID());
      Trace.endSection();
      return paramPTSAppInstance;
    }
    throw new IllegalArgumentException("buildVirtualNode, the node type does not exist, type: " + str);
  }
  
  public static PTSNodeVirtual buildVirtualNodeBFS(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance, HashMap<String, PTSNodeVirtual> paramHashMap)
  {
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNodeBFS, nodeInfo or appInstance is null.");
      return null;
    }
    Trace.beginSection("[PTSNodeFactory]-buildVirtualNodeBFS");
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramPTSNodeInfo);
    Object localObject2 = null;
    if (!localLinkedList.isEmpty())
    {
      PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
      PTSNodeVirtual localPTSNodeVirtual = buildVirtualNode(localPTSNodeInfo, paramPTSAppInstance);
      String str = localPTSNodeInfo.getAttributes().getViewID();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localPTSNodeVirtual;
      }
      if (localPTSNodeVirtual == null)
      {
        PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
        throw new IllegalArgumentException("[buildVirtualNodeBFS], currentNode is null.");
      }
      if (localPTSNodeInfo.hasParent())
      {
        localObject2 = (PTSNodeVirtual)localHashMap.get(localPTSNodeInfo.getParentID());
        if (localObject2 == null) {
          break label222;
        }
        ((PTSNodeVirtual)localObject2).addChild(localPTSNodeVirtual);
      }
      for (;;)
      {
        localHashMap.put(localPTSNodeInfo.getUniqueID(), localPTSNodeVirtual);
        if (TextUtils.isEmpty(str)) {
          break label269;
        }
        if (paramHashMap == null) {
          break label241;
        }
        if (paramHashMap.get(str) == null) {
          break;
        }
        PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], two children have same viewID, nodeInfo = " + paramPTSNodeInfo);
        throw new IllegalArgumentException("same viewID child.");
        label222:
        PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], parentNode is null.");
      }
      paramHashMap.put(str, localPTSNodeVirtual);
      for (;;)
      {
        label241:
        localObject2 = localObject1;
        if (!localPTSNodeInfo.isContainer()) {
          break;
        }
        localLinkedList.addAll(localPTSNodeInfo.getChildren());
        localObject2 = localObject1;
        break;
        label269:
        PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentViewID is null.");
      }
    }
    Trace.endSection();
    return localObject2;
  }
  
  public static void clear()
  {
    sCacheNodes.clear();
  }
  
  public static <T extends PTSNodeVirtual> T getVirtualNode(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance)
  {
    String str = paramPTSNodeInfo.getNodeType();
    Object localObject = (PTSNodeVirtual)sCacheNodes.get(str);
    if (localObject != null)
    {
      ((PTSNodeVirtual)localObject).bindNodeInfo(paramPTSNodeInfo);
      return localObject;
    }
    localObject = (PTSNodeVirtual.IBuilder)sBuilders.get(str);
    if (localObject != null)
    {
      paramPTSAppInstance = ((PTSNodeVirtual.IBuilder)localObject).build(paramPTSAppInstance);
      paramPTSAppInstance.bindNodeInfo(paramPTSNodeInfo);
      sCacheNodes.put(str, paramPTSAppInstance);
      return paramPTSAppInstance;
    }
    throw new IllegalArgumentException("getVirtualNode, the node type does not exist, type: " + str);
  }
  
  public static void registerNodeBuilder(String paramString, PTSNodeVirtual.IBuilder paramIBuilder)
  {
    sBuilders.put(paramString, paramIBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeFactory
 * JD-Core Version:    0.7.0.1
 */