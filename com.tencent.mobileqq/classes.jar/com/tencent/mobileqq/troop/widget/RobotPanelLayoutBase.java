package com.tencent.mobileqq.troop.widget;

import aanz;
import aaog;
import aemd;
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
import bafv;
import bamk;
import bamt;
import baoq;
import baor;
import baos;
import baot;
import baou;
import baov;
import baow;
import baox;
import baxn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x934.cmd0x934.List;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class RobotPanelLayoutBase
  extends RDBaseListLayout<baou, baot>
  implements View.OnClickListener, bamt
{
  protected int a;
  public bamk a;
  protected BaseChatPie a;
  public String a;
  private WeakReference<baow> a;
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
  
  public static bamk a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (bamk)((QQAppInterface)localAppRuntime).getManager(203);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    int i = paramContext.getResources().getInteger(2131427342);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.a(paramContext, 2131719284, 1);
      return;
    }
    boolean bool = paramBaseChatPie instanceof aemd;
    aaog localaaog = new aaog();
    localaaog.i = paramBoolean;
    if (bool)
    {
      paramString3 = bafv.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2, paramString2, paramString3, false, true);
      paramString2 = new ArrayList();
      paramString3 = bafv.a(paramString3, paramString2);
      paramString1 = paramString3 + " " + paramString1;
      aanz.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString1, paramString2, localaaog);
      return;
    }
    aanz.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString1, null, localaaog);
  }
  
  public baot a(int paramInt, baou parambaou)
  {
    parambaou = new baot();
    View localView = LayoutInflater.from(getContext()).inflate(2131560395, null, false);
    localView.setOnClickListener(this);
    parambaou.a(localView);
    parambaou.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368325);
    parambaou.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377046));
    localView.setTag(parambaou);
    return parambaou;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(baou parambaou)
  {
    return null;
  }
  
  public ArrayList<baou> a(cmd0x934.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = new ArrayList(paramRspBody.lists.size());
    int i = 0;
    while (i < paramRspBody.lists.size())
    {
      ((ArrayList)localObject).add(baox.a((cmd0x934.List)paramRspBody.lists.get(i)));
      i += 1;
    }
    paramRspBody = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRspBody.addAll(((baox)((Iterator)localObject).next()).a);
    }
    return paramRspBody;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bamk != null) {
      this.jdField_a_of_type_Bamk.a(null);
    }
  }
  
  public void a(int paramInt, baou parambaou) {}
  
  public void a(int paramInt, baou parambaou, baot parambaot)
  {
    if (parambaou.a())
    {
      bamk localbamk = a();
      if (localbamk == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      parambaou.jdField_b_of_type_Boolean = localbamk.a();
    }
    if (parambaou.jdField_b_of_type_Boolean) {}
    for (parambaou = parambaou.jdField_b_of_type_Baov;; parambaou = parambaou.a)
    {
      parambaot.jdField_a_of_type_AndroidWidgetTextView.setText(parambaou.jdField_a_of_type_JavaLangString);
      a(parambaot);
      return;
    }
  }
  
  protected void a(baot parambaot)
  {
    int i = baxn.a(getContext(), 0.5F);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(baxn.a(getContext(), 20.0F));
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(baxn.a(getContext(), 20.0F));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambaot.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
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
      parambaot.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
      return;
      parambaot.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
  }
  
  public void a(baou parambaou) {}
  
  public void a(baou parambaou, String paramString) {}
  
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
    paramString5 = baou.a(paramString7, paramString6, paramString5, paramString4);
    paramString6 = paramString5.a.jdField_a_of_type_JavaLangString;
    c(paramString5, paramString6);
    if (!TextUtils.isEmpty(paramString5.jdField_b_of_type_Baov.jdField_a_of_type_JavaLangString)) {
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
      baow localbaow = (baow)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbaow != null) {
        localbaow.a(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, BaseChatPie paramBaseChatPie, baos parambaos)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, baou parambaou)
  {
    if ((parambaou == null) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_Bamk == null)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new baoq(this, parambaou);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bamk.a(l2, paramString3, paramString2);
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
        this.jdField_a_of_type_Bamk.a(l1, l2, paramString3, paramString2);
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
    int i = 2130848972;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130848776;
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
  
  public void b(baou parambaou) {}
  
  public void b(baou parambaou, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, baou parambaou)
  {
    if ((this.jdField_a_of_type_Bamk == null) || (TextUtils.isEmpty(paramString3)) || (parambaou == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new baor(this, parambaou);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bamk.b(l2, paramString3, paramString2);
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
        this.jdField_a_of_type_Bamk.b(l1, l2, paramString3, paramString2);
      }
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c(baou parambaou, String paramString) {}
  
  public void d()
  {
    this.jdField_a_of_type_Bamk = a();
    if (this.jdField_a_of_type_Bamk != null) {
      this.jdField_a_of_type_Bamk.a(this);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
  }
  
  public void d(baou parambaou, String paramString) {}
  
  public void e()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    baou localbaou = (baou)a(a(paramView));
    if (localbaou == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    String str = localbaou.a.jdField_a_of_type_JavaLangString;
    a(localbaou, str);
    if (!TextUtils.isEmpty(localbaou.jdField_b_of_type_Baov.jdField_a_of_type_JavaLangString)) {
      paramView = a(localbaou);
    }
    for (;;)
    {
      b(localbaou, paramView);
      a(paramView);
      return;
      if (localbaou.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        a(localbaou);
        paramView = str;
      }
      else if (localbaou.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        b(localbaou);
        paramView = str;
      }
      else
      {
        paramView = str;
        if (localbaou.a.c.startsWith("http"))
        {
          paramView = new Intent(getContext(), QQBrowserActivity.class);
          paramView.putExtra("url", localbaou.a.c);
          getContext().startActivity(paramView);
          paramView = str;
        }
      }
    }
  }
  
  public void setInputLineCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(baow parambaow)
  {
    if (parambaow == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambaow);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.au();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotPanelLayoutBase", 2, "setVisibility:" + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */