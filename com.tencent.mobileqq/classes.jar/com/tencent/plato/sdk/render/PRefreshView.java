package com.tencent.plato.sdk.render;

import android.widget.FrameLayout;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.widget.PullToRefreshBase.State;
import com.tencent.plato.sdk.widget.RefreshStateCallback;
import java.util.List;

public class PRefreshView
  extends PDivView
  implements RefreshStateCallback
{
  ElementItem elementItem;
  IPView parentView = null;
  boolean refreshing = false;
  
  public void attachEvent(List<String> paramList)
  {
    super.attachEvent(paramList);
    if ((paramList != null) && (paramList.contains("refresh")) && ((this.parentView instanceof PScrollView))) {
      ((PScrollView.PVScrollView)this.parentView.getView()).setEventCallBack(this);
    }
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    this.parentView = paramIPView;
    this.elementItem = paramElementItem;
    this.view = new FrameLayout(getPlatoRuntime().getContext());
    this.id = paramElementItem.getElementId();
  }
  
  public void refreshState(PullToRefreshBase.State paramState)
  {
    JSONWritableMap localJSONWritableMap = new JSONWritableMap();
    switch (1.$SwitchMap$com$tencent$plato$sdk$widget$PullToRefreshBase$State[paramState.ordinal()])
    {
    }
    for (;;)
    {
      fireEvent(getPageId(), this.id, "refresh", localJSONWritableMap);
      return;
      localJSONWritableMap.put("refreshingState", "1");
      continue;
      localJSONWritableMap.put("refreshingState", "2");
      continue;
      localJSONWritableMap.put("refreshingState", "3");
    }
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    super.setStyles(paramIReadableMap);
    this.refreshing = paramIReadableMap.getBoolean("refreshing", false);
    PLog.d(PRefreshView.class.getName(), "refreshing : " + this.refreshing);
    if (((this.parentView instanceof PScrollView)) && (this.parentView.getView() != null) && (!this.refreshing))
    {
      ((PScrollView.PVScrollView)this.parentView.getView()).onRefreshComplete();
      PLog.d(PRefreshView.class.getName(), "onRefreshComplete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PRefreshView
 * JD-Core Version:    0.7.0.1
 */