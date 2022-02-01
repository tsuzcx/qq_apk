package com.tencent.mobileqq.troop.widget;

import aean;
import aeau;
import aihd;
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
import bgme;
import bgty;
import bguh;
import bgwf;
import bgwg;
import bgwh;
import bgwi;
import bgwj;
import bgwk;
import bgwl;
import bgwm;
import bhgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x934.cmd0x934.List;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class RobotPanelLayoutBase
  extends RDBaseListLayout<bgwj, bgwi>
  implements View.OnClickListener, bguh
{
  protected int a;
  public bgty a;
  protected BaseChatPie a;
  public String a;
  private WeakReference<bgwl> a;
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
  
  public static bgty a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (bgty)((QQAppInterface)localAppRuntime).getManager(203);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    int i = paramContext.getResources().getInteger(2131427342);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.a(paramContext, 2131717895, 1);
      return;
    }
    boolean bool = paramBaseChatPie instanceof aihd;
    aeau localaeau = new aeau();
    localaeau.i = paramBoolean;
    if (bool)
    {
      paramString3 = bgme.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2, paramString2, paramString3, false, true);
      paramString2 = new ArrayList();
      paramString3 = bgme.a(paramString3, paramString2);
      paramString1 = paramString3 + " " + paramString1;
      aean.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString1, paramString2, localaeau);
      return;
    }
    aean.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString1, null, localaeau);
  }
  
  public bgwi a(int paramInt, bgwj parambgwj)
  {
    parambgwj = new bgwi();
    View localView = LayoutInflater.from(getContext()).inflate(2131560670, null, false);
    localView.setOnClickListener(this);
    parambgwj.a(localView);
    parambgwj.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368866);
    parambgwj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378618));
    localView.setTag(parambgwj);
    return parambgwj;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(bgwj parambgwj)
  {
    return null;
  }
  
  public ArrayList<bgwj> a(cmd0x934.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = new ArrayList(paramRspBody.lists.size());
    int i = 0;
    while (i < paramRspBody.lists.size())
    {
      ((ArrayList)localObject).add(bgwm.a((cmd0x934.List)paramRspBody.lists.get(i)));
      i += 1;
    }
    paramRspBody = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRspBody.addAll(((bgwm)((Iterator)localObject).next()).a);
    }
    return paramRspBody;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bgty != null) {
      this.jdField_a_of_type_Bgty.a(null);
    }
  }
  
  public void a(int paramInt, bgwj parambgwj) {}
  
  public void a(int paramInt, bgwj parambgwj, bgwi parambgwi)
  {
    if (parambgwj.a())
    {
      bgty localbgty = a();
      if (localbgty == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      parambgwj.jdField_b_of_type_Boolean = localbgty.a();
    }
    if (parambgwj.jdField_b_of_type_Boolean) {}
    for (parambgwj = parambgwj.jdField_b_of_type_Bgwk;; parambgwj = parambgwj.a)
    {
      parambgwi.jdField_a_of_type_AndroidWidgetTextView.setText(parambgwj.jdField_a_of_type_JavaLangString);
      a(parambgwi);
      return;
    }
  }
  
  protected void a(bgwi parambgwi)
  {
    int i = bhgr.a(getContext(), 0.5F);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(bhgr.a(getContext(), 20.0F));
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(bhgr.a(getContext(), 20.0F));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambgwi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
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
      parambgwi.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
      return;
      parambgwi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
  }
  
  public void a(bgwj parambgwj) {}
  
  public void a(bgwj parambgwj, String paramString) {}
  
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
    paramString5 = bgwj.a(paramString7, paramString6, paramString5, paramString4);
    paramString6 = paramString5.a.jdField_a_of_type_JavaLangString;
    c(paramString5, paramString6);
    if (!TextUtils.isEmpty(paramString5.jdField_b_of_type_Bgwk.jdField_a_of_type_JavaLangString)) {
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
        break label409;
      }
    }
    label409:
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
      bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbgwl != null) {
        localbgwl.a(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, BaseChatPie paramBaseChatPie, bgwh parambgwh)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, bgwj parambgwj)
  {
    if ((parambgwj == null) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_Bgty == null)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new bgwf(this, parambgwj);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bgty.a(l2, paramString3, paramString2);
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
        this.jdField_a_of_type_Bgty.a(l1, l2, paramString3, paramString2);
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
    int i = 2130850039;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130849842;
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
  
  public void b(bgwj parambgwj) {}
  
  public void b(bgwj parambgwj, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, bgwj parambgwj)
  {
    if ((this.jdField_a_of_type_Bgty == null) || (TextUtils.isEmpty(paramString3)) || (parambgwj == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new bgwg(this, parambgwj);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bgty.b(l2, paramString3, paramString2);
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
        this.jdField_a_of_type_Bgty.b(l1, l2, paramString3, paramString2);
      }
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c(bgwj parambgwj, String paramString) {}
  
  public void d()
  {
    this.jdField_a_of_type_Bgty = a();
    if (this.jdField_a_of_type_Bgty != null) {
      this.jdField_a_of_type_Bgty.a(this);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
  }
  
  public void d(bgwj parambgwj, String paramString) {}
  
  public void e()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    bgwj localbgwj = (bgwj)a(a(paramView));
    if (localbgwj == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = localbgwj.a.jdField_a_of_type_JavaLangString;
    a(localbgwj, str);
    Object localObject;
    if (!TextUtils.isEmpty(localbgwj.jdField_b_of_type_Bgwk.jdField_a_of_type_JavaLangString)) {
      localObject = a(localbgwj);
    }
    for (;;)
    {
      b(localbgwj, (String)localObject);
      a((String)localObject);
      break;
      if (localbgwj.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        a(localbgwj);
        localObject = str;
      }
      else if (localbgwj.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        b(localbgwj);
        localObject = str;
      }
      else
      {
        localObject = str;
        if (localbgwj.a.c.startsWith("http"))
        {
          localObject = new Intent(getContext(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localbgwj.a.c);
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
  
  public void setListener(bgwl parambgwl)
  {
    if (parambgwl == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambgwl);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      a(false);
      this.jdField_a_of_type_JavaLangString = null;
      this.b = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotPanelLayoutBase", 2, "setVisibility:" + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aw();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */