package dov.com.qq.im.ae.gif.giftext.adapter;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;

class AEGIFChunkPreviewAdapter$2
  implements Observer<AEGIFTextColorConfig.SmartTextColor>
{
  AEGIFChunkPreviewAdapter$2(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable AEGIFTextColorConfig.SmartTextColor paramSmartTextColor)
  {
    if (paramSmartTextColor != null)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramSmartTextColor.a);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramSmartTextColor.b);
      if (paramSmartTextColor.a.equals("#ccffffff"))
      {
        this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
        this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(true);
        this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(false);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.2
 * JD-Core Version:    0.7.0.1
 */