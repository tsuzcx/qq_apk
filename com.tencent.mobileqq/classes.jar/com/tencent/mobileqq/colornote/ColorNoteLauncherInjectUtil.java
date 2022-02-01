package com.tencent.mobileqq.colornote;

import com.tencent.mobileqq.colornote.launcher.BoodoLauncher;
import com.tencent.mobileqq.colornote.launcher.ILauncher;
import com.tencent.mobileqq.colornote.launcher.MiniAppLauncher;
import com.tencent.mobileqq.colornote.launcher.MusicLauncher;
import com.tencent.mobileqq.colornote.launcher.QFavLauncher;
import com.tencent.mobileqq.colornote.launcher.QFileColorNoteLauncher;
import com.tencent.mobileqq.colornote.launcher.QZoneLauncher;
import com.tencent.mobileqq.colornote.launcher.SubscribeColorNoteLauncher;
import com.tencent.mobileqq.colornote.launcher.UpcomingLauncher;
import com.tencent.mobileqq.colornote.launcher.WebLauncher;
import com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceLauncher;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLauncher;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class ColorNoteLauncherInjectUtil
{
  @ConfigInject(configPath="Business/ColorNote-impl/src/main/resources/Inject_ColorNoteLauncherConfig.yml", version=1)
  public static ArrayList<Class<? extends ILauncher>> a = new ArrayList();
  
  static
  {
    a.add(BoodoLauncher.class);
    a.add(MiniAppLauncher.class);
    a.add(MusicLauncher.class);
    a.add(QFavLauncher.class);
    a.add(QFileColorNoteLauncher.class);
    a.add(QQVoiceLauncher.class);
    a.add(QZoneLauncher.class);
    a.add(ReadInJoyLauncher.class);
    a.add(SubscribeColorNoteLauncher.class);
    a.add(UpcomingLauncher.class);
    a.add(WebLauncher.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteLauncherInjectUtil
 * JD-Core Version:    0.7.0.1
 */