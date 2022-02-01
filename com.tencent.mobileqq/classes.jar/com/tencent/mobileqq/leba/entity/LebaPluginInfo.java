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
    if ((paramEntityManager != null) && (paramLong > 0L)) {
      return (LebaPluginInfo)paramEntityManager.find(LebaPluginInfo.class, "uiResId=?", new String[] { String.valueOf(paramLong) });
    }
    return null;
  }
  
  public static List<LebaPluginInfo> getAll(EntityManager paramEntityManager)
  {
    if (paramEntityManager != null) {
      paramEntityManager = paramEntityManager.query(LebaPluginInfo.class, false, "", null, null, null, null, null);
    } else {
      paramEntityManager = null;
    }
    Object localObject = paramEntityManager;
    if (paramEntityManager == null) {
      localObject = Collections.EMPTY_LIST;
    }
    return localObject;
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, LebaPluginInfo paramLebaPluginInfo)
  {
    if ((paramEntityManager != null) && (paramLebaPluginInfo != null))
    {
      long l = paramLebaPluginInfo.uiResId;
      if (l > 0L)
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramEntityManager.find(LebaPluginInfo.class, "uiResId=?", new String[] { String.valueOf(l) });
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
          return;
        }
        paramEntityManager.persist(paramLebaPluginInfo);
      }
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LebaPluginInfo：");
    localStringBuilder.append(this.uiResId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.state);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strPkgName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strResName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sResSeq);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sResSubType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.cCanChangeState);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sPriority);
    localStringBuilder.append("|");
    localStringBuilder.append(this.showInSimpleMode);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strResURL);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strGotoUrl);
    localStringBuilder.append("|");
    localStringBuilder.append(this.strGridIconUrl);
    localStringBuilder.append("|");
    localStringBuilder.append(this.resConf);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaPluginInfo
 * JD-Core Version:    0.7.0.1
 */