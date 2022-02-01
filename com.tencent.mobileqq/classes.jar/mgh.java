import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.3.1;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class mgh
  extends lee
{
  public mgh(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    int j = 3;
    if (this.a.h()) {
      return;
    }
    if (paramLong2 != this.a.b)
    {
      QLog.i(this.a.jdField_d_of_type_JavaLangString, 1, "onCreateRoomSuc, not right session. [" + paramLong2 + "," + this.a.b + "]");
      return;
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onCreateRoomSuc, GroupID[" + paramLong2 + "], seq[" + paramLong1 + "], sessionId[" + ((lfe)localObject).c + "]");
    if (this.a.jdField_e_of_type_Boolean) {}
    for (int i = 4;; i = 3)
    {
      mmo.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      i = j;
      if (this.a.jdField_e_of_type_Boolean) {
        i = 4;
      }
      bdks.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.x();
      this.a.r(paramLong1);
      this.a.jdField_a_of_type_Muk.c(true);
      this.a.jdField_a_of_type_Muk.b(true);
      this.a.jdField_a_of_type_Muk.a();
      ((lfe)localObject).al = true;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.b);
      if (((lfe)localObject).ad != 4) {
        break;
      }
      localObject = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject == null) || (((AVActivity)localObject).isFinishing())) {
        break;
      }
      ((AVActivity)localObject).runOnUiThread(new MultiVideoCtrlLayerUI4NewGroupChat.3.1(this, paramLong1));
      return;
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramLong2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_d_of_type_JavaLangString, 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.a.jdField_e_of_type_Int != 1) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.a.jdField_d_of_type_Int);
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
    QLog.e(this.a.jdField_d_of_type_JavaLangString, 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    this.a.i(0L, 16777215);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.a.b(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    int j = 4;
    if (this.a.h()) {
      return;
    }
    QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onEnterRoomSuc, GroupID[" + paramLong2 + "], seq[" + paramLong1 + "]");
    if (this.a.jdField_e_of_type_Boolean)
    {
      i = 4;
      mmo.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_e_of_type_Boolean) {
        break label257;
      }
    }
    label257:
    for (int i = j;; i = 3)
    {
      bdks.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.x();
      this.a.r(paramLong1);
      this.a.jdField_a_of_type_Muk.c(true);
      this.a.jdField_a_of_type_Muk.b(true);
      this.a.jdField_a_of_type_Muk.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable(this.a), 500L);
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.a);
      this.a.i(paramLong1, 16777215);
      this.a.C();
      return;
      i = 3;
      break;
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ac = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.c(this.a);
    }
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ac = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.a);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgh
 * JD-Core Version:    0.7.0.1
 */