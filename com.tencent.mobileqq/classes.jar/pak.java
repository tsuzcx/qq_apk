import android.view.View;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class pak
  implements ActionSheet.OnButtonClickListener
{
  public pak(PubAccountMailJsPlugin paramPubAccountMailJsPlugin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.a.dismiss();
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMailJsPlugin", 2, String.format("Unknow button %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
    case 0: 
      PubAccountMailJsPlugin.a(this.a);
      return;
    case 1: 
      PubAccountMailJsPlugin.b(this.a);
      return;
    case 2: 
      PubAccountMailJsPlugin.c(this.a);
      return;
    }
    PubAccountMailJsPlugin.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pak
 * JD-Core Version:    0.7.0.1
 */