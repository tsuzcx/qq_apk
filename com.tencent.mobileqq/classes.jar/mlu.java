import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class mlu
{
  public static Bitmap a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FaceDrawable.getUserFaceDrawable(paramQQAppInterface, paramString, (byte)2).getLoadedBitmap();
    paramString = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramString = bfvo.a();
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Message paramMessage, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    View localView = paramView.findViewById(2131371500);
    TextView localTextView = (TextView)paramView.findViewById(2131371479);
    ImageView localImageView = (ImageView)paramView.findViewById(2131371478);
    int i;
    int j;
    boolean bool;
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      l = ((Long)paramMessage.obj).longValue();
      i = paramQQAppInterface.getAVNotifyCenter().b(l);
      localObject = (LinearLayout)paramView.findViewById(2131371475);
      if (i == 2)
      {
        paramMessage = paramQQAppInterface.getAVNotifyCenter().a(l);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new ImageView[3];
        localObject[0] = ((ImageView)paramView.findViewById(2131363128));
        localObject[1] = ((ImageView)paramView.findViewById(2131363130));
        localObject[2] = ((ImageView)paramView.findViewById(2131363132));
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
          localObject[0].setImageBitmap(a(String.valueOf(((lmq)paramMessage.get(0)).a), paramQQAppInterface));
        }
      }
    }
    else
    {
      i = paramQQAppInterface.getAVNotifyCenter().e();
      j = paramQQAppInterface.getAVNotifyCenter().b();
      l = paramQQAppInterface.getAVNotifyCenter().c();
      if (paramQQAppInterface.getAVNotifyCenter().g() != 2) {
        break label577;
      }
      bool = true;
      label292:
      if (QLog.isColorLevel()) {
        QLog.w("MultiVideoBarHelper", 1, "updateMultiVideoBar, randomStatus[" + j + "], sessionType[" + i + "], guildGroupId[" + l + "], getSmallScreenState[" + paramQQAppInterface.getAVNotifyCenter().g() + "]");
      }
      if (l <= 0L) {
        break label695;
      }
      j = paramQQAppInterface.getAVNotifyCenter().d();
      if (j >= 2) {
        break label583;
      }
      localTextView.setText(2131689927);
      lzb.a(localView, bool, paramBoolean);
    }
    label401:
    label925:
    for (;;)
    {
      bcef.a(paramQQAppInterface, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 1, 0, "", "", "", "");
      return;
      label426:
      if (paramMessage.size() == 2)
      {
        localObject[0].setVisibility(0);
        localObject[1].setVisibility(0);
        localObject[2].setVisibility(8);
        localObject[0].setImageBitmap(a(String.valueOf(((lmq)paramMessage.get(0)).a), paramQQAppInterface));
        localObject[1].setImageBitmap(a(String.valueOf(((lmq)paramMessage.get(1)).a), paramQQAppInterface));
        break;
      }
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].setVisibility(0);
        localObject[i].setImageBitmap(a(String.valueOf(((lmq)paramMessage.get(i)).a), paramQQAppInterface));
        i += 1;
      }
      break;
      ((LinearLayout)localObject).setVisibility(0);
      break;
      label577:
      bool = false;
      break label292;
      label583:
      paramView = paramQQAppInterface.getAVNotifyCenter().b();
      if ((paramView != null) && (paramView.equals("1")))
      {
        i = 1;
        label607:
        if (i == 0) {
          break label688;
        }
      }
      label688:
      for (i = 2131695223;; i = 2131695222)
      {
        paramMessage = paramQQAppInterface.getApp().getString(i);
        paramView = paramQQAppInterface.getAVNotifyCenter().e();
        paramMessage = String.format(paramMessage, new Object[] { Integer.valueOf(j) });
        localTextView.setText(paramMessage + " " + paramView);
        break;
        i = 0;
        break label607;
      }
      label695:
      if (j == 6)
      {
        localTextView.setText(paramQQAppInterface.getApp().getString(2131695224));
        lzb.a(localView, bool, paramBoolean);
      }
      else if (j >= 5)
      {
        paramView = paramQQAppInterface.getApp().getString(2131695222);
        paramView = paramView + " ";
        localTextView.setText(paramView + paramQQAppInterface.getAVNotifyCenter().e());
        lzb.a(localView, bool, paramBoolean);
      }
      else if ((j >= 1) && (j < 5))
      {
        localTextView.setText(paramQQAppInterface.getApp().getString(2131694911));
        lzb.a(localView, bool, paramBoolean);
      }
      else
      {
        if ((i != 3) && (i != 4)) {
          break label1313;
        }
        l = paramQQAppInterface.getAVNotifyCenter().b();
        i = paramQQAppInterface.getAVNotifyCenter().b(l);
        j = paramQQAppInterface.getAVNotifyCenter().f();
        if (!paramQQAppInterface.getAVNotifyCenter().f()) {
          break label989;
        }
        localTextView.setText(2131689927);
        if ((i == 2) && (!paramQQAppInterface.getAVNotifyCenter().a(String.valueOf(l)))) {
          localImageView.setImageDrawable(null);
        }
        if (j != 1) {
          break label1254;
        }
        paramMessage = paramQQAppInterface.getApp().getString(2131692639);
        paramView = paramMessage;
        if (i == 2) {
          paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719034), paramQQAppInterface.getApp().getString(2131719035));
        }
        mum.a(localView, paramView);
        label978:
        lzb.a(localView, bool, paramBoolean);
      }
    }
    label989:
    long l = paramQQAppInterface.getAVNotifyCenter().b();
    int k = paramQQAppInterface.getAVNotifyCenter().a();
    Object localObject = paramQQAppInterface.getAVNotifyCenter().e();
    if (j == 3000)
    {
      paramMessage = paramQQAppInterface.getApp().getString(2131689919);
      paramView = paramMessage;
      if (i == 2) {
        paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719034), paramQQAppInterface.getApp().getString(2131719035));
      }
    }
    label1254:
    label1533:
    for (;;)
    {
      l = paramQQAppInterface.getAVNotifyCenter().a(k, l);
      if ((localView != null) && (l == 0L))
      {
        lzb.a(localView, false, paramBoolean);
        return;
        if (j == 1)
        {
          paramView = paramQQAppInterface.getApp().getString(2131689912);
          if (i != 2) {
            break label1533;
          }
          paramView = paramView.replace(paramQQAppInterface.getApp().getString(2131719034), paramQQAppInterface.getApp().getString(2131719035));
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
      paramMessage = paramQQAppInterface.getApp().getString(2131692638);
      paramView = paramMessage;
      if (i == 2) {
        paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719034), paramQQAppInterface.getApp().getString(2131719035));
      }
      mum.a(localView, paramView);
      break label978;
      if (i == 1)
      {
        if (paramQQAppInterface.getAVNotifyCenter().f()) {
          localTextView.setText(2131695505);
        }
        for (;;)
        {
          mum.a(localView, paramQQAppInterface.getApp().getString(2131690189));
          lzb.a(localView, bool, paramBoolean);
          break;
          paramView = paramQQAppInterface.getAVNotifyCenter().e();
          paramMessage = paramQQAppInterface.getApp().getString(2131694902);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      if ((i == 2) && (!paramQQAppInterface.getAVNotifyCenter().k()))
      {
        if (paramQQAppInterface.getAVNotifyCenter().f()) {
          localTextView.setText(2131695505);
        }
        for (;;)
        {
          mum.a(localView, paramQQAppInterface.getApp().getString(2131690189));
          lzb.a(localView, bool, paramBoolean);
          break;
          paramView = paramQQAppInterface.getAVNotifyCenter().e();
          paramMessage = paramQQAppInterface.getApp().getString(2131695479);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      lzb.a(localView, false, paramBoolean);
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlu
 * JD-Core Version:    0.7.0.1
 */