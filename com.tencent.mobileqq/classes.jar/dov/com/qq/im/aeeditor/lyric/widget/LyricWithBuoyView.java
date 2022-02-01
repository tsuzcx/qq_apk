package dov.com.qq.im.aeeditor.lyric.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import bpam;
import bpcu;
import bpcz;
import bpdc;
import bpdi;
import bpdj;
import bpdk;
import bpdl;
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import java.text.SimpleDateFormat;

public class LyricWithBuoyView
  extends FrameLayout
{
  private Handler jdField_a_of_type_AndroidOsHandler = new bpdi(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bpcz a;
  private bpdl jdField_a_of_type_Bpdl;
  public LyricViewDetail a;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private View b;
  
  public LyricWithBuoyView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public LyricWithBuoyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LyricWithBuoyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutInflater.from(paramContext).inflate(2131558555, this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail = ((LyricViewDetail)paramContext.findViewById(2131363861));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379954));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131363862);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bpdj(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bpdk(this));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail.setIsDealTouchEvent(false);
    this.b = paramContext.findViewById(2131371565);
    this.jdField_a_of_type_Bpcz = new bpcz(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail);
  }
  
  public static String a(int paramInt)
  {
    return new SimpleDateFormat("mm:ss").format(Integer.valueOf(paramInt));
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    if (this.b == null) {
      bpam.c("LyricWithBuoyView", "handlerHideSelection() mMusicLyricLineView == null.");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bpcz != null) {
        this.jdField_a_of_type_Bpcz.b(false);
      }
      return;
      this.b.setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bpcz != null) {
      this.jdField_a_of_type_Bpcz.a(paramInt);
    }
  }
  
  public void a(bpcu parambpcu)
  {
    if (this.jdField_a_of_type_Bpcz == null)
    {
      bpam.c("LyricWithBuoyView", "registerScrollListener() mLyricViewController == null.");
      return;
    }
    this.jdField_a_of_type_Bpcz.a(parambpcu);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, bpdc parambpdc)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bpam.a("LyricWithBuoyView", "initLyricView() lyric info is empty.");
    }
    label199:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bpcz != null) {
        this.jdField_a_of_type_Bpcz.a();
      }
      Lyric localLyric;
      if (TextUtils.equals(paramString2.toUpperCase(), "LRC"))
      {
        localLyric = LyricParseHelper.parseTextToLyric(paramString1, false);
        paramString1 = localLyric;
        if (this.jdField_a_of_type_Bpcz != null)
        {
          this.jdField_a_of_type_Bpcz.a(null, localLyric, null);
          paramString1 = localLyric;
        }
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label199;
        }
        bpam.a("LyricWithBuoyView", "initLyricView() startTime => " + paramInt + ",lyricFormat:" + paramString2);
        if (this.jdField_a_of_type_Bpcz == null) {
          break;
        }
        this.jdField_a_of_type_Bpcz.a(false);
        this.jdField_a_of_type_Bpcz.a(paramInt, true);
        this.jdField_a_of_type_Bpcz.a(parambpdc);
        return;
        if (TextUtils.equals(paramString2.toUpperCase(), "QRC"))
        {
          localLyric = LyricParseHelper.parseTextToLyric(paramString1, true);
          paramString1 = localLyric;
          if (this.jdField_a_of_type_Bpcz != null)
          {
            this.jdField_a_of_type_Bpcz.a(localLyric, null, null);
            paramString1 = localLyric;
          }
        }
        else
        {
          paramString1 = null;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = (int)(getMeasuredHeight() * 0.3F);
    if (this.b == null) {}
    for (Object localObject = null;; localObject = this.b.getLayoutParams())
    {
      if ((localObject instanceof FrameLayout.LayoutParams))
      {
        localObject = (FrameLayout.LayoutParams)localObject;
        ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, paramInt1, ((FrameLayout.LayoutParams)localObject).rightMargin, ((FrameLayout.LayoutParams)localObject).bottomMargin);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail.a(paramMotionEvent);
      return true;
      Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_DOWN");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((this.b != null) && (this.b.getVisibility() != 0)) {
        this.b.setVisibility(0);
      }
      if (this.jdField_a_of_type_Bpcz != null)
      {
        this.jdField_a_of_type_Bpcz.b(true);
        continue;
        Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_MOVE");
        String str = a(this.jdField_a_of_type_Bpcz.a());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        invalidate();
        continue;
        Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_UP");
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      }
    }
  }
  
  public void setLyric(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    if (this.jdField_a_of_type_Bpcz == null)
    {
      bpam.c("LyricWithBuoyView", "setLyric() mLyricViewController == null.");
      return;
    }
    this.jdField_a_of_type_Bpcz.a(paramLyric1, paramLyric2, paramLyric3);
  }
  
  public void setOnLyricWithBuoyViewOperationListener(bpdl parambpdl)
  {
    this.jdField_a_of_type_Bpdl = parambpdl;
  }
  
  public void setSelectedFlag(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bpcz != null)
    {
      this.jdField_a_of_type_Bpcz.a(paramInt, true);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView
 * JD-Core Version:    0.7.0.1
 */