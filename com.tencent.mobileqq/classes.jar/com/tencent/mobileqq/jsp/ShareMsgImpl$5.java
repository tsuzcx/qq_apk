package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class ShareMsgImpl$5
  implements OpensdkBusinessObserver
{
  ShareMsgImpl$5(ShareMsgImpl paramShareMsgImpl, Intent paramIntent, long paramLong, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.d.a.dismiss();
    if (paramBoolean) {
      try
      {
        Object localObject1 = paramBundle.getByteArray("data");
        if (localObject1 != null)
        {
          paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          paramBundle.mergeFrom((byte[])localObject1);
          if ((paramBundle.has()) && (paramBundle.ret.get() == 0) && (paramBundle.androidInfo != null))
          {
            GetAppInfoProto.AndroidInfo localAndroidInfo = paramBundle.androidInfo;
            Object localObject2 = Share.a(paramBundle.iconsURL, 16);
            Intent localIntent = this.a;
            paramBundle = localAndroidInfo.sourceUrl;
            localObject1 = "";
            if (paramBundle == null) {
              paramBundle = "";
            } else {
              paramBundle = localAndroidInfo.sourceUrl.get();
            }
            localIntent.putExtra("struct_share_key_source_url", paramBundle);
            localIntent = this.a;
            paramBundle = (Bundle)localObject2;
            if (localObject2 == null) {
              paramBundle = "";
            }
            localIntent.putExtra("struct_share_key_source_icon", paramBundle);
            localObject2 = this.a;
            if (localAndroidInfo.messagetail == null) {
              paramBundle = "";
            } else {
              paramBundle = localAndroidInfo.messagetail.get();
            }
            ((Intent)localObject2).putExtra("struct_share_key_source_name", paramBundle);
            localObject2 = this.a;
            if (localAndroidInfo.packName == null) {
              paramBundle = (Bundle)localObject1;
            } else {
              paramBundle = localAndroidInfo.packName.get();
            }
            ((Intent)localObject2).putExtra("struct_share_key_source_a_action_data", paramBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, paramBundle.getMessage());
        }
      }
    }
    LiteAppJs.handleShareKandianLive(this.b, this.c, this.a);
    paramBundle = StructMsgFactory.a(this.a.getExtras());
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareMsgImpl", 2, "build struct msg fail");
      }
    }
    else
    {
      this.a.putExtra("stuctmsg_bytes", paramBundle.getBytes());
      this.d.p.startActivityForResult(this.a, (byte)1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.5
 * JD-Core Version:    0.7.0.1
 */