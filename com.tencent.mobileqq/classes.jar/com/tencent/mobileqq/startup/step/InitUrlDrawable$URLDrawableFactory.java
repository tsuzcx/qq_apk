package com.tencent.mobileqq.startup.step;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.activity.aio.photo.PhotoDecoder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi;
import com.tencent.mobileqq.apollo.res.api.IApolloDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloGifDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloImageDownloader;
import com.tencent.mobileqq.colornote.list.WebCoverDownloader;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.emoticon.api.IPicEmotionDownloaderService;
import com.tencent.mobileqq.emoticon.api.IVasExtensionDownloaderService;
import com.tencent.mobileqq.emoticonview.FavoriteDownloader;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicOriginDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.skin.SkinGifImageDownloader;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.redtouch.RedTouchPicDownloader;
import com.tencent.mobileqq.transfile.AIOFlowerImgDownloader;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.AlbumPreviewThumbDownloader;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.AvatarPendantDownloader;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.DataLineFaceDownloader;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.EmotionDownloader;
import com.tencent.mobileqq.transfile.FavoriteImageDownloader;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.mobileqq.transfile.LocalBilldDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.PicFileGalleryOrigDecoder;
import com.tencent.mobileqq.transfile.ProfileImgDownloader;
import com.tencent.mobileqq.transfile.QQSysAndEmojiDownloader;
import com.tencent.mobileqq.transfile.QZoneCoverDownloader;
import com.tencent.mobileqq.transfile.QZoneRecentPhotoDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.ShortVideoForPicThumbDownloader;
import com.tencent.mobileqq.transfile.ShortVideoThumbDownloader;
import com.tencent.mobileqq.transfile.SignatureTemplateDownloader;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;
import com.tencent.mobileqq.transfile.ThirdPartAppIconDownloader;
import com.tencent.mobileqq.transfile.VasApngDownloader;
import com.tencent.mobileqq.transfile.VideoCoverDownloader;
import com.tencent.mobileqq.transfile.VideoThumbDownloader;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.contentbox.IQzoneContentBoxDownloader;

class InitUrlDrawable$URLDrawableFactory
  extends URLDrawableParams
{
  private ProtocolDownloader a;
  private ProtocolDownloader b;
  private ProtocolDownloader c;
  private ProtocolDownloader d;
  private ProtocolDownloader e;
  private ProtocolDownloader f;
  private ProtocolDownloader g;
  private ProtocolDownloader h;
  
  public InitUrlDrawable$URLDrawableFactory(Application paramApplication)
  {
    super(paramApplication);
    this.mFadeInImage = false;
    this.mUseGifAnimation = false;
  }
  
  protected ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ((!"http".equals(paramString)) && (!"https".equals(paramString)))
    {
      if ((!"nearbyimage".equals(paramString)) && (!"nearbylocalimage".equals(paramString)))
      {
        if ((!"chatthumb".equals(paramString)) && (!"chatimg".equals(paramString)) && (!"chatraw".equals(paramString)))
        {
          if ("datalineimage".equals(paramString)) {
            return new DataLineDownloader(BaseApplicationImpl.getApplication());
          }
          if ("datalineface".equals(paramString)) {
            return new DataLineFaceDownloader(BaseApplicationImpl.getApplication());
          }
          if ("emotion".equals(paramString)) {
            return new EmotionDownloader(BaseApplicationImpl.getApplication());
          }
          if ("emotion_pic".equals(paramString)) {
            return ((IPicEmotionDownloaderService)QRoute.api(IPicEmotionDownloaderService.class)).createPicEmotionDownloader(BaseApplicationImpl.getApplication());
          }
          if ("favorite".equals(paramString)) {
            return new FavoriteDownloader();
          }
          if ("albumthumb".equals(paramString)) {
            return new AlbumThumbDownloader();
          }
          if ("videothumb".equals(paramString)) {
            return new VideoThumbDownloader();
          }
          if ("videocover".equals(paramString)) {
            return new VideoCoverDownloader();
          }
          if ("pubaccountimage".equals(paramString)) {
            return (ProtocolDownloader)((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).getHttpDownloader();
          }
          if ((!"billdthumb".equals(paramString)) && (!"billdimg".equals(paramString)))
          {
            if ((!"profile_img_big".equals(paramString)) && (!"profile_img_thumb".equals(paramString)) && (!"profile_img_icon".equals(paramString)) && (!"profile_img_big_fhd".equals(paramString)))
            {
              if ("qzone_cover".equals(paramString)) {
                return new QZoneCoverDownloader();
              }
              if ("favimage".equals(paramString)) {
                return new FavoriteImageDownloader(BaseApplicationImpl.getApplication());
              }
              if ("fileassistantimage".equals(paramString)) {
                return new FileAssistantDownloader(BaseApplicationImpl.getApplication());
              }
              if ("filegalleryorigimage".equals(paramString)) {
                return new PicFileGalleryOrigDecoder(BaseApplicationImpl.getApplication());
              }
              if ("troop_photo_qzone".equals(paramString)) {
                return new QZoneRecentPhotoDownloader();
              }
              if ("aiothumb".equals(paramString)) {
                return ((IPicFactory)QRoute.api(IPicFactory.class)).getChatImageDownloader(BaseApplication.getContext(), paramString);
              }
              if ("protocol_pendant_image".equals(paramString)) {
                return new AvatarPendantDownloader();
              }
              if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
                return new PhotoDecoder(BaseApplicationImpl.getApplication());
              }
              if ("regionalthumb".equals(paramString)) {
                return new RegionalThumbDownloader(BaseApplicationImpl.getApplication());
              }
              if ("third_part".equals(paramString)) {
                return new ThirdPartAppIconDownloader(BaseApplicationImpl.getApplication());
              }
              if ("gamead".equals(paramString)) {
                return new LastModifySupportDownloader();
              }
              if ("shortvideothumb".equals(paramString)) {
                return new ShortVideoThumbDownloader();
              }
              if ("shortvideoforpicthumb".equals(paramString)) {
                return new ShortVideoForPicThumbDownloader();
              }
              if ("devicemsgthumb".equals(paramString)) {
                return new DeviceMsgThumbDownloader();
              }
              if ("carrier".equals(paramString)) {
                return new CarrierImgDownloader();
              }
              if ("aioflower".equals(paramString)) {
                return new AIOFlowerImgDownloader();
              }
              if ((!"sig_cover".equals(paramString)) && (!"sig_zip".equals(paramString)))
              {
                if ("themediydownloader".equals(paramString)) {
                  return new ThemeDIYDownloader();
                }
                if ("vasapngdownloader".equals(paramString)) {
                  return new VasApngDownloader();
                }
                if ("funny_pic".equals(paramString)) {
                  return ((IFunnyPicHelperService)QRoute.api(IFunnyPicHelperService.class)).createFunnyPicDownloader();
                }
                if ("redtouchpicdownloadprotoc".equals(paramString)) {
                  return new RedTouchPicDownloader(BaseApplicationImpl.getApplication());
                }
                if ("protocol_vas_extension_image".equals(paramString)) {
                  return ((IVasExtensionDownloaderService)QRoute.api(IVasExtensionDownloaderService.class)).createVasExtensionDownloader();
                }
                if ("apollo_pic".equals(paramString)) {
                  return (AbsDownloader)QRoute.api(IApolloDownloader.class);
                }
                if ("apollo_gif".equals(paramString)) {
                  return (AbsDownloader)QRoute.api(IApolloGifDownloader.class);
                }
                if ("apollo_image".equals(paramString)) {
                  return (AbsDownloader)QRoute.api(IApolloImageDownloader.class);
                }
                if ("hot_pic".equals(paramString))
                {
                  if (this.e == null) {
                    this.e = new HotPicDownLoader();
                  }
                  return this.e;
                }
                if ("hot_pic_origin".equals(paramString)) {
                  return new HotPicOriginDownLoader();
                }
                if ("hot_video_preview".equals(paramString))
                {
                  if (this.f == null) {
                    this.f = new HotVideoPreviewDownloader();
                  }
                  return this.f;
                }
                if ("readinjoy_skin_gif".equals(paramString)) {
                  return new SkinGifImageDownloader();
                }
                if ("pubaccountimage_gifplaytime".equals(paramString)) {
                  return (ProtocolDownloader)((IPublicAccountGifPlayTimeHttpDownloader)QRoute.api(IPublicAccountGifPlayTimeHttpDownloader.class)).getHttpDownloader();
                }
                if ("qzonecontentboxdownloader".equals(paramString)) {
                  return (AbsDownloader)QRoute.api(IQzoneContentBoxDownloader.class);
                }
                if ("qwallet_downloader".equals(paramString)) {
                  return ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQWalletPicDownloader();
                }
                if ("sticker_recommended_pic".equals(paramString))
                {
                  if (this.g == null) {
                    this.g = ((IStickerRecApi)QRoute.api(IStickerRecApi.class)).getStickerRecDownloader();
                  }
                  return this.g;
                }
                if ("albumthumbpreview".equals(paramString))
                {
                  if (this.h == null) {
                    this.h = new AlbumPreviewThumbDownloader();
                  }
                  return this.h;
                }
                if ("webcover".equals(paramString)) {
                  return new WebCoverDownloader();
                }
                if ("qqsys_emoji".equals(paramString)) {
                  return new QQSysAndEmojiDownloader();
                }
                return null;
              }
              return new SignatureTemplateDownloader();
            }
            if (this.c == null) {
              this.c = new ProfileImgDownloader();
            }
            return this.c;
          }
          if (this.b == null) {
            this.b = new LocalBilldDownloader(BaseApplicationImpl.getApplication());
          }
          return this.b;
        }
        return ((IPicFactory)QRoute.api(IPicFactory.class)).getChatImageDownloader(BaseApplication.getContext(), paramString);
      }
      if (this.d == null) {
        this.d = new NearbyImgDownloader();
      }
      return this.d;
    }
    if (this.a == null)
    {
      int i = BaseApplicationImpl.sProcessId;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.a = new HttpDownloader(bool, paramObject);
    }
    return this.a;
  }
  
  protected String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  protected ApngSoLoader getApngSoLoader()
  {
    return VasApngIPCModule.a();
  }
  
  protected Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838063);
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    return new ColorDrawable(0);
  }
  
  protected Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066);
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable.URLDrawableFactory
 * JD-Core Version:    0.7.0.1
 */