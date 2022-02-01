package com.tencent.turingfd.sdk.xq;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class private
{
  public static HashMap<String, byte[]> _f;
  public String ag = "UTF-8";
  public for bg = new for();
  public HashMap<String, byte[]> cg = new HashMap();
  public HashMap<String, Object> dg = new HashMap();
  
  public private()
  {
    for localfor = this.bg;
    localfor.n = 3;
    localfor.q = 3;
  }
  
  public <T> T a(String paramString, T paramT)
  {
    Object localObject = null;
    if (this.cg.containsKey(paramString))
    {
      if (!this.dg.containsKey(paramString)) {
        break label35;
      }
      localObject = this.dg.get(paramString);
    }
    for (;;)
    {
      return localObject;
      label35:
      localObject = (byte[])this.cg.get(paramString);
      try
      {
        try localtry = new try();
        localtry.i = ByteBuffer.wrap((byte[])localObject);
        localtry.b(this.ag);
        paramT = localtry.a(paramT, 0, true);
        localObject = paramT;
        if (paramT == null) {
          continue;
        }
        this.dg.put(paramString, paramT);
        return paramT;
      }
      catch (Exception paramString)
      {
        throw new Exception(paramString);
      }
    }
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if ((paramString != null) && (!paramString.startsWith(".")) && (paramT != null) && (!(paramT instanceof Set)))
    {
      byte localbyte = new byte();
      localbyte.b(this.ag);
      localbyte.a(paramT, 0);
      paramT = char.a(localbyte.i);
      this.cg.put(paramString, paramT);
      return;
    }
    throw new IllegalArgumentException("wup put err");
  }
  
  public byte[] x()
  {
    Object localObject1 = this.bg;
    if (((for)localObject1).r == null) {
      ((for)localObject1).r = "";
    }
    localObject1 = this.bg;
    if (((for)localObject1).s == null) {
      ((for)localObject1).s = "";
    }
    localObject1 = new byte(0);
    ((byte)localObject1).b(this.ag);
    ((byte)localObject1).a(this.cg, 0);
    this.bg.t = char.a(((byte)localObject1).i);
    localObject1 = new byte(0);
    ((byte)localObject1).b(this.ag);
    Object localObject2 = this.bg;
    ((byte)localObject1).a(((for)localObject2).n, 1);
    ((byte)localObject1).a(((for)localObject2).o, 2);
    ((byte)localObject1).a(((for)localObject2).p, 3);
    ((byte)localObject1).a(((for)localObject2).q, 4);
    ((byte)localObject1).b(((for)localObject2).r, 5);
    ((byte)localObject1).b(((for)localObject2).s, 6);
    ((byte)localObject1).a(((for)localObject2).t, 7);
    ((byte)localObject1).a(((for)localObject2).u, 8);
    ((byte)localObject1).a(((for)localObject2).v, 9);
    ((byte)localObject1).a(((for)localObject2).status, 10);
    localObject1 = char.a(((byte)localObject1).i);
    int i = localObject1.length + 4;
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(i).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.private
 * JD-Core Version:    0.7.0.1
 */