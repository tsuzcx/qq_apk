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
import auxy;
import auxz;
import auya;
import auyb;
import axlk;
import bbxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class StickyNoteShopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new auxz(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private auyb jdField_a_of_type_Auyb;
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "sticky_list_cache";
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
    View.inflate(getContext(), 2131561026, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131376513));
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localStaggeredGridLayoutManager);
    this.jdField_a_of_type_Auyb = new auyb(getContext(), null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Auyb);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-1);
    findViewById(2131378152).setOnClickListener(this);
    findViewById(2131367851).setOnClickListener(this);
    a();
  }
  
  public int a(int paramInt)
  {
    if (paramInt > axlk.b / 4) {}
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = paramInt;
      setMinimumHeight(localLayoutParams.height);
      setLayoutParams(localLayoutParams);
      return paramInt;
      paramInt = axlk.b / 3;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Auyb);
  }
  
  public void a(int paramInt)
  {
    setVisibility(paramInt);
    if (this.jdField_a_of_type_Auyb.getItemCount() == 0) {
      a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Auyb.a();
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("StickyNoteShopLayout", 2, " appId:" + this.jdField_a_of_type_Int + " mIsLoadLast:" + this.jdField_a_of_type_Boolean + " isLoadMore:" + paramBoolean + " mStrAttachInfo:" + this.b);
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      new bbxb("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetSuixintieSigFontReq").a("getSuixintieSigFont", new GetSuixintieSigFontReq(bbxb.a(), this.jdField_a_of_type_Int, 0, "", this.b), new GetSuixintieSigFontRsp(), new auxy(this, paramBoolean), false);
    } while (paramBoolean);
    ThreadManagerV2.executeOnFileThread(new StickyNoteShopLayout.2(this));
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
    default: 
      return;
    case 2131378152: 
      a(false);
      return;
    }
    a(false);
  }
  
  public void setAppId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Auyb != null) {
      this.jdField_a_of_type_Auyb.a(paramInt);
    }
  }
  
  public void setItemId(int paramInt)
  {
    this.jdField_a_of_type_Auyb.b(paramInt);
  }
  
  public void setShopCallback(auya paramauya)
  {
    this.jdField_a_of_type_Auyb.a(paramauya);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout
 * JD-Core Version:    0.7.0.1
 */