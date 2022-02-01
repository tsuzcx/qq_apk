import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class onl
  implements Comparator<onq>
{
  public onl(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(onq paramonq1, onq paramonq2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(onq.a(paramonq1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(onq.a(paramonq2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = onq.a(paramonq1).codePointAt(0);
      break;
      label44:
      j = onq.a(paramonq2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onl
 * JD-Core Version:    0.7.0.1
 */