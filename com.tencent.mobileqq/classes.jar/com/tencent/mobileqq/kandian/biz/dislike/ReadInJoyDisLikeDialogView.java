package com.tencent.mobileqq.kandian.biz.dislike;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ReadInJoyDisLikeDialogView
  extends FrameLayout
  implements View.OnClickListener
{
  protected ArrayList<DislikeInfo> a;
  protected ArrayList<DislikeInfo> b;
  protected RelativeLayout c;
  protected Button d;
  protected Boolean e = Boolean.valueOf(true);
  protected int[] f = { 2131449107, 2131449108, 2131449109, 2131449110, 2131449111, 2131449112, 2131449113, 2131449114 };
  protected int[] g = { 2131449102, 2131449103, 2131449104, 2131449105 };
  protected ReadInJoyDisLikeDialogView.OnUninterestConfirmListener h;
  protected ReadInJoyDisLikeDialogView.OnComplainListener i;
  private Button[] j;
  private View[] k;
  private View l;
  private TextView m;
  private ImageView n;
  private RelativeLayout o;
  
  public ReadInJoyDisLikeDialogView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void b()
  {
    int i2 = this.a.size();
    Button[] arrayOfButton = this.j;
    int i1 = i2;
    if (i2 >= arrayOfButton.length) {
      i1 = arrayOfButton.length;
    }
    i2 = 0;
    while (i2 < i1)
    {
      if (TextUtils.isEmpty(((DislikeInfo)this.a.get(i2)).c))
      {
        this.j[i2].setVisibility(8);
      }
      else
      {
        this.j[i2].setVisibility(0);
        this.j[i2].setText(((DislikeInfo)this.a.get(i2)).c);
      }
      this.j[i2].setSelected(false);
      i2 += 1;
    }
    i2 = i1;
    int i3;
    for (;;)
    {
      arrayOfButton = this.j;
      int i4 = arrayOfButton.length;
      i3 = 1;
      if (i2 >= i4) {
        break;
      }
      if ((i2 == i1) && (i1 % 2 == 1)) {
        arrayOfButton[i2].setVisibility(4);
      } else {
        this.j[i2].setVisibility(8);
      }
      this.j[i2].setSelected(false);
      i2 += 1;
    }
    for (;;)
    {
      arrayOfButton = this.j;
      if (i3 >= arrayOfButton.length) {
        break;
      }
      if (arrayOfButton[i3].getVisibility() == 8) {
        this.k[(i3 / 2)].setVisibility(8);
      } else {
        this.k[(i3 / 2)].setVisibility(0);
      }
      i3 += 2;
    }
  }
  
  public void a()
  {
    this.h = null;
    this.i = null;
  }
  
  protected void a(Context paramContext)
  {
    this.l = LayoutInflater.from(paramContext).inflate(2131626142, this);
    this.o = ((RelativeLayout)this.l.findViewById(2131449100));
    this.o.setBackgroundColor(getResources().getColor(2131168464));
    this.n = ((ImageView)this.l.findViewById(2131449118));
    this.n.setVisibility(8);
    this.m = ((TextView)this.l.findViewById(2131449115));
    this.m.setText(paramContext.getString(2131897936));
    this.d = ((Button)this.l.findViewById(2131449097));
    this.d.setOnClickListener(this);
    paramContext = this.d;
    int i2 = 0;
    paramContext.setEnabled(false);
    this.c = ((RelativeLayout)this.l.findViewById(2131449099));
    this.c.setOnClickListener(this);
    this.c.setBackgroundColor(Color.parseColor("#FFF6F7FA"));
    this.j = new Button[this.f.length];
    int i1 = 0;
    for (;;)
    {
      paramContext = this.f;
      if (i1 >= paramContext.length) {
        break;
      }
      this.j[i1] = ((Button)this.l.findViewById(paramContext[i1]));
      this.j[i1].setOnClickListener(this);
      i1 += 1;
    }
    this.k = new View[this.g.length];
    i1 = i2;
    for (;;)
    {
      paramContext = this.g;
      if (i1 >= paramContext.length) {
        break;
      }
      this.k[i1] = this.l.findViewById(paramContext[i1]);
      i1 += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 == 2131449097)
    {
      localObject = this.h;
      if ((localObject == null) || (((ReadInJoyDisLikeDialogView.OnUninterestConfirmListener)localObject).a(paramView, this.b, null))) {
        a();
      }
    }
    else if (i1 == 2131449099)
    {
      localObject = this.i;
      if (localObject != null) {
        ((ReadInJoyDisLikeDialogView.OnComplainListener)localObject).a();
      }
      a();
    }
    else
    {
      i1 = 0;
      while (i1 < this.f.length)
      {
        if (paramView.getId() == this.f[i1]) {
          break label115;
        }
        i1 += 1;
      }
      i1 = -1;
      label115:
      if (i1 != -1)
      {
        if (this.j[i1].isSelected())
        {
          this.j[i1].setSelected(false);
          this.b.remove(this.a.get(i1));
        }
        else
        {
          if (!this.e.booleanValue())
          {
            localObject = this.j;
            int i3 = localObject.length;
            int i2 = 0;
            while (i2 < i3)
            {
              localObject[i2].setSelected(false);
              i2 += 1;
            }
            this.b.clear();
          }
          this.j[i1].setSelected(true);
          this.b.add(this.a.get(i1));
        }
        if (this.b.size() == 0) {
          this.d.setEnabled(false);
        } else {
          this.d.setEnabled(true);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnComplainListener(ReadInJoyDisLikeDialogView.OnComplainListener paramOnComplainListener)
  {
    this.i = paramOnComplainListener;
  }
  
  public void setOnUninterestConfirmListener(ReadInJoyDisLikeDialogView.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    this.h = paramOnUninterestConfirmListener;
  }
  
  public void setUninterestData(ArrayList<DislikeInfo> paramArrayList)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      this.b = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = this.a;
    if (localArrayList == null) {
      this.a = new ArrayList();
    } else {
      localArrayList.clear();
    }
    this.a.addAll(paramArrayList);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView
 * JD-Core Version:    0.7.0.1
 */