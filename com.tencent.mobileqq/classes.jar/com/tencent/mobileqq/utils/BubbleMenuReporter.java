package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;

public class BubbleMenuReporter
  implements QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback
{
  private static int b = 100;
  private static Map<String, Integer> c = new BubbleMenuReporter.1();
  int a = -1;
  private ChatMessage d = null;
  private LinearLayout e;
  private View f;
  
  public BubbleMenuReporter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener instanceof ChatAdapter1.BubbleOnlongClickListener)) {
      this.d = ((ChatAdapter1.BubbleOnlongClickListener)paramOnClickListener).a();
    }
    this.e = new LinearLayout(paramContext);
    VideoReport.setPageId(this.e, "pg_aio_menu");
    this.f = new View(paramContext);
    this.e.addView(this.f);
    VideoReport.setElementId(this.f, "em_aio_menu_button");
    paramContext = d();
    VideoReport.setPageParams(this.e, new PageParams(paramContext));
    QLog.d("BubbleMenuReporter", 1, "doDTReportForPageIn");
    VideoReport.reportEvent("pgin", this.e, paramContext);
  }
  
  private void a(int paramInt, String paramString)
  {
    paramString = c(paramInt, paramString);
    QLog.d("BubbleMenuReporter", 1, "doDTReportForMenuClick");
    VideoReport.reportEvent("clck", this.f, paramString);
  }
  
  private void a(String paramString)
  {
    if (this.a < 0) {
      b();
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, this.a, 0, "", "", "", "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.a < 0) {
      b();
    }
    Integer localInteger2 = (Integer)c.get(paramString2);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(b);
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, localInteger1.intValue(), 0, String.valueOf(this.a), "", "", "");
    if ((paramString2 != null) && (paramString2.equals(MobileQQ.getContext().getResources().getString(2131897701))))
    {
      paramString2 = MobileReportManager.getInstance();
      int i;
      if (paramString1.equals("0X800B3BE")) {
        i = 101;
      } else {
        i = 102;
      }
      paramString2.reportAction("similar_emoji", "4", "platform898", "6", "2", i, 1, System.currentTimeMillis());
    }
  }
  
  private void b()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (((localBaseActivity instanceof BaseActivity)) && (localBaseActivity.getChatFragment() != null)) {
      i = localBaseActivity.getChatFragment().k().ah.a;
    } else {
      i = -1;
    }
    int i = Integer.parseInt(ChatActivityUtils.c(i));
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          this.a = 4;
          return;
        }
        this.a = 2;
        return;
      }
      this.a = 3;
      return;
    }
    this.a = 1;
  }
  
  private void b(int paramInt, String paramString)
  {
    paramString = c(paramInt, paramString);
    QLog.d("BubbleMenuReporter", 1, "doDTReportForMenuCreate");
    VideoReport.reportEvent("imp", this.f, paramString);
  }
  
  @NotNull
  private HashMap<String, String> c(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("aio_menu_name_button", paramString);
    localHashMap.put("aio_menu_location_button", String.valueOf(paramInt));
    QLog.d("BubbleMenuReporter", 1, new Object[] { "report menu element params, element_id = ", "em_aio_menu_button", ", button_title = ", paramString, ", button_location = ", Integer.valueOf(paramInt) });
    return localHashMap;
  }
  
  private void c()
  {
    HashMap localHashMap = d();
    QLog.d("BubbleMenuReporter", 1, "doDTReportForPageDismiss");
    VideoReport.reportEvent("pgout", this.e, localHashMap);
  }
  
  private HashMap<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pgid", "pg_aio_menu");
    Object localObject = BaseActivity.sTopActivity;
    int i;
    if ((localObject != null) && (((BaseActivity)localObject).getChatFragment() != null))
    {
      localObject = ((BaseActivity)localObject).getChatFragment().k();
      i = ((BaseChatPie)localObject).ah.a;
      localObject = ((BaseChatPie)localObject).ah.b;
    }
    else
    {
      i = -1;
      localObject = "";
    }
    localHashMap.put("uin_to", localObject);
    localHashMap.put("type_aio_pg", String.valueOf(AIODtReportHelper.a(i)));
    ChatMessage localChatMessage = this.d;
    int j;
    if (localChatMessage != null) {
      j = localChatMessage.msgtype;
    } else {
      j = 0;
    }
    localHashMap.put("msg_type", String.valueOf(j));
    QLog.d("BubbleMenuReporter", 1, new Object[] { "report menu page params, pg_id = ", "pg_aio_menu", ", uin = ", LogUtil.wrapLogUin((String)localObject), ", aio_type = ", Integer.valueOf(i), ", msg_type = ", Integer.valueOf(j) });
    return localHashMap;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt, QQCustomMenuItem paramQQCustomMenuItem)
  {
    a("0X800B3BF", paramQQCustomMenuItem.a());
    a(paramInt, paramQQCustomMenuItem.a());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X800B3C0";
    } else {
      str = "0X800B3C2";
    }
    a(str);
    if (paramBoolean) {
      str = "下一页";
    } else {
      str = "上一页";
    }
    b(paramInt, str);
  }
  
  public void b(int paramInt, QQCustomMenuItem paramQQCustomMenuItem)
  {
    a("0X800B3BE", paramQQCustomMenuItem.a());
    b(paramInt, paramQQCustomMenuItem.a());
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X800B3C1";
    } else {
      str = "0X800B3C3";
    }
    a(str);
    if (paramBoolean) {
      str = "下一页";
    } else {
      str = "上一页";
    }
    a(paramInt, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleMenuReporter
 * JD-Core Version:    0.7.0.1
 */