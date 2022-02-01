package dov.com.qq.im.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import java.util.Set;

class AEGIFChunkPreviewAdapter$1
  implements View.OnClickListener
{
  AEGIFChunkPreviewAdapter$1(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFPreviewWrapper paramAEGIFPreviewWrapper, int paramInt, AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFPreviewWrapper.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFPreviewWrapper.a()) {
        break label80;
      }
      bool = true;
      if (!bool) {
        break label85;
      }
      AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter).add(Integer.valueOf(this.jdField_a_of_type_Int));
      AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFPreviewWrapper.a(bool);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter$ViewHolder.a(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      bool = false;
      break;
      label85:
      AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter).size() < 1) {
        AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */