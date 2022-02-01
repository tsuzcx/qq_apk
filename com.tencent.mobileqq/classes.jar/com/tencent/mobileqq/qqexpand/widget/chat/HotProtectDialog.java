package com.tencent.mobileqq.qqexpand.widget.chat;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class HotProtectDialog
  extends QQCustomDialog
{
  private final QBaseActivity a;
  private ImageView b;
  private TextView c;
  private Button d;
  private TextView e;
  
  public HotProtectDialog(@NonNull QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity, 2131953338);
    this.a = paramQBaseActivity;
    a();
  }
  
  private void a()
  {
    try
    {
      View localView = LayoutInflater.from(this.a).inflate(2131627399, null);
      this.b = ((ImageView)localView.findViewById(2131428999));
      this.c = ((TextView)localView.findViewById(2131439303));
      this.d = ((Button)localView.findViewById(2131439180));
      this.e = ((TextView)localView.findViewById(2131447062));
      setContentView(localView);
      setCancelable(false);
      return;
    }
    catch (InflateException localInflateException)
    {
      label77:
      break label77;
    }
    hide();
    QLog.e("HotProtectDialog", 1, "InflateException, OutOfMemoryError, hide HotProtectDialog");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void a(@NonNull String paramString)
  {
    paramString = FaceDrawable.getStrangerFaceDrawable((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), 200, paramString, true);
    this.b.setImageDrawable(paramString);
  }
  
  public void b(@NonNull String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void c(@NonNull String paramString)
  {
    this.e.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.chat.HotProtectDialog
 * JD-Core Version:    0.7.0.1
 */