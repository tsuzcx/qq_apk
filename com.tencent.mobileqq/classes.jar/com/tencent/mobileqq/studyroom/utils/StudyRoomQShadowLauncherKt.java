package com.tencent.mobileqq.studyroom.utils;

import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"valid", "", "Lcom/tencent/mobileqq/qroute/module/QRoutePluginInfo;", "qqstudyroom_impl_release"}, k=2, mv={1, 1, 16})
public final class StudyRoomQShadowLauncherKt
{
  private static final boolean b(@Nullable QRoutePluginInfo paramQRoutePluginInfo)
  {
    if (paramQRoutePluginInfo != null)
    {
      CharSequence localCharSequence = (CharSequence)paramQRoutePluginInfo.getURL();
      int i;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramQRoutePluginInfo.getMD5();
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i == 0) && (paramQRoutePluginInfo.getLength() > 0L)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncherKt
 * JD-Core Version:    0.7.0.1
 */