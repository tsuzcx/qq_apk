import android.os.Bundle;

public class nlq
{
  aasb a;
  
  public nlq(aasb paramaasb)
  {
    this.a = paramaasb;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(aasd paramaasd)
  {
    if (paramaasd == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 4);
    localBundle.putInt("seq", this.a.a(paramaasd));
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    aasd localaasd;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localaasd = this.a.a(i);
    } while (localaasd == null);
    localaasd.callback(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(aasd paramaasd)
  {
    if (paramaasd == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 6);
    localBundle.putInt("seq", this.a.a(paramaasd));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(aasd paramaasd)
  {
    if (paramaasd == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(nlr.a, 7);
    localBundle.putInt("seq", this.a.a(paramaasd));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlq
 * JD-Core Version:    0.7.0.1
 */