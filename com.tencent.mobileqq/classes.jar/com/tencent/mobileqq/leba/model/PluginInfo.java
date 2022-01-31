package com.tencent.mobileqq.leba.model;

import com.tencent.mobileqq.config.ConfigParser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import tencent.im.DynamicList.DynamicList.SubCmd_DynamicItem_Resp;

public class PluginInfo
  extends Entity
{
  public static final int STATE_ALL = 2;
  public static final int STATE_CLOSE = 0;
  public static final int STATE_OPEN = 1;
  public int isNew;
  public String jumpInfo;
  public int openFlag;
  public String pkgName;
  @unique
  public int pluginId;
  public String resBigUrl;
  public String resConfig;
  public String resDesc;
  public String resName;
  public String resSmallUrl;
  public String strDescIconUrl;
  public int type;
  public int uiCanChangeStatus;
  public int uiJumpType;
  public int version;
  public int weight;
  
  private static void convertConfigInfo(String paramString, PluginInfo paramPluginInfo)
  {
    paramString = ConfigParser.a(paramString);
    if (paramString != null)
    {
      String str = (String)paramString.get("newswitch");
      if (str != null) {}
      try
      {
        if ((byte)Integer.parseInt(str) == 0) {}
        for (paramPluginInfo.isNew = 1;; paramPluginInfo.isNew = 0)
        {
          label36:
          paramString = (String)paramString.get("pluginType");
          return;
        }
      }
      catch (Exception paramPluginInfo)
      {
        break label36;
      }
    }
    paramPluginInfo.isNew = 0;
  }
  
  public static PluginInfo covertFromResp(DynamicList.SubCmd_DynamicItem_Resp paramSubCmd_DynamicItem_Resp)
  {
    int j = -1;
    if (paramSubCmd_DynamicItem_Resp == null) {
      return null;
    }
    PluginInfo localPluginInfo = new PluginInfo();
    String str;
    int i;
    if (paramSubCmd_DynamicItem_Resp.strPkgName.has())
    {
      str = paramSubCmd_DynamicItem_Resp.strPkgName.get();
      localPluginInfo.pkgName = str;
      if (!paramSubCmd_DynamicItem_Resp.uiPluginID.has()) {
        break label398;
      }
      i = paramSubCmd_DynamicItem_Resp.uiPluginID.get();
      label59:
      localPluginInfo.pluginId = i;
      if (!paramSubCmd_DynamicItem_Resp.uiNewVer.has()) {
        break label403;
      }
      i = paramSubCmd_DynamicItem_Resp.uiNewVer.get();
      label83:
      localPluginInfo.version = i;
      if (!paramSubCmd_DynamicItem_Resp.uiType.has()) {
        break label408;
      }
      i = paramSubCmd_DynamicItem_Resp.uiType.get();
      label107:
      localPluginInfo.type = i;
      if (!paramSubCmd_DynamicItem_Resp.uiWeight.has()) {
        break label413;
      }
      i = paramSubCmd_DynamicItem_Resp.uiWeight.get();
      label131:
      localPluginInfo.weight = i;
      if (!paramSubCmd_DynamicItem_Resp.uiOpenFlag.has()) {
        break label418;
      }
      i = paramSubCmd_DynamicItem_Resp.uiOpenFlag.get();
      label155:
      localPluginInfo.openFlag = i;
      if (!paramSubCmd_DynamicItem_Resp.strResName.has()) {
        break label423;
      }
      str = paramSubCmd_DynamicItem_Resp.strResName.get();
      label179:
      localPluginInfo.resName = str;
      if (!paramSubCmd_DynamicItem_Resp.strResDesc.has()) {
        break label429;
      }
      str = paramSubCmd_DynamicItem_Resp.strResDesc.get();
      label203:
      localPluginInfo.resDesc = str;
      if (!paramSubCmd_DynamicItem_Resp.strResURL_big.has()) {
        break label435;
      }
      str = paramSubCmd_DynamicItem_Resp.strResURL_big.get();
      label227:
      localPluginInfo.resBigUrl = str;
      if (!paramSubCmd_DynamicItem_Resp.strResConf.has()) {
        break label441;
      }
      str = paramSubCmd_DynamicItem_Resp.strResConf.get();
      label251:
      localPluginInfo.resConfig = str;
      convertConfigInfo(localPluginInfo.resConfig, localPluginInfo);
      if (!paramSubCmd_DynamicItem_Resp.strJumpInfo.has()) {
        break label447;
      }
      str = paramSubCmd_DynamicItem_Resp.strJumpInfo.get();
      label285:
      localPluginInfo.jumpInfo = str;
      if (!paramSubCmd_DynamicItem_Resp.strResURL_small.has()) {
        break label453;
      }
      str = paramSubCmd_DynamicItem_Resp.strResURL_small.get();
      label309:
      localPluginInfo.resSmallUrl = str;
      if (!paramSubCmd_DynamicItem_Resp.uiJumpType.has()) {
        break label459;
      }
      i = paramSubCmd_DynamicItem_Resp.uiJumpType.get();
      label333:
      localPluginInfo.uiJumpType = i;
      i = j;
      if (paramSubCmd_DynamicItem_Resp.uiCanChangeStatus.has()) {
        i = paramSubCmd_DynamicItem_Resp.uiCanChangeStatus.get();
      }
      localPluginInfo.uiCanChangeStatus = i;
      if (!paramSubCmd_DynamicItem_Resp.strDescIconUrl.has()) {
        break label464;
      }
    }
    label398:
    label403:
    label408:
    label413:
    label418:
    label423:
    label429:
    label435:
    label441:
    label447:
    label453:
    label459:
    label464:
    for (paramSubCmd_DynamicItem_Resp = paramSubCmd_DynamicItem_Resp.strDescIconUrl.get();; paramSubCmd_DynamicItem_Resp = "")
    {
      localPluginInfo.strDescIconUrl = paramSubCmd_DynamicItem_Resp;
      return localPluginInfo;
      str = "";
      break;
      i = -1;
      break label59;
      i = -1;
      break label83;
      i = -1;
      break label107;
      i = -1;
      break label131;
      i = -1;
      break label155;
      str = "";
      break label179;
      str = "";
      break label203;
      str = "";
      break label227;
      str = "";
      break label251;
      str = "";
      break label285;
      str = "";
      break label309;
      i = -1;
      break label333;
    }
  }
  
  public static PluginInfo find(EntityManager paramEntityManager, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = (PluginInfo)paramEntityManager.a(PluginInfo.class, "pluginId=?", new String[] { String.valueOf(paramInt) });
      }
    }
    if (QLog.isDebugVersion()) {
      QLog.d("Q.lebanew", 4, "PluginInfo find " + localObject1);
    }
    return localObject1;
  }
  
  public static List getAll(EntityManager paramEntityManager, int paramInt)
  {
    if (paramInt != 2) {}
    for (paramEntityManager = paramEntityManager.a(PluginInfo.class, false, "openFlag=?", new String[] { String.valueOf(paramInt) }, null, null, "weight desc", null);; paramEntityManager = paramEntityManager.a(PluginInfo.class, false, "", new String[0], null, null, "weight desc", null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebanew", 4, "PluginInfo getAll:state:" + paramInt + "  pluginList:" + paramEntityManager);
      }
      return paramEntityManager;
    }
  }
  
  public static PluginInfo persistOrReplace(EntityManager paramEntityManager, PluginInfo paramPluginInfo)
  {
    if ((paramEntityManager != null) && (paramPluginInfo != null) && (paramPluginInfo.pluginId > 0))
    {
      PluginInfo localPluginInfo = find(paramEntityManager, paramPluginInfo.pluginId);
      if (localPluginInfo != null)
      {
        localPluginInfo.pkgName = paramPluginInfo.pkgName;
        localPluginInfo.version = paramPluginInfo.version;
        localPluginInfo.type = paramPluginInfo.type;
        localPluginInfo.weight = paramPluginInfo.weight;
        localPluginInfo.openFlag = paramPluginInfo.openFlag;
        localPluginInfo.resName = paramPluginInfo.resName;
        localPluginInfo.resDesc = paramPluginInfo.resDesc;
        localPluginInfo.resBigUrl = paramPluginInfo.resBigUrl;
        localPluginInfo.resSmallUrl = paramPluginInfo.resSmallUrl;
        localPluginInfo.resConfig = paramPluginInfo.resConfig;
        localPluginInfo.jumpInfo = paramPluginInfo.jumpInfo;
        localPluginInfo.uiJumpType = paramPluginInfo.uiJumpType;
        localPluginInfo.uiCanChangeStatus = paramPluginInfo.uiCanChangeStatus;
        paramEntityManager.a(localPluginInfo);
        paramPluginInfo = localPluginInfo;
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebanew", 4, "persistOrReplace:" + paramPluginInfo);
      }
      return paramPluginInfo;
      paramEntityManager.a(paramPluginInfo);
      continue;
      paramPluginInfo = null;
    }
  }
  
  public static boolean remove(EntityManager paramEntityManager, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEntityManager != null)
    {
      bool1 = bool2;
      if (paramInt > 0)
      {
        PluginInfo localPluginInfo = find(paramEntityManager, paramInt);
        bool1 = bool2;
        if (localPluginInfo != null) {
          bool1 = paramEntityManager.b(localPluginInfo);
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebanew", 4, "remove plugin:" + paramInt);
    }
    return bool1;
  }
  
  public boolean isAllowFlag(int paramInt)
  {
    return (this.openFlag & paramInt) == paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pkgName:").append(this.pkgName).append(",pluginId:").append(this.pluginId).append(",version:").append(this.version).append(",type:").append(this.type).append(",weight:").append(this.weight).append(",openFlag:").append(this.openFlag).append(",resName:").append(this.resName).append(",resDesc:").append(this.resDesc).append(",resBigUrl:").append(this.resBigUrl).append(",resSmallUrl").append(",resConfig:").append(this.resConfig).append("jumpInfo:").append(this.jumpInfo).append("uiJumpType:").append(this.uiJumpType).append("uiCanChangeStatus").append(this.uiCanChangeStatus).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.PluginInfo
 * JD-Core Version:    0.7.0.1
 */