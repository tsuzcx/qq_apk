package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinSetTypeface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TagCloudView
  extends View
  implements ISkinSetTypeface
{
  public static final int b;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(7);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TagCloudView.OnUpdateDrawingListener jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView$OnUpdateDrawingListener;
  List<Tag> jdField_a_of_type_JavaUtilList = new ArrayList();
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean = false;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  List<TagCloudView.FillTag> jdField_b_of_type_JavaUtilList = new ArrayList();
  int c = jdField_b_of_type_Int;
  int d;
  int e = 42;
  int f = -16777216;
  
  static
  {
    jdField_b_of_type_Int = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
  }
  
  public TagCloudView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TagCloudView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TagCloudView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Int = 0;
    a();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("layoutChildren start w:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" h:");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.i("TagCloudView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject3 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    Object localObject2 = a(null, paramInt1, paramInt2);
    Object localObject4 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    ((List)localObject4).addAll(this.jdField_a_of_type_JavaUtilList);
    int k = 0;
    int j = 0;
    while (j < ((List)localObject4).size())
    {
      Tag localTag = (Tag)((List)localObject4).get(j);
      if ((!localTag.c) && (localTag.jdField_b_of_type_AndroidGraphicsPoint.x * localTag.jdField_b_of_type_AndroidGraphicsPoint.y != 0))
      {
        i = paramInt2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("layoutChildren index:");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(" tagW:");
          ((StringBuilder)localObject1).append(localTag.jdField_b_of_type_AndroidGraphicsPoint.x);
          ((StringBuilder)localObject1).append(" tagH:");
          ((StringBuilder)localObject1).append(localTag.jdField_b_of_type_AndroidGraphicsPoint.y);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(localTag.jdField_a_of_type_JavaLangCharSequence);
          QLog.i("TagCloudView", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
          i = paramInt2;
        }
        for (;;)
        {
          Object localObject5 = a(localTag, (List)localObject1, (List)localObject3, paramInt1, i);
          if ((localObject5 != null) && (((List)localObject5).size() > 0))
          {
            paramInt2 = i;
            localObject2 = localObject1;
            if (localObject5 == null) {
              break;
            }
            paramInt2 = i;
            localObject2 = localObject1;
            if (((List)localObject5).size() <= 0) {
              break;
            }
            localObject5 = a((List)localObject5, paramInt1, i);
            localTag.jdField_a_of_type_AndroidGraphicsPoint.x = ((Rect)localObject5).left;
            localTag.jdField_a_of_type_AndroidGraphicsPoint.y = ((Rect)localObject5).top;
            ((List)localObject3).add(localObject5);
            a((List)localObject1, localTag, paramInt1, i);
            paramInt2 = i;
            localObject2 = localObject1;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("layoutChildren findTheFarest:");
            ((StringBuilder)localObject2).append(localObject5);
            QLog.i("TagCloudView", 4, ((StringBuilder)localObject2).toString());
            paramInt2 = i;
            localObject2 = localObject1;
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "layoutChildren enlarge");
          }
          i = a((List)localObject3, paramInt1, i, (int)(localTag.jdField_b_of_type_AndroidGraphicsPoint.y * 0.3F));
          paramInt2 = 0;
          while (paramInt2 < ((List)localObject3).size())
          {
            ((Tag)((List)localObject4).get(paramInt2)).jdField_a_of_type_AndroidGraphicsPoint.x = ((Rect)((List)localObject3).get(paramInt2)).left;
            ((Tag)((List)localObject4).get(paramInt2)).jdField_a_of_type_AndroidGraphicsPoint.y = ((Rect)((List)localObject3).get(paramInt2)).top;
            paramInt2 += 1;
          }
          localObject1 = a((List)localObject4, paramInt1, i);
        }
      }
      ((List)localObject3).add(new Rect());
      j += 1;
    }
    Object localObject1 = new Point((int)(paramInt1 * 0.5F), (int)(paramInt2 * 0.5F));
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new TagCloudView.TagCenterDisComp(this, (Point)localObject1));
    Collections.sort((List)localObject3, new TagCloudView.RectCenterDisComp(this, (Point)localObject1));
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_JavaUtilList.size() >= 6) {
      i = 2;
    } else if (this.jdField_a_of_type_JavaUtilList.size() >= 4) {
      i = 3;
    }
    a((List)localObject3, (Point)localObject1, i);
    localObject1 = a(a((List)localObject4, paramInt1, paramInt2), (List)localObject3, paramInt1, paramInt2, this.e);
    paramInt1 = k;
    for (;;)
    {
      if (paramInt1 < ((List)localObject1).size())
      {
        localObject2 = (Rect)((List)localObject1).get(paramInt1);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("layoutChildren filltags:");
          ((StringBuilder)localObject3).append(paramInt1);
          ((StringBuilder)localObject3).append(" rect:");
          ((StringBuilder)localObject3).append(((Rect)localObject2).toString());
          QLog.i("TagCloudView", 2, ((StringBuilder)localObject3).toString());
        }
        try
        {
          a((Rect)localObject2);
        }
        catch (StackOverflowError localStackOverflowError) {}
      }
      try
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("get StackOverflowError ");
        ((StringBuilder)localObject4).append(localStackOverflowError.getMessage());
        ((StringBuilder)localObject4).append(" rect:");
        ((StringBuilder)localObject4).append(localObject2);
        ((StringBuilder)localObject4).append(" tags:");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaUtilList.toString());
        QLog.i("TagCloudView", 1, ((StringBuilder)localObject4).toString(), localStackOverflowError);
        label915:
        paramInt1 += 1;
        continue;
        return paramInt2;
      }
      catch (Exception localException)
      {
        break label915;
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2, List<Tag> paramList, int paramInt3)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramList.size())
    {
      Tag localTag = (Tag)paramList.get(paramInt2);
      for (int k = localTag.a(paramInt1); (k > paramInt3 * 1.0F) && (!localTag.c); k = localTag.a(paramInt1))
      {
        localTag.a();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("measureChildren too high ");
          localStringBuilder.append(localTag.jdField_a_of_type_JavaLangCharSequence);
          QLog.i("TagCloudView", 2, localStringBuilder.toString());
        }
        localTag.jdField_a_of_type_Float *= 0.75F;
        localTag.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localTag.jdField_a_of_type_Float);
      }
      j = i;
      if (!localTag.c) {
        j = Math.max(i, k);
      }
      paramInt2 += 1;
      i = j;
    }
    return i;
  }
  
  private int a(Rect paramRect)
  {
    int i2 = 3;
    int[] arrayOfInt1 = new int[3];
    int[] tmp10_8 = arrayOfInt1;
    tmp10_8[0] = -1;
    int[] tmp14_10 = tmp10_8;
    tmp14_10[1] = -1;
    int[] tmp18_14 = tmp14_10;
    tmp18_14[2] = -1;
    tmp18_14;
    int[] arrayOfInt2 = new int[3];
    int[] tmp30_28 = arrayOfInt2;
    tmp30_28[0] = -1;
    int[] tmp34_30 = tmp30_28;
    tmp34_30[1] = -1;
    int[] tmp38_34 = tmp34_30;
    tmp38_34[2] = -1;
    tmp38_34;
    int i = 0;
    int k = -1;
    int m;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = m)
    {
      Tag localTag = (Tag)this.jdField_a_of_type_JavaUtilList.get(i);
      m = (int)(localTag.b() * 0.8F);
      int n = (int)(localTag.c() * 0.8F);
      if (m * n <= 0)
      {
        n = k;
        m = j;
      }
      else
      {
        int i1;
        if ((m <= paramRect.width()) && (n <= paramRect.height()))
        {
          i1 = (int)(localTag.jdField_a_of_type_Float * 0.8F);
        }
        else
        {
          float f1 = paramRect.width() / localTag.b();
          float f2 = paramRect.height() / localTag.c();
          if (f1 >= f2) {
            f1 = f2;
          }
          i1 = (int)(f1 * localTag.jdField_a_of_type_Float);
        }
        n = k;
        m = j;
        if (i1 > k)
        {
          arrayOfInt2[j] = i1;
          arrayOfInt1[j] = i;
          m = a(arrayOfInt2, true);
          n = arrayOfInt2[m];
        }
      }
      i += 1;
      k = n;
    }
    paramRect = new int[3];
    Rect tmp274_273 = paramRect;
    tmp274_273[0] = -1;
    Rect tmp278_274 = tmp274_273;
    tmp278_274[1] = -1;
    Rect tmp282_278 = tmp278_274;
    tmp282_278[2] = -1;
    tmp282_278;
    if (arrayOfInt1[2] >= 0) {
      i = i2;
    } else if (arrayOfInt1[1] >= 0) {
      i = 2;
    } else if (arrayOfInt1[0] >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return -1;
    }
    j = 0;
    for (k = 0; j < i; k = m)
    {
      m = k;
      if (arrayOfInt2[j] >= this.jdField_a_of_type_Float * 12.0F)
      {
        paramRect[k] = arrayOfInt1[j];
        m = k + 1;
      }
      j += 1;
    }
    if (k > 0) {
      return paramRect[this.jdField_a_of_type_JavaUtilRandom.nextInt(k)];
    }
    return arrayOfInt1[a(arrayOfInt2, false)];
  }
  
  private int a(List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)(paramInt2 * 0.5F);
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      Rect localRect = (Rect)paramList.get(paramInt1);
      if ((localRect.top != 0) && ((localRect.centerY() >= i) || (localRect.bottom == paramInt2)))
      {
        localRect.top += paramInt3;
        localRect.bottom += paramInt3;
      }
      paramInt1 += 1;
    }
    return paramInt2 + paramInt3;
  }
  
  private int a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = paramArrayOfInt[0];
    int i = 0;
    int k = 0;
    while (i < paramArrayOfInt.length)
    {
      int m = 1;
      if (paramBoolean ? paramArrayOfInt[i] >= j : paramArrayOfInt[i] <= j) {
        m = 0;
      }
      if (m != 0)
      {
        j = paramArrayOfInt[i];
        k = i;
      }
      i += 1;
    }
    return k;
  }
  
  private static Rect a(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y, paramPoint.x + paramInt3, paramPoint.y + paramInt3);
    if ((localRect.bottom <= paramInt2) && (localRect.right <= paramInt1) && (localRect.left >= 0) && (localRect.top >= 0))
    {
      if (a(paramList, localRect, null)) {
        return null;
      }
      int i = paramInt1 - paramPoint.x;
      localRect.right = (localRect.left + i);
      if (!(a(paramList, localRect, null) ^ true))
      {
        paramInt1 = paramInt3;
        while (Math.abs(paramInt1 - i) > 2)
        {
          int j = (int)((i + paramInt1) * 0.5F);
          localRect.right = (localRect.left + j);
          if ((a(paramList, localRect, null) ^ true)) {
            paramInt1 = j;
          } else {
            i = j;
          }
        }
        localRect.right = (paramInt1 + localRect.left);
      }
      paramInt1 = paramInt2 - paramPoint.y;
      localRect.bottom = (localRect.top + paramInt1);
      if (!(a(paramList, localRect, null) ^ true))
      {
        while (Math.abs(paramInt3 - paramInt1) > 2)
        {
          paramInt2 = (int)((paramInt1 + paramInt3) * 0.5F);
          localRect.bottom = (localRect.top + paramInt2);
          if ((a(paramList, localRect, null) ^ true)) {
            paramInt3 = paramInt2;
          } else {
            paramInt1 = paramInt2;
          }
        }
        localRect.bottom = (paramInt3 + localRect.top);
      }
      return localRect;
    }
    return null;
  }
  
  private Rect a(List<Rect> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    int i = 0;
    Object localObject = (Rect)paramList.get(0);
    float f2 = -1.0F;
    while (i < paramList.size())
    {
      Rect localRect = (Rect)paramList.get(i);
      float f3 = (float)Math.pow(Math.pow(localRect.exactCenterX() - paramInt1 * 0.5F, 2.0D) + Math.pow(localRect.centerY() - paramInt2 * 0.5F, 2.0D), 0.5D);
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = f3;
      }
      f2 = f1;
      if (f3 > f1)
      {
        localObject = localRect;
        f2 = f3;
      }
      i += 1;
    }
    return localObject;
  }
  
  private static List<Rect> a(Tag paramTag, List<Point> paramList, List<Rect> paramList1, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      int j = ((Point)paramList.get(i)).x;
      int k = ((Point)paramList.get(i)).y;
      Rect localRect = new Rect(j, k, paramTag.jdField_b_of_type_AndroidGraphicsPoint.x + j, paramTag.jdField_b_of_type_AndroidGraphicsPoint.y + k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j - paramTag.jdField_b_of_type_AndroidGraphicsPoint.x, k - paramTag.jdField_b_of_type_AndroidGraphicsPoint.y, j, k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j, k - paramTag.jdField_b_of_type_AndroidGraphicsPoint.y, paramTag.jdField_b_of_type_AndroidGraphicsPoint.x + j, k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j - paramTag.jdField_b_of_type_AndroidGraphicsPoint.x, k, j, paramTag.jdField_b_of_type_AndroidGraphicsPoint.y + k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<Point> a(List<Tag> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    localArrayList.add(new Point(0, 0));
    localArrayList.add(new Point(paramInt1, 0));
    localArrayList.add(new Point(0, paramInt2));
    localArrayList.add(new Point(paramInt1, paramInt2));
    paramInt1 = i;
    if (paramList == null) {
      return localArrayList;
    }
    while (paramInt1 < paramList.size())
    {
      Object localObject = (Tag)paramList.get(paramInt1);
      if ((((Tag)localObject).a()) || (!((Tag)localObject).c))
      {
        Point localPoint1 = new Point(((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.x, ((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.y);
        Point localPoint2 = new Point(((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.x + ((Tag)localObject).jdField_b_of_type_AndroidGraphicsPoint.x, ((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.y);
        Point localPoint3 = new Point(((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.x, ((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.y + ((Tag)localObject).jdField_b_of_type_AndroidGraphicsPoint.y);
        localObject = new Point(((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.x + ((Tag)localObject).jdField_b_of_type_AndroidGraphicsPoint.x, ((Tag)localObject).jdField_a_of_type_AndroidGraphicsPoint.y + ((Tag)localObject).jdField_b_of_type_AndroidGraphicsPoint.y);
        if (!a(localArrayList, localPoint1)) {
          localArrayList.add(localPoint1);
        }
        if (!a(localArrayList, localPoint2)) {
          localArrayList.add(localPoint2);
        }
        if (!a(localArrayList, localPoint3)) {
          localArrayList.add(localPoint3);
        }
        if (!a(localArrayList, (Point)localObject)) {
          localArrayList.add(localObject);
        }
      }
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  private static List<Rect> a(List<Point> paramList, List<Rect> paramList1, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TagCloudView", 2, "findAllEmptyRect");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = paramList.size() - 1;
    Object localObject1;
    while (i >= 0)
    {
      localObject1 = (Point)paramList.get(i);
      Object localObject3 = a((Point)localObject1, paramList1, paramInt1, paramInt2, paramInt3);
      Point localPoint;
      if (localObject3 != null)
      {
        localArrayList1.add(localObject3);
        paramList1.add(localObject3);
        localPoint = new Point(((Rect)localObject3).left + ((Rect)localObject3).width(), ((Rect)localObject3).top);
        localObject2 = new Point(((Rect)localObject3).left, ((Rect)localObject3).top + ((Rect)localObject3).height());
        localObject3 = new Point(((Rect)localObject3).left + ((Rect)localObject3).width(), ((Rect)localObject3).top + ((Rect)localObject3).height());
        localArrayList2.add(localPoint);
        localArrayList2.add(localObject2);
        localArrayList2.add(localObject3);
      }
      Object localObject2 = b((Point)localObject1, paramList1, paramInt1, paramInt2, paramInt3);
      if (localObject2 != null)
      {
        localArrayList1.add(localObject2);
        paramList1.add(localObject2);
        localObject1 = new Point(((Rect)localObject2).left, ((Rect)localObject2).top);
        localPoint = new Point(((Rect)localObject2).left + ((Rect)localObject2).width(), ((Rect)localObject2).top);
        localObject2 = new Point(((Rect)localObject2).left + ((Rect)localObject2).width(), ((Rect)localObject2).top + ((Rect)localObject2).height());
        localArrayList2.add(localObject1);
        localArrayList2.add(localPoint);
        localArrayList2.add(localObject2);
      }
      paramList.remove(i);
      i -= 1;
    }
    i = localArrayList2.size() - 1;
    while (i >= 0)
    {
      paramList = (Point)localArrayList2.get(i);
      localObject1 = a(paramList, paramList1, paramInt1, paramInt2, paramInt3);
      if (localObject1 != null)
      {
        localArrayList1.add(localObject1);
        paramList1.add(localObject1);
      }
      paramList = b(paramList, paramList1, paramInt1, paramInt2, paramInt3);
      if (paramList != null)
      {
        localArrayList1.add(paramList);
        paramList1.add(paramList);
      }
      localArrayList2.remove(i);
      i -= 1;
    }
    return localArrayList1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    Tag.a((int)(this.jdField_a_of_type_Float * 4.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-16777216);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    int i;
    if (((j >= 0) && (paramInt != j)) || ((k >= 0) && (paramInt != k))) {
      i = 0;
    } else {
      i = 1;
    }
    paramCanvas.save();
    paramCanvas.clipRect(0, 0, paramInt, paramInt);
    if (i != 0)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix = null;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, paramInt, paramInt);
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
      this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      float f2 = 0.0F;
      float f3;
      float f1;
      if (j * paramInt > paramInt * k)
      {
        f3 = paramInt;
        f1 = f3 / k;
        f3 = (f3 - j * f1) * 0.5F;
      }
      else
      {
        f2 = paramInt;
        f1 = f2 / j;
        f2 = (f2 - k * f1) * 0.5F;
        f3 = 0.0F;
      }
      this.jdField_b_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(Math.round(f3), Math.round(f2));
    }
    if (this.jdField_b_of_type_AndroidGraphicsMatrix == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    else
    {
      paramCanvas.save();
      paramCanvas.concat(this.jdField_b_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  private void a(Rect paramRect)
  {
    float f1 = this.e * 0.5F;
    if ((paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.height() >= f1) && (paramRect.width() >= f1) && ((paramRect.width() >= this.e) || (paramRect.height() >= this.e)))
    {
      int i = paramRect.height();
      int j = paramRect.width();
      int k = this.e;
      if (i * j < k * k) {
        return;
      }
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fillWithTags rect:");
        ((StringBuilder)localObject).append(paramRect);
        QLog.i("TagCloudView", 4, ((StringBuilder)localObject).toString());
      }
      j = paramRect.width();
      k = this.e;
      i = 0;
      boolean bool;
      if (((j >= k * 4) || (paramRect.height() >= this.e * 4)) && (paramRect.width() > this.e) && (paramRect.height() > this.e)) {
        bool = false;
      } else {
        bool = true;
      }
      j = a(paramRect);
      if (j < 0) {
        return;
      }
      Object localObject = (Tag)this.jdField_a_of_type_JavaUtilList.get(j);
      float f2 = ((Tag)localObject).b();
      f1 = 0.8F;
      int m = (int)(f2 * 0.8F);
      k = (int)(((Tag)localObject).c() * 0.8F);
      if (m * k <= 0) {
        return;
      }
      if ((m <= paramRect.width()) && (k <= paramRect.height()))
      {
        if (!bool) {
          f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat() * 0.45F + 0.5F;
        }
        i = (int)(((Tag)localObject).b() * f1);
        k = (int)(((Tag)localObject).c() * f1);
        this.jdField_b_of_type_JavaUtilList.add(new TagCloudView.FillTag(j, f1, paramRect.left, paramRect.top));
        localObject = new Rect(paramRect.left + i, paramRect.top, paramRect.right, paramRect.top + k);
        paramRect = new Rect(paramRect.left, paramRect.top + k, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
        a(paramRect);
        return;
      }
      f1 = paramRect.width() / ((Tag)localObject).b();
      f2 = paramRect.height() / ((Tag)localObject).c();
      if (f1 < f2) {
        i = 1;
      }
      if (i == 0) {
        f1 = f2;
      }
      m = (int)(((Tag)localObject).b() * f1 + 0.5F);
      int n = (int)(((Tag)localObject).c() * f1 + 0.5F);
      k = Math.max(paramRect.width() / m, paramRect.height() / k);
      if (k > 30)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fillWithTags WARNING!!! ");
        localStringBuilder.append(k);
        localStringBuilder.append(" w:");
        localStringBuilder.append(paramRect.width());
        localStringBuilder.append(" h:");
        localStringBuilder.append(paramRect.height());
        localStringBuilder.append(" tagW:");
        localStringBuilder.append(((Tag)localObject).b());
        localStringBuilder.append(" tagH:");
        localStringBuilder.append(((Tag)localObject).b());
        localStringBuilder.append(" small:");
        localStringBuilder.append(bool);
        QLog.i("TagCloudView", 1, localStringBuilder.toString());
        if (bool) {
          return;
        }
      }
      localObject = new Rect();
      if (i != 0)
      {
        ((Rect)localObject).set(paramRect.left, paramRect.top + n, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
      }
      else
      {
        ((Rect)localObject).set(paramRect.left + m, paramRect.top, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
      }
      this.jdField_b_of_type_JavaUtilList.add(new TagCloudView.FillTag(j, f1, paramRect.left, paramRect.top));
    }
  }
  
  public static void a(List<Tag> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ((Tag)paramList.get(i)).a();
      i += 1;
    }
  }
  
  private void a(List<Rect> paramList, Point paramPoint, int paramInt)
  {
    int k = 0;
    int j;
    for (int m = 0; (k < this.jdField_a_of_type_JavaUtilList.size()) && (m < paramInt); m = j)
    {
      Tag localTag = (Tag)this.jdField_a_of_type_JavaUtilList.get(k);
      if (localTag.c)
      {
        j = m;
      }
      else
      {
        int n = (int)(paramPoint.x - (localTag.jdField_a_of_type_AndroidGraphicsPoint.x + localTag.jdField_b_of_type_AndroidGraphicsPoint.x * 0.5F));
        int i1 = (int)(paramPoint.y - (localTag.jdField_a_of_type_AndroidGraphicsPoint.y + localTag.jdField_b_of_type_AndroidGraphicsPoint.y * 0.5F));
        Rect localRect1 = (Rect)paramList.get(k);
        Rect localRect2 = new Rect(localRect1);
        localRect2.offset(n, 0);
        if (a(paramList, localRect2, localRect1))
        {
          i = 0;
          for (;;)
          {
            j = i;
            if (Math.abs(n - i) <= 1) {
              break;
            }
            j = (int)((n + i) * 0.5F);
            localRect2.set(localRect1);
            localRect2.offset(j, 0);
            if (!a(paramList, localRect2, localRect1)) {
              i = j;
            } else {
              n = j;
            }
          }
        }
        j = n;
        n = j;
        if (Math.abs(j) < Math.abs(this.e)) {
          n = 0;
        }
        localRect2 = new Rect(localRect1);
        localRect2.offset(n, i1);
        if (a(paramList, localRect2, localRect1))
        {
          i = 0;
          for (;;)
          {
            j = i;
            if (Math.abs(i1 - i) <= 1) {
              break;
            }
            j = (int)((i1 + i) * 0.5F);
            localRect2.set(localRect1);
            localRect2.offset(n, j);
            if (!a(paramList, localRect2, localRect1)) {
              i = j;
            } else {
              i1 = j;
            }
          }
        }
        j = i1;
        int i = j;
        if (Math.abs(j) < Math.abs(this.e)) {
          i = 0;
        }
        if (n <= 0)
        {
          j = m;
          if (i <= 0) {}
        }
        else
        {
          j = m + 1;
          localRect1.offset(n, i);
          localTag.jdField_a_of_type_AndroidGraphicsPoint.x = localRect1.left;
          localTag.jdField_a_of_type_AndroidGraphicsPoint.y = localRect1.top;
        }
      }
      k += 1;
    }
  }
  
  private static void a(List<Point> paramList, Tag paramTag, int paramInt1, int paramInt2)
  {
    if (!paramTag.a()) {
      return;
    }
    Point localPoint1 = new Point(paramTag.jdField_a_of_type_AndroidGraphicsPoint.x, paramTag.jdField_a_of_type_AndroidGraphicsPoint.y);
    Point localPoint2 = new Point(paramTag.jdField_a_of_type_AndroidGraphicsPoint.x + paramTag.jdField_b_of_type_AndroidGraphicsPoint.x, paramTag.jdField_a_of_type_AndroidGraphicsPoint.y);
    Point localPoint3 = new Point(paramTag.jdField_a_of_type_AndroidGraphicsPoint.x, paramTag.jdField_a_of_type_AndroidGraphicsPoint.y + paramTag.jdField_b_of_type_AndroidGraphicsPoint.y);
    paramTag = new Point(paramTag.jdField_a_of_type_AndroidGraphicsPoint.x + paramTag.jdField_b_of_type_AndroidGraphicsPoint.x, paramTag.jdField_a_of_type_AndroidGraphicsPoint.y + paramTag.jdField_b_of_type_AndroidGraphicsPoint.y);
    if (!a(paramList, localPoint1)) {
      paramList.add(localPoint1);
    }
    if (!a(paramList, localPoint2)) {
      paramList.add(localPoint2);
    }
    if (!a(paramList, localPoint3)) {
      paramList.add(localPoint3);
    }
    if (!a(paramList, paramTag)) {
      paramList.add(paramTag);
    }
  }
  
  private static boolean a(Rect paramRect, List<Rect> paramList, int paramInt1, int paramInt2)
  {
    if ((paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.right >= 0) && (paramRect.bottom >= 0) && (paramRect.right <= paramInt1))
    {
      if (paramRect.bottom > paramInt2) {
        return false;
      }
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        if (Rect.intersects(paramRect, (Rect)paramList.get(paramInt1))) {
          return false;
        }
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  private static boolean a(List<Point> paramList, Point paramPoint)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramPoint.equals(paramList.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean a(List<Rect> paramList, Rect paramRect1, Rect paramRect2)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((!((Rect)paramList.get(i)).equals(paramRect2)) && (Rect.intersects((Rect)paramList.get(i), paramRect1))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static int b(Point paramPoint1, Point paramPoint2)
  {
    return (int)(Math.pow(Math.abs(paramPoint1.x - paramPoint2.x), 2.0D) + Math.pow(Math.abs(paramPoint1.y - paramPoint2.y), 2.0D));
  }
  
  private static Rect b(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y - paramInt3, paramPoint.x + paramInt3, paramPoint.y);
    if ((localRect.bottom <= paramInt2) && (localRect.right <= paramInt1) && (localRect.left >= 0) && (localRect.top >= 0))
    {
      if (a(paramList, localRect, null)) {
        return null;
      }
      paramInt2 = paramInt1 - paramPoint.x;
      localRect.right = (localRect.left + paramInt2);
      if (!(a(paramList, localRect, null) ^ true))
      {
        paramInt1 = paramInt3;
        while (Math.abs(paramInt1 - paramInt2) > 2)
        {
          int i = (int)((paramInt2 + paramInt1) * 0.5F);
          localRect.right = (localRect.left + i);
          if ((a(paramList, localRect, null) ^ true)) {
            paramInt1 = i;
          } else {
            paramInt2 = i;
          }
        }
        localRect.right = (paramInt1 + localRect.left);
      }
      paramInt1 = paramPoint.y;
      localRect.top = (localRect.bottom - paramInt1);
      if (!(a(paramList, localRect, null) ^ true))
      {
        while (Math.abs(paramInt3 - paramInt1) > 2)
        {
          paramInt2 = (int)((paramInt1 + paramInt3) * 0.5F);
          localRect.top = (localRect.bottom - paramInt2);
          if ((a(paramList, localRect, null) ^ true)) {
            paramInt3 = paramInt2;
          } else {
            paramInt1 = paramInt2;
          }
        }
        localRect.top = (localRect.bottom - paramInt3);
      }
      return localRect;
    }
    return null;
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), 0);
    if (i != this.f) {
      this.f = i;
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    if ((localColorStateList != null) && (localColorStateList.isStateful())) {
      b();
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TagCloudView", 4, "onDraw");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView$OnUpdateDrawingListener != null)
    {
      Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localObject1 != null) && ((!this.jdField_a_of_type_Boolean) || ((((Bitmap)localObject1).getWidth() == getMeasuredWidth()) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() == getMeasuredHeight()))))
      {
        localObject1 = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
        break label183;
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject1 != null)
      {
        ((Bitmap)localObject1).recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, localOutOfMemoryError.getMessage());
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject2 != null)
      {
        localObject2 = new Canvas((Bitmap)localObject2);
        break label183;
      }
    }
    Object localObject2 = paramCanvas;
    label183:
    Object localObject3 = new Point(0, 0);
    int m = getPaddingLeft();
    Object localObject4 = new ArrayList();
    ((List)localObject4).addAll(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    Object localObject5;
    int j;
    while (i < ((List)localObject4).size())
    {
      localObject5 = (Tag)((List)localObject4).get(i);
      if ((!((Tag)localObject5).c) && (((Tag)localObject5).a()))
      {
        Object localObject6 = ((Tag)localObject5).jdField_a_of_type_AndroidTextTextPaint;
        Point localPoint1 = ((Tag)localObject5).jdField_a_of_type_AndroidGraphicsPoint;
        Point localPoint2 = ((Tag)localObject5).jdField_b_of_type_AndroidGraphicsPoint;
        if (((Tag)localObject5).jdField_b_of_type_Int != 0)
        {
          ((Canvas)localObject2).save();
          ((Canvas)localObject2).clipRect(localPoint1.x + m, localPoint1.y, localPoint1.x + localPoint2.x + m, localPoint1.y + localPoint2.y);
          ((Canvas)localObject2).translate(localPoint1.x + m, localPoint1.y);
          ((Canvas)localObject2).scale(((Tag)localObject5).jdField_b_of_type_Float, ((Tag)localObject5).jdField_b_of_type_Float);
          ((Canvas)localObject2).drawColor(((Tag)localObject5).jdField_b_of_type_Int);
          ((Canvas)localObject2).restore();
        }
        ((Point)localObject3).set(0, 0);
        int n = Tag.f;
        j = ((Tag)localObject5).e;
        int k = 1;
        if (j == 2)
        {
          ((Canvas)localObject2).save();
          if (((Tag)localObject5).jdField_b_of_type_Boolean)
          {
            boolean bool = ((Tag)localObject5).jdField_a_of_type_Boolean;
            j = localPoint2.y - n * 2;
            if (bool)
            {
              ((Point)localObject3).set(j + n + n, n);
              ((Canvas)localObject2).translate(localPoint1.x + n + m, localPoint1.y + n);
            }
            else
            {
              ((Point)localObject3).set(n, n);
              ((Canvas)localObject2).translate(localPoint1.x + localPoint2.x - j - n + m, localPoint1.y + n);
            }
          }
          else
          {
            j = localPoint2.x - n * 2;
            if (((Tag)localObject5).jdField_a_of_type_Boolean)
            {
              ((Point)localObject3).set(n, j + n + n);
              ((Canvas)localObject2).translate(localPoint1.x + n + m, localPoint1.y + n);
            }
            else
            {
              ((Point)localObject3).set(n, n);
              ((Canvas)localObject2).translate(localPoint1.x + n + m, localPoint1.y + localPoint2.y - j - n);
            }
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            a((Canvas)localObject2, j);
          }
          ((Canvas)localObject2).restore();
        }
        else if (((Tag)localObject5).e == 1)
        {
          ((Point)localObject3).set(n, n);
        }
        n = ((Tag)localObject5).e;
        j = 255;
        if ((n != 0) && (!((Tag)localObject5).c))
        {
          ((TextPaint)localObject6).setColor(-1);
          ((TextPaint)localObject6).setAlpha(255);
          j = k;
        }
        else
        {
          ((TextPaint)localObject6).setColor(this.f);
          if (((Tag)localObject5).c) {
            j = 64;
          }
          ((TextPaint)localObject6).setAlpha(j);
          j = 0;
        }
        ((TextPaint)localObject6).setFakeBoldText(((Tag)localObject5).jdField_d_of_type_Boolean);
        ((Canvas)localObject2).save();
        ((Canvas)localObject2).translate(((Point)localObject3).x + localPoint1.x + m, ((Point)localObject3).y + localPoint1.y - (((Tag)localObject5).jdField_b_of_type_Float * ((Tag)localObject5).jdField_d_of_type_Int + 0.5F));
        if (((Tag)localObject5).jdField_b_of_type_Boolean)
        {
          ((Canvas)localObject2).scale(((Tag)localObject5).jdField_b_of_type_Float, ((Tag)localObject5).jdField_b_of_type_Float);
          ((Tag)localObject5).jdField_a_of_type_AndroidTextLayout.draw((Canvas)localObject2);
        }
        else
        {
          ((Canvas)localObject2).scale(((Tag)localObject5).jdField_b_of_type_Float, ((Tag)localObject5).jdField_b_of_type_Float);
          k = 0;
          while (k < ((Tag)localObject5).jdField_b_of_type_JavaUtilList.size())
          {
            localObject6 = (Layout)((Tag)localObject5).jdField_b_of_type_JavaUtilList.get(k);
            ((Layout)localObject6).draw((Canvas)localObject2);
            ((Canvas)localObject2).translate(((Layout)localObject6).getWidth(), 0.0F);
            k += 1;
          }
        }
        ((Canvas)localObject2).restore();
        if ((j != 0) && (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())))
        {
          ((Canvas)localObject2).save();
          ((Canvas)localObject2).clipRect(localPoint1.x + m, localPoint1.y, localPoint1.x + localPoint2.x + m, localPoint1.y + localPoint2.y);
          ((Canvas)localObject2).translate(localPoint1.x + m, localPoint1.y);
          ((Canvas)localObject2).scale(((Tag)localObject5).jdField_b_of_type_Float, ((Tag)localObject5).jdField_b_of_type_Float);
          ((Canvas)localObject2).drawColor(Color.argb(127, 0, 0, 0));
          ((Canvas)localObject2).restore();
        }
      }
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      localObject4 = (TagCloudView.FillTag)this.jdField_b_of_type_JavaUtilList.get(i);
      localObject3 = (Tag)this.jdField_a_of_type_JavaUtilList.get(((TagCloudView.FillTag)localObject4).jdField_a_of_type_Int);
      localObject5 = ((Tag)localObject3).jdField_a_of_type_AndroidTextTextPaint;
      ((TextPaint)localObject5).setColor(this.f);
      ((TextPaint)localObject5).setAlpha(64);
      ((TextPaint)localObject5).setFakeBoldText(false);
      localObject5 = new Point(((TagCloudView.FillTag)localObject4).jdField_b_of_type_Int, ((TagCloudView.FillTag)localObject4).c);
      ((Canvas)localObject2).save();
      ((Canvas)localObject2).translate(((Point)localObject5).x + m, ((Point)localObject5).y - ((Tag)localObject3).jdField_d_of_type_Int * ((TagCloudView.FillTag)localObject4).jdField_a_of_type_Float);
      ((Canvas)localObject2).scale(((TagCloudView.FillTag)localObject4).jdField_a_of_type_Float, ((TagCloudView.FillTag)localObject4).jdField_a_of_type_Float);
      if (((Tag)localObject3).jdField_b_of_type_Boolean) {
        ((Tag)localObject3).jdField_a_of_type_AndroidTextLayout.draw((Canvas)localObject2);
      }
      for (;;)
      {
        break;
        j = 0;
        while (j < ((Tag)localObject3).jdField_b_of_type_JavaUtilList.size())
        {
          localObject4 = (Layout)((Tag)localObject3).jdField_b_of_type_JavaUtilList.get(j);
          ((Layout)localObject4).draw((Canvas)localObject2);
          ((Canvas)localObject2).translate(((Layout)localObject4).getWidth(), 0.0F);
          j += 1;
        }
      }
      ((Canvas)localObject2).restore();
      i += 1;
    }
    localObject2 = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView$OnUpdateDrawingListener != null)
    {
      localObject3 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject3 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject3, (Rect)localObject2, (Rect)localObject2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramCanvas = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView$OnUpdateDrawingListener;
      if (paramCanvas != null) {
        paramCanvas.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure, wSpec:");
      localStringBuilder.append(i);
      localStringBuilder.append(" hSize:");
      localStringBuilder.append(k);
      QLog.i("TagCloudView", 2, localStringBuilder.toString());
    }
    paramInt2 = i;
    if (n == 0) {
      paramInt2 = 2147483647;
    }
    int m = paramInt2 - (getPaddingLeft() + getPaddingRight());
    if (this.c == paramInt1)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TagCloudView", 2, "onMeasure, use cache return.");
      }
      return;
    }
    this.c = paramInt1;
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramInt2 = a(View.MeasureSpec.makeMeasureSpec(m, n), 0, this.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_Int);
    i = this.jdField_d_of_type_Int;
    paramInt1 = paramInt2;
    if (paramInt2 < i) {
      paramInt1 = i;
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new TagCloudView.RectRandomDescComp(this, this.jdField_a_of_type_JavaUtilRandom, (int)(m * 0.7F), (int)(this.jdField_d_of_type_Int * 0.7F)));
    paramInt2 = a(m, paramInt1);
    if (j == 1073741824)
    {
      paramInt1 = paramInt2;
    }
    else
    {
      paramInt1 = paramInt2;
      if (j == -2147483648)
      {
        paramInt1 = paramInt2;
        if (k > 0) {
          paramInt1 = Math.min(k, paramInt2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure, setDimension w:");
      localStringBuilder.append(m);
      localStringBuilder.append(" h:");
      localStringBuilder.append(paramInt1);
      QLog.i("TagCloudView", 2, localStringBuilder.toString());
    }
    setMeasuredDimension(m + getPaddingRight() + getPaddingRight(), paramInt1);
  }
  
  public void setMaxEms(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMinHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setOnUpdateDrawingListener(TagCloudView.OnUpdateDrawingListener paramOnUpdateDrawingListener)
  {
    if (paramOnUpdateDrawingListener != this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView$OnUpdateDrawingListener)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView$OnUpdateDrawingListener = paramOnUpdateDrawingListener;
      if (paramOnUpdateDrawingListener == null)
      {
        this.jdField_a_of_type_Boolean = false;
        paramOnUpdateDrawingListener = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (paramOnUpdateDrawingListener != null)
        {
          paramOnUpdateDrawingListener.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
      }
      invalidate();
    }
  }
  
  public void setTagIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable != null) {
        paramDrawable.setCallback(this);
      }
      invalidate();
    }
  }
  
  public void setTags(List<Tag> paramList)
  {
    this.c = jdField_b_of_type_Int;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(paramInt);
    b();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      b();
      return;
    }
    throw new NullPointerException();
  }
  
  public void setThreshold(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Tag localTag = (Tag)((Iterator)localObject).next();
        if ((localTag != null) && (localTag.jdField_a_of_type_AndroidTextTextPaint != null)) {
          localTag.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
        }
      }
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView
 * JD-Core Version:    0.7.0.1
 */