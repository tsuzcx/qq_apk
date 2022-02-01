package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/utils/VideoAudioControlUtil;", "", "()V", "SCENE_ADJUST_VOLUME", "", "SCENE_APP_BACKGROUND", "SCENE_BTN_CLICK", "SCENE_ENTER_DAILY_FEEDS", "SCENE_ENTER_KD_TAB", "SCENE_LEAVE_DAILY_FEEDS", "SCENE_LEAVE_KD_TAB", "TAG", "isMute", "", "isMuteConfig", "getMute", "getMuteConfig", "initConfig", "", "isVolumeLargeThanZero", "context", "Landroid/content/Context;", "setMute", "scene", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoAudioControlUtil
{
  public static final VideoAudioControlUtil a;
  private static boolean a;
  private static boolean b = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoUtilsVideoAudioControlUtil = new VideoAudioControlUtil();
    jdField_a_of_type_Boolean = true;
  }
  
  public final void a()
  {
    Object localObject = Aladdin.getConfig(402);
    int i;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("isMute", 1);
    } else {
      i = 1;
    }
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    b = bool;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initConfig] isMuteConfig = ");
    ((StringBuilder)localObject).append(b);
    QLog.i("VideoAudioControlUtil", 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setMute] scene = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isMute = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("VideoAudioControlUtil", 1, localStringBuilder.toString());
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getMuteConfig] isMuteConfig = ");
    localStringBuilder.append(b);
    QLog.i("VideoAudioControlUtil", 1, localStringBuilder.toString());
    return b;
  }
  
  public final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext != null)
    {
      int i = ((AudioManager)paramContext).getStreamVolume(3);
      paramContext = new StringBuilder();
      paramContext.append("[isVolumeNotZero], volume = ");
      paramContext.append(i);
      QLog.i("VideoAudioControlUtil", 1, paramContext.toString());
      return i > 0;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
  }
  
  public final boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil
 * JD-Core Version:    0.7.0.1
 */