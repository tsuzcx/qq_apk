package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.debug.VoiceRoomDebugFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/intervideo/audioroom/pluginimpl/AudioRoomJumpActionDispatcher;", "", "()V", "TAG", "", "dispatch", "", "scheme", "getParams", "", "isNetworkUrl", "", "openStrangerAIO", "openVoiceDebug", "startBrowserActivity", "startJumpAction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomJumpActionDispatcher
{
  public static final AudioRoomJumpActionDispatcher INSTANCE = new AudioRoomJumpActionDispatcher();
  
  private final Map<String, String> a(String paramString)
  {
    Map localMap = (Map)new LinkedHashMap();
    int i = StringsKt.indexOf$default((CharSequence)paramString, "?", 0, false, 6, null);
    if (i >= 0)
    {
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(i + 1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = ((Iterable)StringsKt.split$default((CharSequence)paramString, new String[] { "&" }, false, 0, 6, null)).iterator();
      while (paramString.hasNext())
      {
        List localList = StringsKt.split$default((CharSequence)paramString.next(), new String[] { "=" }, false, 0, 6, null);
        if (localList.size() == 2) {
          localMap.put(localList.get(0), localList.get(1));
        }
      }
    }
    return localMap;
  }
  
  private final void a()
  {
    Intent localIntent = new Intent();
    localIntent.setClass((Context)MobileQQ.context, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", VoiceRoomDebugFragment.class.getName());
    localIntent.addFlags(268435456);
    MobileQQ.context.startActivity(localIntent);
  }
  
  private final void a(String paramString)
  {
    String str = (String)a(paramString).get("uin");
    if (str == null)
    {
      QLog.w("AudioRoomJumpActionDispatcher", 2, "openStrangerAIO fail: " + paramString);
      return;
    }
    paramString = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getApplication()");
    paramString = paramString.getBaseContext();
    Intent localIntent = new Intent(paramString, ChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 10010);
    paramString.startActivity(localIntent);
  }
  
  private final boolean a(String paramString)
  {
    return StringsKt.startsWith$default(paramString, "https", false, 2, null);
  }
  
  private final void b(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = new Intent(((BaseApplicationImpl)localObject).getBaseContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).addFlags(268435456);
    paramString = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "BaseApplicationImpl.getApplication()");
    paramString.getBaseContext().startActivity((Intent)localObject);
  }
  
  private final void c(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.setFlags(268435456);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    localBaseApplicationImpl.getBaseContext().startActivity(paramString);
  }
  
  @JvmStatic
  public static final void dispatch(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scheme");
    if (StringsKt.startsWith$default(paramString, "openStrangerAIO", false, 2, null))
    {
      INSTANCE.a(paramString);
      return;
    }
    if (StringsKt.startsWith$default(paramString, "openVoiceDebug", false, 2, null))
    {
      INSTANCE.a();
      return;
    }
    if (INSTANCE.a(paramString))
    {
      INSTANCE.b(paramString);
      return;
    }
    INSTANCE.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.pluginimpl.AudioRoomJumpActionDispatcher
 * JD-Core Version:    0.7.0.1
 */