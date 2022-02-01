package com.tencent.mobileqq.troop.homework.entry.ui;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class SubmitHomeWorkFragment$1
  extends HomeworkObserver
{
  SubmitHomeWorkFragment$1(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.a.m();
    if (paramBoolean)
    {
      this.a.h();
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
  
  public void a(boolean paramBoolean, HomeworkInfo paramHomeworkInfo)
  {
    super.a(paramBoolean, paramHomeworkInfo);
    this.a.m();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("获取作业信息");
      String str;
      if (paramBoolean) {
        str = "成功";
      } else {
        str = "失败";
      }
      localStringBuilder.append(str);
      QLog.d("SubmitHomeWorkFragment", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramHomeworkInfo != null) && (paramHomeworkInfo.b != null))
    {
      this.a.a = paramHomeworkInfo;
      paramHomeworkInfo = paramHomeworkInfo.b;
    }
    try
    {
      paramHomeworkInfo = new JSONObject(paramHomeworkInfo).getJSONArray("c");
      paramHomeworkInfo = new JSONObject().put("c", paramHomeworkInfo).toString();
      this.a.a(paramHomeworkInfo);
      return;
    }
    catch (Exception paramHomeworkInfo)
    {
      label135:
      break label135;
    }
    this.a.a(3, null, null, null);
    return;
    this.a.a(3, null, null, null);
    paramHomeworkInfo = this.a;
    paramHomeworkInfo.a = null;
    paramHomeworkInfo.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.1
 * JD-Core Version:    0.7.0.1
 */