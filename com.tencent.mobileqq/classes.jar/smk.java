import android.content.Context;

public abstract class smk<MSG extends smd, INFO extends sme>
{
  MSG a;
  
  public smk(MSG paramMSG)
  {
    this.a = paramMSG;
  }
  
  public abstract boolean a(Context paramContext, INFO paramINFO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smk
 * JD-Core Version:    0.7.0.1
 */