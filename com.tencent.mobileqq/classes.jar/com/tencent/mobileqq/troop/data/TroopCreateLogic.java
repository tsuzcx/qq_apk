package com.tencent.mobileqq.troop.data;

import ajin;
import ajiq;
import ajir;
import ajit;
import ajiu;
import ajiv;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.troop.TroopConstants.CreateTroopSource;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import mqq.manager.Manager;

public class TroopCreateLogic
  implements TroopConstants.CreateTroopSource, Manager
{
  int jdField_a_of_type_Int = 0;
  public Dialog a;
  public BizTroopObserver a;
  public QQAppInterface a;
  public TroopObserver a;
  public TroopCreateLogic.TroopCreateCallback a;
  public TroopCreateLogic.TroopCreateInfo a;
  TroopSearchLogic jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic;
  public String a;
  public WeakReference a;
  public ArrayList a;
  Timer jdField_a_of_type_JavaUtilTimer;
  public int b;
  
  public TroopCreateLogic(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo = new TroopCreateLogic.TroopCreateInfo();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ajiq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ajir(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(ArrayList paramArrayList)
  {
    Collections.sort(paramArrayList, new ajiu());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramArrayList = (String)localIterator.next();
      if (i <= 2) {
        break label91;
      }
    }
    label91:
    int k;
    int j;
    for (;;)
    {
      if (localStringBuffer.toString().endsWith("、")) {
        localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
      }
      return localStringBuffer.toString();
      if ((paramArrayList == null) || ("".equals(paramArrayList))) {
        break label324;
      }
      try
      {
        k = localStringBuffer.toString().getBytes("utf-8").length;
        j = paramArrayList.getBytes("utf-8").length;
        k = 30 - k;
        if (k > 0) {
          if (i == 0) {
            if (j > 20)
            {
              while (j >= 14)
              {
                paramArrayList = paramArrayList.substring(0, paramArrayList.length() - 1);
                j = paramArrayList.getBytes("utf-8").length;
              }
              localStringBuffer.append(paramArrayList).append("…").append("、");
            }
            else
            {
              localStringBuffer.append(paramArrayList).append("、");
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
    label222:
    Object localObject2;
    if (k < 3)
    {
      k = 3;
      if (k >= j) {
        break label334;
      }
      Object localObject1 = paramArrayList;
      int n = 0;
      int m = j;
      for (j = n;; j = 1)
      {
        localObject2 = localObject1;
        if (k >= m + 3) {
          break;
        }
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        m = ((String)localObject1).getBytes("utf-8").length;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        localStringBuffer.append((String)localObject2).append("…").append("、");
      }
      else
      {
        localStringBuffer.append(paramArrayList).append("、");
        break label327;
        break label222;
        label324:
        break label331;
      }
      label327:
      i += 1;
      label331:
      break;
      label334:
      j = 0;
      localObject2 = paramArrayList;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    Object localObject = paramArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label107;
      }
      i = 1;
    }
    label107:
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject = new ResultRecord();
        ((ResultRecord)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        ((ResultRecord)localObject).jdField_a_of_type_Int = 0;
        ((ResultRecord)localObject).jdField_b_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).jdField_a_of_type_Int);
        paramArrayList.add(localObject);
      }
      return i == 0;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!(localObject instanceof BaseActivity)) {}
    do
    {
      BaseActivity localBaseActivity;
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()));
        localBaseActivity = (BaseActivity)localObject;
      } while (localBaseActivity.isFinishing());
      localObject = new QQProgressDialog((Context)localObject, localBaseActivity.getTitleBarHeight());
      ((QQProgressDialog)localObject).a(paramString);
      ((QQProgressDialog)localObject).setCancelable(false);
      ((QQProgressDialog)localObject).setOnDismissListener(new ajit(this));
      this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (WindowManager.BadTokenException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("TroopCreateLogic", 2, paramString.getMessage());
  }
  
  public final TroopCreateLogic.TroopCreateInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo;
  }
  
  public String a(ResultRecord paramResultRecord)
  {
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramResultRecord.jdField_a_of_type_JavaLangString)) {
      return ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramResultRecord.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramResultRecord.jdField_a_of_type_JavaLangString)) {
      return paramResultRecord.jdField_b_of_type_JavaLangString;
    }
    Object localObject;
    if (paramResultRecord.jdField_a_of_type_Int == 1)
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramResultRecord.c, paramResultRecord.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).friendnick))) {
        return ((TroopMemberInfo)localObject).friendnick;
      }
    }
    else if (paramResultRecord.jdField_a_of_type_Int == 2)
    {
      localObject = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramResultRecord.c, paramResultRecord.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject).memberName)) {
          return ((DiscussionMemberInfo)localObject).memberName;
        }
        return ((DiscussionMemberInfo)localObject).inteRemark;
      }
    }
    return paramResultRecord.jdField_a_of_type_JavaLangString + "";
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "terminateLogic");
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("isBack2Root", true);
    if ((paramContext instanceof Application)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt)
  {
    a(paramBaseActivity, paramInt, "DEFAULT");
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "startCreateTroopSession: from=" + paramInt + ", type=" + paramString);
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      TroopQQBrowserHelper.a(paramBaseActivity, this.jdField_b_of_type_Int);
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      TroopQQBrowserHelper.a(paramBaseActivity);
      return;
    }
    if (("1".equals(this.jdField_a_of_type_JavaLangString)) || ("0".equals(this.jdField_a_of_type_JavaLangString)) || ("2".equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      }
      TroopQQBrowserHelper.a(paramBaseActivity, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramBaseActivity.finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      TroopQQBrowserHelper.a(paramBaseActivity);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = paramTroopCreateCallback;
    }
    paramBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBaseActivity == null)
    {
      a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback == null))
    {
      a();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback, paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.f))) {}
    MessageForGrayTips localMessageForGrayTips;
    do
    {
      return;
      localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
      localMessageForGrayTips.frienduin = paramString;
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      String str1 = ((Resources)localObject).getString(2131430617);
      String str2 = ((Resources)localObject).getString(2131430618);
      localObject = ((Resources)localObject).getString(2131430619);
      localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, str1, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      localMessageForGrayTips.setTextGravity(17);
      paramString = new Bundle();
      paramString.putInt("key_action", 7);
      int i = str1.indexOf(str2);
      localMessageForGrayTips.addHightlightItem(i, str2.length() + i, paramString);
      paramString = new Bundle();
      paramString.putInt("key_action", 6);
      i = str1.indexOf((String)localObject);
      localMessageForGrayTips.addHightlightItem(i, ((String)localObject).length() + i, paramString);
    } while (MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false));
    paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback)
  {
    a(paramTroopCreateCallback, null, null);
  }
  
  public void a(TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback, BaseActivity paramBaseActivity, ArrayList paramArrayList)
  {
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131434827, 0).a();
      a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData == null))
    {
      a();
      return;
    }
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    }
    Object localObject;
    if (paramArrayList != null)
    {
      a(paramArrayList);
      if (paramArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        paramBaseActivity = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (ResultRecord)paramArrayList.next();
          if (!TextUtils.isEmpty(a((ResultRecord)localObject))) {
            paramBaseActivity.add(a((ResultRecord)localObject));
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_b_of_type_JavaLangString = a(paramBaseActivity);
      }
    }
    int i;
    long l1;
    long l2;
    try
    {
      l3 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramArrayList = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.e.split("\\|");
      i = 0;
      l1 = 0L;
      l2 = 0L;
      paramBaseActivity = "";
      if (localObject.length != 4) {
        break label424;
      }
    }
    catch (NumberFormatException paramTroopCreateCallback)
    {
      long l3;
      float f;
      label272:
      a();
      return;
    }
    try
    {
      i = Integer.parseInt(localObject[0]);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      i = 0;
      break label272;
    }
    try
    {
      f = Float.valueOf(localObject[1]).floatValue();
      l1 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      break label272;
    }
    try
    {
      f = Float.valueOf(localObject[2]).floatValue();
      l2 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      break label272;
    }
    paramBaseActivity = localObject[3];
    for (;;)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Int;
      int j = k;
      if (k == 2) {
        j = k + 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = paramTroopCreateCallback;
      paramArrayList.a(((TroopCreateAdvanceData)localObject).jdField_b_of_type_Long, ((TroopCreateAdvanceData)localObject).jdField_b_of_type_Int, l3, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.d, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_Int, j, l1, l2, i, paramBaseActivity, ((TroopCreateAdvanceData)localObject).a, this.jdField_b_of_type_Int);
      b("正在创建群聊");
      return;
      label424:
      l2 = 0L;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.c(paramString);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.a();
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    localMessageForGrayTips.frienduin = paramString1;
    if ((paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList.size() == 0))) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.f))) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_c_of_type_Boolean = true;
    if (paramBoolean)
    {
      paramString2 = new StringBuffer();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ResultRecord)localIterator.next();
        if (!((ResultRecord)localObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          localObject = a((ResultRecord)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramString2.append((String)localObject).append("、");
          }
        }
      }
      paramString2.delete(paramString2.length() - 1, paramString2.length());
      paramString2 = String.format("你邀请了%s加入群聊。为了方便后续查找，给群聊取个名字吧。", new Object[] { paramString2.toString() });
    }
    for (;;)
    {
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 25);
      int i = paramString2.indexOf("取个名字");
      localMessageForGrayTips.addHightlightItem(i, "取个名字".length() + i, paramString1);
      if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForGrayTips, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = String.format("你发起了群聊，身边的人可以通过输入%s加入。为了方便后续查找，给群聊取个名字吧。", new Object[] { paramString2 });
      } else {
        paramString2 = "你创建了群聊。为了方便后续查找，给多人聊天取个名字吧。";
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.f)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.equals(((ResultRecord)paramString1.next()).jdField_a_of_type_JavaLangString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback, BaseActivity paramBaseActivity, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!localResultRecord.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          ajiv localajiv = new ajiv(this);
          localajiv.jdField_a_of_type_JavaLangString = localResultRecord.jdField_b_of_type_JavaLangString;
          localajiv.jdField_b_of_type_JavaLangString = ChnToSpell.a(localResultRecord.jdField_b_of_type_JavaLangString, 2);
          localArrayList.add(localajiv);
        }
      }
      Collections.sort(localArrayList);
      a(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = paramTroopCreateCallback;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      b("正在创建群聊");
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new ajin(this, localArrayList, paramBaseActivity, paramTroopCreateCallback, paramArrayList));
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic
 * JD-Core Version:    0.7.0.1
 */