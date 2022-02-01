package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class FollowingListFragment$FollowListAdapter
  extends SimpleAdapter
{
  public FollowingListFragment$FollowListAdapter(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramList, paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
  }
  
  protected void a(View paramView, ResultRecord paramResultRecord) {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Map localMap = (Map)getItem(paramInt);
    ResultRecord localResultRecord = ResultRecord.a((String)localMap.get("key_uin"), (String)localMap.get("key_name"));
    if (FollowingListFragment.b(this.a).contains(localResultRecord)) {
      localMap.put("key_checked", Boolean.valueOf(true));
    } else {
      localMap.put("key_checked", Boolean.valueOf(false));
    }
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    a(paramView, localResultRecord);
    return paramView;
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    super.setViewImage(paramImageView, paramString);
    if (paramImageView.getId() == 2131435219) {
      try
      {
        localObject = this.a.getResources().getDrawable(2130841060);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(140, 140));
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.o);
        paramImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception paramImageView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setViewImage: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("FollowingListFragment", 2, ((StringBuilder)localObject).toString(), paramImageView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FollowingListFragment.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */