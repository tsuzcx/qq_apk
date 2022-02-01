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

public class StudyModeManager
{
  private static int jdField_a_of_type_Int = -1;
  private static String jdField_a_of_type_JavaLangString;
  private static ArrayList<StudyModeChangeListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private static boolean jdField_a_of_type_Boolean = true;
  private static int jdField_b_of_type_Int = -1;
  private static String jdField_b_of_type_JavaLangString;
  private static ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c;
  private static boolean d;
  private static boolean e = false;
  
  public static int a()
  {
    try
    {
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a();
      }
      int i = jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      StudyModeConfigProcessor.StudyModeConfigBean localStudyModeConfigBean = StudyModeConfigProcessor.a();
      if (localStudyModeConfigBean.jdField_a_of_type_Boolean) {
        jdField_a_of_type_Boolean = StudyModeConfigProcessor.StudyModeConfigBean.a(localStudyModeConfigBean);
      }
      ArrayList localArrayList = StudyModePushConfigProcessor.a().jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        jdField_b_of_type_JavaUtilArrayList.clear();
        jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      }
      jdField_b_of_type_Boolean = ((Boolean)SharedPreUtils.a("study_mode_key_user_switch", Boolean.valueOf(false))).booleanValue();
      c = ((Boolean)SharedPreUtils.a("study_mode_key_student_mask", Boolean.valueOf(false))).booleanValue();
      jdField_a_of_type_Int = ((Integer)SharedPreUtils.a("kid_mode_key_need_verify_phone", Integer.valueOf(-1))).intValue();
      d = StudyModeSwitchDialogConfigProcessor.a.a();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, String.format("init ,sStudyModeConfigSwitch = %b,sStudyModeSwitch = %b,sStudentMask = %b,sBlackIds = %s,configHas = %b,sShowStudyModeSwitchDialog = %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean), Boolean.valueOf(jdField_b_of_type_Boolean), Boolean.valueOf(c), "sBlackIds.toString()", Boolean.valueOf(localStudyModeConfigBean.jdField_a_of_type_Boolean), Boolean.valueOf(d) }));
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
      boolean bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (!bool) {
        return;
      }
      if (jdField_a_of_type_Int != paramInt)
      {
        SharedPreUtils.a("kid_mode_key_need_verify_phone", Integer.valueOf(paramInt));
        jdField_a_of_type_Int = paramInt;
      }
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
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a();
      }
      jdField_b_of_type_Int = paramInt;
      jdField_a_of_type_JavaLangString = paramString1;
      jdField_b_of_type_JavaLangString = paramString2;
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
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramStudyModeChangeListener)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramStudyModeChangeListener);
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
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
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
      boolean bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (!bool) {
        return;
      }
      if (jdField_b_of_type_Boolean != paramBoolean)
      {
        SharedPreUtils.a("study_mode_key_user_switch", Boolean.valueOf(paramBoolean));
        jdField_b_of_type_Boolean = paramBoolean;
        if (jdField_a_of_type_Boolean) {
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
  
  public static boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAppRuntime != null)
    {
      bool1 = bool2;
      if (localAppRuntime.getCurrentAccountUin() != null)
      {
        if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          a();
        }
        bool1 = bool2;
        if (jdField_a_of_type_Boolean) {
          bool1 = jdField_b_of_type_Boolean;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    boolean bool;
    if (a()) {
      try
      {
        if (jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          bool = jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
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
      QLog.d("StudyModeManager", 2, String.format("init ,studyModeSwitch = %b,notifyID = %d,blackResult = %b,sBlackIds = %s", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean), Integer.valueOf(paramInt), Boolean.valueOf(bool), jdField_b_of_type_JavaUtilArrayList.toString() }));
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      ((SimpleUIHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(false, 0, false, true);
      QLog.e("StudyModeManager", 1, "[KidMode]checkAbnormalFlag both true");
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public static String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static void b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void b(StudyModeChangeListener paramStudyModeChangeListener)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramStudyModeChangeListener)) {
        jdField_a_of_type_JavaUtilArrayList.remove(paramStudyModeChangeListener);
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
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean b(int paramInt)
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
      boolean bool = ((Boolean)SharedPreUtils.a((String)localObject, Boolean.valueOf(false))).booleanValue();
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
  
  public static void c(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    d = StudyModeSwitchDialogConfigProcessor.a.a();
    return d;
  }
  
  public static boolean d()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, "isBanSearchFriend: it isn't in kid mode");
      }
      return false;
    }
    boolean bool = b(8);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBanSearchFriend: ");
      localStringBuilder.append(bool);
      QLog.d("StudyModeManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean e()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date());
    Object localObject = (String)SharedPreUtils.a("kid_mode_advance_setting", "");
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
          int i = localCalendar2.get(6);
          int j = localCalendar1.get(6);
          if (i == j) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeManager
 * JD-Core Version:    0.7.0.1
 */