package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import cooperation.vip.VipReporterManager;
import java.lang.ref.WeakReference;

class MsgPhotoView$WeakVipResourcesListener$1
  implements Runnable
{
  MsgPhotoView$WeakVipResourcesListener$1(MsgPhotoView.WeakVipResourcesListener paramWeakVipResourcesListener, Drawable paramDrawable) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)MsgPhotoView.WeakVipResourcesListener.access$500(this.this$0).get();
    if (localImageView != null)
    {
      Drawable localDrawable = this.val$drawable;
      if (localDrawable != null)
      {
        localImageView.setImageDrawable(localDrawable);
        localImageView.setVisibility(0);
        if (!MsgPhotoView.WeakVipResourcesListener.access$600(this.this$0))
        {
          int i;
          if (MsgPhotoView.WeakVipResourcesListener.access$700(this.this$0) == 2) {
            i = 11;
          } else {
            i = 10;
          }
          VipReporterManager.a(i, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener.1
 * JD-Core Version:    0.7.0.1
 */