package com.tencent.mobileqq.profilecard.vas.component.template;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class TemplateUtilsImpl$TemplateStateListDrawable
{
  private static List<TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec> stateSpecList;
  
  private static void addDrawableState(ITemplateUtils paramITemplateUtils, ProfileCardTemplate paramProfileCardTemplate, StateListDrawable paramStateListDrawable, JSONObject paramJSONObject, String paramString)
  {
    Iterator localIterator = paramJSONObject.keys();
    int[] arrayOfInt = new int[paramJSONObject.length()];
    Drawable localDrawable = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.equalsIgnoreCase("drawable"))
      {
        localDrawable = paramITemplateUtils.getTemplateDrawable(paramProfileCardTemplate, true, false, paramString);
      }
      else
      {
        int j = getStateSpec(paramJSONObject, str);
        if (j > 0)
        {
          arrayOfInt[i] = j;
          i += 1;
        }
      }
    }
    paramITemplateUtils = StateSet.trimStateSet(arrayOfInt, i);
    if (localDrawable != null) {
      paramStateListDrawable.addState(paramITemplateUtils, localDrawable);
    }
  }
  
  private static int getStateSpec(JSONObject paramJSONObject, String paramString)
  {
    initStateSpecList(paramJSONObject);
    int i = 0;
    while (i < stateSpecList.size())
    {
      paramJSONObject = (TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec)stateSpecList.get(i);
      if (paramJSONObject.key.equalsIgnoreCase(paramString))
      {
        if (paramJSONObject.status) {
          return paramJSONObject.spec1;
        }
        return paramJSONObject.spec2;
      }
      i += 1;
    }
    return 0;
  }
  
  private static void initStateSpecList(JSONObject paramJSONObject)
  {
    stateSpecList = new ArrayList();
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_pressed", paramJSONObject.optBoolean("state_pressed"), 16842919, -16842919));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_focused", paramJSONObject.optBoolean("state_focused"), 16842908, -16842908));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_hovered", paramJSONObject.optBoolean("state_hovered"), 16843623, -16843623));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_selected", paramJSONObject.optBoolean("state_selected"), 16842913, -16842913));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_checkable", paramJSONObject.optBoolean("state_checkable"), 16842911, -16842911));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_checked", paramJSONObject.optBoolean("state_checked"), 16842912, -16842912));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_enabled", paramJSONObject.optBoolean("state_enabled"), 16842910, -16842910));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_activated", paramJSONObject.optBoolean("state_activated"), 16843518, -16843518));
    stateSpecList.add(TemplateUtilsImpl.TemplateStateListDrawable.ItemStateSpec.newInstance("state_window_focused", paramJSONObject.optBoolean("state_window_focused"), 16842909, -16842909));
  }
  
  static StateListDrawable invoke(ITemplateUtils paramITemplateUtils, ProfileCardTemplate paramProfileCardTemplate, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int i = 0;
    int j = paramJSONArray.length();
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if ((localJSONObject != null) && (localJSONObject.has("drawable")))
      {
        String str = localJSONObject.optString("drawable");
        if ((str != null) && (str.length() > 0)) {
          addDrawableState(paramITemplateUtils, paramProfileCardTemplate, localStateListDrawable, localJSONObject, str);
        }
      }
      i += 1;
    }
    return localStateListDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.TemplateUtilsImpl.TemplateStateListDrawable
 * JD-Core Version:    0.7.0.1
 */