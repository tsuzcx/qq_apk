package com.tencent.mobileqq.kandian.biz.comment;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import java.util.List;

public class ReadInJoyCommentItemHeightHelper
  implements ReadinjoyCommentListBaseAdapter.OnGetViewListener
{
  private ReadInJoyCommentListView a;
  private List<CommentViewItem> b;
  
  public ReadInJoyCommentItemHeightHelper(ReadInJoyCommentListView paramReadInJoyCommentListView, List<CommentViewItem> paramList, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    this.a = paramReadInJoyCommentListView;
    this.b = paramList;
    paramReadinjoyCommentListBaseAdapter.a(this);
  }
  
  private ReadinjoyCommentListBaseAdapter a()
  {
    Object localObject = this.a;
    if ((localObject != null) && ((((ReadInJoyCommentListView)localObject).getAdapter() instanceof HeaderViewListAdapter)))
    {
      localObject = (HeaderViewListAdapter)this.a.getAdapter();
      if ((((HeaderViewListAdapter)localObject).getWrappedAdapter() instanceof ReadinjoyCommentListBaseAdapter)) {
        return (ReadinjoyCommentListBaseAdapter)((HeaderViewListAdapter)localObject).getWrappedAdapter();
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if ((localObject != null) && (paramInt1 < ((List)localObject).size()) && (this.b.get(paramInt1) != null))
    {
      ((CommentViewItem)this.b.get(paramInt1)).j = paramInt2;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setHeight | postion ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" itemHeight ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int b(int paramInt)
  {
    int j = this.a.getWidth();
    int i = Utils.dp2px(300.0D);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    if ((Build.VERSION.SDK_INT <= 19) && (paramInt == 0)) {
      return i;
    }
    Object localObject = a();
    if (localObject == null) {
      return i;
    }
    try
    {
      localObject = ((ReadinjoyCommentListBaseAdapter)localObject).a(paramInt, null, this.a, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItemMeasureHeight index : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" height : ");
      ((StringBuilder)localObject).append(j);
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, ((StringBuilder)localObject).toString());
      return j;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" index : ");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, localException, new Object[] { localStringBuilder.toString() });
    }
    return i;
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.b;
      if ((localObject == null) || (((List)localObject).size() > paramInt))
      {
        localObject = (CommentViewItem)this.b.get(paramInt);
        if (((CommentViewItem)localObject).j > 0) {
          return ((CommentViewItem)localObject).j;
        }
        ((CommentViewItem)localObject).j = b(paramInt);
        return ((CommentViewItem)localObject).j;
      }
    }
    return -1;
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "onGetView view is null");
      return;
    }
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(new ReadInJoyCommentItemHeightHelper.1(this, paramInt, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentItemHeightHelper
 * JD-Core Version:    0.7.0.1
 */