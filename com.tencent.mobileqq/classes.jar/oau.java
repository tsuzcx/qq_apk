import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class oau
  implements Comparator<oaz>
{
  public oau(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(oaz paramoaz1, oaz paramoaz2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(oaz.a(paramoaz1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(oaz.a(paramoaz2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = oaz.a(paramoaz1).codePointAt(0);
      break;
      label44:
      j = oaz.a(paramoaz2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oau
 * JD-Core Version:    0.7.0.1
 */