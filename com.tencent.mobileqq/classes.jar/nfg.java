import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;

class nfg
  implements OnPluginInstallListener
{
  nfg(nff paramnff) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Nfh != null)
    {
      float f = paramInt1 / paramInt2;
      this.a.jdField_a_of_type_Nfh.a(0, 1, (int)(f * 100.0F));
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (this.a.jdField_a_of_type_Nfh != null) {
      this.a.jdField_a_of_type_Nfh.a(paramInt, "Install Error");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (this.a.jdField_a_of_type_Nfh != null) {
      this.a.jdField_a_of_type_Nfh.a(3, 4, 100);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nfg
 * JD-Core Version:    0.7.0.1
 */