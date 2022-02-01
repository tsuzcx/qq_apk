import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class nar
  extends beyf
{
  nar(naq paramnaq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.b != 24) || (localbete.c != 78)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = naq.a(this.a);
    } while (localObject1 == null);
    beyb localbeyb = ((QQAppInterface)localObject1).a();
    Object localObject2;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("GameResultUploadMgrForRemote_GameRC", 2, "GameResultUploadMgrForRemote send finished:" + localbete.b);
      }
      localObject2 = new Bdh_extinfo.UploadPicExtInfo();
    }
    try
    {
      ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(localbete.a);
      String str = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_file_resid.get().toStringUtf8();
      paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
      localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, "handleMessage imageUUID[" + str + "],imageUrl[" + paramMessage + "], imageThumbUrl" + (String)localObject2 + "]");
      }
      localObject1 = (mxm)((QQAppInterface)localObject1).a(178);
      int i = Integer.parseInt(localbete.q);
      if (localObject1 != null) {
        ((mxm)localObject1).a(i, localbete.k, paramMessage);
      }
    }
    catch (Exception paramMessage)
    {
      label273:
      break label273;
    }
    localbeyb.b(this);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("GameResultUploadMgrForRemote_GameRC", 2, "STATUS_SEND_ERROR:" + localbete.g);
    }
    localbeyb.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nar
 * JD-Core Version:    0.7.0.1
 */