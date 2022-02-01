package dov.com.qq.im.ae.gif.giftext.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;

class AEGIFChunkPreviewAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private DrawableImageView jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView;
  private ImageView b;
  
  public AEGIFChunkPreviewAdapter$ViewHolder(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, View paramView, String paramString)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364129));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374444));
    this.jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView = ((DrawableImageView)paramView.findViewById(2131362295));
    this.b = ((ImageView)paramView.findViewById(2131362296));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)paramView.findViewById(2131372646));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setFontId(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838196);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */