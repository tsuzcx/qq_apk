import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class qwq
  implements RecyclerView.OnChildAttachStateChangeListener
{
  qwq(qwn paramqwn) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView instanceof Container))
    {
      if (qwn.a(this.a) != null)
      {
        int j = qwn.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          Iterator localIterator = ((Container)qwn.a(this.a).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject).getValue() instanceof qut))
            {
              localObject = (qut)((Map.Entry)localObject).getValue();
              if ((((qut)localObject).a() instanceof NativeVideoView))
              {
                localObject = ((qut)localObject).a();
                if (localObject != null) {
                  ((NativeVideoView)localObject).setVideoPlayListener(new qwr(this));
                }
              }
            }
          }
          i += 1;
        }
      }
      qcn.a((Container)paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    if ((paramView instanceof Container)) {
      qcn.b((Container)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwq
 * JD-Core Version:    0.7.0.1
 */