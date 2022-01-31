package com.tencent.mobileqq.data;

import awbv;
import awbw;
import awdg;
import awdj;
import java.util.List;

public class ResourcePluginInfo
  extends awbv
{
  @awdg
  public static final int MASK_FULL_CONFIG = 1;
  public static final int PLUGIN_TYPE_ABOUT = 32;
  public static final int PLUGIN_TYPE_LEBA = 64;
  public static final int PLUGIN_TYPE_NETWORK_PLUGIN = 128;
  public byte cCanChangeState;
  public byte cDataType;
  public byte cDefaultState;
  public byte cLocalState;
  public int flags;
  public int iPluginType = 64;
  public byte isNew;
  public int lebaSearchResultType;
  public String pluginBg;
  public String pluginSetTips;
  public short sLanType;
  public short sPriority;
  public short sResSubType;
  public String strGotoUrl;
  public String strNewPluginDesc;
  public String strNewPluginURL;
  @awdj
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURL;
  public long timeStamp;
  public long uiCurVer;
  public long uiResId;
  
  public static ResourcePluginInfo find(awbw paramawbw, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramawbw != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (ResourcePluginInfo)paramawbw.a(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramString });
      }
    }
    return localObject1;
  }
  
  public static List<ResourcePluginInfo> getAll(awbw paramawbw, int paramInt, boolean paramBoolean)
  {
    List localList = null;
    if (paramawbw != null)
    {
      if (paramBoolean) {
        localList = paramawbw.a(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, "cLocalState desc", null);
      }
    }
    else {
      return localList;
    }
    return paramawbw.a(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  public static void persistOrReplace(awbw paramawbw, ResourcePluginInfo paramResourcePluginInfo)
  {
    if ((paramawbw != null) && (paramResourcePluginInfo != null) && (paramResourcePluginInfo.strPkgName != null) && (!paramResourcePluginInfo.strPkgName.equals("")))
    {
      ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramawbw.a(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramResourcePluginInfo.strPkgName });
      if (localResourcePluginInfo != null)
      {
        localResourcePluginInfo.strResName = paramResourcePluginInfo.strResName;
        localResourcePluginInfo.strResURL = paramResourcePluginInfo.strResURL;
        localResourcePluginInfo.uiCurVer = paramResourcePluginInfo.uiCurVer;
        localResourcePluginInfo.sLanType = paramResourcePluginInfo.sLanType;
        localResourcePluginInfo.sResSubType = paramResourcePluginInfo.sResSubType;
        localResourcePluginInfo.strGotoUrl = paramResourcePluginInfo.strGotoUrl;
        localResourcePluginInfo.sPriority = paramResourcePluginInfo.sPriority;
        localResourcePluginInfo.strResDesc = paramResourcePluginInfo.strResDesc;
        localResourcePluginInfo.cCanChangeState = paramResourcePluginInfo.cCanChangeState;
        localResourcePluginInfo.cDefaultState = paramResourcePluginInfo.cDefaultState;
        if (paramResourcePluginInfo.cDefaultState != localResourcePluginInfo.cDefaultState) {
          localResourcePluginInfo.cLocalState = paramResourcePluginInfo.cLocalState;
        }
        localResourcePluginInfo.isNew = paramResourcePluginInfo.isNew;
        localResourcePluginInfo.uiResId = paramResourcePluginInfo.uiResId;
        localResourcePluginInfo.iPluginType = paramResourcePluginInfo.iPluginType;
        localResourcePluginInfo.strNewPluginDesc = paramResourcePluginInfo.strNewPluginDesc;
        localResourcePluginInfo.strNewPluginURL = paramResourcePluginInfo.strNewPluginURL;
        localResourcePluginInfo.pluginSetTips = paramResourcePluginInfo.pluginSetTips;
        localResourcePluginInfo.lebaSearchResultType = paramResourcePluginInfo.lebaSearchResultType;
        localResourcePluginInfo.flags = paramResourcePluginInfo.flags;
        paramawbw.a(localResourcePluginInfo);
      }
    }
    else
    {
      return;
    }
    paramawbw.a(paramResourcePluginInfo);
  }
  
  public static void remove(awbw paramawbw, String paramString)
  {
    if ((paramawbw != null) && (paramString != null))
    {
      paramString = find(paramawbw, paramString);
      if (paramString != null) {
        paramawbw.b(paramString);
      }
    }
  }
  
  public void disableFlag(int paramInt)
  {
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void enableFlag(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  public boolean isAllowFlag(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public String toString()
  {
    return this.strPkgName + "|" + this.strResName + "|" + this.strResURL + "|" + this.uiCurVer + "|" + this.sLanType + "|" + this.strGotoUrl + "|" + this.sResSubType + "|" + this.sPriority + "|" + this.strResDesc + "|" + this.cDefaultState + "|" + this.cCanChangeState + "|" + this.uiResId + "|" + this.cLocalState + "|" + this.flags;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ResourcePluginInfo
 * JD-Core Version:    0.7.0.1
 */