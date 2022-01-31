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
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import auun;
import auuo;
import auup;
import auuq;
import auur;
import auus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TagCloudView
  extends View
{
  public static final int b;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(7);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  auup jdField_a_of_type_Auup;
  List<auun> jdField_a_of_type_JavaUtilList = new ArrayList();
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  List<auuo> jdField_b_of_type_JavaUtilList = new ArrayList();
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
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("TagCloudView", 2, "layoutChildren start w:" + paramInt1 + " h:" + paramInt2);
    }
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    Object localObject1 = a(null, paramInt1, paramInt2);
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    localArrayList2.addAll(this.jdField_a_of_type_JavaUtilList);
    int j = 0;
    Object localObject2;
    while (j < localArrayList2.size())
    {
      auun localauun = (auun)localArrayList2.get(j);
      if ((localauun.c) || (localauun.jdField_b_of_type_AndroidGraphicsPoint.x * localauun.jdField_b_of_type_AndroidGraphicsPoint.y == 0))
      {
        localArrayList1.add(new Rect());
        j += 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, "layoutChildren index:" + j + " tagW:" + localauun.jdField_b_of_type_AndroidGraphicsPoint.x + " tagH:" + localauun.jdField_b_of_type_AndroidGraphicsPoint.y + " " + localauun.jdField_a_of_type_JavaLangCharSequence);
        }
        i = paramInt2;
        for (localObject2 = localObject1;; localObject2 = a(localArrayList2, paramInt1, i))
        {
          Object localObject3 = a(localauun, (List)localObject2, localArrayList1, paramInt1, i);
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            localObject1 = localObject2;
            paramInt2 = i;
            if (localObject3 == null) {
              break;
            }
            localObject1 = localObject2;
            paramInt2 = i;
            if (((List)localObject3).size() <= 0) {
              break;
            }
            localObject3 = a((List)localObject3, paramInt1, i);
            localauun.jdField_a_of_type_AndroidGraphicsPoint.x = ((Rect)localObject3).left;
            localauun.jdField_a_of_type_AndroidGraphicsPoint.y = ((Rect)localObject3).top;
            localArrayList1.add(localObject3);
            a((List)localObject2, localauun, paramInt1, i);
            localObject1 = localObject2;
            paramInt2 = i;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.i("TagCloudView", 4, "layoutChildren findTheFarest:" + localObject3);
            localObject1 = localObject2;
            paramInt2 = i;
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "layoutChildren enlarge");
          }
          i = a(localArrayList1, paramInt1, i, (int)(0.3F * localauun.jdField_b_of_type_AndroidGraphicsPoint.y));
          paramInt2 = 0;
          while (paramInt2 < localArrayList1.size())
          {
            ((auun)localArrayList2.get(paramInt2)).jdField_a_of_type_AndroidGraphicsPoint.x = ((Rect)localArrayList1.get(paramInt2)).left;
            ((auun)localArrayList2.get(paramInt2)).jdField_a_of_type_AndroidGraphicsPoint.y = ((Rect)localArrayList1.get(paramInt2)).top;
            paramInt2 += 1;
          }
        }
      }
    }
    localObject1 = new Point((int)(paramInt1 * 0.5F), (int)(paramInt2 * 0.5F));
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new auus(this, (Point)localObject1));
    Collections.sort(localArrayList1, new auuq(this, (Point)localObject1));
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_JavaUtilList.size() >= 6) {
      i = 2;
    }
    for (;;)
    {
      a(localArrayList1, (Point)localObject1, i);
      localObject1 = a(a(localArrayList2, paramInt1, paramInt2), localArrayList1, paramInt1, paramInt2, this.e);
      paramInt1 = k;
      label661:
      if (paramInt1 < ((List)localObject1).size())
      {
        localObject2 = (Rect)((List)localObject1).get(paramInt1);
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, "layoutChildren filltags:" + paramInt1 + " rect:" + ((Rect)localObject2).toString());
        }
        try
        {
          a((Rect)localObject2);
          paramInt1 += 1;
          break label661;
          if (this.jdField_a_of_type_JavaUtilList.size() >= 4) {
            i = 3;
          }
        }
        catch (StackOverflowError localStackOverflowError)
        {
          for (;;)
          {
            try
            {
              QLog.i("TagCloudView", 1, "get StackOverflowError " + localStackOverflowError.getMessage() + " rect:" + localObject2 + " tags:" + this.jdField_a_of_type_JavaUtilList.toString(), localStackOverflowError);
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    return paramInt2;
  }
  
  private int a(int paramInt1, int paramInt2, List<auun> paramList, int paramInt3)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramList.size())
    {
      auun localauun = (auun)paramList.get(paramInt2);
      for (int k = localauun.a(paramInt1); (k > 1.0F * paramInt3) && (!localauun.c); k = localauun.a(paramInt1))
      {
        localauun.a();
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, "measureChildren too high " + localauun.jdField_a_of_type_JavaLangCharSequence);
        }
        localauun.jdField_a_of_type_Float *= 0.75F;
        localauun.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localauun.jdField_a_of_type_Float);
      }
      j = i;
      if (!localauun.c) {
        j = Math.max(i, k);
      }
      paramInt2 += 1;
      i = j;
    }
    return i;
  }
  
  private int a(Rect paramRect)
  {
    int[] arrayOfInt1 = new int[3];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = -1;
    int[] tmp15_11 = tmp11_7;
    tmp15_11[2] = -1;
    tmp15_11;
    int[] arrayOfInt2 = new int[3];
    int[] tmp27_25 = arrayOfInt2;
    tmp27_25[0] = -1;
    int[] tmp31_27 = tmp27_25;
    tmp31_27[1] = -1;
    int[] tmp35_31 = tmp31_27;
    tmp35_31[2] = -1;
    tmp35_31;
    int i = 0;
    int k = 0;
    int j = -1;
    int m;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      auun localauun = (auun)this.jdField_a_of_type_JavaUtilList.get(i);
      m = (int)(localauun.b() * 0.8F);
      int n = (int)(localauun.c() * 0.8F);
      if (m * n <= 0)
      {
        n = j;
        m = k;
      }
      int i1;
      for (;;)
      {
        i += 1;
        k = m;
        j = n;
        break;
        if ((m > paramRect.width()) || (n > paramRect.height())) {
          break label216;
        }
        i1 = (int)(localauun.jdField_a_of_type_Float * 0.8F);
        m = k;
        n = j;
        if (i1 > j)
        {
          arrayOfInt2[k] = i1;
          arrayOfInt1[k] = i;
          m = a(arrayOfInt2, true);
          n = arrayOfInt2[m];
        }
      }
      label216:
      float f1 = paramRect.width() / localauun.b();
      float f2 = paramRect.height() / localauun.c();
      if (f1 < f2) {}
      for (;;)
      {
        i1 = (int)(localauun.jdField_a_of_type_Float * f1);
        break;
        f1 = f2;
      }
    }
    paramRect = new int[3];
    Rect tmp271_270 = paramRect;
    tmp271_270[0] = -1;
    Rect tmp275_271 = tmp271_270;
    tmp275_271[1] = -1;
    Rect tmp279_275 = tmp275_271;
    tmp279_275[2] = -1;
    tmp279_275;
    if (arrayOfInt1[2] >= 0) {
      i = 3;
    }
    while (i == 0)
    {
      return -1;
      if (arrayOfInt1[1] >= 0) {
        i = 2;
      } else if (arrayOfInt1[0] >= 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
    k = 0;
    j = 0;
    if (k < i)
    {
      if (arrayOfInt2[k] < this.jdField_a_of_type_Float * 12.0F) {
        break label420;
      }
      m = j + 1;
      paramRect[j] = arrayOfInt1[k];
      j = m;
    }
    label420:
    for (;;)
    {
      k += 1;
      break;
      if (j > 0) {
        return paramRect[this.jdField_a_of_type_JavaUtilRandom.nextInt(j)];
      }
      return arrayOfInt1[a(arrayOfInt2, false)];
    }
  }
  
  private int a(List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)(0.5F * paramInt2);
    paramInt1 = 0;
    if (paramInt1 < paramList.size())
    {
      Rect localRect = (Rect)paramList.get(paramInt1);
      if (localRect.top == 0) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((localRect.centerY() >= i) || (localRect.bottom == paramInt2))
        {
          localRect.top += paramInt3;
          localRect.bottom += paramInt3;
        }
      }
    }
    return paramInt2 + paramInt3;
  }
  
  private int a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = paramArrayOfInt[0];
    int m = 0;
    int j = 0;
    if (j < paramArrayOfInt.length)
    {
      int i;
      if (paramBoolean) {
        if (paramArrayOfInt[j] < k) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          k = paramArrayOfInt[j];
          m = j;
        }
        j += 1;
        break;
        i = 0;
        continue;
        if (paramArrayOfInt[j] > k) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    return m;
  }
  
  private static Rect a(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y, paramPoint.x + paramInt3, paramPoint.y + paramInt3);
    if ((localRect.bottom > paramInt2) || (localRect.right > paramInt1) || (localRect.left < 0) || (localRect.top < 0) || (a(paramList, localRect, null))) {
      return null;
    }
    int i = paramInt1 - paramPoint.x;
    localRect.right = (localRect.left + i);
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt3;
      }
    }
    else
    {
      for (;;)
      {
        label117:
        if (Math.abs(paramInt1 - i) <= 2) {
          break label194;
        }
        int j = (int)((i + paramInt1) * 0.5F);
        localRect.right = (localRect.left + j);
        if (!a(paramList, localRect, null)) {}
        for (int k = 1;; k = 0)
        {
          if (k == 0) {
            break label187;
          }
          paramInt1 = j;
          break label117;
          paramInt1 = 0;
          break;
        }
        label187:
        i = j;
      }
      label194:
      localRect.right = (localRect.left + paramInt1);
    }
    paramInt2 -= paramPoint.y;
    localRect.bottom = (localRect.top + paramInt2);
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt2;
      }
    }
    else
    {
      for (;;)
      {
        label243:
        if (Math.abs(paramInt3 - paramInt1) <= 2) {
          break label316;
        }
        paramInt2 = (int)((paramInt1 + paramInt3) * 0.5F);
        localRect.bottom = (localRect.top + paramInt2);
        if (!a(paramList, localRect, null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label311;
          }
          paramInt3 = paramInt2;
          break label243;
          paramInt1 = 0;
          break;
        }
        label311:
        paramInt1 = paramInt2;
      }
      label316:
      localRect.bottom = (localRect.top + paramInt3);
    }
    return localRect;
  }
  
  private Rect a(List<Rect> paramList, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = (Rect)paramList.get(0);
    float f2 = -1.0F;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= paramList.size()) {
        break;
      }
      localObject2 = (Rect)paramList.get(i);
      float f3 = (float)Math.pow(Math.pow(((Rect)localObject2).exactCenterX() - paramInt1 * 0.5F, 2.0D) + Math.pow(((Rect)localObject2).centerY() - paramInt2 * 0.5F, 2.0D), 0.5D);
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = f3;
      }
      f2 = f1;
      if (f3 > f1)
      {
        f2 = f3;
        localObject1 = localObject2;
      }
      i += 1;
    }
  }
  
  private static List<Rect> a(auun paramauun, List<Point> paramList, List<Rect> paramList1, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      int j = ((Point)paramList.get(i)).x;
      int k = ((Point)paramList.get(i)).y;
      Rect localRect = new Rect(j, k, paramauun.jdField_b_of_type_AndroidGraphicsPoint.x + j, paramauun.jdField_b_of_type_AndroidGraphicsPoint.y + k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j - paramauun.jdField_b_of_type_AndroidGraphicsPoint.x, k - paramauun.jdField_b_of_type_AndroidGraphicsPoint.y, j, k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j, k - paramauun.jdField_b_of_type_AndroidGraphicsPoint.y, paramauun.jdField_b_of_type_AndroidGraphicsPoint.x + j, k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j - paramauun.jdField_b_of_type_AndroidGraphicsPoint.x, k, j, paramauun.jdField_b_of_type_AndroidGraphicsPoint.y + k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<Point> a(List<auun> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Point(0, 0));
    localArrayList.add(new Point(paramInt1, 0));
    localArrayList.add(new Point(0, paramInt2));
    localArrayList.add(new Point(paramInt1, paramInt2));
    if (paramList == null) {
      return localArrayList;
    }
    paramInt1 = 0;
    if (paramInt1 < paramList.size())
    {
      Object localObject = (auun)paramList.get(paramInt1);
      if ((!((auun)localObject).a()) && (((auun)localObject).c)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        Point localPoint1 = new Point(((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.x, ((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.y);
        Point localPoint2 = new Point(((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.x + ((auun)localObject).jdField_b_of_type_AndroidGraphicsPoint.x, ((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.y);
        Point localPoint3 = new Point(((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.x, ((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.y + ((auun)localObject).jdField_b_of_type_AndroidGraphicsPoint.y);
        paramInt2 = ((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.x;
        int i = ((auun)localObject).jdField_b_of_type_AndroidGraphicsPoint.x;
        int j = ((auun)localObject).jdField_a_of_type_AndroidGraphicsPoint.y;
        localObject = new Point(paramInt2 + i, ((auun)localObject).jdField_b_of_type_AndroidGraphicsPoint.y + j);
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
      int j;
      int k;
      int m;
      if (localObject3 != null)
      {
        localArrayList1.add(localObject3);
        paramList1.add(localObject3);
        localPoint = new Point(((Rect)localObject3).left + ((Rect)localObject3).width(), ((Rect)localObject3).top);
        localObject2 = new Point(((Rect)localObject3).left, ((Rect)localObject3).top + ((Rect)localObject3).height());
        j = ((Rect)localObject3).left;
        k = ((Rect)localObject3).width();
        m = ((Rect)localObject3).top;
        localObject3 = new Point(j + k, ((Rect)localObject3).height() + m);
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
        j = ((Rect)localObject2).left;
        k = ((Rect)localObject2).width();
        m = ((Rect)localObject2).top;
        localObject2 = new Point(j + k, ((Rect)localObject2).height() + m);
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
    auun.a((int)(this.jdField_a_of_type_Float * 4.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-16777216);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    float f3 = 0.0F;
    int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    int i;
    if (((j < 0) || (paramInt == j)) && ((k < 0) || (paramInt == k)))
    {
      i = 1;
      paramCanvas.save();
      paramCanvas.clipRect(0, 0, paramInt, paramInt);
      if (i == 0) {
        break label107;
      }
      this.jdField_b_of_type_AndroidGraphicsMatrix = null;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, paramInt, paramInt);
      if (this.jdField_b_of_type_AndroidGraphicsMatrix != null) {
        break label227;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      i = 0;
      break;
      label107:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
      this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      float f2;
      if (j * paramInt > paramInt * k)
      {
        f2 = paramInt / k;
        f3 = (paramInt - j * f2) * 0.5F;
      }
      for (float f1 = 0.0F;; f1 = (paramInt - k * f2) * 0.5F)
      {
        this.jdField_b_of_type_AndroidGraphicsMatrix.setScale(f2, f2);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(Math.round(f3), Math.round(f1));
        break;
        f2 = paramInt / j;
      }
      label227:
      paramCanvas.save();
      paramCanvas.concat(this.jdField_b_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private void a(Rect paramRect)
  {
    float f1 = this.e * 0.5F;
    if ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.height() < f1) || (paramRect.width() < f1) || ((paramRect.width() < this.e) && (paramRect.height() < this.e)) || (paramRect.height() * paramRect.width() < this.e * this.e)) {}
    boolean bool;
    label170:
    int j;
    Object localObject;
    int i;
    int k;
    do
    {
      do
      {
        return;
        if (QLog.isDebugVersion()) {
          QLog.i("TagCloudView", 4, "fillWithTags rect:" + paramRect);
        }
        if (((paramRect.width() >= this.e * 4) || (paramRect.height() >= this.e * 4)) && (paramRect.width() > this.e) && (paramRect.height() > this.e)) {
          break;
        }
        bool = true;
        j = a(paramRect);
      } while (j < 0);
      localObject = (auun)this.jdField_a_of_type_JavaUtilList.get(j);
      i = (int)(((auun)localObject).b() * 0.8F);
      k = (int)(((auun)localObject).c() * 0.8F);
    } while (i * k <= 0);
    if ((i <= paramRect.width()) && (k <= paramRect.height())) {
      if (bool) {
        break label701;
      }
    }
    label436:
    label701:
    for (f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat() * 0.45F + 0.5F;; f1 = 0.8F)
    {
      i = (int)(((auun)localObject).b() * f1);
      k = (int)(((auun)localObject).c() * f1);
      this.jdField_b_of_type_JavaUtilList.add(new auuo(j, f1, paramRect.left, paramRect.top));
      localObject = new Rect(i + paramRect.left, paramRect.top, paramRect.right, paramRect.top + k);
      paramRect = new Rect(paramRect.left, k + paramRect.top, paramRect.right, paramRect.bottom);
      a((Rect)localObject);
      a(paramRect);
      return;
      bool = false;
      break label170;
      f1 = paramRect.width() / ((auun)localObject).b();
      float f2 = paramRect.height() / ((auun)localObject).c();
      int m;
      if (f1 < f2)
      {
        i = 1;
        if (i == 0) {
          break label663;
        }
        m = (int)(((auun)localObject).b() * f1 + 0.5F);
        int n = (int)(((auun)localObject).c() * f1 + 0.5F);
        k = Math.max(paramRect.width() / m, paramRect.height() / k);
        if (k > 30)
        {
          QLog.i("TagCloudView", 1, "fillWithTags WARNING!!! " + k + " w:" + paramRect.width() + " h:" + paramRect.height() + " tagW:" + ((auun)localObject).b() + " tagH:" + ((auun)localObject).b() + " small:" + bool);
          if (bool) {
            break;
          }
        }
        localObject = new Rect();
        if (i == 0) {
          break label668;
        }
        ((Rect)localObject).set(paramRect.left, paramRect.top + n, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilList.add(new auuo(j, f1, paramRect.left, paramRect.top));
        return;
        i = 0;
        break;
        f1 = f2;
        break label436;
        ((Rect)localObject).set(paramRect.left + m, paramRect.top, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
      }
    }
  }
  
  public static void a(List<auun> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ((auun)paramList.get(i)).a();
      i += 1;
    }
  }
  
  private void a(List<Rect> paramList, Point paramPoint, int paramInt)
  {
    int m = 0;
    int i = 0;
    if ((m < this.jdField_a_of_type_JavaUtilList.size()) && (i < paramInt))
    {
      auun localauun = (auun)this.jdField_a_of_type_JavaUtilList.get(m);
      if (localauun.c) {}
      for (;;)
      {
        m += 1;
        break;
        int n = (int)(paramPoint.x - (localauun.jdField_a_of_type_AndroidGraphicsPoint.x + 0.5F * localauun.jdField_b_of_type_AndroidGraphicsPoint.x));
        int i1 = (int)(paramPoint.y - (localauun.jdField_a_of_type_AndroidGraphicsPoint.y + 0.5F * localauun.jdField_b_of_type_AndroidGraphicsPoint.y));
        Rect localRect1 = (Rect)paramList.get(m);
        Rect localRect2 = new Rect(localRect1);
        localRect2.offset(n, 0);
        int j;
        if (a(paramList, localRect2, localRect1))
        {
          j = 0;
          for (;;)
          {
            k = j;
            if (Math.abs(n - j) <= 1) {
              break;
            }
            k = (int)(0.5F * (n + j));
            localRect2.set(localRect1);
            localRect2.offset(k, 0);
            if (!a(paramList, localRect2, localRect1)) {
              j = k;
            } else {
              n = k;
            }
          }
        }
        int k = n;
        n = k;
        if (Math.abs(k) < Math.abs(this.e)) {
          n = 0;
        }
        localRect2 = new Rect(localRect1);
        localRect2.offset(n, i1);
        if (a(paramList, localRect2, localRect1))
        {
          j = 0;
          for (;;)
          {
            k = j;
            if (Math.abs(i1 - j) <= 1) {
              break;
            }
            k = (int)(0.5F * (i1 + j));
            localRect2.set(localRect1);
            localRect2.offset(n, k);
            if (!a(paramList, localRect2, localRect1)) {
              j = k;
            } else {
              i1 = k;
            }
          }
        }
        k = i1;
        i1 = k;
        if (Math.abs(k) < Math.abs(this.e)) {
          i1 = 0;
        }
        if (n <= 0)
        {
          j = i;
          if (i1 <= 0) {}
        }
        else
        {
          j = i + 1;
          localRect1.offset(n, i1);
          localauun.jdField_a_of_type_AndroidGraphicsPoint.x = localRect1.left;
          localauun.jdField_a_of_type_AndroidGraphicsPoint.y = localRect1.top;
        }
        i = j;
      }
    }
  }
  
  private static void a(List<Point> paramList, auun paramauun, int paramInt1, int paramInt2)
  {
    if (!paramauun.a()) {}
    do
    {
      return;
      Point localPoint1 = new Point(paramauun.jdField_a_of_type_AndroidGraphicsPoint.x, paramauun.jdField_a_of_type_AndroidGraphicsPoint.y);
      Point localPoint2 = new Point(paramauun.jdField_a_of_type_AndroidGraphicsPoint.x + paramauun.jdField_b_of_type_AndroidGraphicsPoint.x, paramauun.jdField_a_of_type_AndroidGraphicsPoint.y);
      Point localPoint3 = new Point(paramauun.jdField_a_of_type_AndroidGraphicsPoint.x, paramauun.jdField_a_of_type_AndroidGraphicsPoint.y + paramauun.jdField_b_of_type_AndroidGraphicsPoint.y);
      paramauun = new Point(paramauun.jdField_a_of_type_AndroidGraphicsPoint.x + paramauun.jdField_b_of_type_AndroidGraphicsPoint.x, paramauun.jdField_a_of_type_AndroidGraphicsPoint.y + paramauun.jdField_b_of_type_AndroidGraphicsPoint.y);
      if (!a(paramList, localPoint1)) {
        paramList.add(localPoint1);
      }
      if (!a(paramList, localPoint2)) {
        paramList.add(localPoint2);
      }
      if (!a(paramList, localPoint3)) {
        paramList.add(localPoint3);
      }
    } while (a(paramList, paramauun));
    paramList.add(paramauun);
  }
  
  private static boolean a(Rect paramRect, List<Rect> paramList, int paramInt1, int paramInt2)
  {
    if ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.right < 0) || (paramRect.bottom < 0) || (paramRect.right > paramInt1) || (paramRect.bottom > paramInt2)) {
      return false;
    }
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 >= paramList.size()) {
        break label82;
      }
      if (Rect.intersects(paramRect, (Rect)paramList.get(paramInt1))) {
        break;
      }
      paramInt1 += 1;
    }
    label82:
    return true;
  }
  
  private static boolean a(List<Point> paramList, Point paramPoint)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList.size())
      {
        if (paramPoint.equals(paramList.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean a(List<Rect> paramList, Rect paramRect1, Rect paramRect2)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList.size())
      {
        if ((!((Rect)paramList.get(i)).equals(paramRect2)) && (Rect.intersects((Rect)paramList.get(i), paramRect1))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static int b(Point paramPoint1, Point paramPoint2)
  {
    return (int)(Math.pow(Math.abs(paramPoint1.x - paramPoint2.x), 2.0D) + Math.pow(Math.abs(paramPoint1.y - paramPoint2.y), 2.0D));
  }
  
  private static Rect b(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y - paramInt3, paramPoint.x + paramInt3, paramPoint.y);
    if ((localRect.bottom > paramInt2) || (localRect.right > paramInt1) || (localRect.left < 0) || (localRect.top < 0) || (a(paramList, localRect, null))) {
      return null;
    }
    paramInt2 = paramInt1 - paramPoint.x;
    localRect.right = (localRect.left + paramInt2);
    label115:
    int i;
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt3;
      }
    }
    else
    {
      for (;;)
      {
        if (Math.abs(paramInt1 - paramInt2) <= 2) {
          break label189;
        }
        i = (int)((paramInt2 + paramInt1) * 0.5F);
        localRect.right = (localRect.left + i);
        if (!a(paramList, localRect, null)) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label183;
          }
          paramInt1 = i;
          break label115;
          paramInt1 = 0;
          break;
        }
        label183:
        paramInt2 = i;
      }
      label189:
      localRect.right = (localRect.left + paramInt1);
    }
    paramInt2 = paramPoint.y;
    localRect.top = (localRect.bottom - paramInt2);
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt2;
      }
    }
    else
    {
      for (;;)
      {
        label236:
        if (Math.abs(paramInt3 - paramInt1) <= 2) {
          break label309;
        }
        paramInt2 = (int)((paramInt1 + paramInt3) * 0.5F);
        localRect.top = (localRect.bottom - paramInt2);
        if (!a(paramList, localRect, null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label304;
          }
          paramInt3 = paramInt2;
          break label236;
          paramInt1 = 0;
          break;
        }
        label304:
        paramInt1 = paramInt2;
      }
      label309:
      localRect.top = (localRect.bottom - paramInt3);
    }
    return localRect;
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
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
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
    if (this.jdField_a_of_type_Auup != null) {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != getMeasuredWidth()) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != getMeasuredHeight())))) {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      int m;
      Object localObject3;
      Object localObject4;
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1387;
        }
        Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject2 = new Point(0, 0);
        m = getPaddingLeft();
        localObject3 = new ArrayList();
        ((List)localObject3).addAll(this.jdField_a_of_type_JavaUtilList);
        i = 0;
        if (i >= ((List)localObject3).size()) {
          break label1066;
        }
        localObject4 = (auun)((List)localObject3).get(i);
        if ((!((auun)localObject4).c) && (((auun)localObject4).a())) {
          break label255;
        }
        i += 1;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("TagCloudView", 2, localOutOfMemoryError.getMessage());
        continue;
      }
      Object localObject1 = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
      continue;
      label255:
      Object localObject5 = ((auun)localObject4).jdField_a_of_type_AndroidTextTextPaint;
      Point localPoint1 = ((auun)localObject4).jdField_a_of_type_AndroidGraphicsPoint;
      Point localPoint2 = ((auun)localObject4).jdField_b_of_type_AndroidGraphicsPoint;
      if (((auun)localObject4).jdField_b_of_type_Int != 0)
      {
        ((Canvas)localObject1).save();
        ((Canvas)localObject1).clipRect(localPoint1.x + m, localPoint1.y, localPoint1.x + localPoint2.x + m, localPoint1.y + localPoint2.y);
        ((Canvas)localObject1).translate(localPoint1.x + m, localPoint1.y);
        ((Canvas)localObject1).scale(((auun)localObject4).jdField_b_of_type_Float, ((auun)localObject4).jdField_b_of_type_Float);
        ((Canvas)localObject1).drawColor(((auun)localObject4).jdField_b_of_type_Int);
        ((Canvas)localObject1).restore();
      }
      ((Point)localObject2).set(0, 0);
      int k = auun.f;
      int j;
      if (((auun)localObject4).e == 2)
      {
        ((Canvas)localObject1).save();
        if (((auun)localObject4).jdField_b_of_type_Boolean)
        {
          boolean bool = ((auun)localObject4).jdField_a_of_type_Boolean;
          j = localPoint2.y - k * 2;
          if (bool)
          {
            ((Point)localObject2).set(j + k + k, k);
            ((Canvas)localObject1).translate(localPoint1.x + k + m, k + localPoint1.y);
            label482:
            if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
              a((Canvas)localObject1, j);
            }
            ((Canvas)localObject1).restore();
            label501:
            if ((((auun)localObject4).e != 0) && (!((auun)localObject4).c)) {
              break label969;
            }
            ((TextPaint)localObject5).setColor(this.f);
            if (!((auun)localObject4).c) {
              break label962;
            }
            j = 64;
            label537:
            ((TextPaint)localObject5).setAlpha(j);
            j = 0;
            label545:
            ((TextPaint)localObject5).setFakeBoldText(((auun)localObject4).jdField_d_of_type_Boolean);
            ((Canvas)localObject1).save();
            ((Canvas)localObject1).translate(((Point)localObject2).x + localPoint1.x + m, ((Point)localObject2).y + localPoint1.y - (((auun)localObject4).jdField_b_of_type_Float * ((auun)localObject4).jdField_d_of_type_Int + 0.5F));
            if (!((auun)localObject4).jdField_b_of_type_Boolean) {
              break label988;
            }
            ((Canvas)localObject1).scale(((auun)localObject4).jdField_b_of_type_Float, ((auun)localObject4).jdField_b_of_type_Float);
            ((auun)localObject4).jdField_a_of_type_AndroidTextLayout.draw((Canvas)localObject1);
          }
        }
      }
      for (;;)
      {
        ((Canvas)localObject1).restore();
        if ((j == 0) || (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))) {
          break;
        }
        ((Canvas)localObject1).save();
        j = localPoint1.x;
        k = localPoint1.y;
        int n = localPoint1.x;
        int i1 = localPoint2.x;
        int i2 = localPoint1.y;
        ((Canvas)localObject1).clipRect(j + m, k, n + i1 + m, localPoint2.y + i2);
        ((Canvas)localObject1).translate(localPoint1.x + m, localPoint1.y);
        ((Canvas)localObject1).scale(((auun)localObject4).jdField_b_of_type_Float, ((auun)localObject4).jdField_b_of_type_Float);
        ((Canvas)localObject1).drawColor(Color.argb(127, 0, 0, 0));
        ((Canvas)localObject1).restore();
        break;
        ((Point)localObject2).set(k, k);
        ((Canvas)localObject1).translate(localPoint1.x + localPoint2.x - j - k + m, k + localPoint1.y);
        break label482;
        j = localPoint2.x - k * 2;
        if (((auun)localObject4).jdField_a_of_type_Boolean)
        {
          ((Point)localObject2).set(k, j + k + k);
          ((Canvas)localObject1).translate(localPoint1.x + k + m, k + localPoint1.y);
          break label482;
        }
        ((Point)localObject2).set(k, k);
        ((Canvas)localObject1).translate(localPoint1.x + k + m, localPoint1.y + localPoint2.y - j - k);
        break label482;
        if (((auun)localObject4).e != 1) {
          break label501;
        }
        ((Point)localObject2).set(k, k);
        break label501;
        label962:
        j = 255;
        break label537;
        label969:
        ((TextPaint)localObject5).setColor(-1);
        ((TextPaint)localObject5).setAlpha(255);
        j = 1;
        break label545;
        label988:
        ((Canvas)localObject1).scale(((auun)localObject4).jdField_b_of_type_Float, ((auun)localObject4).jdField_b_of_type_Float);
        k = 0;
        while (k < ((auun)localObject4).jdField_b_of_type_JavaUtilList.size())
        {
          localObject5 = (Layout)((auun)localObject4).jdField_b_of_type_JavaUtilList.get(k);
          ((Layout)localObject5).draw((Canvas)localObject1);
          ((Canvas)localObject1).translate(((Layout)localObject5).getWidth(), 0.0F);
          k += 1;
        }
      }
      label1066:
      int i = 0;
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject3 = (auuo)this.jdField_b_of_type_JavaUtilList.get(i);
        localObject2 = (auun)this.jdField_a_of_type_JavaUtilList.get(((auuo)localObject3).jdField_a_of_type_Int);
        localObject4 = ((auun)localObject2).jdField_a_of_type_AndroidTextTextPaint;
        ((TextPaint)localObject4).setColor(this.f);
        ((TextPaint)localObject4).setAlpha(64);
        ((TextPaint)localObject4).setFakeBoldText(false);
        localObject4 = new Point(((auuo)localObject3).jdField_b_of_type_Int, ((auuo)localObject3).c);
        ((Canvas)localObject1).save();
        ((Canvas)localObject1).translate(((Point)localObject4).x + m, ((Point)localObject4).y - ((auun)localObject2).jdField_d_of_type_Int * ((auuo)localObject3).jdField_a_of_type_Float);
        ((Canvas)localObject1).scale(((auuo)localObject3).jdField_a_of_type_Float, ((auuo)localObject3).jdField_a_of_type_Float);
        if (((auun)localObject2).jdField_b_of_type_Boolean) {
          ((auun)localObject2).jdField_a_of_type_AndroidTextLayout.draw((Canvas)localObject1);
        }
        for (;;)
        {
          ((Canvas)localObject1).restore();
          i += 1;
          break;
          j = 0;
          while (j < ((auun)localObject2).jdField_b_of_type_JavaUtilList.size())
          {
            localObject3 = (Layout)((auun)localObject2).jdField_b_of_type_JavaUtilList.get(j);
            ((Layout)localObject3).draw((Canvas)localObject1);
            ((Canvas)localObject1).translate(((Layout)localObject3).getWidth(), 0.0F);
            j += 1;
          }
        }
      }
      localObject1 = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
      if ((this.jdField_a_of_type_Auup != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject1, (Rect)localObject1, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Auup != null)) {
        this.jdField_a_of_type_Auup.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      label1387:
      localObject1 = paramCanvas;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("TagCloudView", 2, "onMeasure, wSpec:" + i + " hSize:" + k);
    }
    paramInt2 = i;
    if (m == 0) {
      paramInt2 = 2147483647;
    }
    i = paramInt2 - (getPaddingLeft() + getPaddingRight());
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
    paramInt2 = a(View.MeasureSpec.makeMeasureSpec(i, m), 0, this.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_Int);
    paramInt1 = paramInt2;
    if (paramInt2 < this.jdField_d_of_type_Int) {
      paramInt1 = this.jdField_d_of_type_Int;
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new auur(this, this.jdField_a_of_type_JavaUtilRandom, (int)(i * 0.7F), (int)(this.jdField_d_of_type_Int * 0.7F)));
    paramInt2 = a(i, paramInt1);
    if (j == 1073741824) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TagCloudView", 2, "onMeasure, setDimension w:" + i + " h:" + paramInt1);
      }
      setMeasuredDimension(getPaddingRight() + i + getPaddingRight(), paramInt1);
      return;
      paramInt1 = paramInt2;
      if (j == -2147483648)
      {
        paramInt1 = paramInt2;
        if (k > 0) {
          paramInt1 = Math.min(k, paramInt2);
        }
      }
    }
  }
  
  public void setMaxEms(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMinHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setOnUpdateDrawingListener(auup paramauup)
  {
    if (paramauup != this.jdField_a_of_type_Auup)
    {
      this.jdField_a_of_type_Auup = paramauup;
      if (paramauup != null) {
        break label46;
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      label46:
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setTagIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
        unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable != null) {
        paramDrawable.setCallback(this);
      }
      invalidate();
    }
  }
  
  public void setTags(List<auun> paramList)
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
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    b();
  }
  
  public void setThreshold(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView
 * JD-Core Version:    0.7.0.1
 */