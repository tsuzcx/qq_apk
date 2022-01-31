import android.os.Bundle;

public class nbc
{
  yqz a;
  
  public nbc(yqz paramyqz)
  {
    this.a = paramyqz;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    yrb localyrb;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localyrb = this.a.a(i);
    } while (localyrb == null);
    localyrb.callback(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void a(yrb paramyrb)
  {
    if (paramyrb == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 4);
    localBundle.putInt("seq", this.a.a(paramyrb));
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(yrb paramyrb)
  {
    if (paramyrb == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 6);
    localBundle.putInt("seq", this.a.a(paramyrb));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(yrb paramyrb)
  {
    if (paramyrb == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nbd.a, 7);
    localBundle.putInt("seq", this.a.a(paramyrb));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nbc
 * JD-Core Version:    0.7.0.1
 */