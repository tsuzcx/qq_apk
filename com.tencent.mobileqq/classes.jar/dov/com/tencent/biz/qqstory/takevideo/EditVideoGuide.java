package dov.com.tencent.biz.qqstory.takevideo;

import aekt;
import alpo;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bmig;
import bmih;
import bmii;
import bmiv;
import bmix;
import bmjh;
import bmkf;
import bnoa;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import uqj;
import uqm;
import uqs;
import urk;
import urr;
import wsv;
import wta;
import xqo;
import xsg;

public class EditVideoGuide
  extends bmiv
  implements View.OnClickListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EditVideoGuide.GotoLocationPageDelayRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable;
  private EditVideoGuide.InitGuideTypeDelayRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable;
  protected AtomicBoolean a;
  public int b;
  
  public EditVideoGuide(@NonNull bmix parambmix)
  {
    super(parambmix);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  private boolean a(int paramInt)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoGuide", "initTipGuide. guideType = %d", Integer.valueOf(paramInt));
    int j = -aekt.a(1.0F, a().getResources());
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    switch (paramInt)
    {
    default: 
      wsv.e("Q.qqstory.publish.edit.EditVideoGuide", "initTipGuide error. unknown guideType = %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704135));
      i = aekt.a(12.0F, a().getResources());
      paramInt = 0;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.setMargins(i, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.setMargins(paramInt, 0, 0, j);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704255));
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, k);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      paramInt = aekt.a(114.0F, a().getResources());
      k = i / 2;
      i = aekt.a(108.0F, a().getResources());
      paramInt -= k;
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704152));
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, k);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      paramInt = aekt.a(162.0F, a().getResources());
      k = i / 2;
      i = aekt.a(156.0F, a().getResources());
      paramInt -= k;
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704110));
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, k);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      paramInt = aekt.a(114.0F, a().getResources());
      k = i / 2;
      i = aekt.a(108.0F, a().getResources());
      paramInt -= k;
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704150));
      paramInt = aekt.a(15.0F, a());
      k = aekt.a(12.0F, a());
      i = aekt.a(12.0F, a());
      k = (bnoa.jdField_a_of_type_Int - paramInt * 2 - k * 5) / 6;
      paramInt = aekt.a(3.0F, a());
      i = paramInt + (k - i) / 2;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.setMargins(0, 0, 0, aekt.a(161.0F, a()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean b()
  {
    return ((Boolean)((urk)urr.a(10)).b("has_show_fragment_guide", Boolean.valueOf(false))).booleanValue();
  }
  
  private void l()
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(500L);
    localAlphaAnimation1.setRepeatCount(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.05F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setRepeatCount(10);
    localTranslateAnimation.setRepeatMode(2);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(500L);
    localAlphaAnimation2.setRepeatCount(0);
    localAlphaAnimation2.setStartOffset(5000L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation2);
    localAnimationSet.setFillAfter(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localTranslateAnimation.setAnimationListener(new bmii(this));
  }
  
  private void n()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 3: 
    case 6: 
      this.jdField_a_of_type_Bmix.a(6);
      return;
    case 4: 
      this.jdField_a_of_type_Bmix.a(2);
      return;
    }
    this.jdField_a_of_type_Bmix.a(7);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373835));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131373836));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131373837));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    boolean bool1 = bmix.a(this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Long, 262144);
    boolean bool2 = b();
    if ((!bool1) || (bool2))
    {
      wsv.b("Q.qqstory.publish.edit.EditVideoGuide", "enableMultiVideoFragment = %s, hasShowFragmentGuide = %s.", Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      b(false);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    wsv.c("Q.qqstory.publish.edit.EditVideoGuide", "wait for fragment list message.");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable = new EditVideoGuide.InitGuideTypeDelayRunnable(this, null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable, 5000L);
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return super.a(paramMessage);
      wsv.b("Q.qqstory.publish.edit.EditVideoGuide", "handleEditVideoMessage. mWaitForFragmentMsg = %s.", Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false));
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable = null;
    }
    paramMessage = (bmjh)a(bmjh.class);
    if (paramMessage != null) {}
    for (paramMessage = paramMessage.a();; paramMessage = null)
    {
      int i;
      if (paramMessage == null)
      {
        i = 0;
        int j = i;
        if (i > this.jdField_a_of_type_Bmix.a.d()) {
          j = this.jdField_a_of_type_Bmix.a.d();
        }
        if (j >= 2) {
          break label171;
        }
        b(false);
      }
      for (;;)
      {
        d();
        return true;
        i = paramMessage.size();
        break;
        label171:
        b(true);
      }
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    paramObject = (urk)urr.a(10);
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      j();
    case 0: 
    case 13: 
    case 10: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
    case 7: 
    case 5: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    xsg localxsg = new xsg(this.jdField_a_of_type_Bmkf.a());
                    localxsg.a(alpo.a(2131704220));
                    localxsg.show();
                    localxsg.setOnDismissListener(new bmig(this));
                    paramObject.b("has_show_basal_guide", Boolean.valueOf(true));
                    wta.a("video_edit", "guide_txt", 0, 0, new String[0]);
                    return;
                    paramObject = new xqo(this.jdField_a_of_type_Bmkf.a());
                    paramObject.a(alpo.a(2131704251));
                  } while (((Activity)a()).isFinishing());
                  paramObject.show();
                  paramObject.setOnDismissListener(new bmih(this));
                  wta.a("video_edit", "guide_filter", 0, 0, new String[0]);
                  return;
                } while (!a(2));
                l();
                wta.a("video_edit", "guide_sticker", 0, 0, new String[0]);
                return;
              } while (!a(3));
              l();
              paramObject.b("has_show_music_guide", Boolean.valueOf(true));
              wta.a("video_edit", "guide_music", 0, 0, new String[0]);
              return;
            } while (!a(1));
            l();
            paramObject.b("has_show_draw_line_guide", Boolean.valueOf(true));
            wta.a("video_edit", "guide_graffiti", 0, 0, new String[0]);
            return;
          } while (!a(4));
          l();
          paramObject.b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
          wta.a("video_edit", "guide_place", 0, 0, new String[0]);
          return;
        } while (!a(5));
        l();
        paramObject.b("has_show_fragment_guide", Boolean.valueOf(true));
        return;
        if (this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int == 1) {
          paramObject.b("has_show_draw_line_guide", Boolean.valueOf(true));
        }
        j();
        return;
      } while (this.jdField_a_of_type_Int == 2);
      j();
      return;
    case 6: 
      k();
      j();
      return;
    }
    if (this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int == 1) {
      paramObject.b("has_show_music_guide", Boolean.valueOf(true));
    }
    j();
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_Int = 8;
      this.b = 8;
      wsv.c("Q.qqstory.publish.edit.EditVideoGuide", "not story business, initial guideType = GUIDE_NULL.");
      return;
    }
    wsv.b("Q.qqstory.publish.edit.EditVideoGuide", "initGuideType. enableMultiFragment = %s.", Boolean.valueOf(paramBoolean));
    urk localurk = (urk)urr.a(10);
    if ((paramBoolean) && (!((Boolean)localurk.b("has_show_fragment_guide", Boolean.valueOf(false))).booleanValue()))
    {
      this.jdField_a_of_type_Int = 7;
      this.b = 7;
      return;
    }
    if (!((Boolean)localurk.b("has_show_basal_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.jdField_a_of_type_Int = 1;
      this.b = 1;
      return;
    }
    paramBoolean = ((Boolean)localurk.b("has_show_music_guide", Boolean.valueOf(false))).booleanValue();
    uqj localuqj = (uqj)((uqs)urr.a(20)).a(1);
    if ((!paramBoolean) && (!localuqj.a((uqm)localuqj.a())))
    {
      this.jdField_a_of_type_Int = 4;
      this.b = 4;
      return;
    }
    if (!((Boolean)localurk.b("has_show_draw_line_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.jdField_a_of_type_Int = 5;
      this.b = 5;
      return;
    }
    if (!((Boolean)localurk.b("has_show_add_poi_paster_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.jdField_a_of_type_Int = 6;
      this.b = 6;
      return;
    }
    this.jdField_a_of_type_Int = 8;
    this.b = 8;
  }
  
  protected void d()
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoGuide", "checkShowGuide. guideType = %d.", Integer.valueOf(this.jdField_a_of_type_Int));
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 7: 
      this.jdField_a_of_type_Bmix.a(24);
      return;
    case 1: 
      this.jdField_a_of_type_Bmix.a(13);
      return;
    case 4: 
      this.jdField_a_of_type_Bmix.a(15);
      return;
    case 5: 
      this.jdField_a_of_type_Bmix.a(16);
      return;
    }
    this.jdField_a_of_type_Bmix.a(17);
  }
  
  public void f()
  {
    super.f();
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      d();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable = null;
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$InitGuideTypeDelayRunnable = null;
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Int != 8)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      this.jdField_a_of_type_Int = 8;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Int == 6) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable = new EditVideoGuide.GotoLocationPageDelayRunnable(this);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide$GotoLocationPageDelayRunnable, 200L);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide
 * JD-Core Version:    0.7.0.1
 */