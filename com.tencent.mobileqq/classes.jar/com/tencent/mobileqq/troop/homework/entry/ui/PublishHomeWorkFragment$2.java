package com.tencent.mobileqq.troop.homework.entry.ui;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class PublishHomeWorkFragment$2
  extends HomeworkObserver
{
  PublishHomeWorkFragment$2(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.a(paramBoolean, paramLong, paramInt);
    this.a.p();
    this.a.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, HomeworkInfo paramHomeworkInfo)
  {
    super.a(paramBoolean, paramHomeworkInfo);
    this.a.p();
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
      QLog.d("PublishHomeWorkFragment", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramHomeworkInfo != null) && (paramHomeworkInfo.b != null))
    {
      this.a.a(paramHomeworkInfo);
      return;
    }
    this.a.getActivity().finish();
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.a(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetHomeworkTroopIdentity: isSuccess:");
      paramString1.append(paramBoolean);
      paramString1.append(", identity:");
      paramString1.append(paramInt);
      paramString1.append(", course:");
      paramString1.append(paramString3);
      QLog.d("PublishHomeWorkFragment", 2, paramString1.toString());
    }
    if (!this.a.j)
    {
      this.a.a(paramInt, paramString3, paramString4);
      if (paramBoolean)
      {
        paramString1 = this.a;
        paramString1.a = paramString3;
        paramString1.c();
      }
      else
      {
        QQToast.a(this.a.getActivity(), HardCodeUtil.a(2131708818), 0).a();
      }
      QLog.i("PublishHomeWorkFragment", 1, "init data success");
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.2
 * JD-Core Version:    0.7.0.1
 */