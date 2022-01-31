import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.biz.widgets.ScannerView.FlashLightListener;
import com.tencent.biz.widgets.ScannerView.ScannerListener;

public class pio
  extends Handler
{
  public pio(ScannerView paramScannerView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      paramMessage = Toast.makeText(this.a.getContext(), this.a.getContext().getString(2131429921), 1);
      paramMessage.setGravity(17, 0, 0);
      paramMessage.show();
    }
    Object localObject;
    do
    {
      return;
      localObject = ScannerView.a(this.a);
      if (localObject != null) {}
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        localObject = ScannerView.a(this.a);
        if (localObject != null) {}
        switch (paramMessage.what)
        {
        default: 
          localObject = ScannerView.a(this.a);
        }
        break;
      }
    } while (localObject == null);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ((ScannerView.FlashLightListener)localObject).a(bool);
      return;
      ((ScannerView.ScannerListener)localObject).b(String.valueOf(paramMessage.obj));
      return;
      ((ScannerView.ScannerListener)localObject).d();
      return;
      ((ScannerView.ScannerListener)localObject).c();
      return;
      ((ScannerView.ScannerListener)localObject).b();
      return;
      ((ScannerView.FileDecodeListener)localObject).a(String.valueOf(paramMessage.obj));
      return;
      ((ScannerView.FileDecodeListener)localObject).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pio
 * JD-Core Version:    0.7.0.1
 */