package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.MiddleBracketsTitleTextView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.PicData;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import java.io.File;
import java.util.List;

public class ReadInJoyDraftboxAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyDraftboxModule jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule = ReadInJoyLogicEngine.a().a();
  private List<ReadInJoyDraftboxItem> jdField_a_of_type_JavaUtilList;
  
  public ReadInJoyDraftboxAdapter(Context paramContext, List<ReadInJoyDraftboxItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(ReadInJoyDraftboxItem paramReadInJoyDraftboxItem)
  {
    if (paramReadInJoyDraftboxItem.type == 0) {
      return 1;
    }
    if (paramReadInJoyDraftboxItem.type == 1) {
      return 4;
    }
    if (paramReadInJoyDraftboxItem.type == 2) {
      return 3;
    }
    if (paramReadInJoyDraftboxItem.type == 3) {
      return 6;
    }
    return 5;
  }
  
  private URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mRequestWidth = ViewUtils.b(100.0F);
    localURLDrawableOptions.mRequestHeight = ViewUtils.b(100.0F);
    return localURLDrawableOptions;
  }
  
  private URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    boolean bool;
    if (paramHotPicData.getDataType() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    localURLDrawableOptions.mPlayGifImage = bool;
    localURLDrawableOptions.mExtraInfo = paramHotPicData;
    localURLDrawableOptions.mRequestWidth = ViewUtils.a(50.0F);
    localURLDrawableOptions.mRequestHeight = ViewUtils.a(50.0F);
    if (paramHotPicData.getDataType() == 2) {
      paramHotPicData = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData);
    } else {
      paramHotPicData = HotPicDownLoader.a(paramHotPicData.url);
    }
    if (paramHotPicData == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560180, null);
    } else {
      paramViewGroup = paramView;
    }
    Object localObject2 = (TextView)paramViewGroup.findViewById(2131379635);
    MiddleBracketsTitleTextView localMiddleBracketsTitleTextView = (MiddleBracketsTitleTextView)paramViewGroup.findViewById(2131379633);
    paramView = (TextView)paramViewGroup.findViewById(2131379634);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131369345);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131379610);
    ((TextView)localObject2).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    localMiddleBracketsTitleTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (paramInt >= 0) && (paramInt < ((List)localObject1).size()))
    {
      ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(localReadInJoyDraftboxItem.time, false));
      paramView = localReadInJoyDraftboxItem.title;
      if (localReadInJoyDraftboxItem.type == 3) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718000);
      }
      if (!TextUtils.isEmpty(paramView))
      {
        localObject1 = paramView;
        if (localReadInJoyDraftboxItem.type == 2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717999));
          ((StringBuilder)localObject1).append(": ");
          ((StringBuilder)localObject1).append(paramView);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 7, 16));
        ((TextView)localObject2).setVisibility(0);
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject1 = localReadInJoyDraftboxItem.digest;
      paramView = (View)localObject1;
      if (localReadInJoyDraftboxItem.type == 3)
      {
        paramView = (View)localObject1;
        if (!TextUtils.isEmpty(localReadInJoyDraftboxItem.title))
        {
          paramView = new StringBuilder();
          paramView.append("[");
          paramView.append(localReadInJoyDraftboxItem.title);
          paramView.append("]");
          localObject2 = paramView.toString();
          paramView = new StringBuilder();
          paramView.append((String)localObject2);
          paramView.append((String)localObject1);
          paramView = paramView.toString();
          localMiddleBracketsTitleTextView.setTitle((String)localObject2);
          localMiddleBracketsTitleTextView.setNeedAddBrackets(true);
        }
      }
      if (!TextUtils.isEmpty(paramView))
      {
        localMiddleBracketsTitleTextView.setText(new QQText(paramView, 7, 16));
        localMiddleBracketsTitleTextView.setVisibility(0);
      }
      else
      {
        localMiddleBracketsTitleTextView.setVisibility(8);
      }
      if ((localReadInJoyDraftboxItem.firstPicData != null) && ((localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) || (!TextUtils.isEmpty(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_JavaLangString))))
      {
        localImageView.setVisibility(0);
        if (localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
        {
          localImageView.setImageDrawable(a(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData));
        }
        else if (localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_Int == 1)
        {
          paramView = new File(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_JavaLangString);
          if (paramView.exists()) {
            localImageView.setImageDrawable(URLDrawable.getDrawable(paramView, a()));
          }
        }
        else if (localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_Int == 2)
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_JavaLangString, a()));
        }
      }
      else
      {
        localImageView.setVisibility(8);
      }
      paramViewGroup.setOnClickListener(new ReadInJoyDraftboxAdapter.1(this, localReadInJoyDraftboxItem));
      localTextView.setOnClickListener(new ReadInJoyDraftboxAdapter.2(this, localReadInJoyDraftboxItem, paramInt));
    }
    paramViewGroup.setTag(-3, Integer.valueOf(ViewUtils.a(66.0F)));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter
 * JD-Core Version:    0.7.0.1
 */