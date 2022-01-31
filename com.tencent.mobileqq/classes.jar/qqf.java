import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemView;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormTableData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxView;
import java.lang.ref.WeakReference;

public class qqf
  extends TableLayout
{
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private GdtCanvasFormTableData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData;
  
  public qqf(Context paramContext, GdtCanvasFormTableData paramGdtCanvasFormTableData, WeakReference paramWeakReference)
  {
    super(paramContext);
    a(paramContext, paramGdtCanvasFormTableData, paramWeakReference);
  }
  
  private Drawable a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.isValid()) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize() != getChildCount()))
    {
      GdtLog.d("GdtCanvasFormTableView", "getBackground error");
      localObject1 = null;
    }
    int i;
    Object localObject2;
    label164:
    do
    {
      return localObject1;
      if (paramInt == -1)
      {
        i = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize();
        localObject1 = new Drawable[i];
        j = 0;
      }
      for (;;)
      {
        if (j >= this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize()) {
          break label164;
        }
        localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getItem(j);
        if (localObject2 == null)
        {
          GdtLog.d("GdtCanvasFormTableView", "getBackground error");
          return null;
          i = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize() + 1;
          break;
        }
        localObject1[j] = a(a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderCornerRadius, j, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize()), this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderWidth, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderColor, ((GdtCanvasFormItemData)localObject2).backgroundColor);
        j += 1;
      }
      if (paramInt != -1)
      {
        localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getItem(paramInt);
        if (localObject2 == null)
        {
          GdtLog.d("GdtCanvasFormTableView", "getBackground error");
          return null;
        }
        localObject1[(i - 1)] = a(a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderCornerRadius, paramInt, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize()), this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderWidth, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderColorError, ((GdtCanvasFormItemData)localObject2).backgroundColor);
      }
      localObject2 = new LayerDrawable((Drawable[])localObject1);
      int j = 0;
      while (j < this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize())
      {
        localObject1 = getChildAt(j);
        if (localObject1 == null)
        {
          GdtLog.d("GdtCanvasFormTableView", "getBackground error");
          return null;
        }
        ((LayerDrawable)localObject2).setLayerInset(j, 0, ((View)localObject1).getTop() - this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderWidth);
        j += 1;
      }
      localObject1 = localObject2;
    } while (paramInt == -1);
    Object localObject1 = getChildAt(paramInt);
    if (localObject1 == null)
    {
      GdtLog.d("GdtCanvasFormTableView", "getBackground error");
      return null;
    }
    ((LayerDrawable)localObject2).setLayerInset(i - 1, 0, ((View)localObject1).getTop() - this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.borderWidth);
    return localObject2;
  }
  
  private static Drawable a(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    localGradientDrawable.setStroke(paramInt1, paramInt2);
    localGradientDrawable.setColor(paramInt3);
    return localGradientDrawable;
  }
  
  private void a(Context paramContext, GdtCanvasFormTableData paramGdtCanvasFormTableData, WeakReference paramWeakReference)
  {
    if ((paramContext == null) || (paramGdtCanvasFormTableData == null) || (!paramGdtCanvasFormTableData.isValid()))
    {
      GdtLog.d("GdtCanvasFormTableView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData = paramGdtCanvasFormTableData;
    setColumnShrinkable(1, true);
    setColumnStretchable(1, true);
    int i = 0;
    while (i < paramGdtCanvasFormTableData.getSize())
    {
      Object localObject = paramGdtCanvasFormTableData.getItem(i);
      GdtCanvasFormItemTextBoxView localGdtCanvasFormItemTextBoxView = null;
      if ((localObject instanceof GdtCanvasFormItemTextBoxData)) {
        localGdtCanvasFormItemTextBoxView = new GdtCanvasFormItemTextBoxView(paramContext, (GdtCanvasFormItemTextBoxData)GdtCanvasFormItemTextBoxData.class.cast(localObject), paramWeakReference);
      }
      if (localGdtCanvasFormItemTextBoxView == null)
      {
        GdtLog.d("GdtCanvasFormTableView", "init error");
        i += 1;
      }
      else
      {
        localObject = new TableLayout.LayoutParams(-2, -2);
        if (i == paramGdtCanvasFormTableData.getSize() - 1) {
          ((TableLayout.LayoutParams)localObject).setMargins(paramGdtCanvasFormTableData.borderWidth, paramGdtCanvasFormTableData.borderWidth, paramGdtCanvasFormTableData.borderWidth, paramGdtCanvasFormTableData.borderWidth);
        }
        for (;;)
        {
          addView(localGdtCanvasFormItemTextBoxView, (ViewGroup.LayoutParams)localObject);
          break;
          ((TableLayout.LayoutParams)localObject).setMargins(paramGdtCanvasFormTableData.borderWidth, paramGdtCanvasFormTableData.borderWidth, paramGdtCanvasFormTableData.borderWidth, 0);
        }
      }
    }
    b();
  }
  
  private static float[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 0) || (paramInt2 >= paramInt3) || (paramInt3 <= 0)) {
      return null;
    }
    if (paramInt3 == 1) {
      return new float[] { paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1 };
    }
    if (paramInt2 == 0) {
      return new float[] { paramInt1, paramInt1, paramInt1, paramInt1, 0.0F, 0.0F, 0.0F, 0.0F };
    }
    if (paramInt2 == paramInt3 - 1) {
      return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt1, paramInt1, paramInt1 };
    }
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  @TargetApi(16)
  private void b()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) && (getViewTreeObserver() != null))
      {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      }
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new qqg(this);
    } while ((this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) || (getViewTreeObserver() == null));
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void a()
  {
    b();
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.isValid()) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormTableData.getSize() != getChildCount()))
    {
      GdtLog.d("GdtCanvasFormTableView", "reset error");
      return;
    }
    int i = 0;
    label45:
    if (i < getChildCount())
    {
      if ((getChildAt(i) != null) && ((getChildAt(i) instanceof GdtCanvasFormItemView))) {
        break label86;
      }
      GdtLog.d("GdtCanvasFormTableView", "reset error");
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label86:
      ((GdtCanvasFormItemView)GdtCanvasFormItemView.class.cast(getChildAt(i))).a();
    }
  }
  
  @TargetApi(16)
  public void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(a(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqf
 * JD-Core Version:    0.7.0.1
 */