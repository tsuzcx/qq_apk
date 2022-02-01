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
import com.tencent.mobileqq.extendfriend.wiget.LabelTextView;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class C2CShortcutBarStoreView
  extends DialogFromBottom
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private float jdField_a_of_type_Float;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  C2CShortcutBarObserver jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver = new C2CShortcutBarStoreView.3(this);
  private C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView$C2CShortcutBarStoreAdapter;
  private IC2CShortcutBarStoreUIEvent jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString;
  private List<C2CShortcutAppInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  protected C2CShortcutBarStoreView(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, List<C2CShortcutAppInfo> paramList, IC2CShortcutBarStoreUIEvent paramIC2CShortcutBarStoreUIEvent)
  {
    super(paramContext, 2131755056);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent = paramIC2CShortcutBarStoreUIEvent;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<C2CShortcutAppInfo.Label> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = ViewUtils.b(12.0F);
    int k = ViewUtils.b(1.0F);
    int m = ViewUtils.b(8.0F);
    int n = ViewUtils.b(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(ViewUtils.b(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    C2CShortcutAppInfo.Label localLabel;
    if (i < i1)
    {
      localLabel = (C2CShortcutAppInfo.Label)paramList.get(i);
      if ((localLabel == null) || (TextUtils.isEmpty(localLabel.jdField_a_of_type_JavaLangString))) {
        break label313;
      }
      int i2 = (int)(((Paint)localObject).measureText(localLabel.jdField_a_of_type_JavaLangString) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localLabel);
        paramInt = paramInt - i2 - n;
      }
    }
    label313:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localLabel);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (C2CShortcutAppInfo.Label)localArrayList.get(paramInt);
        paramList = new LabelTextView(getContext());
        paramList.setParam(Color.parseColor(((C2CShortcutAppInfo.Label)localObject).b), Color.parseColor(((C2CShortcutAppInfo.Label)localObject).c), j);
        paramList.setTextSize(12);
        paramList.setText(((C2CShortcutAppInfo.Label)localObject).jdField_a_of_type_JavaLangString);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        paramLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt += 1;
      }
      return localArrayList.size();
    }
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (paramRecyclerView.getVisibility() != 0) || (!paramRecyclerView.isShown()) || (!paramRecyclerView.getGlobalVisibleRect(new Rect()))) {}
    for (;;)
    {
      return;
      try
      {
        int[] arrayOfInt = new int[2];
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
        arrayOfInt[0] = paramRecyclerView.findFirstVisibleItemPosition();
        arrayOfInt[1] = paramRecyclerView.findLastVisibleItemPosition();
        if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
          continue;
        }
        int i = arrayOfInt[0];
        while (i <= arrayOfInt[1])
        {
          if ((this.jdField_a_of_type_JavaUtilList != null) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null) && (!TextUtils.isEmpty(((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaUtilList.contains(((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            this.jdField_b_of_type_JavaUtilList.add(((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
            ReportController.b(null, "dc00898", "", "", "0X800B32C", "0X800B32C", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, ((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, i + "", "", "");
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent.a(paramBoolean, this.jdField_a_of_type_JavaLangString);
      }
      ReportController.b(null, "dc00898", "", "", "0X800B32F", "0X800B32F", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
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
      if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent.c();
        continue;
        dismiss();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 8;
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -1;
    paramBundle.gravity = 81;
    int i = DisplayHelper.getScreenWidth(getContext());
    int k = DisplayHelper.getScreenHeight(getContext());
    if (i < k)
    {
      paramBundle.width = i;
      getWindow().setAttributes(paramBundle);
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131558829, null));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364304);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364313));
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramBundle.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(2131299166));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
      if (!bool) {
        break label534;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(getContext().getResources().getDrawable(2130839077));
      label226:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364312));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new C2CShortcutBarStoreView.1(this));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364314));
      paramBundle = new LinearLayoutManager(getContext(), 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView$C2CShortcutBarStoreAdapter = new C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView$C2CShortcutBarStoreAdapter);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new C2CShortcutBarStoreView.2(this));
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364305);
      if (!this.jdField_a_of_type_Boolean) {
        break label557;
      }
      i = 0;
      label364:
      localView.setVisibility(i);
      if (!bool) {
        break label563;
      }
      paramBundle = "#3D3D41";
      label379:
      localView.setBackgroundColor(Color.parseColor(paramBundle));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364315));
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      if (this.jdField_a_of_type_Boolean) {
        if (!bool) {
          break label570;
        }
      }
    }
    label534:
    label557:
    label563:
    label570:
    for (paramBundle = "#282828";; paramBundle = "#FFFFFF")
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundColor(Color.parseColor(paramBundle));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
      ReportController.b(null, "dc00898", "", "", "0X800B32E", "0X800B32E", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
      setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
      return;
      i = k;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(getContext().getResources().getDrawable(2130839076));
      break label226;
      i = 8;
      break label364;
      paramBundle = "#EBEDF5";
      break label379;
    }
  }
  
  public void show()
  {
    super.show();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView
 * JD-Core Version:    0.7.0.1
 */