package com.tencent.mobileqq.dinifly.parser.moshi;

import java.io.Closeable;
import java.util.Arrays;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonReader
  implements Closeable
{
  private static final String[] REPLACEMENT_CHARS = new String[''];
  boolean failOnUnknown;
  boolean lenient;
  int[] pathIndices = new int[32];
  String[] pathNames = new String[32];
  int[] scopes = new int[32];
  int stackSize;
  
  static
  {
    int i = 0;
    while (i <= 31)
    {
      REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    String[] arrayOfString = REPLACEMENT_CHARS;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
  }
  
  public static JsonReader of(BufferedSource paramBufferedSource)
  {
    return new JsonUtf8Reader(paramBufferedSource);
  }
  
  private static void string(BufferedSink paramBufferedSink, String paramString)
  {
    String[] arrayOfString = REPLACEMENT_CHARS;
    paramBufferedSink.writeByte(34);
    int m = paramString.length();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = paramString.charAt(i);
      String str1;
      if (n < 128)
      {
        String str2 = arrayOfString[n];
        str1 = str2;
        if (str2 == null)
        {
          k = j;
          break label126;
        }
      }
      else if (n == 8232)
      {
        str1 = "\\u2028";
      }
      else
      {
        k = j;
        if (n != 8233) {
          break label126;
        }
        str1 = "\\u2029";
      }
      if (j < i) {
        paramBufferedSink.writeUtf8(paramString, j, i);
      }
      paramBufferedSink.writeUtf8(str1);
      k = i + 1;
      label126:
      i += 1;
    }
    if (j < m) {
      paramBufferedSink.writeUtf8(paramString, j, m);
    }
    paramBufferedSink.writeByte(34);
  }
  
  public abstract void beginArray();
  
  public abstract void beginObject();
  
  public abstract void endArray();
  
  public abstract void endObject();
  
  public final String getPath()
  {
    return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
  }
  
  public abstract boolean hasNext();
  
  public abstract boolean nextBoolean();
  
  public abstract double nextDouble();
  
  public abstract int nextInt();
  
  public abstract String nextName();
  
  public abstract String nextString();
  
  public abstract JsonReader.Token peek();
  
  final void pushScope(int paramInt)
  {
    int i = this.stackSize;
    Object localObject = this.scopes;
    if (i == localObject.length) {
      if (i != 256)
      {
        this.scopes = Arrays.copyOf((int[])localObject, localObject.length * 2);
        localObject = this.pathNames;
        this.pathNames = ((String[])Arrays.copyOf((Object[])localObject, localObject.length * 2));
        localObject = this.pathIndices;
        this.pathIndices = Arrays.copyOf((int[])localObject, localObject.length * 2);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Nesting too deep at ");
        ((StringBuilder)localObject).append(getPath());
        throw new JsonDataException(((StringBuilder)localObject).toString());
      }
    }
    localObject = this.scopes;
    i = this.stackSize;
    this.stackSize = (i + 1);
    localObject[i] = paramInt;
  }
  
  public abstract int selectName(JsonReader.Options paramOptions);
  
  public abstract void skipName();
  
  public abstract void skipValue();
  
  final JsonEncodingException syntaxError(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new JsonEncodingException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.moshi.JsonReader
 * JD-Core Version:    0.7.0.1
 */