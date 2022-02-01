package com.tencent.mobileqq.startup.step;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinGifImageDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.activity.aio.photo.PhotoDecoder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDrawableDownLoader;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletPicDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloGifDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloImageDownloader;
import com.tencent.mobileqq.app.FunnyPicHelper.FunnyPicDownloader;
import com.tencent.mobileqq.colornote.list.WebCoverDownloader;
import com.tencent.mobileqq.emoticonview.FavoriteDownloader;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicOriginDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchPicDownloader;
import com.tencent.mobileqq.transfile.AIOFlowerImgDownloader;
import com.tencent.mobileqq.transfile.AIOPhotoImageDownloader;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.AlbumPreviewThumbDownloader;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.AvatarPendantDownloader;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
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
import com.tencent.mobileqq.transfile.PicEmotionDownloader;
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
import com.tencent.mobileqq.transfile.VasExtensionDownloader;
import com.tencent.mobileqq.transfile.VideoCoverDownloader;
import com.tencent.mobileqq.transfile.VideoThumbDownloader;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import cooperation.qzone.contentbox.QzoneContentBoxDownloader;

class InitUrlDrawable$URLDrawableFactory
  extends URLDrawableParams
{
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  private AIOPhotoImageDownloader jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader;
  private ProtocolDownloader b;
  private ProtocolDownloader c;
  private ProtocolDownloader d;
  private ProtocolDownloader e;
  private ProtocolDownloader f;
  private ProtocolDownloader g;
  private ProtocolDownloader h;
  private ProtocolDownloader i;
  
  public InitUrlDrawable$URLDrawableFactory(Application paramApplication)
  {
    super(paramApplication);
    this.mFadeInImage = false;
    this.mUseGifAnimation = false;
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    boolean bool = true;
    if (("http".equals(paramString)) || ("https".equals(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentImageProtocolDownloader == null) {
        if (BaseApplicationImpl.sProcessId != 1) {
          break label52;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new HttpDownloader(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new NearbyImgDownloader();
      }
      return this.e;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new ChatImageDownloader(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
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
      return new PicEmotionDownloader(BaseApplicationImpl.getApplication());
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
      return ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).getHttpDownloader();
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new LocalBilldDownloader(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new ProfileImgDownloader();
      }
      return this.d;
    }
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
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader = new AIOPhotoImageDownloader(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader;
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
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new SignatureTemplateDownloader();
    }
    if ("themediydownloader".equals(paramString)) {
      return new ThemeDIYDownloader();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new FunnyPicHelper.FunnyPicDownloader();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new RedTouchPicDownloader(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new VasExtensionDownloader(BaseApplicationImpl.getApplication());
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
      if (this.f == null) {
        this.f = new HotPicDownLoader();
      }
      return this.f;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new HotPicOriginDownLoader();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.g == null) {
        this.g = new HotVideoPreviewDownloader();
      }
      return this.g;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new SkinGifImageDownloader();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return ((IPublicAccountGifPlayTimeHttpDownloader)QRoute.api(IPublicAccountGifPlayTimeHttpDownloader.class)).getHttpDownloader();
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new QzoneContentBoxDownloader();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new QWalletPicDownloader();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.h == null) {
        this.h = new StickerRecDrawableDownLoader();
      }
      return this.h;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.i == null) {
        this.i = new AlbumPreviewThumbDownloader();
      }
      return this.i;
    }
    if ("webcover".equals(paramString)) {
      return new WebCoverDownloader();
    }
    if ("qqsys_emoji".equals(paramString)) {
      return new QQSysAndEmojiDownloader();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return VasApngIPCModule.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838180);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable.URLDrawableFactory
 * JD-Core Version:    0.7.0.1
 */