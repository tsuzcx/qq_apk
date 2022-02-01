package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDiandianHeaderController$HeaderListAdapter
  extends BaseAdapter
{
  private List<DiandianTopConfig> b = new ArrayList();
  private int c;
  
  ReadInJoyDiandianHeaderController$HeaderListAdapter(List<DiandianTopConfig> paramList, int paramInt)
  {
    this.c = i;
    int j = i * 2;
    int i = j;
    while ((i < paramInt.size()) && (i < j + 2))
    {
      this.b.add(paramInt.get(i));
      i += 1;
    }
  }
  
  public Object a(int paramInt, DiandianTopConfig paramDiandianTopConfig)
  {
    return this.b.set(paramInt, paramDiandianTopConfig);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)this.b.get(paramInt);
    if (paramView == null)
    {
      paramView = new ReadInJoyDiandianHeaderController.ViewHolder(null);
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626225, null);
      paramView.a = ((URLImageView)((View)localObject).findViewById(2131436343));
      paramView.b = ((TextView)((View)localObject).findViewById(2131448384));
      paramView.c = ((TextView)((View)localObject).findViewById(2131448386));
      paramView.d = ((TextView)((View)localObject).findViewById(2131448385));
      paramView.e = new ReadInJoyDiandianHeaderController.OnItemViewClickListener(this.a, null);
      ((View)localObject).setTag(paramView);
      ((View)localObject).setOnClickListener(paramView.e);
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    else
    {
      paramViewGroup = (ReadInJoyDiandianHeaderController.ViewHolder)paramView.getTag();
    }
    paramViewGroup.e.a = (this.c * 2 + paramInt);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.c;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.c;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(localDiandianTopConfig.picUrl, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(DisplayUtil.a(paramView.getContext(), 42.0F), DisplayUtil.a(paramView.getContext(), 42.0F)));
    paramViewGroup.a.setImageDrawable((Drawable)localObject);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    if (localDiandianTopConfig.type == 3) {
      paramViewGroup.b.setVisibility(0);
    } else {
      paramViewGroup.b.setVisibility(8);
    }
    paramViewGroup.c.setText(localDiandianTopConfig.title);
    if (!TextUtils.isEmpty(localDiandianTopConfig.subTitleColor)) {
      try
      {
        paramViewGroup.d.setTextColor(Color.parseColor(localDiandianTopConfig.subTitleColor));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("getView parserColor error color = ");
          localStringBuilder2.append(localDiandianTopConfig.subTitleColor);
          localStringBuilder2.append(" e=");
          localStringBuilder2.append(localException.toString());
          QLog.e("ReadInJoyDiandianHeaderController", 2, localStringBuilder2.toString());
        }
        paramViewGroup.d.setTextColor(Color.parseColor("#9D9D9D"));
      }
    } else {
      paramViewGroup.d.setTextColor(Color.parseColor("#9D9D9D"));
    }
    paramViewGroup.d.setText(localDiandianTopConfig.subTitle);
    if (!ReadInJoyDiandianHeaderController.i(this.a)) {
      try
      {
        paramViewGroup = new JSONObject();
        paramViewGroup.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(ReadInJoyDiandianHeaderController.g(this.a).size());
        localStringBuilder1.append("");
        PublicAccountReportUtils.a(null, "", "0X80092FB", "0X80092FB", 0, 0, localStringBuilder1.toString(), "", "", paramViewGroup.toString(), false);
        ReadInJoyDiandianHeaderController.a(this.a, true);
        return paramView;
      }
      catch (JSONException paramViewGroup)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyDiandianHeaderController", 2, paramViewGroup.toString());
        }
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.HeaderListAdapter
 * JD-Core Version:    0.7.0.1
 */