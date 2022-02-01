package com.tencent.mobileqq.studymode;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StudyModeManager
{
  private static boolean a = true;
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = false;
  private static int e = -1;
  private static int f = -1;
  private static int g = 0;
  private static String h = "";
  private static String i;
  private static String j;
  private static AtomicBoolean k = new AtomicBoolean();
  private static ArrayList<StudyModeChangeListener> l = new ArrayList();
  private static ArrayList<Integer> m = new ArrayList();
  private static boolean n = false;
  
  public static void a()
  {
    try
    {
      StudyModeConfigProcessor.StudyModeConfigBean localStudyModeConfigBean = StudyModeConfigProcessor.a();
      if (localStudyModeConfigBean.b) {
        a = StudyModeConfigProcessor.StudyModeConfigBean.a(localStudyModeConfigBean);
      }
      ArrayList localArrayList = StudyModePushConfigProcessor.a().b;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        m.clear();
        m.addAll(localArrayList);
      }
      b = ((Boolean)SharedPreUtils.c("study_mode_key_user_switch", Boolean.valueOf(false))).booleanValue();
      c = ((Boolean)SharedPreUtils.c("study_mode_key_student_mask", Boolean.valueOf(false))).booleanValue();
      e = ((Integer)SharedPreUtils.c("kid_mode_key_need_verify_phone", Integer.valueOf(-1))).intValue();
      g = ((Integer)SharedPreUtils.c("kid_mode_key_password_state", Integer.valueOf(0))).intValue();
      h = (String)SharedPreUtils.c("kid_mode_key_password_salt", "");
      d = StudyModeSwitchDialogConfigProcessor.a.a();
      k.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, String.format("init ,sStudyModeConfigSwitch = %b,sStudyModeSwitch = %b,sStudentMask = %b,sBlackIds = %s,configHas = %b,sShowStudyModeSwitchDialog = %b", new Object[] { Boolean.valueOf(a), Boolean.valueOf(b), Boolean.valueOf(c), "sBlackIds.toString()", Boolean.valueOf(localStudyModeConfigBean.b), Boolean.valueOf(d) }));
      }
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 1, new Object[] { "setKidModeNeedVerify switch: ", Integer.valueOf(paramInt) });
      }
      boolean bool = k.get();
      if (!bool) {
        return;
      }
      if (e != paramInt)
      {
        SharedPreUtils.a("kid_mode_key_need_verify_phone", Integer.valueOf(paramInt));
        e = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString)
  {
    try
    {
      boolean bool = k.get();
      if (!bool) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setKidModePasswordState, state=");
      localStringBuilder.append(paramInt);
      QLog.i("StudyModeManager", 1, localStringBuilder.toString());
      g = paramInt;
      SharedPreUtils.a("kid_mode_key_password_state", Integer.valueOf(paramInt));
      h = paramString;
      SharedPreUtils.a("kid_mode_key_password_salt", paramString);
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 1, new Object[] { "setIsBindPhone: ", Integer.valueOf(paramInt) });
      }
      if (!k.get()) {
        a();
      }
      f = paramInt;
      i = paramString1;
      j = paramString2;
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt != 8)
    {
      if (paramInt != 16)
      {
        if (paramInt != 32) {
          localObject = null;
        } else {
          localObject = "invite_to_troop_by_stranger_flag";
        }
      }
      else {
        localObject = "search_by_stranger_flag";
      }
    }
    else {
      localObject = "search_friend_flag";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      SharedPreUtils.a((String)localObject, Boolean.valueOf(paramBoolean ^ true));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAdvanceSettingSwitch, mask: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", isSupport: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("StudyModeManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(StudyModeChangeListener paramStudyModeChangeListener)
  {
    try
    {
      if (!l.contains(paramStudyModeChangeListener)) {
        l.add(paramStudyModeChangeListener);
      }
      return;
    }
    finally
    {
      paramStudyModeChangeListener = finally;
      throw paramStudyModeChangeListener;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = l.iterator();
      while (localIterator.hasNext()) {
        ((StudyModeChangeListener)localIterator.next()).onChange(paramBoolean);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, String.format("setUserSwitch switch = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      boolean bool = k.get();
      if (!bool) {
        return;
      }
      if (b != paramBoolean)
      {
        SharedPreUtils.a("study_mode_key_user_switch", Boolean.valueOf(paramBoolean));
        b = paramBoolean;
        if (a) {
          a(paramBoolean);
        }
        if (paramQQAppInterface != null) {
          ((IRedTouchServer)paramQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(true, false, 0);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      ((SimpleUIHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).b(false, 0, false, true);
      QLog.e("StudyModeManager", 1, "[KidMode]checkAbnormalFlag both true");
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    try
    {
      if (!k.get()) {
        a();
      }
      int i1 = e;
      return i1;
    }
    finally {}
  }
  
  public static void b(int paramInt)
  {
    try
    {
      boolean bool = k.get();
      if (!bool) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setKidModePasswordState, state=");
      localStringBuilder.append(paramInt);
      QLog.i("StudyModeManager", 1, localStringBuilder.toString());
      g = paramInt;
      SharedPreUtils.a("kid_mode_key_password_state", Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  public static void b(StudyModeChangeListener paramStudyModeChangeListener)
  {
    try
    {
      if (l.contains(paramStudyModeChangeListener)) {
        l.remove(paramStudyModeChangeListener);
      }
      return;
    }
    finally
    {
      paramStudyModeChangeListener = finally;
      throw paramStudyModeChangeListener;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeManager", 2, String.format("setstudent mask = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    SharedPreUtils.a("study_mode_key_student_mask", Boolean.valueOf(paramBoolean));
  }
  
  public static int c()
  {
    try
    {
      if (!k.get()) {
        a();
      }
      int i1 = g;
      return i1;
    }
    finally {}
  }
  
  public static void c(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c(int paramInt)
  {
    if (!k.get()) {
      return false;
    }
    boolean bool;
    if (h()) {
      try
      {
        if (m.size() > 0) {
          bool = m.contains(Integer.valueOf(paramInt));
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StudyModeManager", 2, localThrowable, new Object[0]);
        }
      }
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeManager", 2, String.format("init ,studyModeSwitch = %b,notifyID = %d,blackResult = %b,sBlackIds = %s", new Object[] { Boolean.valueOf(a), Integer.valueOf(paramInt), Boolean.valueOf(bool), m.toString() }));
    }
    return bool;
  }
  
  public static String d()
  {
    try
    {
      if (!k.get()) {
        a();
      }
      String str = h;
      return str;
    }
    finally {}
  }
  
  public static boolean d(int paramInt)
  {
    Object localObject;
    if (paramInt != 8)
    {
      if (paramInt != 16)
      {
        if (paramInt != 32) {
          localObject = null;
        } else {
          localObject = "invite_to_troop_by_stranger_flag";
        }
      }
      else {
        localObject = "search_by_stranger_flag";
      }
    }
    else {
      localObject = "search_friend_flag";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool = ((Boolean)SharedPreUtils.c((String)localObject, Boolean.valueOf(false))).booleanValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAdvanceSettingSwitch, mask: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", isChecked: ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("StudyModeManager", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    return false;
  }
  
  public static int e()
  {
    return f;
  }
  
  public static String f()
  {
    return i;
  }
  
  public static String g()
  {
    return j;
  }
  
  public static boolean h()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAppRuntime != null)
    {
      bool1 = bool2;
      if (localAppRuntime.getCurrentAccountUin() != null)
      {
        if (!k.get()) {
          a();
        }
        bool1 = bool2;
        if (a)
        {
          if ("com.tencent.mobileqq".equals(MobileQQ.processName)) {
            return b;
          }
          bool1 = ((Boolean)SharedPreUtils.c("study_mode_key_user_switch", Boolean.valueOf(false))).booleanValue();
        }
      }
    }
    return bool1;
  }
  
  public static boolean i()
  {
    return a;
  }
  
  public static boolean j()
  {
    d = StudyModeSwitchDialogConfigProcessor.a.a();
    return d;
  }
  
  public static boolean k()
  {
    if (!h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, "isBanSearchFriend: it isn't in kid mode");
      }
      return false;
    }
    boolean bool = d(8);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBanSearchFriend: ");
      localStringBuilder.append(bool);
      QLog.d("StudyModeManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static void l()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean m()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date());
    Object localObject = (String)SharedPreUtils.c("kid_mode_advance_setting", "");
    if (QLog.isDevelopLevel()) {
      QLog.d("StudyModeManager", 4, new Object[] { "calendar in sp : ", localObject });
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject);
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.setTime((Date)localObject);
        if ((localCalendar2.get(0) == localCalendar1.get(0)) && (localCalendar2.get(1) == localCalendar1.get(1)))
        {
          int i1 = localCalendar2.get(6);
          int i2 = localCalendar1.get(6);
          if (i1 == i2) {
            return false;
          }
        }
      }
      catch (ParseException localParseException)
      {
        QLog.e("StudyModeManager", 1, new Object[] { "simpleDateFormat parse error : ", localParseException.toString() });
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeManager
 * JD-Core Version:    0.7.0.1
 */