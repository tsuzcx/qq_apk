package dov.com.qq.im.capture.text;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bpsl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class DynamicTextItem$TextMap
  implements Parcelable
{
  public static final Parcelable.Creator<TextMap> CREATOR = new bpsl();
  private Map<Integer, String> a = new HashMap();
  
  public DynamicTextItem$TextMap() {}
  
  public DynamicTextItem$TextMap(Parcel paramParcel)
  {
    this();
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      this.a.put(Integer.valueOf(paramParcel.readInt()), paramParcel.readString());
      i += 1;
    }
  }
  
  public DynamicTextItem$TextMap(@NonNull List<String> paramList)
  {
    this();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        this.a.put(Integer.valueOf(i), paramList.get(i));
        i += 1;
      }
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    int i = -1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getKey()).intValue() <= i) {
        break label72;
      }
      i = ((Integer)localEntry.getKey()).intValue();
    }
    label72:
    for (;;)
    {
      break;
      return i + 1;
    }
  }
  
  @NonNull
  public String a(int paramInt)
  {
    int i = a();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IndexOutOfBoundsException("location " + paramInt + " is out of bounds, TextMap size is " + i);
    }
    String str2 = (String)this.a.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @NonNull
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = a();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.a.get(Integer.valueOf(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public JSONArray a()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(a());
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONArray.put(localEntry.getKey());
        localJSONArray.put(localEntry.getValue());
      }
      return localException;
    }
    catch (Exception localException)
    {
      return null;
    }
  }
  
  public void a(int paramInt, @NonNull String paramString)
  {
    if (paramInt != -1) {
      this.a.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() >= paramInt1) && (((Integer)localEntry.getKey()).intValue() < paramInt2) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue()))) {
        return false;
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TextMap)paramObject;
      if (!this.a.equals(paramObject.a))
      {
        int j = this.a.size();
        if (j != paramObject.a.size()) {
          return false;
        }
        int i = 0;
        while (i < j)
        {
          if (!a(i).equals(paramObject.a(i))) {
            return false;
          }
          i += 1;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    int j = a();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.a.get(Integer.valueOf(i))).append("#");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a.size());
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeInt(((Integer)localEntry.getKey()).intValue());
      paramParcel.writeString((String)localEntry.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem.TextMap
 * JD-Core Version:    0.7.0.1
 */