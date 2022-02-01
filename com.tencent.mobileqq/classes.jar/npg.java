import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class npg
  implements ney
{
  public npg(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void a(View paramView, nel paramnel, int paramInt)
  {
    if (paramnel == null) {}
    label167:
    do
    {
      do
      {
        return;
        if (nob.a())
        {
          QQToast.a(this.a.getActivity(), 2131690409, 0).a();
          return;
        }
        paramnel = (nek)paramnel;
        QLog.d(AVGameRoomCenterFragment.a, 2, "getTimeType is " + paramnel.b());
        if (paramView.getId() == 2131363226)
        {
          AVGameRoomCenterFragment localAVGameRoomCenterFragment;
          if (!paramnel.b())
          {
            localAVGameRoomCenterFragment = this.a;
            paramInt = paramnel.c();
            if (paramnel.b()) {
              break label167;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            AVGameRoomCenterFragment.a(localAVGameRoomCenterFragment, paramInt, bool);
            paramnel.b(false);
            paramView.setClickable(false);
            bdla.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(AVGameRoomCenterFragment.a, 2, "reserve button click");
            return;
          }
        }
        if (paramnel.b() != 3) {
          break;
        }
        this.a.a(paramnel.c());
      } while (!QLog.isColorLevel());
      QLog.d(AVGameRoomCenterFragment.a, 2, "reserve item click");
      return;
      QQToast.a(this.a.getActivity(), 0, 2131690413, 0).a();
    } while (!QLog.isColorLevel());
    QLog.d(AVGameRoomCenterFragment.a, 2, "reserve item click err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npg
 * JD-Core Version:    0.7.0.1
 */