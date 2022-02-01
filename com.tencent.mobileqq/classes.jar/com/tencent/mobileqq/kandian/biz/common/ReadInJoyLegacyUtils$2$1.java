package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.data.OpenID;

class ReadInJoyLegacyUtils$2$1
  implements Runnable
{
  ReadInJoyLegacyUtils$2$1(ReadInJoyLegacyUtils.2 param2, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject instanceof OpenID))
    {
      localObject = (OpenID)localObject;
      if ((ReadInJoyLegacyUtils.a(this.this$0.a, (OpenID)localObject, this.this$0.b, this.this$0.c) ^ true)) {
        ReadInJoyLegacyUtils.b(this.this$0.a, this.this$0.b, this.this$0.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils.2.1
 * JD-Core Version:    0.7.0.1
 */