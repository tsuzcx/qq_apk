import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class syu
  extends DownloadIconsListener
{
  public syu(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int k = 0;
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {}
    label241:
    label242:
    for (;;)
    {
      return;
      int m = LebaListMgrActivity.a(this.a).getCount();
      int j = 0;
      int i = k;
      if (j < m)
      {
        Object localObject = LebaListMgrActivity.a(this.a).getItem(j);
        if ((localObject != null) && ((localObject instanceof LebaViewItem)))
        {
          localObject = (LebaViewItem)localObject;
          if ((((LebaViewItem)localObject).a != null) && (paramString.equals(((LebaViewItem)localObject).a.strPkgName)))
          {
            j = 1;
            File localFile = LebaUtil.a(this.a, paramString, ((LebaViewItem)localObject).a.strResURL);
            i = j;
            if (localFile == null) {
              break label241;
            }
            i = j;
            if (paramBitmap == null) {
              break label241;
            }
            ((LebaViewItem)localObject).b = ("LebaIcon://" + localFile.getAbsolutePath());
            i = j;
            if (BaseApplicationImpl.sImageHashMap == null) {
              break label241;
            }
            i = j;
            if (BaseApplicationImpl.sImageHashMap.get(((LebaViewItem)localObject).b) != null) {
              break label241;
            }
            BaseApplicationImpl.sImageHashMap.put(((LebaViewItem)localObject).b, paramBitmap);
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label242;
        }
        this.a.runOnUiThread(new syv(this, paramString));
        return;
        j += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syu
 * JD-Core Version:    0.7.0.1
 */