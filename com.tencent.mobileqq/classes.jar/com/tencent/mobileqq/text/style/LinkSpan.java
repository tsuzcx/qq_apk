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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.UinSearcher;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
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
  private static String c;
  private static String d;
  private MessageRecord a;
  public String b;
  private UinSearcher e;
  private String f;
  
  public LinkSpan(String paramString)
  {
    this.b = paramString;
  }
  
  public LinkSpan(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    this.b = paramString1;
    this.a = paramMessageRecord;
    c = paramString2;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
    localActionSheet.addButton(2131888256, 1);
    localActionSheet.addButton(2131886261, 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new LinkSpan.6(Thrower.a(new LinkSpan.5(paramContext, paramString, localActionSheet)).a(1000L)));
    localActionSheet.show();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    if (paramInt == 0)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131892237), new Object[] { paramString1 }));
      localActionSheet.addButton(2131888562, 1);
      localActionSheet.addButton(2131888244, 1);
      localActionSheet.addButton(2131886255, 1);
      localActionSheet.addButton(2131886219, 1);
      localActionSheet.addButton(2131891071, 1);
    }
    else if (paramInt == 1)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString1 }));
      localActionSheet.addButton(2131888562, 1);
      localActionSheet.addButton(2131888244, 1);
      localActionSheet.addButton(2131886255, 1);
    }
    else if (paramInt == 2)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131891478), new Object[] { paramString1 }));
      localActionSheet.addButton(2131916253, 1);
      localActionSheet.addButton(2131888244, 1);
    }
    else if (paramInt == 3)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString1 }));
      localActionSheet.addButton(2131888562, 1);
      localActionSheet.addButton(2131888244, 1);
      localActionSheet.addButton(2131886255, 1);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new LinkSpan.7(paramInt, paramString1, paramContext, paramString2, localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramString, paramBoolean ^ true, null);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject2 = paramQQAppInterface;
    int i;
    if (paramInt == 2) {
      i = 5;
    } else {
      i = 4;
    }
    Object localObject1 = ActionSheet.create(paramContext);
    Object localObject3 = (FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramInt == 0)
    {
      ((ActionSheet)localObject1).setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
      ((ActionSheet)localObject1).addButton(2131888244, 1);
      ((ActionSheet)localObject1).addButton(2131888562, 1);
      ((ActionSheet)localObject1).addButton(2131886255, 1);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject2, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(paramMessageRecord.istroop), 0, "", "", "", "");
    }
    else if (paramInt == 1)
    {
      ((ActionSheet)localObject1).setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
      ((ActionSheet)localObject1).addButton(2131888244, 1);
      ((ActionSheet)localObject1).addButton(2131888562, 1);
      ((ActionSheet)localObject1).addButton(2131886255, 1);
      if ((!paramMessageRecord.isSend()) && (((FriendsManager)localObject3).n(paramMessageRecord.senderuin)))
      {
        localObject3 = (CardHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (localObject3 != null) {
          ((CardHandler)localObject3).a(c, paramMessageRecord.senderuin, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
        }
        ((ActionSheet)localObject1).addButton(2131886264, 1);
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject2, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(paramMessageRecord.istroop), 0, "", "", "", "");
    }
    else
    {
      localObject2 = localObject1;
      if (paramInt == 2)
      {
        ((ActionSheet)localObject2).setMainTitle(String.format(paramContext.getString(2131891478), new Object[] { paramString }));
        ((ActionSheet)localObject2).addButton(2131888244, 1);
        ((ActionSheet)localObject2).addButton(2131916253, 1);
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A924", "0X800A924", UinSearcher.a(paramQQAppInterface, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
      else if (paramInt == 3)
      {
        ((ActionSheet)localObject2).setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
        ((ActionSheet)localObject2).addButton(2131888244, 1);
        ((ActionSheet)localObject2).addButton(2131888562, 1);
        ((ActionSheet)localObject2).addButton(2131886255, 1);
        int j = UinSearcher.a(paramQQAppInterface, paramMessageRecord.istroop, paramMessageRecord.frienduin);
        localObject1 = localObject2;
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A923", "0X800A923", j, 0, "", "", "", "");
      }
    }
    ((ActionSheet)localObject1).addCancelButton(2131887648);
    ((ActionSheet)localObject1).setOnButtonClickListener(new LinkSpan.3(this, paramContext, paramString, paramQQAppInterface, i, paramInt, paramMessageRecord, (ActionSheet)localObject1));
    ((ActionSheet)localObject1).setOnDismissListener(new LinkSpan.4(this, paramQQAppInterface, i));
    ((ActionSheet)localObject1).show();
  }
  
  private static void c(String paramString1, String paramString2)
  {
    try
    {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(c), "dc00898", "", "", paramString1, paramString2, 0, 0, "", "", "", "");
      return;
    }
    catch (ClassCastException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (AccountNotMatchException paramString1)
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
    if (d == null) {
      return;
    }
    try
    {
      AppRuntime localAppRuntime;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(c);
      }
      catch (ClassCastException localClassCastException)
      {
        localClassCastException.printStackTrace();
        localAppRuntime = null;
      }
      if (paramString2 != null)
      {
        localObject = d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramString2);
        ReportController.b(localAppRuntime, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, (String)localObject, paramString1, localStringBuilder.toString(), "");
        return;
      }
      paramString2 = d;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString1);
      ReportController.b(localAppRuntime, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, paramString2, (String)localObject, localStringBuilder.toString(), "");
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
      a(paramContext, paramString, paramInt, this.f);
      return;
    }
    Object localObject1 = null;
    if ((paramContext instanceof BaseActivity)) {
      localObject1 = ((BaseActivity)paramContext).app;
    }
    if (localObject1 == null) {
      try
      {
        Object localObject2 = paramMessageRecord.selfuin;
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject2);
        localObject1 = localObject2;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        QLog.e("LinkSpan", 1, localAccountNotMatchException, new Object[0]);
      }
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LinkSpan", 2, "app is null, show old action sheet");
      }
      a(paramContext, paramString, paramInt, this.f);
      return;
    }
    if (paramMessageRecord.istroop == 10014)
    {
      a((QQAppInterface)localObject1, paramContext, paramString, paramInt, paramMessageRecord);
      return;
    }
    int i;
    if (paramInt == 2) {
      i = 5;
    } else {
      i = 4;
    }
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    Object localObject3 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramInt == 0)
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
        localActionSheet.addButton(2131888244, 1);
        localActionSheet.addButton(2131889171, 1);
        localActionSheet.addButton(2131888562, 1);
        localActionSheet.addButton(2131886255, 1);
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(paramMessageRecord.istroop), 0, "", "", "", "");
      }
      else
      {
        if (this.e == null) {
          this.e = new UinSearcher(this.f);
        }
        this.e.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
      }
    }
    else if (paramInt == 1)
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        localActionSheet.setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
        localActionSheet.addButton(2131888244, 1);
        localActionSheet.addButton(2131889171, 1);
        localActionSheet.addButton(2131888562, 1);
        localActionSheet.addButton(2131886255, 1);
        if ((!paramMessageRecord.isSend()) && (((FriendsManager)localObject3).n(paramMessageRecord.senderuin)))
        {
          localObject3 = (CardHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
          if (localObject3 != null) {
            ((CardHandler)localObject3).a(c, paramMessageRecord.senderuin, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          }
          localActionSheet.addButton(2131886264, 1);
        }
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800B0C0", "0X800B0C0", UinSearcher.a(paramMessageRecord.istroop), 0, "", "", "", "");
      }
      else
      {
        if (this.e == null) {
          this.e = new UinSearcher(this.f);
        }
        this.e.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
      }
    }
    else if (paramInt == 2)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131891478), new Object[] { paramString }));
      localActionSheet.addButton(2131888244, 1);
      localActionSheet.addButton(2131889171, 1);
      localActionSheet.addButton(2131916253, 1);
      ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A924", "0X800A924", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
    }
    else if (paramInt == 3)
    {
      localActionSheet.setMainTitle(String.format(paramContext.getString(2131892238), new Object[] { paramString }));
      localActionSheet.addButton(2131888244, 1);
      localActionSheet.addButton(2131889171, 1);
      localActionSheet.addButton(2131888562, 1);
      localActionSheet.addButton(2131886255, 1);
      ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", UinSearcher.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new LinkSpan.1(this, paramContext, paramString, (QQAppInterface)localObject1, i, paramMessageRecord, paramInt, localActionSheet));
    localActionSheet.setOnDismissListener(new LinkSpan.2(this, (QQAppInterface)localObject1, i));
    localActionSheet.show();
  }
  
  protected void a(View paramView, String paramString)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getAppRuntime(c);
      if ((localAppRuntime instanceof QQAppInterface)) {
        ECommerceDataReportUtil.a((QQAppInterface)localAppRuntime, this.a, 5, paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LinkSpan", 1, localThrowable, new Object[0]);
    }
    Object localObject2 = null;
    int i = paramString.lastIndexOf("#");
    if (i > 0) {
      localObject2 = paramString.substring(i);
    }
    String str = URLUtil.guessUrl(paramString);
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl((String)localObject1))
    {
      localObject2 = paramView.getContext();
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("url", (String)localObject1);
        ((Bundle)localObject2).putString("tdsourcetag", "s_qq_aiomsg");
        TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject2, false);
      }
      else
      {
        QQToast.makeText((Context)localObject2, ((Context)localObject2).getResources().getString(2131889169), 0).show(((Context)localObject2).getResources().getDimensionPixelSize(2131299920));
      }
    }
    else
    {
      MttBrowerWrapper.a(paramView.getContext(), (String)localObject1, true, true, true, false, this.a, this.f);
    }
    paramView = this.a;
    if (paramView == null)
    {
      ReportController.b(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramView.frienduin;
        if (paramView.istroop != 1) {
          break label416;
        }
        i = 2;
        if (paramString.length() <= 150) {
          break label421;
        }
        paramView = paramString.substring(0, 150);
        paramString = new URL(paramString).getHost();
        ReportController.b(null, "CliOper", "", (String)localObject1, "0X80061B1", "0X80061B1", i, 0, "", "", paramView, paramString);
        if (QLog.isDebugVersion())
        {
          QLog.d("QQText", 4, String.format("the report params:%s,%s,%s,%s", new Object[] { "", "", paramView, paramString }));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      return;
      label416:
      i = 1;
      continue;
      label421:
      paramView = paramString;
    }
  }
  
  public void onClick(View paramView)
  {
    if (BubbleContextMenu.a)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof String)) {
      d = (String)localObject;
    }
    localObject = this.b;
    boolean bool2 = Patterns.d.matcher((CharSequence)localObject).find();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = Patterns.c.matcher((CharSequence)localObject).find();
    }
    if (bool1)
    {
      if (QQTextParseLinkUtil.g.matcher((CharSequence)localObject).find())
      {
        a(paramView.getContext(), (String)localObject, 2, this.a);
        d("1", null);
        return;
      }
      a(paramView, (String)localObject);
      d("0", null);
      return;
    }
    if (QQTextParseLinkUtil.a.matcher((CharSequence)localObject).find())
    {
      a(paramView.getContext(), (String)localObject, 3, this.a);
      d("2", null);
      return;
    }
    Matcher localMatcher = QQTextParseLinkUtil.c.matcher((CharSequence)localObject);
    if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
    {
      a(paramView.getContext(), (String)localObject, 0, this.a);
      d("1", null);
      return;
    }
    if (QQTextParseLinkUtil.f.matcher((CharSequence)localObject).find())
    {
      a(paramView.getContext(), (String)localObject, 1, this.a);
      d("2", null);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan
 * JD-Core Version:    0.7.0.1
 */