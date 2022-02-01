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
      this.a.a(this.b.b, (String)paramObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("test, data: ");
      localStringBuilder.append(paramObject);
      ByteData.logCat("poxy_java", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.b.a
 * JD-Core Version:    0.7.0.1
 */