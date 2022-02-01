package com.tencent.secprotocol;

import a.a.a.b.e;
import com.tencent.secprotocol.utils.IPutListener;

public class ByteData$b$a
  implements IPutListener
{
  public ByteData$b$a(ByteData.b paramb, e parame) {}
  
  public void onResult(Object paramObject, int paramInt)
  {
    if ((paramInt == 0) && (paramObject != null))
    {
      e locale = this.a;
      ByteData.b localb = this.b;
      locale.a(localb.b, localb.a, ByteData.access$300(localb.c), (String)paramObject);
      ByteData.logCat("poxy_java", "test, data: " + paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.b.a
 * JD-Core Version:    0.7.0.1
 */