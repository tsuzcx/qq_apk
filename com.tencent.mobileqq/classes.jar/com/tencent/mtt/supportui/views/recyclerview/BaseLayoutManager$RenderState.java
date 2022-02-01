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
    int m = this.mScrapList.size();
    int i = 2147483647;
    int j = 0;
    Object localObject1 = null;
    Object localObject2;
    int k;
    for (;;)
    {
      if (j < m)
      {
        localObject2 = (RecyclerViewBase.ViewHolder)this.mScrapList.get(j);
        k = (((RecyclerViewBase.ViewHolder)localObject2).getPosition() - this.mCurrentPosition) * this.mItemDirection;
        if (k < 0) {
          j += 1;
        } else if (k < i) {
          if (k != 0) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        this.mCurrentPosition = (((RecyclerViewBase.ViewHolder)localObject2).getPosition() + this.mItemDirection);
        return ((RecyclerViewBase.ViewHolder)localObject2).itemView;
      }
      return null;
      localObject1 = localObject2;
      i = k;
      break;
      break;
      localObject2 = localObject1;
    }
  }
  
  public int hasMore(RecyclerViewBase.State paramState)
  {
    int i = 1;
    if (this.mCurrentPosition < 0) {
      if (Math.abs(this.mCurrentPosition) <= paramState.mHeaderCount) {
        i = 2;
      }
    }
    do
    {
      return i;
      if (this.mCurrentPosition < paramState.getItemCount()) {
        break;
      }
    } while (Math.abs(this.mCurrentPosition) - paramState.getItemCount() >= paramState.mFooterCount);
    return 4;
    return 3;
  }
  
  public void log()
  {
    log("");
  }
  
  public void log(String paramString)
  {
    Log.d("TMYGRID", paramString + "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection + ", scrollOffset:" + this.mScrollingOffset);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.RenderState
 * JD-Core Version:    0.7.0.1
 */