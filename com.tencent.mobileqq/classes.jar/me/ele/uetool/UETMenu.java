package me.ele.uetool;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;
import me.ele.uetool.util.ViewKnife;

public class UETMenu
  extends LinearLayout
{
  private static final int DIFF = ViewKnife.dip2px(30.0F);
  private static final int R = ViewKnife.dip2px(48.0F);
  private ValueAnimator animator;
  private long curTime;
  private Interpolator defaultInterpolator = new AccelerateDecelerateInterpolator();
  private Handler hideHandler = new UETMenu.MyHandler(this);
  private List<UETSubMenu.IchangeStatus> ichangeStatusList = new ArrayList(8);
  private boolean isHide = false;
  private boolean isInit = true;
  private boolean isOpen = true;
  private ValueAnimator menuMoveToEdgeAnim;
  private WindowManager.LayoutParams params = new WindowManager.LayoutParams();
  private List<UETSubMenu.SubMenu> subMenus = new ArrayList();
  private int touchSlop;
  private View vMenu;
  private ViewGroup vSubMenuContainer;
  private int width = 0;
  private WindowManager windowManager;
  private int y;
  
  public UETMenu(Context paramContext, int paramInt)
  {
    super(paramContext);
    inflate(paramContext, JarResource.getIdByName("layout", "qb_uet_menu_layout"), this);
    setGravity(16);
    this.y = paramInt;
    this.touchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.vMenu = findViewById(JarResource.getIdByName("id", "menu"));
    this.vSubMenuContainer = ((ViewGroup)findViewById(JarResource.getIdByName("id", "sub_menu_container")));
    this.subMenus.add(new UETSubMenu.SubMenu("捕捉", JarResource.getIdByName("drawable", "qb_uet_edit_attr"), JarResource.getIdByName("drawable", "qb_uet_edit_attr_chosen"), new UETMenu.1(this)));
    this.subMenus.add(new UETSubMenu.SubMenu("相对位置", JarResource.getIdByName("drawable", "qb_uet_relative_position"), JarResource.getIdByName("drawable", "qb_uet_relative_position_chosen"), new UETMenu.2(this)));
    this.subMenus.add(new UETSubMenu.SubMenu("视图树", JarResource.getIdByName("drawable", "qb_uet_layers"), JarResource.getIdByName("drawable", "qb_uet_layers_chosen"), new UETMenu.3(this)));
    this.subMenus.add(new UETSubMenu.SubMenu("标尺", JarResource.getIdByName("drawable", "qb_uet_show_gridding"), JarResource.getIdByName("drawable", "qb_uet_show_gridding_chosen"), new UETMenu.4(this)));
    this.subMenus.add(new UETSubMenu.SubMenu("取色器", JarResource.getIdByName("drawable", "qb_uet_show_colorpicker"), JarResource.getIdByName("drawable", "qb_uet_show_colorpicker_chosen"), new UETMenu.5(this)));
    paramContext = this.subMenus.iterator();
    while (paramContext.hasNext())
    {
      UETSubMenu.SubMenu localSubMenu = (UETSubMenu.SubMenu)paramContext.next();
      UETSubMenu localUETSubMenu = new UETSubMenu(getContext());
      localUETSubMenu.update(localSubMenu);
      this.ichangeStatusList.add(localUETSubMenu.getChangeStatus());
      this.vSubMenuContainer.addView(localUETSubMenu);
    }
    this.vMenu.setOnClickListener(new UETMenu.6(this));
    this.vMenu.setOnTouchListener(new UETMenu.7(this));
    getViewTreeObserver().addOnGlobalLayoutListener(new UETMenu.8(this));
  }
  
  private void ensureAnim()
  {
    if (this.animator == null)
    {
      this.animator = ValueAnimator.ofInt(new int[] { -this.width, 0 });
      this.animator.addUpdateListener(new UETMenu.10(this));
      this.animator.setDuration(400L);
    }
  }
  
  private WindowManager.LayoutParams getWindowLayoutParams()
  {
    this.params.width = -2;
    this.params.height = -2;
    if (Build.VERSION.SDK_INT < 26) {}
    for (this.params.type = 2003;; this.params.type = 2038)
    {
      this.params.flags = 8;
      this.params.format = -3;
      this.params.gravity = 51;
      this.params.x = 10;
      this.params.y = this.y;
      return this.params;
    }
  }
  
  private void hide()
  {
    if ((this.isHide) || (!isAttachedToWindow())) {
      return;
    }
    try
    {
      this.params.alpha = 0.3F;
      int i = this.windowManager.getDefaultDisplay().getWidth();
      this.params.flags = 520;
      if ((this.params.x < 0) || ((this.params.x >= 0) && (this.params.x < i / 2))) {}
      for (this.params.x = (-DIFF);; this.params.x = (i - (R - DIFF))) {
        do
        {
          this.windowManager.updateViewLayout(this, this.params);
          this.isHide = true;
          return;
        } while ((this.params.x >= i) || (this.params.x <= i / 2));
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void moveSmallImageToEdge()
  {
    int i = this.windowManager.getDefaultDisplay().getWidth();
    if (this.params.x < i / 2) {
      i = 0;
    }
    for (;;)
    {
      if ((this.menuMoveToEdgeAnim != null) && (this.menuMoveToEdgeAnim.isRunning())) {
        this.menuMoveToEdgeAnim.cancel();
      }
      this.menuMoveToEdgeAnim = ValueAnimator.ofInt(new int[] { this.params.x, i });
      this.menuMoveToEdgeAnim.setDuration(300L);
      this.menuMoveToEdgeAnim.setInterpolator(new AccelerateDecelerateInterpolator());
      this.menuMoveToEdgeAnim.addUpdateListener(new UETMenu.11(this));
      this.menuMoveToEdgeAnim.start();
      return;
      i -= R;
    }
  }
  
  private void open()
  {
    open(-1);
  }
  
  private void open(int paramInt)
  {
    Activity localActivity = Util.getCurrentActivity();
    if (localActivity == null) {}
    do
    {
      return;
      if (localActivity.getClass() != TransparentActivity.class) {
        break;
      }
      if ((UETool.getInstance().getCurrentType() == 4) && (paramInt == 1))
      {
        changeStatus(paramInt, true);
        UETool.getInstance().setBaseLineView(((TransparentActivity)localActivity).getBaseLineView());
        localActivity = UETool.getInstance().getTargetActivity();
        localIntent = new Intent(localActivity, TransparentActivity.class);
        localIntent.putExtra("extra_type", paramInt);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(0, 0);
        UETool.getInstance().setCurrentType(paramInt);
        return;
      }
      changeStatus(paramInt, false);
      localActivity.finish();
    } while (UETool.getInstance().getBaseLineView() == null);
    UETool.getInstance().setBaseLineView(null);
    return;
    changeStatus(paramInt, true);
    UETool.getInstance().setTargetActivity(localActivity);
    UETool.getInstance().setCurrentType(paramInt);
    Intent localIntent = new Intent(localActivity, TransparentActivity.class);
    localIntent.putExtra("extra_type", paramInt);
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(0, 0);
  }
  
  private void startAnim()
  {
    ensureAnim();
    boolean bool2 = this.isOpen;
    boolean bool1;
    ValueAnimator localValueAnimator;
    if (!bool2)
    {
      bool1 = true;
      this.isOpen = bool1;
      localValueAnimator = this.animator;
      if (!bool2) {
        break label77;
      }
    }
    label77:
    for (Object localObject = this.defaultInterpolator;; localObject = new UETMenu.ReverseInterpolator(this.defaultInterpolator))
    {
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      this.animator.removeAllListeners();
      this.animator.addListener(new UETMenu.9(this, bool2));
      this.animator.start();
      return;
      bool1 = false;
      break;
    }
  }
  
  private void unHide()
  {
    this.params.alpha = 1.0F;
    this.params.flags = 8;
    this.windowManager.updateViewLayout(this, this.params);
    this.isHide = false;
  }
  
  public void changeStatus(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ((UETSubMenu.IchangeStatus)this.ichangeStatusList.get(0)).changeStatus(paramBoolean);
      return;
    case 2: 
      ((UETSubMenu.IchangeStatus)this.ichangeStatusList.get(1)).changeStatus(paramBoolean);
      return;
    case 3: 
      ((UETSubMenu.IchangeStatus)this.ichangeStatusList.get(2)).changeStatus(paramBoolean);
      return;
    case 4: 
      ((UETSubMenu.IchangeStatus)this.ichangeStatusList.get(3)).changeStatus(paramBoolean);
      return;
    }
    ((UETSubMenu.IchangeStatus)this.ichangeStatusList.get(4)).changeStatus(paramBoolean);
  }
  
  public int dismiss()
  {
    try
    {
      this.windowManager.removeView(this);
      return this.params.y;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void show()
  {
    try
    {
      this.windowManager.addView(this, getWindowLayoutParams());
      hide();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETMenu
 * JD-Core Version:    0.7.0.1
 */