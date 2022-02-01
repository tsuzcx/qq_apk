package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ClientInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RichMsgBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendReq;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.ReqBody;

public class ForwardPluginShareWebViewHelper
{
  public static oidb_cmd0xdc2.ReqBody a(SessionInfo paramSessionInfo, Bundle paramBundle)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    long l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    String str2 = paramBundle.getString("title");
    paramSessionInfo = paramBundle.getString("desc");
    Object localObject1 = paramBundle.getString("detail_url");
    String str1 = paramBundle.getString("image_url_remote");
    QLog.d("ForwardPluginShareWebViewHelper", 1, "buildcmd0xb77ReqBody picture_url =" + str1 + "\n, appId=" + 100446242L + ", uinType = " + i + "\n, title = " + str2 + ", summary = " + paramSessionInfo + ", url = " + (String)localObject1);
    if (i == 0) {
      i = 0;
    }
    for (;;)
    {
      paramBundle = new oidb_cmd0xdc2.ReqBody();
      oidb_cmd0xb77.ReqBody localReqBody = new oidb_cmd0xb77.ReqBody();
      localReqBody.appid.set(100446242L);
      localReqBody.app_type.set(1);
      localReqBody.msg_style.set(0);
      localReqBody.recv_uin.set(l);
      Object localObject2 = new oidb_cmd0xb77.ClientInfo();
      ((oidb_cmd0xb77.ClientInfo)localObject2).platform.set(1);
      localReqBody.client_info.set((MessageMicro)localObject2);
      localObject2 = new oidb_cmd0xb77.RichMsgBody();
      ((oidb_cmd0xb77.RichMsgBody)localObject2).using_ark.set(true);
      if (!TextUtils.isEmpty(str2)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).title.set(str2);
      }
      if (!TextUtils.isEmpty(paramSessionInfo))
      {
        if (!paramSessionInfo.contains(HardCodeUtil.a(2131704834))) {
          break label415;
        }
        paramSessionInfo = paramSessionInfo.replace(HardCodeUtil.a(2131704861), "");
      }
      label415:
      for (;;)
      {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).summary.set(paramSessionInfo);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((oidb_cmd0xb77.RichMsgBody)localObject2).url.set((String)localObject1);
        }
        if (!TextUtils.isEmpty(str1)) {
          ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(str1);
        }
        localReqBody.rich_msg_body.set((MessageMicro)localObject2);
        paramBundle.msg_body.set(localReqBody);
        paramSessionInfo = new ArrayList();
        localObject1 = new oidb_cmd0xdc2.BatchSendReq();
        ((oidb_cmd0xdc2.BatchSendReq)localObject1).recv_uin.set(l);
        ((oidb_cmd0xdc2.BatchSendReq)localObject1).send_type.set(i);
        paramSessionInfo.add(localObject1);
        paramBundle.batch_send_req.set(paramSessionInfo);
        return paramBundle;
        if (i == 1)
        {
          i = 1;
          break;
        }
        if (i != 3000) {
          break label418;
        }
        i = 2;
        break;
      }
      label418:
      i = 0;
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull Activity paramActivity, @NonNull SessionInfo paramSessionInfo, @NonNull Intent paramIntent)
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299166));
    localQQProgressDialog.c(2131694694);
    localQQProgressDialog.show();
    String str = paramIntent.getStringExtra("share_comment_message");
    paramIntent = paramIntent.getExtras();
    paramIntent.putInt("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramIntent.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putLong("req_share_id", 0L);
    paramIntent.putInt("req_type", 1);
    paramIntent = a(paramSessionInfo, paramIntent);
    Bundle localBundle = new Bundle();
    ProtoUtils.a(paramQQAppInterface, new ForwardPluginShareWebViewHelper.1(localQQProgressDialog, paramActivity, paramQQAppInterface, paramSessionInfo, str), paramIntent.toByteArray(), "OidbSvc.0xdc2_34", 3522, 34, localBundle, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper
 * JD-Core Version:    0.7.0.1
 */