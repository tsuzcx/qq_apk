package com.tencent.secprotocol;

import a.a.a.b.b;
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
      Object localObject = this.b;
      long l = ((ByteData.b)localObject).b;
      String str = ((ByteData.b)localObject).a;
      localObject = ByteData.access$200(((ByteData.b)localObject).c);
      paramObject = (String)paramObject;
      locale.a(l, str, (b)localObject, paramObject);
      ByteData.logCat("poxy_java", "data: " + paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.b.a
 * JD-Core Version:    0.7.0.1
 */