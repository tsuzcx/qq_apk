package com.tencent.mobileqq.text.style;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.search.UinSearcher;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Thrower;
import com.tencent.widget.ActionSheet;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class LinkSpan
  extends ClickableSpan
{
  private static String b;
  private static String c;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private UinSearcher jdField_a_of_type_ComTencentMobileqqSearchUinSearcher;
  public String a;
  private String d;
  
  public LinkSpan(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public LinkSpan(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    b = paramString2;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(String.format(paramContext.getString(2131694586), new Object[] { paramString }));
    localActionSheet.addButton(2131691382, 1);
    localActionSheet.addButton(2131689618, 1);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new LinkSpan.4(Thrower.a(new LinkSpan.3(paramContext, paramString, localActionSheet)).a(1000L)));
    localActionSheet.show();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    if (paramInt == 0)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131694585), new Object[] { paramString1 }));
      localActionSheet.addButton(2131691678, 1);
      localActionSheet.addButton(2131691372, 1);
      localActionSheet.addButton(2131689612, 1);
      localActionSheet.addButton(2131689577, 1);
      localActionSheet.addButton(2131693562, 1);
    }
    for (;;)
    {
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new LinkSpan.5(paramInt, paramString1, paramContext, paramString2, localActionSheet));
      localActionSheet.show();
      return;
      if (paramInt == 1)
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131694586), new Object[] { paramString1 }));
        localActionSheet.addButton(2131691678, 1);
        localActionSheet.addButton(2131691372, 1);
        localActionSheet.addButton(2131689612, 1);
      }
      else if (paramInt == 2)
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131693917), new Object[] { paramString1 }));
        localActionSheet.addButton(2131719031, 1);
        localActionSheet.addButton(2131691372, 1);
      }
      else if (paramInt == 3)
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131694586), new Object[] { paramString1 }));
        localActionSheet.addButton(2131691678, 1);
        localActionSheet.addButton(2131691372, 1);
        localActionSheet.addButton(2131689612, 1);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramContext, paramString, i, null);
      return;
    }
  }
  
  private static void c(String paramString1, String paramString2)
  {
    try
    {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(b), "dc00898", "", "", paramString1, paramString2, 0, 0, "", "", "", "");
      return;
    }
    catch (AccountNotMatchException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (ClassCastException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static void d(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
    localIntent.setType("vnd.android.cursor.item/person");
    localIntent.setType("vnd.android.cursor.item/contact");
    localIntent.setType("vnd.android.cursor.item/raw_contact");
    localIntent.putExtra("phone", paramString);
    paramContext.startActivity(localIntent);
    c("0X800A00C", "0X800A00C");
  }
  
  private static void d(String paramString1, String paramString2)
  {
    if (c == null) {
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(b);
      if (paramString2 != null)
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, c, "" + paramString1, "" + paramString2, "");
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      AppRuntime localAppRuntime;
      for (;;)
      {
        localClassCastException.printStackTrace();
        localAppRuntime = null;
      }
      ReportController.b(localAppRuntime, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, c, "" + paramString1, "" + paramString1, "");
      return;
    }
    catch (AccountNotMatchException paramString1) {}
  }
  
  private static void e(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
    localIntent.putExtra("phone", paramString);
    paramContext.startActivity(localIntent);
    c("0X800A00B", "0X800A00B");
  }
  
  public void a(Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LinkSpan", 2, "msg is null, show old action sheet");
      }
      a(paramContext, paramString, paramInt, this.d);
      return;
    }
    Object localObject1 = null;
    if ((paramContext instanceof BaseActivity)) {
      localObject1 = ((BaseActivity)paramContext).app;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        Object localObject2 = paramMessageRecord.selfuin;
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject2);
        localObject1 = localObject2;
        if (localObject1 != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LinkSpan", 2, "app is null, show old action sheet");
        }
        a(paramContext, paramString, paramInt, this.d);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        QLog.e("LinkSpan", 1, localAccountNotMatchException, new Object[0]);
      }
    }
    int i;
    ActionSheet localActionSheet;
    Object localObject3;
    if (paramInt == 2)
    {
      i = 5;
      localActionSheet = ActionSheet.create(paramContext);
      localObject3 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramInt != 0) {
        break label391;
      }
      if (NetworkUtil.a()) {
        break label352;
      }
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131694586), new Object[] { paramString }));
      localActionSheet.addButton(2131691372, 1);
      localActionSheet.addButton(2131692258, 1);
      localActionSheet.addButton(2131691678, 1);
      localActionSheet.addButton(2131689612, 1);
      ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(paramMessageRecord.istroop), 0, "", "", "", "");
    }
    for (;;)
    {
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new LinkSpan.1(this, paramContext, paramString, (QQAppInterface)localObject1, i, paramMessageRecord, paramInt, localActionSheet));
      localActionSheet.setOnDismissListener(new LinkSpan.2(this, (QQAppInterface)localObject1, i));
      localActionSheet.show();
      return;
      i = 4;
      break;
      label352:
      if (this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher = new UinSearcher(this.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
      return;
      label391:
      if (paramInt == 1)
      {
        if (!NetworkUtil.a())
        {
          localActionSheet.setMainTitle(String.format(paramContext.getString(2131694586), new Object[] { paramString }));
          localActionSheet.addButton(2131691372, 1);
          localActionSheet.addButton(2131692258, 1);
          localActionSheet.addButton(2131691678, 1);
          localActionSheet.addButton(2131689612, 1);
          if ((!paramMessageRecord.isSend()) && (((FriendsManager)localObject3).b(paramMessageRecord.senderuin)))
          {
            localObject3 = (CardHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (localObject3 != null) {
              ((CardHandler)localObject3).a(b, paramMessageRecord.senderuin, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
            }
            localActionSheet.addButton(2131689621, 1);
          }
          ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
          ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(paramMessageRecord.istroop), 0, "", "", "", "");
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher == null) {
            this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher = new UinSearcher(this.d);
          }
          this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
        }
      }
      else if (paramInt == 2)
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131693917), new Object[] { paramString }));
        localActionSheet.addButton(2131691372, 1);
        localActionSheet.addButton(2131692258, 1);
        localActionSheet.addButton(2131719031, 1);
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A924", "0X800A924", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
      else if (paramInt == 3)
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131694586), new Object[] { paramString }));
        localActionSheet.addButton(2131691372, 1);
        localActionSheet.addButton(2131692258, 1);
        localActionSheet.addButton(2131691678, 1);
        localActionSheet.addButton(2131689612, 1);
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
    }
  }
  
  protected void a(View paramView, String paramString)
  {
    int i;
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getAppRuntime(b);
      if ((localObject1 instanceof QQAppInterface)) {
        ECommerceDataReportUtil.a((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 5, paramString);
      }
      localObject2 = null;
      i = paramString.lastIndexOf("#");
      if (i > 0) {
        localObject2 = paramString.substring(i);
      }
      String str2 = URLUtil.guessUrl(paramString);
      localObject1 = str2;
      if (localObject2 != null) {
        localObject1 = str2 + (String)localObject2;
      }
      if (TeamWorkUtils.a((String)localObject1))
      {
        localObject2 = paramView.getContext();
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("url", (String)localObject1);
          ((Bundle)localObject2).putString("tdsourcetag", "s_qq_aiomsg");
          TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject2, false);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            break label266;
          }
          ReportController.b(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("LinkSpan", 1, localThrowable, new Object[0]);
        continue;
        QQToast.a((Context)localObject2, ((Context)localObject2).getResources().getString(2131692257), 0).b(((Context)localObject2).getResources().getDimensionPixelSize(2131299166));
        continue;
        MttBrowerWrapper.a(paramView.getContext(), localThrowable, true, true, true, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.d);
      }
    }
    for (;;)
    {
      try
      {
        label266:
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        String str1 = paramView.frienduin;
        if (paramView.istroop == 1)
        {
          i = 2;
          if (paramString.length() <= 150) {
            break label396;
          }
          paramView = paramString.substring(0, 150);
          paramString = new URL(paramString).getHost();
          ReportController.b(null, "CliOper", "", str1, "0X80061B1", "0X80061B1", i, 0, "", "", paramView, paramString);
          if (!QLog.isDebugVersion()) {
            break;
          }
          QLog.d("QQText", 4, String.format("the report params:%s,%s,%s,%s", new Object[] { "", "", paramView, paramString }));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      i = 1;
      continue;
      label396:
      paramView = paramString;
    }
  }
  
  public void onClick(View paramView)
  {
    if (BubbleContextMenu.a) {
      if (QLog.isColorLevel()) {
        QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
      if ((localObject instanceof String)) {
        c = (String)localObject;
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = Patterns.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = Patterns.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (QQTextParseLinkUtil.f.matcher((CharSequence)localObject).find())
        {
          a(paramView.getContext(), (String)localObject, 2, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          d("1", null);
          return;
        }
        a(paramView, (String)localObject);
        d("0", null);
        return;
      }
      if (QQTextParseLinkUtil.a.matcher((CharSequence)localObject).find())
      {
        a(paramView.getContext(), (String)localObject, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        d("2", null);
        return;
      }
      Matcher localMatcher = QQTextParseLinkUtil.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        a(paramView.getContext(), (String)localObject, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        d("1", null);
        return;
      }
    } while (!QQTextParseLinkUtil.e.matcher((CharSequence)localObject).find());
    a(paramView.getContext(), (String)localObject, 1, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    d("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan
 * JD-Core Version:    0.7.0.1
 */