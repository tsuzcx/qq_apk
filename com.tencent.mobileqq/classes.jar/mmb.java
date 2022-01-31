import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.image.AbstractGifImage;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class mmb
  implements AbsListView.OnScrollListener
{
  public mmb(FastWebActivity paramFastWebActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      int i = FastWebActivity.a(this.a).getFirstVisiblePosition();
      FastWebActivity.c(this.a);
      FastWebActivity.a(this.a, i);
    }
    for (;;)
    {
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      }
      return;
      AbstractGifImage.pauseAll();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmb
 * JD-Core Version:    0.7.0.1
 */