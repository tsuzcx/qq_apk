package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EmoticonPanelFavHelper$5
  extends FavEmoRoamingObserver
{
  EmoticonPanelFavHelper$5(EmoticonPanelFavHelper paramEmoticonPanelFavHelper) {}
  
  public void onUpdateFavData(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.this$0.updateFavEmoticonPanel();
    }
    if ((paramObject != null) && ((paramObject instanceof Integer))) {
      ThreadManager.getUIHandler().post(new EmoticonPanelFavHelper.5.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5
 * JD-Core Version:    0.7.0.1
 */