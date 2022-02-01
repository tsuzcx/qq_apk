import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class nbs
  extends TransProcessorHandler
{
  nbs(nbr paramnbr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 78)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = nbr.a(this.a);
    } while (localObject1 == null);
    TransFileController localTransFileController = ((QQAppInterface)localObject1).getTransFileController();
    Object localObject2;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("GameResultUploadMgrForRemote_GameRC", 2, "GameResultUploadMgrForRemote send finished:" + localFileMsg.fileType);
      }
      localObject2 = new Bdh_extinfo.UploadPicExtInfo();
    }
    try
    {
      ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(localFileMsg.bdhExtendInfo);
      String str = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_file_resid.get().toStringUtf8();
      paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
      localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, "handleMessage imageUUID[" + str + "],imageUrl[" + paramMessage + "], imageThumbUrl" + (String)localObject2 + "]");
      }
      localObject1 = (mxx)((QQAppInterface)localObject1).getBusinessHandler(178);
      int i = Integer.parseInt(localFileMsg.friendUin);
      if (localObject1 != null) {
        ((mxx)localObject1).a(i, localFileMsg.compressUrl, paramMessage);
      }
    }
    catch (Exception paramMessage)
    {
      label273:
      break label273;
    }
    localTransFileController.removeHandle(this);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("GameResultUploadMgrForRemote_GameRC", 2, "STATUS_SEND_ERROR:" + localFileMsg.errorCode);
    }
    localTransFileController.removeHandle(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbs
 * JD-Core Version:    0.7.0.1
 */