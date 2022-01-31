import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class rnh
  implements rji
{
  public rnh(ViolaBaseView paramViolaBaseView) {}
  
  public void a()
  {
    String str = rmb.b("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ViolaBaseView.a(), 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      if (!oho.a(str))
      {
        ViolaBaseView.a(this.a, 7);
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.a(), 2, "downLoadSOFromOffline so.zip exists unzip fail");
        }
      }
    }
    do
    {
      do
      {
        return;
        if ((amzt.i()) && (amzs.i()))
        {
          ViolaBaseView.b(this.a, ViolaBaseView.c());
          return;
        }
        ViolaBaseView.a(this.a, 8);
      } while (!QLog.isColorLevel());
      QLog.e(ViolaBaseView.a(), 2, "downLoadSOFromOffline so.zip succ but not Exist");
      return;
      ViolaBaseView.a(this.a, 8);
    } while (!QLog.isColorLevel());
    QLog.e(ViolaBaseView.a(), 2, "downLoadSOFromOffline so.zip not exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
  }
  
  public void a(int paramInt) {}
  
  public void b()
  {
    ViolaBaseView.a(this.a, 6);
    if (QLog.isColorLevel()) {
      QLog.e(ViolaBaseView.a(), 2, "downLoadSOFromOffline [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnh
 * JD-Core Version:    0.7.0.1
 */