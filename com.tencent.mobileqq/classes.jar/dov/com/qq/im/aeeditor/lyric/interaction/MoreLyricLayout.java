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
import bnrh;
import bnte;
import bntf;
import bntg;
import bnth;
import bnti;
import bntj;
import bntk;
import bntl;
import bnub;
import bnun;
import bobg;
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewSingleLine;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class MoreLyricLayout
  extends LinearLayout
  implements bnte, bntf, bnun
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bntg jdField_a_of_type_Bntg;
  private bnth jdField_a_of_type_Bnth;
  private bnti jdField_a_of_type_Bnti;
  private bntk jdField_a_of_type_Bntk;
  private bntl jdField_a_of_type_Bntl = new bntl(this, null);
  private bnub jdField_a_of_type_Bnub;
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
    if (this.jdField_a_of_type_Bnti != null) {
      this.jdField_a_of_type_Bnti.a();
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bnth == null)
    {
      bnrh.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    this.jdField_a_of_type_Bnth.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bnti != null) {
      this.jdField_a_of_type_Bnti.a(paramBoolean);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bnti != null) {
      this.jdField_a_of_type_Bnti.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bntg != null) {
      this.jdField_a_of_type_Bntg.a(paramBoolean);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bnti != null) {
      this.jdField_a_of_type_Bnti.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      bnrh.a("MoreLyricLayout", "changeDragStyle() mMusicBarLyricMore == null.");
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine == null) {
        bnrh.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130837911;; i = 2130837912)
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
    LayoutInflater.from(getContext()).inflate(2131558569, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371699));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine = ((LyricViewSingleLine)findViewById(2131371701));
    this.jdField_a_of_type_Bnub = new bnub(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView = ((LyricWithBuoyView)findViewById(2131371700));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(this.jdField_a_of_type_Bntl);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout = ((AESlidingUpPanelLayout)findViewById(2131371563));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.a(this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.setFadeOnClickListener(new bntj(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371698));
    a(true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout == null) {
      bnrh.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
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
      bnrh.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
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
      if (this.jdField_a_of_type_Bnub != null) {
        this.jdField_a_of_type_Bnub.a(paramInt);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(paramInt);
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_Bntk != null) {
      this.jdField_a_of_type_Bntk.a(paramFloat);
    }
  }
  
  public void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    bnrh.a("MoreLyricLayout", "onPanelStateChanged() newState => " + paramPanelState2);
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
  
  public void a(bobg parambobg, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (parambobg == null)
    {
      bnrh.c("MoreLyricLayout", "initLyricView() mData == null.");
      return;
    }
    f();
    Object localObject2 = parambobg.d();
    String str = parambobg.e();
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
      bnrh.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
      a(true);
      return;
    }
    if (this.jdField_a_of_type_Bnub != null) {
      this.jdField_a_of_type_Bnub.a();
    }
    if (TextUtils.equals(str.toUpperCase(), "LRC"))
    {
      localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, false);
      parambobg = (bobg)localObject2;
      if (this.jdField_a_of_type_Bnub != null)
      {
        this.jdField_a_of_type_Bnub.a(null, (Lyric)localObject2, null);
        parambobg = (bobg)localObject2;
      }
    }
    for (;;)
    {
      label173:
      if (parambobg != null)
      {
        bnrh.a("MoreLyricLayout", "initLyricView() startTime => " + paramInt + ",lyricFormat:" + str);
        if (this.jdField_a_of_type_Bnub != null)
        {
          this.jdField_a_of_type_Bnub.a(false);
          this.jdField_a_of_type_Bnub.a(paramInt, true);
          this.jdField_a_of_type_Bnub.a(null);
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
          parambobg = (bobg)localObject2;
          if (this.jdField_a_of_type_Bnub == null) {
            break label173;
          }
          this.jdField_a_of_type_Bnub.a((Lyric)localObject2, null, null);
          parambobg = (bobg)localObject2;
          break label173;
          paramBoolean2 = false;
        }
      }
      a(true);
      return;
      label361:
      parambobg = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    bnrh.a("MoreLyricLayout", "hideLyricLayout() hide > " + paramBoolean);
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
  
  public void setLyricBackgroundEffect(bntk parambntk)
  {
    this.jdField_a_of_type_Bntk = parambntk;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      bnrh.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
    }
    TextView localTextView;
    do
    {
      return;
      if (this.jdField_a_of_type_Bnub == null) {
        bnrh.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
      }
      while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null)
      {
        bnrh.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
        return;
        this.jdField_a_of_type_Bnub.a(paramInt, false);
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
      bnrh.c("MoreLyricLayout", "setMoreBackground() drawable == null.");
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      bnrh.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnMoreLyricLayoutActionListener(bnth parambnth)
  {
    this.jdField_a_of_type_Bnth = parambnth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */