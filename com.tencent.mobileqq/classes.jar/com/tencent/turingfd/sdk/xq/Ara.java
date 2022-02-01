package com.tencent.turingfd.sdk.xq;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class Ara
{
  public static HashMap<String, byte[]> a;
  public if b = new if();
  public HashMap<String, byte[]> c = new HashMap();
  public HashMap<String, Object> d = new HashMap();
  
  public Ara()
  {
    if localif = this.b;
    localif.d = 3;
    localif.g = 3;
  }
  
  public <T> T a(String paramString, T paramT)
  {
    if (this.c.containsKey(paramString))
    {
      if (this.d.containsKey(paramString)) {
        return this.d.get(paramString);
      }
      byte[] arrayOfByte = (byte[])this.c.get(paramString);
      try
      {
        try localtry = new try();
        localtry.a = ByteBuffer.wrap(arrayOfByte);
        localtry.b = "UTF-8";
        paramT = localtry.a(paramT, 0, true);
        if (paramT != null) {
          this.d.put(paramString, paramT);
        }
        return paramT;
      }
      catch (Exception paramString)
      {
        throw new Exception(paramString);
      }
    }
    return null;
  }
  
  public byte[] a()
  {
    Object localObject = this.b;
    if (((if)localObject).h == null) {
      ((if)localObject).h = "";
    }
    if (((if)localObject).i == null) {
      ((if)localObject).i = "";
    }
    localObject = new case(0);
    ((case)localObject).b = "UTF-8";
    ((case)localObject).a(this.c, 0);
    this.b.j = goto.a(((case)localObject).a);
    localObject = new case(0);
    ((case)localObject).b = "UTF-8";
    this.b.a((case)localObject);
    localObject = goto.a(((case)localObject).a);
    int i = localObject.length + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.putInt(i).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
  
  public <T> void b(String paramString, T paramT)
  {
    if ((!paramString.startsWith(".")) && (paramT != null) && (!(paramT instanceof Set)))
    {
      case localcase = new case(128);
      localcase.b = "UTF-8";
      localcase.a(paramT, 0);
      paramT = goto.a(localcase.a);
      this.c.put(paramString, paramT);
      return;
    }
    throw new IllegalArgumentException("wup put err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Ara
 * JD-Core Version:    0.7.0.1
 */