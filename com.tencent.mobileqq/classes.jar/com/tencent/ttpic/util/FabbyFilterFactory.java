package com.tencent.ttpic.util;

import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.model.StickerItem;

public class FabbyFilterFactory
{
  public static final String FRAGMENT_SHADER_VIDEO;
  public static final String LEFT_RIGHT_VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonLRVertexShader.dat");
  public static final String UP_DOWN_VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonUDVertexShader.dat");
  
  static
  {
    if (VideoModule.es_GL_EXT_shader_framebuffer_fetch) {}
    for (String str = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderVideoExt.dat");; str = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderVideo.dat"))
    {
      FRAGMENT_SHADER_VIDEO = str;
      return;
    }
  }
  
  public static StaticStickerFilter createFilter(StickerItem paramStickerItem, String paramString)
  {
    if (paramStickerItem == null) {
      paramString = null;
    }
    StaticStickerFilter localStaticStickerFilter;
    do
    {
      return paramString;
      localStaticStickerFilter = new StaticStickerFilter(paramStickerItem, paramString);
      if (paramStickerItem.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN)
      {
        localStaticStickerFilter.updateFilterShader(UP_DOWN_VERTEX_SHADER, FRAGMENT_SHADER_VIDEO);
        return localStaticStickerFilter;
      }
      paramString = localStaticStickerFilter;
    } while (paramStickerItem.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT);
    localStaticStickerFilter.updateFilterShader(LEFT_RIGHT_VERTEX_SHADER, FRAGMENT_SHADER_VIDEO);
    return localStaticStickerFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.FabbyFilterFactory
 * JD-Core Version:    0.7.0.1
 */