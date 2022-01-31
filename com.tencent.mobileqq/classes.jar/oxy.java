import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.handlers.DailyHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.Map;

public class oxy
  extends oxx
{
  public int a()
  {
    return 3;
  }
  
  public void a(View paramView, ListView paramListView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ArticleInfo)a((int)paramLong);
    if (oou.c(b())) {
      if (!onh.a(paramAdapterView)) {
        break label35;
      }
    }
    label35:
    for (paramInt = 4;; paramInt = 2)
    {
      olj.a(paramInt);
      return;
    }
  }
  
  public void a(Map<Long, qao> paramMap, boolean paramBoolean)
  {
    super.a(paramMap, paramBoolean);
    if (oou.c(b()))
    {
      paramMap = a();
      if (bhvy.v()) {
        break label36;
      }
      QLog.d("DailyHandler", 1, "detachFromViewGroup,now cmd is 0x68b");
    }
    label36:
    while (paramMap == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DailyHandler.1(this, paramMap.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxy
 * JD-Core Version:    0.7.0.1
 */