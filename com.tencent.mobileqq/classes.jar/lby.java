import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.QavChannelProxy.1;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class lby
  extends nce
  implements ncj, nck
{
  public int a;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public String a;
  public lli a;
  public int b;
  
  public lby(VideoController paramVideoController)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    lcz locallcz;
    do
    {
      return;
      locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } while (locallcz == null);
    locallcz.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lli != null) {
      absy.a(null, "Usr_TV_Video", 4, 0, 0);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramLong1);
    localNewIntent.putExtra("groupuin", paramLong2);
    localNewIntent.putExtra("groupcode", paramLong3);
    localNewIntent.putExtra("reqType", 12);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramBoolean);
    localNewIntent.putExtra("groupuin", paramLong1);
    localNewIntent.putExtra("groupcode", paramLong2);
    localNewIntent.putExtra("reqType", 13);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    lcx.a(paramArrayOfByte);
    if (this.jdField_a_of_type_Lli == null)
    {
      bdla.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_Lli.b(paramArrayOfByte, paramLong);
  }
  
  public void a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    do
    {
      return;
      paramBundle = paramBundle.getByteArray("buffer");
    } while (paramBundle == null);
    if (this.jdField_a_of_type_Lli == null) {
      absy.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    d();
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    receiveSharpVideoCall(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramBundle, null);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("QavNetChannel", 1, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "], seq[" + l + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", mry.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    mur.a(localNewIntent, l);
    a(localNewIntent);
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    while ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    lfe locallfe = lbz.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + mry.a(paramLong) + ", uinType = " + locallfe.j);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    if (locallfe.j == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", mry.a(paramString));
      localNewIntent.putExtra("toUin", paramLong);
      localNewIntent.putExtra("vMsg", paramArrayOfByte);
      a(localNewIntent);
      return;
      localNewIntent.putExtra("reqType", 4);
    }
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", lcx.a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(ArrayList<Long> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      return;
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavNetChannel", 2, "send0x265 --> tinyIDList is null Or size is 0");
    return;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  public void a(NewIntent paramNewIntent)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      QLog.w("QavNetChannel", 1, "sendMsg, Exception", paramNewIntent);
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lli != null;
  }
  
  public boolean a(String paramString)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = this.b;
    return (this.jdField_a_of_type_JavaLangString != null) && (paramString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString)) && (i - j < 3);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendGetGatewayMsg");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QavNetChannel", 2, String.format("receiveSharpVideoOfflineMsg data=%s", new Object[] { paramBundle }));
      }
      e();
      byte[] arrayOfByte = paramBundle.getByteArray("buffer");
      bool = paramBundle.getBoolean("isRequest");
      i(paramBundle);
      long l = paramBundle.getLong("msf_timestamp");
      paramBundle = paramBundle.getString("fromUin");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramBundle, l);
      QLog.d("QavNetChannel", 1, "quaReport --> receiveSharpVideoOfflineMsg msf_timestamp = " + l);
      int i = receiveSharpVideoCall(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
      if (QLog.isColorLevel()) {
        QLog.d("QavNetChannel", 2, "receiveSharpVideoCall result: " + i + ", buf.length: " + arrayOfByte.length);
      }
    } while ((!bool) || (this.jdField_a_of_type_Int != -1));
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    lfe locallfe = lbz.a().a();
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), locallfe.d, paramArrayOfByte);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.b = 0;
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    e();
    if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
      return;
    }
    paramBundle = paramBundle.getByteArray("buffer");
    this.jdField_a_of_type_ComTencentAvVideoController.J();
    receiveMultiVideoMsg(3, paramBundle);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Lli != null);
      this.jdField_a_of_type_Lli = new lli(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      lbz.a().a().j = 9500;
    } while (!QLog.isColorLevel());
    QLog.w("BaseIMSharp", 2, "init device sharp");
  }
  
  public void d(Bundle paramBundle) {}
  
  public void e(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    String str;
    do
    {
      do
      {
        return;
        e();
        byte[] arrayOfByte = paramBundle.getByteArray("buffer");
        str = paramBundle.getString("fromUin");
        boolean bool = paramBundle.getBoolean("isFriend");
        int i = receiveSharpVideoCall(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
        if (QLog.isColorLevel()) {
          QLog.d("QavNetChannel", 2, "receiveSharpVideoMsg: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", fromUin = " + str + ", result = " + i + ",isFriend:" + bool);
        }
        this.jdField_a_of_type_Int = 0;
        paramBundle = lbz.a().a();
      } while ((paramBundle.j != 1006) || (paramBundle.e) || (TextUtils.equals(str, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())));
      paramBundle.f = str;
    } while (!QLog.isColorLevel());
    QLog.d("QavNetChannel", 2, "receiveSharpVideoMsg: CONTACT_STRANGER_FRIEND  peerUin = " + str);
  }
  
  public void f(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    int i;
    do
    {
      return;
      e();
      paramBundle = paramBundle.getByteArray("buffer");
      i = receiveSharpVideoAck(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramBundle, null);
    } while (!QLog.isColorLevel());
    QLog.d("QavNetChannel", 2, "receiveSharpVideoAck: result = " + i);
  }
  
  public void g(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoMsg buf=%s", new Object[] { paramBundle }));
    }
    e();
    this.jdField_a_of_type_ComTencentAvVideoController.J();
    receiveMultiVideoMsg(1, paramBundle);
  }
  
  public void h(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoAck buf=%s", new Object[] { paramBundle }));
    }
    e();
    this.jdField_a_of_type_ComTencentAvVideoController.J();
    ThreadManager.executeOnSubThread(new QavChannelProxy.1(this, paramBundle));
  }
  
  public void i(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("fromUin");
    this.b = ((int)(System.currentTimeMillis() / 1000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lby
 * JD-Core Version:    0.7.0.1
 */