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
import bnzb;
import boah;
import boai;
import boaj;
import boak;
import boal;
import boam;
import boan;
import boao;
import bobe;
import bobq;
import bogx;
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewSingleLine;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class MoreLyricLayout
  extends LinearLayout
  implements boah, boai, bobq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private boaj jdField_a_of_type_Boaj;
  private boak jdField_a_of_type_Boak;
  private boal jdField_a_of_type_Boal;
  private boan jdField_a_of_type_Boan;
  private boao jdField_a_of_type_Boao = new boao(this, null);
  private bobe jdField_a_of_type_Bobe;
  private AESlidingUpPanelLayout jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout;
  private LyricViewSingleLine jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine;
  private LyricWithBuoyView jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView;
  private boolean jdField_a_of_type_Boolean;
  
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
    if (this.jdField_a_of_type_Boal != null) {
      this.jdField_a_of_type_Boal.a();
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boak == null)
    {
      bnzb.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    this.jdField_a_of_type_Boak.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boal != null) {
      this.jdField_a_of_type_Boal.a(paramBoolean);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boal != null) {
      this.jdField_a_of_type_Boal.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boaj != null) {
      this.jdField_a_of_type_Boaj.a(paramBoolean);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boal != null) {
      this.jdField_a_of_type_Boal.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      bnzb.a("MoreLyricLayout", "changeDragStyle() mMusicBarLyricMore == null.");
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine == null) {
        bnzb.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130837737;; i = 2130837738)
      {
        ((ImageView)localObject).setImageResource(i);
        break;
      }
    }
    Object localObject = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((LyricViewSingleLine)localObject).setVisibility(i);
      return;
    }
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131558556, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371437));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine = ((LyricViewSingleLine)findViewById(2131371439));
    this.jdField_a_of_type_Bobe = new bobe(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView = ((LyricWithBuoyView)findViewById(2131371438));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(this.jdField_a_of_type_Boao);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout = ((AESlidingUpPanelLayout)findViewById(2131371303));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.a(this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.setFadeOnClickListener(new boam(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371436));
    a(true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout == null) {
      bnzb.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
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
      bnzb.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
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
      if (this.jdField_a_of_type_Bobe != null) {
        this.jdField_a_of_type_Bobe.a(paramInt);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(paramInt);
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_Boan != null) {
      this.jdField_a_of_type_Boan.a(paramFloat);
    }
  }
  
  public void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    bnzb.a("MoreLyricLayout", "onPanelStateChanged() newState => " + paramPanelState2);
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
  
  public void a(bogx parambogx, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (parambogx == null)
    {
      bnzb.c("MoreLyricLayout", "initLyricView() mData == null.");
      return;
    }
    f();
    Object localObject2 = parambogx.d();
    String str = parambogx.e();
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
      bnzb.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
      a(true);
      return;
    }
    if (this.jdField_a_of_type_Bobe != null) {
      this.jdField_a_of_type_Bobe.a();
    }
    if (TextUtils.equals(str.toUpperCase(), "LRC"))
    {
      localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, false);
      parambogx = (bogx)localObject2;
      if (this.jdField_a_of_type_Bobe != null)
      {
        this.jdField_a_of_type_Bobe.a(null, (Lyric)localObject2, null);
        parambogx = (bogx)localObject2;
      }
    }
    for (;;)
    {
      label173:
      if (parambogx != null)
      {
        bnzb.a("MoreLyricLayout", "initLyricView() startTime => " + paramInt + ",lyricFormat:" + str);
        if (this.jdField_a_of_type_Bobe != null)
        {
          this.jdField_a_of_type_Bobe.a(false);
          this.jdField_a_of_type_Bobe.a(paramInt, true);
          this.jdField_a_of_type_Bobe.a(null);
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
            break label361;
          }
          localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, true);
          parambogx = (bogx)localObject2;
          if (this.jdField_a_of_type_Bobe == null) {
            break label173;
          }
          this.jdField_a_of_type_Bobe.a((Lyric)localObject2, null, null);
          parambogx = (bogx)localObject2;
          break label173;
          paramBoolean2 = false;
        }
      }
      a(true);
      return;
      label361:
      parambogx = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    bnzb.a("MoreLyricLayout", "hideLyricLayout() hide > " + paramBoolean);
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
  
  public void setLyricBackgroundEffect(boan paramboan)
  {
    this.jdField_a_of_type_Boan = paramboan;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      bnzb.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
    }
    TextView localTextView;
    do
    {
      return;
      if (this.jdField_a_of_type_Bobe == null) {
        bnzb.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
      }
      while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null)
      {
        bnzb.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
        return;
        this.jdField_a_of_type_Bobe.a(paramInt, false);
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
      bnzb.c("MoreLyricLayout", "setMoreBackground() drawable == null.");
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      bnzb.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnMoreLyricLayoutActionListener(boak paramboak)
  {
    this.jdField_a_of_type_Boak = paramboak;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */