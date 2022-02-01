package com.tencent.timi.game.liveroom.impl.more;

import android.content.Context;

public class AnchorMoreDialog$Builder
{
  public Context a;
  public long b;
  public int c;
  public boolean d = false;
  
  public static Builder a(Context paramContext, long paramLong, int paramInt, boolean paramBoolean)
  {
    Builder localBuilder = new Builder();
    localBuilder.a = paramContext;
    localBuilder.b = paramLong;
    localBuilder.c = paramInt;
    localBuilder.d = paramBoolean;
    return localBuilder;
  }
  
  public AnchorMoreDialog a()
  {
    AnchorMoreDialog localAnchorMoreDialog = new AnchorMoreDialog(this.a);
    localAnchorMoreDialog.a(this.b);
    localAnchorMoreDialog.a(this.c);
    localAnchorMoreDialog.a(this.d);
    return localAnchorMoreDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorMoreDialog.Builder
 * JD-Core Version:    0.7.0.1
 */