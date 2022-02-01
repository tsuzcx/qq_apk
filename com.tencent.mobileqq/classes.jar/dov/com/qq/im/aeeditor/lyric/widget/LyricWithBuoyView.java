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
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import dov.com.qq.im.ae.util.AEQLog;
import java.text.SimpleDateFormat;

public class LyricWithBuoyView
  extends FrameLayout
{
  private Handler jdField_a_of_type_AndroidOsHandler = new LyricWithBuoyView.1(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public LyricViewController a;
  public LyricViewDetail a;
  private LyricWithBuoyView.OnLyricWithBuoyViewOperationListener jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView$OnLyricWithBuoyViewOperationListener;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private View b = null;
  
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131558588, this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail = ((LyricViewDetail)paramContext.findViewById(2131364056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131380470));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131364057);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new LyricWithBuoyView.2(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new LyricWithBuoyView.3(this));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail.setIsDealTouchEvent(false);
    this.b = paramContext.findViewById(2131372033);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewDetail);
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
      AEQLog.c("LyricWithBuoyView", "handlerHideSelection() mMusicLyricLineView == null.");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.b(false);
      }
      return;
      this.b.setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null) {
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramInt);
    }
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController == null)
    {
      AEQLog.c("LyricWithBuoyView", "registerScrollListener() mLyricViewController == null.");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramLyricScrollListener);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, LyricViewController.OnObtainMusicPositionListener paramOnObtainMusicPositionListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      AEQLog.a("LyricWithBuoyView", "initLyricView() lyric info is empty.");
    }
    label199:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a();
      }
      Lyric localLyric;
      if (TextUtils.equals(paramString2.toUpperCase(), "LRC"))
      {
        localLyric = LyricParseHelper.parseTextToLyric(paramString1, false);
        paramString1 = localLyric;
        if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null)
        {
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(null, localLyric, null);
          paramString1 = localLyric;
        }
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label199;
        }
        AEQLog.a("LyricWithBuoyView", "initLyricView() startTime => " + paramInt + ",lyricFormat:" + paramString2);
        if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController == null) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(false);
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramInt, true);
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramOnObtainMusicPositionListener);
        return;
        if (TextUtils.equals(paramString2.toUpperCase(), "QRC"))
        {
          localLyric = LyricParseHelper.parseTextToLyric(paramString1, true);
          paramString1 = localLyric;
          if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null)
          {
            this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(localLyric, null, null);
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
  
  public void onMeasure(int paramInt1, int paramInt2)
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
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null)
      {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.b(true);
        continue;
        Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_MOVE");
        String str = a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a());
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
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController == null)
    {
      AEQLog.c("LyricWithBuoyView", "setLyric() mLyricViewController == null.");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramLyric1, paramLyric2, paramLyric3);
  }
  
  public void setOnLyricWithBuoyViewOperationListener(LyricWithBuoyView.OnLyricWithBuoyViewOperationListener paramOnLyricWithBuoyViewOperationListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView$OnLyricWithBuoyViewOperationListener = paramOnLyricWithBuoyViewOperationListener;
  }
  
  public void setSelectedFlag(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewController.a(paramInt, true);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView
 * JD-Core Version:    0.7.0.1
 */