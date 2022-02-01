import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.qphone.base.util.QLog;

public class npr
  extends ndm
{
  public npr(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void a(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    AvGameLoadingActivity.a(this.a, true, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchNotify isSuc:%b type:%d roomId:%d mWaitingStrangerMatchPush:%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(AvGameLoadingActivity.c(this.a)) }));
    }
    if (AvGameLoadingActivity.c(this.a))
    {
      AvGameLoadingActivity.a(this.a, false);
      AvGameLoadingActivity.a(this.a, -1);
      this.a.a.removeMessages(9);
      if (paramBoolean)
      {
        bdla.b(null, "dc00898", "", "", "0X800B495", "0X800B495", 0, 0, "", "", "", "");
        if (paramInt != 1) {
          break label144;
        }
        AvGameLoadingActivity.a(this.a, AvGameLoadingActivity.a(this.a), null);
      }
    }
    label144:
    while (paramInt != 2) {
      return;
    }
    AvGameLoadingActivity.b(this.a, AvGameLoadingActivity.c(this.a, 6));
    AvGameLoadingActivity.a(this.a, AvGameLoadingActivity.a(this.a), String.valueOf(paramLong), null);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchStart isSuc:%b uin:%d shareId:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if ((AvGameLoadingActivity.a(this.a)) && (!AvGameLoadingActivity.b(this.a)))
    {
      if (paramBoolean)
      {
        AvGameLoadingActivity.a(this.a, true);
        AvGameLoadingActivity.a(this.a, paramInt1);
      }
    }
    else {
      return;
    }
    if (paramInt2 == 601) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {
        paramString = this.a.getString(2131690444);
      }
      for (;;)
      {
        AvGameLoadingActivity.a(this.a, null, paramString, this.a.getString(2131690469), new nps(this), null, null);
        bdla.b(null, "dc00898", "", "", "0X800B496", "0X800B496", paramInt2, 0, "", "", "", "");
        return;
      }
      paramString = null;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchStop isSuc:%b uin:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString }));
    }
  }
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    AvGameLoadingActivity.a(this.a, false, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npr
 * JD-Core Version:    0.7.0.1
 */