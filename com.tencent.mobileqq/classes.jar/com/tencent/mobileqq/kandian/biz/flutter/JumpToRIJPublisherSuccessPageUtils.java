package com.tencent.mobileqq.kandian.biz.flutter;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/flutter/JumpToRIJPublisherSuccessPageUtils;", "", "()V", "bidId", "", "getBidId", "()Ljava/lang/String;", "setBidId", "(Ljava/lang/String;)V", "communityId", "getCommunityId", "setCommunityId", "content", "getContent", "setContent", "contentType", "getContentType", "setContentType", "coverHeight", "", "getCoverHeight", "()I", "setCoverHeight", "(I)V", "coverLocalUrl", "getCoverLocalUrl", "setCoverLocalUrl", "coverNetWorkUrl", "getCoverNetWorkUrl", "setCoverNetWorkUrl", "coverWidth", "getCoverWidth", "setCoverWidth", "defaultUrl", "getDefaultUrl", "setDefaultUrl", "flutterType", "getFlutterType", "setFlutterType", "introText", "getIntroText", "setIntroText", "introTitle", "getIntroTitle", "setIntroTitle", "isDart2Js", "", "()Z", "setDart2Js", "(Z)V", "jsWidgetName", "getJsWidgetName", "setJsWidgetName", "leftBtnTxt", "getLeftBtnTxt", "setLeftBtnTxt", "leftBtnUrl", "getLeftBtnUrl", "setLeftBtnUrl", "needCopyParams", "getNeedCopyParams", "setNeedCopyParams", "rightBtnTxt", "getRightBtnTxt", "setRightBtnTxt", "rightBtnUrl", "getRightBtnUrl", "setRightBtnUrl", "fillMxFlutterParams", "", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "jumpToRIJPublisherSuccessPage", "context", "Landroid/content/Context;", "putCommonParams", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class JumpToRIJPublisherSuccessPageUtils
{
  public static final JumpToRIJPublisherSuccessPageUtils.Companion a = new JumpToRIJPublisherSuccessPageUtils.Companion(null);
  private int b;
  @NotNull
  private String c = "";
  @NotNull
  private String d = "";
  @NotNull
  private String e = "";
  @NotNull
  private String f = "";
  @NotNull
  private String g = "";
  @NotNull
  private String h = "";
  @NotNull
  private String i = "";
  @NotNull
  private String j = "";
  private int k = 100;
  private int l = 80;
  @NotNull
  private String m = "";
  @NotNull
  private String n = "";
  @NotNull
  private String o = "1";
  @NotNull
  private String p = "";
  private boolean q;
  @NotNull
  private String r = "";
  @NotNull
  private String s = "";
  private boolean t;
  
  private final void a(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("page", "RIJPublisherSuccessPage");
    paramHashMap.put("intro_video_cover_local_url", this.j);
    paramHashMap.put("intro_video_cover_network_url", this.i);
    paramHashMap.put("cover_width", String.valueOf(this.k));
    paramHashMap.put("cover_height", String.valueOf(this.l));
    paramHashMap.put("title", this.m);
    paramHashMap.put("intro_title", this.c);
    paramHashMap.put("intro_text", this.d);
    paramHashMap.put("segue_button_left_title", this.e);
    paramHashMap.put("segue_button_left_url", this.f);
    paramHashMap.put("segue_button_right_title", this.g);
    paramHashMap.put("content_type", this.o);
  }
  
  private final void a(HashMap<String, Object> paramHashMap, String paramString)
  {
    paramHashMap = (Map)paramHashMap;
    paramHashMap.put("page", "RIJMXFlutterPage");
    paramHashMap.put("bidID", this.r);
    paramHashMap.put("isDart2JS", Boolean.valueOf(this.t));
    paramHashMap.put("jsWidgetName", this.s);
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    boolean bool;
    if (this.b == 1) {
      bool = true;
    } else {
      bool = false;
    }
    HashMap localHashMap = new HashMap();
    if (bool)
    {
      localObject1 = (Map)localHashMap;
      ((Map)localObject1).put("page", "RIJPublisherSuccessPage");
      localObject2 = new HashMap();
      ((Map)localObject2).put("segue_button_right_url", this.h);
      a((HashMap)localObject2);
      ((Map)localObject1).put("flutterPushParams", localObject2);
      if (this.q)
      {
        int i1;
        if (((CharSequence)this.p).length() > 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          localObject1 = Uri.parse(this.p).buildUpon().appendQueryParameter("intro_title", this.c).appendQueryParameter("intro_text", this.d).appendQueryParameter("segue_button_left_title", this.e).appendQueryParameter("segue_button_left_url", this.f).appendQueryParameter("segue_button_right_title", this.g).appendQueryParameter("segue_button_right_url", this.h).toString();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "uri.buildUpon()\n        …              .toString()");
          this.p = ((String)localObject1);
        }
      }
      a(localHashMap, this.p);
    }
    else
    {
      a(localHashMap);
      localObject1 = Uri.parse(URLDecoder.decode(this.h, "utf-8")).buildUpon();
      ((Uri.Builder)localObject1).appendQueryParameter("id", this.n);
      localHashMap.put("segue_button_right_url", ((Uri.Builder)localObject1).toString());
    }
    Object localObject1 = RIJFlutterUtils.a;
    Object localObject2 = new FlutterPageSetting();
    ((FlutterPageSetting)localObject2).a(true);
    ((FlutterPageSetting)localObject2).b(false);
    ((FlutterPageSetting)localObject2).c(false);
    ((RIJFlutterUtils)localObject1).a(paramContext, localHashMap, bool, (FlutterPageSetting)localObject2);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public final void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public final void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f = paramString;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.g = paramString;
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.h = paramString;
  }
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.i = paramString;
  }
  
  public final void h(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.j = paramString;
  }
  
  public final void i(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.m = paramString;
  }
  
  public final void j(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.n = paramString;
  }
  
  public final void k(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.o = paramString;
  }
  
  public final void l(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.p = paramString;
  }
  
  public final void m(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.r = paramString;
  }
  
  public final void n(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.s = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.JumpToRIJPublisherSuccessPageUtils
 * JD-Core Version:    0.7.0.1
 */