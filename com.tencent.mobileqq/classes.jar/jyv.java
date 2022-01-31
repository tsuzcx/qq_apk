import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jyv
  implements MultiVideoMembersClickListener
{
  public jyv(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  private void b()
  {
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null)
    {
      localIntent = new Intent(localAVActivity, MultiVideoMembersListviewAvtivity.class);
      localIntent.putExtra("uinType", this.a.jdField_c_of_type_Int);
      localIntent.putExtra("RelationUin", String.valueOf(this.a.b));
      localAVActivity.startActivity(localIntent);
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
    }
    QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "startMembersListViewPage-->can not get activity");
  }
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.a);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 17) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jyv
 * JD-Core Version:    0.7.0.1
 */