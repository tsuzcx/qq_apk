package com.tencent.secprotocol;

import a.a.a.b.a;
import com.tencent.secprotocol.utils.IPutListener;

public class ByteData$a$a
  implements IPutListener
{
  public ByteData$a$a(ByteData.a parama) {}
  
  public void onResult(Object paramObject, int paramInt)
  {
    if ((paramInt == 0) && (paramObject != null))
    {
      a locala = ByteData.access$300(this.a.b);
      paramObject = (String)paramObject;
      locala.a(paramObject);
      ByteData.logCat("poxy_java", "data: " + paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.a.a
 * JD-Core Version:    0.7.0.1
 */