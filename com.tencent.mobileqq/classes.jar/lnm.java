import android.content.Intent;
import android.os.Message;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class lnm
  implements mwx
{
  public lnm(QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 31: 
    case 32: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "handleMessage-->Message is empty!");
      }
      return true;
    }
    if (this.a.mMavCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "handleMessage-->mVideoControl = null");
      }
      return true;
    }
    Object localObject = (mwn)paramMessage.obj;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
      }
      return true;
    }
    int i = paramMessage.what;
    paramMessage = ((mwn)localObject).jdField_a_of_type_ArrayOfByte;
    long l2 = ((mwn)localObject).jdField_a_of_type_Long;
    long l1 = ((mwn)localObject).jdField_b_of_type_Long;
    int j = ((mwn)localObject).jdField_a_of_type_Int;
    int k = ((mwn)localObject).jdField_b_of_type_Int;
    k = ((mwn)localObject).c;
    int m = ((mwn)localObject).d;
    int n = ((mwn)localObject).e;
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + i);
      }
      break;
    }
    for (;;)
    {
      return true;
      this.a.processMicAuthAfterEnterRoom(((mwn)localObject).jdField_a_of_type_ArrayOfByte);
      if (mqw.a())
      {
        mqw.a().a(null, this.a);
        continue;
        this.a.processMicAuthAfterEnterRoom(((mwn)localObject).jdField_a_of_type_ArrayOfByte);
        if (mqw.a())
        {
          mqw.a().a(null, this.a);
          continue;
          i = (int)((mwn)localObject).jdField_a_of_type_Long;
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          lvm.a().a("load", i);
          continue;
          if (l2 == 0L)
          {
            localObject = mwe.a(paramMessage, m);
            this.a.mMavCallback.b((ArrayList)localObject);
            if (((j == 10) || (j == 1)) && (localObject != null))
            {
              l2 = this.a.mMavCallback.a(k, j, l1);
              paramMessage = new ArrayList(((ArrayList)localObject).size());
              long l3 = AudioHelper.a() / 1000L;
              localObject = ((ArrayList)localObject).iterator();
              while (((Iterator)localObject).hasNext()) {
                paramMessage.add(new lnl(((mwe)((Iterator)localObject).next()).jdField_a_of_type_Long, l3));
              }
              this.a.mMavCallback.a(l1, l2, paramMessage);
              if (QLog.isColorLevel()) {
                QLog.i("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PB_INVITE_RSP = MULTIAV_GROUP_AUDIO saveInviteMembers");
              }
            }
          }
          else
          {
            if (paramMessage == null) {}
            for (paramMessage = "";; paramMessage = new String(paramMessage))
            {
              this.a.mMavCallback.b(l1, l2, paramMessage);
              break;
            }
            paramMessage = QQGAudioCtrl.getAVInfoListFromByte2(paramMessage, m);
            if (paramMessage != null)
            {
              this.a.mMavCallback.b(l1, paramMessage);
              continue;
              bcef.b(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int)l2, "", "", "", "");
              continue;
              bcef.b(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int)l2, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lnm
 * JD-Core Version:    0.7.0.1
 */