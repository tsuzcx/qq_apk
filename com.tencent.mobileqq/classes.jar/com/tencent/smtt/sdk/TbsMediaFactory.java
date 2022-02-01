package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory
{
  private Context a = null;
  private v b = null;
  private DexLoader c = null;
  
  public TbsMediaFactory(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    a();
  }
  
  private void a()
  {
    if (this.a == null)
    {
      Log.e("TbsVideo", "TbsVideo needs context !!");
      return;
    }
    if (this.b == null)
    {
      f.a(true).a(this.a, false, false, null);
      this.b = f.a(true).a();
      v localv = this.b;
      if (localv != null) {
        this.c = localv.b();
      }
    }
    if ((this.b != null) && (this.c != null)) {
      return;
    }
    throw new RuntimeException("tbs core dex(s) load failure !!!");
  }
  
  public TbsMediaPlayer createPlayer()
  {
    if (this.b != null)
    {
      DexLoader localDexLoader = this.c;
      if (localDexLoader != null) {
        return new TbsMediaPlayer(new q(localDexLoader, this.a));
      }
    }
    throw new RuntimeException("tbs core dex(s) did not loaded !!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaFactory
 * JD-Core Version:    0.7.0.1
 */