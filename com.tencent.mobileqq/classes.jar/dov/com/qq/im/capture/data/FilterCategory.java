package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anlp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterCategory
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new anlp();
  public int a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  public boolean b;
  
  public FilterCategory(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public FilterCategory(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(QIMFilterCategoryItem.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public FilterCategory(JSONObject paramJSONObject, QIMRedDotConfig paramQIMRedDotConfig)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("categoryId");
    this.jdField_b_of_type_Boolean = "1".equals(paramJSONObject.optString("random_position", "0"));
    this.jdField_b_of_type_Int = paramJSONObject.optInt("hide_mask", 0);
    Object localObject1 = null;
    int i;
    boolean bool;
    Object localObject2;
    if (paramQIMRedDotConfig != null)
    {
      i = paramJSONObject.optInt("redDotVersion");
      bool = paramJSONObject.optBoolean("needRedDot");
      localObject2 = (QIMRedDotConfig.CategoryRedConfig)paramQIMRedDotConfig.categories.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localObject2 == null) {
        break label370;
      }
      localObject1 = localObject2;
      if (((QIMRedDotConfig.CategoryRedConfig)localObject2).version != i)
      {
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).version = i;
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).showRedDot = bool;
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).hasShow = false;
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).firstShowTime = 0L;
        localObject1 = localObject2;
      }
    }
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      localObject2 = new ArrayList();
      int k = paramJSONObject.length();
      i = 0;
      bool = false;
      if (i < k)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        QIMFilterCategoryItem localQIMFilterCategoryItem = new QIMFilterCategoryItem();
        localQIMFilterCategoryItem.jdField_c_of_type_JavaLangString = localJSONObject.optString("iconUrl");
        localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("name");
        localQIMFilterCategoryItem.f = localJSONObject.optString("camera");
        localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("id");
        localQIMFilterCategoryItem.e = localJSONObject.optString("type_combo");
        localQIMFilterCategoryItem.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localQIMFilterCategoryItem.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        localQIMFilterCategoryItem.g = localJSONObject.optString("jump_ws");
        JSONArray localJSONArray = localJSONObject.optJSONArray("filters");
        if (localJSONArray != null)
        {
          int j = 0;
          int m = localJSONArray.length();
          label317:
          if (j < m)
          {
            Object localObject3 = localJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject3).optString("name");
            if (!TextUtils.isEmpty(str)) {
              localQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.add(str);
            }
            for (;;)
            {
              j += 1;
              break label317;
              label370:
              localObject1 = new QIMRedDotConfig.CategoryRedConfig();
              ((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId = this.jdField_a_of_type_Int;
              ((QIMRedDotConfig.CategoryRedConfig)localObject1).version = i;
              ((QIMRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
              break;
              localObject3 = ((JSONObject)localObject3).optString("name_android");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
              }
            }
          }
        }
        localQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("pasters");
        localQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("musics");
        localQIMFilterCategoryItem.jdField_c_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("ufaces");
        localQIMFilterCategoryItem.jdField_d_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("texts");
        if (((localQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray == null) || (localQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.length() == 0)) && ((localQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray == null) || (localQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.length() == 0)) && ((localQIMFilterCategoryItem.jdField_c_of_type_OrgJsonJSONArray == null) || (localQIMFilterCategoryItem.jdField_c_of_type_OrgJsonJSONArray.length() == 0))) {
          localQIMFilterCategoryItem.jdField_a_of_type_Boolean = false;
        }
        for (;;)
        {
          ((List)localObject2).add(localQIMFilterCategoryItem);
          i += 1;
          break;
          localQIMFilterCategoryItem.jdField_a_of_type_Boolean = true;
          bool = true;
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
      if ((paramQIMRedDotConfig != null) && (localObject1 != null)) {
        paramQIMRedDotConfig.categories.put(Integer.valueOf(((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      this.jdField_a_of_type_Boolean = bool;
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
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */