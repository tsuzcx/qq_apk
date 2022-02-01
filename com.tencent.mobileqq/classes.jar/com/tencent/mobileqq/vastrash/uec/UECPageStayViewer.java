package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class UECPageStayViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  private ListView a;
  private UECPageStayViewer.TableQueryAdapter b;
  private Button c;
  private Button d;
  private RelativeLayout e;
  private WindowManager f;
  private UECPageStayViewer g;
  private boolean h = false;
  private int i;
  private ArrayList<QQStayTimeInfo> j = new ArrayList();
  
  public UECPageStayViewer(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131627860, this);
    this.f = ((WindowManager)paramContext.getSystemService("window"));
    this.a = ((ListView)findViewById(2131446768));
    this.c = ((Button)findViewById(2131435040));
    this.d = ((Button)findViewById(2131430754));
    this.e = ((RelativeLayout)findViewById(2131432162));
    this.b = new UECPageStayViewer.TableQueryAdapter(this);
    this.a.setAdapter(this.b);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g = this;
    this.e.setOnTouchListener(new UECPageStayViewer.1(this));
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new UECPageStayViewer.2(this));
  }
  
  public void a()
  {
    this.j.clear();
    this.b.notifyDataSetChanged();
  }
  
  public void a(ArrayList<QQStayTimeInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQStayTimeInfo localQQStayTimeInfo = (QQStayTimeInfo)paramArrayList.next();
      this.j.add(0, localQQStayTimeInfo);
    }
    b();
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2131430754)
    {
      if (k == 2131435040) {
        UECPageStayController.a().b();
      }
    }
    else {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayViewer
 * JD-Core Version:    0.7.0.1
 */