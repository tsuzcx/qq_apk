package com.tencent.mobileqq.search;

import ahde;
import ahdf;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.OperationSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.Map;

public class OperationSearchEntryModel
  extends BaseSearchEntryModel
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TextView b;
  private TextView c;
  
  public OperationSearchEntryModel(int paramInt)
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
        break label207;
      }
    }
    label207:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130971655, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361926));
      this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375215));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375216));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375214));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131363937).setBackgroundColor(Color.parseColor("#040E1C"));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838576);
      }
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838575);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ahdf(this, new OperationSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, this.jdField_a_of_type_Int)), 5, null, true);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    b(paramSearchEntryDataModel);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    paramSearchEntryDataModel = (OperationSearchEntryDataModel)paramSearchEntryDataModel;
    if (paramSearchEntryDataModel == null) {
      return;
    }
    label31:
    label60:
    label81:
    Object localObject;
    if (!TextUtils.isEmpty(paramSearchEntryDataModel.a))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramSearchEntryDataModel.a);
      if (TextUtils.isEmpty(paramSearchEntryDataModel.b)) {
        break label253;
      }
      this.b.setVisibility(0);
      this.b.setText(paramSearchEntryDataModel.b);
      if (TextUtils.isEmpty(paramSearchEntryDataModel.c)) {
        break label265;
      }
      this.c.setText(paramSearchEntryDataModel.c);
      if (TextUtils.isEmpty(paramSearchEntryDataModel.d)) {
        break label277;
      }
      localObject = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(17170445));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(paramSearchEntryDataModel.d, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramSearchEntryDataModel.e)) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ahde(this, paramSearchEntryDataModel));
      }
      localObject = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(2));
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        break;
      }
      SearchUtils.a("home_page", "exp_opera", new String[] { paramSearchEntryDataModel.a, String.valueOf(this.jdField_a_of_type_Int) });
      SearchEntryFragment.a.put(Integer.valueOf(2), Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label31;
      label253:
      this.b.setVisibility(8);
      break label60;
      label265:
      this.c.setVisibility(8);
      break label81;
      label277:
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.OperationSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */