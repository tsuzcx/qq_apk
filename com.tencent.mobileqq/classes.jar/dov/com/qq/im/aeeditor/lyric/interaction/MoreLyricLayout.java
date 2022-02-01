package dov.com.qq.im.aeeditor.lyric.interaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewController;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewSingleLine;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView.OnLyricWithBuoyViewOperationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;

public class MoreLyricLayout
  extends LinearLayout
  implements AESlidingUpPanelLayout.PanelSlideListener, IMoreLyricLayout, LyricWithBuoyView.OnLyricWithBuoyViewOperationListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private AESlidingUpPanelLayout jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout;
  private IMoreLyricLayout.OnLayoutVisibleChangeListener jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnLayoutVisibleChangeListener;
  private IMoreLyricLayout.OnMoreLyricLayoutActionListener jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener;
  private IMoreLyricLayout.OnViewActionReportListener jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener;
  private MoreLyricLayout.LyricBackgroundEffect jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect = null;
  private MoreLyricLayout.LyricScrollListener jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout$LyricScrollListener = new MoreLyricLayout.LyricScrollListener(this, null);
  private LyricViewController jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController = null;
  private LyricViewSingleLine jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine = null;
  private LyricWithBuoyView jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public MoreLyricLayout(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public MoreLyricLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public MoreLyricLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener.a();
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener == null)
    {
      AEQLog.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener.a(paramBoolean);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnLayoutVisibleChangeListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnLayoutVisibleChangeListener.a(paramBoolean);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine == null)
    {
      AEQLog.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
      return;
    }
    LyricViewSingleLine localLyricViewSingleLine = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLyricViewSingleLine.setVisibility(i);
      return;
    }
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131558591, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372012));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine = ((LyricViewSingleLine)findViewById(2131372014));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView = ((LyricWithBuoyView)findViewById(2131372013));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout$LyricScrollListener);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout = ((AESlidingUpPanelLayout)findViewById(2131371875));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.a(this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.setFadeOnClickListener(new MoreLyricLayout.1(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372011));
    a(true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout == null) {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
    }
    for (;;)
    {
      g();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.setPanelState(AESlidingUpPanelLayout.PanelState.COLLAPSED);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null)
    {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a();
  }
  
  public void a()
  {
    b((int)this.jdField_a_of_type_Long);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramInt);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(paramInt);
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect.a(paramFloat);
    }
  }
  
  public void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    AEQLog.a("MoreLyricLayout", "onPanelStateChanged() newState => " + paramPanelState2);
    if (paramPanelState2 == AESlidingUpPanelLayout.PanelState.DRAGGING)
    {
      d(false);
      d();
      return;
    }
    if (paramPanelState2 == AESlidingUpPanelLayout.PanelState.COLLAPSED)
    {
      d(true);
      g();
      b(false);
      return;
    }
    if (paramPanelState2 == AESlidingUpPanelLayout.PanelState.ANCHORED)
    {
      f();
      return;
    }
    d(false);
    b(true);
  }
  
  public void a(AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (paramAEEditorMusicInfo == null)
    {
      AEQLog.c("MoreLyricLayout", "initLyricView() mData == null.");
      return;
    }
    f();
    Object localObject2 = paramAEEditorMusicInfo.d();
    String str = paramAEEditorMusicInfo.e();
    this.jdField_a_of_type_Boolean = false;
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(((String)localObject2).trim())))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏")) {}
    }
    else
    {
      localObject1 = "[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏";
      str = "LRC";
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str)))
    {
      AEQLog.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
      a(true);
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a();
    }
    if (TextUtils.equals(str.toUpperCase(), "LRC"))
    {
      localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, false);
      paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null)
      {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(null, (Lyric)localObject2, null);
        paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
      }
    }
    for (;;)
    {
      label171:
      if (paramAEEditorMusicInfo != null)
      {
        AEQLog.a("MoreLyricLayout", "initLyricView() startTime => " + paramInt + ",lyricFormat:" + str);
        if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null)
        {
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(false);
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramInt, true);
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(null);
        }
        this.jdField_a_of_type_Boolean = true;
        if (!paramBoolean1) {}
        for (;;)
        {
          a(paramBoolean2);
          if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView != null)
          {
            this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a((String)localObject1, str, paramInt, null);
            this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.setOnLyricWithBuoyViewOperationListener(this);
          }
          if (!paramBoolean1) {
            break;
          }
          b();
          return;
          if (!TextUtils.equals(str.toUpperCase(), "QRC")) {
            break label359;
          }
          localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, true);
          paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
          if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController == null) {
            break label171;
          }
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a((Lyric)localObject2, null, null);
          paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
          break label171;
          paramBoolean2 = false;
        }
      }
      a(true);
      return;
      label359:
      paramAEEditorMusicInfo = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    AEQLog.a("MoreLyricLayout", "hideLyricLayout() hide > " + paramBoolean);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      f();
      paramBoolean = bool;
      if (getVisibility() == 0) {
        paramBoolean = true;
      }
      c(paramBoolean);
      return;
    }
  }
  
  public void setLyricBackgroundEffect(MoreLyricLayout.LyricBackgroundEffect paramLyricBackgroundEffect)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect = paramLyricBackgroundEffect;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
    }
    TextView localTextView;
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController == null) {
        AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
      }
      while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null)
      {
        AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
        return;
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramInt, false);
      }
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.setSelectedFlag(paramInt, false);
      localTextView = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a();
    } while (localTextView == null);
    localTextView.setText(LyricWithBuoyView.a(paramInt));
  }
  
  public void setMoreBackground(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() drawable == null.");
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnMoreLyricLayoutActionListener(IMoreLyricLayout.OnMoreLyricLayoutActionListener paramOnMoreLyricLayoutActionListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener = paramOnMoreLyricLayoutActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */