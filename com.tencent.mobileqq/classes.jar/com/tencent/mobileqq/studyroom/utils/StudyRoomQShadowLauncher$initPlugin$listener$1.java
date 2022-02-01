package com.tencent.mobileqq.studyroom.utils;

import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginUpdater.OnPluginInfoUpdateListener;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$initPlugin$listener$1", "Lcooperation/plugin/PluginUpdater$OnPluginInfoUpdateListener;", "onRemovingPluginInfo", "", "info", "Lcooperation/plugin/PluginInfo;", "onUpdateFinish", "", "updateResult", "qqstudyroom_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyRoomQShadowLauncher$initPlugin$listener$1
  implements PluginUpdater.OnPluginInfoUpdateListener
{
  StudyRoomQShadowLauncher$initPlugin$listener$1(CountDownLatch paramCountDownLatch) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.countDown();
  }
  
  public boolean a(@Nullable PluginInfo paramPluginInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.initPlugin.listener.1
 * JD-Core Version:    0.7.0.1
 */