package com.tencent.mobileqq.search;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;

class HotWordSearchEntryModel$3
  implements HotWordSearchEntryModel.OnGifPlayListener
{
  HotWordSearchEntryModel$3(HotWordSearchEntryModel paramHotWordSearchEntryModel, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo) {}
  
  public void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    int i = localSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
    String str = localSharedPreferences.getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UniteSearchHandler localUniteSearchHandler = new UniteSearchHandler(localQQAppInterface);
    if (!TextUtils.equals(str, this.a.hotSearchGifID))
    {
      localSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_try_id", this.a.hotSearchGifID).apply();
      localSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", 1).apply();
      localUniteSearchHandler.a(localQQAppInterface, "gif_sta_first", null, null, this.a.hotSearchGifID);
      return;
    }
    localSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", i + 1).apply();
    localUniteSearchHandler.a(localQQAppInterface, "gif_sta_second", null, null, this.a.hotSearchGifID);
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    int i = localSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UniteSearchHandler localUniteSearchHandler = new UniteSearchHandler(localQQAppInterface);
    if (i == 1) {
      localUniteSearchHandler.a(localQQAppInterface, "gif_suc_first", null, null, this.a.hotSearchGifID);
    } else {
      localUniteSearchHandler.a(localQQAppInterface, "gif_suc_second", null, null, this.a.hotSearchGifID);
    }
    localSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_last_show_id", this.a.hotSearchGifID).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.3
 * JD-Core Version:    0.7.0.1
 */