package cooperation.qzone.UndealCount;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class QZoneCountInfo
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  
  public QZoneCountInfo()
  {
    this(0, 0, new ArrayList(), "", "");
  }
  
  public QZoneCountInfo(int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public QZoneCountInfo(QZoneCountInfo paramQZoneCountInfo)
  {
    this.jdField_a_of_type_Long = paramQZoneCountInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = paramQZoneCountInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaLangString = paramQZoneCountInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = 0;
    this.d = paramQZoneCountInfo.d;
    this.c = paramQZoneCountInfo.c;
    this.jdField_b_of_type_JavaLangString = paramQZoneCountInfo.jdField_b_of_type_JavaLangString;
  }
  
  public static HashMap a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (paramCursor.moveToNext())
    {
      QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
      int j = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      localQZoneCountInfo.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("icontrol"));
      localQZoneCountInfo.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("friendMsg"));
      localQZoneCountInfo.jdField_a_of_type_Long = paramCursor.getInt(paramCursor.getColumnIndex("ucount"));
      localQZoneCountInfo.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("trace_info"));
      localQZoneCountInfo.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("friendsNum"));
      localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject1 = paramCursor.getBlob(paramCursor.getColumnIndex("frienduins"));
      Parcel localParcel;
      if ((localObject1 != null) && (localObject1.length != 0)) {
        localParcel = Parcel.obtain();
      }
      try
      {
        localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
        localParcel.setDataPosition(0);
        localObject1 = localParcel.readParcelableArray(QZoneCountUserInfo.class.getClassLoader());
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.add((QZoneCountUserInfo)localObject2);
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          localParcel.recycle();
        }
      }
      finally
      {
        localParcel.recycle();
      }
      if (paramCursor.getInt(paramCursor.getColumnIndex("existDL")) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQZoneCountInfo.jdField_a_of_type_Boolean = bool;
        localQZoneCountInfo.d = paramCursor.getString(paramCursor.getColumnIndex("pushMsg"));
        localQZoneCountInfo.c = paramCursor.getString(paramCursor.getColumnIndex("schema"));
        localHashMap.put(Integer.valueOf(j), localQZoneCountInfo);
        break;
      }
    }
    return localHashMap;
  }
  
  public ContentValues a()
  {
    ContentValues localContentValues = new ContentValues(9);
    localContentValues.put("icontrol", Integer.valueOf(this.jdField_a_of_type_Int));
    localContentValues.put("ucount", Long.valueOf(this.jdField_a_of_type_Long));
    localContentValues.put("friendsNum", Integer.valueOf(this.jdField_b_of_type_Int));
    Parcel localParcel = Parcel.obtain();
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = new QZoneCountUserInfo[this.jdField_a_of_type_JavaUtilArrayList.size()];
      localParcel.writeParcelableArray((Parcelable[])this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject), 0);
      localObject = localParcel.marshall();
    }
    localParcel.recycle();
    localContentValues.put("frienduins", (byte[])localObject);
    localContentValues.put("friendMsg", this.jdField_a_of_type_JavaLangString);
    localContentValues.put("trace_info", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("existDL", Integer.valueOf(i));
      localContentValues.put("pushMsg", this.d);
      localContentValues.put("schema", this.c);
      return localContentValues;
    }
  }
  
  public boolean a(QZoneCountInfo paramQZoneCountInfo)
  {
    if (paramQZoneCountInfo == null) {}
    while (((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramQZoneCountInfo.jdField_b_of_type_JavaLangString))) || ((paramQZoneCountInfo.jdField_b_of_type_JavaLangString != null) && (!paramQZoneCountInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) || ((this.d != null) && (!this.d.equals(paramQZoneCountInfo.d))) || ((this.d == null) && (paramQZoneCountInfo.d != null)) || ((this.c != null) && (!this.c.equals(paramQZoneCountInfo.c))) || ((this.c == null) && (paramQZoneCountInfo.c != null)) || (this.jdField_a_of_type_Long != paramQZoneCountInfo.jdField_a_of_type_Long) || (!this.jdField_a_of_type_JavaUtilArrayList.equals(paramQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountInfo
 * JD-Core Version:    0.7.0.1
 */