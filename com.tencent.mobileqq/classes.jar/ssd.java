import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class ssd
  implements RecyclerView.OnChildAttachStateChangeListener
{
  ssd(srv paramsrv) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (srn)srv.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == srv.a(this.a)))
    {
      paramView.b();
      veg.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (srn)srv.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == srv.a(this.a)))
    {
      paramView.c();
      veg.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssd
 * JD-Core Version:    0.7.0.1
 */