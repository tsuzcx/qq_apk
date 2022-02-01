package dov.com.qq.im.ae.camera.ui.poi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class AESelectionLocationAdapter$1
  implements View.OnClickListener
{
  AESelectionLocationAdapter$1(AESelectionLocationAdapter paramAESelectionLocationAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AESelectionLocationAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter, (AESelectionLocationAdapter.LocationData)this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter.a.get(this.jdField_a_of_type_Int));
    String str = "";
    if (AESelectionLocationAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter) != null) {
      str = AESelectionLocationAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter).a;
    }
    if (AESelectionLocationAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AESelectionLocationAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter).a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.poi.AESelectionLocationAdapter.1
 * JD-Core Version:    0.7.0.1
 */