import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class stk
  implements bhtv
{
  public stk(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      abvl.a().a("list_subscript");
    }
    for (;;)
    {
      return;
      abvl.a().a("list_subscript", false);
      paramInt = 0;
      while (paramInt <= paramAbsListView.getChildCount())
      {
        Object localObject = paramAbsListView.getChildAt(paramInt);
        if ((localObject != null) && ((((View)localObject).getTag() instanceof stp)))
        {
          localObject = (stp)((View)localObject).getTag();
          Drawable localDrawable = ((stp)localObject).b.getDrawable();
          if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)) && (!((URLDrawable)localDrawable).isDownloadStarted()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SubscriptFeedsActivity", 2, "list child view start download pic!  uin : " + ((stp)localObject).a);
            }
            ((URLDrawable)localDrawable).startDownload();
            ((URLDrawable)localDrawable).setAutoDownload(true);
          }
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stk
 * JD-Core Version:    0.7.0.1
 */