import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.VideoRecoveryMonitor.1;
import com.tencent.av.VideoRecoveryMonitor.2;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class ktn
{
  private long jdField_a_of_type_Long;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public ktn(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (mcq.a().m == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = mcq.a().n;
      QLog.d("VideoRecoveryMonitor", 1, String.format("VideoProcessExitMonitor mRecoveryEnable=%s mRecoveryInterval=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(this.jdField_a_of_type_Long) }));
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.d("VideoRecoveryMonitor", 1, String.format("sendKeepProcessAlive keepAlive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("reqType", 19);
    localNewIntent.putExtra("keepAlive", paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(localNewIntent);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void d()
  {
    for (;;)
    {
      int j;
      try
      {
        boolean bool1;
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = this.jdField_b_of_type_Boolean;
          if (bool1) {}
        }
        else
        {
          return;
        }
        try
        {
          VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          kvq localkvq = localVideoController.a();
          str1 = localkvq.jdField_d_of_type_JavaLangString;
          str2 = localkvq.e;
          i = localkvq.C;
          j = localkvq.jdField_d_of_type_Int;
          bool1 = localkvq.L;
          bool2 = localkvq.N;
          bool3 = localkvq.g;
          l = localVideoController.c(str1);
          if (!QLog.isColorLevel()) {
            break label304;
          }
          QLog.d("VideoRecoveryMonitor", 2, String.format("updateLastCallInfo peerUin=%s displayName=%s businessType=%s relationType=%s sessionType=%s isFriend=%s speakerOn=%s localMute=%s roomId=%s", new Object[] { str1, str2, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l) }));
        }
        catch (Throwable localThrowable)
        {
          String str1;
          String str2;
          int i;
          boolean bool2;
          boolean bool3;
          long l;
          QLog.e("VideoRecoveryMonitor", 1, "updateLastCallInfo fail.", localThrowable);
        }
        if (i != 3) {
          continue;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putString("last_call_uin", str1).putString("last_call_display_name", str2).putInt("last_call_business_type", 0).putInt("last_call_relation_type", i).putBoolean("last_call_is_friend", bool1).putBoolean("last_call_speaker_on", bool2).putBoolean("last_call_local_mute", bool3).putLong("last_call_room_id", l).apply();
        continue;
        continue;
        if (j == 1) {
          continue;
        }
      }
      finally {}
      label304:
      if (j != 2) {}
    }
  }
  
  private void e()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putLong("last_recovery_time", System.currentTimeMillis()).apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryMonitor", 1, "updateLastRecoveryTime fail.", localThrowable);
    }
  }
  
  private void f()
  {
    try
    {
      QLog.d("VideoRecoveryMonitor", 1, "removeLastCallInfo");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0).edit().remove("last_call_uin").remove("last_call_display_name").remove("last_call_business_type").remove("last_call_relation_type").remove("last_call_is_friend").remove("last_call_speaker_on").remove("last_call_local_mute").remove("last_call_room_id").apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryMonitor", 1, "removeLastCallInfo fail.", localThrowable);
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("channelReady mIsRecovering=%s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
    if (this.jdField_c_of_type_Boolean)
    {
      kto.a(true, System.currentTimeMillis() - this.jdField_b_of_type_Long);
      this.jdField_c_of_type_Boolean = false;
      this.d = true;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      Object localObject;
      if (this.e)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a;
        if (localObject != null) {
          ((miu)localObject).d();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((kvq)localObject).jdField_i_of_type_Int, ((kvq)localObject).jdField_d_of_type_JavaLangString, ((kvq)localObject).f);
      }
    }
    a(true);
    d();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("videoClose reason=%s", new Object[] { Integer.valueOf(paramInt) }));
    this.jdField_c_of_type_Boolean = false;
    if (this.d)
    {
      this.d = false;
      kto.a(paramInt, System.currentTimeMillis() - this.jdField_c_of_type_Long);
    }
    a(false);
    f();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0);
        long l1 = System.currentTimeMillis() - ((SharedPreferences)localObject3).getLong("last_recovery_time", 0L);
        paramLong = System.currentTimeMillis() - paramLong;
        Object localObject1 = ((SharedPreferences)localObject3).getString("last_call_uin", null);
        Object localObject2 = ((SharedPreferences)localObject3).getString("last_call_display_name", null);
        int i = ((SharedPreferences)localObject3).getInt("last_call_business_type", -1);
        int j = ((SharedPreferences)localObject3).getInt("last_call_relation_type", -1);
        boolean bool1 = ((SharedPreferences)localObject3).getBoolean("last_call_is_friend", false);
        boolean bool2 = ((SharedPreferences)localObject3).getBoolean("last_call_speaker_on", false);
        boolean bool3 = ((SharedPreferences)localObject3).getBoolean("last_call_local_mute", false);
        long l2 = ((SharedPreferences)localObject3).getLong("last_call_room_id", -1L);
        long l3 = AudioHelper.b();
        QLog.w("VideoRecoveryMonitor", 1, "recoverLastCallIfNeed, source[" + paramInt + "], lastRecoveryInterval[" + l1 + "], interruptInterval[" + paramLong + "], peerUin[" + (String)localObject1 + "], displayName[" + (String)localObject2 + "], businessType[" + i + "], relationType[" + j + "], isFriend[" + bool1 + "], speakerOn[" + bool2 + "], localMute[" + bool3 + "], roomId[" + l2 + "], seq[" + l3 + "]");
        if ((l1 <= 10000L) || (paramLong > this.jdField_a_of_type_Long) || (TextUtils.isEmpty((CharSequence)localObject1)) || (i == -1) || (j == -1) || (l2 == -1L)) {
          break label588;
        }
        localObject3 = ksn.a(j, (String)localObject1, new int[0]);
        localObject3 = ksn.a().a((String)localObject3, false);
        ((kvq)localObject3).jdField_i_of_type_Int = 0;
        ((kvq)localObject3).jdField_d_of_type_JavaLangString = ((String)localObject1);
        ((kvq)localObject3).e = ((String)localObject2);
        ((kvq)localObject3).C = j;
        ((kvq)localObject3).ag = true;
        ((kvq)localObject3).jdField_i_of_type_Long = l2;
        ((kvq)localObject3).a(l3, "recoverLastCallIfNeed", 1);
        ((kvq)localObject3).Q = true;
        ((kvq)localObject3).L = bool1;
        ((kvq)localObject3).g = bool3;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        ((VideoController)localObject2).a(l3, (String)localObject1, i, j, null, null, null, 0, null, null, null, null, null, 0, 0, null, null);
        f();
        e();
        if (lor.f())
        {
          lor.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), false, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), false);
          localObject1 = ((VideoController)localObject2).a;
          if (localObject1 != null) {
            ((miu)localObject1).a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
          }
          this.jdField_c_of_type_Boolean = true;
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          this.e = bool2;
          kto.a(paramInt, paramLong, this.jdField_c_of_type_Boolean);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VideoRecoveryMonitor", 1, "recoverLastCallIfNeed fail.", localThrowable);
        return;
      }
      lor.a(0L, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      continue;
      label588:
      QLog.d("VideoRecoveryMonitor", 1, "recoverLastCallIfNeed no need to recovery last call.");
    }
  }
  
  public void b()
  {
    ThreadManagerV2.executeOnSubThread(new VideoRecoveryMonitor.1(this));
  }
  
  public void c()
  {
    ThreadManagerV2.executeOnSubThread(new VideoRecoveryMonitor.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ktn
 * JD-Core Version:    0.7.0.1
 */