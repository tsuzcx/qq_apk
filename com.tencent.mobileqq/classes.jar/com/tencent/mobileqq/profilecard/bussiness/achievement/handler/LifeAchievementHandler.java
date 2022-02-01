package com.tencent.mobileqq.profilecard.bussiness.achievement.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f.ReqBody;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f.RspBody;

public class LifeAchievementHandler
  extends BusinessHandler
{
  public static final String CMD_LIFE_ACHIEVEMENT_PRAISE = "OidbSvc.0xe5f_2";
  public static final int LIFE_ACHIEVEMENT_PRAISE = 1;
  public static final String LIFE_ACHIEVEMENT_PRAISE_ACTION_TYPE_KEY = "life_achievement_praise_action_type_key";
  public static final int LIFE_ACHIEVEMENT_PRAISE_CANCEL = 2;
  public static final String LIFE_ACHIEVEMENT_PRAISE_ID_KEY = "life_achievement_praise_id_key";
  public static final int MAX_LIFE_ACHIEVEMENT_INFO_COUNT = 10;
  private static final String TAG = "LifeAchievementHandler";
  public static final int TYPE_PRAISE_LIFE_ACHIEVEMENT = 10;
  private AppInterface mApp;
  
  protected LifeAchievementHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.mApp = paramAppInterface;
  }
  
  private void handlePraiseLifeAchievement(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xe5f.RspBody());
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramFromServiceMsg = new Bundle();
    if (paramToServiceMsg != null) {
      paramFromServiceMsg = paramToServiceMsg.extraData;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handlePraiseLifeAchievement and isSuccess is ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(" result is ");
      paramToServiceMsg.append(i);
      QLog.d("LifeAchievementHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(10, bool, paramFromServiceMsg);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xe5f_2");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LifeAchievementObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      return;
    }
    if (TextUtils.equals(str, "OidbSvc.0xe5f_2")) {
      handlePraiseLifeAchievement(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void praiseLifeAchievement(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchievementHandler", 2, String.format(Locale.getDefault(), "praiseLifeAchievement uin=%d achievementId=%d actionType=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    Object localObject = new oidb_0xe5f.ReqBody();
    ((oidb_0xe5f.ReqBody)localObject).uint64_praiseuin.set(paramLong);
    ((oidb_0xe5f.ReqBody)localObject).uint32_achievement_id.set(paramInt1);
    ((oidb_0xe5f.ReqBody)localObject).uint32_actiontype.set(paramInt2);
    localObject = makeOIDBPkg("OidbSvc.0xe5f_2", 3679, 2, ((oidb_0xe5f.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("life_achievement_praise_id_key", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("life_achievement_praise_action_type_key", paramInt2);
    sendPbReq((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementHandler
 * JD-Core Version:    0.7.0.1
 */