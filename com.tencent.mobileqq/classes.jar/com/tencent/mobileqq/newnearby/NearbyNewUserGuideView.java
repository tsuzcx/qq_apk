package com.tencent.mobileqq.newnearby;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileReportKt;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/newnearby/NearbyNewUserGuideView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "configs", "", "Lcom/tencent/mobileqq/newnearby/NearbyNewUserGuideView$Config;", "webTop", "", "parentView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Ljava/util/List;ILandroid/view/ViewGroup;)V", "bottomLayout", "currentConfigIndex", "nextStepText", "Landroid/widget/TextView;", "noticeText", "topLayout", "transparentView", "Landroid/view/View;", "showNextItem", "", "Companion", "Config", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyNewUserGuideView
  extends FrameLayout
{
  public static final NearbyNewUserGuideView.Companion a = new NearbyNewUserGuideView.Companion(null);
  private final TextView b;
  private final TextView c;
  private final ViewGroup d;
  private final ViewGroup e;
  private final View f;
  private int g;
  private final List<NearbyNewUserGuideView.Config> h;
  private final int i;
  private final ViewGroup j;
  
  public NearbyNewUserGuideView(@NotNull Context paramContext, @NotNull List<NearbyNewUserGuideView.Config> paramList, int paramInt, @NotNull ViewGroup paramViewGroup)
  {
    super(paramContext);
    this.h = paramList;
    this.i = paramInt;
    this.j = paramViewGroup;
    this.g = -1;
    LayoutInflater.from(paramContext).inflate(1946484754, (ViewGroup)this);
    paramContext = findViewById(1946419218);
    paramList = (TextView)paramContext;
    paramList.setOnClickListener((View.OnClickListener)new NearbyNewUserGuideView..special..inlined.apply.lambda.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById<TextView>(R…)\n            }\n        }");
    this.b = paramList;
    paramContext = findViewById(1946419219);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.notice_text)");
    this.c = ((TextView)paramContext);
    paramContext = findViewById(1946419232);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.top_layout)");
    this.d = ((ViewGroup)paramContext);
    paramContext = findViewById(1946419200);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.bottom_layout)");
    this.e = ((ViewGroup)paramContext);
    paramContext = findViewById(1946419233);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.transparent_bg)");
    this.f = paramContext;
    setOnClickListener((View.OnClickListener)NearbyNewUserGuideView.2.a);
    a();
  }
  
  @JvmStatic
  @Nullable
  public static final List<NearbyNewUserGuideView.Config> a(@NotNull String paramString)
  {
    return a.a(paramString);
  }
  
  private final void a()
  {
    this.g += 1;
    if (this.g >= this.h.size())
    {
      QLog.i("NearbyNewUserGuideView", 1, "all tags showed, remove self");
      this.j.removeView((View)this);
      return;
    }
    NearbyProfileReportKt.a(this.g + 1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("show item ");
    ((StringBuilder)localObject1).append(this.g);
    QLog.i("NearbyNewUserGuideView", 1, ((StringBuilder)localObject1).toString());
    NearbyNewUserGuideView.Config localConfig = (NearbyNewUserGuideView.Config)this.h.get(this.g);
    localObject1 = this.d;
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = (this.i + localConfig.b());
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (Drawable)new NearbyCenterTransparentDrawable(UIUtils.a(getContext(), 10.0F), localConfig.a(), localConfig.c());
    if (Build.VERSION.SDK_INT >= 16) {
      this.f.setBackground((Drawable)localObject1);
    } else {
      this.f.setBackgroundDrawable((Drawable)localObject1);
    }
    localObject1 = this.f;
    localObject2 = ((View)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = localConfig.d();
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.c.setText((CharSequence)localConfig.e());
    localObject2 = this.b;
    if (this.g + 1 == this.h.size()) {
      localObject1 = (CharSequence)getContext().getString(1946615818);
    } else {
      localObject1 = (CharSequence)getContext().getString(1946615819, new Object[] { Integer.valueOf(this.g + 1), Integer.valueOf(this.h.size()) });
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    if (this.g == 0) {
      return;
    }
    post((Runnable)new NearbyNewUserGuideView.showNextItem.3(this, localConfig));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyNewUserGuideView
 * JD-Core Version:    0.7.0.1
 */