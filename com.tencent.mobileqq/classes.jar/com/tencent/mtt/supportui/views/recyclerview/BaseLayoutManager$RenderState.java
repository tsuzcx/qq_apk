package com.tencent.mtt.supportui.views.recyclerview;

import android.util.Log;
import android.view.View;
import java.util.List;

public class BaseLayoutManager$RenderState
{
  public static final int FILL_TYPE_FOOTER = 4;
  public static final int FILL_TYPE_HEADER = 2;
  public static final int FILL_TYPE_NOMORE = 1;
  public static final int FILL_TYPE_NORMAL = 3;
  public static final int INVALID_LAYOUT = -2147483648;
  public static final int ITEM_DIRECTION_HEAD = -1;
  public static final int ITEM_DIRECTION_TAIL = 1;
  public static final int LAYOUT_END = 1;
  public static final int LAYOUT_NO_DIRECTION = 2147483647;
  public static final int LAYOUT_START = -1;
  public static final int SCOLLING_OFFSET_NaN = -2147483648;
  static final String TAG = "TMYGRID";
  public int mAvailable;
  public int mCurrentPosition;
  public int mExtra = 0;
  public int mItemDirection;
  public int mLayoutDirection;
  public int mOffset;
  public List<RecyclerViewBase.ViewHolder> mScrapList = null;
  public int mScrollingOffset;
  public boolean overscroll = false;
  
  private View nextFromLimitedList()
  {
    int n = this.mScrapList.size();
    int j = 2147483647;
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= n) {
        break;
      }
      localObject2 = (RecyclerViewBase.ViewHolder)this.mScrapList.get(i);
      int m = (((RecyclerViewBase.ViewHolder)localObject2).getPosition() - this.mCurrentPosition) * this.mItemDirection;
      int k;
      if (m < 0)
      {
        k = j;
      }
      else
      {
        k = j;
        if (m < j)
        {
          if (m == 0) {
            break;
          }
          localObject1 = localObject2;
          k = m;
        }
      }
      i += 1;
      j = k;
    }
    if (localObject2 != null)
    {
      this.mCurrentPosition = (((RecyclerViewBase.ViewHolder)localObject2).getPosition() + this.mItemDirection);
      return ((RecyclerViewBase.ViewHolder)localObject2).itemView;
    }
    return null;
  }
  
  public int hasMore(RecyclerViewBase.State paramState)
  {
    int i = this.mCurrentPosition;
    if (i < 0)
    {
      if (Math.abs(i) <= paramState.mHeaderCount) {
        return 2;
      }
      return 1;
    }
    if (i >= paramState.getItemCount())
    {
      if (Math.abs(this.mCurrentPosition) - paramState.getItemCount() < paramState.mFooterCount) {
        return 4;
      }
      return 1;
    }
    return 3;
  }
  
  public void log()
  {
    log("");
  }
  
  public void log(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("avail:");
    localStringBuilder.append(this.mAvailable);
    localStringBuilder.append(", ind:");
    localStringBuilder.append(this.mCurrentPosition);
    localStringBuilder.append(", dir:");
    localStringBuilder.append(this.mItemDirection);
    localStringBuilder.append(", offset:");
    localStringBuilder.append(this.mOffset);
    localStringBuilder.append(", layoutDir:");
    localStringBuilder.append(this.mLayoutDirection);
    localStringBuilder.append(", scrollOffset:");
    localStringBuilder.append(this.mScrollingOffset);
    Log.d("TMYGRID", localStringBuilder.toString());
  }
  
  public View next(RecyclerViewBase.Recycler paramRecycler)
  {
    if (this.mScrapList != null) {
      return nextFromLimitedList();
    }
    paramRecycler = paramRecycler.getViewForPosition(this.mCurrentPosition);
    this.mCurrentPosition += this.mItemDirection;
    return paramRecycler;
  }
  
  public View nextFooter(RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    paramRecycler = paramRecycler.getFooterForPosition(Math.abs(this.mCurrentPosition) - paramState.getItemCount() + 1);
    this.mCurrentPosition += this.mItemDirection;
    return paramRecycler;
  }
  
  public View nextHeader(RecyclerViewBase.Recycler paramRecycler)
  {
    paramRecycler = paramRecycler.getHeaderForPosition(Math.abs(this.mCurrentPosition));
    this.mCurrentPosition += this.mItemDirection;
    return paramRecycler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.RenderState
 * JD-Core Version:    0.7.0.1
 */