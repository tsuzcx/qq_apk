import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class nmf
  implements Comparator<nmk>
{
  public nmf(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(nmk paramnmk1, nmk paramnmk2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(nmk.a(paramnmk1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(nmk.a(paramnmk2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = nmk.a(paramnmk1).codePointAt(0);
      break;
      label44:
      j = nmk.a(paramnmk2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmf
 * JD-Core Version:    0.7.0.1
 */