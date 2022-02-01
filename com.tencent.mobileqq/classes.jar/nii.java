import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class nii
  extends mya
{
  public nii(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void a(boolean paramBoolean, long paramLong, List<nil> paramList, int paramInt1, List<Long> paramList1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = AVGameRoomCenterFragment.a;
      StringBuilder localStringBuilder = new StringBuilder().append("mObserver get isSuc : ").append(paramBoolean).append(" uin : ").append(paramLong).append(" playersNum:").append(paramInt1).append(" bannerlist size:");
      if (paramList != null)
      {
        paramString = Integer.valueOf(paramList.size());
        QLog.d((String)localObject, 2, paramString);
      }
    }
    else
    {
      if (!paramBoolean) {
        return;
      }
      paramInt2 = 0;
      label93:
      if (paramInt2 >= AVGameRoomCenterFragment.a(this.a).a()) {
        break label311;
      }
      if (AVGameRoomCenterFragment.a(this.a).a(paramInt2) != null) {
        break label139;
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label93;
      paramString = "";
      break;
      label139:
      switch (AVGameRoomCenterFragment.a(this.a).a(paramInt2).a())
      {
      default: 
        break;
      case 0: 
        paramString = (myv)AVGameRoomCenterFragment.a(this.a).a(paramInt2);
        if (paramString != null) {
          paramString.a(paramList);
        }
        break;
      case 1: 
        paramString = (myx)AVGameRoomCenterFragment.a(this.a).a(paramInt2);
        if ((paramString != null) && (paramList1 != null))
        {
          paramString.a(paramInt1);
          localObject = new String[paramList1.size()];
          int i = 0;
          while (i < paramList1.size())
          {
            localObject[i] = ((Long)paramList1.get(i)).toString();
            i += 1;
          }
          paramString.a((String[])localObject);
        }
        break;
      }
    }
    label311:
    AVGameRoomCenterFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nii
 * JD-Core Version:    0.7.0.1
 */