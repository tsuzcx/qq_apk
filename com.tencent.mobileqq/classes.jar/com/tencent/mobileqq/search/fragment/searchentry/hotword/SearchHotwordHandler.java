package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import aokg;
import aoki;
import bbzo;
import bcnf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import java.util.HashMap;
import java.util.Map;

public class SearchHotwordHandler
  extends aoki
{
  private QQAppInterface app;
  private final HotWordSearchEntryDataModel dataModel;
  private SearchHippyEventEmitter eventEmitter;
  private final aokg uniteSearchHandler;
  
  public SearchHotwordHandler()
  {
    if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.app.addObserver(this);
    }
    this.dataModel = new HotWordSearchEntryDataModel(this.app, 7, 10, false);
    this.uniteSearchHandler = new aokg(this.app);
  }
  
  @NonNull
  private SmartBox_HotWordsItem convertHotSearchItemToSmartBoxHotWordItem(@NonNull HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    SmartBox_HotWordsItem localSmartBox_HotWordsItem = new SmartBox_HotWordsItem();
    localSmartBox_HotWordsItem.iId = 1;
    localSmartBox_HotWordsItem.sTitle = paramHotSearchItem.title;
    localSmartBox_HotWordsItem.sShowTitle = paramHotSearchItem.title;
    localSmartBox_HotWordsItem.sSubShowTitle = paramHotSearchItem.title;
    localSmartBox_HotWordsItem.iExposureCount = paramHotSearchItem.showCount;
    String str2 = paramHotSearchItem.jumpUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bcnf.a(paramHotSearchItem.recallWord, 5, "kandian_recomword");
    }
    localSmartBox_HotWordsItem.sUrl = str1;
    localSmartBox_HotWordsItem.sAppend = paramHotSearchItem.sAppend;
    localSmartBox_HotWordsItem.sItemExtInfo = paramHotSearchItem.sExtInfo;
    localSmartBox_HotWordsItem.sTextColor = paramHotSearchItem.titleTextColor;
    localSmartBox_HotWordsItem.symbolUrl = paramHotSearchItem.rightIconUrl;
    return localSmartBox_HotWordsItem;
  }
  
  public static Map<String, Object> getHotwordDataMap(@NonNull SearchHotwordHandler paramSearchHotwordHandler, @Nullable String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("hotwords", paramString);
    }
    localHashMap.put("hotwordExtInfo", paramSearchHotwordHandler.getHotwordExtInfo());
    localHashMap.put("showHotword", Boolean.valueOf(paramSearchHotwordHandler.isHotwordVisible()));
    localHashMap.put("tabHideSettingShow", Boolean.valueOf(false));
    return localHashMap;
  }
  
  public void destroy()
  {
    if (this.app != null) {
      this.app.removeObserver(this);
    }
  }
  
  public String getHotwordExtInfo()
  {
    if ((this.dataModel != null) && (this.dataModel.a != null)) {
      return this.dataModel.a;
    }
    return "";
  }
  
  public void getSearchFEHotwordItems(@NonNull SearchHotwordHandler.OnGetHotwordItemResultListener paramOnGetHotwordItemResultListener)
  {
    ThreadManager.post(new SearchHotwordHandler.1(this, paramOnGetHotwordItemResultListener), 5, null, true);
  }
  
  public boolean isHotwordVisible()
  {
    return bbzo.a(this.app);
  }
  
  public void notifyFEHotwordChanged()
  {
    getSearchFEHotwordItems(new SearchHotwordHandler.2(this));
  }
  
  public void onHotwordClick(int paramInt) {}
  
  public void requestSearchHotWord(boolean paramBoolean)
  {
    this.uniteSearchHandler.a(this.app, 10, paramBoolean);
  }
  
  public void setEventEmitter(SearchHippyEventEmitter paramSearchHippyEventEmitter)
  {
    this.eventEmitter = paramSearchHippyEventEmitter;
  }
  
  public void setHotwordVisibility(boolean paramBoolean)
  {
    bbzo.a(this.app, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler
 * JD-Core Version:    0.7.0.1
 */