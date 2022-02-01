import android.os.Bundle;

public class nnf
{
  zon a;
  
  public nnf(zon paramzon)
  {
    this.a = paramzon;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    zop localzop;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localzop = this.a.a(i);
    } while (localzop == null);
    localzop.callback(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void a(zop paramzop)
  {
    if (paramzop == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 4);
    localBundle.putInt("seq", this.a.a(paramzop));
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(zop paramzop)
  {
    if (paramzop == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 6);
    localBundle.putInt("seq", this.a.a(paramzop));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(zop paramzop)
  {
    if (paramzop == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nng.a, 7);
    localBundle.putInt("seq", this.a.a(paramzop));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnf
 * JD-Core Version:    0.7.0.1
 */