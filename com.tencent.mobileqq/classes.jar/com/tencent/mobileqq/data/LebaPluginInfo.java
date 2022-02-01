package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import tencent.im.PluginConfig.PluginConfig.GetResourceRespInfo;

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
  
  public static LebaPluginInfo convToLocalPluginInfo(PluginConfig.GetResourceRespInfo paramGetResourceRespInfo)
  {
    int j = 0;
    if (paramGetResourceRespInfo == null) {
      return null;
    }
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    long l;
    int i;
    label62:
    label86:
    label111:
    short s;
    if (paramGetResourceRespInfo.res_id.has())
    {
      l = paramGetResourceRespInfo.res_id.get();
      localLebaPluginInfo.uiResId = l;
      if (!paramGetResourceRespInfo.state.has()) {
        break label375;
      }
      i = paramGetResourceRespInfo.state.get();
      localLebaPluginInfo.state = i;
      if (!paramGetResourceRespInfo.res_seq.has()) {
        break label380;
      }
      i = paramGetResourceRespInfo.res_seq.get();
      localLebaPluginInfo.sResSeq = i;
      if (!paramGetResourceRespInfo.pkg_name.has()) {
        break label385;
      }
      str = paramGetResourceRespInfo.pkg_name.get();
      localLebaPluginInfo.strPkgName = str;
      if (!paramGetResourceRespInfo.res_name.has()) {
        break label392;
      }
      str = paramGetResourceRespInfo.res_name.get();
      label137:
      localLebaPluginInfo.strResName = str;
      if (!paramGetResourceRespInfo.icon_url.has()) {
        break label399;
      }
      str = paramGetResourceRespInfo.icon_url.get();
      label163:
      localLebaPluginInfo.strResURL = str;
      if (!paramGetResourceRespInfo.sub_type.has()) {
        break label406;
      }
      s = (short)paramGetResourceRespInfo.sub_type.get();
      label189:
      localLebaPluginInfo.sResSubType = s;
      if (!paramGetResourceRespInfo.jump_url.has()) {
        break label411;
      }
      str = paramGetResourceRespInfo.jump_url.get();
      label214:
      localLebaPluginInfo.strGotoUrl = str;
      if (!paramGetResourceRespInfo.can_change_state.has()) {
        break label418;
      }
      i = paramGetResourceRespInfo.can_change_state.get();
      label239:
      localLebaPluginInfo.cCanChangeState = i;
      if (!paramGetResourceRespInfo.res_conf.has()) {
        break label423;
      }
      str = paramGetResourceRespInfo.res_conf.get();
      label264:
      localLebaPluginInfo.resConf = str;
      localLebaPluginInfo.cDataType = 0;
      i = j;
      if (paramGetResourceRespInfo.simple_mode.has()) {
        i = paramGetResourceRespInfo.simple_mode.get();
      }
      localLebaPluginInfo.showInSimpleMode = i;
      if (!paramGetResourceRespInfo.grid_icon_url.has()) {
        break label430;
      }
    }
    label385:
    label392:
    label399:
    label406:
    label411:
    label418:
    label423:
    label430:
    for (String str = paramGetResourceRespInfo.grid_icon_url.get();; str = "")
    {
      localLebaPluginInfo.strGridIconUrl = str;
      if (QLog.isColorLevel()) {
        QLog.i("ConfigManager", 2, "plugin config xml:" + paramGetResourceRespInfo.res_conf.get());
      }
      return localLebaPluginInfo;
      l = 0L;
      break;
      label375:
      i = 0;
      break label62;
      label380:
      i = 0;
      break label86;
      str = "";
      break label111;
      str = "";
      break label137;
      str = "";
      break label163;
      s = -1;
      break label189;
      str = "";
      break label214;
      i = 1;
      break label239;
      str = "";
      break label264;
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.LebaPluginInfo
 * JD-Core Version:    0.7.0.1
 */