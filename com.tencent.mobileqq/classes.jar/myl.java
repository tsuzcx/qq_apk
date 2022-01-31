import android.os.Bundle;

public class myl
{
  wxu a;
  
  public myl(wxu paramwxu)
  {
    this.a = paramwxu;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    wxw localwxw;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localwxw = this.a.a(i);
    } while (localwxw == null);
    localwxw.a(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void a(wxw paramwxw)
  {
    if (paramwxw == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 4);
    localBundle.putInt("seq", this.a.a(paramwxw));
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(wxw paramwxw)
  {
    if (paramwxw == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 6);
    localBundle.putInt("seq", this.a.a(paramwxw));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(wxw paramwxw)
  {
    if (paramwxw == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mym.a, 7);
    localBundle.putInt("seq", this.a.a(paramwxw));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myl
 * JD-Core Version:    0.7.0.1
 */