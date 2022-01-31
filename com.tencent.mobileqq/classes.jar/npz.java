import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tribe.async.reactive.SimpleObserver;

class npz
  extends SimpleObserver
{
  npz(npy paramnpy) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    IconLog.b(npy.a(this.a), "onNext, oldResult=%s, newResult=%s", npy.a(this.a), paramBitmap);
    npy.a(this.a, paramBitmap);
    npy.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    IconLog.a(npy.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    IconLog.c(npy.a(this.a), "onError, oldError=%s, newError=%s", npy.a(this.a), paramError);
    npy.a(this.a, paramError);
    npy.a(this.a, SystemClock.uptimeMillis());
    npy.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npz
 * JD-Core Version:    0.7.0.1
 */