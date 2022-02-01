package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emosm.cameraemotionroaming.ICameraEmoSendControl;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IHotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.relateemo.IRelatedEmoSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.relateemo.ISearchResultItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoticonUITestHelperService
  extends QRouteApi
{
  public abstract IFavoriteEmoticonInfo createFavoriteEmoticonInfo();
  
  public abstract IHotPicSearchEmoticonInfo createHotPicSearchEmoticonInfo(int paramInt1, int paramInt2, String paramString, EmotionSearchItem paramEmotionSearchItem);
  
  public abstract IPicEmoticonInfo createPicEmoticonInfo(String paramString);
  
  public abstract IRelatedEmoSearchEmoticonInfo createRelatedEmoSearchEmoticonInfo(ISearchResultItem paramISearchResultItem, int paramInt);
  
  public abstract ISearchResultItem createRelatedSearchResultItem();
  
  public abstract ICameraEmoSendControl getCameraEmoSendControl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonUITestHelperService
 * JD-Core Version:    0.7.0.1
 */