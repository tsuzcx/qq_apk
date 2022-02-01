package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSysAndEmojiConfProcessor$SystemAndEmojiConfBean
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public int h = 510;
  public int i = 510;
  public String j;
  public String k;
  public String l;
  public String m;
  public QQSysAndEmojiConfProcessor.EmoticonGuideConfBean n = new QQSysAndEmojiConfProcessor.EmoticonGuideConfBean();
  public QQSysAndEmojiConfProcessor.AnimEmoCountConfBean o = new QQSysAndEmojiConfProcessor.AnimEmoCountConfBean();
  public int p = 3;
  
  public static SystemAndEmojiConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = paramArrayOfQConfItem;
    SystemAndEmojiConfBean localSystemAndEmojiConfBean = new SystemAndEmojiConfBean();
    if (localObject1 != null)
    {
      if (localObject1.length < 1) {
        return localSystemAndEmojiConfBean;
      }
      Object localObject2 = localObject1[(localObject1.length - 1)];
      int i1 = localObject1.length;
      int i2 = 0;
      for (localObject1 = localObject2; i2 < i1; localObject1 = localObject2)
      {
        QConfItem localQConfItem = paramArrayOfQConfItem[i2];
        localObject2 = localObject1;
        if (localQConfItem.a > ((QConfItem)localObject1).a) {
          localObject2 = localQConfItem;
        }
        i2 += 1;
      }
      paramArrayOfQConfItem = ((QConfItem)localObject1).b;
      if (TextUtils.isEmpty(paramArrayOfQConfItem)) {
        return localSystemAndEmojiConfBean;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task-id:");
        ((StringBuilder)localObject2).append(((QConfItem)localObject1).a);
        ((StringBuilder)localObject2).append(" parse content:");
        ((StringBuilder)localObject2).append(paramArrayOfQConfItem);
        QLog.i("QQSysAndEmojiConfProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        localSystemAndEmojiConfBean.a = paramArrayOfQConfItem.optString("exp", "default");
        if (paramArrayOfQConfItem.has("config_url"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ConfigUrl=");
          ((StringBuilder)localObject1).append(paramArrayOfQConfItem.optString("config_url"));
          ABTestUtil.a("QQSysAndEmojiConfProcessor", ((StringBuilder)localObject1).toString());
          localSystemAndEmojiConfBean.b = paramArrayOfQConfItem.optString("config_url");
        }
        if (paramArrayOfQConfItem.has("config_md5")) {
          localSystemAndEmojiConfBean.c = paramArrayOfQConfItem.optString("config_md5");
        }
        if (paramArrayOfQConfItem.has("sysface_apng_res_url")) {
          localSystemAndEmojiConfBean.d = paramArrayOfQConfItem.optString("sysface_apng_res_url");
        } else if (paramArrayOfQConfItem.has("sysface_res_url")) {
          localSystemAndEmojiConfBean.d = paramArrayOfQConfItem.optString("sysface_res_url");
        }
        if (paramArrayOfQConfItem.has("sysface_apng_res_md5")) {
          localSystemAndEmojiConfBean.e = paramArrayOfQConfItem.optString("sysface_apng_res_md5");
        } else if (paramArrayOfQConfItem.has("sysface_res_md5")) {
          localSystemAndEmojiConfBean.e = paramArrayOfQConfItem.optString("sysface_res_md5");
        }
        if (paramArrayOfQConfItem.has("emoji_res_url")) {
          localSystemAndEmojiConfBean.f = paramArrayOfQConfItem.optString("emoji_res_url");
        }
        if (paramArrayOfQConfItem.has("emoji_res_md5")) {
          localSystemAndEmojiConfBean.g = paramArrayOfQConfItem.optString("emoji_res_md5");
        }
        if (paramArrayOfQConfItem.has("AniStickerWidth")) {
          localSystemAndEmojiConfBean.h = paramArrayOfQConfItem.optInt("AniStickerWidth");
        }
        if (paramArrayOfQConfItem.has("AniStickerHeight")) {
          localSystemAndEmojiConfBean.i = paramArrayOfQConfItem.optInt("AniStickerHeight");
        }
        if (paramArrayOfQConfItem.has("AniStickerSvgUrl")) {
          localSystemAndEmojiConfBean.j = paramArrayOfQConfItem.optString("AniStickerSvgUrl");
        }
        if (paramArrayOfQConfItem.has("AniStickerSvgMd5")) {
          localSystemAndEmojiConfBean.k = paramArrayOfQConfItem.optString("AniStickerSvgMd5");
        }
        if (paramArrayOfQConfItem.has("AniStickerLottieUrl")) {
          localSystemAndEmojiConfBean.l = paramArrayOfQConfItem.optString("AniStickerLottieUrl");
        }
        if (paramArrayOfQConfItem.has("AniStickerLottieMd5")) {
          localSystemAndEmojiConfBean.m = paramArrayOfQConfItem.optString("AniStickerLottieMd5");
        }
        if (paramArrayOfQConfItem.has("sysface_recent_line_cnt"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sysFaceLineCnt=");
          ((StringBuilder)localObject1).append(paramArrayOfQConfItem.optInt("sysface_recent_line_cnt", 0));
          ABTestUtil.a("QQSysAndEmojiConfProcessor", ((StringBuilder)localObject1).toString());
          localSystemAndEmojiConfBean.p = paramArrayOfQConfItem.optInt("sysface_recent_line_cnt", 3);
        }
        localSystemAndEmojiConfBean.n = QQSysAndEmojiConfProcessor.EmoticonGuideConfBean.a(paramArrayOfQConfItem);
        localSystemAndEmojiConfBean.o = QQSysAndEmojiConfProcessor.AnimEmoCountConfBean.a(paramArrayOfQConfItem);
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      localSystemAndEmojiConfBean.a();
    }
    return localSystemAndEmojiConfBean;
  }
  
  private void a()
  {
    if (this.n.a())
    {
      String str = this.n.c;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      str = this.n.d;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", mConfigUrl:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mConfigMD5:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mSysFaceUrl");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mSysFaceMD5");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mEmojiUrl");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mEmojiMD5");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mEmoticonGuideConfBean");
    localStringBuilder.append(this.n.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean
 * JD-Core Version:    0.7.0.1
 */