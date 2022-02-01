package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.lang.ref.WeakReference;

class MsgPhotoView$WeakVipResourcesListener
  implements VipResourcesListener
{
  private WeakReference<Handler> mHandler;
  private WeakReference<ImageView> mImageView;
  private boolean mIsRepeat;
  private int mVip;
  
  public MsgPhotoView$WeakVipResourcesListener(Handler paramHandler, ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    this.mHandler = new WeakReference(paramHandler);
    this.mImageView = new WeakReference(paramImageView);
    this.mVip = paramInt;
    this.mIsRepeat = paramBoolean;
  }
  
  public void onFailed() {}
  
  public void onLoaded(Drawable paramDrawable)
  {
    Handler localHandler = (Handler)this.mHandler.get();
    if ((paramDrawable != null) && (localHandler != null)) {
      localHandler.post(new MsgPhotoView.WeakVipResourcesListener.1(this, paramDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener
 * JD-Core Version:    0.7.0.1
 */