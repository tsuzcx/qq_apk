package com.tencent.mobileqq.search;

import ahqk;
import ahql;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel.SearchEntry;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BusinessSearchEntryModel
  extends BaseSearchEntryModel
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public BusinessSearchEntryModel(int paramInt)
  {
    super(paramInt);
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label130;
      }
    }
    label130:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130971698, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375390));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838580);
      }
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838579);
      }
    }
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131375384));
    localArrayList.add(Integer.valueOf(2131375385));
    localArrayList.add(Integer.valueOf(2131375386));
    localArrayList.add(Integer.valueOf(2131375387));
    localArrayList.add(Integer.valueOf(2131375388));
    localArrayList.add(Integer.valueOf(2131375389));
    localArrayList.add(Integer.valueOf(2131375391));
    localArrayList.add(Integer.valueOf(2131375392));
    localArrayList.add(Integer.valueOf(2131375393));
    localArrayList.add(Integer.valueOf(2131375394));
    localArrayList.add(Integer.valueOf(2131375395));
    localArrayList.add(Integer.valueOf(2131375396));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new ahql(this, new BusinessSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int)), 5, null, true);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    b(paramSearchEntryDataModel);
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131375384));
    localArrayList.add(Integer.valueOf(2131375385));
    localArrayList.add(Integer.valueOf(2131375386));
    localArrayList.add(Integer.valueOf(2131375387));
    localArrayList.add(Integer.valueOf(2131375388));
    localArrayList.add(Integer.valueOf(2131375391));
    localArrayList.add(Integer.valueOf(2131375392));
    localArrayList.add(Integer.valueOf(2131375393));
    localArrayList.add(Integer.valueOf(2131375394));
    localArrayList.add(Integer.valueOf(2131375395));
    return localArrayList;
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    paramSearchEntryDataModel = (BusinessSearchEntryDataModel)paramSearchEntryDataModel;
    if (paramSearchEntryDataModel == null) {}
    label78:
    label80:
    label209:
    do
    {
      List localList;
      do
      {
        return;
        localList = paramSearchEntryDataModel.a;
      } while ((localList == null) || (localList.size() == 0));
      int i;
      BusinessSearchEntryDataModel.SearchEntry localSearchEntry;
      View localView1;
      View localView2;
      Object localObject2;
      if (localList.size() <= 6)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localList.size() != 10) {
          break label424;
        }
        paramSearchEntryDataModel = b();
        i = 0;
        if (i >= localList.size()) {
          break label463;
        }
        localSearchEntry = (BusinessSearchEntryDataModel.SearchEntry)localList.get(i);
        localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramSearchEntryDataModel.get(i)).intValue());
        localView2 = localView1.findViewById(2131364004);
        TextView localTextView = (TextView)localView1.findViewById(2131375007);
        URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131375006);
        localView1.setVisibility(0);
        localObject2 = new ColorDrawable();
        if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          break label432;
        }
        ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492956));
        if (!TextUtils.isEmpty(localSearchEntry.jdField_b_of_type_JavaLangString))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localURLDrawableOptions.mRequestWidth = AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
          localObject2 = URLDrawable.getDrawable(localSearchEntry.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
          if (localURLImageView != null) {
            localURLImageView.setImageDrawable((Drawable)localObject2);
          }
        }
        localTextView.setText(localSearchEntry.jdField_a_of_type_JavaLangString);
        int j = SharedPreUtils.a(localSearchEntry.c, (String)localObject1);
        boolean bool = SharedPreUtils.a(localSearchEntry.c, (String)localObject1);
        if ((localSearchEntry.jdField_a_of_type_Int != 1) || ((localSearchEntry.jdField_b_of_type_Int <= j) && ((localSearchEntry.jdField_b_of_type_Int != j) || (bool)))) {
          break label453;
        }
        localView2.setVisibility(0);
      }
      for (;;)
      {
        SharedPreUtils.a(localSearchEntry.c, localSearchEntry.jdField_b_of_type_Int, (String)localObject1);
        localView1.setOnClickListener(new ahqk(this, localView1, localSearchEntry, localView2, (String)localObject1, localList));
        i += 1;
        break label80;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        break;
        paramSearchEntryDataModel = a();
        break label78;
        ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492955));
        break label209;
        localView2.setVisibility(8);
      }
      if (localList.size() == 6)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375391).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375392).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375393).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375394).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375395).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375396).setVisibility(8);
        paramSearchEntryDataModel = new StringBuilder("");
        i = 0;
        if (i >= localList.size()) {
          break label693;
        }
        if (i != localList.size() - 1) {
          break label665;
        }
        paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)localList.get(i)).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i += 1;
        break label572;
        if (localList.size() != 10) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375389).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375396).setVisibility(8);
        break;
        paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)localList.get(i)).jdField_a_of_type_JavaLangString).append("::");
      }
      localObject1 = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(3));
    } while ((localObject1 != null) && (((Boolean)localObject1).booleanValue()));
    label424:
    label432:
    label453:
    label463:
    SearchUtils.a("home_page", "exp_entry", new String[] { paramSearchEntryDataModel.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
    label572:
    SearchEntryFragment.a.put(Integer.valueOf(3), Boolean.valueOf(true));
    label665:
    label693:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.BusinessSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */