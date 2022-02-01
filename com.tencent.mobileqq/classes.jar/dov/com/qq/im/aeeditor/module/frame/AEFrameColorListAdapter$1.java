package dov.com.qq.im.aeeditor.module.frame;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import java.util.List;

class AEFrameColorListAdapter$1
  implements View.OnClickListener
{
  AEFrameColorListAdapter$1(AEFrameColorListAdapter paramAEFrameColorListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int >= 1)
    {
      String str = (String)AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter).get(this.jdField_a_of_type_Int - 1);
      if (AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter) != null) {
        AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter).a(str);
      }
      AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter, str);
      AEReportUtils.h(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter.notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter) != null) {
        AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter).a();
      }
      AEFrameColorListAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.frame.AEFrameColorListAdapter.1
 * JD-Core Version:    0.7.0.1
 */