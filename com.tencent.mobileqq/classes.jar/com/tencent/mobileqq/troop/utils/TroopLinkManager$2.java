package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgld;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.AppRuntime;

public class TroopLinkManager$2
  implements Runnable
{
  public TroopLinkManager$2(bgld parambgld, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!FileUtils.writeFile(this.a, this.b)) {
      BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("troop_link_config_version", 0).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopLinkManager.2
 * JD-Core Version:    0.7.0.1
 */