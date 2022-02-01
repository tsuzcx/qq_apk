import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

class ndj
  extends anmu
{
  private final WeakReference<ndg> a;
  private final WeakReference<QQAppInterface> b;
  
  public ndj(ndg paramndg, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramndg);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    ndg localndg = (ndg)this.a.get();
    if ((paramBoolean) && (localndg != null) && (ndg.a(localndg, paramString, 0))) {
      localndg.a(1, paramString, 200);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    ndg localndg = (ndg)this.a.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramBoolean) && (localndg != null) && (ndg.a(localndg, paramString, 1))) {
      localndg.a(0, paramString, ndg.a(localndg, 0, paramString, localQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndj
 * JD-Core Version:    0.7.0.1
 */