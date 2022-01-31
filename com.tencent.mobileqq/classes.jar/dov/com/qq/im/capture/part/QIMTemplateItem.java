package dov.com.qq.im.capture.part;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import blsg;
import bluu;
import java.util.ArrayList;
import org.json.JSONArray;

public class QIMTemplateItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMTemplateItem> CREATOR = new bluu();
  public int a;
  public String a;
  public ArrayList<String> a;
  public JSONArray a;
  public boolean a;
  public String b;
  public JSONArray b;
  public boolean b;
  public String c;
  public JSONArray c;
  public String d;
  public JSONArray d;
  public String e;
  public JSONArray e;
  public String f;
  public JSONArray f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public QIMTemplateItem()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public QIMTemplateItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.f = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label163;
      }
    }
    label163:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.j = (blsg.jdField_b_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + ".mp4");
      return;
      bool1 = false;
      break;
    }
  }
  
  public QIMTemplateItem a()
  {
    try
    {
      QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)super.clone();
      return localQIMTemplateItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains("EMPTY"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.hashCode() != hashCode()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.intern().hashCode();
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.jdField_b_of_type_JavaLangString + '\'' + ", isCombo=" + this.jdField_b_of_type_Boolean + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_b_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      if (!this.jdField_a_of_type_Boolean) {
        break label118;
      }
    }
    label118:
    for (paramInt = k;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.part.QIMTemplateItem
 * JD-Core Version:    0.7.0.1
 */