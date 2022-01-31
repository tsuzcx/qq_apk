import android.os.Bundle;

public class mnm
{
  wis a;
  
  public mnm(wis paramwis)
  {
    this.a = paramwis;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    wiu localwiu;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("seq", -1);
      } while (i == -1);
      localwiu = this.a.a(i);
    } while (localwiu == null);
    localwiu.a(paramBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void a(wiu paramwiu)
  {
    if (paramwiu == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 4);
    localBundle.putInt("seq", this.a.a(paramwiu));
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(wiu paramwiu)
  {
    if (paramwiu == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 6);
    localBundle.putInt("seq", this.a.a(paramwiu));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(wiu paramwiu)
  {
    if (paramwiu == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mnn.a, 7);
    localBundle.putInt("seq", this.a.a(paramwiu));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnm
 * JD-Core Version:    0.7.0.1
 */