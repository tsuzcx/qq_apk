package com.tencent.mobileqq.tts.impl;

import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.tts.TtsListener;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class TtsControllerImpl$2
  implements Runnable
{
  TtsControllerImpl$2(TtsControllerImpl paramTtsControllerImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    TtsControllerImpl.access$302(this.this$0, true);
    Object localObject = this.this$0;
    localObject = TtsControllerImpl.access$400((TtsControllerImpl)localObject, TtsControllerImpl.access$100((TtsControllerImpl)localObject), this.jdField_a_of_type_JavaLangString);
    TtsControllerImpl.access$302(this.this$0, false);
    if (localObject == null)
    {
      QLog.e("TtsController", 1, "[speak] input stream is null.");
      if (TtsControllerImpl.access$000(this.this$0) != null) {
        TtsControllerImpl.access$000(this.this$0).c();
      }
      TtsControllerImpl.access$502(this.this$0, false);
      return;
    }
    if (!TtsControllerImpl.access$500(this.this$0))
    {
      QLog.d("TtsController", 1, "[speak] stream prepared but shouldn't speak.");
      return;
    }
    TtsControllerImpl.access$600(this.this$0).setDataStream((InputStream)localObject);
    TtsControllerImpl.access$600(this.this$0).start(this.jdField_a_of_type_Int);
    if (TtsControllerImpl.access$000(this.this$0) != null) {
      TtsControllerImpl.access$000(this.this$0).a(TtsControllerImpl.access$100(this.this$0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TtsController", 1, new Object[] { "[speak] text: ", Character.valueOf(TtsControllerImpl.access$100(this.this$0).charAt(0)), ", senderUin: ", this.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.impl.TtsControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */