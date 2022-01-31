package dov.com.qq.im.capture.data;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anue;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class QIMFilterCategoryItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new anue();
  public int a;
  public String a;
  public ArrayList a;
  public JSONArray a;
  public boolean a;
  public int b;
  public String b;
  public JSONArray b;
  public String c;
  public JSONArray c;
  public String d;
  public JSONArray d;
  public String e;
  public String f;
  public String g;
  
  public QIMFilterCategoryItem()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
  }
  
  public QIMFilterCategoryItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.f = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.g = paramParcel.readString();
  }
  
  public static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramQIMFilterCategoryItem.hasNext())
    {
      Object localObject = (String)paramQIMFilterCategoryItem.next();
      localObject = VideoFilterTools.a().a((String)localObject);
      if ((localObject != null) && (((FilterDesc)localObject).jdField_b_of_type_Int == 9)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (Build.VERSION.SDK_INT == 18)
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramQIMFilterCategoryItem.hasNext())
      {
        Object localObject = (String)paramQIMFilterCategoryItem.next();
        localObject = VideoFilterTools.a().a((String)localObject);
        if ((localObject != null) && (((FilterDesc)localObject).jdField_b_of_type_Int == 1011)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    int i = -1;
    Iterator localIterator = ((CaptureComboManager)QIMManager.a(5)).a(this).b.iterator();
    if (localIterator.hasNext())
    {
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
      if (!(localCaptureComboBase instanceof CaptureComboFilter)) {
        break label93;
      }
      i = ((CaptureComboFilter)localCaptureComboBase).a.jdField_b_of_type_Int;
    }
    label93:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("FilterCategoryItem", 2, "getFilterId=" + i);
      }
      return i;
    }
  }
  
  public QIMFilterCategoryItem a()
  {
    try
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)super.clone();
      return localQIMFilterCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    String str = "";
    Iterator localIterator = ((CaptureComboManager)QIMManager.a(5)).a(this).b.iterator();
    CaptureComboBase localCaptureComboBase;
    if (localIterator.hasNext())
    {
      localCaptureComboBase = (CaptureComboBase)localIterator.next();
      if (!(localCaptureComboBase instanceof CaptureComboFilter)) {
        break label106;
      }
      if (TextUtils.isEmpty(str)) {
        str = ((CaptureComboFilter)localCaptureComboBase).a.f;
      }
    }
    label106:
    for (;;)
    {
      break;
      str = str + " " + ((CaptureComboFilter)localCaptureComboBase).a.f;
      continue;
      return str;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.g))
    {
      bool1 = bool2;
      if (this.g.startsWith("qim")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = CaptureConst.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(str)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains("EMPTY"));
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() != 1)) {
      return false;
    }
    if (QQAVImageFilterConstants.a(VideoFilterTools.a().a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return "2".equals(this.e);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.hashCode() != hashCode()) {
      return false;
    }
    return true;
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterCategoryItem", 2, "needPredownload");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      FilterDesc localFilterDesc = VideoFilterTools.a().a(str1);
      if (localFilterDesc != null)
      {
        String str2 = localFilterDesc.b(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
        if ((!TextUtils.isEmpty(localFilterDesc.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str2)) && (VideoFilterListDownloader.a(localFilterDesc)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FilterCategoryItem", 2, "needPredownload " + str1);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.intern().hashCode();
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.jdField_b_of_type_JavaLangString + '\'' + ", isCombo=" + this.jdField_a_of_type_Boolean + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(0);
    if (this.jdField_a_of_type_Boolean) {
      paramInt = 1;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMFilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */