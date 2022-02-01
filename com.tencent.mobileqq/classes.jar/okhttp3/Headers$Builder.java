package okhttp3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import okhttp3.internal.http.HttpDate;

public final class Headers$Builder
{
  final List<String> namesAndValues = new ArrayList(20);
  
  public Builder add(String paramString)
  {
    int i = paramString.indexOf(":");
    if (i == -1) {
      throw new IllegalArgumentException("Unexpected header: " + paramString);
    }
    return add(paramString.substring(0, i).trim(), paramString.substring(i + 1));
  }
  
  public Builder add(String paramString1, String paramString2)
  {
    Headers.checkName(paramString1);
    Headers.checkValue(paramString2, paramString1);
    return addLenient(paramString1, paramString2);
  }
  
  public Builder add(String paramString, Date paramDate)
  {
    if (paramDate == null) {
      throw new NullPointerException("value for name " + paramString + " == null");
    }
    add(paramString, HttpDate.format(paramDate));
    return this;
  }
  
  public Builder addAll(Headers paramHeaders)
  {
    int j = paramHeaders.size();
    int i = 0;
    while (i < j)
    {
      addLenient(paramHeaders.name(i), paramHeaders.value(i));
      i += 1;
    }
    return this;
  }
  
  Builder addLenient(String paramString)
  {
    int i = paramString.indexOf(":", 1);
    if (i != -1) {
      return addLenient(paramString.substring(0, i), paramString.substring(i + 1));
    }
    if (paramString.startsWith(":")) {
      return addLenient("", paramString.substring(1));
    }
    return addLenient("", paramString);
  }
  
  Builder addLenient(String paramString1, String paramString2)
  {
    this.namesAndValues.add(paramString1);
    this.namesAndValues.add(paramString2.trim());
    return this;
  }
  
  public Builder addUnsafeNonAscii(String paramString1, String paramString2)
  {
    Headers.checkName(paramString1);
    return addLenient(paramString1, paramString2);
  }
  
  public Headers build()
  {
    return new Headers(this);
  }
  
  public String get(String paramString)
  {
    int i = this.namesAndValues.size() - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i))) {
        return (String)this.namesAndValues.get(i + 1);
      }
      i -= 2;
    }
    return null;
  }
  
  public Builder removeAll(String paramString)
  {
    int j;
    for (int i = 0; i < this.namesAndValues.size(); i = j + 2)
    {
      j = i;
      if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
      {
        this.namesAndValues.remove(i);
        this.namesAndValues.remove(i);
        j = i - 2;
      }
    }
    return this;
  }
  
  public Builder set(String paramString1, String paramString2)
  {
    Headers.checkName(paramString1);
    Headers.checkValue(paramString2, paramString1);
    removeAll(paramString1);
    addLenient(paramString1, paramString2);
    return this;
  }
  
  public Builder set(String paramString, Date paramDate)
  {
    if (paramDate == null) {
      throw new NullPointerException("value for name " + paramString + " == null");
    }
    set(paramString, HttpDate.format(paramDate));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.Headers.Builder
 * JD-Core Version:    0.7.0.1
 */