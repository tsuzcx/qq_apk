package dov.com.qq.im.ae.gif.giftext.fragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import dov.com.qq.im.ae.gif.video.MaterialWrapper;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue;
import java.util.HashMap;
import java.util.List;

class AEGIFChunkPreviewFragment$6
  implements Observer<RecognizedEmotionBean>
{
  AEGIFChunkPreviewFragment$6(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void a(@Nullable RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    int i = 0;
    AEGIFChunkPreviewFragment.a(this.a).a().removeObservers(AEGIFChunkPreviewFragment.a(this.a));
    if (paramRecognizedEmotionBean != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + paramRecognizedEmotionBean });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString + "text ===" + paramRecognizedEmotionBean.jdField_a_of_type_Int + "material ====" + paramRecognizedEmotionBean.jdField_b_of_type_Int);
      if (paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString == null)
      {
        paramRecognizedEmotionBean.jdField_a_of_type_Int = 0;
        paramRecognizedEmotionBean.jdField_b_of_type_Int = 6;
        paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString = "default";
      }
      if ((paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList != null) && (paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.size() == 0)) {
        paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.addAll(AEGIFTextMvp.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = HardCodeUtil.a(2131700054);
        AEGIFChunkPreviewFragment.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < paramRecognizedEmotionBean.jdField_a_of_type_Int)
        {
          localObject = new AEGIFPreviewWrapper();
          ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_JavaLangString = ((String)paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.get(i % paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.size()));
          ((AEGIFPreviewWrapper)localObject).jdField_b_of_type_Int = 2;
          if (AEGIFChunkPreviewFragment.a(this.a).size() < AEGIFChunkPreviewFragment.a(this.a)) {}
        }
        else
        {
          AEGIFChunkPreviewFragment.a(this.a).a().observe(AEGIFChunkPreviewFragment.a(this.a), new AEGIFChunkPreviewFragment.6.1(this, paramRecognizedEmotionBean));
          AEGIFChunkPreviewFragment.a(this.a, paramRecognizedEmotionBean);
          return;
          localObject = (String)AEGIFChunkPreviewFragment.a(this.a).get(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
          localObject = HardCodeUtil.a(2131700049) + (String)localObject + HardCodeUtil.a(2131700056);
          break;
        }
        AEGIFChunkPreviewFragment.a(this.a).add(localObject);
        AEGIFChunkPreviewFragment.a(this.a).notifyItemInserted(AEGIFChunkPreviewFragment.a(this.a).size() - 1);
        MaterialWrapper localMaterialWrapper = new MaterialWrapper();
        localMaterialWrapper.jdField_b_of_type_JavaLangString = ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_JavaLangString;
        localMaterialWrapper.jdField_a_of_type_Int = (i + 1);
        AEGIFChunkPreviewFragment.a(this.a).a(localMaterialWrapper);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    paramRecognizedEmotionBean = new AEGIFPreviewWrapper();
    paramRecognizedEmotionBean.jdField_b_of_type_JavaLangString = "";
    paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString = "";
    paramRecognizedEmotionBean.jdField_b_of_type_Int = 2;
    paramRecognizedEmotionBean.jdField_a_of_type_Int = 11;
    AEGIFChunkPreviewFragment.a(this.a).add(paramRecognizedEmotionBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */