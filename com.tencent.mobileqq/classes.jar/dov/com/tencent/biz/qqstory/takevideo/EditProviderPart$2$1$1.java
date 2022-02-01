package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import dov.com.qq.im.capture.adapter.TransitionProviderGridAdapter;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.List;

class EditProviderPart$2$1$1
  implements AdapterView.OnItemClickListener
{
  EditProviderPart$2$1$1(EditProviderPart.2.1 param1, TransitionProviderGridAdapter paramTransitionProviderGridAdapter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart$2$1.a.a == null)) {}
    while (paramInt >= this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart$2$1.a.a.size()) {
      return;
    }
    paramAdapterView = (TransitionCategoryItem)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart$2$1.a.a.get(paramInt);
    if ((paramAdapterView != null) && (!paramAdapterView.equals(VideoFilterTools.a().a())))
    {
      VideoFilterTools.a().a(paramAdapterView);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderGridAdapter.a();
      paramInt = Integer.parseInt(paramAdapterView.a);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart$2$1.a.this$0.d(paramInt);
      StoryReportor.a("video_edit_transition", "clk_effects", EditVideoTransfer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart$2$1.a.this$0.a.a.a("extra_transiton_src_from", -1)), 0, new String[] { paramAdapterView.k, paramAdapterView.n, paramAdapterView.l, paramAdapterView.m });
    }
    paramView.postDelayed(new EditProviderPart.2.1.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2.1.1
 * JD-Core Version:    0.7.0.1
 */