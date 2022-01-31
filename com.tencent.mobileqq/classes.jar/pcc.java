import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class pcc
  implements RecyclerView.OnChildAttachStateChangeListener
{
  pcc(pbz parampbz) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView instanceof Container))
    {
      if (pbz.a(this.a) != null)
      {
        int j = pbz.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          Iterator localIterator = ((Container)pbz.a(this.a).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject).getValue() instanceof paj))
            {
              localObject = (paj)((Map.Entry)localObject).getValue();
              if ((((paj)localObject).getNativeView() instanceof NativeVideoView))
              {
                localObject = (NativeVideoView)((paj)localObject).getNativeView();
                if (localObject != null) {
                  ((NativeVideoView)localObject).setVideoPlayListener(new pcd(this));
                }
              }
            }
          }
          i += 1;
        }
      }
      omf.a((Container)paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    if ((paramView instanceof Container)) {
      omf.b((Container)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcc
 * JD-Core Version:    0.7.0.1
 */