import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr.2;
import com.tencent.av.ui.MultiIncomingCallUICtr.5;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ltr
  extends lrd
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lts(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public VideoController a;
  ksn jdField_a_of_type_Ksn = ksn.a();
  kur jdField_a_of_type_Kur = new ltt(this);
  kvw jdField_a_of_type_Kvw = new ltu(this);
  mht jdField_a_of_type_Mht;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  Runnable jdField_c_of_type_JavaLangRunnable = new MultiIncomingCallUICtr.5(this);
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  String jdField_e_of_type_JavaLangString = "";
  String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  
  public ltr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public int a(Intent paramIntent)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onStartCommand, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
    a(l, paramIntent);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kur);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kvw);
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
      if (this.jdField_c_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_JavaLangRunnable = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiIncomingCallUICtr", 2, "onDestroy error : " + localException);
        }
      }
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Long localLong;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("MultiIncomingCallUICtr", 1, "closeSession, reason[" + paramInt + "], seq[" + paramLong + "]");
      }
      localLong = Long.valueOf(mfy.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localLong.longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localLong.longValue(), 2);
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Kvq.jdField_d_of_type_JavaLangString, 243);
    this.jdField_a_of_type_ComTencentAvVideoController.b(243);
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
    }
    for (;;)
    {
      if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
      }
      awqx.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
      a();
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("relationType", 3);
    this.jdField_e_of_type_Int = paramIntent.getIntExtra("memberType", -1);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("bindType", 0);
    if (mfs.b(this.jdField_b_of_type_Int)) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.jdField_a_of_type_Boolean = false;
        label133:
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
        String str = ksn.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
        this.jdField_a_of_type_Kvq = this.jdField_a_of_type_Ksn.b(str);
        this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kur);
      }
    }
    for (;;)
    {
      a(true);
      if ((this.jdField_a_of_type_Kvq != null) || (this.jdField_b_of_type_Int == 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "session info null!");
      }
      a();
      return;
      this.jdField_a_of_type_Boolean = true;
      break label133;
      if (!this.jdField_b_of_type_Boolean) {
        break label406;
      }
      paramIntent = ksn.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sessionId : " + paramIntent);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Kvq = ksn.a().b(paramIntent);
      this.jdField_a_of_type_Kvq.a(paramLong, "processIntent.1", 4);
      this.jdField_a_of_type_Kvq.I = true;
      this.jdField_a_of_type_Kvq.an = true;
      this.jdField_a_of_type_Kvq.e = true;
      this.jdField_a_of_type_Kvq.L = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kur);
    }
    label406:
    paramIntent = ksn.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_Kvq = ksn.a().b(paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Kvq.a(paramLong, "processIntent.2", 1);
      this.jdField_a_of_type_Kvq.a(paramLong, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Kvq.e = true;
      this.jdField_a_of_type_Kvq.L = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kvw);
      break;
      this.jdField_a_of_type_Kvq.a(paramLong, "processIntent.3", 2);
      this.jdField_a_of_type_Kvq.a(paramLong, true);
    }
  }
  
  void a(long paramLong, kvq paramkvq)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "acceptRequest, seq[" + paramLong + "]");
    }
    this.jdField_d_of_type_Boolean = true;
    kvq localkvq = ksn.a().a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.f)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.h(true);
      if (this.jdField_a_of_type_Kvq == null) {
        break label591;
      }
      if (this.jdField_a_of_type_Kvq.h()) {
        break label310;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "Session already destroyed, id:" + this.jdField_a_of_type_Kvq.jdField_c_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_Kvq.jdField_g_of_type_Int);
      }
      if (this.jdField_a_of_type_Lzu != null) {
        this.jdField_a_of_type_Lzu.c(ajjy.a(2131641219));
      }
    }
    label310:
    label374:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        if ((paramkvq != null) && (localkvq == paramkvq))
        {
          if (ksn.a().a() >= 2)
          {
            if (paramkvq.h()) {
              a(paramLong, false, paramkvq);
            }
            for (;;)
            {
              a(paramkvq);
              break;
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, 201, new int[] { localkvq.A });
              this.jdField_a_of_type_ComTencentAvVideoController.b(201);
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiIncomingCallUICtr", 2, "no need to close main session because there is only one session");
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("mainSession invalid when accept 3rd request, currMainSession == mainSessionInfo:");
        if (localkvq == paramkvq) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.d("MultiIncomingCallUICtr", 2, bool);
          break;
        }
        if (!mfs.b(this.jdField_b_of_type_Int)) {
          break label374;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_Kvq.jdField_g_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
        awqx.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      int i = 1;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "appType :" + i);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiIncomingCallUICtr", 2, "acceptVideoRequest isDoubleVideoMeeting");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.jdField_a_of_type_Kvq.jdField_d_of_type_JavaLangString).longValue(), null, false);
        awqx.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        b();
        break;
        int j = mjg.d(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, i, j);
        if (this.jdField_a_of_type_Boolean) {
          awqx.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        } else {
          awqx.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
        }
      }
    }
    label591:
    QLog.d("MultiIncomingCallUICtr", 2, "session invalid when accept request");
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "refuseDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], peerUin[" + paramString + "], notifyDestroyUI[" + paramBoolean2 + "], refuse3rd[" + paramBoolean3 + "], seq[" + paramLong + "]");
    }
    long l2;
    if (this.jdField_a_of_type_Kvq.Q)
    {
      awqx.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
      if (!paramBoolean1) {
        break label317;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = mfy.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 23);
          a();
          if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
          awqx.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MultiIncomingCallUICtr", 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
        a();
        continue;
      }
      label317:
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallUICtr.2(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  void a(long paramLong, boolean paramBoolean, kvq paramkvq)
  {
    a(paramLong, paramBoolean, paramkvq, -1);
  }
  
  void a(long paramLong, boolean paramBoolean, kvq paramkvq, int paramInt)
  {
    boolean bool3 = false;
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Object localObject = this.jdField_c_of_type_JavaLangString;
    boolean bool1 = this.jdField_b_of_type_Boolean;
    int i = this.jdField_c_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (!paramBoolean) {
      if (paramkvq != null)
      {
        String str = paramkvq.jdField_d_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramkvq.r;
        }
        bool1 = paramkvq.I;
        i = paramkvq.C;
        l = paramkvq.jdField_g_of_type_Long;
      }
    }
    for (;;)
    {
      int j = mjg.c(i);
      boolean bool2 = bool3;
      if (!paramBoolean) {
        if (!bool1)
        {
          bool2 = bool3;
          if (!a(j)) {}
        }
        else
        {
          bool2 = true;
        }
      }
      if (mfs.b(j))
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, (String)localObject, bool2, paramBoolean);
      return;
    }
  }
  
  void a(kvq paramkvq)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramkvq != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramkvq.jdField_g_of_type_Long);
      localIntent.putExtra("peerUin", paramkvq.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam");
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().m()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean a(int paramInt)
  {
    return paramInt == 3000;
  }
  
  boolean b(int paramInt)
  {
    if ((this.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      localIntent.putExtra("relationId", this.jdField_a_of_type_Long + "");
      localIntent.putExtra("dealResult", paramInt);
      localIntent.putExtra("inviteId", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("friendUin", this.jdField_b_of_type_Long);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sendBroadcast, qav_gaudio_join");
      }
      return true;
    }
    return false;
  }
  
  void c()
  {
    if (!b(0)) {
      a(-1036L, true, null);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onCreate start");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.multiaccept");
    localIntentFilter.addAction("tencent.video.invite.multirefuse");
    localIntentFilter.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    localIntentFilter.addAction("tencent.video.destroyService");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void e()
  {
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long + "");
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.jdField_a_of_type_Long) });
    b(1);
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Mht == null) {
      this.jdField_a_of_type_Mht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    Object localObject;
    if (!mfs.b(this.jdField_b_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_Kvq.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_b_of_type_Int, 2);
      }
    }
    Bitmap localBitmap;
    String str;
    do
    {
      return;
      this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_Kvq.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_b_of_type_Int, 1);
      return;
      localObject = String.valueOf(this.jdField_a_of_type_Long);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, (String)localObject, null, true, true);
      int i = mfs.b(this.jdField_b_of_type_Int);
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, Long.toString(this.jdField_b_of_type_Long), (String)localObject);
    } while (this.jdField_a_of_type_Kvq == null);
    this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_Kvq.jdField_c_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_b_of_type_Int, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ltr
 * JD-Core Version:    0.7.0.1
 */