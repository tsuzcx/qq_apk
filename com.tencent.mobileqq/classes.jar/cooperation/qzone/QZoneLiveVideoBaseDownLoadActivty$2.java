package cooperation.qzone;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class QZoneLiveVideoBaseDownLoadActivty$2
  implements URLDrawable.URLDrawableListener
{
  QZoneLiveVideoBaseDownLoadActivty$2(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QZoneLiveVideoBaseDownLoadActivty.access$000(this.this$0).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty.2
 * JD-Core Version:    0.7.0.1
 */