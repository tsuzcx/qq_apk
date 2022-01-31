package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import bhuu;
import bhuw;
import bhws;
import bhwt;
import bhwv;
import bhww;
import bhwx;
import bhwy;
import bhwz;
import bica;
import java.util.ArrayList;

public class ExpandableListView
  extends ListView
{
  private static final int jdField_a_of_type_Int = getStyleableValue("ExpandableListView_childDivider");
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[][] jdField_a_of_type_Array2dOfInt = { jdField_a_of_type_ArrayOfInt, jdField_b_of_type_ArrayOfInt, jdField_c_of_type_ArrayOfInt, jdField_d_of_type_ArrayOfInt };
  private static final int jdField_b_of_type_Int = getStyleableValue("ExpandableListView_childIndicatorRight");
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int jdField_c_of_type_Int = getStyleableValue("ExpandableListView_childIndicatorLeft");
  private static final int[] jdField_c_of_type_ArrayOfInt;
  private static final int jdField_d_of_type_Int = getStyleableValue("ExpandableListView_indicatorRight");
  private static final int[] jdField_d_of_type_ArrayOfInt;
  private static final int jdField_e_of_type_Int = getStyleableValue("ExpandableListView_indicatorLeft");
  private static final int[] jdField_e_of_type_ArrayOfInt = { 16842918 };
  private static final int f = getStyleableValue("ExpandableListView_childIndicator");
  private static final int g = getStyleableValue("ExpandableListView_groupIndicator");
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ExpandableListAdapter jdField_a_of_type_AndroidWidgetExpandableListAdapter;
  private bhww jdField_a_of_type_Bhww;
  private bhwx jdField_a_of_type_Bhwx;
  private bhwy jdField_a_of_type_Bhwy;
  private bhwz jdField_a_of_type_Bhwz;
  private ExpandableListConnector jdField_a_of_type_ComTencentWidgetExpandableListConnector;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private int h;
  private int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[0];
    jdField_b_of_type_ArrayOfInt = new int[] { 16842920 };
    jdField_c_of_type_ArrayOfInt = new int[] { 16842921 };
    jdField_d_of_type_ArrayOfInt = new int[] { 16842920, 16842921 };
  }
  
  public ExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new bica(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("ExpandableListView"), paramInt, 0));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.a(g);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.a(f);
    this.h = paramContext.c(jdField_e_of_type_Int, 0);
    this.i = paramContext.c(jdField_d_of_type_Int, 0);
    if ((this.i == 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.i = (this.h + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth());
    }
    this.j = paramContext.c(jdField_c_of_type_Int, -1);
    this.k = paramContext.c(jdField_b_of_type_Int, -1);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.a(jdField_a_of_type_Int);
    paramContext.a();
  }
  
  private int a(int paramInt)
  {
    return paramInt - getHeaderViewsCount();
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return 0x0 | (paramInt1 & 0x7FFFFFFF) << 32 | paramInt2 & 0xFFFFFFFF;
  }
  
  private long a(bhwt parambhwt)
  {
    if (parambhwt.jdField_d_of_type_Int == 1) {
      return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildId(parambhwt.jdField_a_of_type_Int, parambhwt.jdField_b_of_type_Int);
    }
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupId(parambhwt.jdField_a_of_type_Int);
  }
  
  private Drawable a(bhws parambhws)
  {
    int n = 1;
    int i1 = 0;
    Drawable localDrawable;
    if (parambhws.jdField_a_of_type_Bhwt.jdField_d_of_type_Int == 2)
    {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((localDrawable != null) && (localDrawable.isStateful()))
      {
        int m;
        if ((parambhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata == null) || (parambhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_b_of_type_Int == parambhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_a_of_type_Int))
        {
          m = 1;
          if (!parambhws.a()) {
            break label97;
          }
        }
        for (;;)
        {
          if (m != 0) {
            i1 = 2;
          }
          localDrawable.setState(jdField_a_of_type_Array2dOfInt[(n | i1)]);
          return localDrawable;
          m = 0;
          break;
          label97:
          n = 0;
        }
      }
    }
    else
    {
      localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if ((localDrawable != null) && (localDrawable.isStateful())) {
        if (parambhws.jdField_a_of_type_Bhwt.jdField_c_of_type_Int != parambhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_b_of_type_Int) {
          break label152;
        }
      }
      label152:
      for (parambhws = jdField_e_of_type_ArrayOfInt;; parambhws = jdField_a_of_type_ArrayOfInt)
      {
        localDrawable.setState(parambhws);
        return localDrawable;
      }
    }
    return localDrawable;
  }
  
  private int b(int paramInt)
  {
    return getHeaderViewsCount() + paramInt;
  }
  
  public static int b(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return 2;
    }
    if ((paramLong & 0x0) == -9223372036854775808L) {
      return 1;
    }
    return 0;
  }
  
  public static long b(int paramInt)
  {
    return (paramInt & 0x7FFFFFFF) << 32;
  }
  
  public static int c(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return -1;
    }
    return (int)((0x0 & paramLong) >> 32);
  }
  
  public static int d(long paramLong)
  {
    if (paramLong == 4294967295L) {}
    while ((paramLong & 0x0) != -9223372036854775808L) {
      return -1;
    }
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  private boolean d(int paramInt)
  {
    int m = this.mItemCount;
    int n = getFooterViewsCount();
    return (paramInt < getHeaderViewsCount()) || (paramInt >= m - n);
  }
  
  public int a(long paramLong)
  {
    Object localObject = bhwt.a(paramLong);
    if (localObject == null) {
      return -1;
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a((bhwt)localObject);
    int m = ((bhws)localObject).jdField_a_of_type_Bhwt.jdField_c_of_type_Int;
    ((bhws)localObject).a();
    return b(m);
  }
  
  public long a(int paramInt)
  {
    if (d(paramInt)) {
      return 4294967295L;
    }
    paramInt = a(paramInt);
    bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    long l = localbhws.jdField_a_of_type_Bhwt.a();
    localbhws.a();
    return l;
  }
  
  public ExpandableListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter;
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    bhwt localbhwt = bhwt.a(paramInt1, paramInt2);
    bhws localbhws2 = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localbhwt);
    bhws localbhws1 = localbhws2;
    if (localbhws2 == null)
    {
      if (!paramBoolean) {
        return false;
      }
      a(paramInt1);
      localbhws2 = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localbhwt);
      localbhws1 = localbhws2;
      if (localbhws2 == null) {
        throw new IllegalStateException("Could not find child");
      }
    }
    super.setSelection(b(localbhws1.jdField_a_of_type_Bhwt.jdField_c_of_type_Int));
    localbhwt.a();
    localbhws1.a();
    return true;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(bhwt.a(2, paramInt, -1, -1));
    boolean bool = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.b(localbhws);
    if (this.jdField_a_of_type_Bhwz != null) {
      this.jdField_a_of_type_Bhwz.a(paramInt);
    }
    if (paramBoolean)
    {
      int m = localbhws.jdField_a_of_type_Bhwt.jdField_c_of_type_Int + getHeaderViewsCount();
      smoothScrollToPosition(this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + m, m);
    }
    localbhws.a();
    return bool;
  }
  
  boolean a(View paramView, int paramInt, long paramLong)
  {
    bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    paramLong = a(localbhws.jdField_a_of_type_Bhwt);
    if (localbhws.jdField_a_of_type_Bhwt.jdField_d_of_type_Int == 2)
    {
      if ((this.jdField_a_of_type_Bhwx != null) && (this.jdField_a_of_type_Bhwx.a(this, paramView, localbhws.jdField_a_of_type_Bhwt.jdField_a_of_type_Int, paramLong)))
      {
        localbhws.a();
        return true;
      }
      if (localbhws.a())
      {
        this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localbhws);
        playSoundEffect(0);
        if (this.jdField_a_of_type_Bhwy != null) {
          this.jdField_a_of_type_Bhwy.a(localbhws.jdField_a_of_type_Bhwt.jdField_a_of_type_Int);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localbhws.a();
      return bool;
      this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.b(localbhws);
      playSoundEffect(0);
      if (this.jdField_a_of_type_Bhwz != null) {
        this.jdField_a_of_type_Bhwz.a(localbhws.jdField_a_of_type_Bhwt.jdField_a_of_type_Int);
      }
      paramInt = localbhws.jdField_a_of_type_Bhwt.jdField_a_of_type_Int;
      int m = localbhws.jdField_a_of_type_Bhwt.jdField_c_of_type_Int + getHeaderViewsCount();
      smoothScrollToPosition(this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + m, m);
      break;
      if (this.jdField_a_of_type_Bhww != null)
      {
        playSoundEffect(0);
        return this.jdField_a_of_type_Bhww.a(this, paramView, localbhws.jdField_a_of_type_Bhwt.jdField_a_of_type_Int, localbhws.jdField_a_of_type_Bhwt.jdField_b_of_type_Int, paramLong);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    if (this.jdField_a_of_type_Bhwy != null) {
      this.jdField_a_of_type_Bhwy.a(paramInt);
    }
    return bool;
  }
  
  public boolean c(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.b(paramInt);
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    if (d(paramInt)) {
      return new bhuu(paramView, paramInt, paramLong);
    }
    paramInt = a(paramInt);
    bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    bhwt localbhwt = localbhws.jdField_a_of_type_Bhwt;
    localbhws.a();
    paramLong = a(localbhwt);
    long l = localbhwt.a();
    localbhwt.a();
    return new bhwv(paramView, l, paramLong);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    int i2 = 0;
    int i1;
    label38:
    int m;
    int i5;
    int i6;
    int i7;
    int i8;
    Rect localRect;
    int i4;
    int i3;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      i1 = 1;
      if (i1 != 0)
      {
        i2 = paramCanvas.save();
        m = getScrollX();
        n = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + m, getPaddingTop() + n, m + getRight() - getLeft() - getPaddingRight(), n + getBottom() - getTop() - getPaddingBottom());
      }
      i5 = getHeaderViewsCount();
      i6 = this.mItemCount;
      i7 = getFooterViewsCount();
      i8 = getBottom();
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      int i9 = getChildCount();
      n = this.mFirstPosition;
      m = -4;
      i4 = 0;
      i3 = n - i5;
      label161:
      if (i4 >= i9) {
        break label213;
      }
      if (i3 >= 0) {
        break label198;
      }
      n = m;
    }
    label198:
    label213:
    int i10;
    int i11;
    do
    {
      do
      {
        i4 += 1;
        i3 += 1;
        m = n;
        break label161;
        i1 = 0;
        break label38;
        if (i3 > i6 - i7 - i5 - 1)
        {
          if (i1 == 0) {
            break;
          }
          paramCanvas.restoreToCount(i2);
          return;
        }
        localObject = getChildAt(i4);
        i10 = ((View)localObject).getTop();
        i11 = ((View)localObject).getBottom();
        n = m;
      } while (i11 < 0);
      n = m;
    } while (i10 > i8);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(i3);
    int n = m;
    if (((bhws)localObject).jdField_a_of_type_Bhwt.jdField_d_of_type_Int != m)
    {
      if (((bhws)localObject).jdField_a_of_type_Bhwt.jdField_d_of_type_Int != 1) {
        break label461;
      }
      if (this.j == -1)
      {
        m = this.h;
        label313:
        localRect.left = m;
        if (this.k != -1) {
          break label453;
        }
        m = this.i;
        label332:
        localRect.right = m;
        label338:
        localRect.left += getPaddingLeft();
        localRect.right += getPaddingLeft();
        n = ((bhws)localObject).jdField_a_of_type_Bhwt.jdField_d_of_type_Int;
      }
    }
    else if (localRect.left != localRect.right)
    {
      if (!this.mStackFromBottom) {
        break label482;
      }
      localRect.top = i10;
    }
    for (localRect.bottom = i11;; localRect.bottom = i11)
    {
      Drawable localDrawable = a((bhws)localObject);
      if (localDrawable != null)
      {
        localDrawable.setBounds(localRect);
        localDrawable.draw(paramCanvas);
      }
      ((bhws)localObject).a();
      break;
      m = this.j;
      break label313;
      label453:
      m = this.k;
      break label332;
      label461:
      localRect.left = this.h;
      localRect.right = this.i;
      break label338;
      label482:
      localRect.top = i10;
    }
  }
  
  void drawDivider(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    paramInt = this.mFirstPosition + paramInt;
    if (paramInt >= 0)
    {
      int m = a(paramInt);
      bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(m);
      if ((localbhws.jdField_a_of_type_Bhwt.jdField_d_of_type_Int == 1) || ((localbhws.a()) && (localbhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_b_of_type_Int != localbhws.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_a_of_type_Int)))
      {
        Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null)
        {
          localDrawable.setBounds(paramRect);
          localDrawable.draw(paramCanvas);
        }
        localbhws.a();
        return;
      }
      localbhws.a();
    }
    super.drawDivider(paramCanvas, paramRect, paramInt);
  }
  
  public ListAdapter getAdapter()
  {
    return super.getAdapter();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExpandableListView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (ExpandableListView.SavedState)paramParcelable;
      super.onRestoreInstanceState(ExpandableListView.SavedState.a(paramParcelable));
    } while ((this.jdField_a_of_type_ComTencentWidgetExpandableListConnector == null) || (paramParcelable.a == null));
    this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramParcelable.a);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListConnector != null) {}
    for (ArrayList localArrayList = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a();; localArrayList = null) {
      return new ExpandableListView.SavedState(localParcelable, localArrayList);
    }
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    if (d(paramInt)) {
      return super.performItemClick(paramView, paramInt, paramLong);
    }
    return a(paramView, a(paramInt), paramLong);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetExpandableListAdapter = paramExpandableListAdapter;
    if (paramExpandableListAdapter != null) {}
    for (this.jdField_a_of_type_ComTencentWidgetExpandableListConnector = new ExpandableListConnector(paramExpandableListAdapter);; this.jdField_a_of_type_ComTencentWidgetExpandableListConnector = null)
    {
      super.setAdapter(this.jdField_a_of_type_ComTencentWidgetExpandableListConnector);
      return;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
  }
  
  public void setChildDivider(Drawable paramDrawable)
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setChildIndicator(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setChildIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((this.i == 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.i = (this.h + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth());
    }
  }
  
  public void setIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void setOnChildClickListener(bhww parambhww)
  {
    this.jdField_a_of_type_Bhww = parambhww;
  }
  
  public void setOnGroupClickListener(bhwx parambhwx)
  {
    this.jdField_a_of_type_Bhwx = parambhwx;
  }
  
  public void setOnGroupCollapseListener(bhwy parambhwy)
  {
    this.jdField_a_of_type_Bhwy = parambhwy;
  }
  
  public void setOnGroupExpandListener(bhwz parambhwz)
  {
    this.jdField_a_of_type_Bhwz = parambhwz;
  }
  
  public void setOnItemClickListener(bhuw parambhuw)
  {
    super.setOnItemClickListener(parambhuw);
  }
  
  public void setSelectedGroup(int paramInt)
  {
    bhwt localbhwt = bhwt.a(paramInt);
    bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localbhwt);
    localbhwt.a();
    super.setSelection(b(localbhws.jdField_a_of_type_Bhwt.jdField_c_of_type_Int));
    localbhws.a();
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    bhwt localbhwt = bhwt.a(paramInt);
    bhws localbhws = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localbhwt);
    localbhwt.a();
    int m = localbhws.jdField_a_of_type_Bhwt.jdField_c_of_type_Int + getHeaderViewsCount();
    smoothScrollToPosition(this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + m, m);
    localbhws.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView
 * JD-Core Version:    0.7.0.1
 */