import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

class nnb
  extends anvi
{
  private final WeakReference<nmy> a;
  private final WeakReference<QQAppInterface> b;
  
  public nnb(nmy paramnmy, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramnmy);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    nmy localnmy = (nmy)this.a.get();
    if ((paramBoolean) && (localnmy != null) && (nmy.a(localnmy, paramString, 0))) {
      localnmy.a(1, paramString, 200);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    nmy localnmy = (nmy)this.a.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramBoolean) && (localnmy != null) && (nmy.a(localnmy, paramString, 1))) {
      localnmy.a(0, paramString, nmy.a(localnmy, 0, paramString, localQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnb
 * JD-Core Version:    0.7.0.1
 */