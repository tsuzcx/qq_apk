package dov.com.qq.im.ae.gif;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class AEGIFStickerListPart$3
  implements Observer<Boolean>
{
  AEGIFStickerListPart$3(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramBoolean = (ViewGroup.MarginLayoutParams)AEGIFStickerListPart.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      AEGIFStickerListPart.a(this.a).setLayoutParams(paramBoolean);
      paramBoolean = (ViewGroup.MarginLayoutParams)AEGIFStickerListPart.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      AEGIFStickerListPart.a(this.a).setLayoutParams(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.3
 * JD-Core Version:    0.7.0.1
 */