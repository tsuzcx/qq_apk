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
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PreviewThumbAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, IPreviewThumbAdapter
{
  private static final String TAG = "PreviewThumbAdapter";
  private ColorDrawable colorDrawable;
  private String currentPath;
  private Context mContext;
  private Drawable mDefaultPhotoDrawable;
  private ArrayList<String> mSelectedPaths = new ArrayList();
  private IPreviewThumbAdapter.IThumbItemClickListener thumbItemClickListener;
  private int thumbWidth;
  
  public PreviewThumbAdapter(Context paramContext, IPreviewThumbAdapter.IThumbItemClickListener paramIThumbItemClickListener)
  {
    this.mContext = paramContext;
    this.thumbItemClickListener = paramIThumbItemClickListener;
    this.colorDrawable = new ColorDrawable(570425344);
    this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(2130848074);
    this.thumbWidth = EmotionUtils.a(50.0F, this.mContext.getResources());
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
    ArrayList localArrayList = this.mSelectedPaths;
    if (localArrayList != null) {
      return localArrayList.size();
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
    ArrayList localArrayList = this.mSelectedPaths;
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
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
    int i = this.thumbWidth;
    localLocalMediaInfo.thumbWidth = i;
    localLocalMediaInfo.thumbHeight = i;
    return localLocalMediaInfo;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new PreviewThumbAdapter.Holder(this);
      localView = LayoutInflater.from(this.mContext).inflate(2131561608, paramViewGroup, false);
      paramView.mImageView = ((URLImageView)localView.findViewById(2131378666));
      paramView.mSelectView = ((ImageView)localView.findViewById(2131378661));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (PreviewThumbAdapter.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject2 = getItem(paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (((String)localObject2).equals(this.currentPath)) {
        paramView.mSelectView.setVisibility(0);
      } else {
        paramView.mSelectView.setVisibility(8);
      }
      localObject1 = getMediaInfoTemp((String)localObject2);
      localObject2 = generateAlbumThumbPreviewURL((String)localObject2, "DEFAULT");
      URLDrawable localURLDrawable = paramView.mDrawable;
      if ((localObject2 != null) && ((localURLDrawable == null) || (!localURLDrawable.getURL().toString().equals(((URL)localObject2).toString()))))
      {
        localObject2 = ((IEmosmService)QRoute.api(IEmosmService.class)).getDrawable((URL)localObject2, this.colorDrawable, this.mDefaultPhotoDrawable);
        ((URLDrawable)localObject2).setTag(localObject1);
        paramView.mImageView.setImageDrawable((Drawable)localObject2);
        paramView.mDrawable = ((URLDrawable)localObject2);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IPreviewThumbAdapter.IThumbItemClickListener localIThumbItemClickListener = this.thumbItemClickListener;
    if (localIThumbItemClickListener != null) {
      localIThumbItemClickListener.onThumbClick(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PreviewThumbAdapter
 * JD-Core Version:    0.7.0.1
 */