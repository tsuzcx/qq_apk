package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavEmotionDataSource
  extends EmotionDataSource
{
  public CustomEmotionRoamingDBManagerBase a;
  
  public FavEmotionDataSource(QQAppInterface paramQQAppInterface, FavEmoticonPreviewData paramFavEmoticonPreviewData)
  {
    if ((paramFavEmoticonPreviewData.a instanceof CameraEmoticonInfo)) {
      paramFavEmoticonPreviewData = ICameraEmotionRoamingDBManagerService.class;
    } else {
      paramFavEmoticonPreviewData = IFavroamingDBManagerService.class;
    }
    this.a = ((CustomEmotionRoamingDBManagerBase)paramQQAppInterface.getRuntimeService(paramFavEmoticonPreviewData));
  }
  
  public int a()
  {
    return 2;
  }
  
  public List<EmoticonPreviewData> a(boolean paramBoolean)
  {
    Object localObject = this.a.syncGetCustomEmotionInfoShowedInPanel();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new FavEmoticonPreviewData((EmoticonInfo)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.FavEmotionDataSource
 * JD-Core Version:    0.7.0.1
 */