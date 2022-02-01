import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class qen
  implements RecyclerView.OnChildAttachStateChangeListener
{
  qen(qek paramqek) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView instanceof Container))
    {
      if (qek.a(this.a) != null)
      {
        int j = qek.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          Iterator localIterator = ((Container)qek.a(this.a).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject).getValue() instanceof qcr))
            {
              localObject = (qcr)((Map.Entry)localObject).getValue();
              if ((((qcr)localObject).a() instanceof NativeVideoView))
              {
                localObject = ((qcr)localObject).a();
                if (localObject != null) {
                  ((NativeVideoView)localObject).setVideoPlayListener(new qeo(this));
                }
              }
            }
          }
          i += 1;
        }
      }
      pmd.a((Container)paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    if ((paramView instanceof Container)) {
      pmd.b((Container)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qen
 * JD-Core Version:    0.7.0.1
 */