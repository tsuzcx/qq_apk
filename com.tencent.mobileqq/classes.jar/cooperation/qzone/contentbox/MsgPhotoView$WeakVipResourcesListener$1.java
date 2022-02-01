package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bmkt;
import java.lang.ref.WeakReference;

class MsgPhotoView$WeakVipResourcesListener$1
  implements Runnable
{
  MsgPhotoView$WeakVipResourcesListener$1(MsgPhotoView.WeakVipResourcesListener paramWeakVipResourcesListener, Drawable paramDrawable) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)MsgPhotoView.WeakVipResourcesListener.access$500(this.this$0).get();
    if ((localImageView != null) && (this.val$drawable != null))
    {
      localImageView.setImageDrawable(this.val$drawable);
      localImageView.setVisibility(0);
      if (!MsgPhotoView.WeakVipResourcesListener.access$600(this.this$0)) {
        if (MsgPhotoView.WeakVipResourcesListener.access$700(this.this$0) != 2) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 11;; i = 10)
    {
      bmkt.a(i, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener.1
 * JD-Core Version:    0.7.0.1
 */