import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class rnd
  implements BusinessObserver
{
  rnd(rnb paramrnb, Intent paramIntent, Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    rnb.a(this.jdField_a_of_type_Rnb).dismiss();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          paramBundle.mergeFrom((byte[])localObject);
          if ((paramBundle.has()) && (paramBundle.ret.get() == 0) && (paramBundle.androidInfo != null))
          {
            localAndroidInfo = paramBundle.androidInfo;
            localObject = xmt.a(paramBundle.iconsURL, 16);
            Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.sourceUrl != null) {
              continue;
            }
            paramBundle = "";
            localIntent.putExtra("struct_share_key_source_url", paramBundle);
            localIntent = this.jdField_a_of_type_AndroidContentIntent;
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            localIntent.putExtra("struct_share_key_source_icon", paramBundle);
            localObject = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.messagetail != null) {
              continue;
            }
            paramBundle = "";
            ((Intent)localObject).putExtra("struct_share_key_source_name", paramBundle);
            localObject = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.packName != null) {
              continue;
            }
            paramBundle = "";
            ((Intent)localObject).putExtra("struct_share_key_source_a_action_data", paramBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        GetAppInfoProto.AndroidInfo localAndroidInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(rnb.b(this.jdField_a_of_type_Rnb), 2, paramBundle.getMessage());
        continue;
        this.jdField_a_of_type_AndroidContentIntent.putExtra("stuctmsg_bytes", paramBundle.getBytes());
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 1);
      }
      paramBundle = axuy.a(this.jdField_a_of_type_AndroidContentIntent.getExtras());
      if (paramBundle != null) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(rnb.b(this.jdField_a_of_type_Rnb), 2, "build struct msg fail");
      }
      return;
      paramBundle = localAndroidInfo.sourceUrl.get();
      continue;
      paramBundle = localAndroidInfo.messagetail.get();
      continue;
      paramBundle = localAndroidInfo.packName.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnd
 * JD-Core Version:    0.7.0.1
 */