import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class mzo
  extends bdzm
{
  mzo(mzn parammzn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || (localbduk.b != 24) || (localbduk.c != 78)) {}
    do
    {
      for (;;)
      {
        return;
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1003: 
          if (QLog.isColorLevel()) {
            QLog.d("GameResultUploadMgrForRemote_GameRC", 2, "GameResultUploadMgrForRemote send finished:" + localbduk.b);
          }
          Object localObject2 = new Bdh_extinfo.UploadPicExtInfo();
          try
          {
            ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(localbduk.a);
            Object localObject1 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_file_resid.get().toStringUtf8();
            paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
            localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("GameResultUploadMgrForRemote_GameRC", 1, "handleMessage imageUUID[" + (String)localObject1 + "],imageUrl[" + paramMessage + "], imageThumbUrl" + (String)localObject2 + "]");
            }
            localObject1 = (mwn)this.a.a.a(178);
            int i = Integer.parseInt(localbduk.q);
            if (localObject1 != null)
            {
              ((mwn)localObject1).a(i, localbduk.k, paramMessage);
              return;
            }
          }
          catch (Exception paramMessage)
          {
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("GameResultUploadMgrForRemote_GameRC", 2, "STATUS_SEND_ERROR:" + localbduk.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzo
 * JD-Core Version:    0.7.0.1
 */