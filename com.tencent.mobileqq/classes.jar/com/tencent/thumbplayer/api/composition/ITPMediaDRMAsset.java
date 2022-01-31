package com.tencent.thumbplayer.api.composition;

import java.util.Map;

public abstract interface ITPMediaDRMAsset
  extends ITPMediaAsset
{
  public static final String TP_PLAYER_DRM_PROPERTY_APPVER = "drm_property_app_ver";
  public static final String TP_PLAYER_DRM_PROPERTY_COOKIE = "drm_property_cookie";
  public static final String TP_PLAYER_DRM_PROPERTY_DRM_USEL1 = "drm_property_use_l1";
  public static final String TP_PLAYER_DRM_PROPERTY_GUID = "drm_property_guid";
  public static final String TP_PLAYER_DRM_PROPERTY_LICENSE_URL = "drm_property_license_url";
  public static final String TP_PLAYER_DRM_PROPERTY_PLATFORM = "drm_property_platform";
  public static final String TP_PLAYER_DRM_PROPERTY_PROVISION_URL = "drm_property_provision_url";
  public static final String TP_PLAYER_DRM_PROPERTY_SAVE_PATH = "drm_property_save_path";
  
  public abstract Map<String, String> getDrmAllProperties();
  
  public abstract String getDrmPlayUrl();
  
  public abstract String getDrmProperty(String paramString1, String paramString2);
  
  public abstract int getDrmType();
  
  public abstract void setDrmPlayUrl(String paramString);
  
  public abstract void setDrmProperty(String paramString1, String paramString2);
  
  public abstract void setDrmType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
 * JD-Core Version:    0.7.0.1
 */