package dov.com.qq.im.aeeditor.module.clip.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class VideoSetSpeedDialog$OnItemSelectListener
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  
  public VideoSetSpeedDialog$OnItemSelectListener(VideoSetSpeedDialog paramVideoSetSpeedDialog, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getValue()).setSelected(false);
      ((TextView)localEntry.getValue()).setTextColor(VideoSetSpeedDialog.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog));
    }
    paramView.setSelected(true);
    ((TextView)paramView).setTextColor(VideoSetSpeedDialog.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog));
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog$OnSpeedChangeListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog$OnSpeedChangeListener.a(this.jdField_a_of_type_Float);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.VideoSetSpeedDialog.OnItemSelectListener
 * JD-Core Version:    0.7.0.1
 */