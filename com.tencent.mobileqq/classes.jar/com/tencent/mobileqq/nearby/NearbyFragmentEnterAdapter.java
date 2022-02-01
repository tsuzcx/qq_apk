package com.tencent.mobileqq.nearby;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class NearbyFragmentEnterAdapter
{
  protected float a;
  protected int a;
  protected Drawable a;
  protected GradientDrawable a;
  protected Handler a;
  protected View.OnClickListener a;
  protected LinearLayout a;
  protected NearbyFragmentEnterAdapter.OnItemClickListener a;
  Runnable a;
  protected ArrayList<NearbyFragmentEnterAdapter.EnterItem> a;
  protected List<ilive_feeds_near_anchor.NearAnchorInfo> a;
  protected int b;
  
  public NearbyFragmentEnterAdapter(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new NearbyFragmentEnterAdapter.1(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyFragmentEnterAdapter.3(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_Float = ((float)(DeviceInfoUtil.i() * 2L / 9L));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float - DisplayUtil.a(paramContext, 20.0F)));
    int i = DisplayUtil.a(paramContext, 80.0F);
    if (this.jdField_a_of_type_Int > i) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840454);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor("#FFDDDFE2"));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public View a(Context paramContext, int paramInt)
  {
    NearbyFragmentEnterAdapter.EnterItem localEnterItem = (NearbyFragmentEnterAdapter.EnterItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    View localView = LayoutInflater.from(paramContext).inflate(2131559607, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    NearbyFragmentEnterAdapter.ViewHolder localViewHolder = new NearbyFragmentEnterAdapter.ViewHolder();
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368603));
    localViewHolder.b = ((URLImageView)localView.findViewById(2131368604));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380726));
    localViewHolder.c = ((URLImageView)localView.findViewById(2131368629));
    localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380770));
    localViewHolder.jdField_a_of_type_Int = paramInt;
    localView.setTag(localViewHolder);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    Object localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)this.jdField_a_of_type_Float);
    localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localViewHolder.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    localViewHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = (View)localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)this.jdField_a_of_type_Float);
    ((View)localObject).setLayoutParams(localLayoutParams);
    localView.setTag(2131378870, Integer.valueOf(localEnterItem.jdField_a_of_type_Int));
    if (localEnterItem.jdField_b_of_type_Int != 0)
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, localViewHolder.jdField_a_of_type_ComTencentImageURLImageView);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b(53).a();
      localView.setTag(2131376828, Integer.valueOf(localEnterItem.jdField_b_of_type_Int));
    }
    if (localEnterItem.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        a(localViewHolder, (ilive_feeds_near_anchor.NearAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#05d380"));
        localViewHolder.c.setVisibility(0);
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        paramContext.mPlayGifImage = true;
        paramContext = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif", paramContext);
        localViewHolder.c.setImageDrawable(paramContext);
        localViewHolder.c.setAdjustViewBounds(true);
        localViewHolder.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localEnterItem.c);
      return localView;
      a(localViewHolder.b, localEnterItem.jdField_b_of_type_JavaLangString);
      break;
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      localViewHolder.c.setVisibility(8);
      a(localViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localEnterItem.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected NearbyFragmentEnterAdapter.ViewHolder a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView != null) && (((Integer)localView.getTag(2131378870)).intValue() == 1)) {
        return (NearbyFragmentEnterAdapter.ViewHolder)localView.getTag();
      }
      i += 1;
    }
    return null;
  }
  
  public ilive_feeds_near_anchor.NearAnchorInfo a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (ilive_feeds_near_anchor.NearAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    URLDrawable localURLDrawable = null;
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "nearby_fragment_enter_icon";
        if (!TextUtils.isEmpty(paramString)) {
          localURLDrawable = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        localURLDrawable.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
        if (localURLDrawable.getStatus() != 2)
        {
          localObject1 = localURLDrawable;
          if (localURLDrawable.getStatus() != 3) {}
        }
        else
        {
          localURLDrawable.restartDownload();
          localObject1 = localURLDrawable;
          if (QLog.isColorLevel())
          {
            QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage restartDownload");
            localObject1 = localURLDrawable;
          }
        }
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject2 = localException2;
        }
      }
      localObject1 = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage empty url");
        localObject1 = localURLDrawable;
        continue;
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
        if (QLog.isColorLevel()) {
          QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage exp: url=" + paramString + ", " + localException1.toString());
        }
      }
    }
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface)
  {
    NearbyProcManager localNearbyProcManager = paramNearbyAppInterface.a();
    if (localNearbyProcManager == null) {
      return;
    }
    int i = 0;
    label14:
    Object localObject2;
    boolean bool1;
    boolean bool2;
    if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject2 != null) && (((View)localObject2).getTag() != null))
      {
        NearbyFragmentEnterAdapter.ViewHolder localViewHolder = (NearbyFragmentEnterAdapter.ViewHolder)((View)localObject2).getTag();
        Object localObject1 = (Integer)((View)localObject2).getTag(2131376828);
        localObject2 = (Integer)((View)localObject2).getTag(2131378870);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = localNearbyProcManager.a(((Integer)localObject1).intValue());
          bool1 = localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
          localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          bool2 = localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
          if ((!bool1) || (bool2)) {
            break label161;
          }
          NearbyUtils.a(paramNearbyAppInterface, "op_red_clear", ((Integer)localObject2).intValue());
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      break;
      label161:
      if ((!bool1) && (bool2)) {
        NearbyUtils.a(paramNearbyAppInterface, "op_red_push", ((Integer)localObject2).intValue());
      }
    }
  }
  
  public void a(NearbyFragmentEnterAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  @RequiresApi(api=11)
  protected void a(NearbyFragmentEnterAdapter.ViewHolder paramViewHolder, ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_fragment_live_avatar";
    paramNearAnchorInfo = URLDrawable.getDrawable(paramNearAnchorInfo.cover_url.get().toStringUtf8(), (URLDrawable.URLDrawableOptions)localObject);
    paramNearAnchorInfo.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
    paramNearAnchorInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
    if (this.jdField_a_of_type_JavaUtilList.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(paramViewHolder.b, "alpha", new float[] { 1.0F, 0.2F });
      ((ObjectAnimator)localObject).setInterpolator(new AccelerateInterpolator());
      ((ObjectAnimator)localObject).addListener(new NearbyFragmentEnterAdapter.2(this, paramViewHolder, paramNearAnchorInfo));
      ((ObjectAnimator)localObject).setDuration(300L).start();
      return;
    }
    paramViewHolder.b.setImageDrawable(paramNearAnchorInfo);
  }
  
  public void a(List<NearbyFragmentEnterAdapter.EnterItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramList = a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
      i += 1;
    }
  }
  
  public void b(List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter
 * JD-Core Version:    0.7.0.1
 */