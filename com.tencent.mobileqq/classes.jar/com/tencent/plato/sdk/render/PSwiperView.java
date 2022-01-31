package com.tencent.plato.sdk.render;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.AssertUtil;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.render.adapter.SwiperBaseAdapter;
import com.tencent.plato.sdk.render.data.BlockElementData;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.ColorUtils;
import com.tencent.plato.sdk.utils.DeviceInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class PSwiperView
  extends PBlockView
{
  private static final String TAG = "PSwiperView";
  private boolean needScrollTo = false;
  
  private void paresChildEvent(final BlockElementData paramBlockElementData, IPView paramIPView)
  {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.offer(paramBlockElementData);
    localLinkedList2.offer(paramIPView);
    while ((!localLinkedList1.isEmpty()) && (!localLinkedList2.isEmpty()))
    {
      paramBlockElementData = (BlockElementData)localLinkedList1.poll();
      paramIPView = (IPView)localLinkedList2.poll();
      if ((paramBlockElementData.getEvents() != null) && (paramBlockElementData.getEvents().contains("click"))) {
        paramIPView.getView().setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            PLog.d("PSwiperView", "onClick : " + paramBlockElementData.getElementId());
            PSwiperView.this.fireEvent(PSwiperView.this.getPageId(), paramBlockElementData.getElementId(), "click", null);
          }
        });
      }
      if ((paramBlockElementData.mChildren != null) && (paramBlockElementData.mChildren.size() > 0))
      {
        int i = 0;
        while (i < paramBlockElementData.mChildren.size())
        {
          localLinkedList1.offer(paramBlockElementData.mChildren.get(i));
          localLinkedList2.offer(paramIPView.getChild(i));
          i += 1;
        }
      }
    }
  }
  
  private IPView paresView(BlockElementData paramBlockElementData)
  {
    PLog.d("PSwiperView", "paresView");
    if (paramBlockElementData != null) {
      return PViewFactory.createView(getPlatoRuntime(), paramBlockElementData);
    }
    return null;
  }
  
  private void parseData()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new LinkedHashMap();
    Iterator localIterator = this.mBlockRoot.mChildren.iterator();
    while (localIterator.hasNext())
    {
      BlockElementData localBlockElementData = (BlockElementData)localIterator.next();
      if (localBlockElementData != null)
      {
        IPView localIPView = paresView(localBlockElementData);
        View localView = localIPView.getView();
        PLog.d("PSwiperView", "paresView");
        if (localView != null)
        {
          ((LinkedHashMap)localObject).put(Integer.valueOf(localBlockElementData.getElementId()), localView);
          paresChildEvent(localBlockElementData, localIPView);
        }
      }
    }
    localObject = ((LinkedHashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((Map.Entry)((Iterator)localObject).next()).getValue());
    }
    if (localArrayList.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.Assert(bool, "swiper data size error");
      ((Swiper)this.view).setData(localArrayList).start();
      return;
    }
  }
  
  public void attachEvent(List<String> paramList)
  {
    super.attachEvent(paramList);
    if ((paramList != null) && (paramList.contains("scrollto"))) {
      this.needScrollTo = true;
    }
  }
  
  public void createBlockFinish()
  {
    if (this.isDirty)
    {
      parseData();
      this.isDirty = false;
      return;
    }
    PLog.d("PSwiperView", "createBlockFinish return, data not changed!");
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    this.view = new Swiper(paramIPlatoRuntime.getContext());
    this.id = paramElementItem.getElementId();
  }
  
  protected void initBlock(int paramInt)
  {
    this.mBlockRoot = createData(null, paramInt, null);
    this.mBlockDatas = new HashMap();
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    if (this.view == null) {
      return;
    }
    boolean bool = paramIReadableMap.getBoolean("needDot", true);
    int i = paramIReadableMap.getInt("dotSize", DeviceInfo.width / 40);
    String str1 = paramIReadableMap.getString("dotColorOn", "#808080");
    String str2 = paramIReadableMap.getString("dotColorOff", "#FFFFFF");
    int j = paramIReadableMap.getInt("scrollTime", 2000);
    ((Swiper)this.view).setDotEnable(bool).setDotSize(i).setDotOnColor(str1).setDotOffColor(str2).setDelayTime(j);
  }
  
  public class Swiper
    extends FrameLayout
    implements ViewPager.OnPageChangeListener
  {
    private SwiperBaseAdapter adapter;
    private boolean autoPlay = true;
    private Handler autoPlayHandler = new Handler(Looper.getMainLooper());
    private RelativeLayout container;
    private int count = 0;
    private int currentPosition = 0;
    private int delayTime = 2000;
    private boolean dotEnable = true;
    private int dotGravity = 17;
    private List<ImageView> dotImages = new ArrayList();
    private LinearLayout dotLayout;
    private int dotMargin = 5;
    private String dotOffColor = "#808080";
    private GradientDrawable dotOffDrawable;
    private String dotOnColor = "#808080";
    private GradientDrawable dotOnDrawable;
    private int dotSize = DeviceInfo.width / 40;
    private int lastPosition = 0;
    private PSwiperView.SwiperScroller mScroller;
    private int realPosition = 0;
    private boolean scroll = true;
    private int scrollTime = 800;
    private List<View> showViews = new ArrayList();
    private final Runnable task = new Runnable()
    {
      public void run()
      {
        if ((PSwiperView.Swiper.this.count > 1) && (PSwiperView.Swiper.this.autoPlay))
        {
          PSwiperView.Swiper.this.viewPager.setCurrentItem(PSwiperView.Swiper.this.realPosition + 1);
          PSwiperView.Swiper.this.autoPlayHandler.postDelayed(PSwiperView.Swiper.this.task, PSwiperView.Swiper.this.delayTime);
        }
      }
    };
    private PSwiperView.SwiperViewPager viewPager;
    
    public Swiper(Context paramContext)
    {
      super();
      init(paramContext);
    }
    
    private void createDot(Context paramContext)
    {
      if (this.dotImages != null) {
        this.dotImages.clear();
      }
      if (this.dotLayout != null) {
        this.dotLayout.removeAllViews();
      }
      int i = 0;
      if (i < this.showViews.size())
      {
        ImageView localImageView = new ImageView(paramContext);
        localImageView.setContentDescription("dot-imageview");
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.dotSize, this.dotSize);
        localLayoutParams.leftMargin = this.dotMargin;
        localLayoutParams.rightMargin = this.dotMargin;
        if (i == 0) {
          localImageView.setImageDrawable(this.dotOnDrawable);
        }
        for (;;)
        {
          this.dotImages.add(localImageView);
          this.dotLayout.addView(localImageView, localLayoutParams);
          i += 1;
          break;
          localImageView.setImageDrawable(this.dotOffDrawable);
        }
      }
    }
    
    private GradientDrawable createDotDrawable(int paramInt1, int paramInt2)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(paramInt1);
      localGradientDrawable.setCornerRadius(paramInt2);
      localGradientDrawable.setShape(1);
      return localGradientDrawable;
    }
    
    private void createDotDrawable()
    {
      this.dotOnDrawable = createDotDrawable(ColorUtils.parseColor(this.dotOnColor), this.dotSize / 2);
      this.dotOffDrawable = createDotDrawable(ColorUtils.parseColor(this.dotOffColor), this.dotSize / 2);
    }
    
    private void init(Context paramContext)
    {
      this.container = new RelativeLayout(paramContext);
      this.container.setContentDescription("Swipe-container");
      this.viewPager = new PSwiperView.SwiperViewPager(PSwiperView.this, paramContext);
      this.viewPager.setContentDescription("Swipe-viewPager");
      this.dotLayout = new LinearLayout(paramContext);
      this.dotLayout.setContentDescription("Swipe-dotLayout");
      addView(this.container);
      paramContext = new RelativeLayout.LayoutParams(-1, -1);
      this.container.addView(this.viewPager, paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(12);
      this.dotLayout.setPadding(30, 30, 30, 30);
      this.container.addView(this.dotLayout, paramContext);
      initViewPagerScroll();
      this.viewPager.setOnPageChangeListener(this);
      this.adapter = new SwiperBaseAdapter();
    }
    
    private void initViewPagerScroll()
    {
      try
      {
        Field localField = ViewPager.class.getDeclaredField("mScroller");
        localField.setAccessible(true);
        this.mScroller = new PSwiperView.SwiperScroller(PSwiperView.this, this.viewPager.getContext());
        this.mScroller.setDuration(this.scrollTime);
        localField.set(this.viewPager, this.mScroller);
        return;
      }
      catch (Exception localException)
      {
        PLog.e("PSwiperView", "initViewPagerScroll error. " + Log.getStackTraceString(localException));
      }
    }
    
    private void setViewPager()
    {
      if (this.adapter == null)
      {
        this.adapter = new SwiperBaseAdapter();
        this.viewPager.setOnPageChangeListener(this);
      }
      this.currentPosition = 0;
      this.realPosition = 0;
      this.adapter.setViews(this.showViews);
      this.viewPager.setAdapter(this.adapter);
      this.viewPager.setFocusable(true);
      this.dotLayout.setGravity(this.dotGravity);
      if ((this.scroll) && (this.showViews.size() > 1)) {
        this.viewPager.setScrollable(true);
      }
      for (;;)
      {
        if (this.autoPlay) {
          startAutoPlay();
        }
        return;
        this.viewPager.setScrollable(false);
      }
    }
    
    public Swiper autoPlay(boolean paramBoolean)
    {
      this.autoPlay = paramBoolean;
      return this;
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      int i;
      if (this.autoPlay)
      {
        i = paramMotionEvent.getAction();
        if ((i != 1) && (i != 3) && (i != 4)) {
          break label37;
        }
        startAutoPlay();
      }
      for (;;)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        label37:
        if (i == 0) {
          stopAutoPlay();
        }
      }
    }
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      if (this.count > 2) {
        this.currentPosition = (paramInt % this.count);
      }
      for (;;)
      {
        if (PSwiperView.this.needScrollTo)
        {
          JSONWritableMap localJSONWritableMap = new JSONWritableMap();
          localJSONWritableMap.put("index", this.currentPosition);
          PSwiperView.this.fireEvent(PSwiperView.this.getPageId(), PSwiperView.this.id, "scrollto", localJSONWritableMap);
        }
        this.realPosition = paramInt;
        if ((this.dotImages != null) && (this.dotImages.size() > 0))
        {
          ((ImageView)this.dotImages.get(this.lastPosition)).setImageDrawable(this.dotOffDrawable);
          ((ImageView)this.dotImages.get(this.currentPosition)).setImageDrawable(this.dotOnDrawable);
        }
        this.lastPosition = this.currentPosition;
        return;
        if (paramInt % this.count == 1) {
          this.currentPosition = 1;
        } else {
          this.currentPosition = 0;
        }
      }
    }
    
    public Swiper setData(ArrayList<View> paramArrayList)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        if (this.showViews != null) {
          this.showViews.clear();
        }
        this.showViews = paramArrayList;
        this.count = paramArrayList.size();
      }
      return this;
    }
    
    public Swiper setDelayTime(int paramInt)
    {
      this.delayTime = paramInt;
      return this;
    }
    
    public Swiper setDotEnable(boolean paramBoolean)
    {
      this.dotEnable = paramBoolean;
      return this;
    }
    
    public Swiper setDotGravity(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return this;
      case 0: 
        this.dotGravity = 19;
        return this;
      case 1: 
        this.dotGravity = 17;
        return this;
      }
      this.dotGravity = 21;
      return this;
    }
    
    public Swiper setDotOffColor(String paramString)
    {
      this.dotOffColor = paramString;
      return this;
    }
    
    public Swiper setDotOnColor(String paramString)
    {
      this.dotOnColor = paramString;
      return this;
    }
    
    public Swiper setDotSize(int paramInt)
    {
      this.dotSize = paramInt;
      return this;
    }
    
    public Swiper setViewPagerScroll(boolean paramBoolean)
    {
      this.scroll = paramBoolean;
      return this;
    }
    
    public Swiper start()
    {
      createDotDrawable();
      if (this.dotEnable) {
        createDot(PSwiperView.this.getPlatoRuntime().getContext());
      }
      setViewPager();
      return this;
    }
    
    public void startAutoPlay()
    {
      this.autoPlayHandler.removeCallbacks(this.task);
      this.autoPlayHandler.postDelayed(this.task, this.delayTime);
    }
    
    public void stopAutoPlay()
    {
      this.autoPlayHandler.removeCallbacks(this.task);
    }
  }
  
  public class SwiperConfig
  {
    public static final boolean AUTO_PLAY = true;
    public static final int DELAY_TIME = 2000;
    public static final int DOT_CENTER = 1;
    public static final String DOT_COLOR_OFF = "#FFFFFF";
    public static final String DOT_COLOR_ON = "#808080";
    public static final boolean DOT_ENABLE = true;
    public static final int DOT_LEFT = 0;
    public static final int DOT_PADDING_SIZE = 5;
    public static final int DOT_RIGHT = 2;
    public static final int DURATION = 800;
    public static final boolean SCROLL = true;
    
    public SwiperConfig() {}
  }
  
  public class SwiperScroller
    extends Scroller
  {
    private int mDuration = 800;
    
    public SwiperScroller(Context paramContext)
    {
      super();
    }
    
    public SwiperScroller(Context paramContext, Interpolator paramInterpolator)
    {
      super(paramInterpolator);
    }
    
    public SwiperScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
    {
      super(paramInterpolator, paramBoolean);
    }
    
    public void setDuration(int paramInt)
    {
      this.mDuration = paramInt;
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
    }
  }
  
  public class SwiperViewPager
    extends ViewPager
  {
    private boolean scrollable = true;
    
    public SwiperViewPager(Context paramContext)
    {
      super();
    }
    
    public SwiperViewPager(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return (this.scrollable) && (super.onInterceptTouchEvent(paramMotionEvent));
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return (this.scrollable) && (super.onTouchEvent(paramMotionEvent));
    }
    
    public void setScrollable(boolean paramBoolean)
    {
      this.scrollable = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PSwiperView
 * JD-Core Version:    0.7.0.1
 */