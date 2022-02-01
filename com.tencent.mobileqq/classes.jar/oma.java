import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class oma
  implements Comparator<omf>
{
  public oma(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(omf paramomf1, omf paramomf2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(omf.a(paramomf1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(omf.a(paramomf2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = omf.a(paramomf1).codePointAt(0);
      break;
      label44:
      j = omf.a(paramomf2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oma
 * JD-Core Version:    0.7.0.1
 */