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
    if (mLogShowTextLayout != null)
    {
      mLogShowTextLayout.removeAllViews();
      mLogShowTextLayout = null;
    }
    mLogShowTextView = null;
    if (mLogViewTextBuilder != null)
    {
      mLogViewTextBuilder.setLength(0);
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
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +6 -> 9
    //   6: ldc 71
    //   8: areturn
    //   9: new 73	java/io/StringWriter
    //   12: dup
    //   13: invokespecial 74	java/io/StringWriter:<init>	()V
    //   16: astore_1
    //   17: new 76	java/io/PrintWriter
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 79	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   25: astore_3
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 85	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   31: aload_3
    //   32: invokevirtual 88	java/io/PrintWriter:flush	()V
    //   35: aload_1
    //   36: invokevirtual 89	java/io/StringWriter:flush	()V
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 92	java/io/StringWriter:close	()V
    //   47: aload_3
    //   48: ifnull +7 -> 55
    //   51: aload_3
    //   52: invokevirtual 93	java/io/PrintWriter:close	()V
    //   55: aload_1
    //   56: invokevirtual 97	java/io/StringWriter:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   65: goto -18 -> 47
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 92	java/io/StringWriter:close	()V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 93	java/io/PrintWriter:close	()V
    //   87: aload_0
    //   88: athrow
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   94: goto -15 -> 79
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_1
    //   101: astore_2
    //   102: aload_3
    //   103: astore_1
    //   104: goto -33 -> 71
    //   107: astore_0
    //   108: aload_1
    //   109: astore_2
    //   110: aload_3
    //   111: astore_1
    //   112: goto -41 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramThrowable	java.lang.Throwable
    //   16	96	1	localObject1	Object
    //   1	75	2	localObject2	Object
    //   89	2	2	localIOException	java.io.IOException
    //   101	9	2	localObject3	Object
    //   25	86	3	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   43	47	60	java/io/IOException
    //   9	17	68	finally
    //   75	79	89	java/io/IOException
    //   17	26	97	finally
    //   26	39	107	finally
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
    if (ViolaSDKManager.getInstance().getLogAdapter() != null) {
      ViolaSDKManager.getInstance().getLogAdapter().callLog(paramString1, paramInt, paramString2);
    }
    while (!ViolaEnvironment.isDebugable()) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = prefix;; paramString1 = prefix + paramString1) {
      switch (paramInt)
      {
      default: 
        Log.d(paramString1, paramString2);
        return;
      }
    }
    Log.e(paramString1, paramString2);
    return;
    Log.i(paramString1, paramString2);
    return;
    Log.d(paramString1, paramString2);
    return;
    Log.v(paramString1, paramString2);
    return;
    Log.w(paramString1, paramString2);
  }
  
  public static void p(String paramString1, String paramString2)
  {
    log(paramString1, 3, "Performance--:" + paramString2);
  }
  
  public static void setLogControlBtnVisiable(boolean paramBoolean)
  {
    if (mLogControlButton != null)
    {
      if (paramBoolean) {
        mLogControlButton.setVisibility(0);
      }
    }
    else {
      return;
    }
    mLogControlButton.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaLogUtils
 * JD-Core Version:    0.7.0.1
 */