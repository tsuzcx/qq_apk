package com.tencent.viola.ui.component;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.image.VImage2;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.image.VImageView2;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class VGif2
  extends VImage2
{
  public VGif2(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VGif2(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer, paramInt);
  }
  
  protected boolean hasFinishEvent()
  {
    return (this.mDomObj != null) && (this.mDomObj.getEvents().contains("beginPlay"));
  }
  
  public boolean isGif()
  {
    return true;
  }
  
  protected void tryFireEvent(boolean paramBoolean, Bundle paramBundle)
  {
    if (!hasFinishEvent()) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = (VImageView2)getHostView();
        int k = 0;
        if (localObject != null)
        {
          j = ((VImageView2)localObject).getNaturalWidth();
          i = ((VImageView2)localObject).getNaturalHeight();
          if (paramBundle != null)
          {
            j = paramBundle.getInt(ImageAdapterHolder.BUNDLE_WIDTH);
            i = paramBundle.getInt(ImageAdapterHolder.BUNDLE_HEIGHT);
          }
          paramBundle = new JSONObject();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("width", j);
          ((JSONObject)localObject).put("height", i);
          i = k;
          if (paramBoolean) {
            i = 1;
          }
          paramBundle.put("success", i);
          paramBundle.put("image", localObject);
          localObject = new JSONArray();
          String str = this.mDomObj.getRef();
          if (!TextUtils.isEmpty(str)) {
            ((JSONArray)localObject).put(str);
          }
          ((JSONArray)localObject).put("beginPlay");
          fireEvent("beginPlay", localObject, paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        return;
      }
      int i = 0;
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VGif2
 * JD-Core Version:    0.7.0.1
 */