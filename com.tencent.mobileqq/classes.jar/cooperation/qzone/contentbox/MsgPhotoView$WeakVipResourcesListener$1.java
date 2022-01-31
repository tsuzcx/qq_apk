package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bhch;
import bhxo;
import java.lang.ref.WeakReference;

public class MsgPhotoView$WeakVipResourcesListener$1
  implements Runnable
{
  public MsgPhotoView$WeakVipResourcesListener$1(bhch parambhch, Drawable paramDrawable) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)bhch.a(this.this$0).get();
    if ((localImageView != null) && (this.a != null))
    {
      localImageView.setImageDrawable(this.a);
      localImageView.setVisibility(0);
      if (!bhch.a(this.this$0)) {
        if (bhch.a(this.this$0) != 2) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 11;; i = 10)
    {
      bhxo.a(i, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener.1
 * JD-Core Version:    0.7.0.1
 */