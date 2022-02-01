package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

class ShortcutUtils$PermissionDialog
  extends QQCustomDialog
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ShortcutUtils$PermissionDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  public static PermissionDialog a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramActivity = new PermissionDialog(paramActivity, 2131756189);
    paramActivity.setTitle(paramString1);
    paramActivity.setNegativeButton(paramString2, paramOnClickListener2);
    paramActivity.setPositiveButton(paramString3, paramOnClickListener1);
    paramActivity.setCanceledOnTouchOutside(false);
    return paramActivity;
  }
  
  public static boolean a()
  {
    boolean bool = StorageUtil.getPreference().getBoolean("mini_shortcut_dialog_hide", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load dialog hide config:");
    localStringBuilder.append(bool);
    QLog.i("Shortcut", 1, localStringBuilder.toString());
    return bool ^ true;
  }
  
  public CharSequence a()
  {
    String str1 = HardCodeUtil.a(2131713883);
    String str2 = HardCodeUtil.a(2131713887);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(str2);
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    ((SpannableString)localObject).setSpan(new ShortcutUtils.PermissionDialog.2(this), str1.length(), str1.length() + str2.length(), 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-15505507), str1.length(), str1.length() + str2.length(), 33);
    return localObject;
  }
  
  public void a()
  {
    setContentView(2131558969);
    this.text.setMovementMethod(LinkMovementMethod.getInstance());
    this.text.setText(a());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369767));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131379059));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380017));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ShortcutUtils.PermissionDialog.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localViewGroup.setVisibility(i);
  }
  
  public void dismiss()
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("save dialog hide config:");
    localStringBuilder.append(bool);
    QLog.i("Shortcut", 1, localStringBuilder.toString());
    StorageUtil.getPreference().edit().putBoolean("mini_shortcut_dialog_hide", bool).commit();
    super.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.PermissionDialog
 * JD-Core Version:    0.7.0.1
 */