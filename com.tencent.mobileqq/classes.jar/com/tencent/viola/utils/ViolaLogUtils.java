package com.tencent.viola.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaSDKManager;

public class ViolaLogUtils
{
  private static Button mLogControlButton;
  private static ScrollView mLogShowTextLayout;
  private static TextView mLogShowTextView;
  private static StringBuilder mLogViewTextBuilder;
  public static String prefix = "Viola.";
  
  public static void d(String paramString1, String paramString2)
  {
    log(paramString1, 3, paramString2);
  }
  
  public static void destroy() {}
  
  private static void destroyLogView()
  {
    mLogControlButton = null;
    Object localObject = mLogShowTextLayout;
    if (localObject != null)
    {
      ((ScrollView)localObject).removeAllViews();
      mLogShowTextLayout = null;
    }
    mLogShowTextView = null;
    localObject = mLogViewTextBuilder;
    if (localObject != null)
    {
      ((StringBuilder)localObject).setLength(0);
      mLogViewTextBuilder = null;
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(paramString1, 6, paramString2);
  }
  
  /* Error */
  public static String getStackTrace(@android.support.annotation.Nullable java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 69
    //   6: areturn
    //   7: aconst_null
    //   8: astore_1
    //   9: new 71	java/io/StringWriter
    //   12: dup
    //   13: invokespecial 72	java/io/StringWriter:<init>	()V
    //   16: astore_2
    //   17: new 74	java/io/PrintWriter
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 77	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   25: astore_3
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 83	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   31: aload_3
    //   32: invokevirtual 86	java/io/PrintWriter:flush	()V
    //   35: aload_2
    //   36: invokevirtual 87	java/io/StringWriter:flush	()V
    //   39: aload_2
    //   40: invokevirtual 90	java/io/StringWriter:close	()V
    //   43: goto +8 -> 51
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   51: aload_3
    //   52: invokevirtual 93	java/io/PrintWriter:close	()V
    //   55: aload_2
    //   56: invokevirtual 97	java/io/StringWriter:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: astore_0
    //   61: aload_3
    //   62: astore_1
    //   63: goto +10 -> 73
    //   66: astore_0
    //   67: goto +6 -> 73
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull +15 -> 89
    //   77: aload_2
    //   78: invokevirtual 90	java/io/StringWriter:close	()V
    //   81: goto +8 -> 89
    //   84: astore_2
    //   85: aload_2
    //   86: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 93	java/io/PrintWriter:close	()V
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramThrowable	java.lang.Throwable
    //   8	86	1	localObject	Object
    //   16	62	2	localStringWriter	java.io.StringWriter
    //   84	2	2	localIOException	java.io.IOException
    //   25	37	3	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   39	43	46	java/io/IOException
    //   26	39	60	finally
    //   17	26	66	finally
    //   9	17	70	finally
    //   77	81	84	java/io/IOException
  }
  
  public static void i(String paramString1, String paramString2)
  {
    log(paramString1, 4, paramString2);
  }
  
  public static void initLogView(Context paramContext, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      mLogControlButton = new Button(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(20, 200, 0, 0);
      mLogControlButton.setLayoutParams(localLayoutParams);
      mLogControlButton.setTextSize(10.0F);
      mLogControlButton.setTextColor(Color.parseColor("#FFFFFF"));
      mLogControlButton.setBackgroundColor(-11711155);
      mLogControlButton.setVisibility(8);
      mLogShowTextLayout = new ScrollView(paramContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(20, 400, 0, 0);
      mLogShowTextLayout.setLayoutParams(localLayoutParams);
      mLogShowTextView = new TextView(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      mLogShowTextView.setLayoutParams(paramContext);
      mLogShowTextView.setTextSize(14.0F);
      mLogShowTextView.setTextColor(Color.parseColor("#FFFFFF"));
      mLogShowTextView.setBackgroundColor(-11711155);
      mLogShowTextLayout.addView(mLogShowTextView);
      paramViewGroup.addView(mLogControlButton);
      paramViewGroup.addView(mLogShowTextLayout);
      mLogControlButton.setOnClickListener(new ViolaLogUtils.1());
    }
  }
  
  public static void log(String paramString1, int paramInt, String paramString2)
  {
    if (ViolaSDKManager.getInstance().getLogAdapter() != null)
    {
      ViolaSDKManager.getInstance().getLogAdapter().callLog(paramString1, paramInt, paramString2);
      return;
    }
    if (ViolaEnvironment.isDebugable())
    {
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = prefix;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(prefix);
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder.toString();
      }
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6)
              {
                Log.d(paramString1, paramString2);
                return;
              }
              Log.e(paramString1, paramString2);
              return;
            }
            Log.w(paramString1, paramString2);
            return;
          }
          Log.i(paramString1, paramString2);
          return;
        }
        Log.d(paramString1, paramString2);
        return;
      }
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void p(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Performance--:");
    localStringBuilder.append(paramString2);
    log(paramString1, 3, localStringBuilder.toString());
  }
  
  public static void setLogControlBtnVisiable(boolean paramBoolean)
  {
    Button localButton = mLogControlButton;
    if (localButton != null)
    {
      if (paramBoolean)
      {
        localButton.setVisibility(0);
        return;
      }
      localButton.setVisibility(8);
    }
  }
  
  public static void setLogText(String paramString)
  {
    ViolaSDKManager.getInstance().postOnUiThread(new ViolaLogUtils.2(paramString));
  }
  
  public static void v(String paramString1, String paramString2)
  {
    log(paramString1, 2, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(paramString1, 5, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaLogUtils
 * JD-Core Version:    0.7.0.1
 */