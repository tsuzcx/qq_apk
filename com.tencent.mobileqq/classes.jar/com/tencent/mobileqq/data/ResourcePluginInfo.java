package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class ResourcePluginInfo
  extends Entity
{
  @notColumn
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
  @unique
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURL;
  public long timeStamp;
  public long uiCurVer;
  public long uiResId;
  
  public static ResourcePluginInfo find(EntityManager paramEntityManager, String paramString)
  {
    if ((paramEntityManager != null) && (paramString != null)) {
      return (ResourcePluginInfo)paramEntityManager.find(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramString });
    }
    return null;
  }
  
  public static List<ResourcePluginInfo> getAll(EntityManager paramEntityManager, int paramInt, boolean paramBoolean)
  {
    if (paramEntityManager != null)
    {
      if (paramBoolean) {
        return paramEntityManager.query(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, "cLocalState desc", null);
      }
      return paramEntityManager.query(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
    }
    return null;
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, ResourcePluginInfo paramResourcePluginInfo)
  {
    if ((paramEntityManager != null) && (paramResourcePluginInfo != null))
    {
      Object localObject = paramResourcePluginInfo.strPkgName;
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        localObject = (ResourcePluginInfo)paramEntityManager.find(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramResourcePluginInfo.strPkgName });
        if (localObject != null)
        {
          ((ResourcePluginInfo)localObject).strResName = paramResourcePluginInfo.strResName;
          ((ResourcePluginInfo)localObject).strResURL = paramResourcePluginInfo.strResURL;
          ((ResourcePluginInfo)localObject).uiCurVer = paramResourcePluginInfo.uiCurVer;
          ((ResourcePluginInfo)localObject).sLanType = paramResourcePluginInfo.sLanType;
          ((ResourcePluginInfo)localObject).sResSubType = paramResourcePluginInfo.sResSubType;
          ((ResourcePluginInfo)localObject).strGotoUrl = paramResourcePluginInfo.strGotoUrl;
          ((ResourcePluginInfo)localObject).sPriority = paramResourcePluginInfo.sPriority;
          ((ResourcePluginInfo)localObject).strResDesc = paramResourcePluginInfo.strResDesc;
          ((ResourcePluginInfo)localObject).cCanChangeState = paramResourcePluginInfo.cCanChangeState;
          ((ResourcePluginInfo)localObject).cDefaultState = paramResourcePluginInfo.cDefaultState;
          if (paramResourcePluginInfo.cDefaultState != ((ResourcePluginInfo)localObject).cDefaultState) {
            ((ResourcePluginInfo)localObject).cLocalState = paramResourcePluginInfo.cLocalState;
          }
          ((ResourcePluginInfo)localObject).isNew = paramResourcePluginInfo.isNew;
          ((ResourcePluginInfo)localObject).uiResId = paramResourcePluginInfo.uiResId;
          ((ResourcePluginInfo)localObject).iPluginType = paramResourcePluginInfo.iPluginType;
          ((ResourcePluginInfo)localObject).strNewPluginDesc = paramResourcePluginInfo.strNewPluginDesc;
          ((ResourcePluginInfo)localObject).strNewPluginURL = paramResourcePluginInfo.strNewPluginURL;
          ((ResourcePluginInfo)localObject).pluginSetTips = paramResourcePluginInfo.pluginSetTips;
          ((ResourcePluginInfo)localObject).lebaSearchResultType = paramResourcePluginInfo.lebaSearchResultType;
          ((ResourcePluginInfo)localObject).flags = paramResourcePluginInfo.flags;
          paramEntityManager.update((Entity)localObject);
          return;
        }
        paramEntityManager.persist(paramResourcePluginInfo);
      }
    }
  }
  
  public static void remove(EntityManager paramEntityManager, String paramString)
  {
    if ((paramEntityManager != null) && (paramString != null))
    {
      paramString = find(paramEntityManager, paramString);
      if (paramString != null) {
        paramEntityManager.remove(paramString);
      }
    }
  }
  
  public void disableFlag(int paramInt)
  {
    this.flags = ((paramInt ^ 0xFFFFFFFF) & this.flags);
  }
  
  public void enableFlag(int paramInt)
  {
    this.flags = (paramInt | this.flags);
  }
  
  public boolean isAllowFlag(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.strPkgName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strResName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strResURL);
    localStringBuilder.append("|");
    localStringBuilder.append(this.uiCurVer);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sLanType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strGotoUrl);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sResSubType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sPriority);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strResDesc);
    localStringBuilder.append("|");
    localStringBuilder.append(this.cDefaultState);
    localStringBuilder.append("|");
    localStringBuilder.append(this.cCanChangeState);
    localStringBuilder.append("|");
    localStringBuilder.append(this.uiResId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.cLocalState);
    localStringBuilder.append("|");
    localStringBuilder.append(this.flags);
    localStringBuilder.append("|");
    localStringBuilder.append(this.isNew);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ResourcePluginInfo
 * JD-Core Version:    0.7.0.1
 */