package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import aifi;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLAudioWaveN;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLyricsManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar.ProgressBarListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GamingResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GeneralResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.LBGeneralResource;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.List;
import java.util.TreeSet;

public class DancePlayFilter
  extends DanceBaseFilter
  implements Animation.AnimationListener, GLProgressBar.ProgressBarListener
{
  private long jdField_a_of_type_Long;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private GLAudioWaveN jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN;
  private GLImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private GLLittleBoyManager jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager;
  private GLLyricsManager jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsManager;
  private GLProgressBar jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar;
  private GLRecognizeRegionView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView;
  private GLScoreBoard jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard;
  private boolean jdField_a_of_type_Boolean;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private boolean jdField_b_of_type_Boolean = false;
  
  public DancePlayFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.c();
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.a(i);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.a());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.b());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().b(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.e(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsManager.a();
  }
  
  public TreeSet a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.b();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a.b = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a();
    QQDanceEventHandler localQQDanceEventHandler = a().a();
    if (localQQDanceEventHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a.jdField_a_of_type_Boolean = true;
      localQQDanceEventHandler.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a);
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().b();
    paramInt1 = ((Rect)localObject).width();
    paramInt2 = ((Rect)localObject).height();
    localObject = ResourceManager.a().jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource;
    RectF localRectF1 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(localRectF1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(localRectF1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(((ResourceManager.GamingResource)localObject).m);
    localRectF1 = new RectF(DisplayUtils.a(37.0F), DisplayUtils.a(32.0F), paramInt1 - DisplayUtils.a(37.0F), DisplayUtils.a(161.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(localRectF1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.b(localRectF1);
    RectF localRectF2 = new RectF(DisplayUtils.a(2.0F), DisplayUtils.a(0.0F), DisplayUtils.a(213.0F), DisplayUtils.a(119.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.b((String)((ResourceManager.GamingResource)localObject).jdField_a_of_type_JavaUtilList.get(0));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.c(localRectF2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(DisplayUtils.a(80.0F), DisplayUtils.a(131.0F));
    int i = ResourceManager.a().jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(i);
    localRectF2 = new RectF(DisplayUtils.a(2.0F), DisplayUtils.a(197.0F), paramInt1 - DisplayUtils.a(2.0F), paramInt2 - DisplayUtils.a(194.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.a(localRectF2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.a(localRectF2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.a();
    localRectF2.set(DisplayUtils.a(15.0F), DisplayUtils.a(185.0F), paramInt1 - DisplayUtils.a(15.0F), DisplayUtils.a(328.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.b(localRectF2);
    localRectF2.set(DisplayUtils.a(0.0F), DisplayUtils.a(0.0F), paramInt1, DisplayUtils.a(571.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.c(localRectF2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.b(DisplayUtils.a(180.0F));
    localRectF2.set(DisplayUtils.a(194.0F), DisplayUtils.a(98.0F), paramInt1 - DisplayUtils.a(194.0F), DisplayUtils.a(138.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a(localRectF2, localRectF1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.e(DisplayUtils.a(-10.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN.a(((ResourceManager.GamingResource)localObject).n);
    float f = DisplayUtils.a(1.0F);
    localRectF2.set(f, paramInt2 - DisplayUtils.a(180.0F), paramInt1 - f, paramInt2 - f);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN.a(localRectF2);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a();
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(((RectF)localObject).left, ((RectF)localObject).left, -20.0F, ((RectF)localObject).top);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    int i = ResourceManager.a().jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(i);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.e();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.d();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.d();
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = ResourceManager.a().jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$LBGeneralResource;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().b(((ResourceManager.LBGeneralResource)localObject).jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.f_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN.f_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.f_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.f_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.a(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = null;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsManager.b();
  }
  
  public void d()
  {
    Object localObject = ResourceManager.a().jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(ResourceManager.a().jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GeneralResource.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar = new GLProgressBar(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.g(2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView = new GLRecognizeRegionView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.a((String)((ResourceManager.GamingResource)localObject).jdField_b_of_type_JavaUtilList.get(1));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.b((String)((ResourceManager.GamingResource)localObject).jdField_b_of_type_JavaUtilList.get(0));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.c((String)((ResourceManager.GamingResource)localObject).jdField_b_of_type_JavaUtilList.get(3));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.d((String)((ResourceManager.GamingResource)localObject).jdField_b_of_type_JavaUtilList.get(2));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.a("", ((ResourceManager.GamingResource)localObject).j, ((ResourceManager.GamingResource)localObject).k, ((ResourceManager.GamingResource)localObject).l);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.b(((ResourceManager.GamingResource)localObject).e, ((ResourceManager.GamingResource)localObject).f, ((ResourceManager.GamingResource)localObject).g, ((ResourceManager.GamingResource)localObject).h);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.c(((ResourceManager.GamingResource)localObject).jdField_a_of_type_JavaLangString, ((ResourceManager.GamingResource)localObject).jdField_b_of_type_JavaLangString, ((ResourceManager.GamingResource)localObject).c, ((ResourceManager.GamingResource)localObject).d);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.a(new aifi(this));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard = new GLScoreBoard(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    localObject = ResourceManager.a().jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GameNumberResource;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a(((ResourceManager.GameNumberResource)localObject).jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager = new GLLittleBoyManager(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN = new GLAudioWaveN(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLAudioWaveN.g(2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsManager = new GLLyricsManager(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().c();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView.b();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoyManager.a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsManager.a(this.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DancePlayFilter
 * JD-Core Version:    0.7.0.1
 */