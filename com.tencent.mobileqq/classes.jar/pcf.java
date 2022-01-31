import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.qphone.base.util.QLog;

public class pcf
  implements DialogInterface.OnClickListener
{
  public pcf(PubAccountMailJsPlugin paramPubAccountMailJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!TextUtils.isEmpty(this.a.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMailJsPlugin", 2, String.format("Contact menu dialog click phone = %s, which = %d", new Object[] { this.a.a, Integer.valueOf(paramInt) }));
      }
      switch (paramInt)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMailJsPlugin", 2, String.format("Unknow contact button %d", new Object[] { Integer.valueOf(paramInt) }));
        }
        break;
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      PubAccountMailJsPlugin.e(this.a);
      return;
      PubAccountMailJsPlugin.f(this.a);
      return;
    }
    QLog.d("PubAccountMailJsPlugin", 2, "phone is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcf
 * JD-Core Version:    0.7.0.1
 */