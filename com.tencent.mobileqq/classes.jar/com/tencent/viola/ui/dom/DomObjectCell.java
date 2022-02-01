package com.tencent.viola.ui.dom;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.dispatch.ComponentAppearEvent;
import com.tencent.viola.core.dispatch.ViolaDispatchManager;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class DomObjectCell
  extends DomObject
{
  static final FlexNode.MeasureFunction CELL_MEASURE_FUNCTION = new DomObjectCell.1();
  public String changeRef;
  public int changeType = -1;
  private boolean hasInitLazy = false;
  private ConcurrentHashMap<String, DomObjectCell.ComponentState> mBeforeTouchUpStateMap;
  private ComponentAppearEvent mComponentAppearEvent;
  private ArrayMap<String, Float> mReDidAppearComptDxEndMap;
  private ArrayMap<String, Float> mReDidAppearComptDxEndOffsetMap;
  private ArrayMap<String, Float> mReDidAppearComptDxStartMap;
  private ArrayMap<String, Float> mReDidAppearComptDxStartOffsetMap;
  private ArrayMap<String, Float> mReDidAppearComptDyEndMap;
  private ArrayMap<String, Float> mReDidAppearComptDyEndOffsetMap;
  private ArrayMap<String, Float> mReDidAppearComptDyStartMap;
  private ArrayMap<String, Float> mReDidAppearComptDyStartOffsetMap;
  private ArrayList<String> mRegisterAppearComponentList;
  private ArrayList<String> mRegisterDidAppearComponentList;
  private ConcurrentHashMap<String, DomObjectCell.ComponentState> mRegisterDidAppearComponentStateMap;
  private ArrayList<String> mRegisterDidDisAppearComponentList;
  private Boolean mTouchDirectionDown = Boolean.valueOf(true);
  public boolean needRefresh = false;
  private List<String> scrollEventList;
  
  public DomObjectCell()
  {
    setMeasureFunction(CELL_MEASURE_FUNCTION);
    this.mReDidAppearComptDyStartMap = new ArrayMap();
    this.mReDidAppearComptDyEndMap = new ArrayMap();
    this.mReDidAppearComptDxStartMap = new ArrayMap();
    this.mReDidAppearComptDxEndMap = new ArrayMap();
    this.mReDidAppearComptDyStartOffsetMap = new ArrayMap();
    this.mReDidAppearComptDyEndOffsetMap = new ArrayMap();
    this.mRegisterDidAppearComponentStateMap = new ConcurrentHashMap();
    this.mRegisterAppearComponentList = new ArrayList();
    this.mRegisterDidAppearComponentList = new ArrayList();
    this.mRegisterDidDisAppearComponentList = new ArrayList();
    this.mReDidAppearComptDxStartOffsetMap = new ArrayMap();
    this.mReDidAppearComptDxEndOffsetMap = new ArrayMap();
    this.mBeforeTouchUpStateMap = new ConcurrentHashMap();
  }
  
  private void dispatchAppearEvent(String paramString1, String paramString2)
  {
    if (this.mComponentAppearEvent == null) {
      this.mComponentAppearEvent = new ComponentAppearEvent(paramString1, paramString2);
    }
    this.mComponentAppearEvent.event = paramString1;
    this.mComponentAppearEvent.ref = paramString2;
    ViolaDispatchManager.getInstance().dispatchEvent("EVENT_NAME_COMPONENT_APPEAR", this.mComponentAppearEvent);
  }
  
  public void addReDidAppearComptDxEnd(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDxEndMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDxEndOffset(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDxEndOffsetMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDxStart(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDxStartMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDxStartOffset(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDxStartOffsetMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDyEnd(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDyEndMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDyEndOffset(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDyEndOffsetMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDyStart(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDyStartMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addReDidAppearComptDyStartOffset(float paramFloat, String paramString)
  {
    this.mReDidAppearComptDyStartOffsetMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addRegisterComponent(String paramString1, String paramString2)
  {
    if ("didAppear".equals(paramString1))
    {
      this.mRegisterDidAppearComponentList.add(paramString2);
      return;
    }
    if ("didDisappear".equals(paramString1))
    {
      this.mRegisterDidDisAppearComponentList.add(paramString2);
      return;
    }
    this.mRegisterAppearComponentList.add(paramString2);
  }
  
  public void addScrollEvent(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.scrollEventList == null) {
      this.scrollEventList = new ArrayList();
    }
    this.scrollEventList.add(paramString);
  }
  
  public void clearComptStateWhenTouchDown()
  {
    this.mBeforeTouchUpStateMap.clear();
  }
  
  public void fireEvent(String paramString1, String paramString2, String paramString3)
  {
    dispatchAppearEvent(paramString2, paramString3);
    if (!TextUtils.isEmpty(paramString1))
    {
      JSONArray localJSONArray = new JSONArray();
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONArray.put(paramString3);
      }
      localJSONArray.put(paramString2);
      ViolaBridgeManager.getInstance().callbackJavascript(paramString1, "dom", "fireEvent", localJSONArray, new JSONObject(), true);
    }
  }
  
  public int getCellType()
  {
    return ViolaUtils.getInt(getStyle().get("cellType"), 0);
  }
  
  public DomObjectCell.ComponentState getComponentState(String paramString)
  {
    return (DomObjectCell.ComponentState)this.mRegisterDidAppearComponentStateMap.get(paramString);
  }
  
  public ArrayMap getReDidAppearComptDxEndMap()
  {
    return this.mReDidAppearComptDxEndMap;
  }
  
  public ArrayMap getReDidAppearComptDxEndOffsetMap()
  {
    return this.mReDidAppearComptDxEndOffsetMap;
  }
  
  public ArrayMap getReDidAppearComptDxStartMap()
  {
    return this.mReDidAppearComptDxStartMap;
  }
  
  public ArrayMap getReDidAppearComptDxStartOffsetMap()
  {
    return this.mReDidAppearComptDxStartOffsetMap;
  }
  
  public ArrayMap getReDidAppearComptDyEndMap()
  {
    return this.mReDidAppearComptDyEndMap;
  }
  
  public ArrayMap getReDidAppearComptDyEndOffsetMap()
  {
    return this.mReDidAppearComptDyEndOffsetMap;
  }
  
  public ArrayMap getReDidAppearComptDyStartMap()
  {
    return this.mReDidAppearComptDyStartMap;
  }
  
  public ArrayMap getReDidAppearComptDyStartOffsetMap()
  {
    return this.mReDidAppearComptDyStartOffsetMap;
  }
  
  public List<String> getScrollEventList()
  {
    return this.scrollEventList;
  }
  
  public DomObjectCell.ComponentState getTouchUpComptState(String paramString)
  {
    return (DomObjectCell.ComponentState)this.mBeforeTouchUpStateMap.get(paramString);
  }
  
  public boolean isComponentRegisterEvent(String paramString1, String paramString2)
  {
    if ("didAppear".equals(paramString1)) {
      return this.mRegisterDidAppearComponentList.contains(paramString2);
    }
    if ("didDisappear".equals(paramString1)) {
      return this.mRegisterDidDisAppearComponentList.contains(paramString2);
    }
    return this.mRegisterAppearComponentList.contains(paramString2);
  }
  
  public boolean isLazy()
  {
    int i;
    if (!this.hasInitLazy)
    {
      this.hasInitLazy = true;
      Object localObject = getDomParent();
      if ((localObject != null) && ("list".equals(((DomObject)localObject).getType())) && (localObject != null) && (((DomObject)localObject).getAttributes() != null))
      {
        localObject = ((DomObject)localObject).getAttributes().entrySet().iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (!"direction".equals((String)localEntry.getKey())) {
            break label139;
          }
          if ("vertical".equals(ViolaUtils.getString(localEntry.getValue(), null))) {
            lazy(true);
          }
          i = 1;
        }
      }
    }
    label139:
    for (;;)
    {
      break;
      if (i == 0) {
        lazy(true);
      }
      return super.isLazy();
    }
  }
  
  public boolean isRegisterDidAppear()
  {
    return (this.mReDidAppearComptDyStartMap.size() > 0) || (this.mReDidAppearComptDxStartMap.size() > 0);
  }
  
  public boolean isSetComponentStaet(String paramString)
  {
    return this.mRegisterDidAppearComponentStateMap.containsKey(paramString);
  }
  
  public boolean needFireNextStateWhenWillAppear(String paramString, Boolean paramBoolean)
  {
    return ((getTouchUpComptState(paramString) == null) || (DomObjectCell.ComponentState.WILLAPPEAR.equals(getTouchUpComptState(paramString)))) && (paramBoolean == this.mTouchDirectionDown);
  }
  
  public void resetComponentState(String paramString, boolean paramBoolean)
  {
    if (this.mRegisterDidAppearComponentStateMap.size() >= 0)
    {
      Iterator localIterator = this.mRegisterDidAppearComponentStateMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((getComponentState(str).equals(DomObjectCell.ComponentState.DIDAPPEAR)) || (getComponentState(str).equals(DomObjectCell.ComponentState.WILLAPPEAR))) {
          if (getComponentState(str).equals(DomObjectCell.ComponentState.WILLAPPEAR))
          {
            if ((needFireNextStateWhenWillAppear(str, Boolean.valueOf(paramBoolean))) && (isComponentRegisterEvent("didAppear", str))) {
              fireEvent(paramString, "didAppear", str);
            }
            if (isComponentRegisterEvent("didDisappear", str)) {
              fireEvent(paramString, "didDisappear", str);
            }
            label141:
            dispatchAppearEvent("didDisappear", str);
          }
        }
        for (;;)
        {
          this.mRegisterDidAppearComponentStateMap.put(str, DomObjectCell.ComponentState.DIDDISAPPEAR);
          break;
          if ((!getComponentState(str).equals(DomObjectCell.ComponentState.DIDAPPEAR)) || (!isComponentRegisterEvent("didDisappear", str))) {
            break label141;
          }
          fireEvent(paramString, "didDisappear", str);
          break label141;
          if (needFireNextStateWhenWillAppear(str, Boolean.valueOf(paramBoolean)))
          {
            if (isComponentRegisterEvent("willAppear", str)) {
              fireEvent(paramString, "willAppear", str);
            }
            if (isComponentRegisterEvent("didAppear", str)) {
              fireEvent(paramString, "didAppear", str);
            }
            if (isComponentRegisterEvent("didDisappear", str)) {
              fireEvent(paramString, "didDisappear", str);
            }
          }
        }
      }
    }
  }
  
  public void setComponentState(String paramString, DomObjectCell.ComponentState paramComponentState)
  {
    this.mRegisterDidAppearComponentStateMap.put(paramString, paramComponentState);
  }
  
  public void setTouchDirection(boolean paramBoolean)
  {
    this.mTouchDirectionDown = Boolean.valueOf(paramBoolean);
  }
  
  public void setTouchUpComptState(String paramString, DomObjectCell.ComponentState paramComponentState)
  {
    this.mBeforeTouchUpStateMap.put(paramString, paramComponentState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectCell
 * JD-Core Version:    0.7.0.1
 */