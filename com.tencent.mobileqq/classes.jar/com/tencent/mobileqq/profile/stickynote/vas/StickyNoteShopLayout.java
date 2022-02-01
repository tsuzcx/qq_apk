package com.tencent.mobileqq.profile.stickynote.vas;

import QC.GetSuixintieSigFontReq;
import QC.GetSuixintieSigFontRsp;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class StickyNoteShopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String a;
  public int b = 2;
  private RecyclerView c;
  private StickyNoteVasAdapter d;
  private int e;
  private String f = "";
  private boolean g = false;
  private int h = 0;
  private RecyclerView.OnScrollListener i = new StickyNoteShopLayout.3(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sticky_list_cache");
    a = localStringBuilder.toString();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int j = 0;
    int k = paramArrayOfInt[0];
    int i1 = paramArrayOfInt.length;
    while (j < i1)
    {
      int n = paramArrayOfInt[j];
      int m = k;
      if (n > k) {
        m = n;
      }
      j += 1;
      k = m;
    }
    return k;
  }
  
  private void c()
  {
    View.inflate(getContext(), 2131627744, this);
    this.c = ((RecyclerView)findViewById(2131446391));
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    this.c.setLayoutManager(localStaggeredGridLayoutManager);
    this.d = new StickyNoteVasAdapter(getContext(), null);
    this.d.a(this);
    this.c.setAdapter(this.d);
    this.c.setOnScrollListener(this.i);
    this.c.setBackgroundColor(-1);
    findViewById(2131448421).setOnClickListener(this);
    findViewById(2131435441).setOnClickListener(this);
    a();
  }
  
  public int a(int paramInt)
  {
    if (paramInt <= ScreenUtil.SCREEN_HIGHT / 4) {
      paramInt = ScreenUtil.SCREEN_HIGHT / 3;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = paramInt;
    setMinimumHeight(localLayoutParams.height);
    setLayoutParams(localLayoutParams);
    return paramInt;
  }
  
  public void a()
  {
    this.c.setAdapter(this.d);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.d.a();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" appId:");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" mIsLoadLast:");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(" isLoadMore:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" mStrAttachInfo:");
    ((StringBuilder)localObject).append(this.f);
    QLog.d("StickyNoteShopLayout", 2, ((StringBuilder)localObject).toString());
    if (this.g) {
      return;
    }
    if ((this.b == 2) && (this.d.c() >= 30) && (paramBoolean)) {
      return;
    }
    IJce localIJce = VasUtil.a().getJceRequset().build("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetSuixintieSigFontReq");
    GetSuixintieSigFontReq localGetSuixintieSigFontReq = new GetSuixintieSigFontReq(IJce.Util.a(), this.e, this.h, "", this.f);
    if (this.b == 1) {
      localObject = "getSuixintieSigFont";
    } else {
      localObject = "getExtendFriendSigFont";
    }
    localIJce.request((String)localObject, localGetSuixintieSigFontReq, new GetSuixintieSigFontRsp(), new StickyNoteShopLayout.1(this, paramBoolean), false);
    if (!paramBoolean) {
      ThreadManagerV2.executeOnFileThread(new StickyNoteShopLayout.2(this));
    }
  }
  
  public void b()
  {
    setVisibility(8);
    a(0);
  }
  
  public void b(int paramInt)
  {
    setVisibility(paramInt);
    if (this.d.getItemCount() == 0) {
      a(false);
    }
  }
  
  public StickyNoteVasAdapter getmAdapter()
  {
    return this.d;
  }
  
  public int getmAppId()
  {
    return this.e;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131435441)
    {
      if (j == 2131448421) {
        a(false);
      }
    }
    else {
      a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAppId(int paramInt)
  {
    this.e = paramInt;
    StickyNoteVasAdapter localStickyNoteVasAdapter = this.d;
    if (localStickyNoteVasAdapter != null) {
      localStickyNoteVasAdapter.a(paramInt);
    }
  }
  
  public void setItemId(int paramInt)
  {
    this.d.d(paramInt);
  }
  
  public void setShopCallback(StickyNoteShopLayout.StickyNoteShopSetting paramStickyNoteShopSetting)
  {
    this.d.a(paramStickyNoteShopSetting);
  }
  
  public void setUseId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setUsingItem(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout
 * JD-Core Version:    0.7.0.1
 */