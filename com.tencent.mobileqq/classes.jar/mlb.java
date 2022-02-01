import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.VideoInviteFloatBar.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mlb
  implements View.OnClickListener, View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  Intent jdField_a_of_type_AndroidContentIntent = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoInviteFloatBar.1(this);
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 2131755838;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  
  public mlb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559792, null);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  public TextView a()
  {
    return (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371647);
  }
  
  public void a()
  {
    Log.i("VideoInviteFloatBar", "hide");
    if (!this.jdField_d_of_type_Boolean) {}
    do
    {
      for (;;)
      {
        return;
        this.jdField_d_of_type_Boolean = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoInviteFloatBar", 2, "hide removeView start");
          }
          if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
            this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("VideoInviteFloatBar", 2, "hide removeView end");
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoInviteFloatBar", 2, "hide error : " + localException);
  }
  
  public void a(Bitmap paramBitmap)
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366213)).setImageBitmap(paramBitmap);
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366213)).setImageBitmap(paramBitmap);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371647)).setText(paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370769));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Boolean = paramBoolean3;
    QLog.w("VideoInviteFloatBar", 1, "show, mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], misMultiCall[" + this.jdField_c_of_type_Boolean + "], mIsMultiIncomingCall[" + this.jdField_a_of_type_Boolean + "]");
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370769);
    Button localButton1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361814);
    Button localButton2 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376481);
    localButton1.setClickable(true);
    localButton2.setClickable(true);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    if (paramBoolean3) {
      if (this.jdField_b_of_type_Boolean) {
        localTextView.setText(localTextView.getResources().getString(2131694743));
      }
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_Int <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int * 1000);
      return;
      localTextView.setText(localTextView.getResources().getString(2131694744));
      continue;
      if (this.jdField_b_of_type_Boolean) {
        localTextView.setText(localTextView.getResources().getString(2131694742));
      } else {
        localTextView.setText(localTextView.getResources().getString(2131694745));
      }
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBar", 2, "initTN");
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 2098088;
        if (Build.VERSION.SDK_INT >= 26)
        {
          this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;
          this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
          if (Build.VERSION.SDK_INT >= 19)
          {
            WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
            localLayoutParams.flags |= 0x4000000;
          }
          this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 49;
          if (this.jdField_b_of_type_Int != -1) {
            this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = this.jdField_b_of_type_Int;
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoInviteFloatBar", 2, "startHandler addView start");
        }
        this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        this.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("VideoInviteFloatBar", 2, "startHandler addView end");
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + localIllegalStateException);
        return;
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + localBadTokenException);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + localSecurityException);
        return;
      }
      catch (Exception localException2)
      {
        lbj.e("VideoInviteFloatBar", "startHandler error : " + localException2);
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2010;
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378884));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void c()
  {
    Object localObject = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361814);
    Button localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376481);
    ((Button)localObject).setVisibility(4);
    localButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370769);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370769));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void d(String paramString)
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371647)).setText(paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131361814: 
      l = AudioHelper.b();
      QLog.w("VideoInviteFloatBar", 1, "onClick accept, mIsMultiIncomingCall[" + this.jdField_a_of_type_Boolean + "], misMultiCall[" + this.jdField_c_of_type_Boolean + "], seq[" + l + "]");
      localIntent = new Intent();
      muk.a(localIntent, l);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.setAction("tencent.video.invite.multiaccept");
      }
      for (;;)
      {
        ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361814)).setClickable(false);
        ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376481)).setClickable(false);
        localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
        break;
        if (this.jdField_c_of_type_Boolean) {
          localIntent.setAction("tencent.video.invite.gaaccept");
        } else {
          localIntent.setAction("tencent.video.invite.accept");
        }
      }
    }
    long l = AudioHelper.b();
    QLog.w("VideoInviteFloatBar", 1, "onClick reject, mIsMultiIncomingCall[" + this.jdField_a_of_type_Boolean + "], misMultiCall[" + this.jdField_c_of_type_Boolean + "], seq[" + l + "]");
    Intent localIntent = new Intent();
    muk.a(localIntent, l);
    if (this.jdField_a_of_type_Boolean) {
      localIntent.setAction("tencent.video.invite.multirefuse");
    }
    for (;;)
    {
      localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      a();
      break;
      if (this.jdField_c_of_type_Boolean) {
        localIntent.setAction("tencent.video.invite.gaignore");
      } else {
        localIntent.setAction("tencent.video.invite.refuse");
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
    Log.i("currP", "currX" + this.jdField_c_of_type_Float + "====currY" + this.jdField_d_of_type_Float);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      if (paramMotionEvent.getY() - this.jdField_b_of_type_Float < 0.0F) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlb
 * JD-Core Version:    0.7.0.1
 */