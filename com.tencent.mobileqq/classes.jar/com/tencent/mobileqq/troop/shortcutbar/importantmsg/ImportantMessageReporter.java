package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ImportantMessageReporter
{
  private LeftAppShortcutBarPanel a;
  private AIOShortcutBarContext b;
  private TroopAppShortcutBarHelper c;
  private HashSet<Long> d = new HashSet();
  private HashSet<Long> e = new HashSet();
  private HashMap<Long, Long> f = new HashMap();
  private HashMap<Long, Long> g = new HashMap();
  private HashMap<Long, Long> h = new HashMap();
  private HashMap<Long, Long> i = new HashMap();
  
  public ImportantMessageReporter(ILeftAppShortBarDataUI paramILeftAppShortBarDataUI, AIOShortcutBarContext paramAIOShortcutBarContext, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper)
  {
    this.a = ((LeftAppShortcutBarPanel)paramILeftAppShortBarDataUI);
    this.b = paramAIOShortcutBarContext;
    this.c = paramTroopAppShortcutBarHelper;
  }
  
  private int a(long paramLong)
  {
    if (this.d.contains(Long.valueOf(paramLong))) {
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    TroopAppShortcutBarHelper localTroopAppShortcutBarHelper = this.c;
    if (localTroopAppShortcutBarHelper != null)
    {
      if (this.a == null) {
        return;
      }
      ReportController.b(null, "dc00898", "", localTroopAppShortcutBarHelper.v(), "0X800B19D", "0X800B19D", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt)
  {
    TroopAppShortcutBarHelper localTroopAppShortcutBarHelper = this.c;
    if (localTroopAppShortcutBarHelper != null)
    {
      if (this.a == null) {
        return;
      }
      ReportController.b(null, "dc00898", "", localTroopAppShortcutBarHelper.v(), "0X800B19E", "0X800B19E", 0, 0, "", "", String.valueOf(paramInt), "");
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.c != null)
    {
      if (this.a == null) {
        return;
      }
      String str;
      if (paramInt == 1) {
        str = "0X800B19F";
      } else {
        str = "0X800B19A";
      }
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ShortcutBarInfo)))
      {
        paramView = (ShortcutBarInfo)paramView.getTag();
        ReportController.b(null, "dc00898", "", this.c.v(), str, str, 0, 0, String.valueOf(paramView.d()), "", String.valueOf(this.a.g()), "");
        this.d.add(Long.valueOf(paramView.d()));
      }
    }
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    this.f.put(paramLong1, paramLong2);
    this.i.put(paramLong1, paramLong2);
  }
  
  public void b()
  {
    if ((this.f.size() != 0) && (this.c != null))
    {
      if (this.a == null) {
        return;
      }
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong != null) && (!this.e.contains(localLong)))
        {
          this.e.add(localLong);
          ReportController.b(null, "dc00898", "", this.c.v(), "0X800B199", "0X800B199", 0, 0, String.valueOf(localLong), "", "", "");
        }
      }
      this.f.clear();
    }
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.c != null)
    {
      if (this.a == null) {
        return;
      }
      String str;
      if (paramInt == 0) {
        str = "0X800B19C";
      } else {
        str = "0X800B1A0";
      }
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ShortcutBarInfo)))
      {
        paramView = (ShortcutBarInfo)paramView.getTag();
        ReportController.b(null, "dc00898", "", this.c.v(), str, str, 0, 0, String.valueOf(paramView.d()), String.valueOf(this.a.g()), String.valueOf(a(paramView.b())), "");
        this.d.add(Long.valueOf(paramView.b()));
      }
    }
  }
  
  public void b(Long paramLong1, Long paramLong2)
  {
    this.g.put(paramLong1, paramLong2);
    this.i.put(paramLong1, paramLong2);
  }
  
  public void c()
  {
    if ((this.g.size() != 0) && (this.c != null))
    {
      if (this.a == null) {
        return;
      }
      Iterator localIterator = this.h.values().iterator();
      String str = "";
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(";");
          localStringBuilder.append(String.valueOf(localLong));
          str = localStringBuilder.toString();
        }
      }
      ReportController.b(null, "dc00898", "", this.c.v(), "0X800B198", "0X800B198", 0, 0, String.valueOf(this.h.size()), String.valueOf(this.a.g()), str, String.valueOf(this.i.size()));
      this.h.clear();
      this.i.clear();
    }
  }
  
  public void c(Long paramLong1, Long paramLong2)
  {
    this.h.put(paramLong1, paramLong2);
  }
  
  public void d()
  {
    this.d.clear();
    this.e.clear();
    this.c = null;
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMessageReporter
 * JD-Core Version:    0.7.0.1
 */