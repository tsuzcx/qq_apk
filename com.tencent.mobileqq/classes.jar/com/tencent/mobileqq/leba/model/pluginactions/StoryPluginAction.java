package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class StoryPluginAction
  extends PluginAction
{
  public StoryPluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    QQAppInterface localQQAppInterface = a();
    JumpAction localJumpAction = a(paramLebaGridItemInfo);
    Object localObject3 = (TroopRedTouchManager)localQQAppInterface.getManager(69);
    Object localObject2 = ((TroopRedTouchManager)localObject3).a();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (((MsgTabStoryNodeConfigManager)localQQAppInterface.getManager(251)).a)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StoryPluginAction", 2, "check invisible red point for msgtab");
        }
        localObject1 = ((TroopRedTouchManager)localObject3).a(49);
        if (localObject1 != null) {
          break label220;
        }
        localObject1 = ((TroopRedTouchManager)localObject3).a(35);
      }
    }
    label220:
    for (;;)
    {
      if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() == 37))
      {
        localObject2 = null;
        try
        {
          localObject3 = new JSONObject(((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
          localObject2 = localObject3;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            SLog.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
            continue;
            localObject1 = String.valueOf(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get());
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
      for (paramLebaGridItemInfo = a(paramLebaGridItemInfo);; paramLebaGridItemInfo = localJumpAction) {
        if (localObject1 == null)
        {
          localObject1 = "";
          paramLebaGridItemInfo.a("redid", (String)localObject1);
          paramLebaGridItemInfo.a("lebaVersion", "old");
          paramLebaGridItemInfo.b();
          return;
        }
      }
    }
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo, View paramView)
  {
    paramLebaGridItemInfo = a();
    paramView = (RedTouch)paramView;
    if (paramView == null) {
      return;
    }
    paramLebaGridItemInfo = (TroopRedTouchManager)paramLebaGridItemInfo.getManager(69);
    oidb_0x791.RedDotInfo localRedDotInfo = paramLebaGridItemInfo.a();
    if (localRedDotInfo == null)
    {
      paramView.b();
      return;
    }
    StoryReportor.a("dynamic", "exp_story", 0, paramLebaGridItemInfo.b(), new String[0]);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int i;
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
    case 8: 
    case 11: 
    case 37: 
      for (i = -1; i != -1; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "更新动态红点:" + TroopRedTouchManager.a(localRedDotInfo));
        }
        localRedTypeInfo.red_type.set(i);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramView.a(localRedTypeInfo);
        return;
      }
    case 35: 
      label142:
      i = localRedDotInfo.uint32_cmd_uin_type.get();
      if (i == 0)
      {
        localObject = localRedDotInfo.str_face_url.get().toStringUtf8();
        paramLebaGridItemInfo = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { localRedDotInfo.uint64_cmd_uin.get() + "" });
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramLebaGridItemInfo = "{'av':1, 'dot':1}";
          localRedTypeInfo.red_content.set((String)localObject);
        }
        localRedTypeInfo.red_desc.set(paramLebaGridItemInfo);
      }
      for (;;)
      {
        i = 3;
        break label142;
        if (i != 1) {
          break;
        }
        paramLebaGridItemInfo = "http://p.qlogo.cn/gh/" + localRedDotInfo.uint64_cmd_uin.get() + "/" + localRedDotInfo.uint64_cmd_uin.get() + "/100?t=" + TroopRedTouchManager.c;
        localRedTypeInfo.red_content.set(paramLebaGridItemInfo);
        localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
      }
    }
    Object localObject = localRedTypeInfo.red_content;
    if (localRedDotInfo.uint32_number.get() > 99) {}
    for (paramLebaGridItemInfo = "99+";; paramLebaGridItemInfo = localRedDotInfo.uint32_number.get() + "")
    {
      ((PBStringField)localObject).set(paramLebaGridItemInfo);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      i = 4;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.StoryPluginAction
 * JD-Core Version:    0.7.0.1
 */