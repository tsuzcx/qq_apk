import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tribe.async.reactive.SimpleObserver;

class nwc
  extends SimpleObserver
{
  nwc(nwb paramnwb) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    IconLog.b(nwb.a(this.a), "onNext, oldResult=%s, newResult=%s", nwb.a(this.a), paramBitmap);
    nwb.a(this.a, paramBitmap);
    nwb.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    IconLog.a(nwb.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    IconLog.c(nwb.a(this.a), "onError, oldError=%s, newError=%s", nwb.a(this.a), paramError);
    nwb.a(this.a, paramError);
    nwb.a(this.a, SystemClock.uptimeMillis());
    nwb.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwc
 * JD-Core Version:    0.7.0.1
 */