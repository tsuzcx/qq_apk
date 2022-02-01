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
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.MiddleBracketsTitleTextView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.PicData;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import java.io.File;
import java.util.List;

public class ReadInJoyDraftboxAdapter
  extends BaseAdapter
{
  private List<ReadInJoyDraftboxItem> a;
  private Context b;
  private ReadInJoyDraftboxModule c = ReadInJoyLogicEngine.a().Z();
  
  public ReadInJoyDraftboxAdapter(Context paramContext, List<ReadInJoyDraftboxItem> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
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
    localURLDrawableOptions.mRequestWidth = ViewUtils.dpToPx(100.0F);
    localURLDrawableOptions.mRequestHeight = ViewUtils.dpToPx(100.0F);
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
    localURLDrawableOptions.mRequestWidth = ViewUtils.dip2px(50.0F);
    localURLDrawableOptions.mRequestHeight = ViewUtils.dip2px(50.0F);
    if (paramHotPicData.getDataType() == 2) {
      paramHotPicData = HotVideoPreviewDownloader.b((HotVideoData)paramHotPicData);
    } else {
      paramHotPicData = HotPicDownLoader.b(paramHotPicData.url);
    }
    if (paramHotPicData == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public int getCount()
  {
    List localList = this.a;
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
      paramViewGroup = View.inflate(this.b, 2131626227, null);
    } else {
      paramViewGroup = paramView;
    }
    Object localObject2 = (TextView)paramViewGroup.findViewById(2131448406);
    MiddleBracketsTitleTextView localMiddleBracketsTitleTextView = (MiddleBracketsTitleTextView)paramViewGroup.findViewById(2131448403);
    paramView = (TextView)paramViewGroup.findViewById(2131448404);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131436356);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131448372);
    ((TextView)localObject2).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    localMiddleBracketsTitleTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    Object localObject1 = this.a;
    if ((localObject1 != null) && (paramInt >= 0) && (paramInt < ((List)localObject1).size()))
    {
      ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.a.get(paramInt);
      paramView.setText(ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(localReadInJoyDraftboxItem.time, false));
      paramView = localReadInJoyDraftboxItem.title;
      if (localReadInJoyDraftboxItem.type == 3) {
        paramView = this.b.getResources().getString(2131915480);
      }
      if (!TextUtils.isEmpty(paramView))
      {
        localObject1 = paramView;
        if (localReadInJoyDraftboxItem.type == 2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.b.getResources().getString(2131915479));
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
      if ((localReadInJoyDraftboxItem.firstPicData != null) && ((localReadInJoyDraftboxItem.firstPicData.a != null) || (!TextUtils.isEmpty(localReadInJoyDraftboxItem.firstPicData.b))))
      {
        localImageView.setVisibility(0);
        if (localReadInJoyDraftboxItem.firstPicData.a != null)
        {
          localImageView.setImageDrawable(a(localReadInJoyDraftboxItem.firstPicData.a));
        }
        else if (localReadInJoyDraftboxItem.firstPicData.c == 1)
        {
          paramView = new File(localReadInJoyDraftboxItem.firstPicData.b);
          if (paramView.exists()) {
            localImageView.setImageDrawable(URLDrawable.getDrawable(paramView, a()));
          }
        }
        else if (localReadInJoyDraftboxItem.firstPicData.c == 2)
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(localReadInJoyDraftboxItem.firstPicData.b, a()));
        }
      }
      else
      {
        localImageView.setVisibility(8);
      }
      paramViewGroup.setOnClickListener(new ReadInJoyDraftboxAdapter.1(this, localReadInJoyDraftboxItem));
      localTextView.setOnClickListener(new ReadInJoyDraftboxAdapter.2(this, localReadInJoyDraftboxItem, paramInt));
    }
    paramViewGroup.setTag(-3, Integer.valueOf(ViewUtils.dip2px(66.0F)));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter
 * JD-Core Version:    0.7.0.1
 */