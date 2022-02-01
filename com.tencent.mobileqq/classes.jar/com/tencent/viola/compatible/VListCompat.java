package com.tencent.viola.compatible;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter.VH;
import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VFooterLayout.OnFooterStateChangeListener;
import com.tencent.viola.ui.view.VRefreshLayout.OnHeaderStateChangeListener;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VListCompat
  extends VComponentCompat<VRecyclerList, DomObject>
  implements VFooterLayout.OnFooterStateChangeListener, VRefreshLayout.OnHeaderStateChangeListener
{
  public static final String ATTR_SCROLL_THROTTLE = "scrollEventThrottle";
  public static final String EVENT_EXPOSURE_REPORT = "kdExposureReport";
  public static final String EVENT_SCROLL = "kdScroll";
  public static final String EVENT_SCROLL_BEGIN_DRAG = "kdScrollBeginDrag";
  public static final String EVENT_SCROLL_END_DRAG = "kdScrollEndDrag";
  private static final String TAG = "VListCompat";
  private boolean isInStickState;
  private int lastFooterOffset;
  private long lastScrollTs;
  private int scrollState;
  
  public VListCompat(VRecyclerList paramVRecyclerList, DomObject paramDomObject)
  {
    super(paramVRecyclerList, paramDomObject);
  }
  
  private void fireScrollEvent()
  {
    fireEvent("kdScroll", getScrollParam(-1));
  }
  
  private JSONObject getDragParam()
  {
    JSONObject localJSONObject1 = getScrollParam(-1);
    JSONObject localJSONObject2 = new JSONObject();
    VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
    if (localVRecyclerView == null) {
      return localJSONObject1;
    }
    try
    {
      float f1 = -localVRecyclerView.getContentOffsetX();
      float f2 = -localVRecyclerView.getContentOffsetY();
      localJSONObject2.put("x", px2dp(f1));
      localJSONObject2.put("y", px2dp(f2));
      localJSONObject1.put("contentOffset", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ViolaLogUtils.d("VListCompat", "getDragParam error: " + localJSONException.getMessage());
      }
    }
  }
  
  private PointF getPositionInList(RecyclerView paramRecyclerView, View paramView)
  {
    PointF localPointF = new PointF();
    paramRecyclerView = paramRecyclerView.getChildViewHolder(paramView);
    if (!(paramRecyclerView instanceof VRecyclerViewAdapter.VH)) {
      return localPointF;
    }
    paramRecyclerView = ((VRecyclerViewAdapter.VH)paramRecyclerView).mVCell;
    if (paramRecyclerView == null) {
      return localPointF;
    }
    localPointF.x = ViolaUtils.getLayoutXInList(getInstanceId(), paramRecyclerView.getRef());
    localPointF.y = ViolaUtils.getLayoutYInList(getInstanceId(), paramRecyclerView.getRef());
    return localPointF;
  }
  
  private JSONObject getScrollParam(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
    if (localVRecyclerView == null) {
      return localJSONObject;
    }
    boolean bool = ((VRecyclerList)this.component).isVertical();
    int j;
    int i;
    if (bool)
    {
      j = -localVRecyclerView.getContentOffsetY();
      i = localVRecyclerView.getHeight() + j;
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        j = -paramInt;
        if (!bool) {
          break label184;
        }
        i = localVRecyclerView.getHeight() + j;
      }
      try
      {
        for (;;)
        {
          paramInt = localVRecyclerView.getFirstVisibleItemPosition();
          int k = localVRecyclerView.getLastVisibleItemPosition();
          localJSONObject.put("startEdgePos", px2dp(j));
          localJSONObject.put("endEdgePos", px2dp(i));
          localJSONObject.put("firstVisibleRowIndex", paramInt);
          localJSONObject.put("lastVisibleRowIndex", k);
          localJSONObject.put("scrollState", this.scrollState);
          localJSONObject.put("visibleRowFrames", getVisibleRowFrames(localVRecyclerView));
          return localJSONObject;
          j = -localVRecyclerView.getContentOffsetX();
          i = localVRecyclerView.getWidth() + j;
          break;
          label184:
          i = localVRecyclerView.getWidth() + j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ViolaLogUtils.d("VListCompat", "getScrollParam error: " + localException.getMessage());
        }
      }
    }
  }
  
  private JSONArray getVisibleRowFrames(RecyclerView paramRecyclerView)
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          PointF localPointF = getPositionInList(paramRecyclerView, localView);
          localJSONObject.put("x", px2dp(localPointF.x));
          localJSONObject.put("y", px2dp(localPointF.y));
          localJSONObject.put("width", px2dp(localView.getWidth()));
          localJSONObject.put("height", px2dp(localView.getHeight()));
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ViolaLogUtils.d("VListCompat", "getVisibleRowFrames error: " + localJSONException.getMessage());
          }
        }
      }
    }
    return localJSONArray;
  }
  
  private boolean needBeginEvent(int paramInt)
  {
    return ((this.scrollState == 0) && (paramInt == 1)) || ((this.scrollState == 2) && (paramInt == 1));
  }
  
  private boolean needEndEvent(int paramInt)
  {
    return (this.scrollState == 1) && ((paramInt == 2) || (paramInt == 0));
  }
  
  private boolean needFireScroll()
  {
    boolean bool = false;
    if (System.currentTimeMillis() - this.lastScrollTs >= ViolaUtils.getInt(this.dom.getAttributes().get("scrollEventThrottle"), 0)) {
      bool = true;
    }
    return bool;
  }
  
  private void onFingerRelease()
  {
    if (this.scrollState != 2)
    {
      this.scrollState = 2;
      tryFireExposedEvent();
      if ((isContainEvent("kdScrollEndDrag")) && (!this.isInStickState)) {
        fireEvent("kdScrollEndDrag", getDragParam());
      }
    }
  }
  
  private void onHeaderOrFooterMove(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      do
      {
        return;
      } while ((1 == this.scrollState) || (2 == this.scrollState) || (this.isInStickState));
      this.scrollState = 1;
      tryFireExposedEvent();
    } while (!isContainEvent("kdScrollBeginDrag"));
    fireEvent("kdScrollBeginDrag", getDragParam());
  }
  
  private void onHeaderOrFooterStateFinish()
  {
    if (this.scrollState != 0)
    {
      this.scrollState = 0;
      tryFireExposedEvent();
    }
  }
  
  private void tryFireExposedEvent()
  {
    if (isContainEvent("kdExposureReport")) {
      fireEvent("kdExposureReport", getScrollParam(-1));
    }
  }
  
  public void callExposureReport()
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    localView.post(new VListCompat.1(this));
  }
  
  public void fireScrollEvent(int paramInt)
  {
    fireEvent("kdScroll", getScrollParam(paramInt));
  }
  
  public void onFooterFingerRelease()
  {
    onFingerRelease();
  }
  
  public void onFooterFinish()
  {
    onHeaderOrFooterStateFinish();
  }
  
  public void onFooterMove(int paramInt)
  {
    ((VRecyclerView)getHostView()).performOnScroll(0, paramInt - this.lastFooterOffset);
    onHeaderOrFooterMove(paramInt);
    this.lastFooterOffset = paramInt;
  }
  
  public void onFooterReachEnd()
  {
    this.isInStickState = false;
    if (this.scrollState != 0)
    {
      this.scrollState = 0;
      tryFireExposedEvent();
    }
  }
  
  public void onHeaderFingerRelease()
  {
    onFingerRelease();
  }
  
  public void onOverScroll(int paramInt1, int paramInt2)
  {
    if ((needFireScroll()) && (isContainEvent("kdScroll")))
    {
      this.lastScrollTs = System.currentTimeMillis();
      fireScrollEvent(paramInt1);
    }
  }
  
  public void onRefreshMove(int paramInt)
  {
    onHeaderOrFooterMove(paramInt);
  }
  
  public void onScroll()
  {
    if ((needFireScroll()) && (isContainEvent("kdScroll")))
    {
      this.lastScrollTs = System.currentTimeMillis();
      fireScrollEvent();
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((needBeginEvent(paramInt)) && (isContainEvent("kdScrollBeginDrag"))) {
      fireEvent("kdScrollBeginDrag", getDragParam());
    }
    for (;;)
    {
      if (this.scrollState != paramInt)
      {
        this.scrollState = paramInt;
        tryFireExposedEvent();
      }
      return;
      if ((needEndEvent(paramInt)) && (isContainEvent("kdScrollEndDrag"))) {
        fireEvent("kdScrollEndDrag", getDragParam());
      }
    }
  }
  
  public void onStateEnd()
  {
    this.isInStickState = false;
    if (this.scrollState != 0)
    {
      this.scrollState = 0;
      tryFireExposedEvent();
    }
  }
  
  public void onStickRefreshing()
  {
    this.isInStickState = true;
    onHeaderOrFooterStateFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.compatible.VListCompat
 * JD-Core Version:    0.7.0.1
 */