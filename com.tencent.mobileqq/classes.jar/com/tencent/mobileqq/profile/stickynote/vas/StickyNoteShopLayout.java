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
import baba;
import babb;
import babc;
import babd;
import bdep;
import biib;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class StickyNoteShopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new babb(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private babd jdField_a_of_type_Babd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "sticky_list_cache";
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2;
    c();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2;
    c();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2;
    c();
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int k = paramArrayOfInt[j];
      if (k <= i) {
        break label39;
      }
      i = k;
    }
    label39:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void c()
  {
    View.inflate(getContext(), 2131561494, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131378024));
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localStaggeredGridLayoutManager);
    this.jdField_a_of_type_Babd = new babd(getContext(), null);
    this.jdField_a_of_type_Babd.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Babd);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-1);
    findViewById(2131379806).setOnClickListener(this);
    findViewById(2131368396).setOnClickListener(this);
    a();
  }
  
  public int a(int paramInt)
  {
    if (paramInt > bdep.jdField_b_of_type_Int / 4) {}
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = paramInt;
      setMinimumHeight(localLayoutParams.height);
      setLayoutParams(localLayoutParams);
      return paramInt;
      paramInt = bdep.jdField_b_of_type_Int / 3;
    }
  }
  
  public babd a()
  {
    return this.jdField_a_of_type_Babd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Babd);
  }
  
  public void a(int paramInt)
  {
    setVisibility(paramInt);
    if (this.jdField_a_of_type_Babd.getItemCount() == 0) {
      a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Babd.a();
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("StickyNoteShopLayout", 2, " appId:" + this.jdField_b_of_type_Int + " mIsLoadLast:" + this.jdField_a_of_type_Boolean + " isLoadMore:" + paramBoolean + " mStrAttachInfo:" + this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {
      break label68;
    }
    label68:
    while ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Babd.a() >= 30) && (paramBoolean)) {
      return;
    }
    biib localbiib = new biib("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetSuixintieSigFontReq");
    GetSuixintieSigFontReq localGetSuixintieSigFontReq = new GetSuixintieSigFontReq(biib.a(), this.jdField_b_of_type_Int, this.c, "", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 1) {}
    for (String str = "getSuixintieSigFont";; str = "getExtendFriendSigFont")
    {
      localbiib.a(str, localGetSuixintieSigFontReq, new GetSuixintieSigFontRsp(), new baba(this, paramBoolean), false);
      if (paramBoolean) {
        break;
      }
      ThreadManagerV2.executeOnFileThread(new StickyNoteShopLayout.2(this));
      return;
    }
  }
  
  public void b()
  {
    setVisibility(8);
    a(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(false);
      continue;
      a(false);
    }
  }
  
  public void setAppId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Babd != null) {
      this.jdField_a_of_type_Babd.a(paramInt);
    }
  }
  
  public void setItemId(int paramInt)
  {
    this.jdField_a_of_type_Babd.c(paramInt);
  }
  
  public void setShopCallback(babc parambabc)
  {
    this.jdField_a_of_type_Babd.a(parambabc);
  }
  
  public void setUseId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setUsingItem(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout
 * JD-Core Version:    0.7.0.1
 */