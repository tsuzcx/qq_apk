import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.av.ui.BeautyToolbar.DataReport;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class joq
  extends IAVServiceForQQ.Stub
{
  private joq(AVServiceForQQ paramAVServiceForQQ) {}
  
  public int a(long paramLong, int paramInt)
  {
    Object localObject;
    label72:
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if ((localObject == null) || (!((VideoController)localObject).e) || (((VideoController)localObject).a().F != paramInt) || (((VideoController)localObject).a().f != paramLong)) {
        break label117;
      }
      localObject = ((VideoController)localObject).a().iterator();
      paramInt = 0;
      i = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break label120;
      }
      if (((VideoController.GAudioFriends)((Iterator)localObject).next()).c != 1) {
        break label123;
      }
      paramInt += 1;
    }
    label117:
    label120:
    label123:
    for (;;)
    {
      break label72;
      localObject = VideoController.a();
      break;
      i = 0;
      return i;
    }
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "processQCallPush in AVServiceForQQ");
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(); localVideoController != null; localVideoController = VideoController.a()) {
      return localVideoController.a(paramArrayOfByte);
    }
    return null;
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      localVideoController.a("startSpeak", localVideoController.jdField_a_of_type_Long, true, true);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    b();
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (!localVideoController.e) {
        break label90;
      }
      if (paramLong == 0L) {
        paramLong = localVideoController.jdField_a_of_type_Long;
      }
      localVideoController.a(localVideoController.c, localVideoController.jdField_a_of_type_Long, 95);
    }
    for (;;)
    {
      localVideoController.a(0, 0, null);
      SessionMgr.a().a().d();
      SessionMgr.a().a().e();
      return;
      localVideoController = VideoController.a();
      break;
      label90:
      localVideoController.a(AVServiceForQQ.a(this.a), paramLong, 96);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(); (localVideoController.e) && (localVideoController.a().aE); localVideoController = VideoController.a()) {
      return;
    }
    localVideoController.a().N = true;
    AVServiceForQQ.a(this.a, TraeHelper.a());
    AVServiceForQQ.a(this.a).a(null);
    AVServiceForQQ.a(this.a).c();
    AVServiceForQQ.a(this.a).e();
    if ((SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int == 3) && ((paramLong == -1L) || (paramLong == SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long)))
    {
      AVServiceForQQ.a(this.a, true);
      this.a.jdField_b_of_type_JavaLangString = SessionMgr.a().a().jdField_b_of_type_JavaLangString;
      if ((!AVServiceForQQ.a(this.a)) && (localVideoController.e))
      {
        localVideoController.a(localVideoController.c, localVideoController.jdField_a_of_type_Long, 94);
        SessionMgr.a().a().e();
        SessionMgr.a().a().d();
      }
      SessionMgr.a().b(this.a.jdField_b_of_type_JavaLangString);
      if (AVServiceForQQ.a(this.a)) {
        break label392;
      }
      AVServiceForQQ.a(this.a).b();
      AVServiceForQQ.a(this.a).a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      AVServiceForQQ.a(this.a).a();
      localVideoController.f(false);
      label283:
      if (!localVideoController.e) {
        break label502;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "StartOrEnterGAudio already in room");
      }
    }
    for (;;)
    {
      localVideoController.a().d = 3;
      localVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = paramString;
      localVideoController.a().aE = true;
      return;
      this.a.jdField_b_of_type_JavaLangString = SessionMgr.a(AVServiceForQQ.a(this.a), String.valueOf(paramLong), new int[0]);
      SessionMgr.a().a(this.a.jdField_b_of_type_JavaLangString, false);
      AVServiceForQQ.a(this.a, false);
      break;
      label392:
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "IsAccompanyReturn");
      }
      AVServiceForQQ.a(this.a).a();
      if (SessionMgr.a().a(this.a.jdField_b_of_type_JavaLangString).jdField_c_of_type_Boolean)
      {
        localVideoController.a("enterRoom", SessionMgr.a().a(this.a.jdField_b_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, false, false);
        break label283;
      }
      localVideoController.a("enterRoom", SessionMgr.a().a(this.a.jdField_b_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, true, false);
      break label283;
      label502:
      int i = localVideoController.a(AVServiceForQQ.a(this.a), paramLong, AVServiceForQQ.b(this.a), new long[] { this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() }, false);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "enterRoom result = " + i);
      }
      new Handler(Looper.getMainLooper()).post(new jos(this, i));
    }
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback) {}
  
  public void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.z(paramString);
      }
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.a(paramString, paramBitmap);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      localVideoController.c(paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (;;)
    {
      return;
      if (!paramBoolean) {
        break;
      }
      if (paramNotification != null) {}
      for (this.a.jdField_a_of_type_AndroidAppNotification = paramNotification; this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null; this.a.jdField_a_of_type_AndroidAppNotification = new Notification())
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new jor(this));
        return;
      }
    }
    this.a.stopForeground(true);
    this.a.jdField_a_of_type_AndroidAppNotification = null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.b(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      localVideoController.a("stopSpeak", localVideoController.jdField_a_of_type_Long, false, true);
      return;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.c(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void c()
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      TraeHelper.a().a("exitQQCall");
      localVideoController.a().jdField_b_of_type_Boolean = false;
      localVideoController.a(localVideoController.a().jdField_c_of_type_JavaLangString, 0);
      localVideoController.b(224);
      if (localVideoController.a().z == -1) {
        break label173;
      }
    }
    for (;;)
    {
      localVideoController.a().o = true;
      AVLog.c(this.a.jdField_a_of_type_JavaLangString, "DataReport onClose: ");
      EffectFilterTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectZimuManager.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectPendantTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      BeautyToolbar.DataReport.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      VoiceChangeDataReport.b(localVideoController.a());
      localVideoController.c(localVideoController.a().jdField_c_of_type_JavaLangString, localVideoController.a().z);
      localVideoController.a().jdField_c_of_type_Boolean = false;
      return;
      localVideoController = VideoController.a();
      break;
      label173:
      localVideoController.a().z = 0;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.d(paramArrayOfByte);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     joq
 * JD-Core Version:    0.7.0.1
 */