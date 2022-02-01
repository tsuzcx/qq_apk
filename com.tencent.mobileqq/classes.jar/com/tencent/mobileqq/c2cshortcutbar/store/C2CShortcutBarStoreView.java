package com.tencent.mobileqq.c2cshortcutbar.store;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutAppInfo;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutAppInfo.Label;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.qqexpand.widget.LabelTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class C2CShortcutBarStoreView
  extends DialogFromBottom
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  C2CShortcutBarObserver a = new C2CShortcutBarStoreView.3(this);
  private QQAppInterface b;
  private ViewGroup c;
  private View d;
  private ImageView e;
  private LinearLayout f;
  private RecyclerView g;
  private FormSwitchItem h;
  private C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter i;
  private List<C2CShortcutAppInfo> j;
  private IC2CShortcutBarStoreUIEvent k;
  private String l;
  private boolean m;
  private boolean n;
  private float o;
  private float p;
  private boolean q = true;
  private List<String> r = new ArrayList();
  
  protected C2CShortcutBarStoreView(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, List<C2CShortcutAppInfo> paramList, IC2CShortcutBarStoreUIEvent paramIC2CShortcutBarStoreUIEvent)
  {
    super(paramContext, 2131951677);
    this.b = paramQQAppInterface;
    this.k = paramIC2CShortcutBarStoreUIEvent;
    this.j = new ArrayList();
    if (paramList != null) {
      this.j.addAll(paramList);
    }
    this.l = paramString;
    this.m = paramBoolean1;
    this.n = paramBoolean2;
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<C2CShortcutAppInfo.Label> paramList)
  {
    paramLinearLayout.removeAllViews();
    int i4 = ViewUtils.dpToPx(12.0F);
    int i5 = ViewUtils.dpToPx(1.0F);
    int i6 = ViewUtils.dpToPx(8.0F);
    int i7 = ViewUtils.dpToPx(6.0F);
    Object localObject = new Paint();
    float f1 = 12;
    ((Paint)localObject).setTextSize(ViewUtils.dpToPx(f1));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i8 = paramList.size();
    int i3 = 0;
    int i2 = 0;
    int i1 = paramInt;
    paramInt = i2;
    while (paramInt < i8)
    {
      C2CShortcutAppInfo.Label localLabel = (C2CShortcutAppInfo.Label)paramList.get(paramInt);
      i2 = i1;
      if (localLabel != null)
      {
        i2 = i1;
        if (!TextUtils.isEmpty(localLabel.a))
        {
          i2 = (int)(((Paint)localObject).measureText(localLabel.a) + i6 * 2);
          if (i1 >= i2 + i7)
          {
            localArrayList.add(localLabel);
            i2 = i1 - i2 - i7;
          }
          else
          {
            if (paramInt != 0) {
              break;
            }
            localArrayList.add(localLabel);
            break;
          }
        }
      }
      paramInt += 1;
      i1 = i2;
    }
    i1 = localArrayList.size();
    paramInt = i3;
    while (paramInt < i1)
    {
      localObject = (C2CShortcutAppInfo.Label)localArrayList.get(paramInt);
      paramList = new LabelTextView(getContext());
      paramList.setParam(Color.parseColor(((C2CShortcutAppInfo.Label)localObject).b), Color.parseColor(((C2CShortcutAppInfo.Label)localObject).c), i4);
      paramList.setTextSize(f1);
      paramList.setText(((C2CShortcutAppInfo.Label)localObject).a);
      paramList.setPadding(i6, i5, i6, i5);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      if (paramInt != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = i7;
      }
      paramLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
      paramInt += 1;
    }
    return localArrayList.size();
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && (paramRecyclerView.getVisibility() == 0) && (paramRecyclerView.isShown())) {
      if (!paramRecyclerView.getGlobalVisibleRect(new Rect())) {
        return;
      }
    }
    for (;;)
    {
      int[] arrayOfInt;
      int i1;
      try
      {
        arrayOfInt = new int[2];
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
        arrayOfInt[0] = paramRecyclerView.findFirstVisibleItemPosition();
        arrayOfInt[1] = paramRecyclerView.findLastVisibleItemPosition();
        if (arrayOfInt.length >= 2) {
          break label282;
        }
        return;
      }
      catch (Exception paramRecyclerView)
      {
        int i2;
        StringBuilder localStringBuilder;
        paramRecyclerView.printStackTrace();
      }
      if (i1 <= arrayOfInt[1])
      {
        if ((this.j != null) && (i1 < this.j.size()) && (this.j.get(i1) != null) && (!TextUtils.isEmpty(((C2CShortcutAppInfo)this.j.get(i1)).a)) && (!this.r.contains(((C2CShortcutAppInfo)this.j.get(i1)).a)))
        {
          this.r.add(((C2CShortcutAppInfo)this.j.get(i1)).a);
          i2 = C2CShortcutBarManager.a(this.b).a(this.l);
          paramRecyclerView = ((C2CShortcutAppInfo)this.j.get(i1)).a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i1);
          localStringBuilder.append("");
          ReportController.b(null, "dc00898", "", "", "0X800B32C", "0X800B32C", i2, 0, paramRecyclerView, localStringBuilder.toString(), "", "");
        }
        i1 += 1;
      }
      else
      {
        return;
        label282:
        i1 = arrayOfInt[0];
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.a);
      this.b = null;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.h;
    if ((localObject != null) && (((FormSwitchItem)localObject).getSwitch() == paramCompoundButton))
    {
      localObject = this.k;
      if (localObject != null) {
        ((IC2CShortcutBarStoreUIEvent)localObject).a(paramBoolean, this.l);
      }
      ReportController.b(null, "dc00898", "", "", "0X800B32F", "0X800B32F", C2CShortcutBarManager.a(this.b).a(this.l), 0, "", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131430219)
    {
      if (i1 == 2131430227)
      {
        IC2CShortcutBarStoreUIEvent localIC2CShortcutBarStoreUIEvent = this.k;
        if (localIC2CShortcutBarStoreUIEvent != null) {
          localIC2CShortcutBarStoreUIEvent.c();
        }
      }
    }
    else {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -1;
    paramBundle.gravity = 81;
    int i1 = DisplayHelper.getScreenWidth(getContext());
    int i2 = DisplayHelper.getScreenHeight(getContext());
    if (i1 >= i2) {
      i1 = i2;
    }
    paramBundle.width = i1;
    getWindow().setAttributes(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(67108864);
    boolean bool1 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.c = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131624347, null));
    this.d = this.c.findViewById(2131430219);
    this.d.setOnClickListener(this);
    this.f = ((LinearLayout)this.c.findViewById(2131430228));
    paramBundle = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    paramBundle.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(2131299920));
    this.f.setLayoutParams(paramBundle);
    if (bool1) {
      this.f.setBackgroundDrawable(getContext().getResources().getDrawable(2130839084));
    } else {
      this.f.setBackgroundDrawable(getContext().getResources().getDrawable(2130839083));
    }
    this.e = ((ImageView)this.c.findViewById(2131430227));
    this.e.setOnClickListener(this);
    this.e.setOnTouchListener(new C2CShortcutBarStoreView.1(this));
    this.g = ((RecyclerView)this.c.findViewById(2131430229));
    paramBundle = new LinearLayoutManager(getContext(), 1, false);
    this.g.setLayoutManager(paramBundle);
    this.i = new C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter(this);
    this.g.setAdapter(this.i);
    this.g.addOnScrollListener(new C2CShortcutBarStoreView.2(this));
    View localView = this.c.findViewById(2131430220);
    boolean bool2 = this.m;
    i2 = 8;
    if (bool2) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    if (bool1) {
      paramBundle = "#3D3D41";
    } else {
      paramBundle = "#EBEDF5";
    }
    localView.setBackgroundColor(Color.parseColor(paramBundle));
    this.h = ((FormSwitchItem)this.c.findViewById(2131430230));
    paramBundle = this.h;
    i1 = i2;
    if (this.m) {
      i1 = 0;
    }
    paramBundle.setVisibility(i1);
    if (this.m)
    {
      if (bool1) {
        paramBundle = "#282828";
      } else {
        paramBundle = "#FFFFFF";
      }
      this.h.setBackgroundColor(Color.parseColor(paramBundle));
      this.h.setChecked(this.n);
      this.h.setOnCheckedChangeListener(this);
      this.h.setOnClickListener(this);
      ReportController.b(null, "dc00898", "", "", "0X800B32E", "0X800B32E", C2CShortcutBarManager.a(this.b).a(this.l), 0, "", "", "", "");
    }
    setContentView(this.c);
  }
  
  public void show()
  {
    super.show();
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView
 * JD-Core Version:    0.7.0.1
 */