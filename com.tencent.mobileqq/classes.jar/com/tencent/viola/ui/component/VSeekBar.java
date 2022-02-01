package com.tencent.viola.ui.component;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.view.VSeekBarView;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VSeekBar
  extends VComponent<VSeekBarView>
  implements SeekBar.OnSeekBarChangeListener
{
  public static final String ATTR_ENABLE = "enable";
  public static final String ATTR_MAX_PROGRESS = "maxProgress";
  public static final String ATTR_PROGRESS = "progress";
  public static final String STYLE_BACKGROUND_COLOR = "backgroundProgressColor";
  public static final String STYLE_CYCLE_THUMB_COLOR = "cycleThumbColor";
  public static final String STYLE_CYCLE_THUMB_SIZE = "cycleThumbSize";
  public static final String STYLE_PROGRESS_COLOR = "progressColor";
  public static final String STYLE_SEEK_BAR_HEIGHT = "seekBarHeight";
  
  public VSeekBar(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VSeekBar(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer, paramInt);
  }
  
  private int getColor(Object paramObject, String paramString)
  {
    paramObject = ViolaUtils.getString(paramObject, null);
    if (paramObject == null) {
      return Color.parseColor(paramString);
    }
    return ViolaUtils.getColor(paramObject);
  }
  
  private void onProgressChange(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.mAppendEvents.contains("progressChange")) {
        return;
      }
      Object localObject1 = (VSeekBarView)getHostView();
      if (localObject1 == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("progress", paramInt / ((VSeekBarView)localObject1).getMax());
      ((JSONObject)localObject2).put("isFromUser", paramBoolean);
      localJSONObject.put("progressChange", localObject2);
      localObject1 = new JSONArray();
      localObject2 = this.mDomObj.getRef();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONArray)localObject1).put(localObject2);
      }
      ((JSONArray)localObject1).put("progressChange");
      fireEvent("progressChange", localObject1, localJSONObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void onStartSeek(int paramInt)
  {
    try
    {
      if (!this.mAppendEvents.contains("startSeek")) {
        return;
      }
      Object localObject1 = (VSeekBarView)getHostView();
      if (localObject1 == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("progress", paramInt / ((VSeekBarView)localObject1).getMax());
      localJSONObject.put("startSeek", localObject2);
      localObject1 = new JSONArray();
      localObject2 = this.mDomObj.getRef();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONArray)localObject1).put(localObject2);
      }
      ((JSONArray)localObject1).put("startSeek");
      fireEvent("startSeek", localObject1, localJSONObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void onStopSeek(int paramInt)
  {
    try
    {
      if (!this.mAppendEvents.contains("stopSeek")) {
        return;
      }
      Object localObject1 = (VSeekBarView)getHostView();
      if (localObject1 == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("progress", paramInt / ((VSeekBarView)localObject1).getMax());
      localJSONObject.put("stopSeek", localObject2);
      localObject1 = new JSONArray();
      localObject2 = this.mDomObj.getRef();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONArray)localObject1).put(localObject2);
      }
      ((JSONArray)localObject1).put("stopSeek");
      fireEvent("stopSeek", localObject1, localJSONObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void setBackgroundColor(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setBackgroundColor(getColor(paramObject, "#66ffffff"));
    }
  }
  
  private void setCycleThumbColor(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setCycleThumbColor(getColor(paramObject, "#ffffff"));
    }
  }
  
  private void setCycleThumbSize(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setThumbSize(ViolaUtils.getInt(paramObject));
    }
  }
  
  private void setEnable(boolean paramBoolean)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setEnableSeek(paramBoolean);
    }
  }
  
  private void setMax(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setMax(ViolaUtils.getInt(paramObject));
    }
  }
  
  private void setPaddingLeft(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setPadding(ViolaUtils.getInt(paramObject, 12), localVSeekBarView.getPaddingTop(), localVSeekBarView.getPaddingRight(), localVSeekBarView.getPaddingBottom());
    }
  }
  
  private void setPaddingRight(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null)
    {
      int i = ViolaUtils.getInt(paramObject, 12);
      localVSeekBarView.setPadding(localVSeekBarView.getPaddingLeft(), localVSeekBarView.getPaddingTop(), i, localVSeekBarView.getPaddingBottom());
    }
  }
  
  private void setProgress(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setProgress((int)(ViolaUtils.getFloat(paramObject, Float.valueOf(0.0F)) * localVSeekBarView.getMax()));
    }
  }
  
  private void setProgressColor(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null) {
      localVSeekBarView.setProgressColor(getColor(paramObject, "#ffffff"));
    }
  }
  
  private void setSeekBarHeight(Object paramObject)
  {
    VSeekBarView localVSeekBarView = (VSeekBarView)getHostView();
    if (localVSeekBarView != null)
    {
      localVSeekBarView.setSeekBarHeight(ViolaUtils.getInt(paramObject));
      localVSeekBarView.invalidateProgressDrawable();
    }
  }
  
  public int getThumbSize()
  {
    if (this.mDomObj == null) {
      return 0;
    }
    return ViolaUtils.getInt(this.mDomObj.getStyle().get("cycleThumbSize"));
  }
  
  protected VSeekBarView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VSeekBarView(paramContext);
    paramContext.setPadding(0, paramContext.getPaddingTop(), 0, paramContext.getPaddingBottom());
    paramContext.setMax(10000);
    paramContext.bindComponent(this);
    paramContext.setOnSeekBarChangeListener(this);
    return paramContext;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    onProgressChange(paramInt, paramBoolean);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    onStartSeek(paramSeekBar.getProgress());
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    onStopSeek(paramSeekBar.getProgress());
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  protected boolean setProperty(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1031219121: 
      if (paramString.equals("maxProgress")) {
        i = 9;
      }
      break;
    case 755159350: 
      if (paramString.equals("progressColor")) {
        i = 2;
      }
      break;
    case 713848971: 
      if (paramString.equals("paddingRight")) {
        i = 7;
      }
      break;
    case 110056625: 
      if (paramString.equals("cycleThumbSize")) {
        i = 5;
      }
      break;
    case -897822541: 
      if (paramString.equals("cycleThumbColor")) {
        i = 3;
      }
      break;
    case -1001078227: 
      if (paramString.equals("progress")) {
        i = 8;
      }
      break;
    case -1298848381: 
      if (paramString.equals("enable")) {
        i = 0;
      }
      break;
    case -1409714302: 
      if (paramString.equals("seekBarHeight")) {
        i = 4;
      }
      break;
    case -1501175880: 
      if (paramString.equals("paddingLeft")) {
        i = 6;
      }
      break;
    case -1663695192: 
      if (paramString.equals("backgroundProgressColor")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return super.setProperty(paramString, paramObject);
    case 9: 
      setMax(paramObject);
      return true;
    case 8: 
      setProgress(paramObject);
      return true;
    case 7: 
      setPaddingRight(paramObject);
      return true;
    case 6: 
      setPaddingLeft(paramObject);
      return true;
    case 5: 
      setCycleThumbSize(paramObject);
      return true;
    case 4: 
      setSeekBarHeight(paramObject);
      return true;
    case 3: 
      setCycleThumbColor(paramObject);
      return true;
    case 2: 
      setProgressColor(paramObject);
      return true;
    case 1: 
      setBackgroundColor(paramObject);
      return true;
    }
    setEnable(ViolaUtils.getBoolean(paramObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSeekBar
 * JD-Core Version:    0.7.0.1
 */