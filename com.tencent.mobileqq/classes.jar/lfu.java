import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import java.util.Comparator;

public class lfu
  implements Comparator
{
  public lfu(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(lgd paramlgd1, lgd paramlgd2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(lgd.a(paramlgd1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(lgd.a(paramlgd2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = lgd.a(paramlgd1).codePointAt(0);
      break;
      label44:
      j = lgd.a(paramlgd2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfu
 * JD-Core Version:    0.7.0.1
 */