import android.os.Bundle;

public class myi
{
  wxr a;
  
  public myi(wxr paramwxr)
  {
    this.a = paramwxr;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    wxt localwxt;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localwxt = this.a.a(i);
    } while (localwxt == null);
    localwxt.a(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void a(wxt paramwxt)
  {
    if (paramwxt == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 4);
    localBundle.putInt("seq", this.a.a(paramwxt));
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(wxt paramwxt)
  {
    if (paramwxt == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 6);
    localBundle.putInt("seq", this.a.a(paramwxt));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(wxt paramwxt)
  {
    if (paramwxt == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(myj.a, 7);
    localBundle.putInt("seq", this.a.a(paramwxt));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myi
 * JD-Core Version:    0.7.0.1
 */