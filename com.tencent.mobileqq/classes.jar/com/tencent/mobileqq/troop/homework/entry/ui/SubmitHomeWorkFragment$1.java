package com.tencent.mobileqq.troop.homework.entry.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class SubmitHomeWorkFragment$1
  extends TroopBusinessObserver
{
  SubmitHomeWorkFragment$1(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onGetHomeworkInfo(boolean paramBoolean, HomeworkInfo paramHomeworkInfo)
  {
    super.onGetHomeworkInfo(paramBoolean, paramHomeworkInfo);
    this.a.l();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label123;
      }
    }
    for (String str = "成功";; str = "失败")
    {
      QLog.d("SubmitHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (paramHomeworkInfo == null) || (paramHomeworkInfo.b == null)) {
        break;
      }
      this.a.a = paramHomeworkInfo;
      paramHomeworkInfo = paramHomeworkInfo.b;
      try
      {
        paramHomeworkInfo = new JSONObject(paramHomeworkInfo).getJSONArray("c");
        paramHomeworkInfo = new JSONObject().put("c", paramHomeworkInfo).toString();
        this.a.a(paramHomeworkInfo);
        return;
      }
      catch (Exception paramHomeworkInfo)
      {
        label123:
        this.a.a(3, null, null, null);
        return;
      }
    }
    this.a.a(3, null, null, null);
    this.a.a = null;
    this.a.getActivity().finish();
  }
  
  public void onSubmitHomework(boolean paramBoolean, int paramInt)
  {
    super.onSubmitHomework(paramBoolean, paramInt);
    this.a.l();
    if (paramBoolean)
    {
      this.a.g();
      return;
    }
    if (paramInt == 1002)
    {
      this.a.a(2, null, null, null);
      return;
    }
    if (paramInt == 10022)
    {
      this.a.a(1, null, null, null);
      return;
    }
    this.a.a(3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.1
 * JD-Core Version:    0.7.0.1
 */