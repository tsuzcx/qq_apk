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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
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
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new StickyNoteShopLayout.3(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private StickyNoteVasAdapter jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int c = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sticky_list_cache");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
    int i = 0;
    int j = paramArrayOfInt[0];
    int n = paramArrayOfInt.length;
    while (i < n)
    {
      int m = paramArrayOfInt[i];
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private void c()
  {
    View.inflate(getContext(), 2131561388, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131377908));
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localStaggeredGridLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter = new StickyNoteVasAdapter(getContext(), null);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(-1);
    findViewById(2131379649).setOnClickListener(this);
    findViewById(2131368536).setOnClickListener(this);
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
  
  public StickyNoteVasAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter);
  }
  
  public void a(int paramInt)
  {
    setVisibility(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.getItemCount() == 0) {
      a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" appId:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(" mIsLoadLast:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(" isLoadMore:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" mStrAttachInfo:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    QLog.d("StickyNoteShopLayout", 2, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a() >= 30) && (paramBoolean)) {
      return;
    }
    IJce localIJce = ((IJce)QRoute.api(IJce.class)).build("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetSuixintieSigFontReq");
    GetSuixintieSigFontReq localGetSuixintieSigFontReq = new GetSuixintieSigFontReq(IJce.Util.a(), this.jdField_b_of_type_Int, this.c, "", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 1) {
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
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131368536)
    {
      if (i == 2131379649) {
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
    this.jdField_b_of_type_Int = paramInt;
    StickyNoteVasAdapter localStickyNoteVasAdapter = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter;
    if (localStickyNoteVasAdapter != null) {
      localStickyNoteVasAdapter.a(paramInt);
    }
  }
  
  public void setItemId(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.c(paramInt);
  }
  
  public void setShopCallback(StickyNoteShopLayout.StickyNoteShopSetting paramStickyNoteShopSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter.a(paramStickyNoteShopSetting);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout
 * JD-Core Version:    0.7.0.1
 */