package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.OnTalkingChangeListener;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x934.cmd0x934.List;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class RobotPanelLayoutBase
  extends RDBaseListLayout<RobotPanelLayoutBase.RobotPanelItemData, RobotPanelLayoutBase.ItemViewHolder>
  implements View.OnClickListener, ITroopRobotService.OnTalkingChangeListener
{
  protected String a;
  protected String b;
  protected AIOShortcutBarContext c;
  protected int d = 0;
  protected ITroopRobotService e;
  private WeakReference<RobotPanelLayoutBase.RobotPanelLayoutListener> f = null;
  
  public RobotPanelLayoutBase(Context paramContext)
  {
    super(paramContext);
    b(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, AIOShortcutBarContext paramAIOShortcutBarContext)
  {
    int i = paramContext.getResources().getInteger(2131492891);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.a(paramContext, 2131916265, 1);
      return;
    }
    if ((paramAIOShortcutBarContext.c() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAIOShortcutBarContext.c();
      boolean bool = paramAIOShortcutBarContext.b();
      ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
      localSendMsgParams.y = paramBoolean;
      if (bool)
      {
        paramString3 = AtTroopMemberSpan.a(localQQAppInterface, paramContext, paramString2, paramString2, paramString3, false, true);
        paramString2 = new ArrayList();
        paramString3 = AtTroopMemberSpan.a(paramString3, paramString2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString3);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder.toString();
        ChatActivityFacade.a(localQQAppInterface, paramContext, paramAIOShortcutBarContext.d(), paramString1, paramString2, localSendMsgParams);
        return;
      }
      ChatActivityFacade.a(localQQAppInterface, paramContext, paramAIOShortcutBarContext.d(), paramString1, null, localSendMsgParams);
      return;
    }
    QLog.e("RobotPanelLayoutBase", 1, "AppRuntime cast error");
  }
  
  public static ITroopRobotService getTroopRobotService()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (ITroopRobotService)((QQAppInterface)localAppRuntime).getRuntimeService(ITroopRobotService.class, "all");
    }
    return null;
  }
  
  public String a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    return null;
  }
  
  protected ArrayList<RobotPanelLayoutBase.RobotPanelItemData> a(cmd0x934.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = new ArrayList(paramRspBody.lists.size());
    int i = 0;
    while (i < paramRspBody.lists.size())
    {
      ((ArrayList)localObject).add(RobotPanelLayoutBase.RobotPanelListData.a((cmd0x934.List)paramRspBody.lists.get(i)));
      i += 1;
    }
    paramRspBody = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRspBody.addAll(((RobotPanelLayoutBase.RobotPanelListData)((Iterator)localObject).next()).b);
    }
    return paramRspBody;
  }
  
  public void a(int paramInt, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void a(int paramInt, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, RobotPanelLayoutBase.ItemViewHolder paramItemViewHolder)
  {
    if (paramRobotPanelItemData.a())
    {
      ITroopRobotService localITroopRobotService = getTroopRobotService();
      if (localITroopRobotService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      paramRobotPanelItemData.d = localITroopRobotService.isTalking();
    }
    if (paramRobotPanelItemData.d) {
      paramRobotPanelItemData = paramRobotPanelItemData.b;
    } else {
      paramRobotPanelItemData = paramRobotPanelItemData.a;
    }
    paramItemViewHolder.b.setText(paramRobotPanelItemData.a);
    setItemBackgroundDrawable(paramItemViewHolder);
  }
  
  public void a(AIOShortcutBarContext paramAIOShortcutBarContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((paramAIOShortcutBarContext != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (TextUtils.isEmpty(paramString5)) {
        return;
      }
      if (getTroopRobotService() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      paramString5 = RobotPanelLayoutBase.RobotPanelItemData.a(paramString7, paramString6, paramString5, paramString4);
      paramString6 = paramString5.a.a;
      c(paramString5, paramString6);
      if (!TextUtils.isEmpty(paramString5.b.a))
      {
        if (QLog.isColorLevel())
        {
          paramAIOShortcutBarContext = new StringBuilder();
          paramAIOShortcutBarContext.append("talking: ");
          paramAIOShortcutBarContext.append(paramString6);
          QLog.d("RobotPanelLayoutBase", 2, paramAIOShortcutBarContext.toString());
        }
      }
      else if (paramString5.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        a(getContext(), paramString5.a.a, paramString2, paramString3, false, paramAIOShortcutBarContext);
        if (QLog.isColorLevel())
        {
          paramAIOShortcutBarContext = new StringBuilder();
          paramAIOShortcutBarContext.append("send to robot: ");
          paramAIOShortcutBarContext.append(paramString5.a.a);
          QLog.d("RobotPanelLayoutBase", 2, paramAIOShortcutBarContext.toString());
        }
      }
      else if (paramString5.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        paramString4 = null;
        int i = paramString5.a.c.indexOf("content=");
        if (i > 0) {
          paramString4 = paramString5.a.c.substring(i + 8);
        }
        a(getContext(), paramString5.a.a, paramString2, paramString3, true, paramAIOShortcutBarContext);
        a(paramString1, paramString2, paramString4, paramString5);
        if (QLog.isColorLevel())
        {
          paramAIOShortcutBarContext = new StringBuilder();
          paramAIOShortcutBarContext.append("send to server: ");
          paramAIOShortcutBarContext.append(paramString5.a.a);
          QLog.d("RobotPanelLayoutBase", 2, paramAIOShortcutBarContext.toString());
        }
      }
      else if (paramString5.a.c.startsWith("http"))
      {
        paramAIOShortcutBarContext = new Intent(getContext(), QQBrowserActivity.class);
        paramAIOShortcutBarContext.putExtra("url", paramString5.a.c);
        getContext().startActivity(paramAIOShortcutBarContext);
      }
      d(paramString5, paramString6);
    }
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  protected void a(String paramString)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (RobotPanelLayoutBase.RobotPanelLayoutListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((RobotPanelLayoutBase.RobotPanelLayoutListener)localObject).a(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, AIOShortcutBarContext paramAIOShortcutBarContext, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback)
  {
    this.c = paramAIOShortcutBarContext;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if ((paramRobotPanelItemData != null) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      if (this.e == null) {
        return;
      }
    }
    try
    {
      l2 = Long.valueOf(paramString1).longValue();
      l1 = Long.valueOf(paramString2).longValue();
      l3 = l1;
    }
    catch (Exception localException)
    {
      long l2;
      long l1;
      long l3;
      label59:
      StringBuilder localStringBuilder;
      break label59;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendContent exception:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    QLog.e("RobotPanelLayoutBase", 2, localStringBuilder.toString());
    l1 = -1L;
    l3 = l1;
    l2 = l1;
    if (l2 != -1L)
    {
      if (l3 == -1L) {
        return;
      }
      paramString2 = new RobotPanelLayoutBase.1(this, paramRobotPanelItemData);
      if ("1".equals(paramString1))
      {
        this.e.sendContent(l3, paramString3, paramString2);
        return;
      }
      this.e.sendContent(l2, l3, paramString3, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    f();
  }
  
  public boolean a()
  {
    e();
    setOverScrollMode(0);
    int i = 2130852165;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130851968;
      }
      setBackgroundResource(i);
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    QLog.e("RobotPanelLayoutBase", 2, "onInit setBackgroundResource exception");
    return true;
  }
  
  public RobotPanelLayoutBase.ItemViewHolder b(int paramInt, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    paramRobotPanelItemData = new RobotPanelLayoutBase.ItemViewHolder();
    View localView = LayoutInflater.from(getContext()).inflate(2131626742, null, false);
    localView.setOnClickListener(this);
    paramRobotPanelItemData.a(localView);
    paramRobotPanelItemData.a = localView.findViewById(2131435970);
    paramRobotPanelItemData.b = ((TextView)localView.findViewById(2131447090));
    localView.setTag(paramRobotPanelItemData);
    return paramRobotPanelItemData;
  }
  
  public void b()
  {
    this.f = null;
    ITroopRobotService localITroopRobotService = this.e;
    if (localITroopRobotService != null) {
      localITroopRobotService.setOnTalkingChangeListener(null);
    }
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if ((this.e != null) && (!TextUtils.isEmpty(paramString3)) && (paramRobotPanelItemData != null) && (!TextUtils.isEmpty(paramString2))) {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
    }
    try
    {
      l2 = Long.valueOf(paramString1).longValue();
      l1 = Long.valueOf(paramString2).longValue();
      l3 = l1;
    }
    catch (Exception localException)
    {
      long l2;
      long l1;
      long l3;
      label59:
      StringBuilder localStringBuilder;
      break label59;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestGrayTips exception:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    QLog.e("RobotPanelLayoutBase", 2, localStringBuilder.toString());
    l1 = -1L;
    l3 = l1;
    l2 = l1;
    if (l2 != -1L)
    {
      if (l3 == -1L) {
        return;
      }
      paramString2 = new RobotPanelLayoutBase.2(this, paramRobotPanelItemData);
      if ("1".equals(paramString1))
      {
        this.e.reqGrayTips(l3, paramString3, paramString2);
        return;
      }
      this.e.reqGrayTips(l2, l3, paramString3, paramString2);
    }
  }
  
  public void c(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void c(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  public void d(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  public void e()
  {
    this.e = getTroopRobotService();
    ITroopRobotService localITroopRobotService = this.e;
    if (localITroopRobotService != null)
    {
      localITroopRobotService.setOnTalkingChangeListener(this);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RobotPanelLayoutBase", 2, "mTroopRobotServive = null");
    }
  }
  
  public void f()
  {
    d();
  }
  
  public String getCurrentRobotUin()
  {
    return this.a;
  }
  
  public int getInputLineCount()
  {
    return this.d;
  }
  
  public void onClick(View paramView)
  {
    RobotPanelLayoutBase.RobotPanelItemData localRobotPanelItemData = (RobotPanelLayoutBase.RobotPanelItemData)c(a(paramView));
    if (localRobotPanelItemData != null)
    {
      String str = localRobotPanelItemData.a.a;
      a(localRobotPanelItemData, str);
      Object localObject;
      if (!TextUtils.isEmpty(localRobotPanelItemData.b.a))
      {
        localObject = a(localRobotPanelItemData);
      }
      else if (localRobotPanelItemData.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        b(localRobotPanelItemData);
        localObject = str;
      }
      else if (localRobotPanelItemData.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        c(localRobotPanelItemData);
        localObject = str;
      }
      else
      {
        localObject = str;
        if (localRobotPanelItemData.a.c.startsWith("http"))
        {
          localObject = new Intent(getContext(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localRobotPanelItemData.a.c);
          getContext().startActivity((Intent)localObject);
          localObject = str;
        }
      }
      b(localRobotPanelItemData, (String)localObject);
      a((String)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setInputLineCount(int paramInt)
  {
    this.d = paramInt;
  }
  
  protected void setItemBackgroundDrawable(RobotPanelLayoutBase.ItemViewHolder paramItemViewHolder)
  {
    int i = DisplayUtil.a(getContext(), 0.5F);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(DisplayUtil.a(getContext(), 20.0F));
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(DisplayUtil.a(getContext(), 20.0F));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramItemViewHolder.b.setTextColor(Color.parseColor("#737373"));
      localGradientDrawable1.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColorFilter(Color.argb(126, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#1F1F1F"));
    }
    else
    {
      paramItemViewHolder.b.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(new int[0], localGradientDrawable1);
    paramItemViewHolder.a.setBackgroundDrawable(localStateListDrawable);
  }
  
  public void setListener(RobotPanelLayoutBase.RobotPanelLayoutListener paramRobotPanelLayoutListener)
  {
    if (paramRobotPanelLayoutListener == null)
    {
      this.f = null;
      return;
    }
    this.f = new WeakReference(paramRobotPanelLayoutListener);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      a(false);
      this.a = null;
      this.b = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisibility:");
      localStringBuilder.append(paramInt);
      QLog.e("RobotPanelLayoutBase", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */