package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$initMediaDisplayLayout$2", "Lkotlin/Function1;", "", "", "invoke", "position", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$initMediaDisplayLayout$2
  implements Function1<Integer, Unit>
{
  PublishArticlePage$initMediaDisplayLayout$2(Activity paramActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject = PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage).a().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mediaDisplayLayout.displayItems[position]");
    localObject = (DisplayItem)localObject;
    if (((DisplayItem)localObject).getMedia().getType() != MediaType.VIDEO)
    {
      TLog.d("PublishArticleFragment", "onCoverSelectListener error. " + localObject + " is not a video");
      return;
    }
    CoverSelectData localCoverSelectData = new CoverSelectData();
    localCoverSelectData.setCoverFrom(((DisplayItem)localObject).getFromPage());
    localCoverSelectData.setInitialProgress(((DisplayItem)localObject).getInitialProgress());
    localCoverSelectData.setCoverPath(((DisplayItem)localObject).getCoverPath());
    localCoverSelectData.setVideoPath(((DisplayItem)localObject).getRealPath());
    localCoverSelectData.setVideoWidth(((DisplayItem)localObject).getMedia().getWidth());
    localCoverSelectData.setVideoHeight(((DisplayItem)localObject).getMedia().getHeight());
    TopicSDKHelperKt.a().a(this.jdField_a_of_type_AndroidAppActivity, localCoverSelectData, (Function1)new PublishArticlePage.initMediaDisplayLayout.2.invoke.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initMediaDisplayLayout.2
 * JD-Core Version:    0.7.0.1
 */