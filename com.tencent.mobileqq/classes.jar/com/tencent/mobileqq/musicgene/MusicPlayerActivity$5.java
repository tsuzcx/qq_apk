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
            this.jdField_a_of_type_AndroidContentIntent.putExtra("struct_share_key_source_url", localAndroidInfo.sourceUrl.get());
            Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            localIntent.putExtra("struct_share_key_source_icon", paramBundle);
            this.jdField_a_of_type_AndroidContentIntent.putExtra("struct_share_key_source_name", localAndroidInfo.messagetail.get());
            this.jdField_a_of_type_AndroidContentIntent.putExtra("struct_share_key_source_a_action_data", localAndroidInfo.packName.get());
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
    paramBundle = StructMsgFactory.a(this.jdField_a_of_type_AndroidContentIntent.getExtras());
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerActivity", 2, "build struct msg fail");
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("stuctmsg_bytes", paramBundle.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.5
 * JD-Core Version:    0.7.0.1
 */