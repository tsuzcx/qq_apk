package com.tencent.tbs.one.impl.a;

import android.util.Log;

final class f$a
  implements f.b
{
  f.b a;
  boolean b = false;
  
  public final void a(int paramInt, String paramString)
  {
    f.b localb = this.a;
    if (localb != null) {
      localb.a(paramInt, paramString);
    }
    if ((5 == paramInt) || (this.b)) {
      Log.println(paramInt, "TBSOne", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.f.a
 * JD-Core Version:    0.7.0.1
 */