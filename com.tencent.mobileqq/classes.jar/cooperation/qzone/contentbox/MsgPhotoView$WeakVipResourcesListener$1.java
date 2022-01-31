package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bhcy;
import bhyf;
import java.lang.ref.WeakReference;

public class MsgPhotoView$WeakVipResourcesListener$1
  implements Runnable
{
  public MsgPhotoView$WeakVipResourcesListener$1(bhcy parambhcy, Drawable paramDrawable) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)bhcy.a(this.this$0).get();
    if ((localImageView != null) && (this.a != null))
    {
      localImageView.setImageDrawable(this.a);
      localImageView.setVisibility(0);
      if (!bhcy.a(this.this$0)) {
        if (bhcy.a(this.this$0) != 2) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 11;; i = 10)
    {
      bhyf.a(i, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener.1
 * JD-Core Version:    0.7.0.1
 */