package com.tencent.mobileqq.notification.modularize.business;

import android.app.PendingIntent;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.PushComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/AudioRoomScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "modifyAudioRoomScheme", "", "scheme", "needCustomJump", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomScheme
  extends BaseJumpScheme
{
  public static final AudioRoomScheme.Companion a = new AudioRoomScheme.Companion(null);
  
  private final String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("before modify scheme: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AudioRoomScheme", 2, ((StringBuilder)localObject).toString());
    localObject = StringsKt.replace$default(paramString, "mqqapi://now/audioroom", "mqqapi://now/openroom", false, 4, null);
    paramString = (String)localObject;
    if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"src_type", false, 2, null))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&src_type=app");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"version", false, 2, null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&version=1");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"fromid", false, 2, null))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&fromid=10026");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"roomtype", false, 2, null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&roomtype=10001");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new StringBuilder();
    paramString.append("after modify: ");
    paramString.append((String)localObject);
    QLog.d("AudioRoomScheme", 2, paramString.toString());
    return localObject;
  }
  
  @NotNull
  protected PendingIntent a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    if (StringsKt.startsWith$default(paramPushComponent.d, "mqqapi://now/audioroom", false, 2, null)) {
      paramPushComponent.d = a(paramPushComponent.d);
    }
    return d(paramPushComponent);
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.business.AudioRoomScheme
 * JD-Core Version:    0.7.0.1
 */