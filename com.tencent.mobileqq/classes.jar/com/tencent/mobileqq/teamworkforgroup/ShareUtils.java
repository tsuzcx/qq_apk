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
  private float jdField_a_of_type_Float = 1.0F;
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private IShareUtils.SharePanelListener jdField_a_of_type_ComTencentMobileqqTeamworkIShareUtils$SharePanelListener = null;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected String a;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private ElasticHorScrView jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView;
  protected String b;
  protected String c = null;
  protected String d = null;
  
  public ShareUtils(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  @SuppressLint({"InflateParams"})
  @TargetApi(9)
  protected View a()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131559103, null);
    localView.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377008));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377009));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362004));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719571);
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject1 = (LinearLayout)localView.findViewById(2131362008);
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 != null) {
        ((LinearLayout)localObject1).addView((View)localObject2, this.jdField_b_of_type_Int);
      }
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131367811);
    GridView localGridView1 = (GridView)localView.findViewById(2131367812);
    localObject1 = (TextView)localView.findViewById(2131362003);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setText(2131690728);
    ((TextView)localObject1).setOnClickListener(new ShareUtils.1(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = a();
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
    int i = ((List)localObject1).size();
    localGridView2.setNumColumns(i);
    ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
    localLayoutParams.width = ((int)((i * 75 + (i - 1) * 10 + 3) * this.jdField_a_of_type_Float));
    localGridView2.setLayoutParams(localLayoutParams);
    localGridView2.setAdapter(new IPublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
    localGridView2.setSelector(new ColorDrawable(0));
    localGridView2.setOnItemClickListener(this);
    i = localLayoutParams.width;
    int j = ((List)localObject2).size();
    localObject1 = localGridView1.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ((int)((j * 75 + (j - 1) * 10 + 3) * this.jdField_a_of_type_Float));
    localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localGridView1.setNumColumns(j);
    localGridView1.setAdapter(new IPublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
    localGridView1.setSelector(new ColorDrawable(0));
    localGridView1.setOnItemClickListener(this);
    localView.post(new ShareUtils.2(this, i, ((ViewGroup.LayoutParams)localObject1).width));
    return localView;
  }
  
  public void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(IShareUtils.SharePanelListener paramSharePanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkIShareUtils$SharePanelListener = paramSharePanelListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.d = paramString4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected List<IPublicAccountBrowser.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696399);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839067;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696420);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839071;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696402);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839065;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696417);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839070;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 12;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696408);
    localActionSheetItem.jdField_a_of_type_Int = 2130837673;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 26;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696391);
    localActionSheetItem.jdField_a_of_type_Int = 2130839063;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696397);
    localActionSheetItem.jdField_a_of_type_Int = 2130842727;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(this.jdField_a_of_type_AndroidAppActivity, null));
      View localView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ShareUtils.3(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(new ShareUtils.4(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localView, null);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void c()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkIShareUtils$SharePanelListener = null;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
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
      localObject = ((IPublicAccountBrowser.ActionSheetItemViewHolder)localObject).a;
      IShareUtils.SharePanelListener localSharePanelListener = this.jdField_a_of_type_ComTencentMobileqqTeamworkIShareUtils$SharePanelListener;
      if (localSharePanelListener != null) {
        localSharePanelListener.a(((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils
 * JD-Core Version:    0.7.0.1
 */