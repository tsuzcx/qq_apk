package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.socket.b.b;
import com.tencent.qapmsdk.socket.b.e.a;
import java.util.List;
import okio.BufferedSource;

class j$h
  implements e.a
{
  private j.i a;
  
  public j$h(j.i parami)
  {
    this.a = parami;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
  {
    if (paramBoolean) {
      this.a.a.h = true;
    }
    this.a.b.h = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<b> paramList)
  {
    boolean bool2 = true;
    if (paramBoolean1) {
      this.a.b.h = true;
    }
    j.g localg = this.a.a;
    boolean bool1 = bool2;
    if (!paramBoolean1) {
      if (!paramBoolean2) {
        break label63;
      }
    }
    label63:
    for (bool1 = bool2;; bool1 = false)
    {
      localg.h = bool1;
      this.a.a.a(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.h
 * JD-Core Version:    0.7.0.1
 */