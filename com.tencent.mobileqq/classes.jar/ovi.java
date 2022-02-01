import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class ovi
  implements Comparator<ovn>
{
  public ovi(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(ovn paramovn1, ovn paramovn2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(ovn.a(paramovn1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(ovn.a(paramovn2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = ovn.a(paramovn1).codePointAt(0);
      break;
      label44:
      j = ovn.a(paramovn2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovi
 * JD-Core Version:    0.7.0.1
 */