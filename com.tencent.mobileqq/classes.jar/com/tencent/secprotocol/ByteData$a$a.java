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
      ByteData.access$400(this.a.b).a((String)paramObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data: ");
      localStringBuilder.append(paramObject);
      ByteData.logCat("poxy_java", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.a.a
 * JD-Core Version:    0.7.0.1
 */