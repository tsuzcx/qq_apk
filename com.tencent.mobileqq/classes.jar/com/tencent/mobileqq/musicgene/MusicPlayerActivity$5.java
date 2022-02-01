package com.tencent.mobileqq.musicgene;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class MusicPlayerActivity$5
  implements OpensdkBusinessObserver
{
  MusicPlayerActivity$5(MusicPlayerActivity paramMusicPlayerActivity, Intent paramIntent) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        Object localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          paramBundle.mergeFrom((byte[])localObject);
          if ((paramBundle.has()) && (paramBundle.ret.get() == 0) && (paramBundle.androidInfo != null))
          {
            GetAppInfoProto.AndroidInfo localAndroidInfo = paramBundle.androidInfo;
            localObject = Share.a(paramBundle.iconsURL, 16);
            this.a.putExtra("struct_share_key_source_url", localAndroidInfo.sourceUrl.get());
            Intent localIntent = this.a;
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            localIntent.putExtra("struct_share_key_source_icon", paramBundle);
            this.a.putExtra("struct_share_key_source_name", localAndroidInfo.messagetail.get());
            this.a.putExtra("struct_share_key_source_a_action_data", localAndroidInfo.packName.get());
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicPlayerActivity", 2, paramBundle.getMessage());
        }
      }
    }
    paramBundle = StructMsgFactory.a(this.a.getExtras());
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerActivity", 2, "build struct msg fail");
      }
    }
    else
    {
      this.a.putExtra("stuctmsg_bytes", paramBundle.getBytes());
      this.b.startActivityForResult(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.5
 * JD-Core Version:    0.7.0.1
 */