package com.tencent.timi.game.profile.impl.view.record;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/view/record/MessageSmobaRecordView;", "Lcom/tencent/timi/game/profile/impl/view/record/BaseProfileSmobaRecordView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initView", "", "refreshUI", "renderIfUidInvalid", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageSmobaRecordView
  extends BaseProfileSmobaRecordView
{
  private HashMap a;
  
  public MessageSmobaRecordView(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MessageSmobaRecordView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MessageSmobaRecordView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    RelativeLayout.inflate(paramContext, 2131629468, (ViewGroup)this);
    paramContext = (LinearLayout)b(2131431755);
    if (paramContext != null) {
      ViewExKt.a((View)paramContext, LayoutExKt.b(4), new int[] { Color.parseColor("#FEFAF1") });
    }
  }
  
  public View b(int paramInt)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    View localView2 = (View)this.a.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.a.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void c()
  {
    View localView1 = b(2131433190);
    Intrinsics.checkExpressionValueIsNotNull(localView1, "firstDescribeItem");
    View localView2 = b(2131445465);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "secondDescribeItem");
    View localView3 = b(2131447306);
    Intrinsics.checkExpressionValueIsNotNull(localView3, "thirdDescribeItem");
    a(localView1, localView2, localView3);
  }
  
  public void e()
  {
    Object localObject = (ImageView)b(2131444401);
    if (localObject != null) {
      a((ImageView)localObject, g());
    }
    localObject = b(2131433190);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "firstDescribeItem");
    View localView1 = b(2131445465);
    Intrinsics.checkExpressionValueIsNotNull(localView1, "secondDescribeItem");
    View localView2 = b(2131447306);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "thirdDescribeItem");
    a((View)localObject, localView1, localView2);
    a((TextView)b(2131435018), (LinearLayout)b(2131445108));
    localObject = (TextView)b(2131440530);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)f());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.record.MessageSmobaRecordView
 * JD-Core Version:    0.7.0.1
 */