import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.shortvideo.ptvfilter.PanoramicVideoFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.StaticGestureFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.BuckleFaceFilter;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.filter.VideoFilterListExtension.CreateExternalFiltersListener;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.Iterator;
import java.util.List;

class kye
  implements VideoFilterListExtension.CreateExternalFiltersListener
{
  kye(kyd paramkyd) {}
  
  public VideoFilterBase createBigHeadFilter(VideoMaterial paramVideoMaterial)
  {
    return null;
  }
  
  public BuckleFaceFilter createBuckleFaceFilter(VideoMaterial paramVideoMaterial)
  {
    return null;
  }
  
  public VideoFilterBase createNonFit2DFilter(VideoMaterial paramVideoMaterial)
  {
    return null;
  }
  
  public StaticStickerFilter createPanoramicFilter(StickerItem paramStickerItem, String paramString)
  {
    PanoramicVideoFilter localPanoramicVideoFilter = new PanoramicVideoFilter(paramStickerItem, paramString);
    if (SLog.isEnable()) {
      SLog.d("PanoramicLogUtil", "createPanoramicFilter  " + paramStickerItem.name + "|" + paramString);
    }
    return localPanoramicVideoFilter;
  }
  
  public void createQQGestureVideoFilterList(VideoMaterial paramVideoMaterial, List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2)
  {
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.getTriggerTypeInt() == 1001)
        {
          Object localObject;
          if (localStickerItem.type == 1)
          {
            localObject = new StaticGestureFilter(localStickerItem, paramVideoMaterial.getDataPath());
            ((StaticGestureFilter)localObject).setControllerInfo(paramVideoMaterial.gestureAnimType, paramVideoMaterial.gestureAnimGapTime, paramVideoMaterial.gesturePointIndex);
            paramList1.add(localObject);
            if (SLog.isEnable()) {
              SLog.d("GesturetestUse", "static normalFirst is item:" + localStickerItem.toString() + "dataPath is:" + paramVideoMaterial.getDataPath() + ":" + ((StaticGestureFilter)localObject).printControllerInfo());
            }
          }
          else if (localStickerItem.type == 2)
          {
            localObject = new GestureFilterManager(localStickerItem, paramVideoMaterial.getDataPath());
            ((GestureFilterManager)localObject).setControllerInfo(paramVideoMaterial.gestureAnimType, paramVideoMaterial.gestureAnimGapTime, paramVideoMaterial.gesturePointIndex);
            paramList2.add(localObject);
            if (SLog.isEnable()) {
              SLog.d("GesturetestUse", "dynamic normalFirst is item:" + localStickerItem.toString() + "dataPath is:" + paramVideoMaterial.getDataPath() + ":markMode:" + localStickerItem.markMode + ":" + ((GestureFilterManager)localObject).printControllerInfo());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kye
 * JD-Core Version:    0.7.0.1
 */