import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1;
import com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class lyt
  extends lzb
{
  private lyt(AVServiceForQQ paramAVServiceForQQ) {}
  
  public int a(long paramLong, int paramInt)
  {
    Object localObject;
    label72:
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if ((localObject == null) || (!((VideoController)localObject).e) || (((VideoController)localObject).a().E != paramInt) || (((VideoController)localObject).a().jdField_g_of_type_Long != paramLong)) {
        break label117;
      }
      localObject = ((VideoController)localObject).c().iterator();
      paramInt = 0;
      i = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break label120;
      }
      if (((lfu)((Iterator)localObject).next()).d != 1) {
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
      lfb.a().a().a();
      lfb.a().a().b();
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
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(); (localVideoController.e) && (localVideoController.a().aA); localVideoController = VideoController.a()) {
      return;
    }
    long l = AudioHelper.b();
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "enterRoom, groupId[" + paramLong + "], nickname[" + paramString + "], seq[" + l + "]");
    localVideoController.a().a("enterRoom", true);
    AVServiceForQQ.a(this.a, mwk.a());
    AVServiceForQQ.a(this.a).a(null);
    AVServiceForQQ.a(this.a).c();
    AVServiceForQQ.a(this.a).d();
    if ((lfb.a().a().jdField_a_of_type_Lif.jdField_a_of_type_Int == 3) && ((paramLong == -1L) || (paramLong == lfb.a().a().jdField_a_of_type_Lif.jdField_a_of_type_Long)))
    {
      AVServiceForQQ.a(this.a, true);
      this.a.b = lfb.a().a().c;
      if ((!AVServiceForQQ.a(this.a)) && (localVideoController.e))
      {
        localVideoController.a(localVideoController.c, localVideoController.jdField_a_of_type_Long, 94);
        lfb.a().a().b();
        lfb.a().a().a();
      }
      lfb.a().b(this.a.b);
      if (AVServiceForQQ.a(this.a)) {
        break label457;
      }
      AVServiceForQQ.a(this.a).b();
      AVServiceForQQ.a(this.a).a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      AVServiceForQQ.a(this.a).a();
      localVideoController.f(false);
      label344:
      if (!localVideoController.e) {
        break label567;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "StartOrEnterGAudio already in room");
      }
    }
    for (;;)
    {
      localVideoController.a().a(l, "enterRoom", 3);
      localVideoController.a().jdField_a_of_type_Lie.b = paramString;
      localVideoController.a().aA = true;
      return;
      this.a.b = lfb.a(AVServiceForQQ.a(this.a), String.valueOf(paramLong), new int[0]);
      lfb.a().a(this.a.b, false);
      AVServiceForQQ.a(this.a, false);
      break;
      label457:
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "IsAccompanyReturn");
      }
      AVServiceForQQ.a(this.a).a();
      if (lfb.a().c(this.a.b).jdField_g_of_type_Boolean)
      {
        localVideoController.a("enterRoom", lfb.a().c(this.a.b).jdField_a_of_type_Lif.jdField_a_of_type_Long, false, false);
        break label344;
      }
      localVideoController.a("enterRoom", lfb.a().c(this.a.b).jdField_a_of_type_Lif.jdField_a_of_type_Long, true, false);
      break label344;
      label567:
      int i = localVideoController.a(AVServiceForQQ.a(this.a), paramLong, AVServiceForQQ.b(this.a), new long[] { this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() }, false);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "enterRoom result = " + i);
      }
      new Handler(Looper.getMainLooper()).post(new AVServiceForQQ.AVServiceForQQStub.2(this, i));
    }
  }
  
  public void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.w(paramString);
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
  
  public void a(lyx paramlyx) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      localVideoController.e(paramBoolean);
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
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVServiceForQQ.AVServiceForQQStub.1(this));
        return;
      }
    }
    try
    {
      this.a.stopForeground(true);
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "setAvServiceForegroud stop foreground.");
      this.a.jdField_a_of_type_AndroidAppNotification = null;
      return;
    }
    catch (Throwable paramNotification)
    {
      for (;;)
      {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "setAvServiceForegroud stop foreground fail", paramNotification);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
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
        localVideoController.d(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "exitQQCall, seq[" + l + "]");
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      mwk.a().b(l);
      localVideoController.a().f = false;
      localVideoController.a(localVideoController.a().d, 224);
      localVideoController.b(224);
      if (localVideoController.a().y == -1) {
        break label220;
      }
    }
    for (;;)
    {
      localVideoController.a().t = true;
      lek.c(this.a.jdField_a_of_type_JavaLangString, "DataReport onClose: ");
      ljt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      llt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      lku.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      mem.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      moi.a(localVideoController.a());
      localVideoController.b(localVideoController.a().d, localVideoController.a().y);
      localVideoController.a().jdField_g_of_type_Boolean = false;
      return;
      localVideoController = VideoController.a();
      break;
      label220:
      localVideoController.a().y = 0;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.f(paramArrayOfByte);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyt
 * JD-Core Version:    0.7.0.1
 */