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
  protected int a;
  protected AIOShortcutBarContext a;
  protected ITroopRobotService a;
  protected String a;
  private WeakReference<RobotPanelLayoutBase.RobotPanelLayoutListener> a;
  protected String b;
  
  public RobotPanelLayoutBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    a(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    a(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    a(1);
  }
  
  public static ITroopRobotService a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (ITroopRobotService)((QQAppInterface)localAppRuntime).getRuntimeService(ITroopRobotService.class, "all");
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, AIOShortcutBarContext paramAIOShortcutBarContext)
  {
    int i = paramContext.getResources().getInteger(2131427346);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.a(paramContext, 2131718759, 1);
      return;
    }
    if ((paramAIOShortcutBarContext.a() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAIOShortcutBarContext.a();
      boolean bool = paramAIOShortcutBarContext.a();
      ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
      localSendMsgParams.i = paramBoolean;
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
        ChatActivityFacade.a(localQQAppInterface, paramContext, paramAIOShortcutBarContext.a(), paramString1, paramString2, localSendMsgParams);
        return;
      }
      ChatActivityFacade.a(localQQAppInterface, paramContext, paramAIOShortcutBarContext.a(), paramString1, null, localSendMsgParams);
      return;
    }
    QLog.e("RobotPanelLayoutBase", 1, "AppRuntime cast error");
  }
  
  public RobotPanelLayoutBase.ItemViewHolder a(int paramInt, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    paramRobotPanelItemData = new RobotPanelLayoutBase.ItemViewHolder();
    View localView = LayoutInflater.from(getContext()).inflate(2131560697, null, false);
    localView.setOnClickListener(this);
    paramRobotPanelItemData.a(localView);
    paramRobotPanelItemData.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369010);
    paramRobotPanelItemData.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378476));
    localView.setTag(paramRobotPanelItemData);
    return paramRobotPanelItemData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
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
      paramRspBody.addAll(((RobotPanelLayoutBase.RobotPanelListData)((Iterator)localObject).next()).a);
    }
    return paramRspBody;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    ITroopRobotService localITroopRobotService = this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService;
    if (localITroopRobotService != null) {
      localITroopRobotService.setOnTalkingChangeListener(null);
    }
  }
  
  public void a(int paramInt, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void a(int paramInt, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, RobotPanelLayoutBase.ItemViewHolder paramItemViewHolder)
  {
    if (paramRobotPanelItemData.a())
    {
      ITroopRobotService localITroopRobotService = a();
      if (localITroopRobotService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      paramRobotPanelItemData.jdField_b_of_type_Boolean = localITroopRobotService.isTalking();
    }
    if (paramRobotPanelItemData.jdField_b_of_type_Boolean) {
      paramRobotPanelItemData = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData;
    } else {
      paramRobotPanelItemData = paramRobotPanelItemData.a;
    }
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramRobotPanelItemData.jdField_a_of_type_JavaLangString);
    a(paramItemViewHolder);
  }
  
  public void a(AIOShortcutBarContext paramAIOShortcutBarContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((paramAIOShortcutBarContext != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (TextUtils.isEmpty(paramString5)) {
        return;
      }
      if (a() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      paramString5 = RobotPanelLayoutBase.RobotPanelItemData.a(paramString7, paramString6, paramString5, paramString4);
      paramString6 = paramString5.a.jdField_a_of_type_JavaLangString;
      c(paramString5, paramString6);
      if (!TextUtils.isEmpty(paramString5.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString))
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
        a(getContext(), paramString5.a.jdField_a_of_type_JavaLangString, paramString2, paramString3, false, paramAIOShortcutBarContext);
        if (QLog.isColorLevel())
        {
          paramAIOShortcutBarContext = new StringBuilder();
          paramAIOShortcutBarContext.append("send to robot: ");
          paramAIOShortcutBarContext.append(paramString5.a.jdField_a_of_type_JavaLangString);
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
        a(getContext(), paramString5.a.jdField_a_of_type_JavaLangString, paramString2, paramString3, true, paramAIOShortcutBarContext);
        a(paramString1, paramString2, paramString4, paramString5);
        if (QLog.isColorLevel())
        {
          paramAIOShortcutBarContext = new StringBuilder();
          paramAIOShortcutBarContext.append("send to server: ");
          paramAIOShortcutBarContext.append(paramString5.a.jdField_a_of_type_JavaLangString);
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
  
  protected void a(RobotPanelLayoutBase.ItemViewHolder paramItemViewHolder)
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
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      localGradientDrawable1.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColorFilter(Color.argb(126, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#1F1F1F"));
    }
    else
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(new int[0], localGradientDrawable1);
    paramItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  protected void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if ((paramRobotPanelItemData != null) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService == null) {
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
        this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.sendContent(l3, paramString3, paramString2);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.sendContent(l2, l3, paramString3, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    e();
  }
  
  public boolean a()
  {
    d();
    setOverScrollMode(0);
    int i = 2130850374;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130850177;
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
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService != null) && (!TextUtils.isEmpty(paramString3)) && (paramRobotPanelItemData != null) && (!TextUtils.isEmpty(paramString2))) {
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
        this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.reqGrayTips(l3, paramString3, paramString2);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.reqGrayTips(l2, l3, paramString3, paramString2);
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService = a();
    ITroopRobotService localITroopRobotService = this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService;
    if (localITroopRobotService != null)
    {
      localITroopRobotService.setOnTalkingChangeListener(this);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RobotPanelLayoutBase", 2, "mTroopRobotServive = null");
    }
  }
  
  public void d(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString) {}
  
  public void e()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    RobotPanelLayoutBase.RobotPanelItemData localRobotPanelItemData = (RobotPanelLayoutBase.RobotPanelItemData)a(a(paramView));
    if (localRobotPanelItemData != null)
    {
      String str = localRobotPanelItemData.a.jdField_a_of_type_JavaLangString;
      a(localRobotPanelItemData, str);
      Object localObject;
      if (!TextUtils.isEmpty(localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString))
      {
        localObject = a(localRobotPanelItemData);
      }
      else if (localRobotPanelItemData.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        a(localRobotPanelItemData);
        localObject = str;
      }
      else if (localRobotPanelItemData.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        b(localRobotPanelItemData);
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
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(RobotPanelLayoutBase.RobotPanelLayoutListener paramRobotPanelLayoutListener)
  {
    if (paramRobotPanelLayoutListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRobotPanelLayoutListener);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      a(false);
      this.jdField_a_of_type_JavaLangString = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */