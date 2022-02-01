package com.tencent.mobileqq.selectmember;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class SelectMemberActivity$12
  extends DiscussionObserver
{
  SelectMemberActivity$12(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = false;
    }
    if (this.a.mQQProgressDialog != null)
    {
      this.a.mQQProgressDialog.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("create discussion success: roomId: ");
          paramString.append(paramLong);
          paramString.append(", mSubType: ");
          paramString.append(this.a.mSubType);
          paramString.append(", mEntrance: ");
          paramString.append(this.a.mEntrance);
          QLog.d("SelectMemberActivity", 2, paramString.toString());
        }
        paramString = new ArrayList();
        Iterator localIterator = this.a.mResultList.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          if (localResultRecord.type == 5)
          {
            if (localResultRecord.uin.startsWith("pstn")) {
              localResultRecord.uin = localResultRecord.uin.substring(4);
            }
            paramString.add(localResultRecord.uin);
          }
          else if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+")))
          {
            paramString.add(localResultRecord.uin);
          }
        }
        this.a.mIntent.putExtra("roomId", paramLong);
        if (this.a.mEntrance == 12) {
          this.a.mIntent.putExtra("select_memeber_discussion_memeber_count", this.a.mResultList.size() + 1);
        }
        this.a.mIntent.putParcelableArrayListExtra("result_set", this.a.mResultList);
        paramString = this.a;
        paramString.setResult(-1, paramString.mIntent);
        this.a.finish();
        return;
      }
      paramString = new StringBuilder();
      paramString.append("create discussion fail, errCode=");
      paramString.append(paramInt);
      QLog.d("SelectMemberActivity", 1, paramString.toString());
      if (paramInt == 1000)
      {
        paramString = this.a;
        QQToast.a(paramString, paramString.getString(2131697625), 2000).b(this.a.mTitleBar.getHeight());
        ReportController.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
        return;
      }
      paramString = this.a;
      QQToast.a(paramString, paramString.getString(2131691759), 2000).b(this.a.mTitleBar.getHeight());
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (this.a.mQQProgressDialog != null)
    {
      this.a.mQQProgressDialog.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("add discussion member success: roomId: ");
          paramArrayList.append(paramLong);
          QLog.d("SelectMemberActivity", 2, paramArrayList.toString());
        }
        paramArrayList = new ArrayList();
        Iterator localIterator = this.a.mResultList.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          if (localResultRecord.type == 5)
          {
            if (localResultRecord.uin.startsWith("pstn")) {
              localResultRecord.uin = localResultRecord.uin.substring(4);
            }
            paramArrayList.add(localResultRecord.uin);
          }
        }
        this.a.mIntent.putExtra("roomId", paramLong);
        this.a.mIntent.putParcelableArrayListExtra("result_set", this.a.mResultList);
        if (paramBoolean)
        {
          paramArrayList = this.a;
          paramArrayList.setResult(-1, paramArrayList.mIntent);
        }
        else
        {
          paramArrayList = this.a;
          paramArrayList.setResult(1, paramArrayList.mIntent);
        }
        this.a.finish();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add discussion member fail");
      }
      if (paramInt == 1000) {
        ReportController.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
      }
      paramArrayList = this.a;
      QQToast.a(paramArrayList, paramArrayList.getString(2131691757), 2000).b(this.a.mTitleBar.getHeight());
    }
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    if (this.a.mQQProgressDialog != null) {
      this.a.mQQProgressDialog.dismiss();
    }
    if (paramArrayOfObject == null) {
      return;
    }
    String str = (String)paramArrayOfObject[0];
    if (this.a.mGroupCode.equals(str))
    {
      int i = ((Integer)paramArrayOfObject[1]).intValue();
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("add discussion member failed, error code: ");
      paramArrayOfObject.append(i);
      QLog.d("SelectMemberActivity", 2, paramArrayOfObject.toString());
      paramArrayOfObject = this.a;
      QQToast.a(paramArrayOfObject, paramArrayOfObject.getString(2131691757), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.12
 * JD-Core Version:    0.7.0.1
 */