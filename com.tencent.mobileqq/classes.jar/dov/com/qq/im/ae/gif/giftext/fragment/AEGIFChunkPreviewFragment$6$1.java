package dov.com.qq.im.ae.gif.giftext.fragment;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.download.AEDownloadStateWrapper;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import dov.com.qq.im.ae.gif.video.MaterialWrapper;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue;
import java.util.List;
import java.util.Map;

class AEGIFChunkPreviewFragment$6$1
  implements Observer<AEDownloadStateWrapper>
{
  AEGIFChunkPreviewFragment$6$1(AEGIFChunkPreviewFragment.6 param6, RecognizedEmotionBean paramRecognizedEmotionBean) {}
  
  public void a(@Nullable AEDownloadStateWrapper paramAEDownloadStateWrapper)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((paramAEDownloadStateWrapper == null) || (AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_DovComQqImAeGifRecognizedEmotionBean.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).size()) {
          break label360;
        }
        AEGIFPreviewWrapper localAEGIFPreviewWrapper = (AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).get(i);
        if ((localAEGIFPreviewWrapper != null) && (localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(paramAEDownloadStateWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localAEGIFPreviewWrapper.jdField_b_of_type_Int != paramAEDownloadStateWrapper.jdField_a_of_type_Int) {
            localAEGIFPreviewWrapper.jdField_b_of_type_Int = paramAEDownloadStateWrapper.jdField_a_of_type_Int;
          }
          if (localAEGIFPreviewWrapper.jdField_b_of_type_Int != 2) {
            break;
          }
          localAEGIFPreviewWrapper.jdField_b_of_type_JavaLangString = AEGifMaterialManager.a().a(localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localAEGIFPreviewWrapper.jdField_b_of_type_JavaLangString });
          paramAEDownloadStateWrapper = new MaterialWrapper();
          paramAEDownloadStateWrapper.jdField_a_of_type_Int = i;
          paramAEDownloadStateWrapper.jdField_a_of_type_JavaLangString = localAEGIFPreviewWrapper.jdField_b_of_type_JavaLangString;
          if ((localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString == null) || (localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = "";
              paramAEDownloadStateWrapper.c = ((String)localAEGIFPreviewWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).a(paramAEDownloadStateWrapper);
            localAEGIFPreviewWrapper.jdField_a_of_type_Int = 12;
            AEGIFChunkPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFChunkPreviewFragment$6.a).notifyItemChanged(i);
            return;
            paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = "";
            paramAEDownloadStateWrapper.c = "";
            continue;
            if (localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString == null) {
              paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = "";
            } else {
              paramAEDownloadStateWrapper.jdField_b_of_type_JavaLangString = localAEGIFPreviewWrapper.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.6.1
 * JD-Core Version:    0.7.0.1
 */