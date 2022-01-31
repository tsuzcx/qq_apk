package com.tencent.mobileqq.data;

import awge;
import awgf;
import awhp;
import awhs;
import java.util.List;

public class ResourcePluginInfo
  extends awge
{
  @awhp
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
  @awhs
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURL;
  public long timeStamp;
  public long uiCurVer;
  public long uiResId;
  
  public static ResourcePluginInfo find(awgf paramawgf, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramawgf != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (ResourcePluginInfo)paramawgf.a(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramString });
      }
    }
    return localObject1;
  }
  
  public static List<ResourcePluginInfo> getAll(awgf paramawgf, int paramInt, boolean paramBoolean)
  {
    List localList = null;
    if (paramawgf != null)
    {
      if (paramBoolean) {
        localList = paramawgf.a(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, "cLocalState desc", null);
      }
    }
    else {
      return localList;
    }
    return paramawgf.a(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  public static void persistOrReplace(awgf paramawgf, ResourcePluginInfo paramResourcePluginInfo)
  {
    if ((paramawgf != null) && (paramResourcePluginInfo != null) && (paramResourcePluginInfo.strPkgName != null) && (!paramResourcePluginInfo.strPkgName.equals("")))
    {
      ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramawgf.a(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramResourcePluginInfo.strPkgName });
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
        paramawgf.a(localResourcePluginInfo);
      }
    }
    else
    {
      return;
    }
    paramawgf.a(paramResourcePluginInfo);
  }
  
  public static void remove(awgf paramawgf, String paramString)
  {
    if ((paramawgf != null) && (paramString != null))
    {
      paramString = find(paramawgf, paramString);
      if (paramString != null) {
        paramawgf.b(paramString);
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