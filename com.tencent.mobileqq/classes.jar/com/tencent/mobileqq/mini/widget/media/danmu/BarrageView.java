package com.tencent.mobileqq.mini.widget.media.danmu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbkx;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BarrageView
  extends RelativeLayout
  implements Comparator<Barrage>
{
  private static final boolean DEFAULT_ALLOWREPEAT = true;
  private static final int DEFAULT_BARRAGESIZE = 10;
  private static final int DEFAULT_BORDERCOLOR = -16777216;
  private static final int DEFAULT_LINEHEIGHT = 24;
  private static final int DEFAULT_MAXTEXTSIZE = 18;
  private static final int DEFAULT_MINTEXTSIZE = 14;
  private static final int DEFAULT_PADDING = 15;
  private static final boolean DEFAULT_RANDOMCOLOR = false;
  private static final String TAG = "BarrageView";
  private int INTERVAL = 500;
  private final SparseArray<Animation> animCache = new SparseArray();
  private final List<Barrage> barrages = new LinkedList();
  private int borderColor = -16777216;
  private int lastShowBarrageIndex = -1;
  private long lastUpdateTime = 9223372036854775807L;
  private int lineHeight = 24;
  private int maxBarrageSize = 10;
  private int maxTextSize = 18;
  private int minTextSize = 18;
  private boolean noRepeat = true;
  private Random random = new Random(System.currentTimeMillis());
  private boolean random_color = false;
  private int textBottomPadding = 15;
  private int textLeftPadding = 15;
  private int textRightPadding = 15;
  private int textTopPadding = 15;
  private final Set<Animation> transientAnimCache = new HashSet();
  private final List<Barrage> transientBarrages = new LinkedList();
  
  public BarrageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (px2sp(paramContext, this.lineHeight) < this.maxTextSize) {
      this.maxTextSize = px2sp(paramContext, this.lineHeight);
    }
  }
  
  private Animation createBarrageAnim(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    Animation localAnimation = AnimationHelper.createTranslateAnim(getContext(), paramInt, -bbkx.a());
    localAnimation.setAnimationListener(paramAnimationListener);
    localAnimation.setDuration(3000L);
    return localAnimation;
  }
  
  private TextView createTextByBarrage(Barrage paramBarrage, int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setPadding(this.textLeftPadding, this.textTopPadding, this.textRightPadding, this.textBottomPadding);
    localTextView.setTextSize(paramInt1);
    localTextView.setText(paramBarrage.text);
    localTextView.setTextColor(paramBarrage.color);
    paramBarrage = new RelativeLayout.LayoutParams(-2, -2);
    paramBarrage.addRule(10);
    paramBarrage.topMargin = paramInt2;
    Log.i("BarrageView", "createTextByBarrage: " + paramInt2);
    localTextView.setLayoutParams(paramBarrage);
    return localTextView;
  }
  
  private int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  private void showBarrage(List<Integer> paramList)
  {
    Log.i("BarrageView", "showBarrage: " + Arrays.toString(paramList.toArray()));
    int j = getRight() - getLeft() - getPaddingLeft();
    int k = this.minTextSize;
    paramList = paramList.iterator();
    int i = 10;
    TextView localTextView;
    Animation localAnimation;
    while (paramList.hasNext())
    {
      int m = ((Integer)paramList.next()).intValue();
      if (this.animCache.get(m) == null)
      {
        localTextView = createTextByBarrage((Barrage)this.barrages.get(m), k, i);
        localAnimation = createBarrageAnim(j, new BarrageView.1(this, localTextView, m));
        startBarrageAnim(localTextView, localAnimation);
        this.animCache.put(m, localAnimation);
        i = k * 3 + i;
      }
    }
    paramList = this.transientBarrages.iterator();
    while (paramList.hasNext())
    {
      localTextView = createTextByBarrage((Barrage)paramList.next(), k, i);
      i += k * 3;
      localAnimation = createBarrageAnim(j, new BarrageView.2(this, localTextView));
      startBarrageAnim(localTextView, localAnimation);
      this.transientAnimCache.add(localAnimation);
    }
    this.transientBarrages.clear();
  }
  
  private void startBarrageAnim(TextView paramTextView, Animation paramAnimation)
  {
    paramTextView.startAnimation(paramAnimation);
    addView(paramTextView);
  }
  
  public int compare(Barrage paramBarrage1, Barrage paramBarrage2)
  {
    if (paramBarrage1.time < paramBarrage2.time) {
      return -1;
    }
    if (paramBarrage1.time == paramBarrage2.time) {
      return 0;
    }
    return 1;
  }
  
  public void destroy()
  {
    this.barrages.clear();
    int i = 0;
    while (i < this.animCache.size())
    {
      ((Animation)this.animCache.valueAt(i)).cancel();
      i += 1;
    }
    Iterator localIterator = this.transientAnimCache.iterator();
    while (localIterator.hasNext()) {
      ((Animation)localIterator.next()).cancel();
    }
    this.animCache.clear();
    this.transientAnimCache.clear();
    this.lastUpdateTime = 9223372036854775807L;
    this.lastShowBarrageIndex = -1;
  }
  
  public void setBarrages(List<Barrage> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      Collections.sort(paramList, this);
    } while (this.barrages.equals(paramList));
    destroy();
    this.barrages.addAll(paramList);
  }
  
  public void showBarrageNextTime(Barrage paramBarrage)
  {
    this.transientBarrages.add(paramBarrage);
  }
  
  public void updateTime(long paramLong)
  {
    if ((paramLong < 0L) || (paramLong == this.lastUpdateTime)) {
      return;
    }
    if (paramLong < this.lastUpdateTime) {
      this.lastShowBarrageIndex = -1;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.lastShowBarrageIndex + 1;
    for (;;)
    {
      long l;
      if (i < this.barrages.size())
      {
        l = ((Barrage)this.barrages.get(i)).time * 1000L;
        if (l <= paramLong) {}
      }
      else
      {
        this.lastUpdateTime = paramLong;
        if ((localLinkedList.size() <= 0) && (this.transientBarrages.size() <= 0)) {
          break;
        }
        showBarrage(localLinkedList);
        return;
      }
      this.lastShowBarrageIndex += 1;
      if (paramLong - l < 400L) {
        localLinkedList.add(Integer.valueOf(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.danmu.BarrageView
 * JD-Core Version:    0.7.0.1
 */