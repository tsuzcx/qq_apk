package com.tencent.weseevideo.model.utils;

import android.text.TextUtils;
import com.tencent.oscar.app.GlobalContext;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.MusicModel;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils
{
  public static final String ONLINE_MATERIAL_FOLDER = "musicdot";
  public static final String ONLINE_MATERIAL_PARENT_FOLDER = "olm";
  public static final String TAG = "Utils";
  
  public static boolean equals(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  private static String getDir(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    File localFile = DeviceUtils.getExternalFilesDir(GlobalContext.getContext(), "olm");
    if (localFile == null) {
      break label87;
    }
    boolean bool;
    label87:
    while (TextUtils.isEmpty(localFile.getPath()))
    {
      return null;
      localFile = new File(localFile.getPath() + File.separator + "musicdot");
      if (localFile.exists()) {
        break;
      }
      bool = localFile.mkdirs();
      Logger.i("Utils", "getDir downloadDir mkdirs result:" + bool);
    }
    paramMusicMaterialMetaDataBean = new File(localFile.getPath() + File.separator + paramMusicMaterialMetaDataBean.id);
    if (!paramMusicMaterialMetaDataBean.exists())
    {
      paramMusicMaterialMetaDataBean.mkdirs();
      Logger.i("Utils", "getDir dir mkdirs result:$r");
    }
    do
    {
      do
      {
        return paramMusicMaterialMetaDataBean.getPath();
        if (localFile.isDirectory()) {
          break;
        }
        bool = localFile.delete();
        Logger.i("Utils", "getDir, downloadDir delete result:" + bool);
        if (localFile.mkdirs()) {
          break;
        }
        Logger.i("Utils", "getDir, downloadDir mkdir err ");
        return null;
      } while (paramMusicMaterialMetaDataBean.isDirectory());
      paramMusicMaterialMetaDataBean.delete();
      Logger.i("Utils", "getDir, dir delete result:$r");
    } while (paramMusicMaterialMetaDataBean.mkdirs());
    Logger.i("Utils", "getDir, dir mkdir err ");
    return null;
  }
  
  public static String getPath(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    String str = getDir(paramMusicMaterialMetaDataBean);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      paramMusicMaterialMetaDataBean = paramMusicMaterialMetaDataBean.stuckPointJsonUrl;
    } while (TextUtils.isEmpty(paramMusicMaterialMetaDataBean));
    return str + File.separator + MD5Util.getUrlStrMd5(paramMusicMaterialMetaDataBean);
  }
  
  public static float getPlayVolume(MusicModel paramMusicModel)
  {
    if (paramMusicModel != null)
    {
      if ((paramMusicModel.getMetaDataBean() == null) && (!paramMusicModel.isManuallyChangedVolume())) {
        return 1.0F;
      }
      return paramMusicModel.getVolume();
    }
    return 0.0F;
  }
  
  public static boolean isLayerFillAble(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    label4:
    Iterator localIterator;
    if (paramTAVStickerLayerInfo == null) {}else
    {
      do
      {
        return false;
        paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getUserDataList();
      } while ((paramTAVStickerLayerInfo == null) || (paramTAVStickerLayerInfo.isEmpty()));
      localIterator = paramTAVStickerLayerInfo.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label4;
      }
      paramTAVStickerLayerInfo = (TAVStickerLayerInfo.TAVStickerUserData)localIterator.next();
      if (paramTAVStickerLayerInfo == null) {
        break;
      }
      paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getData();
      if (TextUtils.isEmpty(paramTAVStickerLayerInfo)) {
        break;
      }
      try
      {
        paramTAVStickerLayerInfo = new JSONObject(paramTAVStickerLayerInfo);
        if (paramTAVStickerLayerInfo == null) {
          continue;
        }
        if (paramTAVStickerLayerInfo.optInt("videoTrack", 0) > 0)
        {
          bool = true;
          return bool;
        }
      }
      catch (JSONException paramTAVStickerLayerInfo)
      {
        for (;;)
        {
          Logger.e("Utils", "isLayerFillAble JSONException " + paramTAVStickerLayerInfo.getMessage());
          paramTAVStickerLayerInfo.printStackTrace();
          paramTAVStickerLayerInfo = null;
          continue;
          boolean bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.Utils
 * JD-Core Version:    0.7.0.1
 */