package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SogouEmojiTaskController
{
  int a;
  private ProgressDialog b;
  private TextView c = null;
  private Map<Integer, SogouEmojiTaskController.TaskParam> d;
  private AtomicInteger e;
  private Activity f;
  
  public SogouEmojiTaskController(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController begins");
    }
    this.f = paramActivity;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController ends");
    }
  }
  
  private void d()
  {
    this.e = new AtomicInteger(0);
    this.d = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func addTask begins, packId:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",exprId:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new SogouEmojiTaskController.TaskParam();
    this.a = this.e.addAndGet(1);
    ((SogouEmojiTaskController.TaskParam)localObject).b = paramString1;
    ((SogouEmojiTaskController.TaskParam)localObject).c = paramString2;
    int i = this.a;
    ((SogouEmojiTaskController.TaskParam)localObject).a = i;
    paramString1 = this.d;
    if (paramString1 != null) {
      paramString1.put(Integer.valueOf(i), localObject);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("func addTask ends, mCurTaskId:");
      paramString1.append(this.a);
      QLog.d("SogouEmojiTaskController", 2, paramString1.toString());
    }
    c(2131892581);
    return this.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDestroy begins");
    }
    Map localMap = this.d;
    if (localMap != null)
    {
      localMap.clear();
      this.d = null;
    }
    this.f = null;
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDestroy ends");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func removeTask begins, taskId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",mEmojiTaskHashMap:");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((Map)localObject).remove(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func removeTask ends");
    }
  }
  
  public void b()
  {
    Map localMap = this.d;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func isTaskInMap begins, taskId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d;
    boolean bool = false;
    if (localObject != null)
    {
      if ((SogouEmojiTaskController.TaskParam)((Map)localObject).get(Integer.valueOf(paramInt)) != null) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func isTaskInMap ends, taskId:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(",exists=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func isTaskInMap ends, taskId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" NOT exist, cause map is null.");
      QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog begins");
    }
    ProgressDialog localProgressDialog = this.b;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.b.cancel();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog ends");
    }
  }
  
  void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("func showProgressDialog begins, textResId:");
      localStringBuilder1.append(paramInt);
      QLog.d("SogouEmojiTaskController", 2, localStringBuilder1.toString());
    }
    try
    {
      if (this.b != null)
      {
        c();
      }
      else
      {
        this.b = new ReportProgressDialog(this.f, 2131953338);
        this.b.setOnDismissListener(new SogouEmojiTaskController.1(this));
        this.b.setCancelable(true);
        this.b.show();
        this.b.setContentView(2131625585);
        this.c = ((TextView)this.b.findViewById(2131440191));
      }
      this.c.setText(paramInt);
      if (!this.b.isShowing()) {
        this.b.show();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("func showProgressDialog ends, ERROR! msg:");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.d("SogouEmojiTaskController", 2, localStringBuilder2.toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmojiTaskController
 * JD-Core Version:    0.7.0.1
 */