package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.Collections;
import java.util.List;

public class LebaPluginInfo
  extends Entity
{
  public static final int STATE_ADD = 3;
  public static final int STATE_DEL = 2;
  public static final int STATE_NONE = 0;
  public static final int STATE_UPDATE = 1;
  public int cCanChangeState;
  public byte cDataType;
  public String resConf;
  @notColumn
  public int sPriority;
  public int sResSeq;
  public short sResSubType;
  public int showInSimpleMode;
  @notColumn
  public int state = 0;
  public String strGotoUrl;
  public String strGridIconUrl;
  @Deprecated
  public String strPkgName;
  public String strResName;
  public String strResURL;
  @unique
  public long uiResId;
  
  public static LebaPluginInfo find(EntityManager paramEntityManager, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (paramLong > 0L) {
        localObject1 = (LebaPluginInfo)paramEntityManager.find(LebaPluginInfo.class, "uiResId=?", new String[] { String.valueOf(paramLong) });
      }
    }
    return localObject1;
  }
  
  public static List<LebaPluginInfo> getAll(EntityManager paramEntityManager)
  {
    if (paramEntityManager != null) {}
    for (paramEntityManager = paramEntityManager.query(LebaPluginInfo.class, false, "", null, null, null, null, null);; paramEntityManager = null)
    {
      Object localObject = paramEntityManager;
      if (paramEntityManager == null) {
        localObject = Collections.EMPTY_LIST;
      }
      return localObject;
    }
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, LebaPluginInfo paramLebaPluginInfo)
  {
    if ((paramEntityManager != null) && (paramLebaPluginInfo != null) && (paramLebaPluginInfo.uiResId > 0L))
    {
      LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramEntityManager.find(LebaPluginInfo.class, "uiResId=?", new String[] { String.valueOf(paramLebaPluginInfo.uiResId) });
      if (localLebaPluginInfo != null)
      {
        localLebaPluginInfo.sResSeq = paramLebaPluginInfo.sResSeq;
        localLebaPluginInfo.strPkgName = paramLebaPluginInfo.strPkgName;
        localLebaPluginInfo.strResName = paramLebaPluginInfo.strResName;
        localLebaPluginInfo.strResURL = paramLebaPluginInfo.strResURL;
        localLebaPluginInfo.sResSubType = paramLebaPluginInfo.sResSubType;
        localLebaPluginInfo.strGotoUrl = paramLebaPluginInfo.strGotoUrl;
        localLebaPluginInfo.cCanChangeState = paramLebaPluginInfo.cCanChangeState;
        localLebaPluginInfo.resConf = paramLebaPluginInfo.resConf;
        localLebaPluginInfo.cDataType = paramLebaPluginInfo.cDataType;
        localLebaPluginInfo.showInSimpleMode = paramLebaPluginInfo.showInSimpleMode;
        localLebaPluginInfo.strGridIconUrl = paramLebaPluginInfo.strGridIconUrl;
        paramEntityManager.update(localLebaPluginInfo);
      }
    }
    else
    {
      return;
    }
    paramEntityManager.persist(paramLebaPluginInfo);
  }
  
  public static void remove(EntityManager paramEntityManager, long paramLong)
  {
    if (paramEntityManager != null)
    {
      LebaPluginInfo localLebaPluginInfo = find(paramEntityManager, paramLong);
      if (localLebaPluginInfo != null) {
        paramEntityManager.remove(localLebaPluginInfo);
      }
    }
  }
  
  public String toString()
  {
    return "LebaPluginInfo：" + this.uiResId + "|" + this.state + "|" + this.strPkgName + "|" + this.strResName + "|" + this.sResSeq + "|" + this.sResSubType + "|" + this.cCanChangeState + "|" + this.sPriority + "|" + this.showInSimpleMode + "|" + this.strResURL + "|" + this.strGotoUrl + "|" + this.strGridIconUrl + "|" + this.resConf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaPluginInfo
 * JD-Core Version:    0.7.0.1
 */