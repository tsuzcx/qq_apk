package com.tencent.weseevideo.model.utils;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.common.utils.CollectionExtKt;
import com.tencent.weseevideo.editor.sticker.utils.StickerConverterKt;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.effect.VideoBeginModel;
import com.tencent.weseevideo.model.effect.VideoEffectModel;
import com.tencent.weseevideo.model.effect.VideoEndModel;
import com.tencent.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;

public class ModelAdaptUtils
{
  public static final String TAG = "ModelAdaptUtils";
  
  private static TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit;
    case 1: 
      return TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill;
    }
    return TAVVideoConfiguration.TAVVideoConfigurationContentMode.scaleToFit;
  }
  
  public static TAVSticker stickerModelToTAVSticker(@NonNull StickerModel paramStickerModel, @NonNull CGSize paramCGSize)
  {
    return StickerUtil.stickerModel2TavSticker(paramStickerModel);
  }
  
  public static TAVSticker subtitleModelToTAVSticker(@NonNull SubtitleModel paramSubtitleModel, @NonNull CGSize paramCGSize)
  {
    return StickerConverterKt.convert2TavSticker(paramSubtitleModel);
  }
  
  public static TAVMovieAudioConfiguration transformToTAVAudioConfiguration(@NonNull AudioConfigurationModel paramAudioConfigurationModel)
  {
    return new TAVMovieAudioConfiguration();
  }
  
  public static TAVResource transformToTAVResource(@NonNull VideoResourceModel paramVideoResourceModel)
  {
    Object localObject = null;
    if ((paramVideoResourceModel.getType() == 1) || (paramVideoResourceModel.getType() == 3)) {
      localObject = new TAVAssetTrackResource(new URLAsset(paramVideoResourceModel.getPath()));
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((TAVResource)localObject).setSourceTimeRange(new CMTimeRange(new CMTime(paramVideoResourceModel.getSourceTimeStart() + paramVideoResourceModel.getSelectTimeStart(), 1000), new CMTime(paramVideoResourceModel.getSelectTimeDuration(), 1000)));
        Log.d("lingeng_time", "transformToTAVResource:  \nvideoResourceModel.getSourceTimeStart()" + paramVideoResourceModel.getSourceTimeStart() + "\nvideoResourceModel.getSelectTimeStart()" + paramVideoResourceModel.getSelectTimeStart() + "\nvideoResourceModel.getSelectTimeDuration()" + paramVideoResourceModel.getSelectTimeDuration() + "\nvideoResourceModel.getScaleDuration()" + paramVideoResourceModel.getScaleDuration());
        ((TAVResource)localObject).setScaledDuration(new CMTime(paramVideoResourceModel.getScaleDuration(), 1000));
      }
      return localObject;
      if (paramVideoResourceModel.getType() == 2)
      {
        localObject = new TAVImageTrackResource(paramVideoResourceModel.getPath(), new CMTime((float)paramVideoResourceModel.getSourceTimeDuration() / 1000.0F));
      }
      else if (paramVideoResourceModel.getType() == 4)
      {
        localObject = new CGSize(paramVideoResourceModel.getWidth(), paramVideoResourceModel.getHeight());
        localObject = new TAVImageResource(new CIImage(paramVideoResourceModel.getPath(), (CGSize)localObject), new CMTime((float)paramVideoResourceModel.getSourceTimeDuration() / 1000.0F));
      }
    }
  }
  
  public static TAVMovieVideoConfiguration transformToTAVVideoConfiguration(@NonNull VideoConfigurationModel paramVideoConfigurationModel)
  {
    TAVMovieVideoConfiguration localTAVMovieVideoConfiguration = new TAVMovieVideoConfiguration();
    localTAVMovieVideoConfiguration.setContentMode(getContentMode(paramVideoConfigurationModel.getContentMode()));
    Object localObject = paramVideoConfigurationModel.createFrameRect();
    if (localObject != null) {
      localTAVMovieVideoConfiguration.setFrame((CGRect)localObject);
    }
    localObject = new Matrix();
    ((Matrix)localObject).setValues(CollectionExtKt.a(paramVideoConfigurationModel.getMatrix()));
    localTAVMovieVideoConfiguration.setTransform((Matrix)localObject);
    localTAVMovieVideoConfiguration.setPreferRotation(paramVideoConfigurationModel.getRotate());
    return localTAVMovieVideoConfiguration;
  }
  
  public static TAVSticker videoBeginModelToTAVSticker(@NonNull VideoBeginModel paramVideoBeginModel)
  {
    TAVSticker localTAVSticker = new TAVSticker();
    localTAVSticker.setFilePath(paramVideoBeginModel.getFilePath());
    try
    {
      paramVideoBeginModel = localTAVSticker.init();
      return paramVideoBeginModel;
    }
    catch (StickerInitializationException paramVideoBeginModel)
    {
      paramVideoBeginModel.printStackTrace();
    }
    return localTAVSticker;
  }
  
  public static TAVSticker videoEffectModelToTAVSticker(@NonNull VideoEffectModel paramVideoEffectModel)
  {
    TAVMovieSticker localTAVMovieSticker = new TAVMovieSticker(paramVideoEffectModel.getFilePath());
    localTAVMovieSticker.setTimeRange(new CMTimeRange(new CMTime(paramVideoEffectModel.getStartTime() / 1000.0F), new CMTime(paramVideoEffectModel.getDuration() / 1000.0F)));
    localTAVMovieSticker.getSticker().setStickerId(paramVideoEffectModel.getEffectId());
    return localTAVMovieSticker.getSticker();
  }
  
  public static TAVSticker videoEndModelToTAVSticker(@NonNull VideoEndModel paramVideoEndModel)
  {
    Object localObject = paramVideoEndModel.getPag();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (FileUtils.exists((String)localObject)))
    {
      localObject = new TAVMovieSticker((String)localObject);
      CMTime localCMTime = new CMTime((float)((TAVMovieSticker)localObject).getSticker().durationTime() / 1000000.0F);
      ((TAVMovieSticker)localObject).setTimeRange(new CMTimeRange(new CMTime(paramVideoEndModel.getCompositionDuration() / 1000.0F).sub(localCMTime), localCMTime));
      return ((TAVMovieSticker)localObject).getSticker();
    }
    return null;
  }
  
  public static TAVSticker videoFenWeiModelToTAVSticker(@NonNull VideoFenWeiModel paramVideoFenWeiModel)
  {
    TAVSticker localTAVSticker = new TAVSticker();
    localTAVSticker.setFilePath(paramVideoFenWeiModel.getFilePath());
    try
    {
      localTAVSticker.init();
      return localTAVSticker;
    }
    catch (StickerInitializationException paramVideoFenWeiModel)
    {
      paramVideoFenWeiModel.printStackTrace();
    }
    return localTAVSticker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.ModelAdaptUtils
 * JD-Core Version:    0.7.0.1
 */