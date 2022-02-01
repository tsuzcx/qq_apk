import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class les
  extends BroadcastReceiver
{
  private final WeakReference<VideoAppInterface> a;
  
  private les(VideoAppInterface paramVideoAppInterface)
  {
    this.a = new WeakReference(paramVideoAppInterface);
  }
  
  public void a(long paramLong1, VideoAppInterface paramVideoAppInterface, String paramString, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "rejectMultiChat, session[" + paramString + "], relationType[" + paramInt + "], groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    mts.a(paramVideoAppInterface);
    VideoController.a().a(paramLong1, paramInt, paramLong2);
    paramVideoAppInterface = msp.a(paramVideoAppInterface);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(paramString);
    }
  }
  
  public void a(long paramLong, VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "rejectDoubleChat, session[" + paramString1 + "], peerUin[" + paramString2 + "], isDoubleVideoMeeting[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    mts.a(paramVideoAppInterface);
    VideoController localVideoController = VideoController.a();
    if (paramBoolean)
    {
      localVideoController.a(paramLong, paramString2, 1, true);
      long l = mqu.a(paramString2);
      localVideoController.a(paramLong, 3, l);
      localVideoController.a(paramLong, l, 1);
    }
    for (;;)
    {
      paramVideoAppInterface = msp.a(paramVideoAppInterface);
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a(paramString1);
      }
      return;
      localVideoController.a(paramLong, paramString2, 1, false);
      localVideoController.a(paramString2, 248);
      localVideoController.b(248);
      localVideoController.b(paramString2, 1);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    label209:
    do
    {
      Object localObject;
      do
      {
        do
        {
          boolean bool;
          do
          {
            do
            {
              do
              {
                return;
                paramContext = paramIntent.getAction();
                long l = mtl.a(paramIntent);
                if (QLog.isColorLevel()) {
                  QLog.i("QAVNotifyActionMonitor", 2, "onReceive action[" + paramContext + "], seq[" + l + "]");
                }
                if ("com.tencent.qav.notify.refuse".equals(paramContext))
                {
                  paramContext = paramIntent.getStringExtra("session_id");
                  paramIntent = lbu.a().c(paramContext);
                  if (QLog.isColorLevel()) {
                    QLog.i("QAVNotifyActionMonitor", 2, "refuse call session[" + paramContext + "], info[" + paramIntent + "], seq[" + l + "]");
                  }
                  if (paramIntent != null)
                  {
                    localObject = (VideoAppInterface)this.a.get();
                    if (!lbu.a(paramIntent)) {
                      break label209;
                    }
                    a(l, (VideoAppInterface)localObject, paramIntent.c, paramIntent.d, paramIntent.J);
                  }
                  for (;;)
                  {
                    bcst.b(null, "dc00898", "", "", "0X800A2C7", "0X800A2C7", 0, 0, "", "", "", "");
                    return;
                    a(l, (VideoAppInterface)localObject, paramContext, paramIntent.F, paramIntent.g);
                  }
                }
                if (!"tencent.video.q2v.ptusoDownloadRet".equals(paramContext)) {
                  break;
                }
                i = paramIntent.getIntExtra("packageIdx", 0);
                bool = paramIntent.getBooleanExtra("isDownloaded", false);
                j = paramIntent.getIntExtra("errorType", 0);
                if (QLog.isColorLevel()) {
                  QLog.i("QAVNotifyActionMonitor", 2, "onAEResDownloadResult, package[" + i + ", isDownloaded[" + bool + ", errorType[" + j + "]");
                }
              } while ((!bool) || (i != bnpt.b.a));
              paramContext = VideoController.a().a();
            } while (paramContext == null);
            lid.a(paramContext);
            ((lhz)paramContext.a(5)).a(3);
            return;
            if (!"tencent.video.q2v.ptuLibpagDownloadRet".equals(paramContext)) {
              break;
            }
            i = paramIntent.getIntExtra("packageIdx", 0);
            bool = paramIntent.getBooleanExtra("isDownloaded", false);
            int j = paramIntent.getIntExtra("errorType", 0);
            if (QLog.isColorLevel()) {
              QLog.i("QAVNotifyActionMonitor", 2, "ACTION_PTU_LIBPAG_DOWNLOAD_RET onAEResDownloadResult, package[" + i + ", isDownloaded[" + bool + ", errorType[" + j + "]");
            }
          } while ((!bool) || (i != bnpt.c.a));
          paramContext = VideoController.a().a();
        } while (paramContext == null);
        lol.b(paramContext);
        ((lhz)paramContext.a(5)).a(3);
        return;
      } while (!"tencent.video.q2v.avReceivePushMsg".equals(paramContext));
      paramContext = paramIntent.getStringExtra("key");
      i = paramIntent.getIntExtra("msg_type", 0);
      paramIntent = paramIntent.getByteArrayExtra("msg_content");
      if (TextUtils.equals(paramContext, "avChatRoom"))
      {
        localObject = VideoController.a().a();
        if (localObject != null)
        {
          localObject = ((VideoAppInterface)localObject).a();
          if (localObject != null) {
            ((ljo)localObject).a(i, paramIntent);
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    paramContext = new StringBuilder().append("ACTION_AV_RECEIVE_PUSH_MSG , key[").append(paramContext).append("], msgType[").append(i).append("], bytes[");
    if (paramIntent == null) {}
    for (int i = 0;; i = paramIntent.length)
    {
      QLog.i("ChatRoomMng", 4, i + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     les
 * JD-Core Version:    0.7.0.1
 */