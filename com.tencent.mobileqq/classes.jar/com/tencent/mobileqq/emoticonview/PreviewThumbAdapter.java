package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PreviewThumbAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private static final String TAG = "PreviewThumbAdapter";
  private ColorDrawable colorDrawable;
  private String currentPath;
  private Context mContext;
  private Drawable mDefaultPhotoDrawable;
  private ArrayList<String> mSelectedPaths = new ArrayList();
  private PreviewThumbAdapter.IThumbItemClickListener thumbItemClickListener;
  private int thumbWidth;
  
  public PreviewThumbAdapter(Context paramContext, PreviewThumbAdapter.IThumbItemClickListener paramIThumbItemClickListener)
  {
    this.mContext = paramContext;
    this.thumbItemClickListener = paramIThumbItemClickListener;
    this.colorDrawable = new ColorDrawable(570425344);
    this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(2130848203);
    this.thumbWidth = AIOUtils.a(50.0F, this.mContext.getResources());
  }
  
  public static URL generateAlbumThumbPreviewURL(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewThumbAdapter", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.mSelectedPaths != null) {
      return this.mSelectedPaths.size();
    }
    return 0;
  }
  
  public String getCurrentPath()
  {
    return this.currentPath;
  }
  
  public ArrayList<String> getDataList()
  {
    return this.mSelectedPaths;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.mSelectedPaths != null) && (paramInt < this.mSelectedPaths.size())) {
      return (String)this.mSelectedPaths.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public LocalMediaInfo getMediaInfoTemp(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mMediaType = 0;
    localLocalMediaInfo.path = paramString;
    localLocalMediaInfo.thumbWidth = this.thumbWidth;
    localLocalMediaInfo.thumbHeight = this.thumbWidth;
    return localLocalMediaInfo;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new PreviewThumbAdapter.Holder(this);
      localView = LayoutInflater.from(this.mContext).inflate(2131559695, paramViewGroup, false);
      paramView.mImageView = ((URLImageView)localView.findViewById(2131379314));
      paramView.mSelectView = ((ImageView)localView.findViewById(2131379311));
      localView.setTag(paramView);
    }
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      localObject2 = getItem(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (PreviewThumbAdapter.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    if (((String)localObject2).equals(this.currentPath)) {
      paramView.mSelectView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = getMediaInfoTemp((String)localObject2);
      localObject2 = generateAlbumThumbPreviewURL((String)localObject2, "DEFAULT");
      URLDrawable localURLDrawable = paramView.mDrawable;
      if ((localObject2 != null) && ((localURLDrawable == null) || (!localURLDrawable.getURL().toString().equals(((URL)localObject2).toString()))))
      {
        localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, this.colorDrawable, this.mDefaultPhotoDrawable);
        ((URLDrawable)localObject2).setTag(localObject1);
        paramView.mImageView.setImageDrawable((Drawable)localObject2);
        paramView.mDrawable = ((URLDrawable)localObject2);
      }
      break;
      paramView.mSelectView.setVisibility(8);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.thumbItemClickListener != null) {
      this.thumbItemClickListener.onThumbClick(paramInt);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setCurrentPath(String paramString)
  {
    this.currentPath = paramString;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    this.mSelectedPaths = paramArrayList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PreviewThumbAdapter
 * JD-Core Version:    0.7.0.1
 */