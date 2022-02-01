package com.tencent.mobileqq.extendfriend.limitchat;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.wiget.CompletePersonalDataDialog;
import com.tencent.mobileqq.extendfriend.wiget.HeadsPanelAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.TagInfosAdapter;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ExtendFriendLimitChatMatchFragment$10
  extends ExtendFriendObserver
{
  ExtendFriendLimitChatMatchFragment$10(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void onGetUnLimitBaseInfo(boolean paramBoolean1, ArrayList<TagInfo> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3)
  {
    paramBoolean2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1);
    }
    if (paramBoolean1)
    {
      if (paramInt > 0) {
        break label130;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onlineCount  wrong");
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView == null) {
          break label197;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.a(paramArrayList1);
      }
      label85:
      if ((ExtendFriendLimitChatMatchFragment.a(this.a) != null) && (!ExtendFriendLimitChatMatchFragment.a(this.a).isFinishing()) && (ExtendFriendLimitChatMatchFragment.a(this.a).app != null)) {
        break label208;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mActivity finish ");
    }
    label130:
    label197:
    label208:
    do
    {
      return;
      Object localObject = paramInt + BaseApplication.getContext().getResources().getString(2131698787);
      if (ExtendFriendLimitChatMatchFragment.a(this.a) != null)
      {
        ExtendFriendLimitChatMatchFragment.a(this.a).setText((CharSequence)localObject);
        break;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mMatchCountTxt is null");
      break;
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mHeadsPanleView is null");
      break label85;
      paramArrayList1 = (ExtendFriendManager)ExtendFriendLimitChatMatchFragment.a(this.a).app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if ((paramArrayList1 != null) && (paramArrayList1.k()))
      {
        ExtendFriendLimitChatMatchFragment.a(this.a).setVisibility(0);
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "signalBtn VISIBLE with controlbit");
        if (!paramBoolean3) {
          break label459;
        }
        if (paramArrayList1 != null)
        {
          if (paramArrayList1.k()) {
            break label423;
          }
          ExtendFriendLimitChatMatchFragment.b(this.a, true);
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "bSignalBombOpen FALSE BUG signaflag open NEED PB CLOSE");
        }
      }
      for (;;)
      {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (ExtendFriendLimitChatMatchFragment.a(this.a) == null)) {
          break label597;
        }
        paramInt = 0;
        while (paramInt < paramArrayList.size())
        {
          localObject = (TagInfo)paramArrayList.get(paramInt);
          if (!TextUtils.isEmpty(((TagInfo)localObject).jdField_a_of_type_JavaLangString)) {
            ExtendFriendLimitChatMatchFragment.a(this.a, ExtendFriendLimitChatMatchFragment.a(this.a) + ((TagInfo)localObject).jdField_a_of_type_JavaLangString + ";");
          }
          paramInt += 1;
        }
        ExtendFriendLimitChatMatchFragment.a(this.a).setVisibility(8);
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "signalBtn GONE with controlbit");
        break;
        if (!SignalBombHelper.a())
        {
          ExtendFriendLimitChatMatchFragment.b(this.a, true);
          ExtendFriendLimitChatMatchFragment.e(this.a);
        }
        else
        {
          ExtendFriendLimitChatMatchFragment.a(this.a, true, true);
          continue;
          ExtendFriendLimitChatMatchFragment.a(this.a, false, true);
        }
      }
      paramBoolean1 = paramBoolean2;
      if (paramArrayList1 != null) {
        paramBoolean1 = paramArrayList1.j();
      }
      paramInt = paramArrayList.size() - 1;
      while (paramInt >= 0)
      {
        if ((((TagInfo)paramArrayList.get(paramInt)).jdField_a_of_type_Int == 10000) && (!paramBoolean1))
        {
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "MATCH_CHAT_TAG_ID_FOR_VOICE_MATCH REMOVE by flag");
          paramArrayList.remove(paramInt);
        }
        paramInt -= 1;
      }
      paramArrayList1 = new TagInfosAdapter();
      paramArrayList1.a(paramArrayList);
      if (paramArrayList.size() <= 0) {
        break label588;
      }
    } while (ExtendFriendLimitChatMatchFragment.a(this.a) == null);
    label423:
    label459:
    ExtendFriendLimitChatMatchFragment.a(this.a).setAdapter(paramArrayList1);
    return;
    label588:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TaginfoInfo size 0");
    return;
    label597:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo size 0");
  }
  
  public void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt)
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)ExtendFriendLimitChatMatchFragment.a(this.a).app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    int j;
    int i;
    if (localExtendFriendManager != null)
    {
      j = (int)localExtendFriendManager.a();
      i = (int)localExtendFriendManager.b();
    }
    for (int k = (int)localExtendFriendManager.c();; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "onUpdateCampusCertificateStatus,isSuccess = " + paramBoolean + ",maxMatchCount = " + j + ",matchedCount = " + i + ",leftMatchCount = " + k + ",scene = " + paramInt);
      }
      if ((paramBoolean) && (paramInt == 1))
      {
        ExtendFriendLimitChatMatchFragment.b(this.a).setVisibility(0);
        ExtendFriendLimitChatMatchFragment.f(this.a);
        if ((ExtendFriendLimitChatMatchFragment.a(this.a).isShowing()) && (localExtendFriendManager != null)) {
          ExtendFriendLimitChatMatchFragment.a(this.a).b(j, k, localExtendFriendManager.a());
        }
      }
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void onUpdateRedPoint(int paramInt)
  {
    MatchChatMsgUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, ExtendFriendLimitChatMatchFragment.a(this.a).app);
  }
  
  public void onUpdateSignalBombPush(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendLimitChatMatchFragment.a(this.a) == 1) && (ExtendFriendLimitChatMatchFragment.a(this.a) != null) && (ExtendFriendLimitChatMatchFragment.a(this.a).isResume()) && (ExtendFriendLimitChatMatchFragment.a(this.a).a() != 2) && (!ExtendFriendLimitChatMatchFragment.a(this.a))) {
      ExtendFriendLimitChatMatchFragment.a(this.a, SignalBombHelper.a(ExtendFriendLimitChatMatchFragment.a(this.a), ExtendFriendLimitChatMatchFragment.a(this.a).app, ExtendFriendLimitChatMatchFragment.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.10
 * JD-Core Version:    0.7.0.1
 */