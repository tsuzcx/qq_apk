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
  public static final int e = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
  int a;
  Random b = new Random();
  List<Tag> c = new ArrayList();
  List<TagCloudView.FillTag> d = new ArrayList();
  int f = e;
  int g = 0;
  int h = 42;
  Drawable i;
  int j = -16777216;
  ColorStateList k;
  float l;
  TagCloudView.OnUpdateDrawingListener m;
  Paint n = new Paint(7);
  private Matrix o = new Matrix();
  private Matrix p;
  private boolean q = false;
  private Bitmap r;
  
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
    Object localObject3 = new ArrayList(this.c.size());
    Object localObject2 = b(null, paramInt1, paramInt2);
    Object localObject4 = new ArrayList(this.c.size());
    ((List)localObject4).addAll(this.c);
    int i3 = 0;
    int i2 = 0;
    while (i2 < ((List)localObject4).size())
    {
      Tag localTag = (Tag)((List)localObject4).get(i2);
      if ((!localTag.n) && (localTag.h.x * localTag.h.y != 0))
      {
        i1 = paramInt2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("layoutChildren index:");
          ((StringBuilder)localObject1).append(i2);
          ((StringBuilder)localObject1).append(" tagW:");
          ((StringBuilder)localObject1).append(localTag.h.x);
          ((StringBuilder)localObject1).append(" tagH:");
          ((StringBuilder)localObject1).append(localTag.h.y);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(localTag.c);
          QLog.i("TagCloudView", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
          i1 = paramInt2;
        }
        for (;;)
        {
          Object localObject5 = a(localTag, (List)localObject1, (List)localObject3, paramInt1, i1);
          if ((localObject5 != null) && (((List)localObject5).size() > 0))
          {
            paramInt2 = i1;
            localObject2 = localObject1;
            if (localObject5 == null) {
              break;
            }
            paramInt2 = i1;
            localObject2 = localObject1;
            if (((List)localObject5).size() <= 0) {
              break;
            }
            localObject5 = a((List)localObject5, paramInt1, i1);
            localTag.g.x = ((Rect)localObject5).left;
            localTag.g.y = ((Rect)localObject5).top;
            ((List)localObject3).add(localObject5);
            a((List)localObject1, localTag, paramInt1, i1);
            paramInt2 = i1;
            localObject2 = localObject1;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("layoutChildren findTheFarest:");
            ((StringBuilder)localObject2).append(localObject5);
            QLog.i("TagCloudView", 4, ((StringBuilder)localObject2).toString());
            paramInt2 = i1;
            localObject2 = localObject1;
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "layoutChildren enlarge");
          }
          i1 = a((List)localObject3, paramInt1, i1, (int)(localTag.h.y * 0.3F));
          paramInt2 = 0;
          while (paramInt2 < ((List)localObject3).size())
          {
            ((Tag)((List)localObject4).get(paramInt2)).g.x = ((Rect)((List)localObject3).get(paramInt2)).left;
            ((Tag)((List)localObject4).get(paramInt2)).g.y = ((Rect)((List)localObject3).get(paramInt2)).top;
            paramInt2 += 1;
          }
          localObject1 = b((List)localObject4, paramInt1, i1);
        }
      }
      ((List)localObject3).add(new Rect());
      i2 += 1;
    }
    Object localObject1 = new Point((int)(paramInt1 * 0.5F), (int)(paramInt2 * 0.5F));
    Collections.sort(this.c, new TagCloudView.TagCenterDisComp(this, (Point)localObject1));
    Collections.sort((List)localObject3, new TagCloudView.RectCenterDisComp(this, (Point)localObject1));
    int i1 = this.c.size();
    if (this.c.size() >= 6) {
      i1 = 2;
    } else if (this.c.size() >= 4) {
      i1 = 3;
    }
    a((List)localObject3, (Point)localObject1, i1);
    localObject1 = a(b((List)localObject4, paramInt1, paramInt2), (List)localObject3, paramInt1, paramInt2, this.h);
    paramInt1 = i3;
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
        ((StringBuilder)localObject4).append(this.c.toString());
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
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramList.size())
    {
      Tag localTag = (Tag)paramList.get(paramInt2);
      for (int i3 = localTag.b(paramInt1); (i3 > paramInt3 * 1.0F) && (!localTag.n); i3 = localTag.b(paramInt1))
      {
        localTag.a();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("measureChildren too high ");
          localStringBuilder.append(localTag.c);
          QLog.i("TagCloudView", 2, localStringBuilder.toString());
        }
        localTag.i *= 0.75F;
        localTag.m.setTextSize(localTag.i);
      }
      i2 = i1;
      if (!localTag.n) {
        i2 = Math.max(i1, i3);
      }
      paramInt2 += 1;
      i1 = i2;
    }
    return i1;
  }
  
  private int a(List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = (int)(paramInt2 * 0.5F);
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      Rect localRect = (Rect)paramList.get(paramInt1);
      if ((localRect.top != 0) && ((localRect.centerY() >= i1) || (localRect.bottom == paramInt2)))
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
    int i2 = paramArrayOfInt[0];
    int i1 = 0;
    int i3 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      int i4 = 1;
      if (paramBoolean ? paramArrayOfInt[i1] >= i2 : paramArrayOfInt[i1] <= i2) {
        i4 = 0;
      }
      if (i4 != 0)
      {
        i2 = paramArrayOfInt[i1];
        i3 = i1;
      }
      i1 += 1;
    }
    return i3;
  }
  
  private static Rect a(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y, paramPoint.x + paramInt3, paramPoint.y + paramInt3);
    if ((localRect.bottom <= paramInt2) && (localRect.right <= paramInt1) && (localRect.left >= 0) && (localRect.top >= 0))
    {
      if (a(paramList, localRect, null)) {
        return null;
      }
      int i1 = paramInt1 - paramPoint.x;
      localRect.right = (localRect.left + i1);
      if (!(a(paramList, localRect, null) ^ true))
      {
        paramInt1 = paramInt3;
        while (Math.abs(paramInt1 - i1) > 2)
        {
          int i2 = (int)((i1 + paramInt1) * 0.5F);
          localRect.right = (localRect.left + i2);
          if ((a(paramList, localRect, null) ^ true)) {
            paramInt1 = i2;
          } else {
            i1 = i2;
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
    int i1 = 0;
    Object localObject = (Rect)paramList.get(0);
    float f2 = -1.0F;
    while (i1 < paramList.size())
    {
      Rect localRect = (Rect)paramList.get(i1);
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
      i1 += 1;
    }
    return localObject;
  }
  
  private static List<Rect> a(Tag paramTag, List<Point> paramList, List<Rect> paramList1, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = 0;
    while (i1 < paramList.size())
    {
      int i2 = ((Point)paramList.get(i1)).x;
      int i3 = ((Point)paramList.get(i1)).y;
      Rect localRect = new Rect(i2, i3, paramTag.h.x + i2, paramTag.h.y + i3);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(i2 - paramTag.h.x, i3 - paramTag.h.y, i2, i3);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(i2, i3 - paramTag.h.y, paramTag.h.x + i2, i3);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(i2 - paramTag.h.x, i3, i2, paramTag.h.y + i3);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      i1 += 1;
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
    int i1 = paramList.size() - 1;
    Object localObject1;
    while (i1 >= 0)
    {
      localObject1 = (Point)paramList.get(i1);
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
      paramList.remove(i1);
      i1 -= 1;
    }
    i1 = localArrayList2.size() - 1;
    while (i1 >= 0)
    {
      paramList = (Point)localArrayList2.get(i1);
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
      localArrayList2.remove(i1);
      i1 -= 1;
    }
    return localArrayList1;
  }
  
  private void a()
  {
    this.l = getResources().getDisplayMetrics().density;
    Tag.a((int)(this.l * 4.0F));
    this.i = new ColorDrawable(-16777216);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    int i2 = this.i.getIntrinsicWidth();
    int i3 = this.i.getIntrinsicHeight();
    int i1;
    if (((i2 >= 0) && (paramInt != i2)) || ((i3 >= 0) && (paramInt != i3))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    paramCanvas.save();
    paramCanvas.clipRect(0, 0, paramInt, paramInt);
    if (i1 != 0)
    {
      this.p = null;
      this.i.setBounds(0, 0, paramInt, paramInt);
    }
    else
    {
      this.i.setBounds(0, 0, i2, i3);
      this.p = new Matrix(this.o);
      float f2 = 0.0F;
      float f3;
      float f1;
      if (i2 * paramInt > paramInt * i3)
      {
        f3 = paramInt;
        f1 = f3 / i3;
        f3 = (f3 - i2 * f1) * 0.5F;
      }
      else
      {
        f2 = paramInt;
        f1 = f2 / i2;
        f2 = (f2 - i3 * f1) * 0.5F;
        f3 = 0.0F;
      }
      this.p.setScale(f1, f1);
      this.p.postTranslate(Math.round(f3), Math.round(f2));
    }
    if (this.p == null)
    {
      this.i.draw(paramCanvas);
    }
    else
    {
      paramCanvas.save();
      paramCanvas.concat(this.p);
      this.i.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  private void a(Rect paramRect)
  {
    float f1 = this.h * 0.5F;
    if ((paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.height() >= f1) && (paramRect.width() >= f1) && ((paramRect.width() >= this.h) || (paramRect.height() >= this.h)))
    {
      int i1 = paramRect.height();
      int i2 = paramRect.width();
      int i3 = this.h;
      if (i1 * i2 < i3 * i3) {
        return;
      }
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fillWithTags rect:");
        ((StringBuilder)localObject).append(paramRect);
        QLog.i("TagCloudView", 4, ((StringBuilder)localObject).toString());
      }
      i2 = paramRect.width();
      i3 = this.h;
      i1 = 0;
      boolean bool;
      if (((i2 >= i3 * 4) || (paramRect.height() >= this.h * 4)) && (paramRect.width() > this.h) && (paramRect.height() > this.h)) {
        bool = false;
      } else {
        bool = true;
      }
      i2 = b(paramRect);
      if (i2 < 0) {
        return;
      }
      Object localObject = (Tag)this.c.get(i2);
      float f2 = ((Tag)localObject).d();
      f1 = 0.8F;
      int i4 = (int)(f2 * 0.8F);
      i3 = (int)(((Tag)localObject).e() * 0.8F);
      if (i4 * i3 <= 0) {
        return;
      }
      if ((i4 <= paramRect.width()) && (i3 <= paramRect.height()))
      {
        if (!bool) {
          f1 = this.b.nextFloat() * 0.45F + 0.5F;
        }
        i1 = (int)(((Tag)localObject).d() * f1);
        i3 = (int)(((Tag)localObject).e() * f1);
        this.d.add(new TagCloudView.FillTag(i2, f1, paramRect.left, paramRect.top));
        localObject = new Rect(paramRect.left + i1, paramRect.top, paramRect.right, paramRect.top + i3);
        paramRect = new Rect(paramRect.left, paramRect.top + i3, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
        a(paramRect);
        return;
      }
      f1 = paramRect.width() / ((Tag)localObject).d();
      f2 = paramRect.height() / ((Tag)localObject).e();
      if (f1 < f2) {
        i1 = 1;
      }
      if (i1 == 0) {
        f1 = f2;
      }
      i4 = (int)(((Tag)localObject).d() * f1 + 0.5F);
      int i5 = (int)(((Tag)localObject).e() * f1 + 0.5F);
      i3 = Math.max(paramRect.width() / i4, paramRect.height() / i3);
      if (i3 > 30)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fillWithTags WARNING!!! ");
        localStringBuilder.append(i3);
        localStringBuilder.append(" w:");
        localStringBuilder.append(paramRect.width());
        localStringBuilder.append(" h:");
        localStringBuilder.append(paramRect.height());
        localStringBuilder.append(" tagW:");
        localStringBuilder.append(((Tag)localObject).d());
        localStringBuilder.append(" tagH:");
        localStringBuilder.append(((Tag)localObject).d());
        localStringBuilder.append(" small:");
        localStringBuilder.append(bool);
        QLog.i("TagCloudView", 1, localStringBuilder.toString());
        if (bool) {
          return;
        }
      }
      localObject = new Rect();
      if (i1 != 0)
      {
        ((Rect)localObject).set(paramRect.left, paramRect.top + i5, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
      }
      else
      {
        ((Rect)localObject).set(paramRect.left + i4, paramRect.top, paramRect.right, paramRect.bottom);
        a((Rect)localObject);
      }
      this.d.add(new TagCloudView.FillTag(i2, f1, paramRect.left, paramRect.top));
    }
  }
  
  public static void a(List<Tag> paramList)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      ((Tag)paramList.get(i1)).a();
      i1 += 1;
    }
  }
  
  private void a(List<Rect> paramList, Point paramPoint, int paramInt)
  {
    int i3 = 0;
    int i2;
    for (int i4 = 0; (i3 < this.c.size()) && (i4 < paramInt); i4 = i2)
    {
      Tag localTag = (Tag)this.c.get(i3);
      if (localTag.n)
      {
        i2 = i4;
      }
      else
      {
        int i5 = (int)(paramPoint.x - (localTag.g.x + localTag.h.x * 0.5F));
        int i6 = (int)(paramPoint.y - (localTag.g.y + localTag.h.y * 0.5F));
        Rect localRect1 = (Rect)paramList.get(i3);
        Rect localRect2 = new Rect(localRect1);
        localRect2.offset(i5, 0);
        if (a(paramList, localRect2, localRect1))
        {
          i1 = 0;
          for (;;)
          {
            i2 = i1;
            if (Math.abs(i5 - i1) <= 1) {
              break;
            }
            i2 = (int)((i5 + i1) * 0.5F);
            localRect2.set(localRect1);
            localRect2.offset(i2, 0);
            if (!a(paramList, localRect2, localRect1)) {
              i1 = i2;
            } else {
              i5 = i2;
            }
          }
        }
        i2 = i5;
        i5 = i2;
        if (Math.abs(i2) < Math.abs(this.h)) {
          i5 = 0;
        }
        localRect2 = new Rect(localRect1);
        localRect2.offset(i5, i6);
        if (a(paramList, localRect2, localRect1))
        {
          i1 = 0;
          for (;;)
          {
            i2 = i1;
            if (Math.abs(i6 - i1) <= 1) {
              break;
            }
            i2 = (int)((i6 + i1) * 0.5F);
            localRect2.set(localRect1);
            localRect2.offset(i5, i2);
            if (!a(paramList, localRect2, localRect1)) {
              i1 = i2;
            } else {
              i6 = i2;
            }
          }
        }
        i2 = i6;
        int i1 = i2;
        if (Math.abs(i2) < Math.abs(this.h)) {
          i1 = 0;
        }
        if (i5 <= 0)
        {
          i2 = i4;
          if (i1 <= 0) {}
        }
        else
        {
          i2 = i4 + 1;
          localRect1.offset(i5, i1);
          localTag.g.x = localRect1.left;
          localTag.g.y = localRect1.top;
        }
      }
      i3 += 1;
    }
  }
  
  private static void a(List<Point> paramList, Tag paramTag, int paramInt1, int paramInt2)
  {
    if (!paramTag.b()) {
      return;
    }
    Point localPoint1 = new Point(paramTag.g.x, paramTag.g.y);
    Point localPoint2 = new Point(paramTag.g.x + paramTag.h.x, paramTag.g.y);
    Point localPoint3 = new Point(paramTag.g.x, paramTag.g.y + paramTag.h.y);
    paramTag = new Point(paramTag.g.x + paramTag.h.x, paramTag.g.y + paramTag.h.y);
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
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if (paramPoint.equals(paramList.get(i1))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static boolean a(List<Rect> paramList, Rect paramRect1, Rect paramRect2)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if ((!((Rect)paramList.get(i1)).equals(paramRect2)) && (Rect.intersects((Rect)paramList.get(i1), paramRect1))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static int b(Point paramPoint1, Point paramPoint2)
  {
    return (int)(Math.pow(Math.abs(paramPoint1.x - paramPoint2.x), 2.0D) + Math.pow(Math.abs(paramPoint1.y - paramPoint2.y), 2.0D));
  }
  
  private int b(Rect paramRect)
  {
    int i7 = 3;
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
    int i1 = 0;
    int i3 = -1;
    int i4;
    for (int i2 = 0; i1 < this.c.size(); i2 = i4)
    {
      Tag localTag = (Tag)this.c.get(i1);
      i4 = (int)(localTag.d() * 0.8F);
      int i5 = (int)(localTag.e() * 0.8F);
      if (i4 * i5 <= 0)
      {
        i5 = i3;
        i4 = i2;
      }
      else
      {
        int i6;
        if ((i4 <= paramRect.width()) && (i5 <= paramRect.height()))
        {
          i6 = (int)(localTag.i * 0.8F);
        }
        else
        {
          float f1 = paramRect.width() / localTag.d();
          float f2 = paramRect.height() / localTag.e();
          if (f1 >= f2) {
            f1 = f2;
          }
          i6 = (int)(f1 * localTag.i);
        }
        i5 = i3;
        i4 = i2;
        if (i6 > i3)
        {
          arrayOfInt2[i2] = i6;
          arrayOfInt1[i2] = i1;
          i4 = a(arrayOfInt2, true);
          i5 = arrayOfInt2[i4];
        }
      }
      i1 += 1;
      i3 = i5;
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
      i1 = i7;
    } else if (arrayOfInt1[1] >= 0) {
      i1 = 2;
    } else if (arrayOfInt1[0] >= 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      return -1;
    }
    i2 = 0;
    for (i3 = 0; i2 < i1; i3 = i4)
    {
      i4 = i3;
      if (arrayOfInt2[i2] >= this.l * 12.0F)
      {
        paramRect[i3] = arrayOfInt1[i2];
        i4 = i3 + 1;
      }
      i2 += 1;
    }
    if (i3 > 0) {
      return paramRect[this.b.nextInt(i3)];
    }
    return arrayOfInt1[a(arrayOfInt2, false)];
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
          int i1 = (int)((paramInt2 + paramInt1) * 0.5F);
          localRect.right = (localRect.left + i1);
          if ((a(paramList, localRect, null) ^ true)) {
            paramInt1 = i1;
          } else {
            paramInt2 = i1;
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
  
  private static List<Point> b(List<Tag> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    localArrayList.add(new Point(0, 0));
    localArrayList.add(new Point(paramInt1, 0));
    localArrayList.add(new Point(0, paramInt2));
    localArrayList.add(new Point(paramInt1, paramInt2));
    paramInt1 = i1;
    if (paramList == null) {
      return localArrayList;
    }
    while (paramInt1 < paramList.size())
    {
      Object localObject = (Tag)paramList.get(paramInt1);
      if ((((Tag)localObject).b()) || (!((Tag)localObject).n))
      {
        Point localPoint1 = new Point(((Tag)localObject).g.x, ((Tag)localObject).g.y);
        Point localPoint2 = new Point(((Tag)localObject).g.x + ((Tag)localObject).h.x, ((Tag)localObject).g.y);
        Point localPoint3 = new Point(((Tag)localObject).g.x, ((Tag)localObject).g.y + ((Tag)localObject).h.y);
        localObject = new Point(((Tag)localObject).g.x + ((Tag)localObject).h.x, ((Tag)localObject).g.y + ((Tag)localObject).h.y);
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
  
  private void b()
  {
    int i1 = this.k.getColorForState(getDrawableState(), 0);
    if (i1 != this.j) {
      this.j = i1;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ColorStateList localColorStateList = this.k;
    if ((localColorStateList != null) && (localColorStateList.isStateful())) {
      b();
    }
  }
  
  public int getColor()
  {
    return this.j;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.i)
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
    if (this.m != null)
    {
      Object localObject1 = this.r;
      if ((localObject1 != null) && ((!this.q) || ((((Bitmap)localObject1).getWidth() == getMeasuredWidth()) && (this.r.getHeight() == getMeasuredHeight()))))
      {
        localObject1 = new Canvas(this.r);
        ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
        break label183;
      }
      localObject1 = this.r;
      if (localObject1 != null)
      {
        ((Bitmap)localObject1).recycle();
        this.r = null;
      }
      try
      {
        this.r = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, localOutOfMemoryError.getMessage());
        }
      }
      localObject2 = this.r;
      if (localObject2 != null)
      {
        localObject2 = new Canvas((Bitmap)localObject2);
        break label183;
      }
    }
    Object localObject2 = paramCanvas;
    label183:
    Object localObject3 = new Point(0, 0);
    int i4 = getPaddingLeft();
    Object localObject4 = new ArrayList();
    ((List)localObject4).addAll(this.c);
    int i1 = 0;
    Object localObject5;
    int i2;
    while (i1 < ((List)localObject4).size())
    {
      localObject5 = (Tag)((List)localObject4).get(i1);
      if ((!((Tag)localObject5).n) && (((Tag)localObject5).b()))
      {
        Object localObject6 = ((Tag)localObject5).m;
        Point localPoint1 = ((Tag)localObject5).g;
        Point localPoint2 = ((Tag)localObject5).h;
        if (((Tag)localObject5).k != 0)
        {
          ((Canvas)localObject2).save();
          ((Canvas)localObject2).clipRect(localPoint1.x + i4, localPoint1.y, localPoint1.x + localPoint2.x + i4, localPoint1.y + localPoint2.y);
          ((Canvas)localObject2).translate(localPoint1.x + i4, localPoint1.y);
          ((Canvas)localObject2).scale(((Tag)localObject5).q, ((Tag)localObject5).q);
          ((Canvas)localObject2).drawColor(((Tag)localObject5).k);
          ((Canvas)localObject2).restore();
        }
        ((Point)localObject3).set(0, 0);
        int i5 = Tag.u;
        i2 = ((Tag)localObject5).s;
        int i3 = 1;
        if (i2 == 2)
        {
          ((Canvas)localObject2).save();
          if (((Tag)localObject5).b)
          {
            boolean bool = ((Tag)localObject5).a;
            i2 = localPoint2.y - i5 * 2;
            if (bool)
            {
              ((Point)localObject3).set(i2 + i5 + i5, i5);
              ((Canvas)localObject2).translate(localPoint1.x + i5 + i4, localPoint1.y + i5);
            }
            else
            {
              ((Point)localObject3).set(i5, i5);
              ((Canvas)localObject2).translate(localPoint1.x + localPoint2.x - i2 - i5 + i4, localPoint1.y + i5);
            }
          }
          else
          {
            i2 = localPoint2.x - i5 * 2;
            if (((Tag)localObject5).a)
            {
              ((Point)localObject3).set(i5, i2 + i5 + i5);
              ((Canvas)localObject2).translate(localPoint1.x + i5 + i4, localPoint1.y + i5);
            }
            else
            {
              ((Point)localObject3).set(i5, i5);
              ((Canvas)localObject2).translate(localPoint1.x + i5 + i4, localPoint1.y + localPoint2.y - i2 - i5);
            }
          }
          if (this.i != null) {
            a((Canvas)localObject2, i2);
          }
          ((Canvas)localObject2).restore();
        }
        else if (((Tag)localObject5).s == 1)
        {
          ((Point)localObject3).set(i5, i5);
        }
        i5 = ((Tag)localObject5).s;
        i2 = 255;
        if ((i5 != 0) && (!((Tag)localObject5).n))
        {
          ((TextPaint)localObject6).setColor(-1);
          ((TextPaint)localObject6).setAlpha(255);
          i2 = i3;
        }
        else
        {
          ((TextPaint)localObject6).setColor(this.j);
          if (((Tag)localObject5).n) {
            i2 = 64;
          }
          ((TextPaint)localObject6).setAlpha(i2);
          i2 = 0;
        }
        ((TextPaint)localObject6).setFakeBoldText(((Tag)localObject5).o);
        ((Canvas)localObject2).save();
        ((Canvas)localObject2).translate(((Point)localObject3).x + localPoint1.x + i4, ((Point)localObject3).y + localPoint1.y - (((Tag)localObject5).q * ((Tag)localObject5).r + 0.5F));
        if (((Tag)localObject5).b)
        {
          ((Canvas)localObject2).scale(((Tag)localObject5).q, ((Tag)localObject5).q);
          ((Tag)localObject5).d.draw((Canvas)localObject2);
        }
        else
        {
          ((Canvas)localObject2).scale(((Tag)localObject5).q, ((Tag)localObject5).q);
          i3 = 0;
          while (i3 < ((Tag)localObject5).f.size())
          {
            localObject6 = (Layout)((Tag)localObject5).f.get(i3);
            ((Layout)localObject6).draw((Canvas)localObject2);
            ((Canvas)localObject2).translate(((Layout)localObject6).getWidth(), 0.0F);
            i3 += 1;
          }
        }
        ((Canvas)localObject2).restore();
        if ((i2 != 0) && (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())))
        {
          ((Canvas)localObject2).save();
          ((Canvas)localObject2).clipRect(localPoint1.x + i4, localPoint1.y, localPoint1.x + localPoint2.x + i4, localPoint1.y + localPoint2.y);
          ((Canvas)localObject2).translate(localPoint1.x + i4, localPoint1.y);
          ((Canvas)localObject2).scale(((Tag)localObject5).q, ((Tag)localObject5).q);
          ((Canvas)localObject2).drawColor(Color.argb(127, 0, 0, 0));
          ((Canvas)localObject2).restore();
        }
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.d.size())
    {
      localObject4 = (TagCloudView.FillTag)this.d.get(i1);
      localObject3 = (Tag)this.c.get(((TagCloudView.FillTag)localObject4).a);
      localObject5 = ((Tag)localObject3).m;
      ((TextPaint)localObject5).setColor(this.j);
      ((TextPaint)localObject5).setAlpha(64);
      ((TextPaint)localObject5).setFakeBoldText(false);
      localObject5 = new Point(((TagCloudView.FillTag)localObject4).c, ((TagCloudView.FillTag)localObject4).d);
      ((Canvas)localObject2).save();
      ((Canvas)localObject2).translate(((Point)localObject5).x + i4, ((Point)localObject5).y - ((Tag)localObject3).r * ((TagCloudView.FillTag)localObject4).b);
      ((Canvas)localObject2).scale(((TagCloudView.FillTag)localObject4).b, ((TagCloudView.FillTag)localObject4).b);
      if (((Tag)localObject3).b) {
        ((Tag)localObject3).d.draw((Canvas)localObject2);
      }
      for (;;)
      {
        break;
        i2 = 0;
        while (i2 < ((Tag)localObject3).f.size())
        {
          localObject4 = (Layout)((Tag)localObject3).f.get(i2);
          ((Layout)localObject4).draw((Canvas)localObject2);
          ((Canvas)localObject2).translate(((Layout)localObject4).getWidth(), 0.0F);
          i2 += 1;
        }
      }
      ((Canvas)localObject2).restore();
      i1 += 1;
    }
    localObject2 = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
    if (this.m != null)
    {
      localObject3 = this.r;
      if (localObject3 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject3, (Rect)localObject2, (Rect)localObject2, this.n);
      }
    }
    if (this.q)
    {
      paramCanvas = this.m;
      if (paramCanvas != null) {
        paramCanvas.a(this.r);
      }
    }
    this.q = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i5 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure, wSpec:");
      localStringBuilder.append(i1);
      localStringBuilder.append(" hSize:");
      localStringBuilder.append(i3);
      QLog.i("TagCloudView", 2, localStringBuilder.toString());
    }
    paramInt2 = i1;
    if (i5 == 0) {
      paramInt2 = 2147483647;
    }
    int i4 = paramInt2 - (getPaddingLeft() + getPaddingRight());
    if (this.f == paramInt1)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TagCloudView", 2, "onMeasure, use cache return.");
      }
      return;
    }
    this.f = paramInt1;
    this.q = true;
    a(this.c);
    this.d.clear();
    paramInt2 = a(View.MeasureSpec.makeMeasureSpec(i4, i5), 0, this.c, this.g);
    i1 = this.g;
    paramInt1 = paramInt2;
    if (paramInt2 < i1) {
      paramInt1 = i1;
    }
    Collections.sort(this.c, new TagCloudView.RectRandomDescComp(this, this.b, (int)(i4 * 0.7F), (int)(this.g * 0.7F)));
    paramInt2 = a(i4, paramInt1);
    if (i2 == 1073741824)
    {
      paramInt1 = paramInt2;
    }
    else
    {
      paramInt1 = paramInt2;
      if (i2 == -2147483648)
      {
        paramInt1 = paramInt2;
        if (i3 > 0) {
          paramInt1 = Math.min(i3, paramInt2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure, setDimension w:");
      localStringBuilder.append(i4);
      localStringBuilder.append(" h:");
      localStringBuilder.append(paramInt1);
      QLog.i("TagCloudView", 2, localStringBuilder.toString());
    }
    setMeasuredDimension(i4 + getPaddingRight() + getPaddingRight(), paramInt1);
  }
  
  public void setMaxEms(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setMinHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setOnUpdateDrawingListener(TagCloudView.OnUpdateDrawingListener paramOnUpdateDrawingListener)
  {
    if (paramOnUpdateDrawingListener != this.m)
    {
      this.m = paramOnUpdateDrawingListener;
      if (paramOnUpdateDrawingListener == null)
      {
        this.q = false;
        paramOnUpdateDrawingListener = this.r;
        if (paramOnUpdateDrawingListener != null)
        {
          paramOnUpdateDrawingListener.recycle();
          this.r = null;
        }
      }
      else
      {
        this.q = true;
      }
      invalidate();
    }
  }
  
  public void setTagIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = this.i;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.i);
      }
      this.i = paramDrawable;
      if (paramDrawable != null) {
        paramDrawable.setCallback(this);
      }
      invalidate();
    }
  }
  
  public void setTags(List<Tag> paramList)
  {
    this.f = e;
    this.c.clear();
    this.d.clear();
    this.c.addAll(paramList);
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.k = ColorStateList.valueOf(paramInt);
    b();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.k = paramColorStateList;
      b();
      return;
    }
    throw new NullPointerException();
  }
  
  public void setThreshold(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Tag localTag = (Tag)((Iterator)localObject).next();
        if ((localTag != null) && (localTag.m != null)) {
          localTag.m.setTypeface(paramTypeface);
        }
      }
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView
 * JD-Core Version:    0.7.0.1
 */