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
  private int jdField_a_of_type_Int;
  protected Context a;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected VoicePlayer a;
  protected QfavMicroPhoneDialog.Listener a;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public QfavMicroPhoneDialog(Context paramContext, AppRuntime paramAppRuntime, int paramInt, QfavMicroPhoneDialog.Listener paramListener)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_CooperationQqfavWidgetQfavMicroPhoneDialog$Listener = paramListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    super.setContentView(2131558993);
    super.setNegativeButton(2131690728, this);
    super.setPositiveButton(2131692184, this);
    super.setTitle(2131689651);
    ((TextView)super.findViewById(2131365648)).setGravity(3);
    paramInt = ViewUtils.a(6.0F);
    int i = ViewUtils.a(16.0F);
    int j = ViewUtils.a(40.0F);
    int k = ViewUtils.a(50.0F);
    paramContext = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramAppRuntime = new LinearLayout.LayoutParams(j, j);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramContext.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAppRuntime);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131373181);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130844202);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844224));
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130844207, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setHeight(k);
    paramContext.addView(this.jdField_a_of_type_AndroidWidgetButton);
    super.findViewById(2131365644).setVisibility(8);
    paramAppRuntime = (RelativeLayout)super.findViewById(2131365640);
    paramListener = new RelativeLayout.LayoutParams(0, -2);
    paramListener.addRule(3, 2131365648);
    paramListener.addRule(5, 2131365648);
    paramListener.addRule(7, 2131365648);
    paramListener.bottomMargin = i;
    paramListener.topMargin = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131368874));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131692190);
    Object localObject = new InputFilter.LengthFilter(60);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localObject });
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
    paramContext.setId(2131365179);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131365179);
    paramAppRuntime.addView(paramContext, paramListener);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    super.setOnDismissListener(this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130844207, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a(String paramString, int paramInt, Bitmap paramBitmap, Drawable paramDrawable)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtil.b(paramString)) && (paramInt > 0))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(PttItemBuilder.a(paramInt));
      this.jdField_a_of_type_AndroidWidgetButton.setPadding(ViewUtils.a(20.0F), 0, Math.min(PttItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramInt, null, null, 0), ViewUtils.a(200.0F)), 0);
      if (paramDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.b = paramInt;
      return true;
    }
    return false;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt != 0) && (paramInt == 1))
    {
      paramDialogInterface = this.jdField_a_of_type_CooperationQqfavWidgetQfavMicroPhoneDialog$Listener;
      if (paramDialogInterface != null) {
        paramDialogInterface.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      }
    }
    super.cancel();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373181)
    {
      VoicePlayer localVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
      if ((localVoicePlayer != null) && (localVoicePlayer.a() == 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.d();
        this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130844207, 0, 0, 0);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      }
      else
      {
        localVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
        if (localVoicePlayer != null) {
          localVoicePlayer.e();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(super.getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
        this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable, null, null, null);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (paramDialogInterface != null) {
      paramDialogInterface.e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavMicroPhoneDialog
 * JD-Core Version:    0.7.0.1
 */