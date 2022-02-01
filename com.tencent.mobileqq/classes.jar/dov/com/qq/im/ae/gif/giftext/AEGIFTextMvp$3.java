package dov.com.qq.im.ae.gif.giftext;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AEGIFTextMvp$3
  implements Observer<RecognizedEmotionBean>
{
  AEGIFTextMvp$3(AEGIFTextMvp paramAEGIFTextMvp) {}
  
  public void a(@Nullable RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    AEGIFTextMvp.a(this.a).a().removeObservers(AEGIFTextMvp.a(this.a));
    RecognizedEmotionBean localRecognizedEmotionBean;
    if (paramRecognizedEmotionBean != null)
    {
      localRecognizedEmotionBean = paramRecognizedEmotionBean;
      if (paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localRecognizedEmotionBean = new RecognizedEmotionBean();
      localRecognizedEmotionBean.jdField_a_of_type_JavaLangString = "default";
    }
    paramRecognizedEmotionBean = (String)AEGIFTextMvp.a(this.a).get(localRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
    if (!localRecognizedEmotionBean.jdField_a_of_type_JavaLangString.equals("default")) {
      paramRecognizedEmotionBean = HardCodeUtil.a(2131700077) + paramRecognizedEmotionBean + HardCodeUtil.a(2131700070);
    }
    for (;;)
    {
      AEGIFTextMvp.a(this.a).setText(paramRecognizedEmotionBean);
      if ((AEGIFTextMvp.a(this.a).size() == 0) && (!AEGIFTextMvp.a(this.a)))
      {
        AEGIFTextMvp.a(this.a).addAll(localRecognizedEmotionBean.jdField_a_of_type_JavaUtilList);
        this.a.b();
        AEGIFTextMvp.a(this.a, true);
      }
      return;
      paramRecognizedEmotionBean = HardCodeUtil.a(2131700066);
      localRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.addAll(AEGIFTextMvp.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp.3
 * JD-Core Version:    0.7.0.1
 */