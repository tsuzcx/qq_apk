package com.tencent.mobileqq.profilecard.vas.component.template;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class TemplateUtilsImpl$TemplateColorStateList
{
  private static List<TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec> stateSpecList;
  
  static int getStateSpec(JSONObject paramJSONObject, String paramString)
  {
    initStateSpecList(paramJSONObject);
    int i = 0;
    while (i < stateSpecList.size())
    {
      paramJSONObject = (TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec)stateSpecList.get(i);
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
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_pressed", paramJSONObject.optBoolean("state_pressed"), 16842919, -16842919));
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_focused", paramJSONObject.optBoolean("state_focused"), 16842908, -16842908));
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_selected", paramJSONObject.optBoolean("state_selected"), 16842913, -16842913));
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_checkable", paramJSONObject.optBoolean("state_checkable"), 16842911, -16842911));
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_checked", paramJSONObject.optBoolean("state_checked"), 16842912, -16842912));
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_enabled", paramJSONObject.optBoolean("state_enabled"), 16842910, -16842910));
    stateSpecList.add(TemplateUtilsImpl.TemplateColorStateList.ItemStateSpec.newInstance("state_window_focused", paramJSONObject.optBoolean("state_window_focused"), 16842909, -16842909));
  }
  
  static ColorStateList invoke(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Object localObject2 = new int[20];
      Object localObject1 = new int[20][];
      int i2 = paramJSONArray.length();
      int k = 0;
      int i = 20;
      int m = 0;
      while (k < i2)
      {
        Object localObject5 = paramJSONArray.optJSONObject(k);
        int n = m;
        localObject3 = localObject2;
        Object localObject4 = localObject1;
        int j = i;
        if (localObject5 != null)
        {
          n = m;
          localObject3 = localObject2;
          localObject4 = localObject1;
          j = i;
          if (((JSONObject)localObject5).has("color"))
          {
            String str1 = ((JSONObject)localObject5).optString("color");
            n = m;
            localObject3 = localObject2;
            localObject4 = localObject1;
            j = i;
            if (str1 != null)
            {
              n = m;
              localObject3 = localObject2;
              localObject4 = localObject1;
              j = i;
              if (str1.length() > 0)
              {
                localObject3 = ((JSONObject)localObject5).keys();
                localObject4 = new int[((JSONObject)localObject5).length()];
                j = 0;
                n = -65536;
                while (((Iterator)localObject3).hasNext())
                {
                  String str2 = (String)((Iterator)localObject3).next();
                  if (str2.equalsIgnoreCase("color"))
                  {
                    n = Color.parseColor(str1);
                  }
                  else
                  {
                    i1 = getStateSpec((JSONObject)localObject5, str2);
                    if (i1 > 0)
                    {
                      localObject4[j] = i1;
                      j += 1;
                    }
                  }
                }
                localObject5 = StateSet.trimStateSet((int[])localObject4, j);
                int i1 = m + 1;
                localObject3 = localObject2;
                localObject4 = localObject1;
                j = i;
                if (i1 >= i)
                {
                  localObject3 = new int[i1];
                  System.arraycopy(localObject2, 0, localObject3, 0, m);
                  localObject4 = new int[i1][];
                  System.arraycopy(localObject1, 0, localObject4, 0, m);
                  j = i1;
                }
                localObject3[m] = n;
                localObject4[m] = localObject5;
                n = i1;
              }
            }
          }
        }
        k += 1;
        m = n;
        localObject2 = localObject3;
        localObject1 = localObject4;
        i = j;
      }
      paramJSONArray = new int[m];
      Object localObject3 = new int[m][];
      System.arraycopy(localObject2, 0, paramJSONArray, 0, m);
      System.arraycopy(localObject1, 0, localObject3, 0, m);
      return new ColorStateList((int[][])localObject3, paramJSONArray);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.TemplateUtilsImpl.TemplateColorStateList
 * JD-Core Version:    0.7.0.1
 */