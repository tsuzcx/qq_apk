import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tribe.async.reactive.SimpleObserver;

class nrm
  extends SimpleObserver
{
  nrm(nrl paramnrl) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    IconLog.b(nrl.a(this.a), "onNext, oldResult=%s, newResult=%s", nrl.a(this.a), paramBitmap);
    nrl.a(this.a, paramBitmap);
    nrl.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    IconLog.a(nrl.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    IconLog.c(nrl.a(this.a), "onError, oldError=%s, newError=%s", nrl.a(this.a), paramError);
    nrl.a(this.a, paramError);
    nrl.a(this.a, SystemClock.uptimeMillis());
    nrl.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrm
 * JD-Core Version:    0.7.0.1
 */