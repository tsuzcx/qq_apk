package com.tencent.mobileqq.cmshow.engine.resource;

import java.util.HashMap;

class AbsApolloResManager$6$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResManager$6$1(AbsApolloResManager.6 param6, HashMap paramHashMap) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((paramBoolean) && (paramArrayOfInt != null))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt.length)
      {
        this.a.put(Integer.valueOf(paramArrayOfInt[paramInt1]), this.b.this$0.c(paramArrayOfInt[paramInt1]));
        paramInt1 += 1;
      }
      if (this.b.b != null) {
        this.b.b.a(this.a, "success", 0);
      }
    }
    else if (this.b.b != null)
    {
      this.b.b.a(null, "download error", -5003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.6.1
 * JD-Core Version:    0.7.0.1
 */