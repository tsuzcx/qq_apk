package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import java.util.ArrayList;
import java.util.List;

class RecommendEmotionAdapter$3
  implements QueryTask.Query<Void, List<EmotionPanelData>>
{
  RecommendEmotionAdapter$3(RecommendEmotionAdapter paramRecommendEmotionAdapter) {}
  
  public List<EmotionPanelData> query(Void paramVoid)
  {
    paramVoid = ((EmoticonManagerServiceProxy)this.this$0.app.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(false, RecommendEmotionAdapter.access$100(this.this$0), false);
    ArrayList localArrayList = new ArrayList();
    if (paramVoid != null) {
      localArrayList.addAll(paramVoid);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.3
 * JD-Core Version:    0.7.0.1
 */