import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class mol
{
  public static Bitmap a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = bdbk.a(paramQQAppInterface, paramString, (byte)2).a();
    paramString = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramString = bdhj.a();
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Message paramMessage, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    View localView = paramView.findViewById(2131370864);
    TextView localTextView = (TextView)paramView.findViewById(2131370842);
    ImageView localImageView = (ImageView)paramView.findViewById(2131370841);
    int i;
    int j;
    boolean bool;
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      l = ((Long)paramMessage.obj).longValue();
      i = paramQQAppInterface.a().b(l);
      localObject = (LinearLayout)paramView.findViewById(2131370838);
      if (i == 2)
      {
        paramMessage = paramQQAppInterface.a().a(l);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new ImageView[3];
        localObject[0] = ((ImageView)paramView.findViewById(2131362975));
        localObject[1] = ((ImageView)paramView.findViewById(2131362977));
        localObject[2] = ((ImageView)paramView.findViewById(2131362979));
        if ((paramMessage == null) || (paramMessage.size() == 0))
        {
          j = localObject.length;
          i = 0;
        }
        while (i < j)
        {
          localObject[i].setVisibility(8);
          i += 1;
          continue;
          if (paramMessage.size() != 1) {
            break label426;
          }
          localObject[0].setVisibility(0);
          localObject[1].setVisibility(8);
          localObject[2].setVisibility(8);
          localObject[0].setImageBitmap(a(String.valueOf(((lpo)paramMessage.get(0)).a), paramQQAppInterface));
        }
      }
    }
    else
    {
      i = paramQQAppInterface.a().e();
      j = paramQQAppInterface.a().b();
      l = paramQQAppInterface.a().c();
      if (paramQQAppInterface.a().g() != 2) {
        break label577;
      }
      bool = true;
      label292:
      if (QLog.isColorLevel()) {
        QLog.w("MultiVideoBarHelper", 1, "updateMultiVideoBar, randomStatus[" + j + "], sessionType[" + i + "], guildGroupId[" + l + "], getSmallScreenState[" + paramQQAppInterface.a().g() + "]");
      }
      if (l <= 0L) {
        break label695;
      }
      j = paramQQAppInterface.a().d();
      if (j >= 2) {
        break label583;
      }
      localTextView.setText(2131690015);
      mbt.a(localView, bool, paramBoolean);
    }
    label401:
    label925:
    for (;;)
    {
      azqs.a(paramQQAppInterface, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 1, 0, "", "", "", "");
      return;
      label426:
      if (paramMessage.size() == 2)
      {
        localObject[0].setVisibility(0);
        localObject[1].setVisibility(0);
        localObject[2].setVisibility(8);
        localObject[0].setImageBitmap(a(String.valueOf(((lpo)paramMessage.get(0)).a), paramQQAppInterface));
        localObject[1].setImageBitmap(a(String.valueOf(((lpo)paramMessage.get(1)).a), paramQQAppInterface));
        break;
      }
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].setVisibility(0);
        localObject[i].setImageBitmap(a(String.valueOf(((lpo)paramMessage.get(i)).a), paramQQAppInterface));
        i += 1;
      }
      break;
      ((LinearLayout)localObject).setVisibility(0);
      break;
      label577:
      bool = false;
      break label292;
      label583:
      paramView = paramQQAppInterface.a().b();
      if ((paramView != null) && (paramView.equals("1")))
      {
        i = 1;
        label607:
        if (i == 0) {
          break label688;
        }
      }
      label688:
      for (i = 2131696162;; i = 2131696161)
      {
        paramMessage = paramQQAppInterface.getApp().getString(i);
        paramView = paramQQAppInterface.a().e();
        paramMessage = String.format(paramMessage, new Object[] { Integer.valueOf(j) });
        localTextView.setText(paramMessage + " " + paramView);
        break;
        i = 0;
        break label607;
      }
      label695:
      if (j == 6)
      {
        localTextView.setText(paramQQAppInterface.getApp().getString(2131696163));
        mbt.a(localView, bool, paramBoolean);
      }
      else if (j >= 5)
      {
        paramView = paramQQAppInterface.getApp().getString(2131696161);
        paramView = paramView + " ";
        localTextView.setText(paramView + paramQQAppInterface.a().e());
        mbt.a(localView, bool, paramBoolean);
      }
      else if ((j >= 1) && (j < 5))
      {
        localTextView.setText(paramQQAppInterface.getApp().getString(2131695853));
        mbt.a(localView, bool, paramBoolean);
      }
      else
      {
        if ((i != 3) && (i != 4)) {
          break label1312;
        }
        l = paramQQAppInterface.a().b();
        i = paramQQAppInterface.a().b(l);
        j = paramQQAppInterface.a().f();
        if (!paramQQAppInterface.a().f()) {
          break label989;
        }
        localTextView.setText(2131690015);
        if ((i == 2) && (!paramQQAppInterface.a().a(String.valueOf(l)))) {
          localImageView.setImageDrawable(null);
        }
        if (j != 1) {
          break label1254;
        }
        paramMessage = paramQQAppInterface.getApp().getString(2131693067);
        paramView = paramMessage;
        if (i == 2) {
          paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131720917), paramQQAppInterface.getApp().getString(2131720918));
        }
        mww.a(localView, paramView);
        label978:
        mbt.a(localView, bool, paramBoolean);
      }
    }
    label989:
    long l = paramQQAppInterface.a().b();
    int k = paramQQAppInterface.a().a();
    Object localObject = paramQQAppInterface.a().e();
    if (j == 3000)
    {
      paramMessage = paramQQAppInterface.getApp().getString(2131690006);
      paramView = paramMessage;
      if (i == 2) {
        paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131720917), paramQQAppInterface.getApp().getString(2131720918));
      }
    }
    label1254:
    label1532:
    for (;;)
    {
      l = paramQQAppInterface.a().a(k, l);
      if ((localView != null) && (l == 0L))
      {
        mbt.a(localView, false, paramBoolean);
        return;
        if (j == 1)
        {
          paramView = paramQQAppInterface.getApp().getString(2131689999);
          if (i != 2) {
            break label1532;
          }
          paramView = paramView.replace(paramQQAppInterface.getApp().getString(2131720917), paramQQAppInterface.getApp().getString(2131720918));
          localImageView.setImageDrawable(null);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MultiVideoBarHelper", 2, "updateMultiVideoBar-->wrong type of UinType.uintype=" + j);
        return;
      }
      if (localView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiVideoBarHelper", 2, "updateMultiVideoBar-->multiVideoBar is null");
        return;
      }
      paramView = String.format(paramView, new Object[] { Long.valueOf(l) });
      localTextView.setText(paramView + " " + (String)localObject);
      break label925;
      if (j != 3000) {
        break label978;
      }
      paramMessage = paramQQAppInterface.getApp().getString(2131693066);
      paramView = paramMessage;
      if (i == 2) {
        paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131720917), paramQQAppInterface.getApp().getString(2131720918));
      }
      mww.a(localView, paramView);
      break label978;
      if (i == 1)
      {
        if (paramQQAppInterface.a().f()) {
          localTextView.setText(2131696441);
        }
        for (;;)
        {
          mww.a(localView, paramQQAppInterface.getApp().getString(2131690322));
          mbt.a(localView, bool, paramBoolean);
          break;
          paramView = paramQQAppInterface.a().e();
          paramMessage = paramQQAppInterface.getApp().getString(2131695844);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      if ((i == 2) && (!paramQQAppInterface.a().k()))
      {
        if (paramQQAppInterface.a().f()) {
          localTextView.setText(2131696441);
        }
        for (;;)
        {
          mww.a(localView, paramQQAppInterface.getApp().getString(2131690322));
          mbt.a(localView, bool, paramBoolean);
          break;
          paramView = paramQQAppInterface.a().e();
          paramMessage = paramQQAppInterface.getApp().getString(2131696415);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      mbt.a(localView, false, paramBoolean);
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mol
 * JD-Core Version:    0.7.0.1
 */