package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory
{
  private Context mAppContext = null;
  private TbsWizard mAppWizard = null;
  private DexLoader mDexLoader = null;
  
  public TbsMediaFactory(Context paramContext)
  {
    this.mAppContext = paramContext.getApplicationContext();
    initPlayerFactory();
  }
  
  private void initPlayerFactory()
  {
    if (this.mAppContext == null) {
      Log.e("TbsVideo", "TbsVideo needs context !!");
    }
    do
    {
      return;
      if (this.mAppWizard == null)
      {
        SDKEngine.getInstance(true).init(this.mAppContext, false, false, null);
        this.mAppWizard = SDKEngine.getInstance(true).wizard();
        if (this.mAppWizard != null) {
          this.mDexLoader = this.mAppWizard.dexLoader();
        }
      }
    } while ((this.mAppWizard != null) && (this.mDexLoader != null));
    throw new RuntimeException("tbs core dex(s) load failure !!!");
  }
  
  public TbsMediaPlayer createPlayer()
  {
    if ((this.mAppWizard == null) || (this.mDexLoader == null)) {
      throw new RuntimeException("tbs core dex(s) did not loaded !!!");
    }
    return new TbsMediaPlayer(new TbsMediaPlayerWizard(this.mDexLoader, this.mAppContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaFactory
 * JD-Core Version:    0.7.0.1
 */