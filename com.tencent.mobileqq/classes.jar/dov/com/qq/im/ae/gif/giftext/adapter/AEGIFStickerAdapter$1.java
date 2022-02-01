package dov.com.qq.im.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;

class AEGIFStickerAdapter$1
  implements View.OnClickListener
{
  AEGIFStickerAdapter$1(AEGIFStickerAdapter paramAEGIFStickerAdapter, int paramInt, AEMaterialWrapper paramAEMaterialWrapper) {}
  
  public void onClick(View paramView)
  {
    AEGIFStickerAdapter.OnMaterialClickCallback localOnMaterialClickCallback1 = null;
    Object localObject = null;
    AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position=" + this.jdField_a_of_type_Int + ", mClickedPos=" + AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter) + ", mActivatedPos=" + AEGIFStickerAdapter.b(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter));
    AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter, this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.b == 1))
    {
      AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADED");
      AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != AEGIFStickerAdapter.b(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter))
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position != mActivatedPos");
        int i = AEGIFStickerAdapter.b(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter);
        AEGIFStickerAdapter.b(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter.notifyItemChanged(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter.notifyItemChanged(i);
        if (AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter) != null)
        {
          localOnMaterialClickCallback1 = AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter);
          if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.b == 1) {
            localOnMaterialClickCallback1.a((AEMaterialWrapper)localObject);
          }
        }
        else
        {
          AEBaseReportParam.a().n(this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.jdField_a_of_type_JavaLangString);
          AEBaseDataReporter.a().ag();
          AEQLog.b("AEGIFStickerAdapter", "[ItemView.onClick] gifMaterialClick, id=" + this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper;
      break;
      AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position == mActivatedPos");
      continue;
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.jdField_a_of_type_Int == 0)
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_NOT_DOWNLOAD");
        if (AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter) != null)
        {
          AEGIFStickerAdapter.OnMaterialClickCallback localOnMaterialClickCallback2 = AEGIFStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter);
          if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper.b == 1) {}
          for (localObject = localOnMaterialClickCallback1;; localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialWrapper)
          {
            localOnMaterialClickCallback2.a((AEMaterialWrapper)localObject);
            break;
          }
        }
      }
      else
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADING");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFStickerAdapter.1
 * JD-Core Version:    0.7.0.1
 */