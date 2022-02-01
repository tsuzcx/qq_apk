package com.tencent.turingfd.sdk.xq;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class volatile
{
  public static HashMap<String, byte[]> tg;
  public String ug = "UTF-8";
  public for vg = new for();
  public HashMap<String, byte[]> wg = new HashMap();
  public HashMap<String, Object> xg = new HashMap();
  
  public volatile()
  {
    for localfor = this.vg;
    localfor.s = 3;
    localfor.v = 3;
  }
  
  public byte[] K()
  {
    Object localObject1 = this.vg;
    if (((for)localObject1).A == null) {
      ((for)localObject1).A = "";
    }
    localObject1 = this.vg;
    if (((for)localObject1).B == null) {
      ((for)localObject1).B = "";
    }
    localObject1 = new byte(0);
    ((byte)localObject1).c(this.ug);
    ((byte)localObject1).a(this.wg, 0);
    this.vg.C = char.a(((byte)localObject1).n);
    localObject1 = new byte(0);
    ((byte)localObject1).c(this.ug);
    Object localObject2 = this.vg;
    ((byte)localObject1).a(((for)localObject2).s, 1);
    ((byte)localObject1).a(((for)localObject2).t, 2);
    ((byte)localObject1).b(((for)localObject2).u, 3);
    ((byte)localObject1).b(((for)localObject2).v, 4);
    ((byte)localObject1).b(((for)localObject2).A, 5);
    ((byte)localObject1).b(((for)localObject2).B, 6);
    ((byte)localObject1).a(((for)localObject2).C, 7);
    ((byte)localObject1).b(((for)localObject2).D, 8);
    ((byte)localObject1).a(((for)localObject2).F, 9);
    ((byte)localObject1).a(((for)localObject2).status, 10);
    localObject1 = char.a(((byte)localObject1).n);
    int i = localObject1.length + 4;
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(i).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public <T> T a(String paramString, T paramT)
  {
    if (this.wg.containsKey(paramString))
    {
      if (this.xg.containsKey(paramString)) {
        return this.xg.get(paramString);
      }
      byte[] arrayOfByte = (byte[])this.wg.get(paramString);
      try
      {
        try localtry = new try();
        localtry.n = ByteBuffer.wrap(arrayOfByte);
        localtry.c(this.ug);
        paramT = localtry.a(paramT, 0, true);
        if (paramT != null) {
          this.xg.put(paramString, paramT);
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
  
  public <T> void put(String paramString, T paramT)
  {
    if ((paramString != null) && (!paramString.startsWith(".")) && (paramT != null) && (!(paramT instanceof Set)))
    {
      byte localbyte = new byte();
      localbyte.c(this.ug);
      localbyte.a(paramT, 0);
      paramT = char.a(localbyte.n);
      this.wg.put(paramString, paramT);
      return;
    }
    throw new IllegalArgumentException("wup put err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.volatile
 * JD-Core Version:    0.7.0.1
 */