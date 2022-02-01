package com.tencent.tkd.topicsdk.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.style;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.framework.BaseDialog;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/CommonProgressDialog;", "Lcom/tencent/tkd/topicsdk/framework/BaseDialog;", "context", "Landroid/content/Context;", "dialogStyle", "", "(Landroid/content/Context;I)V", "background", "Landroid/widget/RelativeLayout;", "frameAnimation", "Landroid/graphics/drawable/Animatable;", "isNightMode", "", "()Z", "value", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "msgTextView", "Landroid/widget/TextView;", "progressImg", "Landroid/widget/ImageView;", "rootView", "Landroid/view/View;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "showProgress", "show", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CommonProgressDialog
  extends BaseDialog
{
  public static final CommonProgressDialog.Companion a = new CommonProgressDialog.Companion(null);
  private final View b;
  private final TextView c;
  private ImageView d;
  private Animatable e;
  private final RelativeLayout f;
  @NotNull
  private String g;
  
  public CommonProgressDialog(@NotNull Context paramContext, int paramInt)
  {
    super(paramContext, R.style.a);
    if (paramInt == 2)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(R.layout.b, null);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…on_progress_center, null)");
    }
    else
    {
      paramContext = LayoutInflater.from(paramContext).inflate(R.layout.a, null);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…og_common_progress, null)");
    }
    this.b = paramContext;
    paramContext = this.b.findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootView.findViewById(R.id.background)");
    this.f = ((RelativeLayout)paramContext);
    paramContext = this.b.findViewById(R.id.aw);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootView.findViewById(R.id.tv_content)");
    this.c = ((TextView)paramContext);
    paramContext = this.b.findViewById(R.id.H);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootView.findViewById(R.id.iv_progress)");
    this.d = ((ImageView)paramContext);
    paramContext = this.d.getDrawable();
    if (paramContext != null)
    {
      this.e = ((Animatable)paramContext);
      this.g = "";
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Animatable");
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.g = paramString;
    this.c.setText((CharSequence)paramString);
  }
  
  public boolean a()
  {
    return TopicSDK.a.a().b().j().a();
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 196	com/tencent/tkd/topicsdk/framework/BaseDialog:dismiss	()V
    //   4: getstatic 201	com/tencent/tkd/topicsdk/common/ActivityLeakSolution:a	Lcom/tencent/tkd/topicsdk/common/ActivityLeakSolution;
    //   7: aload_0
    //   8: checkcast 203	android/app/Dialog
    //   11: invokevirtual 206	com/tencent/tkd/topicsdk/common/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: goto +37 -> 53
    //   19: astore_1
    //   20: new 208	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   27: astore_2
    //   28: aload_2
    //   29: ldc 212
    //   31: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 221
    //   43: aload_2
    //   44: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 229	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: goto -46 -> 4
    //   53: getstatic 201	com/tencent/tkd/topicsdk/common/ActivityLeakSolution:a	Lcom/tencent/tkd/topicsdk/common/ActivityLeakSolution;
    //   56: aload_0
    //   57: checkcast 203	android/app/Dialog
    //   60: invokevirtual 206	com/tencent/tkd/topicsdk/common/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   63: goto +5 -> 68
    //   66: aload_1
    //   67: athrow
    //   68: goto -2 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	CommonProgressDialog
    //   15	1	1	localObject	java.lang.Object
    //   19	48	1	localException	java.lang.Exception
    //   27	17	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	4	15	finally
    //   20	50	15	finally
    //   0	4	19	java/lang/Exception
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setContentView(this.b);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle = paramBundle.getAttributes();
    } else {
      paramBundle = null;
    }
    if (paramBundle != null) {
      paramBundle.width = -1;
    }
    if (paramBundle != null) {
      paramBundle.height = -1;
    }
    if (paramBundle != null) {
      paramBundle.gravity = 48;
    }
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setAttributes(paramBundle);
    }
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.d.postDelayed((Runnable)new CommonProgressDialog.onStart.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.e.isRunning()) {
      this.e.stop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.CommonProgressDialog
 * JD-Core Version:    0.7.0.1
 */