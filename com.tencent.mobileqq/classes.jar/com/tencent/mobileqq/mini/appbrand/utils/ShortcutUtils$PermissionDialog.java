package com.tencent.mobileqq.mini.appbrand.utils;

import amtj;
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
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ShortcutUtils$PermissionDialog
  extends QQCustomDialog
{
  private static final String CONFIG_SHORTCUT_DIALOG_HIDE = "mini_shortcut_dialog_hide";
  private static final String CONFIG_SHORTCUT_HELP_URL = "mini_shortcut_help_url";
  private static final String URL_SHORTCUT_HELP = "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15";
  private Activity mActivity;
  private CheckBox mCheckBox;
  private ViewGroup mCheckBoxLayout;
  private TextView mCheckText;
  
  public ShortcutUtils$PermissionDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.mActivity = paramActivity;
    initUI();
  }
  
  public static boolean canShowDialog()
  {
    boolean bool = StorageUtil.getPreference().getBoolean("mini_shortcut_dialog_hide", false);
    QLog.i("Shortcut", 1, "load dialog hide config:" + bool);
    return !bool;
  }
  
  public static PermissionDialog createPermissionDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramActivity = new PermissionDialog(paramActivity, 2131755826);
    paramActivity.setTitle(paramString1);
    paramActivity.setNegativeButton(paramString2, paramOnClickListener2);
    paramActivity.setPositiveButton(paramString3, paramOnClickListener1);
    paramActivity.setCanceledOnTouchOutside(false);
    return paramActivity;
  }
  
  public void dismiss()
  {
    boolean bool = this.mCheckBox.isChecked();
    QLog.i("Shortcut", 1, "save dialog hide config:" + bool);
    StorageUtil.getPreference().edit().putBoolean("mini_shortcut_dialog_hide", bool).commit();
    super.dismiss();
  }
  
  public CharSequence getMessageContent()
  {
    String str1 = amtj.a(2131713109);
    String str2 = amtj.a(2131713113);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ShortcutUtils.PermissionDialog.2(this), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-15505507), str1.length(), str1.length() + str2.length(), 33);
    return localSpannableString;
  }
  
  public void initUI()
  {
    setContentView(2131559007);
    this.text.setMovementMethod(LinkMovementMethod.getInstance());
    this.text.setText(getMessageContent());
    this.mCheckBoxLayout = ((ViewGroup)findViewById(2131369651));
    this.mCheckBox = ((CheckBox)findViewById(2131379003));
    this.mCheckText = ((TextView)findViewById(2131379967));
    this.mCheckText.setOnClickListener(new ShortcutUtils.PermissionDialog.1(this));
  }
  
  public void showCheckbox(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.mCheckBoxLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.PermissionDialog
 * JD-Core Version:    0.7.0.1
 */