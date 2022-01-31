import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class msi
  extends MqqHandler
{
  public msi(SubscriptFeedsActivity paramSubscriptFeedsActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1002: 
            try
            {
              paramMessage = TroopBarAssistantManager.a().b(this.a.app);
              this.a.runOnUiThread(new msj(this, paramMessage));
              return;
            }
            catch (Exception paramMessage) {}
          }
        } while (!QLog.isColorLevel());
        QLog.i("SubscriptFeedsActivity", 2, paramMessage.toString());
        return;
        this.a.runOnUiThread(new msk(this));
        return;
        paramMessage = paramMessage.getData();
      } while ((paramMessage == null) || (!ReadInJoyHelper.a()));
      paramMessage = paramMessage.getSerializable("ReadInJoyArticleList");
    } while ((paramMessage == null) || (!(paramMessage instanceof ArrayList)));
    if ((!SubscriptFeedsActivity.a(this.a, (ArrayList)paramMessage)) && (QLog.isColorLevel())) {
      QLog.d("SubscriptFeedsActivity", 2, "onGetRecommendReadInJoyArticleList data save to sp fail");
    }
    this.a.runOnUiThread(new msl(this, paramMessage));
    return;
    this.a.runOnUiThread(new msm(this));
    return;
    this.a.runOnUiThread(new msn(this));
    return;
    this.a.runOnUiThread(new mso(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msi
 * JD-Core Version:    0.7.0.1
 */