package com.tencent.mobileqq.teamworkforgroup;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.IPublicAccountBrowser.ActionSheetItem;
import com.tencent.mobileqq.teamwork.IPublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.mobileqq.teamwork.IPublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.mobileqq.teamwork.IShareUtils;
import com.tencent.mobileqq.teamwork.IShareUtils.SharePanelListener;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

public class ShareUtils
  implements AdapterView.OnItemClickListener, IShareUtils
{
  protected int a;
  protected String b = null;
  protected String c = null;
  protected String d = null;
  protected String e = null;
  private ActionSheet f;
  private ElasticHorScrView g;
  private ElasticHorScrView h;
  private float i = 1.0F;
  private Activity j;
  private AppInterface k;
  private IShareUtils.SharePanelListener l = null;
  private View m;
  private int n = 0;
  private boolean o = true;
  private TextView p;
  
  public ShareUtils(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.j = paramActivity;
    this.k = paramAppInterface;
    this.i = this.j.getResources().getDisplayMetrics().density;
  }
  
  public void a()
  {
    View localView = this.m;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(IShareUtils.SharePanelListener paramSharePanelListener)
  {
    this.l = paramSharePanelListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.a = paramInt;
    this.e = paramString4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void b()
  {
    if (this.j.isFinishing()) {
      return;
    }
    if (this.f == null)
    {
      this.f = ((ActionSheet)((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(this.j, null));
      View localView = e();
      this.f.setOnDismissListener(new ShareUtils.3(this));
      this.f.setOnKeyListener(new ShareUtils.4(this));
      this.f.setActionContentView(localView, null);
    }
    if (!this.f.isShowing()) {
      this.f.show();
    }
  }
  
  public void c()
  {
    ActionSheet localActionSheet = this.f;
    if ((localActionSheet != null) && (localActionSheet.isShowing()))
    {
      this.l = null;
      this.f.dismiss();
    }
  }
  
  protected List<IPublicAccountBrowser.ActionSheetItem>[] d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.j.getString(2131894171);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839221;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).b = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.j.getString(2131894192);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839225;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.j.getString(2131894174);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839219;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.j.getString(2131894189);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839224;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).b = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 12;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.c = this.j.getString(2131894180);
    localActionSheetItem.a = 2130837697;
    localActionSheetItem.b = true;
    localActionSheetItem.d = 26;
    localActionSheetItem.e = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.c = this.j.getString(2131894163);
    localActionSheetItem.a = 2130839217;
    localActionSheetItem.b = true;
    localActionSheetItem.d = 1;
    localActionSheetItem.e = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.c = this.j.getString(2131894169);
    localActionSheetItem.a = 2130843680;
    localActionSheetItem.b = true;
    localActionSheetItem.d = 11;
    localActionSheetItem.e = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  @SuppressLint({"InflateParams"})
  @TargetApi(9)
  protected View e()
  {
    View localView = this.j.getLayoutInflater().inflate(2131624764, null);
    localView.setBackgroundResource(2130838958);
    this.g = ((ElasticHorScrView)localView.findViewById(2131445372));
    this.h = ((ElasticHorScrView)localView.findViewById(2131445373));
    this.p = ((TextView)localView.findViewById(2131427565));
    this.p.setText(2131917134);
    if (f()) {
      this.p.setVisibility(0);
    } else {
      this.p.setVisibility(8);
    }
    Object localObject1 = (LinearLayout)localView.findViewById(2131427586);
    if (localObject1 != null)
    {
      localObject2 = this.m;
      if (localObject2 != null) {
        ((LinearLayout)localObject1).addView((View)localObject2, this.n);
      }
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131434386);
    GridView localGridView1 = (GridView)localView.findViewById(2131434387);
    localObject1 = (TextView)localView.findViewById(2131427564);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setText(2131887648);
    ((TextView)localObject1).setOnClickListener(new ShareUtils.1(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.g.setOverScrollMode(2);
      this.h.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = d();
    if (localObject2.length > 0) {
      localObject1 = localObject2[0];
    } else {
      localObject1 = new ArrayList(0);
    }
    if (localObject2.length > 1) {
      localObject2 = localObject2[1];
    } else {
      localObject2 = new ArrayList(0);
    }
    int i1 = ((List)localObject1).size();
    localGridView2.setNumColumns(i1);
    ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
    localLayoutParams.width = ((int)((i1 * 75 + (i1 - 1) * 10 + 3) * this.i));
    localGridView2.setLayoutParams(localLayoutParams);
    localGridView2.setAdapter(new IPublicAccountBrowser.ActionSheetItemAdapter(this.j, 0, (List)localObject1));
    localGridView2.setSelector(new ColorDrawable(0));
    localGridView2.setOnItemClickListener(this);
    i1 = localLayoutParams.width;
    int i2 = ((List)localObject2).size();
    localObject1 = localGridView1.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ((int)((i2 * 75 + (i2 - 1) * 10 + 3) * this.i));
    localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localGridView1.setNumColumns(i2);
    localGridView1.setAdapter(new IPublicAccountBrowser.ActionSheetItemAdapter(this.j, 0, (List)localObject2));
    localGridView1.setSelector(new ColorDrawable(0));
    localGridView1.setOnItemClickListener(this);
    localView.post(new ShareUtils.2(this, i1, ((ViewGroup.LayoutParams)localObject1).width));
    return localView;
  }
  
  public boolean f()
  {
    return this.o;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareUtils", 2, "onItemClick, tag is null");
      }
    }
    else
    {
      localObject = ((IPublicAccountBrowser.ActionSheetItemViewHolder)localObject).c;
      IShareUtils.SharePanelListener localSharePanelListener = this.l;
      if (localSharePanelListener != null) {
        localSharePanelListener.a(((IPublicAccountBrowser.ActionSheetItem)localObject).d);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils
 * JD-Core Version:    0.7.0.1
 */