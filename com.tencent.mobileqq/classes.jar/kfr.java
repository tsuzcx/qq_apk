import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.common.app.AppInterface;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class kfr
  extends QAVPtvTemplateAdapter
{
  WeakReference a;
  
  public kfr(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, HorizontalListView paramHorizontalListView, ZimuToolbar paramZimuToolbar)
  {
    super(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView);
    this.a = new WeakReference(paramZimuToolbar);
  }
  
  public void a(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = getCount();
      i = 1;
      if (i < j)
      {
        QavListItemBase.ItemInfo localItemInfo = a(i);
        if ((localItemInfo == null) || (!paramString.equals(localItemInfo.a))) {}
      }
    }
    for (;;)
    {
      a(i);
      c(this.c);
      return;
      i += 1;
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kfr
 * JD-Core Version:    0.7.0.1
 */