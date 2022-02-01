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
    int i = this.mActiveColor;
    int j = this.mInActiveColor;
    this.mColorStateList = new ColorStateList(new int[][] { { 16842912 }, { 0 } }, new int[] { i, j });
  }
  
  public void addEvent(String paramString)
  {
    int i;
    if ((paramString.hashCode() == -1361636432) && (paramString.equals("change"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0)
    {
      super.addEvent(paramString);
      return;
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
      int i = -1;
      int j = paramString.hashCode();
      if (j != -1742453971)
      {
        if (j != -1077332995)
        {
          if ((j == -505680456) && (paramString.equals("inactiveColor"))) {
            i = 1;
          }
        }
        else if (paramString.equals("activeColor")) {
          i = 0;
        }
      }
      else if (paramString.equals("thumbColor")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            ((VSwitchView)getHostView()).setThumbResource(ColorParseUtils.parseColor(str));
            return true;
          }
        }
        else
        {
          this.mInActiveColor = ColorParseUtils.parseColor(str);
          paramString = new int[] { 16842912 };
          i = this.mActiveColor;
          j = this.mInActiveColor;
          this.mColorStateList = new ColorStateList(new int[][] { paramString, { 0 } }, new int[] { i, j });
          ((VSwitchView)getHostView()).setTrackTintList(this.mColorStateList);
          return true;
        }
      }
      else
      {
        this.mActiveColor = ColorParseUtils.parseColor(str);
        paramString = new int[] { 16842912 };
        i = this.mActiveColor;
        j = this.mInActiveColor;
        this.mColorStateList = new ColorStateList(new int[][] { paramString, { 0 } }, new int[] { i, j });
        ((VSwitchView)getHostView()).setTrackTintList(this.mColorStateList);
        return true;
      }
    }
    return super.setProperty(paramString, paramObject);
  }
  
  public void switchFireEvent(String paramString, boolean paramBoolean)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("active", paramBoolean);
      localObject2 = new JSONArray();
      if (((VSwitchView)getHostView()).getComponent().getDomObject() != null)
      {
        String str = ((VSwitchView)getHostView()).getComponent().getDomObject().getRef();
        if (str != null) {
          ((JSONArray)localObject2).put(str);
        }
      }
      ((JSONArray)localObject2).put(paramString);
      fireEvent(paramString, localObject2, localObject1);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("switchFireEvent error :");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      ViolaLogUtils.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSwitch
 * JD-Core Version:    0.7.0.1
 */