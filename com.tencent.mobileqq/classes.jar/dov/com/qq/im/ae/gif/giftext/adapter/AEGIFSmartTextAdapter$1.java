package dov.com.qq.im.ae.gif.giftext.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.AEGIFSmartTextData;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import java.util.ArrayList;
import java.util.List;

class AEGIFSmartTextAdapter$1
  implements View.OnClickListener
{
  AEGIFSmartTextAdapter$1(AEGIFSmartTextAdapter paramAEGIFSmartTextAdapter, AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder paramQIMGIFSmartTextViewHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter) != this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter$QIMGIFSmartTextViewHolder.getLayoutPosition()) {
      AEBaseDataReporter.a().l(this.jdField_a_of_type_JavaLangString);
    }
    if ((AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter) == -1) && (TextUtils.isEmpty(AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter).a())))
    {
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter).a(this.jdField_a_of_type_JavaLangString, ((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.a.get(0)).jdField_a_of_type_JavaLangString, ((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.a.get(0)).b);
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter).a(true, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter.a();
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter, this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter$QIMGIFSmartTextViewHolder.getLayoutPosition());
      ((AEGIFSmartTextData)AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter).get(AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter) - 1)).a(true);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter$QIMGIFSmartTextViewHolder.a(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEGIFSmartTextAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFSmartTextAdapter).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFSmartTextAdapter.1
 * JD-Core Version:    0.7.0.1
 */