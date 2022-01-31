package com.tencent.mobileqq.data;

import atmo;
import atmp;
import atnz;
import atoc;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import tencent.im.PluginConfig.PluginConfig.GetResourceRespInfo;

public class LebaPluginInfo
  extends atmo
{
  public static final int STATE_ADD = 3;
  public static final int STATE_DEL = 2;
  public static final int STATE_NONE = 0;
  public static final int STATE_UPDATE = 1;
  public int cCanChangeState;
  public byte cDataType;
  public String resConf;
  @atnz
  public int sPriority;
  public int sResSeq;
  public short sResSubType;
  public int showInSimpleMode;
  @atnz
  public int state = 0;
  public String strGotoUrl;
  @Deprecated
  public String strPkgName;
  public String strResName;
  public String strResURL;
  @atoc
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
        break label349;
      }
      i = paramGetResourceRespInfo.state.get();
      localLebaPluginInfo.state = i;
      if (!paramGetResourceRespInfo.res_seq.has()) {
        break label354;
      }
      i = paramGetResourceRespInfo.res_seq.get();
      localLebaPluginInfo.sResSeq = i;
      if (!paramGetResourceRespInfo.pkg_name.has()) {
        break label359;
      }
      str = paramGetResourceRespInfo.pkg_name.get();
      localLebaPluginInfo.strPkgName = str;
      if (!paramGetResourceRespInfo.res_name.has()) {
        break label366;
      }
      str = paramGetResourceRespInfo.res_name.get();
      label137:
      localLebaPluginInfo.strResName = str;
      if (!paramGetResourceRespInfo.icon_url.has()) {
        break label373;
      }
      str = paramGetResourceRespInfo.icon_url.get();
      label163:
      localLebaPluginInfo.strResURL = str;
      if (!paramGetResourceRespInfo.sub_type.has()) {
        break label380;
      }
      s = (short)paramGetResourceRespInfo.sub_type.get();
      label189:
      localLebaPluginInfo.sResSubType = s;
      if (!paramGetResourceRespInfo.jump_url.has()) {
        break label385;
      }
      str = paramGetResourceRespInfo.jump_url.get();
      label214:
      localLebaPluginInfo.strGotoUrl = str;
      if (!paramGetResourceRespInfo.can_change_state.has()) {
        break label392;
      }
      i = paramGetResourceRespInfo.can_change_state.get();
      label239:
      localLebaPluginInfo.cCanChangeState = i;
      if (!paramGetResourceRespInfo.res_conf.has()) {
        break label397;
      }
    }
    label385:
    label392:
    label397:
    for (String str = paramGetResourceRespInfo.res_conf.get();; str = "")
    {
      localLebaPluginInfo.resConf = str;
      localLebaPluginInfo.cDataType = 0;
      i = j;
      if (paramGetResourceRespInfo.simple_mode.has()) {
        i = paramGetResourceRespInfo.simple_mode.get();
      }
      localLebaPluginInfo.showInSimpleMode = i;
      if (QLog.isColorLevel()) {
        QLog.i("ConfigManager", 2, "plugin config xml:" + paramGetResourceRespInfo.res_conf.get());
      }
      return localLebaPluginInfo;
      l = 0L;
      break;
      label349:
      i = 0;
      break label62;
      label354:
      i = 0;
      break label86;
      label359:
      str = "";
      break label111;
      label366:
      str = "";
      break label137;
      label373:
      str = "";
      break label163;
      label380:
      s = -1;
      break label189;
      str = "";
      break label214;
      i = 1;
      break label239;
    }
  }
  
  public static LebaPluginInfo find(atmp paramatmp, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramatmp != null)
    {
      localObject1 = localObject2;
      if (paramLong > 0L) {
        localObject1 = (LebaPluginInfo)paramatmp.a(LebaPluginInfo.class, "uiResId=?", new String[] { String.valueOf(paramLong) });
      }
    }
    return localObject1;
  }
  
  public static List<LebaPluginInfo> getAll(atmp paramatmp)
  {
    if (paramatmp != null) {}
    for (paramatmp = paramatmp.a(LebaPluginInfo.class, false, "", null, null, null, null, null);; paramatmp = null)
    {
      Object localObject = paramatmp;
      if (paramatmp == null) {
        localObject = Collections.EMPTY_LIST;
      }
      return localObject;
    }
  }
  
  public static void persistOrReplace(atmp paramatmp, LebaPluginInfo paramLebaPluginInfo)
  {
    if ((paramatmp != null) && (paramLebaPluginInfo != null) && (paramLebaPluginInfo.uiResId > 0L))
    {
      LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramatmp.a(LebaPluginInfo.class, "uiResId=?", new String[] { String.valueOf(paramLebaPluginInfo.uiResId) });
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
        paramatmp.a(localLebaPluginInfo);
      }
    }
    else
    {
      return;
    }
    paramatmp.a(paramLebaPluginInfo);
  }
  
  public static void remove(atmp paramatmp, long paramLong)
  {
    if (paramatmp != null)
    {
      LebaPluginInfo localLebaPluginInfo = find(paramatmp, paramLong);
      if (localLebaPluginInfo != null) {
        paramatmp.b(localLebaPluginInfo);
      }
    }
  }
  
  public String toString()
  {
    return "LebaPluginInfo：" + this.uiResId + "|" + this.state + "|" + this.strPkgName + "|" + this.strResName + "|" + this.sResSeq + "|" + this.sResSubType + "|" + this.cCanChangeState + "|" + this.sPriority + "|" + this.showInSimpleMode + "|" + this.strResURL + "|" + this.strGotoUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.LebaPluginInfo
 * JD-Core Version:    0.7.0.1
 */