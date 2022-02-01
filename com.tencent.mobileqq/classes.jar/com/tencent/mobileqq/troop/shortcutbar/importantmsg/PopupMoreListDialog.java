package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class PopupMoreListDialog
{
  private AIOShortcutBarContext a;
  private ArrayList<ShortcutBarInfo> b;
  private PopupWindow c;
  private OverScrollRecyclerView d;
  private CommonAdapter e;
  private View f;
  private TroopAppShortcutBarHelper g;
  private ImportantMessageReporter h;
  private ImageView i;
  private PopupWindow.OnDismissListener j;
  private WindowManager.LayoutParams k;
  private View l;
  private Activity m;
  private AppRuntime n;
  private Context o;
  
  public PopupMoreListDialog(AIOShortcutBarContext paramAIOShortcutBarContext, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper, PopupWindow.OnDismissListener paramOnDismissListener, ImportantMessageReporter paramImportantMessageReporter)
  {
    this.a = paramAIOShortcutBarContext;
    this.g = paramTroopAppShortcutBarHelper;
    this.j = paramOnDismissListener;
    this.h = paramImportantMessageReporter;
    this.m = paramAIOShortcutBarContext.f();
    this.n = paramAIOShortcutBarContext.c();
    this.o = paramAIOShortcutBarContext.e();
  }
  
  private void a(ViewHolder paramViewHolder, ShortcutBarInfo paramShortcutBarInfo, int paramInt)
  {
    if ((paramViewHolder != null) && (paramShortcutBarInfo != null))
    {
      if (!(paramShortcutBarInfo instanceof ShortcutBarInfo)) {
        return;
      }
      Object localObject = (ShortcutBarMoreListHolder)paramViewHolder;
      ((ShortcutBarMoreListHolder)localObject).e = paramShortcutBarInfo;
      paramViewHolder = this.h;
      if (paramViewHolder != null) {
        paramViewHolder.a(Long.valueOf(paramShortcutBarInfo.b()), Long.valueOf(paramShortcutBarInfo.d()));
      }
      boolean bool2 = ThemeUtil.isInNightMode(this.n);
      boolean bool1 = true;
      if (paramInt == 0)
      {
        if (bool2) {
          ((ShortcutBarMoreListHolder)localObject).a.setBackgroundDrawable(this.o.getResources().getDrawable(2130841681));
        } else {
          ((ShortcutBarMoreListHolder)localObject).a.setBackgroundDrawable(this.o.getResources().getDrawable(2130841680));
        }
      }
      else if (paramInt == this.b.size() - 1)
      {
        if (bool2) {
          ((ShortcutBarMoreListHolder)localObject).a.setBackgroundDrawable(this.o.getResources().getDrawable(2130841683));
        } else {
          ((ShortcutBarMoreListHolder)localObject).a.setBackgroundDrawable(this.o.getResources().getDrawable(2130841682));
        }
      }
      else if (bool2) {
        ((ShortcutBarMoreListHolder)localObject).a.setBackgroundDrawable(this.o.getResources().getDrawable(2130841685));
      } else {
        ((ShortcutBarMoreListHolder)localObject).a.setBackgroundDrawable(this.o.getResources().getDrawable(2130841684));
      }
      if (bool2)
      {
        ((ShortcutBarMoreListHolder)localObject).d.setTextColor(Color.parseColor("#ffffff"));
        ((ShortcutBarMoreListHolder)localObject).b.setColorFilter(1996488704);
        ((ShortcutBarMoreListHolder)localObject).c.setColorFilter(1996488704);
      }
      else
      {
        ((ShortcutBarMoreListHolder)localObject).d.setTextColor(Color.parseColor("#1C1D1E"));
      }
      ((ShortcutBarMoreListHolder)localObject).d.setText(paramShortcutBarInfo.e());
      ((ShortcutBarMoreListHolder)localObject).c.setTag(paramShortcutBarInfo);
      ((ShortcutBarMoreListHolder)localObject).itemView.setTag(paramShortcutBarInfo);
      ((ShortcutBarMoreListHolder)localObject).c.setContentDescription("关闭");
      ((ShortcutBarMoreListHolder)localObject).c.setOnClickListener(new PopupMoreListDialog.5(this));
      paramViewHolder = this.o;
      localObject = ((ShortcutBarMoreListHolder)localObject).b;
      String str = paramShortcutBarInfo.f();
      if (paramShortcutBarInfo.g() != 1) {
        bool1 = false;
      }
      TroopAppShortcutUtils.a(paramViewHolder, (ImageView)localObject, str, 19.0F, bool1);
    }
  }
  
  private void g()
  {
    if (this.k == null)
    {
      this.k = new WindowManager.LayoutParams();
      WindowManager.LayoutParams localLayoutParams = this.k;
      localLayoutParams.type = 1000;
      localLayoutParams.format = -3;
      localLayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localLayoutParams = this.k;
        localLayoutParams.flags |= 0x4000000;
      }
      localLayoutParams = this.k;
      int i2 = -1;
      localLayoutParams.width = -1;
      int i1 = i2;
      if (this.m.getWindow() != null)
      {
        i1 = i2;
        if (this.m.getWindow().getDecorView() != null)
        {
          i1 = this.m.getWindow().getDecorView().getHeight();
          if (i1 <= 0) {
            i1 = i2;
          }
        }
      }
      localLayoutParams = this.k;
      localLayoutParams.height = i1;
      localLayoutParams.windowAnimations = 2131952300;
    }
    if (this.l == null)
    {
      this.l = new View(this.m);
      this.l.setBackgroundColor(this.m.getResources().getColor(2131165797));
      this.l.setOnClickListener(new PopupMoreListDialog.1(this));
    }
  }
  
  private void h()
  {
    this.f = LayoutInflater.from(this.o).inflate(2131624133, null);
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout)((View)localObject).findViewById(2131448049);
    this.i = ((ImageView)this.f.findViewById(2131448052));
    this.d = ((OverScrollRecyclerView)this.f.findViewById(2131448050));
    this.d.setLayoutManager(new LinearLayoutManager(this.m, 1, false));
    if (ThemeUtil.isInNightMode(this.n)) {
      ((LinearLayout)localObject).setBackgroundDrawable(this.o.getResources().getDrawable(2130838710));
    } else {
      ((LinearLayout)localObject).setBackgroundDrawable(this.o.getResources().getDrawable(2130838709));
    }
    this.c = new PopupWindow(this.f, ViewUtils.dip2px(175.0F), -2, true);
    localObject = this.j;
    if (localObject != null) {
      this.c.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
    }
    this.d.addOnScrollListener(new PopupMoreListDialog.2(this));
  }
  
  private void i()
  {
    this.e = new PopupMoreListDialog.3(this, this.m, 2131629597);
    this.e.a(new PopupMoreListDialog.4(this));
  }
  
  private void j()
  {
    this.d.setAdapter(this.e);
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (!(localArrayList.get(0) instanceof ShortcutBarInfo)))
    {
      this.e.a(null);
      return;
    }
    this.e.b();
    this.e.a(this.b);
    this.e.notifyDataSetChanged();
  }
  
  public void a()
  {
    h();
    i();
    j();
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c != null)
    {
      Object localObject = this.i;
      if ((localObject != null) && (paramView != null))
      {
        localObject = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        if (localObject != null)
        {
          paramView.getLocationOnScreen(new int[2]);
          if (paramInt1 > this.c.getWidth() / 2) {
            ((LinearLayout.LayoutParams)localObject).leftMargin = (this.c.getWidth() / 2 + ViewUtils.dip2px(73.0F) / 2);
          } else {
            ((LinearLayout.LayoutParams)localObject).leftMargin = (ViewUtils.dip2px(73.0F) / 2 + paramInt1);
          }
          this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView = this.n;
          if (paramView != null) {
            if (ThemeUtil.isInNightMode(paramView)) {
              this.i.setColorFilter(-14934754);
            } else {
              this.i.setColorFilter(-1);
            }
          }
        }
        this.c.update(paramInt1, paramInt2, paramInt3, paramInt4);
        paramView = this.e;
        if (paramView != null) {
          paramView.notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.c != null)
    {
      Object localObject = this.d;
      if (localObject == null) {
        return;
      }
      this.b = paramArrayList;
      localObject = ((OverScrollRecyclerView)localObject).getLayoutParams();
      if (paramArrayList.size() > 5) {
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dip2px(247.0F);
      } else {
        ((ViewGroup.LayoutParams)localObject).height = -2;
      }
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramArrayList = this.e;
      if (paramArrayList != null)
      {
        paramArrayList.b();
        this.e.a(this.b);
        this.e.notifyDataSetChanged();
      }
    }
  }
  
  public void b()
  {
    PopupWindow localPopupWindow = this.c;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.c.dismiss();
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.c != null) && (this.i != null) && (paramView != null))
    {
      Object localObject1 = this.h;
      Object localObject2 = this.b;
      if (localObject2 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((ArrayList)localObject2).size();
      }
      ((ImportantMessageReporter)localObject1).a(paramInt1);
      localObject1 = (LinearLayout.LayoutParams)this.i.getLayoutParams();
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        paramView.getLocationOnScreen((int[])localObject2);
        if (paramInt3 > 0) {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = (localObject2[0] - paramInt3 + ViewUtils.dip2px(73.0F) / 2);
        } else {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = (localObject2[0] + ViewUtils.dip2px(73.0F) / 2);
        }
        this.i.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.n;
        if (localObject1 != null) {
          if (ThemeUtil.isInNightMode((AppRuntime)localObject1)) {
            this.i.setColorFilter(-14934754);
          } else {
            this.i.setColorFilter(-1);
          }
        }
      }
      if (LiuHaiUtils.b(this.m)) {
        ((ViewGroup)this.m.getWindow().getDecorView()).addView(this.l, this.k);
      } else {
        this.m.getWindowManager().addView(this.l, this.k);
      }
      this.c.showAtLocation(paramView, paramInt2, paramInt3, paramInt4);
      paramView = this.e;
      if (paramView != null) {
        paramView.notifyDataSetChanged();
      }
    }
  }
  
  public boolean c()
  {
    PopupWindow localPopupWindow = this.c;
    if (localPopupWindow != null) {
      return localPopupWindow.isShowing();
    }
    return false;
  }
  
  public void d()
  {
    try
    {
      if (LiuHaiUtils.b(this.m))
      {
        ((ViewGroup)this.m.getWindow().getDecorView()).removeView(this.l);
        return;
      }
      this.m.getWindowManager().removeView(this.l);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMoreListDialog", 2, localException.toString());
      }
    }
  }
  
  public void e()
  {
    try
    {
      if (LiuHaiUtils.b(this.m)) {
        ((ViewGroup)this.m.getWindow().getDecorView()).removeView(this.l);
      } else {
        this.m.getWindowManager().removeView(this.l);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMoreListDialog", 2, localException.toString());
      }
    }
    PopupWindow localPopupWindow = this.c;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  public int f()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog
 * JD-Core Version:    0.7.0.1
 */