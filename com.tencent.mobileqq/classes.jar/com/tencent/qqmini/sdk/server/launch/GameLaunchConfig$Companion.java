package com.tencent.qqmini.sdk.server.launch;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig$Companion;", "", "()V", "enableGameProcessReuse", "", "fromWnsConfig", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameLaunchConfig$Companion
{
  private final boolean enableGameProcessReuse()
  {
    int i;
    if (WnsConfig.getConfig("qqminiapp", "mini_game_process_reuse", 1) > 0)
    {
      i = 1;
      if (i != 0) {
        break label24;
      }
    }
    label24:
    Object localObject;
    do
    {
      return false;
      i = 0;
      break;
      localObject = WnsConfig.getConfig("qqminiapp", "mini_game_process_reuse_blacklist", "");
      if (localObject == null) {
        break label76;
      }
      localObject = StringsKt.split$default((CharSequence)localObject, new char[] { '.' }, false, 0, 6, null);
    } while ((localObject != null) && (((List)localObject).contains(Build.MODEL) == true));
    label76:
    return true;
  }
  
  @JvmStatic
  @NotNull
  public final GameLaunchConfig fromWnsConfig()
  {
    int i = RangesKt.coerceAtLeast(WnsConfig.getConfig("qqminiapp", "mini_game_multi_instance", 1), 1);
    boolean bool = ((Companion)this).enableGameProcessReuse();
    if ((!bool) || (Build.VERSION.SDK_INT < 21)) {
      i = 1;
    }
    GameLaunchConfig localGameLaunchConfig = new GameLaunchConfig(bool, i);
    QMLog.i("GameLaunchStrategy", localGameLaunchConfig.toString());
    return localGameLaunchConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchConfig.Companion
 * JD-Core Version:    0.7.0.1
 */