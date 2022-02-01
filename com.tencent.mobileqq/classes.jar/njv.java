import android.os.Bundle;

public class njv
{
  aanz a;
  
  public njv(aanz paramaanz)
  {
    this.a = paramaanz;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(aaob paramaaob)
  {
    if (paramaaob == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 4);
    localBundle.putInt("seq", this.a.a(paramaaob));
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    aaob localaaob;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localaaob = this.a.a(i);
    } while (localaaob == null);
    localaaob.callback(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(aaob paramaaob)
  {
    if (paramaaob == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 6);
    localBundle.putInt("seq", this.a.a(paramaaob));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(aaob paramaaob)
  {
    if (paramaaob == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(njw.a, 7);
    localBundle.putInt("seq", this.a.a(paramaaob));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njv
 * JD-Core Version:    0.7.0.1
 */