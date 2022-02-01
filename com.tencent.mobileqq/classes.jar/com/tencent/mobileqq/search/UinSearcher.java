package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class UinSearcher
{
  private int jdField_a_of_type_Int;
  private UnifySearchHandler jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler;
  private UnifySearchObserver jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver = new UinSearcher.1(this);
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private long[] jdField_a_of_type_ArrayOfLong = { 1001L, 1002L, 8001L };
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private WeakReference<Context> jdField_b_of_type_MqqUtilWeakReference;
  private String c;
  private String d;
  
  public UinSearcher(String paramString)
  {
    this.d = paramString;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 3;
    }
    return 4;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (ChatActivityUtils.a(paramQQAppInterface, paramInt, paramString)) {
      return 5;
    }
    if (ChatActivityUtils.a(paramInt)) {
      return 3;
    }
    switch (paramInt)
    {
    default: 
      return -1;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  private void a()
  {
    this.jdField_b_of_type_JavaLangString = "0";
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UinSearcher", 2, "searching, skip");
      }
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = ((UnifySearchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    paramString = paramChatMessage.selfuin;
    if ((!paramChatMessage.isSend()) && (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {}
    for (this.c = paramChatMessage.senderuin;; this.c = paramChatMessage.frienduin)
    {
      this.jdField_a_of_type_Int = paramChatMessage.istroop;
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
      paramQQAppInterface = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString, this.c, 1, 0L, (byte)1, 0L, 0L, null, "", 8192L, 10004, null, (byte)0);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.e(17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.f(2130839549);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.getWindow() != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.getWindow().setDimAmount(0.0F);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new UinSearcher.2(this));
        if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
      }
      catch (RuntimeException paramQQAppInterface)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramQQAppInterface, new Object[0]);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, SearchUtil.a(this.jdField_a_of_type_ArrayOfLong), null, null, 0, 0.0D, 0.0D, null, "{ \"search_by_id_only\": 1 }");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher
 * JD-Core Version:    0.7.0.1
 */