package com.tencent.mobileqq.troop.homework.entry.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class PublishHomeWorkFragment$2
  extends TroopBusinessObserver
{
  PublishHomeWorkFragment$2(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onAssignHomework(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.onAssignHomework(paramBoolean, paramLong, paramInt);
    this.a.o();
    this.a.a(paramBoolean, paramInt);
  }
  
  public void onGetHomeworkInfo(boolean paramBoolean, HomeworkInfo paramHomeworkInfo)
  {
    super.onGetHomeworkInfo(paramBoolean, paramHomeworkInfo);
    this.a.o();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label79;
      }
    }
    label79:
    for (String str = "成功";; str = "失败")
    {
      QLog.d("PublishHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (paramHomeworkInfo == null) || (paramHomeworkInfo.b == null)) {
        break;
      }
      this.a.a(paramHomeworkInfo);
      return;
    }
    this.a.getActivity().finish();
  }
  
  public void onGetHomeworkTroopIdentity(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.onGetHomeworkTroopIdentity(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onGetHomeworkTroopIdentity: isSuccess:" + paramBoolean + ", identity:" + paramInt + ", course:" + paramString3);
    }
    if (!this.a.j)
    {
      if (!this.a.h) {
        this.a.b(paramString3);
      }
      this.a.a(paramInt, paramString3, paramString4);
      if (!paramBoolean) {
        break label142;
      }
      this.a.a = paramString3;
      this.a.b();
    }
    for (;;)
    {
      QLog.i("PublishHomeWorkFragment", 1, "init data success");
      this.a.f();
      return;
      label142:
      QQToast.a(this.a.getActivity(), HardCodeUtil.a(2131708812), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.2
 * JD-Core Version:    0.7.0.1
 */