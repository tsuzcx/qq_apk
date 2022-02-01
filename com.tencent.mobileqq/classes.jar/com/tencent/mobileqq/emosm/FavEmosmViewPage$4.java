package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.List;

class FavEmosmViewPage$4
  implements CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback
{
  FavEmosmViewPage$4(FavEmosmViewPage paramFavEmosmViewPage) {}
  
  public void a(List<EmoticonInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (FavEmosmViewPage.a(this.a) != null) {
      FavEmosmViewPage.a(this.a).obtainMessage(206, localObject).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.4
 * JD-Core Version:    0.7.0.1
 */