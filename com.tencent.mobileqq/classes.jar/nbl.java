import android.os.Handler;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.QLog;

class nbl
  extends mxw
{
  nbl(nbk paramnbk) {}
  
  public void a()
  {
    int i = lev.b();
    if (myk.a().a()) {
      this.a.a.sendEmptyMessageDelayed(8, 0L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onEnterRoomSucess, curNetType[" + i + "]");
      }
      return;
      this.a.a.sendEmptyMessageDelayed(8, 3000L);
      this.a.a.sendEmptyMessageDelayed(9, 6000L);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    nbk.a(this.a);
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    nbk.a(this.a);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 1, "onMemberVideoInOrOut userUin:" + paramLong + "  videoIn:" + paramBoolean + "  videoSrcType:" + paramInt);
    }
    this.a.a.sendEmptyMessage(2);
    nbk.a(this.a);
    this.a.a(250);
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    this.a.a(250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbl
 * JD-Core Version:    0.7.0.1
 */