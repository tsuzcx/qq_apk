package com.tencent.mobileqq.kandian.biz.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class RIJTabFrameDeliverPopupUtil
{
  private static int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  @VisibleForTesting
  public static int a(@NotNull Context paramContext, List<PopupMenuDialog.MenuItem> paramList)
  {
    int i = a(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localMenuItem.title)) + a(71.0F, paramContext.getResources());
      if (j > i) {
        i = j;
      }
    }
    return i;
  }
  
  private static PopupMenuDialog.MenuItem a(int paramInt, String paramString, Drawable paramDrawable)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = paramInt;
    localMenuItem.title = paramString;
    localMenuItem.drawable = paramDrawable;
    return localMenuItem;
  }
  
  @VisibleForTesting
  public static PopupMenuDialog a(Frame paramFrame, List<PopupMenuDialog.MenuItem> paramList, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2130842932;
    } else {
      i = 2130839517;
    }
    int j;
    if (paramBoolean) {
      j = 2131755036;
    } else {
      j = 2131755035;
    }
    return PopupMenuDialog.build(paramFrame.a(), paramList, new RIJTabFrameDeliverPopupUtil.1(paramFrame), new RIJTabFrameDeliverPopupUtil.2(), a(paramFrame.a(), paramList), false, i, j);
  }
  
  @VisibleForTesting
  public static List<PopupMenuDialog.MenuItem> a(Frame paramFrame)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramFrame, ReadInJoyHelper.m(paramFrame.a), localArrayList);
    if (localArrayList.size() == 0) {
      a(paramFrame, 31, localArrayList);
    }
    return localArrayList;
  }
  
  public static void a()
  {
    a("0X800AC6C", 0);
  }
  
  private static void a(Frame paramFrame, int paramInt, List<PopupMenuDialog.MenuItem> paramList)
  {
    Drawable localDrawable;
    if (RIJUgcUtils.g())
    {
      localDrawable = paramFrame.a().getDrawable(2130842951).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, RIJUgcUtils.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (RIJUgcUtils.a(paramInt))
    {
      localDrawable = paramFrame.a().getDrawable(2130842952).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131717883), localDrawable));
    }
    if (RIJUgcUtils.h())
    {
      localDrawable = paramFrame.a().getDrawable(2130843153).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, RIJUgcUtils.b(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (RIJUgcUtils.i())
    {
      localDrawable = paramFrame.a().getDrawable(2130843156).mutate();
      if (ThemeUtil.isInNightMode(paramFrame.a)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, RIJUgcUtils.c(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  public static void a(Frame paramFrame, View paramView, boolean paramBoolean)
  {
    a(paramFrame, a(paramFrame), paramBoolean).showAsDropDown(paramView, paramView.getWidth() - paramFrame.a().getResources().getDimensionPixelSize(2131298902) - paramFrame.a().getResources().getDimensionPixelSize(2131298898) + a(40.0F, paramFrame.a().getResources()), paramFrame.a().getResources().getDimensionPixelSize(2131298214));
    a();
  }
  
  public static void a(String paramString, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    ((IReadInJoyCaptureLauncher)QRoute.api(IReadInJoyCaptureLauncher.class)).launchFromNative(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772281, 2130772067);
  }
  
  private static void c()
  {
    a("0X800AC6E", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJTabFrameDeliverPopupUtil
 * JD-Core Version:    0.7.0.1
 */