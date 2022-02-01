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
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1393970161: 
      if (paramString.equals("willDisappear")) {
        i = 1;
      }
      break;
    case -140590073: 
      if (paramString.equals("willAppear")) {
        i = 0;
      }
      break;
    case -323196444: 
      if (paramString.equals("didDisappear")) {
        i = 2;
      }
      break;
    case -1521507596: 
      if (paramString.equals("didAppear")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            super.addEvent(paramString);
            return;
          }
          this.mAppendEvents.add(paramString);
          return;
        }
        this.mAppendEvents.add(paramString);
        return;
      }
      this.mAppendEvents.add(paramString);
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void appearFireEvent(String paramString)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    try
    {
      localJSONObject.put("frame", getPositionInfoRelativeToRoot(1));
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadMore error :");
      ((StringBuilder)localObject).append(localException.getMessage());
      ViolaLogUtils.e("VCell", ((StringBuilder)localObject).toString());
    }
    JSONArray localJSONArray = new JSONArray();
    if (getDomObject() != null)
    {
      localObject = getDomObject().getRef();
      if (localObject != null) {
        localJSONArray.put(localObject);
      }
    }
    localJSONArray.put(paramString);
    fireEvent(paramString, localJSONArray, localJSONObject);
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
    if (this.mCurrentPageState == VPage.PAGEVIEWSTATE.WILLAPPEAR)
    {
      appearFireEvent("willAppear");
      return;
    }
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
    if (this.mCurrentPageState == VPage.PAGEVIEWSTATE.DIDDISAPPEAR) {
      appearFireEvent("didDisappear");
    }
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