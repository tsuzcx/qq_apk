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
import bmbx;
import bmdm;
import bmdn;
import bmdo;
import bmdp;
import bmdq;
import bmdr;
import bmds;
import bmdt;
import bmej;
import bmev;
import bmlo;
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewSingleLine;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class MoreLyricLayout
  extends LinearLayout
  implements bmdm, bmdn, bmev
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bmdo jdField_a_of_type_Bmdo;
  private bmdp jdField_a_of_type_Bmdp;
  private bmdq jdField_a_of_type_Bmdq;
  private bmds jdField_a_of_type_Bmds;
  private bmdt jdField_a_of_type_Bmdt = new bmdt(this, null);
  private bmej jdField_a_of_type_Bmej;
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
    if (this.jdField_a_of_type_Bmdq != null) {
      this.jdField_a_of_type_Bmdq.a();
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bmdp == null)
    {
      bmbx.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    this.jdField_a_of_type_Bmdp.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmdq != null) {
      this.jdField_a_of_type_Bmdq.a(paramBoolean);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bmdq != null) {
      this.jdField_a_of_type_Bmdq.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmdo != null) {
      this.jdField_a_of_type_Bmdo.a(paramBoolean);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bmdq != null) {
      this.jdField_a_of_type_Bmdq.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      bmbx.a("MoreLyricLayout", "changeDragStyle() mMusicBarLyricMore == null.");
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine == null) {
        bmbx.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130837757;; i = 2130837758)
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
    LayoutInflater.from(getContext()).inflate(2131558558, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371513));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine = ((LyricViewSingleLine)findViewById(2131371515));
    this.jdField_a_of_type_Bmej = new bmej(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewSingleLine);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView = ((LyricWithBuoyView)findViewById(2131371514));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(this.jdField_a_of_type_Bmdt);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout = ((AESlidingUpPanelLayout)findViewById(2131371378));
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.a(this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout.setFadeOnClickListener(new bmdr(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371512));
    a(true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout == null) {
      bmbx.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
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
      bmbx.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
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
      if (this.jdField_a_of_type_Bmej != null) {
        this.jdField_a_of_type_Bmej.a(paramInt);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView.a(paramInt);
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_Bmds != null) {
      this.jdField_a_of_type_Bmds.a(paramFloat);
    }
  }
  
  public void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    bmbx.a("MoreLyricLayout", "onPanelStateChanged() newState => " + paramPanelState2);
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
  
  public void a(bmlo parambmlo, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (parambmlo == null)
    {
      bmbx.c("MoreLyricLayout", "initLyricView() mData == null.");
      return;
    }
    f();
    Object localObject2 = parambmlo.d();
    String str = parambmlo.e();
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
      bmbx.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
      a(true);
      return;
    }
    if (this.jdField_a_of_type_Bmej != null) {
      this.jdField_a_of_type_Bmej.a();
    }
    if (TextUtils.equals(str.toUpperCase(), "LRC"))
    {
      localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, false);
      parambmlo = (bmlo)localObject2;
      if (this.jdField_a_of_type_Bmej != null)
      {
        this.jdField_a_of_type_Bmej.a(null, (Lyric)localObject2, null);
        parambmlo = (bmlo)localObject2;
      }
    }
    for (;;)
    {
      label173:
      if (parambmlo != null)
      {
        bmbx.a("MoreLyricLayout", "initLyricView() startTime => " + paramInt + ",lyricFormat:" + str);
        if (this.jdField_a_of_type_Bmej != null)
        {
          this.jdField_a_of_type_Bmej.a(false);
          this.jdField_a_of_type_Bmej.a(paramInt, true);
          this.jdField_a_of_type_Bmej.a(null);
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
          parambmlo = (bmlo)localObject2;
          if (this.jdField_a_of_type_Bmej == null) {
            break label173;
          }
          this.jdField_a_of_type_Bmej.a((Lyric)localObject2, null, null);
          parambmlo = (bmlo)localObject2;
          break label173;
          paramBoolean2 = false;
        }
      }
      a(true);
      return;
      label361:
      parambmlo = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    bmbx.a("MoreLyricLayout", "hideLyricLayout() hide > " + paramBoolean);
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
  
  public void setLyricBackgroundEffect(bmds parambmds)
  {
    this.jdField_a_of_type_Bmds = parambmds;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      bmbx.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
    }
    TextView localTextView;
    do
    {
      return;
      if (this.jdField_a_of_type_Bmej == null) {
        bmbx.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
      }
      while (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView == null)
      {
        bmbx.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
        return;
        this.jdField_a_of_type_Bmej.a(paramInt, false);
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
      bmbx.c("MoreLyricLayout", "setMoreBackground() drawable == null.");
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      bmbx.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnMoreLyricLayoutActionListener(bmdp parambmdp)
  {
    this.jdField_a_of_type_Bmdp = parambmdp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */