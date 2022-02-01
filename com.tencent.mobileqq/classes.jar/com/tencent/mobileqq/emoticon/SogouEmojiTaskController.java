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
  int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private Map<Integer, SogouEmojiTaskController.TaskParam> jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  public SogouEmojiTaskController(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController begins");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController ends");
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
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
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    ((SogouEmojiTaskController.TaskParam)localObject).jdField_a_of_type_JavaLangString = paramString1;
    ((SogouEmojiTaskController.TaskParam)localObject).b = paramString2;
    int i = this.jdField_a_of_type_Int;
    ((SogouEmojiTaskController.TaskParam)localObject).jdField_a_of_type_Int = i;
    paramString1 = this.jdField_a_of_type_JavaUtilMap;
    if (paramString1 != null) {
      paramString1.put(Integer.valueOf(i), localObject);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("func addTask ends, mCurTaskId:");
      paramString1.append(this.jdField_a_of_type_Int);
      QLog.d("SogouEmojiTaskController", 2, paramString1.toString());
    }
    b(2131694878);
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDestroy begins");
    }
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null)
    {
      localMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilMap);
      QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).remove(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func removeTask ends");
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func isTaskInMap begins, taskId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SogouEmojiTaskController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
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
  
  public void b()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  void b(int paramInt)
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
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        c();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setOnDismissListener(new SogouEmojiTaskController.1(this));
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
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
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog begins");
    }
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmojiTaskController
 * JD-Core Version:    0.7.0.1
 */