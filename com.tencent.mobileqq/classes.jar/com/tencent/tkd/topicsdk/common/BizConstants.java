package com.tencent.tkd.topicsdk.common;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/BizConstants;", "", "()V", "BUNDLE_KEY_ALLOW_CREATE_TWEET_TOPIC", "", "BUNDLE_KEY_COMMODITY_CONFIG", "BUNDLE_KEY_DISPLAY_INFO", "BUNDLE_KEY_DRAFT_INFO", "BUNDLE_KEY_GLOBAL_PUBLISHER_CONFIG", "BUNDLE_KEY_TOPIC_INFO", "BUNDLE_KEY_VIDEO_URL", "DEFAULT_PUBLISH_PLACEHOLDER", "DEFAULT_TEXT_COUNT_LIMIT", "", "NO_ERROR", "REQUEST_CODE_COVER_SELECT_PAGE", "REQUEST_CODE_CREATE_TOPIC", "REQUEST_CODE_LOCATION", "REQUEST_CODE_PREVIEW_PHOTO_PAGE", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_STORAGE", "REQUEST_CODE_VIDEO_CROP_PAGE", "RESULT_CODE_SELECT_PHOTO", "RESULT_CODE_TOPIC_INFO", "SCENE_FIREWORKS", "SCENE_KOL", "SCENE_MAIN_TIMELINE", "SCENE_RIJ_UGC", "SCENE_USER_DETAILS", "SCENE_VIDEO_PUBLISHER", "SCENE_WEIBO", "SP_COMMENT_AFTER_PUBLISH_CONFIG", "SP_HAS_SHOW_MAX_LIMIT", "SP_HAS_SHOW_MIN_LIMIT", "SP_KEYBOARD_HEIGHT", "SP_TOPIC_INFO_SKETCH", "THEME_DEFAULT", "THEME_FIREWORKS", "isFireworksBusiness", "", "scene", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BizConstants
{
  public static final BizConstants a = new BizConstants();
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    return CollectionsKt.arrayListOf(new String[] { "fireworks", "main_timeline", "video_publisher", "userdetails" }).contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.BizConstants
 * JD-Core Version:    0.7.0.1
 */