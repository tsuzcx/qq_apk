package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  QQCustomDialog a;
  private QQAppInterface b;
  private BaseActivity c;
  private ActionSheet d;
  private int e = -1;
  private int f = -1;
  private boolean g = false;
  private boolean h = false;
  
  private void a()
  {
    if (this.d != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    LyricsController localLyricsController = ListenTogetherManager.a(this.b).k();
    this.d = ActionSheet.create(this.c);
    boolean bool = ListenTogetherUtils.a();
    if (bool) {
      this.d.addButton(2131891246);
    }
    this.d.addButton(2131891221);
    this.d.addCancelButton(2131887648);
    this.d.setOnDismissListener(new ListenTogetherOverlayFragment.1(this, localLyricsController));
    this.d.setOnCancelListener(new ListenTogetherOverlayFragment.2(this, localLyricsController));
    this.d.setOnButtonClickListener(new ListenTogetherOverlayFragment.3(this, bool, localLyricsController));
    this.d.show();
    localLyricsController.b(true);
    ReportController.b(this.b, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.a != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.a = DialogUtil.a(this.c, 230).setMessage(2131893628).setNegativeButton(2131887648, new ListenTogetherOverlayFragment.5(this)).setPositiveButton(2131893630, new ListenTogetherOverlayFragment.4(this));
    this.a.setTitle(2131893629);
    this.a.setCancelable(false);
    this.a.setCanceledOnTouchOutside(false);
    this.a.show();
  }
  
  private void c()
  {
    if (this.d != null) {
      return;
    }
    if (this.h) {
      return;
    }
    this.h = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.b);
    this.d = ActionSheet.create(this.c);
    this.d.addButton(2131914217);
    this.d.addButton(2131891259, 3);
    this.d.addCancelButton(2131887648);
    this.d.setOnButtonClickListener(new ListenTogetherOverlayFragment.6(this, localListenTogetherManager));
    this.d.setOnDismissListener(new ListenTogetherOverlayFragment.7(this));
    this.d.show();
  }
  
  private void d()
  {
    if (this.a != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.b);
    LyricsController localLyricsController = localListenTogetherManager.k();
    this.a = DialogUtil.a(this.c, 230).setNegativeButton(2131887648, new ListenTogetherOverlayFragment.9(this, localListenTogetherManager, localLyricsController)).setPositiveButton(2131891258, new ListenTogetherOverlayFragment.8(this, localListenTogetherManager, localLyricsController));
    this.a.setTitle(2131891223);
    this.a.setOnDismissListener(new ListenTogetherOverlayFragment.10(this, localListenTogetherManager, localLyricsController));
    this.a.setCanceledOnTouchOutside(false);
    this.a.show();
    localLyricsController.b(true);
  }
  
  private void e()
  {
    if (this.a != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    int i;
    if (this.f == 1) {
      i = 1;
    } else {
      i = 0;
    }
    LyricsController localLyricsController = ListenTogetherManager.a(this.b).k();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.c, 230);
    int j;
    if (i != 0) {
      j = 2131891225;
    } else {
      j = 2131891224;
    }
    this.a = localQQCustomDialog.setMessage(j).setNegativeButton(2131917793, new ListenTogetherOverlayFragment.11(this));
    localQQCustomDialog = this.a;
    if (i != 0) {
      i = 2131891227;
    } else {
      i = 2131891226;
    }
    localQQCustomDialog.setTitle(i);
    this.a.setOnDismissListener(new ListenTogetherOverlayFragment.12(this, localLyricsController));
    this.a.setCanceledOnTouchOutside(false);
    this.a.show();
    localLyricsController.b(true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getBaseActivity().app;
    this.c = getBaseActivity();
    paramBundle = this.c.getIntent();
    if (paramBundle != null)
    {
      this.e = paramBundle.getIntExtra("type", 0);
      this.f = paramBundle.getIntExtra("uinType", -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onDestroy");
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume mType: ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" mHasGotoSetting:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" mUinType:");
      localStringBuilder.append(this.f);
      QLog.d("ListenTogetherOverlayFragment", 2, localStringBuilder.toString());
    }
    int i = this.e;
    if (i == 1)
    {
      a();
      return;
    }
    if (i == 2)
    {
      if (this.g)
      {
        this.c.finish();
        return;
      }
      b();
      return;
    }
    if (i == 3)
    {
      c();
      return;
    }
    if (i == 4)
    {
      e();
      return;
    }
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */