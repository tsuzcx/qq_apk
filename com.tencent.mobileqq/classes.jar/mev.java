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

public class mev
  extends mce
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mew(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public VideoController a;
  lcb jdField_a_of_type_Lcb = lcb.a();
  lef jdField_a_of_type_Lef = new mex(this);
  lfl jdField_a_of_type_Lfl = new mey(this);
  mtn jdField_a_of_type_Mtn;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  Runnable jdField_c_of_type_JavaLangRunnable = new MultiIncomingCallUICtr.5(this);
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  String jdField_e_of_type_JavaLangString = "";
  String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  
  public mev(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lef);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfl);
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
      localLong = Long.valueOf(mrs.a(this.jdField_c_of_type_JavaLangString));
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
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Lff.jdField_d_of_type_JavaLangString, 243);
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
      bdll.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
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
    if (mrl.b(this.jdField_b_of_type_Int)) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.jdField_a_of_type_Boolean = false;
        label133:
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
        String str = lcb.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
        this.jdField_a_of_type_Lff = this.jdField_a_of_type_Lcb.c(str);
        this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lef);
      }
    }
    for (;;)
    {
      a(true);
      if ((this.jdField_a_of_type_Lff != null) || (this.jdField_b_of_type_Int == 1)) {
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
        break label409;
      }
      paramIntent = lcb.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sessionId : " + paramIntent);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Lff = lcb.a().c(paramIntent);
      this.jdField_a_of_type_Lff.a(paramLong, "processIntent.1", 4);
      this.jdField_a_of_type_Lff.e("processIntent", true);
      this.jdField_a_of_type_Lff.ap = true;
      this.jdField_a_of_type_Lff.e = true;
      this.jdField_a_of_type_Lff.N = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lef);
    }
    label409:
    paramIntent = lcb.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_Lff = lcb.a().c(paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Lff.a(paramLong, "processIntent.2", 1);
      this.jdField_a_of_type_Lff.a(paramLong, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Lff.e = true;
      this.jdField_a_of_type_Lff.N = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfl);
      break;
      this.jdField_a_of_type_Lff.a(paramLong, "processIntent.3", 2);
      this.jdField_a_of_type_Lff.a(paramLong, true);
    }
  }
  
  void a(long paramLong, lff paramlff)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "acceptRequest, seq[" + paramLong + "]");
    }
    this.jdField_d_of_type_Boolean = true;
    lff locallff = lcb.a().a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.f)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.g(true);
      if (this.jdField_a_of_type_Lff == null) {
        break label591;
      }
      if (this.jdField_a_of_type_Lff.j()) {
        break label310;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "Session already destroyed, id:" + this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_Lff.jdField_g_of_type_Int);
      }
      if (this.jdField_a_of_type_Mlb != null) {
        this.jdField_a_of_type_Mlb.c(anzj.a(2131705897));
      }
    }
    label310:
    label374:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        if ((paramlff != null) && (locallff == paramlff))
        {
          if (lcb.a().a() >= 2)
          {
            if (paramlff.j()) {
              a(paramLong, false, paramlff);
            }
            for (;;)
            {
              a(paramlff);
              break;
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, 201, new int[] { locallff.D });
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
        if (locallff == paramlff) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.d("MultiIncomingCallUICtr", 2, bool);
          break;
        }
        if (!mrl.b(this.jdField_b_of_type_Int)) {
          break label374;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_Lff.jdField_g_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
        bdll.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
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
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.jdField_a_of_type_Lff.jdField_d_of_type_JavaLangString).longValue(), null, false);
        bdll.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        b();
        break;
        int j = mvd.d(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, i, j);
        if (this.jdField_a_of_type_Boolean) {
          bdll.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        } else {
          bdll.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Lff.S)
    {
      bdll.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
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
        l1 = mrs.a(paramString);
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
          bdll.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
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
  
  void a(long paramLong, boolean paramBoolean, lff paramlff)
  {
    a(paramLong, paramBoolean, paramlff, -1);
  }
  
  void a(long paramLong, boolean paramBoolean, lff paramlff, int paramInt)
  {
    boolean bool3 = false;
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Object localObject = this.jdField_c_of_type_JavaLangString;
    boolean bool1 = this.jdField_b_of_type_Boolean;
    int i = this.jdField_c_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (!paramBoolean) {
      if (paramlff != null)
      {
        String str = paramlff.jdField_d_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramlff.s;
        }
        bool1 = paramlff.J;
        i = paramlff.F;
        l = paramlff.jdField_g_of_type_Long;
      }
    }
    for (;;)
    {
      int j = mvd.c(i);
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
      if (mrl.b(j))
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, (String)localObject, bool2, paramBoolean);
      return;
    }
  }
  
  void a(lff paramlff)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramlff != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramlff.jdField_g_of_type_Long);
      localIntent.putExtra("peerUin", paramlff.jdField_d_of_type_JavaLangString);
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
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().o()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().p()))
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
    if (this.jdField_a_of_type_Mtn == null) {
      this.jdField_a_of_type_Mtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    Object localObject;
    if (!mrl.b(this.jdField_b_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_b_of_type_Int, 2);
      }
    }
    Bitmap localBitmap;
    String str;
    do
    {
      return;
      this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_b_of_type_Int, 1);
      return;
      localObject = String.valueOf(this.jdField_a_of_type_Long);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, (String)localObject, null, true, true);
      int i = mrl.b(this.jdField_b_of_type_Int);
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, Long.toString(this.jdField_b_of_type_Long), (String)localObject);
    } while (this.jdField_a_of_type_Lff == null);
    this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_b_of_type_Int, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mev
 * JD-Core Version:    0.7.0.1
 */