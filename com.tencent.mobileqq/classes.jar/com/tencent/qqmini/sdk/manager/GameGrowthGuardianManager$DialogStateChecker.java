package com.tencent.qqmini.sdk.manager;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class GameGrowthGuardianManager$DialogStateChecker
{
  private final GameGrowthGuardianManager.GuardInstructionDialog a;
  private final GameGrowthGuardianManager.DialogStateChecker.Callback b;
  private int c = 0;
  private boolean d = false;
  private final Handler e = new GameGrowthGuardianManager.DialogStateChecker.1(this, Looper.getMainLooper());
  
  public GameGrowthGuardianManager$DialogStateChecker(@NonNull GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog, @NonNull GameGrowthGuardianManager.DialogStateChecker.Callback paramCallback)
  {
    this.a = paramGuardInstructionDialog;
    this.b = paramCallback;
  }
  
  private void c()
  {
    if (!d())
    {
      this.c += 1;
      if (this.c >= 4)
      {
        this.b.onDialogStateInvalid();
        return;
      }
      this.e.sendEmptyMessageDelayed(10001, 2000L);
      return;
    }
    this.e.sendEmptyMessageDelayed(10001, 5000L);
  }
  
  private boolean d()
  {
    Object localObject = this.a.getDialog();
    boolean bool1;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localObject != null) && (((Dialog)localObject).getWindow() != null) && (((Dialog)localObject).getWindow().getDecorView().isShown())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isDialogStateValid: Dialog=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", showing=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", viewShowing=");
    ((StringBuilder)localObject).append(bool2);
    QMLog.d("GameGrowthGuardianManager", ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  void a()
  {
    if (this.d) {
      return;
    }
    if (!this.e.hasMessages(10001)) {
      this.e.sendEmptyMessageDelayed(10001, 2000L);
    }
  }
  
  void b()
  {
    this.e.removeMessages(10001);
    this.c = 0;
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.DialogStateChecker
 * JD-Core Version:    0.7.0.1
 */