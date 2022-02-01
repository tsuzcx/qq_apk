package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class FastWebShareUtils$4
  implements OpensdkBusinessObserver
{
  FastWebShareUtils$4(FastWebShareUtils paramFastWebShareUtils, Intent paramIntent, Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    FastWebShareUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils).dismiss();
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
            Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
            paramBundle = localAndroidInfo.sourceUrl;
            localObject1 = "";
            if (paramBundle == null) {
              paramBundle = "";
            } else {
              paramBundle = localAndroidInfo.sourceUrl.get();
            }
            localIntent.putExtra("struct_share_key_source_url", paramBundle);
            localIntent = this.jdField_a_of_type_AndroidContentIntent;
            paramBundle = (Bundle)localObject2;
            if (localObject2 == null) {
              paramBundle = "";
            }
            localIntent.putExtra("struct_share_key_source_icon", paramBundle);
            localObject2 = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.messagetail == null) {
              paramBundle = "";
            } else {
              paramBundle = localAndroidInfo.messagetail.get();
            }
            ((Intent)localObject2).putExtra("struct_share_key_source_name", paramBundle);
            localObject2 = this.jdField_a_of_type_AndroidContentIntent;
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
        QLog.e(FastWebShareUtils.a(), 2, paramBundle.getMessage());
      }
    }
    paramBundle = StructMsgFactory.a(this.jdField_a_of_type_AndroidContentIntent.getExtras());
    if (paramBundle == null)
    {
      QLog.e(FastWebShareUtils.a(), 2, "build struct msg fail");
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("stuctmsg_bytes", paramBundle.getBytes());
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils.4
 * JD-Core Version:    0.7.0.1
 */