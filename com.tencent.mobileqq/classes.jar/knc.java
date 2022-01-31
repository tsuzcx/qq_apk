import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.biz.huanjiplugin.HuanjiPluginProxy;
import com.tencent.biz.huanjiplugin.HuanjiPluginStartListener;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;

public class knc
  implements OnPluginInstallListener
{
  public knc(HuanjiPluginProxy paramHuanjiPluginProxy) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener != null)
    {
      float f = paramInt1 / paramInt2;
      this.a.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener.a(0, 1, (int)(f * 100.0F));
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener != null) {
      this.a.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener.a(paramInt, "Install Error");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener != null) {
      this.a.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener.a(3, 4, 100);
    }
    if (this.a.jdField_a_of_type_Int == 2)
    {
      paramString = new Intent(BaseApplicationImpl.getApplication().getApplicationContext(), TranslucentActivty.class);
      paramString.addFlags(268435456);
      paramString.putExtras(paramString);
      paramString.putExtra("startParam", this.a.jdField_a_of_type_JavaLangString);
      BaseApplicationImpl.getApplication().getApplicationContext().startActivity(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knc
 * JD-Core Version:    0.7.0.1
 */