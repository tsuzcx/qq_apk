package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.CommonUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;
import mqq.os.MqqHandler;

public class GameAioViewSwitcher
  extends ViewSwitcher
  implements Handler.Callback
{
  protected final MqqHandler a = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private Animation b;
  private Animation c;
  private Animation d;
  private Animation e;
  private ImageView f;
  private CornerImageView g;
  private List<String> h;
  private int i = 0;
  
  public GameAioViewSwitcher(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GameAioViewSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = 1;
    this.a.removeCallbacksAndMessages(null);
    this.a.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(int paramInt)
  {
    if (paramInt % 2 == 0)
    {
      setInAnimation(this.d);
      setOutAnimation(this.e);
      setDisplayedChild(0);
      return;
    }
    setInAnimation(this.b);
    setOutAnimation(this.c);
    if (this.h.size() >= this.i)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130841444);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130841444);
      localObject = URLDrawable.getDrawable((String)this.h.get(this.i), (URLDrawable.URLDrawableOptions)localObject);
      this.g.setImageDrawable((Drawable)localObject);
      this.i += 1;
      if (this.i == this.h.size()) {
        this.i = 0;
      }
      setDisplayedChild(1);
    }
  }
  
  public void a(Context paramContext)
  {
    this.d = AnimationUtils.loadAnimation(paramContext, 2130772484);
    this.b = AnimationUtils.loadAnimation(paramContext, 2130772485);
    this.e = AnimationUtils.loadAnimation(paramContext, 2130772486);
    this.c = AnimationUtils.loadAnimation(paramContext, 2130772487);
    this.f = new ImageView(paramContext);
    this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.g = new CornerImageView(paramContext);
    this.g.setRadius(CommonUtils.a(12.0F, getResources()));
    this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    addView(this.f, 0, paramContext);
    addView(this.g, 1, localLayoutParams);
    this.f.setImageResource(2130840484);
    this.g.setImageResource(2130841444);
    setDisplayedChild(0);
  }
  
  public List<String> getData()
  {
    return this.h;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    a(paramMessage.arg1);
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    int j = paramMessage.arg1 + 1;
    paramMessage.arg1 = j;
    localMessage.arg1 = j;
    if (localMessage.arg1 < this.h.size() * 2 + 1) {
      this.a.sendMessageDelayed(localMessage, 2000L);
    }
    return true;
  }
  
  public void setData(List<String> paramList)
  {
    this.h = paramList;
    paramList = this.h;
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.excute(new GameAioViewSwitcher.1(this), 128, null, true);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.GameAioViewSwitcher
 * JD-Core Version:    0.7.0.1
 */