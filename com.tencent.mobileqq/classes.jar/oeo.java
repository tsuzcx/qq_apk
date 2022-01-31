import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;
import java.util.ArrayList;

public class oeo
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
  private oer jdField_a_of_type_Oer;
  
  public oer a()
  {
    return this.jdField_a_of_type_Oer;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void a(ReadInjoyCutImageView paramReadInjoyCutImageView, ogq paramogq1, ogq paramogq2, int paramInt1, int paramInt2, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Point localPoint1 = new Point();
    Point localPoint2 = new Point();
    Point localPoint3 = new Point();
    Point localPoint4 = new Point();
    float f1 = 0.0F;
    int n = 0;
    int i1 = 0;
    int m;
    int k;
    int j;
    int i;
    if (paramogq1.a == paramogq2.a)
    {
      paramogq1.b = Math.abs(paramogq1.b);
      paramogq2.b = Math.abs(paramogq2.b);
      if (paramogq1.b > paramogq2.b) {
        paramogq1.a(paramogq2);
      }
      localArrayList1.add(new ogq(0.0F, 0.0F));
      localArrayList1.add(paramogq1);
      localArrayList1.add(paramogq2);
      localArrayList1.add(new ogq(0.0F, 1.0F));
      localArrayList1.add(new ogq(0.0F, 0.0F));
      localArrayList2.add(paramogq1);
      localArrayList2.add(new ogq(1.0F, 0.0F));
      localArrayList2.add(new ogq(1.0F, 1.0F));
      localArrayList2.add(paramogq2);
      localArrayList2.add(paramogq1);
      if ((paramInt1 != 5) || (paramInt2 != 5)) {
        break label2165;
      }
      m = 2;
      k = 1;
      j = 1;
      i = i1;
    }
    for (;;)
    {
      switch (m)
      {
      default: 
        label280:
        switch (k)
        {
        }
        break;
      }
      for (;;)
      {
        paramReadInjoyCutImageView.a();
        paramReadInjoyCutImageView.setClipArea(localArrayList1, localArrayList2);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateInterpolator());
        f1 = localPoint2.x - localPoint1.x;
        f2 = localPoint2.y - localPoint1.y;
        f3 = localPoint4.x - localPoint3.x;
        float f4 = localPoint4.y - localPoint3.y;
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new oep(this, f1, f2, f3, f4, paramReadInjoyCutImageView));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new oeq(this, paramReadInjoyCutImageView));
        return;
        if (paramogq1.b == paramogq2.b)
        {
          paramogq1.b = Math.abs(paramogq1.b);
          paramogq2.b = Math.abs(paramogq2.b);
          if (paramogq1.a > paramogq2.a) {
            paramogq1.a(paramogq2);
          }
          localArrayList1.add(new ogq(0.0F, 0.0F));
          localArrayList1.add(new ogq(1.0F, 0.0F));
          localArrayList1.add(paramogq2);
          localArrayList1.add(paramogq1);
          localArrayList1.add(new ogq(0.0F, 0.0F));
          localArrayList2.add(paramogq1);
          localArrayList2.add(paramogq2);
          localArrayList2.add(new ogq(1.0F, 1.0F));
          localArrayList2.add(new ogq(0.0F, 1.0F));
          localArrayList2.add(paramogq1);
          if ((paramInt1 != 5) || (paramInt2 != 5)) {
            break label2147;
          }
          m = 3;
          k = 4;
          i = 1;
          j = n;
          break;
        }
        f2 = (paramogq2.b - paramogq1.b) / (paramogq2.a - paramogq1.a);
        f3 = (paramogq2.b + paramogq1.b - (paramogq2.a + paramogq1.a) * f2) / 2.0F;
        paramogq1.b = Math.abs(paramogq1.b);
        paramogq2.b = Math.abs(paramogq2.b);
        if (f2 > 0.0F)
        {
          if (paramogq1.a < paramogq2.a) {
            paramogq1.a(paramogq2);
          }
          localArrayList1.add(new ogq(0.0F, 0.0F));
          localArrayList2.add(new ogq(paramogq1));
          localogq = new ogq(1.0F, 0.0F);
          if (localogq.b > localogq.a * f2 + f3)
          {
            localArrayList1.add(localogq);
            label795:
            localArrayList1.add(paramogq1);
            localArrayList2.add(new ogq(1.0F, 1.0F));
            localArrayList1.add(paramogq2);
            localogq = new ogq(0.0F, 1.0F);
            if (-localogq.b <= localogq.a * f2 + f3) {
              break label1133;
            }
            localArrayList1.add(localogq);
          }
          for (;;)
          {
            localArrayList2.add(paramogq2);
            localArrayList1.add(new ogq((ogq)localArrayList1.get(0)));
            localArrayList2.add(new ogq((ogq)localArrayList2.get(0)));
            i = i1;
            j = n;
            f1 = f2;
            m = paramInt1;
            k = paramInt2;
            if (paramInt1 != 5) {
              break;
            }
            i = i1;
            j = n;
            f1 = f2;
            m = paramInt1;
            k = paramInt2;
            if (paramInt2 != 5) {
              break;
            }
            f1 = -1.0F / f2;
            f4 = f3 / (f1 - f2);
            localPoint1.x = ((int)(paramReadInjoyCutImageView.getWidth() * f4));
            localPoint1.y = (-(int)((f4 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
            localPoint2.x = 0;
            localPoint2.y = 0;
            f1 = (f3 + f1 + 1.0F) / (f1 - f2);
            localPoint3.x = ((int)(paramReadInjoyCutImageView.getWidth() * f1));
            localPoint3.y = (-(int)((f1 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
            localPoint4.x = paramReadInjoyCutImageView.getWidth();
            localPoint4.y = paramReadInjoyCutImageView.getHeight();
            i = i1;
            j = n;
            f1 = f2;
            m = paramInt1;
            k = paramInt2;
            break;
            localArrayList2.add(localogq);
            break label795;
            label1133:
            localArrayList2.add(localogq);
          }
        }
        if (paramogq1.a > paramogq2.a) {
          paramogq1.a(paramogq2);
        }
        localArrayList2.add(paramogq1);
        ogq localogq = new ogq(0.0F, 0.0F);
        if (localogq.b < localogq.a * f2 + f3)
        {
          localArrayList1.add(localogq);
          label1207:
          localArrayList1.add(paramogq1);
          localArrayList1.add(paramogq2);
          localArrayList2.add(new ogq(1.0F, 0.0F));
          localogq = new ogq(1.0F, 1.0F);
          if (-localogq.b >= localogq.a * f2 + f3) {
            break label1560;
          }
          localArrayList1.add(localogq);
        }
        for (;;)
        {
          localArrayList1.add(new ogq(0.0F, 1.0F));
          localArrayList2.add(paramogq2);
          localArrayList1.add(new ogq((ogq)localArrayList1.get(0)));
          localArrayList2.add(new ogq((ogq)localArrayList2.get(0)));
          i = i1;
          j = n;
          f1 = f2;
          m = paramInt1;
          k = paramInt2;
          if (paramInt1 != 5) {
            break;
          }
          i = i1;
          j = n;
          f1 = f2;
          m = paramInt1;
          k = paramInt2;
          if (paramInt2 != 5) {
            break;
          }
          f1 = -1.0F / f2;
          f4 = (1.0F + f3) / (f1 - f2);
          localPoint1.x = ((int)(paramReadInjoyCutImageView.getWidth() * f4));
          localPoint1.y = (-(int)((f4 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
          localPoint2.x = 0;
          localPoint2.y = paramReadInjoyCutImageView.getHeight();
          f1 = (f3 + f1) / (f1 - f2);
          localPoint3.x = ((int)(paramReadInjoyCutImageView.getWidth() * f1));
          localPoint3.y = (-(int)((f1 * f2 + f3) * paramReadInjoyCutImageView.getHeight()));
          localPoint4.x = paramReadInjoyCutImageView.getWidth();
          localPoint4.y = 0;
          i = i1;
          j = n;
          f1 = f2;
          m = paramInt1;
          k = paramInt2;
          break;
          localArrayList2.add(localogq);
          break label1207;
          label1560:
          localArrayList2.add(localogq);
        }
        localPoint1.x = ((int)(Math.max(paramogq1.a, paramogq2.a) * paramReadInjoyCutImageView.getWidth()));
        localPoint1.y = 0;
        localPoint2.x = 0;
        localPoint2.y = 0;
        break label280;
        f2 = Math.max(paramogq1.a, paramogq2.a);
        localPoint1.x = 0;
        localPoint1.y = 0;
        localPoint2.x = ((int)(f2 * paramReadInjoyCutImageView.getWidth()));
        localPoint2.y = 0;
        break label280;
        f2 = Math.min(paramogq1.b, paramogq2.b);
        f3 = Math.max(paramogq1.b, paramogq2.b);
        if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
        for (paramInt1 = 0;; paramInt1 = (int)(f2 * paramReadInjoyCutImageView.getHeight()))
        {
          localPoint1.y = paramInt1;
          localPoint1.x = 0;
          localPoint2.y = ((int)(paramReadInjoyCutImageView.getHeight() * f3));
          localPoint2.x = 0;
          break;
        }
        f2 = Math.min(paramogq1.b, paramogq2.b);
        localPoint1.y = ((int)(Math.max(paramogq1.b, paramogq2.b) * paramReadInjoyCutImageView.getHeight()));
        localPoint1.x = 0;
        if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
        for (paramInt1 = 0;; paramInt1 = (int)(f2 * paramReadInjoyCutImageView.getHeight()))
        {
          localPoint2.y = paramInt1;
          localPoint2.x = 0;
          break;
        }
        f1 = Math.min(paramogq1.a, paramogq2.a);
        localPoint3.x = paramReadInjoyCutImageView.getWidth();
        localPoint3.y = 0;
        localPoint4.x = ((int)(f1 * paramReadInjoyCutImageView.getWidth()));
        localPoint4.y = 0;
        continue;
        localPoint3.x = ((int)(Math.min(paramogq1.a, paramogq2.a) * paramReadInjoyCutImageView.getWidth()));
        localPoint3.y = 0;
        localPoint4.x = paramReadInjoyCutImageView.getWidth();
        localPoint4.y = 0;
      }
      float f2 = Math.min(paramogq1.b, paramogq2.b);
      float f3 = Math.max(paramogq1.b, paramogq2.b);
      localPoint3.y = ((int)(f2 * paramReadInjoyCutImageView.getHeight()));
      localPoint3.x = 0;
      if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
      for (paramInt1 = paramReadInjoyCutImageView.getHeight();; paramInt1 = (int)(paramReadInjoyCutImageView.getHeight() * f3))
      {
        localPoint4.y = paramInt1;
        localPoint4.x = 0;
        break;
      }
      f2 = Math.min(paramogq1.b, paramogq2.b);
      f3 = Math.max(paramogq1.b, paramogq2.b);
      if ((i != 0) || (j != 0) || (f1 > 0.0F)) {}
      for (paramInt1 = paramReadInjoyCutImageView.getHeight();; paramInt1 = (int)(f3 * paramReadInjoyCutImageView.getHeight()))
      {
        localPoint3.y = paramInt1;
        localPoint3.x = 0;
        localPoint4.y = ((int)(paramReadInjoyCutImageView.getHeight() * f2));
        localPoint4.x = 0;
        break;
      }
      label2147:
      i = 1;
      j = n;
      m = paramInt1;
      k = paramInt2;
      continue;
      label2165:
      j = 1;
      i = i1;
      m = paramInt1;
      k = paramInt2;
    }
  }
  
  public void a(oer paramoer)
  {
    this.jdField_a_of_type_Oer = paramoer;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isStarted())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oeo
 * JD-Core Version:    0.7.0.1
 */