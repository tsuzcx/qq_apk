package com.tencent.mobileqq.wink.editor.recommend;

import androidx.lifecycle.MutableLiveData;
import com.tencent.videocut.model.MediaModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WinkRecommendViewModel$extractVideoCover$1
  implements Runnable
{
  WinkRecommendViewModel$extractVideoCover$1(WinkRecommendViewModel paramWinkRecommendViewModel, boolean paramBoolean, List paramList, long paramLong) {}
  
  public final void run()
  {
    ArrayList localArrayList;
    if (this.a) {
      localArrayList = WinkRecommendViewModel.a(this.this$0, (MediaModel)this.b.get(0));
    } else {
      localArrayList = WinkRecommendViewModel.a(this.this$0, (MediaModel)this.b.get(0), this.c);
    }
    WinkRecommendViewModel.a(this.this$0).postValue(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.recommend.WinkRecommendViewModel.extractVideoCover.1
 * JD-Core Version:    0.7.0.1
 */