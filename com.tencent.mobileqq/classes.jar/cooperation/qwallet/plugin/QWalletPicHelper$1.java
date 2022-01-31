package cooperation.qwallet.plugin;

import com.tencent.image.URLDrawable;

final class QWalletPicHelper$1
  implements Runnable
{
  QWalletPicHelper$1(URLDrawable paramURLDrawable, QWalletPicHelper.OnDecodeListener paramOnDecodeListener) {}
  
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
          ((QWalletPicHelper.OnDecodeListener)???).onDecodeFinished(bool, this.val$d1);
          return;
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPicHelper.1
 * JD-Core Version:    0.7.0.1
 */