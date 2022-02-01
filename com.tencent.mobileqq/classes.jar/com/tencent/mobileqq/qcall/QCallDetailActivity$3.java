package com.tencent.mobileqq.qcall;

import android.text.TextUtils;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QCallDetailActivity$3
  extends DiscussionObserver
{
  QCallDetailActivity$3(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((((ArrayList)paramObject).indexOf(QCallDetailActivity.b(this.a)) != -1) && (paramBoolean) && (QCallDetailActivity.a(this.a) == 3000))
    {
      paramObject = this.a;
      paramObject.a(QCallDetailActivity.b(paramObject));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((QCallDetailActivity.b(this.a) != null) && (QCallDetailActivity.b(this.a).equals(paramString)) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" === onUpdateDiscussionFaceIcon isSuccess | ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", disUin | ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",isComplete | ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("QCallDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) && (paramBoolean2) && (QCallDetailActivity.b(this.a) != null) && (QCallDetailActivity.a(this.a) == 3000))
    {
      localObject = paramString;
      if (GroupIconHelper.i(paramString)) {
        localObject = GroupIconHelper.h(paramString);
      }
      if (QCallDetailActivity.b(this.a).equals(localObject))
      {
        paramString = this.a;
        paramString.a(QCallDetailActivity.b(paramString));
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, "==== onUpdateDiscussionFaceIcon updateUin ===");
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(QCallDetailActivity.b(this.a))) && (QCallDetailActivity.b(this.a).equals(paramString)) && (!this.a.isFinishing())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */