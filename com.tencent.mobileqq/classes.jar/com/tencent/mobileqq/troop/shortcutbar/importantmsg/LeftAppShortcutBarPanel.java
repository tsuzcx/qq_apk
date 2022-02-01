package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class LeftAppShortcutBarPanel
  extends ILeftAppShortBarDataUI
{
  protected ArrayList<ShortcutBarInfo> a;
  protected boolean b = false;
  protected boolean c = false;
  protected AppRuntime d;
  protected Context e;
  protected View.OnClickListener f = new LeftAppShortcutBarPanel.1(this);
  protected View.OnClickListener g = new LeftAppShortcutBarPanel.2(this);
  protected PopupWindow.OnDismissListener h = new LeftAppShortcutBarPanel.3(this);
  protected ViewTreeObserver.OnGlobalLayoutListener i = new LeftAppShortcutBarPanel.4(this);
  private AIOShortcutBarContext j;
  private AppShortcutBarScrollView k;
  private LinearLayout l;
  private LinearLayout m;
  private LinearLayout n;
  private TroopAppShortcutBarHelper o;
  private boolean p = false;
  private View q;
  private PopupMoreListDialog r;
  private ImportantMessageReporter s;
  
  public LeftAppShortcutBarPanel(AIOShortcutBarContext paramAIOShortcutBarContext, AppShortcutBarScrollView paramAppShortcutBarScrollView, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper)
  {
    this.j = paramAIOShortcutBarContext;
    this.d = paramAIOShortcutBarContext.c();
    this.e = paramAIOShortcutBarContext.e();
    this.k = paramAppShortcutBarScrollView;
    this.l = ((LinearLayout)this.k.findViewById(2131439812));
    this.m = ((LinearLayout)this.l.findViewById(2131439802));
    this.n = ((LinearLayout)this.l.findViewById(2131439810));
    this.o = paramTroopAppShortcutBarHelper;
    this.s = new ImportantMessageReporter(this, paramAIOShortcutBarContext, this.o);
  }
  
  private void a(View paramView, ImportantMsgInfo paramImportantMsgInfo, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    paramView.setTag(paramImportantMsgInfo);
    paramView.setOnClickListener(this.f);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.d);
    paramImportantMsgInfo = (TextView)paramView.findViewById(2131445873);
    if (bool) {
      paramImportantMsgInfo.setTextColor(Color.parseColor("#ffffff"));
    } else {
      paramImportantMsgInfo.setTextColor(Color.parseColor("#1C1D1E"));
    }
    paramImportantMsgInfo = (LinearLayout)paramView.findViewById(2131445870);
    if (bool) {
      paramImportantMsgInfo.setBackgroundDrawable(this.e.getResources().getDrawable(2130838710));
    } else {
      paramImportantMsgInfo.setBackgroundDrawable(this.e.getResources().getDrawable(2130838709));
    }
    paramImportantMsgInfo = (ImageView)paramView.findViewById(2131445871);
    if (bool) {
      paramImportantMsgInfo.setColorFilter(1996488704);
    } else {
      paramImportantMsgInfo.setColorFilter(0);
    }
    paramView = (TextView)paramView.findViewById(2131445858);
    paramView.setVisibility(0);
    paramView.setText(String.valueOf(paramArrayList.size()));
    paramView.setBackgroundResource(2130847875);
  }
  
  private void a(ShortcutBarInfo paramShortcutBarInfo, View paramView)
  {
    paramView.setTag(paramShortcutBarInfo);
    paramView.setOnClickListener(this.f);
    boolean bool2 = ThemeUtil.isInNightMode(this.d);
    Object localObject = (TextView)paramView.findViewById(2131445867);
    ((TextView)localObject).setText(paramShortcutBarInfo.e());
    ((TextView)localObject).setContentDescription(paramShortcutBarInfo.e());
    if (bool2) {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
    } else {
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
    }
    localObject = (LinearLayout)paramView.findViewById(2131445865);
    if (bool2) {
      ((LinearLayout)localObject).setBackgroundDrawable(this.e.getResources().getDrawable(2130838710));
    } else {
      ((LinearLayout)localObject).setBackgroundDrawable(this.e.getResources().getDrawable(2130838709));
    }
    localObject = (URLImageView)paramView.findViewById(2131445866);
    if (bool2) {
      ((URLImageView)localObject).setColorFilter(1996488704);
    } else {
      ((URLImageView)localObject).setColorFilter(0);
    }
    Context localContext = this.e;
    String str = paramShortcutBarInfo.f();
    int i1 = paramShortcutBarInfo.g();
    boolean bool1 = true;
    if (i1 != 1) {
      bool1 = false;
    }
    TroopAppShortcutUtils.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
    paramView = (ImageView)paramView.findViewById(2131445864);
    if (!paramShortcutBarInfo.a())
    {
      paramView.setVisibility(8);
      return;
    }
    if (bool2) {
      paramView.setColorFilter(1996488704);
    } else {
      paramView.setColorFilter(0);
    }
    paramView.setTag(paramShortcutBarInfo);
    paramView.setOnClickListener(this.g);
    paramView.setContentDescription("关闭");
  }
  
  private void a(ImportantMsgInfo paramImportantMsgInfo, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (paramImportantMsgInfo == null) {
      return;
    }
    this.a = paramArrayList;
    try
    {
      View localView = View.inflate(this.e, 2131627902, null);
      a(localView, paramImportantMsgInfo, paramArrayList);
      this.q = localView;
      this.n.addView(localView);
      if ((this.q != null) && (this.b))
      {
        this.b = false;
        this.s.a();
      }
      paramImportantMsgInfo = this.q;
      if (paramImportantMsgInfo != null) {
        paramImportantMsgInfo.getViewTreeObserver().addOnGlobalLayoutListener(this.i);
      }
      return;
    }
    catch (InflateException paramImportantMsgInfo)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:");
        paramArrayList.append(paramImportantMsgInfo.getMessage());
        QLog.e("LeftAppShortcutBarPanel", 2, paramArrayList.toString());
      }
      System.gc();
      return;
    }
    catch (OutOfMemoryError paramImportantMsgInfo)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:");
        paramArrayList.append(paramImportantMsgInfo.getMessage());
        QLog.e("LeftAppShortcutBarPanel", 2, paramArrayList.toString());
      }
      System.gc();
    }
  }
  
  private void b(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    Object localObject1 = this.n;
    if ((localObject1 != null) && (this.m != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (paramArrayList == null) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      boolean bool = false;
      int i1 = 1;
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (ShortcutBarInfo)paramArrayList.next();
        try
        {
          if (this.s != null) {
            this.s.b(Long.valueOf(((ShortcutBarInfo)localObject2).b()), Long.valueOf(((ShortcutBarInfo)localObject2).d()));
          }
          localObject1 = View.inflate(this.j.e(), 2131627901, null);
          a((ShortcutBarInfo)localObject2, (View)localObject1);
          this.n.addView((View)localObject1);
          int i2 = i1;
          if (i1 != 0)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.dip2px(14.0F), 0, 0, 0);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            i2 = 0;
          }
          bool = true;
          i1 = i2;
        }
        catch (InflateException paramArrayList)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:");
            ((StringBuilder)localObject1).append(paramArrayList.getMessage());
            QLog.e("LeftAppShortcutBarPanel", 2, ((StringBuilder)localObject1).toString());
          }
          System.gc();
          return;
        }
        catch (OutOfMemoryError paramArrayList)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:");
            ((StringBuilder)localObject1).append(paramArrayList.getMessage());
            QLog.e("LeftAppShortcutBarPanel", 2, ((StringBuilder)localObject1).toString());
          }
          System.gc();
          return;
        }
      }
      this.p = bool;
      if (bool) {
        this.o.m();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LeftAppShortcutBarPanel", 2, "updateMessageShortcutPanel. messageShortcutPanel is null.");
    }
  }
  
  private void c(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if ((!this.c) && (this.o != null))
    {
      if (this.h == null) {
        return;
      }
      Object localObject = this.r;
      if ((localObject == null) || ((localObject != null) && (!((PopupMoreListDialog)localObject).c())))
      {
        this.r = new PopupMoreListDialog(this.j, this.o, this.h, this.s);
        this.r.a();
      }
      this.r.a(paramArrayList);
      if (this.r.c())
      {
        paramArrayList = this.q;
        if (paramArrayList != null)
        {
          localObject = new int[2];
          paramArrayList.getLocationOnScreen((int[])localObject);
          int i1;
          if (this.r.f() > 5) {
            i1 = ViewUtils.dip2px(247.0F);
          } else {
            i1 = ViewUtils.dip2px(this.r.f() * 40 + 7);
          }
          this.r.a(this.q, localObject[0] - ViewUtils.dip2px(175.0F) / 2, localObject[1] - i1 - 5, ViewUtils.dip2px(175.0F), i1);
        }
      }
    }
  }
  
  public void a()
  {
    ImportantMessageReporter localImportantMessageReporter = this.s;
    if (localImportantMessageReporter != null)
    {
      localImportantMessageReporter.c();
      this.s.d();
    }
    this.j = null;
    this.q = null;
    this.p = false;
    this.o = null;
    this.m = null;
    this.k = null;
    this.l = null;
    this.n = null;
    this.i = null;
    this.h = null;
    this.c = true;
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.j != null)
    {
      if (this.k == null) {
        return;
      }
      int i1 = 0;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        this.p = false;
        if ((paramArrayList.size() > 3) && (this.m.getChildCount() > 0))
        {
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          while (i1 < paramArrayList.size())
          {
            if (i1 < 2) {
              ((ArrayList)localObject).add(paramArrayList.get(i1));
            } else {
              localArrayList.add(paramArrayList.get(i1));
            }
            i1 += 1;
          }
          b((ArrayList)localObject);
          a(new ImportantMsgInfo(0L, 0L, "更多", "", "", 0L, 0), localArrayList);
          return;
        }
        Object localObject = this.r;
        if ((localObject != null) && (((PopupMoreListDialog)localObject).c())) {
          this.r.e();
        }
        b(paramArrayList);
        return;
      }
      this.n.removeAllViews();
      if (this.m.getChildCount() == 0) {
        this.o.o();
      }
      this.p = false;
    }
  }
  
  public void b()
  {
    this.b = true;
  }
  
  public void c()
  {
    PopupMoreListDialog localPopupMoreListDialog = this.r;
    if (localPopupMoreListDialog != null) {
      localPopupMoreListDialog.b();
    }
  }
  
  public void d() {}
  
  public boolean e()
  {
    return this.p;
  }
  
  public void f()
  {
    if ((this.n != null) && (this.k != null))
    {
      Object localObject1 = this.d;
      if (localObject1 != null)
      {
        if (this.o == null) {
          return;
        }
        if (((TroopManager)((AppRuntime)localObject1).getManager(QQManagerFactory.TROOP_MANAGER)).f(this.o.v()) == null) {
          return;
        }
        localObject1 = new Rect();
        this.k.getHitRect((Rect)localObject1);
        int i1 = 0;
        while (i1 < this.n.getChildCount())
        {
          Object localObject2 = this.n.getChildAt(i1);
          if ((localObject2 != null) && (((View)localObject2).getLocalVisibleRect((Rect)localObject1)))
          {
            localObject2 = ((View)localObject2).getTag();
            if ((localObject2 instanceof ImportantMsgInfo))
            {
              localObject2 = (ImportantMsgInfo)localObject2;
              if (localObject2 != null)
              {
                ImportantMessageReporter localImportantMessageReporter = this.s;
                if (localImportantMessageReporter != null) {
                  localImportantMessageReporter.c(Long.valueOf(((ImportantMsgInfo)localObject2).b()), Long.valueOf(((ImportantMsgInfo)localObject2).d()));
                }
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public int g()
  {
    LinearLayout localLinearLayout = this.m;
    int i2 = 2;
    int i1 = i2;
    if (localLinearLayout != null)
    {
      i1 = i2;
      if (this.k.getChildCount() > 0) {
        i1 = 1;
      }
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel
 * JD-Core Version:    0.7.0.1
 */