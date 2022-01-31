import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class nxq
  implements Comparator<nxv>
{
  public nxq(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(nxv paramnxv1, nxv paramnxv2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(nxv.a(paramnxv1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(nxv.a(paramnxv2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = nxv.a(paramnxv1).codePointAt(0);
      break;
      label44:
      j = nxv.a(paramnxv2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxq
 * JD-Core Version:    0.7.0.1
 */