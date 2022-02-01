import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class moe
  extends mgm
{
  WeakReference<ZimuToolbar> a;
  
  public moe(AppInterface paramAppInterface, Context paramContext, ArrayList<mhm> paramArrayList, HorizontalListView paramHorizontalListView, ZimuToolbar paramZimuToolbar)
  {
    super(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView);
    this.a = new WeakReference(paramZimuToolbar);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    boolean bool1 = false;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      j = getCount();
      i = 1;
      if (i < j)
      {
        mhm localmhm = a(i);
        if ((localmhm != null) && (paramString2.equals(localmhm.a))) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedItem, id[" + paramString2 + "], find[" + bool1 + "], seq[" + paramLong + "], from[" + paramString1 + "], mCurSelectedPosition[" + this.d + "]");
      }
      j = this.d;
      boolean bool2 = a(i);
      if (bool2) {
        a(paramLong, this.d);
      }
      QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedItem end, from[" + paramString1 + "], seq[" + paramLong + "], id[" + paramString2 + "], find[" + bool1 + "], index[" + i + "], Pos[" + j + "->" + this.d + "], selectResult[" + bool2 + "]");
      return;
      i += 1;
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moe
 * JD-Core Version:    0.7.0.1
 */