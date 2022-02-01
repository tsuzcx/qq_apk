package dov.com.qq.im.ae.play;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

class AEPlayShowPart$8
  implements Observer<Boolean>
{
  AEPlayShowPart$8(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onChanged(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      AEPlayShowPart.access$000(this.this$0).refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.8
 * JD-Core Version:    0.7.0.1
 */