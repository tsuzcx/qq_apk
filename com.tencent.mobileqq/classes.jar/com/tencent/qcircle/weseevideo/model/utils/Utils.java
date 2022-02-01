package com.tencent.qcircle.weseevideo.model.utils;

import android.text.TextUtils;
import com.tencent.qcircle.oscar.app.GlobalContext;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.device.LightDeviceUtils;

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
    File localFile = LightDeviceUtils.getExternalFilesDir(GlobalContext.getContext(), "olm");
    if (localFile == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("musicdot");
    localFile = new File(localStringBuilder.toString());
    boolean bool;
    if (!localFile.exists())
    {
      bool = localFile.mkdirs();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDir downloadDir mkdirs result:");
      localStringBuilder.append(bool);
      Logger.i("Utils", localStringBuilder.toString());
    }
    else if (!localFile.isDirectory())
    {
      bool = localFile.delete();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDir, downloadDir delete result:");
      localStringBuilder.append(bool);
      Logger.i("Utils", localStringBuilder.toString());
      if (!localFile.mkdirs())
      {
        Logger.i("Utils", "getDir, downloadDir mkdir err ");
        return null;
      }
    }
    if (TextUtils.isEmpty(localFile.getPath())) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMusicMaterialMetaDataBean.id);
    paramMusicMaterialMetaDataBean = new File(localStringBuilder.toString());
    if (!paramMusicMaterialMetaDataBean.exists())
    {
      paramMusicMaterialMetaDataBean.mkdirs();
      Logger.i("Utils", "getDir dir mkdirs result:$r");
    }
    else if (!paramMusicMaterialMetaDataBean.isDirectory())
    {
      paramMusicMaterialMetaDataBean.delete();
      Logger.i("Utils", "getDir, dir delete result:$r");
      if (!paramMusicMaterialMetaDataBean.mkdirs())
      {
        Logger.i("Utils", "getDir, dir mkdir err ");
        return null;
      }
    }
    return paramMusicMaterialMetaDataBean.getPath();
  }
  
  public static String getPath(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    String str = getDir(paramMusicMaterialMetaDataBean);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    paramMusicMaterialMetaDataBean = paramMusicMaterialMetaDataBean.stuckPointJsonUrl;
    if (TextUtils.isEmpty(paramMusicMaterialMetaDataBean)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(MD5Util.getUrlStrMd5(paramMusicMaterialMetaDataBean));
    return localStringBuilder.toString();
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
    boolean bool2 = false;
    if (paramTAVStickerLayerInfo == null) {
      return false;
    }
    paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getUserDataList();
    boolean bool1 = bool2;
    if (paramTAVStickerLayerInfo != null)
    {
      if (paramTAVStickerLayerInfo.isEmpty()) {
        return false;
      }
      Iterator localIterator = paramTAVStickerLayerInfo.iterator();
      do
      {
        Object localObject;
        do
        {
          do
          {
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            paramTAVStickerLayerInfo = (TAVStickerLayerInfo.TAVStickerUserData)localIterator.next();
          } while (paramTAVStickerLayerInfo == null);
          localObject = paramTAVStickerLayerInfo.getData();
        } while (TextUtils.isEmpty((CharSequence)localObject));
        paramTAVStickerLayerInfo = null;
        try
        {
          localObject = new JSONObject((String)localObject);
          paramTAVStickerLayerInfo = (TAVStickerLayerInfo)localObject;
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isLayerFillAble JSONException ");
          localStringBuilder.append(localJSONException.getMessage());
          Logger.e("Utils", localStringBuilder.toString());
          localJSONException.printStackTrace();
        }
      } while (paramTAVStickerLayerInfo == null);
      bool1 = bool2;
      if (paramTAVStickerLayerInfo.optInt("videoTrack", 0) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.Utils
 * JD-Core Version:    0.7.0.1
 */