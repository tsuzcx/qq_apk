import android.text.TextUtils;

public class ssp
{
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 7);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (paramInt == 2) || ((paramInt == 6) && (!TextUtils.isEmpty(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssp
 * JD-Core Version:    0.7.0.1
 */