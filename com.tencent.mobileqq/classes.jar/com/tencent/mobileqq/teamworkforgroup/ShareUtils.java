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
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;

public class ShareUtils
  implements AdapterView.OnItemClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ShareUtils.SharePanelListener jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils$SharePanelListener = null;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected String a;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private ElasticHorScrView jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView;
  protected String b;
  protected String c = null;
  protected String d = null;
  
  public ShareUtils(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  @SuppressLint({"InflateParams"})
  @TargetApi(9)
  protected View a()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131559223, null);
    localView.setBackgroundResource(2130838979);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377564));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377565));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361988));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719846);
    Object localObject1;
    GridView localGridView2;
    GridView localGridView1;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = (LinearLayout)localView.findViewById(2131361993);
      if ((localObject1 != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
        ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int);
      }
      localGridView2 = (GridView)localView.findViewById(2131368059);
      localGridView1 = (GridView)localView.findViewById(2131368060);
      localObject1 = (TextView)localView.findViewById(2131361987);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setText(2131690800);
      ((TextView)localObject1).setOnClickListener(new ShareUtils.1(this));
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
        this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localGridView1.setSmoothScrollbarEnabled(false);
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label458;
      }
      localObject1 = localObject2[0];
      label228:
      if (localObject2.length <= 1) {
        break label470;
      }
    }
    label458:
    label470:
    for (Object localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i = ((List)localObject1).size();
      localGridView2.setNumColumns(i);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i - 1) * 10 + i * 75 + 3) * this.jdField_a_of_type_Float));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      localObject1 = new ArrayList(0);
      break label228;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
        View localView = a();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ShareUtils.3(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(new ShareUtils.4(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localView, null);
      }
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(ShareUtils.SharePanelListener paramSharePanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils$SharePanelListener = paramSharePanelListener;
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
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696380);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839214;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696401);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839218;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696383);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839212;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696398);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839217;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 12;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696389);
    localActionSheetItem.jdField_a_of_type_Int = 2130837586;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 26;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696372);
    localActionSheetItem.jdField_a_of_type_Int = 2130839210;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696378);
    localActionSheetItem.jdField_a_of_type_Int = 2130842827;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils$SharePanelListener = null;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ShareUtils", 2, "onItemClick, tag is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject = ((IPublicAccountBrowser.ActionSheetItemViewHolder)localObject).a;
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils$SharePanelListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupShareUtils$SharePanelListener.a(((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils
 * JD-Core Version:    0.7.0.1
 */