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
    super(paramContext, 2131755059);
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
    int m = ViewUtils.b(12.0F);
    int n = ViewUtils.b(1.0F);
    int i1 = ViewUtils.b(8.0F);
    int i2 = ViewUtils.b(6.0F);
    Object localObject = new Paint();
    float f = 12;
    ((Paint)localObject).setTextSize(ViewUtils.b(f));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i3 = paramList.size();
    int k = 0;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < i3)
    {
      C2CShortcutAppInfo.Label localLabel = (C2CShortcutAppInfo.Label)paramList.get(paramInt);
      j = i;
      if (localLabel != null)
      {
        j = i;
        if (!TextUtils.isEmpty(localLabel.jdField_a_of_type_JavaLangString))
        {
          j = (int)(((Paint)localObject).measureText(localLabel.jdField_a_of_type_JavaLangString) + i1 * 2);
          if (i >= j + i2)
          {
            localArrayList.add(localLabel);
            j = i - j - i2;
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
      i = j;
    }
    i = localArrayList.size();
    paramInt = k;
    while (paramInt < i)
    {
      localObject = (C2CShortcutAppInfo.Label)localArrayList.get(paramInt);
      paramList = new LabelTextView(getContext());
      paramList.setParam(Color.parseColor(((C2CShortcutAppInfo.Label)localObject).b), Color.parseColor(((C2CShortcutAppInfo.Label)localObject).c), m);
      paramList.setTextSize(f);
      paramList.setText(((C2CShortcutAppInfo.Label)localObject).jdField_a_of_type_JavaLangString);
      paramList.setPadding(i1, n, i1, n);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      if (paramInt != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = i2;
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
      int i;
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
        int j;
        StringBuilder localStringBuilder;
        paramRecyclerView.printStackTrace();
      }
      if (i <= arrayOfInt[1])
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null) && (!TextUtils.isEmpty(((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaUtilList.contains(((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaUtilList.add(((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
          j = C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString);
          paramRecyclerView = ((C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ReportController.b(null, "dc00898", "", "", "0X800B32C", "0X800B32C", j, 0, paramRecyclerView, localStringBuilder.toString(), "", "");
        }
        i += 1;
      }
      else
      {
        return;
        label282:
        i = arrayOfInt[0];
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if ((localObject != null) && (((FormSwitchItem)localObject).a() == paramCompoundButton))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent;
      if (localObject != null) {
        ((IC2CShortcutBarStoreUIEvent)localObject).a(paramBoolean, this.jdField_a_of_type_JavaLangString);
      }
      ReportController.b(null, "dc00898", "", "", "0X800B32F", "0X800B32F", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364216)
    {
      if (i == 2131364224)
      {
        IC2CShortcutBarStoreUIEvent localIC2CShortcutBarStoreUIEvent = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreIC2CShortcutBarStoreUIEvent;
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
    int i = DisplayHelper.getScreenWidth(getContext());
    int j = DisplayHelper.getScreenHeight(getContext());
    if (i >= j) {
      i = j;
    }
    paramBundle.width = i;
    getWindow().setAttributes(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(67108864);
    boolean bool1 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131558727, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364216);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364225));
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramBundle.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(2131299168));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(getContext().getResources().getDrawable(2130838930));
    } else {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(getContext().getResources().getDrawable(2130838929));
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364224));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new C2CShortcutBarStoreView.1(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364226));
    paramBundle = new LinearLayoutManager(getContext(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView$C2CShortcutBarStoreAdapter = new C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView$C2CShortcutBarStoreAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new C2CShortcutBarStoreView.2(this));
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364217);
    boolean bool2 = this.jdField_a_of_type_Boolean;
    j = 8;
    if (bool2) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    if (bool1) {
      paramBundle = "#3D3D41";
    } else {
      paramBundle = "#EBEDF5";
    }
    localView.setBackgroundColor(Color.parseColor(paramBundle));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364227));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    }
    paramBundle.setVisibility(i);
    if (this.jdField_a_of_type_Boolean)
    {
      if (bool1) {
        paramBundle = "#282828";
      } else {
        paramBundle = "#FFFFFF";
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundColor(Color.parseColor(paramBundle));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
      ReportController.b(null, "dc00898", "", "", "0X800B32E", "0X800B32E", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
    }
    setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void show()
  {
    super.show();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView
 * JD-Core Version:    0.7.0.1
 */