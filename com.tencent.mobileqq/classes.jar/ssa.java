import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class ssa
  implements RecyclerView.OnChildAttachStateChangeListener
{
  ssa(srs paramsrs) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (srk)srs.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == srs.a(this.a)))
    {
      paramView.b();
      ved.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (srk)srs.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == srs.a(this.a)))
    {
      paramView.c();
      ved.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssa
 * JD-Core Version:    0.7.0.1
 */