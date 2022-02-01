package dov.com.qq.im.aeeditor.module.edit.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/edit/widgets/AEEditorCheckGroupView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checked", "checkedChangeListener", "Ldov/com/qq/im/aeeditor/module/edit/widgets/AEEditorCheckGroupView$OnCheckedChangeListener;", "lastClickTime", "", "check", "", "id", "getCheckIndex", "innerCheck", "index", "boldText", "", "isDoubleClick", "setOnCheckedChangeListener", "listener", "Companion", "OnCheckedChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AEEditorCheckGroupView
  extends LinearLayout
{
  public static final AEEditorCheckGroupView.Companion a;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private AEEditorCheckGroupView.OnCheckedChangeListener jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$OnCheckedChangeListener;
  
  static
  {
    jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$Companion = new AEEditorCheckGroupView.Companion(null);
  }
  
  public AEEditorCheckGroupView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AEEditorCheckGroupView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getViewTreeObserver();
    if (paramContext != null) {
      paramContext.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new AEEditorCheckGroupView.1(this));
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView1;
    if (paramInt != this.jdField_a_of_type_Int)
    {
      localView1 = getChildAt(paramInt);
      localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$OnCheckedChangeListener;
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localView1, "vCurrChecked");
        if (((AEEditorCheckGroupView.OnCheckedChangeListener)localObject).a(this, localView1.getId()) == true)
        {
          localView1.setSelected(true);
          if ((localView1 instanceof Checkable)) {
            break label399;
          }
        }
      }
    }
    label392:
    label399:
    for (Object localObject = null;; localObject = localView1)
    {
      localObject = (Checkable)localObject;
      if (localObject != null) {
        ((Checkable)localObject).setChecked(true);
      }
      if (paramBoolean1) {
        if ((localView1 instanceof ViewGroup)) {
          break label392;
        }
      }
      for (localObject = null;; localObject = localView1)
      {
        View localView2;
        if ((ViewGroup)localObject != null)
        {
          j = ((ViewGroup)localView1).getChildCount();
          if (j <= 0)
          {
            i = 0;
            for (;;)
            {
              localView2 = ((ViewGroup)localView1).getChildAt(i);
              localObject = localView2;
              if (!(localView2 instanceof TextView)) {
                localObject = null;
              }
              localObject = (TextView)localObject;
              if (localObject != null) {
                ((TextView)localObject).setTypeface(null, 1);
              }
              if (i == j) {
                break;
              }
              i += 1;
            }
          }
        }
        int i = getChildCount();
        int j = this.jdField_a_of_type_Int;
        if (j < 0) {}
        while (i <= j)
        {
          this.jdField_a_of_type_Int = paramInt;
          return;
        }
        localView1 = getChildAt(this.jdField_a_of_type_Int);
        if (localView1 != null) {
          localView1.setSelected(false);
        }
        if (!(localView1 instanceof Checkable)) {}
        for (localObject = null;; localObject = localView1)
        {
          localObject = (Checkable)localObject;
          if (localObject != null) {
            ((Checkable)localObject).setChecked(false);
          }
          if (!paramBoolean1) {
            break;
          }
          if (!(localView1 instanceof ViewGroup)) {}
          for (localObject = null;; localObject = localView1)
          {
            if ((ViewGroup)localObject == null) {
              break label383;
            }
            j = ((ViewGroup)localView1).getChildCount();
            if (j <= 0)
            {
              i = 0;
              for (;;)
              {
                localView2 = ((ViewGroup)localView1).getChildAt(i);
                localObject = localView2;
                if (!(localView2 instanceof TextView)) {
                  localObject = null;
                }
                localObject = (TextView)localObject;
                if (localObject != null) {
                  ((TextView)localObject).setTypeface(null, 0);
                }
                if (i == j) {
                  break;
                }
                i += 1;
              }
            }
            break;
          }
          label383:
          break;
        }
      }
    }
  }
  
  public final void a(int paramInt)
  {
    int j = getChildCount();
    if (j <= 0)
    {
      int i = 0;
      for (;;)
      {
        View localView = getChildAt(i);
        if ((localView != null) && (localView.getId() == paramInt)) {
          a(this, i, false, false, 6, null);
        }
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public final void setOnCheckedChangeListener(@NotNull AEEditorCheckGroupView.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnCheckedChangeListener, "listener");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView
 * JD-Core Version:    0.7.0.1
 */