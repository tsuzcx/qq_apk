package com.tencent.mobileqq.emoticonview;

import avsq;
import avtc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class RecommendEmotionAdapter$3
  implements avtc<Void, List<EmotionPanelData>>
{
  RecommendEmotionAdapter$3(RecommendEmotionAdapter paramRecommendEmotionAdapter) {}
  
  public List<EmotionPanelData> query(Void paramVoid)
  {
    paramVoid = ((avsq)this.this$0.app.getManager(14)).a(false, RecommendEmotionAdapter.access$100(this.this$0), false);
    ArrayList localArrayList = new ArrayList();
    if (paramVoid != null) {
      localArrayList.addAll(paramVoid);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.3
 * JD-Core Version:    0.7.0.1
 */