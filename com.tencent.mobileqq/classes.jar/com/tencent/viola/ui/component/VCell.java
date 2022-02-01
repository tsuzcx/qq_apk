package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VCell
  extends VDiv
{
  public static final String TAG = "VCell";
  private ViewGroup mRealView;
  private boolean needFresh = false;
  
  public VCell(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    if ((paramVComponentContainer instanceof VRecyclerList)) {
      lazy(true);
    }
  }
  
  public void addEvent(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1411068523)
    {
      if ((i == -177721437) && (paramString.equals("disappear")))
      {
        i = 1;
        break label50;
      }
    }
    else if (paramString.equals("appear"))
    {
      i = 0;
      break label50;
    }
    i = -1;
    label50:
    if (i != 0)
    {
      if (i != 1)
      {
        super.addEvent(paramString);
        return;
      }
      this.mAppendEvents.add(paramString);
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void appearFireEvent()
  {
    if (!this.mAppendEvents.contains("appear")) {
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
      ((StringBuilder)localObject).append("onDragBegin error :");
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
    localJSONArray.put("appear");
    fireEvent("appear", localJSONArray, localJSONObject);
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VFrameLayout(paramContext);
    this.mRealView = paramContext;
    paramContext.bindComponent(this);
    this.mRealView.addOnAttachStateChangeListener(new VCell.1(this));
    return paramContext;
  }
  
  public void needFresh(boolean paramBoolean)
  {
    this.needFresh = paramBoolean;
  }
  
  public void notifyChange()
  {
    Object localObject = ViolaSDKManager.getInstance().getDomManager().getDomContext(getInstance().getInstanceId());
    if (localObject != null)
    {
      localObject = ((DOMActionContext)localObject).getDomByRef(getRef());
      if ((localObject != null) && ((localObject instanceof DomObjectCell))) {
        ((DomObjectCell)localObject).needRefresh = true;
      }
      this.needFresh = true;
    }
    if ((getParent() instanceof VRecyclerList)) {
      ((VRecyclerList)getParent()).judgeIfNeedAppearEvent(this);
    }
    super.notifyChange();
  }
  
  public void notifyChange(int paramInt, String paramString)
  {
    Object localObject = ViolaSDKManager.getInstance().getDomManager().getDomContext(getInstance().getInstanceId());
    if (localObject != null)
    {
      localObject = ((DOMActionContext)localObject).getDomByRef(getRef());
      if ((localObject != null) && ((localObject instanceof DomObjectCell)))
      {
        localObject = (DomObjectCell)localObject;
        ((DomObjectCell)localObject).needRefresh = true;
        ((DomObjectCell)localObject).changeRef = paramString;
        ((DomObjectCell)localObject).changeType = paramInt;
      }
      this.needFresh = true;
    }
    if ((getParent() instanceof VRecyclerList)) {
      ((VRecyclerList)getParent()).judgeIfNeedAppearEvent(this);
    }
    super.notifyChange();
  }
  
  public void setHostView(VFrameLayout paramVFrameLayout)
  {
    this.mHost = paramVFrameLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VCell
 * JD-Core Version:    0.7.0.1
 */