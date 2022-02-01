package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.winkpublish.adapter.PublishAssociateLabelAdapter;
import com.tencent.mobileqq.winkpublish.base.BaseBlockContainer;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.event.PublishAssociateTagEvent;
import com.tencent.mobileqq.winkpublish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.winkpublish.view.edittext.ExtendEditText;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class PublishLabelPart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver
{
  public static final String a;
  TextWatcher b = new PublishLabelPart.4(this);
  private PublishViewModel e;
  private PublishLabelViewModel f;
  private LinearLayout g;
  private FrameLayout h;
  private RecyclerView i;
  private PublishLabelPart.LabelAdapter j;
  private ExtendEditText k;
  private RelativeLayout l;
  private BaseBlockContainer m;
  private ImageView n;
  private PublishAssociateLabelAdapter o;
  private String p;
  private String q;
  private String r;
  private int s;
  private int t = -1;
  private String u = "^#[，a-z0-9A-Z一-龥]+$";
  private boolean v = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSLabelPart");
    a = localStringBuilder.toString();
  }
  
  private void a(UIStateData<List<FeedCloudMeta.StTagInfo>> paramUIStateData)
  {
    if (paramUIStateData.e() != null)
    {
      if (!paramUIStateData.i()) {
        this.o.a((List)paramUIStateData.e());
      } else {
        this.o.b((List)paramUIStateData.e());
      }
      a(true, paramUIStateData.i(), paramUIStateData.h());
      n();
    }
  }
  
  private void b(View paramView)
  {
    this.l = ((RelativeLayout)paramView.findViewById(2131441891));
    this.n = ((ImageView)paramView.findViewById(2131441896));
    this.n.setOnClickListener(this);
    this.m = ((BaseBlockContainer)paramView.findViewById(2131441716));
    this.m.setLayoutManagerType(1, 1);
    this.m.getBlockMerger().b(2);
    this.m.setEnableLoadMore(true);
    this.m.setEnableRefresh(false);
    this.m.setParentFragment(j());
    this.m.getRecyclerView().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.o = new PublishAssociateLabelAdapter(null);
    paramView.add(this.o);
    this.o.setOnLoadDataDelegate(new PublishLabelPart.1(this));
    this.m.a(paramView);
    this.o.a(this.m.getRecyclerView());
    this.m.getRecyclerView().addOnScrollListener(new PublishLabelPart.2(this));
    this.m.g();
  }
  
  private void b(String paramString)
  {
    try
    {
      String str = this.k.getText().toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str, 0, this.s);
      localStringBuffer.append(paramString);
      localStringBuffer.append(" ");
      localStringBuffer.append(str.substring(this.k.getSelectionStart()));
      this.k.setText(localStringBuffer);
      this.k.setSelection(this.s + paramString.length() + 1);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(a, 1, paramString, new Object[0]);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      Object localObject1 = this.k.getText().toString();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool)
      {
        localObject1 = this.k;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" ");
        ((ExtendEditText)localObject1).setText(((StringBuilder)localObject2).toString());
        this.k.setSelection(paramString.length() + 1);
        return;
      }
      if (((String)localObject1).contains(paramString)) {
        return;
      }
      int i1 = this.k.getSelectionStart();
      int i2 = this.k.getSelectionEnd();
      Object localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append((CharSequence)localObject1, 0, i1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      ((StringBuffer)localObject2).append(localStringBuilder.toString());
      ((StringBuffer)localObject2).append(((String)localObject1).substring(i2));
      this.k.setText((CharSequence)localObject2);
      this.k.setSelection(i1 + paramString.length() + 1);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(a, 1, paramString, new Object[0]);
    }
  }
  
  private void d(View paramView)
  {
    this.g = ((LinearLayout)paramView.findViewById(2131441715));
    this.g.setOnClickListener(this);
    this.h = ((FrameLayout)paramView.findViewById(2131441859));
    this.i = ((RecyclerView)paramView.findViewById(2131441860));
    paramView = new LinearLayoutManager(g());
    paramView.setOrientation(0);
    this.i.setLayoutManager(paramView);
    this.j = new PublishLabelPart.LabelAdapter(this);
    this.i.setAdapter(this.j);
    this.j.a(new PublishLabelPart.3(this));
  }
  
  private void d(String paramString)
  {
    try
    {
      String str = this.k.getText().toString();
      if (!TextUtils.isEmpty(str))
      {
        paramString = str.replaceAll(paramString, "");
        this.k.setText(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e(a, 1, paramString, new Object[0]);
    }
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.r))
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestAssociateLable, mInputTag:");
        localStringBuilder.append(this.r);
        QLog.e(str, 1, localStringBuilder.toString());
      }
      this.f.a(this.r, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(a, 1, "requestAssociateLable, mInputTag is null");
    }
    this.f.a("");
  }
  
  private void f()
  {
    this.f.b().observe(j(), new PublishLabelPart.5(this));
  }
  
  private void l()
  {
    this.f.e.observe(j(), new PublishLabelPart.6(this));
    this.f.f.observe(j(), new PublishLabelPart.7(this));
    this.f.c.observe(j(), new PublishLabelPart.8(this));
    this.f.d.observe(j(), new PublishLabelPart.9(this));
    if (this.e == null) {
      this.e = ((PublishViewModel)a(PublishViewModel.class));
    }
    this.e.c.observe(j(), new PublishLabelPart.10(this));
    f();
  }
  
  private void m()
  {
    try
    {
      String str = this.k.getText().toString();
      boolean bool = TextUtils.isEmpty(str);
      if (bool)
      {
        this.s = 0;
        this.k.setText("#");
        this.k.setSelection(1);
      }
      else
      {
        int i1 = this.k.getSelectionStart();
        int i2 = this.k.getSelectionEnd();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str, 0, i1);
        localStringBuffer.append("#");
        localStringBuffer.append(str.substring(i2));
        this.s = i1;
        this.k.setText(localStringBuffer);
        this.k.setSelection(i1 + 1);
      }
      if (PublishViewModel.l()) {
        this.f.d();
      }
      SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(true));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, localException, new Object[0]);
    }
  }
  
  private void n()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getVisibility() == 0) {
        return;
      }
      if (c().isFinishing()) {
        return;
      }
      this.l.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(g(), 2130772353);
      ((Animation)localObject).setDuration(200L);
      this.l.clearAnimation();
      this.l.startAnimation((Animation)localObject);
      this.e.b(true);
    }
  }
  
  private void o()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getVisibility() == 8) {
        return;
      }
      localObject = AnimationUtils.loadAnimation(g(), 2130772354);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setAnimationListener(new PublishLabelPart.11(this));
      this.l.clearAnimation();
      this.l.startAnimation((Animation)localObject);
      this.e.b(false);
    }
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = this.k.getSelectionStart();
      if ((paramInt1 != 0) && (paramCharSequence != null))
      {
        if (paramCharSequence.length() == 0) {
          return -1;
        }
        if (paramCharSequence.toString().substring(0, paramInt1).contains("#"))
        {
          paramInt1 = paramCharSequence.toString().substring(0, paramInt1).lastIndexOf("#", paramInt1);
          return paramInt1;
        }
      }
      return -1;
    }
    catch (Exception paramCharSequence)
    {
      QLog.e(a, 1, paramCharSequence, new Object[0]);
    }
    return -1;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    QLog.d(a, 1, new Object[] { "onActivityResult... requestCode:", Integer.valueOf(paramInt1), " resultCode:", Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      return;
    }
    if ((20000 == paramInt1) && (paramInt2 == -1) && (!paramIntent.getBooleanExtra("key_qcircle_pulish_use_draft", false))) {
      this.f.a(c(), paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    QLog.d(a, 1, "onInitView...");
    if (this.f == null) {
      this.f = ((PublishLabelViewModel)a(PublishLabelViewModel.class));
    }
    this.k = ((ExtendEditText)paramView.findViewById(2131431344));
    if (PublishViewModel.l()) {
      this.k.addTextChangedListener(this.b);
    }
    b(paramView);
    d(paramView);
    l();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.m != null) && (this.o.getBlockMerger() != null))
    {
      this.o.getLoadInfo().a(4);
      this.o.getLoadInfo().a(paramBoolean3);
      this.m.setRefreshing(false);
      this.o.getBlockMerger().a(false);
      this.o.getBlockMerger().b("");
      this.o.getBlockMerger().a(paramBoolean1, paramBoolean3);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("iscuccess:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isfinish:");
      localStringBuilder.append(paramBoolean3);
      QLog.d(str, 4, localStringBuilder.toString());
    }
  }
  
  public boolean a(String paramString)
  {
    return paramString.matches(this.u);
  }
  
  public boolean ah_()
  {
    RelativeLayout localRelativeLayout = this.l;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      o();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.e.c();
    this.f.e();
    this.v = true;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PublishAssociateTagEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if ((this.h != null) && (this.v))
    {
      this.j.notifyDataSetChanged();
      this.h.setVisibility(8);
      this.v = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131441715) {
      m();
    } else if (i1 == 2131441896) {
      o();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof PublishAssociateTagEvent))
    {
      b(((PublishAssociateTagEvent)paramSimpleBaseEvent).tag);
      o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart
 * JD-Core Version:    0.7.0.1
 */