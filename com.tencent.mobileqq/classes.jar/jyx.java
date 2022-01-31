import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class jyx
  extends GAudioUIObserver
{
  public jyx(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(long paramLong)
  {
    int j = 4;
    super.a(paramLong);
    QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onCreateRoomSuc, GroupID[" + paramLong + "]");
    if (this.a.f)
    {
      i = 4;
      VoiceChangeDataReport.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.f) {
        break label232;
      }
    }
    label232:
    for (int i = j;; i = 3)
    {
      MultiVideoRichActionReportCollection.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.J();
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
        MultiVideoCtrlLayerUI4NewGroupChat.c(this.a);
      }
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
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.a.d != 1) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.a.jdField_c_of_type_Int);
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
    QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    super.a(paramLong, paramBoolean, paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365396)) {
      return;
    }
    this.a.s_();
  }
  
  protected void b(long paramLong)
  {
    int j = 4;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    super.b(paramLong);
    if (this.a.f)
    {
      i = 4;
      VoiceChangeDataReport.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.f) {
        break label236;
      }
    }
    label236:
    for (int i = j;; i = 3)
    {
      MultiVideoRichActionReportCollection.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.J();
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jyy(this.a), 500L);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
        MultiVideoCtrlLayerUI4NewGroupChat.d(this.a);
      }
      MultiVideoCtrlLayerUI4NewGroupChat.e(this.a);
      return;
      i = 3;
      break;
    }
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    super.b(paramLong, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onGroupVideoChatClosed-->relationId" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      if (QLog.isColorLevel()) {
        QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onGroupVideoChatClosed--> relationId != mIntentGroupId");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.a.jdField_c_of_type_Int);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat2");
      AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        localAVActivity.sendBroadcast(localIntent);
        MultiVideoCtrlLayerUI4NewGroupChat.c(this.a, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.g(this.a);
    }
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.f(this.a);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jyx
 * JD-Core Version:    0.7.0.1
 */