package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VPage
  extends VDiv
{
  public static final String TAG = "VCell";
  private VPage.PAGEVIEWSTATE mCurrentPageState = VPage.PAGEVIEWSTATE.NOTINIT;
  private ViewGroup mRealView;
  
  public VPage(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void addEvent(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        super.addEvent(paramString);
        return;
        if (paramString.equals("willAppear"))
        {
          i = 0;
          continue;
          if (paramString.equals("willDisappear"))
          {
            i = 1;
            continue;
            if (paramString.equals("didDisappear"))
            {
              i = 2;
              continue;
              if (paramString.equals("didAppear")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
  }
  
  public void appearFireEvent(String paramString)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("frame", getPositionInfoRelativeToRoot(1));
      JSONArray localJSONArray = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put(paramString);
      fireEvent(paramString, localJSONArray, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("VCell", "onLoadMore error :" + localException.getMessage());
      }
    }
  }
  
  public VPage.PAGEVIEWSTATE getCurrentPageState()
  {
    return this.mCurrentPageState;
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VFrameLayout(paramContext);
    this.mRealView = paramContext;
    paramContext.bindComponent(this);
    this.mRealView.addOnAttachStateChangeListener(new VPage.1(this));
    return paramContext;
  }
  
  public void notifyChange() {}
  
  public void setCurrentPageState(VPage.PAGEVIEWSTATE paramPAGEVIEWSTATE)
  {
    this.mCurrentPageState = paramPAGEVIEWSTATE;
    if (this.mCurrentPageState == VPage.PAGEVIEWSTATE.WILLAPPEAR) {
      appearFireEvent("willAppear");
    }
    do
    {
      return;
      if (this.mCurrentPageState == VPage.PAGEVIEWSTATE.DIDAPPEAR)
      {
        appearFireEvent("didAppear");
        return;
      }
      if (this.mCurrentPageState == VPage.PAGEVIEWSTATE.WILLDISAPPEAR)
      {
        appearFireEvent("willDisappear");
        return;
      }
    } while (this.mCurrentPageState != VPage.PAGEVIEWSTATE.DIDDISAPPEAR);
    appearFireEvent("didDisappear");
  }
  
  public void setHostView(VFrameLayout paramVFrameLayout)
  {
    this.mHost = paramVFrameLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VPage
 * JD-Core Version:    0.7.0.1
 */