package cooperation.qqfav.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class QfavMicroPhoneDialog
  extends QQCustomDialog
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, View.OnClickListener, VoicePlayer.VoicePlayerListener
{
  protected VoicePlayer a;
  protected QfavMicroPhoneDialog.Listener b;
  protected Context c;
  private int d;
  private String e;
  private int f;
  private ImageView g;
  private Button h;
  private EditText i;
  private AnimationDrawable j;
  
  public QfavMicroPhoneDialog(Context paramContext, AppRuntime paramAppRuntime, int paramInt, QfavMicroPhoneDialog.Listener paramListener)
  {
    super(paramContext, 2131953338);
    this.b = paramListener;
    this.c = paramContext;
    this.d = paramInt;
    super.setContentView(2131624626);
    super.setNegativeButton(2131887648, this);
    super.setPositiveButton(2131889171, this);
    super.setTitle(2131886262);
    ((TextView)super.findViewById(2131431880)).setGravity(3);
    paramInt = ViewUtils.dip2px(6.0F);
    int k = ViewUtils.dip2px(16.0F);
    int m = ViewUtils.dip2px(40.0F);
    int n = ViewUtils.dip2px(50.0F);
    paramContext = new LinearLayout(this.c);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramAppRuntime = new LinearLayout.LayoutParams(m, m);
    this.g = new ImageView(this.c);
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    paramContext.addView(this.g, paramAppRuntime);
    this.h = new Button(this.c);
    this.h.setId(2131440790);
    this.h.setTextColor(-1);
    this.h.setBackgroundResource(2130845519);
    this.j = ((AnimationDrawable)this.c.getResources().getDrawable(2130845541));
    this.h.setCompoundDrawablesWithIntrinsicBounds(2130845524, 0, 0, 0);
    this.h.setHeight(n);
    paramContext.addView(this.h);
    super.findViewById(2131431876).setVisibility(8);
    paramAppRuntime = (RelativeLayout)super.findViewById(2131431871);
    paramListener = new RelativeLayout.LayoutParams(0, -2);
    paramListener.addRule(3, 2131431880);
    paramListener.addRule(5, 2131431880);
    paramListener.addRule(7, 2131431880);
    paramListener.bottomMargin = k;
    paramListener.topMargin = paramInt;
    this.i = ((EditText)super.findViewById(2131435808));
    this.i.setHint(2131889177);
    Object localObject = new InputFilter.LengthFilter(60);
    this.i.setFilters(new InputFilter[] { localObject });
    localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    paramContext.setId(2131431340);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131431340);
    paramAppRuntime.addView(paramContext, paramListener);
    this.h.setOnClickListener(this);
    super.setOnDismissListener(this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.h.setCompoundDrawablesWithIntrinsicBounds(2130845524, 0, 0, 0);
    this.j.stop();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a(String paramString, int paramInt, Bitmap paramBitmap, Drawable paramDrawable)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtil.d(paramString)) && (paramInt > 0))
    {
      this.h.setText(PttItemBuilder.a(paramInt));
      this.h.setPadding(ViewUtils.dip2px(20.0F), 0, Math.min(PttItemBuilder.a(this.c, paramInt, null, null, 0), ViewUtils.dip2px(200.0F)), 0);
      if (paramDrawable != null) {
        this.g.setImageDrawable(paramDrawable);
      } else {
        this.g.setImageBitmap(paramBitmap);
      }
      this.e = paramString;
      this.f = paramInt;
      return true;
    }
    return false;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt != 0) && (paramInt == 1))
    {
      paramDialogInterface = this.b;
      if (paramDialogInterface != null) {
        paramDialogInterface.a(this.e, this.f, this.i.getText().toString());
      }
    }
    super.cancel();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131440790)
    {
      VoicePlayer localVoicePlayer = this.a;
      if ((localVoicePlayer != null) && (localVoicePlayer.g() == 2))
      {
        this.a.e();
        this.h.setCompoundDrawablesWithIntrinsicBounds(2130845524, 0, 0, 0);
        this.j.stop();
      }
      else
      {
        localVoicePlayer = this.a;
        if (localVoicePlayer != null) {
          localVoicePlayer.f();
        }
        this.a = new VoicePlayer(this.e, new Handler(), this.d);
        this.a.a(super.getContext());
        this.a.h();
        this.a.a(this);
        this.a.c();
        this.j.stop();
        this.h.setCompoundDrawablesWithIntrinsicBounds(this.j, null, null, null);
        this.j.start();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.j.stop();
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.f();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      super.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavMicroPhoneDialog
 * JD-Core Version:    0.7.0.1
 */