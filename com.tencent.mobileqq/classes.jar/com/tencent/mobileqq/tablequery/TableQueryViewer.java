package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

public class TableQueryViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  private ListView a;
  private TableQueryViewer.TableQueryAdapter b;
  private TableQueryController c;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private boolean h = true;
  private boolean i = true;
  private HorizontalScrollView j;
  private LinearLayout k;
  private View l;
  private RelativeLayout m;
  private WindowManager n;
  private TableQueryViewer o;
  private boolean p;
  private int q;
  private List r;
  
  public TableQueryViewer(Context paramContext)
  {
    super(paramContext);
    int i1 = 0;
    this.p = false;
    this.r = new LinkedList();
    LayoutInflater.from(paramContext).inflate(2131629367, this);
    this.n = ((WindowManager)paramContext.getSystemService("window"));
    this.j = ((HorizontalScrollView)findViewById(2131442923));
    this.a = ((ListView)findViewById(2131446768));
    this.d = ((Button)findViewById(2131435040));
    this.e = ((Button)findViewById(2131430754));
    this.g = ((Button)findViewById(2131431967));
    Button localButton = this.g;
    Object localObject;
    if (TableQueryController.b) {
      localObject = paramContext.getString(2131887549);
    } else {
      localObject = paramContext.getString(2131887553);
    }
    localButton.setText((CharSequence)localObject);
    this.f = ((Button)findViewById(2131444363));
    localButton = this.f;
    if (TableQueryController.c) {
      localObject = paramContext.getString(2131887551);
    } else {
      localObject = paramContext.getString(2131887552);
    }
    localButton.setText((CharSequence)localObject);
    this.k = ((LinearLayout)findViewById(2131446770));
    this.k.setBackgroundColor(getResources().getColor(2131165558));
    while (i1 < this.k.getChildCount())
    {
      localObject = this.k.getChildAt(i1);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(1));
      }
      i1 += 1;
    }
    this.l = findViewById(2131444664);
    this.m = ((RelativeLayout)findViewById(2131432162));
    this.c = TableQueryController.a();
    this.b = new TableQueryViewer.TableQueryAdapter(this);
    this.a.setAdapter(this.b);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.o = this;
    this.a.setOnItemLongClickListener(new TableQueryViewer.1(this, paramContext));
    this.m.setOnTouchListener(new TableQueryViewer.2(this));
  }
  
  public void a()
  {
    this.r.clear();
    this.b.notifyDataSetChanged();
  }
  
  public void a(QueryData paramQueryData)
  {
    this.r.add(0, paramQueryData);
    this.b.notifyDataSetChanged();
  }
  
  public int b(QueryData paramQueryData)
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.r.size(); i2 = i3)
    {
      QueryData localQueryData = (QueryData)this.r.get(i1);
      i3 = i2;
      if (paramQueryData.b.contains(localQueryData.a))
      {
        this.r.set(i1, paramQueryData);
        this.b.notifyDataSetChanged();
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131444363: 
      if (TableQueryController.c)
      {
        this.f.setText(getContext().getString(2131887552));
        TableQueryController.c = false;
      }
      else
      {
        this.f.setText(getContext().getString(2131887551));
        TableQueryController.c = true;
      }
      break;
    case 2131435040: 
      if (this.i)
      {
        this.j.setVisibility(8);
        this.d.setText(getContext().getString(2131887559));
        this.j.setEnabled(false);
        this.i = false;
      }
      else
      {
        this.j.setVisibility(0);
        this.d.setText(getContext().getString(2131887550));
        this.j.setEnabled(true);
        this.i = true;
      }
      break;
    case 2131431967: 
      if (TableQueryController.b)
      {
        this.g.setText(getContext().getString(2131887553));
        TableQueryController.b = false;
      }
      else
      {
        this.g.setText(getContext().getString(2131887549));
        TableQueryController.b = true;
      }
      break;
    case 2131430754: 
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer
 * JD-Core Version:    0.7.0.1
 */