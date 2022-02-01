package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class PhoneNumQuickLoginManager$BindPhoneNumAdapter
  extends BaseAdapter
{
  private List<PhoneNumQuickLoginManager.AccountInfo> a;
  
  private PhoneNumQuickLoginManager$BindPhoneNumAdapter(List<PhoneNumQuickLoginManager.AccountInfo> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = paramViewGroup.getContext();
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(localContext).inflate(2131561317, null);
      paramView = new PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder(null);
      localView.setBackgroundResource(2130842072);
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.a(paramView, (URLImageView)localView.findViewById(2131361866));
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.a(paramView, (TextView)localView.findViewById(2131361903));
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.b(paramView, (TextView)localView.findViewById(2131361928));
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.a(paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localView.setTag(paramView);
      localObject = (PhoneNumQuickLoginManager.AccountInfo)getItem(paramInt);
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.a(paramView).setText(PhoneNumQuickLoginManager.AccountInfo.access$600((PhoneNumQuickLoginManager.AccountInfo)localObject));
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.b(paramView).setText(PhoneNumQuickLoginManager.AccountInfo.access$700((PhoneNumQuickLoginManager.AccountInfo)localObject));
      if (!TextUtils.isEmpty(PhoneNumQuickLoginManager.AccountInfo.access$800((PhoneNumQuickLoginManager.AccountInfo)localObject))) {
        break label205;
      }
      localObject = BitmapFactory.decodeResource(localContext.getResources(), 2130840792);
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.a(paramView).setImageBitmap(AvatarUtil.a((Bitmap)localObject));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label205:
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = Utils.a(48.0F, localContext.getResources());
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mLoadingDrawable = localContext.getResources().getDrawable(2131165706);
      localURLDrawableOptions.mFailedDrawable = localContext.getResources().getDrawable(2131165706);
      localObject = URLDrawable.getDrawable(PhoneNumQuickLoginManager.AccountInfo.access$800((PhoneNumQuickLoginManager.AccountInfo)localObject), localURLDrawableOptions);
      ((URLDrawable)localObject).setTag(new int[] { i, i });
      ((URLDrawable)localObject).setDecodeHandler(PhoneNumQuickLoginManager.a);
      PhoneNumQuickLoginManager.BindPhoneNumAdapter.ViewHolder.a(paramView).setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.BindPhoneNumAdapter
 * JD-Core Version:    0.7.0.1
 */