package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.List;

class FavRoamingStrategy$2
  implements CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback
{
  FavRoamingStrategy$2(FavRoamingStrategy paramFavRoamingStrategy) {}
  
  public void a(List<EmoticonInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (this.a.b != null) {
      this.a.b.a((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.2
 * JD-Core Version:    0.7.0.1
 */