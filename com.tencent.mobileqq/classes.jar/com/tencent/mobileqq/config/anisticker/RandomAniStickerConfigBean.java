package com.tencent.mobileqq.config.anisticker;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RandomAniStickerConfigBean
{
  public boolean a;
  
  public static RandomAniStickerConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    RandomAniStickerConfigBean localRandomAniStickerConfigBean = new RandomAniStickerConfigBean();
    boolean bool = false;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    } else {
      paramArrayOfQConfItem = null;
    }
    if (TextUtils.isEmpty(paramArrayOfQConfItem)) {
      return localRandomAniStickerConfigBean;
    }
    try
    {
      if (new JSONObject(paramArrayOfQConfItem).optInt("randomLottieEmoSwitch", 0) == 1) {
        bool = true;
      }
      localRandomAniStickerConfigBean.a = bool;
      return localRandomAniStickerConfigBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("RandomAniStickerConfigBean", 1, "parse: exception=", paramArrayOfQConfItem);
    }
    return localRandomAniStickerConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.anisticker.RandomAniStickerConfigBean
 * JD-Core Version:    0.7.0.1
 */