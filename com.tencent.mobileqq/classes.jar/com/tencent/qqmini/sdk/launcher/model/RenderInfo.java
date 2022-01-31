package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StRenderInfo;
import NS_MINI_INTERFACE.INTERFACE.StRenderMaterial;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import besg;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RenderInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RenderInfo> CREATOR = new besg();
  public int a;
  public Map<Integer, String> a;
  
  public RenderInfo()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public RenderInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      Integer localInteger = (Integer)paramParcel.readValue(Integer.class.getClassLoader());
      String str = paramParcel.readString();
      this.jdField_a_of_type_JavaUtilMap.put(localInteger, str);
      i += 1;
    }
  }
  
  public static RenderInfo a(INTERFACE.StRenderInfo paramStRenderInfo)
  {
    RenderInfo localRenderInfo = new RenderInfo();
    if (paramStRenderInfo != null)
    {
      localRenderInfo.jdField_a_of_type_Int = paramStRenderInfo.renderMode.get();
      paramStRenderInfo = paramStRenderInfo.renderMaterials.get();
      if (paramStRenderInfo != null)
      {
        paramStRenderInfo = paramStRenderInfo.iterator();
        while (paramStRenderInfo.hasNext())
        {
          Object localObject = (INTERFACE.StRenderMaterial)paramStRenderInfo.next();
          int i = ((INTERFACE.StRenderMaterial)localObject).renderMode.get();
          localObject = ((INTERFACE.StRenderMaterial)localObject).downloadUrl.get();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localRenderInfo.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject);
          }
        }
      }
    }
    return localRenderInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RenderInfo))) {}
    while (this.jdField_a_of_type_Int != ((RenderInfo)paramObject).jdField_a_of_type_Int) {
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_a_of_type_JavaUtilMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeValue(localEntry.getKey());
      paramParcel.writeString((String)localEntry.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.RenderInfo
 * JD-Core Version:    0.7.0.1
 */