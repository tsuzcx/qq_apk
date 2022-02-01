package com.tencent.mobileqq.troop.widget;

import admh;
import admo;
import afzn;
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
import bgcz;
import bgls;
import bgmb;
import bgny;
import bgnz;
import bgoa;
import bgob;
import bgoc;
import bgod;
import bgoe;
import bgof;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x934.cmd0x934.List;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class RobotPanelLayoutBase
  extends RDBaseListLayout<bgoc, bgob>
  implements View.OnClickListener, bgmb
{
  protected int a;
  public bgls a;
  protected BaseChatPie a;
  public String a;
  private WeakReference<bgoe> a;
  public String b;
  
  public RobotPanelLayoutBase(Context paramContext)
  {
    super(paramContext);
    a(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(1);
  }
  
  public RobotPanelLayoutBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(1);
  }
  
  public static bgls a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (bgls)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    int i = paramContext.getResources().getInteger(2131427342);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.a(paramContext, 2131718520, 1);
      return;
    }
    boolean bool = paramBaseChatPie instanceof afzn;
    admo localadmo = new admo();
    localadmo.i = paramBoolean;
    if (bool)
    {
      paramString3 = bgcz.a(paramBaseChatPie.app, paramContext, paramString2, paramString2, paramString3, false, true);
      paramString2 = new ArrayList();
      paramString3 = bgcz.a(paramString3, paramString2);
      paramString1 = paramString3 + " " + paramString1;
      admh.a(paramBaseChatPie.app, paramContext, paramBaseChatPie.sessionInfo, paramString1, paramString2, localadmo);
      return;
    }
    admh.a(paramBaseChatPie.app, paramContext, paramBaseChatPie.sessionInfo, paramString1, null, localadmo);
  }
  
  public bgob a(int paramInt, bgoc parambgoc)
  {
    parambgoc = new bgob();
    View localView = LayoutInflater.from(getContext()).inflate(2131560734, null, false);
    localView.setOnClickListener(this);
    parambgoc.a(localView);
    parambgoc.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369049);
    parambgoc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378673));
    localView.setTag(parambgoc);
    return parambgoc;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(bgoc parambgoc)
  {
    return null;
  }
  
  public ArrayList<bgoc> a(cmd0x934.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = new ArrayList(paramRspBody.lists.size());
    int i = 0;
    while (i < paramRspBody.lists.size())
    {
      ((ArrayList)localObject).add(bgof.a((cmd0x934.List)paramRspBody.lists.get(i)));
      i += 1;
    }
    paramRspBody = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRspBody.addAll(((bgof)((Iterator)localObject).next()).a);
    }
    return paramRspBody;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bgls != null) {
      this.jdField_a_of_type_Bgls.a(null);
    }
  }
  
  public void a(int paramInt, bgoc parambgoc) {}
  
  public void a(int paramInt, bgoc parambgoc, bgob parambgob)
  {
    if (parambgoc.a())
    {
      bgls localbgls = a();
      if (localbgls == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      parambgoc.jdField_b_of_type_Boolean = localbgls.a();
    }
    if (parambgoc.jdField_b_of_type_Boolean) {}
    for (parambgoc = parambgoc.jdField_b_of_type_Bgod;; parambgoc = parambgoc.a)
    {
      parambgob.jdField_a_of_type_AndroidWidgetTextView.setText(parambgoc.jdField_a_of_type_JavaLangString);
      a(parambgob);
      return;
    }
  }
  
  protected void a(bgob parambgob)
  {
    int i = DisplayUtil.dip2px(getContext(), 0.5F);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(DisplayUtil.dip2px(getContext(), 20.0F));
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(DisplayUtil.dip2px(getContext(), 20.0F));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambgob.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      localGradientDrawable1.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColor(Color.parseColor("#1F1F1F"));
      localGradientDrawable2.setColorFilter(Color.argb(126, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#1F1F1F"));
    }
    for (;;)
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      parambgob.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
      return;
      parambgob.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
  }
  
  public void a(bgoc parambgoc) {}
  
  public void a(bgoc parambgoc, String paramString) {}
  
  public void a(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((paramBaseChatPie == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {}
    do
    {
      return;
      if (a() != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
    return;
    paramString5 = bgoc.a(paramString7, paramString6, paramString5, paramString4);
    paramString6 = paramString5.a.jdField_a_of_type_JavaLangString;
    c(paramString5, paramString6);
    if (!TextUtils.isEmpty(paramString5.jdField_b_of_type_Bgod.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("RobotPanelLayoutBase", 2, "talking: " + paramString6);
      }
    }
    for (;;)
    {
      d(paramString5, paramString6);
      return;
      if (!paramString5.a.c.startsWith("inputKeyOp://sendToRobot")) {
        break;
      }
      a(getContext(), paramString5.a.jdField_a_of_type_JavaLangString, paramString2, paramString3, false, paramBaseChatPie);
      if (QLog.isColorLevel()) {
        QLog.d("RobotPanelLayoutBase", 2, "send to robot: " + paramString5.a.jdField_a_of_type_JavaLangString);
      }
    }
    int i;
    if (paramString5.a.c.startsWith("inputKeyOp://sendToBackEnd"))
    {
      i = paramString5.a.c.indexOf("content=");
      if (i <= 0) {
        break label414;
      }
    }
    label414:
    for (paramString4 = paramString5.a.c.substring(i + 8);; paramString4 = null)
    {
      a(getContext(), paramString5.a.jdField_a_of_type_JavaLangString, paramString2, paramString3, true, paramBaseChatPie);
      a(paramString1, paramString2, paramString4, paramString5);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotPanelLayoutBase", 2, "send to server: " + paramString5.a.jdField_a_of_type_JavaLangString);
      break;
      if (!paramString5.a.c.startsWith("http")) {
        break;
      }
      paramBaseChatPie = new Intent(getContext(), QQBrowserActivity.class);
      paramBaseChatPie.putExtra("url", paramString5.a.c);
      getContext().startActivity(paramBaseChatPie);
      break;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bgoe localbgoe = (bgoe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbgoe != null) {
        localbgoe.a(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, BaseChatPie paramBaseChatPie, bgoa parambgoa)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, bgoc parambgoc)
  {
    if ((parambgoc == null) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_Bgls == null)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new bgny(this, parambgoc);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bgls.a(l2, paramString3, paramString2);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        for (;;)
        {
          QLog.e("RobotPanelLayoutBase", 2, "sendContent exception:" + paramString1 + ":" + paramString2);
          l2 = -1L;
          l1 = -1L;
        }
        this.jdField_a_of_type_Bgls.a(l1, l2, paramString3, paramString2);
      }
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
    int i = 2130850049;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130849852;
      }
      setBackgroundResource(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("RobotPanelLayoutBase", 2, "onInit setBackgroundResource exception");
      }
    }
    return true;
  }
  
  public void b(bgoc parambgoc) {}
  
  public void b(bgoc parambgoc, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, bgoc parambgoc)
  {
    if ((this.jdField_a_of_type_Bgls == null) || (TextUtils.isEmpty(paramString3)) || (parambgoc == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new bgnz(this, parambgoc);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bgls.b(l2, paramString3, paramString2);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        for (;;)
        {
          QLog.e("RobotPanelLayoutBase", 2, "requestGrayTips exception:" + paramString1 + ":" + paramString2);
          l2 = -1L;
          l1 = -1L;
        }
        this.jdField_a_of_type_Bgls.b(l1, l2, paramString3, paramString2);
      }
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c(bgoc parambgoc, String paramString) {}
  
  public void d()
  {
    this.jdField_a_of_type_Bgls = a();
    if (this.jdField_a_of_type_Bgls != null) {
      this.jdField_a_of_type_Bgls.a(this);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
  }
  
  public void d(bgoc parambgoc, String paramString) {}
  
  public void e()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    bgoc localbgoc = (bgoc)a(a(paramView));
    if (localbgoc == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = localbgoc.a.jdField_a_of_type_JavaLangString;
    a(localbgoc, str);
    Object localObject;
    if (!TextUtils.isEmpty(localbgoc.jdField_b_of_type_Bgod.jdField_a_of_type_JavaLangString)) {
      localObject = a(localbgoc);
    }
    for (;;)
    {
      b(localbgoc, (String)localObject);
      a((String)localObject);
      break;
      if (localbgoc.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        a(localbgoc);
        localObject = str;
      }
      else if (localbgoc.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        b(localbgoc);
        localObject = str;
      }
      else
      {
        localObject = str;
        if (localbgoc.a.c.startsWith("http"))
        {
          localObject = new Intent(getContext(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localbgoc.a.c);
          getContext().startActivity((Intent)localObject);
          localObject = str;
        }
      }
    }
  }
  
  public void setInputLineCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(bgoe parambgoe)
  {
    if (parambgoe == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambgoe);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      a(false);
      this.jdField_a_of_type_JavaLangString = null;
      this.b = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.resumeAppShorcutBar();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotPanelLayoutBase", 2, "setVisibility:" + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideAppShortcutBar();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */