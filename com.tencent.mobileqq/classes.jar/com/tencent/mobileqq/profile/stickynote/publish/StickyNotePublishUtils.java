package com.tencent.mobileqq.profile.stickynote.publish;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import com.tencent.mobileqq.text.QQTextBuilder;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.publishInterface.QzonePublishMoodCallback;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class StickyNotePublishUtils
{
  public static int a = -16692;
  public static int b = -16693;
  
  public static Drawable a(int paramInt)
  {
    Iterator localIterator = StickyNotePublishConstant.a.iterator();
    while (localIterator.hasNext())
    {
      BackgroundSelectBean localBackgroundSelectBean = (BackgroundSelectBean)localIterator.next();
      if (paramInt == localBackgroundSelectBean.jdField_a_of_type_Long) {
        return localBackgroundSelectBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      }
    }
    return null;
  }
  
  private static Class<?> a(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext).loadClass(paramString);
          return localObject2;
        }
        catch (Throwable paramContext)
        {
          QLog.e("StickyNotePublishUtils", 1, "loadQZoneClass, failed to load class from qzone plugin class loader.");
        }
        localThrowable = localThrowable;
        QLog.e("StickyNotePublishUtils", 1, "loadQZoneClass, failed to load class from normal class loader.");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return localObject1;
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      if ((paramEditText.getText() instanceof QQTextBuilder))
      {
        QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getText();
        if (localQQTextBuilder != null) {
          return localQQTextBuilder.toPlainText();
        }
      }
      if ((paramEditText != null) && (paramEditText.getEditableText() != null)) {
        return paramEditText.getEditableText().toString();
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString, boolean paramBoolean, QzonePublishMoodCallback paramQzonePublishMoodCallback)
  {
    try
    {
      paramContext = a(paramContext, "com.qzone.publish.stickynote.StickyNotePublishProxy");
      if (paramContext != null) {
        paramContext.getMethod("modifyStickyNotePriv", new Class[] { Long.TYPE, Long.TYPE, String.class, Boolean.TYPE, QzonePublishMoodCallback.class }).invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Boolean.valueOf(paramBoolean), paramQzonePublishMoodCallback });
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("StickyNotePublishUtils", 1, "modifyStickyNotePriv fail.", paramContext);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, QzonePublishMoodCallback paramQzonePublishMoodCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickyNotePublishUtils", 0, String.format("publishStickyNote, hostUin=%s publishUin=%s isPublic=%s bgColor=%s bgVersion=%s vasExtendInfo=%s content=%s callback=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3, paramString4, paramQzonePublishMoodCallback }));
    }
    if ((paramContext == null) || (paramQQAppInterface == null) || (paramLong1 == 0L) || (paramLong2 == 0L) || (TextUtils.isEmpty(paramString4))) {
      QLog.e("StickyNotePublishUtils", 1, "publishStickyNote, params invalid.");
    }
    for (;;)
    {
      return;
      boolean bool1 = QZoneApiProxy.initEnv(paramContext, paramQQAppInterface);
      boolean bool2 = QZoneApiProxy.initServlet(paramContext, paramQQAppInterface);
      if ((!bool1) || (!bool2))
      {
        QLog.e("StickyNotePublishUtils", 1, String.format("publishStickyNote, init fail. initEnv=%s initServlet=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        return;
      }
      try
      {
        paramContext = a(paramContext, "com.qzone.publish.stickynote.StickyNotePublishProxy");
        if (paramContext != null)
        {
          paramContext.getMethod("publishStickyNote", new Class[] { Long.TYPE, Long.TYPE, Boolean.TYPE, String.class, String.class, String.class, String.class, QzonePublishMoodCallback.class }).invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3, paramString4, paramQzonePublishMoodCallback });
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("StickyNotePublishUtils", 1, "publishStickyNote fail.", paramContext);
      }
    }
  }
  
  public static String b(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      paramEditText = a(paramEditText);
      if (!TextUtils.isEmpty(paramEditText)) {
        return QzoneEmotionUtils.splash2Emo(paramEditText.replaceAll(HardCodeUtil.a(2131705818), HardCodeUtil.a(2131705820)).replaceAll(HardCodeUtil.a(2131705817), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(2131717522), "/chigua"));
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishUtils
 * JD-Core Version:    0.7.0.1
 */