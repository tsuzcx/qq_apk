package dov.com.qq.im.aeeditor.module.edit.multi.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.ae.album.data.AEAlbumImageModel;
import dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DataProcessor
{
  public static MediaClipModel a(@NonNull AEAlbumImageModel paramAEAlbumImageModel)
  {
    return a(paramAEAlbumImageModel, false);
  }
  
  public static MediaClipModel a(@NonNull AEAlbumImageModel paramAEAlbumImageModel, boolean paramBoolean)
  {
    MediaClipModel localMediaClipModel = new MediaClipModel();
    VideoResourceModel localVideoResourceModel = new VideoResourceModel();
    localVideoResourceModel.setPath(paramAEAlbumImageModel.getPath());
    localVideoResourceModel.setType(2);
    if (paramBoolean)
    {
      localVideoResourceModel.setSelectTimeDurationUs(5000000L);
      localVideoResourceModel.setSourceTimeDurationUs(5000000L);
      localVideoResourceModel.setScaleDuration(5000L);
    }
    for (;;)
    {
      paramAEAlbumImageModel = BitmapUtil.getImageSize(paramAEAlbumImageModel.getPath());
      localVideoResourceModel.setWidth(paramAEAlbumImageModel.getWidth());
      localVideoResourceModel.setHeight(paramAEAlbumImageModel.getHeight());
      localVideoResourceModel.setRotate(0);
      localMediaClipModel.setResource(localVideoResourceModel);
      localMediaClipModel.setVideoConfigurationModel(new VideoConfigurationModel());
      localMediaClipModel.setAudioConfigurationModel(new AudioConfigurationModel());
      return localMediaClipModel;
      localVideoResourceModel.setSelectTimeDurationUs(2500000L);
      localVideoResourceModel.setSourceTimeDurationUs(3000000L);
      localVideoResourceModel.setScaleDuration(2500L);
    }
  }
  
  public static MediaClipModel a(@NonNull AEAlbumVideoModel paramAEAlbumVideoModel)
  {
    MediaClipModel localMediaClipModel = new MediaClipModel();
    VideoResourceModel localVideoResourceModel = new VideoResourceModel();
    localVideoResourceModel.setPath(paramAEAlbumVideoModel.getPath());
    localVideoResourceModel.setType(1);
    long l = DecoderUtils.getDuration(paramAEAlbumVideoModel.getPath()) / 1000L;
    localVideoResourceModel.setSelectTimeDurationUs(l * 1000L - 1L);
    localVideoResourceModel.setSourceTimeDurationUs(l * 1000L - 1L);
    localVideoResourceModel.setScaleDuration(l - 1L);
    paramAEAlbumVideoModel = VideoUtil.getVideoSize(paramAEAlbumVideoModel.getPath());
    localVideoResourceModel.setWidth(paramAEAlbumVideoModel.getWidth());
    localVideoResourceModel.setHeight(paramAEAlbumVideoModel.getHeight());
    localVideoResourceModel.setRotate(0);
    localMediaClipModel.setResource(localVideoResourceModel);
    localMediaClipModel.setVideoConfigurationModel(new VideoConfigurationModel());
    localMediaClipModel.setAudioConfigurationModel(new AudioConfigurationModel());
    return localMediaClipModel;
  }
  
  public static List<MediaClipModel> a(@Nullable List<AEAlbumMediaBaseModel> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((paramList.size() == 1) && ((paramList.get(0) instanceof AEAlbumImageModel)))
    {
      localLinkedList.add(a((AEAlbumImageModel)paramList.get(0)));
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    label145:
    for (;;)
    {
      label75:
      if (localIterator.hasNext())
      {
        paramList = (AEAlbumMediaBaseModel)localIterator.next();
        if (!(paramList instanceof AEAlbumVideoModel)) {
          break label124;
        }
        paramList = a((AEAlbumVideoModel)paramList);
      }
      for (;;)
      {
        if (paramList == null) {
          break label145;
        }
        localLinkedList.add(paramList);
        break label75;
        break;
        label124:
        if ((paramList instanceof AEAlbumImageModel)) {
          paramList = a((AEAlbumImageModel)paramList);
        } else {
          paramList = null;
        }
      }
    }
  }
  
  public static List<CropConfig> b(@Nullable List<AEAlbumMediaBaseModel> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (AEAlbumMediaBaseModel)localIterator.next();
      if (!(paramList instanceof AEAlbumImageModel)) {
        break label128;
      }
      paramList = ((AEAlbumImageModel)paramList).getEditorPicInfo();
      if (paramList != null) {
        paramList = new CropConfig((float)paramList.x, (float)paramList.y, (float)Math.min(paramList.w, 1.0D), (float)paramList.h);
      }
    }
    for (;;)
    {
      localLinkedList.add(paramList);
      break;
      paramList = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
      continue;
      return localLinkedList;
      label128:
      paramList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.data.DataProcessor
 * JD-Core Version:    0.7.0.1
 */