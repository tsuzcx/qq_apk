package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.LebaGridHandler;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class BuluoPluginAction
  extends PluginAction
{
  public BuluoPluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(int paramInt)
  {
    QQAppInterface localQQAppInterface = a();
    Object localObject = (TroopRedTouchManager)localQQAppInterface.getManager(69);
    if (localObject == null) {
      return;
    }
    int i;
    if (((TroopRedTouchManager)localObject).a(7)) {
      i = 7;
    }
    for (;;)
    {
      label34:
      if (paramInt == 0) {}
      for (localObject = "Clk_tribe";; localObject = "exp_tribe")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_tribe", "", "dynamic", (String)localObject, 0, 0, i + "", "", "", "");
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("xingqubuluo", 4, "reportTroopTribe,action=" + (String)localObject + ", appId=" + i);
        return;
        if (((TroopRedTouchManager)localObject).a(6))
        {
          i = 6;
          break label34;
        }
        if (!((TroopRedTouchManager)localObject).a(1)) {
          break label162;
        }
        i = 1;
        break label34;
        if (paramInt != 1) {
          break;
        }
      }
      label162:
      i = 0;
    }
  }
  
  public void a(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    Object localObject = a();
    localObject = SharedPreUtils.c(this.a, ((QQAppInterface)localObject).getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramLebaGridItemInfo.a.jumpInfo = ((String)localObject).trim();
    }
    super.a(paramView, paramLebaGridItemInfo);
    a(0);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    Object localObject = a();
    JumpAction localJumpAction = a(paramLebaGridItemInfo);
    paramLebaGridItemInfo = (TroopRedTouchManager)((QQAppInterface)localObject).getManager(69);
    localObject = new StringBuffer();
    int i = paramLebaGridItemInfo.d();
    if (i > 0) {
      ((StringBuffer)localObject).append("redid=" + i);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("xingqubuluo", 4, "***redid=" + i);
    }
    i = paramLebaGridItemInfo.a();
    if (i > 0) {
      if (((StringBuffer)localObject).length() != 0) {
        break label178;
      }
    }
    label178:
    for (paramLebaGridItemInfo = "";; paramLebaGridItemInfo = "&rpnumber=" + i)
    {
      ((StringBuffer)localObject).append(paramLebaGridItemInfo);
      if (QLog.isDevelopLevel()) {
        QLog.d("xingqubuluo", 4, "***rpnumber=" + i);
      }
      if (((StringBuffer)localObject).length() > 0) {
        localJumpAction.c(((StringBuffer)localObject).toString());
      }
      localJumpAction.b();
      return;
    }
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo, View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    RedTouch localRedTouch = (RedTouch)paramView;
    paramView = (TroopRedTouchManager)localQQAppInterface.getManager(69);
    oidb_0x791.RedDotInfo localRedDotInfo = paramView.a(7);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    boolean bool1 = SharedPreUtils.k(this.a, localQQAppInterface.getCurrentAccountUin());
    if ((localRedDotInfo != null) && (localRedDotInfo.uint32_number.has()) && (localRedDotInfo.uint32_number.get() > 0) && (bool1))
    {
      localRedTypeInfo.red_type.set(4);
      localObject = localRedTypeInfo.red_content;
      if (localRedDotInfo.uint32_number.get() > 99) {}
      for (paramView = "99+";; paramView = localRedDotInfo.uint32_number.get() + "")
      {
        ((PBStringField)localObject).set(paramView);
        bool1 = true;
        if (!bool1) {
          break;
        }
        localRedTouch.a(localRedTypeInfo);
        label139:
        a(1);
        a(localRedTypeInfo, paramLebaGridItemInfo, localQQAppInterface, bool1);
        return;
      }
    }
    Object localObject = paramView.a(1);
    boolean bool2;
    if (localObject != null) {
      if ((((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.has()) && (((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() > 0L))
      {
        localRedTypeInfo.red_type.set(3);
        if ((!((oidb_0x791.RedDotInfo)localObject).str_face_url.has()) || (((oidb_0x791.RedDotInfo)localObject).str_face_url.get() == null)) {
          break label426;
        }
        paramView = ((oidb_0x791.RedDotInfo)localObject).str_face_url.get().toStringUtf8();
        if (TextUtils.isEmpty(paramView)) {
          break label426;
        }
        localRedTypeInfo.red_content.set(paramView);
        localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
        bool2 = true;
      }
    }
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        break;
      }
      bool1 = bool2;
      if (!((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.has()) {
        break;
      }
      paramView = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { ((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() + "" });
      localRedTypeInfo.red_desc.set(paramView);
      bool1 = true;
      break;
      localRedTypeInfo.red_type.set(0);
      bool1 = true;
      break;
      if (paramView.a(6) != null)
      {
        localRedTypeInfo.red_type.set(0);
        bool1 = true;
        break;
        localRedTouch.b();
        break label139;
      }
      bool1 = false;
      break;
      label426:
      bool2 = false;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, LebaGridItemInfo paramLebaGridItemInfo, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramLebaGridItemInfo == null) || (paramLebaGridItemInfo.a == null)) {
      return;
    }
    if ((paramRedTypeInfo != null) && (paramBoolean))
    {
      paramRedTypeInfo = (LebaGridHandler)paramQQAppInterface.a(106);
      if ((paramLebaGridItemInfo.b != -1) || (LebaShowListManager.a == 1)) {
        break label92;
      }
    }
    label92:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramLebaGridItemInfo.b = 1;
      paramRedTypeInfo.a(1, true, new Object[] { Integer.valueOf(paramLebaGridItemInfo.a.pluginId), Boolean.valueOf(paramBoolean) });
      return;
      paramLebaGridItemInfo.b = -1;
      return;
    }
  }
  
  public void b(LebaGridItemInfo paramLebaGridItemInfo)
  {
    paramLebaGridItemInfo = a();
    Object localObject = (TroopRedTouchManager)paramLebaGridItemInfo.getManager(69);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(1);
      if (localRedDotInfo != null) {
        TroopRedTouchHandler.a(paramLebaGridItemInfo, localRedDotInfo);
      }
      localObject = ((TroopRedTouchManager)localObject).a(6);
      if (localObject != null) {
        TroopRedTouchHandler.a(paramLebaGridItemInfo, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.BuluoPluginAction
 * JD-Core Version:    0.7.0.1
 */