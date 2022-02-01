package com.tencent.qapmsdk.socket.b;

import okio.ByteString;

public final class b
{
  public static final ByteString a = ByteString.encodeUtf8(":");
  public static final ByteString b = ByteString.encodeUtf8(":status");
  public static final ByteString c = ByteString.encodeUtf8(":method");
  public static final ByteString d = ByteString.encodeUtf8(":path");
  public static final ByteString e = ByteString.encodeUtf8(":scheme");
  public static final ByteString f = ByteString.encodeUtf8(":authority");
  public final ByteString g;
  public final ByteString h;
  final int i;
  
  public b(String paramString1, String paramString2)
  {
    this(ByteString.encodeUtf8(paramString1), ByteString.encodeUtf8(paramString2));
  }
  
  public b(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.encodeUtf8(paramString));
  }
  
  public b(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.g = paramByteString1;
    this.h = paramByteString2;
    this.i = (paramByteString1.size() + 32 + paramByteString2.size());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (this.g.equals(paramObject.g))
      {
        bool1 = bool2;
        if (this.h.equals(paramObject.h)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (527 + this.g.hashCode()) * 31 + this.h.hashCode();
  }
  
  public String toString()
  {
    return g.a("%s: %s", new Object[] { this.g.utf8(), this.h.utf8() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.b
 * JD-Core Version:    0.7.0.1
 */