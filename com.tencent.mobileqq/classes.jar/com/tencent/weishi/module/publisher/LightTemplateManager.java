package com.tencent.weishi.module.publisher;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weishi/module/publisher/LightTemplateManager;", "", "()V", "COVER_OFFSET", "", "FONT_PROGRESS", "", "LIGHTSDK_BASE_FILE_PROGRESS", "MUSIC_PROGRESS", "PERCENT_10", "", "PERCENT_30", "RED_PACKET_KEY", "TAG", "TEMPLATE_JSON", "TEMPLATE_PROGRESS", "downloadFontComplete", "", "downloadMusicComplete", "fetchMusicInfoComplete", "progressCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LightTemplateManager
{
  private static final long COVER_OFFSET = 700L;
  private static final String FONT_PROGRESS = "font_progress";
  public static final LightTemplateManager INSTANCE = new LightTemplateManager();
  private static final String LIGHTSDK_BASE_FILE_PROGRESS = "lightsdk_progress";
  private static final String MUSIC_PROGRESS = "music_progress";
  private static final float PERCENT_10 = 0.1F;
  private static final float PERCENT_30 = 0.3F;
  @NotNull
  public static final String RED_PACKET_KEY = "hongbao";
  private static final String TAG = "LightTemplateManager";
  private static final String TEMPLATE_JSON = "template.json";
  private static final String TEMPLATE_PROGRESS = "template__progress";
  private static boolean downloadFontComplete;
  private static boolean downloadMusicComplete;
  private static boolean fetchMusicInfoComplete;
  private static HashMap<String, Float> progressCache = new HashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.LightTemplateManager
 * JD-Core Version:    0.7.0.1
 */