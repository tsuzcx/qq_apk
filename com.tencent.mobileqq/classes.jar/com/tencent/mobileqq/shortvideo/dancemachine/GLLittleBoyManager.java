package com.tencent.mobileqq.shortvideo.dancemachine;

import ahmh;
import ahmi;
import ahmj;
import ahmk;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class GLLittleBoyManager
  implements Animation.AnimationListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private GLViewContext jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator jdField_a_of_type_JavaUtilComparator = new ahmk(this);
  private TreeSet jdField_a_of_type_JavaUtilTreeSet;
  private boolean jdField_a_of_type_Boolean;
  private RectF[] jdField_a_of_type_ArrayOfAndroidGraphicsRectF = new RectF[2];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 0;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 65;
  private float e = 0.0F;
  
  public GLLittleBoyManager(GLViewContext paramGLViewContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext = paramGLViewContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(this.jdField_a_of_type_JavaUtilComparator);
  }
  
  private Animation a(GLLittleBoy paramGLLittleBoy, double paramDouble)
  {
    paramGLLittleBoy = paramGLLittleBoy.a();
    int i = (int)(1.0D / paramDouble * 1000.0D);
    float f = paramGLLittleBoy.height() / 2.0F;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a();
    paramGLLittleBoy = new TranslateAnimation(paramGLLittleBoy.left, paramGLLittleBoy.left, paramGLLittleBoy.top, 0.0F);
    paramGLLittleBoy.setDuration(i);
    paramGLLittleBoy.setFillEnabled(true);
    paramGLLittleBoy.setFillAfter(true);
    paramGLLittleBoy.setInterpolator(new LinearInterpolator());
    paramGLLittleBoy.setAnimationListener(new ahmh(this));
    return paramGLLittleBoy;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b();
    int k = ((Rect)localObject).width();
    int m = ((Rect)localObject).height();
    localObject = ResourceManager.a();
    int j = paramInt2;
    int i = paramInt3;
    if (((ResourceManager)localObject).jdField_a_of_type_Boolean)
    {
      j = (int)(paramInt2 / ((ResourceManager)localObject).jdField_a_of_type_Float);
      i = (int)(paramInt3 / ((ResourceManager)localObject).jdField_a_of_type_Float);
    }
    paramInt2 = (int)(j * 0.82F);
    paramInt3 = (int)(i * 0.82F);
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsRectF[0].set(DisplayUtils.a(65.0F), m, DisplayUtils.a(paramInt2 + 65), m + DisplayUtils.a(paramInt3));
      return;
    }
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRectF[1] = new RectF(k - DisplayUtils.a(paramInt2 + 65), m, k - DisplayUtils.a(65.0F), m + DisplayUtils.a(paramInt3));
  }
  
  private void a(Animation paramAnimation)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localGLLittleBoy.a() == paramAnimation) {
          a(localGLLittleBoy);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(GLLittleBoy paramGLLittleBoy)
  {
    if (paramGLLittleBoy.e) {
      throw new RuntimeException("状态错误,消失动画的对象是有效对象");
    }
    paramGLLittleBoy.h_(false);
    paramGLLittleBoy.e();
    paramGLLittleBoy.d();
    this.jdField_b_of_type_JavaUtilArrayList.add(paramGLLittleBoy);
  }
  
  private void b(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localGLLittleBoy.a() == paramAnimation) && (localGLLittleBoy.e))
      {
        localGLLittleBoy.d = true;
        float f = localGLLittleBoy.b().centerY();
        DanceLog.a("changeLittleBoyMissStatus", "[false]ID=" + localGLLittleBoy.a().jdField_a_of_type_JavaLangString + " index" + localGLLittleBoy.jdField_b_of_type_Int + " centerY=" + f + " top=" + this.jdField_a_of_type_AndroidGraphicsRectF.top);
      }
      i += 1;
    }
  }
  
  private void b(GLLittleBoy paramGLLittleBoy)
  {
    if ((!paramGLLittleBoy.e) && (!paramGLLittleBoy.c) && (!paramGLLittleBoy.d)) {
      throw new RuntimeException("对象不是无效对象,mMatched=false mMissed=false");
    }
  }
  
  private Animation c()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.5F));
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setDuration(160L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    localAnimationSet.setAnimationListener(new ahmi(this));
    return localAnimationSet;
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilTreeSet.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      this.jdField_a_of_type_JavaUtilTreeSet.add(localGLLittleBoy);
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      if (!localGLLittleBoy.e)
      {
        b(localGLLittleBoy);
        localGLLittleBoy.jdField_b_of_type_Boolean = false;
      }
      else
      {
        RectF localRectF = localGLLittleBoy.b();
        float f1 = localRectF.centerY();
        localGLLittleBoy.i();
        if (f1 >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom)
        {
          localGLLittleBoy.jdField_b_of_type_Boolean = false;
        }
        else if (f1 <= this.jdField_a_of_type_AndroidGraphicsRectF.top)
        {
          localGLLittleBoy.d = true;
          localGLLittleBoy.jdField_b_of_type_Boolean = false;
          DanceLog.a("judgeLittleBoyValidate", "[true]ID=" + localGLLittleBoy.a().jdField_a_of_type_JavaLangString + " index" + localGLLittleBoy.jdField_b_of_type_Int + " centerY=" + f1 + " top=" + this.jdField_a_of_type_AndroidGraphicsRectF.top);
        }
        else
        {
          DanceLog.a("judgeLittleBoyValidate", "[false]ID=" + localGLLittleBoy.a().jdField_a_of_type_JavaLangString + " index" + localGLLittleBoy.jdField_b_of_type_Int + " centerY=" + f1 + " top=" + this.jdField_a_of_type_AndroidGraphicsRectF.top + " [AccumulationBug]region.top=" + localRectF.top);
          if (localRectF.top <= 0.0F)
          {
            float f2 = f1 - this.jdField_a_of_type_AndroidGraphicsRectF.top;
            if (f2 < 45.0F)
            {
              localGLLittleBoy.d = true;
              localGLLittleBoy.jdField_b_of_type_Boolean = false;
            }
            else
            {
              throw new RuntimeException("judgeLittleBoyValidate:centerY=" + f1 + " mRecognizeRegion.top" + this.jdField_a_of_type_AndroidGraphicsRectF.top + " diff=" + f2 + " 图片过大,设计优化资源");
            }
          }
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    label149:
    label308:
    label474:
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      if (!localGLLittleBoy.e)
      {
        b(localGLLittleBoy);
      }
      else
      {
        int i;
        if (localGLLittleBoy.c)
        {
          this.jdField_a_of_type_Boolean = true;
          f = localGLLittleBoy.b().centerY() - this.jdField_a_of_type_AndroidGraphicsRectF.top;
          if (f <= 0.0F)
          {
            localGLLittleBoy.d = true;
            localGLLittleBoy.jdField_b_of_type_Boolean = false;
            continue;
          }
          if ((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_d_of_type_Float)) {
            break label308;
          }
          this.jdField_a_of_type_Int += 20;
          i = 20;
          localGLLittleBoy.jdField_a_of_type_Int = 1;
          localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_a_of_type_Int = i;
          if (localGLLittleBoy.jdField_a_of_type_Int > this.jdField_b_of_type_Int) {
            this.jdField_b_of_type_Int = localGLLittleBoy.jdField_a_of_type_Int;
          }
        }
        RectF localRectF = localGLLittleBoy.b();
        float f = localRectF.centerY();
        if (f <= this.jdField_a_of_type_AndroidGraphicsRectF.top)
        {
          localGLLittleBoy.d = true;
          localGLLittleBoy.jdField_b_of_type_Boolean = false;
          DanceLog.a("HaveMatchedItems", "[true]ID=" + localGLLittleBoy.a().jdField_a_of_type_JavaLangString + " index" + localGLLittleBoy.jdField_b_of_type_Int + " centerY=" + f + " top=" + this.jdField_a_of_type_AndroidGraphicsRectF.top);
        }
        for (;;)
        {
          if (!localGLLittleBoy.d) {
            break label474;
          }
          localGLLittleBoy.jdField_a_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = true;
          break;
          if (((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_b_of_type_Float)) || ((f >= this.jdField_c_of_type_Float) && (f <= this.jdField_d_of_type_Float)))
          {
            this.jdField_a_of_type_Int += 40;
            i = 40;
            localGLLittleBoy.jdField_a_of_type_Int = 2;
            break label149;
          }
          this.jdField_a_of_type_Int += 50;
          i = 50;
          localGLLittleBoy.jdField_a_of_type_Int = 3;
          break label149;
          DanceLog.a("HaveMatchedItems", "[false]ID=" + localGLLittleBoy.a().jdField_a_of_type_JavaLangString + " index" + localGLLittleBoy.jdField_b_of_type_Int + " centerY=" + f + " top=" + this.jdField_a_of_type_AndroidGraphicsRectF.top + " [AccumulationBug]region.top=" + localRectF.top);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Animation a()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillBefore(true);
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(1.1F, 0.0F, 1.1F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(100L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillBefore(false);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new ahmj(this));
    return localAnimationSet;
  }
  
  public TreeSet a()
  {
    f();
    e();
    return this.jdField_a_of_type_JavaUtilTreeSet;
  }
  
  public void a()
  {
    Rect localRect = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b();
    int i = localRect.width();
    int j = localRect.height();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRectF[0] = new RectF(DisplayUtils.a(65.0F), j, DisplayUtils.a(315), DisplayUtils.a(400) + j);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRectF[1] = new RectF(i - DisplayUtils.a(315), j, i - DisplayUtils.a(65.0F), j + DisplayUtils.a(400));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(RectF paramRectF)
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.equals(paramRectF))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    }
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.height() / 5.0F);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * 2.0F);
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float * 3.0F);
    this.jdField_d_of_type_Float = (this.jdField_a_of_type_Float * 4.0F);
  }
  
  public void a(GLLittleBoy paramGLLittleBoy, boolean paramBoolean)
  {
    paramGLLittleBoy.j();
    paramGLLittleBoy.c(paramGLLittleBoy.c());
    paramGLLittleBoy.e();
    if (paramBoolean)
    {
      if (paramGLLittleBoy.c)
      {
        paramGLLittleBoy.a(a());
        return;
      }
      throw new RuntimeException("initLittleBoyNewRegion,状态错误 mMatched=false");
    }
    if (paramGLLittleBoy.d)
    {
      paramGLLittleBoy.a(c());
      return;
    }
    throw new RuntimeException("initLittleBoyNewRegion,状态错误 mMissed=false");
  }
  
  public int b()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == -1) {
        throw new RuntimeException("匹配成功，但是状态不对.mHaveMatched=true,mCurrentScoreLevel=" + this.jdField_b_of_type_Int);
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label62;
      }
      i = 0;
    }
    return i;
    label62:
    return -1;
  }
  
  public Animation b()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setDuration(130L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  public void b()
  {
    float f = (float)((SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / 100L) / 10.0F;
    ResourceManager localResourceManager = ResourceManager.a();
    Iterator localIterator = localResourceManager.a().iterator();
    while (localIterator.hasNext())
    {
      ResourceManager.DancePosture localDancePosture = (ResourceManager.DancePosture)localIterator.next();
      if ((localDancePosture.jdField_a_of_type_Double <= f) && (!localDancePosture.jdField_a_of_type_Boolean))
      {
        GLLittleBoy localGLLittleBoy = new GLLittleBoy(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext, this.jdField_a_of_type_JavaLangString);
        localGLLittleBoy.a(localResourceManager.a(localDancePosture.jdField_a_of_type_JavaLangString).a);
        localGLLittleBoy.b(1);
        localGLLittleBoy.a(1);
        localGLLittleBoy.a(62.0F);
        localGLLittleBoy.b();
        localGLLittleBoy.a(localDancePosture);
        int i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i + 1);
        localGLLittleBoy.jdField_b_of_type_Int = i;
        Object localObject = localGLLittleBoy.a();
        i = localDancePosture.jdField_b_of_type_Int - 1;
        a(i, ((GLImage)localObject).b(), ((GLImage)localObject).c());
        localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsRectF[i];
        localGLLittleBoy.b((RectF)localObject);
        localGLLittleBoy.d((RectF)localObject);
        localGLLittleBoy.h_(true);
        localGLLittleBoy.a(a(localGLLittleBoy, localDancePosture.jdField_b_of_type_Double));
        this.jdField_a_of_type_JavaUtilArrayList.add(localGLLittleBoy);
        localDancePosture.jdField_a_of_type_Boolean = true;
        localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_a_of_type_Boolean = false;
        localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_a_of_type_JavaLangString = localGLLittleBoy.a().jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      g();
      b();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      GLLittleBoy localGLLittleBoy;
      if (localIterator.hasNext())
      {
        localGLLittleBoy = (GLLittleBoy)localIterator.next();
        if (localGLLittleBoy.e)
        {
          if (localGLLittleBoy.d)
          {
            localGLLittleBoy.e = false;
            a(localGLLittleBoy, false);
            localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_a_of_type_Boolean = true;
            localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_b_of_type_Int = 0;
            if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a.jdField_a_of_type_JavaUtilArrayList.add(localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem);
            }
          }
          if (localGLLittleBoy.c)
          {
            localGLLittleBoy.e = false;
            a(localGLLittleBoy, true);
            localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_a_of_type_Boolean = true;
            localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem.jdField_b_of_type_Int = localGLLittleBoy.jdField_a_of_type_Int;
            if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a.jdField_a_of_type_JavaUtilArrayList.add(localGLLittleBoy.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem);
            }
          }
        }
        for (;;)
        {
          localGLLittleBoy.a();
          break;
          b(localGLLittleBoy);
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localGLLittleBoy = (GLLittleBoy)localIterator.next();
        if (!localGLLittleBoy.e) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localGLLittleBoy);
        } else {
          throw new RuntimeException("状态错误,清理的对象是有效对象");
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilTreeSet.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    Iterator localIterator = ResourceManager.a().a().iterator();
    while (localIterator.hasNext()) {
      ((ResourceManager.DancePosture)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    a(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager
 * JD-Core Version:    0.7.0.1
 */