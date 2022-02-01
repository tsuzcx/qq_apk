package cooperation.qzone.album;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.get_album_rsp;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneGetAlbumRequest;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneGetAlbumServlet
  extends MSFServlet
{
  public static final int RESULT_DELETE = 1;
  public static final int RESULT_SUCCESS = 0;
  private static final String TAG = "QzoneGetAlbumServlet";
  private static final long TIMEOUT = 10000L;
  
  public static void sendRequest(String paramString, long paramLong, QzoneGetAlbumIntent.OnResultListener paramOnResultListener)
  {
    QzoneGetAlbumIntent localQzoneGetAlbumIntent = new QzoneGetAlbumIntent(BaseApplicationImpl.getContext(), QzoneGetAlbumServlet.class);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localQzoneGetAlbumIntent.albumId = str;
    localQzoneGetAlbumIntent.type = 1;
    localQzoneGetAlbumIntent.ownerUin = paramLong;
    localQzoneGetAlbumIntent.listenerRef = new WeakReference(paramOnResultListener);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localQzoneGetAlbumIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      Object localObject = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = new int[1];
      localObject = QZoneGetAlbumRequest.onResponse((byte[])localObject, paramFromServiceMsg);
      if (paramFromServiceMsg[0] == -11529) {
        if ((paramIntent != null) && ((paramIntent instanceof QzoneGetAlbumIntent)))
        {
          paramIntent = (QzoneGetAlbumIntent)paramIntent;
          QLog.i("QzoneGetAlbumServlet", 1, "onReceive: album is deleted. albumId=" + paramIntent.albumId);
          paramIntent = paramIntent.listenerRef;
          if ((paramIntent != null) && (paramIntent.get() != null)) {
            ((QzoneGetAlbumIntent.OnResultListener)paramIntent.get()).onResult(1, null, null);
          }
        }
      }
      do
      {
        do
        {
          return;
          if (localObject == null)
          {
            QLog.e("QzoneGetAlbumServlet", 1, "onReceive fail, response == null");
            return;
          }
          if (((get_album_rsp)localObject).album == null)
          {
            QLog.e("QzoneGetAlbumServlet", 1, "onReceive fail, response.album == null");
            return;
          }
        } while ((paramIntent == null) || (!(paramIntent instanceof QzoneGetAlbumIntent)));
        paramIntent = ((QzoneGetAlbumIntent)paramIntent).listenerRef;
        QLog.i("QzoneGetAlbumServlet", 1, "onReceive success: albumId=" + ((get_album_rsp)localObject).album.albumid + " albumName=" + ((get_album_rsp)localObject).album.name);
      } while ((paramIntent == null) || (paramIntent.get() == null));
      ((QzoneGetAlbumIntent.OnResultListener)paramIntent.get()).onResult(0, ((get_album_rsp)localObject).album.albumid, ((get_album_rsp)localObject).album.name);
      return;
    }
    if (paramFromServiceMsg == null)
    {
      QLog.e("QzoneGetAlbumServlet", 1, "onReceive fail, fromServiceMsg == null");
      return;
    }
    QLog.e("QzoneGetAlbumServlet", 1, "onReceive fail, the resultCode is " + paramFromServiceMsg.getResultCode());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (!(paramIntent instanceof QzoneGetAlbumIntent)) {
      return;
    }
    QzoneGetAlbumIntent localQzoneGetAlbumIntent = (QzoneGetAlbumIntent)paramIntent;
    QZoneGetAlbumRequest localQZoneGetAlbumRequest = new QZoneGetAlbumRequest(localQzoneGetAlbumIntent.albumId, localQzoneGetAlbumIntent.type, localQzoneGetAlbumIntent.ownerUin);
    byte[] arrayOfByte = localQZoneGetAlbumRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(10000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localQZoneGetAlbumRequest.uniKey());
    paramPacket.putSendData(paramIntent);
    QLog.i("QzoneGetAlbumServlet", 1, "onSend finish. albumId=" + localQzoneGetAlbumIntent.albumId + " type=" + localQzoneGetAlbumIntent.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.album.QzoneGetAlbumServlet
 * JD-Core Version:    0.7.0.1
 */