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
  private ComponentAppearEvent mComponentAppearEvent;
  private ArrayList<String> mRegisterAppearComponentList;
  private ArrayMap<String, Float> mRegisterDidAppearComponentDyEndMap;
  private ArrayMap<String, Float> mRegisterDidAppearComponentDyEndOffsetMap;
  private ArrayMap<String, Float> mRegisterDidAppearComponentDyStartMap;
  private ArrayMap<String, Float> mRegisterDidAppearComponentDyStartOffsetMap;
  private ArrayList<String> mRegisterDidAppearComponentList;
  private ConcurrentHashMap<String, DomObjectCell.ComponentState> mRegisterDidAppearComponentStateMap;
  private ArrayList<String> mRegisterDidDisAppearComponentList;
  public boolean needRefresh = false;
  private List<String> scrollEventList;
  
  public DomObjectCell()
  {
    setMeasureFunction(CELL_MEASURE_FUNCTION);
    this.mRegisterDidAppearComponentDyStartMap = new ArrayMap();
    this.mRegisterDidAppearComponentDyEndMap = new ArrayMap();
    this.mRegisterDidAppearComponentDyStartOffsetMap = new ArrayMap();
    this.mRegisterDidAppearComponentDyEndOffsetMap = new ArrayMap();
    this.mRegisterDidAppearComponentStateMap = new ConcurrentHashMap();
    this.mRegisterAppearComponentList = new ArrayList();
    this.mRegisterDidAppearComponentList = new ArrayList();
    this.mRegisterDidDisAppearComponentList = new ArrayList();
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
  
  public void addRegisterDidAppearComponentDyEnd(float paramFloat, String paramString)
  {
    this.mRegisterDidAppearComponentDyEndMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addRegisterDidAppearComponentDyEndOffset(float paramFloat, String paramString)
  {
    this.mRegisterDidAppearComponentDyEndOffsetMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addRegisterDidAppearComponentDyStart(float paramFloat, String paramString)
  {
    this.mRegisterDidAppearComponentDyStartMap.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void addRegisterDidAppearComponentDyStartOffset(float paramFloat, String paramString)
  {
    this.mRegisterDidAppearComponentDyStartOffsetMap.put(paramString, Float.valueOf(paramFloat));
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
  
  public ArrayMap getRegisterDidAppearComponentDyEndMap()
  {
    return this.mRegisterDidAppearComponentDyEndMap;
  }
  
  public ArrayMap getRegisterDidAppearComponentDyEndOffsetMap()
  {
    return this.mRegisterDidAppearComponentDyEndOffsetMap;
  }
  
  public ArrayMap getRegisterDidAppearComponentDyStartMap()
  {
    return this.mRegisterDidAppearComponentDyStartMap;
  }
  
  public ArrayMap getRegisterDidAppearComponentDyStartOffsetMap()
  {
    return this.mRegisterDidAppearComponentDyStartOffsetMap;
  }
  
  public List<String> getScrollEventList()
  {
    return this.scrollEventList;
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
            break label138;
          }
          if ("vertical".equals(ViolaUtils.getString(localEntry.getValue(), null))) {
            lazy(true);
          }
          i = 1;
        }
      }
    }
    label138:
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
    return this.mRegisterDidAppearComponentDyStartMap.size() > 0;
  }
  
  public boolean isSetComponentStaet(String paramString)
  {
    return this.mRegisterDidAppearComponentStateMap.containsKey(paramString);
  }
  
  public void resetComponentState(String paramString)
  {
    if (this.mRegisterDidAppearComponentStateMap.size() >= 0)
    {
      Iterator localIterator = this.mRegisterDidAppearComponentStateMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((getComponentState(str).equals(DomObjectCell.ComponentState.DIDAPPEAR)) || (getComponentState(str).equals(DomObjectCell.ComponentState.WILLAPPEAR)))
        {
          dispatchAppearEvent("didDisappear", str);
          if (isComponentRegisterEvent("didDisappear", str)) {
            fireEvent(paramString, "didDisappear", str);
          }
        }
        this.mRegisterDidAppearComponentStateMap.put(str, DomObjectCell.ComponentState.DIDDISAPPEAR);
      }
    }
  }
  
  public void setComponentState(String paramString, DomObjectCell.ComponentState paramComponentState)
  {
    this.mRegisterDidAppearComponentStateMap.put(paramString, paramComponentState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectCell
 * JD-Core Version:    0.7.0.1
 */