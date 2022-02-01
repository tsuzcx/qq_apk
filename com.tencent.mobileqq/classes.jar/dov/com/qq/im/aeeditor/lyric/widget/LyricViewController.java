package dov.com.qq.im.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager;
import dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager.TimerTaskRunnable;
import dov.com.qq.im.aeeditor.lyric.util.LyricContext;
import dov.com.qq.im.aeeditor.module.music.AEEditorLyricProgressCalculator;
import java.util.ArrayList;

public class LyricViewController
{
  protected static final String a;
  protected int a;
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new LyricViewController.7(this, Looper.getMainLooper());
  protected Lyric a;
  protected TimerTaskManager.TimerTaskRunnable a;
  protected TimerTaskManager a;
  protected LyricBaseInternalViewInterface a;
  protected LyricScrollHelper a;
  public LyricViewController.OnObtainMusicPositionListener a;
  private LyricViewScroll.LyricViewScrollListener jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener = new LyricViewController.1(this);
  protected LyricViewScroll a;
  protected volatile boolean a;
  protected int b;
  private boolean b;
  protected int c;
  private boolean c;
  private volatile int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int f = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "task_name_lyric_draw_" + Math.random();
  }
  
  public LyricViewController(LyricView paramLyricView)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_DovComQqImAeeditorLyricCommonTimerTaskManager = LyricContext.a();
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper = new LyricScrollHelper();
    this.jdField_a_of_type_DovComQqImAeeditorLyricCommonTimerTaskManager$TimerTaskRunnable = new LyricViewController.2(this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface = paramLyricView.a();
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      if (paramInt > 0) {
        this.f = paramInt;
      }
      b(this.f);
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController$OnObtainMusicPositionListener != null) {
        paramInt = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController$OnObtainMusicPositionListener.a();
      } else {
        paramInt = (int)AEEditorLyricProgressCalculator.a().a(false);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    Log.d("ModuleController", "stop");
    this.jdField_a_of_type_DovComQqImAeeditorLyricCommonTimerTaskManager.a(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (Thread.currentThread().equals(Looper.getMainLooper().getThread()))
    {
      b(paramInt);
      return;
    }
    LyricContext.a().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    LyricContext.a().post(new LyricViewController.6(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    LyricContext.a().post(new LyricViewController.4(this, paramInt, paramBoolean));
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    LyricContext.a().post(new LyricViewController.3(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper.a(paramLyricScrollListener);
  }
  
  public void a(LyricViewController.OnObtainMusicPositionListener paramOnObtainMusicPositionListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController$OnObtainMusicPositionListener = paramOnObtainMusicPositionListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface.setEffectEnable(paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface.a();
    Lyric localLyric = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
    if ((localLyric == null) || (localLyric.isEmpty())) {
      return;
    }
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Int > 0) {
        i = paramInt + this.jdField_a_of_type_Int;
      }
    }
    paramInt = i;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = i;
      if (i >= this.jdField_b_of_type_Int) {
        paramInt = this.jdField_b_of_type_Int;
      }
    }
    this.jdField_d_of_type_Int = paramInt;
    a(localLyric.findLineNo(paramInt), paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  protected void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) || (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface != null))
    {
      paramInt = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface.a(paramInt);
      if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) && (!this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty())) {
        break label51;
      }
      Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
    }
    label51:
    int i;
    do
    {
      return;
      if (paramInt != this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size() - 1) {
        break;
      }
      i = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface.b();
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll != null)
      {
        Log.d("ModuleController", "onScrollStop() endTop => " + i);
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.smoothScrollTo(0, i);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper == null);
    long l1 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper.a(l1, i);
    return;
    Log.d("ModuleController", "onScrollStop -> scroll to lineNo：" + paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()))
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
      Log.d("ModuleController", "onScrollStop -> start time of current sentence：" + l2);
      l1 = l2;
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Int < 0) || (l2 >= this.jdField_a_of_type_Int)) {
          break label416;
        }
        l1 = this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        Log.d("ModuleController", "onScrollStop -> correct start time：" + l1);
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        Log.d("ModuleController", "onScrollStop -> output time：" + l1);
        if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper != null) {
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper.a(l1);
        }
        if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean)) {
          break;
        }
        a((int)l1, false);
        return;
        label416:
        l1 = l2;
        if (this.jdField_b_of_type_Int >= 0)
        {
          l1 = l2;
          if (l2 > this.jdField_b_of_type_Int) {
            l1 = this.jdField_b_of_type_Int;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
  
  protected void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) || (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface != null))
    {
      paramInt = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricBaseInternalViewInterface.b(paramInt);
      if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty())) {
        Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()))
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
      long l1 = l2;
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Int < 0) || (l2 >= this.jdField_a_of_type_Int)) {
          break label235;
        }
        l1 = this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        int i = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.getScrollY();
        AEQLog.a("ModuleController", "onScrolling() scrollY => " + i + ",position => " + l1 + ",lineNo:" + paramInt);
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricScrollHelper.a(l1, i);
        return;
        label235:
        l1 = l2;
        if (this.jdField_b_of_type_Int >= 0)
        {
          l1 = l2;
          if (l2 > this.jdField_b_of_type_Int) {
            l1 = this.jdField_b_of_type_Int;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewController
 * JD-Core Version:    0.7.0.1
 */