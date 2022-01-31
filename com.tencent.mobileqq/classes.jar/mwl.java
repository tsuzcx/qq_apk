import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter.FeedItemCellHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class mwl
  implements AbsListView.OnScrollListener
{
  public mwl(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      DropFrameMonitor.a().a("list_subscript");
    }
    for (;;)
    {
      return;
      DropFrameMonitor.a().a("list_subscript", false);
      paramInt = 0;
      while (paramInt <= paramAbsListView.getChildCount())
      {
        Object localObject = paramAbsListView.getChildAt(paramInt);
        if ((localObject != null) && ((((View)localObject).getTag() instanceof SubscriptFeedsAdapter.FeedItemCellHolder)))
        {
          localObject = (SubscriptFeedsAdapter.FeedItemCellHolder)((View)localObject).getTag();
          Drawable localDrawable = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).b.getDrawable();
          if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)) && (!((URLDrawable)localDrawable).isDownloadStarted()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SubscriptFeedsActivity", 2, "list child view start download pic!  uin : " + ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).a);
            }
            ((URLDrawable)localDrawable).startDownload();
            ((URLDrawable)localDrawable).setAutoDownload(true);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwl
 * JD-Core Version:    0.7.0.1
 */