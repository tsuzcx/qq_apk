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
  private WeakReference<QQAppInterface> a;
  private UnifySearchHandler b;
  private String c;
  private String d = "";
  private long[] e = { 1001L, 1002L, 8001L };
  private WeakReference<Context> f;
  private QQProgressDialog g;
  private ChatMessage h;
  private int i;
  private String j;
  private String k;
  private int l;
  private UnifySearchObserver m = new UinSearcher.1(this);
  
  public UinSearcher(String paramString)
  {
    this.k = paramString;
  }
  
  public static int a(int paramInt)
  {
    int n = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1006) {
          if (paramInt != 3000)
          {
            if ((paramInt == 10008) || (paramInt == 10010) || (paramInt == 10013) || (paramInt == 1020) || (paramInt == 1021)) {}
          }
          else {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  return 0;
                  return 3;
                }
                break;
              }
              break;
            }
          }
        }
        return 4;
      }
      n = 2;
    }
    return n;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (ChatActivityUtils.a(paramQQAppInterface, paramInt, paramString)) {
      return 5;
    }
    if (ChatActivityUtils.a(paramInt)) {
      return 3;
    }
    int n = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return -1;
        }
        return 4;
      }
      n = 2;
    }
    return n;
  }
  
  private void a()
  {
    this.d = "0";
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.m);
    }
    if (this.g != null) {
      this.g = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ChatMessage paramChatMessage)
  {
    if (this.g != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UinSearcher", 2, "searching, skip");
      }
      return;
    }
    this.a = new WeakReference(paramQQAppInterface);
    this.f = new WeakReference(paramContext);
    if (this.b == null) {
      this.b = ((UnifySearchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    }
    this.c = paramString;
    this.h = paramChatMessage;
    paramString = paramChatMessage.selfuin;
    if ((!paramChatMessage.isSend()) && (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      this.j = paramChatMessage.senderuin;
    } else {
      this.j = paramChatMessage.frienduin;
    }
    this.i = paramChatMessage.istroop;
    paramChatMessage = new StringBuilder();
    paramChatMessage.append(System.currentTimeMillis());
    paramChatMessage.append("");
    this.d = paramChatMessage.toString();
    paramQQAppInterface.addObserver(this.m);
    paramQQAppInterface = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramString, this.j, 1, 0L, (byte)1, 0L, 0L, null, "", 8192L, 10004, null, (byte)0);
    }
    try
    {
      this.g = new QQProgressDialog(paramContext);
      this.g.e(17);
      this.g.a(null);
      this.g.f(2130839590);
      if (this.g.getWindow() != null) {
        this.g.getWindow().setDimAmount(0.0F);
      }
      this.g.setOnDismissListener(new UinSearcher.2(this));
      if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
        this.g.show();
      }
    }
    catch (RuntimeException paramQQAppInterface)
    {
      QLog.e("UinSearcher", 1, paramQQAppInterface, new Object[0]);
    }
    this.b.a(this.c, this.d, 20, SearchUtil.a(this.e), null, null, 0, 0.0D, 0.0D, null, "{ \"search_by_id_only\": 1 }");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher
 * JD-Core Version:    0.7.0.1
 */