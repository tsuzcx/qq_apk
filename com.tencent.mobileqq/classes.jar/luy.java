import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class luy
  extends kur
{
  public luy(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    int j = 4;
    if (this.a.g()) {
      return;
    }
    QLog.w(this.a.c, 1, "onCreateRoomSuc, GroupID[" + paramLong2 + "], seq[" + paramLong1 + "]");
    if (this.a.jdField_e_of_type_Boolean)
    {
      i = 4;
      mba.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_e_of_type_Boolean) {
        break label237;
      }
    }
    label237:
    for (int i = j;; i = 3)
    {
      awqp.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.w();
      this.a.o(paramLong1);
      this.a.jdField_a_of_type_Mig.c(true);
      this.a.jdField_a_of_type_Mig.b(true);
      this.a.jdField_a_of_type_Mig.a();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.b);
      return;
      i = 3;
      break;
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramLong2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.a.jdField_e_of_type_Int != 1) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.a.d);
      localIntent.putExtra("info", paramLong2);
      localIntent.putExtra("strMsg", paramString);
      localIntent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
      paramString = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        paramString.sendBroadcast(localIntent);
        MultiVideoCtrlLayerUI4NewGroupChat.b(this.a, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.a.c, 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    this.a.f(0L, 65535);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.a.a(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    int j = 4;
    if (this.a.g()) {
      return;
    }
    QLog.w(this.a.c, 1, "onEnterRoomSuc, GroupID[" + paramLong2 + "], seq[" + paramLong1 + "]");
    if (this.a.jdField_e_of_type_Boolean)
    {
      i = 4;
      mba.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_e_of_type_Boolean) {
        break label257;
      }
    }
    label257:
    for (int i = j;; i = 3)
    {
      awqp.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.w();
      this.a.o(paramLong1);
      this.a.jdField_a_of_type_Mig.c(true);
      this.a.jdField_a_of_type_Mig.b(true);
      this.a.jdField_a_of_type_Mig.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable(this.a), 500L);
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.a);
      this.a.f(paramLong1, 65535);
      this.a.B();
      return;
      i = 3;
      break;
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().A == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.c(this.a);
    }
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().A == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.a);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     luy
 * JD-Core Version:    0.7.0.1
 */