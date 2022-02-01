package dov.com.qq.im.ae.camera.ui.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEFilterProviderAdapter$1
  implements View.OnClickListener
{
  AEFilterProviderAdapter$1(AEFilterProviderAdapter paramAEFilterProviderAdapter, AEFilterProviderAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter$ViewHolder.getLayoutPosition();
    AEFilterProviderAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter).a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter$ViewHolder.itemView, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderAdapter.1
 * JD-Core Version:    0.7.0.1
 */