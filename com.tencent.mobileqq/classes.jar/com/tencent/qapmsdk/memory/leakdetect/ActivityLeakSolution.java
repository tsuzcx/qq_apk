package com.tencent.qapmsdk.memory.leakdetect;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ActivityLeakSolution
{
  private static final String TAG = "QAPM_memory_ActivityLeakSolution";
  private static boolean isSoluteLeak = false;
  
  public static void fixAudioManagerLeak(@NonNull Context paramContext)
  {
    if (isSoluteLeak)
    {
      if (AndroidVersion.isM()) {
        return;
      }
      try
      {
        paramContext = (AudioManager)paramContext.getSystemService("audio");
        Field localField = paramContext.getClass().getDeclaredField("mContext");
        localField.setAccessible(true);
        localField.set(paramContext, null);
        return;
      }
      catch (Exception paramContext)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramContext.toString() });
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramContext.toString() });
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramContext.toString() });
        return;
      }
      catch (NoSuchFieldException paramContext)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramContext.toString() });
      }
    }
  }
  
  public static void fixInputMethodManagerLeak(@Nullable Context paramContext)
  {
    if (!isSoluteLeak) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    Object localObject1;
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    }
    catch (Throwable localThrowable1)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityLeakSolution", localThrowable1);
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mCurRootView";
    arrayOfString[1] = "mServedView";
    arrayOfString[2] = "mNextServedView";
    int i = 0;
    while (i < arrayOfString.length)
    {
      Object localObject2 = arrayOfString[i];
      try
      {
        localObject2 = localObject1.getClass().getDeclaredField((String)localObject2);
        if (!((Field)localObject2).isAccessible()) {
          ((Field)localObject2).setAccessible(true);
        }
        Object localObject3 = ((Field)localObject2).get(localObject1);
        if ((localObject3 != null) && ((localObject3 instanceof View)))
        {
          localObject3 = (View)localObject3;
          if (((View)localObject3).getContext() == paramContext)
          {
            ((Field)localObject2).set(localObject1, null);
          }
          else
          {
            Logger.INSTANCE.d(new String[] { "QAPM_memory_ActivityLeakSolution", "fixInputMethodManagerLeak break, context not suitable", ", get_context=", ((View)localObject3).getContext().toString(), ", dest_context=", paramContext.toString() });
            return;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityLeakSolution", localThrowable2);
        i += 1;
      }
    }
  }
  
  private static void fixTextWatcherLeak(@Nullable TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setHint("");
    try
    {
      Field localField = TextView.class.getDeclaredField("mListeners");
      if (localField == null) {
        return;
      }
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      paramTextView = localField.get(paramTextView);
      if ((paramTextView instanceof ArrayList))
      {
        paramTextView = ((ArrayList)paramTextView).iterator();
        while (paramTextView.hasNext())
        {
          paramTextView.next();
          paramTextView.remove();
        }
      }
      return;
    }
    catch (Throwable paramTextView)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramTextView.toString() });
      return;
    }
    catch (IllegalAccessException paramTextView)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramTextView.toString() });
      return;
    }
    catch (IllegalArgumentException paramTextView)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramTextView.toString() });
      return;
    }
    catch (NoSuchFieldException paramTextView)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", paramTextView.toString() });
    }
  }
  
  private static void fixTextWatcherLeak2()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Class.forName("android.text.TextLine").getDeclaredField("sCached");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (Object[])((Field)localObject1).get(null);
        if (localObject1 != null) {
          try
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              Field localField = localObject2.getClass().getDeclaredField("mSpanned");
              localField.setAccessible(true);
              localObject2 = (Spanned)localField.get(localObject2);
              if (localObject2 == null) {
                break label261;
              }
              localField = localObject2.getClass().getDeclaredField("mSpanned");
              localField.setAccessible(true);
              localObject2 = (Spanned)localField.get(localObject2);
              if (!(localObject2 instanceof SpannableStringBuilder)) {
                break label261;
              }
              ((SpannableStringBuilder)localObject2).clearSpans();
              break label261;
            }
            return;
          }
          finally {}
        } else {
          throw new IllegalStateException("Failed to invoke currentActivityThread");
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localException.toString() });
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localNoSuchFieldException.toString() });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localIllegalAccessException.toString() });
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localIllegalArgumentException.toString() });
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localClassNotFoundException.toString() });
        return;
      }
      label261:
      i += 1;
    }
  }
  
  private static void recycleFrameLayout(@Nullable FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout != null)
    {
      Drawable localDrawable = paramFrameLayout.getForeground();
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        paramFrameLayout.setForeground(null);
      }
    }
  }
  
  private static void recycleImageView(@NonNull Activity paramActivity, @Nullable ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject = paramImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    paramImageView.setImageDrawable(null);
    if (localObject != null) {}
    for (;;)
    {
      int m;
      int n;
      try
      {
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          m = ((Bitmap)localObject).getWidth();
          n = ((Bitmap)localObject).getHeight();
          if ((m > 0) && (n > 0))
          {
            int j = paramImageView.getWidth();
            int k = paramImageView.getHeight();
            i = 0;
            if ((j <= 0) || (k <= 0)) {
              break label252;
            }
            m = Math.max(Math.round(m / j), Math.round(n / k));
            if (m >= 2) {
              i = j * k * (m * m - 1);
            }
            if (i > 0)
            {
              localObject = new StringBuffer(100);
              i = paramImageView.getId();
              ((StringBuffer)localObject).append(paramActivity.getClass().getName());
              ((StringBuffer)localObject).append('_');
              ((StringBuffer)localObject).append(i);
              if (i == -1)
              {
                paramActivity = paramImageView.getParent();
                if ((i == -1) && (paramActivity != null) && ((paramActivity instanceof ViewGroup)))
                {
                  i = ((ViewGroup)paramActivity).getId();
                  ((StringBuffer)localObject).append('_');
                  ((StringBuffer)localObject).append(i);
                  paramActivity = paramActivity.getParent();
                  continue;
                }
              }
            }
          }
        }
        return;
      }
      catch (Throwable paramActivity)
      {
        return;
      }
      label252:
      int i = m * n;
    }
  }
  
  @TargetApi(16)
  private static void recycleLinearLayout(@Nullable LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout == null) {
      return;
    }
    if (11 <= Build.VERSION.SDK_INT)
    {
      Object localObject1;
      Object localObject2;
      if (16 <= Build.VERSION.SDK_INT)
      {
        localObject1 = paramLinearLayout.getDividerDrawable();
      }
      else
      {
        try
        {
          localObject1 = paramLinearLayout.getClass().getDeclaredField("mDivider");
          ((Field)localObject1).setAccessible(true);
          localObject1 = (Drawable)((Field)localObject1).get(paramLinearLayout);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localIllegalAccessException.toString() });
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localIllegalArgumentException.toString() });
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_memory_ActivityLeakSolution", localNoSuchFieldException.toString() });
        }
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject2.setCallback(null);
        paramLinearLayout.setDividerDrawable(null);
      }
    }
  }
  
  /* Error */
  private static void recycleListView(ListView paramListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 307	android/widget/ListView:getSelector	()Landroid/graphics/drawable/Drawable;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 204	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   14: aload_0
    //   15: invokevirtual 311	android/widget/ListView:getAdapter	()Landroid/widget/ListAdapter;
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: aconst_null
    //   23: invokevirtual 315	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: invokevirtual 319	android/widget/ListView:setOnScrollListener	(Landroid/widget/AbsListView$OnScrollListener;)V
    //   31: aload_0
    //   32: aconst_null
    //   33: invokevirtual 323	android/widget/ListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: invokevirtual 327	android/widget/ListView:setOnItemLongClickListener	(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: invokevirtual 331	android/widget/ListView:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   46: return
    //   47: astore_0
    //   48: new 302	java/lang/IncompatibleClassChangeError
    //   51: dup
    //   52: ldc_w 333
    //   55: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   62: checkcast 302	java/lang/IncompatibleClassChangeError
    //   65: checkcast 302	java/lang/IncompatibleClassChangeError
    //   68: athrow
    //   69: astore_0
    //   70: new 302	java/lang/IncompatibleClassChangeError
    //   73: dup
    //   74: ldc_w 333
    //   77: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   84: checkcast 302	java/lang/IncompatibleClassChangeError
    //   87: checkcast 302	java/lang/IncompatibleClassChangeError
    //   90: athrow
    //   91: astore_0
    //   92: new 302	java/lang/IncompatibleClassChangeError
    //   95: dup
    //   96: ldc_w 333
    //   99: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   102: aload_0
    //   103: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   106: checkcast 302	java/lang/IncompatibleClassChangeError
    //   109: checkcast 302	java/lang/IncompatibleClassChangeError
    //   112: athrow
    //   113: astore_0
    //   114: new 302	java/lang/IncompatibleClassChangeError
    //   117: dup
    //   118: ldc_w 333
    //   121: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   128: checkcast 302	java/lang/IncompatibleClassChangeError
    //   131: checkcast 302	java/lang/IncompatibleClassChangeError
    //   134: athrow
    //   135: astore_0
    //   136: new 302	java/lang/IncompatibleClassChangeError
    //   139: dup
    //   140: ldc_w 333
    //   143: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   150: checkcast 302	java/lang/IncompatibleClassChangeError
    //   153: checkcast 302	java/lang/IncompatibleClassChangeError
    //   156: athrow
    //   157: astore_1
    //   158: goto -132 -> 26
    //   161: astore_1
    //   162: goto -131 -> 31
    //   165: astore_1
    //   166: goto -130 -> 36
    //   169: astore_1
    //   170: goto -129 -> 41
    //   173: astore_0
    //   174: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramListView	ListView
    //   4	6	1	localDrawable	Drawable
    //   157	1	1	localThrowable1	Throwable
    //   161	1	1	localThrowable2	Throwable
    //   165	1	1	localThrowable3	Throwable
    //   169	1	1	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   41	46	47	java/lang/IncompatibleClassChangeError
    //   36	41	69	java/lang/IncompatibleClassChangeError
    //   31	36	91	java/lang/IncompatibleClassChangeError
    //   26	31	113	java/lang/IncompatibleClassChangeError
    //   14	26	135	java/lang/IncompatibleClassChangeError
    //   14	26	157	java/lang/Throwable
    //   26	31	161	java/lang/Throwable
    //   31	36	165	java/lang/Throwable
    //   36	41	169	java/lang/Throwable
    //   41	46	173	java/lang/Throwable
  }
  
  private static void recycleProgressBar(ProgressBar paramProgressBar)
  {
    Drawable localDrawable = paramProgressBar.getProgressDrawable();
    if (localDrawable != null)
    {
      paramProgressBar.setProgressDrawable(null);
      localDrawable.setCallback(null);
    }
    localDrawable = paramProgressBar.getIndeterminateDrawable();
    if (localDrawable != null)
    {
      paramProgressBar.setIndeterminateDrawable(null);
      localDrawable.setCallback(null);
    }
  }
  
  private static void recycleTextView(TextView paramTextView)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    int j = arrayOfDrawable.length;
    int i = 0;
    while (i < j)
    {
      Drawable localDrawable = arrayOfDrawable[i];
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      i += 1;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
    if ((paramTextView instanceof EditText)) {
      fixTextWatcherLeak(paramTextView);
    }
    paramTextView.setCursorVisible(false);
  }
  
  /* Error */
  private static void recycleView(@Nullable View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: aconst_null
    //   7: invokevirtual 376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   10: aload_0
    //   11: aconst_null
    //   12: invokevirtual 380	android/view/View:setOnCreateContextMenuListener	(Landroid/view/View$OnCreateContextMenuListener;)V
    //   15: aload_0
    //   16: aconst_null
    //   17: invokevirtual 384	android/view/View:setOnFocusChangeListener	(Landroid/view/View$OnFocusChangeListener;)V
    //   20: aload_0
    //   21: aconst_null
    //   22: invokevirtual 388	android/view/View:setOnKeyListener	(Landroid/view/View$OnKeyListener;)V
    //   25: aload_0
    //   26: aconst_null
    //   27: invokevirtual 392	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   30: aload_0
    //   31: aconst_null
    //   32: invokevirtual 376	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   35: aload_0
    //   36: aconst_null
    //   37: invokevirtual 396	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   40: aload_0
    //   41: invokevirtual 399	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +13 -> 59
    //   49: aload_1
    //   50: aconst_null
    //   51: invokevirtual 204	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   54: aload_0
    //   55: aconst_null
    //   56: invokevirtual 402	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   59: aload_0
    //   60: invokevirtual 405	android/view/View:destroyDrawingCache	()V
    //   63: return
    //   64: astore_0
    //   65: new 302	java/lang/IncompatibleClassChangeError
    //   68: dup
    //   69: ldc_w 333
    //   72: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   79: checkcast 302	java/lang/IncompatibleClassChangeError
    //   82: checkcast 302	java/lang/IncompatibleClassChangeError
    //   85: athrow
    //   86: astore_0
    //   87: new 302	java/lang/IncompatibleClassChangeError
    //   90: dup
    //   91: ldc_w 333
    //   94: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   101: checkcast 302	java/lang/IncompatibleClassChangeError
    //   104: checkcast 302	java/lang/IncompatibleClassChangeError
    //   107: athrow
    //   108: astore_0
    //   109: new 302	java/lang/IncompatibleClassChangeError
    //   112: dup
    //   113: ldc_w 333
    //   116: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   123: checkcast 302	java/lang/IncompatibleClassChangeError
    //   126: checkcast 302	java/lang/IncompatibleClassChangeError
    //   129: athrow
    //   130: astore_0
    //   131: new 302	java/lang/IncompatibleClassChangeError
    //   134: dup
    //   135: ldc_w 333
    //   138: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   145: checkcast 302	java/lang/IncompatibleClassChangeError
    //   148: checkcast 302	java/lang/IncompatibleClassChangeError
    //   151: athrow
    //   152: astore_0
    //   153: new 302	java/lang/IncompatibleClassChangeError
    //   156: dup
    //   157: ldc_w 333
    //   160: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   167: checkcast 302	java/lang/IncompatibleClassChangeError
    //   170: checkcast 302	java/lang/IncompatibleClassChangeError
    //   173: athrow
    //   174: astore_0
    //   175: new 302	java/lang/IncompatibleClassChangeError
    //   178: dup
    //   179: ldc_w 333
    //   182: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   185: aload_0
    //   186: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   189: checkcast 302	java/lang/IncompatibleClassChangeError
    //   192: checkcast 302	java/lang/IncompatibleClassChangeError
    //   195: athrow
    //   196: astore_0
    //   197: new 302	java/lang/IncompatibleClassChangeError
    //   200: dup
    //   201: ldc_w 333
    //   204: invokespecial 334	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   207: aload_0
    //   208: invokevirtual 338	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   211: checkcast 302	java/lang/IncompatibleClassChangeError
    //   214: checkcast 302	java/lang/IncompatibleClassChangeError
    //   217: athrow
    //   218: astore_1
    //   219: goto -209 -> 10
    //   222: astore_1
    //   223: goto -208 -> 15
    //   226: astore_1
    //   227: goto -207 -> 20
    //   230: astore_1
    //   231: goto -206 -> 25
    //   234: astore_1
    //   235: goto -205 -> 30
    //   238: astore_1
    //   239: goto -204 -> 35
    //   242: astore_1
    //   243: goto -203 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramView	View
    //   44	6	1	localDrawable	Drawable
    //   218	1	1	localThrowable1	Throwable
    //   222	1	1	localThrowable2	Throwable
    //   226	1	1	localThrowable3	Throwable
    //   230	1	1	localThrowable4	Throwable
    //   234	1	1	localThrowable5	Throwable
    //   238	1	1	localThrowable6	Throwable
    //   242	1	1	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   35	40	64	java/lang/IncompatibleClassChangeError
    //   30	35	86	java/lang/IncompatibleClassChangeError
    //   25	30	108	java/lang/IncompatibleClassChangeError
    //   20	25	130	java/lang/IncompatibleClassChangeError
    //   15	20	152	java/lang/IncompatibleClassChangeError
    //   10	15	174	java/lang/IncompatibleClassChangeError
    //   5	10	196	java/lang/IncompatibleClassChangeError
    //   5	10	218	java/lang/Throwable
    //   10	15	222	java/lang/Throwable
    //   15	20	226	java/lang/Throwable
    //   20	25	230	java/lang/Throwable
    //   25	30	234	java/lang/Throwable
    //   30	35	238	java/lang/Throwable
    //   35	40	242	java/lang/Throwable
  }
  
  private static void recycleViewGroup(@NonNull Activity paramActivity, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      unbindDrawablesAndRecyle(paramActivity, paramViewGroup.getChildAt(i));
      i += 1;
    }
  }
  
  public static void setSwitchLeakSolution(boolean paramBoolean)
  {
    isSoluteLeak = paramBoolean;
  }
  
  private static void unbindDrawablesAndRecyle(@NonNull Activity paramActivity, @Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    recycleView(paramView);
    if ((paramView instanceof ImageView))
    {
      recycleImageView(paramActivity, (ImageView)paramView);
      return;
    }
    if ((paramView instanceof TextView))
    {
      recycleTextView((TextView)paramView);
      return;
    }
    if ((paramView instanceof ProgressBar))
    {
      recycleProgressBar((ProgressBar)paramView);
      return;
    }
    if ((paramView instanceof ListView)) {
      recycleListView((ListView)paramView);
    } else if ((paramView instanceof FrameLayout)) {
      recycleFrameLayout((FrameLayout)paramView);
    } else if ((paramView instanceof LinearLayout)) {
      recycleLinearLayout((LinearLayout)paramView);
    }
    if ((paramView instanceof ViewGroup)) {
      recycleViewGroup(paramActivity, (ViewGroup)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.ActivityLeakSolution
 * JD-Core Version:    0.7.0.1
 */