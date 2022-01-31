import android.content.Context;

public abstract class rzo<MSG extends rzh, INFO extends rzi>
{
  MSG a;
  
  public rzo(MSG paramMSG)
  {
    this.a = paramMSG;
  }
  
  public abstract boolean a(Context paramContext, INFO paramINFO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzo
 * JD-Core Version:    0.7.0.1
 */