import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class nxn
  implements Comparator<nxs>
{
  public nxn(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(nxs paramnxs1, nxs paramnxs2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(nxs.a(paramnxs1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(nxs.a(paramnxs2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = nxs.a(paramnxs1).codePointAt(0);
      break;
      label44:
      j = nxs.a(paramnxs2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxn
 * JD-Core Version:    0.7.0.1
 */