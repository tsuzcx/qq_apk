import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class syi
  extends DownloadIconsListener
{
  public syi(Leba paramLeba) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("DownloadIconsListener onDownloadSuc, key=").append(paramString).append(", bitmap is null?");
      if (paramBitmap == null)
      {
        bool1 = true;
        QLog.d("Q.lebatab.leba", 2, bool1);
      }
    }
    else
    {
      int j = this.a.a.getCount();
      i = 0;
      bool1 = bool2;
      label73:
      if (i >= j) {
        break label230;
      }
      localObject = (LebaViewItem)this.a.a.getItem(i);
      if ((localObject == null) || (((LebaViewItem)localObject).a == null) || (!paramString.equals(((LebaViewItem)localObject).a.strPkgName)) || (paramBitmap == null)) {
        break label250;
      }
      File localFile = LebaUtil.a(this.a.a(), paramString, ((LebaViewItem)localObject).a.strResURL);
      if (localFile != null)
      {
        ((LebaViewItem)localObject).b = ("LebaIcon://" + localFile.getAbsolutePath());
        if ((BaseApplicationImpl.sImageHashMap != null) && (BaseApplicationImpl.sImageHashMap.get(((LebaViewItem)localObject).b) == null)) {
          BaseApplicationImpl.sImageHashMap.put(((LebaViewItem)localObject).b, paramBitmap);
        }
      }
      bool1 = true;
    }
    label230:
    label250:
    for (;;)
    {
      i += 1;
      break label73;
      bool1 = false;
      break;
      this.a.a(new syj(this, paramString, paramBitmap, bool1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syi
 * JD-Core Version:    0.7.0.1
 */