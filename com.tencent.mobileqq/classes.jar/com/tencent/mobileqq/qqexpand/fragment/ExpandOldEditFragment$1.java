package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ExpandOldEditFragment$1
  extends ExpandObserver
{
  ExpandOldEditFragment$1(ExpandOldEditFragment paramExpandOldEditFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendProfileEdit", 2, String.format("ExtendFriendEditFragment onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (this.a.h != null))
    {
      IExpandManager localIExpandManager = (IExpandManager)ExpandOldEditFragment.c(this.a).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      this.a.i.n = localIExpandManager.H();
      this.a.h.b(this.a.i);
    }
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    boolean bool = false;
    if (paramBoolean)
    {
      this.a.i = new ExtendFriendInfo(paramCard);
      paramCard = this.a;
      paramBoolean = bool;
      if (TextUtils.isEmpty(paramCard.i.a))
      {
        paramBoolean = bool;
        if (TextUtils.isEmpty(this.a.i.d)) {
          paramBoolean = true;
        }
      }
      ExpandOldEditFragment.a(paramCard, paramBoolean);
      this.a.h.a(this.a.i);
    }
    else
    {
      QQToast.makeText(ExpandOldEditFragment.b(this.a), "获取扩列信息失败", 0).show();
    }
    ExpandOldEditFragment.a(this.a).dismiss();
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      String str1 = paramObject.getString("name");
      String str2 = paramObject.getString("schoolid");
      int i = paramObject.getInt("category");
      int j = paramObject.getInt("idx");
      if ((this.a.i != null) && (this.a.h != null))
      {
        this.a.i.m = str1;
        this.a.i.l = str2;
        this.a.i.p = i;
        this.a.i.n = -1L;
        this.a.i.o = j;
        this.a.h.b(this.a.i);
      }
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      ExpandOldEditFragment.a(this.a).dismiss();
      ExpandOldEditFragment.b(this.a).setResult(8193);
      if (ExpandOldEditFragment.b(this.a) != null) {
        ExpandOldEditFragment.b(this.a).finish();
      }
    }
    else
    {
      ExpandOldEditFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandOldEditFragment.1
 * JD-Core Version:    0.7.0.1
 */