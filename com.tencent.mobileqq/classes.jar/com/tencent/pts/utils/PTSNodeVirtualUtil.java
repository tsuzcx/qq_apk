package com.tencent.pts.utils;

import android.view.View;
import java.util.Map;

public class PTSNodeVirtualUtil
{
  public static final String TAG = "PTSNodeVirtualUtil";
  private static PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo sOnBindNodeInfo;
  private static PTSNodeVirtualUtil.INodeVirtualOnViewClick sOnViewClick;
  
  public static void onBindNodeInfoFinished(String paramString1, View paramView, String paramString2, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo localINodeVirtualOnBindNodeInfo = sOnBindNodeInfo;
    if (localINodeVirtualOnBindNodeInfo != null) {
      localINodeVirtualOnBindNodeInfo.onBindNodeInfoFinished(paramString1, paramView, paramString2, paramMap1, paramMap2);
    }
  }
  
  public static void onViewClicked(View paramView)
  {
    PTSNodeVirtualUtil.INodeVirtualOnViewClick localINodeVirtualOnViewClick = sOnViewClick;
    if (localINodeVirtualOnViewClick != null) {
      localINodeVirtualOnViewClick.onViewClicked(paramView);
    }
  }
  
  public static void register(PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo paramINodeVirtualOnBindNodeInfo, PTSNodeVirtualUtil.INodeVirtualOnViewClick paramINodeVirtualOnViewClick)
  {
    sOnBindNodeInfo = paramINodeVirtualOnBindNodeInfo;
    sOnViewClick = paramINodeVirtualOnViewClick;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSNodeVirtualUtil
 * JD-Core Version:    0.7.0.1
 */