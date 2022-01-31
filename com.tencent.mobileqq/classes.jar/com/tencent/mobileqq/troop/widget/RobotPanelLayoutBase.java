package com.tencent.mobileqq.troop.widget;

import acex;
import acfe;
import agiu;
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
import bceh;
import bckx;
import bclg;
import bcnd;
import bcne;
import bcnf;
import bcng;
import bcnh;
import bcni;
import bcnj;
import bcnk;
import bcwh;
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
  extends RDBaseListLayout<bcnh, bcng>
  implements View.OnClickListener, bclg
{
  protected int a;
  public bckx a;
  protected BaseChatPie a;
  public String a;
  private WeakReference<bcnj> a;
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
  
  public static bckx a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (bckx)((QQAppInterface)localAppRuntime).getManager(203);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    int i = paramContext.getResources().getInteger(2131427342);
    if (paramString1.length() > i)
    {
      ChatActivityUtils.a(paramContext, 2131719765, 1);
      return;
    }
    boolean bool = paramBaseChatPie instanceof agiu;
    acfe localacfe = new acfe();
    localacfe.i = paramBoolean;
    if (bool)
    {
      paramString3 = bceh.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2, paramString2, paramString3, false, true);
      paramString2 = new ArrayList();
      paramString3 = bceh.a(paramString3, paramString2);
      paramString1 = paramString3 + " " + paramString1;
      acex.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString1, paramString2, localacfe);
      return;
    }
    acex.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString1, null, localacfe);
  }
  
  public bcng a(int paramInt, bcnh parambcnh)
  {
    parambcnh = new bcng();
    View localView = LayoutInflater.from(getContext()).inflate(2131560503, null, false);
    localView.setOnClickListener(this);
    parambcnh.a(localView);
    parambcnh.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368472);
    parambcnh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377567));
    localView.setTag(parambcnh);
    return parambcnh;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(bcnh parambcnh)
  {
    return null;
  }
  
  public ArrayList<bcnh> a(cmd0x934.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = new ArrayList(paramRspBody.lists.size());
    int i = 0;
    while (i < paramRspBody.lists.size())
    {
      ((ArrayList)localObject).add(bcnk.a((cmd0x934.List)paramRspBody.lists.get(i)));
      i += 1;
    }
    paramRspBody = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRspBody.addAll(((bcnk)((Iterator)localObject).next()).a);
    }
    return paramRspBody;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bckx != null) {
      this.jdField_a_of_type_Bckx.a(null);
    }
  }
  
  public void a(int paramInt, bcnh parambcnh) {}
  
  public void a(int paramInt, bcnh parambcnh, bcng parambcng)
  {
    if (parambcnh.a())
    {
      bckx localbckx = a();
      if (localbckx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
        }
        return;
      }
      parambcnh.jdField_b_of_type_Boolean = localbckx.a();
    }
    if (parambcnh.jdField_b_of_type_Boolean) {}
    for (parambcnh = parambcnh.jdField_b_of_type_Bcni;; parambcnh = parambcnh.a)
    {
      parambcng.jdField_a_of_type_AndroidWidgetTextView.setText(parambcnh.jdField_a_of_type_JavaLangString);
      a(parambcng);
      return;
    }
  }
  
  protected void a(bcng parambcng)
  {
    int i = bcwh.a(getContext(), 0.5F);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(bcwh.a(getContext(), 20.0F));
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(bcwh.a(getContext(), 20.0F));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambcng.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
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
      parambcng.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
      return;
      parambcng.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
      localGradientDrawable1.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable1.setStroke(i, Color.parseColor("#D4D8E7"));
      localGradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
      localGradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
      localGradientDrawable2.setStroke(i, Color.parseColor("#D4D8E7"));
    }
  }
  
  public void a(bcnh parambcnh) {}
  
  public void a(bcnh parambcnh, String paramString) {}
  
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
    paramString5 = bcnh.a(paramString7, paramString6, paramString5, paramString4);
    paramString6 = paramString5.a.jdField_a_of_type_JavaLangString;
    c(paramString5, paramString6);
    if (!TextUtils.isEmpty(paramString5.jdField_b_of_type_Bcni.jdField_a_of_type_JavaLangString)) {
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
      bcnj localbcnj = (bcnj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbcnj != null) {
        localbcnj.a(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, BaseChatPie paramBaseChatPie, bcnf parambcnf)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, bcnh parambcnh)
  {
    if ((parambcnh == null) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_Bckx == null)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new bcnd(this, parambcnh);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bckx.a(l2, paramString3, paramString2);
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
        this.jdField_a_of_type_Bckx.a(l1, l2, paramString3, paramString2);
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
    int i = 2130849403;
    try
    {
      if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130849207;
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
  
  public void b(bcnh parambcnh) {}
  
  public void b(bcnh parambcnh, String paramString) {}
  
  protected void b(String paramString1, String paramString2, String paramString3, bcnh parambcnh)
  {
    if ((this.jdField_a_of_type_Bckx == null) || (TextUtils.isEmpty(paramString3)) || (parambcnh == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        if ((l1 != -1L) && (l2 != -1L))
        {
          paramString2 = new bcne(this, parambcnh);
          if ("1".equals(paramString1))
          {
            this.jdField_a_of_type_Bckx.b(l2, paramString3, paramString2);
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
        this.jdField_a_of_type_Bckx.b(l1, l2, paramString3, paramString2);
      }
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c(bcnh parambcnh, String paramString) {}
  
  public void d()
  {
    this.jdField_a_of_type_Bckx = a();
    if (this.jdField_a_of_type_Bckx != null) {
      this.jdField_a_of_type_Bckx.a(this);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
  }
  
  public void d(bcnh parambcnh, String paramString) {}
  
  public void e()
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    bcnh localbcnh = (bcnh)a(a(paramView));
    if (localbcnh == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    String str = localbcnh.a.jdField_a_of_type_JavaLangString;
    a(localbcnh, str);
    if (!TextUtils.isEmpty(localbcnh.jdField_b_of_type_Bcni.jdField_a_of_type_JavaLangString)) {
      paramView = a(localbcnh);
    }
    for (;;)
    {
      b(localbcnh, paramView);
      a(paramView);
      return;
      if (localbcnh.a.c.startsWith("inputKeyOp://sendToRobot"))
      {
        a(localbcnh);
        paramView = str;
      }
      else if (localbcnh.a.c.startsWith("inputKeyOp://sendToBackEnd"))
      {
        b(localbcnh);
        paramView = str;
      }
      else
      {
        paramView = str;
        if (localbcnh.a.c.startsWith("http"))
        {
          paramView = new Intent(getContext(), QQBrowserActivity.class);
          paramView.putExtra("url", localbcnh.a.c);
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
  
  public void setListener(bcnj parambcnj)
  {
    if (parambcnj == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcnj);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aw();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotPanelLayoutBase", 2, "setVisibility:" + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ax();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase
 * JD-Core Version:    0.7.0.1
 */