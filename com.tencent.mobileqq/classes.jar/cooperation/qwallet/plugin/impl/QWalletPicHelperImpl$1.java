package cooperation.qwallet.plugin.impl;

import com.tencent.image.URLDrawable;
import cooperation.qwallet.plugin.IQWalletPicHelper.OnDecodeListener;

class QWalletPicHelperImpl$1
  implements Runnable
{
  QWalletPicHelperImpl$1(QWalletPicHelperImpl paramQWalletPicHelperImpl, URLDrawable paramURLDrawable, IQWalletPicHelper.OnDecodeListener paramOnDecodeListener) {}
  
  public void run()
  {
    boolean bool = true;
    if (this.val$d1.getStatus() == 1)
    {
      if (this.val$l != null) {
        this.val$l.onDecodeFinished(true, this.val$d1);
      }
      return;
    }
    if (this.val$d1.getConstantState() != null) {}
    for (;;)
    {
      synchronized (this.val$d1.getConstantState())
      {
        this.val$d1.downloadImediatly();
        if (this.val$l == null) {
          break;
        }
        ??? = this.val$l;
        if (this.val$d1.getStatus() == 1)
        {
          ((IQWalletPicHelper.OnDecodeListener)???).onDecodeFinished(bool, this.val$d1);
          return;
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletPicHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */