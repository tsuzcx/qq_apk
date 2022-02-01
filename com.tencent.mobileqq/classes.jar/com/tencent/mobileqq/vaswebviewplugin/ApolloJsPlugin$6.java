package com.tencent.mobileqq.vaswebviewplugin;

import amlo;
import amod;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filament.CmShowAssetsData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ApolloJsPlugin$6
  implements amod
{
  ApolloJsPlugin$6(ApolloJsPlugin paramApolloJsPlugin, Map paramMap, String paramString1, String paramString2) {}
  
  public void onGetApolloDressInfo(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    QLog.i("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] onGetApolloDressInfo: " + paramHashMap + ", errMsg: " + paramString);
    paramString = new CmShowAssetsData();
    if (paramHashMap != null)
    {
      Iterator localIterator = this.val$dressMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramString.dressResMap.put(localEntry.getValue(), paramHashMap.get(localEntry.getKey()));
      }
    }
    amlo.a(this.val$faceDataUrl, new ApolloJsPlugin.6.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */