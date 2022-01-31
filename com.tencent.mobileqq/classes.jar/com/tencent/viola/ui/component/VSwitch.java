package com.tencent.viola.ui.component;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VSwitchView;
import com.tencent.viola.utils.ColorParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VSwitch
  extends VComponent<VSwitchView>
{
  public static String TAG = "VSwitch";
  private int mActiveColor;
  private ColorStateList mColorStateList;
  private int mInActiveColor;
  @VComponentField(nativeReturnMethod="getTrackTintList", propertyName="inactiveColor")
  private int mIntrackTintList;
  @VComponentField(nativeReturnMethod="getTrackTintList", propertyName="activeColor")
  private int mTrackTintList;
  
  public VSwitch(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    paramViolaInstance = new int[] { 16842912 };
    int i = this.mActiveColor;
    int j = this.mInActiveColor;
    this.mColorStateList = new ColorStateList(new int[][] { paramViolaInstance, { 0 } }, new int[] { i, j });
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
        if (paramString.equals("change")) {
          i = 0;
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
  }
  
  protected VSwitchView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VSwitchView(paramContext);
    paramContext.bindComponent(this);
    paramContext.setTrackTintList(this.mColorStateList);
    paramContext.setOnCheckedChangeListener(new VSwitch.1(this));
    return paramContext;
  }
  
  @VComponentProp(initToHostView=true, name="active", nativeReturnMethod="isChecked")
  public void setActive(int paramInt)
  {
    if (paramInt == 1)
    {
      ((VSwitchView)getHostView()).setChecked(true);
      return;
    }
    ((VSwitchView)getHostView()).setChecked(false);
  }
  
  @VComponentProp(initToHostView=true, name="disabled", nativeReturnMethod="isActivated")
  public void setDisable(int paramInt)
  {
    if (paramInt == 1)
    {
      ((VSwitchView)getHostView()).setActivated(false);
      return;
    }
    ((VSwitchView)getHostView()).setActivated(true);
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    String str = ViolaUtils.getString(paramObject, null);
    if (str != null)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return super.setProperty(paramString, paramObject);
        if (paramString.equals("activeColor"))
        {
          i = 0;
          continue;
          if (paramString.equals("inactiveColor"))
          {
            i = 1;
            continue;
            if (paramString.equals("thumbColor")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    this.mActiveColor = ColorParseUtils.parseColor(str);
    int i = this.mActiveColor;
    int j = this.mInActiveColor;
    this.mColorStateList = new ColorStateList(new int[][] { { 16842912 }, { 0 } }, new int[] { i, j });
    ((VSwitchView)getHostView()).setTrackTintList(this.mColorStateList);
    return true;
    this.mInActiveColor = ColorParseUtils.parseColor(str);
    i = this.mActiveColor;
    j = this.mInActiveColor;
    this.mColorStateList = new ColorStateList(new int[][] { { 16842912 }, { 0 } }, new int[] { i, j });
    ((VSwitchView)getHostView()).setTrackTintList(this.mColorStateList);
    return true;
    ((VSwitchView)getHostView()).setThumbResource(ColorParseUtils.parseColor(str));
    return true;
  }
  
  public void switchFireEvent(String paramString, boolean paramBoolean)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("active", paramBoolean);
      JSONArray localJSONArray = new JSONArray();
      if (((VSwitchView)getHostView()).getComponent().getDomObject() != null)
      {
        String str = ((VSwitchView)getHostView()).getComponent().getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put(paramString);
      fireEvent(paramString, localJSONArray, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      ViolaLogUtils.e(TAG, "switchFireEvent error :" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSwitch
 * JD-Core Version:    0.7.0.1
 */