package com.tencent.mobileqq.qqexpand.flutter.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;
import com.tencent.mobileqq.profile.PersonalityLabel.Constants;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.fragment.ExpandBirthPickFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExtendFriendVoiceMatchLoadingFragment;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/router/ExpandRouter;", "Lcom/tencent/mobileqq/qqexpand/flutter/router/BaseRouter;", "()V", "enterNativeVoiceMatchFromFlutter", "", "map", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getRouterName", "jumpToAnonymous", "jumpToFeaturePhoto", "jumpToPage", "pageName", "pageUri", "Landroid/net/Uri;", "jumpToPersonalLabel", "jumpToStickyNote", "openRouterPath", "urlParams", "", "exts", "showBirthDayDialog", "date", "", "(Ljava/lang/Integer;)V", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandRouter
  extends BaseRouter
{
  public static final ExpandRouter.Companion a = new ExpandRouter.Companion(null);
  
  private final void a(Integer paramInteger)
  {
    Intent localIntent = new Intent();
    int i;
    if (paramInteger != null) {
      i = paramInteger.intValue();
    } else {
      i = 0;
    }
    localIntent.putExtra("birth_date", i);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(268435456);
    QPublicTransFragmentActivity.a((Context)BaseApplicationImpl.context, localIntent, ExpandBirthPickFragment.class);
  }
  
  private final void a(String paramString, Uri paramUri)
  {
    label112:
    Object localObject;
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 1221699540: 
        if (paramString.equals("personal_label_edit"))
        {
          paramString = BaseApplicationImpl.getApplication();
          if (paramString != null)
          {
            paramString = paramString.getRuntime();
            if (paramString != null)
            {
              paramString = paramString.getAccount();
              if (paramString != null) {
                break label112;
              }
            }
          }
          paramString = "";
          if (!TextUtils.isEmpty((CharSequence)paramString))
          {
            paramUri = BaseApplicationImpl.context;
            if (paramUri == null) {
              return;
            }
            localObject = new Intent((Context)paramUri, PersonalityLabelGalleryActivity.class);
            ((Intent)localObject).putExtra("uin", paramString);
            ((Intent)localObject).setFlags(268435456);
            ((Intent)localObject).putExtra("fling_action_key", 2);
            ((Intent)localObject).putExtra("fling_code_key", hashCode());
            paramUri.startActivity((Intent)localObject);
            return;
          }
          paramString = LogUtils.a;
          paramUri = (Throwable)null;
          paramString.a().a("ExpandRouter", 1, "jump personal_label_edit error account is null", paramUri);
          return;
        }
        break;
      case 830494773: 
        if (paramString.equals("personal_label"))
        {
          e();
          return;
        }
        break;
      case 188064685: 
        if (paramString.equals("msg_list_setting"))
        {
          paramString = new Intent();
          paramString.setFlags(268435456);
          paramUri = BaseApplicationImpl.context;
          if (paramUri == null) {
            return;
          }
          PublicFragmentActivity.a((Context)paramUri, paramString, MatchChatSettingFragment.class);
          return;
        }
        break;
      case -1173124183: 
        if (paramString.equals("feature_photo"))
        {
          d();
          return;
        }
        break;
      case -1177041573: 
        if (paramString.equals("stickynote"))
        {
          c();
          return;
        }
        break;
      case -2095811475: 
        if (paramString.equals("anonymous"))
        {
          b();
          return;
        }
        break;
      }
    }
    paramUri = LogUtils.a;
    if (QLog.isColorLevel())
    {
      paramUri = paramUri.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump to ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" not notImplemented");
      paramUri.a("ExpandRouter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private final void a(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap != null) {
      paramHashMap = paramHashMap.get("gender");
    } else {
      paramHashMap = null;
    }
    paramHashMap = (String)paramHashMap;
    if (paramHashMap == null) {
      paramHashMap = "0";
    }
    try
    {
      i = Integer.parseInt(paramHashMap);
    }
    catch (NumberFormatException paramHashMap)
    {
      int i;
      label39:
      break label39;
    }
    i = 0;
    paramHashMap = new Intent();
    paramHashMap.putExtra("intent_sex_key", i);
    PublicFragmentActivity.Launcher.a(paramHashMap, PublicFragmentActivity.class, ExtendFriendVoiceMatchLoadingFragment.class);
  }
  
  private final void b()
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null)
    {
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null)
      {
        localObject1 = ((AppRuntime)localObject1).getAccount();
        if (localObject1 != null) {
          break label32;
        }
      }
    }
    localObject1 = "";
    label32:
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = BaseApplicationImpl.context;
      if (localObject2 != null)
      {
        Intent localIntent = new Intent((Context)localObject2, QQBrowserActivity.class);
        Object localObject3 = StringCompanionObject.INSTANCE;
        localObject3 = new Object[2];
        localObject3[0] = localObject1;
        localObject3[1] = Integer.valueOf(1);
        localObject1 = String.format("https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d", Arrays.copyOf((Object[])localObject3, localObject3.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        localIntent.putExtra("url", (String)localObject1);
        localIntent.setFlags(268435456);
        ((BaseApplication)localObject2).startActivity(localIntent);
      }
    }
    else
    {
      localObject1 = LogUtils.a;
      localObject2 = (Throwable)null;
      ((LogUtils)localObject1).a().a("ExpandRouter", 1, "jump photo stickynote account is null", (Throwable)localObject2);
    }
  }
  
  private final void c()
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null)
    {
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null)
      {
        l = ((AppRuntime)localObject1).getLongAccountUin();
        break label27;
      }
    }
    long l = 0L;
    label27:
    Object localObject2;
    if (l != 0L)
    {
      localObject1 = BaseApplicationImpl.context;
      if (localObject1 != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("key_host_uin", l);
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.putExtras((Bundle)localObject2);
        PublicFragmentActivity.Launcher.a((Context)localObject1, localIntent, PublicFragmentActivity.class, StickyNotePublishFragment.class);
      }
    }
    else
    {
      localObject1 = LogUtils.a;
      localObject2 = (Throwable)null;
      ((LogUtils)localObject1).a().a("ExpandRouter", 1, "jump photo stickynote account is null", (Throwable)localObject2);
    }
  }
  
  private final void d()
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null)
    {
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null)
      {
        localObject1 = ((AppRuntime)localObject1).getAccount();
        if (localObject1 != null) {
          break label32;
        }
      }
    }
    localObject1 = "";
    label32:
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = BaseApplicationImpl.context;
      if (localObject2 != null)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("https://ti.qq.com/photowall/index.html?_wv=1027");
        ((StringBuilder)localObject3).append("&uin=");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        ((Intent)localObject3).putExtra("hide_operation_bar", true);
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).setFlags(268435456);
        ((BaseApplication)localObject2).startActivity((Intent)localObject3);
      }
    }
    else
    {
      localObject1 = LogUtils.a;
      localObject2 = (Throwable)null;
      ((LogUtils)localObject1).a().a("ExpandRouter", 1, "jump photo error account is null", (Throwable)localObject2);
    }
  }
  
  private final void e()
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null)
    {
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null)
      {
        localObject1 = ((AppRuntime)localObject1).getAccount();
        if (localObject1 != null) {
          break label32;
        }
      }
    }
    localObject1 = "";
    label32:
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = BaseApplicationImpl.context;
      if (localObject2 != null)
      {
        Intent localIntent = new Intent((Context)localObject2, QQBrowserActivity.class);
        localIntent.putExtra("url", Constants.c);
        localIntent.putExtra("uin", (String)localObject1);
        localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify_personality_label");
        localIntent.putExtra("fromProfile", false);
        localIntent.setFlags(268435456);
        ((BaseApplication)localObject2).startActivity(localIntent);
      }
    }
    else
    {
      localObject1 = LogUtils.a;
      localObject2 = (Throwable)null;
      ((LogUtils)localObject1).a().a("ExpandRouter", 1, "jump personal_label error account is null", (Throwable)localObject2);
    }
  }
  
  @NotNull
  public String a()
  {
    return "expand";
  }
  
  public void a(@NotNull Uri paramUri, @Nullable Map<Object, ? extends Object> paramMap1, @Nullable Map<Object, ? extends Object> paramMap2)
  {
    Intrinsics.checkParameterIsNotNull(paramUri, "pageUri");
    String str = paramUri.getPath();
    if (str != null)
    {
      int i = str.hashCode();
      Object localObject2 = null;
      Object localObject1 = null;
      switch (i)
      {
      default: 
        break;
      case 1259844215: 
        if (str.equals("/birth_dialog"))
        {
          paramMap1 = paramUri.getQueryParameter("date");
          paramUri = localObject1;
          if (paramMap1 != null) {
            paramUri = Integer.valueOf(Integer.parseInt(paramMap1));
          }
          a(paramUri);
          return;
        }
        break;
      case 46749288: 
        if (str.equals("/main"))
        {
          paramMap2 = (Context)BaseApplicationImpl.context;
          paramUri = localObject2;
          if (paramMap1 != null) {
            paramUri = paramMap1.get("type");
          }
          ExpandPublicFragmentActivity.launchExtendFriendNewFragment(paramMap2, 4, false, (String)paramUri);
          return;
        }
        break;
      case 46679261: 
        if (str.equals("/jump"))
        {
          a(paramUri.getQueryParameter("page"), paramUri);
          return;
        }
        break;
      case 1496760: 
        if (str.equals("/aio"))
        {
          if (paramMap1 != null)
          {
            LimitChatUtil.a(paramUri, (Map)paramMap1);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any?> /* = java.util.HashMap<kotlin.String, kotlin.Any?> */");
        }
        break;
      case -89405150: 
        if (str.equals("/voiceMatch"))
        {
          a((HashMap)paramMap2);
          return;
        }
        break;
      case -164884942: 
        if (str.equals("/conversation"))
        {
          MatchChatMsgListFragment.a((Context)BaseApplicationImpl.context, 2);
          return;
        }
        break;
      case -675666397: 
        if (str.equals("/edit_profile"))
        {
          paramUri = BaseApplicationImpl.context;
          if (paramUri == null) {
            return;
          }
          paramMap1 = new Intent();
          paramMap1.setFlags(268435456);
          paramMap1.putExtra("fling_action_key", 2);
          paramMap1.putExtra("fling_code_key", hashCode());
          QPublicFragmentActivity.Launcher.a((Context)paramUri, paramMap1, QPublicFragmentActivity.class, ExtendFriendNewEditFragment.class);
          return;
        }
        break;
      }
    }
    paramMap1 = LogUtils.a;
    if (QLog.isColorLevel())
    {
      paramMap1 = paramMap1.a();
      paramMap2 = new StringBuilder();
      paramMap2.append("native router ");
      paramMap2.append(paramUri);
      paramMap2.append(" not support");
      paramMap1.a("ExpandRouter", 2, paramMap2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.router.ExpandRouter
 * JD-Core Version:    0.7.0.1
 */