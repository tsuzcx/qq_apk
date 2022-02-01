package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.Logger;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.autotemplate.FrameExtractor;
import dov.com.qq.im.aeeditor.module.autotemplate.FrameExtractor.MediaWithType;
import java.util.ArrayList;
import java.util.List;

class MultiVideoAIFilterProxy$1
  implements Runnable
{
  MultiVideoAIFilterProxy$1(MultiVideoAIFilterProxy paramMultiVideoAIFilterProxy, List paramList, Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      AEQLog.a(MultiVideoAIFilterProxy.a(), "getVideoFrame start");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().size())
      {
        localObject = (MediaClipModel)this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().get(i);
        if (((MediaClipModel)localObject).getResource().getPath() != null) {
          localArrayList.add(new FrameExtractor.MediaWithType(((MediaClipModel)localObject).getResource().getPath(), ((MediaClipModel)localObject).getResource().getType(), ((MediaClipModel)localObject).getResource().getSourceTimeDuration()));
        }
        i += 1;
      }
      Object localObject = new FrameExtractor();
      this.this$0.jdField_a_of_type_JavaUtilList = ((FrameExtractor)localObject).a(localArrayList, this.jdField_a_of_type_JavaUtilList, 250);
      AEQLog.a(MultiVideoAIFilterProxy.a(), "getVideoFrame end");
      Logger.i("Cover", "get covers num =" + this.this$0.jdField_a_of_type_JavaUtilList.size());
      this.this$0.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_JavaUtilList.size();
      this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterProxyBase$AIFilterProxyCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.MultiVideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */