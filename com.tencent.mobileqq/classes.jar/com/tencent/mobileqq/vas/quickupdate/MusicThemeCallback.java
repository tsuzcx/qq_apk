package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;

public class MusicThemeCallback
  extends BaseUpdateCallback
{
  public static MusicThemeCallback sInstance = new MusicThemeCallback();
  
  public void cleanCache(Context paramContext)
  {
    super.cleanCache(paramContext);
    ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).onMusicThemeCleanCache();
  }
  
  public long getBID()
  {
    return 38L;
  }
  
  protected String getRootDir()
  {
    return "musicTheme";
  }
  
  protected String getScidPrefix()
  {
    return "musicTheme.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback
 * JD-Core Version:    0.7.0.1
 */