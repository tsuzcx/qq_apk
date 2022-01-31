import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class syt
  extends swl
  implements slx<tax, tcg>
{
  public static int a = 20;
  private long c;
  
  public tax a(int paramInt, ArrayList<spx> paramArrayList)
  {
    if (paramArrayList.size() > a) {
      urk.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    tax localtax = new tax();
    localtax.c = paramInt;
    localtax.a = paramArrayList;
    slv.a().a(localtax, this);
    this.c = System.currentTimeMillis();
    return localtax;
  }
  
  public void a(@NonNull tax paramtax, @Nullable tcg paramtcg, @NonNull ErrorMessage paramErrorMessage)
  {
    spw localspw = (spw)sqg.a(13);
    if ((paramtcg == null) || (paramErrorMessage.isFail()))
    {
      urk.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramtcg = paramtax.a.iterator();
    }
    while (paramtcg.hasNext())
    {
      localspw.a((spx)paramtcg.next(), false);
      continue;
      localspw.a(paramtcg.a);
      urk.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramtcg.a.size()), Integer.valueOf(paramtax.a.size()) });
      paramErrorMessage = paramtax.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        spx localspx = (spx)paramErrorMessage.next();
        if (!paramtcg.a.contains(localspx)) {
          localspw.a(localspx, false);
        }
      }
      if (paramtax.a.size() > paramtcg.a.size()) {
        urp.b("home_page", "batch_watch_video", 0, paramtax.a.size() - paramtcg.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), urp.a(BaseApplication.getContext()) });
      }
    }
    localspw.a(paramtax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syt
 * JD-Core Version:    0.7.0.1
 */