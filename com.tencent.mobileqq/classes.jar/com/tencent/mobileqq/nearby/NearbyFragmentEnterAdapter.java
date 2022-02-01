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
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840323);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor("#FFDDDFE2"));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
    paramContext = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    i = this.jdField_a_of_type_Int;
    paramContext.setSize(i, i);
  }
  
  public View a(Context paramContext, int paramInt)
  {
    NearbyFragmentEnterAdapter.EnterItem localEnterItem = (NearbyFragmentEnterAdapter.EnterItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    View localView = LayoutInflater.from(paramContext).inflate(2131559484, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    NearbyFragmentEnterAdapter.ViewHolder localViewHolder = new NearbyFragmentEnterAdapter.ViewHolder();
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368343));
    localViewHolder.b = ((URLImageView)localView.findViewById(2131368344));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379994));
    localViewHolder.c = ((URLImageView)localView.findViewById(2131368366));
    localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380035));
    localViewHolder.jdField_a_of_type_Int = paramInt;
    localView.setTag(localViewHolder);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    Object localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)this.jdField_a_of_type_Float);
    localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramInt = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).width = paramInt;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt;
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localViewHolder.b.getLayoutParams();
    paramInt = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).width = paramInt;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt;
    localViewHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = (View)localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)this.jdField_a_of_type_Float);
    ((View)localObject).setLayoutParams(localLayoutParams);
    localView.setTag(2131378259, Integer.valueOf(localEnterItem.jdField_a_of_type_Int));
    if (localEnterItem.jdField_b_of_type_Int != 0)
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, localViewHolder.jdField_a_of_type_ComTencentImageURLImageView);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b(53).a();
      localView.setTag(2131376320, Integer.valueOf(localEnterItem.jdField_b_of_type_Int));
    }
    if (localEnterItem.jdField_a_of_type_Int == 1)
    {
      paramContext = this.jdField_a_of_type_JavaUtilList;
      if (paramContext != null) {
        a(localViewHolder, (ilive_feeds_near_anchor.NearAnchorInfo)paramContext.get(this.jdField_b_of_type_Int));
      } else {
        a(localViewHolder.b, localEnterItem.jdField_b_of_type_JavaLangString);
      }
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
    else
    {
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      localViewHolder.c.setVisibility(8);
      a(localViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localEnterItem.jdField_b_of_type_JavaLangString);
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localEnterItem.c);
    return localView;
  }
  
  protected NearbyFragmentEnterAdapter.ViewHolder a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView != null) && (((Integer)localView.getTag(2131378259)).intValue() == 1)) {
        return (NearbyFragmentEnterAdapter.ViewHolder)localView.getTag();
      }
      i += 1;
    }
    return null;
  }
  
  public ilive_feeds_near_anchor.NearAnchorInfo a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return (ilive_feeds_near_anchor.NearAnchorInfo)localList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    Object localObject2 = null;
    URLDrawable localURLDrawable2 = null;
    URLDrawable localURLDrawable1 = localURLDrawable2;
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_Int;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "nearby_fragment_enter_icon";
      localURLDrawable1 = localURLDrawable2;
      if (!TextUtils.isEmpty(paramString))
      {
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2 = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2.setDecodeHandler(URLDrawableDecodeHandler.a);
        localURLDrawable1 = localURLDrawable2;
        if (localURLDrawable2.getStatus() != 2)
        {
          localURLDrawable1 = localURLDrawable2;
          localObject1 = localURLDrawable2;
          if (localURLDrawable2.getStatus() != 3) {}
        }
        else
        {
          localURLDrawable1 = localURLDrawable2;
          localURLDrawable2.restartDownload();
          localURLDrawable1 = localURLDrawable2;
          localObject1 = localURLDrawable2;
          if (QLog.isColorLevel())
          {
            localURLDrawable1 = localURLDrawable2;
            QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage restartDownload");
            localObject1 = localURLDrawable2;
          }
        }
      }
      else
      {
        localURLDrawable1 = localURLDrawable2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localURLDrawable1 = localURLDrawable2;
          QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
      localObject1 = localURLDrawable1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(localException.toString());
        QLog.w("NearbyFragmentEnterAdapter", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localURLDrawable1;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  public void a(NearbyFragmentEnterAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  @RequiresApi(api=11)
  protected void a(NearbyFragmentEnterAdapter.ViewHolder paramViewHolder, ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    int i = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_fragment_live_avatar";
    paramNearAnchorInfo = URLDrawable.getDrawable(paramNearAnchorInfo.cover_url.get().toStringUtf8(), (URLDrawable.URLDrawableOptions)localObject);
    i = this.jdField_a_of_type_Int;
    paramNearAnchorInfo.setTag(URLDrawableDecodeHandler.a(i, i));
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
  
  public void a(INearbyAppInterface paramINearbyAppInterface)
  {
    INearbyProcManager localINearbyProcManager = paramINearbyAppInterface.getNearbyProcManager();
    if (localINearbyProcManager == null) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject2 != null) && (((View)localObject2).getTag() != null))
      {
        NearbyFragmentEnterAdapter.ViewHolder localViewHolder = (NearbyFragmentEnterAdapter.ViewHolder)((View)localObject2).getTag();
        Object localObject1 = (Integer)((View)localObject2).getTag(2131376320);
        localObject2 = (Integer)((View)localObject2).getTag(2131378259);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = localINearbyProcManager.a(((Integer)localObject1).intValue());
          boolean bool1 = localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
          localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          boolean bool2 = localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
          if ((bool1) && (!bool2)) {
            NearbyUtils.b((AppInterface)paramINearbyAppInterface, "op_red_clear", ((Integer)localObject2).intValue());
          } else if ((!bool1) && (bool2)) {
            NearbyUtils.b((AppInterface)paramINearbyAppInterface, "op_red_push", ((Integer)localObject2).intValue());
          }
        }
      }
      i += 1;
    }
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
    paramList = this.jdField_a_of_type_JavaUtilList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter
 * JD-Core Version:    0.7.0.1
 */