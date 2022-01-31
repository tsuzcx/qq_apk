import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mfw
  implements mrx
{
  public mfw(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  private void b()
  {
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null) {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().ab))
      {
        bool = true;
        VideoMsgTools.a(localAVActivity, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), bool, true);
        axqw.b(null, "CliOper", "", "", "0X8009E27", "0X8009E27", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    QLog.e(this.a.c, 2, "startMembersListViewPage-->can not get activity");
  }
  
  public void a()
  {
    long l = AudioHelper.b();
    this.a.z(l);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 7) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfw
 * JD-Core Version:    0.7.0.1
 */