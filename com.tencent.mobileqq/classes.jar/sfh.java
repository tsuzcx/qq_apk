import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class sfh
  implements RecyclerView.OnChildAttachStateChangeListener
{
  sfh(sez paramsez) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (ser)sez.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == sez.a(this.a)))
    {
      paramView.b();
      urk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (ser)sez.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == sez.a(this.a)))
    {
      paramView.c();
      urk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */