import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteFloatBarUICtr.4;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class mkg
  extends mbi
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mkh(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public VideoController a;
  ldy jdField_a_of_type_Ldy = new mkj(this);
  lfe jdField_a_of_type_Lfe = new mki(this);
  muj jdField_a_of_type_Muj;
  Runnable b;
  public boolean b;
  boolean c;
  int d;
  String e = "";
  String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  
  public mkg(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangRunnable = new VideoInviteFloatBarUICtr.4(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Int == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.e))
      {
        localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        ((Intent)localObject).putExtra("relationId", this.jdField_a_of_type_Long + "");
        ((Intent)localObject).putExtra("dealResult", paramInt);
        ((Intent)localObject).putExtra("inviteId", this.e);
        ((Intent)localObject).putExtra("friendUin", this.jdField_b_of_type_Long);
        ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d("VideoInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
        }
        if (paramInt != 1) {
          break label208;
        }
      }
    }
    label208:
    for (Object localObject = "tip_in";; localObject = "tip_no")
    {
      bcst.b(null, "dc00899", "Grp_video", "", "invite", (String)localObject, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_d_of_type_Int + "", "", "");
      bool1 = true;
      return bool1;
    }
  }
  
  public int a(long paramLong, Intent paramIntent)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      QLog.w("VideoInviteFloatBarUICtr", 1, "onStartCommand, seq[" + paramLong + "]");
      AudioHelper.a("VideoInviteFloatBarUICtr.onStartCommand", paramIntent.getExtras());
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("relationType", 0);
    if (mqo.b(this.jdField_b_of_type_Int))
    {
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
      this.e = paramIntent.getStringExtra("inviteId");
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("memberType", -1);
      this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ldy);
      paramIntent = lbu.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      if (lbu.a().a(paramIntent))
      {
        this.jdField_a_of_type_Ley = lbu.a().c(paramIntent);
        return 2;
      }
      this.jdField_a_of_type_Ley = lbu.a().a();
      return 2;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("shutCamera", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onStartCommand  mIsAudioMode = " + this.jdField_a_of_type_Boolean + ", isDoubleVideoMeeting = " + this.jdField_c_of_type_Boolean);
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoInviteFloatBarUICtr", 2, "mPeerUin is empty!");
      }
      a();
    }
    while (this.jdField_c_of_type_Boolean)
    {
      paramIntent = lbu.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "sessionId : " + paramIntent);
      }
      this.jdField_a_of_type_Ley = lbu.a().c(paramIntent);
      this.jdField_a_of_type_Ley.a(paramLong, "onStartCommand.1", 4);
      this.jdField_a_of_type_Ley.e("onStartCommand", true);
      this.jdField_a_of_type_Ley.ap = true;
      this.jdField_a_of_type_Ley.e = true;
      this.jdField_a_of_type_Ley.N = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ldy);
      return 2;
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "mPeerUin : " + this.jdField_c_of_type_JavaLangString);
      }
    }
    paramIntent = lbu.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_Ley = lbu.a().c(paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ley.a(paramLong, "onStartCommand.2", 1);
      this.jdField_a_of_type_Ley.a(paramLong, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ley.e = true;
      this.jdField_a_of_type_Ley.N = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfe);
      return 2;
      this.jdField_a_of_type_Ley.a(paramLong, "onStartCommand.3", 2);
      paramIntent = this.jdField_a_of_type_Ley;
      if (!this.jdField_b_of_type_Boolean) {
        bool = true;
      }
      paramIntent.a(paramLong, bool);
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ldy);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfe);
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroy error : " + localException);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (!a())
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 1");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 2");
      return;
    }
    QLog.w("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest, seq[" + paramLong + "], mIsDoubleVideoMeeting[" + this.jdField_c_of_type_Boolean + "]");
    int j = 1;
    if (this.jdField_a_of_type_Ley.S) {
      j = 0;
    }
    int i = 1;
    if (!this.jdField_a_of_type_Ley.N) {
      i = 4;
    }
    if (1008 == this.jdField_a_of_type_Ley.j) {
      i = 4;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString).longValue(), null, false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Mkf != null) {
          this.jdField_a_of_type_Mkf.c(anni.a(2131714955));
        }
        if (!this.jdField_a_of_type_Ley.S) {
          break;
        }
        bcst.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_Ley.jdField_d_of_type_JavaLangString, j, i);
      }
      bcst.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvVideoController.c();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Muj == null) {
      this.jdField_a_of_type_Muj = new muj(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext(), 1, "video wifi lock");
    }
    if ((msf.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext())) && (this.jdField_a_of_type_Muj != null)) {
      this.jdField_a_of_type_Muj.a();
    }
    return true;
  }
  
  public void b(long paramLong)
  {
    QLog.w("VideoInviteFloatBarUICtr", 1, "refuseVideoRequest, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Ley.S) {
      bcst.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    }
    while (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, 1, true);
      long l = mqu.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l, 1);
      a();
      return;
      bcst.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, 1, false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 252);
    this.jdField_a_of_type_ComTencentAvVideoController.b(252);
    this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString, 1);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mVideoController = null, return !");
      return false;
    }
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mPeerUin = null, return !");
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString);
  }
  
  void c()
  {
    c(-1039L);
  }
  
  public void c(long paramLong)
  {
    QLog.w("VideoInviteFloatBarUICtr", 1, "ignoreGAInvite, seq[" + paramLong + "]");
    bcst.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
    if (!a(0)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long);
    }
    a();
  }
  
  public void d()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "onCreate start");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.accept");
    localIntentFilter.addAction("tencent.video.invite.refuse");
    localIntentFilter.addAction("tencent.video.invite.gaaccept");
    localIntentFilter.addAction("tencent.video.invite.gaignore");
    localIntentFilter.addAction("tencent.video.q2v.sdk.onRequestVideo");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void d(long paramLong)
  {
    QLog.w("VideoInviteFloatBarUICtr", 1, "acceptGAudioChat, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Mkf != null) {
      this.jdField_a_of_type_Mkf.c(anni.a(2131714956));
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_Ley.g, this.jdField_a_of_type_ArrayOfLong, false);
    bcst.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkg
 * JD-Core Version:    0.7.0.1
 */