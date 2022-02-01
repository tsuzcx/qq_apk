package com.tencent.mobileqq.emotionintegrate;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class AIOEmotionFragment$9
  implements QueryCallback<EmoticonPackage>
{
  AIOEmotionFragment$9(AIOEmotionFragment paramAIOEmotionFragment, QQAppInterface paramQQAppInterface) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.name != null) && ((paramEmoticonPackage.mobileFeetype != 0) || (paramEmoticonPackage.downloadCount != 0)))
    {
      int i = this.a.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int j = (int)(System.currentTimeMillis() / 1000L);
      if ((j - i <= 86400) && (j >= i))
      {
        MarketFaceItemBuilder.a(6, this.b.getBaseActivity(), this.a, paramEmoticonPackage, this.b.E, this.b.C, null, true);
        return;
      }
      AIOEmotionFragment.a(this.b, this.a, 6);
      return;
    }
    AIOEmotionFragment.a(this.b, this.a, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.9
 * JD-Core Version:    0.7.0.1
 */