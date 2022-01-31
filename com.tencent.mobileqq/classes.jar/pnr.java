import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class pnr
  implements RecyclerView.OnChildAttachStateChangeListener
{
  pnr(pno parampno) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView instanceof Container))
    {
      if (pno.a(this.a) != null)
      {
        int j = pno.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          Iterator localIterator = ((Container)pno.a(this.a).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject).getValue() instanceof ply))
            {
              localObject = (ply)((Map.Entry)localObject).getValue();
              if ((((ply)localObject).a() instanceof NativeVideoView))
              {
                localObject = ((ply)localObject).a();
                if (localObject != null) {
                  ((NativeVideoView)localObject).setVideoPlayListener(new pns(this));
                }
              }
            }
          }
          i += 1;
        }
      }
      oxq.a((Container)paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    if ((paramView instanceof Container)) {
      oxq.b((Container)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pnr
 * JD-Core Version:    0.7.0.1
 */