package com.tencent.tavcut.session;

import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.List;

class TAVCutImageSession$2
  implements Runnable
{
  TAVCutImageSession$2(TAVCutImageSession paramTAVCutImageSession) {}
  
  public void run()
  {
    if (this.this$0.mediaModels == null)
    {
      this.this$0.mediaModels = new ArrayList();
      int i = 0;
      while (i < TAVCutImageSession.access$200(this.this$0).size())
      {
        Object localObject3 = (String)TAVCutImageSession.access$200(this.this$0).get(i);
        MediaModel localMediaModel = new MediaModel();
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new MediaClipModel();
        Object localObject2 = new VideoResourceModel();
        ((VideoResourceModel)localObject2).setPath((String)localObject3);
        ((VideoResourceModel)localObject2).setType(4);
        ((VideoResourceModel)localObject2).setSourceTimeDurationUs(1000000L);
        ((VideoResourceModel)localObject2).setSelectTimeDurationUs(1000000L);
        localObject3 = BitmapUtil.getImageSize((String)localObject3);
        Object localObject4;
        if ((this.this$0.sessionConfig != null) && (this.this$0.sessionConfig.getMaxImageDecodeSize() != -1))
        {
          localObject4 = Util.constrainMaxSize((Size)localObject3, this.this$0.sessionConfig.getMaxImageDecodeSize());
          int k = ((Size)localObject3).getWidth() / ((Size)localObject4).getWidth();
          if (((Size)localObject3).getWidth() % ((Size)localObject4).getWidth() == 0) {
            j = 0;
          } else {
            j = 1;
          }
          k = j + k;
          int j = k;
          if (k <= 0) {
            j = 1;
          }
          ((Size)localObject3).setWidth(((Size)localObject3).getWidth() / j);
          ((Size)localObject3).setHeight(((Size)localObject3).getHeight() / j);
        }
        if ((this.this$0.sessionConfig != null) && (this.this$0.sessionConfig.getImageInitCropConfigs() != null))
        {
          localObject4 = this.this$0.sessionConfig.getImageInitCropConfigs();
          CropModel localCropModel = new CropModel();
          localCropModel.setCropConfig((CropConfig)((List)localObject4).get(i));
          localMediaModel.getMediaEffectModel().setCropModel(localCropModel);
        }
        Logger.i(TAVCutImageSession.access$300(), String.format("targetDecodeSize = %d * %d", new Object[] { Integer.valueOf(((Size)localObject3).getWidth()), Integer.valueOf(((Size)localObject3).getHeight()) }));
        ((VideoResourceModel)localObject2).setWidth(((Size)localObject3).getWidth());
        ((VideoResourceModel)localObject2).setHeight(((Size)localObject3).getHeight());
        ((VideoResourceModel)localObject2).setRotate(0);
        ((MediaClipModel)localObject1).setResource((VideoResourceModel)localObject2);
        localObject2 = new VideoConfigurationModel();
        ((VideoConfigurationModel)localObject2).setRotate(0);
        ((VideoConfigurationModel)localObject2).setContentMode(0);
        ((MediaClipModel)localObject1).setVideoConfigurationModel((VideoConfigurationModel)localObject2);
        localArrayList.add(localObject1);
        localObject1 = localMediaModel.getMediaResourceModel();
        ((MediaResourceModel)localObject1).setVideos(localArrayList);
        localMediaModel.setMediaResourceModel((MediaResourceModel)localObject1);
        this.this$0.mediaModels.add(localMediaModel);
        i += 1;
      }
      this.this$0.recordInitMediaModelsMD5();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.2
 * JD-Core Version:    0.7.0.1
 */