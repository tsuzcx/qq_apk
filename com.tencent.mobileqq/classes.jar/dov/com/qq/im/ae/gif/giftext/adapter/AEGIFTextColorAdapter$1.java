package dov.com.qq.im.ae.gif.giftext.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEGIFTextColorAdapter$1
  implements View.OnClickListener
{
  AEGIFTextColorAdapter$1(AEGIFTextColorAdapter paramAEGIFTextColorAdapter, int paramInt, AEGIFTextColorAdapter.TextEditColorViewHolder paramTextEditColorViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != AEGIFTextColorAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter))
    {
      AEGIFTextColorAdapter.TextEditColorViewHolder localTextEditColorViewHolder = (AEGIFTextColorAdapter.TextEditColorViewHolder)AEGIFTextColorAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter).findViewHolderForAdapterPosition(AEGIFTextColorAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter));
      if (localTextEditColorViewHolder == null) {
        break label101;
      }
      localTextEditColorViewHolder.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter$TextEditColorViewHolder.a(true);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a(this.jdField_a_of_type_Int);
      if (AEGIFTextColorAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter) != null) {
        AEGIFTextColorAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter).setTextColor(Color.parseColor(AEGIFTextColorAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter)));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFTextColorAdapter.1
 * JD-Core Version:    0.7.0.1
 */