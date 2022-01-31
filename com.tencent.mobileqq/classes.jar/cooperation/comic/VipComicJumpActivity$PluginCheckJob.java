package cooperation.comic;

import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

abstract class VipComicJumpActivity$PluginCheckJob
  implements Runnable
{
  final WeakReference<QQAppInterface> a;
  
  VipComicJumpActivity$PluginCheckJob(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.PluginCheckJob
 * JD-Core Version:    0.7.0.1
 */