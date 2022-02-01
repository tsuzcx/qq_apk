package dov.com.qq.im.ae.gif.giftext.adapter;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class AEGIFChunkPreviewAdapter$3
  implements Observer<String>
{
  AEGIFChunkPreviewAdapter$3(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = HardCodeUtil.a(2131700044);
    }
    paramString = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter) * 3 / 10;; i = AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter) * 11 / 50)
    {
      paramString.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(DisplayUtil.c(AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter), 23.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.a(AEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter), 2.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(str);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.3
 * JD-Core Version:    0.7.0.1
 */