import java.lang.ref.WeakReference;

class okc
  implements slr
{
  private WeakReference<okb> a;
  
  public okc(okb paramokb)
  {
    this.a = new WeakReference(paramokb);
  }
  
  public void a()
  {
    okb localokb = (okb)this.a.get();
    if ((localokb == null) || (!localokb.b())) {
      return;
    }
    okb.a(localokb).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okc
 * JD-Core Version:    0.7.0.1
 */