package com.tencent.mobileqq.troop.shortcutbar;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopShortcutBarConfig
{
  public static boolean a = false;
  public static boolean b = false;
  public static int c = 1;
  public int a;
  public ArrayList<Integer> a;
  public int b;
  public ArrayList<Integer> b;
  
  public TroopShortcutBarConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public static TroopShortcutBarConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    boolean bool2 = false;
    int i4 = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i = 0;
    while (i4 < paramArrayOfQConfItem.length)
    {
      Object localObject2 = paramArrayOfQConfItem[i4].a;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((ArrayList)localObject1).clear();
        localArrayList.clear();
        int j = i1;
        int k = i2;
        int m = i3;
        int n = i;
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          j = i1;
          k = i2;
          m = i3;
          n = i;
          int i5 = ((JSONObject)localObject2).optInt("globalOpen", 0);
          j = i5;
          k = i2;
          m = i3;
          n = i;
          int i6 = ((JSONObject)localObject2).optInt("globalOpenStudyMode", 0);
          j = i5;
          k = i6;
          m = i3;
          n = i;
          int i7 = ((JSONObject)localObject2).optInt("groupShortcutBarSwitchWithoutAdmin", 0);
          j = i5;
          k = i6;
          m = i7;
          n = i;
          int i8 = ((JSONObject)localObject2).optInt("groupAppHotRecommendSwitch", 0);
          j = i5;
          k = i6;
          m = i7;
          n = i8;
          JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("enabledGroupTypes");
          if (localJSONArray != null)
          {
            j = i5;
            k = i6;
            m = i7;
            n = i8;
            if (localJSONArray.length() > 0)
            {
              i = 0;
              for (;;)
              {
                j = i5;
                k = i6;
                m = i7;
                n = i8;
                if (i >= localJSONArray.length()) {
                  break;
                }
                j = i5;
                k = i6;
                m = i7;
                n = i8;
                ((ArrayList)localObject1).add(Integer.valueOf(localJSONArray.getInt(i)));
                i += 1;
              }
            }
          }
          j = i5;
          k = i6;
          m = i7;
          n = i8;
          localObject2 = ((JSONObject)localObject2).optJSONArray("enabledGroupTypesStudyMode");
          i1 = i5;
          i2 = i6;
          i3 = i7;
          i = i8;
          if (localObject2 != null)
          {
            j = i5;
            k = i6;
            m = i7;
            n = i8;
            i1 = i5;
            i2 = i6;
            i3 = i7;
            i = i8;
            if (((JSONArray)localObject2).length() > 0)
            {
              int i9 = 0;
              for (;;)
              {
                j = i5;
                k = i6;
                m = i7;
                n = i8;
                i1 = i5;
                i2 = i6;
                i3 = i7;
                i = i8;
                if (i9 >= ((JSONArray)localObject2).length()) {
                  break;
                }
                j = i5;
                k = i6;
                m = i7;
                n = i8;
                localArrayList.add(Integer.valueOf(((JSONArray)localObject2).getInt(i9)));
                i9 += 1;
              }
            }
          }
          i4 += 1;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i = n;
          i3 = m;
          i2 = k;
          i1 = j;
        }
      }
    }
    paramArrayOfQConfItem = new TroopShortcutBarConfig();
    if (i1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (i2 == 1) {
      bool1 = true;
    }
    jdField_b_of_type_Boolean = bool1;
    paramArrayOfQConfItem.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
    paramArrayOfQConfItem.jdField_a_of_type_Int = i3;
    paramArrayOfQConfItem.jdField_b_of_type_Int = i;
    paramArrayOfQConfItem.jdField_b_of_type_JavaUtilArrayList = localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse:");
      ((StringBuilder)localObject1).append(paramArrayOfQConfItem.toString());
      QLog.d("TroopShortcutBarConfig", 2, ((StringBuilder)localObject1).toString());
    }
    return paramArrayOfQConfItem;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int > 0;
  }
  
  public boolean a(int paramInt)
  {
    if (true != jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
    }
    return true;
  }
  
  public boolean b(int paramInt)
  {
    if (true != jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isGlobalOpen:");
    localStringBuilder.append(jdField_a_of_type_Boolean);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("isGlobalStudyModeOpen:");
    localStringBuilder.append(jdField_b_of_type_Boolean);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mTroopShortCutBarSwitchList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mStudyModeTroopSwitchList:");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("groupShortcutBarSwitchWithoutAdmin:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("groupAppHotRecommendSwitch:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfig
 * JD-Core Version:    0.7.0.1
 */