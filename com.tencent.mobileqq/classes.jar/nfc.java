import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

class nfc
  extends anyu
{
  private final WeakReference<nez> a;
  private final WeakReference<QQAppInterface> b;
  
  public nfc(nez paramnez, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramnez);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    nez localnez = (nez)this.a.get();
    if ((paramBoolean) && (localnez != null) && (nez.a(localnez, paramString, 0))) {
      localnez.a(1, paramString, 200);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    nez localnez = (nez)this.a.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramBoolean) && (localnez != null) && (nez.a(localnez, paramString, 1))) {
      localnez.a(0, paramString, nez.a(localnez, 0, paramString, localQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfc
 * JD-Core Version:    0.7.0.1
 */