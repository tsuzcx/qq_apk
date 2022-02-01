package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSendControl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.ICameraEmoSendControl;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IHotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService;
import com.tencent.mobileqq.emoticonview.relateemo.IRelatedEmoSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.relateemo.ISearchResultItem;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem;

public class EmoticonUITestHelperServiceImpl
  implements IEmoticonUITestHelperService
{
  public IFavoriteEmoticonInfo createFavoriteEmoticonInfo()
  {
    return new FavoriteEmoticonInfo();
  }
  
  public IHotPicSearchEmoticonInfo createHotPicSearchEmoticonInfo(int paramInt1, int paramInt2, String paramString, EmotionSearchItem paramEmotionSearchItem)
  {
    return new HotPicSearchEmoticonInfo(paramInt1, paramInt2, paramString, paramEmotionSearchItem);
  }
  
  public IPicEmoticonInfo createPicEmoticonInfo(String paramString)
  {
    return new PicEmoticonInfo(paramString);
  }
  
  public IRelatedEmoSearchEmoticonInfo createRelatedEmoSearchEmoticonInfo(ISearchResultItem paramISearchResultItem, int paramInt)
  {
    return new RelatedEmoSearchEmoticonInfo((RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem)paramISearchResultItem, paramInt);
  }
  
  public ISearchResultItem createRelatedSearchResultItem()
  {
    return new RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem();
  }
  
  public ICameraEmoSendControl getCameraEmoSendControl()
  {
    return CameraEmoSendControl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonUITestHelperServiceImpl
 * JD-Core Version:    0.7.0.1
 */