import android.view.View;

public class shb
  extends psx
{
  private final String a;
  
  public shb(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.a = paramString;
  }
  
  public shb(String paramString, int paramInt)
  {
    super(-12084769, paramInt, 860716207);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    ors.a(paramView.getContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     shb
 * JD-Core Version:    0.7.0.1
 */