package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipStickerProcessor
  extends BaseQVipConfigProcessor<QVipStickerConfig>
{
  public static int a = 5;
  public static int b;
  public static int c;
  
  static
  {
    int i = jdField_a_of_type_Int;
    b = i;
    c = i;
  }
  
  @NonNull
  public QVipStickerConfig a()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = ((AppRuntime)localObject).getCurrentAccountUin();
    localObject = ((AppRuntime)localObject).getApp().getSharedPreferences("sticker_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_max_show_num_");
    localStringBuilder.append(str);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject).apply();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_max_send_num_");
    localStringBuilder.append(str);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject).commit();
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).flatBuffersParserSetEnable(true);
    return new QVipStickerConfig();
  }
  
  @NonNull
  public QVipStickerConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = localAppRuntime.getCurrentAccountUin();
    int m = paramArrayOfQConfItem.length;
    int i = 0;
    int j = -1;
    Object localObject1;
    int k;
    if (i < m)
    {
      localObject1 = paramArrayOfQConfItem[i];
      k = ((QConfItem)localObject1).jdField_a_of_type_Int;
      if (k < j)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("received old task id ");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", latest task id: ");
        ((StringBuilder)localObject1).append(j);
        SLog.e("QVipStickerProcessor", ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(((QConfItem)localObject1).jdField_a_of_type_JavaLangString.getBytes("utf-8")));
        localObject2 = localAppRuntime.getApp().getSharedPreferences("sticker_pref", 0).edit();
        StringBuilder localStringBuilder;
        if (localJSONObject.has("emojiMaxShowNum"))
        {
          c = localJSONObject.optInt("emojiMaxShowNum");
          if (c <= 0) {
            c = jdField_a_of_type_Int;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sticker_max_show_num_");
          localStringBuilder.append(str);
          ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), c);
          ((SharedPreferences.Editor)localObject2).apply();
        }
        if (localJSONObject.has("emojiMaxStickNum"))
        {
          b = localJSONObject.optInt("emojiMaxStickNum");
          if (b <= 0) {
            b = jdField_a_of_type_Int;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sticker_max_send_num_");
          localStringBuilder.append(str);
          ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), b);
          ((SharedPreferences.Editor)localObject2).commit();
        }
        if (localJSONObject.has("flatBufferEnable"))
        {
          localObject2 = (IVasDepTemp)QRoute.api(IVasDepTemp.class);
          int n = localJSONObject.optInt("flatBufferEnable");
          bool = true;
          if (n != 1) {
            break label502;
          }
          ((IVasDepTemp)localObject2).flatBuffersParserSetEnable(bool);
        }
        j = k;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("item.content=");
        ((StringBuilder)localObject2).append(((QConfItem)localObject1).jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" e=");
        ((StringBuilder)localObject2).append(localJSONException);
        SLog.e("QVipStickerProcessor", ((StringBuilder)localObject2).toString());
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("item.content=");
        ((StringBuilder)localObject2).append(((QConfItem)localObject1).jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" e=");
        ((StringBuilder)localObject2).append(localUnsupportedEncodingException);
        SLog.e("QVipStickerProcessor", ((StringBuilder)localObject2).toString());
      }
      i += 1;
      break;
      return new QVipStickerConfig();
      label502:
      boolean bool = false;
    }
  }
  
  @NonNull
  public QVipStickerConfig b()
  {
    return new QVipStickerConfig();
  }
  
  public Class<QVipStickerConfig> clazz()
  {
    return QVipStickerConfig.class;
  }
  
  public int type()
  {
    return 189;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor
 * JD-Core Version:    0.7.0.1
 */