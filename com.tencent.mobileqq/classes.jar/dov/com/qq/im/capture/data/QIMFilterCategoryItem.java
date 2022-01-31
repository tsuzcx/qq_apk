package dov.com.qq.im.capture.data;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import blmf;
import blng;
import blni;
import blnl;
import blns;
import blnt;
import bloi;
import bncp;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class QIMFilterCategoryItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMFilterCategoryItem> CREATOR = new bloi();
  public int a;
  public String a;
  public ArrayList<String> a;
  public JSONArray a;
  public boolean a;
  public int b;
  public String b;
  public JSONArray b;
  public int c;
  public String c;
  public JSONArray c;
  public String d;
  public JSONArray d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i = "";
  
  public QIMFilterCategoryItem()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
  }
  
  public QIMFilterCategoryItem(Parcel paramParcel)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.g = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramQIMFilterCategoryItem.hasNext())
    {
      Object localObject = (String)paramQIMFilterCategoryItem.next();
      localObject = bncp.a().a((String)localObject);
      if ((localObject != null) && (((FilterDesc)localObject).id == 9)) {
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
        localObject = bncp.a().a((String)localObject);
        if ((localObject != null) && (((FilterDesc)localObject).id == 1011)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    int j = -1;
    Iterator localIterator = ((blnl)blmf.a(5)).a(this).b.iterator();
    if (localIterator.hasNext())
    {
      blng localblng = (blng)localIterator.next();
      if (!(localblng instanceof blni)) {
        break label93;
      }
      j = ((blni)localblng).a.id;
    }
    label93:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("FilterCategoryItem", 2, "getFilterId=" + j);
      }
      return j;
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
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("name", this.b);
      localJSONObject.put("camera", this.g);
      localJSONObject.put("iconUrl", this.d);
      localJSONObject.put("categoryId", this.jdField_a_of_type_Int);
      localJSONObject.put("categoryName", this.e);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
        localJSONObject.put("filterIds", localJSONArray);
      }
      localJSONObject.put("isCombo", this.jdField_a_of_type_Boolean);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.h))
    {
      bool1 = bool2;
      if (this.h.startsWith("qim")) {
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
      String[] arrayOfString = blns.a;
      int k = arrayOfString.length;
      int j = 0;
      while (j < k)
      {
        if (arrayOfString[j].equals(str)) {
          return false;
        }
        j += 1;
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
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_a_of_type_JavaUtilArrayList.contains("EMPTY")) || (this.jdField_a_of_type_JavaUtilArrayList.contains("EMPTY2")));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() != 1)) {
      return false;
    }
    if (QQAVImageFilterConstants.getFilterType(bncp.a().a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0)).id) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    return ("2".equals(this.f)) || ("3".equals(this.f));
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.intern().hashCode();
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.b + '\'' + ", isCombo=" + this.jdField_a_of_type_Boolean + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.e);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(0);
    if (this.jdField_a_of_type_Boolean) {
      paramInt = 1;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMFilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */