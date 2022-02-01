package com.tencent.xaction.trigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.gesture.Prediction;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.trigger.gesture.GestureListener;
import com.tencent.xaction.trigger.gesture.GestureRecognizer;
import com.tencent.xaction.trigger.touch.TouchEventHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/GestureTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "gestureRecognizer", "Lcom/tencent/xaction/trigger/gesture/GestureRecognizer;", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "ptype", "getPtype", "setPtype", "score", "", "getScore", "()D", "setScore", "(D)V", "initGesture", "", "context", "Landroid/content/Context;", "monitor", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "recognized", "view", "Landroid/view/View;", "predictionList", "", "Landroid/gesture/Prediction;", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class GestureTrigger
  extends BaseTrigger
{
  public static final GestureTrigger.Companion Companion = new GestureTrigger.Companion(null);
  @NotNull
  public static final String STATUS_RECOGNIZED = "recognized";
  @NotNull
  public static final String STATUS_UNDEFINED = "undefined";
  @NotNull
  public static final String TAG = "GestureTrigger";
  private GestureRecognizer gestureRecognizer;
  @Nullable
  private String path;
  @Nullable
  private String ptype;
  private double score = 2.0D;
  
  private final void initGesture(Context paramContext)
  {
    String str = this.path;
    if (str != null)
    {
      int i;
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1) {
        this.gestureRecognizer = new GestureRecognizer(new File(paramContext.getExternalFilesDir(null), str));
      }
    }
  }
  
  private final void recognized(View paramView, List<? extends Prediction> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Prediction localPrediction = (Prediction)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recognized prediction name=");
      localStringBuilder.append(localPrediction.name);
      localStringBuilder.append(", score=");
      localStringBuilder.append(localPrediction.score);
      Log.d("GestureTrigger", localStringBuilder.toString());
      if ((Intrinsics.areEqual(localPrediction.name, this.ptype)) && (localPrediction.score > this.score)) {
        updateStatus(paramView, "recognized");
      }
    }
  }
  
  @Nullable
  public final String getPath()
  {
    return this.path;
  }
  
  @Nullable
  public final String getPtype()
  {
    return this.ptype;
  }
  
  public final double getScore()
  {
    return this.score;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    super.monitor(paramViewData, paramIView);
    paramViewData = paramIView.getDecor().getProxy();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramIView = paramViewData.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramIView, "view.context");
    initGesture(paramIView);
    paramIView = this.gestureRecognizer;
    if (paramIView != null) {
      paramIView.a((GestureListener)new GestureTrigger.monitor.1(this, paramViewData));
    }
    TouchEventHelper.a.a(paramViewData, (View.OnTouchListener)new GestureTrigger.monitor.2(this));
  }
  
  public final void setPath(@Nullable String paramString)
  {
    this.path = paramString;
  }
  
  public final void setPtype(@Nullable String paramString)
  {
    this.ptype = paramString;
  }
  
  public final void setScore(double paramDouble)
  {
    this.score = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.GestureTrigger
 * JD-Core Version:    0.7.0.1
 */