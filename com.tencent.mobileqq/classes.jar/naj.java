import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class naj
  extends mwt
{
  private final WeakReference<Handler> a;
  
  naj(Handler paramHandler)
  {
    this.a = new WeakReference(paramHandler);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNetTypeChange, [" + paramInt1 + "-->" + paramInt2 + "]");
    }
    Handler localHandler = (Handler)this.a.get();
    if ((localHandler != null) && (paramInt2 != 1) && (paramInt1 == 1)) {
      localHandler.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     naj
 * JD-Core Version:    0.7.0.1
 */