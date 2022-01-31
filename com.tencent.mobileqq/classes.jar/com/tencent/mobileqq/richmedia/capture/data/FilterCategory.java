package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import axkl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterCategory
  implements Parcelable
{
  public static final Parcelable.Creator<FilterCategory> CREATOR = new axkl();
  public int a;
  public String a;
  public List<FilterCategoryItem> a;
  
  public FilterCategory(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(FilterCategoryItem.CREATOR);
  }
  
  public FilterCategory(JSONObject paramJSONObject, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("categoryId");
    Object localObject1 = null;
    int i;
    boolean bool;
    Object localObject2;
    if (paramCaptureRedDotConfig != null)
    {
      i = paramJSONObject.optInt("redDotVersion");
      bool = paramJSONObject.optBoolean("needRedDot");
      localObject2 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localObject2 == null) {
        break label434;
      }
      localObject1 = localObject2;
      if (((CaptureRedDotConfig.CategoryRedConfig)localObject2).version != i)
      {
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).version = i;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).showRedDot = bool;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).hasShow = false;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).firstShowTime = 0L;
        localObject1 = localObject2;
      }
    }
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      localObject2 = new ArrayList();
      int k = paramJSONObject.length();
      i = 0;
      label145:
      if (i < k)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        FilterCategoryItem localFilterCategoryItem = new FilterCategoryItem();
        localFilterCategoryItem.d = localJSONObject.optString("iconUrl");
        localFilterCategoryItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("name");
        localFilterCategoryItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("id");
        localFilterCategoryItem.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        localFilterCategoryItem.e = localJSONObject.optString("englishName");
        localFilterCategoryItem.f = localJSONObject.optString("usedPeople");
        localFilterCategoryItem.jdField_a_of_type_Boolean = localJSONObject.optBoolean("advertisement");
        if (localFilterCategoryItem.jdField_a_of_type_Boolean) {
          QLog.d("FilterCategory", 2, "item.advertisement is true name is:" + localFilterCategoryItem.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          try
          {
            localFilterCategoryItem.j = localJSONObject.optString("badgeurl");
            localFilterCategoryItem.h = localJSONObject.optString("openurl");
            localFilterCategoryItem.g = localJSONObject.optString("androidopenurlheader");
            localFilterCategoryItem.i = localJSONObject.optString("storeurl");
            localFilterCategoryItem.jdField_b_of_type_Boolean = localJSONObject.optBoolean("popup");
            localFilterCategoryItem.m = localJSONObject.optString("popupbtn");
            localFilterCategoryItem.l = localJSONObject.optString("popupcontent");
            localFilterCategoryItem.o = localJSONObject.optString("popupbtn2");
            localFilterCategoryItem.n = localJSONObject.optString("popupcontent2");
            localFilterCategoryItem.k = localJSONObject.optString("popupimgurl");
            localFilterCategoryItem.p = localJSONObject.optString("buttonbgcolor");
            ((List)localObject2).add(localFilterCategoryItem);
            i += 1;
            break label145;
            label434:
            localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
            ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = this.jdField_a_of_type_Int;
            ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = i;
            ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          }
          catch (Exception localException)
          {
            QLog.e("FilterCategory", 2, "item.advertisement is true has Exception", localException);
            continue;
          }
          Object localObject3 = localException.optJSONArray("filters");
          if (localObject3 != null)
          {
            int j = 0;
            int m = ((JSONArray)localObject3).length();
            while (j < m)
            {
              String str = ((JSONArray)localObject3).getJSONObject(j).optString("name");
              if (!TextUtils.isEmpty(str)) {
                localFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.add(str);
              }
              j += 1;
            }
          }
          localObject3 = localFilterCategoryItem.a();
          if ((localObject3 != null) && (((FilterDesc)localObject3).type == 1)) {
            if (QmcfManager.getInstance().isArtFilterVersionOK(((FilterDesc)localObject3).version)) {
              if (QmcfManager.getInstance().hasQmcfEntrance(1)) {}
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */