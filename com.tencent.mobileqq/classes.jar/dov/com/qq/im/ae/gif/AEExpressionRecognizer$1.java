package dov.com.qq.im.ae.gif;

import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.config.CameraPeakServiceObserver;

class AEExpressionRecognizer$1
  extends CameraPeakServiceObserver
{
  AEExpressionRecognizer$1(AEExpressionRecognizer paramAEExpressionRecognizer, AppInterface paramAppInterface) {}
  
  public void onUpdateRecommendText(boolean paramBoolean, RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean)
    {
      AEExpressionRecognizer.a(this.jdField_a_of_type_DovComQqImAeGifAEExpressionRecognizer).a(paramRecognizedEmotionBean);
      return;
    }
    AEExpressionRecognizer.a(this.jdField_a_of_type_DovComQqImAeGifAEExpressionRecognizer).a(new RecognizedEmotionBean());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEExpressionRecognizer.1
 * JD-Core Version:    0.7.0.1
 */