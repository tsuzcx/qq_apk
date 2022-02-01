import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class npc
  extends ndm
{
  public npc(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListObserver", 2, "onPkProcessRestart");
    }
    AVGameRoomCenterFragment.a(this.a, true);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AVGameRoomCenterFragment.a, 2, "onReservePKGame mObserver get isSuc : " + paramBoolean + " errorCode: " + paramInt2 + " pkId: " + paramInt1);
    }
    paramInt2 = 0;
    if (paramInt2 < AVGameRoomCenterFragment.a(this.a).a())
    {
      if (AVGameRoomCenterFragment.a(this.a).a(paramInt2) == null) {}
      do
      {
        do
        {
          paramInt2 += 1;
          break;
          paramString = AVGameRoomCenterFragment.a(this.a).a(paramInt2);
        } while (!(paramString instanceof nek));
        paramString = (nek)paramString;
      } while (paramString.c() != paramInt1);
      if (paramBoolean) {
        if (paramString.b()) {
          break label207;
        }
      }
      label207:
      for (boolean bool = true;; bool = false)
      {
        paramString.a(bool);
        if (paramString.b()) {
          AVGameRoomCenterFragment.a(this.a, this.a.getString(2131690412), this.a.getString(2131690411), this.a.getString(2131690469), new npd(this), null, null);
        }
        paramString.b(true);
        break;
      }
    }
    AVGameRoomCenterFragment.a(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, long paramLong, List<nph> paramList, npi paramnpi, List<nek> paramList1, int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = AVGameRoomCenterFragment.a;
      StringBuilder localStringBuilder = new StringBuilder().append("onGameLobbyInfo mObserver get isSuc : ").append(paramBoolean).append("errorCode: ").append(paramInt).append(" uin: ").append(paramLong).append(" bannerlist size:");
      if (paramList != null)
      {
        paramString = Integer.valueOf(paramList.size());
        localStringBuilder = localStringBuilder.append(paramString).append(" pkCardInfos size:");
        if (paramList1 == null) {
          break label170;
        }
        paramString = Integer.valueOf(paramList1.size());
        label101:
        QLog.d((String)localObject, 2, paramString);
      }
    }
    else
    {
      if (!paramBoolean) {
        return;
      }
      paramInt = 0;
      label124:
      if (paramInt >= AVGameRoomCenterFragment.a(this.a).a()) {
        break label363;
      }
      if (AVGameRoomCenterFragment.a(this.a).a(paramInt) != null) {
        break label177;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label124;
      paramString = "";
      break;
      label170:
      paramString = "";
      break label101;
      label177:
      switch (AVGameRoomCenterFragment.a(this.a).a(paramInt).a())
      {
      default: 
        break;
      case 0: 
        paramString = (neh)AVGameRoomCenterFragment.a(this.a).a(paramInt);
        if (paramString != null) {
          paramString.a(paramList);
        }
        break;
      case 1: 
        paramString = (nej)AVGameRoomCenterFragment.a(this.a).a(paramInt);
        if ((paramString != null) && (paramnpi != null))
        {
          paramString.a(paramnpi.jdField_a_of_type_Int);
          localObject = new String[paramnpi.jdField_a_of_type_JavaUtilList.size()];
          int i = 0;
          while (i < paramnpi.jdField_a_of_type_JavaUtilList.size())
          {
            localObject[i] = ((Long)paramnpi.jdField_a_of_type_JavaUtilList.get(i)).toString();
            i += 1;
          }
          paramString.a((String[])localObject);
        }
        break;
      }
    }
    label363:
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      AVGameRoomCenterFragment.a(this.a).a(paramList1, 1);
      paramInt = 0;
      while (paramInt < paramList1.size())
      {
        bdla.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B68F", "0X800B68F", 0, 0, "", "", "", "");
        paramInt += 1;
      }
    }
    AVGameRoomCenterFragment.a(this.a).b();
    AVGameRoomCenterFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npc
 * JD-Core Version:    0.7.0.1
 */