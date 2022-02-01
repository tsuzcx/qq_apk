import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

class ngj
  extends amsu
{
  private final WeakReference<ngg> a;
  private final WeakReference<QQAppInterface> b;
  
  public ngj(ngg paramngg, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramngg);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    ngg localngg = (ngg)this.a.get();
    if ((paramBoolean) && (localngg != null) && (ngg.a(localngg, paramString, 0))) {
      localngg.a(1, paramString, 200);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    ngg localngg = (ngg)this.a.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramBoolean) && (localngg != null) && (ngg.a(localngg, paramString, 1))) {
      localngg.a(0, paramString, ngg.a(localngg, 0, paramString, localQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngj
 * JD-Core Version:    0.7.0.1
 */