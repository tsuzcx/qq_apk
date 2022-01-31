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
  public static void a(String paramString, long paramLong, QzoneGetAlbumIntent.OnResultListener paramOnResultListener)
  {
    QzoneGetAlbumIntent localQzoneGetAlbumIntent = new QzoneGetAlbumIntent(BaseApplicationImpl.getContext(), QzoneGetAlbumServlet.class);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localQzoneGetAlbumIntent.jdField_a_of_type_JavaLangString = str;
    localQzoneGetAlbumIntent.jdField_a_of_type_Int = 1;
    localQzoneGetAlbumIntent.jdField_a_of_type_Long = paramLong;
    localQzoneGetAlbumIntent.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnResultListener);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localQzoneGetAlbumIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      Object localObject = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = new int[1];
      localObject = QZoneGetAlbumRequest.a((byte[])localObject, paramFromServiceMsg);
      if (paramFromServiceMsg[0] == -11529) {
        if ((paramIntent != null) && ((paramIntent instanceof QzoneGetAlbumIntent)))
        {
          paramIntent = (QzoneGetAlbumIntent)paramIntent;
          QLog.i("QzoneGetAlbumServlet", 1, "onReceive: album is deleted. albumId=" + paramIntent.jdField_a_of_type_JavaLangString);
          paramIntent = paramIntent.jdField_a_of_type_JavaLangRefWeakReference;
          if ((paramIntent != null) && (paramIntent.get() != null)) {
            ((QzoneGetAlbumIntent.OnResultListener)paramIntent.get()).a(1, null, null);
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
        paramIntent = ((QzoneGetAlbumIntent)paramIntent).jdField_a_of_type_JavaLangRefWeakReference;
        QLog.i("QzoneGetAlbumServlet", 1, "onReceive success: albumId=" + ((get_album_rsp)localObject).album.albumid + " albumName=" + ((get_album_rsp)localObject).album.name);
      } while ((paramIntent == null) || (paramIntent.get() == null));
      ((QzoneGetAlbumIntent.OnResultListener)paramIntent.get()).a(0, ((get_album_rsp)localObject).album.albumid, ((get_album_rsp)localObject).album.name);
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
    QZoneGetAlbumRequest localQZoneGetAlbumRequest = new QZoneGetAlbumRequest(localQzoneGetAlbumIntent.jdField_a_of_type_JavaLangString, localQzoneGetAlbumIntent.jdField_a_of_type_Int, localQzoneGetAlbumIntent.jdField_a_of_type_Long);
    byte[] arrayOfByte = localQZoneGetAlbumRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(10000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localQZoneGetAlbumRequest.uniKey());
    paramPacket.putSendData(paramIntent);
    QLog.i("QzoneGetAlbumServlet", 1, "onSend finish. albumId=" + localQzoneGetAlbumIntent.jdField_a_of_type_JavaLangString + " type=" + localQzoneGetAlbumIntent.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.album.QzoneGetAlbumServlet
 * JD-Core Version:    0.7.0.1
 */